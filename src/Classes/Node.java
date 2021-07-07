package Classes;
//Class node, this class innherits from the Item class
public class Node extends Item{
    //methods helps us to create a list of nodes.
    public static Node[] createNodes(int n){
        Node[] list = new Node[n];
        for (int i = 0; i < n; i++) {
            list[i] = new Node();
        }
        return list;
    }
    //setValues abstract method  from Item class
    @Override
    public void  setValues(int a,float b,float c,float d,int e,int f,int g, int h, float i) {
        id = a;
        x = b;
        y = c;
        z = d;
    }
}
