/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termproject;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static termproject.Player.balance;
import static termproject.Player.msg;
import static termproject.Player.oos;
import static termproject.Player.playerID;
import static termproject.Player.prebet;

/**
 *
 * @author PRANTO
 */
public class PokerTable2 extends Application {

    public static Stage stage;
    public static Player p;
    public static String str;

    public static void Scene15() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        Text t1 = new Text(p.msg.message);
        t1.setX(430);
        t1.setY(550);
        t1.setFill(Color.SALMON);
        t1.setFont(Font.font(null, FontWeight.BOLD, 50));
        root1.getChildren().add(t1);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene03() {
        Image image = new Image("file:background.png");
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        // simple displays ImageView the image as is
        // ImageView iv1 = new ImageView();
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);
        
        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(686);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(751);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        Rectangle rect = new Rectangle(150, 30);
        final Label label = new Label();
        label.setStyle("-fx-font: 25 arial;");
        label.setLayoutX(40);

        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(3);
        rect.setFill(Color.WHITE);

        // final String[] greetings = new String[] { "A", "B", "C" };
        final ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("MATCH", "RAISE", "FOLD"));
//        cb.setTooltip(new Tooltip("Select the language"));
        cb.setValue("MATCH");
        HBox hb = new HBox();
        hb.getChildren().addAll(cb, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene1.getRoot()).getChildren().add(hb);
        //String str = new String();
        Button btn = new Button("CLICK");
        btn.setLayoutX(102);
        btn.setLayoutY(13);

        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                //str = cb.getSelectionModel().getSelectedItem();
                str = cb.getSelectionModel().getSelectedItem();
                System.out.println(str);
                if (str.equals("MATCH")) {
                    p.balance = p.balance - (p.msg.Bet - p.prebet);
                    p.msg.pot = p.msg.pot + p.msg.Bet - p.prebet;
                    p.prebet = p.msg.Bet;
                    p.msg.choice = 1;
                    p.msg.message = "Opponent Matched.";
                    //CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    CommunicationMsg temp = MakeNewMsg(p.msg);
                    //System.out.println("******In choice 1");
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene02();
                    // code of showing balance
                } else if (str.equals("RAISE")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Raise");
                    dialog.setHeaderText("Set Bet");
                    dialog.setContentText("Please enter your raise amount :");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        p.msg.Bet = Integer.parseInt(result.get());
                    }
                    p.msg.choice = 2;
                    p.msg.pot = p.msg.pot + p.msg.Bet;
                    p.balance = p.balance - p.msg.Bet;
                    p.prebet = p.msg.Bet;
                    p.msg.balance = p.balance;
                    p.msg.bidderID = p.playerID;
                    System.out.println("******In choice 2");
                    msg.message = "Opponent raised bet amount to " + msg.Bet + "$";
                    System.out.println(msg.message);
                    try {
                        CommunicationMsg temp = MakeNewMsg(p.msg);
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene02();
                } else if (str.equals("FOLD")) {
                    p.msg.message = "Opponent Folded. ";
                    p.msg.foldID = p.playerID;
                    p.msg.choice = 3;
                    //CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    try {
                        CommunicationMsg temp = MakeNewMsg(p.msg);
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });
        root1.getChildren().add(btn);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene02() {
        Image image = new Image("file:background.png");
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        // simple displays ImageView the image as is
        // ImageView iv1 = new ImageView();
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(686);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(751);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        stage.setScene(scene1);

    }

    public static void Scene04() {
        Image image = new Image("file:background.png");
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        // simple displays ImageView the image as is
        // ImageView iv1 = new ImageView();
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        Rectangle rect = new Rectangle(150, 30);
        final Label label = new Label();
        label.setStyle("-fx-font: 25 arial;");
        label.setLayoutX(40);

        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(3);
        rect.setFill(Color.WHITE);

        // final String[] greetings = new String[] { "A", "B", "C" };
        final ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("CHECK", "RAISE", "FOLD"));
