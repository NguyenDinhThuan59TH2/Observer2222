package vn.edu.ntu.nguyendinhthuan.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

import vn.edu.ntu.nguyendinhthuan.util.MyDateDialog;

public class MainActivity extends AppCompatActivity implements MyDateDialog.OnMyDateChangeListener {
    EditText dateCongTac;
    ImageView imvCongtac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        setViews();
    }
    private void addViews () {
        dateCongTac = findViewById(R.id.dateCongTac);
        dateCongTac.setEnabled(false);
        imvCongtac = findViewById(R.id.imvCongtac);
    }
    private void setViews () {
        imvCongtac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDateDialog myDateDialog = new MyDateDialog(MainActivity.this, Calendar.getInstance(), MainActivity.this);
                myDateDialog.showDateDialog();
            }
        });
    }

    @Override
    public void dateUpdate(Calendar newDate) {
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append(newDate.get(newDate.DAY_OF_MONTH))
                .append("/")
                .append(newDate.get(newDate.MONTH) + 1)
                .append("/")
                .append(newDate.get(newDate.YEAR));
        dateCongTac.setText(stringBuilder.toString());
    }
}
