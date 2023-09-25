import java.io.BufferedReader;
// Allows to read the text file line by line

import java.io.FileReader;
// Allows to read each character of the text file


import org.bytedeco.javacpp.Loader;
// imports the Loader class and loads the necessary libraries to run the C++ code in Java




import org.bytedeco.javacpp.annotation.*;
// Allows annotations for configuring the behavior of native c++ methods and classes from java



@Platform(include="Maximum.cpp")
// Annotation calling the C++ class "Maximum,cpp".

public class Lab1 {

    static { Loader.load(); }

    private native int Maximum(int[] numeros, int tam);

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Debe proporcionar el nombre del archivo como argumento.");
            return;
        }
      // If in any case the txt file was not placed on the command line, show a message


        String archivo = args[0];
        int[] numeros = null;
// Store the file name through the "file" variable and create a vector of numbers



        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine();
   //Open and read the file




            String[] numerosString = linea.split(" ");
            numeros = new int[numerosString.length];
// Separates the numbers found in the txt each time it identifies a space and saves it in the string vector




            for (int i = 0; i  < numeros.length; i++) {
                numeros[i] = Integer.parseInt(numerosString[i]);
            }
          // Convert string numbers to int type and store them in the vector


            for (int i=0; i<numeros.length; i++) {
                System.out.print(numeros[i]+ " ");
            }
          // Print the vector


        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }




        if (numeros != null) {
            Lab1 obj = new Lab1();
            int maximo= obj.Maximum(numeros,numeros.length);
            System.out.println("\nEl número mayor es: "+maximo);
        }
     //Creates an object of class Lab1, calls the "Maximum" method to find the largest number in the numeric vector and prints it.
    }
}