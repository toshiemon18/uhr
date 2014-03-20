import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class uhr_3D extends PApplet {

//uhr\u306e\u6642\u9593\u5186\u304c3\u6b21\u5143\u904b\u52d5\u3059\u308b\u30d0\u30fc\u30b8\u30e7\u30f3
int disp = 650;
float sRange = 250.0f;//second length
float mRange = 180.0f;//minute length
float hRange = 110.0f;//hour length
float hx = disp / 2.0f, hy = disp / 2.0f;

public void setup(){
	size(disp, disp);
	colorMode(RGB);
	background(0, 0, 0);
	//Pfont uhr = fontload("AgencyFB-Reg-25.vlw");
	//textFont(uhr, 24);
	stroke(255, 255, 255);
}

public void draw(){

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "uhr_3D" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
