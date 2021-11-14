package com.example.canvasex2;

import static com.example.canvasex2.MainActivity.CIRCLE;
import static com.example.canvasex2.MainActivity.Cblue;
import static com.example.canvasex2.MainActivity.Cgreen;
import static com.example.canvasex2.MainActivity.Cred;
import static com.example.canvasex2.MainActivity.FigureFILL;
import static com.example.canvasex2.MainActivity.FigureSTROKE;
import static com.example.canvasex2.MainActivity.LINE;
import static com.example.canvasex2.MainActivity.RECT;
import static com.example.canvasex2.MainActivity.changeColor;
import static com.example.canvasex2.MainActivity.curSharp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

class MyGraphicView extends View {
    //MainAcivity의 setContentView를 재정의한 클래스로 View클래스를 상속한다.
    int startX = -1, startY = -1, stopX = -1, stopY = -1;
    //좌표저장을 위한 클래스 멤버 변수 4개를 선언했다.
    public MyGraphicView(Context context) {
        super(context);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //터치했을때의 이벤트를 처리할 메소드이다.
        switch (event.getAction()) {
            //처음 터치했을 때가 선의 시작점이나 도형으 중심점이 되는데 이 위치를 기억한다.
            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX();
                //X의 좌표를 가져온다.
                startY = (int) event.getY();
                //Y의 좌표를 가져온다.
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                /*ACTION_MOVE와 ACTION_UP을 동일 취급한 이유는 드래그할 때마다 그려지는 것이 손가락을 따라
                다니면서 흔적을 보여주는 효과를 내기 위해서이다.*/
                stopX = (int) event.getX();
                //X의 좌표를 가져온다.
                stopY = (int) event.getY();
                //Y의 좌표를 가져온다.
                this.invalidate();
                //this.invalidate를 호출하면 화면이 무효화되고, onDraw메소드르 자동으로 실행한다.
                break;
        }
        return true;
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas); //상위 클래스의 onDraw를 호출한다.
        Paint paint = new Paint(); //Paint를 정의한다
        paint.setAntiAlias(true); //AntiAlias는 선을 부드럽게 해준다.
        paint.setStrokeWidth(5); //두께 설정으로 5px를 나타낸다.
        paint.setStyle(Paint.Style.STROKE); //빈 도형의 스타일을 보여준다.
        paint.setColor(Color.RED); //색상을 빨강색으로 정의한다.

        switch (changeColor) {
            case Cred: //만약 Cred일 경우
                paint.setColor(Color.RED);
                paint.setStrokeWidth(5);
                paint.setStyle(Paint.Style.STROKE);
                //색을 빨강색으로 나타내고, 두께는 5px, 빈 도형을 나타낸다.
                break;
            case Cblue:
                paint.setColor(Color.BLUE);
                paint.setStrokeWidth(5);
                paint.setStyle(Paint.Style.STROKE);
                //색을 파랑색으로 나타내고, 두께는 5px, 빈 도형을 나타낸다.
                break;
            case Cgreen:
                paint.setColor(Color.GREEN);
                paint.setStrokeWidth(5);
                paint.setStyle(Paint.Style.STROKE);
                //색을 초록색으로 나타내고, 5px, 빈 도형을 나타낸다.
                break;
            case FigureFILL:
                paint.setStyle(Paint.Style.FILL);
                //도형은 curSharp에 저장되어있으므로 FigureFILL를 선택하면 채워진 도형이 나타낸다.
                break;
            case FigureSTROKE:
                paint.setStyle(Paint.Style.STROKE);
                //도형은 curSharp에 저장되어있으므로 FigureSTROKE를 선택하면 빈 도형이 나타난다.
                break;
        }

        switch (curSharp) {
            case LINE:
                canvas.drawLine(startX, startY, stopX, stopY, paint);
                //LINE을 선택하면 X,Y에 대한 좌표를 저장하고 paint한다.
                break;
            case CIRCLE:
                int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2) +
                        Math.pow(stopY - startY, 2));
                //radius를 정수형 선언하고, 시작점과 끝점을 계산하여 반지름으로 사용한다.
                canvas.drawCircle(startX, startY, radius, paint);
                //시작점을 중심점으로 사용하고, 반지름이 radius인 원을 그린다.
                break;
            case RECT:
                canvas.drawRect(startX, startY, stopX, stopY, paint);
                //사각형을 그리는 함수로 X,Y 좌표를 저장하고 paint한다.
                break;
        }
    }
}