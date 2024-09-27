public class HuffmanNode extends HuffmanTree{
    
    private HuffmanTree rightTree;
    private HuffmanTree leftTree;

    public HuffmanNode(HuffmanTree rightTree, HuffmanTree leftTree) {
        super(rightTree.getFrequency()+leftTree.getFrequency());
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public HuffmanTree getRightTree() {
        return rightTree;
    }

    public HuffmanTree getLeftTree() {
        return leftTree;
    }

    public void setRightTree(HuffmanTree rightTree) {
        this.rightTree = rightTree;
    }

    public void setLeftTree(HuffmanTree leftTree) {
        this.leftTree = leftTree;
    }

}
