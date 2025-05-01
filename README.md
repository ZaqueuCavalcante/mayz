# MAYZ

Autômatos Celulares + Árvores na prática!

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








Encontrei esse problema em um desafio da Stone anos atrás, que coordenado pelo pessoal da Sigma Geek.
