package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    tvOne.setOnClickListener{appendOnExpression("1",true)}
    tvTwo.setOnClickListener{appendOnExpression("2",true)}
    tvThree.setOnClickListener{appendOnExpression("3",true)}
    tvFour.setOnClickListener{appendOnExpression("4",true)}
    tvFive.setOnClickListener{appendOnExpression("5",true)}
    tvSix.setOnClickListener{appendOnExpression("6",true)}
    tvSeven.setOnClickListener{appendOnExpression("7",true)}
    tvEight.setOnClickListener{appendOnExpression("8",true)}
    tvNine.setOnClickListener{appendOnExpression("9",true)}
    tvZero.setOnClickListener{appendOnExpression("0",true)}
    tvDot.setOnClickListener{appendOnExpression(".",true)}

    tvPlus.setOnClickListener{appendOnExpression("+",true)}
    tvMinus.setOnClickListener{appendOnExpression("-",true)}
    tvMul.setOnClickListener{appendOnExpression("*",true)}
    tvDivide.setOnClickListener{appendOnExpression("/",true)}
    tvOpen.setOnClickListener{appendOnExpression("(",true)}
    tvClose.setOnClickListener{appendOnExpression(")",true)}


    tvClear.setOnClickListener {
      tvExpression.text=""
      tvResult.text=""
    }
    tvBack.setOnClickListener {
      val text=tvExpression.text.toString()
      if(text.isNotEmpty()){
        tvExpression.text=text.substring(0,text.length-1)
      }
      tvResult.text=""
    }
    tvEquals.setOnClickListener {
      try{
        val expression=ExpressionBuilder(tvExpression.text.toString()).build()
        val result=expression.evaluate()
        val longResult=result.toLong()
        if(result== longResult.toDouble()){
          tvResult.text=longResult.toString() }
        else{
          tvResult.text=longResult.toString()
        }

      }
      catch (e:Exception){

      }
    }
 }
  private fun appendOnExpression(text:String, canClear:Boolean){

    if(tvResult.text.isNotEmpty()){
      tvExpression.text=""
    }
    if(canClear){
      tvResult.text=""
      tvExpression.append(text)

    }
    else{
      tvExpression.append(tvResult.text)
    }

  }
}
