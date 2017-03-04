import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zeqingzhang on 12/9/16.
 */
public class ArraysAsList {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serializeHelper(root , result);
        return result.toString();
    }


    private void serializeHelper(TreeNode t, StringBuilder result){
        if(t == null){
            result.append("X" + "->");
        }else{
            serializeHelper(t.left, result.append(t.val + "->"));
            serializeHelper(t.right, result.append(t.val + "->"));
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split("->")));
        return deserializeHelper(queue);
    }


    private TreeNode deserializeHelper(Queue<String> queue){
        String val = queue.remove();
        if(val.equals("X")){
            return null;
        }else{
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = deserializeHelper(queue);
            root.right = deserializeHelper(queue);
            return root;
        }

    }
    public static void main(String[] args){
        String s = "1->2->3->34->8";
        System.out.println(new LinkedList<>(Arrays.asList(s.split("->"))));
        Queue<String> queue = new LinkedList<>();
        queue.add("2");
        queue.add("1");
        queue.add("3");
        ArraysAsList a = new ArraysAsList();
        a.deserializeHelper(queue);
    }
}
