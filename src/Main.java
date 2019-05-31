import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet{
    //- Main Board
    int WinWidth = 800;
    int WinHeight = 600;

    //- Logo
    int imgWidth = 150;
    int imgHeight = 55;

    //- Life
    int lifeWidth = 40;
    int lifeHeight = 40;
    int lifePos = 0;
    //- Anzahl Leben
    int lifeCount = 3;
    int maxCenterOffset = 50;

    int currentLVL = 1;

    //- Time
    long lvlMaxTime = 10;
    long timeLeft;

    int countFigur = 10;
    int figureTypeCount = 3;

    //- End Message
    String EndMessage = "";

    //- Score
    long scoreCount = 0;

    //- Figure init
    ArrayList<PositionedFigure> figurePool = new ArrayList<PositionedFigure>();


    //- Grundsatzüberlegung wegen Arrays oder ArrayList und ob diese Mehrdimensional
    //- Gerade wenn es um die Leben und Zeit geht. Leben und Score müssen von Level zu level kopiert werden
    //- Zeiten nur pro Level

    processing.core.PImage imgLogo;	// Declare a variable of type PImage
    processing.core.PImage imgLife;	// Declare a variable of type PImage

    //- Auswahl der Figur für den vergleich
    int selectedFigureIndex;
    PositionedFigure selectedFigure;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(WinWidth,WinHeight);
    }

    public void setup(){

        //- Framerate Bildaufbau --> hier 1 für alle sekunden
        frameRate(1);


        imgLogo = loadImage("CELIO_bLANK.png");
        imgLife = loadImage("heart-icon.png");

        initFigure(countFigur, figureTypeCount);
        timeLeft = lvlMaxTime + 1; // we remove 1 ate first before first draw
    }
    public void badclick(){
        println(":-(");
        EndMessage = ":-(";
        textSize(32);
        textAlign(CENTER);
        text(EndMessage, WinWidth/2, (WinHeight/2)-30);
        fill(0, 102, 153);
        text(EndMessage, WinWidth/2, (WinHeight/2));
        fill(0, 102, 153, 51);
        text(EndMessage, WinWidth/2, (WinHeight/2)+30);
        textAlign(LEFT);

    }

    public void draw(){
        calcSpendTime();


        //- reset Window
        resetWindow();

        //- paintFigure
        for(int i = 0; i < figurePool.size(); i++)
        {
            figurePool.get(i).paint(this);
        }

        selectedFigure.paint(this);

        if(lifeCount == 0) {
            noLoop();
            println("Game Over");
            EndMessage = "Game Over";
            textSize(32);
            textAlign(CENTER);
            text(EndMessage, WinWidth/2, (WinHeight/2)-30);
            fill(0, 102, 153);
            text(EndMessage, WinWidth/2, (WinHeight/2));
            fill(0, 102, 153, 51);
            text(EndMessage, WinWidth/2, (WinHeight/2)+30);
            textAlign(LEFT);
        }

        drawScore();
        //- berechne Time
        drawTime();

    }

    public void initFigure(int figureCount, int readyFigure)
    {
        this.figurePool.clear();
        int ready = readyFigure;
        for(int i = 0; i < figureCount; i++)
        {
            float x = random(0 + maxCenterOffset, WinWidth - maxCenterOffset);
            float y = random(imgHeight + maxCenterOffset, WinHeight - imgHeight - maxCenterOffset*2 - 10);
            readyFigure = (int)random(0,ready)+1;
            Figure figure;
            switch(readyFigure) {
                case 1:
                     figure = new Square(maxCenterOffset);
                    break;
                case 2:
                    figure = new Circle(maxCenterOffset);
                    break;
                case 3:
                    figure = new Triangle(maxCenterOffset);
                    break;
                default:
                    figure = new Square(maxCenterOffset);
            }
            figurePool.add(new PositionedFigure(x, y, figure));
        }

        float x = WinWidth - (maxCenterOffset + 5);
        float y = WinHeight - (maxCenterOffset + 5);

        selectedFigureIndex = (int)random(1, figurePool.size()-1);

        //- Auswahl von Vorgesehen Figur
        selectedFigure =  new PositionedFigure(x, y, this.figurePool.get(selectedFigureIndex).getFigure());
    }

    public void calcSpendTime()
    {
        //- Calculate Time differenz -> Countdown from lvlMaxtime
        if(timeLeft > 0) {
            timeLeft-=1;
        }
        else
        {
            lifeCount = lifeCount - 1;
            timeLeft = lvlMaxTime;
        }
    }

    public void resetWindow()
    {
        fill(255,255,255);
        rect(0,0,WinWidth,WinHeight);
        fill(0,0,0);
        //- Abtrennung oben
        rect(0, imgHeight,WinWidth,3 );
        //- Abtrennung unten
        //rect(0, WinHeight - imgHeight -5,WinWidth,3 );
        fill(255,255,255);
        rect(WinWidth-maxCenterOffset*2-10, WinHeight - maxCenterOffset*2-10,maxCenterOffset*2+10,maxCenterOffset*2+10 );
        //- Level
        rect(0, WinHeight - imgHeight,imgWidth,imgHeight );
        fill(0,0,0);
        textSize(20);
        text("Level: " + currentLVL, 15, WinHeight - (imgHeight/2) + (imgHeight/5)  );

        //- Logo
        image(imgLogo, ((WinWidth/2)-imgWidth/2), 3, imgWidth,imgHeight);


        //- Life
        if(lifeCount > 0){
            for(int i = 0; i < lifeCount; i++)
            {
                lifePos = (i * lifeWidth) + 2 + lifeWidth;
                image(imgLife,(WinWidth-lifePos), 4, lifeWidth, lifeHeight);
            }
        }
        else
        {
            textSize(32);
            text("0", (WinWidth-(lifePos / 2)-10), 38);
        }
    }

    public void drawScore()
    {
        //- Score
        fill(0,0,0);
        textSize(14);

        text("Score: " + scoreCount , 10, 23);
    }

    public void drawTime()
    {
        fill(0,0,0);
        textSize(14);
        text("Time: " + timeLeft , 13, 42);
    }

    @Override
    public void mouseClicked()
    {
        if(this.figurePool.get(selectedFigureIndex).contains(this.mouseX, this.mouseY))
        {
            scoreCount += 10;
            currentLVL += 1;
            initFigure(countFigur, figureTypeCount);
            timeLeft = lvlMaxTime + 1;
            redraw();
        } else {
            --lifeCount;
            badclick();
            println(":-(");
        }
    }
}