package Roulette;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashMap;



public class Table {


    private final String RED = "red";
    private final String BLACK = "black";
    private final String ZERO = "zero";

    private int number;
    private int bankaccount = 200;
    private int yourbet;

    private String bet = "";

    HashMap<Integer, String> rouletteTable;

    JLabel text = new JLabel("Wie viel € möchtest du setzten?");
    JTextField textField = new JTextField("");
    JButton buttonRed = new JButton("Red");
    JButton buttonBlack = new JButton("Black");
    JLabel result = new JLabel("Result: ");
    JLabel bank = new JLabel("Bank: " + bankaccount + "€");



    public void openUI(){

        JFrame frame = new JFrame("Roulette");
        frame.setSize(500, 1000);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        text.setBounds(150, 20, 200, 30);
        textField.setBounds(140, 50, 180, 30);
        buttonBlack.setBounds(140, 100, 180, 30);
        buttonRed.setBounds(140, 150, 180, 30);
        result.setBounds(140, 200, 280, 30);
        bank.setBounds(400, 20, 100, 30);

        addListeners();


        frame.add(bank);
        frame.add(result);
        frame.add(buttonBlack);
        frame.add(buttonRed);
        frame.add(textField);
        frame.add(text);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void addListeners(){
        buttonBlack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bet = BLACK;
                avoidException();
            }
        });

        buttonRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bet = RED;
                avoidException();
            }
        });
    }

    public void avoidException(){
        try {
            String textFromTextfield = textField.getText();
            int textNumber = Integer.parseInt(textFromTextfield);
            yourbet = textNumber;
            run();
        } catch (Exception error) {
            text.setText("Bitte gebe eine Zahl ein!");
        }
    }

    public Table(){
        rouletteTable = new HashMap<>();
        rouletteTable.put(0, ZERO);
        rouletteTable.put(1, RED);
        rouletteTable.put(2, BLACK);
        rouletteTable.put(3, RED);
        rouletteTable.put(4, BLACK);
        rouletteTable.put(5, RED);
        rouletteTable.put(6, BLACK);
        rouletteTable.put(7, RED);
        rouletteTable.put(8, BLACK);
        rouletteTable.put(9, RED);
        rouletteTable.put(10, BLACK);
        rouletteTable.put(11, BLACK);
        rouletteTable.put(12, RED);
        rouletteTable.put(13, BLACK);
        rouletteTable.put(14, RED);
        rouletteTable.put(15, BLACK);
        rouletteTable.put(16, RED);
        rouletteTable.put(17, BLACK);
        rouletteTable.put(18, RED);
        rouletteTable.put(19, RED);
        rouletteTable.put(20, BLACK);
        rouletteTable.put(21, RED);
        rouletteTable.put(22, BLACK);
        rouletteTable.put(23, RED);
        rouletteTable.put(24, BLACK);
        rouletteTable.put(25, RED);
        rouletteTable.put(26, BLACK);
        rouletteTable.put(27, RED);
        rouletteTable.put(28, BLACK);
        rouletteTable.put(29, BLACK);
        rouletteTable.put(30, RED);
        rouletteTable.put(31, BLACK);
        rouletteTable.put(32, RED);
        rouletteTable.put(33, BLACK);
        rouletteTable.put(34, RED);
        rouletteTable.put(35, BLACK);
        rouletteTable.put(36, RED);
    }

    public int run(){
        number = ThreadLocalRandom.current().nextInt(0, 36);
        String color = rouletteTable.get(number);
        boolean won = bet == color;
        if (won){
            yourbet = yourbet * 2;
            bankaccount = bankaccount + yourbet;
            result.setText("Result: " + number + "(" + color.toUpperCase() +")" + " ==> YOU WON " + yourbet + "€!" );
            bank.setText("Bank: " + bankaccount + "€");
        } else {
            bankaccount = bankaccount - yourbet;
            bank.setText("Bank: " + bankaccount + "€");
            result.setText("Result: " + number + "(" + color.toUpperCase() +")" + " ==> YOU LOST EVERY CENT!");
        }
        System.out.println(yourbet);
        return number;
    }
}
