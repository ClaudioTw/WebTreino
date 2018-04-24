package com.example.claudio.webtreino.MODULOS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.claudio.webtreino.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Locale;

public class MeuTreinamento extends AppCompatActivity implements
        BaseSliderView.OnSliderClickListener, BaseSliderView.ImageLoadListener {


    TextToSpeech t1;
    ImageView b1;
    private Button btnScan;

    private String[] images = {

            "http://static.mybookcard.com/Content/uploads/static/710c48bf3edf4209bfac00e7c56f6426/_imgs/73aff3d5_1423_4d3d_8f4d_f904a775397f.jpeg",
            "http://static.mybookcard.com/Content/uploads/static/710c48bf3edf4209bfac00e7c56f6426/_imgs/4d94eeda_4ff7_4d15_846a_99ed92f017b2.jpeg",
            "https://i.ytimg.com/vi/PoknRc6WBXo/hqdefault.jpg"};


    private SliderLayout slImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_treinamento);

        b1 = (ImageView) findViewById(R.id.btnaudio);
        btnScan = (Button) findViewById(R.id.btnScan);



        // SLIDERLAYOUT
        slImages = (SliderLayout) findViewById(R.id.slImages);

        TextSliderView aux1 = new TextSliderView(MeuTreinamento.this);
        aux1.description("Pescarias Emocionantes");
        aux1.image(images[0]);
        aux1.setOnSliderClickListener(MeuTreinamento.this);
        aux1.setOnImageLoadListener(MeuTreinamento.this);
        slImages.addSlider(aux1);

        aux1 = new TextSliderView(MeuTreinamento.this);
        aux1.description("Aprenda a Pescar Conosco");
        aux1.image(images[1]);
        aux1.setOnSliderClickListener(MeuTreinamento.this);
        aux1.setOnImageLoadListener(MeuTreinamento.this);
        slImages.addSlider(aux1);

        DefaultSliderView aux2 = new DefaultSliderView(MeuTreinamento.this);
        aux2.image(R.drawable.logoweb);
        aux2.setOnSliderClickListener(MeuTreinamento.this);
        aux2.description("1");
        slImages.addSlider(aux2);

        aux2 = new DefaultSliderView(MeuTreinamento.this);
        aux2.description("Os Maiores Peixes com Caiaque");
        aux2.image(R.drawable.headerimg);
        aux2.setOnSliderClickListener(MeuTreinamento.this);
        aux2.description("2");
        slImages.addSlider(aux2);

        aux2 = new DefaultSliderView(MeuTreinamento.this);
        aux2.image(R.drawable.capa);
        aux2.setOnSliderClickListener(MeuTreinamento.this);
        aux2.description("3");
        slImages.addSlider(aux1);
        //slImages.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        slImages.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        //slImages.setDuration(4000);
        //slImages.setSliderTransformDuration(8000, null);
        slImages.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);

        PagerIndicator p = (PagerIndicator) findViewById(R.id.custom_indicator);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LOG", "ID: " + v.getId());
            }
        });


        ///////////////////////
        final Activity activity = this;

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Camera Scan");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                alert(result.getContents());
            } else {
                alert("Scan cancelado");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void alert(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();


///////////////////////////////////////////////


        // LISTVIEW
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.getDefault());
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String falar = "FILADELFIA\n" +
                        "Ar-Condicionado Automotivo.\n" +
                        "Manutenção e Instalação.\n" +
                        "Cargas de Gás Ecologico.\n" +
                        "Higienização e Troca de Filtro.\n" +
                        "Revisão Geral do Ar-condicionado.\n" +
                        "\n" +
                        "Entre em contato conosco.\n" +
                        "Telefones onze - 3991-0702 \n" +
                        "ou onze 3975-9221\n" +
                        "\n" +
                        "ou 7883-5170 / 55*9*4805.\n" +
                        "\n" +
                        "Venha nos visitar no endereço.\n" +
                        "Av.Elisio Teixeira Leite, nº27.\n" +
                        "esq.c/Itaberaba.\n" +
                        "Freguesia do Ó.\n" +
                        "São Paulo.\n" +
                        "\n" +
                        "Nosso email é.\n" +
                        "filadelfiaarcondicionado@hotmail.com. " +
                        ""
                                .toString();
                Toast.makeText(getApplicationContext(), falar, Toast.LENGTH_SHORT).show();
                t1.speak(falar, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public void onPause() {
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }


    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {
        Log.i("LOG", "onSliderClick(" + baseSliderView.getDescription() + ")");
        slImages.startAutoCycle();
    }

    @Override
    public void onStart(BaseSliderView baseSliderView) {
        Log.i("LOG", "onStart(" + baseSliderView.getDescription() + ")");
    }

    @Override
    public void onEnd(boolean b, BaseSliderView baseSliderView) {
        Log.i("LOG", "onEnd(" + baseSliderView.getDescription() + ")");


    }

}
