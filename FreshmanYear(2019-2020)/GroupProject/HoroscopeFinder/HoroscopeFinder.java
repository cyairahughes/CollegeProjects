package Horoscope;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




    /****************************************************************************
     * Final Project: HoroscopeFinder
     ****************************************************************************
     * Based on a user’s birth day and month, this program
     * will give them a horoscope unique to their zodiac sign,
     * as well as an image of their sign
     *______________________________________________________________________________
     *Alexa Sparkman, Darriel McLaurin, Cyaira Hughes, Kalilah Kroll
     * April 19th, 2020
     * CMSC_255- 901
     ****************************************************************************/


    public class HoroscopeFinder extends Application {
        /*************************************
         * Create a text area for the output *
         ************************************/
        TextArea outputMessage = new TextArea();

        public static void main(String[] args) {
            Application.launch(args);
        }

        /********************************************************************************************************
         * Create a keyboard shortcut for 'Calculate' button (users can press 'Enter' and the program will run) *
         ********************************************************************************************************/
        private void setGlobalEventHandler(VBox root, Button btn) {
            root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
                if (ev.getCode() == KeyCode.ENTER) {
                    btn.fire();
                    ev.consume();
                }
            });
        }


        @Override
        public void start(Stage stage) {
            /*************************************
             * Create a text field for user input *
             * ***********************************/
            final TextField numInput1 = new TextField();
            final TextField numInput = new TextField();
            numInput1.setPromptText("Please input a valid date");
            numInput.setPromptText("Please input a valid month (numerically)");

            /********************************
             * Set the size of the text area *
             * ******************************/
            outputMessage.setPromptText("Results");
            outputMessage.setPrefColumnCount(20);
            outputMessage.setPrefRowCount(10);

            /********************************
             * Create a 'Calculate' button   *
             * ******************************/
            Button HoroscopeButton = new Button("Find Horoscope");
            // Add an EventHandler to the Button
            HoroscopeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                    /**********************************************************
                     * Sets up a loop that clears text field after user input *
                     **********************************************************/
                    while (numInput.getText().length() > 0 && numInput1.getText().length() > 0) {

                        /********************************
                         * Initialize Horoscope object *
                         *******************************/
                        Horoscope horoscope = new Horoscope(); // Creates a Horoscope object called horoscope

                        try {
                            int userInput = Integer.parseInt(numInput.getText()); // Retrieve user input from text field

                            horoscope.setMonth(userInput); // Sets month for Horoscope object
                            horoscope.setDay(userInput); // Sets day for Horoscope object

                            String outputVal = horoscope.determineSign();

                            outputMessage.setText(outputVal); // Fills large message window with results from determineSign method

                        }
                        catch (NumberFormatException ex) {
                            String errorStatement = "Error, you did not enter an integer.\n"; // Set error statement
                            outputMessage.setText(errorStatement);

                        }
                        finally {
                            numInput.setText("");
                            numInput1.setText("");

                        }

                    }
                }
            });


            /***************************
             * Create a 'Reset' button  *
             * *************************/
            Button resetButton = new Button("Reset");
            // Add an EventHandler to the Button
            resetButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    outputMessage.setText(""); // Clears large message window
                }
            });

            /*******************************
             * Create viewing window (root) *
             * *****************************/
            // Create window (VBox)
            VBox root = new VBox();
            VBox root1 = new VBox();
            // Add Labels, TextArea and TextField to the Window
            root.getChildren().addAll(new Label("Enter your birth month (numerically):"), numInput, new Label("Enter day of birth here:"), numInput1, new Label("Your Horoscope:"), outputMessage, HoroscopeButton, resetButton);

            // Define size of window
            // Define size of window
            root.setMinSize(400, 200);
            root1.setMinSize(400, 200);
            // Set root to shortcut method
            setGlobalEventHandler(root, HoroscopeButton);
            setGlobalEventHandler(root1, HoroscopeButton);

            /**********************************
             * Configure window (root) design *
             *********************************/
            root.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: blue;" +
                    "-fx-background-color : #add8e6;");

            /********************
             * Create the Stage *
             *******************/
            Scene scene = new Scene(root);
            // Add the scene to the stage
            stage.setScene(scene);
            // Set the title of the Stage
            stage.setTitle("A Horoscope Finder");

            // Display the Stage
            stage.show();
        }
    }

