import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 
import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class about3dRotation extends PApplet {




/*
Study number: 1 - November 2018 - Nicolás Troncoso - Designer
*/

// How nested rotation woks
// -----------------------------------------------------------------------------

// Interaction
PeasyCam cam;
ControlP5 cp5;

Particle p;

public void setup() {
    
    
    p = new Particle();
    cam = new PeasyCam(this, 1000);
}

public void draw() {
    background(p.gray);
    p.axis();
    p.dot();
    p.lines();

}
class Particle {
    PVector pos, acc, vel;
    int bg, fill, stroke, gray, blue, cyan, red, purple;
    float raduis;

    Particle() {
        gray = color(231, 237, 244);
        blue = color(31, 9, 191);
        cyan = color(20, 219, 241);
        red = color(196, 15, 69);
        purple = color(55, 4, 78);
        pos = new PVector(0, 0, 0);
        acc = new PVector(0, 0, 0);
        vel = new PVector(0, 0, 0);
        raduis = 100;
    }
    public void movement() {
        vel.add(acc);
        pos.add(vel);
    }
    public void dot() {
        strokeWeight(5);
        stroke(red);
        point(pos.x, pos.y, pos.z);
    }

    // axis
    public void axis() {
        stroke(purple);
        noFill();
        pushMatrix();
        translate(pos.x, pos.y, pos.z);
        strokeWeight(0.1f);
        strokeCap(ROUND);
        line(-5000, 0, 0, 5000, 0, 0); // X axis
        line(0, -5000, 0, 0, 5000, 0); // Y axis
        strokeWeight(2);
        ellipse(0, 0, raduis*2, raduis*2);
        popMatrix();
    }

    // line
    public void lines() {
        PVector scale = new PVector(raduis, 0, 0);
        strokeWeight(5);
        stroke(red);
        pushMatrix();
        line(pos.x, pos.y,  pos.z, scale.x, scale.y, scale.z);
        popMatrix();

    }

    // spine
    public void spine (int amt, float rotationX,  float rotationY, float rotationZ) {
      for (int i = 0; i < amt; i ++) {
        // code
      }
    }
}
  public void settings() {  size(1920, 950, P3D);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "about3dRotation" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
