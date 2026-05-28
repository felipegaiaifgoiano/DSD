<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\Categoria;

class DatabaseSeeder extends Seeder
{
    public function run(): void
    {
        Categoria::firstOrCreate([
            'nome' => 'Informática'
        ]);

        Categoria::firstOrCreate([
            'nome' => 'Games'
        ]);

        Categoria::firstOrCreate([
            'nome' => 'Escritório'
        ]);
    }
}