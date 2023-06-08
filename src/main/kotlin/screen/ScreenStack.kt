package screen

object ScreenStack { // 싱글톤 객체, 화면 전역에서 쓰임
    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen) {
        screenStack.add(screen)
    }

    fun pop() { // list의 원소가 없을 때 Null을 반환하므로 IsEmpty()는 굳이 필요 없다
        screenStack.removeLastOrNull()
    }

    fun peak(): Screen? {
        return screenStack.lastOrNull()
    }
}

sealed class Screen