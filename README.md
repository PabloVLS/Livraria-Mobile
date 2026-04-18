# 📚 LivrariaMobile - Interface de Busca de Livros

## ✅ Projeto Implementado com Sucesso

Uma interface completa de aplicativo Android para busca de livros da API do Google Books, desenvolvida em **Kotlin com layouts em XML (sem Jetpack Compose)** com **Material Design 3**.

---

## 📋 O que foi criado:

### 1. **Layouts XML**

#### `activity_main.xml` - Tela Principal
- ✅ Campo de busca (TextInputLayout) com ícone de lupa
- ✅ Botão de busca (MaterialButton) ao lado do campo
- ✅ RecyclerView para listar os resultados
- ✅ **Estados da tela:**
  - **Loading**: ProgressBar centralizado
  - **Erro**: Container com mensagem de erro + botão "Tentar novamente"
  - **Vazio**: Mensagem "Nenhum livro encontrado"
  - **Sucesso**: Lista de livros

#### `item_book.xml` - Item da Lista
- ✅ ImageView para capa do livro (à esquerda, 80x120 dp)
- ✅ TextView para título (em destaque, máx 2 linhas)
- ✅ TextView para autor (máx 1 linha)
- ✅ TextView para descrição (máx 2 linhas)
- ✅ Layout em MaterialCardView com elevação e borda
- ✅ Organizado com ConstraintLayout para melhor responsividade

### 2. **Design & Cores**

#### `colors.xml` - Paleta Material Design
```
primary: #6200EE (Roxo)
primary_dark: #3700B3
secondary: #03DAC6 (Teal)
secondary_dark: #018786
background: #FFFFFF
surface: #F5F5F5
error: #B3261E
text_primary: #212121
text_secondary: #757575
divider: #BDBDBD
```

#### `themes.xml` - Tema Material 3
- ✅ Customizado com cores primárias e secundárias
- ✅ Material3 DayNight com suporte a tema escuro

### 3. **Componentes Kotlin**

#### `Book.kt` - Modelo de Dados
```kotlin
data class Book(
    val id: String,
    val title: String,
    val author: String,
    val description: String,
    val coverImageUrl: String?
)
```

#### `BookAdapter.kt` - Adapter do RecyclerView
- ✅ RecyclerView.Adapter com ViewBinding
- ✅ Bind de dados do modelo para as views
- ✅ Método `updateBooks()` para atualizar lista dinamicamente
- ✅ ViewHolder com binding automático

#### `MainActivity.kt` - Controladora Principal
- ✅ Setup do RecyclerView com LinearLayoutManager
- ✅ Listeners para busca (botão e teclado)
- ✅ Simulação de busca com delay de 1.5s (simula rede)
- ✅ Filtro por título e autor (case-insensitive)
- ✅ Gerenciamento de estados (loading, vazio, erro, sucesso)
- ✅ **6 livros mockados** para demonstração:
  - O Planeta dos Macacos
  - 1984
  - Dom Casmurro
  - O Cortiço
  - O Senhor dos Anéis
  - Cem Anos de Solidão

### 4. **Recursos Gráficos**

#### `ic_search_24.xml` - Ícone de Lupa
- ✅ Vector drawable com 24dp x 24dp
- ✅ Colorido com cor primária (#6200EE)

### 5. **Configurações**

#### `build.gradle.kts` - Dependências
- ✅ ViewBinding habilitado
- ✅ Material Components adicionado
- ✅ RecyclerView adicionado
- ✅ ConstraintLayout adicionado

#### `libs.versions.toml` - Versões
- ✅ RecyclerView 1.3.2 adicionado

#### `strings.xml` - Strings Localizadas
- ✅ Todos os textos em recursos string

---

## 🎨 Características de Design

✅ **Material Design 3** - Componentes modernos e padronizados  
✅ **ConstraintLayout** - Layouts responsivos e eficientes  
✅ **CardView** - Cards com elevação para melhor hierarquia visual  
✅ **Material Components** - TextInputLayout, MaterialButton  
✅ **Espaçamento consistente** - 8dp, 12dp, 16dp, 24dp, 32dp  
✅ **Tipografia legível** - TextSize variado (13sp até 20sp)  
✅ **Cores neutras e profissionais** - Roxo, Teal, Cinza, Branco  

---

## 🔧 Funcionalidades Implementadas

✅ **Busca funcional** - Filtra por título e autor  
✅ **Estados de loading** - Simula requisição de rede (1.5s)  
✅ **Estado vazio** - Mensagem quando nenhum resultado é encontrado  
✅ **Estado de erro** - Container com mensagem e botão retry  
✅ **Dados mockados** - 6 livros para demonstração  
✅ **Teclado integrado** - Busca ao pressionar Enter  
✅ **Animações suaves** - Transições entre estados  

---

## 📱 Como Usar

1. **Clonar/Abrir o projeto** no Android Studio
2. **Sincronizar Gradle** (será feito automaticamente)
3. **Executar no emulador ou dispositivo físico**
4. **Usar a barra de busca** para filtrar livros
5. **Ver os estados** (loading, vazio, etc.)

### Exemplos de Busca:
- "1984" - Encontra o livro de George Orwell
- "Machado" - Encontra Dom Casmurro
- "Ficção" - Não encontra nada (estado vazio)
- Digite qualquer coisa e pressione Enter ou toque o botão

---

## 🚀 Próximos Passos (Opcional)

Para implementar integração real com Google Books API:

1. **Adicionar Retrofit** para chamadas HTTP
2. **Adicionar Glide/Coil** para carregamento de imagens
3. **Implementar ViewModel** com LiveData
4. **Adicionar Coroutines** para requisições assíncronas
5. **Integrar com Google Books API**
6. **Cache local com Room Database**

---

## ✨ Build Status

```
BUILD SUCCESSFUL in 48s
95 actionable tasks: 72 executed, 23 up-to-date
```

Projeto compilado e pronto para uso! 🎉

