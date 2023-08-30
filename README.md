<h1 align="center"> Flood Fill </h1>

<p>Flood Fill é um algoritmo que tem como objetivo alterar a
informação de nós (nodes) que estão conectados. Esse algoritmo é utilizado na ferramenta “balde”
de softwares de desenho (como paint) e pode ser utilizado também em jogos como Go e Campo
Minado para determinar quais posições serão limpas.</p>

<p>Imagine que cada quadrado na imagem é um pixel de uma imagem qualquer. No exemplo a
imagem possui um fundo inteiro branco, e uma linha preta na diagonal. Essa imagem pode ser
representada por uma matriz de pixels no nosso código.</p>

![image](https://github.com/elvisclaudino/flood-fill-java/assets/102040112/f89def05-4715-4fe5-ae45-4cdb9fe857a7)

<p>Informamos ao programa uma coordenada inicial para obter um ponto de partida e guardamos a
cor de fundo em uma variável. Esse ponto é armazenado numa Pilha/Fila e então começa o nosso
loop de repetição. O ponto inicial é desempilhado/desenfileirado e preenchido com a nova cor.
Em seguida, empilhamos/enfileiramos os 4 vizinhos laterais deste ponto.
</p>

![image](https://github.com/elvisclaudino/flood-fill-java/assets/102040112/5326710c-7bc1-4dcb-a730-d9f34b6b1d78)

<p>Começamos o loop novamente, e então pintamos o pixel que foi desempilhado/desenfileirado. É
importante que sempre ocorra uma verificação para checar se o pixel não está ultrapassando o
limite da matriz (Index Out Of Bounds) e se a cor é igual a cor de fundo que foi armazenada no
início do programa em uma variável (no caso desse exemplo, branco). Só iremos pintar o pixel
caso essa condição seja atendida. Esse processo continua se repetindo enquanto a condição for
atendida.
</p>

![image](https://github.com/elvisclaudino/flood-fill-java/assets/102040112/0e6bfc05-7c31-4d84-85b2-dd33a42199f5)

<p>Pixels de cores diferentes do que a cor de fundo armazenada inicialmente são
empilhados/enfileirados, mas nunca são pintados, pois não atendem as condições da checagem
que é realizada dentro do loop (descrita anteriormente). O mesmo acontece com pixels
inexistentes na imagem (fora da matriz).</p>

![image](https://github.com/elvisclaudino/flood-fill-java/assets/102040112/f8c7731d-7d2e-4182-bbcb-40362c2e26c4)

<p>Por não atenderem as condições de checagem, seus vizinhos também nunca são
empilhados/enfileirados.
</p>

![image](https://github.com/elvisclaudino/flood-fill-java/assets/102040112/62160217-a5f7-45ca-8854-54ea168e1901)

<p>O algoritmo encerra quando todos os pixels tiverem sido preenchidos.</p>

![image](https://github.com/elvisclaudino/flood-fill-java/assets/102040112/04cccef3-8152-4e0a-9de0-b84f9131f089)





