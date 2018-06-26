package com.sintup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marin.sintup.R;
import com.sintup.base.Article;
import com.squareup.picasso.Picasso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ArticleActivity extends AppCompatActivity {

    private static final String STUDENT_USER = "student";
    private static final String STUDENT_PASSWORD = "Test123";

    String position;
    ImageView articleIcon;
    EditText articleData;
    EditText articleTitle;
    Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        articleIcon = (ImageView)findViewById(R.id.articleIcon);

        Intent intent = getIntent();
        position = intent.getStringExtra("position");

        article = HomeActivity.dataList.get(Integer.parseInt(position));

        articleTitle=(EditText) findViewById(R.id.title);
        articleTitle.setText(article.getTitle());
        articleTitle.setFocusable(false);

        articleData = (EditText) findViewById(R.id.articleData);
        articleData.setText(article.getArticleData());
        articleData.setFocusable(false);

        Picasso.with(this)
                .load(article.getDefaultIcon())
                .resize(300, 200)
                .into(articleIcon);

        Button likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                article.setUpVotes(article.getUpVotes()+1);
            }
        });

        Button dislikeButton = (Button) findViewById(R.id.dislikeButton);
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                article.setDislikes(article.getDislikes()+1);
            }
        });

        TextView link = (TextView) findViewById(R.id.externalLink);
        String linkText = "<a href='"+article.getArticleUrl()+"'>Оригинална статия</a>";
        link.setText(Html.fromHtml(linkText));
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }


    private Article getArticle(String title) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", STUDENT_USER);
        properties.setProperty("password", STUDENT_PASSWORD);
        properties.setProperty("useSSL", String.valueOf(false));
        properties.setProperty("autoReconnect", String.valueOf(true));

        Connection connect = DriverManager.getConnection("jdbc:mysql://95.43.88.200/diplomna", properties);

        Statement statement = connect.createStatement();

        ResultSet result = statement.executeQuery(String.format("select * from diplomna.article where title='%s'", title));

        result.next();

        Article article = new Article();
        article.setArticleData(result.getString("articleData"));
        article.setTitle(result.getString("title"));
        article.setRaiting(Integer.parseInt(result.getString("raiting")));
        article.setDefaultIcon(result.getString("defaultIcon"));

        return article;
    }
}
