package com.example.firebase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cv_mensajes.view.*

class AdapterMensaje (mensajes : ArrayList<Mensaje>, contexto : Context) : RecyclerView.Adapter<HolderMensaje>(){
    var lista_mensajes = mensajes
    var c = contexto

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMensaje {
        return HolderMensaje(LayoutInflater.from(parent.context).inflate(R.layout.cv_mensajes, parent, false))
    }

    override fun getItemCount(): Int {
        return lista_mensajes.size
    }

    override fun onBindViewHolder(holder: HolderMensaje, position: Int) {
        holder.itemView.mensajeMensaje.text = lista_mensajes.get(position).mensaje
        holder.itemView.mensajeMensaje.text = lista_mensajes.get(position).mensaje
        holder.itemView.horaMensaje.text = lista_mensajes.get(position).hora
        val foto =lista_mensajes.get(position).foto
        if(!foto.equals(""))
            Glide.with(c).load(foto).into(holder.itemView.fotoPerfilMensaje)

        //Si el mensaje sólo contiene texto...
        if(lista_mensajes.get(position).tipo.equals("1")){
            holder.itemView.mensajeMensaje.visibility= View.VISIBLE
            holder.itemView.mensajeFoto.visibility= View.GONE

        }
        //Si se ha enviado una imagen
        else{
            holder.itemView.mensajeMensaje.visibility= View.VISIBLE
            holder.itemView.mensajeFoto.visibility= View.VISIBLE
            Glide.with(c).load(lista_mensajes.get(position).urlFoto).into(holder.itemView.mensajeFoto)
        }
        //-------------------------------------------------------------------------------------------------------------


    }

}

class HolderMensaje(item : View) : RecyclerView.ViewHolder(item)
