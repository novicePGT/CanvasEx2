package com.example.canvasex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final static int LINE =1, CIRCLE =2, RECT =3;
    /*전역 상수 선언으로 static을 사용한 이유는 전역적으로 쉽게 재사용하기 위해 사용했고, final은
      한번만 할당하여 변수가 항상 동일한 값을 사용하기 위해 사용하고 한 번 값을 넣어두면 절대 바뀌지 않는다.
      상수 이기때문에 LINE=1과 같은 식으로 선언하였다.*/
    final static int Cred =4, Cblue =5, Cgreen=6, FigureFILL=7, FigureSTROKE=8;
    static int curSharp = LINE;
    //curSharp는 현재 선택된 도형이 어떠한 것인지를 저장하고, 기본값을 선으로 설정하였다.
    static int changeColor = Cred;
    //curSharp는 현재 선택된 도형이 저장되어있으므로 도형을 변형하기위해 changeColor라는 멤버를 생성하였다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("그림판 만들기"); // 타이틀 설정.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // 상위 클래스의 생성자를 실행한다.
        MenuInflater menuInflater = getMenuInflater();
        // 메뉴의 인플레이터를 생성한다.
        menuInflater.inflate(R.menu.menu1, menu);
        // 메뉴의 XML파일 menu1을 등록한다.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 메뉴를 선택했을 때 어떤 동작을 할 것인지 이벤트처리 메소드이다.
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            //item.getItemId는 메뉴에 있는 아이템의 아이디를 가져온다.
            case R.id.itemLINE: // itemLINE이 선택되었을 때
                curSharp = LINE;
                return true;
            case R.id.itemCIRCLE: // itemCIRCLE이 선택되었을 때
                curSharp = CIRCLE;
                return true;
            case R.id.itemRECT: // itemRECT가 선택되었을 때
                curSharp = RECT;
                return true;
            case R.id.itemRED: // itemRED가 선택되었을 때
                changeColor = Cred;
                return true;
            case R.id.itemBLUE: // itemBLUE가 선택되었을 때
                changeColor = Cblue;
                return true;
            case R.id.itemGREEN: // itemGREEN이 선택되었을 때
                changeColor = Cgreen;
                return true;
            case R.id.itemFILL: // itemFILL이 선택되었을 때
                changeColor = FigureFILL;
                return true;
            case R.id.itemSTROKE: // itemSTROKE가 선택되었을 때
                changeColor = FigureSTROKE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}