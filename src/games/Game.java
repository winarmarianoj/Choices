package games;

import list.Lists;
import messages.MessageInformation;
import ui.panels.MainPanel;

import javax.swing.*;
import java.io.*;

public class Game {

    private final Lists lists = new Lists();
    private int score;
    private int noScore;
    private int amountAssert;
    private int amountNoAssert;
    private String correct;
    private int cantAnswers;

    public Game() {}

    /**
     * Funcion que genera Todas las oraciones y las muestra por pantalla
     * @param panel objeto tipo MainPanel
     */
    private void generateSentences(MainPanel panel) {
        panel.setTxtAnswer(generateAnswer());

        int turn = (int) Math.floor(Math.random() * 3);
        if (turn == 0) {
            panel.setOpA(correct);
            panel.setOpB(generateIncorrects());
            panel.setOpC(generateIncorrects());
        }else if (turn == 1) {
            panel.setOpA(generateIncorrects());
            panel.setOpB(correct);
            panel.setOpC(generateIncorrects());
        } else if (turn == 2) {
            panel.setOpA(generateIncorrects());
            panel.setOpB(generateIncorrects());
            panel.setOpC(correct);
        }
        cantAnswers++;
    }

    /**
     * Funcion que inicia el juego y genera las listas
     * como las preguntas, correctas, incorrectas
     * @return String pregunta actual
     * @throws Exception
     */
    public void start(MainPanel panel) throws Exception {
        generateList();
        generateSentences(panel);
    }

    /**
     * Funcion que continua el juego y genera nueva pregunta,
     * correctas e incorrectas
     * @param panel objeto tipo MainPanel
     * @return la pregunta tipo String
     */
    public void continues(MainPanel panel) {
        generateSentences(panel);
    }

    /**
     * Funcion que imprime al finalizar cada juego la estadisticas obtenidas
     */
    public void statistics() {
        new MessageInformation("RESULTS", "STADISTICAS DEL JUEGO: \n" +
                " CANTIDAD DE PREGUNTAS RESPONDIDAS : " + " " + cantAnswers + "\n" +
                " CANTIDAD DE ASIERTOS : " + " " + amountAssert + "\n" +
                " CANTIDAD DE PUNTOS OBTENIDOS : " + " " + score + "\n" +
                " CANTIDAD DE DESASIERTOS : " + " " + amountNoAssert + "\n" +
                " CANTIDAD DE PUNTOS PERDIDOS : " + " " + noScore + "\n" +
                " PUNTUACIÓN TOTAL DE ESTE JUEGO : " + " " + (+score-noScore) + "\n" +
                "\n" +
                " GRACIAS POR JUGAR CON NOSOTROS!!!!!");
    }

    /**
     * Genera un numero entero al azar para la posicion de la oración
     * incorrecta a mostrar en pantalla, en la lista de Incorrectas
     * de la base de datos
     * @return String con la respuesta incorrecta a mostrar
     */
    private String generateIncorrects() {
        int pos = (int) Math.floor(Math.random() * lists.incorrectListSize());
        return lists.searchIncorrect(pos);
    }

    /**
     * Genera un numero entero al azar para la posicion de la pregunta
     * a responder, en la lista de Preguntas de la base de datos
     * @return String con la pregunta a responder
     */
    private String generateAnswer() {
        int pos = (int) Math.floor(Math.random() * lists.answersListSize());
        correct = lists.searchCorrectList(pos);
        return lists.searchAnswersList(pos);
    }

    /**
     * Funcion que lee y genera las listas de Preguntas,
     * Respuestas Correctas e Incorrectas
     * @throws Exception
     */
    private void generateList () throws Exception {
        File fileAnswers = new File("sources/preguntas.bbl");
        BufferedReader readAnswers = new BufferedReader(new FileReader(fileAnswers));

        File fileCorrects = new File("sources/correctas.bbl");
        BufferedReader readCorrects = new BufferedReader(new FileReader(fileCorrects));

        File fileIncorrects = new File("sources/incorrectas.bbl");
        BufferedReader readIncorrects = new BufferedReader(new FileReader(fileIncorrects));

        String answers;
        int i=1;
        while ((answers = readAnswers.readLine()) != null) {
            lists.addAnswersList(i,answers);
            i++;
        }

        String corrects;
        int j=1;
        while ((corrects = readCorrects.readLine()) != null) {
            lists.addCorrectList(j,corrects);
            j++;
        }

        String incorrects;
        while ((incorrects = readIncorrects.readLine()) != null) {
            lists.addIncorrectList(incorrects);
        }
        readAnswers.close();
        readCorrects.close();
        readIncorrects.close();
    }

    /**
     * Funcion que a medida de los intentos fallidos va imprimiendo
     * por pantalla la imagen relacionada al numero de intento fallido
     * @param intentFailed Numero entero del contador de intentos fallidos
     * @return La imagen tipo jpg a mostrar por pantalla
     */
    private ImageIcon searchImageIcon(int intentFailed) {
        ImageIcon imageIcon = new ImageIcon();
        switch (intentFailed){
            case 1:
                imageIcon = new ImageIcon("sources/ok.jpg");
                break;
            case 2:
                imageIcon = new ImageIcon("sources/error.jpg");
                break;
        }
        return imageIcon;
    }

    /**
     * Funcion que imprime la imagen de No asierto en la opcion seleccionada
     * ademas suma puntos a errores y palabras no acertadas
     * @param panel objeto tipo MainPanel
     */
    private void no(MainPanel panel) {
        panel.setResultado(searchImageIcon(2));
        noScore+=10;
        amountNoAssert++;
        panel.setTxtScore(String.valueOf(score-noScore));
    }

    /**
     * Funcion que imprime la imagen de Asierto en la opcion seleccionada
     * Ademas suma puntos y cantidad de aciertos
     * @param panel objeto MainPanel
     */
    private void yes(MainPanel panel) {
        panel.setResultado(searchImageIcon(1));
        score+=10;
        amountAssert++;
        panel.setTxtScore(String.valueOf(score-noScore));
    }

    /**
     * Funcion que supervisa si con la opcion seleccionada es igual o no
     * a la respuesta correcta de cada pregunta
     * @param option Letra con la seleccion de cada boton
     * @param panel objeto MainPanel
     */
    public void isCorrect(char option, MainPanel panel) {
        switch (option){
            case 'a':
                  if (correct.equals(panel.getOpA().getText())) { yes(panel);} else { no(panel);}
                break;
            case 'b':
                if (correct.equals(panel.getOpB().getText())) { yes(panel);} else { no(panel);}
                break;
            case 'c':
                if (correct.equals(panel.getOpC().getText())) { yes(panel);} else { no(panel);}
                break;
        }
    }

}
