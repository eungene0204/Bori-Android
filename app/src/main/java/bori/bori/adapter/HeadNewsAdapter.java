package bori.bori.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bori.bori.R;
import bori.bori.activity.WebViewActivity;
import bori.bori.news.News;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HeadNewsAdapter extends RecyclerView.Adapter<HeadNewsAdapter.ListItemViewHolder>
{
    public static final String TAG = HeadNewsAdapter.class.getSimpleName();

    private Context mContext;
    private List<News> mData = Collections.emptyList();
    private int mFontSize = 0;

    private OnHeadNewsClickListener mOnNewsClickListener;

    public HeadNewsAdapter(Context mContext, List<News> data)
    {
        this.mContext = mContext;
        this.mData = data;
    }

    public void setNewsClickListener(OnHeadNewsClickListener listener)
    {
        mOnNewsClickListener = listener;
    }


    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item,parent, false);

        ListItemViewHolder listItemViewHolder = new ListItemViewHolder(v,mContext);

        return listItemViewHolder;
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position)
    {
        News news = mData.get(position);



       String title = news.getTitle();
       holder.getTextView().setText(title);

       ImageView imageView = holder.getImageView();
       String imgUrl = news.getImgUrl();
       setImageSrc(imgUrl,position,imageView);

       holder.setNews(news);
    }



    private void setImageSrc(String url, int position, ImageView imageView)
    {
       Log.i(TAG,mData.get(position).getTitle()) ;
       Log.i(TAG,url);
       UrlImageViewHelper.setUrlDrawable(imageView,url, R.drawable.ic_rss_feed_grey_24dp,6000);

    }


    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder
    {
        private Context mContext;

        private News mNews;

        private final TextView mTextView;
        private final ImageView mImageView;

        public ListItemViewHolder(View itemView,Context context)
        {
            super(itemView);
            mContext = context;

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    setFontSize(mOnNewsClickListener.onSetFontSize());
                    startWebViewActivity(getNews());

                }
            });

            mTextView = (TextView) itemView.findViewById(R.id.row_textview);
            mImageView = (ImageView) itemView.findViewById(R.id.row_imageview);
        }

        private void startWebViewActivity(News news)
        {
            Intent intent = new Intent(mContext, WebViewActivity.class);

            intent.putExtra(News.KEY_ID,news.getId());
            intent.putExtra(News.KEY_URL,news.getUrl());
            intent.putExtra(News.KEY_TITLE, news.getTitle());
            intent.putExtra(News.KEY_IMG_URL, news.getImgUrl());
            intent.putExtra(News.KEY_FONT_SIZE, getFontSize());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            mContext.startActivity(intent);
        }

        public TextView getTextView()
        {
            return mTextView;
        }
        public ImageView getImageView()
        {
            return mImageView;
        }

        public News getNews()
        {
            return mNews;
        }

        public void setNews(News news)
        {
            mNews = news;
        }

    }

    public int getFontSize()
    {
        return mFontSize;
    }

    public void setFontSize(int fontSize)
    {
        mFontSize = fontSize;
    }


    public interface OnHeadNewsClickListener
    {
        int onSetFontSize();
    }


}