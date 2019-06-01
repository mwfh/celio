import processing.core.PApplet;

public class Triangle extends Figure {

    public Triangle(int maxCenterOffset)
    {
        super(maxCenterOffset);
    }

    float offsetY1;
    float offsetX2, offsetY2;
    float offsetX3, offsetY3;

    public void paint(PApplet applet, float x, float y)
    {
        applet.fill(color1,color2,color3);
        applet.triangle(x,y - offsetY1,
                x - offsetX2, y + offsetY2,
                x + offsetX3, y + offsetY3);
    }

    public void randomSize()
    {
        offsetY1 = random(5, maxCenterOffset);
        offsetX2 = random(5, maxCenterOffset);
        offsetY2 = random(5, maxCenterOffset);
        offsetX3 = random(5, maxCenterOffset);
        offsetY3 = random(5, maxCenterOffset);
    }

    @Override
    public boolean contains(float x, float y, int mouseX, int mouseY) {

        float cornerA = x - offsetX3;
        float cornerB = y - offsetY3;


        return mouseX >= cornerA && mouseX <= cornerA + width &&
                mouseY >= cornerB && mouseY <= cornerB + height;
    }
}



