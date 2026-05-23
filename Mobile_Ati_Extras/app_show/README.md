<!DOCTYPE html>
<html lang="pt-BR">


<h1>📱 LogCat Button - App Educativo Android</h1>

<div class="screenshot">
    <img src="imagem.png" alt="LogCat Button App Screenshot">
    <p><em>Tela principal do aplicativo LogCat Button</em></p>
</div>

<h2>📋 Sobre o Projeto</h2>
<p>O <strong>LogCat Button</strong> é um aplicativo educativo desenvolvido em Kotlin com Jetpack Compose que demonstra o uso do sistema de logs do Android (LogCat). O app permite que os usuários insiram seus nomes e avaliem seu desempenho através de botões coloridos, cada um registrando mensagens em diferentes níveis de log.</p>

<div class="container">
    <strong>🎯 Objetivo Educacional:</strong> Ensinar na prática como utilizar os diferentes níveis de log do Android para depuração e monitoramento de aplicações.
</div>

<h2>🎯 Funcionalidades</h2>
<ul class="feature-list">
    <li><strong>Campo de entrada</strong> para o nome do usuário</li>
    <li><strong>4 botões de avaliação</strong> (I, R, B, MB) com cores distintas</li>
    <li><strong>Sistema de logs</strong> demonstrando diferentes níveis de severidade</li>
    <li><strong>Feedback visual</strong> animado para cada ação</li>
    <li><strong>Design moderno</strong> com animações e gradientes</li>
    <li><strong>Interface responsiva</strong> e intuitiva</li>
</ul>

<h2>🎨 Cores dos Botões e Significados</h2>
<table>
    <thead>
        <tr><th>Botão</th><th>Significado</th><th>Cor</th><th>Nível do Log</th></tr>
    </thead>
    <tbody>
        <tr><td><strong>I</strong></td><td>Insuficiente</td><td style="background-color:#e74c3c; color:white;">🔴 Vermelho</td><td><code>Log.e()</code> - Error</td></tr>
        <tr><td><strong>R</strong></td><td>Regular</td><td style="background-color:#f39c12; color:white;">🟠 Laranja</td><td><code>Log.w()</code> - Warning</td></tr>
        <tr><td><strong>B</strong></td><td>Bom</td><td style="background-color:#27ae60; color:white;">🟢 Verde</td><td><code>Log.d()</code> - Debug</td></tr>
        <tr><td><strong>MB</strong></td><td>Muito Bom</td><td style="background-color:#3498db; color:white;">🔵 Azul</td><td><code>Log.i()</code> - Info</td></tr>
    </tbody>
</table>

<h2>📝 Como Funciona o LogCat</h2>
<p>O LogCat é uma ferramenta do Android Studio que exibe mensagens de log do sistema e dos aplicativos. Este projeto demonstra 4 níveis principais:</p>

<h3>Níveis de Log Utilizados:</h3>

<div class="container">
    <h4>1. Log.e() - Error</h4>
    <p>Usado para situações de erro</p>
    <code>Log.e("TesteAndroid", "App: João - Nota I")</code>
    <p><span class="badge" style="background-color:#e74c3c;">🔴 Cor: Vermelha no LogCat</span></p>
</div>

<div class="container">
    <h4>2. Log.w() - Warning</h4>
    <p>Usado para avisos</p>
    <code>Log.w("TesteAndroid", "App: Maria - Nota R")</code>
    <p><span class="badge" style="background-color:#f39c12;">🟠 Cor: Laranja no LogCat</span></p>
</div>

<div class="container">
    <h4>3. Log.d() - Debug</h4>
    <p>Usado para informações de depuração</p>
    <code>Log.d("TesteAndroid", "App: Pedro - Nota B")</code>
    <p><span class="badge" style="background-color:#27ae60;">🟢 Cor: Verde no LogCat</span></p>
</div>

<div class="container">
    <h4>4. Log.i() - Info</h4>
    <p>Usado para informações gerais</p>
    <code>Log.i("TesteAndroid", "App: Ana - Nota MB")</code>
    <p><span class="badge" style="background-color:#3498db;">🔵 Cor: Azul no LogCat</span></p>
</div>

<h3>Como Visualizar os Logs:</h3>
<ol>
    <li>Abra o <strong>LogCat</strong> no Android Studio (View → Tool Windows → Logcat)</li>
    <li>Filtre pela tag <code>TesteAndroid</code></li>
    <li>Execute o app e clique nos botões</li>
    <li>Observe as mensagens aparecendo em diferentes cores</li>
