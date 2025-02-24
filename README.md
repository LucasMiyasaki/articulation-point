# Algoritmo de Pontos de Articulação em Java

Este projeto implementa o algoritmo de identificação de pontos de articulação em grafos utilizando a linguagem Java. Os pontos de articulação são vértices cuja remoção desconecta partes significativas de uma rede, sendo essenciais para a análise de falhas em sistemas conectados, como redes de comunicação.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

- **Main.java**: Classe principal que inicializa a aplicação, lê o grafo de um arquivo de texto e executa o algoritmo.
- **Matriz.java**: Responsável pela leitura do arquivo de texto, armazenamento e exibição da matriz de adjacência do grafo.
- **No.java**: Representa um vértice do grafo, contendo informações sobre suas ligações e valores utilizados pelo algoritmo.
- **Arvore.java**: Implementa a lógica do algoritmo, incluindo busca em profundidade, definição de valores para cada nó, ajustes de valores e identificação dos pontos de articulação.

## Como Executar

1. Crie um arquivo chamado `grafo.txt` contendo a matriz de adjacência do grafo.
2. Compile todas as classes Java.
3. Execute a classe `Main.java`.

## Exemplo de Entrada (grafo.txt)
```
ABCDEFGH
01100000
10011000
10010000
01101100
01010000
00010011
00000101
00000110
```

## Saída Esperada
```
Roteadores que precisam de no-break: D F
```
