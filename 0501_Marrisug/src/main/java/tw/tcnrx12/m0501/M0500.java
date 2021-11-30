package tw.tcnrx12.m0501;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class M0500 extends AppCompatActivity {


    private EditText e001;
    private Spinner s001;
    private Button b001;
    private TextView ans01;
    private String sSex;    //選擇的性別

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0501);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        e001 = (EditText) findViewById(R.id.m0501_e001);
        s001 = (Spinner) findViewById(R.id.m0501_s001);
        b001 = (Button) findViewById(R.id.m0501_b001);
        ans01 = (TextView) findViewById(R.id.m0501_f000);


        b001.setOnClickListener(b001on);

        ArrayAdapter<CharSequence> adapterSexList =
                ArrayAdapter.createFromResource(
                        this, R.array.m0501_a001, R.layout.support_simple_spinner_dropdown_item);

        s001.setOnItemSelectedListener(s001on);


    }


    private AdapterView.OnItemSelectedListener s001on = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sSex = parent.getSelectedItem().toString();                   //選擇的性別會放在暫存區,再看會使用者輸入幾歲

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strsug = getString(R.string.m0501_f000);
//---------------------------------------------------------------------------------------
//檢查年齡是否輸入
            if (e001.getText().toString().length() > 0) {  //輸入大於0

                int iage = Integer.parseInt(e001.getText().toString());

                if (sSex.equals(getString(R.string.chk01))) {

//                -----男生---- -判斷年齡
                    if (iage < 28) {
                        strsug += getString(R.string.m0501_f001);
                    } else if (iage > 33) {
                        strsug += getString(R.string.m0501_f003);
                    } else {
                        strsug += getString(R.string.m0501_f002);
                    }
//                -----女生---- -判斷年齡
                } else {
                    if (iage < 25) {
                        strsug += getString(R.string.m0501_f001);
                    } else if (iage > 30) {
                        strsug += getString(R.string.m0501_f003);
                    } else {
                        strsug += getString(R.string.m0501_f002);
                    }
                }
//---------------------------------------------------------------------------------------
            } else {
                strsug = getString(R.string.nospace);           //輸入小於0,顯示nospace
            }
            ans01.setText(strsug);
        }


    };
}



