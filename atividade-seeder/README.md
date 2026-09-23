# 🌱 Atividade Seeders - Laravel

Projeto desenvolvido como parte de uma atividade prática de **povoamento de banco de dados (Seeders)** em uma aplicação web construída com o framework **Laravel**. O objetivo é demonstrar, de forma clara e versionada, como inserir dados em massa em uma tabela utilizando as ferramentas nativas do Laravel e, ao final, exportar o banco de dados completo em um arquivo `.sql`.

---

## 📖 Sobre o Projeto

Este projeto aplica os conceitos de **Seeders** para popular automaticamente a tabela `produtos` com dados de exemplo. Ele cobre desde a criação da migration, implementação do seeder com inserção massiva, execução via Artisan, verificação no banco e exportação do dump SQL.

> **O que é um Seeder?**
> Seeder é uma classe do Laravel responsável por popular o banco de dados com dados iniciais ou de teste. Ele permite automatizar a inserção de registros, garantindo que qualquer pessoa que clone o projeto possa reproduzir o mesmo estado do banco com um único comando.

---

## 🎯 Objetivos da Atividade

- Criar e configurar classes de **Seeder** via Artisan.
- Implementar **inserção massiva** de dados no método `run()`.
- Executar o povoamento com `php artisan db:seed`.
- Verificar a integridade dos dados em um SGBD (phpMyAdmin).
- Exportar o banco em um arquivo `.sql` (dump completo).
- Versionar o projeto no **GitHub** com README explicativo.

---

## 🧰 Tecnologias Utilizadas

| Ferramenta       | Finalidade                          |
| ---------------- | ----------------------------------- |
| PHP 8.2+         | Linguagem base do Laravel           |
| Laravel 11       | Framework MVC                       |
| Composer         | Gerenciador de dependências do PHP  |
| MySQL / MariaDB  | Banco de dados relacional           |
| phpMyAdmin       | Cliente para visualização e dump    |
| Git / GitHub     | Versionamento e hospedagem          |

---

## 📂 Estrutura Relevante do Projeto
