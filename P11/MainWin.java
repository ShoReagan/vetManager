import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import shelter.Shelter;
import shelter.Animal;
import shelter.Client;
import shelter.Dog;
import shelter.DogBreed;
import shelter.Pig;
import shelter.PigBreed;
import shelter.Cat;
import shelter.CatBreed;
import shelter.Gender;

public class MainWin extends JFrame {// implements ActionListener {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file       = new JMenu("File");
        JMenuItem quit       = new JMenuItem("Quit");
        JMenuItem newShelter = new JMenuItem("New Shelter");
        JMenuItem openShelter = new JMenuItem("Open Shelter");
        JMenuItem saveShelter = new JMenuItem("Save Shelter");
        JMenuItem saveShelterAs = new JMenuItem("Save Shelter As");
        JMenu     animal     = new JMenu("Animal");
        JMenuItem newDog     = new JMenuItem("New Dog");
        JMenuItem newCat     = new JMenuItem("New Cat");
        JMenuItem newPig     = new JMenuItem("New Pig");
        JMenuItem listAnimals = new JMenuItem("List Available");
        JMenuItem listAdopted = new JMenuItem("List Adopted");
        JMenu     help       = new JMenu("Help");
        JMenuItem rules      = new JMenuItem("Rules");
        JMenuItem about      = new JMenuItem("About");
        JMenu client = new JMenu("Client");
        JMenuItem newClient     = new JMenuItem("New Client");
        JMenuItem listClients     = new JMenuItem("List Client");
        JMenuItem adoptAnimal = new JMenuItem("Adopt an Animal");
        
        quit  .addActionListener(event -> onQuitClick());
        newShelter  .addActionListener(event -> onNewShelterClick());
        openShelter  .addActionListener(event -> onOpenShelterClick());
        saveShelter  .addActionListener(event -> onSaveShelterClick());
        saveShelterAs  .addActionListener(event -> onSaveShelterAsClick());
        newDog.addActionListener(event -> onNewDogClick());
        newCat.addActionListener(event -> onNewCatClick());
        newPig.addActionListener(event -> onNewPigClick());
        about .addActionListener(event -> onAboutClick());
        newClient.addActionListener(event -> onNewClientClick());
        listClients.addActionListener(event -> onListClientClick());
        listAnimals.addActionListener(event -> onListAnimalClick());
        listAdopted.addActionListener(event -> onListAdoptedClick());
        adoptAnimal.addActionListener(event -> onAdoptAnimalClick());

        file.add(newShelter);
        file.add(openShelter);
        file.add(saveShelter);
        file.add(saveShelterAs);
        file.add(quit);
        animal.add(newDog);
        animal.add(newCat);
        animal.add(newPig);
        animal.add(listAnimals);
        help.add(about);
        client.add(newClient);
        client.add(listClients);
        
        menubar.add(file);
        menubar.add(animal);
        menubar.add(client);
        menubar.add(help);
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("MASS Commands");

        // A "horizontal strut" is just a space of the specified pixel width
        //toolbar.add(Box.createHorizontalStrut(25));
        
        // Create the 3 buttons using the icons provided
        JButton buttonNewDog  = new JButton(new ImageIcon("new_dog.png"));
          buttonNewDog.setActionCommand("New dog");
          buttonNewDog.setToolTipText("Add a new dog");
          toolbar.add(buttonNewDog);
          buttonNewDog.addActionListener(event -> onNewDogClick());

          //toolbar.add(Box.createHorizontalStrut(25));

        JButton buttonNewCat  = new JButton(new ImageIcon("new_cat.png"));
          buttonNewCat.setActionCommand("New cat");
          buttonNewCat.setToolTipText("Add a new cat");
          toolbar.add(buttonNewCat);
          buttonNewCat.addActionListener(event -> onNewCatClick());

          //toolbar.add(Box.createHorizontalStrut(25));

        JButton buttonNewPig  = new JButton(new ImageIcon("new_pig.jpg"));
          buttonNewPig.setActionCommand("New pig");
          buttonNewPig.setToolTipText("Add a new pig");
          toolbar.add(buttonNewPig);
          buttonNewPig.addActionListener(event -> onNewPigClick());

          //toolbar.add(Box.createHorizontalStrut(25));