//        cb.setTooltip(new Tooltip("Select the language"));
        cb.setValue("CHECK");
        HBox hb = new HBox();
        hb.getChildren().addAll(cb, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene1.getRoot()).getChildren().add(hb);
        //String str = new String();
        Button btn = new Button("CLICK");
        btn.setLayoutX(102);
        btn.setLayoutY(13);
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                //str = cb.getSelectionModel().getSelectedItem();
                str = cb.getSelectionModel().getSelectedItem();
                System.out.println(str);
                if (str.equals("CHECK")) {
                    p.msg.choice = 1;
                    p.msg.message = "Opponent Matched.";
                    //CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    CommunicationMsg temp = MakeNewMsg(msg);
                    //System.out.println("******In choice 1");
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene02();
                    // code of showing balance
                } else if (str.equals("RAISE")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Raise");
                    dialog.setHeaderText("Set Bet");
                    dialog.setContentText("Please enter your raise amount :");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        p.msg.Bet = Integer.parseInt(result.get());
                    }
                    p.msg.pot = p.msg.pot + p.msg.Bet;
                    p.balance = p.balance - p.msg.Bet;
                    p.prebet = p.msg.Bet;
                    p.msg.balance = p.balance;
                    p.msg.bidderID = p.playerID;
                    p.msg.choice = 2;
                    System.out.println("******In choice 2");
                    msg.message = "Opponent raised bet amount to " + msg.Bet + "$";
                    try {
                        CommunicationMsg temp = MakeNewMsg(msg);
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene02();
                } else if (str.equals("FOLD")) {
                    p.msg.choice = 3;
                    p.msg.message = "Opponent Folded. ";
                    p.msg.foldID = p.playerID;
                    CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });
        root1.getChildren().add(btn);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene05() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        String st1;
        String st2;
        String st3;

        st1 = Display(p.river[0]);
        st2 = Display(p.river[1]);
        st3 = Display(p.river[2]);

        Image rimg1 = new Image("file:" + st1 + ".png");
        ImageView rimv1 = new ImageView();
        rimv1.setImage(rimg1);
        rimv1.setFitHeight(70);
        rimv1.setFitWidth(50);
        rimv1.setLayoutX(578);
        rimv1.setLayoutY(300);
        root1.getChildren().add(rimv1);

        Image rimg2 = new Image("file:" + st2 + ".png");
        ImageView rimv2 = new ImageView();
        rimv2.setImage(rimg2);
        rimv2.setFitHeight(70);
        rimv2.setFitWidth(50);
        rimv2.setLayoutX(650);
        rimv2.setLayoutY(300);
        root1.getChildren().add(rimv2);

        Image rimg3 = new Image("file:" + st3 + ".png");
        ImageView rimv3 = new ImageView();
        rimv3.setImage(rimg3);
        rimv3.setFitHeight(70);
        rimv3.setFitWidth(50);
        rimv3.setLayoutX(724);
        rimv3.setLayoutY(300);
        root1.getChildren().add(rimv3);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene06() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        Rectangle rect = new Rectangle(150, 30);
        final Label label = new Label();
        label.setStyle("-fx-font: 25 arial;");
        label.setLayoutX(40);

        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(3);
        rect.setFill(Color.WHITE);

        // final String[] greetings = new String[] { "A", "B", "C" };
        final ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("MATCH", "RAISE", "FOLD"));
//        cb.setTooltip(new Tooltip("Select the language"));
        cb.setValue("MATCH");
        HBox hb = new HBox();
        hb.getChildren().addAll(cb, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene1.getRoot()).getChildren().add(hb);
        //String str = new String();
        Button btn = new Button("CLICK");
        btn.setLayoutX(102);
        btn.setLayoutY(13);
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                //str = cb.getSelectionModel().getSelectedItem();
                str = cb.getSelectionModel().getSelectedItem();
                System.out.println(str);
                if (str.equals("MATCH")) {
                    p.msg.choice = 1;
                    p.msg.message = "Opponent Matched.";
                    //CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    CommunicationMsg temp = MakeNewMsg(msg);
                    //System.out.println("******In choice 1");
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene05();
                    // code of showing balance
                } else if (str.equals("RAISE")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Raise");
                    dialog.setHeaderText("Set Bet");
                    dialog.setContentText("Please enter your raise amount :");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        p.msg.Bet = Integer.parseInt(result.get());
                    }
                    p.msg.pot = p.msg.pot + p.msg.Bet;
                    p.balance = p.balance - p.msg.Bet;
                    p.prebet = p.msg.Bet;
                    p.msg.balance = p.balance;
                    p.msg.bidderID = p.playerID;
                    p.msg.choice = 2;
                    System.out.println("******In choice 2");
                    msg.message = "Opponent raised bet amount to " + msg.Bet + "$";
                    try {
                        CommunicationMsg temp = MakeNewMsg(msg);
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene05();
                } else if (str.equals("FOLD")) {
                    p.msg.choice = 3;
                    p.msg.message = "Opponent Folded. ";
                    p.msg.foldID = p.playerID;
                    CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });
        root1.getChildren().add(btn);

        String st1;
        String st2;
        String st3;

        st1 = Display(p.river[0]);
        st2 = Display(p.river[1]);
        st3 = Display(p.river[2]);

        Image rimg1 = new Image("file:" + st1 + ".png");
        ImageView rimv1 = new ImageView();
        rimv1.setImage(rimg1);
        rimv1.setFitHeight(70);
        rimv1.setFitWidth(50);
        rimv1.setLayoutX(578);
        rimv1.setLayoutY(300);
        root1.getChildren().add(rimv1);

        Image rimg2 = new Image("file:" + st2 + ".png");
        ImageView rimv2 = new ImageView();
        rimv2.setImage(rimg2);
        rimv2.setFitHeight(70);
        rimv2.setFitWidth(50);
        rimv2.setLayoutX(650);
        rimv2.setLayoutY(300);
        root1.getChildren().add(rimv2);

        Image rimg3 = new Image("file:" + st3 + ".png");
        ImageView rimv3 = new ImageView();
        rimv3.setImage(rimg3);
        rimv3.setFitHeight(70);
        rimv3.setFitWidth(50);
        rimv3.setLayoutX(724);
        rimv3.setLayoutY(300);
        root1.getChildren().add(rimv3);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene07() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        Rectangle rect = new Rectangle(150, 30);
        final Label label = new Label();
        label.setStyle("-fx-font: 25 arial;");
        label.setLayoutX(40);

        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(3);
        rect.setFill(Color.WHITE);

        // final String[] greetings = new String[] { "A", "B", "C" };
        final ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("CHECK", "RAISE", "FOLD"));
