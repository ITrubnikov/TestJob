package com.example.iatru.testjob;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;



public class PathView extends View implements View.OnClickListener {
    private Paint mPaint;
    private Path mPath;
    String[] mMs = MainActivity.getMs();
    int mj= MainActivity.getJ();

    public PathView(Context context) {
        super(context);

        // TODO Auto-generated constructor stub
        init();
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }




    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();
        mPaint.setColor(Color.RED);
        setOnClickListener(this);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setAntiAlias(true);

        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);


        Float x0 = Float.valueOf(mMs[1]);
        Float y0 = Float.valueOf(mMs[3]);
        Float x1;
        Float y1;

        mPath.moveTo(x0, y0);

        for (int i = 4; i < mj; i=i+2) {
            switch (mMs[i]) {
                case "V":
                case "v": {
                    if (Objects.equals(mMs[i], "v")) {
                        x1 = x0;
                        y1 = (y0 + Float.valueOf(mMs[i + 1]));
                        mPath.lineTo(x1, y1);
                        y0=y1;
                    }
                    break;
                }
                case "H":
                case "h": {
                    if (Objects.equals(mMs[i], "h")) {
                        x1 = (x0 + Float.valueOf(mMs[i + 1]));
                    } else {
                        x1 = Float.valueOf(mMs[i + 1]);
                    }
                    y1 = y0;
                    x0=x1;
                    mPath.lineTo(x1, y1);
                    break;
                }
                case "z": {
                    mPath.close();
                    break;
                }
            }
        }
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "View clicked.", Toast.LENGTH_SHORT).show();
        mPath.reset();
        mPaint.setColor(Color.GREEN);
    }
}
