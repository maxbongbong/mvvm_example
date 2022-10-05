package kr.waem.example_viewmodel.db

class DataBase {

    private lateinit var dataBase: DataBase
    private var arrayList: ArrayList<Int> = ArrayList()

    fun saveNum(num: Int) {
        arrayList.add(num)
    }

    fun getAllNum(): ArrayList<Int> {
        return arrayList
    }

    fun removeNum(index: Int) {
        arrayList.removeAt(index)
    }

    fun removeAllNum() {
        arrayList.clear()
    }
}