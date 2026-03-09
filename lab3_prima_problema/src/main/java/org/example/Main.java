package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class RssItem {
    private String title;
    private String link;
    private String description;
    private String pubDate;

    public RssItem(String title, String link, String description, String pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
    }

    String getTitle() {
        return title;
    }

    String getLink() {
        return link;
    }

    String getDescription() {
        return description;
    }

    String getPubDate() {
        return pubDate;
    }
}

class RssFeed {

    private String title;
    private String link;
    private String description;
    private String pubDate;
    private List<RssItem> items;

    public RssFeed(String title, String link, String description, String pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.items = new ArrayList<>();
    }

    public void addItem(RssItem item) {
        items.add(item);
    }

    public List<RssItem> getItems() {
        return items;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        String url = "http://rss.cnn.com/rss/edition.rss";

        Document doc = Jsoup.connect(url).get();
        Element channel = doc.selectFirst("channel");

        String title = channel.selectFirst("> title").text();
        String link = channel.selectFirst("> link").text();
        String description = channel.selectFirst("> description").text();

        Element channelPubDateElement = channel.selectFirst("> pubDate");
        String pubDate = "";
        if (channelPubDateElement != null) {
            pubDate = channelPubDateElement.text();
        }

        RssFeed feed = new RssFeed(title, link, description, pubDate);

        Elements items = channel.select("item");

        for (Element item : items) {

            Element titleElement = item.selectFirst("title");
            String itemTitle = "";
            if (titleElement != null) {
                itemTitle = titleElement.text();
            }

            Element linkElement = item.selectFirst("link");
            String itemLink = "";
            if (linkElement != null) {
                itemLink = linkElement.text();
            }

            Element descriptionElement = item.selectFirst("description");
            String itemDescription = "";
            if (descriptionElement != null) {
                itemDescription = descriptionElement.text();
            }

            Element pubDateElement = item.selectFirst("pubDate");
            String itemPubDate = "";
            if (pubDateElement != null) {
                itemPubDate = pubDateElement.text();
            }
            feed.addItem( new RssItem(itemTitle, itemLink, itemDescription, itemPubDate));
        }

        for (RssItem item : feed.getItems()) {
            System.out.println(item.getTitle());
            System.out.println(item.getLink());
            System.out.println();
        }
    }
}