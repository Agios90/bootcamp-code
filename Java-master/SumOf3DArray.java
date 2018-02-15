
package sumof3darray;

/**
 *
 * @author agios
 */
public class SumOf3DArray {


    public static void main(String[] args) {
        
        //ΔΗΛΩΣΗ ΜΕΤΑΒΛΗΤΩΝ
        int rows = 3;
        int columns = 3;
        int aisles = 3;
        int[][][] arr = new int [rows][columns][aisles];
        int i, j, k;
        int[] sumi = new int[rows];
        int[] sumj = new int[columns];
        int[] sumk = new int[aisles];
        int printvar;
        
        //ΑΡΧΙΚΟΠΟΙΗΣΗ
        for (i=0; i<rows; i++) {
            for (j=0; j<columns; j++) {
                for (k=0; k<aisles; k++) {
                    arr[i][j][k] = i+j+k;
                    System.out.println(i + " + " + j + " + " + k + "" + " = " + arr[i][j][k]);
                }
            }
        }
        
        //ΑΘΡΟΙΣΜΑΤΑ 1ΗΣ ΔΙΑΣΤΑΣΗΣ
        System.out.println();
        for (i=0; i<rows; i++) {
            sumi[i] = 0;
            for (j=0; j<columns; j++) {
                for (k=0; k<aisles; k++) {
                    sumi[i] += arr[i][j][k];
                }
            }
            printvar = i+1;
            System.out.println("Το άθροισμα των στοιχείων της " + printvar +"ης γραμμής είναι: " + sumi[i]);
        }
        
        //ΑΘΡΟΙΣΜΑΤΑ 2ΗΣ ΔΙΑΣΤΑΣΗΣ
        System.out.println();
        for (j=0; j<columns; j++) {
            sumj[j] = 0;
            for (i=0; i<rows; i++) {
                for (k=0; k<aisles; k++) {
                    sumj[j] += arr[i][j][k];
                }
            }
            printvar = j+1;
            System.out.println("Το άθροισμα των στοιχείων της " + printvar +"ης στήλης είναι: " + sumj[j]);
        }
        
        ////ΑΘΡΟΙΣΜΑΤΑ 3ΗΣ ΔΙΑΣΤΑΣΗΣ
        System.out.println();
        for (k=0; k<aisles; k++) {
            sumk[k] = 0;
            for (i=0; i<rows; i++) {
                for (j=0; j<columns; j++) {
                    sumk[k] += arr[i][j][k];
                }
            }
            printvar = k+1;
            System.out.println("Το άθροισμα των στοιχείων του " + printvar +"ου διαδρόμου είναι: " + sumk[k]);
        }
        
    }
    
}
