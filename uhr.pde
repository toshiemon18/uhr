//円を使ってぐるぐる回して時計ライクなもの
//進捗ダメなので冬休みから頑張ります(12/21～)
//ToDo
//-時計回りの動作
//-1分ごとの秒の誤差の修正
//-前に描画した円を消去するアルゴリズム

void setup(){
	size(displayWidth, displayHeight);
	colorMode(RGB);
	background(0, 0, 0);
	smooth();
	PFont uhr = loadFont("AgencyFB-Reg-18.vlw");
  	textFont(uhr, 21);
  	stroke(255, 255, 255);
}

void draw(){
	background(0, 0, 0);
	float sec, min, hou;//秒、分、時間
	int s, m ,h;//コンバートして表示するための
	float sRange = 300.0;//秒の円周の半径
	float mRange = 230.0;//分の円周の半径
	float hx = displayWidth / 2, hy = displayHeight / 2;//ディスプレイの中心座標
	float sRad; //算出した角度を格納する(秒円用)
	float mRad;	//算出した角度を格納する(分円用)

	sec = second();
	min = minute() + (sec/60.0);
	hou = hour() % 12.0 + (min/60.0);

	sRad = (360 * (sec - 15) / 60.0) * -1;//秒の角度導出式
	mRad = (360 * (min - 15) /60.0) * -1;//分の角度導出式

	s = int(sec);//秒の値をfloatからintへコンバート
	m = int(min);//分の値をfloatからintへコンバート
	h = int(hou);//時間の値をfloatからintへコンバート

	//秒円の表現
	fill(255, 255, 255);
	ellipse(sin(radians(sRad + 90)) * sRange + hx, cos(radians(sRad + 90)) * sRange + hy, 20 * PI, 20 * PI);
	noFill();
	//秒の値を円の中に表示	
	fill(0, 0, 0);
	text(s, sin(radians(sRad + 90)) * sRange + hx - 7, cos(radians(sRad + 90)) * sRange + hy + 8.5);
	noFill();
	
	//分円の表現
	fill(255, 255, 255);
	ellipse(sin(radians(mRad + 90)) * mRange + hx, cos(radians(mRad + 90)) * mRange + hy, 20 * PI, 20 * PI);
	noFill();
	//分の値を円の中に表示
	fill(0, 0, 0);
	text(m, sin(radians(mRad + 90)) * mRange + hx - 7, cos(radians(mRad + 90)) * mRange + hy + 8.5);
	noFill();


	println("Now time : "+h+":"+m+":"+s);
}