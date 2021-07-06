package Classes;

public class Condition extends Item{
    
    public static Condition[] createConditions(int n){
        Condition[] list = new Condition[n];
        for (int i = 0; i < n; i++) {
            list[i] = new Condition();
        }
        return list;
    }

    @Override
    public void setValues(int a,float b,float c,float d,int e,int f,int g, int h, float i) {
        node1 = e;
        value = i;
    }



}
