/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superfatorial;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class InputException extends Exception {
    private static final String VAR_NEGATIVA = "Numero negativo";
    /**
     * Creates a new instance of <code>InputException</code> without detail
     * message.
     */
    public InputException() {
        super(VAR_NEGATIVA);
        Component rootPane = null;
        JOptionPane.showMessageDialog(rootPane, VAR_NEGATIVA, "ERRO", JOptionPane.ERROR_MESSAGE, null);
    }

    /**
     * Constructs an instance of <code>InputException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    
    public InputException(String msg) {
        super(msg);
        Component rootPane = null;
        JOptionPane.showMessageDialog(rootPane, msg, "ERRO", JOptionPane.ERROR_MESSAGE, null);
    }
}
