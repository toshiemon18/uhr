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

public class uhr extends PApplet {

//\u5186\u3092\u4f7f\u3063\u3066\u3050\u308b\u3050\u308b\u56de\u3057\u3066\u6642\u8a08\u30e9\u30a4\u30af\u306a\u3082\u306e
//\u9032\u6357\u30c0\u30e1\u306a\u306e\u3067\u51ac\u4f11\u307f\u304b\u3089\u9811\u5f35\u308a\u307e\u3059(12/21\uff5e)

public void setup(){
	size(displayWidth, displayHeight);
	colorMode(RGB);
	background(0, 0, 0);
	fill();
}

public void draw(){

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "uhr" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
