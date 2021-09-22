package com.example.demotemp;

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
import java.util.Arrays;

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
            System.out.println("Server is running...");
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            byte[] resultarray = fromServer.readAllBytes();

            byte[] temp = new byte[] {resultarray[0], resultarray[1]};
            byte[] humi = new byte[] {resultarray[2], resultarray[3]};

            System.out.println(Arrays.toString(resultarray));

            String str1 = new String(temp);
            String str2 = new String(humi);
            double tempDouble = Double.parseDouble(str1);
            double humiDouble = Double.parseDouble(str2);

            System.out.println("Temp : " + tempDouble);
            System.out.println("Humi : " + humiDouble);


        } catch (IOException ex) {
            System.out.println("ERROR!!");
            //         ta.appendText(ex.toString() + '\n');
        }
    }
}
