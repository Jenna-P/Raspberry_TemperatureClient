package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientTemp extends Application {
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPane = new BorderPane();
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));

        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            Socket socket = new Socket("10.200.130.36", 1980);

            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());

            System.out.println("Output from server: " + fromServer);
        } catch (
                IOException ex){
            System.out.println("ERROR!!");
            ta.appendText(ex.toString() + '\n');
        }

        try {
            String result = fromServer.readUTF();
            System.out.println("Result is: " + result);
            ta.appendText(result + "\n");
        } catch (IOException ex) {
            System.out.println("Error2!!");
            ex.printStackTrace();
        }
    }
}