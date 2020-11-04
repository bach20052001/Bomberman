package com.project.bomberman.entities.mob;

import com.project.bomberman.entities.Entity;
import com.project.bomberman.graphics.Screen;
import com.project.bomberman.graphics.Sprite;
import com.project.bomberman.level.Coordinates;

public class Shield extends Entity{
    private boolean isActive = false;
    private double timeRemaining;
    private double countdownSkill = 1800;

    public Shield(double x, double y) {
        this._x = x;
        this._y = y;
        _sprite = Sprite.shield;
        timeRemaining = 300;//5s
        countdownSkill = 1800;//30s để hồi skill
    }

    public void setX(double x){
        this._x = x;
    }

    public void setY(double y){
        this._y = y;
    }

    public boolean  getActive(){
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setTimeRemaining(double timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    @Override
    public void update() {
        if (timeRemaining > 0){
            timeRemaining--;
            System.out.println(timeRemaining);
        }
        else if (isActive)
            {
            this.setActive(false);
        }
    }

    @Override
    public void render(Screen screen) {
        screen.renderEntity(Coordinates.tileToPixel(_x), Coordinates.tileToPixel(_y), this);
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }
}
