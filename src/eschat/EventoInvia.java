/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eschat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Ginevra
 */
public class EventoInvia implements ActionListener
{
     ThreadGestioneChat gestioneServizio;
        JTextField textnuovo;
    /**
     * costruttore con parametri
     * @param num l'elenco del numero di partecipanti
     */
     public EventoInvia(ThreadGestioneChat g,JTextField t)
     {
         gestioneServizio=g;
         textnuovo=t;
     }

    @Override
    public void actionPerformed(ActionEvent e) {
            String bottone=e.getActionCommand();
            if(bottone.equals("Invia"))
            {
                gestioneServizio.spedisciMessaggio(textnuovo.getText());
                textnuovo.setText("");
            }
        }
}
