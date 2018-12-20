package bori.bori.news;

import java.util.List;

public class NewsInfo
{
    private List<News> mNewsList = null;
    private String mNewsType ;

    public String getmNewsType()
    {
        return mNewsType;
    }

    public void setNewsType(String mNewsType)
    {
        this.mNewsType = mNewsType;
    }

    public List<News> getNewsList()
    {
        return mNewsList;
    }

    public void setNewsList(List<News> mNewsList)
    {
        this.mNewsList = mNewsList;
    }

    public NewsInfo(List<News> newsList, String newType)
    {
        this.mNewsList = newsList;
        this.mNewsType = newType;
    }

    public NewsInfo()
    {
    }
}