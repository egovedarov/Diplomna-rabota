package com.sintup.parser.dataLoding;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.sintup.parser.base.Article;
import com.sintup.parser.utils.ArticleParserUtil;
import com.sintup.parser.utils.DatabaseUtil;

public class DataLoader {

    final static Logger logger = Logger.getLogger(DataLoader.class);

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASSWORD = "Test321";

    private static final String DEVELOPER_TECH_URL = "https://www.developer-tech.com/";
    private static final String MIT_URL = "http://news.mit.edu";

    private static final String[] MIT_TOPICS = new String[] { "electrical-engineering", "mechanical-engineering",
            "computer-science-and-artificial-intelligence-laboratory-csail" };

    public static void main(String[] args) {
        loadPredifyinedData();
    }

    public static void loadPredifyinedData() {
        List<Article> devTechArticles = ArticleParserUtil.parseDevTechArticles(DEVELOPER_TECH_URL);

        if (devTechArticles != null) {
            for (Article article : devTechArticles) {
                writeArticleToDb(article);
            }
        }

        for (String topic : MIT_TOPICS) {
            List<Article> mitArticles = ArticleParserUtil.parseMitArticles(MIT_URL, topic);
            if (mitArticles != null) {
                for (Article article : mitArticles) {
                    writeArticleToDb(article);
                }
            }
        }
    }

    public static String loadCustomData(String webPortal, String title, String cssSelector, String iconUrl,
            String subject, int raiting) {
        Article article = ArticleParserUtil.parseCustomAdminArticle(webPortal, title, cssSelector, iconUrl, subject,
                raiting);
        if (article == null) {
            return "Error while getting the article data.";
        }

        String databaseErrorMessage = null;
        databaseErrorMessage = writeArticleToDb(article);
        if (databaseErrorMessage == null) {
            return "Error while saving the article to the Database.";
        }
        return null;
    }

    public static String writeArticleToDb(Article article) {
        DatabaseUtil dbManager = new DatabaseUtil(ADMIN_USER, ADMIN_PASSWORD);
        try {
            dbManager.insertArticle(normalizeParameter(article.getArticleData()),
                    normalizeParameter(article.getTitle()), article.getRaiting(), article.getDefaultIcon(),
                    article.getArticleUrl(), article.getSubject());
            return "The article was successfully saved to the database";
        } catch (SQLException e) {
            throw new RuntimeException(
                    String.format("There was a problem with storing article %s to the database!", article.getTitle()));
        } finally {
            try {
                dbManager.disconnect();
            } catch (SQLException e) {
                throw new RuntimeException("There was a problem with disconnecting from the database!");
            }
        }
    }

    private static String normalizeParameter(String parameter) {
        return parameter.replaceAll("‘", "").replaceAll("’", "").replaceAll("\"", "").replaceAll("'", "");
    }
}