        JButton buttonNewClient  = new JButton(new ImageIcon("new_client.jpg"));
          buttonNewClient.setActionCommand("New client");
          buttonNewClient.setToolTipText("Add a new client");
          toolbar.add(buttonNewClient);
          buttonNewClient.addActionListener(event -> onNewClientClick());

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        
        // /////////////////////////// ////////////////////////////////////////////
        // D A T A   D I S P L A Y
        // Provide a text entry box to show data
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(data, BorderLayout.CENTER);

        // Just for fun, a cute dog / cat splash image 
        //   (removed on first data, see updateDisplay())
        try {
            data.setHorizontalAlignment(JLabel.CENTER);
            BufferedImage pic = ImageIO.read(new File("cat-and-dog.jpg"));
            ImageIcon icon = new ImageIcon(pic);
            data.setIcon(icon);
        } catch(IOException e) {
        }

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);

        // Make everything in the JFrame visible
        setVisible(true);
        
        shelter = new Shelter("UTA Animal Friends");
    }
    
    
    // Generic animal dialog

    // Listeners
    private JLabel breed = new JLabel("Breed");

    private JLabel name = new JLabel("<HTML><br/>Name</HTML>");
    private JTextField names = new JTextField(20);
        
    private JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
    private JComboBox genders = new JComboBox(Gender.values());
        
    private JLabel age = new JLabel("<HTML><br/>Age</HTML>");
    private SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
    private JSpinner ages = new JSpinner(range);

    private JLabel phoneNumber = new JLabel("<HTML><br/>Phone Number</HTML>");
    private JTextField phoneNumbers = new JTextField(20);

    private JLabel clientslist = new JLabel("Clients");
    private JLabel animalslist = new JLabel("Animals");

    // private <T extends Animal> void newAnimal(T animal, JComboBox breeds) {

    // }
    protected void onAdoptAnimalClick() { 
        String clientsString[];
        String animalsString[];
        ListIterator<Client> clientIterator = shelter.clientListIterator();
        ListIterator<Client> animalIterator = shelter.animalListIterator();
        int counter = 0;
        while(clientIterator.hasNext()) {
            clientsString[counter] = clientIterator.next();
            counter++;
        }
        counter = 0;
        while(animalIterator.hasNext()) {
            animalsString[counter] = animalIterator.next();
            counter++;
        }

        JComboBox cli = new JComboBox(clientsString);
        JComboBox ani = new JComboBox(animalsString);
        
        Object[] objects = { // Array of widgets to display
            clientsList, cli, animalsList, ani};
        
        int button = JOptionPane.showConfirmDialog( // Show the dialog
            this,
            objects,
            "New Adoption",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) 
            shelter.addAdoption(
                new Dog((DogBreed) breeds.getSelectedItem(), names.getText(), 
                        (Gender) genders.getSelectedItem(), (int) ages.getValue()
                )
            );
        onListAnimalClick();
        updateDisplay();
    }

    protected void onNewDogClick() { 
        JComboBox breeds = new JComboBox(DogBreed.values());
        
        Object[] objects = { // Array of widgets to display
            breed, breeds, name, names, gender, genders, age, ages};
        
        int button = JOptionPane.showConfirmDialog( // Show the dialog
            this,
            objects,
            "New Dog",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) 
            shelter.addAnimal(
                new Dog((DogBreed) breeds.getSelectedItem(), names.getText(), 
                        (Gender) genders.getSelectedItem(), (int) ages.getValue()
                )
            );
        onListAnimalClick();
        updateDisplay();
    }

    public void onNewShelterClick() {
        String newShelter = JOptionPane.showInputDialog("Enter new Shelter name");
        shelter = new Shelter(newShelter);
        onListAnimalClick();
        updateDisplay();
    }

    public void onOpenShelterClick() {
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter shelterFiles = new FileNameExtensionFilter("Shelter Files", "mass");
        fc.addChoosableFileFilter(shelterFiles);
        fc.setFileFilter(shelterFiles);

        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                shelter = new Shelter(br);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e, "Unable to open", JOptionPane.ERROR_MESSAGE);
            }
        }
        onListAnimalClick();
        updateDisplay();
    }

    public void onSaveShelterClick() {
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            shelter.save(bw);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e, "Unable to open", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void onSaveShelterAsClick() {
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter shelterFiles = new FileNameExtensionFilter("Shelter Files", "shelter");
        fc.addChoosableFileFilter(shelterFiles);
        fc.setFileFilter(shelterFiles);

        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile();
            if(!filename.getAbsolutePath().endsWith(".mass")) 
                filename = new File(filename.getAbsolutePath() + ".mass");;
            onSaveShelterClick();
        }
    }
            
    protected void onNewCatClick() { 
        JComboBox breeds = new JComboBox(CatBreed.values());
        
        Object[] objects = { // Array of widgets to display
            breed, breeds, name, names, gender, genders, age, ages};
        
        int button = JOptionPane.showConfirmDialog( // Show the dialog
            this,
            objects,
            "New Cat",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) 
            shelter.addAnimal(
                new Cat((CatBreed) breeds.getSelectedItem(), names.getText(), 
                        (Gender) genders.getSelectedItem(), (int) ages.getValue()
                )
            );
        onListAnimalClick();
        updateDisplay();
    }

    protected void onNewPigClick() { 
        JComboBox breeds = new JComboBox(PigBreed.values());
        
        Object[] objects = { // Array of widgets to display
            breed, breeds, name, names, gender, genders, age, ages};
        
        int button = JOptionPane.showConfirmDialog( // Show the dialog
            this,
            objects,
            "New Pig",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) 
            shelter.addAnimal(
                new Pig((PigBreed) breeds.getSelectedItem(), names.getText(), 
                        (Gender) genders.getSelectedItem(), (int) ages.getValue()
                )
            );
        onListAnimalClick();
        updateDisplay();
    }

    protected void onListAnimalClick() {
        data.setText("<html>" + shelter.toString()
                                       .replaceAll("<","&lt;")
                                       .replaceAll(">", "&gt;")
                                       .replaceAll("\n", "<br/>")
                              + "</html>");
        updateDisplay();
    }

    protected void onListAdoptedClick() {
        data.setText("<html>" + shelter.adoptionsToString()
                                       .replaceAll("<","&lt;")
                                       .replaceAll(">", "&gt;")
                                       .replaceAll("\n", "<br/>")
                              + "</html>");
        updateDisplay();
    }

    protected void onNewClientClick() { 
        Object[] objects = { // Array of widgets to display
           name, names, phoneNumber, phoneNumbers};
        
        int button = JOptionPane.showConfirmDialog( // Show the dialog
            this,
            objects,
            "New Client",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION) 
            shelter.addClient(new Client(names.getText(), phoneNumbers.getText()));
        onListClientClick();
        updateDisplay();
    }

    protected void onListClientClick() {
        data.setText("<html>" + shelter.clientToString()
                                       .replaceAll("<","&lt;")
                                       .replaceAll(">", "&gt;")
                                       .replaceAll("\n", "<br/>")
                              + "</html>");
        updateDisplay();
    }


    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mav's Animal Shelter Software");
        
        try {
            BufferedImage pic = ImageIO.read(new File("cat-and-dog.jpg"));
            JLabel logo = new JLabel(new ImageIcon(pic));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>MASS</font></p>"
          + "</html>");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        info.add(titlePanel);

        JLabel subtitle = new JLabel("<html>"
          + "<p><font size=+1>Mavs Animal Shelter Software</font></p>"
          + "</html>");
        JPanel subtitlePanel = new JPanel();
        subtitlePanel.add(subtitle);
        info.add(subtitlePanel);

        JLabel artists = new JLabel("<html></br>"
          + "<p>Version 1.0</p>"
          + "<p>Copyright 2022 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by Anna Langova, CC0 Public Domain</p>"
          + "<p><font size=-2>https://www.publicdomainpictures.net/<br/>en/view-image.php?image=24076</font></p>"
          + "<br/>"
          + "<p><a href=\"https://www.flaticon.com/free-icons/dog\" title=\"dog icons\">Dog icons created by Freepik - Flaticon</a></p>"
          + "<p><a href=\"https://www.flaticon.com/free-icons/cat\" title=\"cat icons\">Cat icons created by justicon - Flaticon</a></p>"  
          + "<br/><br/></html>");
        info.add(artists); 

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        JPanel okPanel = new JPanel();
        okPanel.add(ok);
        info.add(okPanel);
        
        about.add(info);
        
        about.pack();
        about.setVisible(true);
     }
    protected void onQuitClick() {
        System.exit(0);
    }

    // Update the data display in the main window
    private void updateDisplay() {
        data.setIcon(null);  // remove the splash image if present
        data.setHorizontalAlignment(JLabel.LEFT);
        data.setVerticalAlignment(JLabel.TOP);
        data.revalidate(); // Not usually required
    }

    private Shelter shelter;
    private File filename;
    
    private JLabel data;                    // Display of data
    private JLabel msg;                     // Status message display
}
