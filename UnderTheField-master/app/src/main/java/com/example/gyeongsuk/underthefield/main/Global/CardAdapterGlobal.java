package com.example.gyeongsuk.underthefield.main.Global;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.gyeongsuk.underthefield.R;
import java.util.List;


/**
 * Created by Gyeongsuk on 2016-12-03.
 */

public class CardAdapterGlobal<T> extends RecyclerView.Adapter<CardAdapterGlobal.ViewHolder> {

    List<T> datas;
    int itemLayout;
    Context context;

    public CardAdapterGlobal(List<T> datas, int itemLayout, Context context) {
        this.datas = datas;
        this.itemLayout = itemLayout;
        this.context = context;
    }

    @Override
    public CardAdapterGlobal.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new CardAdapterGlobal.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardAdapterGlobal.ViewHolder holder, int position) {
        T data = datas.get(position);
        if (data instanceof CardDataGlobal) {

            holder.cardUserName.setText(((CardDataGlobal) data).getGlobalUserName());
            String url = ((CardDataGlobal) data).getGlobalScUrl();
            Log.e("check3", "url = " + url);

            String html = "<!DOCTYPE html><html> <head> <meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"target-densitydpi=high-dpi\" />" +
                    " <meta name=\"viewport\" content=\"width=device-width, initial-scale=0.55\"> <link rel=\"stylesheet\" media=\"screen and (-webkit-device-pixel-ratio:1.5)\" href=\"hdpi.css\" />" +
                    "</head> <body style=\"background:black;margin:0 0 0 5; padding:0 0 0 0;\"> <iframe id=\"sc-widget " +
                    "\" width=\"100%\" height=\"580 \"" + // Set Appropriate Width and Height that you want for SoundCloud Player
                    " src=\"" + url   // Set Embedded url
                    + "\" frameborder=\"no\" scrolling=\"no\"></iframe>" +
                    "<script src=\"https://w.soundcloud.com/player/api.js\" type=\"text/javascript\"></script> </body> </html> ";

            holder.scView.setVisibility(View.VISIBLE);
            holder.scView.getSettings().setJavaScriptEnabled(true);
            holder.scView.getSettings().setLoadWithOverviewMode(true);
            holder.scView.getSettings().setUseWideViewPort(true);
            holder.scView.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
            holder.scView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            if (Build.VERSION.SDK_INT >= 19) {
                holder.scView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
            else {
                holder.scView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }
        }
        setAnimation(holder.DomesticGlobalCard, position);

    }

    int lastPosition = -1;

    public void setAnimation(View view, int position) {

        if (position > lastPosition) {
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

        CardView DomesticGlobalCard;
        TextView cardUserName;
        WebView scView;


        public ViewHolder(View itemView) {
            super(itemView);

            DomesticGlobalCard = (CardView) itemView.findViewById(R.id.DomesticGlobalCard);
            cardUserName = (TextView) itemView.findViewById(R.id.cardUserName);
            scView = (WebView) itemView.findViewById(R.id.scView);

        }
    }
}
