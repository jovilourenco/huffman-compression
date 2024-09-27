public class Main {
    public static void main(String[] args) {
        String text = "ABRACADABRA";

        int[] charFrequencies = new int[256];

        for (char c : text.toCharArray())
            ++charFrequencies[c];

        HuffmanCode code = new HuffmanCode();
        HuffmanTree huffmanTree = code.buildTree(charFrequencies);
        code.generateCodes(huffmanTree, new StringBuilder());

        // Imprime os códigos
        System.out.println("Códigos de Huffman:");
        for (char c : code.huffmanCodes.keySet()) {
            System.out.println(c + "\t" + code.huffmanCodes.get(c));
        }

        // Codifica o texto original
        String encodedText = code.encode(text);
        System.out.println("Texto codificado: " + encodedText);

        // Escreve o texto codificado em um arquivo
        try {
            code.writeToFile("compressed.bin", encodedText);
            System.out.println("Arquivo comprimido gerado: compressed.bin");
        } catch (Exception e) {
            System.err.println("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }
}
