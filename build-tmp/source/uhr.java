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

//\u5186\u3092\u4f7f\u3063\u3066\u3050\u308b\u3050\u308b\u56de\u3057\u3066\u6642\u8a08\u3063\u307d\u3044\u3082\u306e
//\u5b9f\u88c5\u4e88\u5b9a\u306e\u6a5f\u80fd
//\u5186\u306e\u7e01\u3092\u307c\u304b\u3057\u3066\u5149\u3063\u3066\u308b\u611f\u3058\u3092\u51fa\u3059\u3001\u3082\u3057\u304f\u306f\u5149\u3089\u305b\u308b
//\u30bf\u30a4\u30de\u30fc\u6a5f\u80fd(\uff1f)
//\u30ac\u30e9\u30ca\u3063\u307d\u3044\u30a8\u30d5\u30a7\u30af\u30c8(\uff1f\uff1f\uff1f\uff1f)


int disp = 650;//\u30a6\u30a3\u30f3\u30c9\u30a6\u30b5\u30a4\u30ba
float sRange = 250.0f;//\u79d2\u306e\u5186\u5468\u306e\u534a\u5f84
float mRange = 180.0f;//\u5206\u306e\u5186\u5468\u306e\u534a\u5f84
float hRange = 110.0f;
float hx = disp / 2.0f, hy = disp / 2.0f;

public void setup(){
	size(disp, disp);
	colorMode(RGB);
	background(0, 0, 0);
	PFont uhr = loadFont("AgencyFB-Reg-25.vlw");
  	textFont(uhr, 24);
  	stroke(255, 255, 255);
  	smooth();
}

public void draw(){
	background(0, 0, 0);
	smooth();
	float sec, min, hou;//\u79d2\u3001\u5206\u3001\u6642\u9593
	int s, m ,h;//\u30b3\u30f3\u30d0\u30fc\u30c8\u3057\u3066\u8868\u793a\u3059\u308b\u305f\u3081\u306e\u3084\u3064(\u79d2\u3001\u5206\u3001\u6642\u9593)	
	float srad, mrad, hrad; //\u89d2\u5ea6\u683c\u7d0d\u7528(\u79d2\u3001\u5206\u3001\u6642\u9593)
	String s_s, m_s, h_s;//\u30c6\u30ad\u30b9\u30c8\u5316\u3057\u305f\u6642\u9593(\u79d2\u3001\u5206\u3001\u6642\u9593)

	//\u30c6\u30ad\u30b9\u30c8\u5909\u63db
	//\u79d2\u6570\u304c1\u6841\u306e\u3068\u304d\u306f\u5148\u982d\u306b0\u3092\u3064\u3051\u308b
	if(second() < 10)
		s_s = "0" + str(second());
	else
		s_s = str(second());

	//\u5206\u304c1\u6841\u306e\u3068\u304d\u306f\u5148\u982d\u306b0\u3092\u3064\u3051\u308b
	if(minute() < 10)
		m_s = "0" + str(minute());
	else
		m_s = str(minute());

	//\u6642\u9593\u304c1\u6841\u306e\u6642\u306f\u5148\u982d\u306b0\u3092\u3064\u3051\u308b
	if(hour() < 10)
		h_s = "0" + str(hour());
	else
		h_s = str(hour());

	//\u6642\u9593\u306e\u53d6\u5f97
	sec = second();
	min = minute();
	hou = hour() % 12.0f;

	//\u5186\u306e\u8868\u793a\u4f4d\u7f6e\u3092\u6c7a\u5b9a\u3059\u308b\u89d2\u5ea6\u306e\u5c0e\u51fa
	srad = (360 * (sec - 15) / 60.0f) * -1;//\u79d2\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f
	mrad = (360 * (min - 15) / 60.0f) * -1;//\u5206\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f
	hrad = (360 * (hou - 15) / 60.0f) * -1;//\u6642\u9593\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f

	s = PApplet.parseInt(sec);//\u79d2\u306e\u5024\u3092float\u304b\u3089int\u3078\u30b3\u30f3\u30d0\u30fc\u30c8
	m = PApplet.parseInt(min);//\u5206\u306e\u5024\u3092float\u304b\u3089int\u3078\u30b3\u30f3\u30d0\u30fc\u30c8
	h = PApplet.parseInt(hou);//\u6642\u9593\u306e\u5024\u3092float\u304b\u3089int\u3078\u30b3\u30f3\u30d0\u30fc\u30c8

	//\u30a6\u30a3\u30f3\u30c9\u30a6\u306e\u89d2\u306b\u6642\u9593\u3068\u30d7\u30ed\u30b0\u30e9\u30e0\u540d\u3072\u3087\u3046\u3058\u3059\u308b
	fill(255, 255, 255);
	text("Uhr", 10, 20);
	text(h_s + " : " + m_s + " : " + s_s, 10, 40);
	noFill();

	//\u79d2\u5186\u306e\u8868\u73fe
	fill(255, 255, 255);
	ellipse(sin(radians(srad + 90)) * sRange + hx, cos(radians(srad + 90)) * sRange + hy, 60, 60);
	noFill();
	//\u79d2\u306e\u5024\u3092\u5186\u306e\u4e2d\u306b\u8868\u793a	
	fill(0, 0, 0);
	text(s_s + "s", sin(radians(srad + 90)) * sRange + hx - 15, cos(radians(srad + 90)) * sRange + hy + 8.5f);
	noFill();
	
	//\u5206\u5186\u306e\u8868\u73fe
	fill(255, 255, 255);
	ellipse(sin(radians(mrad + 90)) * mRange + hx, cos(radians(mrad + 90)) * mRange + hy, 60, 60);
	noFill();
	//\u5206\u306e\u5024\u3092\u5186\u306e\u4e2d\u306b\u8868\u793a
	fill(0, 0, 0);
	text(m_s + "m", sin(radians(mrad + 90)) * mRange + hx - 15, cos(radians(mrad + 90)) * mRange + hy + 8.5f);
	noFill();

	//\u6642\u9593\u5186\u306e\u8868\u73fe
	fill(255, 255, 255);
	ellipse(sin(radians(hrad + 180)) * hRange + hx, cos(radians(hrad + 180)) * hRange + hy, 60, 60);
	noFill();
	//\u6642\u9593\u306e\u5024\u3092\u5186\u306e\u4e2d\u306b\u8868\u793a
	fill(0, 0, 0);
	text(h_s + "h", sin(radians(hrad + 180)) * hRange + hx - 15, cos(radians(hrad + 180)) * hRange + hy + 8.5f);
	noFill();

	//AM\u30fbPM\u3092\u8868\u793a\u3059\u308b\u5186\u3092\u63cf\u753b
	fill(255, 255, 255);
	ellipse(hx, hy, 30 * 3, 30 * 3);
	noFill();
	if(hour() <= 12){
		fill(0, 0, 0);
		text(" PM", hx - 14, hy + 9);
		noFill();
	}
	else{
		fill(0, 0, 0);
		text(" AM", hx - 14, hy + 9);
		noFill();
	}
	//println("Now time : "+h+":"+m+":"+s);
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
