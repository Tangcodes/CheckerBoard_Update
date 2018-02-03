/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Jingxuan Tang
 */

public class checkerboardFXMLController implements Initializable {
    
    private Checkerboard checkerboard;
    private Stage stage;
    
    @FXML
    private VBox root;
    
    @FXML
    private AnchorPane board;
    
    @FXML
    private MenuBar menuBar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void start(Stage stage){
        this.stage = stage;
        refreshBoard(8, 8, Color.RED, Color.BLACK);
        
        this.stage.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refreshBoard(checkerboard.getNumRows(), checkerboard.getNumCols(), checkerboard.getLightColor(), checkerboard.getDarkColor());
        });
        
        this.stage.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refreshBoard(checkerboard.getNumRows(), checkerboard.getNumCols(), checkerboard.getLightColor(), checkerboard.getDarkColor());
        });
    }
    
    private void clearBoard(){
        board.getChildren().clear();
    }
    
    private void refreshBoard(int rowNums, int colNums){
        refreshBoard(rowNums, colNums, checkerboard.getLightColor(), checkerboard.getDarkColor());
    }
    
    private void refreshBoard(Color lightColor, Color darkColor){
        refreshBoard(checkerboard.getNumRows(), checkerboard.getNumCols(), lightColor, darkColor);
    }
    
    private void refreshBoard(int rowNums, int colNums, Color lightColor, Color darkColor){
        clearBoard();
        checkerboard = new Checkerboard(rowNums, colNums, root.getWidth(), root.getHeight() - menuBar.getHeight(), lightColor, darkColor);
        checkerboard.build(board);
    }
    
    @FXML
    private void GridSixteen(){
        refreshBoard(16, 16);
    }
    
    @FXML
    private void GridTen(){
        refreshBoard(10, 10);
    }
    
    @FXML
    private void GridEight(){
        refreshBoard(8, 8);
    }
    
    @FXML
    private void GridThree(){
        refreshBoard(3, 3);
    }
    
    @FXML
    private void changeToDefault(){
        refreshBoard(Color.RED, Color.BLACK);
    }
    
    @FXML
    private void changeToBlue(){
        refreshBoard(Color.SKYBLUE, Color.DARKBLUE);
    }
}
