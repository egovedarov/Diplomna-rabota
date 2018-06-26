package com.sintup.render;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marin.sintup.R;
import com.sintup.base.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SHAJIB-PC on 10/23/2017.
 */

public class ListNewsAdapter extends BaseAdapter {
    private Activity activity;
    private List<Article> data;

    public ListNewsAdapter(Activity a, List<Article> d) {
        activity = a;
        data = d;
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListNewsViewHolder holder = null;
        if (convertView == null) {
            holder = new ListNewsViewHolder();
            convertView = LayoutInflater.from(activity).inflate(
                    R.layout.list_row, parent, false);
            holder.galleryImage = (ImageView) convertView.findViewById(R.id.galleryImage);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.subject= (TextView) convertView.findViewById(R.id.subject);
            convertView.setTag(holder);
        } else {
            holder = (ListNewsViewHolder) convertView.getTag();
        }
        holder.galleryImage.setId(position);
        holder.title.setId(position);

        Article article=data.get(position);
            holder.title.setText(article.getTitle());
            Picasso.with(activity)
                    .load(article.getDefaultIcon())
                    .resize(300, 200)
                    .into(holder.galleryImage);
            holder.subject.setText(article.getSubject());
        return convertView;
    }
}

class ListNewsViewHolder {
    ImageView galleryImage;
    TextView title, subject;
}