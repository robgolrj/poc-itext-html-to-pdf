## Gerador de PDF a partir de HTML

Este é um programa Java simples para gerar múltiplos arquivos PDF a partir de HTML usando a biblioteca iText.

### Requisitos

- Java Development Kit (JDK) instalado
- Biblioteca iText adicionada ao projeto (pode ser feita manualmente ou via gerenciador de dependências)

### Como usar

1. Clone este repositório ou baixe os arquivos diretamente.
2. Abra o projeto em sua IDE Java preferida.
3. Certifique-se de ter configurado o JDK e a biblioteca iText corretamente no projeto.
4. Execute o arquivo `GeradorPdf.java` para gerar os arquivos PDF.

### Personalização

- Você pode personalizar o conteúdo HTML dentro do loop `for` no método `main` para ajustar o conteúdo de cada PDF gerado.
- O número total de PDFs gerados é definido pelo valor do contador no loop `for`.

### Observações

- Os arquivos PDFs gerados serão salvos no diretório `target/results/` dentro do diretório de trabalho.
- Certifique-se de ter permissão de escrita no diretório de destino para que os arquivos PDF sejam gerados corretamente.
