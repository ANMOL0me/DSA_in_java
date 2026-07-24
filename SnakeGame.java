import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class SnakeGame {

    public static void main(String[] args) {
        new GameFrame();
    }
}

class GameFrame extends JFrame {

    GameFrame() {

        this.add(new GamePanel());

        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

class GamePanel extends JPanel implements ActionListener, KeyListener {

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

    GamePanel() {

        random = new Random();

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        startGame();
    }

    public void startGame() {

        for (int i = 0; i < bodyParts; i++) {
            x[i] = 100 - i * UNIT_SIZE;
            y[i] = 100;
        }

        newApple();

        running = true;

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void newApple() {

        boolean valid;

        do {
            valid = true;

            appleX = random.nextInt(WIDTH / UNIT_SIZE) * UNIT_SIZE;
            appleY = random.nextInt(HEIGHT / UNIT_SIZE) * UNIT_SIZE;

            for (int i = 0; i < bodyParts; i++) {
                if (appleX == x[i] && appleY == y[i]) {
                    valid = false;
                    break;
                }
            }

        } while (!valid);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if (running) {

            // Apple
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // Snake
            for (int i = 0; i < bodyParts; i++) {

                if (i == 0) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(new Color(45, 180, 0));
                }

                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }

            // Score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score : " + applesEaten, 10, 25);

        } else {
            gameOver(g);
        }
    }

    public void move() {

        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {

            case 'U':
                y[0] -= UNIT_SIZE;
                break;

            case 'D':
                y[0] += UNIT_SIZE;
                break;

            case 'L':
                x[0] -= UNIT_SIZE;
                break;

            case 'R':
                x[0] += UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {

        if (x[0] == appleX && y[0] == appleY) {

            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {

        // Self collision
        for (int i = bodyParts; i > 0; i--) {

            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }

        // Wall collision
        if (x[0] < 0) running = false;
        if (x[0] >= WIDTH) running = false;
        if (y[0] < 0) running = false;
        if (y[0] >= HEIGHT) running = false;

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("GAME OVER", 150, 250);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Score : " + applesEaten, 220, 320);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {
            move();
            checkApple();
            checkCollisions();
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_LEFT:
                if (direction != 'R')
                    direction = 'L';
                break;

            case KeyEvent.VK_RIGHT:
                if (direction != 'L')
                    direction = 'R';
                break;

            case KeyEvent.VK_UP:
                if (direction != 'D')
                    direction = 'U';
                break;

            case KeyEvent.VK_DOWN:
                if (direction != 'U')
                    direction = 'D';
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}