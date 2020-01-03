package com.mmm.mytestutil.rvInRecycler

data class itemBean ( var id : Int , var imgId:Int, var text :String ) {
    override fun toString(): String {
        return "这是第"+ id+"个item ： $text "
    }
}
