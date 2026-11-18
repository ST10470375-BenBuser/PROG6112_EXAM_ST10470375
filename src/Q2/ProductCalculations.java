/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author benja
 */

  
public class ProductCalculations implements IApp{

    
 
    public double CalculateVAT(String productPrice) {
        double price = Double.parseDouble(productPrice.trim());
      
        return price * 12 / 100.0;
    }
     public double CalculateComission(String productPrice) {
        double price = Double.parseDouble(productPrice.trim());
      
        return price * 5 / 100.0;
    }
      public double CalculateTotalSale(String productPrice) {
        double price = Double.parseDouble(productPrice.trim());
      
       
         return price + (price * 12 / 100.0) + (price * 5 / 100.0);
    }

   
    @Override
    public boolean ValidateData(Data dataToValidate) {
       
        if (dataToValidate == null
                || isEmpty(dataToValidate.getProduct())
                || isEmpty(dataToValidate.getMatressName())) {
            return false;
        }
      
        try {
            double price = Double.parseDouble(dataToValidate.getProductPrice().trim());
            double percent = 12;
            return price > 0 && percent > 0;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

   
    private boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }
}


