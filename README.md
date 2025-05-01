# MAYZ

Um **autômato celular** é um modelo matemático e computacional que descreve como padrões complexos emergem a partir de regras simples, aplicadas em uma rede de células discretas. Cada célula assume um estado (ativa / inativa) e evolui a cada geração de acordo com as regras, que dependem apenas do seu próprio estado e dos estados das células vizinhas.

Meio abstrato né, vamos pegar um exemplo para entender melhor.

Considere o tabuleiro a seguir, que possui 7 linhas e 8 colunas. Nele, as células azúis estão ativas, já as de cor cinza estão inativas.

<p align="center">
  <img src="https://github.com/ZaqueuCavalcante/mayz/blob/master/docs/00_example_maze.png?raw=true" style="display: block; margin: 0 auto" />
</p>

Veja a quantidade de vizinhos azúis de cada célula a seguir (um célula pode ter até no máximo 8 vizinhos azúis):

<p align="center">
  <img src="https://github.com/ZaqueuCavalcante/mayz/blob/master/docs/01_example_maze_neighbors_count.png?raw=true" style="display: block; margin: 0 auto" />
</p>

Vamos alterar o estado das células ao longo do tempo, utilizando as seguintes regras:

- As células cinza com 2 ou 3 vizinhos azúis viram azúis na próxima geração.
- As células azúis com 4 ou 5 ou 6 vizinhos azúis permanecem azúis. Do contrário, viram cinza.

Aplicando essas regras à cada célula do tabuleiro, chegamos no seguinte estado:

<p align="center">
  <img src="https://github.com/ZaqueuCavalcante/mayz/blob/master/docs/02_example_maze_gen_01.png?raw=true" style="display: block; margin: 0 auto" />
</p>

E se continuarmos aplicando as regras a cada nova geração, vamos ver que os padrões complexos citados lá no início começam a emergir no tabuleiro:

<p align="center">
  <img src="https://github.com/ZaqueuCavalcante/mayz/blob/master/docs/03_example_maze_generations.gif?raw=true" style="display: block; margin: 0 auto" />
</p>





https://github.com/ZaqueuCavalcante/mayz/assets/52336768/a27d2307-8eee-46dc-a50e-5f5ea692e05f

https://github.com/ZaqueuCavalcante/maze-challenge



Encontrei esse problema em um desafio da Stone anos atrás, que coordenado pelo pessoal da Sigma Geek.
