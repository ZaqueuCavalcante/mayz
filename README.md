# MAYZ

## ꡌ‍ Pathfinding com labirinto dinâmico: Autômatos Celulares + Árvores na prática! 🌳

No labirinto a seguir, é trivial sair do canto superior esquerdo e chegar no canto inferior direito:

<p align="center">
  <img src="docs/01_Trivial.gif" style="display: block; margin: 0 auto" />
</p>

Mas como você faria isso se o labirinto mudasse (deterministicamente) a cada movimento?

<p align="center">
  <img src="docs/02_Dynamic.gif" style="display: block; margin: 0 auto" />
</p>

E em labirintos maiores?

<p align="center">
  <img src="docs/03_PacMan.gif" style="display: block; margin: 0 auto" />
</p>


---------------------------------------------------------------------------------------------------

E o que isso tem haver com Autômatos Celulares e Árvores?

Esse labirinto dinâmico é um Autômato Celular e o algoritmo que o resolve utiliza como base uma Árvore para otimizar a busca pelo menor caminho!

Se você reparar bem, todos os labirintos seguem as seguintes regras de mudança a cada movimento:

- As células cinza com 2 ou 3 vizinhos viram azúis na próxima geração.
- As células azúis com 4 ou 5 ou 6 vizinhos permanecem azúis. Do contrário, viram cinza.

Além disso, a própria busca pelo caminho é naturalmente modelada como uma árvore, onde cada movimento aumenta uma unidade na profundidade da mesma.

Se quiser ver como implementei tudo isso, acesse o projeto no GitHub: https://github.com/ZaqueuCavalcante/mayz

Ele possui testes automatizados e vários modos de jogo:

- Fun: você pode jogar manualmente (opções para ajuda de quantidade de vizinhos + hints de próximo estado)



- Debug: você pode ver o algoritmo rodando passo a passo (controlando a execução via teclado)



- Replay: pegar uma string que representa uma partida e fazer o algoritmo ir executando ela passo a passo



- Release: para labirintos gigantes onde queremos apenas a solução final, sem ficar renderizando na tela cada movimento

TABELA COM TESTES EM LABIRINTOS ALEATORIOS

| Size                  | Moves | Time |
|-----------------------|-------|------|
| 100 x 100             |       |      |
| 1.000 x 1.000         |       |      |
| 10.000 x 10.000       |       |      |
| 100.000 x 100.000     |       |      |
| 1.000.000 x 1.000.000 |       |      |









Um **autômato celular** é um modelo matemático e computacional que descreve como padrões complexos emergem a partir de regras simples, aplicadas em uma rede de células discretas. Cada célula assume um estado (ativa / inativa) e evolui a cada geração de acordo com as regras, que dependem apenas do seu próprio estado e dos estados das células vizinhas.

Meio abstrato né, vamos pegar um exemplo para entender melhor.

Considere o tabuleiro a seguir, onde as células azúis estão **ativas**, já as de cor cinza estão **inativas**:

<p align="center">
  <img src="https://github.com/ZaqueuCavalcante/mayz/blob/master/docs/00_example_maze.png?raw=true" style="display: block; margin: 0 auto" />
</p>

A **quantidade de vizinhos** de uma célula é definida como a quantidade de células azúis adjacentes à ela. Veja a seguir a quantidade de vizinhos de cada célula do tabuleiro no estado inicial (perceba que uma célula pode ter até no máximo 8 vizinhos):

<p align="center">
  <img src="https://github.com/ZaqueuCavalcante/mayz/blob/master/docs/01_example_maze_neighbors_count.png?raw=true" style="display: block; margin: 0 auto" />
</p>

Vamos **alterar o estado** das células ao longo do tempo, utilizando as seguintes **regras**:

- As células cinza com 2 ou 3 vizinhos viram azúis na próxima geração.
- As células azúis com 4 ou 5 ou 6 vizinhos permanecem azúis. Do contrário, viram cinza.

Aplicando essas regras à cada célula do tabuleiro, chegamos no seguinte estado:

<p align="center">
  <img src="https://github.com/ZaqueuCavalcante/mayz/blob/master/docs/02_example_maze_gen_01.png?raw=true" style="display: block; margin: 0 auto" />
</p>

E se continuarmos aplicando as regras a cada nova geração, vamos ver que os padrões complexos citados lá no início começam a emergir no tabuleiro:

<p align="center">
  <img src="https://github.com/ZaqueuCavalcante/mayz/blob/master/docs/03_example_maze_generations.gif?raw=true" style="display: block; margin: 0 auto" />
</p>

Esse tabuleiro dinâmico se parece muito com um labirinto...

- Será que é possível se mover do canto superior esquerdo até o canto infeiror direito do tabuleiro sem nunca ocupar uma célula ativa?
- Se sim, será que é possível fazer isso de maneira ótima, ou seja, com a menor quantidade possível de movimentos?

É o que veremos a seguir!

---------------------------------------------------------------------------------------------------

Vamos adicionar ínicio e fim do labirinto, além do player que vai tentar atravessá-lo.



Como o player sabe as regras, ele também sabe qual vai ser o estado de cada célula na próxima geração. Adicionei bolinhas indicando quais opções de movimento o player possui antes de cada movimento.


Agora temos que achar um jeito de calcular qual o melhor caminho até o final. Podemos modelar o problema utilizando uma **árvore**, onde cada 

https://github.com/ZaqueuCavalcante/maze-challenge

## Criei testes automatizados para me guiar na implementação dos algoritmos

## Encontrei esse problema em um desafio da Stone anos atrás, que coordenado pelo pessoal da Sigma Geek.
