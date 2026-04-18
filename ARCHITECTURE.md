# 🏗️ Arquitetura do Projeto

## Estrutura de Arquivos

```
LivrariaMobile/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/livrariamobile/
│   │   │   ├── MainActivity.kt          # Controladora principal
│   │   │   ├── Book.kt                  # Modelo de dados
│   │   │   └── BookAdapter.kt           # Adapter do RecyclerView
│   │   │
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml    # Tela principal
│   │   │   │   └── item_book.xml        # Item da lista
│   │   │   │
│   │   │   ├── drawable/
│   │   │   │   └── ic_search_24.xml     # Ícone de lupa
│   │   │   │
│   │   │   ├── values/
│   │   │   │   ├── strings.xml          # Strings localizadas
│   │   │   │   ├── colors.xml           # Paleta de cores
│   │   │   │   └── themes.xml           # Tema Material 3
│   │   │   │
│   │   │   ├── values-night/
│   │   │   │   └── themes.xml           # Tema escuro
│   │   │   │
│   │   │   └── mipmap-*/
│   │   │       └── ic_launcher.*        # Ícones do app
│   │   │
│   │   └── AndroidManifest.xml
│   │
│   ├── build.gradle.kts                 # Config do módulo (ViewBinding, deps)
│   └── proguard-rules.pro
│
├── gradle/
│   ├── libs.versions.toml               # Versões centralizadas
│   └── wrapper/
│
├── build.gradle.kts                     # Config raiz
├── settings.gradle.kts
├── gradlew & gradlew.bat
└── README.md (Este arquivo)
```

---

## 🔄 Fluxo de Dados

```
MainActivity
    ↓
setupRecyclerView()
    ↓
BookAdapter ← mockBooks (List<Book>)
    ↓
RecyclerView.Adapter<BookViewHolder>
    ↓
item_book.xml (CardView com TextViews e ImageView)
```

---

## 📊 Estados da Tela

```
┌─────────────────────────────────────────┐
│          MainActivity                   │
├─────────────────────────────────────────┤
│                                         │
│  ┌─────────────────────────────────┐   │
│  │  Search Bar (TextInputLayout)   │   │
│  └─────────────────────────────────┘   │
│                                         │
│  ┌─────────────────────────────────┐   │
│  │     ESTADO 1: SUCESSO           │   │
│  │  ┌──────────────────────────┐   │   │
│  │  │ RecyclerView             │   │   │
│  │  │ - Item 1 (CardView)      │   │   │
│  │  │ - Item 2 (CardView)      │   │   │
│  │  │ - Item 3 (CardView)      │   │   │
│  │  └──────────────────────────┘   │   │
│  └─────────────────────────────────┘   │
│                                         │
│  ┌─────────────────────────────────┐   │
│  │    ESTADO 2: LOADING            │   │
│  │         ProgressBar             │   │
│  └─────────────────────────────────┘   │
│                                         │
│  ┌─────────────────────────────────┐   │
│  │    ESTADO 3: VAZIO              │   │
│  │  "Nenhum livro encontrado"      │   │
│  └─────────────────────────────────┘   │
│                                         │
│  ┌─────────────────────────────────┐   │
│  │    ESTADO 4: ERRO               │   │
│  │  "Erro ao buscar livros"        │   │
│  │  [Tentar novamente]             │   │
│  └─────────────────────────────────┘   │
│                                         │
└─────────────────────────────────────────┘
```

---

## 🎯 Componentes Key

### MainActivity
- **Responsabilidades:**
  - Gerenciar o RecyclerView
  - Processar eventos de busca
  - Controlar estados de tela
  - Fornecer dados mockados

- **Métodos principais:**
  - `setupRecyclerView()` - Inicializa o adapter
  - `setupSearchListeners()` - Listeners de busca
  - `performSearch()` - Executa a busca
  - `searchBooks(query)` - Filtra dados
  - `showBooksList()` - Exibe sucesso
  - `showLoadingState()` - Exibe loading
  - `showEmptyState()` - Exibe vazio
  - `showErrorState()` - Exibe erro

