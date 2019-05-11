public class Triangle extends Figure {

    public Triangle()
    {
        super();
    }

    public void paint()
    {
        run.fill(color1,color2,color3);
        run.triangle(sx,sy,ex,ey,ex2,ey2);
    }


    @Override
    public void paint(int setx, int sety, int setex,int setey, int setex2, int setey2)
    {
        run.fill(color1,color2,color3);
        run.triangle(setx,sety,setex,setey,setex2,setey2);
    }

    public void randomSize()
    {

    }

    public void randomPos()
    {
        int randNum = (int)random(0,5);
        int mainSign = (int)Math.pow(-1, randNum);

        sx = random(1,  run.width - 50);
        sy = random(top, run.height - bottom - 50);

        if(sx+(mainSign*random(25,45)) > 0)
        {
            ex = sx+(mainSign*random(25,45));
        } else {ex = 0;}
        if(sy+(mainSign*random(25,45)) > top)
        {
            ey = sy+(mainSign*random(25,45));
        } else {ey = top;}
        if(sx-(mainSign*random(25,45)) > 0)
        {
            ex2 = sx-(mainSign*random(25,45));
        } else {ex2 = 0;}
        if(sy+(mainSign*random(25,45)) > top)
        {
            ey2 = sy+(mainSign*random(25,45));
        } else {ey2 = top;}


//        ex = sx+30;
//        ey = sy+42;
//        ex2 = sx-30;
//        ey2 = sy+42;
        //ex2 = ey2 + ex2;
    }

    public String whatAmI()
    {
        return "Triangle";
    }

    public int calcPos(int setVal, int size, int window)
    {

        setVal = (setVal % size) + (window - size);

        return setVal;
    }


}

