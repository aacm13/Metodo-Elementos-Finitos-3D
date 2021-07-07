package Classes;

public abstract class Item {
    //variables globales
    protected int id;
    protected float x;
    protected float y;
    protected float z;
    protected int node1;
    protected int node2;
    protected int node3;
    protected int node4;
    protected int node5;
    protected int node6;
    protected int node7;
    protected int node8;
    protected int node9;
    protected int node10;
    protected float value;

    //metodos setters
    public void setId(int identifier) {

        id = identifier;
    }

    public void setX(float x) {

        this.x = x;
    }

    public void setY(float y) {

        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }
    
    public void setNode1(int node1) {

        this.node1 = node1;
    }

    public void setNode2(int node2) {

        this.node2 = node2;
    }

    public void setNode3(int node3) {

        this.node3 = node3;
    }
    
    public void setNode4(int node4) {
        this.node4 = node4;
    }
    
    public void setNode5(int node5) {
        this.node5 = node5;
    }
    
    public void setNode6(int node6) {
        this.node4 = node6;
    }
    
    public void setNode7(int node7) {
        this.node7 = node7;
    }
    
    public void setNode8(int node8) {
        this.node8 = node8;
    }
    
    public void setNode9(int node9) {
        this.node9 = node9;
    }
    
    public void setNode10(int node10) {
        this.node10 = node10;
    }

    public void setValue(float value) {

        this.value = value;
    }

    //metodos getters
    public int getId() {
        return id;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public int getNode1() {
        return node1;
    }

    public int getNode2() {
        return node2;
    }

    public int getNode3() {
        return node3;
    }

    public int getNode4() {
        return node4;
    }
    
    public int getNode5() {
        return node5;
    }
    
    public int getNode6() {
        return node6;
    }
    
    public int getNode7() {
        return node7;
    }
    
    public int getNode8() {
        return node8;
    }
    
    public int getNode9() {
        return node9;
    }
    public int getNode10() {
        return node4;
    }

    public float getValue() {
        return value;
    }
    //Abstract class, that will be used by other classes that inherit from item
    //to set the values
    public abstract void setValues(int a,float b,float c,float d,int e,int f,int g, int h, float i);


}
