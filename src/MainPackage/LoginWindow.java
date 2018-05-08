package MainPackage;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/*


Tom, the code to make the login work will have to be merged into the Login.java class to build via the GUI. It 
    should have the "Design" tab in the window

- Luke 

*/





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thom
 */
public class LoginWindow {
    
    public static GridPane login(Connection con){
        
        //text, textfields, buttons
        
        Text logo = new Text("");
        
        //prompts
        Text usernamePrompt = new Text("Username: ");   
        Text passwordPrompt = new Text("Password: ");
        
        //text Fields
        TextField userName = new TextField ();
        userName.setPromptText("Username");
        userName.setPrefColumnCount(15);
        
        PasswordField passWord = new PasswordField ();
        passWord.setPromptText("Password");
        passWord.setPrefColumnCount(15);
        
        //buttons
        Button loginBtn = new Button();
        loginBtn.setText("Login");
        
        Button ShutdownBtn = new Button();
        ShutdownBtn.setText("Shutdown");
        ShutdownBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
           
                if(con != null){
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.exit(0);
               
            }
        });
        
        GridPane root = new GridPane();
        //root.setGridLinesVisible(true);
        root.setVgap(5); 
        root.setHgap(5);  
        root.setPadding(new Insets(30, 30, 30, 30));
        root.setAlignment(Pos.CENTER);
        Color color = Color.rgb(0, 0, 50, 0.50);
        BackgroundFill fill = new BackgroundFill(color, CornerRadii.EMPTY,
                Insets.EMPTY);
        Background background = new Background(fill);
        root.setBackground(background);
        root.setBorder(new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        
        //add elements to gridpane and return
        //root.add(logo, 0, 0);
        root.add(usernamePrompt, 0, 0);
        root.add(userName, 1, 0);
        root.add(passwordPrompt, 0, 1);
        root.add(passWord, 1, 1);
        root.add(loginBtn, 1, 2);
        root.add(ShutdownBtn, 2, 3);
        return root;
    }
}


