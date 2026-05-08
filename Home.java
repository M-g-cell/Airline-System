package airlinesystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    public Home() {

        // Frame Settings
        setTitle("Airline Management System...");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Screen Size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Background Image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("airlinesystem/icons/front3.jpg"));
        Image img = icon.getImage().getScaledInstance(
                screenSize.width,
                screenSize.height,
                Image.SCALE_SMOOTH
        );

        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, screenSize.width, screenSize.height);
        add(background);

        // Heading
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setFont(new Font("Tahoma", Font.BOLD, 38));
        heading.setForeground(Color.BLACK);
        heading.setBounds(screenSize.width / 2 - 350, 40, 700, 50);
        background.add(heading);

        // ===== MENU BAR =====
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5)); // spacing control
        setJMenuBar(menuBar);

        // Add Menu Items Directly to MenuBar
        addMenuItem(menuBar, "Flight Details");
        addMenuItem(menuBar, "Add Customer Details");
        addMenuItem(menuBar, "Book Flight");
        addMenuItem(menuBar, "Journey Details");
        addMenuItem(menuBar, "Boarding Pass");
        addMenuItem(menuBar, "Cancel Ticket");

        // EXIT BUTTON
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("Tahoma", Font.PLAIN, 13));
        exit.setForeground(Color.RED);
        exit.setFocusPainted(false);
        exit.setMargin(new Insets(4, 10, 4, 10));

        exit.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to exit?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        menuBar.add(exit);

        setVisible(true);
    }

    // Method to add menu items neatly
    private void addMenuItem(JMenuBar bar, String title) {
        JMenuItem item = new JMenuItem(title);
        item.setFont(new Font("Tahoma", Font.PLAIN, 13));
        item.setFocusPainted(false);
        item.setMargin(new Insets(4, 10, 4, 10)); // controls size
        item.addActionListener(this);
        bar.add(item);
    }

    // Action Handling
    public void actionPerformed(ActionEvent ae) {

        String text = ae.getActionCommand();

        switch (text) {
            case "Add Customer Details":
                new AddCustomer();
                break;

            case "Flight Details":
                new FlightInfo();
                break;

            case "Book Flight":
                new BookFlight();
                break;

            case "Journey Details":
                new JourneyDetails();
                break;

            case "Cancel Ticket":
                new Cancel();
                break;

            case "Boarding Pass":
                new BoardingPass();
                break;
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}