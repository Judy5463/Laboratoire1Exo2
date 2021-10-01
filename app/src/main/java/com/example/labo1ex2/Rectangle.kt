package com.example.labo1ex2

 open class Rectangle(_hauteur:Double,_largeur:Double,_couleur:String,_remplie:Boolean):Shape(_couleur,_remplie)
 {

     constructor():this(1.0,1.0,"vert",true)
     constructor(_hauteur: Double,_largeur: Double):this(_hauteur,_largeur,"vert",true)


     private var hauteur:Double
     private var largeur:Double

     init{
         this.hauteur = _hauteur
         this.largeur  =_largeur
     }

     fun getHauteur() = this.hauteur
     open fun setHauteur(n:Double){
         this.hauteur = n
     }

     fun getLargeur() = this.largeur
     open fun setLargeur(n:Double){
         this.largeur = n
     }

     override fun GetNomForme(): String {
         return "Rectangle"
     }

     override fun getAire(): Double {
         return getHauteur() * getLargeur()
     }

     override fun getPerimeter(): Double {
         return 2 * getHauteur() + 2 * getLargeur()
     }


 }