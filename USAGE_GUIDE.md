# 📖 Guia de Uso - LivrariaMobile

## 🎯 Funcionalidades Principais

### 1️⃣ Barra de Busca

```
┌──────────────────────────────────────────────┐
│  🔍 Buscar livros...              [🔍 Buscar] │
└──────────────────────────────────────────────┘
```

- **Campo de texto**: Digite o nome de um livro ou autor
- **Ícone de lupa**: Indicador de função de busca
- **Botão de busca**: Clique para buscar (ou pressione Enter)

---

### 2️⃣ Resultados da Busca

Quando há resultados, a tela exibe cards com:

```
┌────────────────────────────────────────────┐
│  ┌────┐                                    │
│  │    │  Dom Casmurro                      │
│  │ 📖 │  Machado de Assis                  │
│  │    │                                    │
│  │    │  Um romance brasileiro que         │
│  │    │  explora ciúmes, traição e...     │
│  └────┘                                    │
└────────────────────────────────────────────┘
```

Cada card contém:
- **Capa do livro**: Placeholder com fundo cinza
- **Título**: Em negrito, máx 2 linhas
- **Autor**: Em cinza secundário
- **Descrição**: Em cinza, máx 2 linhas truncadas

---

### 3️⃣ Estados da Tela

#### 🔄 Estado de Carregamento (Loading)

```
┌──────────────────────────────────────────┐
│                                          │
│                 ⟳ Carregando...         │
│                                          │
│             (Aguardando 1.5s)            │
│                                          │
└──────────────────────────────────────────┘
```

- ProgressBar circular no centro
- Simula requisição de rede (1.5 segundos)

#### ✅ Estado de Sucesso

```
┌──────────────────────────────────────────┐
│  Livro 1 (Card)                          │
│  Livro 2 (Card)                          │
│  Livro 3 (Card)                          │
│  Livro 4 (Card)                          │
│  [... mais itens, scroll disponível]     │
└──────────────────────────────────────────┘
```

- RecyclerView com cards deslizáveis
- Todos os livros encontrados

#### 📭 Estado Vazio

```
┌──────────────────────────────────────────┐
│                                          │
│      Nenhum livro encontrado            │
│                                          │
└──────────────────────────────────────────┘
```

- Mensagem centralizada
- Nenhum resultado para a busca

#### ⚠️ Estado de Erro

```
┌──────────────────────────────────────────┐
│   Erro ao buscar livros                  │
│                                          │
│  Não foi possível carregar os livros.    │
│  Tente novamente.                        │
│                                          │
│       [Tentar novamente]                 │
└──────────────────────────────────────────┘
```

- Título em vermelho
- Mensagem descritiva
- Botão para retry

---

## 🔍 Exemplos de Busca

### Buscas Bem-Sucedidas

| Termo | Resultado |
|-------|-----------|
| "1984" | ✅ Encontra: 1984 by George Orwell |
| "machado" | ✅ Encontra: Dom Casmurro by Machado de Assis |
| "senhor" | ✅ Encontra: O Senhor dos Anéis |
| "ficção" | ✅ Encontra: O Planeta dos Macacos, 1984, O Senhor dos Anéis |
| "gabriel" | ✅ Encontra: Cem Anos de Solidão by Gabriel García Márquez |

### Buscas Sem Resultados

| Termo | Resultado |
|-------|-----------|
| "pokemon" | ❌ Estado Vazio: "Nenhum livro encontrado" |
| "Harry" | ❌ Estado Vazio |
| "xyz123" | ❌ Estado Vazio |

### Características de Busca

- ✅ **Case-insensitive**: "machado" = "MACHADO" = "Machado"
- ✅ **Busca parcial**: "1984" encontra livros com "1984" no título
- ✅ **Busca por autor**: Digite o nome do autor
- ✅ **Espaços ignorados**: Busca é feita com `.trim()`

---

## 📋 Lista Completa de Livros Mockados

```
1. O Planeta dos Macacos
   Autor: Pierre Boulle
   Descrição: Um clássico de ficção científica que explora 
              temas sobre evolução e sociedade.

2. 1984
   Autor: George Orwell
   Descrição: Uma distopia futurista que retrata um totalitarismo 
              extremo e a luta pela liberdade.

3. Dom Casmurro
   Autor: Machado de Assis
   Descrição: Um romance brasileiro que explora ciúmes, traição 
              e memória através de uma narrativa envolvente.

4. O Cortiço
   Autor: Aluísio Azevedo
   Descrição: Uma obra que retrata a vida em um cortiço do Rio de 
              Janeiro com realismo intenso.

5. O Senhor dos Anéis
   Autor: J.R.R. Tolkien
   Descrição: Uma epopeia de fantasia que acompanha uma jornada 
              pela Terra Média em busca de destruir um anel.

6. Cem Anos de Solidão
   Autor: Gabriel García Márquez
   Descrição: Uma saga familiar que mistura realismo mágico com 
              histórias de amor e morte.
```

