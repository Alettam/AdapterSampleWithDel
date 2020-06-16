package com.example.adaptersample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    private ItemsDataAdapter adapter;
    private List<Drawable> images = new ArrayList<>();
    private Button delBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.myToolbar);
        ListView listView = findViewById(R.id.listView);
        delBtn = findViewById(R.id.delBtn);
        setSupportActionBar(toolbar);

        fillImages();

        adapter = new ItemsDataAdapter(this,null);
        listView.setAdapter(adapter);

        generateRandomItemData();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showItemData(i);
                return true;
            }
        });

    }

    private void showItemData(int position) {
        ItemData itemData = adapter.getItem(position);
        Toast.makeText(MainActivity.this,
                        "Subtitle: " + itemData.getSubtitle() + "\n",
                Toast.LENGTH_SHORT).show();
    }

    private void generateRandomItemData() {
        adapter.addItem(new ItemData(
                images.get(random.nextInt(images.size())),
                "HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello" + adapter.getCount(),
                "Записная книжка",
                random.nextBoolean()));

        adapter.addItem(new ItemData(
                images.get(random.nextInt(images.size())),
                "HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello" + adapter.getCount(),
                "Подсписка",
                random.nextBoolean()));

        adapter.addItem(new ItemData(
                images.get(random.nextInt(images.size())),
                "HelloHelloHelloHelloHelloHelloHello" + adapter.getCount(),
                "Фотогалерея",
                random.nextBoolean()));

        adapter.addItem(new ItemData(
                images.get(random.nextInt(images.size())),
                "HelloHelloHelloHelloHelloHelloHelloHelloHelHelloHelloHelloHelloHelloHello" + adapter.getCount(),
                "Мониторинг здоровья",
                random.nextBoolean()));

        adapter.addItem(new ItemData(
                images.get(random.nextInt(images.size())),
                "HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello" + adapter.getCount(),
                "Оплата",
                random.nextBoolean()));

        adapter.addItem(new ItemData(
                images.get(random.nextInt(images.size())),
                "HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello" + adapter.getCount(),
                "Ввод адреса",
                random.nextBoolean()));

        adapter.addItem(new ItemData(
                images.get(random.nextInt(images.size())),
                "HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello" + adapter.getCount(),
                "Календарь",
                random.nextBoolean()));

    }

    private void fillImages() {
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_report_image));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_add));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_agenda));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_camera));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_call));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        int id = item.getItemId();

        switch (id){
            case R.id.action_open_notes:
                Toast.makeText(MainActivity.this, "Открыть запиную книжку", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,NotesActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_open_subscription:
                Toast.makeText(MainActivity.this, "Открыть подписку", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,SubscriptionActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_open_foto:
                Toast.makeText(MainActivity.this, "Открыть фотогалерею", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,FotoActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_open_health:
                Toast.makeText(MainActivity.this, "Открыть фотогалерею", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,HealthActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_open_payment:
                Toast.makeText(MainActivity.this, "Открыть оплату", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,PaymentActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_open_spinner:
                Toast.makeText(MainActivity.this, "Открыть ввод адреса", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,SpinerActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_open_calendarview:
                Toast.makeText(MainActivity.this, "Открыть календарь", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,CalendarviewActivity.class);
                startActivity(intent);
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }
}