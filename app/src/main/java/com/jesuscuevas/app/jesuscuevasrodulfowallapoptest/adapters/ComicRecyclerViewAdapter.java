package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.R;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.api.model.MarvelComic;
import com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.ui.mvp.views.MainFragmentView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComicRecyclerViewAdapter extends RecyclerView.Adapter<ComicRecyclerViewAdapter.ComicHolder> {

    private MarvelComic mMarvelComic;
    private Context mContext;
    private MainFragmentView mView;

    public ComicRecyclerViewAdapter(MarvelComic marvelComic, Context context, MainFragmentView view) {
        mMarvelComic = marvelComic;
        mContext = context;
        mView = view;
    }

    @Override
    public ComicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comic_list, parent, false);
        return new ComicHolder(view, mMarvelComic, mView);
    }

    @Override
    public void onBindViewHolder(ComicHolder holder, final int position) {

        holder.comicName.setText(mMarvelComic.getData().
                getResults().get(position).getTitle());

        Picasso.with(mContext).load(mMarvelComic.getData().getResults()
                .get(position)
                .getThumbnail().getPath() + "."
                + mMarvelComic.getData().getResults()
                .get(position).getThumbnail().getExtension())
                .into(holder.comicBackgroundImage);
    }

    @Override
    public int getItemCount() {
        return mMarvelComic.getData().getResults().size();
    }

    public static class ComicHolder extends RecyclerView.ViewHolder {

        private MarvelComic marvelComic;
        private MainFragmentView holderView;

        @BindView(R.id.item_comic_general_background)
        ImageView comicBackgroundImage;
        @BindView(R.id.item_comic_name)
        TextView comicName;

        public ComicHolder(View itemView, MarvelComic marvelComic, MainFragmentView view) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.marvelComic = marvelComic;
            holderView = view;
        }

        @OnClick({R.id.item_comic_general_background
                , R.id.item_comic_name})
        public void itemClick(View view) {
            if (holderView != null) {
                holderView.onItemClick(marvelComic, getAdapterPosition());
            }
        }
    }
}
