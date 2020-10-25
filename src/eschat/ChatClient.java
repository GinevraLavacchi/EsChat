/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eschat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import javax.swing.JFrame;

/**
 *
 * @author Ginevra
 */
public class ChatClient extends JFrame{
    private List lista;
    public ChatClient()
    {
        super("Chat Client");
        this.setSize(new Dimension(500,300));//setto la grandezza della finestra
        this.setLocationRelativeTo(null);//la metto al centro dello schermo
        this.setEnabled(true);//setto la proprietà enable
        this.setBackground(Color.blue);//setto il colore dello sfondo
        //creo il pannello per l'inserimento dei messaggi
        PannelloChatServer pan=new PannelloChatServer(lista);
        this.getContentPane().add(pan);
        this.setVisible(true);
    }
   
}
