/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eschat;

import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ginevra
 */
public class ThreadGestioneChat implements Runnable
{
    private int maxcon; //numero massimo di connessioni
    private List lista;
    private ThreadConnessioni[] listacon;
    Thread me;
    private ServerSocket serverChat;
    
    public ThreadGestioneChat(int n,List l)
    {
        maxcon=n;
        lista=l;
        listacon= new ThreadConnessioni[maxcon];
        me=new Thread(this);
        me.start();
    }
    @Override
    public void run() 
    {
        boolean continua= true;
        //instanzio la connessine
        try
        {
            serverChat =new ServerSocket(1234);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Impossibile instanziare il server");
            continua=false;
        }
        if(continua)//se è vero accetto le connessioni
        {
            try
            {
                for(int i=0;i<maxcon;i++)
                {
                    Socket tempo=null;
                    tempo= serverChat.accept();
                    listacon[i]= new ThreadConnessioni(this,tempo);
                }
                serverChat.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Impossibile instanziare server chat");
            }
        }
    }
    public void spedisciMessaggio(String mex)
    {
        lista.add(mex);
        lista.select(lista.getItemCount()-1);
        //mando i mess
        for(int i=0; i<this.maxcon;i++)
        {
            if(listacon[i]!=null)
            {
                listacon[i].inviaMess(mex);
            }
        }
    }
 
}
