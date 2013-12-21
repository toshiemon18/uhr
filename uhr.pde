//円を使ってぐるぐる回して時計ライクなもの
//進捗ダメなので冬休みから頑張ります(12/21～)
//ToDo
//-前に描画した円を消去するアルゴリズム

int ang = 360;

void setup(){
	size(displayWidth, displayHeight);
	colorMode(RGB);
	background(0, 0, 0);
	smooth();
	PFont uhr = createFont("Gabriola", 60);
	textFont(uhr);
}

void draw(){
	float sec, min, hou;//秒、分、時間
	float sRange = 300.0;//秒の円周の半径
	float mRage = 60.0;//分の円周の半径
	float hx = displayWidth / 2;//ディスプレイの中心のx座標
	float hy = displayHeight / 2;//ディスプレイの中心のy座標
	float sRad; //算出した角度を格納する(秒円用)
	float mRad;	//算出した角度を格納する(分円用)

	sec = second();
	min = minute() + (sec/60.0);
	hou = hour() % 12.0 + (min/60.0);

	sRad = (360 * (sec - 15) / 60) * -1;//秒円の角度導出式

	ellipse(sin(radians(sRad + 90)) * sRange + hx, cos(radians(sRad + 90)) * sRange + hy, 20 * PI, 20 * PI);




	println("Now time : "+hou+":"+min+":"+sec);

}