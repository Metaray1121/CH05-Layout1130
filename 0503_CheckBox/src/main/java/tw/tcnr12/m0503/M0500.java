package tw.tcnr12.m0503;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class M0500 extends AppCompatActivity {

    private CheckBox chb01, chb02, chb03, chb04;
    private Button b001;
    private TextView t001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        chb01 = (CheckBox) findViewById(R.id.m0503_chb01);
        chb02 = (CheckBox) findViewById(R.id.m0503_chb02);
        chb03 = (CheckBox) findViewById(R.id.m0503_chb03);
        chb04 = (CheckBox) findViewById(R.id.m0503_chb04);
        b001 = (Button) findViewById(R.id.m0503_b001);
        t001 = (TextView) findViewById(R.id.m0503_t001);

        b001.setOnClickListener(b001on);
    }

    //-----------------------------------宣告b001on
    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            String ans01 = getString(R.string.m0503_t001);                    //這行是從 t001.setText(ans01)生出來的,ans01要改成String

            if (chb01.isChecked()) ans01 += chb01.getText().toString() + " ";     //if判斷式 如果chb0x被點擊, ans01 = ans01 + chb01
            if (chb02.isChecked()) ans01 += chb02.getText().toString() + " ";
            if (chb03.isChecked()) ans01 += chb03.getText().toString() + " ";
            if (chb04.isChecked()) ans01 += chb04.getText().toString() + " ";

            t001.setText(ans01);                                                                //這行先打

        }
    };
}