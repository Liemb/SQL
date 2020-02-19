package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Grades extends AppCompatActivity {

    SQLiteDatabase db;
    HelperDB hlp;
    EditText etNAME, etQUAR, etGRADE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        etNAME = (EditText) findViewById(R.id.etNAME);
        etQUAR = (EditText) findViewById(R.id.etQUAR);
        etGRADE = (EditText) findViewById(R.id.etGRADE);

        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();
    }

    /**
     * putting the edittext input in variables and the field name and the value in content value
     * @param view
     */
    public void sumbitg(View view) {

        String name, strQuar, strGrade;
        int Grade, Quar;
        name = etNAME.getText().toString();
        strQuar = etQUAR.getText().toString();
        Quar = Integer.parseInt(strQuar);
        strGrade = etGRADE.getText().toString();
        Grade = Integer.parseInt(strGrade);

        ContentValues cv = new ContentValues();
        cv.put(gradess.NAME, name);
        cv.put(gradess.QUARTER, Quar);
        cv.put(gradess.GRADE, Grade);

        db = hlp.getWritableDatabase();
        db.insert(gradess.TABLE_GRADES, null, cv);
        db.close();

    }

    /**
     * inflating oprions menu to go to other activities
     * @param menu
     */
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        String st = item.getTitle().toString();
        if (st.equals("students")) {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        if (st.equals("Info")){
            Intent si = new Intent(this, InfoActivity.class);
            startActivity(si);
        }
        if (st.equals("Sort")){
            Intent si = new Intent(this, SortActivity.class);
            startActivity(si);
        }
        if (st.equals("credits")){
            Intent si = new Intent(this, credits.class);
            startActivity(si);
        }
        return true;
    }
}