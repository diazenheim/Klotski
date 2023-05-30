package com.klotski.klotski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class PieceController {

    public Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    public Button[] butt = new Button[10];
    @FXML
    private Button btn = null;
    @FXML
    private Text Count;
    private double x;
    private double y;
    private int counter;

    //refresh allow uor variable x and y to start with the right starting X and Y of the button
    public void refresh(){
        x = btn.getLayoutX();
        y= btn.getLayoutY();
        butt[0] = btn0;
        butt[1] = btn1;
        butt[2] = btn2;
        butt[3] = btn3;
        butt[4] = btn4;
        butt[5] = btn5;
        butt[6] = btn6;
        butt[7] = btn7;
        butt[8] = btn8;
        butt[9] = btn9;
    }
    public void select(ActionEvent e) {
        if(btn != null) {
            btn.setStyle(null);
        }

        Button generic = (Button) e.getSource();
        btn = generic;
        refresh();
        if(btn == btn0){
            btn0.setStyle("-fx-background-color: RED");
        }
        else {
            btn.setStyle("-fx-background-color: BLUE");
        }
    }

    // all the movement are controlled by increasing or decreasing (by 100) of the variable X and Y.The Y axis is inverted
    public void MoveRight(ActionEvent e) {
        if(btn == null){
            return;
        }
        for (int i =0; i < 10;i++ ){
            if(butt[i].getLayoutX() == (btn.getLayoutX())+btn.getWidth()) {
                if( (btn.getLayoutY() == butt[i].getLayoutY())|| ((butt[i].getLayoutY()+butt[i].getHeight())-100 == btn.getLayoutY())){
                    return;
                }
            }
        }
        if(btn.getLayoutX() != (400-btn.getWidth())) {
            btn.setLayoutX(x += 100);
        }
        else {return;}
        counter +=1;
        Count.setText("Counter: " + counter );
    }
    public void MoveLeft(ActionEvent e) {
        if(btn == null) {
            return;
        }
        for (int i =0; i < 10;i++ ){

            if(btn.getLayoutX() == (butt[i].getLayoutX()+butt[i].getWidth()) ) {

                if((butt[i].getLayoutY() == btn.getLayoutY()) || ((butt[i].getLayoutY()+butt[i].getHeight())-100 == btn.getLayoutY())) {
                    return;
                }

            }
        }

        if(btn.getLayoutX() != 0){
            btn.setLayoutX(x -= 100);
        }
        else return;
        counter +=1;
        Count.setText("Counter: " + counter );
    }
    public void MoveUp(ActionEvent e) {
        if(btn == null){
            return;
        }

        for (int i =0; i < 10;i++ ){

            if(btn.getLayoutY() == (butt[i].getLayoutY()+butt[i].getHeight()) ) {

                if((butt[i].getLayoutX() == btn.getLayoutX()) || ((butt[i].getLayoutX()+butt[i].getWidth()-100) == btn.getLayoutX())) {
                    return;
                }

            }
        }
        if(btn.getLayoutY() != 0) {
            btn.setLayoutY(y -= 100);
        }
        else return;
        counter +=1;
        Count.setText("Counter: " + counter );
    }
    public void MoveDown(ActionEvent e) {
        if(btn == null){
            return;
        }

        for (int i =0; i < 10;i++ ){
            if(butt[i].getLayoutY() == (btn.getLayoutY())+btn.getHeight()) {
                if(butt[i].getLayoutX() == btn.getLayoutX()|| (btn.getLayoutX()+btn.getWidth()-100) == butt[i].getLayoutX()){
                    return;
                }
            }
        }
        if(btn.getLayoutY() != (500-btn.getHeight())) {
            btn.setLayoutY(y += 100);
        }
        else return;
        counter +=1;
        Count.setText("Counter: " + counter );
    }
    public void Save(ActionEvent e) {
    }

    public void LoadSave(ActionEvent e) {
    }

    public void BestMove(ActionEvent e) {
    }

    public void Quit(ActionEvent e) {
    }

    public void Back(ActionEvent e) {
    }
}