//        cb.setTooltip(new Tooltip("Select the language"));
        cb.setValue("CHECK");
        HBox hb = new HBox();
        hb.getChildren().addAll(cb, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene1.getRoot()).getChildren().add(hb);
        //String str = new String();
        Button btn = new Button("CLICK");
        btn.setLayoutX(102);
        btn.setLayoutY(13);
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                //str = cb.getSelectionModel().getSelectedItem();
                str = cb.getSelectionModel().getSelectedItem();
                System.out.println(str);
                if (str.equals("CHECK")) {
                    p.msg.choice = 1;
                    p.msg.message = "Opponent Matched.";
                    //CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    CommunicationMsg temp = MakeNewMsg(msg);
                    //System.out.println("******In choice 1");
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene05();
                    // code of showing balance
                } else if (str.equals("RAISE")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Raise");
                    dialog.setHeaderText("Set Bet");
                    dialog.setContentText("Please enter your raise amount :");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        p.msg.Bet = Integer.parseInt(result.get());
                    }
                    p.msg.pot = p.msg.pot + p.msg.Bet;
                    p.balance = p.balance - p.msg.Bet;
                    p.prebet = p.msg.Bet;
                    p.msg.balance = p.balance;
                    p.msg.bidderID = p.playerID;
                    p.msg.choice = 2;
                    System.out.println("******In choice 2");
                    msg.message = "Opponent raised bet amount to " + msg.Bet + "$";
                    try {
                        CommunicationMsg temp = MakeNewMsg(msg);
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene05();
                } else if (str.equals("FOLD")) {
                    p.msg.choice = 3;
                    p.msg.message = "Opponent Folded. ";
                    p.msg.foldID = p.playerID;
                    CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });
        root1.getChildren().add(btn);

        String st1;
        String st2;
        String st3;

        st1 = Display(p.river[0]);
        st2 = Display(p.river[1]);
        st3 = Display(p.river[2]);

        Image rimg1 = new Image("file:" + st1 + ".png");
        ImageView rimv1 = new ImageView();
        rimv1.setImage(rimg1);
        rimv1.setFitHeight(70);
        rimv1.setFitWidth(50);
        rimv1.setLayoutX(578);
        rimv1.setLayoutY(300);
        root1.getChildren().add(rimv1);

        Image rimg2 = new Image("file:" + st2 + ".png");
        ImageView rimv2 = new ImageView();
        rimv2.setImage(rimg2);
        rimv2.setFitHeight(70);
        rimv2.setFitWidth(50);
        rimv2.setLayoutX(650);
        rimv2.setLayoutY(300);
        root1.getChildren().add(rimv2);

        Image rimg3 = new Image("file:" + st3 + ".png");
        ImageView rimv3 = new ImageView();
        rimv3.setImage(rimg3);
        rimv3.setFitHeight(70);
        rimv3.setFitWidth(50);
        rimv3.setLayoutX(724);
        rimv3.setLayoutY(300);
        root1.getChildren().add(rimv3);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene08() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        String st1;
        String st2;
        String st3;
        String st4;

        st1 = Display(p.river[0]);
        st2 = Display(p.river[1]);
        st3 = Display(p.river[2]);
        st4 = Display(p.river[3]);

        Image rimg1 = new Image("file:" + st1 + ".png");
        ImageView rimv1 = new ImageView();
        rimv1.setImage(rimg1);
        rimv1.setFitHeight(70);
        rimv1.setFitWidth(50);
        rimv1.setLayoutX(578);
        rimv1.setLayoutY(300);
        root1.getChildren().add(rimv1);

        Image rimg2 = new Image("file:" + st2 + ".png");
        ImageView rimv2 = new ImageView();
        rimv2.setImage(rimg2);
        rimv2.setFitHeight(70);
        rimv2.setFitWidth(50);
        rimv2.setLayoutX(650);
        rimv2.setLayoutY(300);
        root1.getChildren().add(rimv2);

        Image rimg3 = new Image("file:" + st3 + ".png");
        ImageView rimv3 = new ImageView();
        rimv3.setImage(rimg3);
        rimv3.setFitHeight(70);
        rimv3.setFitWidth(50);
        rimv3.setLayoutX(724);
        rimv3.setLayoutY(300);
        root1.getChildren().add(rimv3);

        Image rimg4 = new Image("file:" + st4 + ".png");
        ImageView rimv4 = new ImageView();
        rimv4.setImage(rimg4);
        rimv4.setFitHeight(70);
        rimv4.setFitWidth(50);
        rimv4.setLayoutX(800);
        rimv4.setLayoutY(300);
        root1.getChildren().add(rimv4);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene09() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        Rectangle rect = new Rectangle(150, 30);
        final Label label = new Label();
        label.setStyle("-fx-font: 25 arial;");
        label.setLayoutX(40);

        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(3);
        rect.setFill(Color.WHITE);

        // final String[] greetings = new String[] { "A", "B", "C" };
        final ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("MATCH", "RAISE", "FOLD"));
