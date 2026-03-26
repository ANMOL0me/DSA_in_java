
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
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
            checkApple();
            checkCollisions();
        }

        repaint();
    }
