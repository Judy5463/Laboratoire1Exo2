package com.example.labo1ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var rdoCercle: RadioButton
    private lateinit var rdoRectangle: RadioButton
    private lateinit var rdoCarre: RadioButton
    private lateinit var edRayonCoter: EditText
    private lateinit var edCouleur: EditText
    private lateinit var edLargeur: EditText
    private lateinit var chkRempli: CheckBox
    private lateinit var btnAire: Button
    private lateinit var btnPerimetre: Button
    private lateinit var txtResultat: TextView
    private lateinit var txtRayonCoter: TextView
    private lateinit var objets: Shape

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.rdoCarre = findViewById<RadioButton>(R.id.rdoCarre)
        this.rdoCercle = findViewById<RadioButton>(R.id.rdoCercle)
        this.rdoRectangle = findViewById<RadioButton>(R.id.rdoRectangle)
        this.edCouleur = findViewById<EditText>(R.id.edCouleur)
        this.edLargeur = findViewById<EditText>(R.id.edLargeur)
        this.edRayonCoter = findViewById<EditText>(R.id.edRayon)
        this.chkRempli = findViewById<CheckBox>(R.id.checkRemplie)
        this.btnAire = findViewById<Button>(R.id.btnAir)
        this.btnPerimetre = findViewById<Button>(R.id.btnPerimetre)
        this.txtResultat = findViewById<Button>(R.id.txtResultat)
        this.txtRayonCoter = findViewById<Button>(R.id.txtRayon)



        this.chkRempli.isChecked = true
        this.rdoCercle.isChecked = true
        edLargeur.isEnabled = false
        objets = Circle()

        this.rdoCercle.setOnClickListener(){
            activation(true,false,0)
            objets = Circle()
        }
        this.rdoRectangle.setOnClickListener(){
            activation(true,true,1)
            objets = Rectangle()
        }
        this.rdoCarre.setOnClickListener(){
            activation(false,true,2)
            objets = Square()
        }

        this.btnAire.setOnClickListener(View.OnClickListener {
            var forme = objets.GetNomForme()
            var rayon = 1.0
            var couleur = objets.getColor()
            var remplie = chkRempli.isChecked
            var largeur = 1.0

            if(edCouleur.text.toString() != ""){
                couleur =  edCouleur.text.toString()
            }
            if(!remplie){
                couleur = ""
            }

            try {
                rayon = edRayonCoter.text.toString().toDouble()
            } catch (e: Exception){ }
            try {
                largeur = edLargeur.text.toString().toDouble()
            } catch (e: Exception){ }

            when (forme){
                "Circle"-> {
                    objets = Circle(rayon,couleur,remplie)
                    txtResultat.text = "L'AIR du " + forme + " " + couleur + " =  " + objets.getAire().toString()
                    objets = Circle()
                }
                "Rectangle"->{
                    objets = Rectangle(rayon,largeur,couleur,remplie)
                    txtResultat.text = "L'AIR du " + forme + " " + couleur + " = " + objets.getAire().toString()
                    objets = Rectangle()
                }
                "Square"->{
                    objets = Square(largeur,couleur,remplie)
                    txtResultat.text = "L'AIR du " + forme + " " + couleur + " = " + objets.getAire().toString()
                    objets = Square()
                }
            }
        })

        this.btnPerimetre.setOnClickListener(View.OnClickListener {
            var forme = objets.GetNomForme()
            var rayon = 1.0
            var couleur = objets.getColor()
            var rempli = chkRempli.isChecked
            var largeur = 1.0

            if(edCouleur.text.toString() != ""){
                couleur =  edCouleur.text.toString()
            }
            if(rempli == false){
                couleur = ""
            }

            try {
                rayon = edRayonCoter.text.toString().toDouble()
            } catch (e: Exception){ }
            try {
                largeur = edLargeur.text.toString().toDouble()
            } catch (e: Exception){ }

            when (forme){
                "circle"-> {
                    objets = Circle(rayon,couleur,rempli)
                    txtResultat.text = "Le PÉRIMÈTRE du " + forme + " " + couleur + " =  " + objets.getPerimeter().toString()
                    objets = Circle()
                }
                "rectangle"->{
                    objets = Rectangle(rayon,largeur,couleur,rempli)
                    txtResultat.text = "Le PÉRIMÈTRE du " + forme + " " + couleur + " =  " + objets.getPerimeter().toString()
                    objets = Rectangle()
                }
                "care"->{
                    objets = Square(largeur,couleur,rempli)
                    txtResultat.text = "Le PÉRIMÈTRE du " + forme + " " + couleur + " = " + objets.getPerimeter().toString()
                    objets = Square()
                }
            }
        })
    }

    fun activation(bPrm1:Boolean,bPrm2:Boolean,forme:Int){
        if(forme == 0 ) {
            txtRayonCoter.text = "Rayon:"
            edRayonCoter.hint = "SAISSIR UN RAYON SVP !!!"
        }
        else if (forme == 1 || forme == 2){
            txtRayonCoter.text = "Hauteur:"
            edRayonCoter.hint = "SAISSIR UNE HAUTEUR SVP !!! "
        }
        edRayonCoter.isEnabled = bPrm1
        edLargeur.isEnabled = bPrm2
    }
}