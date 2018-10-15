package lab11;
import java.util.Scanner;

public class Driver {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int userSelection;
        Driver ui = new Driver();

        MyBinarySearchTreePlus<Item, String> BST = new MyBinarySearchTreePlus<>();
        MyBinarySearchTreePlus<Item, String> copyBST;

        ui.listOptions();

        do {
            userSelection = ui.menuSelection();
            System.out.println(userSelection);
            switch (userSelection) {
                case 1:
                    ui.insertKey(BST);
                    break;
                case 2:
                    ui.removeKey(BST);
                    break;
                case 3:
                    ui.search(BST);
                    break;
                case 4:
                    ui.getHeight(BST);
                    break;
                case 5:
                    ui.getSize(BST);
                    break;
                case 6:
                    ui.displayInorder(BST);
                    break;
                case 7:
                    ui.displayPreorder(BST);
                    break;
                case 8:
                    ui.displayPostorder(BST);
                    break;
                case 9:
                    copyBST = ui.copyTree(BST);
                    ui.testCopy(BST, copyBST);
                    break;
                case 10:
                    ui.exitProgram();
                    break;
            }
        } while(userSelection != 10);
    }


    public void insertKey(MyBinarySearchTreePlus<Item, String> BST) {
        String key;
        System.out.print("Enter key to insert: ");
        key = in.next().trim();
        System.out.print(key);
        BST.insert(new Item(key));
        System.out.println("Key " + key + " inserted");
    }

    public void removeKey(MyBinarySearchTreePlus<Item, String > BST) {
        String key;
        System.out.print("Enter key to remove: ");
        key = in.next().trim();
        System.out.print(key);
        BST.delete(key);
        System.out.println("Key " + key + " deleted");
    }

    public void search(MyBinarySearchTreePlus<Item, String> BST) {
        String key;
        Item result;
        System.out.print("Enter key to search: ");
        key = in.next().trim();
        System.out.print(key);
        result = BST.retrieve(key);
        if (result == null) {
            System.out.println("Key not found");
        }
        else {
            System.out.println("Key " + result.getKey() + " found");
        }
    }

    public void getHeight(MyBinarySearchTreePlus<Item, String> BST) {
        System.out.println("The height of the tree is " + BST.getHeight());
    }

    public void getSize(MyBinarySearchTreePlus<Item, String> BST) {
        System.out.println("The size of the tree is " + BST.getSize());
    }

    public void displayInorder(MyBinarySearchTreePlus<Item, String> BST) {
        System.out.println(BST.toStringInorder());
    }

    public void displayPreorder(MyBinarySearchTreePlus<Item, String> BST) {
        System.out.println(BST.toStringPreorder());
    }

    public void displayPostorder(MyBinarySearchTreePlus<Item, String> BST) {
        System.out.println(BST.toStringPostorder());
    }

    public MyBinarySearchTreePlus<Item, String> copyTree(MyBinarySearchTreePlus<Item, String> BST) {
        return BST.getCopyOfTree();
    }

    public void testCopy(MyBinarySearchTreePlus<Item, String> BST, MyBinarySearchTreePlus<Item, String> copyBST) {
        System.out.println("ORIGINAL TREE INORDER");
        displayInorder(BST);

        System.out.println("COPY TREE INORDER");
        displayInorder(copyBST);

        System.out.println("ADDING A KEY TO ORIGINAL TREE");
        insertKey(BST);

        System.out.println("REMOVING ITEM FROM COPY TREE");
        removeKey(copyBST);

        System.out.println("COMPARISON OF ORIGINAL AND COPY");
        displayInorder(BST);
        displayInorder(copyBST);
    }








        public int menuSelection() {
            System.out.print("Make your menu selection now: ");
            return Integer.parseInt(in.next().trim());
        }

        public void listOptions(){
            System.out.println("Select from the following menu:");
            System.out.println("    1. Insert key into BST");
            System.out.println("    2. Remove key from BST");
            System.out.println("    3. Search for key in BST");
            System.out.println("    4. Display height of BST");
            System.out.println("    5. Display size of BST");
            System.out.println("    6. Display content of BST inorder");
            System.out.println("    7. Display content of BST in preorder");
            System.out.println("    8. Display content of BST in postorder");
            System.out.println("    9. Build copy of tree and test it");
            System.out.println("    10. Exit program");
        }

        void exitProgram(){
            System.out.println("Exiting program...Good Bye");
            System.exit(0);
        }
}
