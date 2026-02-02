package domain

data class GameString(val value: String) {
    private val regex = "^[A-Za-z]+$".toRegex()

    init {
        require(regex.matches(value)) {
            "영어대소문자만 입력가능합니다"
        }

        require(value.length == Constant.GAME_STRING_LENGTH) {
            "길이가 ${Constant.GAME_STRING_LENGTH} 인 글자를 입력해주세요"
        }
    }
}
