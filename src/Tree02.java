/**
 * Created by zeqingzhang on 2/7/17.
 */

class BT{
    BT left;
    BT right;
    String s;
    int weight;
    BT(BT left, BT right){
        this.left = left;
        this.right = right;
    }

    BT(String s, int weight){
        this.s = s;
        this.weight = weight;
    }




    private String printTree(){
        BT tree = this;

        return helper(tree);
    }


    private String helper(BT tree){
        if(tree.s != null){
            return tree.s;
        }
        String left = helper(tree.left);
        String right = helper(tree.right);

        return "(" + left + " " + right + ")";
    }

    public static  void main(String[] args){
        BT a = new BT("A", 4);
        BT b = new BT("B", 2);
        BT c = new BT("C", 2);
        BT d = new BT("D", 2);
        BT e = new BT("E", 7);
        BT bc = new BT(b, c);
        BT ad = new BT(a, d);
        BT abcd = new BT(ad, bc);
        BT top = new BT(abcd , e);

        System.out.println(top.printTree());


    }


}



public class Tree02 {


}
