package com.example.koordination;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import static com.example.koordination.MainActivity.orientation;
public class MyView extends View {

    private float x, y; // Координаты шара
    private float vx, vy; // Скорость движения шара
    private Paint paint;

    public MyView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (x == 0 && y == 0) {
            // Инициализация координат при первом запуске
            x = canvas.getWidth() / 2;
            y = canvas.getHeight() / 2;
        }

        // Рисуем шар на текущей позиции
        canvas.drawCircle(x, y, 100, paint);

        // Обновляем позицию шара в соответствии со скоростью
        x += (orientation[2] % 2)*5;
        y += (orientation[1] % 2)*-5;

        // Проверяем, чтобы шар не выходил за границы экрана
        if (x < 100) {
            x = 100;
        }
        if (y < 100) {
            y = 100;
        }
        if (x > canvas.getWidth() - 100) {
            x = canvas.getWidth() - 100;
        }
        if (y > canvas.getHeight() - 100) {
            y = canvas.getHeight() - 100;
        }

        // Перерисовываем представление
        invalidate();
    }

    // Устанавливаем новую ориентацию
    public void setOrientation(float newVx, float newVy) {
        vx = newVx;
        vy = newVy;
    }
}

