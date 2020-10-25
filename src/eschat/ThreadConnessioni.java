/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eschat;

import java.awt.Color;
import java.awt.Dimension;
import java.io.*;
import java.net.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ginevra
 */
public class ThreadConnessioni implements Runnable{
    private ThreadGestioneChat gestoreChat;
    private Socket client=null;
    private BufferedReader input=null;
    private PrintWriter output=null;
    Thread me;
    
    public ThreadConnessioni(ThreadGestioneChat g,Socket c)
    {
        gestoreChat=g;
        client=c;
        try
        {
            input=new BufferedReader(new InputStreamReader(client.getInputStream()));
            output=new PrintWriter(this.client.getOutputStream(),true);
            
        }
        catch(Exception e)
        {
            output.println("Errore nella lettura");
        }
        me=new Thread(this);
        me.start();
    }

    @Override
    public void run() 
    {
        while(true)
        {
            try
            {
                String mex=null;
                //rimango in attesa dei messaggi mandati dal client
                while((mex=input.readLine())==null)
                {}
                //invoco il metodo del gestoreChat per ripetere a tutti i messaggio ricevuto
                gestoreChat.spedisciMessaggio(mex);
            }
            catch(Exception e)
            {
                output.println("Errore nella spedizione del messaggio a tutti");
            }
        }
    }
    public void inviaMess(String mess)
    {
        try
        {
            output.println(mess);
        }
        catch(Exception e)
        {
            output.println("Errore nella spedizione del singolo messaggio");
        }
    }
    public class ThreadClient implements Runnable
    {
        private List lista;
        Thread me;
        private Socket client;
        private BufferedReader input=null;
        private PrintWriter output=null;

        public ThreadClient(List l, String ipServer, int porta)
        {
            lista=l;
            try
            {
                client=new Socket(ipServer,porta);
                input=new BufferedReader(new InputStreamReader(client.getInputStream()));
                output= new PrintWriter(new PrintWriter(client.getOutputStream(),true));

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "impossibile connettersi al server");
            }
            me= new Thread(this);
            me.start();
        }
        @Override
        public void run() {
            while(true)
            {
                try
                {
                    String mex=null;
                    //rimango in attesa dei messaggi mandati dal client
                    while((mex=input.readLine())==null)
                    {}
                    //invoco il metodo del getsoreChat per ripetere a tutti il messaggio ricevuto
                    gestoreChat.spedisciMessaggio(mex);
                }
                catch(Exception e)
                {
                    output.println("Errore nella spedizione del messaggio a tutti");
                }
            }
        }
        public void spedisciMessagggioChat(String messaggio)
        {
            try
            {
                output.println(messaggio);
            }
            catch(Exception e)
            {
                
            }
        }
    }
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ginevra
 */


}

