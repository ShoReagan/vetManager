import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import shelter.Cat;
import shelter.Dog;
import shelter.Shelter;
import shelter.DogBreed;
import shelter.CatBreed;
import shelter.Gender;
import shelter.Animal;

public class MainWin extends JFrame {
    private Shelter shelter;
    private JLabel label = new JLabel();
    
    public MainWin(String title) {
        this.shelter = new Shelter(title);

        JButton dogButton = new JButton("DDD");
        dogButton.setBounds(20, 20, 50, 50);
        dogButton.addActionListener(event -> onNewDogClick());
        dogButton.setBorder(null);
        add(dogButton);

        JButton catButton = new JButton("CCC");
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
        JLabel name = new JLabel("<HTML><br/>Name</HTML>");
        names = new JtextField(20);

        JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
        String[] genders = {"Male", "Female"};
        genders = new JComboBox<String>(gender.txt);

        JLabel age = new JLabel("<HTML><br/>Age</HTML>");

        SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
        ages = new jSpinner(range);
        
        
        System.out.println("DOG");
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