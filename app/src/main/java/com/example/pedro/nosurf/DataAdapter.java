package com.example.pedro.nosurf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by pedro on 08/06/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>  {
    private ArrayList<Praias> praiasList;
    private Context context;

    public DataAdapter(Context context,ArrayList<Praias> praias) {
        this.praiasList = praias;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        Context context2 = viewHolder.img_android.getContext();
        String url = "https://www.softcond.com/nosurf/imagens/"+praiasList.get(i).getAndroid_image_url();
        Picasso.with(context).load(url).into(viewHolder.img_android);
        viewHolder.tx_praia.setText(praiasList.get(i).getAndroid_version_name());
        viewHolder.tx_temperatura.setText(praiasList.get(i).getTemperatura());
        viewHolder.tx_vento.setText(praiasList.get(i).getVento());
        viewHolder.tx_onda.setText(praiasList.get(i).getOnda());

    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tx_praia, tx_temperatura, tx_vento,tx_onda;
        private ImageView img_android;
        private LinearLayout card;

        public ViewHolder(View view) {
            super(view);

            tx_praia = (TextView)view.findViewById(R.id.txt_praia);
            img_android = (ImageView) view.findViewById(R.id.myImageView);
            tx_temperatura = (TextView) view.findViewById(R.id.txt_temperatura);
            tx_vento = (TextView) view.findViewById(R.id.txt_vento);
            tx_onda = (TextView) view.findViewById(R.id.txt_ondas);



        }
    }
    @Override
    public int getItemCount() {
        return praiasList.size();
    }
}
