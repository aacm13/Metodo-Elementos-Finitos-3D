package Classes;

public class Element extends Item{

    public static Element[] createElements(int n){
        Element[] list = new Element[n];
        for (int i = 0; i < n; i++) {
            list[i] = new Element();
        }
        return list;
    }

    @Override
    public void setValues(int a,float b,float c,float d,int e,int f,int g, int h, float i) {
        id = a;
        node1 = e;
        node2 = f;
        node3 = g;
        node4 = h;
    }
}
