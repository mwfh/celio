import processing.core.PApplet;

public abstract class Figure extends PApplet {

    PApplet run = Main.prog;

    int color1,color2,color3;

    int top = 55;
    int bottom = 60;


    public Figure()
    {
        randomColor();
        randomSize();
        randomPos();
    }

    //- Einzuführende Methoden
    public abstract void paint();
    public abstract void randomPos();
    public abstract void randomSize();

    public void setColor(int c1, int c2, int c3)
    {
        this.color1 = c1;
        this.color2 = c2;
        this.color3 = c3;
    }

    public void randomColor()
    {
        color1 = (int)random(1,255);
        color2 = (int)random(1,255);
        color3 = (int)random(1,255);
        println("color1: " + color1 + "color2: " + color2 +"color3: " + color3);
    }

    public int getColor1() {
        return color1;
    }

    public void setColor1(int color1) {
        this.color1 = color1;
    }

    public int getColor2() {
        return color2;
    }

    public void setColor2(int color2) {
        this.color2 = color2;
    }

    public int getColor3() {
        return color3;
    }

    public void setColor3(int color3) {
        this.color3 = color3;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}