//        cb.setTooltip(new Tooltip("Select the language"));
        cb.setValue("MATCH");
        HBox hb = new HBox();
        hb.getChildren().addAll(cb, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene1.getRoot()).getChildren().add(hb);
        //String str = new String();
        Button btn = new Button("CLICK");
        btn.setLayoutX(102);
        btn.setLayoutY(13);
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                // str = cb.getSelectionModel().getSelectedItem();
                str = cb.getSelectionModel().getSelectedItem();
                System.out.println(str);
                if (str.equals("MATCH")) {
                    p.msg.choice = 1;
                    p.msg.message = "Opponent Matched.";
                    //CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    CommunicationMsg temp = MakeNewMsg(msg);
                    //System.out.println("******In choice 1");
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene08();
                    // code of showing balance
                } else if (str.equals("RAISE")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Raise");
                    dialog.setHeaderText("Set Bet");
                    dialog.setContentText("Please enter your raise amount :");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        p.msg.Bet = Integer.parseInt(result.get());
                    }
                    p.msg.pot = p.msg.pot + p.msg.Bet;
                    p.balance = p.balance - p.msg.Bet;
                    p.prebet = p.msg.Bet;
                    p.msg.balance = p.balance;
                    p.msg.bidderID = p.playerID;
                    p.msg.choice = 2;
                    System.out.println("******In choice 2");
                    msg.message = "Opponent raised bet amount to " + msg.Bet + "$";
                    try {
                        CommunicationMsg temp = MakeNewMsg(msg);
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene08();
                } else if (str.equals("FOLD")) {
                    p.msg.choice = 3;
                    p.msg.message = "Opponent Folded. ";
                    p.msg.foldID = p.playerID;
                    CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });
        root1.getChildren().add(btn);

        String st1;
        String st2;
        String st3;
        String st4;

        st1 = Display(p.river[0]);
        st2 = Display(p.river[1]);
        st3 = Display(p.river[2]);
        st4 = Display(p.river[3]);

        Image rimg1 = new Image("file:" + st1 + ".png");
        ImageView rimv1 = new ImageView();
        rimv1.setImage(rimg1);
        rimv1.setFitHeight(70);
        rimv1.setFitWidth(50);
        rimv1.setLayoutX(578);
        rimv1.setLayoutY(300);
        root1.getChildren().add(rimv1);

        Image rimg2 = new Image("file:" + st2 + ".png");
        ImageView rimv2 = new ImageView();
        rimv2.setImage(rimg2);
        rimv2.setFitHeight(70);
        rimv2.setFitWidth(50);
        rimv2.setLayoutX(650);
        rimv2.setLayoutY(300);
        root1.getChildren().add(rimv2);

        Image rimg3 = new Image("file:" + st3 + ".png");
        ImageView rimv3 = new ImageView();
        rimv3.setImage(rimg3);
        rimv3.setFitHeight(70);
        rimv3.setFitWidth(50);
        rimv3.setLayoutX(724);
        rimv3.setLayoutY(300);
        root1.getChildren().add(rimv3);

        Image rimg4 = new Image("file:" + st4 + ".png");
        ImageView rimv4 = new ImageView();
        rimv4.setImage(rimg4);
        rimv4.setFitHeight(70);
        rimv4.setFitWidth(50);
        rimv4.setLayoutX(800);
        rimv4.setLayoutY(300);
        root1.getChildren().add(rimv4);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene10() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        Rectangle rect = new Rectangle(150, 30);
        final Label label = new Label();
        label.setStyle("-fx-font: 25 arial;");
        label.setLayoutX(40);

        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(3);
        rect.setFill(Color.WHITE);

        // final String[] greetings = new String[] { "A", "B", "C" };
        final ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("CHECK", "RAISE", "FOLD"));
