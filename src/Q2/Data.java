/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author benja
 */

    public class Data {
    private final String product;
    private final String matressName;
    private final String productPrice;
    

    public Data(String product, String agentName, String propertyPrice) {
        this.product = product;
        this.matressName = agentName;
        this.productPrice = propertyPrice;
       
    }

    public String getProduct() { return product; }
    public String getMatressName() { return matressName; }
    public String getProductPrice() { return productPrice; }
  
}


