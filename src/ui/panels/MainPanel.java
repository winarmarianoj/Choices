package ui.panels;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static ui.Window.BG;

public class MainPanel extends Panel{

    public static final int PANEL_WIDTH = 1800;
    public static final int PANEL_HEIGHT = 650;
    public static final int MARGIN = 20;
    public static final int MARGIN_Y = 80;

    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    public static final String START = "START";
    public static final String CONTINUE = "CONTINUE";
    public static final String FINALIZE = "FINALIZE";
    public static final String EXIT = "QUIT";

    private final int BUTTON_WIDTH_WORDS = 50;
    private final int BUTTON_HEIGHT_WORDS = 50;

    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 60;

    private final int JLABEL_WIDTH = 350;
    private final int JLABEL_HEIGHT = 350;

    private final int JTEXTFIELD_WORD_HEIGHT = 50;
    private final int JTEXTFIELD_WORD_WIDTH = 1250;
    private final int JTEXTNAME_WIDTH = 400;

    private final int JLABEL_TITLE_WIDTH = 200;
    private final int JLABEL_TITLE_HEIGHT = 40;

    private final int JLABEL_SCORE_WIDTH = 150;
    private final int JLABEL_SCORE_HEIGHT = 30;
    private final int JTEXTFIELD_SCORE_WIDTH = 120;
    private final int JTEXTFIELD_SCORE_HEIGHT = 60;
    private final int JTEXTFIELD_CLOCK_WIDTH = 120;
    private final int JTEXTFIELD_CLOCK_HEIGHT = 110;

    private JButton btnA;
    private JButton btnB;
    private JButton btnC;
    private JButton btnSTART;
    private JButton btnCONTINUE;
    private JButton btnFINALIZE;
    private JButton btnQUIT;

    private JLabel resultado;
    private JTextField namePlayer;
    private JTextField txtScore;
    private JTextField txtClock;
    private JTextField txtAnswer;
    private JTextField opA;
    private JTextField opB;
    private JTextField opC;

    private int buttonCounter;
    private int textCounter;

    public MainPanel(){super();}

