package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView tvCategory;
    TextView tvSubCategory;
    Spinner spnCategory;
    Spinner spnSubCategory;
    Button btGo;

    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        int pos1 =spnCategory.getSelectedItemPosition();
        int pos2 =spnSubCategory.getSelectedItemPosition();
        prefEdit.putInt("pos1",pos1);
        prefEdit.putInt("pos2",pos2);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int pos1=prefs.getInt("pos1",0);
        int pos2=prefs.getInt("pos2",0);
        spnCategory.setSelection(pos1);
        spnSubCategory.setSelection(pos2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCategory = findViewById(R.id.textViewCategory);
        tvSubCategory = findViewById(R.id.textViewSubCategory);
        spnCategory = findViewById(R.id.spinnerCategory);
        spnSubCategory =findViewById(R.id.spinnerSubCategory);
        btGo = findViewById(R.id.button);

        alCategory = new ArrayList<>();

        aaCategory = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, alCategory);

        spnSubCategory.setAdapter(aaCategory);


        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spnCategory.getSelectedItemPosition();
                int subpos = spnSubCategory.getSelectedItemPosition();
                alCategory.clear();

                if (pos == 0 && subpos == 0){
                    String[] strCategory = getResources().getStringArray(R.array.RPSubCategory);
                    alCategory.addAll(Arrays.asList(strCategory));

                    Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                    intent.putExtra("URL","https://www.rp.edu.sg/");
                    startActivity(intent);
                }else if(pos == 0 && subpos ==1){
                    String[] strCategory = getResources().getStringArray(R.array.RPSubCategory);
                    alCategory.addAll(Arrays.asList(strCategory));

                    Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                    intent.putExtra("URL","https://www.rp.edu.sg/student-life");
                    startActivity(intent);
                }else if(pos ==1 && subpos ==0){
                    String[] strCategory = getResources().getStringArray(R.array.SOISubCategory);
                    alCategory.addAll(Arrays.asList(strCategory));

                    Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                    intent.putExtra("URL","https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                    startActivity(intent);
                }else{
                    String[] strCategory = getResources().getStringArray(R.array.SOISubCategory);
                    alCategory.addAll(Arrays.asList(strCategory));

                    Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                    intent.putExtra("URL","https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                    startActivity(intent);
                }
            }
        });


        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        alCategory.clear();
                        String[] strCategory = getResources().getStringArray(R.array.RPSubCategory);
                        alCategory.addAll(Arrays.asList(strCategory));
                        aaCategory.notifyDataSetChanged();
                        break;

                    case 1:
                        alCategory.clear();
                        String[] strCategory1 = getResources().getStringArray(R.array.SOISubCategory);
                        alCategory.addAll(Arrays.asList(strCategory1));
                        aaCategory.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
