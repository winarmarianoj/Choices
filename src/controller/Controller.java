package controller;

import ui.Window;

import java.awt.event.ActionListener;

public abstract class Controller implements ActionListener {
    /**
     * Funcion del Controlador implementa las Acciones en los botones
     * @param window Tipo de dato Window de JFrame
     */
    public Controller(Window window){window.setController(this);}
}
