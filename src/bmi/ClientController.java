package bmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.*;
import java.net.Socket;

public class ClientController {
  @FXML TextField weightText;
  @FXML TextField heightText;
  @FXML Label bmiLabel;
  @FXML Label sumLabel;
  @FXML Label connectLabel;

//BMI System
    public void confirmBtn(ActionEvent actionEvent) throws IOException{
      try {
          Socket s = new Socket("localhost",5161);

          DataOutputStream sent_server =new DataOutputStream(s.getOutputStream());
          sent_server.writeUTF("Connect client");
          sent_server.flush();

          DataInputStream recieve_server = new DataInputStream(s.getInputStream());
          String  str_server=(String)recieve_server.readUTF();
          connectLabel.setText(str_server);

        String weight = weightText.getText();
        String height = heightText.getText();

        float w = Float.parseFloat(weight);
          DataOutputStream weight_server =new DataOutputStream(s.getOutputStream());
          weight_server.writeUTF(weight);
          weight_server.flush();
        float h = Float.parseFloat(height);
          DataOutputStream height_server =new DataOutputStream(s.getOutputStream());
          height_server.writeUTF(height);
          height_server.flush();

          DataInputStream bmi = new DataInputStream(s.getInputStream());
          String  bmi_show=(String)bmi.readUTF();
          bmiLabel.setText(bmi_show);

          DataInputStream sum = new DataInputStream(s.getInputStream());
          String  sum_show=(String)sum.readUTF();
          sumLabel.setText(sum_show);


          s.close();


    }catch(Exception e){System.out.println(e);}
}





    }





