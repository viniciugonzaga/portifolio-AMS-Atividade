<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;

class AccessMiddleware
{
    public function handle(Request $request, Closure $next)
    {
        // Adiciona a mensagem diretamente no request
        $request->attributes->set('mensagem', 'Bem vindo ao portal. Seu acesso não foi autorizado. Entrar em contato com o administrador.');

        // Continua o fluxo para o controller
        return $next($request);
    }
}