package vn.phamthang.practice02.objects
import com.google.gson.annotations.SerializedName

data class Product(
        @SerializedName("brand")
        var brand: String,
        @SerializedName("category")
        var category: String,
        @SerializedName("description")
        var description: String,
        @SerializedName("discountPercentage")
        var discountPercentage: Double,
        @SerializedName("id")
        var id: Int,
        @SerializedName("images")
        var images: List<String>,
        @SerializedName("price")
        var price: Int,
        @SerializedName("rating")
        var rating: Double,
        @SerializedName("stock")
        var stock: Int,
        @SerializedName("thumbnail")
        var thumbnail: String,
        @SerializedName("title")
        var title: String
    )