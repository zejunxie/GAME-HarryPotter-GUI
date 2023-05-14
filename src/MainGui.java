import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Optional;
import java.util.Random;

public class MainGui extends Application {
    Enemy[] enemies = new Enemy[7];
    int i = 0;
    private Label turnLabel;
    private Button[] actionButtons;
    boolean isSpellSelected = false;
    Wizard wizard = new Wizard();
    Label labelPlayerHealth = new Label("Your HP: " + 100);
    Label labelBossHealth = new Label("Enemy HP: " + 100);
    VBox vboxLevel = new VBox();
    Label messageLabelBoss = new Label();
    Label messageLabelPlayer = new Label();
    Label messageLabelHp = new Label();
    private static final Duration MESSAGE_DURATION = Duration.seconds(2);
    private static final double MOVE_DELTA = 30.0;
    String playerName;
    private ImageView player;
    private final ImageView[] bosses = new ImageView[7];
    private double playerX;
    private double playerY;
    private double windowWidth;
    private double windowHeight;
    Button buttonAttack;
    Button buttonPotion;
    Button buttonWeapon;
    Label labelLevel = new Label("Level "+(i+1));




    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HarryPotter");
        primaryStage.getIcons().add(new Image("/Sources/icon.jpg"));
        primaryStage.setResizable(false);

