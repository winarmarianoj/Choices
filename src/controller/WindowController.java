package controller;

import clock.Clock;
import games.Game;
import messages.MessageError;
import messages.MessageInformation;
import ui.Window;
import ui.panels.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static ui.panels.MainPanel.*;

public class WindowController extends Controller{

    private static final int MAX_SECONDS = 10;

    private final Window window;
    private final Game game;
    private String jugador;

    public WindowController(Window window) {
        super(window);
        this.window = window;
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        this.window.getPanel();
        game = new Game();
    }

    /**
     * Funcion que toma la accion de cada boton por letra
     * @param actionEvent El evento del boton presionado
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MainPanel panel = (MainPanel) window.getPanel();
        Clock clock = new Clock(panel);

        switch (actionEvent.getActionCommand()){
            case A:
                go(clock, 'a',panel);
                break;
            case B:
                go(clock, 'b',panel);
                break;
            case C:
                go(clock,'c',panel);
                break;
            case START:
                jugador = JOptionPane.showInputDialog(null, "INGRESE SU NOMBRE COMO JUGADOR", "DATOS DEL JUGADOR", JOptionPane.QUESTION_MESSAGE);
                new MessageInformation("WELCOME ", "WELCOME " + " " + jugador);
                panel.setNamePlayer(jugador);
                clock.start();
                try {
                    game.start(panel);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
            case CONTINUE:
                printClear(panel);
                clock.start();
                panel.setResultado(new ImageIcon("sources/continua.jpg"));
                try {
                    game.continues(panel);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
            case FINALIZE:
                printClear(panel);
                game.statistics();
                break;
            case EXIT:
                new MessageInformation("GAME OVER", "THANK YOU " + " " + jugador + " " + "FOR PLAYING WITH OUR");
                System.exit(0);
                break;
        }
    }

    /**
     * Funcion que inicia la operacion por cada opcion seleccionada
     * @param clock temporizador
     * @param letra opcion elegida
     * @param panel objeto tipo MainPanel
     */
    private void go(Clock clock, char letra, MainPanel panel) {
        if (clock.getSeconds() <= MAX_SECONDS) {
            game.isCorrect(letra,panel);
            printClear(panel);
        } else {
            new MessageError("TIMER", "TIME IS OVER");
            new MessageInformation("TIMER", "PRESIONE NUEVAMENTE CONTINUE PARA SEGUIR");
        }
    }

    /**
     * Funcion que deja en blanco los campos Letras Utilizadas y Acertadas
     * @param panel tipo de dato del MainPanel de Panel
     */
    private void printClear(MainPanel panel) {
        panel.setTxtAnswer(" ");
        panel.setOpA(" ");
        panel.setOpB(" ");
        panel.setOpC(" ");
    }

}
