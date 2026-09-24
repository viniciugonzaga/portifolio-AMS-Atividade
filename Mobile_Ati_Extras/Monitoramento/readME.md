# Monitoramento de Concursos Públicos Docentes (Android)

Aplicativo Android para gerenciamento de concursos públicos docentes, com operações CRUD (Create, Read, Update, Delete) integradas ao Firebase Firestore.

## 🎯 Objetivo
Facilitar o acompanhamento de editais de concursos docentes, permitindo cadastrar, visualizar, editar e excluir informações como faculdade, disciplina, banca examinadora e data da prova.

## 🚀 Tecnologias Utilizadas
- **Linguagem:** Kotlin
- **Plataforma:** Android Studio
- **Banco de Dados:** Firebase Firestore

## 🔧 Funcionalidades
- **Cadastrar** um novo concurso.
- **Listar** os concursos cadastrados em tempo real.
- **Editar** as informações de um concurso existente.
- **Excluir** um concurso.
- **Sincronização em Tempo Real:** A lista é atualizada automaticamente com as mudanças no Firestore.

## 🗄️ Estrutura do Banco de Dados (Firestore)
- **Coleção:** `concursos`
- **Documento:** Contém os campos: `faculdade`, `disciplina`, `banca`, `dataProva`.

## 🔌 Como Rodar o Projeto
1.  Clone este repositório.
2.  Abra o projeto no **Android Studio**.
3.  No [Console do Firebase](https://console.firebase.google.com/), crie um projeto, ative o **Firestore Database** e registre um app Android com o mesmo *package name* do projeto.
4.  Baixe o arquivo `google-services.json` e coloque-o na pasta `app/` do projeto.
5.  Sincronize o projeto com o Gradle (**File > Sync Project with Gradle Files**).
6.  Execute o aplicativo em um emulador ou dispositivo físico.
