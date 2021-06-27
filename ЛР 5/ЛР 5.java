package codewith;
import java.util.ArrayList;

class BinarySearch{
    public void Binary_Tree() {
        Tree Form = new Tree();
        Form.insertNode(10);
        Form.insertNode(5);
        Form.insertNode(15);
        Form.insertNode(3);
        Form.insertNode(20);
        Form.insertNode(7);
        Form.insertNode(19);
        Form.insertNode(13);

        ArrayList<Integer> units = new ArrayList<>();
        units.addAll(Form.items_to_heap);
        Heap heap = new Heap(units.size()+1);
        for (int i = 0; i < units.size(); i++) {
            heap.insertNode(units.get(i));
        }
    }
    static class Node{
        private int value;
        private Node leftchild;
        private Node rightchild;

        public int getValue(){
            return this.value;
        }
        public void setValue( int value){
            this.value = value;
        }
        public Node getLeftChild(){
            return this.leftchild;
        }
        public void setLeftChild(Node leftChild){
            this.leftchild = leftChild;
        }
        public Node getRightChild(){
            return this.rightchild;
        }
        public void setRightChild (Node rightChild){
            this.rightchild = rightChild;
        }

    }
     class Tree {
         private Node rootNode;
         private ArrayList<Integer> items_to_heap;

         public void insertNode(int value) {

             Node newNode = new Node();
             newNode.setValue(value);
             if (rootNode == null) {
                 rootNode = newNode;
                 items_to_heap.add(newNode.getValue());
             } else {
                 Node currentNode = rootNode;
                 Node parentNode;
                 while (true) {
                     parentNode = currentNode;
                     if (value == currentNode.getValue()) {
                         return;
                     } else if (value < currentNode.getValue()) {
                         currentNode = currentNode.getLeftChild();
                         if (currentNode == null) {
                             parentNode.setLeftChild(newNode);
                             items_to_heap.add(newNode.getValue());
                             return;
                         }
                     } else {
                         currentNode = currentNode.getRightChild();
                         if (currentNode == null) {
                             parentNode.setRightChild(newNode);
                             items_to_heap.add(newNode.getValue());
                             return;
                         }
                     }
                 }
             }
         }
     }
    public class Node_H {
        private int value;

        public Node_H(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    public class Heap {
        private Node_H[] heapArray;
        private int maxSize;
        private int currentSize;

        public Heap(int maxSize) {
            this.maxSize = maxSize;
            this.currentSize = 0;
            heapArray = new Node_H[maxSize];
        }

        public boolean insertNode(int value) {
            if (currentSize == maxSize) {
                return false;
            }
            Node_H newNode = new Node_H(value);
            heapArray[currentSize] = newNode;
            displaceUp(currentSize++);
            return true;
        }

        private void displaceUp(int index) {
            int parentIndex = (index - 1) / 2;
            Node_H bottom = heapArray[index];
            while (index > 0 && heapArray[parentIndex].getValue() < bottom.getValue()) {
                heapArray[index] = heapArray[parentIndex];
                index = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            }
            heapArray[index] = bottom;
        }
    }
}
