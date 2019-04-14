package com.chanfool21.minimozo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView ImageViewChar1;
    private ImageView ImageViewChar2;
    private ImageView ImageViewChar3;
    private Random rng = new Random();

    private void random_id_generator()
    {
        int ch = rng.nextInt(3)+1;
        int []a = new int[3];

        for(int i = 0; i < 3; i++)
        {
            a[i] = 0;
        }

        a[ch] = 1;

        switch(ch){
            case 1:
                ImageViewChar1.setImageResource(R.drawable.letter_a);
                break;
            case 2:
                ImageViewChar1.setImageResource(R.drawable.letter_b);
                break;
            case 3:
                ImageViewChar1.setImageResource(R.drawable.letter_c);
                break;
            default:
                break;

        }

    }

    int uc = 0;
    int ind = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        int ctr = 0;
        final int a = rng.nextInt(3)+1;


            ImageViewChar1 = findViewById(R.id.image_view1);
            ImageViewChar2 = findViewById(R.id.image_view2);
            ImageViewChar3 = findViewById(R.id.image_view3);
            Button b1 = (Button) findViewById(R.id.swap);
            Button b2 = (Button)findViewById(R.id.notswap);
            b1.setBackgroundColor(Color.GREEN);
            b2.setBackgroundColor(Color.RED);

            if(ctr >= 1) {
                b1.setEnabled(true);
                b2.setEnabled(true);
            }

            ImageViewChar1.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    uc = 1;
                    /*
                    if(a == 1)
                    {
                        Toast.makeText(getApplicationContext(), "Congrats, good job", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Sorry Bud, Wrong Guess", Toast.LENGTH_LONG).show();
                    }
                    */
                    ind = 0;
                    for(int i = 1; i <= 3; i++)
                    {
                        if(i != a && i != uc)
                        {
                            ind = i;
                            break;
                        }
                    }

                }

            });

            ImageViewChar2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    uc = 2;
                    ind = 0;
                    for(int i = 1; i <= 3; i++)
                    {
                        if(i != a && i != uc)
                        {
                            ind = i;
                            break;
                        }
                    }
                }
            });

            ImageViewChar3.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    uc = 3;
                    ind = 0;
                    for(int i = 1; i <= 3; i++)
                    {
                        if(i != a && i != uc)
                        {
                            ind = i;
                            break;
                        }
                    }
                }
            });

            ImageView wrong;
            if(ind == 1)
            {
                wrong = findViewById(R.id.image_view1);
            }
            else if(ind == 2)
            {
                wrong = findViewById(R.id.image_view2);
            }
            else
            {
                wrong = findViewById(R.id.image_view3);
            }

            wrong.setImageResource(R.drawable.wrong1);

            b1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int i = 1; i <= 3; i++)
                    {
                        if(i != uc && i != ind)
                        {
                            ind = i;
                            break;
                        }
                        uc = ind;
                    }

                    if(uc == a)
                    {
                        if(uc == 1)
                        {
                            ImageViewChar1.setImageResource(R.drawable.jackpot);
                        }
                        else if(uc == 2)
                        {
                            ImageViewChar2.setImageResource(R.drawable.jackpot);
                        }
                        else
                        {
                            ImageViewChar3.setImageResource(R.drawable.jackpot);
                        }
                    }
                    else
                    {
                        if(uc == 1)
                        {
                            ImageViewChar1.setImageResource(R.drawable.wrong1);
                        }
                        else if(uc == 2)
                        {
                            ImageViewChar2.setImageResource(R.drawable.wrong1);
                        }
                        else
                        {
                            ImageViewChar3.setImageResource(R.drawable.wrong1);
                        }
                    }
                }


            }


        );

            b2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(uc == a)
                    {
                        if(uc == 1)
                        {
                            ImageViewChar1.setImageResource(R.drawable.jackpot);
                        }
                        else if(uc == 2)
                        {
                            ImageViewChar2.setImageResource(R.drawable.jackpot);
                        }
                        else
                        {
                            ImageViewChar3.setImageResource(R.drawable.jackpot);
                        }
                    }
                    else
                    {
                        if(uc == 1)
                        {
                            ImageViewChar1.setImageResource(R.drawable.wrong1);
                        }
                        else if(uc == 2)
                        {
                            ImageViewChar2.setImageResource(R.drawable.wrong1);
                        }
                        else
                        {
                            ImageViewChar3.setImageResource(R.drawable.wrong1);
                        }
                    }
                }
            });


    }
}
