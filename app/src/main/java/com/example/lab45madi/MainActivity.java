package com.example.lab45madi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button buttonSearch, buttonLike, buttonDislike, buttonGoToSite;
    private ImageView imageView;
    private TextView textViewLink;

    private int[] images = {R.drawable.labka4, R.drawable.labka5};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText1);
        buttonSearch = findViewById(R.id.button1);
        buttonLike = findViewById(R.id.buttonLike);
        buttonDislike = findViewById(R.id.buttonDislike);
        buttonGoToSite = findViewById(R.id.buttonGoToSite);
        imageView = findViewById(R.id.imageView);
        textViewLink = findViewById(R.id.textViewLink);

        imageView.setImageResource(images[currentIndex]);
        textViewLink.setText("https://steamcommunity.com/sharedfiles/filedetails/?l=vietnamese&id=2734048351");


        buttonSearch.setOnClickListener(v -> {
            String query = editText.getText().toString();
            Toast.makeText(this, "Поиск: " + query, Toast.LENGTH_SHORT).show();
        });


        buttonLike.setOnClickListener(v -> showNextImage());
        buttonDislike.setOnClickListener(v -> showNextImage());


        buttonGoToSite.setOnClickListener(v -> {
            String url = textViewLink.getText().toString();
            if (!url.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    private void showNextImage() {
        currentIndex++; // следующая картинка
        if (currentIndex >= images.length) {
            currentIndex = 0; // по кругу
        }
        imageView.setImageResource(images[currentIndex]);
        textViewLink.setText("https://www.youtube.com/channel/UCAn7OLz_UMhpbFpREAcGrFQ/videos?sort=p" + (currentIndex + 1));
    }
}
