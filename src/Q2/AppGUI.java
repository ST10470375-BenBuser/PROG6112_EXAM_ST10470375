/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author benja
 */
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class AppGUI extends JFrame {

    // Components are fields so every method can reach them 
    private final JComboBox<String> locationCombo =
            new JComboBox<>(new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy "}); // Q.2.1 values
    private final JTextField nameField = new JTextField();
    private final JTextField priceField = new JTextField();
   
    private final JTextArea reportArea = new JTextArea(6, 20);

    private final App matressApp = new App(); // logic class

    public AppGUI() {
        super("Estate Agent Report");                   
        setDefaultCloseOperation(EXIT_ON_CLOSE);        

        buildMenu();
        buildForm();

        pack();                                          
        setLocationRelativeTo(null);                   
    }

   
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process Report");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem saveItem = new JMenuItem("Save Report");
        processItem.addActionListener(e -> processReport());
        clearItem.addActionListener(e -> clearForm());
        saveItem.addActionListener(e -> saveReport());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        toolsMenu.add(saveItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    /** Q.2.1 - labels + inputs in a 2-column grid, report area underneath. */
    private void buildForm() {
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns, gaps
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        form.add(new JLabel("MATRESS TYPE:"));       form.add(locationCombo);
        form.add(new JLabel("CUSTOMER NAME:"));    form.add(nameField);
        form.add(new JLabel("MATRESS PRICE:"));       form.add(priceField);
       
        form.add(new JLabel("DATA LOG:"));  // 4th row left cell
        form.add(new JLabel(""));                      // 4th row right cell (filler)

        reportArea.setEditable(false);                 // user must not type in the report
        JScrollPane scroll = new JScrollPane(reportArea);
        scroll.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        setLayout(new BorderLayout());
        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    
    private void processReport() {
     
        Data data = new Data(
                String.valueOf(locationCombo.getSelectedItem()),
                nameField.getText(),
                priceField.getText()
        );
              

      
        if (!matressApp.ValidateData(data)) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a name.",
                    "Invalid input", JOptionPane.ERROR_MESSAGE);
            return;                                   
        }

        double price = Double.parseDouble(data.getProductPrice().trim());
        
        double vat = matressApp.CalculateVAT(data.getProductPrice());
        double comission = matressApp.CalculateComission(data.getProductPrice());
         double total = matressApp.CalculateTotalSale(data.getProductPrice());
        // "\n" starts a new line in the text area
        reportArea.setText(
                "PRODUCT :: " + data.getProduct() + "\n"
              + "CUSTOMER NAME: " + data.getMatressName().trim() + "\n"
              + "CALCULATED VAT: R " + vat
              + "\nCOMMISSION: R " + comission
              + "\nTOTAL: R " + total);
    }

   
    private void saveReport() {
        if (reportArea.getText().isEmpty()) {          // nothing processed yet
            JOptionPane.showMessageDialog(this, "Process a report first.");
            return;
        }
        // try-with-resources closes the writer automatically (even if an error happens)
        try (PrintWriter out = new PrintWriter(new FileWriter("report.txt"))) {
            out.println("ESTATE AGENT REPORT");
            out.println("*".repeat(35));
            out.println(reportArea.getText());
            out.println("*".repeat(35));
            JOptionPane.showMessageDialog(this, "Report saved to report.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   
    private void clearForm() {
        locationCombo.setSelectedIndex(0);
        nameField.setText("");
        priceField.setText("");
      
        reportArea.setText("");
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> new AppGUI().setVisible(true));
    }
}

    

