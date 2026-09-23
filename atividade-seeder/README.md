<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Atividade Seeders - Laravel</title>
</head>
<body>

    <h1>Atividade Seeders - Laravel</h1>
    <p>Povoamento de banco de dados com Seeders e exportacao SQL.</p>

    <hr>

    <h2>Sobre o Projeto</h2>
    <p>
        Este projeto foi desenvolvido como parte de uma atividade pratica de
        <strong>povoamento de banco de dados (Seeders)</strong> em uma aplicacao web
        construida com o framework <strong>Laravel</strong>. O objetivo e demonstrar,
        de forma clara e versionada, como inserir dados em massa em uma tabela
        utilizando as ferramentas nativas do Laravel e, ao final, exportar o
        banco de dados completo em um arquivo <code>.sql</code>.
    </p>

    <h3>O que e um Seeder?</h3>
    <p>
        Seeder e uma classe do Laravel responsavel por popular o banco de dados
        com dados iniciais ou de teste. Ele permite automatizar a insercao de
        registros, garantindo que qualquer pessoa que clone o projeto possa
        reproduzir o mesmo estado do banco com um unico comando.
    </p>

    <hr>

    <h2>Objetivos da Atividade</h2>
    <ul>
        <li>Criar e configurar classes de Seeder via Artisan.</li>
        <li>Implementar insercao massiva de dados no metodo <code>run()</code>.</li>
        <li>Executar o povoamento com <code>php artisan db:seed</code>.</li>
        <li>Verificar a integridade dos dados em um SGBD (phpMyAdmin).</li>
        <li>Exportar o banco em um arquivo <code>.sql</code> (dump completo).</li>
        <li>Versionar o projeto no GitHub com README explicativo.</li>
    </ul>

    <hr>

    <h2>Tecnologias Utilizadas</h2>
    <ul>
        <li>PHP 8.2+</li>
        <li>Laravel 11</li>
        <li>Composer</li>
        <li>MySQL / MariaDB</li>
        <li>phpMyAdmin</li>
        <li>Git / GitHub</li>
    </ul>

    <hr>

    <h2>Estrutura Relevante do Projeto</h2>
    <pre>
atividade-seeder/
├── app/
├── database/
│   ├── migrations/
│   │   └── xxxx_xx_xx_create_produtos_table.php
│   └── seeders/
│       ├── DatabaseSeeder.php
│       └── ProdutoSeeder.php
├── .env
├── artisan
├── composer.json
├── dump_completo.sql
└── README.html
    </pre>

    <hr>

    <h2>Passo a Passo de Execucao</h2>

    <h3>1. Clonar o repositorio</h3>
    <pre>
git clone https://github.com/seu-usuario/atividade-seeder.git
cd atividade-seeder
    </pre>

    <h3>2. Instalar as dependencias</h3>
    <pre>
composer install
    </pre>

    <h3>3. Configurar o arquivo .env</h3>
    <pre>
copy .env.example .env
php artisan key:generate
    </pre>
    <p>Configurar no .env:</p>
    <pre>
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=laravel_seeder
DB_USERNAME=root
DB_PASSWORD=
    </pre>

    <h3>4. Criar o banco de dados</h3>
    <pre>
mysql -u root -p -e "CREATE DATABASE laravel_seeder;"
    </pre>

    <h3>5. Executar as migrations</h3>
    <pre>
php artisan migrate
    </pre>

    <h3>6. Executar os Seeders</h3>
    <p>Para rodar todos os seeders:</p>
    <pre>
php artisan db:seed
    </pre>
    <p>Para executar apenas o ProdutoSeeder:</p>
    <pre>
php artisan db:seed --class=ProdutoSeeder
    </pre>
    <p>Para recriar tudo do zero e popular:</p>
    <pre>
php artisan migrate:fresh --seed
    </pre>

    <hr>

    <h2>Sobre o ProdutoSeeder</h2>
    <p>
        O seeder insere <strong>5 produtos de exemplo</strong> na tabela
        <code>produtos</code> utilizando insercao massiva (um unico
        <code>insert</code> com array de registros).
    </p>

    <pre>
