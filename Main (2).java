public class Main {
    
    public static void main(String[] args) {
        Matrix.matrixInputChoice();
        
        if (Matrix.getReadFile())
            Matrix.inputFromFile();
        else if (Matrix.getReadKea())
            Matrix.inputKeyboard();
            
        Matrix.printMatrixA();
        System.out.println();
        
        Matrix.matrixB();
        Matrix.printMatrixB();
        System.out.println();
        
        Matrix.matrixBToFile();
	}
}