### BookAdapter
- **Responsabilidades:**
  - Mapear List<Book> para views
  - Criar e reusar ViewHolders
  - Notificar mudanças na lista

- **Métodos principais:**
  - `onCreateViewHolder()` - Cria view
  - `onBindViewHolder()` - Popula view
  - `updateBooks()` - Atualiza dados

### Layouts
- **activity_main.xml**
  - 5 containers (AppBar, RecyclerView, Loading, Empty, Error)
  - ConstraintLayout para responsividade

- **item_book.xml**
  - MaterialCardView como container
  - ImageView + 3 TextViews organizados
  - ConstraintLayout interno

---

## 🎨 Design System

### Cores
| Nome | Hex | Uso |
|------|-----|-----|
| Primary | #6200EE | Botões, ícones, highlights |
| Primary Dark | #3700B3 | Variante escura |
| Secondary | #03DAC6 | Accents |
| Background | #FFFFFF | Fundo |
| Surface | #F5F5F5 | Campos de entrada |
| Error | #B3261E | Mensagens de erro |
| Text Primary | #212121 | Títulos, main text |
| Text Secondary | #757575 | Subtítulos, descriptions |

### Espaçamento
- 8dp - Padding mínimo
- 12dp - Espaço entre elementos
- 16dp - Espaço padrão
- 24dp - Espaço grande
- 32dp - Espaço máximo

### Tipografia
- 20sp - Títulos (erro)
- 18sp - Subtítulos (estado vazio)
- 16sp - Conteúdo principal
- 14sp - Autor dos livros
- 13sp - Descrição dos livros

---

## 📚 Dados Mockados

```kotlin
Book(id, title, author, description, coverImageUrl)

1. "O Planeta dos Macacos" by Pierre Boulle
2. "1984" by George Orwell
3. "Dom Casmurro" by Machado de Assis
4. "O Cortiço" by Aluísio Azevedo
5. "O Senhor dos Anéis" by J.R.R. Tolkien
6. "Cem Anos de Solidão" by Gabriel García Márquez
```

---

## 🔗 Dependências

```toml
androidx.core:core-ktx = 1.18.0
androidx.appcompat:appcompat = 1.7.1
com.google.android.material:material = 1.13.0
androidx.activity:activity = 1.13.0
androidx.constraintlayout:constraintlayout = 2.2.1
androidx.recyclerview:recyclerview = 1.3.2
```

---

## 🚀 Ciclo de Vida

1. **onCreate()**
   - Infla activity_main.xml com ViewBinding
   - Chama setupRecyclerView()
   - Chama setupSearchListeners()
   - Chama showBooksList() (mostra dados iniciais)

2. **performSearch()**
   - Lê texto do EditText
   - Valida se não vazio
   - Mostra LoadingState
   - Aguarda 1.5s (simula rede)
   - Chama searchBooks(query)
   - Mostra resultado ou EmptyState

3. **searchBooks(query)**
   - Filtra mockBooks por título ou autor
   - Retorna lista filtrada

4. **showBooksList(books)**
   - Chama adapter.updateBooks(books)
   - Adapter chama notifyDataSetChanged()
   - RecyclerView re-renderiza items

---

## ✅ Checklist de Implementação

- [x] Layouts em XML (sem Compose)
- [x] Material Design 3
- [x] ConstraintLayout
- [x] RecyclerView com Adapter
- [x] EditText com TextInputLayout
- [x] MaterialButton
- [x] MaterialCardView
- [x] Estados (loading, erro, vazio, sucesso)
- [x] Barra de busca funcional
- [x] Dados mockados
- [x] ViewBinding
- [x] Cores customizadas
- [x] Ícone SVG (lupa)
- [x] Strings localizadas
- [x] Build bem-sucedido

---

## 🎓 Padrões Utilizados

- **MVC (Model-View-Controller)** - MainActivity é o controller
- **Adapter Pattern** - BookAdapter adapta dados para RecyclerView
- **ViewHolder Pattern** - Reuso eficiente de views no RecyclerView
- **ViewBinding** - Type-safe access to views
- **Data Classes** - Book.kt é uma data class Kotlin


