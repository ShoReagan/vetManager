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
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

public class MainWin extends JFrame {
    private Shelter shelter;
    private JLabel data = new JLabel();
    
    public MainWin(String title) {
        this.shelter = new Shelter(title);

        ImageIcon dogIcon = new ImageIcon("dog.png");
        ImageIcon catIcon = new ImageIcon("cat.jfif");

        JButton dogButton = new JButton(dogIcon);
        dogButton.setBounds(20, 20, 100, 100);
        dogButton.addActionListener(event -> onNewDogClick());
        dogButton.setBorder(null);
        add(dogButton);

        JButton catButton = new JButton(catIcon);
        catButton.setBounds(20, 100, 100, 100);
        catButton.addActionListener(event -> onNewCatClick());
        catButton.setBorder(null);
        add(catButton);

        JButton aboutButton = new JButton("About");
        aboutButton.setBounds(20, 180, 50, 50);
        aboutButton.addActionListener(event -> onAboutClick());
        aboutButton.setBorder(null);
        add(aboutButton);

        data.setBounds(200, 200, 200, 200);
        //data.setBounds(null);
        add(data);

        setSize(200, 200);
        setLayout(null);
        setVisible(true);

        onQuitClick();

    }

    public void onNewDogClick() {
        JTextField names;
        JComboBox genders;
        JComboBox breeds;
        JSpinner ages;

        JLabel name = new JLabel("<HTML><br/>Name</HTML>");
        names = new JTextField(20);

        JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");

        String[] gender_choices = {"male", "female"};
        genders = new JComboBox<String>(gender_choices);

        JLabel breed = new JLabel("<HTML><br/>Breed</HTML>");

        String[] breed_choices = {"Affenpinscher", "Akita", "basenji", "beagle", "bloodhound", "borzoi", "boxer", "briard"};
        breeds = new JComboBox<String>(breed_choices);

        JLabel age = new JLabel("<HTML><br/>Age</HTML>");

        SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
        ages = new JSpinner(range);

        Object[] objects = {name, names, gender, genders, breed, breeds, age, ages};

        int button = JOptionPane.showConfirmDialog(this, objects,"New Animal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) {
            Dog dog = new Dog(DogBreed.valueOf((String)breeds.getSelectedItem()), names.getText(), Gender.valueOf((String)genders.getSelectedItem()), (int) ages.getValue());
            shelter.addAnimal(dog);
            data.setText("<html>" + shelter.toString()
                               .replaceAll("<","&lt;")
                               .replaceAll(">", "&gt;")
                               .replaceAll("\n", "<br/>")
                      + "</html>");
                      updateDisplay();
        }
            
    }

    public void onNewCatClick() {
        JTextField names;
        JComboBox genders;
        JComboBox breeds;
        JSpinner ages;

        JLabel name = new JLabel("<HTML><br/>Name</HTML>");
        names = new JTextField(20);

        JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");

        String[] gender_choices = {"male", "female"};
        genders = new JComboBox<String>(gender_choices);

        JLabel breed = new JLabel("<HTML><br/>Breed</HTML>");

        String[] breed_choices = {"Abyssinian", "Burmese" , "Himalayan" , "Manx" ,"Persian" ,"Siamese,Sphynx"};
        breeds = new JComboBox<String>(breed_choices);

        JLabel age = new JLabel("<HTML><br/>Age</HTML>");

        SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
        ages = new JSpinner(range);

        Object[] objects = {name, names, gender, genders, breed, breeds, age, ages};

        int button = JOptionPane.showConfirmDialog(this, objects,"New Animal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) {
            Cat cat = new Cat(CatBreed.valueOf((String)breeds.getSelectedItem()), name.getText(), Gender.valueOf((String)genders.getSelectedItem()), (int) ages.getValue());
            shelter.addAnimal(cat);
            data.setText("<html>" + shelter.toString()
                               .replaceAll("<","&lt;")
                               .replaceAll(">", "&gt;")
                               .replaceAll("\n", "<br/>")
                      + "</html>");
            updateDisplay();
        }  
    }

    public void onAboutClick() {
        System.out.println("ABOUT");
    }

    public void onQuitClick() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateDisplay() {
        data.setVisible(false);
        data.setVisible(true);
    }
}