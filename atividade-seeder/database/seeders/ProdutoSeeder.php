<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class ProdutoSeeder extends Seeder
{
    public function run(): void
    {
        $produtos = [
            [
                'nome' => 'Smartphone Galaxy S23',
                'preco' => 3499.90,
                'estoque' => 15,
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'nome' => 'Notebook Dell Inspiron',
                'preco' => 4299.00,
                'estoque' => 8,
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'nome' => 'Fone de Ouvido Bluetooth',
                'preco' => 299.90,
                'estoque' => 50,
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'nome' => 'Teclado Mecânico RGB',
                'preco' => 450.00,
                'estoque' => 25,
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'nome' => 'Mouse Gamer Sem Fio',
                'preco' => 189.90,
                'estoque' => 40,
                'created_at' => now(),
                'updated_at' => now(),
            ],
        ];

        DB::table('produtos')->insert($produtos);
    }
}