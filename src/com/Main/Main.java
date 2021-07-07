package com.Main;

import java.util.ArrayList;
import Classes.Mesh;
import Tools.Matrix;
import Tools.Vector;
import java.util.ArrayList;
import static Enums.Sizes.*;
import static Tools.Math_Tools.*;
import static Tools.Sel.*;
import static Tools.Tools.*;
public class Main {

    public static void main(String[] args) {
        String filename = "3dtest";
        //instanciates vectors and matrix
        ArrayList<Matrix> localKs = new ArrayList<Matrix>();
        ArrayList<Vector> localbs = new ArrayList<Vector>();
        Matrix K = new Matrix();
        Vector b = new Vector();
        Vector T = new Vector();

        System.out.println("IMPLEMENTACION DEL METODO DE LOS ELEMENTOS FINITOS EN 3D");
        System.out.println("*************************************************************************");

        Mesh m = new Mesh();
        //reads .dat file
        leerMallayCondiciones(m, filename);
        System.out.println("Datos obtenidos correctamente\n***********************");
        //creates and shows locas
        crearSistemasLocales(m, localKs, localbs);
        System.out.println("*******************************");

        //matrix's are set to 0, they are then assembled
        zeroes(K, m.getSize(NODES.ordinal()));
        zeroes(b, m.getSize(NODES.ordinal()));
        ensamblaje(m, localKs, localbs, K, b);
        System.out.println("*******************************");

        //applys neumann
        applyNeumann(m, b);
        System.out.println("*******************************");

        //apply dirichlet
        applyDirichlet(m,K,b);
        System.out.println("*******************************");

        //calculates results
        zeroes(T, b.size());
        calculate(K,b,T);

        //results are writen into a file
        writeResults(m,T,filename);

    }
}