        //Exit game
        Platform.setImplicitExit(false);
        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit game");
            alert.setHeaderText(null);
            alert.setContentText("Do you want to quit the game?");
            Optional<ButtonType>  result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Platform.exit();
            }
        });

        CreatGame(primaryStage);
        primaryStage.show();
    }




    public void CreatGame(Stage primaryStage){
// Create enemy
        enemies[0] = new Enemy("Troll", 100, 40, "Toilets of the dungeon", "In order to defeat him, you must lift the objects and release them when they are above his head.");
        enemies[1] = new Enemy("Basil", 100, 40, "Room of secrets", "Summon the legendary sword of Godric Gryffindor or rip off one of its fangs and use it to destroy Tom Jedusol's diary.");
        enemies[2] = new Enemy("Detractors", 100, 40, "Lake in the Forbidden Forest", "The destroyers are on the run. They're roaming the streets and the countryside. Fortunately, you've heard of a spell that will make them fly ...... Expect... Expect... ... ");
        enemies[3] = new Enemy("Voldemort and Peter Pettigrew", 100, 40, "Little Hangleton Cemetery", "Get close to Portkey and draw him to you (Accio)");
        enemies[4] = new Enemy("Dolores Umbridge", 100, 40, "Hogwarts Examination Hall", " Dolores Umbridge is guarding the grain. Your goal is to distract her until the Fireworks are ready to be used.");
        enemies[5] = new Enemy("Death Eaters", 100, 40, "Astronomy tower", "Death Eaters are attacking Hogwarts. Are you ready to defend yourselves? You must attack them from the front (Sectumsempra)");
        enemies[6] = new Enemy("Voldemort and Bellatrix Lestrange", 100, 40, "Poudlard", "Beware of the Avada Kedavra. When in doubt, use the Expelliarmus spell ! ");

        //HomePage(scene)
        Pane root = new Pane();
        Button buttonStart = new Button("Start game");
        buttonStart.setLayoutX(600);
        buttonStart.setLayoutY(500);
        root.getChildren().add(buttonStart);
        Scene scene = new Scene(root,1280,960);
        //Background
        Image backgroundImage0 = new Image("Sources/homePage.jpg");
        BackgroundImage backgroundImg0 = new BackgroundImage(backgroundImage0,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
        Background background0 = new Background(backgroundImg0);
        root.setBackground(background0);


//NamePage(scene0)
        Label nameLabel = new Label("Please enter your name:");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        // Create a button to submit the name
        Button submitButton = new Button("Submit");

        // Create a layout and add the components
        VBox vbox0 = new VBox(10);
        vbox0.setPadding(new Insets(10));
        vbox0.getChildren().addAll(nameLabel, nameField, submitButton);
        Scene scene0 = new Scene(vbox0, 300, 200);


        Scene[] scenes=new Scene[7];
        Pane[] roots = new Pane[7];

// level1(scene0)
        roots[0] = new Pane();
        scenes[0] = new Scene(roots[0],1500,800);
        //Background
        Image backgroundImage = new Image("Sources/level1.jpg");
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
        Background background = new Background(backgroundImg);
        roots[0].setBackground(background);

//level2(scene1)
        roots[1] = new Pane();
        //Background
        Image backgroundImage1 = new Image("Sources/level2.jpg");
        BackgroundImage backgroundImg1 = new BackgroundImage(backgroundImage1,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
        Background background1 = new Background(backgroundImg1);
        roots[1].setBackground(background1);
        scenes[1] = new Scene(roots[1],1500,800);

//level3(scene2)
        roots[2] = new Pane();
        //Background
        Image backgroundImage2 = new Image("Sources/level3.jpg");
        BackgroundImage backgroundImg2 = new BackgroundImage(backgroundImage2,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
        Background background2 = new Background(backgroundImg2);
        roots[2].setBackground(background2);
        scenes[2] = new Scene(roots[2],1500,800);

//level4(scene3)
        roots[3] = new Pane();
        //Background
        Image backgroundImage3 = new Image("Sources/level4.jpg");
        BackgroundImage backgroundImg3 = new BackgroundImage(backgroundImage3,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
        Background background3 = new Background(backgroundImg3);
        roots[3].setBackground(background3);
        scenes[3] = new Scene(roots[3],1500,800);

//level5(scene4)
        roots[4] = new Pane();
        //Background
        Image backgroundImage4 = new Image("Sources/level5.jpg");
        BackgroundImage backgroundImg4 = new BackgroundImage(backgroundImage4,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
        Background background4 = new Background(backgroundImg4);
        roots[4].setBackground(background4);
        scenes[4] = new Scene(roots[4],1500,800);

//level6(scene5)
        roots[5] = new Pane();
        //Background
        Image backgroundImage5 = new Image("Sources/level6.jpg");
        BackgroundImage backgroundImg5 = new BackgroundImage(backgroundImage5,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
        Background background5 = new Background(backgroundImg5);
        roots[5].setBackground(background5);
        scenes[5] = new Scene(roots[5],1500,800);

//level7(scene6)
        roots[6] = new Pane();
        //Background
        Image backgroundImage6 = new Image("Sources/level7.jpg");
        BackgroundImage backgroundImg6 = new BackgroundImage(backgroundImage6,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));
        Background background6 = new Background(backgroundImg6);
        roots[6].setBackground(background6);
        scenes[6] = new Scene(roots[6],1500,800);


//boss and player
        windowWidth = scenes[i].getWidth();
        windowHeight = scenes[i].getHeight();
//BOSS
        bosses[0] = new ImageView(new Image("Sources/boss1.png")); // boss1
        bosses[0].setFitWidth(350);
        bosses[0].setFitHeight(350);
        double bossX = 1000;
        double bossY = 270;
        bosses[0].setLayoutX(bossX);
        bosses[0].setLayoutY(bossY);

        bosses[1] = new ImageView(new Image("Sources/boss2.png")); // boss2
        bosses[1].setFitWidth(350);
        bosses[1].setFitHeight(350);
        double boss2X = 1000;
        double boss2Y = 270;
        bosses[1].setLayoutX(boss2X);
        bosses[1].setLayoutY(boss2Y);

        bosses[2] = new ImageView(new Image("Sources/boss3.jpg")); // boss3
        bosses[2].setFitWidth(350);
        bosses[2].setFitHeight(350);
        double boss3X = 1000;
        double boss3Y = 270;
        bosses[2].setLayoutX(boss3X);
        bosses[2].setLayoutY(boss3Y);

        bosses[3] = new ImageView(new Image("Sources/boss4.jpg")); // boss4
        bosses[3].setFitWidth(350);
        bosses[3].setFitHeight(350);
        double boss4X = 1000;
        double boss4Y = 270;
        bosses[3].setLayoutX(boss4X);
        bosses[3].setLayoutY(boss4Y);

        bosses[4] = new ImageView(new Image("Sources/boss5.jpg")); // boss5
        bosses[4].setFitWidth(350);
        bosses[4].setFitHeight(350);
        double boss5X = 1000;
        double boss5Y = 270;
        bosses[4].setLayoutX(boss5X);
        bosses[4].setLayoutY(boss5Y);

        bosses[5] = new ImageView(new Image("Sources/boss6.jpg")); // boss6
        bosses[5].setFitWidth(350);
        bosses[5].setFitHeight(350);
        double boss6X = 1000;
        double boss6Y = 270;
        bosses[5].setLayoutX(boss6X);
        bosses[5].setLayoutY(boss6Y);

        bosses[6] = new ImageView(new Image("Sources/boss7.jpg")); // boss7
        bosses[6].setFitWidth(350);
        bosses[6].setFitHeight(350);
        double boss7X = 1000;
        double boss7Y = 270;
        bosses[6].setLayoutX(boss7X);
        bosses[6].setLayoutY(boss7Y);

//player
        Image playerImage = new Image("Sources/wizard.png");
        player = new ImageView(playerImage);
        player.setFitWidth(350);
        player.setFitHeight(350);
        playerX = 70;
        playerY = 300;
        player.setLayoutX(playerX);
        player.setLayoutY(playerY);

        scenes[i].setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            switch (keyCode) {
                case UP:
                    if (playerY - MOVE_DELTA >= 0) {
                        playerY -= MOVE_DELTA;
                    }
                    break;
                case DOWN:
                    if (playerY + player.getFitHeight() + MOVE_DELTA <= windowHeight) {
                        playerY += MOVE_DELTA;
                    }
                    break;
                case LEFT:
                    if (playerX - MOVE_DELTA >= 0) {
                        playerX -= MOVE_DELTA;
                    }
                    break;
                case RIGHT:
                    if (playerX + player.getFitWidth() + MOVE_DELTA <= windowWidth) {
                        playerX += MOVE_DELTA;
                    }
                    break;
            }
            player.setLayoutX(playerX);
            player.setLayoutY(playerY);
        });

        //labelLevel
        vboxLevel.setAlignment(Pos.CENTER);
        vboxLevel.setPrefSize(1500, 800);

        labelLevel.setStyle("-fx-font-size: 30px; -fx-text-fill: yellow; -fx-border-color: blue; -fx-border-width: 2px;");
        vboxLevel.setLayoutY(-330);
        vboxLevel.getChildren().add(labelLevel);


        //turnLabel
        turnLabel = new Label();
        turnLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: #ffa700;");
        turnLabel.setLayoutX(650);
        turnLabel.setLayoutY(144);


        //labelHealth
        labelPlayerHealth.setLayoutX(20);
        labelPlayerHealth.setLayoutY(20);
        labelPlayerHealth.setStyle("-fx-font-size: 60px; -fx-text-fill: red; -fx-border-color: blue; -fx-border-width: 2px;");

        labelBossHealth.setLayoutX(1060);
        labelBossHealth.setLayoutY(20);
        labelBossHealth.setStyle("-fx-font-size: 60px; -fx-text-fill: red; -fx-border-color: blue; -fx-border-width: 2px;");


        //LabelStatus
        messageLabelPlayer.setStyle("-fx-font-size: 24px;");
        messageLabelPlayer.setAlignment(Pos.CENTER);
        messageLabelPlayer.setTextFill(Color.RED);
        messageLabelPlayer.setLayoutX(500);
        messageLabelPlayer.setLayoutY(400);

        messageLabelBoss.setStyle("-fx-font-size: 24px;");
        messageLabelBoss.setAlignment(Pos.CENTER);
        messageLabelBoss.setTextFill(Color.RED);
        messageLabelBoss.setLayoutX(500);
        messageLabelBoss.setLayoutY(400);

        messageLabelHp.setStyle("-fx-font-size: 35px;");
        messageLabelHp.setAlignment(Pos.CENTER);
        messageLabelHp.setTextFill(Color.GREEN);
        messageLabelHp.setLayoutX(200);
        messageLabelHp.setLayoutY(300);



        //button-spell
        Image imageAttack = new Image("Sources/spell.jpg");
        ImageView imageViewAttack = new ImageView(imageAttack);
        imageViewAttack.setFitWidth(120);
        imageViewAttack.setFitHeight(160);
        buttonAttack = new Button();
        buttonAttack.setGraphic(imageViewAttack);
        buttonAttack.setPadding(Insets.EMPTY);
        buttonAttack.setLayoutX(700);
        buttonAttack.setLayoutY(600);


        //button-potion
        Image imagePotion = new Image("Sources/potion.jpg");
        ImageView imageViewPotion = new ImageView(imagePotion);
        imageViewPotion.setFitWidth(120);
        imageViewPotion.setFitHeight(160);
        buttonPotion = new Button();
        buttonPotion.setGraphic(imageViewPotion);
        buttonPotion.setPadding(Insets.EMPTY);
        buttonPotion.setLayoutX(550);
        buttonPotion.setLayoutY(600);


        //button-weapon
        Image imageWeapon = new Image("Sources/weapon.jpg");
        ImageView imageViewWeapon = new ImageView(imageWeapon);
        imageViewWeapon.setFitWidth(120);
        imageViewWeapon.setFitHeight(160);
        buttonWeapon = new Button();
        buttonWeapon.setGraphic(imageViewWeapon);
        buttonWeapon.setPadding(Insets.EMPTY);
        buttonWeapon.setLayoutX(850);
        buttonWeapon.setLayoutY(600);


        //actionButton
        actionButtons = new Button[]{buttonAttack, buttonPotion, buttonWeapon};
        for (Button button : actionButtons) {
            button.setDisable(true);
        }

        buttonPotion.setOnAction(event ->{
            handlePlayerAction(0);
            wizard.healthPoints+=50;
            disableActionButtons();
            showMessage(messageLabelHp,"+50");
            labelPlayerHealth.setText("Your HP: " + wizard.healthPoints);
            performBossAction(primaryStage,scenes);
        });

        buttonAttack.setOnAction(event -> {
            isSpellSelected = true;
            disableActionButtons();
            handlePlayerAction(1);
            useSpell(messageLabelPlayer,primaryStage,scenes, roots);
        });

        buttonWeapon.setOnAction(event ->{
            handlePlayerAction(2);
            showMessage(messageLabelPlayer,"You currently have no available weapons");
            performBossAction(primaryStage,scenes);
        });

        buttonStart.setOnAction(event -> {
            primaryStage.setScene(scene0);
        });

        submitButton.setOnAction(event -> {
            playerName = nameField.getText();
            primaryStage.setScene(scenes[i]);
            displayInfo();
            System.out.println("Welcome to the first level !");
            System.out.println("Your turn !");
        });

        scenes[i].setCursor(new ImageCursor(new Image("Sources/wand.png")));
        roots[0].getChildren().addAll(vboxLevel,turnLabel,player,bosses[0],buttonAttack,buttonPotion,buttonWeapon,labelBossHealth,labelPlayerHealth,messageLabelPlayer,messageLabelBoss,messageLabelHp);

        showTurnLabel("   Your turn !");
        enableActionButtons();
        primaryStage.setScene(scene);
    }

    public void displayInfo(){
        System.out.println("\n" + "Here are some of your personal information:");
        System.out.println("Your Name: " +playerName );
        System.out.println("Wand Type: " + wizard.wand.type);
        System.out.println("Wand Wood: " + wizard.wand.wood);
        System.out.println("Wand Length: " + wizard.wand.length + " inches");
        System.out.println("House: " + wizard.house);
        System.out.println("Health Points: " + wizard.healthPoints);
        System.out.println("Spell Damage: " + wizard.spellDamage);
        System.out.println("Accuracy: " + wizard.accuracy + "%");
        System.out.println("Resistance: " + wizard.resistance);
        System.out.println("Potency of potion: " + wizard.potionEffectiveness + "HP+" + "\n");
    }
    private void showMessage(Label label, String message) {
        label.setText(message);
        label.setVisible(true);

        // Create a Timeline to hide the message after MESSAGE_DURATION
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(MESSAGE_DURATION, event -> {
            label.setVisible(false);
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    private void restartGame() {
        // Reset player and enemy health
        wizard.healthPoints = 100;
        enemies[i].healthPoints = 100;

        // Reset player and boss positions
        player.setLayoutX(70);
        player.setLayoutY(300);
        bosses[i].setLayoutX(1000);
        bosses[i].setLayoutY(270);

        // Update UI labels
        labelPlayerHealth.setText("Your HP: " + wizard.healthPoints);
        labelBossHealth.setText("Enemy HP: " + enemies[i].healthPoints);
    }

    private void showTurnLabel(String text) {
        turnLabel.setText(text);
    }

    private void enableActionButtons() {
        for (Button button : actionButtons) {
            button.setDisable(false);
        }
    }

    private void disableActionButtons() {
        for (Button button : actionButtons) {
            button.setDisable(true);
        }
    }

    private void handlePlayerAction(int actionIndex) {
        disableActionButtons();
        switch (actionIndex) {
            case 0:
                System.out.println("You have used the potion !");
                break;
            case 1:
                System.out.println("You have used the spell !");
                break;
            case 2:
                System.out.println("You have used a weapon !");
                break;
        }
    }
    private void upgradeAttributes(Stage primaryStage,Scene[] scenes,Pane[] roots){
        // Boss's life is 0, player wins
        // A dialog box is displayed, allowing the player to select the attributes to upgrade
        Alert attributeDialog = new Alert(Alert.AlertType.CONFIRMATION);
        attributeDialog.setTitle("Level Clear");
        attributeDialog.setHeaderText(null);
        attributeDialog.setContentText("Congratulations! You defeated the boss!\nChoose an attribute to enhance:");

        ButtonType healthAttributeButton = new ButtonType("Health Points");
        ButtonType spellDamageAttributeButton = new ButtonType("Spell Damage");
        ButtonType accuracyAttributeButton = new ButtonType("Accuracy");

        attributeDialog.getButtonTypes().setAll(healthAttributeButton, spellDamageAttributeButton, accuracyAttributeButton);
        Optional<ButtonType> result = attributeDialog.showAndWait();

        // Increase the corresponding attributes according to the player's choice
        if (result.isPresent()) {
            i +=1;
            wizard.healthPoints = 100;
            enemies[i].healthPoints = 100;
            labelBossHealth.setText("Enemy HP: " + enemies[i].healthPoints);
            labelPlayerHealth.setText("Your HP: " + wizard.healthPoints);
            isSpellSelected=false;
            enableActionButtons();
            labelLevel.setText("Level "+(i+1));
            roots[i].getChildren().addAll(vboxLevel,turnLabel,player,bosses[i],buttonAttack,buttonPotion,buttonWeapon,labelBossHealth,labelPlayerHealth,messageLabelPlayer,messageLabelBoss,messageLabelHp);
            primaryStage.setScene(scenes[i]);
            System.out.println("Welcome to level "+(i+1));
            System.out.println(enemies[i].tips);


            if (result.get() == healthAttributeButton) {
                wizard.healthPoints += 10;
                labelPlayerHealth.setText("Your HP: " + wizard.healthPoints);
            } else if (result.get() == spellDamageAttributeButton) {
                wizard.spellDamage += 5;
            } else if (result.get() == accuracyAttributeButton) {
                wizard.accuracy += 10;
            }
        }
    }



    private void useSpell(Label messageLabelPlayer, Stage primaryStage, Scene[] scenes,Pane[] roots){
        scenes[i].setOnMouseClicked(event -> {
            double clickX = event.getX();
            double clickY = event.getY();
            if (isSpellSelected) {
                disableActionButtons();
                if (Math.abs(clickX - 1210) <= 15 && Math.abs(clickY - 291) <= 15){
                    int damagePlayer = 100;
                    enemies[i].healthPoints -= damagePlayer;
                    System.out.println("Congratulations on your success in defeating the boss, ready to move on to the next level.");
                    labelBossHealth.setText("Enemy HP: " + enemies[i].healthPoints);
                    showMessage(messageLabelPlayer, "You dealt " + damagePlayer +" points of damage to the enemy ! ");
                }else {
                    if (wizard.accuracy >= new Random().nextInt(100)) {
                        int damagePlayer = wizard.spellDamage;
                        enemies[i].healthPoints-= damagePlayer;
                        System.out.println("You dealt "+ damagePlayer +" points of damage to the enemy !"+"\n");
                        labelBossHealth.setText("Enemy HP: " + enemies[i].healthPoints);
                        showMessage(messageLabelPlayer, "You dealt " + damagePlayer +" points of damage to the enemy !");
                    }else {
                        System.out.println("Unfortunately!You missed!"+"\n");
                        showMessage(messageLabelPlayer, "             Unfortunately!You missed!");
                    }
                }
                Image stoneImage = new Image("Sources/stone.png");
                ImageView stoneImageView = new ImageView(stoneImage);
                stoneImageView.setFitWidth(100);
                stoneImageView.setFitHeight(100);
                stoneImageView.setLayoutX(clickX - 50);
                stoneImageView.setLayoutY(clickY - 50);
                roots[i].getChildren().add(stoneImageView);

                // Create a Timeline to remove the stone image after a certain time delay
                Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1.5), event2 -> {
                    roots[i].getChildren().remove(stoneImageView);
                }));
                timeline1.play();

                if (enemies[i].healthPoints>0){
                    performBossAction(primaryStage,scenes);
                }else {
                    if (i<6){
                        upgradeAttributes(primaryStage,scenes,roots);
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Congratulations!");
                        alert.setHeaderText("You have successfully completed the game!");
                        alert.setContentText("You have been rewarded with a special weapon.");
                        alert.setOnHidden(event2 -> {
                            primaryStage.close();
                        });
                        alert.showAndWait();
                    }
                }
            }
        });
    }



    private void performBossAction(Stage primaryStage, Scene[] scenes) {

        disableActionButtons();
        showTurnLabel("Enemy's turn !");
        isSpellSelected = false;
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(3), event1 -> {
            enableActionButtons();
            showTurnLabel("   Your turn !");
            int damage = enemies[i].damagePoints-wizard.resistance;
            showMessage(messageLabelBoss, "     "+enemies[i].name+" dealt "+ damage +" points of damage to you !");
            wizard.healthPoints -= damage;
            labelPlayerHealth.setText("Your HP: " + wizard.healthPoints);
            System.out.println(enemies[i].name+" dealt "+damage+" points of damage to you !"+"\n");
            System.out.println("Your turn !");
        }));


        if (enemies[i].healthPoints > 0){
            System.out.println("Enemy's turn !");

            // Create an animation of a Boss attacking
            TranslateTransition bossMove = new TranslateTransition(Duration.seconds(1), bosses[i]);
            bossMove.setToX(player.getTranslateX() - bosses[i].getTranslateX());
            bossMove.setToY(player.getTranslateY() - bosses[i].getTranslateY());

            TranslateTransition bossAttack = new TranslateTransition(Duration.seconds(1.5), bosses[i]);
            bossAttack.setToX(-800);
            bossAttack.setAutoReverse(true);
            bossAttack.setCycleCount(2);

            TranslateTransition bossRetreat = new TranslateTransition(Duration.seconds(1.5), bosses[i]);
            bossRetreat.setToX(0);
            bossRetreat.setToY(0);

            SequentialTransition bossAnimation = new SequentialTransition(
                    bossMove,
                    bossAttack,
                    bossRetreat
            );
            bossAnimation.play();
            timeline2.play();


//alert
            if (wizard.healthPoints<=0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText("You lost!");
                alert.setContentText("Your health points have dropped to 0. Better luck next time!");
                ButtonType restartButton = new ButtonType("Restart");
                ButtonType exitButton = new ButtonType("Exit");
                alert.getButtonTypes().setAll(restartButton, exitButton);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == restartButton) {
                    restartGame();
                    primaryStage.setScene(scenes[i]);
                } else {
                    Platform.exit();
                }
            }
        }
        else {
            System.out.println("Congratulations! You have successfully defeated the enemy, now you can move on to the next level!");
        }
    }
}