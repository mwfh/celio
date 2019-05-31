public class Circle extends Figure {

    float sx,sy,ex,ey= -1;

    public Circle()
    {
        super();
    }

    public void paint()
    {
        run.fill(color1,color2,color3);
        run.circle(sx, sy, ex);
    }


    public void randomSize()
    {
        ex = random(10,50);
        ey = random(10,50);
    }

    public void randomPos()
    {
        sx = random(ex,  run.width - ex);
        sy = random(top+ex, run.height - bottom - ey);
    }

}
