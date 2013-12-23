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
//ToDo
//-\u6642\u8a08\u56de\u308a\u306e\u52d5\u4f5c
//-1\u5206\u3054\u3068\u306e\u79d2\u306e\u8aa4\u5dee\u306e\u4fee\u6b63
//-\u524d\u306b\u63cf\u753b\u3057\u305f\u5186\u3092\u6d88\u53bb\u3059\u308b\u30a2\u30eb\u30b4\u30ea\u30ba\u30e0

public void setup(){
	size(displayWidth, displayHeight);
	colorMode(RGB);
	background(0, 0, 0);
	smooth();
	PFont uhr = loadFont("AgencyFB-Reg-18.vlw");
  	textFont(uhr, 21);
}

public void draw(){
	float sec, min, hou;//\u79d2\u3001\u5206\u3001\u6642\u9593
	int s, m ,h;//\u30ad\u30e3\u30b9\u30c8\u3057\u3066\u8868\u793a\u3059\u308b\u305f\u3081\u306e
	float sRange = 300.0f;//\u79d2\u306e\u5186\u5468\u306e\u534a\u5f84
	float mRage = 60.0f;//\u5206\u306e\u5186\u5468\u306e\u534a\u5f84
	float hx = displayWidth / 2, hy = displayHeight / 2;//\u30c7\u30a3\u30b9\u30d7\u30ec\u30a4\u306e\u4e2d\u5fc3\u5ea7\u6a19
	float sRad; //\u7b97\u51fa\u3057\u305f\u89d2\u5ea6\u3092\u683c\u7d0d\u3059\u308b(\u79d2\u5186\u7528)
	float mRad;	//\u7b97\u51fa\u3057\u305f\u89d2\u5ea6\u3092\u683c\u7d0d\u3059\u308b(\u5206\u5186\u7528)

	sec = second();
	min = minute() + (sec/60.0f);
	hou = hour() % 12.0f + (min/60.0f);

	sRad = (360 * (sec - 15) / 60) * -1;//\u79d2\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f

	s = PApplet.parseInt(sec);//\u79d2\u3092float\u304b\u3089int\u3078\u30b3\u30f3\u30d0\u30fc\u30c8

	fill(255, 255, 255);
	ellipse(sin(radians(sRad + 90)) * sRange + hx, cos(radians(sRad + 90)) * sRange + hy, 10 * PI, 10 * PI);
	noFill();

	fill(0, 0, 0);
	text(s, sin(radians(sRad + 90)) * sRange + hx - 7, cos(radians(sRad + 90)) * sRange + hy + 8.5f);
	noFill();
	

	println("Now time : "+hou+":"+min+":"+s);

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
