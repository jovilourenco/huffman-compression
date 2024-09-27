import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCode {
    
    protected HashMap<Character, String> huffmanCodes = new HashMap<>();

    public HuffmanTree buildTree(int[] charFrequencies) {
        PriorityQueue<HuffmanTree> queue = new PriorityQueue<>();

        for (int i = 0; i < charFrequencies.length; i++) {
            if (charFrequencies[i] > 0)
                queue.add(new HuffmanLeaf(charFrequencies[i], (char) i));
        }

        while (queue.size() > 1) {
            HuffmanTree tree1 = queue.poll();
            HuffmanTree tree2 = queue.poll();
            queue.add(new HuffmanNode(tree1, tree2));
        }

        return queue.poll();
    }

    public void generateCodes(HuffmanTree tree, StringBuilder prefix) {
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            huffmanCodes.put(leaf.getValue(), prefix.toString());
        } else {
            HuffmanNode node = (HuffmanNode) tree;
            prefix.append("0");
            generateCodes(node.getLeftTree(), prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append("1");
            generateCodes(node.getRightTree(), prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public String encode(String text) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        return encodedString.toString();
    }

    public void writeToFile(String filename, String encodedText) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            byte[] bytes = new byte[(encodedText.length() + 7) / 8];
            for (int i = 0; i < encodedText.length(); i++) {
                if (encodedText.charAt(i) == '1') {
                    bytes[i / 8] |= (1 << (7 - (i % 8)));
                }
            }
            fos.write(bytes);
        }
    }
}
