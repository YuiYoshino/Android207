package jp.ac.hec.cm0107.android207;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RowModelAdapter adapter = new RowModelAdapter(MainActivity.this);
                ArrayList<Student> students = JsonHelper.parseJson(getData());
//                StringBuilder sb = new StringBuilder();
                for (Student tmp: students){
//                    sb.append("名前："+ tmp.getName()+"\n");
//                    sb.append("学籍番号："+ tmp.getId()+"\n");
//                    sb.append("好きなゲーム："+ tmp.getGame()+"\n");
                }
//                TextView txtResult = findViewById(R.id.txtResult);
//                txtResult.setText(sb.toString());
                ListView list = findViewById(R.id.studentList);
                list.setAdapter(adapter);
            }
        });

    }
    class RowModelAdapter extends ArrayAdapter{

        public RowModelAdapter(@NonNull Context context) {
            super(context, R.layout.row_item);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Student item =(Student) getItem(position);
            if(convertView == null){
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.row_item,null);
            }
            if (item != null){
                TextView txtName = convertView.findViewById(R.id.txtName);
                if (txtName != null){
                    txtName.setText(item.getName());
                }
                TextView txtId = convertView.findViewById(R.id.txtId);
                if(txtId != null){
                    txtId.setText(String.valueOf(item.getId()));
                }
            }
            return convertView;
        }
    }
    private String getData() {
        String json = "";
        BufferedReader br = null;
        try{
            InputStream in = getAssets().open("studentList.json");
            br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine())!= null){
                sb.append(line);
            }
            json = sb.toString();
        }catch (Exception e){
            Log.e("MainActivity", Log.getStackTraceString(e));
        }finally {
            try {
                if(br != null)br.close();
            }catch (IOException e){
                Log.e("MainActivity", Log.getStackTraceString(e));
            }
        }
        return json;
    }
}