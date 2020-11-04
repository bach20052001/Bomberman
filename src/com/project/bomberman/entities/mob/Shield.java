package com.project.bomberman.entities.mob;

import com.project.bomberman.Board;
import com.project.bomberman.entities.Entity;
import com.project.bomberman.graphics.Screen;
import com.project.bomberman.graphics.Sprite;
import com.project.bomberman.level.Coordinates;

public class Shield extends Entity{
    private boolean isActive = false;
    private double timeRemaining = 0;
    private double cdSkill = 0;
    protected Board _board;

    public Shield(double x, double y,double timeRemaining,double cdSkill,Board board) {
        this._x = x;
        this._y = y;
        _sprite = Sprite.shield;
        _board = board;
        this.timeRemaining = timeRemaining;//5s
        this.cdSkill = cdSkill;//30s để hồi skill
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

    public double getCdSkill() {
        return cdSkill;
    }

    public void setTimeRemaining(double timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    @Override
    public void update() {
        if (cdSkill > 0) {
            cdSkill--;
        }
        System.out.println(cdSkill);

        if (timeRemaining > 0){
            timeRemaining--;
        }
        else if (isActive)
            {
            this.setActive(false);
            remove();
        }
    }

    @Override
    public void render(Screen screen) {
        screen.renderEntity((int)_x, (int)_y, this);
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }
}
