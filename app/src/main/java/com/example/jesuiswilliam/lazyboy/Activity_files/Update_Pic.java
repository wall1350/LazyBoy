package com.example.jesuiswilliam.lazyboy.Activity_files;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesuiswilliam.lazyboy.R;
import com.example.jesuiswilliam.lazyboy.Function_class.BitmapToBase64Util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.*;
import com.google.firebase.storage.UploadTask;


public class Update_Pic extends AppCompatActivity {
    private static final String TAG = "CameraView";
    private boolean thisGuyCanUpate = true;
    private Button update;
    private ImageButton imageButton;
    private Bitmap originalBitmap;
    private TextView update_text;
    //保存 照片的目录
    private String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "mms";


    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    String userName = user.getUid();
    FirebaseStorage storage = FirebaseStorage.getInstance();
    // Create a storage reference from our app
    StorageReference storageRef = storage.getReference();
    Uri file;
    TimeStamp ts = new TimeStamp();
    String dateString = ts.swapDateToStr();


    // Create a reference to 'images/userName+dateString+.jpg'
    StorageReference mountainImagesRef = storageRef.child("images/"+userName+"dateString.jpg");
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("messages/"+userName);


    static int REQUEST_READ_EXTERNAL_STORAGE = 0;
    static boolean read_external_storage_granted = false;
    private final int ACTION_PICK_PHOTO = 1;
    private String base64;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        imageButton = (ImageButton)findViewById(R.id.imageButton1);
        update = (Button) findViewById(R.id.update_bt);
        update_text = (TextView)findViewById(R.id.update_text);
        if(!thisGuyCanUpate){
            update.setEnabled(false);
            update.setText("您已經上傳過了");
        }

        if (ContextCompat.checkSelfPermission(Update_Pic.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.i("permission", "request READ_EXTERNAL_STORAGE");
            ActivityCompat.requestPermissions(Update_Pic.this, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE },
                    REQUEST_READ_EXTERNAL_STORAGE);
        } else {
            Log.i("permission", "READ_EXTERNAL_STORAGE already granted");
            read_external_storage_granted = true;
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (read_external_storage_granted) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, ACTION_PICK_PHOTO);
                } else {
                    Log.i("read_photos", "read_external_storage_granted=0");
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i("permission", "READ_EXTERNAL_STORAGE granted");
                read_external_storage_granted = true;
            } else {
                Log.i("permission", "READ_EXTERNAL_STORAGE denied");
            }
        }
    }
    public void sendTocloud(View view){

        Toast toast2 = Toast.makeText(Update_Pic.this,
                "上傳中", Toast.LENGTH_SHORT);
        //顯示Toast
        toast2.show();
        //上傳
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        originalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] baosdata = baos.toByteArray();

        // Write a message to the database

        UploadTask uploadTask = mountainImagesRef.putBytes(baosdata);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast toast = Toast.makeText(Update_Pic.this,
                        "失敗", Toast.LENGTH_LONG);
                //顯示Toast
                toast.show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast toast = Toast.makeText(Update_Pic.this,
                        "成功", Toast.LENGTH_LONG);
                //顯示Toast
                toast.show();
                finish();

            }
        });

        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }

                // Continue with the task to get the download URL
                return mountainImagesRef.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                    myRef.child("user email").setValue(user.getEmail());
                    myRef.child("date").setValue(dateString);
                    myRef.child("description").setValue(update_text.getText().toString());
                    myRef.child("photo uri").setValue(downloadUri.toString());
                } else {
                    // Handle failures
                    // ...
                }
            }
        });

    }
    //以下參考蔡主任教的程式碼
    @Override
    protected void onActivityResult(int requeestCode, int resultCode, Intent data) {
        super.onActivityResult(requeestCode, resultCode, data);
        if (requeestCode == ACTION_PICK_PHOTO && resultCode == RESULT_OK && null != data && read_external_storage_granted) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            String picturePath;
            if (cursor == null) {
                Log.i("data", "cannot load any image");
                return;
            } else {
                try {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    picturePath = cursor.getString(columnIndex);
                } finally {
                    cursor.close();
                }
            }

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap temp = BitmapFactory.decodeFile(picturePath, options);


            int orientation = 0;
            try {
                ExifInterface imgParams = new ExifInterface(picturePath);
                orientation = imgParams.getAttributeInt(
                        ExifInterface.TAG_ORIENTATION,
                        ExifInterface.ORIENTATION_UNDEFINED);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            if (temp != null) {
                Matrix rotate90 = new Matrix();
                rotate90.postRotate(orientation);

                originalBitmap = rotateBitmap(temp, orientation);

                imageButton.setImageBitmap(originalBitmap);


                //base64 = BitmapToBase64Util.bitmapToBase64(originalBitmap);
            }
            else {
                Log.i("data", "originalBitmap is empty");
            }
        }
    }
    public static Bitmap rotateBitmap(Bitmap bitmap, int orientation) {
        Matrix matrix = new Matrix();
        switch (orientation) {
            case ExifInterface.ORIENTATION_NORMAL:
                return bitmap;
            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
                matrix.setScale(-1, -1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                matrix.setRotate(180);
                break;
            case ExifInterface.ORIENTATION_FLIP_VERTICAL:
                matrix.setRotate(180);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_TRANSPOSE:
                matrix.setRotate(90);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_90:
                matrix.setRotate(90);
                break;
            case ExifInterface.ORIENTATION_TRANSVERSE:
                matrix.setRotate(-90);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                matrix.setRotate(-90);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap bmRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return bmRotated;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
}


 class TimeStamp {
    private long timeStamp = System.currentTimeMillis();
    public String printTimeStamp(){
        return "TimeStamp: " + String.valueOf(timeStamp);
    }
    public String swapDateToStr(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
        return "Date: " + format.format(new Date(timeStamp));
    }


}

