import processing.core.PConstants;

public class Wrapper{
    private int x;
    private int y;
    private int w;
    private int h;
    private int value;
    private States state;
    private ChangeStates changeState;

    public Wrapper(int x, int y, int w, int h, int value){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.value = value;
        state = States.UNCHECKED;
        changeState = ChangeStates.NOTTAKEN;
    }

    public void display(){
        if(state == States.UNCHECKED) {
            Main.app.fill(237, 184, 135);//orginal circle
            //Main.app.rect(x-30, y, w, h);
            Main.app.circle(x+3,y+32,w);
            Main.app.fill(242, 246, 250);
        } else if(state == States.CHECKED){
            Main.app.fill(175, 240, 195);//after opened with key n
           // Main.app.rect(x-30, y, w, h);
            Main.app.circle(x+3,y+32,w);
            Main.app.fill(237, 107, 146);
        } else {
            Main.app.fill(0, 0, 0);//if circle has target value
            //Main.app.rect(x-30, y, w, h);
            Main.app.circle(x+3,y+32,w);
            Main.app.fill(242, 246, 250);
          //  setupImage("download-14.jpg");
        }
        Main.app.textAlign(PConstants.CENTER, PConstants.CENTER);
        Main.app.textSize(25);
        Main.app.text(value, x+3, y +30);
    }


  //  public void display(){
       // if(state == States.UNCHECKED) {
      //      a.setupImage("starbucks.png");
       // }

   // }
    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
    public void setCircleState(States state){
        this.state = state;
    }
    public States getState(){
        return state;
    }
    public void setChangeState(ChangeStates changeState){
        this.changeState = changeState;
    }
    public ChangeStates getChangeState(){
        return changeState;
    }
}