    /**
     * Funcion que inicia los componentes del Panel
     */
    @Override
    protected void init() {

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(BG);

        btnA = new JButton(A);
        btnA.setActionCommand(A);
        btnA.setFont(new Font("Arial", Font.BOLD,18));
        btnA.setForeground(Color.white);
        btnA.setSize(BUTTON_WIDTH_WORDS, BUTTON_HEIGHT_WORDS);
        btnA.setLocation( nextButtonLocation() );
        btnA.setFocusable(false);
        btnA.setBackground(Color.blue);
        add(btnA);

        btnB = new JButton(B);
        btnB.setActionCommand(B);
        btnB.setFont(new Font("Arial", Font.BOLD,18));
        btnB.setForeground(Color.white);
        btnB.setSize(BUTTON_WIDTH_WORDS, BUTTON_HEIGHT_WORDS);
        btnB.setLocation( nextButtonLocation() );
        btnB.setFocusable(false);
        btnB.setBackground(Color.blue);
        add(btnB);

        btnC = new JButton(C);
        btnC.setActionCommand(C);
        btnC.setFont(new Font("Arial", Font.BOLD,18));
        btnC.setForeground(Color.white);
        btnC.setSize(BUTTON_WIDTH_WORDS, BUTTON_HEIGHT_WORDS);
        btnC.setLocation( nextButtonLocation() );
        btnC.setFocusable(false);
        btnC.setBackground(Color.blue);
        add(btnC);

        btnSTART = new JButton(START);
        btnSTART.setActionCommand(START);
        btnSTART.setFont(new Font("Arial", Font.BOLD,22));
        btnSTART.setForeground(Color.yellow);
        btnSTART.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnSTART.setLocation( MARGIN, PANEL_HEIGHT - MARGIN - MARGIN_Y );
        btnSTART.setFocusable(false);
        btnSTART.setBackground(Color.black);
        add(btnSTART);

        btnCONTINUE = new JButton(CONTINUE);
        btnCONTINUE.setActionCommand(CONTINUE);
        btnCONTINUE.setFont(new Font("Arial", Font.BOLD,22));
        btnCONTINUE.setForeground(Color.yellow);
        btnCONTINUE.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnCONTINUE.setLocation( MARGIN + 200, PANEL_HEIGHT - MARGIN - MARGIN_Y );
        btnCONTINUE.setFocusable(false);
        btnCONTINUE.setBackground(Color.black);
        add(btnCONTINUE);

        btnFINALIZE = new JButton(FINALIZE);
        btnFINALIZE.setActionCommand(FINALIZE);
        btnFINALIZE.setFont(new Font("Arial", Font.BOLD,22));
        btnFINALIZE.setForeground(Color.yellow);
        btnFINALIZE.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnFINALIZE.setLocation( MARGIN + 400, PANEL_HEIGHT - MARGIN - MARGIN_Y );
        btnFINALIZE.setFocusable(false);
        btnFINALIZE.setBackground(Color.black);
        add(btnFINALIZE);

        btnQUIT = new JButton(EXIT);
        btnQUIT.setActionCommand(EXIT);
        btnQUIT.setFont(new Font("Arial", Font.BOLD,22));
        btnQUIT.setForeground(Color.yellow);
        btnQUIT.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnQUIT.setLocation(MARGIN + 600, PANEL_HEIGHT - MARGIN - MARGIN_Y );
        btnQUIT.setFocusable(false);
        btnQUIT.setBackground(Color.black);
        add(btnQUIT);

        JLabel titleScore = new JLabel("SCORE : ");
        titleScore.setFont(new Font("Arial", Font.BOLD, 22));
        titleScore.setForeground(Color.blue);
        titleScore.setSize(JLABEL_SCORE_WIDTH, JLABEL_SCORE_HEIGHT);
        titleScore.setLocation(JTEXTFIELD_WORD_WIDTH + 50 ,  PANEL_HEIGHT - MARGIN - MARGIN_Y);
        add(titleScore, BorderLayout.NORTH);

        txtScore = new JTextField();
        txtScore.setFont(new Font("Serif", Font.PLAIN, 45));
        txtScore.setBackground(Color.green);
        txtScore.setForeground(Color.BLUE);
        txtScore.setSize(JTEXTFIELD_SCORE_WIDTH, JTEXTFIELD_SCORE_HEIGHT);
        txtScore.setLocation(JTEXTFIELD_WORD_WIDTH + 220, PANEL_HEIGHT - MARGIN - MARGIN_Y);
        add(txtScore);

        JLabel titleTime = new JLabel(" SECONDS RUN : ");
        titleTime.setFont(new Font("Arial", Font.BOLD, 22));
        titleTime.setForeground(Color.blue);
        titleTime.setSize(JLABEL_SCORE_WIDTH + 140, JLABEL_SCORE_HEIGHT);
        titleTime.setLocation(JTEXTFIELD_WORD_WIDTH + 50,  MARGIN);
        add(titleTime, BorderLayout.NORTH);

        txtClock = new JTextField();
        txtClock.setFont(new Font("Serif", Font.BOLD, 80));
        txtClock.setBackground(Color.green);
        txtClock.setForeground(Color.RED);
        txtClock.setSize(JTEXTFIELD_CLOCK_WIDTH, JTEXTFIELD_CLOCK_HEIGHT);
        txtClock.setLocation( JTEXTFIELD_WORD_WIDTH + 280, MARGIN);
        add(txtClock);

        resultado = new JLabel(" ");
        resultado.setSize(JLABEL_WIDTH, JLABEL_HEIGHT);
        resultado.setLocation(JTEXTFIELD_WORD_WIDTH + 160, 150);
        resultado.setBorder(new LineBorder(new Color(0,0,0),3,true));
        add(resultado);

        JLabel titlePlayer = new JLabel("PLAYER NAME : ");
        titlePlayer.setFont(new Font("Arial", Font.BOLD, 22));
        titlePlayer.setForeground(Color.red);
        titlePlayer.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titlePlayer.setLocation(positionTitleName());
        add(titlePlayer, BorderLayout.NORTH);

        namePlayer = new JTextField();
        namePlayer.setFont(new Font("Serif", Font.PLAIN, 30));
        namePlayer.setForeground(Color.black);
        namePlayer.setSize(JTEXTNAME_WIDTH, JLABEL_TITLE_HEIGHT);
        namePlayer.setLocation(positionName());
        add(namePlayer);

        JLabel titleAnswer = new JLabel(" ANSWERS : ");
        titleAnswer.setFont(new Font("Arial", Font.BOLD, 22));
        titleAnswer.setForeground(Color.red);
        titleAnswer.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titleAnswer.setLocation(nextTextLocation());
        add(titleAnswer, BorderLayout.NORTH);

        txtAnswer = new JTextField();
        txtAnswer.setFont(new Font("Serif", Font.PLAIN, 20));
        txtAnswer.setForeground(Color.black);
        txtAnswer.setSize(JTEXTFIELD_WORD_WIDTH,JTEXTFIELD_WORD_HEIGHT);
        txtAnswer.setLocation(nextTextLocation());
        add(txtAnswer);

        JLabel titleOpA = new JLabel(" OPTION A : ");
        titleOpA.setFont(new Font("Arial", Font.BOLD, 22));
        titleOpA.setForeground(Color.red);
        titleOpA.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titleOpA.setLocation(nextTextLocation());
        add(titleOpA, BorderLayout.NORTH);

        opA = new JTextField();
        opA.setFont(new Font("Serif", Font.PLAIN, 20));
        opA.setForeground(Color.black);
        opA.setSize(JTEXTFIELD_WORD_WIDTH,JTEXTFIELD_WORD_HEIGHT);
        opA.setLocation(nextTextLocation());
        add(opA);

        JLabel titleOpB = new JLabel(" OPTION B : ");
        titleOpB.setFont(new Font("Arial", Font.BOLD, 22));
        titleOpB.setForeground(Color.red);
        titleOpB.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titleOpB.setLocation(nextTextLocation());
        add(titleOpB, BorderLayout.NORTH);

        opB = new JTextField();
        opB.setFont(new Font("Serif", Font.PLAIN, 20));
        opB.setForeground(Color.black);
        opB.setSize(JTEXTFIELD_WORD_WIDTH,JTEXTFIELD_WORD_HEIGHT);
        opB.setLocation(nextTextLocation());
        add(opB);

        JLabel titleOpC = new JLabel(" OPTION C : ");
        titleOpC.setFont(new Font("Arial", Font.BOLD, 22));
        titleOpC.setForeground(Color.red);
        titleOpC.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titleOpC.setLocation(nextTextLocation());
        add(titleOpC, BorderLayout.NORTH);

        opC = new JTextField();
        opC.setFont(new Font("Serif", Font.PLAIN, 20));
        opC.setForeground(Color.black);
        opC.setSize(JTEXTFIELD_WORD_WIDTH,JTEXTFIELD_WORD_HEIGHT);
        opC.setLocation(nextTextLocation());
        add(opC);

    }