//        cb.setTooltip(new Tooltip("Select the language"));
        cb.setValue("CHECK");
        HBox hb = new HBox();
        hb.getChildren().addAll(cb, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene1.getRoot()).getChildren().add(hb);
        //String str = new String();
        Button btn = new Button("CLICK");
        btn.setLayoutX(102);
        btn.setLayoutY(13);
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                // str = cb.getSelectionModel().getSelectedItem();
                str = cb.getSelectionModel().getSelectedItem();
                System.out.println(str);
                if (str.equals("CHECK")) {
                    p.msg.choice = 1;
                    p.msg.message = "Opponent Matched.";
                    //CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    CommunicationMsg temp = MakeNewMsg(msg);
                    //System.out.println("******In choice 1");
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene08();
                    // code of showing balance
                } else if (str.equals("RAISE")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Raise");
                    dialog.setHeaderText("Set Bet");
                    dialog.setContentText("Please enter your raise amount :");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        p.msg.Bet = Integer.parseInt(result.get());
                    }
                    p.msg.pot = p.msg.pot + p.msg.Bet;
                    p.balance = p.balance - p.msg.Bet;
                    p.prebet = p.msg.Bet;
                    p.msg.balance = p.balance;
                    p.msg.bidderID = p.playerID;
                    p.msg.choice = 2;
                    System.out.println("******In choice 2");
                    msg.message = "Opponent raised bet amount to " + msg.Bet + "$";
                    try {
                        CommunicationMsg temp = MakeNewMsg(msg);
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene08();
                } else if (str.equals("FOLD")) {
                    p.msg.choice = 3;
                    p.msg.message = "Opponent Folded. ";
                    p.msg.foldID = p.playerID;
                    CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });
        root1.getChildren().add(btn);

        String st1;
        String st2;
        String st3;
        String st4;

        st1 = Display(p.river[0]);
        st2 = Display(p.river[1]);
        st3 = Display(p.river[2]);
        st4 = Display(p.river[3]);

        Image rimg1 = new Image("file:" + st1 + ".png");
        ImageView rimv1 = new ImageView();
        rimv1.setImage(rimg1);
        rimv1.setFitHeight(70);
        rimv1.setFitWidth(50);
        rimv1.setLayoutX(578);
        rimv1.setLayoutY(300);
        root1.getChildren().add(rimv1);

        Image rimg2 = new Image("file:" + st2 + ".png");
        ImageView rimv2 = new ImageView();
        rimv2.setImage(rimg2);
        rimv2.setFitHeight(70);
        rimv2.setFitWidth(50);
        rimv2.setLayoutX(650);
        rimv2.setLayoutY(300);
        root1.getChildren().add(rimv2);

        Image rimg3 = new Image("file:" + st3 + ".png");
        ImageView rimv3 = new ImageView();
        rimv3.setImage(rimg3);
        rimv3.setFitHeight(70);
        rimv3.setFitWidth(50);
        rimv3.setLayoutX(724);
        rimv3.setLayoutY(300);
        root1.getChildren().add(rimv3);

        Image rimg4 = new Image("file:" + st4 + ".png");
        ImageView rimv4 = new ImageView();
        rimv4.setImage(rimg4);
        rimv4.setFitHeight(70);
        rimv4.setFitWidth(50);
        rimv4.setLayoutX(800);
        rimv4.setLayoutY(300);
        root1.getChildren().add(rimv4);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene11() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        String st1;
        String st2;
        String st3;
        String st4;
        String st5;

        st1 = Display(p.river[0]);
        st2 = Display(p.river[1]);
        st3 = Display(p.river[2]);
        st4 = Display(p.river[3]);
        st5 = Display(p.river[4]);

        Image rimg1 = new Image("file:" + st1 + ".png");
        ImageView rimv1 = new ImageView();
        rimv1.setImage(rimg1);
        rimv1.setFitHeight(70);
        rimv1.setFitWidth(50);
        rimv1.setLayoutX(578);
        rimv1.setLayoutY(300);
        root1.getChildren().add(rimv1);

        Image rimg2 = new Image("file:" + st2 + ".png");
        ImageView rimv2 = new ImageView();
        rimv2.setImage(rimg2);
        rimv2.setFitHeight(70);
        rimv2.setFitWidth(50);
        rimv2.setLayoutX(650);
        rimv2.setLayoutY(300);
        root1.getChildren().add(rimv2);

        Image rimg3 = new Image("file:" + st3 + ".png");
        ImageView rimv3 = new ImageView();
        rimv3.setImage(rimg3);
        rimv3.setFitHeight(70);
        rimv3.setFitWidth(50);
        rimv3.setLayoutX(724);
        rimv3.setLayoutY(300);
        root1.getChildren().add(rimv3);

        Image rimg4 = new Image("file:" + st4 + ".png");
        ImageView rimv4 = new ImageView();
        rimv4.setImage(rimg4);
        rimv4.setFitHeight(70);
        rimv4.setFitWidth(50);
        rimv4.setLayoutX(800);
        rimv4.setLayoutY(300);
        root1.getChildren().add(rimv4);

        Image rimg5 = new Image("file:" + st5 + ".png");
        ImageView rimv5 = new ImageView();
        rimv5.setImage(rimg5);
        rimv5.setFitHeight(70);
        rimv5.setFitWidth(50);
        rimv5.setLayoutX(876);
        rimv5.setLayoutY(300);
        root1.getChildren().add(rimv5);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene12() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        Rectangle rect = new Rectangle(150, 30);
        final Label label = new Label();
        label.setStyle("-fx-font: 25 arial;");
        label.setLayoutX(40);

        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(3);
        rect.setFill(Color.WHITE);

        // final String[] greetings = new String[] { "A", "B", "C" };
        final ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("MATCH", "RAISE", "FOLD"));
