package screen

import extensions.*
class ShoppingCategory: Screen() {
    fun showCategories() {
        ScreenStack.push(this)
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요")

        val selectedCategory = readLine().getNotEmptyString() // immutable type으로 변경
        if (selectedCategory == "#") {
            // TODO 1. 장바구니 이동
            val shoppingCart = ShoppingCart() // alt + shift + enter
            shoppingCart.showCartItems()
        } else {
            if (categories.contains(selectedCategory)) {
                // TODO 2. 카테고리 상품 목록 보여주기
                val shoppingProductList = ShoppingProductList(selectedCategory)
                shoppingProductList.showProducts()
            } else {
                showErrorMessage(selectedCategory)
            }
        }
    }
    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리 입니다. 다시 입력하세요.")
        showCategories()
    }
}