import processing.core.PApplet;
import processing.core.PVector;

public class Particle extends PApplet {

    PVector pos;
    final PVector vel;
    int windowWidth, windowHeight;

    public Particle(PVector pos, PVector vel, int windowWidth, int windowHeight) {
        this.pos = pos;
        this.vel = vel;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }

    /*
    public void update(int mouseX, int mouseY, Particle[] particles) {
        for (Particle p : particles) {
            if (p.pos == this.pos) continue;
            while (dist(p.pos.x, p.pos.y, this.pos.x, this.pos.y) < 50) {
                PVector v = new PVector(this.pos.x - p.pos.x,this.pos.y - p.pos.y);
                pos.add(v.limit(1));
            }
        }

        pos.x += xV;
        pos.y += yV;

        if (pos.x > 500) pos.x = 0;
        if (pos.y > 500) pos.y = 0;
    }

     */

    public void update(int mouseX, int mouseY, Particle[] particles) {
        if (dist(mouseX, mouseY, this.pos.x, this.pos.y) < 50) {
            PVector v = new PVector(this.pos.x - mouseX, this.pos.y - mouseY);
            while (dist(mouseX, mouseY, this.pos.x, this.pos.y) < 50) {
                pos.add(v.limit(1));
            }
        }

        pos.add(vel);

        if (pos.x > windowWidth) pos.x = 0;
        if (pos.x < 0) pos.x = windowWidth;
        if (pos.y > windowHeight) pos.y = 0;
        if (pos.y < 0) pos.y = windowHeight;
    }




}
