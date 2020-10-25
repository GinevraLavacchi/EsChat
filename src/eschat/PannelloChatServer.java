/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eschat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ginevra
 */
 public class PannelloChatServer extends JPanel
    {
        ThreadGestioneChat gestioneServizio;
        JTextField textnuovo;
        List lista;
        public PannelloChatServer(List l)
        {
            super();
            lista=l;
            this.setBackground(new Color(50,100,255));
            //pannello superiore:lista messaggi
            JPanel panLista=new JPanel(new BorderLayout(20,50));
            panLista.setBackground(new Color(50,100,255));
            lista=new List();
            lista.setBackground(Color.lightGray);
            lista.setSize(100, 50);
            lista.setVisible(true);
            panLista.add(lista);
            //pannello inferiore inseriemento messaggio
            JPanel nuovoMex= new JPanel(new BorderLayout(20,5));
            nuovoMex.setBackground(new Color(50,100,255));
            JLabel labNuovo=new JLabel("Nuovo Messaggio--> ",JLabel.CENTER);
            labNuovo.setForeground(new Color(255,255,0));
            textnuovo = new JTextField("");
            JButton bottoneInvia= new JButton("Invia");
            EventoInvia e=new EventoInvia(gestioneServizio,textnuovo);
            bottoneInvia.addActionListener(e);
            nuovoMex.add(labNuovo,BorderLayout.WEST);
            nuovoMex.add(textnuovo, BorderLayout.CENTER);
            nuovoMex.add(bottoneInvia, BorderLayout.EAST);
            this.setLayout(new BorderLayout(0,5));
            add(panLista,BorderLayout.CENTER);
            add(nuovoMex,BorderLayout.SOUTH);
            connetti();
        }
        public void connetti()
        {
            gestioneServizio = new ThreadGestioneChat(10,lista);
        }
        /*public void ActionPerformed(ActionEvent e)
        {
            String bottone=e.getActionCommand();
            if(bottone.equals("Invia"))
            {
                gestioneServizio.spedisciMessaggio(textnuovo.getText());
                textnuovo.setText("");
            }
        }*/
    }
