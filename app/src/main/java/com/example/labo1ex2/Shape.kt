package com.example.labo1ex2

abstract class Shape(_color:String,_remplie:Boolean)
{
    constructor():this("red",true)

    private var color:String
    private var remplie:Boolean

    init
    {
        this.color=_color
        this.remplie=_remplie
    }

    fun getColor()= this.color
    fun setColor(n:String){
        this.color = n
    }

    fun getRemplie() = this.remplie
    fun setRemplie(n:Boolean){
        this.remplie = n
    }

    abstract fun GetNomForme():String

    abstract fun getAire():Double

    abstract fun getPerimeter():Double

}