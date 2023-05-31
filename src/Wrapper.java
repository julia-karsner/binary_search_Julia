import processing.core.PConstants;

public class Wrapper{
    private int x;
    private int y;
    private int w;
    private int h;
    private int value;
    private CircleStates circleState;
    private ScrambleStates scrambleState;

    public Wrapper(int x, int y, int w, int h, int value){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.value = value;
        circleState = CircleStates.UNCHECKED;
        scrambleState = ScrambleStates.NOTTAKEN;
    }

    public void display(){
        if(circleState == CircleStates.UNCHECKED) {
            Main.app.fill(175, 160, 215);
            Main.app.rect(x-30, y, w, h);
            Main.app.fill(242, 246, 250);
        } else if(circleState == CircleStates.CHECKED){
            Main.app.fill(242, 246, 250);
            Main.app.rect(x-30, y, w, h);
            Main.app.fill(175, 160, 215);
        } else {
            Main.app.fill(0, 0, 0);
            Main.app.rect(x-30, y, w, h);
            Main.app.fill(242, 246, 250);
        }
        Main.app.textAlign(PConstants.CENTER, PConstants.CENTER);
        Main.app.textSize(25);
        Main.app.text(value, x+3, y +30);
    }
    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
    public void setCircleState(CircleStates circleState){
        this.circleState = circleState;
    }
    public CircleStates getCircleState(){
        return circleState;
    }
    public void setScrambleState(ScrambleStates scrambleState){
        this.scrambleState = scrambleState;
    }
    public ScrambleStates getScrambleState(){
        return scrambleState;
    }
}