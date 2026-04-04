LogCat Button - App Educativo Android
https://imagem.png

📋 Sobre o Projeto
O LogCat Button é um aplicativo educativo desenvolvido em Kotlin com Jetpack Compose que demonstra o uso do sistema de logs do Android (LogCat). O app permite que os usuários insiram seus nomes e avaliem seu desempenho através de botões coloridos, cada um registrando mensagens em diferentes níveis de log.

🎯 Funcionalidades
✅ Campo de entrada para o nome do usuário

✅ 4 botões de avaliação (I, R, B, MB) com cores distintas

✅ Sistema de logs demonstrando diferentes níveis de severidade

✅ Feedback visual animado para cada ação

✅ Design moderno com animações e gradientes

✅ Interface responsiva e intuitiva

🎨 Cores dos Botões e Significados
Botão	Significado	Cor	Nível do Log
I	Insuficiente	🔴 Vermelho	Error (Log.e)
R	Regular	🟠 Laranja	Warning (Log.w)
B	Bom	🟢 Verde	Debug (Log.d)
MB	Muito Bom	🔵 Azul	Info (Log.i)
📝 Como Funciona o LogCat
O LogCat é uma ferramenta do Android Studio que exibe mensagens de log do sistema e dos aplicativos. Este projeto demonstra 4 níveis principais:

Níveis de Log Utilizados:
Log.e() - Error

Usado para situações de erro

Ex: Log.e("TesteAndroid", "App: João - Nota I")

Cor: Vermelha no LogCat

Log.w() - Warning

Usado para avisos

Ex: Log.w("TesteAndroid", "App: Maria - Nota R")

Cor: Laranja no LogCat

Log.d() - Debug

Usado para informações de depuração

Ex: Log.d("TesteAndroid", "App: Pedro - Nota B")

Cor: Azul no LogCat

Log.i() - Info

Usado para informações gerais

Ex: Log.i("TesteAndroid", "App: Ana - Nota MB")

Cor: Verde no LogCat

Como Visualizar os Logs:
Abra o LogCat no Android Studio (View → Tool Windows → Logcat)

Filtre pela tag TesteAndroid

Execute o app e clique nos botões

Observe as mensagens aparecendo em diferentes cores

🛠️ Tecnologias Utilizadas
Kotlin - Linguagem principal

Jetpack Compose - UI moderna e declarativa

Material Design 3 - Componentes e temas

Coroutines - Animações e feedback assíncrono

Android LogCat - Sistema de logs

📦 Estrutura do Projeto
text
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
🚀 Como Executar
Pré-requisitos:
Android Studio Hedgehog ou superior

SDK Android 21 (Lollipop) ou superior

Kotlin 1.9.0 ou superior

Passos:
Clone o repositório

bash
git clone https://github.com/seu-usuario/logcat-button.git
Abra no Android Studio

File → Open → Selecione a pasta do projeto

Sincronize as dependências

File → Sync Project with Gradle Files

Execute o app

Conecte um dispositivo Android ou inicie um emulador

Clique no botão "Run" (▶️)

💡 Exemplo de Uso
Digite seu nome no campo de texto

Clique em um dos botões de avaliação (I, R, B ou MB)

Observe:

Feedback visual na tela confirmando a ação

Mensagem no LogCat com o formato: App: [nome] - Nota [avaliação]

Cor diferente no LogCat dependendo do nível

Exemplo de Saída no LogCat:
text
2024-01-15 14:30:25.123 E/TesteAndroid: App: João - Nota I
2024-01-15 14:30:28.456 W/TesteAndroid: App: João - Nota R
2024-01-15 14:30:31.789 D/TesteAndroid: App: João - Nota B
2024-01-15 14:30:35.012 I/TesteAndroid: App: João - Nota MB
🎯 Objetivos Educacionais
Este projeto foi desenvolvido para demonstrar:

✅ Uso prático do sistema de logs do Android

✅ Diferenças entre níveis de log (Error, Warning, Debug, Info)

✅ Desenvolvimento UI com Jetpack Compose

✅ Gerenciamento de estado em Compose

✅ Animações e feedback visual

✅ Boas práticas de programação Android

🤝 Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para:

Fazer um Fork do projeto

Criar uma branch para sua feature (git checkout -b feature/AmazingFeature)

Commit suas mudanças (git commit -m 'Add some AmazingFeature')

Push para a branch (git push origin feature/AmazingFeature)

Abrir um Pull Request

📄 Licença
Este projeto está sob a licença MIT - veja o arquivo LICENSE para detalhes.

📧 Contato
Seu Nome - @seu_twitter - email@exemplo.com

Link do Projeto: https://github.com/seu-usuario/logcat-button

🙏 Agradecimentos
Android Documentation

Jetpack Compose Team

Material Design Team

⭐️ Desenvolvido para fins educacionais - Demonstrando o uso do LogCat no Android!
