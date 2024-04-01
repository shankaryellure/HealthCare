package com.shankar.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[] [] doctor_details1 =
            {
                    {"Doctor Name : Anil Kumar","Hospital Address : Hyderabad", "Exp : 5 Yrs","Mobile no:9999999999","999"},
                    {"Doctor Name : Anil Kittu","Hospital Address : Delhi", "Exp : 6 Yrs","Mobile no:987654321","1099"},
                    {"Doctor Name : Manideep Goud","Hospital Address : Mumbai", "Exp : 3 Yrs","Mobile no:9988776655","799"},
                    {"Doctor Name : Karthik A","Hospital Address : Chennai", "Exp : 5 Yrs","Mobile no:9998765432","999"},
                    {"Doctor Name : Chaitanya Rao","Hospital Address : kolkata", "Exp : 7 Yrs","Mobile no:9999999999","1299"}
            };
    private String[] [] doctor_details2 =
            {
                    {"Doctor Name : Swathi pawar","Hospital Address : Hyderabad", "Exp : 5 Yrs","Mobile no:8973947362","999"},
                    {"Doctor Name : Anjali Gupta","Hospital Address : Delhi", "Exp : 6 Yrs","Mobile no:984746376223","1099"},
                    {"Doctor Name : Shardha Kapoor","Hospital Address : Mumbai", "Exp : 3 Yrs","Mobile no:87976547223","799"},
                    {"Doctor Name : Harsh gupta","Hospital Address : Chennai", "Exp : 5 Yrs","Mobile no:98768798654","999"},
                    {"Doctor Name : Meenakshi Sharma","Hospital Address : kolkata", "Exp : 7 Yrs","Mobile no:9898976583","1299"}
            };
    private String[] [] doctor_details3 =
            {
                    {"Doctor Name : Samyuktha Sharma","Hospital Address : Hyderabad", "Exp : 5 Yrs","Mobile no:9999999999","999"},
                    {"Doctor Name : Ishitha Sharma","Hospital Address : Delhi", "Exp : 6 Yrs","Mobile no:5674565433","1099"},
                    {"Doctor Name : Vijay Sethupati","Hospital Address : Mumbai", "Exp : 3 Yrs","Mobile no:9876543455","799"},
                    {"Doctor Name : Shankar Tillu","Hospital Address : Chennai", "Exp : 5 Yrs","Mobile no:9878976543","999"},
                    {"Doctor Name : Rakesh Mishra","Hospital Address : kolkata", "Exp : 7 Yrs","Mobile no:9654323456","1299"}
            };
    private String[] [] doctor_details4 =
            {
                    {"Doctor Name : Rajesh Kumar","Hospital Address : Hyderabad", "Exp : 5 Yrs","Mobile no:9345623423","999"},
                    {"Doctor Name : Harish Pawar","Hospital Address : Delhi", "Exp : 6 Yrs","Mobile no:8765434543","1099"},
                    {"Doctor Name : Shiva Kumar","Hospital Address : Mumbai", "Exp : 7 Yrs","Mobile no:7654323453","1199"},
                    {"Doctor Name : Rishi More","Hospital Address : Chennai", "Exp : 5 Yrs","Mobile no:6345765345","999"},
                    {"Doctor Name : Akash","Hospital Address : kolkata", "Exp : 7 Yrs","Mobile no:7895635634","1299"}
            };
    private String[] [] doctor_details5 =
            {
                    {"Doctor Name : Manju","Hospital Address : Hyderabad", "Exp : 5 Yrs","Mobile no:8978568455","999"},
                    {"Doctor Name : Alokh Nath","Hospital Address : Delhi", "Exp : 6 Yrs","Mobile no:987654321","1099"},
                    {"Doctor Name : kailesh kair","Hospital Address : Mumbai", "Exp : 15 Yrs","Mobile no:9988776655","1499"},
                    {"Doctor Name : Sonu Nigam","Hospital Address : Chennai", "Exp : 5 Yrs","Mobile no:9998765432","999"},
                    {"Doctor Name : Hirthik Roshan","Hospital Address : kolkata", "Exp : 7 Yrs","Mobile no:987987654","1299"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewLDPackageName);
        btn = findViewById(R.id.buttonLTGoToCart);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0; i<doctor_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
            }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i, long l){
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}