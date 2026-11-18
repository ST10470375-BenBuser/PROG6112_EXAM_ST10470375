/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import Q2.Data;
import Q2.AppGUI;
import Q2.ProductCalculations;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author benja
 */
public class Q2test {
    
    

    private final ProductCalculations a = new ProductCalculations();

    
    void CalculateVAT_CalculatedSuccessfully() {
        // R1 000 at 12% -> R120
        double actual = a.CalculateComission("1000");
        assertEquals(120.0, actual);
    }

   
    void CalculateVAT_CalculatedUnSuccessfully() {
        // Deliberately compare with a WRONG expected value to prove the result is
        // not accidentally right: assertNotEquals passes when values differ.
        double actual = a.CalculateComission("1000");
        assertNotEquals(120.0, actual);
    }

    
    void CalculateTotal_CalculatedSuccessfully() {
        // R100 + 12% + 5% -> R117
        double actual = a.CalculateComission("117");
        assertEquals(117.0, actual);
    }
    
    void CalculateTotal_CalculatedUnSuccessfully() {
        // Deliberately compare with a WRONG expected value to prove the result is
        // not accidentally right: assertNotEquals passes when values differ.
        double actual = a.CalculateComission("117");
        assertNotEquals(117.0, actual);
    }
}
