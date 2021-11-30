package tw.tcnr07.m0500d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.text.DecimalFormat;

public class M0500 extends AppCompatActivity {

    private EditText e001;
    private Button b001;
    private TextView t003;
    private DecimalFormat pondsFormat;
    private String ans;
    private BottomNavigationView bottomBar; //底部按鈕
    private EditText e001_f;
    private Button b001_f;
    private TextView t003_f;
    private LinearLayout l01,l02;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {     //Ctrl+A=全選  Shift+Ctrl+Alt+L=排列好  Ctrl+Shift+"+"=展開 , +"-"=縮編
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewcomponent();                                                     //從這開始打"setup"     為了自定義方法
    }
    private void setupViewcomponent() {

        currentPage = R.id.m0500f_layout;
        ChangePage(R.id.m0500d_layout);

        //private void開頭 自定義配置
        l01 = (LinearLayout)findViewById(R.id.m0500d_layout);
        l02 = (LinearLayout)findViewById(R.id.m0500f_layout);
        e001 = (EditText) findViewById(R.id.m0500_e001);        //打"(EditText)findViewById"跑出"(id)"後打"R.id"找"m0500_e001"
        b001 = (Button) findViewById(R.id.m0500_b001);         //選擇EditText  Button TextView 要看相對應類型
        t003 = (TextView) findViewById(R.id.m0500_t003);
//-------------------------0500f
        e001_f = (EditText) findViewById(R.id.m0500f_e001);        //打"(EditText)findViewById"跑出"(id)"後打"R.id"找"m0500_e001"
        b001_f = (Button) findViewById(R.id.m0500f_b001);         //選擇EditText  Button TextView 要看相對應類型
        t003_f = (TextView) findViewById(R.id.m0500f_t003);
        b001_f.setOnClickListener(b001on);                                   //監聽 b001on=下面宣告要用的名字  "xxxx".setOnClickListener
        //---------------------0500g-------------------------------------------------
//        e001_g = (EditText) findViewById(R.id.m0500g_e001);        //打"(EditText)findViewById"跑出"(id)"後打"R.id"找"m0500_e001"
//        b001_g = (Button) findViewById(R.id.m0500g_b001);         //選擇EditText  Button TextView 要看相對應類型
//        t003_g = (TextView) findViewById(R.id.m0500g_t003);
//        t006_g = (TextView) findViewById(R.id.m0500g_t006);
//        t008_g = (TextView) findViewById(R.id.m0500g_t008);
//
//        b001_g.setOnClickListener(b001on);                                   //監聽 b001on=下面宣告要用的名字  "xxxx".setOnClickListener
//--------------------------------------------------------------------------------
        bottomBar = findViewById(R.id.bottom_menu); //底部按鈕
        bottomBar.setOnItemSelectedListener(bottomOn); //底部按鈕
//---------------------------------------------------------------------------------
        b001.setOnClickListener(b001on);                                   //監聽 b001on=下面宣告要用的名字  "xxxx".setOnClickListener
        b001_f.setOnClickListener(b001on);
    }
//---------------------------------------------------------------------------------
    private void ChangePage(int resID) {
        findViewById(currentPage).setVisibility(View.INVISIBLE);
        findViewById(resID).setVisibility(View.VISIBLE);

        currentPage=resID;
    }

    //----------------------------------------------------------------------------------
    NavigationBarView.OnItemSelectedListener bottomOn = new NavigationBarView.OnItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item01:
                ChangePage(R.id.m0500d_layout);
//                layout_show(1);
//                l01.setVisibility(View.VISIBLE);
//                l02.setVisibility(View.INVISIBLE);
                break;
            case R.id.item02:
                ChangePage(R.id.m0500f_layout);
//                layout_show(2);
//                l01.setVisibility(View.INVISIBLE);
//                l02.setVisibility(View.VISIBLE);
                break;
            case R.id.item03:
//                layout_show(3);
                break;
        }
        return true;
    }
};

//    private void layout_show(int i) {
//        l01.setVisibility(View.INVISIBLE);
//        l02.setVisibility(View.INVISIBLE);
//        switch(i){
//            case 1:
//                layout_show(1);
//                break;
//            case  2:
//                layout_show(2);
//                break;
//            case  3:
//                layout_show(3);
//                break;
//        }
//    }
//private NavigationBarView.OnItemSelectedListener bottomOn = new NavigationBarView.OnItemSelectedListener() {
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.m0200_team_info:
//                ChangePage(R.id.m0200_layout_team_manager);
//                break;
//            case R.id.m0200_team_list:
//                ChangePage(R.id.m0200_layout_list);
//                break;
//        }
//        return true;
//    }
//};
// ------------------------------------------------------------------------------

    private View.OnClickListener b001on = new View.OnClickListener() {         //private View開頭 宣告b001on按鈕被觸碰後要執行的動作
        @Override
        public void onClick(View v) {                                             // DecimalFormat   pondsFormat = new DecimalFormat("0.00000");   ---複製用

//            switch (v.getId()){
//               R.id.item01;
//
//               break;
//            }





            pondsFormat = new DecimalFormat("0.00000"); //複製上面的刪掉DecimalFormat後 pondsFormat選field
            if (e001.getText().toString().length() > 0) {
                ans = pondsFormat.format(Float.parseFloat(e001.getText().toString()) * 2.20462262);//紅的"ans"選local 然後選"String"  (number:"隨意打")
            } else {
                ans = "";
            }
            t003.setText(ans);                                                             //選t003是因為輸出在t003
        }
    };

}