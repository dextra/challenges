package dev.dextra.newsapp.feature.sources

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import android.widget.LinearLayout.VERTICAL
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import dev.dextra.newsapp.R
import dev.dextra.newsapp.api.model.Source
import dev.dextra.newsapp.api.model.enums.Category
import dev.dextra.newsapp.api.model.enums.Country
import dev.dextra.newsapp.base.BaseListActivity
import dev.dextra.newsapp.feature.news.NEWS_ACTIVITY_SOURCE
import dev.dextra.newsapp.feature.news.NewsActivity
import dev.dextra.newsapp.feature.sources.adapter.CustomArrayAdapter
import dev.dextra.newsapp.feature.sources.adapter.SourcesListAdapter
import kotlinx.android.synthetic.main.activity_sources.*
import org.koin.android.ext.android.inject


class SourcesActivity : BaseListActivity(), SourcesListAdapter.SourceListAdapterItemListener {

    override val emptyStateTitle: Int = R.string.empty_state_title_source
    override val emptyStateSubTitle: Int = R.string.empty_state_subtitle_source
    override val errorStateTitle: Int = R.string.error_state_title_source
    override val errorStateSubTitle: Int = R.string.error_state_subtitle_source
    override val mainList: View
        get() = sources_list

    val sourcesViewModel: SourcesViewModel by inject()

    private var viewAdapter: SourcesListAdapter = SourcesListAdapter(this)
    private var viewManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_sources)
        setupView()
        loadSources()
        super.onCreate(savedInstanceState)
    }

    private fun setupList() {
        sources_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun loadSources() {
        sourcesViewModel.sources.observe(this, Observer {
            viewAdapter.apply {
                clear()
                notifyDataSetChanged()
                add(it)
                notifyDataSetChanged()
                sources_list.scrollToPosition(0)
                app_bar.setExpanded(true)
            }
        })

        sourcesViewModel.networkState.observe(this, networkStateObserver)

        sourcesViewModel.loadSources()
    }

    private fun setupView() {
        configureAutocompletes()
        setupList()
    }

    private fun configureAutocompletes() {
        val countryAdapter = CustomArrayAdapter(
            this,
            R.layout.select_item,
            Country.values().toMutableList()
        )
        country_select.setAdapter(countryAdapter)
        country_select.keyListener = null
        country_select.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position)
            if (item is Country) {
                sourcesViewModel.changeCountry(item)
            }
        }

        category_select.setAdapter(
            CustomArrayAdapter(
                this,
                R.layout.select_item,
                Category.values().toMutableList()
            )
        )
        category_select.keyListener = null
        category_select.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position)
            if (item is Category) {
                sourcesViewModel.changeCategory(item)
            }
        }
    }

    override fun onClick(source: Source) {
        val intent = Intent(this, NewsActivity::class.java)
        intent.putExtra(NEWS_ACTIVITY_SOURCE, source)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    override fun setupPortrait() {
        setListColumns(1)
        sources_filters.orientation = VERTICAL
        configureFilterLayoutParams(country_select_layout, MATCH_PARENT, 0f)
        configureFilterLayoutParams(category_select_layout, MATCH_PARENT, 0f)
    }

    override fun setupLandscape() {
        setListColumns(2)
        sources_filters.orientation = HORIZONTAL
        configureFilterLayoutParams(country_select_layout, 0, 1f)
        configureFilterLayoutParams(category_select_layout, 0, 1f)
    }

    private fun configureFilterLayoutParams(textInput: TextInputLayout, width: Int, weight: Float) {
        val layoutParams = textInput.layoutParams
        if (layoutParams is LinearLayout.LayoutParams) {
            layoutParams.width = width
            layoutParams.weight = weight
        }
    }

    private fun setListColumns(columns: Int) {
        val layoutManager = sources_list.layoutManager
        if (layoutManager is GridLayoutManager) {
            layoutManager.spanCount = columns
            viewAdapter.notifyDataSetChanged()
        }
    }

    override fun executeRetry() {
        loadSources()
    }
}
