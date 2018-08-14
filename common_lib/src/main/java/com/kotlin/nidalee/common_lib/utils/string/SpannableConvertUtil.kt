package com.nidalee.kotlin.utils.string

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.CharacterStyle
import android.text.style.ForegroundColorSpan
import java.util.regex.Pattern

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/3 18:42
 */
class SpannableConvertUtil private constructor(){

  companion object {

    /**
     * 关键字高亮
     */
    @JvmStatic
    fun keyWordBright(content: String, target: String ,colorRes: String): SpannableStringBuilder{
      val spannable = SpannableStringBuilder(content)
      var span: CharacterStyle
      var wordReg: String
      var key: String = ""
      var target = target
      if(target.contains("*") || target.contains("(") || target.contains(")") || target.contains(".")){
        val chars = target.toCharArray()
        for(c in chars){
          if(c == '*' || c == '(' || c == ')' || c=='.'){
            key += c.toString()
          }
        }
        target = key
      }
      wordReg = "(?i)$target"
      val pattern = Pattern.compile(wordReg)
      val matcher = pattern.matcher(content)
      while (matcher.find()){
        span = ForegroundColorSpan(Color.parseColor(colorRes))
        spannable.setSpan(span, matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      }
      return spannable
    }

  }
}