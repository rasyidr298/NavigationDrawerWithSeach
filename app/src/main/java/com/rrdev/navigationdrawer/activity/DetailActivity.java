package com.rrdev.navigationdrawer.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.rrdev.navigationdrawer.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvnama,tvdesc;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvnama = findViewById(R.id.tv_title);
        img = findViewById(R.id.iv);
        tvdesc = findViewById(R.id.tv_desc);

        Intent intent = getIntent();
        String nama = intent.getExtras().getString("name");
        String desc = intent.getExtras().getString("desc");
        int imge = intent.getExtras().getInt("img");

        tvnama.setText(nama);
        tvdesc.setText(desc);
        img.setImageResource(imge);

        //menampilkan tombol kembali
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    //action tombol kembali
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
