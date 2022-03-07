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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class MainWin extends JFrame {
    private Shelter shelter;
    private JLabel data = new JLabel();
    
    public MainWin(String title) {
        this.shelter = new Shelter(title);

        ImageIcon dogIcon = new ImageIcon("dog.png");
        ImageIcon catIcon = new ImageIcon("cat.jfif");

        JLabel img = new JLabel();
        img.setIcon(dogIcon);
        add(img);

        JMenuBar menuBar = new JMenuBar();


        JMenu addAnimal = new JMenu("Add Animal");
        JMenuItem catMenu = new JMenuItem("Cat");
        JMenuItem dogMenu = new JMenuItem("Dog");

        JMenu aboutMenu = new JMenu("About");

        addAnimal.add(dogMenu);
        addAnimal.add(catMenu);
        menuBar.add(addAnimal);
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);
        setVisible(true);

        dogMenu.addActionListener(event -> onNewDogClick());

        catMenu.addActionListener(event -> onNewCatClick());

        aboutMenu.addActionListener(event -> onAboutClick());

        data.setBounds(0, 0, 200, 200);
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
            Cat cat = new Cat(CatBreed.valueOf((String)breeds.getSelectedItem()), names.getText(), Gender.valueOf((String)genders.getSelectedItem()), (int) ages.getValue());
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
    }

    public void onQuitClick() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateDisplay() {
        data.setVisible(false);
        data.setVisible(true);
    }
}