    /**
     * Funcion que setea y envia los botones al Controller
     * @param controller tipo de dato Controller
     */
    @Override
    public void setController(Controller controller) {
        btnA.addActionListener(controller);
        btnB.addActionListener(controller);
        btnC.addActionListener(controller);
        btnSTART.addActionListener(controller);
        btnCONTINUE.addActionListener(controller);
        btnFINALIZE.addActionListener(controller);
        btnQUIT.addActionListener(controller);
    }

    /**
     * Funcion que establece la posicion de los Botones
     * para seleccionar la opcion de su respuesta
     * @return la posicion del mismo
     */
    private Point nextButtonLocation(){
        return new Point( (JTEXTFIELD_WORD_WIDTH + 60), 250 + BUTTON_WIDTH_WORDS * buttonCounter++*2);
    }

    /**
     * Funcion que establece la posicion del Titulo Name
     * @return la posicion del mismo
     */
    private Point positionTitleName(){
        return new Point(MARGIN, MARGIN );
    }

    /**
     * Funcion que establece la posicion del Name al lado del Titulo
     * @return la posicion del mismo
     */
    private Point positionName(){
        return new Point(JLABEL_TITLE_WIDTH + 40, MARGIN );
    }

    /**
     * Funcion que establece la siguiente posicion del texto a dibujar en el Panel
     * @return la posicion del mismo
     */
    private Point nextTextLocation(){
        return new Point(MARGIN, JTEXTFIELD_WORD_HEIGHT * textCounter++ + 100);
    }

    /**
     * Funcion que devuelve si es el primer Boton a dibujar
     * @return retorna verdadero o falso
     */
    private boolean isFirstButton(){
        return buttonCounter == 1;
    }

    /**
     * Recibe el nombre del jugador
     * @param namePlayer imprime por pantalla el nombre del jugador
     */
    public void setNamePlayer(String namePlayer) {
        this.namePlayer.setText(namePlayer);
    }

    /**
     * Recibe y setea la opcion Texto de la Pregunta
     * @param txtAnswer recibe String
     */
    public void setTxtAnswer(String txtAnswer) {
        this.txtAnswer.setText(txtAnswer);
    }

    /**
     * Recibe y setea la opcion A seleccionada
     * @param opA a
     */
    public void setOpA(String opA) {
        this.opA.setText(opA);
    }

    /**
     * Recibe y setea la opcion B seleccionada
     * @param opB b
     */
    public void setOpB(String opB) {
        this.opB.setText(opB);
    }

    /**
     * Recibe y setea la opcion C seleccionada
     * @param opC c
     */
    public void setOpC(String opC) {
        this.opC.setText(opC);
    }

    /**
     * Funcion que devuelve lo impreso en Opcion A
     * @return
     */
    public JTextField getOpA() {
        return opA;
    }

    /**
     * Funcion que devuelve lo impreso en Opcion B
     * @return
     */
    public JTextField getOpB() {
        return opB;
    }

    /**
     * Funcion que devuelve lo impreso en Opcion C
     * @return
     */
    public JTextField getOpC() {
        return opC;
    }

    /**
     * Funcion que recibe la imagen jpg a mostrar por pantalla
     * @param ahorcado recibe jpg del tipo ImageIcon
     */
    public void setResultado(ImageIcon ahorcado) {
        this.resultado.setIcon(ahorcado);
    }

    /**
     * Funcion que devuelve Score actual
     * @return un string
     */
    public JTextField getTxtScore() {
        return txtScore;
    }

    /**
     * Funcion que setea Score y lo muestra por pantalla
     * @param txtScore dato a mostrar
     */
    public void setTxtScore(String txtScore) {
        this.txtScore.setText(txtScore);
    }

    /**
     * Funcion que devuelve el texto
     * @return
     */
    public JTextField getTxtClock() {
        return txtClock;
    }

    /**
     * Funcion que setea e imprime los segundos
     * @param txtClock
     */
    public void setTxtClock(int txtClock) {
        String seconds = String.valueOf(txtClock);
        this.txtClock.setText(seconds);
    }
}
