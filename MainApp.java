package com.hpc.narm;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
    
    private static Empolyee who;
    public static Querier q=new Querier();
    private static Stage st;
    private static MainApp instance;
    public static void setWho(Empolyee emp){
        who=emp;
    }
    
    public static MainApp getMain(){
        return instance;
    }
    
    public static Empolyee getWho(){
        return who;
    }

     void changeScene(String scene_name,String where) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource(where));
         Scene scene = new Scene(p);
         scene.getStylesheets().add("/styles/Styles.css");
         st.setTitle("گمرک عقابستان");
         st.setScene(scene);
         st.show();

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        instance=this;
        st=stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("گمرک عقابستان");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
