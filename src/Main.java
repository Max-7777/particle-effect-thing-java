import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {

    Particle[] particles;
    Particle[] prevParticles;
    int particleNum;
    int lineDrawDist;
    int particleSpeed;

    public void settings() {
        size(700,700);
    }

    public void setup() {
        lineDrawDist = 150;
        particleNum = 100;
        particleSpeed = 2;
        particles = new Particle[particleNum];
        for (int i = 0; i < particleNum; i++) {
            PVector randomPos = new PVector(random(0,width),random(0,height));
            PVector randomVel = new PVector(random(-2,2),random(-2,2));
            particles[i] = new Particle(randomPos,randomVel,width,height);
        }
        prevParticles = particles.clone();
    }


    public void draw() {
        strokeWeight(1);
        println(frameRate);
        background(0);
        for (Particle p : particles) {
            p.update(mouseX,mouseY,particles);
            ellipse(p.pos.x,p.pos.y,5,5);
            //draw in-between lines
            for (Particle p2 : particles) {
                if (p.pos == p2.pos) continue;
                if (dist(p.pos.x,p.pos.y,p2.pos.x,p2.pos.y) > lineDrawDist) continue;
                stroke(255, map(dist(p.pos.x,p.pos.y,p2.pos.x,p2.pos.y),0,100,255,0));
                line(p.pos.x,p.pos.y,p2.pos.x,p2.pos.y);
                noStroke();
            }
        }
    }







    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
