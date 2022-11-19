package com.chy.tankgame3;

public class Tank {
    private int x;  //坦克的横坐标
    private int y;  //坦克的纵坐标
    private int direct; //坦克方向
    private int speed = 5;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp(){
        y -= speed;
    }
    public void moveRight(){
        x += speed;
    }
    public void moveDown(){
        y += speed;
    }
    public void moveLeft(){
        x -= speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}
