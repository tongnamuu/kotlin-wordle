package domain

import com.sun.org.apache.bcel.internal.util.Args.require

data class GameString(val value: String) {
    init {
        require(value.length == Constant.GAME_STRING_LENGTH) {
            "길이가 ${Constant.GAME_STRING_LENGTH} 인 글자를 입력해주세요"
        }
    }
}
