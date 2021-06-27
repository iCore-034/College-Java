package codewith;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random in = new Random();
        Rand_Bin Tree = new Rand_Bin();

        for (int i = 0; i < 5; i++) {
            int rand = in.nextInt(10+1);
            Tree.insertValue(rand);
        }
        Check recognize = new Check();
        recognize.checkBin(Tree.rootNode);
        if (recognize.stop){
            System.out.println("The Tree corresponds to the binary search tree");
        }
        else{
            System.out.println("The Tree don't correspond to the binary search tree");
        }
    }
    static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public int getValue() {
            return this.value;
        }
        public void setValue(int value1){
            this.value = value1;
        }
        public void setLeftChild(Node node) {
            this.leftChild = node;
        }

        public void setRightChild(Node node) {
            this.rightChild = node;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }
    }
    static class Rand_Bin {
        Node rootNode;
        public void insertValue(int value){
            Node newNode = new Node();
            newNode.setValue(value);
            if (rootNode == null){
                rootNode = newNode;
            }
            else{
                Node currentNode = rootNode;
                Node parentNode;
                while (true){
                    parentNode = currentNode;
                    Random in = new Random();
                    boolean polar = in.nextBoolean();
                    if (polar){
                        currentNode = currentNode.getLeftChild();
                        if (currentNode == null){
                            parentNode.setLeftChild(newNode);
                            return;
                        }
                    }
                    else{
                        currentNode = currentNode.getRightChild();
                        if (currentNode == null){
                            parentNode.setRightChild(newNode);
                            return;
                        }
                    }
                }
            }
        }
    }
    static class Check{
        boolean stop = true;
        public void checkBin(Node root){
            Node checkNode = root;

            if (checkNode.leftChild != null){
                if (checkNode.leftChild.getValue() < checkNode.getValue()){
                    checkNode = checkNode.getLeftChild();
                    checkBin( checkNode);
                }
                else{
                    stop = false;
                    return;
                }
            }
            if (checkNode.rightChild != null){
                if (checkNode.rightChild.getValue() > checkNode.getValue()){
                    checkNode = checkNode.getRightChild();
                    checkBin(checkNode);
                }
                else{
                    stop = false;
                    return;
                }
            }
        }
    }
}