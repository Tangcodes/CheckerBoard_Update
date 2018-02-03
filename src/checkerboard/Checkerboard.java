/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Jingxuan Tang
 */
public class Checkerboard extends Application {
    
    private AnchorPane board;
    private final int rowNums;
    private final int colNums;
    private final double boardWidth;
    private final double boardHeight;
    private final double rectWidth;
    private final double rectHeight;
    private final Color lightColor;
    private final Color darkColor;
    

    public Checkerboard(int rowNums, int colNums, double boardWidth, double boardHeight){
        this(rowNums, colNums, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public Checkerboard(int rowNums, int colNums, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.rowNums = rowNums;
        this.colNums = colNums;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        this.rectWidth = Math.ceil(boardWidth / colNums);
        this.rectHeight = Math.ceil(boardHeight / rowNums);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("checkerboardFXML.fxml"));
        Parent root = (Parent)loader.load();
        checkerboardFXMLController boardController = loader.getController();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        System.out.println("CheckerBoard(The default is 8x8)");
        boardController.start(stage);    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Dynamically add rectangles to an existing AnchorPane
     * @param board
     * @return AnchorPane
     */
    public AnchorPane build(AnchorPane board){
        for(int row = 0; row < rowNums; row++){
            for(int col = 0; col < colNums; col++){
                Color color = (row + col)%2 == 0? lightColor : darkColor;
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                
                board.getChildren().add(rect);
                AnchorPane.setLeftAnchor(rect, rectWidth * col);
                AnchorPane.setTopAnchor(rect, rectHeight * row);
            }
        }
        this.board = board;
        return board;
    }
    
    /**
     * Build a brand new AnchorPane.
     * @return AnchorPane
     */
    public AnchorPane build(){
        
        board = new AnchorPane();
        for(int row = 0; row < rowNums; row++){
            for(int col = 0; col < colNums; col++){
                Color color = (row + col)%2 == 0? lightColor : darkColor;
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                
                board.getChildren().add(rect);
                AnchorPane.setLeftAnchor(rect, rectWidth * col);
                AnchorPane.setTopAnchor(rect, rectHeight * row);
            }
        }
        return board;
    }
    
    
    public Checkerboard(){
        this(8,8,600.0,600.0);
    }
    
    public int getNumRows(){
        return rowNums;
    }
    
    public int getNumCols(){
        return colNums;
    }
    
    public double getWidth(){
        return boardWidth;
    }
    
    public double getHeight(){
        return boardHeight;
    }
    
    public double getRectWidth(){
        return rectWidth;
    }
    
    public double getRectHeight(){
        return rectHeight;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
    
    public AnchorPane getBoard(){
        return board;
    }
}
