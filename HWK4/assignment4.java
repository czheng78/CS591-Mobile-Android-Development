// 3.14
int rows = 4;
int cols = 2;
GridLayout gridLayout = new GridLayout(this);
gridLayout.setColumnCount(cols);
gridLayout.setRowCount(rows);

// 3.15
private Button button = new Button(this);

// 3.16
int btnrows = 5;
int btncols = 2;
private Button [][] buttons = new Button[btnrows][btncols];
for (int row=0; row<btnrows; row++) {
	for (int col=0; col<btncols; col++) {
		buttons[row][col] = new Button(this);
	}
}

// 3.17
GridLayout gl = new GridLayout(this);
private Button b = new Button(this);
int w_h = 200;
gl.addView(b,w_h,w_h);

// 3.21
private class ButtonHandler implements View.OnClickListener {
	public void onClick( View v ) {
		if (v==b) {
			Log.i("msg", "YES");
		} else {
			Log.i("msg", "NO");
		}
	}
}

// 7.18
protected void onCreate( Bundle savedInstanceState ){
	super.onCreate( savedInstanceState );

	setContentView(R.layout.activity_main);
	View view = findViewById(android.R.id.content);
	view.setOnTouchListener(this);
}

// 7.19
public boolean setOnTouchEvent( MotionEvent event ){
	detector.OnTouchEvent(event);
	return true;
}

