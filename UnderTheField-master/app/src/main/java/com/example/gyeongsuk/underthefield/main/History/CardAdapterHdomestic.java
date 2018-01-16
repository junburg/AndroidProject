package com.example.gyeongsuk.underthefield.main.History;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.gyeongsuk.underthefield.R;

import java.util.List;

/**
 * Created by Gyeongsuk on 2016-11-30.
 */

public class CardAdapterHdomestic<T> extends RecyclerView.Adapter<CardAdapterHdomestic.ViewHolder> {

    List<T> datas;
    int itemLayout;
    Context context;


    public CardAdapterHdomestic(List<T> datas, int itemLayout, Context context) {
        this.datas = datas;
        this.itemLayout = itemLayout;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        T data = datas.get(position);
        if(data instanceof CardDataHdomestic) {

            holder.hCardUserName.setText(((CardDataHdomestic) data).gethDomesticUserName());
            holder.hCardArtistName.setText(((CardDataHdomestic) data).gethDomesticArtistName());
            holder.hCardTitleName.setText(((CardDataHdomestic) data).gethDomesticTitleName());
            final String goWeb = ((CardDataHdomestic) data).gethDomesticScUrl();
            holder.goBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(goWeb));
                    context.startActivity(intent);


                }
            });

        }

        setAnimation(holder.historyCard, position);
    }

    int lastPosition = -1;
    public void setAnimation(View view, int position){

        if(position> lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(animation);
            lastPosition = position;
        }
    }
    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView historyCard;
        TextView hCardRec;
        TextView hCardUserName;
        TextView hCardArtist;
        TextView hCardArtistName;
        TextView hCardTitle;
        TextView hCardTitleName;
        Button goBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            historyCard = (CardView) itemView.findViewById(R.id.historyCard);
            hCardRec = (TextView) itemView.findViewById(R.id.hCardRec);
            hCardUserName = (TextView) itemView.findViewById(R.id.hCardUserName);
            hCardArtist = (TextView) itemView.findViewById(R.id.hCardArtist);
            hCardArtistName = (TextView) itemView.findViewById(R.id.hCardArtistName);
            hCardTitle = (TextView) itemView.findViewById(R.id.hCardTitle);
            hCardTitleName = (TextView) itemView.findViewById(R.id.hCardTitleName);
            goBtn = (Button) itemView.findViewById(R.id.goBtn);
        }
    }
}
