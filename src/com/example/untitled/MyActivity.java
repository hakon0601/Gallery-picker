package com.example.untitled;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MyActivity extends Activity {

    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath;
    private ImageView img;
    private Button but;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        img = (ImageView) findViewById(R.id.img);
        but = (Button) findViewById(R.id.but);
    }

    public void getGalleryImg(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = selectedImageUri.getPath(); //getPath(selectedImageUri);
                img.setImageURI(selectedImageUri);
            }
        }

    }
}
