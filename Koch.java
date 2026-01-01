/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {
       
        if (args.length > 0) {
            snowFlake(Integer.parseInt(args[0]));
        }
    }

    /** Draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
       
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

      
        double xA = x1 + (x2 - x1) / 3.0;
        double yA = y1 + (y2 - y1) / 3.0;
        
        double xB = x1 + 2.0 * (x2 - x1) / 3.0;
        double yB = y1 + 2.0 * (y2 - y1) / 3.0;

       
        double sqrt3over6 = Math.sqrt(3) / 6.0;
        double xC = 0.5 * (x1 + x2) - sqrt3over6 * (y2 - y1);
        double yC = 0.5 * (y1 + y2) + sqrt3over6 * (x2 - x1);

     
        curve(n - 1, x1, y1, xA, yA); 
        curve(n - 1, xA, yA, xC, yC); 
        curve(n - 1, xC, yC, xB, yB); 
        curve(n - 1, xB, yB, x2, y2); 
    }

    /** Draws a Koch snowflake of n edges in the standard canvas. */
    public static void snowFlake(int n) {
        StdDraw.setYscale(-0.2, 1.1);
        StdDraw.setXscale(0, 1.1);
        
      
        double x1 = 0.1, y1 = 0.2;
        double x2 = 0.9, y2 = 0.2;
        double x3 = 0.5, y3 = 0.2 + 0.8 * (Math.sqrt(3) / 2.0);

      
        curve(n, x1, y1, x2, y2); 
        curve(n, x2, y2, x3, y3); 
        curve(n, x3, y3, x1, y1); 
    }
}