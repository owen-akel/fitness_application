import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.ArrayList;

public class bst{
    public dateWeight object = new dateWeight();
    public ArrayList<dateWeight> toSort = new ArrayList<dateWeight>();
    public ArrayList<dateWeight> Sorted = new ArrayList<dateWeight>(); 
    public class TreeNode{
        dateWeight treenode = new dateWeight();
        TreeNode left;
        TreeNode right; 
        TreeNode() {}

        TreeNode(dateWeight treenode){
            this.treenode = treenode; 
            left = null; 
            right = null; 
        }

        TreeNode(dateWeight treenode, TreeNode left, TreeNode right){
            this.treenode = treenode; 
            this.left = left;
            this.right = right; 
        }
    }
    public Date convert(String i){ 
        Date date = null; 
        try
        {
            date=new SimpleDateFormat("MM/dd/yyyy").parse(i);
        }
        catch (java.text.ParseException pe)
        {
            pe.printStackTrace();
        } 
        return date;
    } 

    public ArrayList<dateWeight> populate(ArrayList<dateWeight> x, ArrayList<String> date, ArrayList<Double> weight){
        ArrayList<dateWeight> toSort = new ArrayList<dateWeight>(); 
        for(int i = 0; i<date.size(); i++){
            object = new dateWeight();
            object.x = convert(date.get(i));
            object.weight = weight.get(i);
            toSort.add(object);
        }
        return toSort; 
    }

    public void inOrderTraversal(TreeNode root){
        if(root.left != null) inOrderTraversal(root.left);
        Sorted.add(root.treenode);
        if(root.right != null) inOrderTraversal(root.right);
    }

    public TreeNode insertNode(TreeNode root, dateWeight treenode){
        if(root == null) return new TreeNode(treenode);
        if(treenode.x.compareTo(root.treenode.x)<0) root.left = insertNode(root.left, treenode);
        else if(treenode.x.compareTo(root.treenode.x)>0) root.right = insertNode(root.right, treenode);
        else if(treenode.x.compareTo(root.treenode.x) == 0) root.left = insertNode(root.left, treenode);
        return root; 
    }

    public ArrayList<dateWeight> sort(ArrayList<String> date, ArrayList<Double> weight){
        try{
            toSort = populate(toSort, date, weight);
            TreeNode root = new TreeNode();
            root.treenode = toSort.get(0);
            for(int i = 1; i<toSort.size(); i++){
                insertNode(root, toSort.get(i));    
            }
            inOrderTraversal(root);
        }
        catch(Exception e){
        }
        return Sorted;
    }
}