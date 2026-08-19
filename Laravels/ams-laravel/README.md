# 📚 Sistema de Blog com Migrations Laravel

Este projeto foi desenvolvido como atividade prática para demonstrar a criação de **migrations** no Laravel, abrangendo os principais tipos de relacionamento entre tabelas em um banco de dados relacional: **1:1 (Um para Um)**, **1:N (Um para Muitos)** e **N:M (Muitos para Muitos)**.

O banco de dados utilizado é o **MySQL**, e toda a estrutura foi gerada utilizando os recursos nativos do Eloquent ORM, com geração automática de chaves estrangeiras (*Foreign Keys*) e índices.

---

## 🗂️ Estrutura do Banco de Dados

O esquema do banco `ams_laravel_db` é composto pelas seguintes tabelas e seus respectivos relacionamentos:

| Tabela | Descrição | Relacionamento |
| :--- | :--- | :--- |
| **users** | Armazena os dados de login (nome, e-mail, senha). | Tabela base para os relacionamentos. |
| **profiles** | Armazena dados complementares do usuário (bio, avatar). | **1:1** com `users` (cada usuário tem um único perfil). |
| **posts** | Armazena as postagens do blog (título e conteúdo). | **1:N** com `users` (um usuário pode ter vários posts). |
| **tags** | Armazena as categorias/etiquetas disponíveis. | Tabela independente. |
| **post_tag** | Tabela pivô que faz a ligação entre `posts` e `tags`. | **N:M** (muitos para muitos) entre `posts` e `tags`. |

### 🔍 Detalhamento dos Relacionamentos

1.  **1:1 (Um para Um) – `users` → `profiles`**
    - A tabela `profiles` possui a coluna `user_id` definida como `foreignId()->constrained()`.
    - Isso garante que cada perfil esteja vinculado a um único usuário e vice-versa.
    - Foi aplicado `onDelete('cascade')` para que, ao excluir um usuário, seu perfil também seja removido automaticamente.

2.  **1:N (Um para Muitos) – `users` → `posts`**
    - A tabela `posts` possui a coluna `user_id` definida como `foreignId()->constrained()`.
    - Um usuário pode criar múltiplos posts, mas cada post pertence a um único autor.

3.  **N:M (Muitos para Muitos) – `posts` ↔ `tags`**
    - Foi criada a tabela pivô `post_tag` contendo as colunas `post_id` e `tag_id`, ambas com `foreignId()->constrained()`.
    - Um post pode ter várias tags, e uma tag pode estar associada a vários posts.

---

## 🚀 Como Configurar e Executar o Projeto

Siga os passos abaixo para rodar o projeto em seu ambiente local:

### 1. Pré-requisitos

- PHP >= 8.0
- Composer
- MySQL (ou MariaDB)
- Git

### 2. Clonar o Repositório

```bash
git clone <URL_DO_SEU_REPOSITORIO>
cd ams-laravel
