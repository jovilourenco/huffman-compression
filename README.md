# Compressão de Huffman

Código de compressão usando algoritmo de Huffman. Criado para teste de intuição na disciplina de Ordenação e Recuperação de Dados na UFPB.

Classes:
- HuffmanTree;
- HuffmanNode;
- HuffmanLeaf;
- HuffmanCode;
- Main (Contém o método main).

## Execução:

A execução é feita por meio da classe Main. Nesse código, a main define uma string (no exemplo: ABRACADABRA) e gera um arquivo binário com os códigos dos caracteres da string. A fim de comparação, deixo disponível um arquivo chamado "no-compressed.txt" que corresponde a um arquivo de texto com a palavra "ABRACADABRA" com tamanho de *11 bytes*, e outro arquivo "compressed.bin" que trata-se da compressão da palavra "ABRACADABRA" (*3 bytes*).

## Próximos passos:

Com base no algoritmo de codificação de Huffman, criar outro para decodificação.
