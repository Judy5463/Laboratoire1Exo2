package com.example.labo1ex2

class Square(_coter:Double,_color:String,_Remplie:Boolean):Rectangle(_coter,_coter,_color,_Remplie)
{
    constructor():this(1.0,"noir",true)
    constructor(_coter: Double):this(_coter,"noir",true)

    fun getCoter() = this.getHauteur()
    fun setCoter(n:Double){
        this.setHauteur(n)
        this.setLargeur(n)
    }

    override fun GetNomForme(): String {
        return "Square"
    }
}