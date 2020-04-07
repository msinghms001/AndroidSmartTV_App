package com.example.myproject1;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseSupportFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;

public class MainFragment extends BrowseSupportFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUI(); // In this we will implement some basic data.
    }
    private void setUI() {
        setTitle("BlazingTV"); // our In-App title will be shown in top-right corner
        setHeadersState(HEADERS_ENABLED); // to show or hide the category list your content is divided into.
        setBrandColor(Color.GRAY); // Set the background color or BrowseLane.

        loadRows();

    }

    private void loadRows() {
        HeaderItem category1 = new HeaderItem(0,"Movies");
        HeaderItem category2 = new HeaderItem(1, "Shows");
        ArrayObjectAdapter adapterForRow1 = new ArrayObjectAdapter(new MyPresenter());

        adapterForRow1.add(new SingleRowView("Ironman",getContext().getResources().getDrawable(R.drawable.ironman)));
        adapterForRow1.add(new SingleRowView("The Matrix",getContext().getResources().getDrawable(R.drawable.matrix)));
        adapterForRow1.add(new SingleRowView("Avengers",getContext().getResources().getDrawable(R.drawable.avengers)));

        ArrayObjectAdapter windowAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        windowAdapter.add(new ListRow(category1,adapterForRow1));

            }

    private class MyPresenter extends Presenter{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            return null;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object o) {

        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }


}