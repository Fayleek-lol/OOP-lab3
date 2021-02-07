import java.util.*;
import java.io.*;

public class Matrix{ 
    
    private static int[][] A = new int[5][5];
    private static int[] B = new int [5];
    private static boolean readFile = false;
    private static boolean readKea = true;
    
    public static void matrixInputChoice(){
        System.out.println("Способо ввода: f - файл, k - клавиатура");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        if (choice == "f")
            readFile = true;
        else 
            readKea = true;
    }
    
    public static boolean getReadFile(){
        return readFile;
    }
    
    public static boolean getReadKea(){
        return readKea;
    }
    
    public static int[][] inputFromFile() {
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        File file = new File(path);
        
        try {
            in  = new Scanner(file);
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    A[i][j] = in.nextInt();
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Ошибка " + e + "! файл " +path + " не найден!");
        } 
        catch (InputMismatchException e) {
            System.out.println("Ошибка " + e + "! Несоответствие типов данных!");
        }
        return A;
    }
    
    public static void inputKeyboard(){
        Scanner in = new Scanner(System.in);
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                A[i][j] = in.nextInt();
            }
        }
    }
    
    public static void matrixB(){
        int sum = 0;
        int b = 0;
        for (int i = 0, n = 0; i < A.length; i ++){
            for (int j = 0; j < A.length; j++){
                if (i != j && j >= n){
                    sum += A[i][j];
                    if (j == n){
                        B[b] = sum;
                        n++;
                        b += 1;
                        sum = 0;
                        
                    }
                }
            }
        }
    }
    
    public static void printMatrixA(){
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A.length; j++){
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static void printMatrixB(){
        for(int i = 0; i < B.length; i++){
            System.out.print(B[i] + "\t");
        }
    }
    
    public static void matrixBToFile(){
        System.out.println("Введите файл");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        in.close();
        
        File file = new File(path);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            
            for (int number : B){
                fileWriter.write(number + " ");
            }
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println("Файл с таким именем уже существует");
        }
    }
}