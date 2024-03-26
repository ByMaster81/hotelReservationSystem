package hotelreservation;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JMenuItem exitItem;
	private JMenuItem editItem2;
	private JMenuItem editItem;
	private JMenuItem helpItem;
	private JMenuItem helpItem2;

	public static List<Calculable> hotelList = new ArrayList<>();
	static double income = 0;
	static double bill = 0;
	static double employeeEx = 0;
	private JMenuBar menuBar;
	private JPanel panel;
	private JTextArea textArea;

	public frame() {
		super("Hotel Reservation System");
		setLayout(new FlowLayout());
		button1 = new JButton("Display Reservation");
		button2 = new JButton("Display Extra Services");
		button3 = new JButton("Disp. Res. For City");
		button4 = new JButton("City Search(MultiTread)");
		button5 = new JButton("Save Reservations");
		button6 = new JButton("Load Reservations");

		button1.setBackground(Color.GRAY);
		button2.setBackground(Color.GRAY);
		button3.setBackground(Color.GRAY);
		button4.setBackground(Color.GRAY);
		button5.setBackground(Color.GRAY);
		button1.setForeground(Color.WHITE);
		button2.setForeground(Color.WHITE);
		button3.setForeground(Color.WHITE);
		button4.setForeground(Color.WHITE);
		button5.setForeground(Color.WHITE);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);

		panel = new JPanel();
		Border border = BorderFactory.createEtchedBorder();
		panel.setBorder(border);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setPreferredSize(new Dimension(1000, 500));
		panel.setLayout(new GridBagLayout());
		add(panel);

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		menuBar.setForeground(Color.WHITE);

		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");
		fileMenu.setForeground(Color.WHITE);
		editMenu.setForeground(Color.WHITE);
		helpMenu.setForeground(Color.WHITE);
		exitItem = new JMenuItem("Exit");
		editItem = new JMenuItem("New Reservation");
		editItem2 = new JMenuItem("New Service");
		helpItem = new JMenuItem("Help");
		helpItem2 = new JMenuItem("About");
		helpMenu.add(helpItem);
		fileMenu.add(exitItem);
		editMenu.add(editItem);
		editMenu.add(editItem2);
		helpMenu.add(helpItem2);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);

		ButtonHandler buttonHandler = new ButtonHandler();
		button1.addActionListener(buttonHandler);
		button2.addActionListener(buttonHandler);
		button3.addActionListener(buttonHandler);
		button4.addActionListener(buttonHandler);
		button5.addActionListener(buttonHandler);
		button6.addActionListener(buttonHandler);

		MenuHandler menuHandler = new MenuHandler();
		exitItem.addActionListener(menuHandler);
		editItem.addActionListener(menuHandler);
		editItem2.addActionListener(menuHandler);
		helpItem.addActionListener(menuHandler);
		helpItem2.addActionListener(menuHandler);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.GRAY);
		Font font = new Font("Arial", Font.PLAIN, 18);
		textArea.setFont(font);

		JScrollPane scrollPane = new JScrollPane(textArea);
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Color.DARK_GRAY);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		panel.add(scrollPane, constraints);

		pack();

		enableDarkTheme();
	}

	private void enableDarkTheme() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("MenuBar.background", new Color(43, 43, 43));
			UIManager.put("MenuBar.foreground", new Color(187, 187, 187));
			UIManager.put("Menu.foreground", new Color(187, 187, 187));
			UIManager.put("MenuItem.foreground", new Color(187, 187, 187));
			UIManager.put("MenuItem.background", new Color(43, 43, 43));
			UIManager.put("MenuItem.selectionBackground", new Color(66, 66, 66));
			UIManager.put("MenuItem.selectionForeground", new Color(187, 187, 187));
			UIManager.put("Menu.selectionBackground", new Color(66, 66, 66));
			UIManager.put("Menu.selectionForeground", new Color(187, 187, 187));
			UIManager.put("TextArea.background", new Color(25, 25, 25));
			UIManager.put("TextArea.foreground", new Color(187, 187, 187));
			UIManager.put("TextArea.caretForeground", new Color(187, 187, 187));
			UIManager.put("TextArea.selectionBackground", new Color(66, 66, 66));
			UIManager.put("TextArea.selectionForeground", new Color(187, 187, 187));
			UIManager.put("Button.background", new Color(66, 66, 66));
			UIManager.put("Button.foreground", new Color(187, 187, 187));
			UIManager.put("Button.select", new Color(117, 117, 117));
			UIManager.put("Button.focus", new Color(43, 43, 43));
			UIManager.put("Button.highlight", new Color(66, 66, 66));
			UIManager.put("Button.shadow", new Color(66, 66, 66));
			UIManager.put("Button.border", BorderFactory.createEmptyBorder());
			UIManager.put("Panel.background", new Color(25, 25, 25));
			UIManager.put("Panel.foreground", new Color(187, 187, 187));
			UIManager.put("OptionPane.background", new Color(43, 43, 43));
			UIManager.put("OptionPane.foreground", new Color(187, 187, 187));
			UIManager.put("OptionPane.messageForeground", new Color(187, 187, 187));
			UIManager.put("OptionPane.buttonBackground", new Color(66, 66, 66));
			UIManager.put("OptionPane.buttonForeground", new Color(187, 187, 187));
			UIManager.put("OptionPane.messageAreaBorder", BorderFactory.createEmptyBorder(10, 10, 10, 10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == button1) {
				Iterator<Calculable> iterator = hotelList.iterator();
				while (iterator.hasNext()) {
					Calculable reservation = iterator.next();

					if (reservation instanceof Reservation) {
						textArea.append(((Reservation) reservation).displayInfoGUI() + "\n");
					}
				}

			} else if (event.getSource() == button2) {

				Iterator<Calculable> iterator = hotelList.iterator();

				while (iterator.hasNext()) {
					Calculable reservation = iterator.next();

					if (reservation instanceof Laundry) {
						textArea.append("The cost for the Laundry service of reservation ID: "
								+ ((services) reservation).getCustomerId() + " " + ((services) reservation).getCost()
								+ "\n");
					} else if (reservation instanceof spa) {
						textArea.append("The cost for the Spa service of reservation ID: "
								+ ((services) reservation).getCustomerId() + " " + ((services) reservation).getCost()
								+ "\n");
					}

				}
			} else if (event.getSource() == button3) {

				String city = JOptionPane.showInputDialog("Type a city name for a reservation search:");
				Iterator<Calculable> iterator = hotelList.iterator();
				textArea.append("Reservations for " + city + "\n");
				while (iterator.hasNext()) {

					Calculable reservation = iterator.next();
					if (reservation instanceof Reservation) {
						if (((Reservation) reservation).getCity().equals(city))
							textArea.append(((Reservation) reservation).displayInfoGUI() + "\n");
					}

				}
			} else if (event.getSource() == button4) {
				if (Reservation.totalNumberOfReservations < 8) {
					JOptionPane.showMessageDialog(null,
							"You should create at least 8 reservation for multi thread searching");

				} else {
					String hotelInfo = JOptionPane.showInputDialog("Enter a hotel name ");
					multiThreadSearch(hotelInfo);
				}
			} else if (event.getSource() == button5) {
				
				try (BufferedWriter writer = new BufferedWriter(new FileWriter("reservations.csv"))) {
					writer.write("CityName,HotelName,ReservationMonth,ReservationStart,ReservationEnd");
					writer.newLine();

					Iterator<Calculable> iterator = hotelList.iterator();
					while (iterator.hasNext()) {
						Calculable reservation = iterator.next();
						if (reservation instanceof Reservation) {
							
							writer.write(((Reservation) reservation).getCity() + ","
									+ ((Reservation) reservation).getHotelName() + ","
									+ ((Reservation) reservation).getReservationMonth() + ","
									+ ((Reservation) reservation).getReservationStart() + ","
									+ ((Reservation) reservation).getReservationEnd());
							writer.newLine();
						}
					}

					JOptionPane.showMessageDialog(panel, "Reservations Saved!");
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(panel, "An error occurred.");
				}
			}else if (event.getSource() == button6) {
				 try (BufferedReader reader = new BufferedReader(new FileReader("reservations.csv"))) {
				        String line;
				        StringBuilder sb = new StringBuilder();

				        while ((line = reader.readLine()) != null) {
				            sb.append(line);
				            sb.append("\n");
				        }

				        textArea.setText(sb.toString());
				    } catch (IOException ex) {
				        ex.printStackTrace();
				        JOptionPane.showMessageDialog(panel, "An error occurred.");
				    }
			}

		}

	}

	private class MenuHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == exitItem) {
				System.exit(0);
			} else if (event.getSource() == editItem) { // Create reservation
				Room room = new Single();

				String hotelName = JOptionPane.showInputDialog("Enter Hotel Name: ");
				String city = JOptionPane.showInputDialog("Enter city: ");
				String reservationMonth = JOptionPane.showInputDialog("Enter the reservation month");
				String reservationStart = JOptionPane.showInputDialog("Enter reservation start date: ");
				String reservationEnd = JOptionPane.showInputDialog("End date:");
				int reservationEnd1 = Integer.parseInt(reservationEnd);
				int reservationStart1 = Integer.parseInt(reservationStart);
				if (reservationStart1 < reservationEnd1 && reservationEnd1 < 30) {
					int id = Reservation.totalNumberOfReservations + 1;
					services reservation = new Reservation(id, hotelName, city, reservationMonth, reservationStart1,
							reservationEnd1, room);
					hotelList.add(reservation);
					Reservation.totalNumberOfReservations++;
				} else
					JOptionPane.showMessageDialog(null, "Invalid entry for date!", "Error", JOptionPane.ERROR_MESSAGE);

			} else if (event.getSource() == editItem2) {

				String choice = JOptionPane.showInputDialog(
						"Please select one of the extra services below:\n" + "1. Laundry\n" + "2. Spa ");
				if (choice.equals("1")) {
					String id = JOptionPane.showInputDialog("Enter ID: ");
					int id1 = Integer.parseInt(id);
					String pieces = JOptionPane.showInputDialog("Pieces: ");
					int pieces1 = Integer.parseInt(pieces);
					services laundry = new Laundry(id1, pieces1, 20);
					Iterator<Calculable> iterator = hotelList.iterator();
					while (iterator.hasNext()) {
						Calculable reservation = iterator.next();
						if (((services) reservation).getCustomerId() == id1) {
							hotelList.add(laundry);
							break;
						}
					}
				} else if (choice.equals("2")) {
					String id = JOptionPane.showInputDialog("Enter ID: ");
					int id1 = Integer.parseInt(id);
					String days = JOptionPane.showInputDialog("Pieces: ");
					int days1 = Integer.parseInt(days);
					services spa = new spa(id1, days1, 20);
					Iterator<Calculable> iterator = hotelList.iterator();
					while (iterator.hasNext()) {
						Calculable reservation = iterator.next();
						if (((services) reservation).getCustomerId() == id1) {
							hotelList.add(spa);
							break;
						}
					}

				}
			} else if (event.getSource() == helpItem) {
				String guideMessage = "Welcome to the Hotel Reservation System!\n\n"
						+ "1. To display all reservations, click the 'Display Reservation' button.\n"
						+ "2. To display extra services, click the 'Display Extra Services' button.\n"
						+ "3. To display reservations for a specific city, click the 'Disp. Res. For City' button.\n"
						+ "4. To create a new reservation, select 'New Reservation' from the 'Edit' menu.\n"
						+ "5. To add a new extra service, select 'New Service' from the 'Edit' menu.\n"
						+ "6. To exit the program, select 'Exit' from the 'File' menu.\n\n"
						+ "Enjoy using the Hotel Reservation System!";
				JOptionPane.showMessageDialog(null, guideMessage, "Help", JOptionPane.INFORMATION_MESSAGE);
			} else if (event.getSource() == helpItem2) {
				String aboutMessage = "Hotel Reservation System - CSE212 Assignment\n\n"
						+ "This program is developed by Rüştü Yemenici, a student of Computer Engineering at Yeditepe University.\n"
						+ "It is created as part of the CSE212 course assignment.\n\n"
						+ "For any inquiries or assistance, please contact:\n" + "- Name: Rüştü Yemenici\n"
						+ "- University: Yeditepe University\n" + "- Department: Computer Engineering";
				JOptionPane.showMessageDialog(null, aboutMessage, "About", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void multiThreadSearch(String hotelInfo) {

		List<Integer> idL = new ArrayList<>();
		List<Thread> threadL = new ArrayList<>();
		for (Calculable iterator : hotelList) {

			if (iterator instanceof Reservation) {

				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						if (((Reservation) iterator).getHotelName().equals(hotelInfo)) {
							synchronized (idL) {
								idL.add(((Reservation) iterator).getCustomerId());
							}
						}
					}
				});
				thread.start();
				threadL.add(thread);
			}
		}

		for (Thread thread : threadL) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (!idL.isEmpty()) {
			StringBuilder info = new StringBuilder("Reservation IDs for hotel with the name " + hotelInfo + " : \n");
			for (int id : idL) {
				info.append(id).append("\n");
			}
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					textArea.append(info.toString());
				}
			});
		} else {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					textArea.append("No reservations found for the hotel name '" + hotelInfo + "'.\n");
				}
			});
		}
	}

}
