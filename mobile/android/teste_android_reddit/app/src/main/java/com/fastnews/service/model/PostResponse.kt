package com.fastnews.service.model

import android.os.Parcel
import android.os.Parcelable

data class PostResponse(val data: PostDataChild)

data class PostDataChild(val children: List<PostChildren>)

data class PostChildren(val data: PostData)

data class PostData(val id: String,
                    val author: String = "",
                    val thumbnail: String = "",
                    val name: String = "",
                    val num_comments: Int,
                    val score: Int,
                    val title: String = "",
                    val created_utc: Long,
                    val url: String,
                    val preview: Preview) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readParcelable(Preview::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(author)
        parcel.writeString(thumbnail)
        parcel.writeString(name)
        parcel.writeInt(num_comments)
        parcel.writeInt(score)
        parcel.writeString(title)
        parcel.writeLong(created_utc)
        parcel.writeString(url)
        parcel.writeParcelable(preview, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostData> {
        override fun createFromParcel(parcel: Parcel): PostData {
            return PostData(parcel)
        }

        override fun newArray(size: Int): Array<PostData?> {
            return arrayOfNulls(size)
        }
    }
}

data class Preview(val images: List<PreviewImage>) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(PreviewImage)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(images)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Preview> {
        override fun createFromParcel(parcel: Parcel): Preview {
            return Preview(parcel)
        }

        override fun newArray(size: Int): Array<Preview?> {
            return arrayOfNulls(size)
        }
    }
}

data class PreviewImage(val id: String, val source: PreviewImageSource) :

    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(PreviewImageSource::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeParcelable(source, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PreviewImage> {
        override fun createFromParcel(parcel: Parcel): PreviewImage {
            return PreviewImage(parcel)
        }

        override fun newArray(size: Int): Array<PreviewImage?> {
            return arrayOfNulls(size)
        }
    }
}

data class PreviewImageSource(val url: String, val width: Int, val height: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeInt(width)
        parcel.writeInt(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PreviewImageSource> {
        override fun createFromParcel(parcel: Parcel): PreviewImageSource {
            return PreviewImageSource(parcel)
        }

        override fun newArray(size: Int): Array<PreviewImageSource?> {
            return arrayOfNulls(size)
        }
    }
}