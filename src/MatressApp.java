
import java.util.Locale;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author benja
 */
public class MatressApp {
    public static void main(String[] args) {
        String[] matressess = {"Cozy Nights Monarch Matress", "Restonic Barbados Matress", "Sealy Phuket Matress"};
        String[] months = {"month 1", "month 2", "month 3"};
        
        MatressApp matressApp = new MatressApp();
        Scanner sc = new Scanner(System.in);
       
        int data[][] = new int [matressess.length][months.length];
        
        for (int i = 0; i < months.length;i ++)
        {
            for (int m = 0; m <months.length; m++)
            {
                System.out.println("Enter value for matress " + matressess[m] + "For " + months[i]);
                data[i][m] = sc.nextInt();
            }
        }
        
        System.out.println("PRODUCT SALES REPORT 2026 \n");
       // System.out.printf("%15s", ""); 
        int sum =0;
        int av = 0;
         for (int row[] : data){
             for (int num : row)
             {
                 sum += num;
                 av = sum/3;
             }
             
         }
         
         
        
        int topIndex = 0;                              
        int rowIndex = 0;
        int s1 = 0;
        String n = "temp";
        
        for (int i = 0; i< 3 ; i++)
        {
        for (int col = 0; col < data[rowIndex].length; col ++)
        {
            s1 += data[rowIndex][col];
           
        }
        }
       
    
         System.out.println("TOTAL PRODUCT SALES : " + sum);
         System.out.println("AVERAGE SALES : " + av);
         System.out.println("TOP SALES : " + s1 );
        
    }
}
