package app_b.CircleApplet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class CircleApplet extends Applet implements Runnable {
    private int x;
    private int y;
    private int width;
    private int height;
    private int radius = 10;
    private int interval = 100;
    private Color color = Color.white;
    private Random random = new Random();
    private Thread thread = null;

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void init() {
        radius = getInteger("radius", 10);
        interval = getInteger("interval", 100);
        Dimension d = getSize();
        width = d.width;
        height = d.height;
    }

    @Override
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        thread = null;
    }

    @Override
    public void run() {
        try {
            while (thread == Thread.currentThread()) {
                x = random.nextInt(width);
                y = random.nextInt(height);
                int r = random.nextInt(256);
                int g = random.nextInt(256);
                int b = random.nextInt(256);
                color = new Color(r, g, b);
                repaint();
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
        }
    }

    private int getInteger(String name, int defaultValue) {
        int value = defaultValue;
        String param = getParameter(name);
        if (param != null) {
            try {
                value = Integer.parseInt(param);
            } catch (NumberFormatException e) {
                // ignore
            }
        }
        return value;
    }
}
