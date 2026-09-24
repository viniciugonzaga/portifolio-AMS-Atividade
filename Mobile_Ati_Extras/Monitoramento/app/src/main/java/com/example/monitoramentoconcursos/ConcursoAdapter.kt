package com.example.monitoramentoconcursos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.monitoramentoconcursos.R

class ConcursoAdapter(
    private val listaConcursos: MutableList<Concurso>,
    private val onEditarClick: (Concurso) -> Unit,
    private val onExcluirClick: (Concurso) -> Unit,
) : RecyclerView.Adapter<ConcursoAdapter.ConcursoViewHolder>() {

    class ConcursoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvFaculdade: TextView = view.findViewById(R.id.tvFaculdade)
        val tvDisciplina: TextView = view.findViewById(R.id.tvDisciplina)
        val tvBanca: TextView = view.findViewById(R.id.tvBanca)
        val tvData: TextView = view.findViewById(R.id.tvData)
        val btnEditar: Button = view.findViewById(R.id.btnEditar)
        val btnExcluir: Button = view.findViewById(R.id.btnExcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcursoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_concurso, parent, false)
        return ConcursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConcursoViewHolder, position: Int) {
        val concurso = listaConcursos[position]
        holder.tvFaculdade.text = concurso.faculdade
        holder.tvDisciplina.text = concurso.disciplina
        holder.tvBanca.text = concurso.banca
        holder.tvData.text = concurso.dataProva

        holder.btnEditar.setOnClickListener { onEditarClick(concurso) }
        holder.btnExcluir.setOnClickListener { onExcluirClick(concurso) }
    }

    override fun getItemCount() = listaConcursos.size
}
