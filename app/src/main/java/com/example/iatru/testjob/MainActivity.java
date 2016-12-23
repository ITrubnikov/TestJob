package com.example.iatru.testjob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    public static String[] ms = new String[100];
    public static int  j =0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        String string = "M58.375,259.344v-76h526v-66.667h114.667v66.667h194v76h9.333v98.667h-9.333v72H58.375v-72H45.708v-98.667H58.375z";
        String delimiter = "MvhHz,";
        StringTokenizer strtoken = new StringTokenizer(string, delimiter, true);
        int i = 0;


        while (strtoken.hasMoreTokens()) {
            ms[i] = strtoken.nextToken();

            System.out.println(ms[i]);
            i++;
        }
        j=i-1;

        setContentView(new PathView(this));
    }

    public static String[] getMs() {
        return ms;
    }
    public static int getJ() {
        return j;
    }
}
