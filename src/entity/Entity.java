package src.entity;

public abstract class Entity {
    protected float x, y;
    protected int width, height;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //System.out.println("ENTITY => width: "+width+" height: "+ height);
    }

}
