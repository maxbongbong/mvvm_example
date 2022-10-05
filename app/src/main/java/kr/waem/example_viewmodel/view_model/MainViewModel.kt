package kr.waem.example_viewmodel.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.waem.example_viewmodel.db.DataBase
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel: ViewModel() {
    private val database: DataBase = DataBase()

    private var rand = Random()

    private var nowNum = -1

    companion object {
        var MaxNum = 10
    }

    var text: MutableLiveData<String> = MutableLiveData()

    init {
        text.value = ""
    }

    fun getNum() {
        nowNum = rand.nextInt(MaxNum) + 1
        database.saveNum(nowNum)
        text.value = "$nowNum "
    }

    fun setMaxNum(int: Int?) {
        println(int)
        MaxNum = int!!
    }

    fun getMaxNum(): Int {
        return MaxNum
    }

    fun showAllNum() {
        if(nowNum == -1) return

        text.value = ""

        val list: ArrayList<Int> = database.getAllNum()

        for(i in list) {
            text.value += i.toString()
        }

        println(text)
    }

    fun removeAllNum(): String {
        return if(database.getAllNum().size > 0) {
            database.removeAllNum()
            "모든 번호가 삭제되었습니다."
        } else {
            "모든 번호가 삭제되었습니다."
        }
    }

    fun removeLastNum(): String {
        return if(database.getAllNum().size > 0) {
            database.removeNum(database.getAllNum().lastIndex)
            "마지막 번호가 삭제되었습니다."
        } else {
            "마지막 번호가 삭제되었습니다."
        }
    }
}