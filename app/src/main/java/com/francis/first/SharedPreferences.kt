import android.annotation.SuppressLint
import android.content.SharedPreferences

@SuppressLint("CommitPrefEdits")
fun SharedPreferences.open(block:SharedPreferences.Editor.()->Unit){
    val editor = edit()
    editor.block()
    editor.apply()
}

fun <T> later(block: () -> T) = Later(block)