package com.example.firebase

import java.net.HttpURLConnection

class Mensaje(){

    lateinit var mensaje : String
    lateinit var nombre : String
    lateinit var hora : String
    lateinit var foto: String
    lateinit var tipo : String
    var urlFoto : String = ""

    constructor(mensaje : String,nombre : String, hora: String, foto : String, tipo : String) : this() {
        this.mensaje = mensaje
        this.nombre= nombre
        this.hora= hora
        this.foto = foto
        this.tipo= tipo

    }

    constructor(mensaje : String,url : String ,nombre : String, hora: String, foto : String, tipo : String) : this() {
        this.mensaje = mensaje
        this.nombre = nombre
        this.hora = hora
        this.foto = foto
        this.tipo = tipo
        urlFoto = url
    }

}