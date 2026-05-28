<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Produto;
use App\Models\Categoria;

class ProdutoController
{
    public function index()
    {
        $produtos = Produto::with(
            'categoria'
        )->get();

        $categorias = Categoria::all();

        return view(
            'produtos',
            compact(
                'produtos',
                'categorias'
            )
        );
    }

    public function salvar(
        Request $request
    )
    {
        Produto::create([

            'nome' =>
                $request->nome,

            'categoria_id' =>
                $request->categoria_id

        ]);

        return redirect('/');
    }
}