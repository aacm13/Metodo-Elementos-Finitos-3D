package Tools;
import Classes.Condition;
import Classes.Item;
import Classes.Mesh;
import Enums.Lines;
import Enums.Modes;
import Enums.Indicator;
import Enums.Parameters;
import Enums.Sizes;
import java.io.*;
import static Enums.Indicator.*;
import static Enums.Lines.*;
import static Enums.Modes.*;

public class Tools {
    
    //reads data
    public static void obtenerDatos(BufferedReader file, Lines nlines, int n, Modes mode, Item[] itemList) throws IOException {
        String line;
        line = file.readLine();
        line = file.readLine();
        String[] values = null;
        if(nlines == DOUBLELINE)
            line = file.readLine();

        for (int i = 0; i < n; i++) {
            switch (mode){
                case INT_FLOAT:

                    int e0; float r0;
                    line = file.readLine();
                    values = line.split("\\s+");
                    e0 = Integer.parseInt(values[0].trim());
                    r0 = Float.parseFloat(values[1].trim());
                    System.out.println(e0+"\t"+r0);
                    itemList[i].setValues(0,0,0,0,e0,0,0,0,r0 );
                    break;
                case INT_FLOAT_FLOAT_FLOAT:

                    int e; float r,rr,rrr;
                    line = file.readLine();
                    values = line.split("\\s+");
                    e = Integer.parseInt(values[0].trim());
                    r = Float.parseFloat(values[1].trim());
                    rr = Float.parseFloat(values[2].trim());
                    rrr = Float.parseFloat(values[3].trim());
                    System.out.println(e+"\t"+r+"\t"+rr);
                    itemList[i].setValues(e,r,rr,rrr,0,0,0,0,0);
                    break;
                case INT_INT_INT_INT_INT:

                    int e1,e2,e3,e4,e5;
                    line = file.readLine();
                    values = line.split("\\s+");
                    e1 = Integer.parseInt(values[0].trim());
                    e2 = Integer.parseInt(values[1].trim());
                    e3 = Integer.parseInt(values[2].trim());
                    e4 = Integer.parseInt(values[3].trim());
                    e5 = Integer.parseInt(values[4].trim());
                    System.out.println(e1+"\t"+e2+"\t"+e3+"\t"+e4);
                    itemList[i].setValues(e1,0,0,0,e2,e3,e4,e5,0);
                    break;
            }
        }
    }
    
    public static void correctConditions(int n, Condition[] list, int[] indices){
        for(int i=0; i<n; i++)
            indices[i] = list[i].getNode1();
        for(int i=0; i<n-1; i++){
            int pivot = list[i].getNode1();
            for(int j=i; j<n; j++)
                if(list[j].getNode1()>pivot)
                    list[j].setNode1(list[j].getNode1()-1);
        }
    }

    public static String addExtension(String filename, String extension){
        String newFilename = filename + extension;
        return newFilename;
    }
    //readd data from bat file, to be processed
    public static void leerMallayCondiciones(Mesh m, String filename){
        String inputfilename, line;
        String[] values;
        float k, Q;
        int nnodes, neltos, ndirich, nneu;
        inputfilename = addExtension(filename, ".dat");
        System.out.println(inputfilename);
        
        try(FileReader fr = new FileReader(inputfilename);
            BufferedReader file = new BufferedReader(fr)) {
            System.out.println(fr);
            line = file.readLine();
            values = line.split("\\s+");
            k = Float.parseFloat(values[0].trim()); Q = Float.parseFloat(values[1].trim());
            System.out.println("k "+k+"   Q "+Q);

            line = file.readLine();
            values = line.split("\\s+");

            nnodes = Integer.parseInt(values[0].trim()); neltos = Integer.parseInt(values[1].trim());
            ndirich = Integer.parseInt(values[2].trim()); nneu = Integer.parseInt(values[3].trim());

            System.out.println(nnodes+"\t"+neltos+"\t"+ndirich+"\t"+nneu);

            m.setParameters(k,Q);
            m.setSizes(nnodes,neltos,ndirich,nneu);
            m.createData();

            obtenerDatos(file,SINGLELINE,nnodes,INT_FLOAT_FLOAT_FLOAT,m.getNodes());
            System.out.println("\nElements");
            obtenerDatos(file,DOUBLELINE,neltos,INT_INT_INT_INT_INT,m.getElements());
            System.out.println("\nDirichlet");
            obtenerDatos(file,DOUBLELINE,ndirich,INT_FLOAT,m.getDirichlet());
            System.out.println("\nNeumann");
            obtenerDatos(file,DOUBLELINE,nneu,INT_FLOAT,m.getNeumann());

            correctConditions(ndirich, m.getDirichlet(), m.getDirichletIndices());

        } catch (IOException ex){
            System.out.println("Hubo un error al leer el archivo...\n"+ex.getMessage()+"\nSaliendo");
            System.exit(1);
        }
    }

    public static Boolean findIndex(int v, int s, int[] arr){
        for (int i = 0; i < s; i++) {
            if(arr[i] == v) return true;
        }
        return false;
    }
    //Method writes the results into a file
    public static void writeResults(Mesh m, Vector T, String filename){
        String outputfilename;
        int[] dirichlet_indices = m.getDirichletIndices();
        Condition[] dirich = m.getDirichlet();

        outputfilename = addExtension(filename, ".post.res");

        try (FileWriter fr = new FileWriter(outputfilename); BufferedWriter file = new BufferedWriter(fr)) {

            file.write("GiD Post Results File 1.0\n");
            file.write("Result \"Temperature\" \"Load Case 1\" 1 Scalar OnNodes\nComponentNames \"T\"\nValues\n");

            int Tpos = 0;
            int Dpos = 0;
            int n = m.getSize(Sizes.NODES.ordinal());
            int nd = m.getSize(Sizes.DIRICHLET.ordinal());

            for (int i = 0; i < n; i++) {
                if(findIndex(i +1, nd, dirichlet_indices)){
                    file.write((i+1)+" "+dirich[Dpos].getValue()+"\n");
                    Dpos++;
                }else{
                    file.write((i+1)+" "+T.get(Tpos)+"\n");
                    Tpos++;
                }
            }
            file.write("End values\n");

        } catch (IOException ex){
            System.out.println("Error al escribir el archivo...\nSaliendo");
            System.exit(1);
        }

    }

}
