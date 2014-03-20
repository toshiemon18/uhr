//uhrやつ
/*実装予定の機能
	・円の縁をぼかして光ってる感じを出す、もしくは光らせる
	・タイマー機能(？)
	・ガラナっぽいエフェクト(？？？？)
	・3次元的な円運動 => 別なプログラムとして
*/
int disp = 650;//request window size
float sRange = 250.0;//second length
float mRange = 180.0;//minute length
float hRange = 110.0;//hour length
float hx = disp / 2.0, hy = disp / 2.0;

void setup(){
	size(disp, disp);
	colorMode(RGB);
	background(0, 0, 0);
	PFont uhr = loadFont("AgencyFB-Reg-25.vlw");
  	textFont(uhr, 24);
  	stroke(255, 255, 255);
}

void draw(){
	background(0, 0, 0);
	smooth();
	float sec, min, hou;//time varue(second, minute, hour)
	int s, m ,h;//For convert data for uotput(second, minute, hour)
	float srad, mrad, hrad; 
	String sec_s, min_s, hou_s;//converted data for strings(second, minute, hour)

	//秒数が1桁のときは先頭に0をつける
	if(second() < 10) { sec_s = "0" + str(second()); }
	else { sec_s = str(second()); }

	//分が1桁のときは先頭に0をつける
	if(minute() < 10) { min_s = "0" + str(minute()); }
	else { min_s = str(minute()); }

	//時間が1桁の時は先頭に0をつける
	if(hour() < 10) { hou_s = "0" + str(hour()); }
	else { hou_s = str(hour()); } 


	//Get the value of time
	sec = second();
	min = minute();
	hou = hour() % 12.0;
	
	srad = (360 * (sec - 15) / 60.0) * -1;//秒の角度導出式
	mrad = (360 * (min - 15) / 60.0) * -1;//分の角度導出式
	hrad = (360 * hou / 12.0) * -1;//時間の角度導出式

	s = int(sec);//second value convert int type to float type
	m = int(min);//minute value convert int type to float type
	h = int(hou);//hour value convert int type to float type

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
	text(s + "s", sin(radians(srad + 90)) * sRange + hx - 10, cos(radians(srad + 90)) * sRange + hy + 8.5);
	noFill();
	
	//Display minute value into ellipse
	fill(255, 255, 255);
	ellipse(sin(radians(mrad + 90)) * mRange + hx, cos(radians(mrad + 90)) * mRange + hy, 60, 60);
	noFill();

	fill(0, 0, 0);
	text(m + "m", sin(radians(mrad + 90)) * mRange + hx - 10, cos(radians(mrad + 90)) * mRange + hy + 8.5);
	noFill();

	//Display hour value into ellipse
	fill(255, 255, 255);
	ellipse(sin(radians(hrad + 180)) * hRange + hx, cos(radians(hrad + 180)) * hRange + hy, 60, 60);
	noFill();

	fill(0, 0, 0);
	text(h + "h", sin(radians(hrad + 180)) * hRange + hx - 10, cos(radians(hrad + 180)) * hRange + hy + 8.5);
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