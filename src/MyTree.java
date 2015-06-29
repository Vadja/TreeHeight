import java.util.*;
import java.lang.*;
import java.util.ArrayList;

class MyTree
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Random r = new Random();
        Tree<Integer> tree = new Tree<>(0);
        Node<Integer> parent = new Node<>();
        tree.setRoot(parent);
        List<Node<Integer>> children;
        for (int i = 0; i < 10; i++) {
            children = new ArrayList<Node<Integer>>();
            Node<Integer> node = new Node<>();
            children.add(node);
            node.setAll(r.nextInt(10), parent);
            parent.setChildren(children);
            parent = node;
        }
        System.out.println(tree.getHeight());
    }
    static class Tree<T> {
        private Node<T> root;

        public Tree(T rootData) {
            root = new Node<T>();
            root.data = rootData;
            root.children = new ArrayList<Node<T>>();
        }


        public int getHeight()
        {
            return getHeight(root);
        }

        public int getHeight(Node<T> root)
        {
            if(root == null)
                return  0;
            int max = 0;
            if(root.children != null){
                for(Node<T> node: root.children){
                    int height = getHeight(node);
                    if(height > max){
                        max = height;
                    }
                }
            }
            return max+1;
        }

        public void setRoot(Node node){
            this.root = node;
        }
    }


    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;

        public void setAll(T data, Node<T> parent){
            this.data = data;
            this.parent = parent;
        }

        public void setChildren(List<Node<T>> children){
            this.children = children;
        }
    }
}