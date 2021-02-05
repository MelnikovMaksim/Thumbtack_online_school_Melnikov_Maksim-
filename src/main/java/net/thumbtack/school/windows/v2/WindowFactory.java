package net.thumbtack.school.windows.v2;

public class WindowFactory {
    private static int rectButtonCount = 0;
    private static int roundButtonCount = 0;

    public static RectButton createRectButton(Point leftTop, Point rightBottom, boolean active, String text){
        rectButtonCount++;
        return new RectButton(leftTop,rightBottom,active,text);
    }

    public static RoundButton createRoundButton(Point center, int radius, boolean active, String text){
        roundButtonCount++;
        return  new RoundButton(center,radius,active,text);
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
