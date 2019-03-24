package bori.bori.news;

import android.graphics.drawable.Drawable;

/**
 * Created by Eugene on 2017-08-10.
 */

public class News
{
    public static String KEY_NEWS_TYPE = "news_type";
    public static String KEY_HEAD_LINE_NEWS = "head_line_news";
    public static String KEY_RECOMMEND_NEWS = "recommend_news";
    public static String KEY_ID ="id";
    public static String KEY_URL = "url";
    public static String KEY_TITLE = "title";
    public static String KEY_IMG_URL = "imgUrl";
    public static String KEY_FONT_SIZE = "fontSize";
    public static String KEY_CATEGORY = "category";

    private String mNewsType;
    private String mTitle;
    private String mLink;
    private String mImgSrc;
    private String mId;
    private String mSource;
    private String mDate;
    private String mCategory;
    private Drawable mSourceLogo;

    public void setSourceLogo(Drawable logo)
    {
        mSourceLogo = logo;
    }

    public Drawable getSourceLogo()
    {
        return mSourceLogo;
    }

    public String getSource()
    {
        return mSource;
    }

    public void setSource(String source)
    {
        mSource = source;
    }

    public String getDate()
    {
        return mDate;
    }

    public void setDate(String date)
    {
        mDate = date;
    }

    public String getCategory()
    {
        return mCategory;
    }

    public void setCategory(String category)
    {
        mCategory = category;
    }





    public String getId()
    {
        return mId;
    }

    public void setId(String id)
    {
        mId = id;
    }


    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public String getUrl()
    {
        return mLink;
    }

    public void setUrl(String link)
    {
        mLink = link;
    }

    public String getImgUrl()
    {
        return mImgSrc;
    }

    public void setImgUrl(String imgSrc)
    {
        mImgSrc = imgSrc;
    }

    public String getNewsType()
    {
        return mNewsType;
    }

    public void setNewsType(String mNewsType)
    {
        this.mNewsType = mNewsType;
    }
}
