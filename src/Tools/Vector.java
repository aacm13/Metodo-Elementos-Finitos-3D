package Tools;

import java.util.ArrayList;

public class Vector extends ArrayList<Float>{
    public Vector(){};

    public Vector(int size, float defaultElement){
        for (int i = 0; i < size; i++) {
            this.add(defaultElement);
        }
    }

    public void Show(){
        System.out.print("[\t");
        for (int i = 0; i < this.size(); i++) {
            System.out.print(String.format("%.3f", this.get(i))+"\t");
        }
        System.out.println("]");
    }
}
