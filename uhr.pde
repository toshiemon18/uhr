//円を使ってぐるぐる回して時計ライクなもの
//進捗ダメなので冬休みから頑張ります(12/21～)
//ToDo
//-時計回りの動作
//-1分ごとの秒の誤差の修正
//-前に描画した円を消去するアルゴリズム

int ang = 360;

void setup(){
	size(displayWidth, displayHeight);
	colorMode(RGB);
	background(0, 0, 0);
	smooth();
	PFont uhr = loadFont("AgencyFB-Reg-18.vlw");
  	textFont(uhr, 21);
}

void draw(){
	float sec, min, hou;//秒、分、時間
	int s, m ,h;//キャストして表示するための
	float sRange = 300.0;//秒の円周の半径
	float mRage = 60.0;//分の円周の半径
	float hx = displayWidth / 2, hy = displayHeight / 2;//ディスプレイの中心座標
	float sRad; //算出した角度を格納する(秒円用)
	float mRad;	//算出した角度を格納する(分円用)

	sec = second();
	min = minute() + (sec/60.0);
	hou = hour() % 12.0 + (min/60.0);

	sRad = (360 * (sec - 15) / 60) * -1;//秒の角度導出式

	s = int(sec);

	fill(255, 255, 255);
	ellipse(sin(radians(sRad + 90)) * sRange + hx, cos(radians(sRad + 90)) * sRange + hy, 10 * PI, 10 * PI);
	noFill();

	fill(0, 0, 0);
	text(s, sin(radians(sRad + 90)) * sRange + hx - 7, cos(radians(sRad + 90)) * sRange + hy + 8.5);
	noFill();
	

	println("Now time : "+hou+":"+min+":"+s);

}