---

## ⌨️ Atalhos de Teclado

| Ação | Como Fazer |
|------|-----------|
| Buscar | Pressionar **Enter** no campo de texto |
| Buscar | Clicar no botão **[🔍 Buscar]** |
| Limpar campo | Selecionar tudo e deletar |
| Retry | Clicar em **[Tentar novamente]** (em caso de erro) |
| Scroll | Deslizar para cima/baixo na lista de resultados |

---

## 🎨 Tema Visual

### Cores Utilizadas

```
Roxo Primário (#6200EE)
  ↓ Usada em: Botões, ícones, highlights
  
Roxo Escuro (#3700B3)
  ↓ Usada em: Variantes de hover
  
Teal Secundário (#03DAC6)
  ↓ Usada em: Accents
  
Fundo Branco (#FFFFFF)
  ↓ Usada em: Cards, barra de busca
  
Superfície Cinza (#F5F5F5)
  ↓ Usada em: Campos de entrada, background de cover
  
Texto Preto (#212121)
  ↓ Usada em: Títulos principais
  
Texto Cinza (#757575)
  ↓ Usada em: Autores, descrições
```

---

## 🏗️ Layout Responsivo

O layout usa **ConstraintLayout** e **CardView** para ser responsivo:

- ✅ Se a tela é pequena: Cards ocupam 100% da largura
- ✅ Se a tela é grande: Cards ainda ocupam 100% (fill)
- ✅ Padding adaptável em diferentes densidades
- ✅ Texto truncado automaticamente quando necessário

### Tamanhos de Fonte

```
Erro/Vazio    → 18sp / 20sp (destaque)
Título livro  → 16sp (bold)
Autor         → 14sp (secondary color)
Descrição     → 13sp (secondary color)
```

---

## 🐛 Troubleshooting

### "Nenhum livro encontrado" para buscas válidas?
- Verifique se digitou corretamente
- A busca é por **contém** (substring), não por correspondência exata
- Tente buscar apenas por "1984" em vez de "livro 1984"

### Campo de busca não responde?
- Verifique se o app está totalmente carregado
- Tente fechar e abrir novamente

### Cards não aparecem depois da busca?
- Aguarde os 1.5s de carregamento
- Se nada aparecer, pode estar no estado vazio
- Tente outra busca com termos diferentes

---

## 📱 Compatibilidade

- **Min SDK**: 24 (Android 7.0 Nougat)
- **Target SDK**: 36 (Android 15)
- **Orientações**: Suporta retrato e paisagem
- **Temas**: Modo claro e escuro (Material3 DayNight)

---

## 🎓 Dicas de Uso

1. **Teste todos os estados**
   - Busque algo que existe
   - Busque algo que não existe
   - Observe o Loading

2. **Explore a UI**
   - Clique no ícone de lupa
   - Pressione Enter no campo
   - Clique no botão de busca
   - Deslize a lista

3. **Para Desenvolvedor**
   - Abra o Logcat para ver logs
   - Use o Android Studio Debugger
   - Teste com diferentes tamanhos de tela

---

## 🚀 Performance

- **Renderização**: Otimizada com RecyclerView
- **Memória**: ViewHolder reutiliza views
- **Simulação de rede**: 1.5s de delay artificial
- **Filtro**: O(n) linear search, suficiente para 6 itens

---

## 📸 Screenshots Esperados

### Tela Inicial
```
[Barra de Busca]
[Card 1: O Planeta dos Macacos]
[Card 2: 1984]
[Card 3: Dom Casmurro]
[Card 4: O Cortiço]
[Card 5: O Senhor dos Anéis]
[Card 6: Cem Anos de Solidão]
```

### Durante Busca
```
[Barra de Busca com "machado" digitado]
⟳ Carregando...
```

### Resultado de Busca "machado"
```
[Barra de Busca com "machado" digitado]
[Card 1: Dom Casmurro - Machado de Assis]
```

### Resultado Vazio
```
[Barra de Busca com "pokemon" digitado]
"Nenhum livro encontrado"
```


