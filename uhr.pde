//円を使ってぐるぐる回して時計っぽいもの
int disp = 600;
float sRange = 250.0;//秒の円周の半径
float mRange = 180.0;//分の円周の半径
float hRange = 110.0;
float hx = disp / 2.0, hy = disp / 2.0;

void setup(){
	size(disp, disp);
	colorMode(RGB);
	background(0, 0, 0);
	PFont uhr = loadFont("AgencyFB-Reg-25.vlw");
  	textFont(uhr, 23);
  	stroke(255, 255, 255);
  	smooth();
}

void draw(){
	background(0, 0, 0);
	int pa = hour();
	float sec, min, hou;//秒、分、時間
	int s, m ,h;//コンバートして表示するための	
	float srad, mrad, hrad; //角度格納用
	String s_s, m_s, h_s;

	//テキスト変換
	//秒数が1桁のときは先頭に0をつける
	if(second() < 10)
		s_s = "0" + str(second());
	else
		s_s = str(second());

	//分が1桁のときは先頭に0をつける
	if(minute() < 10)
		m_s = "0" + str(minute());
	else
		m_s = str(minute());

	//時間が1桁の時は先頭に0をつける
	if(hour() < 10)
		h_s = "0" + str(hour());
	else
		h_s = str(hour());

	//時間の取得
	sec = second();
	min = minute();
	hou = hour() % 12.0;

	//円の表示位置を決定する角度の導出
	srad = (360 * (sec - 15) / 60.0) * -1;//秒の角度導出式
	mrad = (360 * (min - 15) / 60.0) * -1;//分の角度導出式
	hrad = (360 * (hou - 15) / 60.0) * -1;//時間の角度導出式

	s = int(sec);//秒の値をfloatからintへコンバート
	m = int(min);//分の値をfloatからintへコンバート
	h = int(hou);//時間の値をfloatからintへコンバート

	//ウィンドウの角に時間とプログラム名ひょうじする
	fill(255, 255, 255);
	text("Uhr", 10, 20);
	text(h_s + " : " + m_s + " : " + s_s, 10, 40);
	noFill();

	//秒円の表現
	fill(255, 255, 255);
	ellipse(sin(radians(srad + 90)) * sRange + hx, cos(radians(srad + 90)) * sRange + hy, 60, 60);
	noFill();
	//秒の値を円の中に表示	
	fill(0, 0, 0);
	text(s_s + "s", sin(radians(srad + 90)) * sRange + hx - 7.5, cos(radians(srad + 90)) * sRange + hy + 8.5);
	noFill();
	
	//分円の表現
	fill(255, 255, 255);
	ellipse(sin(radians(mrad + 90)) * mRange + hx, cos(radians(mrad + 90)) * mRange + hy, 60, 60);
	noFill();
	//分の値を円の中に表示
	fill(0, 0, 0);
	text(m_s + "m", sin(radians(mrad + 90)) * mRange + hx - 7.5, cos(radians(mrad + 90)) * mRange + hy + 8.5);
	noFill();

	//時間円の表現
	fill(255, 255, 255);
	ellipse(sin(radians(hrad + 90)) * hRange + hx, cos(radians(hrad + 90)) * hRange + hy, 60, 60);
	noFill();
	//時間の値を円の中に表示
	fill(0, 0, 0);
	text(h_s + "h", sin(radians(hrad + 90)) * hRange + hx - 7.5, cos(radians(hrad + 90)) * hRange + hy + 8.5);
	noFill();

	//AM・PMを表示する円を描画
	fill(255, 255, 255);
	ellipse(hx, hy, 30 * 3, 30 * 3);
	noFill();
	if(pa <= 12){
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