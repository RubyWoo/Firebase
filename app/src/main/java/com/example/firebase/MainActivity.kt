package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val IMAGE_CODE = 123
    }
    val baseChat: DatabaseReference = FirebaseDatabase.getInstance().reference
    lateinit var adapter : AdapterMensaje

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Para el RecyclerView----------------------------------------------------------------------

        val mensajes = ArrayList<Mensaje>()
        adapter = AdapterMensaje(mensajes,this)
        val llm = LinearLayoutManager(this)
        rvMensajes.layoutManager = llm
        rvMensajes.adapter = adapter

        //------------------------------------------------------------------------------------------

        //Cuando se presiona el botón enviar mensaje------------------------------------------------
        btnEnviar.setOnClickListener() {

            //val fecha = obtenerFecha()
            //Se crea un objeto de tipo mensaje que obtiene la información de la vista
            val new_msj = Mensaje(txtMensaje.text.toString(), "", "", "", "", "")

            /*mensajes.add(new_msj)
            Toast.makeText(this, mensajes.get(mensajes.size-1).mensaje,Toast.LENGTH_LONG).show()
            adapter.notifyDataSetChanged()*/

            //Añadimos el objeto a la base
            baseChat.child("Chat").push().setValue(new_msj)
            txtMensaje.setText("")

        }

        btnEnviarFoto.setOnClickListener {

        }
        //------------------------------------------------------------------------------------------

        var childEvent = object  : ChildEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                //Se obtiene el elemento y se guarda en un objeto de tipo mensaje
                val mensaje = p0?.getValue(Mensaje::class.java)
                //Se agrega a nuestra estructura de datos
                mensajes.add(mensaje!!)
                //Se indica que hubo un cambio para actualizar la vista
                adapter.notifyDataSetChanged()

            }

            override fun onChildRemoved(p0: DataSnapshot) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        baseChat.child("Chat").addChildEventListener(childEvent)
    }
}