//        cb.setTooltip(new Tooltip("Select the language"));
        cb.setValue("MATCH");
        HBox hb = new HBox();
        hb.getChildren().addAll(cb, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene1.getRoot()).getChildren().add(hb);
        //String str = new String();
        Button btn = new Button("CLICK");
        btn.setLayoutX(102);
        btn.setLayoutY(13);
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                // str = cb.getSelectionModel().getSelectedItem();
                str = cb.getSelectionModel().getSelectedItem();
                System.out.println(str);
                if (str.equals("MATCH")) {
                    p.msg.choice = 1;
                    p.msg.message = "Opponent Matched.";
                    //CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    CommunicationMsg temp = MakeNewMsg(msg);
                    //System.out.println("******In choice 1");
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene11();
                    // code of showing balance
                } else if (str.equals("RAISE")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Raise");
                    dialog.setHeaderText("Set Bet");
                    dialog.setContentText("Please enter your raise amount :");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        p.msg.Bet = Integer.parseInt(result.get());
                    }
                    p.msg.pot = p.msg.pot + p.msg.Bet;
                    p.balance = p.balance - p.msg.Bet;
                    p.prebet = p.msg.Bet;
                    p.msg.balance = p.balance;
                    p.msg.bidderID = p.playerID;
                    p.msg.choice = 2;
                    System.out.println("******In choice 2");
                    msg.message = "Opponent raised bet amount to " + msg.Bet + "$";
                    try {
                        CommunicationMsg temp = MakeNewMsg(msg);
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene11();
                } else if (str.equals("FOLD")) {
                    p.msg.choice = 3;
                    p.msg.message = "Opponent Folded. ";
                    p.msg.foldID = p.playerID;
                    CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });
        root1.getChildren().add(btn);

        String st1;
        String st2;
        String st3;
        String st4;
        String st5;

        st1 = Display(p.river[0]);
        st2 = Display(p.river[1]);
        st3 = Display(p.river[2]);
        st4 = Display(p.river[3]);
        st5 = Display(p.river[4]);

        Image rimg1 = new Image("file:" + st1 + ".png");
        ImageView rimv1 = new ImageView();
        rimv1.setImage(rimg1);
        rimv1.setFitHeight(70);
        rimv1.setFitWidth(50);
        rimv1.setLayoutX(578);
        rimv1.setLayoutY(300);
        root1.getChildren().add(rimv1);

        Image rimg2 = new Image("file:" + st2 + ".png");
        ImageView rimv2 = new ImageView();
        rimv2.setImage(rimg2);
        rimv2.setFitHeight(70);
        rimv2.setFitWidth(50);
        rimv2.setLayoutX(650);
        rimv2.setLayoutY(300);
        root1.getChildren().add(rimv2);

        Image rimg3 = new Image("file:" + st3 + ".png");
        ImageView rimv3 = new ImageView();
        rimv3.setImage(rimg3);
        rimv3.setFitHeight(70);
        rimv3.setFitWidth(50);
        rimv3.setLayoutX(724);
        rimv3.setLayoutY(300);
        root1.getChildren().add(rimv3);

        Image rimg4 = new Image("file:" + st4 + ".png");
        ImageView rimv4 = new ImageView();
        rimv4.setImage(rimg4);
        rimv4.setFitHeight(70);
        rimv4.setFitWidth(50);
        rimv4.setLayoutX(800);
        rimv4.setLayoutY(300);
        root1.getChildren().add(rimv4);

        Image rimg5 = new Image("file:" + st5 + ".png");
        ImageView rimv5 = new ImageView();
        rimv5.setImage(rimg5);
        rimv5.setFitHeight(70);
        rimv5.setFitWidth(50);
        rimv5.setLayoutX(876);
        rimv5.setLayoutY(300);
        root1.getChildren().add(rimv5);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene13() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        String s1; //=new String(); 
        String s2;
        Text bal = new Text("Balance : " + p .balance);
        bal.setX(100);
        bal.setY(100);
        bal.setFill(Color.WHITE);
        bal.setFont(Font.font(25));
        root1.getChildren().add(bal);

        Text t = new Text("MY CARD");
        t.setX(691);
        t.setY(550);
        t.setFill(Color.WHITE);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t.setFont(Font.font(25));
        root1.getChildren().add(t);
        s1 = Display(p.hand[0]);
        System.out.println(s1);
        Image playcard1 = new Image("file:" + s1 + ".png");
        ImageView ivplaycard1 = new ImageView();
        ivplaycard1.setImage(playcard1);
        ivplaycard1.setFitHeight(70);
        ivplaycard1.setFitWidth(50);
        ivplaycard1.setLayoutX(705);
        ivplaycard1.setLayoutY(436);
        root1.getChildren().add(ivplaycard1);
        s2 = Display(p.hand[1]);
        Image playcard2 = new Image("file:" + s2 + ".png");
        ImageView ivplaycard2 = new ImageView();
        ivplaycard2.setImage(playcard2);
        ivplaycard2.setFitHeight(70);
        ivplaycard2.setFitWidth(50);
        ivplaycard2.setLayoutX(780);
        ivplaycard2.setLayoutY(436);
        root1.getChildren().add(ivplaycard2);

        Rectangle rect = new Rectangle(150, 30);
        final Label label = new Label();
        label.setStyle("-fx-font: 25 arial;");
        label.setLayoutX(40);

        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(3);
        rect.setFill(Color.WHITE);

        // final String[] greetings = new String[] { "A", "B", "C" };
        final ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("CHECK", "RAISE", "FOLD"));
