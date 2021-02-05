package net.thumbtack.school.windows.v1;

public class WindowFactory {
    private static int rectButtonCount = 0;
    private static int roundButtonCount = 0;

    public static RectButton createRectButton(Point leftTop, Point rightBottom, boolean active){
        rectButtonCount++;
        return new  RectButton(leftTop,rightBottom,active);
    }

    public static RoundButton createRoundButton(Point center, int radius, boolean active){
        roundButtonCount++;
        return  new RoundButton(center,radius,active);
    }

    public static int getRectButtonCount(){
        return rectButtonCount;
    }

    public static int getRoundButtonCount(){
        return roundButtonCount;
    }

    public static int getWindowCount(){
        return rectButtonCount+roundButtonCount;
    }

    public static void reset(){
        rectButtonCount = 0;
        roundButtonCount = 0;
    }
}
