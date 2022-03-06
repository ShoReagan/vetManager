import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import shelter.Cat;
import shelter.Dog;
import shelter.Shelter;
import shelter.DogBreed;
import shelter.CatBreed;
import shelter.Gender;
import shelter.Animal;

public class MainWin extends JFrame {
    private Shelter shelter;
    private JLabel data = new JLabel();
    
    public MainWin(String title) {
        this.shelter = new Shelter(title);

        JButton dogButton = new JButton("DOG");
        dogButton.setBounds(20, 20, 50, 50);
        dogButton.addActionListener(event -> onNewDogClick());
        dogButton.setBorder(null);
        add(dogButton);

        JButton catButton = new JButton("CAT");
        catButton.setBounds(20, 100, 50, 50);
        catButton.addActionListener(event -> onNewCatClick());
        catButton.setBorder(null);
        add(catButton);

        JButton aboutButton = new JButton("About");
        aboutButton.setBounds(20, 180, 50, 50);
        aboutButton.addActionListener(event -> onAboutClick());
        aboutButton.setBorder(null);
        add(aboutButton);

        setSize(200, 200);
        setLayout(null);
        setVisible(true);

        onQuitClick();

    }

    public void onNewDogClick() {
        JTextField names;
        JComboBox genders;
        JSpinner ages;

        JLabel name = new JLabel("<HTML><br/>name</HTML>");
        names = new JTextField(20);

        JLabel gender = new JLabel("<HTML><br/>gender</HTML>");

        String[] gender_choices = {"Male", "Female"};
        genders = new JComboBox<String>(gender_choices);

        JLabel age = new JLabel("<HTML><br/>age</HTML>");

        SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
        ages = new JSpinner(range);

        Object[] objects = {name, names, gender, genders, age, ages};

        int button = JOptionPane.showConfirmDialog(this, objects,"New Animal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this, names.getText() + genders.getSelectedItem() + ages.getValue());
        }
    }

    public void onNewCatClick() {
        System.out.println("CAT");
    }

    public void onAboutClick() {
        System.out.println("ABOUT");
    }

    public void onQuitClick() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateDisplay() {

    }
}