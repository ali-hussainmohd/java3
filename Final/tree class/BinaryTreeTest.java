package Final;

public class BinaryTreeTest {

    public static void main(String [] args) {

        Binarytree<Integer> numsTree = new Binarytree<Integer>();

        for(int i=0; i< 11; i++)
            numsTree.insertNode(i);


        System.out.println(" Pre order traversal: ");
        numsTree.preOrderTraverse();

        System.out.println("\n In order traversal: ");
        numsTree.inOrderTraverse();

        System.out.println("\n Post order traversal: ");
        numsTree.postOrderTraverse();

        System.out.println("\n"+numsTree.treeHeight());

    }
}
