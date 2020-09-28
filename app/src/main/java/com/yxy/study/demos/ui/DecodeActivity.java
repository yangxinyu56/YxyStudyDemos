package com.yxy.study.demos.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.HybridBinarizer;
import com.yxy.study.demos.R;
import com.yxy.study.demos.XLog;

import java.util.HashMap;
import java.util.Map;

public class DecodeActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decode);
        imageView = findViewById(R.id.iv_test);
        imageView.setImageDrawable(getResources().getDrawable(R.mipmap.testcode));
        findViewById(R.id.btn_start_t).setOnClickListener(v -> {
            test1();
        });
    }

    private void test1() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.testcode)
                .copy(Bitmap.Config.ARGB_8888, true);//从文件得到一个位图对象。要调用copy函数重新生成位图，不然会报错
        /*Bitmap bitmap=Bitmap.createBitmap(800,600,Bitmap.Config.ARGB_8888);*/
        Canvas canvas = new Canvas(bitmap);//创建一个空画布，并给画布设置位图
        Paint p = new Paint();
        p.setColor(0xff00ff00);//设置画笔颜色
        p.setAntiAlias(true);//抗锯齿
        p.setTextSize(50);//设置字体大小

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        final int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        RGBLuminanceSource luminanceSource = new RGBLuminanceSource(width, height, pixels);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

        // 原图里面二维码的url
        String originalURL = null;
        Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
        Result result = null;
        try {
            result = new MultiFormatReader().decode(binaryBitmap, hints);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        originalURL = result.getText();

        // 解码
        ResultPoint[] resultPoint = result.getResultPoints();
        XLog.i("原二维码里面的url:" + originalURL + ",\npoints1： " + resultPoint[0] + ",\npoints2： " + resultPoint[1] + ",\npoints3： "
                + resultPoint[2] + ",\npoints4： " + resultPoint[3]);

        // 获得二维码坐标
        float point1X = resultPoint[0].getX();
        float point1Y = resultPoint[0].getY();
        float point2X = resultPoint[1].getX();
        float point2Y = resultPoint[1].getY();
        float point3X = resultPoint[2].getX();
        float point3Y = resultPoint[2].getY();
        float point4X = resultPoint[3].getX();
        float point4Y = resultPoint[3].getY();

        Bitmap girlBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.code2)
                .copy(Bitmap.Config.ARGB_8888, true);
        int sca = (int) (point3X - point1X) + 100;
        Bitmap bitmap1 = scaleBitmap(girlBitmap, sca, sca);
        canvas.drawBitmap(bitmap1, point2X - 50, point2Y - 50, null);
        imageView.setImageBitmap(bitmap);//给ImageView设置新的图片
    }

    /**
     * 根据给定的宽和高进行拉伸
     *
     * @param origin    原图
     * @param newWidth  新图的宽
     * @param newHeight 新图的高
     * @return new Bitmap
     */
    private Bitmap scaleBitmap(Bitmap origin, int newWidth, int newHeight) {
        if (origin == null) {
            return null;
        }
        int height = origin.getHeight();
        int width = origin.getWidth();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);// 使用后乘
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (!origin.isRecycled()) {
            origin.recycle();
        }
        return newBM;
    }

}
