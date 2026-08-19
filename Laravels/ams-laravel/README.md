# Projeto Laravel - Migrations com Relacionamentos

## Estrutura do Banco de Dados

- **users** → **profiles** (1:1)  
- **users** → **posts** (1:N)  
- **posts** ↔ **tags** (N:M) com tabela pivô `post_tag`

## Como executar

1. Configurar `.env` com o banco `ams_laravel_db`
2. Executar `php artisan migrate`
3. O dump da estrutura está em `database_schema.sql`
