package messages;

import javax.swing.*;

public class MessageError {

    public MessageError(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }}
