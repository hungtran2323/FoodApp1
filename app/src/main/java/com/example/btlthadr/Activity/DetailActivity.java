package com.example.btlthadr.Activity;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.example.btlthadr.Domain.Foods;
import com.example.btlthadr.Helper.ManagmentCart;
import com.example.btlthadr.R;
import com.example.btlthadr.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private Foods object;
    private int num = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        managmentCart=new ManagmentCart(this);
        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);
        binding.priceTxt.setText("$" + object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.totalTxt.setText(num * object.getPrice() + "$");

        binding.plusBtn.setOnClickListener(v -> {
            num=num+1;
            binding.numTxt.setText( num +" ");
            binding.totalTxt.setText("$"+(num*object.getPrice()));
        });
        binding.minusBtn.setOnClickListener(v -> {
            if(num>1){
                num=num-1;
                binding.numTxt.setText(num+"");
                binding.totalTxt.setText("$"+(num*object.getPrice()));

            }
        });
        binding.addBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managmentCart.insertFood(object);

        });
    }


    private void getIntentExtra() {
        object = (Foods) getIntent().getSerializableExtra("object");
    }
}