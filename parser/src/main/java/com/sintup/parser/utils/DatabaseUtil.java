package com.sintup.parser.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sintup.parser.base.Article;

public class DatabaseUtil {

    private String user;
    private String password;

    private static Connection connect;
    private static Statement statement;
    private static ResultSet result;

    private static final String DB_URL = "jdbc:mysql://localhost/diplomna";

    public DatabaseUtil(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static void main(String[] args) throws SQLException {
        DatabaseUtil db = new DatabaseUtil("admin", "Test321");
        for (Article article : db.getArticles()) {
            System.out.println(article.getTitle());
        }
//        Article art = db.getArticle("test");
//        System.out.println(art.getTitle());
    }

    public List<Article> getArticles() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("useSSL", String.valueOf(false));
        properties.setProperty("autoReconnect", String.valueOf(true));

        connect = DriverManager.getConnection(DB_URL, properties);

        statement = connect.createStatement();

        result = statement.executeQuery("select * from article");

        List<Article> articles = new ArrayList<Article>();

        while (result.next()) {
            Article article = new Article();
            article.setArticleData(result.getString("articleData"));
            article.setTitle(result.getString("title"));
            article.setRaiting(Integer.parseInt(result.getString("raiting")));
            article.setDefaultIcon(result.getString("defaultIcon"));
            article.setSubject(result.getString("articleSubject"));
            article.setArticleUrl(result.getString("articleUrl"));

            articles.add(article);
        }

        disconnect();

        return articles;
    }

    public Article getArticle(String title) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("useSSL", String.valueOf(false));
        properties.setProperty("autoReconnect", String.valueOf(true));

        connect = DriverManager.getConnection(DB_URL, properties);

        statement = connect.createStatement();

        result = statement.executeQuery(String.format("select * from diplomna.article where title='%s';", title));

        Article article = new Article();
        result.next();
        article.setArticleData(result.getString("articleData"));
        article.setTitle(result.getString("title"));
        article.setRaiting(Integer.parseInt(result.getString("raiting")));
        article.setDefaultIcon(result.getString("defaultIcon"));
        article.setSubject(result.getString("articleSubject"));
        article.setArticleUrl(result.getString("articleUrl"));

        disconnect();

        return article;
    }

    public void insertArticle(String articleData, String title, int raiting, String defaultIcon, String articleUrl,
            String articleSubject) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("useSSL", String.valueOf(false));
        properties.setProperty("autoReconnect", String.valueOf(true));
        properties.setProperty("verifyServerCertificate", String.valueOf(false));

        connect = DriverManager.getConnection(DB_URL, properties);

        statement = connect.createStatement();

        statement.executeUpdate(String.format(
                "insert into diplomna.article(articleData,title,raiting,defaultIcon,articleSubject,articleUrl) values('%s','%s',%d,'%s','%s','%s');",
                articleData, title, raiting, defaultIcon, articleSubject, articleUrl));

        disconnect();
    }

    public void updateArticle(String title, String subject, int raiting) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("useSSL", String.valueOf(false));
        properties.setProperty("autoReconnect", String.valueOf(true));
        properties.setProperty("verifyServerCertificate", String.valueOf(false));

        connect = DriverManager.getConnection(DB_URL, properties);

        statement = connect.createStatement();

        statement.executeUpdate(String.format(
                "UPDATE article SET raiting = %d, articleSubject= \"%s\" WHERE title='%s';", raiting, subject, title));

        disconnect();
    }

    public void disconnect() throws SQLException {
        if (result != null) {
            result.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connect != null) {
            connect.close();
        }
    }
}
