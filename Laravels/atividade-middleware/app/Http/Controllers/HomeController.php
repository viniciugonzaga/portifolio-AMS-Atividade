<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HomeController extends Controller
{
    public function index(Request $request)
    {
        // Recupera a mensagem definida no middleware
        $mensagem = $request->attributes->get('mensagem');

        // Retorna a view passando a mensagem
        return view('home', compact('mensagem'));
    }
}