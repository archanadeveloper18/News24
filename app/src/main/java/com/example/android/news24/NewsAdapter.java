package com.example.android.news24;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = converView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the list of newss
        News currentNews = getItem(position);

        //Find the TextView with view Id sectionname.
        TextView sectionNameView = (TextView) listItemView.findViewById(R.id.sectionName);
        String section = currentNews.getArticalSection();
        sectionNameView.setText(section);

        //Find the TextView with view Id webtittle.
        TextView webTittleView = (TextView) listItemView.findViewById(R.id.webTittle);
        String tittle = currentNews.getArticalTittle();
        webTittleView.setText(tittle);

        //Find the TextView with view Id webtittle.
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        String author = currentNews.getArticalAuthor();
        authorView.setText(author);

        //Find the TextView with view Id date.
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String date = currentNews.getDate();
        // Display the date of the current earthquake in that TextView
        dateView.setText(date);

        return listItemView;
    }
}
