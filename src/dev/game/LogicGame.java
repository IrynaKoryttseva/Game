package dev.game;

import display.Display;

/**
 * @author Sasha on 4/1/2016.
 */
public class LogicGame implements Runnable {
    private Display display;
    public int width, height;
    public String title;
    private Thread thread;
    private boolean running = false;

    public LogicGame(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        display = new Display(title, width, height);
    }

    private void tick() {

    }

    private void render() {

    }

    // @Override
    public void run() {
        init();
        while (running) {
            tick();
            render();
        }
        stop();
    }

    public synchronized void star() {
        if(running)return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running)return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
