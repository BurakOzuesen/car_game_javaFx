import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.util.Random;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
public class Main extends Application {
    private Pane root = new Pane();
    public double speed=1;
    int levelCounter=0;
    ArrayList<Sprite> seritler = new ArrayList<>();
    ArrayList<String> yon = new ArrayList<>();
    ArrayList<Circle> trees = new ArrayList<>();
    ArrayList<Sprite> arabalar = new ArrayList<>();
    ArrayList<Integer> puanlar = new ArrayList<>();

    private Rectangle garden = new Rectangle(80,600,Color.GREEN);
    private Rectangle garden1 = new Rectangle(80,600,Color.GREEN);
    private Rectangle road = new Rectangle(440,600,Color.GREY);
    private Sprite player = new Sprite(280,500,80,40,"player",Color.RED);
    private Sprite serit = new Sprite(295,600,40,10,"yol",Color.BLACK);
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {

            if (yon.contains("LEFT")){
                player.moveLeft();
            }
            if (yon.contains("RIGHT")) {
                player.moveRight();
            }
            if (yon.contains("UP")){
                speed = speed + (0.01*puanlar.get(0));
                for (Sprite s : seritler){
                    s.setTranslateY(s.getTranslateY()+speed);
                    if(s.getTranslateY() >= 600){
                        s.setTranslateY(-30);
                    }
                }
                for (Circle c : trees){
                    c.setTranslateY(c.getTranslateY()+speed);
                    if(c.getTranslateY() > 600){
                        c.setTranslateY(-20);
                    }
                }
                for (Sprite s : arabalar){
                    s.setTranslateY(s.getTranslateY()+speed);
                    if(s.getTranslateY() > 600){
                        s.setTranslateY(-40);
                        Random r = new Random();
                        double randomValue1 = 80 + (480-80) * r.nextDouble();
                        s.setTranslateX(randomValue1);
                        s.setFill(Color.YELLOW);
                    }
                    if(s.getBoundsInParent().intersects(player.getBoundsInParent())){
                        player.setFill(Color.BLACK);
                        s.setFill(Color.BLACK);
                        speed=0;
                        Canvas canvasS = new Canvas( 400, 200 );
                        //root.getChildren().add( canvasS );
                        GraphicsContext gcc = canvasS.getGraphicsContext2D();
                        gcc.setFill( Color.RED );
                        gcc.setStroke( Color.BLACK );
                        gcc.setLineWidth(2);
                        Font theFont = Font.font( "Times New Roman", FontWeight.THIN, 30 );
                        gcc.setFont( theFont );
                        gcc.fillText( "GAME OVER!", 90, 50 );
                        gcc.fillText( "PRESS ENTER TO", 90, 82 );
                        gcc.fillText( "RESTART", 90, 114 );
                        root.getChildren().add(canvasS);

                    }
                    else if(s.getTranslateY()>500){
                        s.setFill(Color.GREEN);

                    }

                }
            }


            if (!yon.contains("UP")){
                if(speed > 0){
                    speed = speed - 0.06;

                    for (Sprite s : seritler) {
                        s.setTranslateY(s.getTranslateY() + speed);
                        if (s.getTranslateY() >= 600) {
                            s.setTranslateY(-30);
                        }
                    }
                    for (Circle c : trees){
                        c.setTranslateY(c.getTranslateY()+speed);
                        if(c.getTranslateY() > 600){
                            c.setTranslateY(-20);
                        }
                    }
                    for (Sprite s : arabalar){
                        s.setTranslateY(s.getTranslateY()+speed);
                        if(s.getTranslateY() >600){
                            s.setTranslateY(-40);
                            Random rr = new Random();
                            double randomValue1 = 80 + (480-80) * rr.nextDouble();
                            s.setTranslateX(randomValue1);
                            s.setFill(Color.YELLOW);
                        }
                        if(s.getBoundsInParent().intersects(player.getBoundsInParent())){
                            player.setFill(Color.BLACK);
                            s.setFill(Color.BLACK);
                            speed=0;
                            Canvas canvasS = new Canvas( 400, 200 );
                            //root.getChildren().add( canvasS );
                            GraphicsContext gcc = canvasS.getGraphicsContext2D();
                            gcc.setFill( Color.RED );
                            gcc.setStroke( Color.BLACK );
                            gcc.setLineWidth(2);
                            Font theFont = Font.font( "Times New Roman", FontWeight.THIN, 30 );
                            gcc.setFont( theFont );
                            gcc.fillText( "GAME OVER!", 90, 50 );
                            gcc.fillText( "PRESS ENTER TO", 90, 82 );
                            gcc.fillText( "RESTART", 90, 114 );
                            root.getChildren().add(canvasS);

                        }
                        else if(s.getTranslateY()>500){
                            s.setFill(Color.GREEN);

                        }
                    }
                }

            }
        }
    };
    private void tree(){
        Random r = new Random();
        double randomValue1 = 20 + (40) * r.nextDouble();
        double randomValue11 = 20 + (40) * r.nextDouble();
        double randomValue111 = 20 + (40) * r.nextDouble();
        double randomValue2 = 540 + (580 - 540) * r.nextDouble();
        double randomValue22 = 540 + (580 - 540) * r.nextDouble();
        double randomValue222 = 540 + (580 - 540) * r.nextDouble();
        double randomValue3 = 0 + (580 ) * r.nextDouble();
        double randomValue33 = 0 + (580 ) * r.nextDouble();
        double randomValue333 = 0 + (580 ) * r.nextDouble();
        double randomValue4 = 0 + (580 ) * r.nextDouble();
        double randomValue44 = 0 + (580 ) * r.nextDouble();
        double randomValue444 = 0 + (580 ) * r.nextDouble();
        for (int i=0;i<3;i=i+1){
            Circle myTree1 = new Circle(randomValue1,randomValue3,20,Color.DARKGREEN); // sol
            Circle myTree2 = new Circle(randomValue2,randomValue4,20,Color.DARKGREEN); // sag
            Circle myTree3 = new Circle(randomValue11,randomValue33,20,Color.DARKGREEN); // sol
            Circle myTree4 = new Circle(randomValue111,randomValue333,20,Color.DARKGREEN); // sol
            Circle myTree5 = new Circle(randomValue22,randomValue44,20,Color.DARKGREEN); //
            Circle myTree6 = new Circle(randomValue222,randomValue444,20,Color.DARKGREEN); //
            root.getChildren().add(myTree1);
            root.getChildren().add(myTree2);
            root.getChildren().add(myTree3);
            root.getChildren().add(myTree4);
            root.getChildren().add(myTree5);
            root.getChildren().add(myTree6);
            trees.add(myTree1);
            trees.add(myTree2);
            trees.add(myTree3);
            trees.add(myTree4);
            trees.add(myTree5);
            trees.add(myTree6);
        }


    }
    private void serit(){
        for (int i=0;i<599;i=i+50){
            Sprite serit = new Sprite(295, i, 25, 10, "yol", Color.BLACK);
            root.getChildren().add(serit);
           // Sprite.getSeritler().add(serit);
            seritler.add(serit);
        }
    }

    private void araba(){
        Sprite araba1 = new Sprite(90,10,80,40,"rakip",Color.YELLOW);
        Sprite araba2 = new Sprite(200,130,80,40,"rakip",Color.YELLOW);
        Sprite araba3 = new Sprite(310,250,80,40,"rakip",Color.YELLOW);
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        double randomValue11 = 80 + (400) * r1.nextDouble();
        double randomValue12 = 80 + (400) * r2.nextDouble();
        double randomValue13 = 80 + (400) * r3.nextDouble();
        araba1.setTranslateX(randomValue11);
        araba2.setTranslateX(randomValue12);
        araba3.setTranslateX(randomValue13);
        root.getChildren().add(araba1);
        root.getChildren().add(araba2);
        root.getChildren().add(araba3);
        arabalar.add(araba1);
        arabalar.add(araba2);
        arabalar.add(araba3);
    }
    private Parent createContent(){
        root.setPrefSize(600,600);
        garden1.setX(520);
        road.setX(80);
        int score=0;
        int level=1;
        puanlar.add(level);
        puanlar.add(score);
        root.getChildren().add(road);
        root.getChildren().add(garden);
        root.getChildren().add(garden1);
        serit();
        tree();
        araba();
        Canvas canvas = new Canvas( 80, 100 );
        root.getChildren().add( canvas );
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 20 );
        gc.setFont( theFont );
        gc.fillText( "Level: "+ puanlar.get(0), 5, 20 );
        gc.fillText( "Score: "+puanlar.get(1), 5, 35 );
        root.getChildren().add(player);
        return root;
    }
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        timer.start();
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(e -> {
            String code =e.getCode().toString();
            if (!yon.contains(code))
                yon.add(code);
            if(code.equals("ENTER")){
                stage.close();
                Platform.runLater(() -> {
                    try {
                        new Main().start(new Stage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            }
        });
        scene.setOnKeyReleased(e -> {
            String code = e.getCode().toString();
            yon.remove(code);
        });

        stage.setTitle("HUBBM-Racer");
        stage.setScene(scene);
        stage.show();

    }
}
