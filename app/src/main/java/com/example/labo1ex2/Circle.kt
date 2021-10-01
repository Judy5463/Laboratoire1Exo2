package com.example.labo1ex2

class Circle(_rayon:Double,_color:String,_Remplie:Boolean):Shape(_color,_Remplie) {
    constructor() : this(1.0, "bleu", true)
    constructor(_rayon: Double) : this(_rayon, "bleu", true)

    private var rayon: Double

    init {
        this.rayon = _rayon

    }

    fun getRayon() = this.rayon
    fun setRayon(n: Double) {
        this.rayon = n
    }

    override fun getAire(): Double {
        if (this.getRemplie()) {
            return 3.1415 * Math.pow(this.getRayon(), 2.0)
        }
        return 0.0
    }

    override fun GetNomForme(): String {
        return "Circle"
    }

    override fun getPerimeter(): Double {
        return 2 * 3.1415 * this.getRayon()
    }



}