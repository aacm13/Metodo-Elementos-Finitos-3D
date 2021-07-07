package Tools;

import java.util.ArrayList;

public class Matrix extends ArrayList<Vector> {
    public Matrix(){};

    //this method instantiates a matrix object
    public Matrix(int numRows, int numCols, float defaultElement){
        for (int i = 0; i < numRows; i++) {
            this.add(new Vector(numCols,defaultElement));
        }
    }
    //prints matrix
    public void Show(){
        for (int i = 0; i < this.size(); i++) {
            this.get(i).Show();
        }
    }

}
