package Tools;

import java.util.ArrayList;

public class Matrix extends ArrayList<Vector> {
    public Matrix(){};

    public Matrix(int numRows, int numCols, float defaultElement){
        for (int i = 0; i < numRows; i++) {
            this.add(new Vector(numCols,defaultElement));
        }
    }
    
    public void Show(){
        for (int i = 0; i < this.size(); i++) {
            this.get(i).Show();
        }
    }

}
