package Classes;
//Class condition, this class innherits from the Item class
public class Condition extends Item{
    //methods will create a list of conditions
    public static Condition[] createConditions(int n){
        Condition[] list = new Condition[n];
        for (int i = 0; i < n; i++) {
            list[i] = new Condition();
        }
        return list;
    }
    //setValues abstract method  from Item class
    @Override
    public void setValues(int a,float b,float c,float d,int e,int f,int g, int h, float i) {
        node1 = e;
        value = i;
    }



}