</ol>

<h2>🛠️ Tecnologias Utilizadas</h2>
<div>
    <span class="tech-badge">🎯 Kotlin</span>
    <span class="tech-badge">⚡ Jetpack Compose</span>
    <span class="tech-badge">🎨 Material Design 3</span>
    <span class="tech-badge">🔄 Coroutines</span>
    <span class="tech-badge">📱 Android LogCat</span>
</div>

<h2>📦 Estrutura do Projeto</h2>
<pre>
app/
├── src/main/java/com/example/logcatbutton/
│   ├── MainActivity.kt          # Activity principal e UI
│   └── ui/theme/                # Configurações de tema
│       ├── Color.kt             # Cores personalizadas
│       ├── Theme.kt             # Tema do app
│       └── Type.kt              # Tipografia
└── src/main/res/
    └── drawable/                # Recursos de imagem
        └── eteclogo.png         # Logo do app
</pre>

<h2>🚀 Como Executar</h2>

<h3>Pré-requisitos:</h3>
<ul>
    <li>Android Studio Hedgehog ou superior</li>
    <li>SDK Android 21 (Lollipop) ou superior</li>
    <li>Kotlin 1.9.0 ou superior</li>
</ul>

<h3>Passos:</h3>
<ol>
    <li>
        <strong>Clone o repositório</strong>
        <pre><code>git clone https://github.com/seu-usuario/logcat-button.git</code></pre>
    </li>
    <li>
        <strong>Abra no Android Studio</strong>
        <p>File → Open → Selecione a pasta do projeto</p>
    </li>
    <li>
        <strong>Sincronize as dependências</strong>
        <p>File → Sync Project with Gradle Files</p>
    </li>
    <li>
        <strong>Execute o app</strong>
        <p>Conecte um dispositivo Android ou inicie um emulador e clique no botão "Run" (▶️)</p>
    </li>
</ol>

<h2>💡 Exemplo de Uso</h2>
<ol>
    <li>Digite seu nome no campo de texto</li>
    <li>Clique em um dos botões de avaliação (I, R, B ou MB)</li>
    <li>Observe:
        <ul>
            <li><strong>Feedback visual</strong> na tela confirmando a ação</li>
            <li><strong>Mensagem no LogCat</strong> com o formato: <code>App: [nome] - Nota [avaliação]</code></li>
            <li><strong>Cor diferente</strong> no LogCat dependendo do nível</li>
        </ul>
    </li>
</ol>

<h3>Exemplo de Saída no LogCat:</h3>
<pre>
2024-01-15 14:30:25.123 E/TesteAndroid: App: João - Nota I
2024-01-15 14:30:28.456 W/TesteAndroid: App: João - Nota R
2024-01-15 14:30:31.789 D/TesteAndroid: App: João - Nota B
2024-01-15 14:30:35.012 I/TesteAndroid: App: João - Nota MB
</pre>

<h2>🎯 Objetivos Educacionais</h2>
<p>Este projeto foi desenvolvido para demonstrar:</p>
<ul class="feature-list">
    <li>Uso prático do sistema de logs do Android</li>
    <li>Diferenças entre níveis de log (Error, Warning, Debug, Info)</li>
    <li>Desenvolvimento UI com Jetpack Compose</li>
    <li>Gerenciamento de estado em Compose</li>
    <li>animações e feedback visual</li>
    <li>Boas práticas de programação Android</li>
</ul>

<h2>🤝 Contribuição</h2>
<p>Contribuições são bem-vindas! Sinta-se à vontade para:</p>
<ol>
    <li>Fazer um Fork do projeto</li>
    <li>Criar uma branch para sua feature (<code>git checkout -b feature/AmazingFeature</code>)</li>
    <li>Commit suas mudanças (<code>git commit -m 'Add some AmazingFeature'</code>)</li>
    <li>Push para a branch (<code>git push origin feature/AmazingFeature</code>)</li>
    <li>Abrir um Pull Request</li>
</ol>

<h2>🙏 Agradecimentos</h2>
<ul>
    <li>Android Documentation</li>
    <li>Jetpack Compose Team</li>
    <li>Material Design Team</li>
</ul>

<div class="footer">
    <p>⭐️ Desenvolvido para fins educacionais - Demonstrando o uso do LogCat no Android!</p>
    <p>© 2024 LogCat Button - Todos os direitos reservados</p>
</div>

</body>
</html>
