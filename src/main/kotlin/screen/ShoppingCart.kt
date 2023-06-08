package screen

import LINE_DIVIDER
import data.CartItems
import extensions.getNotEmptyString

/*
    장바구니의 아이템 목록 display
 */
class ShoppingCart : Screen() {
    private val products = CartItems.products
    fun showCartItems() {
        ScreenStack.push(this)
        if (products.isNotEmpty()) {
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                        $LINE_DIVIDER 
                        장바구니에 담은 상품 목록 입니다.
                        
                    """.trimIndent() // Alt + Enter
                ) { product ->
                    "카테고리: ${product.categoryLabel}/ 상품명: ${product.name} / 수량: ${products[product]}"
                }
            )
        } else {
            println(
                """
            장바구니에 담긴 상품이 없습니다.
        """.trimIndent()
            )
        }
        showPreviousScreenOption()
    }

    private fun showPreviousScreenOption() {
        println(
            """
                $LINE_DIVIDER
                이전 화면으로 돌아가시겠습니까? (y/n)
            """.trimIndent()
        )
        when (readLine().getNotEmptyString()){
            "y" -> {
                moveToPreviousScreen() // Alt + enter
            }
            "n" -> {
                showCartItems()
            }
            else -> {
                // TODO 재입력 요청
            }
        }
    }

    private fun moveToPreviousScreen() {
        ScreenStack.pop() // 현재화면에서 벗어남
        when (val previousScreen = ScreenStack.peek()) {
            is ShoppingCategory -> {
                previousScreen.showCategories()
            }
            is ShoppingProductList -> {
                previousScreen.showProducts()
            }
            is ShoppingCart, is ShoppingHome -> {
                //아무것도 하지 않음 n하다가 y누르면 오류남 (계속 스택에 쌓여서)
            }
            else -> {

            }
        }// 이전 화면에 대한참조
    }
}
