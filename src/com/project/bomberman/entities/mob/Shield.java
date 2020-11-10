package com.project.bomberman.entities.mob;

import com.project.bomberman.Board;
import com.project.bomberman.entities.Entity;
import com.project.bomberman.graphics.Screen;
import com.project.bomberman.graphics.Sprite;

public class Shield extends Mob{
    private boolean isActive = false;
    private double timeRemaining;
    private double cdSkill;
    protected Board _board;
    private final Player player;

    public Shield(int x, int y,double timeRemaining,double cdSkill,Board board,Player player) {
        super(x,y,board);
        this._x = x;
        this._y = y;
        _sprite = Sprite.shield;
        _board = board;
        this.timeRemaining = timeRemaining; //Tồn tại 5s
        this.cdSkill = cdSkill; //1p để hồi skill
        this.player = player;
    }


    public void setPosition(double x,double y){
        this._x  = x;
        this._y  = y;
    }


    public boolean  getActive(){
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public double getCdSkill() {
        return cdSkill /60;
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
            this._x = player.getX();
            this._y = player.getY();
        }
        else if (isActive)
            {
            this.setActive(false);
            remove();

        }

    }


    @Override
    public void render(Screen screen) {
        if (timeRemaining > 0)
        screen.renderEntity((int)_x, (int)_y - _sprite.SIZE, this);
    }

    @Override
    protected void calculateMove() {

    }

    @Override
    protected void move(double xa, double ya) {

    }

    @Override
    public void kill() {

    }

    @Override
    protected void afterKill() {

    }

    @Override
    protected boolean canMove(double x, double y) {
        return false;
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }
}
