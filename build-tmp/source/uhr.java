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

public void setup(){
	size(displayWidth, displayHeight);
	colorMode(RGB);
	background(0, 0, 0);
	smooth();
	PFont uhr = loadFont("AgencyFB-Reg-18.vlw");
  	textFont(uhr, 21);
  	stroke(255, 255, 255);
}

public void draw(){
	background(0, 0, 0);
	int pa = hour();
	float sec, min, hou;//\u79d2\u3001\u5206\u3001\u6642\u9593
	int s, m ,h;//\u30b3\u30f3\u30d0\u30fc\u30c8\u3057\u3066\u8868\u793a\u3059\u308b\u305f\u3081\u306e
	float sRange = 300.0f;//\u79d2\u306e\u5186\u5468\u306e\u534a\u5f84
	float mRange = 230.0f;//\u5206\u306e\u5186\u5468\u306e\u534a\u5f84
	float hRange = 160.0f;
	float hx = displayWidth / 2, hy = displayHeight / 2;//\u30c7\u30a3\u30b9\u30d7\u30ec\u30a4\u306e\u4e2d\u5fc3\u5ea7\u6a19
	float sRad; //\u7b97\u51fa\u3057\u305f\u89d2\u5ea6\u3092\u683c\u7d0d\u3059\u308b(\u79d2\u5186\u7528)
	float mRad;	//\u7b97\u51fa\u3057\u305f\u89d2\u5ea6\u3092\u683c\u7d0d\u3059\u308b(\u5206\u5186\u7528)
	float hRad; //\u7b97\u51fa\u3057\u305f\u89d2\u5ea6\u3092\u683c\u7d0d\u3059\u308b(\u6642\u9593\u5186\u7528)

	sec = second();
	min = minute();
	hou = hour() % 12.0f;

	sRad = (360 * (sec - 15) / 60.0f) * -1;//\u79d2\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f
	mRad = (360 * (min - 15) / 60.0f) * -1;//\u5206\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f
	hRad = (360 * (hou - 15) / 60.0f) * -1;//\u6642\u9593\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f

	s = PApplet.parseInt(sec);//\u79d2\u306e\u5024\u3092float\u304b\u3089int\u3078\u30b3\u30f3\u30d0\u30fc\u30c8
	m = PApplet.parseInt(min);//\u5206\u306e\u5024\u3092float\u304b\u3089int\u3078\u30b3\u30f3\u30d0\u30fc\u30c8
	h = PApplet.parseInt(hou);//\u6642\u9593\u306e\u5024\u3092float\u304b\u3089int\u3078\u30b3\u30f3\u30d0\u30fc\u30c8

	//\u79d2\u5186\u306e\u8868\u73fe
	fill(255, 255, 255);
	ellipse(sin(radians(sRad + 90)) * sRange + hx, cos(radians(sRad + 90)) * sRange + hy, 20 * PI, 20 * PI);
	noFill();
	//\u79d2\u306e\u5024\u3092\u5186\u306e\u4e2d\u306b\u8868\u793a	
	fill(0, 0, 0);
	text(s, sin(radians(sRad + 90)) * sRange + hx - 7, cos(radians(sRad + 90)) * sRange + hy + 8.5f);
	noFill();
	
	//\u5206\u5186\u306e\u8868\u73fe
	fill(255, 255, 255);
	ellipse(sin(radians(mRad + 90)) * mRange + hx, cos(radians(mRad + 90)) * mRange + hy, 20 * PI, 20 * PI);
	noFill();
	//\u5206\u306e\u5024\u3092\u5186\u306e\u4e2d\u306b\u8868\u793a
	fill(0, 0, 0);
	text(m, sin(radians(mRad + 90)) * mRange + hx - 7, cos(radians(mRad + 90)) * mRange + hy + 8.5f);
	noFill();

	//\u6642\u9593\u5186\u306e\u8868\u73fe
	fill(255, 255, 255);
	ellipse(sin(radians(hRad + 90)) * hRange + hx, cos(radians(hRad + 90)) * hRange + hy, 20 * PI, 20 * PI);
	noFill();
	//\u6642\u9593\u306e\u5024\u3092\u5186\u306e\u4e2d\u306b\u8868\u793a
	fill(0, 0, 0);
	text(h, sin(radians(hRad + 90)) * hRange + hx - 7, cos(radians(hRad + 90)) * hRange + hy + 8.5f);
	noFill();

	fill(255, 255, 255);
	ellipse(hx, hy, 30 * PI, 30 * PI);
	noFill();
	if(pa <= 12){
		fill(0, 0, 0);
		text("PM", hx - 13, hy + 8.5f);
		noFill();
	}

	else{
		fill(0, 0, 0);
		text("AM", hx - 13, hy + 8.5f);
		noFill();
	}

	println("Now time : "+h+":"+m+":"+s);
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
