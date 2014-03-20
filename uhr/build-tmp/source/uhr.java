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

//uhr\u3084\u3064
/*\u5b9f\u88c5\u4e88\u5b9a\u306e\u6a5f\u80fd
	\u30fb\u5186\u306e\u7e01\u3092\u307c\u304b\u3057\u3066\u5149\u3063\u3066\u308b\u611f\u3058\u3092\u51fa\u3059\u3001\u3082\u3057\u304f\u306f\u5149\u3089\u305b\u308b
	\u30fb\u30bf\u30a4\u30de\u30fc\u6a5f\u80fd(\uff1f)
	\u30fb\u30ac\u30e9\u30ca\u3063\u307d\u3044\u30a8\u30d5\u30a7\u30af\u30c8(\uff1f\uff1f\uff1f\uff1f)
	\u30fb3\u6b21\u5143\u7684\u306a\u5186\u904b\u52d5 => \u5225\u306a\u30d7\u30ed\u30b0\u30e9\u30e0\u3068\u3057\u3066
*/
int disp = 650;//request window size
float sRange = 250.0f;//second length
float mRange = 180.0f;//minute length
float hRange = 110.0f;//hour length
float hx = disp / 2.0f, hy = disp / 2.0f;

public void setup(){
	size(disp, disp);
	colorMode(RGB);
	background(0, 0, 0);
	PFont uhr = loadFont("AgencyFB-Reg-25.vlw");
  	textFont(uhr, 24);
  	stroke(255, 255, 255);
}

public void draw(){
	background(0, 0, 0);
	smooth();
	float sec, min, hou;//time varue(second, minute, hour)
	int s, m ,h;//For convert data for uotput(second, minute, hour)
	float srad, mrad, hrad; 
	String sec_s, min_s, hou_s;//converted data for strings(second, minute, hour)

	//\u79d2\u6570\u304c1\u6841\u306e\u3068\u304d\u306f\u5148\u982d\u306b0\u3092\u3064\u3051\u308b
	if(second() < 10) { sec_s = "0" + str(second()); }
	else { sec_s = str(second()); }

	//\u5206\u304c1\u6841\u306e\u3068\u304d\u306f\u5148\u982d\u306b0\u3092\u3064\u3051\u308b
	if(minute() < 10) { min_s = "0" + str(minute()); }
	else { min_s = str(minute()); }

	//\u6642\u9593\u304c1\u6841\u306e\u6642\u306f\u5148\u982d\u306b0\u3092\u3064\u3051\u308b
	if(hour() < 10) { hou_s = "0" + str(hour()); }
	else { hou_s = str(hour()); } 


	//Get the value of time
	sec = second();
	min = minute();
	hou = hour() % 12.0f;
	
	srad = (360 * (sec - 15) / 60.0f) * -1;//\u79d2\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f
	mrad = (360 * (min - 15) / 60.0f) * -1;//\u5206\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f
	hrad = (360 * hou / 12.0f) * -1;//\u6642\u9593\u306e\u89d2\u5ea6\u5c0e\u51fa\u5f0f

	s = PApplet.parseInt(sec);//second value convert int type to float type
	m = PApplet.parseInt(min);//minute value convert int type to float type
	h = PApplet.parseInt(hou);//hour value convert int type to float type

	//Display "uhr" and time on window corner
	fill(255, 255, 255);
	text("Uhr", 10, 20);
	text(hou_s + " : " + min_s + " : " + sec_s, 10, 40);
	noFill();

	//Display second value into ellipse
	fill(255, 255, 255);
	ellipse(sin(radians(srad + 90)) * sRange + hx, cos(radians(srad + 90)) * sRange + hy, 60, 60);
	noFill();

	fill(0, 0, 0);
	text(s + "s", sin(radians(srad + 90)) * sRange + hx - 10, cos(radians(srad + 90)) * sRange + hy + 8.5f);
	noFill();
	
	//Display minute value into ellipse
	fill(255, 255, 255);
	ellipse(sin(radians(mrad + 90)) * mRange + hx, cos(radians(mrad + 90)) * mRange + hy, 60, 60);
	noFill();

	fill(0, 0, 0);
	text(m + "m", sin(radians(mrad + 90)) * mRange + hx - 10, cos(radians(mrad + 90)) * mRange + hy + 8.5f);
	noFill();

	//Display hour value into ellipse
	fill(255, 255, 255);
	ellipse(sin(radians(hrad + 180)) * hRange + hx, cos(radians(hrad + 180)) * hRange + hy, 60, 60);
	noFill();

	fill(0, 0, 0);
	text(h + "h", sin(radians(hrad + 180)) * hRange + hx - 10, cos(radians(hrad + 180)) * hRange + hy + 8.5f);
	noFill();

	//Displya AM or PM
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
