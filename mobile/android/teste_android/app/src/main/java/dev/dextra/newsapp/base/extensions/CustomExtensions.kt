import androidx.lifecycle.MutableLiveData

//add all the values from the list to the LiveData
fun <T> MutableLiveData<ArrayList<T>>.addListValues(values: List<T>) {
    val value = this.value ?: arrayListOf()
    value.addAll(values)
    this.postValue(value)
}

//clear the LiveData
fun <T> MutableLiveData<ArrayList<T>>.clear() {
    this.postValue(null)
}