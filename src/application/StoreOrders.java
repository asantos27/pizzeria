package application;

import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class keeps the list of orders placed by the user
 * @author Daniel Flts, Alyssa Santos
 */
public class StoreOrders implements Customizable {

    public ArrayList<Order> storeOrderList = new ArrayList<Order>();

    /**
     * Method to add order
     * @param order to add
     * @return true if added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        Order order = (Order) obj;
        this.storeOrderList.add(order);
        return true;
    }

    /**
     * Method to remove order
     * @param order to remove
     * @return true if removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if (storeOrderList.size() <= 0) {
            return false;
        }

        Order order = (Order) obj;
        storeOrderList.remove(order);
        return true;
    }

    /**
     * Method to save store orders to an external file
     * @return
     */
    public boolean export() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file
        DecimalFormat df = new DecimalFormat("###,##0.00");
        String path = targetFile.getAbsolutePath();

        if (targetFile == null || path == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid file/path");
            alert.showAndWait();
            return false;
        }
        try {
            FileWriter myWriter = new FileWriter(path);
            if (storeOrderList.size() == 0) {
                myWriter.write("No orders available");
                myWriter.close();
                return false;
            }
            for (Order o: storeOrderList) {
                myWriter.write("Customer phone number: " + String.valueOf(o) + "\n");
                myWriter.write("Order:" + String.valueOf(o.getOrderList()) + "\n");
                myWriter.write("Order total: $" + df.format(o.getOrderTotal()) + "\n");
            }
            myWriter.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("File has been exported!");
            alert.showAndWait();
        } catch (IOException e) {
        }
        return true;
    }

}
