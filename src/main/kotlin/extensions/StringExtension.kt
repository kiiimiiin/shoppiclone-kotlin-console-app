package extensions
/*
사용자 입력값 요청 처리 공통화
 */
fun String?.getNotEmptyString(): String { // 카테고리, # , * 등을 입력하라 했을 때 빈값&공백을 입력하지 않도록 확인하는 용도
    var input = this
    while(input.isNullOrBlank()) {
        println("값을 입력해주세요")
        input = readLine()
    }
    return input.trim() // 공백제거
}

fun String?.getNotEmptyInt(): Int { // 상품 번호를 입력 받을 때 그 값이 Int type을 변환할 수 있는지 확인하는 용도
    var input = this?.trim()
    while(input.isNullOrEmpty() ||  input.toIntOrNull() == null) {
        println("값을 입력해주세요")
        input = readLine()
    }
    return input.toInt()
}