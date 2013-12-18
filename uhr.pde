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
}

void draw(){
	float sec, min, hou; //秒、分、時間
	float sRange = 100.0;//秒の円周の半径
	float mRage = 60.0;//分の円周の半径
	int hx = 683;//時間の円のx座標
	int hy = 384;//時間の円のy座標


}