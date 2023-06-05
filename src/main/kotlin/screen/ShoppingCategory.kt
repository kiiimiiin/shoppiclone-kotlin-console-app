package screen

class ShoppingCategory {
    fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요")

        var selectedCategory = readLine() // 입력값을 읽어드리지 못하면 Null, Empty&blank 가능성
        while (selectedCategory.isNullOrBlank()) {
            println("올바른 입력값을 입력해주세요")
            selectedCategory = readLine()
        }

        if (selectedCategory == "#") {
            // TODO 1. 장바구니 이동
        } else {
            if (categories.contains(selectedCategory)) {
                // TODO 2. 카테고리 상품 목록 보여주기
            } else {
                // TODO 3. 카테고리 목록에 없는 값 처리
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리 입니다. 다시 입력하세요.")
        showCategories()
    }
}