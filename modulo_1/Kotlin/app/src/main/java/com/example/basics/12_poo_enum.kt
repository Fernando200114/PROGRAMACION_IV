package com.example.basics

enum class TipoSable(val color:String, val poder: Int) {
    AZUL("azul", 85) {
        override fun description() = "Sabe tradicional de los Jedi"
    },
    VERDE("verde", 90) {
        override fun description() = "Sable de los Jedi consultores"
    },
    ROJO("rojo", 95) {
        override fun description() = "Sable de los Sith"
    },
    MORADO("morado", 95) {
        override fun description() = "Sable equilibra luz y oscuridad"
    };
    abstract  fun description(): String
    companion object {
        fun porColor(color: String) = values().find { it.color == color }
    }
}
class SableDeLuz(val tipo: TipoSable, val portador:String){
    fun activar()="!ZZrum! El sable color ${tipo.color} es ${portador}, se enciene"
    fun info()="${tipo.description()} - tipo poder ${tipo.poder}"
   }

    fun main(){
        val  sableMindoo = SableDeLuz(TipoSable.MORADO,"Bindoo")
        println(sableMindoo)
        println(sableMindoo.activar())
        println(sableMindoo.info())

}