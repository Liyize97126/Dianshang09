package com.bawei.dianshang09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 自定义控件（画图）
 */
public class MyView extends FrameLayout {
    //定义
    private Paint paint,paint1;
    public MyView(@NonNull Context context) {
        super(context);
        //调用画笔方法
        init();
        init1();
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //调用画笔方法
        init();
        init1();
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //调用画笔方法
        init();
        init1();
    }
    //初始化画笔
    private void init(){
        //画笔
        paint = new Paint();
        //画线
        paint.setStyle(Paint.Style.STROKE);
        //设置线的宽度（单位：像素(px)）
        paint.setStrokeWidth(15);
        //颜色
        paint.setColor(Color.parseColor("#ff00ff"));
    }
    private void init1(){
        //画笔
        paint1 = new Paint();
        //填充
        paint1.setStyle(Paint.Style.FILL);
        //设置线的宽度（单位：像素(px)）
        paint1.setStrokeWidth(10);
        //颜色
        paint1.setColor(Color.parseColor("#ff0000"));
    }
    //测量方法：测量控件本身的大小，有三种测量模式
    /*1、MeasureSpec.UNSPECIFIED,父视图不对子视图施加任何限制，子视图可以得到任意想要的大小；
    2、MeasureSpec.EXACTLY，父视图希望子视图的大小是specSize中指定的大小；
    3、MeasureSpec.AT_MOST，子视图的大小最多是specSize中的大小。*/
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    //布局方法：用于确定控件所在位置，左上右下四个坐标
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    //绘图方法：画线画圆等绘制操作
    //Canvas canvas   画布
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画线
        canvas.drawLine(50,50,50,600,paint);
        //画圆
        canvas.drawCircle(400,400,100,paint);
        //画矩形
        canvas.drawRect(new Rect(325,75,675,275),paint1);
        //画路径
        Path path = new Path();
        //moveTo方法是移动到路径的起点位置
        path.moveTo(300,800);
        //lineTo 连接下一个路径点（可以有多个）
        path.lineTo(500,800);
        path.lineTo(500,1000);
        path.lineTo(200,1000);
        //闭合路径
        path.close();
        paint.setColor(Color.parseColor("#ffff00"));
        canvas.drawPath(path,paint);
        //画文字
        paint.setColor(Color.parseColor("#00ffff"));
        paint.setStrokeWidth(5);
        paint.setTextSize(90);
        canvas.drawText("Android画板",200,600,paint);
        //画贝塞尔曲线
        //1.二阶贝塞尔曲线
        Path ebseqx = new Path();
        ebseqx.moveTo(50,700);
        //贝塞尔曲线（x1、y1：中间的曲线点；x2、y2：曲线终点）
        ebseqx.quadTo(150,800,250,700);
        ebseqx.quadTo(350,600,450,700);
        paint.setColor(Color.parseColor("#0000ff"));
        //完成绘制
        canvas.drawPath(ebseqx,paint);
        //2.三阶贝塞尔曲线
        Path sbseqx = new Path();
        ebseqx.moveTo(150,50);
        //贝塞尔曲线（x1、y1：中间的曲线点1；x2、y2：中间的曲线点2；x3、y3：曲线终点）
        ebseqx.cubicTo(60,250,240,450,150,650);
        //完成绘制
        canvas.drawPath(ebseqx,paint);
    }
}
