package Assignment;
//JAVA PROGRAMMING ASSIGNMENT 2 
//SE LG05 (G07)

//CONTRIBUTED BY NISA//
import javax.swing.*;

class Encoded{

    private String inputText;
    private int charCount;
    private String resultText;
    private final String groupID = "G05/SE-G07"; // Hardcoded secret key

    public Encoded() {
        //Default constructor
    }

    //Overloaded constructor for input processing and encoding
    public Encoded(String inputText) {
        this.inputText = inputText;
        this.charCount = countCharacters();
        int finalShift = calculateFinalShift();
        this.resultText = applyCipher(finalShift);
    }


    //Counts the number of non-space characters in the input
    public int countCharacters() {
        int count = 0;
        for (char c : inputText.toCharArray()) {
            if (c != ' ')
                count++;
        }
        return count;
    }

    // Validates that input contains only uppercase letters, digits, and spaces
    public boolean checkStringValidity(String inputText) {
        for (char c : inputText.toCharArray()) {
            if (!(Character.isLowerCase(c) || Character.isDigit(c) || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    
    //Generates a unique shift based on the group's ID using hashCode()
    public int generateShift() {
        return Math.abs(groupID.hashCode()) % 10 + 1;
    }


    //Calculates final shift as groupShift + non-space char count
    public int calculateFinalShift() {
        return generateShift() + charCount;
    }

    //Applies the cipher to the inputText using the given shift value
    public String applyCipher(int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : inputText.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else if (Character.isDigit(c)) {
                result.append((char) ((c - '0' + shift) % 10 + '0'));
            } else {
                result.append(' ');
            }
        }
        return result.toString();
    }

    // === Getters and Setters ===

    public String getResultText() {
        return resultText;
    }

    public int getCharCount() {
        return charCount;
    }

    public int getFinalShift() {
        return calculateFinalShift();
    }
}

public class Assignment {
    //CONTRIBUTED BY ABDUL RAHIM
    private JFrame frame;
    private JTextField inputField;
    private JButton encodeButton;
    private JTextArea resultArea;
    private JLabel shiftLabel;
    private JLabel charCountLabel;

    public Assignment() {
        initializeGUI();
    }

    private void initializeGUI() { 
        //Main application window GUI
        //CONTRIBUTED BY ABDUL RAHIM
        frame = new JFrame("Text Encoder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);

        JLabel instructionLabel = new JLabel("Enter text (LOWERCASE letters, digits, spaces only):");
        inputField = new JTextField(30);
        encodeButton = new JButton("Encode");
        
        //Label and text area to display the encoded result
        JLabel resultLabel = new JLabel("Encoded Result:");
        resultArea = new JTextArea(2, 30);
        resultArea.setEditable(false); //Block user to edit encoded result
        resultArea.setLineWrap(true); 
        resultArea.setWrapStyleWord(true);

        //Label to display the final calceulated shift
        shiftLabel = new JLabel("Final Shift: ");

        //CONTRIBUTED BY WAN ADAM
        //Label to display the number of non space characters as required
        charCountLabel = new JLabel("Non-Space Characters: ");

        //Panel to hold and organize UI components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Aligning layout to the left for better readability
        // CONTRIBUTED BY ABDUL RAHIM
        instructionLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        inputField.setAlignmentX(JTextField.LEFT_ALIGNMENT);
        encodeButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        resultLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        resultArea.setAlignmentX(JTextArea.LEFT_ALIGNMENT);
        shiftLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        charCountLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        //Add all UI components to the panel
        panel.add(instructionLabel);
        panel.add(inputField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(encodeButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(resultLabel);
        panel.add(new JScrollPane(resultArea));
        panel.add(Box.createVerticalStrut(10));
        panel.add(shiftLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(charCountLabel); //CONTRIBUTED BY WAN ADAM

        frame.getContentPane().add(panel);

        setupActionListeners();
        frame.setVisible(true);
    }

    public void setupActionListeners() {
        // Button click logic
        //CONTRIBUTED BY ABDUL RAHIM AND WAN ADAM
        encodeButton.addActionListener(e -> {
            String input = inputField.getText().trim();
            Encoded validator = new Encoded(input);

            //Validate input format
            if (!validator.checkStringValidity(input)) {

                //Show error popup if input is invalid
                //CONTRIBUTED BY WAN ADAM
                JOptionPane.showMessageDialog(frame,
                        "Invalid input! Only LOWERCASE letters, digits, and spaces allowed.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Process input using overloaded constructor
            Encoded encoder = new Encoded(input); // Process input
        
            //Update UI with results
            resultArea.setText(encoder.getResultText());
            shiftLabel.setText("Final Shift: " + encoder.getFinalShift());
            charCountLabel.setText("Non-space Characters: " + encoder.getCharCount());
            
            //Show success message
            //CONTRIBUTED BY WAN ADAM
            JOptionPane.showMessageDialog(frame,
                    "Encoding completed successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        });

    }
    public static void main(String[] args) {

        // Run the application
        //CONTRIBUTED BY ABDUL RAHIM
        SwingUtilities.invokeLater(() -> new Assignment());
    }
}


