# Events-Planner-Rawan
This program helps the users to organize and manage their events.  The users must register when the program is first used, so they can go back and sign in using their usernames and passwords. All their information will be saved in their account for future usage. 


•	Implementation:

		We used JFrame class to design the Frames. We created two classes for each frame 
and used ImageIcon and imgLabel to insert images in the frame. For creating Radio buttons, we used JRadioButton; and to make it accept only one selction we used The ButtonGroup class which is responsible to make sure only one button is selected (by deselecting others in the group), and added the radio Buttons to the ButtonGroup object. We also used two JPanel in the first frame for logging in and registering. We used (BorderFactory.createTitledBorder) to create borders for each panel.

To enable the panel based on the user choice, we declared an array of Component (Component[] com), we assigned the login Panel to it and disable the components using for loop and method  (setEnabled(false)), then we did the same to the registered Panel. We used JLabel for outputs and JTextField for user inputs. and to make the program save the user info by clicking the Exit button we used WindowListener, WindowAdapter, and method windowClosing. To detect user clicks, we used actionPerformed.
For the Second Class, We used JTabbedPane to make the tabs and declaring 4 JPanel components for each tab. To make it easier we Created 4 methods: FindEvent, addEvent, SaveLoad, Reminders. All of them are from Type JPanel, therefore, they return a JPanel component. Each assigned to a specific tab. We used an addTab method. To add the tabs.
We also made this class implements ChangeListener. If the user clicks on a tab, It refreshes the information. To make that, we implemented the stateChanged method and getSelectedIndex to determine which tab the user clicked 
Tab Add Event: We used JSpinner and SpinnerDateModel.
Tab Find Event: We used JScrollPane and added JTextArea to it. 
