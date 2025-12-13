package pizzeria_chain.classes

interface ICheckPhoto {
    val checkPhotoDiscount : Double
    var checkPhotoCount : Int

    fun showCheckPhoto()
}