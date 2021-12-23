package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            loadFragment(new Fragment1());
        } else {
           // loadFragment(new Fragment2());
            // Диалоговое окно
            MyDialog md = new MyDialog();
            md.show(getSupportFragmentManager(),null);
        }
    }

    public void loadFragment(Fragment f) {
        // Менеджер переключения фрагментов
        FragmentManager fm = getSupportFragmentManager();

        // Передача данных во фрагмент
        Bundle args = new Bundle();
        args.putString("key","что-то!!!");
        f.setArguments(args);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frBody,f);
        ft.addToBackStack(null);
        ft.commit();
    }

}