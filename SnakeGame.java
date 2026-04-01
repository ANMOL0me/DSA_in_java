import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {

    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (WIDTH * HEIGHT) / UNIT_SIZE;
    static final int DELAY = 100;

    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;

    char direction = 'R';
    boolean running = false;

    Timer timer;
    Random random;

    SnakeGame() {
        random = new Random();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(this);
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if (running) {
           g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(45,180,0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.BOLD,20));
            g.drawString("Score: "+applesEaten,10,20);
        }

        else {
            gameOver(g);
        }
    }

    public void newApple() {
        appleX = random.nextInt((int)(WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move() {

        for(int i = bodyParts; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
 
        }

        switch(direction) {
            case 'U': y[0] = y[0] - UNIT_SIZE; break;
            case 'D': y[0] = y[0] + UNIT_SIZE; break;
            case 'L': x[0] = x[0] - UNIT_SIZE; break;
            case 'R': x[0] = x[0] + UNIT_SIZE; break;
        }
    }

    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {

        for(int i = bodyParts; i > 0; i--) {
            if((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        if(x[0] < 0) running = false;
        if(x[0] > WIDTH) running = false;
        if(y[0] < 0) running = false;
        if(y[0] > HEIGHT) running = false;

        if(!running) timer.stop();
    }

    public void gameOver(Graphics g) {

        g.setColor(Color.red);
        g.setFont(new Font("Arial",Font.BOLD,40));
        g.drawString("Game Over",200,300);

        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString("Score: "+applesEaten,250,350);
    }

    @Override
    public void actionPerformed(A {
            move();
            checkApple();ctionEvent e) {

        if(running)
            checkCollisions();
        }

        repaint();
    }