//        cb.setTooltip(new Tooltip("Select the language"));
        cb.setValue("CHECK");
        HBox hb = new HBox();
        hb.getChildren().addAll(cb, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));

        ((Group) scene1.getRoot()).getChildren().add(hb);
        //String str = new String();
        Button btn = new Button("CLICK");
        btn.setLayoutX(102);
        btn.setLayoutY(13);
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                // str = cb.getSelectionModel().getSelectedItem();
                str = cb.getSelectionModel().getSelectedItem();
                System.out.println(str);
                if (str.equals("CHECK")) {
                    p.msg.choice = 1;
                    p.msg.message = "Opponent Matched.";
                    //CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    CommunicationMsg temp = MakeNewMsg(msg);
                    //System.out.println("******In choice 1");
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene11();
                    // code of showing balance
                } else if (str.equals("RAISE")) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Raise");
                    dialog.setHeaderText("Set Bet");
                    dialog.setContentText("Please enter your raise amount :");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        p.msg.Bet = Integer.parseInt(result.get());
                    }
                    p.msg.pot = p.msg.pot + p.msg.Bet;
                    p.balance = p.balance - p.msg.Bet;
                    p.prebet = p.msg.Bet;
                    p.msg.balance = p.balance;
                    p.msg.bidderID = p.playerID;
                    p.msg.choice = 2;
                    System.out.println("******In choice 2");
                    msg.message = "Opponent raised bet amount to " + msg.Bet + "$";
                    try {
                        CommunicationMsg temp = MakeNewMsg(msg);
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene11();
                } else if (str.equals("FOLD")) {
                    p.msg.choice = 3;
                    p.msg.message = "Opponent Folded. ";
                    p.msg.foldID = p.playerID;
                    CommunicationMsg temp = p.MakeNewMsg(p.msg);
                    try {
                        oos.writeObject(temp);
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
        root1.getChildren().add(btn);

        String st1;
        String st2;
        String st3;
        String st4;
        String st5;

        st1 = Display(p.river[0]);
        st2 = Display(p.river[1]);
        st3 = Display(p.river[2]);
        st4 = Display(p.river[3]);
        st5 = Display(p.river[4]);

        Image rimg1 = new Image("file:" + st1 + ".png");
        ImageView rimv1 = new ImageView();
        rimv1.setImage(rimg1);
        rimv1.setFitHeight(70);
        rimv1.setFitWidth(50);
        rimv1.setLayoutX(578);
        rimv1.setLayoutY(300);
        root1.getChildren().add(rimv1);

        Image rimg2 = new Image("file:" + st2 + ".png");
        ImageView rimv2 = new ImageView();
        rimv2.setImage(rimg2);
        rimv2.setFitHeight(70);
        rimv2.setFitWidth(50);
        rimv2.setLayoutX(650);
        rimv2.setLayoutY(300);
        root1.getChildren().add(rimv2);

        Image rimg3 = new Image("file:" + st3 + ".png");
        ImageView rimv3 = new ImageView();
        rimv3.setImage(rimg3);
        rimv3.setFitHeight(70);
        rimv3.setFitWidth(50);
        rimv3.setLayoutX(724);
        rimv3.setLayoutY(300);
        root1.getChildren().add(rimv3);

        Image rimg4 = new Image("file:" + st4 + ".png");
        ImageView rimv4 = new ImageView();
        rimv4.setImage(rimg4);
        rimv4.setFitHeight(70);
        rimv4.setFitWidth(50);
        rimv4.setLayoutX(800);
        rimv4.setLayoutY(300);
        root1.getChildren().add(rimv4);

        Image rimg5 = new Image("file:" + st5 + ".png");
        ImageView rimv5 = new ImageView();
        rimv5.setImage(rimg5);
        rimv5.setFitHeight(70);
        rimv5.setFitWidth(50);
        rimv5.setLayoutX(876);
        rimv5.setLayoutY(300);
        root1.getChildren().add(rimv5);

        stage.setScene(scene1);
        stage.show();
    }

    public static void Scene14() {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1);
        Image image = new Image("file:background.png");
        ImageView playimageView = new ImageView();
        playimageView.setImage(image);
        playimageView.setX(0);
        playimageView.setY(0);
        playimageView.setFitWidth(1368);

        playimageView.setFitHeight(768);
        root1.getChildren().add(playimageView);
        Image pokertable = new Image("file:Table.png");

        ImageView ivp = new ImageView();
        ivp.setImage(pokertable);
        ivp.setFitWidth(700);

        ivp.setFitHeight(450);
        ivp.setLayoutX(400);
        ivp.setLayoutY(50);
        root1.getChildren().add(ivp);

        Text t1 = new Text("You Got " + p.msg.handname);
        t1.setX(490);
        t1.setY(550);
        t1.setFill(Color.SALMON);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t1.setFont(Font.font(null, FontWeight.BOLD, 50));
        root1.getChildren().add(t1);

        Text t2 = new Text(p.msg.message);
        t2.setX(300);
        t2.setY(625);
        t2.setFill(Color.SALMON);
//        t.setLayoutX(212);
//        t.setLayoutY(212);
        t2.setFont(Font.font(null, FontWeight.BOLD, 50));
        root1.getChildren().add(t2);

        String stw1;
        String stw2;
        String stw3;
        String stw4;
        String stw5;

        stw1 = Display(p.msg.winningcards[0]);
        stw2 = Display(p.msg.winningcards[1]);
        stw3 = Display(p.msg.winningcards[2]);
        stw4 = Display(p.msg.winningcards[3]);
        stw5 = Display(p.msg.winningcards[4]);

        Image wrimg1 = new Image("file:" + stw1 + ".png");
        ImageView wrimv1 = new ImageView();
        wrimv1.setImage(wrimg1);
        wrimv1.setFitHeight(70);
        wrimv1.setFitWidth(50);
        wrimv1.setLayoutX(578);
        wrimv1.setLayoutY(300);
        root1.getChildren().add(wrimv1);

        Image wrimg2 = new Image("file:" + stw2 + ".png");
        ImageView wrimv2 = new ImageView();
        wrimv2.setImage(wrimg2);
        wrimv2.setFitHeight(70);
        wrimv2.setFitWidth(50);
        wrimv2.setLayoutX(650);
        wrimv2.setLayoutY(300);
        root1.getChildren().add(wrimv2);

        Image wrimg3 = new Image("file:" + stw3 + ".png");
        ImageView wrimv3 = new ImageView();
        wrimv3.setImage(wrimg3);
        wrimv3.setFitHeight(70);
        wrimv3.setFitWidth(50);
        wrimv3.setLayoutX(724);
        wrimv3.setLayoutY(300);
        root1.getChildren().add(wrimv3);

        Image wrimg4 = new Image("file:" + stw4 + ".png");
        ImageView wrimv4 = new ImageView();
        wrimv4.setImage(wrimg4);
        wrimv4.setFitHeight(70);
        wrimv4.setFitWidth(50);
        wrimv4.setLayoutX(800);
        wrimv4.setLayoutY(300);
        root1.getChildren().add(wrimv4);

        Image wrimg5 = new Image("file:" + stw5 + ".png");
        ImageView wrimv5 = new ImageView();
        wrimv5.setImage(wrimg5);
        wrimv5.setFitHeight(70);
        wrimv5.setFitWidth(50);
        wrimv5.setLayoutX(876);
        wrimv5.setLayoutY(300);
        root1.getChildren().add(wrimv5);

        stage.setScene(scene1);
        stage.show();

    }

    public static void menu() {
        Group root = new Group();
        Scene scene = new Scene(root);

        scene.setFill(Color.TRANSPARENT);
        Image image = new Image("file:giphy.gif");

        // simple displays ImageView the image as is
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        ImageView playimageView = new ImageView("file:Play.png");

        playimageView.setFitWidth(160);

        playimageView.setFitHeight(140);

        playimageView.setX(40);
        playimageView.setY(170);
        playimageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Scene02();
            }
        });

        ImageView creditsimageView = new ImageView("file:Credit.png");
        creditsimageView.setFitWidth(160);
        creditsimageView.setFitHeight(140);
        creditsimageView.setX(40);
        creditsimageView.setY(530);

        // root.getChildren().add(creditsimageView);
        ImageView rulesimageView = new ImageView("file:Rule.png");
        rulesimageView.setFitWidth(160);
        rulesimageView.setFitHeight(140);
        rulesimageView.setX(40);
        rulesimageView.setY(350);
        root.getChildren().add(iv1);
        root.getChildren().add(playimageView);
        root.getChildren().add(creditsimageView);
        root.getChildren().add(rulesimageView);
        iv1.fitWidthProperty().bind(stage.widthProperty());
        iv1.fitHeightProperty().bind(stage.heightProperty());
        stage.setTitle("POKER");
        //stage.setWidth(415);
        //stage.setHeight(200);
        // scene.setOnMouseClicked(mouseHandler);
        stage.setScene(scene);
        // stage.sizeToScene();
        stage.show();
    }

    @Override
    public void start(Stage pstage) throws Exception {
        stage = pstage;
        p = new Player();
        menu();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public static String Display(Card card) {
        String strsuit = null, strrank = null, str = null;
        if (card.suit == 1) {
            strsuit = new String("S");
        }
        if (card.suit == 2) {
            strsuit = new String("H");
        }
        if (card.suit == 3) {
            strsuit = new String("D");
        }
        if (card.suit == 4) {
            strsuit = new String("C");
        }
        if (card.rank == 14) {
            strrank = new String("14");
        }
        if (card.rank == 2) {
            strrank = new String("2");
        }
        if (card.rank == 3) {
            strrank = new String("3");
        }
        if (card.rank == 4) {
            strrank = new String("4");
        }
        if (card.rank == 5) {
            strrank = new String("5");
        }
        if (card.rank == 6) {
            strrank = new String("6");
        }
        if (card.rank == 7) {
            strrank = new String("7");
        }
        if (card.rank == 8) {
            strrank = new String("8");
        }
        if (card.rank == 9) {
            strrank = new String("9");
        }
        if (card.rank == 10) {
            strrank = new String("10");
        }
        if (card.rank == 11) {
            strrank = new String("11");
        }
        if (card.rank == 12) {
            strrank = new String("12");
        }
        if (card.rank == 13) {
            strrank = new String("13");
        }

        str = strsuit + strrank;
        return str;
    }

    public static CommunicationMsg MakeNewMsg(CommunicationMsg x) {
        CommunicationMsg temp = new CommunicationMsg();
        temp.Bet = x.Bet;
        temp.winnerID = x.winnerID;
        temp.SortedCard = x.SortedCard;
        temp.balance = x.balance;
        temp.choice = x.choice;
        temp.hand = x.hand;
        temp.pot = x.pot;
        temp.river = x.river;
        temp.type = x.type;
        temp.bidderID = x.bidderID;
        temp.playerID = x.playerID;
        temp.rank = x.rank;
        temp.handname = x.handname;
        temp.winningcards = x.winningcards;
        temp.message = x.message;
        return temp;
    }

}
