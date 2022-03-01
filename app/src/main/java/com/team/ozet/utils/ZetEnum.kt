package com.team.ozet.utils


enum class ZetEnum (){
    MILITARY{
        override fun valueChange(value: String): String {
            return when(value){
                Military.NA -> Military.NA_KR
                Military.NA_KR -> Military.NA
                Military.EXEMPTION -> Military.EXEMPTION_KR
                Military.EXEMPTION_KR -> Military.EXEMPTION
                Military.UNFINISHED  -> Military.UNFINISHED_KR
                Military.UNFINISHED_KR -> Military.UNFINISHED
                Military.FINISHED -> Military.FINISHED_KR
                Military.FINISHED_KR -> Military.FINISHED
                else -> value
            }
        }
    },
    CAREER{
        override fun valueChange(value: String): String {
            return when(value){
                Position.STAFF -> Position.STAFF_KR
                Position.STAFF_KR -> Position.STAFF
                Position.MANAGER -> Position.MANAGER_KR
                Position.MANAGER_KR -> Position.MANAGER
                Position.DESIGNER  -> Position.DESIGNER_KR
                Position.DESIGNER_KR -> Position.DESIGNER
                Position.DIRECTOR -> Position.DIRECTOR_KR
                Position.DIRECTOR_KR -> Position.DIRECTOR
                else -> value
            }
        }

    };

    abstract fun valueChange(value: String) : String

}