&lt;?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class ProdutoSeeder extends Seeder
{
    public function run(): void
    {
        $produtos = [
            [
                'nome' =&gt; 'Smartphone Galaxy S23',
                'preco' =&gt; 3499.90,
                'estoque' =&gt; 15,
                'created_at' =&gt; now(),
                'updated_at' =&gt; now(),
            ],
            [
                'nome' =&gt; 'Notebook Dell Inspiron',
                'preco' =&gt; 4299.00,
                'estoque' =&gt; 8,
                'created_at' =&gt; now(),
                'updated_at' =&gt; now(),
            ],
            [
                'nome' =&gt; 'Fone de Ouvido Bluetooth',
                'preco' =&gt; 299.90,
                'estoque' =&gt; 50,
                'created_at' =&gt; now(),
                'updated_at' =&gt; now(),
            ],
            [
                'nome' =&gt; 'Teclado Mecanico RGB',
                'preco' =&gt; 450.00,
                'estoque' =&gt; 25,
                'created_at' =&gt; now(),
                'updated_at' =&gt; now(),
            ],
            [
                'nome' =&gt; 'Mouse Gamer Sem Fio',
                'preco' =&gt; 189.90,
                'estoque' =&gt; 40,
                'created_at' =&gt; now(),
                'updated_at' =&gt; now(),
            ],
        ];

        DB::table('produtos')-&gt;insert($produtos);
    }
}
    </pre>

    <hr>

    <h2>Estrutura da Tabela produtos</h2>
    <table border="1" cellpadding="6" cellspacing="0">
        <thead>
            <tr>
                <th>Coluna</th>
                <th>Tipo</th>
                <th>Descricao</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>id</td>
                <td>BIGINT UNSIGNED</td>
                <td>Chave primaria auto-incremental</td>
            </tr>
            <tr>
                <td>nome</td>
                <td>VARCHAR(255)</td>
                <td>Nome do produto</td>
            </tr>
            <tr>
                <td>preco</td>
                <td>DECIMAL(10,2)</td>
                <td>Preco unitario</td>
            </tr>
            <tr>
                <td>estoque</td>
                <td>INT</td>
                <td>Quantidade em estoque</td>
            </tr>
            <tr>
                <td>created_at</td>
                <td>TIMESTAMP</td>
                <td>Data de criacao</td>
            </tr>
            <tr>
                <td>updated_at</td>
                <td>TIMESTAMP</td>
                <td>Data de atualizacao</td>
            </tr>
        </tbody>
    </table>

    <hr>

    <h2>Exportacao do Banco (Dump)</h2>
    <p>Via linha de comando:</p>
    <pre>
mysqldump -u root -p laravel_seeder &gt; dump_completo.sql
    </pre>

    <p>Via phpMyAdmin:</p>
    <ol>
        <li>Selecionar o banco laravel_seeder.</li>
        <li>Clicar na aba Exportar.</li>
        <li>Escolher metodo Rapida e formato SQL.</li>
        <li>Clicar em Executar e salvar como dump_completo.sql.</li>
    </ol>

    <hr>

    <h2>Verificacao dos Dados</h2>
    <pre>
php artisan db:show
php artisan tinker
&gt;&gt;&gt; DB::table('produtos')-&gt;count();
    </pre>

    <hr>

    <h2>Problemas Comuns</h2>
    <table border="1" cellpadding="6" cellspacing="0">
        <thead>
            <tr>
                <th>Erro</th>
                <th>Causa</th>
                <th>Solucao</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>vendor/autoload.php not found</td>
                <td>Dependencias nao instaladas</td>
                <td>Rodar composer install</td>
            </tr>
            <tr>
                <td>Table 'produtos' doesn't exist</td>
                <td>Migration nao executada</td>
                <td>Rodar php artisan migrate</td>
            </tr>
            <tr>
                <td>Class ProdutoSeeder not found</td>
                <td>Namespace ou caminho incorreto</td>
                <td>Conferir database/seeders/ProdutoSeeder.php</td>
            </tr>
            <tr>
                <td>Nenhum dado inserido</td>
                <td>Seeder nao executado</td>
                <td>Rodar php artisan db:seed --class=ProdutoSeeder</td>
            </tr>
        </tbody>
    </table>

    <hr>

    <h2>Comandos Principais</h2>
    <pre>
# Criar migration
php artisan make:migration create_produtos_table --create=produtos

# Criar seeder
php artisan make:seeder ProdutoSeeder

# Executar migrations
php artisan migrate

# Executar seeders
php artisan db:seed
php artisan db:seed --class=ProdutoSeeder
php artisan migrate:fresh --seed

# Exportar dump
mysqldump -u root -p laravel_seeder &gt; dump_completo.sql
    </pre>

    <hr>

    <h2>Entregas</h2>
    <ul>
        <li>Repositorio GitHub com este README documentando o processo completo.</li>
        <li>Arquivo dump_completo.sql contendo a estrutura e os dados populados.</li>
    </ul>

    <hr>

    <p><em>Atividade desenvolvida para pratica de Seeders em Laravel.</em></p>

</body>
</html>
