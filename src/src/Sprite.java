import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
public class Sprite extends Rectangle {
    boolean dead = false;
   // static ArrayList<Sprite> seritler = new ArrayList<>();
    double speed = 1;
    final String type;
    /*public static ArrayList<Sprite> getSeritler() {
        return seritler;
    }*/
    Sprite(int x, int y, int h, int w, String type, Color color){
        super(w,h,color);
        this.type=type;
        setTranslateX(x);
        setTranslateY(y);
    }
    void moveLeft(){
        setTranslateX(getTranslateX()-5);
    }
    void moveRight(){
        setTranslateX(getTranslateX()+5);
    }
   /* void moveUp(){
        //speed=speed+(double)35/100;
        for(Sprite s : seritler){
            s.setTranslateX(getTranslateX()+5);
        }

    }*/
    void moveDown(){
        speed=speed-(double)(35/100);
    }
}