package com.sintup.parser.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sintup.parser.base.Article;

public class ArticleParserUtil {

    final static Logger logger = Logger.getLogger(ArticleParserUtil.class);

    private static final int DEFAULT_RAITING = 5;

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        parseDevTechArticles("https://www.dr-tech.com/");

        parseMitArticles("http://news.mit.edu", "electrical-engineering");
    }

    public static List<Article> parseDevTechArticles(String webPortal) {

        // the keys are the articles headings and the values are the article URLs
        Map<String, String> articles = new HashMap<String, String>();

        Document articlesListHtml;
        try {
            articlesListHtml = Jsoup.connect(webPortal + "/news/?categories=13").get();
        } catch (IOException e) {
            logger.error(String.format("Could not connect to webPortal:%s. Loading aborted!", webPortal));
            return null;
        }
        Elements articlesHeadlines = articlesListHtml.select("a[href^=/news/2018/]");
        for (Element articleHeadLine : articlesHeadlines) {
            articles.put(articleHeadLine.text(), webPortal + articleHeadLine.attributes().get("href"));
        }

        List<Article> articleList = new ArrayList<Article>();
        for (Entry<String, String> article : articles.entrySet()) {
            StringBuilder articleData = new StringBuilder();

            Article art = new Article();
            art.setArticleUrl(article.getValue());
            art.setSubject("computer science");

            Document articleHtml;
            try {
                articleHtml = Jsoup.connect(article.getValue()).get();
            } catch (IOException e) {
                logger.error(String.format("Could not connect to webPortal:%s. Loading aborted!", webPortal));
                return null;
            }

            String defaultIcon = webPortal + articleHtml.select("div[class=image_wrapper]").select("img").attr("src");

            // remove unneeded sections
            articleHtml.select("section[class=further_reading]").remove();
            articleHtml.select("div[id=comments]").remove();
            articleHtml.select("script").remove();

            Elements articleSection = articleHtml.select("div[class=content]");
            Document articleTag = Jsoup.parse(articleSection.html());

            for (Element paragraph : articleTag.body().select("p")) {
                String paragraphText = paragraph.text();
                articleData.append(paragraphText + "\n");

            }

            art.setArticleData(articleData.toString());
            art.setDefaultIcon(defaultIcon);
            art.setRaiting(DEFAULT_RAITING);
            art.setTitle(article.getKey());

            articleList.add(art);
        }
        logger.info(String.format("Articles from %s have been parsed!", webPortal));

        return articleList;
    }

    public static List<Article> parseMitArticles(String originalPortal, String topic) {

        String webPortal = String.format("%s/topic/%s", originalPortal, topic);

        // the keys are the articles headings and the values are the article URLs
        Map<String, String> articles = new HashMap<String, String>();

        Document articlesListHtml;
        try {
            articlesListHtml = Jsoup.connect(webPortal).get();
        } catch (IOException e) {
            logger.error(String.format("Could not connect to webPortal:%s. Loading aborted!", originalPortal));
            return null;
        }
        Elements articlesHeadlines = articlesListHtml.select("ul[class=view-news-items]").select("li");
        for (Element articleHeadLine : articlesHeadlines) {
            articles.put(articleHeadLine.select("h3[class=title]").text(),
                    originalPortal + articleHeadLine.select("a").attr("href"));
        }

        List<Article> articleList = new ArrayList<Article>();
        for (Entry<String, String> article : articles.entrySet()) {
            StringBuilder articleData = new StringBuilder();

            Document articleHtml;

            Article art = new Article();
            art.setArticleUrl(article.getValue());
            art.setSubject(topic);

            try {
                articleHtml = Jsoup.connect(article.getValue()).get();
            } catch (IOException e) {
                logger.error(String.format("Could not connect to webPortal:%s. Loading aborted!", originalPortal));
                return null;
            }

            String defaultIcon = articleHtml.select("div[class=image]").select("img").attr("src");

            Elements paragraphs = articleHtml.select("div[class=field-item even] > p");

            for (Element paragraph : paragraphs) {
                String paragraphText = paragraph.text();
                articleData.append(paragraphText + "\n");

            }

            art.setArticleData(articleData.toString());
            art.setDefaultIcon(defaultIcon);
            art.setRaiting(DEFAULT_RAITING);
            art.setTitle(article.getKey());

            articleList.add(art);
        }
        logger.info(String.format("Articles from %s have been parsed!", originalPortal));

        return articleList;
    }

    public static Article parseCustomAdminArticle(String webPortal, String title, String cssSelector, String iconUrl,
            String subject, int raiting) {

        Article article = new Article();
        article.setDefaultIcon(iconUrl);
        article.setArticleUrl(webPortal);
        article.setSubject(subject);
        article.setRaiting(raiting);

        Document articleListHtml;

        try {
            articleListHtml = Jsoup.connect(webPortal).get();
        } catch (IOException e) {
            logger.error(String.format("Could not connect to webPortal:%s. Loading aborted!", webPortal));
            return null;
        }

        Elements paragraphs = articleListHtml.select(cssSelector);

        StringBuilder articleData = new StringBuilder();
        for (Element paragraph : paragraphs) {
            String paragraphText = paragraph.text();
            articleData.append(paragraphText + "\n");
        }

        article.setArticleData(paragraphs.text());
        article.setTitle(title);

        return article;
    }
}
