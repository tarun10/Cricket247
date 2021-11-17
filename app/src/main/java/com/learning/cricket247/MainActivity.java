 package com.learning.cricket247;

 import android.app.ProgressDialog;
 import android.content.Intent;
 import android.graphics.Bitmap;
 import android.graphics.BitmapFactory;
 import android.net.Uri;
 import android.os.Bundle;
 import android.util.DisplayMetrics;
 import android.view.MenuItem;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.Button;
 import android.widget.ImageView;
 import android.widget.Toast;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.appcompat.widget.Toolbar;
 import androidx.fragment.app.Fragment;
 import androidx.navigation.NavController;

 import com.bumptech.glide.Glide;
 import com.bumptech.glide.load.engine.DiskCacheStrategy;
 import com.google.android.gms.tasks.OnFailureListener;
 import com.google.android.gms.tasks.OnSuccessListener;
 import com.google.android.material.bottomnavigation.BottomNavigationView;
// import com.google.firebase.storage.FileDownloadTask;
// import com.google.firebase.storage.FirebaseStorage;
// import com.google.firebase.storage.StorageReference;
 import com.learning.cricket247.utility.constantfiles.ConstantLinks;

 import java.io.File;
 import java.io.IOException;

 public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavController navController;
    Toolbar toolbar;
    private ImageView adsframe;
//    StorageReference storageReference;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



//        final long ONE_MEGABYTE = 1024 * 1024;
//        storageReference.getBytes(ONE_MEGABYTE)
//                .addOnSuccessListener(new OnSuccessListener<byte[]>() {
//                    @Override
//                    public void onSuccess(byte[] bytes) {
//                                            if (progressDialog.isShowing())
//                        progressDialog.dismiss();
//                        Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                        DisplayMetrics dm = new DisplayMetrics();
//                        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//                        adsframe.setMinimumHeight(dm.heightPixels);
//                        adsframe.setMinimumWidth(dm.widthPixels);
//                        adsframe.setImageBitmap(bm);
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle any errors
//                                    if (progressDialog.isShowing())
//                        progressDialog.dismiss();
//            }
//        });

    }

    //hello
//     @Override
//     protected void onResume() {
//         super.onResume();
//
//         progressDialog = new ProgressDialog(MainActivity.this);
//         progressDialog.setMessage("Loading");
//         progressDialog.setCancelable(false);
//         progressDialog.show();
//
//         storageReference = FirebaseStorage.getInstance().getReference("images/bottomaads.jpeg");
//
//         try {
//             File localFile = File.createTempFile("tempfile",".jpeg");
//             storageReference.getFile(localFile)
//                     .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                         @Override
//                         public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//
//                             if (progressDialog.isShowing())
//                                 progressDialog.dismiss();
//
//                             Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                             adsframe.setImageBitmap(bitmap);
//                         }
//                     }).addOnFailureListener(new OnFailureListener() {
//                 @Override
//                 public void onFailure(@NonNull Exception e) {
//                     if (progressDialog.isShowing())
//                         progressDialog.dismiss();
//                     adsframe.setImageBitmap(null);
//                     Toast.makeText(MainActivity.this, "Failed to Retrive image", Toast.LENGTH_SHORT).show();
//                 }
//             });
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

     private void init() {

        adsframe = findViewById(R.id.adsframe);

        try {
            Glide.
                    with(getApplicationContext()).
                    load(""+ConstantLinks.BANNER_IMAGE_URL)
                    .into(adsframe);

        }catch (Exception e){

        }

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer, new HomeFragment()).commit();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        adsframe.setOnClickListener(view -> {

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(ConstantLinks.getWHATSAPPLINK()));
            startActivity(i);
        });

    }



    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seletctedFragment = null;
            switch (item.getItemId()){
                case R.id.homeFragment:
                    seletctedFragment = new HomeFragment();
                    break;
                case R.id.newsFragment:
                    seletctedFragment = new NewsFragment();
                    break;
                case R.id.fixturesFragment:
                    seletctedFragment = new FixturesFragment();
                    break;
                case R.id.settingsFragment:
                    seletctedFragment = new SettingsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conainer,seletctedFragment).commit();
            return true;
        }
    };
}