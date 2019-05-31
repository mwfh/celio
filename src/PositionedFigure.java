public class PositionedFigure {
    float x;
    float y;

    public Figure getFigure() {
        return figure;
    }

    Figure figure;

    public PositionedFigure(float x, float y, Figure figure) {
        this.x = x;
        this.y = y;
        this.figure = figure;
    }

    public void paint(processing.core.PApplet applet) {
        this.figure.paint(applet, x, y);
    }

    public boolean contains(int mouseX, int mouseY) {
        return this.figure.contains(this.x, this.y, mouseX, mouseY);
    }
}
