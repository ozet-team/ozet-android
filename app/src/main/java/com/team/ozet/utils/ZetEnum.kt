package com.team.ozet.utils


enum class ZetEnum ( value: String){
    NA("해당없음"),
    EXEMPTION("면제"),
    UNFINISHED("미필"),
    FINISHED("군필"),
    STAFF("인턴"),
    STAFF_KR("인턴(스탭)"),
    MANAGER("매니저");

    companion object {
        fun valueOf(value: String) = ZetEnum.values().find { it.equals(value) }
    }
}

