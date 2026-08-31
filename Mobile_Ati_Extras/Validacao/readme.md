# 🏟️ Sociologia do Esporte e Cidades

Aplicativo Android nativo desenvolvido em **Kotlin** com **Jetpack Compose** para explorar a evolução arquitetônica dos estádios, uniformes históricos e o impacto cultural das torcidas nas metrópoles. O app utiliza **Firebase Authentication** para gerenciar login e cadastro de usuários.

---

## 📋 Índice

- [Tecnologias e Versões](#tecnologias-e-versões)
- [Arquitetura e Padrões](#arquitetura-e-padrões)
- [Estrutura de Diretórios](#estrutura-de-diretórios)
- [Configuração do Gradle](#configuração-do-gradle)
- [Firebase – Configuração](#firebase--configuração)
- [Pré-visualização da UI (@Preview)](#pré-visualização-da-ui-preview)
- [Como Executar](#como-executar)
- [Licença](#licença)

---

## 🧰 Tecnologias e Versões

| Componente                  | Tecnologia / Biblioteca          | Versão          |
|-----------------------------|----------------------------------|-----------------|
| Linguagem                   | Kotlin                           | 1.9.22          |
| UI Framework                | Jetpack Compose (Material 3)     | BOM 2024.06.00  |
| Compose Compiler Extension  | kotlinCompilerExtensionVersion   | 1.5.14          |
| Navegação                   | Navigation Compose               | 2.7.7           |
| Gerenciamento de Estado     | ViewModel + LiveData             | lifecycle 2.8.0 |
| Autenticação                | Firebase Authentication          | BoM 33.0.0      |
| Android SDK                 | compileSdk / targetSdk           | 34 (Android 14) |
| SDK Mínimo                  | minSdk                           | 24 (Android 7.0)|

---

## 🧩 Arquitetura e Padrões

O projeto segue o padrão **MVVM (Model-View-ViewModel)** com separação clara de responsabilidades:

- **Model (`AuthViewModel`)**  
  Gerencia o estado de autenticação (`AuthState`), expõe `LiveData` para a UI e implementa os métodos `login()`, `signup()` e `logout()` utilizando a instância do `FirebaseAuth`.

- **View (Páginas Compose)**  
  Cada tela é dividida em duas funções:
  - `XxxContent(...)`: UI pura, recebe callbacks e dados como parâmetros.  
  - `XxxPage(...)`: Conecta o ViewModel ao `Content`, gerenciando estado local e observando o `LiveData`.

- **Navigation**  
  Roteamento gerenciado pelo `NavHost` com rotas `"login"`, `"signup"` e `"home"`. O destino inicial é definido dinamicamente com base no `AuthState`.

