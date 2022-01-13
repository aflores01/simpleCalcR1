import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {

    private Math math   = new Math();
    private UI ui       = new UI();

    public String firstValue = new String();
    public String operator = new String();

    private JTextField  resultDisplay;
    private JButton     plusButton;
    private JButton     subtractButton;
    private JButton     divideButton;
    private JButton     multiplyButton;
    private JButton     equalsButton;
    private JButton     clearButton;
    private JButton     oneButton;
    private JButton     twoButton;
    private JButton     threeButton;
    private JButton     fourButton;
    private JButton     fiveButton;
    private JButton     sixButton;
    private JButton     sevenButton;
    private JButton     eightButton;
    private JButton     nineButton;
    private JButton     zeroButton;

    public static void main(String[] args) {
        new MainScreen();
    }

    public MainScreen() {
        setTitle("Calculadora UVEG - 19012192");
        setSize(380, 470);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        ListenButton listenButton = new ListenButton();

        resultDisplay = new JTextField();
        resultDisplay.setBounds(10,10,350,50);

        plusButton = new JButton("+");
        plusButton.setBounds(280, 70, 80, 80);
        plusButton.addActionListener(listenButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(280, 160, 80, 80);
        subtractButton.addActionListener(listenButton);

        divideButton = new JButton("/");
        divideButton.setBounds(280, 250, 80, 80);
        divideButton.addActionListener(listenButton);

        equalsButton = new JButton("=");
        equalsButton.setBounds(190, 340, 80, 80);
        equalsButton.addActionListener(listenButton);

        multiplyButton = new JButton("*");
        multiplyButton.setBounds(280, 340, 80, 80);
        multiplyButton.addActionListener(listenButton);

        clearButton = new JButton("C");
        clearButton.setBounds(10, 340, 80, 80);
        clearButton.addActionListener(listenButton);

        oneButton = new JButton("1");
        oneButton.setBounds(10, 70, 80, 80 );
        oneButton.addActionListener(listenButton);

        twoButton = new JButton("2");
        twoButton.setBounds(100, 70 , 80, 80);
        twoButton.addActionListener(listenButton);

        threeButton = new JButton("3");
        threeButton.setBounds(190, 70,80, 80);
        threeButton.addActionListener(listenButton);

        fourButton = new JButton("4");
        fourButton.setBounds(10, 160 , 80, 80);
        fourButton.addActionListener(listenButton);

        fiveButton = new JButton("5");
        fiveButton.setBounds(100, 160, 80, 80);
        fiveButton.addActionListener(listenButton);

        sixButton = new JButton("6");
        sixButton.setBounds(190, 160, 80, 80);
        sixButton.addActionListener(listenButton);

        sevenButton = new JButton("7");
        sevenButton.setBounds(10, 250, 80, 80);
        sevenButton.addActionListener(listenButton);

        eightButton = new JButton("8");
        eightButton.setBounds(100, 250, 80, 80);
        eightButton.addActionListener(listenButton);

        nineButton = new JButton("9");
        nineButton.setBounds(190, 250, 80, 80);
        nineButton.addActionListener(listenButton);

        zeroButton = new JButton("0");
        zeroButton.setBounds(100, 340, 80 , 80);
        zeroButton.addActionListener(listenButton);

        getContentPane().add(resultDisplay);
        getContentPane().add(oneButton);
        getContentPane().add(twoButton);
        getContentPane().add(threeButton);
        getContentPane().add(fourButton);
        getContentPane().add(fiveButton);
        getContentPane().add(sixButton);
        getContentPane().add(sevenButton);
        getContentPane().add(eightButton);
        getContentPane().add(nineButton);
        getContentPane().add(zeroButton);
        getContentPane().add(plusButton);
        getContentPane().add(subtractButton);
        getContentPane().add(divideButton);
        getContentPane().add(multiplyButton);
        getContentPane().add(equalsButton);
        getContentPane().add(clearButton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class ListenButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearButton) {
                resultDisplay.setText(null);
                firstValue = "";
                operator = "";
            }
            else if (
                e.getSource() == plusButton     ||
                e.getSource() == subtractButton ||
                e.getSource() == multiplyButton ||
                e.getSource() == divideButton
            ) {
                operationButtonAction((JButton) e.getSource());
            }
            else if (e.getSource() == equalsButton) {
                equalsButtonAction();
            }
            else {
                JButton source = (JButton) e.getSource();
                resultDisplay.setText(ui.addInput(resultDisplay.getText(), source.getText()));
            }
        }

        public void operationButtonAction(JButton source) {
            if (firstValue.isEmpty()) {
                firstValue = resultDisplay.getText();
                operator = source.getText();
                resultDisplay.setText(source.getText());
            } else {
                resultDisplay.setText(math.operation(firstValue, operator, resultDisplay.getText()));
                firstValue = "";
                operator = "";
            }
        }

        public void equalsButtonAction() {
            if (!firstValue.isEmpty()) {
                resultDisplay.setText(math.operation(firstValue, operator, resultDisplay.getText()));
                firstValue = "";
                operator = "";
            }
        }
    }
}