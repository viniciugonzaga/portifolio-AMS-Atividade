<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README · Sociologia do Esporte · Android App</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:opsz,wght@14..32,400;14..32,500;14..32,600;14..32,700&family=JetBrains+Mono:wght@400;600&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-color: #0d1117;
            padding: 40px 20px;
            display: flex;
            justify-content: center;
            font-family: 'Inter', -apple-system, BlinkMacSystemFont, sans-serif;
            color: #e6edf3;
            line-height: 1.6;
        }

        .container {
            max-width: 920px;
            width: 100%;
            background-color: #0d1117;
            padding: 20px 0 40px 0;
        }

        /* cabeçalho */
        .repo-header {
            display: flex;
            align-items: center;
            gap: 12px;
            border-bottom: 1px solid #30363d;
            padding-bottom: 20px;
            margin-bottom: 24px;
        }

        .repo-header .badge {
            background: #238636;
            color: #fff;
            font-size: 12px;
            font-weight: 600;
            padding: 2px 10px;
            border-radius: 20px;
            letter-spacing: 0.3px;
        }

        .repo-header h1 {
            font-size: 22px;
            font-weight: 600;
            color: #f0f6fc;
        }

        .repo-header .lang {
            font-size: 14px;
            color: #8b949e;
            margin-left: auto;
        }

        /* tipografia */
        h1 {
            font-size: 32px;
            font-weight: 700;
            margin-top: 28px;
            margin-bottom: 12px;
            letter-spacing: -0.5px;
            color: #f0f6fc;
        }

        h2 {
            font-size: 24px;
            font-weight: 600;
            margin-top: 32px;
            margin-bottom: 16px;
            padding-bottom: 8px;
            border-bottom: 1px solid #21262d;
            color: #f0f6fc;
        }

        h3 {
            font-size: 18px;
            font-weight: 600;
            margin-top: 24px;
            margin-bottom: 10px;
            color: #e6edf3;
        }

        p, li {
            color: #c9d1d9;
            margin-bottom: 12px;
        }

        a {
            color: #58a6ff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        /* listas */
        ul, ol {
            padding-left: 24px;
            margin-bottom: 16px;
        }

        li {
            margin-bottom: 6px;
        }

        /* tabelas */
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 16px 0 20px 0;
            font-size: 14px;
        }

        th {
            background-color: #161b22;
            color: #c9d1d9;
            font-weight: 600;
            text-align: left;
            padding: 10px 16px;
            border: 1px solid #30363d;
        }

        td {
            padding: 10px 16px;
            border: 1px solid #30363d;
            background-color: #0d1117;
            color: #c9d1d9;
        }

        /* blocos de código */
        pre {
            background-color: #161b22;
            border-radius: 8px;
            padding: 16px 20px;
            overflow-x: auto;
            margin: 16px 0 20px 0;
            border: 1px solid #30363d;
            font-family: 'JetBrains Mono', 'Fira Code', monospace;
            font-size: 13px;
            line-height: 1.7;
            color: #e6edf3;
        }

        code {
            font-family: 'JetBrains Mono', 'Fira Code', monospace;
            font-size: 13px;
            background-color: #161b22;
            padding: 2px 8px;
            border-radius: 6px;
            color: #f0f6fc;
        }

        pre code {
            background-color: transparent;
            padding: 0;
            border-radius: 0;
            color: inherit;
        }

        /* Destaque de sintaxe manual simplificado */
        .k { color: #ff7b72; }   /* palavra-chave */
        .s { color: #a5d6ff; }   /* string */
        .c { color: #8b949e; }   /* comentário */
        .n { color: #f0f6fc; }   /* nome */
        .f { color: #d2a8ff; }   /* função */
        .p { color: #e6edf3; }   /* pontuação */
        .v { color: #79c0ff; }   /* valor/constante */

        /* badges inline */
        .tech-badge {
            display: inline-block;
            background: #21262d;
            padding: 2px 12px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: 500;
            color: #8b949e;
            border: 1px solid #30363d;
            margin-right: 6px;
        }

        .divider {
            height: 1px;
            background: #21262d;
            margin: 32px 0 24px 0;
        }

        /* ícone pequeno */
        .emoji {
            font-style: normal;
        }

        @media (max-width: 600px) {
            body { padding: 20px 12px; }
            .repo-header { flex-wrap: wrap; }
            .repo-header .lang { margin-left: 0; width: 100%; }
        }
    </style>
</head>
<body>
    <div class="container">

        <!-- cabeçalho do repositório -->
        <div class="repo-header">
            <span class="badge">📱 Android</span>
            <h1>sociologia-esporte-cidades</h1>
            <span class="lang">Kotlin · Jetpack Compose</span>
        </div>

        <!-- TÍTULO PRINCIPAL -->
        <h1>🏟️ Sociologia do Esporte e Cidades</h1>
        <p>
            Aplicativo Android nativo com arquitetura <strong>MVVM</strong>, interface declarativa 
            <strong>Jetpack Compose</strong> e autenticação via <strong>Firebase Auth</strong>. 
            O projeto explora a evolução arquitetônica dos estádios, uniformes históricos e o 
            impacto cultural das torcidas nas metrópoles.
        </p>

        <hr class="divider">

        <!-- SUMÁRIO TÉCNICO -->
        <h2>📋 Sumário Técnico</h2>
        <ul>
            <li><a href="#stack">Stack &amp; Versões</a></li>
            <li><a href="#arch">Arquitetura e Padrões</a></li>
            <li><a href="#structure">Estrutura de Diretórios</a></li>
            <li><a href="#gradle">Configuração do Gradle (KTS)</a></li>
            <li><a href="#firebase-setup">Configuração do Firebase</a></li>
            <li><a href="#ui-preview">UI com Pré-visualização (@Preview)</a></li>
            <li><a href="#run">Como Executar</a></li>
        </ul>

        <hr class="divider">

        <!-- 1. STACK -->
        <h2 id="stack">🧰 Stack Tecnológica</h2>
        <table>
            <thead>
                <tr>
                    <th>Componente</th>
                    <th>Tecnologia / Biblioteca</th>
                    <th>Versão</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Linguagem</td>
                    <td>Kotlin</td>
                    <td>1.9.22</td>
                </tr>
                <tr>
                    <td>UI Framework</td>
                    <td>Jetpack Compose (Material 3)</td>
                    <td>BOM 2024.06.00</td>
                </tr>
                <tr>
                    <td>Compiler Extension</td>
                    <td>Kotlin Compose Compiler</td>
                    <td>1.5.14</td>
                </tr>
                <tr>
                    <td>Navegação</td>
                    <td>Navigation Compose</td>
                    <td>2.7.7</td>
                </tr>
                <tr>
                    <td>Gerenciamento de Estado</td>
                    <td>ViewModel + LiveData (observable)</td>
                    <td>lifecycle 2.8.0</td>
                </tr>
                <tr>
                    <td>Autenticação</td>
                    <td>Firebase Authentication (e-mail/senha)</td>
                    <td>BoM 33.0.0</td>
                </tr>
                <tr>
                    <td>SDK Android</td>
                    <td>Compile / Target SDK</td>
                    <td>34 (Android 14)</td>
                </tr>
                <tr>
                    <td>Mínimo Suportado</td>
                    <td>Min SDK</td>
                    <td>24 (Android 7.0)</td>
                </tr>
            </tbody>
        </table>

        <hr class="divider">

        <!-- 2. ARQUITETURA -->
        <h2 id="arch">🧩 Arquitetura e Padrões</h2>
        <p>
            O projeto segue o padrão <strong>MVVM (Model-View-ViewModel)</strong> com separação 
            clara de responsabilidades:
        </p>
        <ul>
            <li>
                <strong>Model (AuthViewModel):</strong> Gerencia o estado de autenticação 
                (<code>AuthState</code>), expõe <code>LiveData</code> para a UI e implementa 
                os métodos <code>login()</code>, <code>signup()</code> e <code>logout()</code> 
                utilizando o <code>FirebaseAuth</code>.
            </li>
            <li>
                <strong>View (Pages):</strong> Telas em Compose que observam o ViewModel. 
                Cada tela é dividida em duas funções:
                <ul>
                    <li><code>XxxContent(...)</code> – UI pura, recebe callbacks e dados como parâmetros.</li>
                    <li><code>XxxPage(...)</code> – Conecta o ViewModel ao Content, gerenciando estado local.</li>
                </ul>
            </li>
            <li>
                <strong>Navigation:</strong> Roteamento gerenciado pelo <code>NavHost</code> 
                com rotas <code>"login"</code>, <code>"signup"</code> e <code>"home"</code>. 
                O destino inicial é definido dinamicamente com base no <code>AuthState</code>.
            </li>
        </ul>

        <hr class="divider">

        <!-- 3. ESTRUTURA -->
        <h2 id="structure">📁 Estrutura de Diretórios</h2>
        <pre>
<code>app/src/main/
├── java/com/example/android_app/
│   ├── MainActivity.kt                 # Entry point, configura o tema e o scaffold
│   ├── AuthViewModel.kt                # ViewModel com FirebaseAuth + sealed class AuthState
│   ├── MyAppNavigation.kt              # NavHost com as rotas principais
│   ├── pages/
│   │   ├── LoginPage.kt                # LoginContent + LoginPage + @Preview
│   │   ├── SignupPage.kt               # SignupContent + SignupPage + @Preview
│   │   └── HomePage.kt                 # HomeContent + HomePage + @Preview
│   └── ui/theme/
│       ├── Theme.kt                    # Wrapper do MaterialTheme
│       ├── Color.kt                    # Paleta de cores
│       └── Type.kt                     # Tipografia personalizada
├── res/
│   ├── drawable/ic_stadium.xml         # Ícone vetorizado (estádio)
│   └── (demais recursos padrão)
└── google-services.json                # 🔐 Credenciais do Firebase (não versionar)</code>
        </pre>

        <hr class="divider">

        <!-- 4. GRADLE -->
        <h2 id="gradle">⚙️ Configuração do Gradle (build.gradle.kts)</h2>
        <p><strong>Projeto (root):</strong></p>
        <pre>
<code>plugins {
    id("com.android.application") version "8.5.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}</code>
        </pre>

        <p><strong>Módulo app:</strong></p>
        <pre>
<code>plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.android_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.android_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures { compose = true }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"   # essencial para compatibilidade com BOM 2024.06.00
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions { jvmTarget = "11" }

    # Resolve conflitos transitivos
    configurations.all {
        resolutionStrategy {
            force("androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")
        }
    }
}

dependencies {
    # Core
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation("androidx.activity:activity-compose:1.9.0")

    # Compose BOM
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.runtime:runtime-livedata")

    # Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    # Firebase (BoM gerencia as versões)
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation("com.google.firebase:firebase-auth-ktx")
}</code>
        </pre>

        <hr class="divider">

        <!-- 5. FIREBASE -->
        <h2 id="firebase-setup">🔥 Firebase - Configuração Técnica</h2>
        <ol>
            <li>
                <strong>Criação do projeto:</strong> Acesse o <a href="https://console.firebase.google.com" target="_blank">Console do Firebase</a> 
                e crie um novo projeto (ex: <code>SociologiaApp</code>).
            </li>
            <li>
                <strong>Registro do app Android:</strong> Adicione um app com o <code>applicationId</code> 
                <code>com.example.android_app</code>. Baixe o arquivo <code>google-services.json</code> 
                e insira em <code>app/</code>.
            </li>
            <li>
                <strong>Habilitar método de login:</strong> No painel, vá em <strong>Authentication → Sign-in methods</strong> 
                e ative <strong>E-mail/senha</strong>.
            </li>
            <li>
                <strong>Regras de segurança (Firestore, se usado):</strong> Não aplicável, pois o app 
                utiliza apenas o Authentication (sem banco de dados).
            </li>
            <li>
                <strong>Verificação do plugin:</strong> O Gradle já está configurado com o plugin 
                <code>com.google.gms.google-services</code> para processar o JSON.
            </li>
        </ol>
        <p>
            ⚠️ O arquivo <code>google-services.json</code> contém chaves de API sensíveis. 
            Recomenda-se adicionar <code>google-services.json</code> ao <code>.gitignore</code>.
        </p>

        <hr class="divider">

        <!-- 6. UI PREVIEW -->
        <h2 id="ui-preview">👁️ Pré-visualização com @Preview</h2>
        <p>
            Cada página possui uma função <code>@Preview</code> que renderiza o <code>Content</code> 
            com dados estáticos (mockados). Isso permite visualizar as telas diretamente no 
            Android Studio no modo <strong>Split</strong> ou <strong>Design</strong>, 
            <strong>sem necessidade de build completo ou emulador</strong>.
        </p>
        <pre>
<code>@Preview(showBackground = true, name = "Login Preview")
@Composable
fun PreviewLogin() {
    Android_appTheme {
        LoginContent(
            email = "teste@email.com",
            onEmailChange = {},
            password = "123456",
            onPasswordChange = {},
            passwordVisible = false,
            onTogglePassword = {},
            onLoginClick = {},
            onSignupClick = {},
            errorMessage = null
        )
    }
}</code>
        </pre>
        <p>
            Essa abordagem acelera o desenvolvimento de interface e permite ajustes finos 
            de layout, cores e espaçamentos em segundos.
        </p>

        <hr class="divider">

        <!-- 7. RUN -->
        <h2 id="run">🚀 Como Executar</h2>
        <ol>
            <li>Clone o repositório: <code>git clone &lt;url&gt;</code></li>
            <li>Abra o projeto no <strong>Android Studio Iguana (2023.2.1+)</strong>.</li>
            <li>Adicione o arquivo <code>google-services.json</code> na pasta <code>app/</code>.</li>
            <li>Clique em <strong>File → Sync Project with Gradle Files</strong>.</li>
            <li>Conecte um dispositivo físico (USB Debugging) ou crie um AVD (API 24+).</li>
            <li>Clique em <strong>Run</strong> (▶) ou use o atalho <code>Shift + F10</code>.</li>
        </ol>

        <hr class="divider">

        <!-- FOOTER TÉCNICO -->
        <div style="display: flex; flex-wrap: wrap; gap: 12px; justify-content: space-between; align-items: center; padding-top: 16px; border-top: 1px solid #21262d; margin-top: 32px;">
            <span style="color: #8b949e; font-size: 14px;">
                ⚡ Kotlin 1.9.22 · Compose 2024.06.00 · Firebase BoM 33.0.0
            </span>
            <span style="color: #8b949e; font-size: 14px;">
                📄 Licença · Uso acadêmico
            </span>
        </div>

    </div>
</body>
</html>
