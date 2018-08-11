package androidruntimepermission.androidruntimepermission;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public int[] permissionCheck;

    public int MY_PERMISSIONS_ACCESS_ALL_PERMISSION;


//-- -- -- -- -Permission List declared in an array---- -- -- -- -///

    public String[] permissions = new

            String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,

            android.Manifest.permission.WRITE_CONTACTS,

            android.Manifest.permission.WRITE_CALENDAR, android.Manifest.permission.CALL_PHONE};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////--------cheak permiison----//
        ///-----BUG FIXED-------////


        permissionCheck = new int[]

                {ContextCompat.checkSelfPermission(this.getApplicationContext(),

                        android.Manifest.permission.ACCESS_COARSE_LOCATION),

                        ContextCompat.checkSelfPermission(this.getApplicationContext(),

                                android.Manifest.permission.WRITE_CONTACTS),

                        ContextCompat.checkSelfPermission(this.getApplicationContext(),

                                android.Manifest.permission.WRITE_CALENDAR),

                        ContextCompat.checkSelfPermission(this.getApplicationContext(),

                                android.Manifest.permission.CALL_PHONE)};

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            requestForPermission();

        }

    }



    public void call1(View view){


        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: +8801835559161"));
        startActivity(intent);



    }


    public void call2(View view){



        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: +8801682148802"));
        startActivity(intent);

        ///------this is call work-----


    }


    public void call3(View view){



        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: +8801834808579"));
        startActivity(intent);



    }




    public void requestForPermission() {

        if (permissionCheck[0] != PackageManager.PERMISSION_GRANTED ||

                permissionCheck[1] != PackageManager.PERMISSION_GRANTED || permissionCheck[2] !=

                PackageManager.PERMISSION_GRANTED || permissionCheck[3] !=

                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, permissions,

                    MY_PERMISSIONS_ACCESS_ALL_PERMISSION);

        }

    }

}