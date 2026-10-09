# Calculadora IMC App

Construção de uma aplicação Android desenvolvida em Kotlin e Jetpack Compose que calcula o Índice de Massa Corporal (IMC) com base no peso e na altura do utilizador.
Exibe a classificação detalhada de acordo com as diretrizes da Organização Mundial da Saúde (OMS) e guarda o histórico de medições numa base de dados local (Room Database).


Projeto prático com o objetivo de aplicar **Jetpack Compose**, persistência de dados local com **Room Database**, navegação declarativa com passagem de parâmetros por rotas e boas práticas de arquitetura.

---

## Funcionalidades

- ✅ **Splash Screen** - Ecrã inicial de abertura com logótipo personalizado (`ImcLogo`), gradiente e transição automática para a aplicação.
- ✅ **Cálculo de IMC** - Ecrã principal (`InputScreen`) para inserção do peso (kg) e altura (m/cm), com suporte a formatação decimal flexível (pontos e vírgulas).
- ✅ **Classificação do IMC** - Classificação em tempo real segundo a tabela da OMS (*Abaixo do peso*, *Normal*, *Sobrepeso*, *Obesidade Grau I*, *Obesidade Grau II* e *Obesidade Grau III*).
- ✅ **Resultado Detalhado** - Ecrã de resultado (`ResultScreen`) com destaque visual para o valor numérico do IMC e a respetiva categoria de saúde.
- ✅ **Histórico Local (Room Database)** - Registo automático de cada cálculo efetuado na base de dados SQLite local, guardando peso, altura, IMC, classificação e a data/hora exata da medição.
- ✅ **Gestão do Histórico** - Ecrã (`HistoryScreen`) com listagem dinâmica (`LazyColumn`) dos registos anteriores e funcionalidade para eliminar registos do histórico.
- ✅ **Navegação Declarativa** - Fluxo fluido entre ecrãs utilizando Navigation Compose e passagem de argumentos formatados entre ecrãs.

---

## Arquitetura

O projeto foi estruturado seguindo os princípios de separação de conceitos e arquitetura Android moderna:

```
✅ UI LAYER (Presentation)
--> Screens (SplashScreen, InputScreen, ResultScreen, HistoryScreen)
--> Navigation (NavHost + NavController com rotas parametrizadas em ImcRoutes)
--> Components & Theme (ImcLogo, ImcHeader, ImcTextField, SimpleButton, HistoryRow, Colors, Typography)

✅ DOMAIN LAYER (Business Logic)
--> BmiCalculator (Object responsável pelos cálculos de IMC, formatação e classificação OMS)
--> BmiResult (Data class para representação do resultado)

✅ DATA LAYER (Persistence & Local Database)
--> Room Database (ImcDatabase)
--> DAO (BmiDao com consultas SQL, inserção e eliminação por ID)
--> Entities (BmiRecord - Mapeamento da tabela "bmi_calculations")
```

---

## 🛠️ Tecnologias Utilizadas

### UI & Design
- **Jetpack Compose**: Interface declarativa moderna desenvolvida 100% em Kotlin.
- **Material Design 3**: Componentes como `Button`, `TextButton`, `LazyColumn`, `Icons Extended`, cores e tipografia personalizadas.
- **Custom Components**: Componentes visuais estilizados e reutilizáveis (`ImcLogo`, `ImcHeader`, `ImcTextField`, `SimpleButton`, `HistoryRow`).

### **Arquitetura, Persistência & Ciclo de Vida**
- **Room Database**: Abstração de SQLite para persistência e consulta local segura do histórico de medições.
- **Coroutines & Kotlin Dispatchers**: Operações assíncronas em segundo plano (`Dispatchers.IO`) para acesso à base de dados sem bloquear a UI.
- **Navigation Compose**: Gestão declarativa das rotas e transição fluida entre os ecrãs da aplicação.
- **State Management**: Gestão reativa de estados de UI com `rememberSaveable`, `mutableStateOf` e `LaunchedEffect`.

---

## **Lógica de Cálculo**

O cálculo do IMC é realizado no objeto de domínio `BmiCalculator` aplicando a fórmula oficial:

**IMC = Peso em kg / (Altura em metros * Altura em metros)**

### Tabela de Classificação da OMS:
- **< 18.5**: ABAIXO DO PESO
- **18.5 - 24.9**: NORMAL
- **25.0 - 29.9**: SOBREPESO
- **30.0 - 34.9**: OBESIDADE GRAU I
- **35.0 - 39.9**: OBESIDADE GRAU II
- **≥ 40.0**: OBESIDADE GRAU III

---

## **Build**
- **Gradle**: 8.x / 9.x
- **Kotlin**: 2.2+
- **Android SDK**: 36 / 37 (Compile SDK 37)
- **Min SDK**: 24

### Configuração e Execução do Projeto
1. Efetuar o clone do repositório.
2. Abrir o projeto no Android Studio.
3. Executar a sincronização do Gradle.
4. Compilar e executar a app num dispositivo ou emulador (API 24+).

---

## Autor

**Rui Martins**
- 💻 GitHub: [https://github.com/Rui-Martins23](https://github.com/Rui-Martins23)
- 🔗 LinkedIn: [https://www.linkedin.com/in/rui-pedro-martins-913219169/](https://www.linkedin.com/in/rui-pedro-martins-913219169/)
