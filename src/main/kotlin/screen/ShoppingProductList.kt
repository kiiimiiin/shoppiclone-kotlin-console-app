package screen

import data.*
import extensions.*
/*
    Category별 상품 목록을 관리하고
    사용자가 요청한 Category의 상품목록을 표시하도록 구현
 */
class ShoppingProductList {
    private val products = arrayOf(
        Product("패션","겨울 패딩"),
        Product("패션","겨울 바지"),
        Product("전자기기","핸드폰"),
        Product("전자기기","블루투스 이어폰"),
        Product("전자기기","노트북"),
        Product("반려동물용품","간식사료"),
        Product("반려동물용품","습식사료"),
        Product("반려동물용품","치약"),
        Product("반려동물용품","간식"),
    )
    private val categories: Map<String, List<Product>> = products.groupBy { product ->
        product.categoryLabel
    }
    fun showProducts(selectedCategory: String) {
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()){
            println("""
                ***==================================***
                선택하신 [$selectedCategory] 카테고리 상품입니다.
                """.trimIndent())

            categoryProducts.forEachIndexed { index, product ->
                println("${index}. ${product.name}")
            }
            showCartOption(categoryProducts, selectedCategory)
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>, selectedCategory: String ) { // 장바구니에 담을 상품을 선택
        println(
            """
                ***==========================***
                장바구니에 담을 상품 번호를 선택해주세요.
            """.trimIndent()
        )

        val selectedIndex = readLine().getNotEmptyInt()
        categoryProducts.getOrNull(selectedIndex)?.let { product ->
            CartItems.addProduct(product)
            println("=> 장바구니로 이동하시려면 #을, 계속 소핑하시려면 *을 입력해주세요.")
            val answer = readLine().getNotEmptyString()
            if (answer == "#"){
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            } else if ( answer == "*") {
                showProducts(selectedCategory)
            } else {
                // TODO 그 외 값 입력
            }
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전입니다.")
    }
}