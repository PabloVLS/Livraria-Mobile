# 🎯 Quick Start - LivrariaMobile

## ⚡ Início Rápido (2 minutos)

### 1. Abrir o Projeto
```bash
# No Android Studio:
File → Open → C:\Users\Pichau\AndroidStudioProjects\LivrariaMobile
```

### 2. Sincronizar Gradle
```bash
# Android Studio fará isso automaticamente
# Ou: Build → Clean Project → Rebuild Project
```

### 3. Executar no Emulador
```bash
# Run → Run 'app'
# Ou pressione Shift + F10
```

### 4. Testar a Interface
- Digite um livro na barra de busca (ex: "1984", "machado")
- Clique no botão 🔍 ou pressione Enter
- Observe os estados de loading e resultados

---

## 📁 Arquivos Criados/Modificados

### ✨ NOVOS ARQUIVOS

```
📁 src/main/java/com/example/livrariamobile/
  📄 Book.kt                    → Modelo de dados
  📄 BookAdapter.kt             → Adapter do RecyclerView

📁 src/main/res/
  📁 layout/
    📄 item_book.xml            → Item da lista
  📁 drawable/
    📄 ic_search_24.xml         → Ícone de lupa

📁 raiz/
  📄 README.md                  → Documentação principal
  📄 ARCHITECTURE.md            → Arquitetura detalhada
  📄 USAGE_GUIDE.md             → Guia de uso
```

### ♻️ MODIFICADOS

```
📁 src/main/java/com/example/livrariamobile/
  📄 MainActivity.kt            → Lógica completa de busca

📁 src/main/res/layout/
  📄 activity_main.xml          → Layout principal com 5 estados

📁 src/main/res/values/
  📄 strings.xml                → Strings localizadas
  📄 colors.xml                 → Paleta Material Design
  📄 themes.xml                 → Tema customizado

📁 raiz/
  📄 build.gradle.kts           → ViewBinding, RecyclerView
  📄 libs.versions.toml         → Versão RecyclerView
```

---

## 🎨 Recursos Principais

| Recurso | Descrição |
|---------|-----------|
| 📱 **Material Design 3** | Design moderno e consistente |
| 📋 **ConstraintLayout** | Layouts responsivos |
| 🎫 **MaterialCardView** | Cards com elevação |
| 🔄 **RecyclerView** | Lista eficiente |
| 🔍 **TextInputLayout** | Campo de busca Material |
| 🔘 **MaterialButton** | Botões Material |
| 🎭 **Estados** | 4 estados de tela distintos |
| 📚 **Dados Mockados** | 6 livros para demonstração |

---

## 🚀 Funcionalidades

✅ Busca por título  
✅ Busca por autor  
✅ Case-insensitive  
✅ Loading visual (1.5s)  
✅ Estado vazio  
✅ Estado erro  
✅ Botão retry  
✅ Atalho teclado (Enter)  

---

## 🎯 Estrutura do Código

```
MainActivity (main)
    ↓
setupRecyclerView()
setupSearchListeners()
showBooksList()
    ↓
BookAdapter
    ↓
BookViewHolder (item_book.xml)
    ↓
Book (data class)
```

---

## 📊 Build Status

```
✅ BUILD SUCCESSFUL
   95 actionable tasks
   72 executed
   23 up-to-date
```

---

## 🔧 Dependências

```gradle
androidx.core:core-ktx:1.18.0
androidx.appcompat:appcompat:1.7.1
com.google.android.material:material:1.13.0
androidx.activity:activity:1.13.0
androidx.constraintlayout:constraintlayout:2.2.1
androidx.recyclerview:recyclerview:1.3.2
```

---

## 📱 Compatibilidade

- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 36 (Android 15)
- **Suporte**: Landscape e Portrait
- **Temas**: Light e Dark

---

## 🎓 6 Livros Mockados

1. **O Planeta dos Macacos** - Pierre Boulle
2. **1984** - George Orwell
3. **Dom Casmurro** - Machado de Assis
4. **O Cortiço** - Aluísio Azevedo
5. **O Senhor dos Anéis** - J.R.R. Tolkien
6. **Cem Anos de Solidão** - Gabriel García Márquez

---

## 🧪 Testes de Busca Recomendados

```
✅ Buscar "1984"           → 1 resultado
✅ Buscar "machado"        → 1 resultado
✅ Buscar "ficção"         → 3 resultados
✅ Buscar "pokemon"        → 0 resultados (vazio)
✅ Buscar ""               → 0 resultados (vazio)
✅ Pressionar Enter        → Busca ativada
✅ Clicar botão 🔍         → Busca ativada
```

---

## 💡 Próximos Passos (Opcional)

Para evoluir o projeto:

1. Adicionar **Retrofit** para Google Books API
2. Adicionar **Glide** para carregar capas
3. Implementar **ViewModel + LiveData**
4. Adicionar **Coroutines** para async
5. Implementar **Room Database** para cache
6. Adicionar **Paging** para infinite scroll
7. Implementar **Search suggestions**

---

## 📚 Documentação Adicional

- 📖 **README.md** - Visão geral completa
- 🏗️ **ARCHITECTURE.md** - Arquitetura detalhada
- 📖 **USAGE_GUIDE.md** - Guia de uso passo a passo

---

## ✨ Destaques

🎨 **UI Limpa e Moderna**
- Material Design 3
- Cores neutras e profissionais
- Espaçamento consistente

⚡ **Performance**
- RecyclerView otimizado
- ViewHolder reutilizado
- Filtro O(n)

🔧 **Código Limpo**
- Data class para modelo
- Adapter reutilizável
- ViewBinding type-safe
- Métodos bem nomeados

---

## 🎬 Como Rodar

```bash
# 1. Abrir projeto no Android Studio
# 2. Clicar em "Run" ou Shift+F10
# 3. Selecionar emulador ou dispositivo
# 4. Aguardar build (≈ 1-2 minutos)
# 5. App abrirá automaticamente
# 6. Usar a barra de busca!
```

---

## 📞 Suporte

Se tiver dúvidas:
1. Verifique os arquivos de documentação
2. Consulte os comentários no código
3. Valide as dependências no build.gradle.kts
4. Verifique o Logcat para erros

---

**Projeto pronto para uso! 🚀**

Desenvolvido com ❤️ usando Kotlin + XML + Material Design 3

