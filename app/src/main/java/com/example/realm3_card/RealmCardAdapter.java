package com.example.realm3_card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class RealmCardAdapter extends ArrayAdapter<RealmCard> {
    List<RealmCard> mCards;

    public RealmCardAdapter(Context context, int layoutResouceId, List<RealmCard> objects){
        super(context,layoutResouceId,objects);

        mCards = objects;
    }
    @Override
    public int getCount(){
        return  mCards.size();
    }
    @Override
    public RealmCard getItem(int position){
        return  mCards.get(position);
    }
    @Override
    public View getView(final int position,View convertView,ViewGroup parent){
        final ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.realm_card,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final RealmCard item=getItem(position);

        if (item != null){
            viewHolder.text.setText(item.texts);
            viewHolder.number.setText(item.number);
        }
        return convertView;

    }

    public static class ViewHolder{

        TextView text;
        TextView number;

        public ViewHolder(View view){
            text = (TextView)view.findViewById(R.id.text);
            number = (TextView)view.findViewById(R.id.number);
        }
    }







}
