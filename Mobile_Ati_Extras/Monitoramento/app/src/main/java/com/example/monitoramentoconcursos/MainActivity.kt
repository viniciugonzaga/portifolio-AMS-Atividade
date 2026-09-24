package com.example.monitoramentoconcursos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class MainActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var adapter: ConcursoAdapter
    private val listaConcursos = mutableListOf<Concurso>()
    private var concursoEditando: Concurso? = null

    private lateinit var etFaculdade: EditText
    private lateinit var etDisciplina: EditText
    private lateinit var etBanca: EditText
    private lateinit var etData: EditText
    private lateinit var btnSalvar: Button
    private lateinit var btnCancelar: Button
    private lateinit var rvConcursos: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa o Firestore
        db = FirebaseFirestore.getInstance()

        // Vincula os componentes do layout
        etFaculdade = findViewById(R.id.etFaculdade)
        etDisciplina = findViewById(R.id.etDisciplina)
        etBanca = findViewById(R.id.etBanca)
        etData = findViewById(R.id.etData)
        btnSalvar = findViewById(R.id.btnSalvar)
        btnCancelar = findViewById(R.id.btnCancelar)
        rvConcursos = findViewById(R.id.rvConcursos)

        // Configura o RecyclerView
        adapter = ConcursoAdapter(listaConcursos, ::preencherFormulario, ::excluirConcurso)
        rvConcursos.layoutManager = LinearLayoutManager(this)
        rvConcursos.adapter = adapter

        // Configura os listeners dos botões
        btnSalvar.setOnClickListener { salvarConcurso() }
        btnCancelar.setOnClickListener { limparFormulario() }

        // Carrega os dados em tempo real
        carregarConcursos()
    }

    // CREATE e UPDATE
    private fun salvarConcurso() {
        val faculdade = etFaculdade.text.toString().trim()
        val disciplina = etDisciplina.text.toString().trim()
        val banca = etBanca.text.toString().trim()
        val data = etData.text.toString().trim()

        if (faculdade.isEmpty() || disciplina.isEmpty() || banca.isEmpty() || data.isEmpty()) {
            Toast.makeText(this, getString(R.string.msg_preencha_campos), Toast.LENGTH_SHORT).show()
            return
        }

        val concursoMap: Map<String, Any> = mapOf(
            "faculdade" to faculdade,
            "disciplina" to disciplina,
            "banca" to banca,
            "dataProva" to data,
        )

        val editando = concursoEditando

        if (editando == null) {
            // CREATE
            db.collection("concursos").add(concursoMap)
                .addOnSuccessListener {
                    Toast.makeText(this, getString(R.string.msg_concurso_cadastrado), Toast.LENGTH_SHORT).show()
                    limparFormulario()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, getString(R.string.msg_erro, e.message ?: ""), Toast.LENGTH_SHORT).show()
                }
        } else {
            // UPDATE
            db.collection("concursos").document(editando.id).update(concursoMap)
                .addOnSuccessListener {
                    Toast.makeText(this, getString(R.string.msg_concurso_atualizado), Toast.LENGTH_SHORT).show()
                    limparFormulario()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, getString(R.string.msg_erro, e.message ?: ""), Toast.LENGTH_SHORT).show()
                }
        }
    }

    // READ (Tempo Real)
    @SuppressLint("NotifyDataSetChanged")
    private fun carregarConcursos() {
        db.collection("concursos")
            .orderBy("dataProva", Query.Direction.ASCENDING)
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(this, getString(R.string.msg_erro_carregar, e.message ?: ""), Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    listaConcursos.clear()
                    for (doc in snapshot.documents) {
                        val concurso = doc.toObject(Concurso::class.java)
                        concurso?.let {
                            // Garante que o ID do documento seja atribuído ao objeto
                            listaConcursos.add(it.copy(id = doc.id))
                        }
                    }
                    adapter.notifyDataSetChanged()
                }
            }
    }

    // DELETE
    private fun excluirConcurso(concurso: Concurso) {
        db.collection("concursos").document(concurso.id).delete()
            .addOnSuccessListener {
                Toast.makeText(this, getString(R.string.msg_concurso_excluido), Toast.LENGTH_SHORT).show()
                // Se o item excluído estava sendo editado, limpa o formulário
                if (concursoEditando?.id == concurso.id) {
                    limparFormulario()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, getString(R.string.msg_erro_excluir, e.message ?: ""), Toast.LENGTH_SHORT).show()
            }
    }

    // Preenche o formulário para edição (UPDATE)
    private fun preencherFormulario(concurso: Concurso) {
        concursoEditando = concurso
        etFaculdade.setText(concurso.faculdade)
        etDisciplina.setText(concurso.disciplina)
        etBanca.setText(concurso.banca)
        etData.setText(concurso.dataProva)
        btnSalvar.text = getString(R.string.btn_atualizar)
        btnCancelar.visibility = View.VISIBLE
    }

    // Limpa o formulário e o estado de edição
    private fun limparFormulario() {
        etFaculdade.text.clear()
        etDisciplina.text.clear()
        etBanca.text.clear()
        etData.text.clear()
        concursoEditando = null
        btnSalvar.text = getString(R.string.btn_salvar)
        btnCancelar.visibility = View.GONE
    }
}
