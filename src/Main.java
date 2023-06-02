
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.lang.Math;
import processing.core.PConstants;

import java.util.ArrayList;

public class Main extends PApplet {

    public static Main app;
    private ArrayList<Wrapper> list;
    private int bottom;
    private int top;
    private int value;
   private String strValue="";
    private boolean found;
    private int tracker;
    private int location;
    private boolean notInList;
    public boolean sorted;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public Main() {
        super();
        app = this;
    }

    public void settings() {
        size(1000, 500);
    }

    public void setup() {
        reset();
        textSize(29);


       //
      //  b.setupImage("starbucks.png");
        //c.setupImage("starbucks.png");
      ///  d.setupImage("starbucks.png");
       /// e.setupImage("starbucks.png");
     //   f.setupImage("starbucks.png");
        // g.setupImage("starbucks.png");
      ///  h.setupImage("starbucks.png");



        Table table = loadTable("stores.csv", "header");
        for (TableRow row : table.rows()) {
            int year = row.getInt("year"); // obtain year data
            int stores = row.getInt("stores"); // obtain starbucks stores quantity
            list.add(new Wrapper(stores, height / 2, width / 15, width / 15, year));

        }
        reset();

    }

    public void draw() {
        background(245, 130, 226);
        for (Wrapper wrapper : list) {
            wrapper.display();
        }
        Main.app.textAlign(PConstants.CENTER, PConstants.CENTER);
        if (!sorted) {
            fill(255);
            text("1. Press 'f' to sort the list", width / 2, height / 4);
        } else if (found) {
            fill(255);
            text(("The value was found at index " + location + " in " + tracker + " checks"), width / 2, height / 4);
            text("Press 'r' to reset", width / 2, height / 5);
        } else if (value==0) {
            fill(255);
            text("2. Please type in the value that you would like to search for then press 's' :) ", width / 2, height / 4);
        } else if(tracker==0 && value>0){
            fill(255);
            text("3. Press 'a' to search", width / 2, height / 4);
        }   else if (!found&& value>0 && !notInList) {
                fill(255);
                text(("The value was not found at index " + location + " in " + tracker + " checks"), width / 2, height / 4);
        } else if (notInList) {
            fill(255);
            text(("The value " + value + " is not in the list"), width / 2, height / 4);
            text("Press 'r' to reset", width / 2, height / 6);
        } else if (list.get(list.size() / 2).getState() == States.CHECKED && tracker>1) {
            fill(255);
            text(("The value was not found at " + location + ". There  has been " + tracker + " check"), width / 2, height / 4);

       // } else if(tracker==0 && value>0){
            //fill(255);
            //text("3. Press 'n' to search", width / 2, height / 4);
        }
        if (!notInList && !found) {
            text("The value you are searching for is: " + strValue, width /3, height/7 );
        }
       // Main.app.fill(255, 255, 255){
        //    Main.app.text(width / 20, height / 2, width / 15, width / 15, years);
         //   Main.app.text(width / 20, height / 2, width / 15, width / 15, stores);
        }




    public void reset(){
        int x = width/20;
        int y = height/2;
        int w = width/15;
        int h = width/15;
        int target = 1;
        list = new ArrayList<Wrapper>();
        for(int i = 0; i < 10; i++){
            double powerOne = Math.pow(2, target);
            int power = (int)powerOne;
            Wrapper wrap = new Wrapper(x, y, w, h, power);
            x += (width/20) * 2;
            target++;
            list.add(wrap);
        }
        scrambler();
        top = list.size() - 1;
        bottom = 0;
        value = 0;
        strValue = "";
        found = false;
        tracker = 0;
        notInList = false;
        sorted = false;
    }

