class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insertion operation
    public void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Deletion operation
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Search operation
    public boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (root.key < key)
            return searchRec(root.right, key);
        return searchRec(root.left, key);
    }

    // Inorder traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}

public class BST {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Gaming Tournament Player Management");
        System.out.println("========================================");

        //ข้อ 1
        BinarySearchTree Tree = new BinarySearchTree();

        //ข้อ 2
        Tree.insert(1050);
        Tree.insert(720);
        Tree.insert(1350);
        Tree.insert(480);
        Tree.insert(900);
        Tree.insert(1200);
        Tree.insert(1500);
        Tree.insert(810);
        Tree.insert(980);

        //ข้อ 3
        System.out.println("Registered Player IDs:");
        Tree.inorder();
        System.out.println();

        //ข้อ 4
        System.out.println("Search Player ID 900:");
        if(Tree.search(900) == true) System.out.println("Player ID 900 is registered.");
        else System.out.println("Player ID 900 is not registered.");

        System.out.println();

        System.out.println("Search Player ID 1100:");
        if(Tree.search(1100) == true) System.out.println("Player ID 1100 is registered.");
        else System.out.println("Player ID 1100 is not registered.");

        System.out.println();

        //ข้อ 5
        System.out.println("Player ID 720 has withdrawn.");
        Tree.delete(720);
        System.out.println();

        System.out.println("Current Player IDs:");
        Tree.inorder();
        System.out.println();

        //ข้อ 6
        System.out.println("Preorder traversal:");
        Tree.preorder();
        System.out.println();

        System.out.println("Postorder traversal:");
        Tree.postorder();

    }
}