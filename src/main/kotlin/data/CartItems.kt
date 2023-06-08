package data
/*
    프로젝트 전역에서 상품 데이터를 저장하는 클래스 임으로
    항상 같은 값이 유지되어야 하기 때문에 싱글턴 객체로 유지한다.
 */

object CartItems {
    private val mutableProducts = mutableMapOf<Product, Int>()
    val products: Map<Product, Int> = mutableProducts
    // 상품 데이터를 저장할 수 있는 데이터 타입 | mutable type의 경우 private로 외부에 공개할 수 없게 처리 | 외부에 공개하는 immutable type으로 선언하여 Read-Only하게 만듦
    fun addProduct(product: Product) { //Map에서 Key조회시 없을 수도 있으므로 nullable type이다. 따라서 safecall operator & let 함수가 자주 활용된다.
        mutableProducts[product]?.let {
            mutableProducts[product] = it + 1 // 상품이 있을 때
        } ?: kotlin.run {
            mutableProducts[product] = 1
        } // 상품이 없을 때
    }
}