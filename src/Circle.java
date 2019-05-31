import processing.core.PApplet;

public class Circle extends Figure {

    public Circle(int maxCenterOffset) {
        super(maxCenterOffset);
    }

    float radius;

    public void paint(PApplet applet, float x, float y) {
        applet.fill(color1, color2, color3);
        applet.circle(x, y, radius*2);
    }

    public void randomSize() {
        radius = random(10, maxCenterOffset);
    }

    @Override
    public boolean contains(float x, float y, int mouseX, int mouseY) {
        float cornerX = x - radius*2;
        float cornerY = y - radius*2;

        return mouseX >= cornerX && mouseX <= cornerX + width &&
                mouseY >= cornerY && mouseY <= cornerY + height;
    }
}
