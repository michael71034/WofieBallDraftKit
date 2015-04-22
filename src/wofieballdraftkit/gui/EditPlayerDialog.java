/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wofieballdraftkit.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import wofieballdraftkit.data.Player;
import static wofieballdraftkit.gui.WBDK_GUI.CLASS_HEADING_LABEL;
import static wofieballdraftkit.gui.WBDK_GUI.PRIMARY_STYLE_SHEET;

/**
 *
 * @author MiChAeL
 */
public class EditPlayerDialog extends Stage{
     // THIS IS THE OBJECT DATA BEHIND THIS UI
    Player player;
    
    // GUI CONTROLS FOR OUR DIALOG
    GridPane gridPane;
    Scene dialogScene;
    Label headingLabel;
    Label playerLabel;
    Label fantasyTeamLabel;
    Label positionLabel;
    Label contractLabel;
    Label salaryLabel;
    
    
    ComboBox fantasyTeamComboBox;
    ComboBox positionComboBox;
    ComboBox contractComboBox;
    TextField salaryTextField;
    Button completeButton;
    Button cancelButton;
    
    // THIS IS FOR KEEPING TRACK OF WHICH BUTTON THE USER PRESSED
    String selection;
    
    // CONSTANTS FOR OUR UI
    public static final String COMPLETE = "Complete";
    public static final String CANCEL = "Cancel";
    public static final String FANTASY_PROMPT = "Fantasy Team: ";
    public static final String POSITION_PROMPT = "Position: ";
    public static final String CONTRACT_PROMPT = "Contract: ";
    public static final String SALARY_PROMPT = "Salary($): ";
    public static final String PLAYER_HEADING = "Player Details";

    public static final String EDIT_PLAYER_TITLE = "Edit Player";
    /**
     * Initializes this dialog so that it can be used for either adding
     * new schedule items or editing existing ones.
     * 
     * @param primaryStage The owner of this modal dialog.
     */
    public EditPlayerDialog(Stage primaryStage) {
        // FIRST MAKE OUR LECTURE AND INITIALIZE
        // IT WITH DEFAULT VALUES
        player = new Player();
        setTitle(EDIT_PLAYER_TITLE);
        // MAKE THIS DIALOG MODAL, MEANING OTHERS WILL WAIT
        // FOR IT WHEN IT IS DISPLAYED
        initModality(Modality.WINDOW_MODAL);
        initOwner(primaryStage);
        
        // FIRST OUR CONTAINER
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        // PUT THE HEADING IN THE GRID, NOTE THAT THE TEXT WILL DEPEND
        // ON WHETHER WE'RE ADDING OR EDITING
        headingLabel = new Label(PLAYER_HEADING);
        headingLabel.getStyleClass().add(CLASS_HEADING_LABEL);
    
        // NOW THE TOPIC 
        fantasyTeamLabel = new Label(FANTASY_PROMPT);
        fantasyTeamComboBox = new ComboBox();
        
        positionLabel = new Label(POSITION_PROMPT);
        positionComboBox = new ComboBox();
        
        contractLabel = new Label(CONTRACT_PROMPT);
        contractComboBox = new ComboBox();
        contractComboBox.getItems().addAll("S2","S1","X");
        salaryLabel = new Label(SALARY_PROMPT);
        salaryTextField = new TextField();        
        
      
        

        
        // AND THE NUMBER OF SESSIONS

//      sessionsComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                int numSessions = Integer.parseInt(newValue.toString());
//                lecture.setSessions(numSessions);
//            }
//            
//        });

        // AND FINALLY, THE BUTTONS
        completeButton = new Button(COMPLETE);
        cancelButton = new Button(CANCEL);
        
        // REGISTER EVENT HANDLERS FOR OUR BUTTONS
        EventHandler completeCancelHandler = (EventHandler<ActionEvent>) (ActionEvent ae) -> {
            Button sourceButton = (Button)ae.getSource();
            EditPlayerDialog.this.selection = sourceButton.getText();
            EditPlayerDialog.this.hide();
        };
        completeButton.setOnAction(completeCancelHandler);
        cancelButton.setOnAction(completeCancelHandler);

        // NOW LET'S ARRANGE THEM ALL AT ONCE
        gridPane.add(headingLabel,      0, 0, 2, 1);
        gridPane.add(fantasyTeamLabel,        0, 2, 1, 1);
        gridPane.add(fantasyTeamComboBox,    1, 2, 1, 1);
        gridPane.add(positionLabel,     0, 3, 1, 1);
        gridPane.add(positionComboBox,  1, 3, 1, 1);
        gridPane.add(contractLabel,     0, 4, 1, 1);
        gridPane.add(contractComboBox,  1, 4, 1, 1);
        gridPane.add(salaryLabel,     0, 5, 1, 1);
        gridPane.add(salaryTextField,  1, 5, 1, 1);        
        gridPane.add(completeButton,    1, 6, 1, 1);
        gridPane.add(cancelButton,      2, 6, 1, 1);

        // AND PUT THE GRID PANE IN THE WINDOW
        dialogScene = new Scene(gridPane);
        dialogScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        this.setScene(dialogScene);
    }
    
    /**
     * Accessor method for getting the selection the user made.
     * 
     * @return Either YES, NO, or CANCEL, depending on which
     * button the user selected when this dialog was presented.
     */
    public String getSelection() {
        return selection;
    }
    
    public Player getLecture() { 
        return player;
    }
    
    /**
     * This method loads a custom message into the label and
     * then pops open the dialog.
     * 
     * @param message Message to appear inside the dialog.
     */

    
    public void loadGUIData() {
        // LOAD THE UI STUFF
//        topicTextField.setText(lecture.getTopic());
//        
//        int sessionsIndex = lecture.getSessions()-1;
//        sessionsComboBox.getSelectionModel().select(sessionsIndex);
    }
    
    public boolean wasCompleteSelected() {
        return selection.equals(COMPLETE);
    }
    
    public void showEditPlayerDialog(Player player) {
        // SET THE DIALOG TITLE
        setTitle(EDIT_PLAYER_TITLE);
        
        // LOAD THE LECTURE INTO OUR LOCAL OBJECT
    
        
        // AND THEN INTO OUR GUI
        loadGUIData();
               
        // AND OPEN IT UP
        this.showAndWait();
    }
}
