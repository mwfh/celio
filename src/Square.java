import processing.core.PApplet;

public class Square extends Figure {

    float width, height;

    public Square(int maxCenterOffset)
    {
        super(maxCenterOffset);
    }

    public void paint(PApplet applet, float x, float y)
    {
        println(color1 + ", " + color2 + ", " + color3);
        applet.fill(color1,color2,color3);
        applet.rect(x - width/2, y - height/2, width, height);
    }

    public void randomSize()
    {
        width = random(10,maxCenterOffset);
        height = random(10, maxCenterOffset);
    }

    @Override
    public boolean contains(float x, float y, int mouseX, int mouseY) {
        float cornerX = x - width/2;
        float cornerY = y - height/2;

        return mouseX >= cornerX && mouseX <= cornerX + width &&
                mouseY >= cornerY && mouseY <= cornerY + height;
    }
}
