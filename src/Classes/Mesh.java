package Classes;
import java.util.ArrayList;
import Enums.*;
import static Enums.Sizes.*;

public class Mesh {
    //variables globales
    float parameters[] = new float[6];
    int sizes[] = new int [4];
    int indices_dirich[];
    Node node_list[];
    Element element_list[];
    Condition dirichlet_list[];
    Condition neumann_list[];

    public Mesh(){
    };

    //setters
    public void setParameters(float k, float Q){
        parameters[Parameters.THERMAL_CONDUCTIVITY.ordinal()] = k;
        parameters[Parameters.HEAT_SOURCE.ordinal()] = Q;
    }

    public void setSizes(int nnodes, int neltos, int ndirich, int nneu){
        sizes[NODES.ordinal()]=nnodes;
        sizes[ELEMENTS.ordinal()]=neltos;
        sizes[DIRICHLET.ordinal()]=ndirich;
        sizes[NEUMANN.ordinal()]=nneu;
    }
    
    public int getSize(int s){
        return sizes[s];
    }

    public float getParameter(int p){
        return parameters[p];
    }

    public void createData(){
        node_list = Node.createNodes(sizes[NODES.ordinal()]);
        element_list = Element.createElements(sizes[ELEMENTS.ordinal()]);
        indices_dirich = new int[sizes[DIRICHLET.ordinal()]];
        dirichlet_list = Condition.createConditions(sizes[DIRICHLET.ordinal()]);
        neumann_list = Condition.createConditions(sizes[NEUMANN.ordinal()]);

    }
    //getters
    public int[] getDirichletIndices() {
        return indices_dirich;
    }

    public Node[] getNodes() {
        return node_list;
    }
    
    public Node getNode(int i){
        return node_list[i];
    }

    public Element[] getElements() {
        return element_list;
    }
    
    public Element getElement(int i){
        return element_list[i];
    }

    public Condition[] getDirichlet(){
        return dirichlet_list;
    }

    public Condition[] getNeumann(){
        return neumann_list;
    }

    public Condition getCondition(int i, Sizes type){
        if(type == Sizes.DIRICHLET) return dirichlet_list[i];
        else return neumann_list[i];
    }
}
