package com.example.imagenes_transparentes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

// https://stackoverflow.com/questions/44495167/image-change-in-imageview-when-its-clicked
// https://stackoverflow.com/questions/6690530/how-to-show-one-layout-on-top-of-the-other-programmatically-in-my-case
// https://stackoverflow.com/questions/3821684/is-it-possible-to-place-one-view-over-another-in-android
// https://stackoverflow.com/questions/15116393/fit-image-in-imagebutton-in-android
// https://stackoverflow.com/questions/5291726/what-is-the-main-purpose-of-settag-gettag-methods-of-view
// https://stackoverflow.com/questions/4526585/get-the-id-of-a-drawable-in-imageview

public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    ImageView sombrero;
    ImageView gafas;
    int oatmealColor;
    int cyanColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sombrero = findViewById(R.id.sombrero);
        gafas = findViewById(R.id.gafas);

        imagen = findViewById(R.id.jesse);
        imagen.setImageResource(R.drawable.jesse);

        oatmealColor = getResources().getColor(R.color.oatmeal);
        cyanColor = getResources().getColor(R.color.cyan);
    }


    public void usarComplemento(View view) {

        switch (view.getId()) {
            case R.id.btn_gafas_1:
                cambiarGafas(view, R.drawable.gafas1);
                break;
            case R.id.btn_gafas_2:
                cambiarGafas(view, R.drawable.gafas2);
                break;
            case R.id.btn_gafas_3:
                cambiarGafas(view, R.drawable.gafas3);
                break;
            case R.id.btn_gafas_4:
                cambiarGafas(view, R.drawable.gafas4);
                break;
            case R.id.btn_sombrero_1:
                cambiarSombrero(view, R.drawable.sombrero1);
                break;
            case R.id.btn_sombrero_2:
                cambiarSombrero(view, R.drawable.sombrero2);
                break;
            case R.id.btn_sombrero_3:
                cambiarSombrero(view, R.drawable.sombrero3);
                break;
            case R.id.btn_sombrero_4:
                cambiarSombrero(view, R.drawable.sombrero4);
                break;
        }
    }


    public void cambiarGafas(View view, Integer resource) {
        apagarBotonesGafas();
        Drawable drawable = gafas.getDrawable();
        if (drawable == null || resource != getDrawableId(gafas)) {
            gafas.setImageResource(resource);
            gafas.setTag(resource);
            view.setBackgroundColor(cyanColor);
        } else {
            gafas.setImageDrawable(null);
            view.setBackgroundColor(oatmealColor);
        }
    }

    public void cambiarSombrero(View view, Integer resource) {
        apagarBotonesSombreros();
        Drawable drawable = sombrero.getDrawable();
        if (drawable == null || resource != getDrawableId(sombrero)) {
            sombrero.setImageResource(resource);
            sombrero.setTag(resource);
            view.setBackgroundColor(cyanColor);
        } else {
            sombrero.setImageDrawable(null);
            view.setBackgroundColor(oatmealColor);
        }
    }

    private int getDrawableId(ImageView iv) {
        return (Integer) iv.getTag();
    }

    public void apagarBotonesGafas(){
        LinearLayout ll = findViewById(R.id.linearLayoutGafas);
        final int childCount = ll.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View v = ll.getChildAt(i);
            v.setBackgroundColor(oatmealColor);
        }
    }

    public void apagarBotonesSombreros(){
        LinearLayout ll = findViewById(R.id.linearLayoutSombreros);
        final int childCount = ll.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View v = ll.getChildAt(i);
            v.setBackgroundColor(oatmealColor);
        }
    }
}
