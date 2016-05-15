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
    private Object current;
    public static void setWho(Empolyee emp){
        who=emp;
    }
    
    //public void set_current(Object o){
    //    current=o;
    //}
    
    public Object get_current(){
        return current;
    }
    
    public static MainApp getMain(){
        return instance;
    }
    
    public static Empolyee getWho(){
        return who;
    }

     void changeScene(String where) throws IOException {
        if ("karshenas".equals(where)){
            current=new Ezharname();
            Parent kareshenas = FXMLLoader.load(getClass().getResource("/fxml/ezharname.fxml"));
            Scene scene = new Scene(kareshenas);
            scene.getStylesheets().add("/styles/Styles.css");
            st.setTitle("گمرک مرکزی هرات،جمهوری افغانستان");
            st.setScene(scene);
            st.show();
        }    
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        instance=this;
        st=stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("گمرک مرکزی اوغانستان-هرات");
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
