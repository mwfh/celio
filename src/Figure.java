import processing.core.PApplet;

public abstract class Figure extends PApplet {

    int color1,color2,color3;
    int maxCenterOffset;

    public Figure(int maxCenterOffset)
    {
        this.maxCenterOffset = maxCenterOffset;
        randomColor();
        randomSize();
    }

    //- Einzuführende Methoden
    public abstract void paint(PApplet applet, float x, float y);

    public abstract void randomSize();

    public void randomColor()
    {
        color1 = (int)random(1,255);
        color2 = (int)random(1,255);
        color3 = (int)random(1,255);
        println("color1: " + color1 + "color2: " + color2 +"color3: " + color3);
    }

    public abstract boolean contains(float x, float y, int mouseX, int mouseY);
}