    private int binarySearchIterative(ArrayList<Wrapper> arr, int value){
        int mid = bottom + (top - bottom) / 2;
        if(arr.get(mid).getState() == States.CHECKED||(location==10 && arr.get(mid).getValue()< value)|| (location==1 && arr.get(mid).getValue()>value)) {
            notInList = true;
            return -1;

        }
        States c = States.CHECKED;
        States f = States.FOUND;


        if (arr.get(mid).getValue() == value) {
            arr.get(mid).setCircleState(f);
            found = true;
            tracker++;
            location = mid;
            return mid;
        }

        if (arr.get(mid).getValue() < value) {
            bottom = mid + 1;
            tracker++;
            arr.get(mid).setCircleState(c);
            location = mid;
        }

        else {
            top = mid - 1;
            tracker++;
            arr.get(mid).setCircleState(c);
            location = mid;
        }

        System.out.println("not found");
        return -1;
    }
    public void keyPressed() {
        if(key == 'f'){
            selectionSort();
        } else if(key == 'a') {
            binarySearchIterative(list, value);
        } else if(key == '1'){
            strValue += "1";
        } else if(key == '2'){
            strValue += "2";
        } else if(key == '3'){
            strValue += "3";
        } else if(key == '4'){
            strValue += "4";
        } else if(key == '5'){
            strValue += "5";
        } else if(key == '6'){
            strValue += "6";
        } else if(key == '7'){
            strValue += "7";
        } else if(key == '8'){
            strValue += "8";
        } else if(key == '9'){
            strValue += "9";
        } else if(key == '0'){
            strValue += "0";
        } else if(key == 's'){
            System.out.println(strValue);
            start();
        } else if(key == 'r'){
            reset();
        }
    }
    public void start(){
        for(int i = 0; i < strValue.length(); i++){
            if(strValue.charAt(i) == '1') {
                value += 1*(Math.pow(10, (strValue.length() - i - 1)));
                System.out.println(value);
            } else if(strValue.charAt(i) == '2') {
                value += 2*(Math.pow(10, (strValue.length() - i - 1)));
                System.out.println(value);
            } else if(strValue.charAt(i) == '3') {
                value += 3*(Math.pow(10, (strValue.length() - i - 1)));
                System.out.println(value);
            } else if(strValue.charAt(i) == '4') {
                value += 4*(Math.pow(10, (strValue.length() - i - 1)));
                System.out.println(value);
            } else if(strValue.charAt(i) == '5') {
                value += 5*(Math.pow(10, (strValue.length() - i - 1)));
                System.out.println(value);
            } else if(strValue.charAt(i) == '6') {
                value += 6*(Math.pow(10, (strValue.length() - i - 1)));
                System.out.println(value);
            } else if(strValue.charAt(i) == '7') {
                value += 7*(Math.pow(10, (strValue.length() - i - 1)));
                System.out.println(value);
            } else if(strValue.charAt(i) == '8') {
                value += 8*(Math.pow(10, (strValue.length() - i - 1)));
                System.out.println(value);
            } else if(strValue.charAt(i) == '9') {
                value += 9*(Math.pow(10, (strValue.length() - i - 1)));
                System.out.println(value);
            }
        }
        System.out.println(value);
    }
    public void scrambler(){
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(int i = 0; i < 10; i ++){
            tempList.add(0);
        }
        for(int j = 0; j < 10; j++){
            while(tempList.get(j) == 0){
                int rand = (int)(Math.random()*10);
                if(list.get(rand).getChangeState() == ChangeStates.NOTTAKEN){
                    tempList.set(j, list.get(rand).getValue());
                    list.get(rand).setChangeState(ChangeStates.TAKEN);
                }
            }
            System.out.println(tempList.get(j));
        }
        for(int k = 0; k < 10; k++){
            list.get(k).setValue(tempList.get(k));
        }
    }
    private void selectionSort(){
        int n = list.size();
        for (int i = 0; i < 10; i++)
        {

            int min = i;
            for (int j = i+1; j < n; j++) {
                if (list.get(j).getValue() < list.get(min).getValue()) {
                    min= j;
                }
            }
            int temporary = list.get(min).getValue();
            list.get(min).setValue(list.get(i).getValue());
            list.get(i).setValue(temporary);
        }
        sorted = true;
    }
    //private int binarySearchRecursive(int bottom, int top, int target, ArrayList<Wrapper> list) {
    //    while (top >= bottom) {
         //      int mid= (bottom + top) / 2;
       //    }
          // if (list.get(mid).getNumber() == target) {
       //         return mid;
       //    } else if (list.get(mid).getNumber() < target) {
        //        return binarySearch2(bottom, mid - 1, target, ArrayList < Wrapper > list);
        //  } else {
        //      return binarySearch2(mid + 1, top, target, ArrayList < Wrapper > list);
       //   }
      // }
}
