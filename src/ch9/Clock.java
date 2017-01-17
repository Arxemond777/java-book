package ch9;

public class Clock extends ch9.UpdateApplet {
    public void paint( java.awt.Graphics graphics ) {
        graphics.drawString( new java.util.Date().toString(), 10, 25 );
    }
}
