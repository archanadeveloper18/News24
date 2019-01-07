package com.example.android.news24;

public class News {

    //Artical name of the news.
    private String mArticalSection;

    //Artical name in the web .
    private String mArticalTittle;

    /* Article author */
    private String mArticleAuthor;

    /** Time of the artical published*/
    private String mdate;

    /** Website URL of the news*/
    private String mUrl;

    //** Constructs a new {@link News} object.
    //** @param ArticalSection is the sectionName of the news.
    //** @param ArticalTittleis is the tittle of the news.
    // * @param date is the time in when the news was published.
    // * @param url is the website URL to find more details about the news.
    // */

    public News(String articalSection, String articalTittle ,String date, String url, String articleAuthor){
        mArticalSection = articalSection;
        mdate = date;
        mArticalTittle = articalTittle;
        mArticleAuthor = articleAuthor;
        mUrl = url;
    }

    //Return artical of the news
    public String getArticalSection(){
        return mArticalSection;
    }

    //Return date of the news
    public String getDate(){
        return mdate;
    }

    //Return webtittle of the news
    public String getArticalTittle(){
        return mArticalTittle;
    }

    /**
     * Returns the website URL to find more information about the news.
     */
    public String getUrl() {
        return mUrl;
    }

    //Return authorName of the news
    public String getArticalAuthor(){
        return mArticleAuthor;
    }
}
