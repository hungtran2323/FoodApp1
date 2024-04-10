package com.example.btlthadr.Adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.btlthadr.Helper.ChangeNumberItemsListener;
import com.example.btlthadr.Helper.ManagmentCart;
import com.example.btlthadr.R;
import org.jetbrains.annotations.NotNull;
import com.example.btlthadr.Domain.Foods;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewholder> {
    ArrayList<Foods> list;
    private ManagmentCart managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdapter(ArrayList<Foods> list, Context context , ChangeNumberItemsListener changeNumberItemsListener){
        this.list=list;
        managmentCart=new ManagmentCart(context);
        this.changeNumberItemsListener=changeNumberItemsListener;
    }



    @NonNull
    @NotNull
    @Override
    public CartAdapter.viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        View inflate= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_cart,viewGroup,false);

        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CartAdapter.viewholder viewholder, int i) {
        viewholder.title.setText(list.get(i).getTitle());
        viewholder.feeEachItem.setText("$"+list.get(i).getNumberInCart()*list.get(i).getPrice());
        viewholder.totalEachItem.setText(list.get(i).getNumberInCart()+"* $"+(
                list.get(i).getPrice()));
        viewholder.num.setText(list.get(i).getPrice()+"");
        Glide.with(viewholder.itemView.getContext()).
                load(list.get(i).getImagePath()).
                transform(new CenterCrop(),new RoundedCorners(30))
                .into(viewholder.pic);
        viewholder.plusItem.setOnClickListener(v -> managmentCart.plusNumberItem(list, i, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            }
        }));
        viewholder.minusItem.setOnClickListener(v -> managmentCart.minusNumberItem(list, i, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                notifyDataSetChanged();
                changeNumberItemsListener.change();

            }
        }));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView title,feeEachItem,plusItem,minusItem;
        ImageView pic;
        TextView totalEachItem,num;
        public viewholder(@NonNull @NotNull View itemView) {

            super(itemView);
            title=itemView.findViewById(R.id.titleTxt);
            pic=itemView.findViewById(R.id.pic);
            feeEachItem=itemView.findViewById(R.id.feeEachItem);
            plusItem=itemView.findViewById(R.id.plusCartBtn);
            minusItem=itemView.findViewById(R.id.minusCartBtn);
            totalEachItem=itemView.findViewById(R.id.totalEachItem);
            num=itemView.findViewById(R.id.numberitemTxt);




        }
    }
}
