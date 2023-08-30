# TODOS

- Adicionar efeito das bolinhas se movendo de A -> B
- Adicionar efeito das cells irem se apagando / acendendo ao mesmo tempo

- Entender como o ganhador implementou a solucao dele

- Types
    - Normal
    - Many lifes
    - Change the value of any cell in the board
    - Board lost piece [x]
    - Balance particles

- Pipeline:
    - Load current board
    - Calculate all cells neighbors
    - Load next board (using rules and neighbors)
    - * Use particle change cell value power
    - PARTICLE(s) needs to choose U-R-D-L
        - NORMAL -> Simple node expansion
        - MANY LIFES -> Use life or not?
    - Check particle current cell (EMPTY OR OBSTACLE)
        - * Check if have lifes
        - * Check for particle collision (GAME OVER)
        - Game over or not
