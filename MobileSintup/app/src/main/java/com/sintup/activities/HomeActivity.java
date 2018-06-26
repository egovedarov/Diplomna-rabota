package com.sintup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.marin.sintup.R;
import com.sintup.base.Article;
import com.sintup.render.ListNewsAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ListView listNews;
    String preferredSubject;

    public static List<Article> dataList = new ArrayList<Article>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        preferredSubject = intent.getStringExtra("subject");

        listNews = (ListView) findViewById(R.id.listNews);

        getArticles();
        visualizeArticles();
    }

    private void getArticles(){
        Article article = new Article();
        article.setDefaultIcon("https://www.developer-tech.com//media/img/news/xboxing-extremely-powerful-punch-picture-id626815202.jpg.800x600_q96.png.pagespeed.ic.1ve-V4WqUM.jpg");
        article.setTitle("Stack Overflow report examines brutal lifecycle of JavaScript frameworks");
        article.setSubject("computer science");
        article.setArticleUrl("https://www.developer-tech.com//news/2018/jan/15/stack-overflow-report-examines-brutal-lifecycle-javascript-frameworks/");
        article.setRaiting(5);
        article.setUpVotes(4);
        article.setDislikes(0);
        article.setArticleData("Developers on Stack Overflow continue to be more interested in jQuery than other JavaScript frameworks according to new data analysis – although adding the share for market voice as new frameworks come in is “brutal.”\n" +
                " The report was released days after a three-part report from NPM, software registry and package manager for JavaScript, which argued jQuery remains hugely popular but decreasingly so.\n" +
                " Any cliché normally written about JavaScript frameworks and buses aside, the Stack Overflow report provides some fascinating figures. From halfway through 2011 until 2014, jQuery represented at least 7% of all JavaScript tags on the developer community page. Since then it has dipped below 5% - aligning with the NPM data – with Angular and React increasingly the beneficiaries. Beneath this lies Vue, which only stands at 0.40% but has seen a rapid rise in the past 12 months, Ember, Knockout, and Backbone. The latter three represent less than 0.1% of queries.\n" +
                " Ian Allen, Stack Overflow developer and author of a blog post explaining the data, explained the grab for share. “There appear to be two major phases in JavaScript framework usage,” wrote Allen. “There appears to be a quick ascent, as the framework gains popularity and then a slightly less quick but steady decline as developers adopt newer technologies.\n" +
                " “These lifecycles only last a couple of years,” added Allen. “The latest startup is the Vue.js framework, which has shown quick adoption, as it is one of the fastest growing tags on Stack Overflow.\n" +
                " “Only time can tell how long this growth will last.”\n" +
                " The report took a deeper dive into React and Angular – by far the most popular frameworks used alongside practically all programming technologies, from TypeScript to Node.js to Python. The media and retail industries are most likely to use these frameworks, compared to academia, government and healthcare, with minimal requirement for them. Perhaps naturally, tech companies sit somewhere in the middle, while the insurance industry provided an intriguing case study, opting much more for Angular than React.\n" +
                " Nevertheless, as the NPM report put it last week, the overall growth of React cannot be ignored. “Web developers are enthusiastically adopting React, and other domains such as mobile and desktop application development are using it too,” the report noted.\n" +
                " You can read the full Stack Overflow blog post here.\n" +
                " ");
        dataList.add(article);

        article = new Article();
        article.setDefaultIcon("https://www.developer-tech.com//media/img/news/xprogramming_languages_of_2018.jpg.800x600_q96.png.pagespeed.ic.qcUS5kDn1U.jpg");
        article.setTitle("Skills for these ten platforms are the most in-demand for 2018");
        article.setSubject("computer science");
        article.setArticleUrl("https://www.developer-tech.com//news/2018/jan/16/skills-these-ten-platforms-are-most-demand-2018/");
        article.setRaiting(5);
        article.setUpVotes(5);
        article.setDislikes(0);
        article.setArticleData("A global network of freelance engineers, designers, and finance experts has released a list of the ten most in-demand programming languages for 2018.\n" +
                " According to Toptals internal data, skills for the most in-demand platforms requested by its clients are:\n" +
                " Angular 2 (+441.5% year over year (YOY)\n" +
                " React Native (+353.7% YOY)\n" +
                " Docker (+140.7% YOY)\n" +
                " Redux (120.6% YOY)\n" +
                " React.js (+97.4 YOY)\n" +
                " Firebase (+96.4 YOY)\n" +
                " Shopify (+93.0 YOY)\n" +
                " WooCommerce (69.0% YOY)\n" +
                " Azure (+53.0% YOY)\n" +
                " Laravel (+45.0 YOY)\n" +
                " “Angular 2, which is a complete rewrite of AngularJS, has grown significantly over the past few years,” said Alvaro Oliveira, Toptals VP of Talent Operations. “As a TypeScript-based front-end web application platform, its core features allow businesses to improve internal processes and build business logic. For any platform that depends on client integration, this is imperative.”\n" +
                " Interestingly, Toptals results are in contrast to figures from NPM who put React some distance ahead of Angular as being the most popular.\n" +
                " “React has been adopted very rapidly,” notes Laurie Voss, co-founder and COO of NPM. “Part of this is a reflection of its nature; unlike [other frameworks], React isnt a full end-to-end solution for building a web application. Its a well-designed solution to a specific need that many applications have, and it incorporates easily with a number of alternative solutions for other parts of the application.”\n" +
                " Earlier this month, Developer reported C was picked as Tiobes programming language of 2017 due to its position and leading growth. The language remains at #2 in the January 2018 rankings, behind Java and ahead of C++\n" +
                " According to Toptal, languages expected to fall out of favor in 2018 include:\n" +
                " Objective-C\n" +
                " Perl\n" +
                " COBOL\n" +
                " What platforms and languages do you think will lead this year? Let us know in the comments.\n" +
                " ");
        dataList.add(article);

        article = new Article();
        article.setDefaultIcon("https://www.developer-tech.com//media/img/news/xcoffee-beans-and-hot-cofee-cup-with-latte-art-on-wooden-background-picture-id814684194.jpg.800x600_q96.png.pagespeed.ic.5AKd5BjJRM.jpg");
        article.setTitle("10 essential resources for intermediate Java programmers");
        article.setSubject("mechanical-engineering");
        article.setArticleUrl("https://www.developer-tech.com//news/2018/jun/01/10-essential-resources-intermediate-java-programmers/");
        article.setRaiting(5);
        article.setUpVotes(10);
        article.setDislikes(1);
        article.setArticleData("Java remains one of the most popular programming languages to learn, thanks to its long history and reputation for being easy to pick up yet difficult to master. After you get through the initial tutorials and become more comfortable in the language, finding out how to progress further can be difficult. This article is intended to help with that, offering ten useful resources that will help you further improve your skills and work your way to becoming an expert programmer. Lets start.\n" +
                " Book, Joshua Bloch\n" +
                " The Effective series of programming resources are some of the most commonly recommended, thanks to their compartmentalised format that focuses on delivering well-explained lessons, complete with full source code.\n" +
                " Online or Book, Oracle\n" +
                " These official tutorials written by Java caretaker Oracle range widely, introducing everything from introductory topics to user interfaces, helpful APIs and generics. Language features and syntax are the highlight here. The book equivalent is called The Java Tutorial, A Short Course on the Basics. Its worth noting that the tutorials were written for Java 8, so the new features of Java 9 and 10 wont be covered -- a common issue with resources for a language that has remained popular for much of its 23-year lifespan.\n" +
                " Book, Eric Freeman and Elisabeth Robson\n" +
                " Once you get past the painfully 2000s cover, Head First Design Patterns offer a handy rundown of commonly used patterns that will save you development time. The visual format and humorous tone should keep things interesting, too.\n" +
                " Online, IBM\n" +
                " IBMs intermediate Java programming tutorial covers the more advanced tools that should be in any Java developers toolkit, including potentially thorny subjects such as inheritance, abstraction, interfaces, regular expressions and so on. While the guide was written in 2005, it remains useful to this day.\n" +
                " Online, Jayaprabhakar Kadarkarai\n" +
                " The Codiva site provides a Java IDE and compiler, allowing you to write or investigate Java online, and it even works on your smartphone. More importantly, once you sign into the site, you can see a large number of Recommended Projects that show you how common tasks can be solved in Java. The website also has its own tutorials that are worth checking out, including Data Structures and Algorithms and Popular Algorithms.\n" +
                " \n" +
                " Online, Google\n" +
                " One of the most common reasons to learn Java is to begin programming for Android. With that in mind, the Android Developer Guides can be a good way to get started with making your own real apps for smartphones. Similarly, Googles Codelabs project also provides a good range of tutorials on common Android topics.\n" +
                " Project, Richard Schneeman\n" +
                " As we mentioned in our rundown of essential Python resources for intermediate programmers, actually coding is one of the best ways to learn a language once youve mastered the basics. However, it can be difficult to know where exactly to get started if you dont already have an idea in mind. CodeTriage is a project designed to provide that direction, letting you find and join open source projects to solve bugs, answer questions and generally become involved with proper Java development.\n" +
                " Online, University of Helsinki\n" +
                " This Finnish-made, English language resource takes you through twelve weeks of learning object-oriented programming, using precisely the same content as those in the university itself. The first part is designed for beginners, but by the second part you may begin to find topics that you dont understand completely so its worth at least cruising through the lessons until you get to one that you dont fully understand.\n" +
                " Online, Princeton University\n" +
                " This course is another good option, teaching important algorithms and data structures over a twelve week period. Rather than just text, this course includes videos, quizzes and projects to get your teeth into. Helpfully, while Java is used throughout, these lessons are applicable to many different languages and thus will be a boon for your future career.\n" +
                " Online, John Purcell\n" +
                " Prefer more visual learning, with people talking and animations and so on? This YouTube course starts slow, but builds into fairly advanced topics quite quickly. Have a look at the playlist and explore topics that youre not already familiar with.\n" +
                " What Java resources can you recommend? Let us know in the comments.\n" +
                " ");
        dataList.add(article);

        article = new Article();
        article.setDefaultIcon("https://www.developer-tech.com//media/img/news/xlondon-congestion-charge-picture-id172664307.jpg.800x600_q96.png.pagespeed.ic.QEvDEOUe5Y.jpg");
        article.setTitle("10 essential resources for intermediate C programmers");
        article.setSubject("electrical-engineering");
        article.setArticleUrl("https://www.developer-tech.com//news/2018/jun/08/10-essential-resources-intermediate-c-programmers/");
        article.setRaiting(5);
        article.setUpVotes(50);
        article.setDislikes(12);
        article.setArticleData("C is one of the most common languages taught at university, even though more modern languages like Java and Python are considered easier to learn. Why is that? Well, learning C is considered a good foundation for learning fancier languages later, as you get a better idea of what is going on behind the scenes by doing some things yourself. Its also widely used, forming the majority of code written to create Windows, Linux, Mac, databases, embedded systems and more.\n" +
                " In this article, were going to share 10 essential resources for improving your C skills. Whether youre a new programmer who has mastered the basics of C, or youre moving into C from another language, we hope these tutorials, guides, references and projects are helpful.\n" +
                " Book / Online, Kernighan and Ritchie\n" +
                " The C Programming Language (or the K&W book, as it is sometimes known) has been recommended as a reference for C programmers since time immemorial. The first edition was released back in 1978 and co-written by the original designer of C; an updated version was released ten years later to cover (then-new) ANSI C. What the book lacks in style and modernity, it makes up for in authority. If you are going to call yourself a C programmer, you should probably have The C Programming Language downloaded onto your PC or sitting on your bookshelf.\n" +
                " Book / Online, Jens Gustedt\n" +
                " As the name suggests, this freely available book covers modern C programming, with up-to-date references (as of 2018) that should make it a bit more understandable than The C Programming Language. Its divided into several levels, from introductory to advanced. If youre an intermediate programmer, its worth skimming through the opening encounter, acquaintance and cognition levels to make sure you fully understand each before you get into experience and ambition.\n" +
                " Online, rby90\n" +
                " Learning from books and working on toy code can be very helpful when youre starting out, but youre learn a lot by actually taking on complete project as well. This resource includes a categorised list of project-based tutorials, allowing you to build your own game, operating system, programming language, video player and so on. If that sounds a bit daunting, dont worry—there are plenty of smaller, easier projects to tackle as well.\n" +
                " Online, Harvard University\n" +
                " This well-respected online course taught by Harvard University introduces a range of Computer Science topics, including quite a lot of C. The course is offered for free, and includes nine long programming assignments (10-20 hours each) and one final project. If you complete the class, you can get a signed certificate to prove it.\n" +
                " Project, Richard Schneeman\n" +
                " The best way you can learn C is to actually write real projects... but if you dont have an idea to get started on, what should you do? CodeTriage could be the answer, as this simple website points you towards real open source projects that need your assistance. Find a project close to your heart (or just click on one randomly), check out its list of issues and try to solve bugs and answer questions. Even if you dont always succeed, the experience of working in a greater project is still quite edifying.\n" +
                " \n" +
                " Online, Steve Summit\n" +
                " This resource is a slightly more readable HTML version of frequently asked questions on the comp.lang.c Usenet, covering all sorts of standard and interestingly weird questions asked by journeyman C programmers. This one is a bit esoteric, but its somehow comforting to see C learners twenty years ago encountering the same problems as modern students.\n" +
                " Online, Peter Ranieri\n" +
                " This free book, available online as a PDF, is a compilation of the shuttered Stack Overflow Documentation. It is an exhaustive reference, which can take you from the earliest stages of learning C into more advanced topics such as threads, atomics, memory management and so on. Theres also a section on common C programming idioms, develop practices and pitfalls. Bookmark this one and refer to it often.\n" +
                " Online, Linus Torvalds\n" +
                " If youre going to take style advice from anyone, why not the creator of the Linux kernel Linus Torvalds? This brief document outlines a perennially popular style of laying out your C code, ensuring that the code you produce will be similar to others and therefore more readable.\n" +
                " Project, Qualified\n" +
                " Codewars is a very interesting idea: a kind of programming dojo, where you take on other students in challenges to complete challenges called kata to rise up the kyu ranks. The site supports a wide range of languages, C included.\n" +
                " Book / Online, Mecklenburg\n" +
                " If you begin using C for real projects, pretty quickly your compilation stage will begin to outstrip a single line that begins gcc, and thats where a makefile comes in handy. This is an entire tome on the topic, but reading at least the introductory elements can be a useful way to get to grips with this essential skill for C and other languages.\n" +
                " Did you find these C resources handy? Got any more to add? Let us know in the comments below.\n" +
                " ");
        dataList.add(article);

        article = new Article();
        article.setDefaultIcon("https://www.developer-tech.com//media/img/news/xamethystine-python-head-and-neck-raised-picture-id645260552.jpg.800x600_q96.png.pagespeed.ic.Mv3Pno8kPg.jpg");
        article.setTitle("10 essential resources for intermediate Python programmers");
        article.setSubject("computer science");
        article.setArticleUrl("https://www.developer-tech.com//news/2018/may/24/10-essential-resources-intermediate-python-programmers/");
        article.setRaiting(5);
        article.setUpVotes(1);
        article.setDislikes(0);
        article.setArticleData("So, youre an intermediate Python programmer. Youve earned that title through coming into Python after knowing another language, or by going through Python tutorials or classes until you felt confident enough in the basics. Thats great. Now, its time to really spread your wings and really start thinking in a Pythonic way. Here are ten of my favourite resources to do just that, including fun challenges, must-read books, reference tools and projects.\n" +
                " Website, Doug Hellmann\n" +
                " As the name suggests, this website highlights a single Python module each week, taking you through the practical details of the standard library. As Python itself is fairly straightforward but its libraries are famously immense, this is a nice way to get better acquainted with them without getting too overburdened. Just bookmark it, check back every week and youll be up to speed in no time.\n" +
                " Book, OReilly\n" +
                " If youre looking for a deeper understanding of Python, then one of the best resources is the OReilly title Fluent Python. This book is intended for intermediate to experienced Python programmers, so this might not be the best choice if you were calling yourself a Python beginner not too long ago!\n" +
                " Website or Book, Guido van Rossum\n" +
                " Python is rare in having an official resource that is actually excellent. Along with the official Python tutorial, Python creator Guido van Rossum takes you though the most essential parts of the Python language. This is particularly handy for experienced programmers that are new to Python. Once again, bookmark it and refer to it whenever you get stuck -- odds are, youll be able to solve your issue or at least learn where to go next by checking this resource.\n" +
                " Book, Brett Slatkin\n" +
                " This books subtitle is 59 specific ways to write better Python, and thats exactly what you get. Each chapter offers a proper lesson with source code printed with syntax highlighting, exactly as youd have on screen. Through going through the examples, you should gain a better understanding of how to solve common problems and what makes Python tick.\n" +
                " Book, David Beazley\n" +
                " This title is regarded as one of the best books for learning Python if youre already an experienced software developer. Note that a fifth edition of the book based on Python 3.6 will be available in late 2019, so if youre reading this close to that date, you may want to hang fire for a more up-to-date version.\n" +
                " \n" +
                " Project, Richard Schneeman\n" +
                " Reading books and playing with challenges can be a good way to learn, but what about contributing to an actual open source project? CodeTriage gives you the chance to do just that, providing a way to easily find and join an open source project that needs questions answering, bugs fixing and so on. If youre new to open source and youre not sure how to get involved, this is a great place to start.\n" +
                " Website, Aristotelis Kittas\n" +
                " These presentations are sparsely presented -- just a Github page with a choice of slides in several subjects -- but provide some valuable real world examples of Python problems and how to solve them, with jokes peppered throughout. For the live version, you might be able to find the author at a Python meetup if you live in or near the UK.\n" +
                " Website, Reddit\n" +
                " Of the two main Python sections on Reddit, /r/Python and /r/LearnPython, the latter is the most practical option for someone looking to improve their skills. As new books are published, challenges created and questions answered, youll find all of them here. Its also a nice way to give back to the community, by answering the questions of others when possible. You can do something similar on legendary programming resource Stack Overflow as well.\n" +
                " Website, Philip Guo\n" +
                " This useful tool shows you what is actually happening as each line of code is run. This visualisation makes it much easier to find logical errors and gain a better grasp of Python, as you can step back and forth to see exactly what is happening in your variables, objects and so on. You can even ask other website users to join in and chat with you about whatever problems youre facing.\n" +
                " Website, Louie Dinh\n" +
                " Python Practice Projects is another well-named resource, providing... small Python projects for you to practice with! Youre asked to build a command line parser, a lisp interpreter, a templating engine or a static site generator, and given just enough information to get started. If you are just learning and practising Python in your spare time, this is a nice way to actually be motivated to finish a useful program!\n" +
                " Did you find these Python resources useful? Got any more to add? Let us know in the comments below.\n" +
                " ");
        dataList.add(article);

        article = new Article();
        article.setDefaultIcon("https://www.developer-tech.com//media/img/news/xprogramming-works-picture-id494345930.jpg.800x600_q96.png.pagespeed.ic.uWNClmI5By.jpg");
        article.setTitle("A developing affection: Assessing the rise and fall of programming languages");
        article.setSubject("computer science");
        article.setArticleUrl("https://www.developer-tech.com//news/2018/jan/11/developing-affection-assessing-rise-and-fall-programming-languages/");
        article.setRaiting(5);
        article.setUpVotes(100);
        article.setDislikes(0);
        article.setArticleData("These days we take applications for granted to run our businesses and organise and entertain us in our personal lives. But which are the programming languages that enable our digital world – and how are they progressing over time?\n" +
                " A good starting point for understanding the relative popularity of programming languages is to look at studies from groups like TIOBE, RedMonk, and Stack Overflow, which show how languages trend over time. GitHub can also be an important gauge, particularly in the open source community, because it objectively shows how many code contributions are being made in a specific language.\n" +
                " In the last five years weve entered a period of programming language density. For example, there has been an explosion of languages that have also made their way onto the Java Virtual Machine. But even with all of these newcomers, if you were to map the trend, the top ones have stayed much the same with Java, C, C++, PHP, Python and JavaScript consistently among the most popular languages, according to these studies.\n" +
                " Timing, adoption and being associated with a “killer app” use case are what differentiate popular programming languages from those that fall by the wayside. If you look at programming languages from an academic point of view, there have been some, theoretically better languages that have not taken off or have fallen into disuse simply because they didnt come along at the right time, or get used as the basis of a killer use case.\n" +
                " The languages C and C++ have been around for decades and are still going strong, and they continue to play an important role for low-level development on things like operating systems, device drivers, or where high performance interaction with hardware is needed, so I expect their use will continue for years to come.\n" +
                " Similarly, Java has been around since 1996 and is also going strong today. One of the reasons for its massive popularity is that it came along at the right time, when developers wanted to increase their productivity and object-oriented programming languages. Java also handles the execution of multiple parallel processes (threads) within a single process very well. When it came along in 1996, threads just werent a common thing in general and almost unheard of within programming languages. Java also offered the benefit of being able to write once run anywhere, so that the code could run on different machine architectures and operating systems, giving it wide appeal among developers.\n" +
                " JavaScript is another programming language that is regularly included among the most popular languages, but here its important to draw a distinction between popularity in terms of the number of users and how well-liked a programming language is. JavaScript is a dynamic language that has been widely adopted for web and mobile development; however, the developer community at large is quite divided on its likeability. Regardless, the web and more recently the proliferation of mobile has been a “killer app” use case that has propelled its popularity.\n" +
                " Googles Go language is an interesting one that is worth mentioning. At only 10 years old, Go is relatively young compared to the other languages previously highlighted, but it is rising quickly. In July 2016, the language ranked 55th on the TIOBE Index, and by July 2017 it had moved all the way up to 10th position (though it has dipped several spots in recent months). With the meteoric rise of container technologies like Docker and Kubernetes, we saw traction around Go increase and containers and orchestration of them is probably the “killer app” for Go. In a similar vein, the popularity of Apple devices has led to the rapid rise of Swift to become a top-15 programming language, which is phenomenal considering the fact that it was only introduced three years ago.\n" +
                " In summary, while there has been some fluctuation among the top programming languages, the list of leaders has remained pretty stable over the years. The exact position depends on how each language is being evaluated, and again, I think its important to differentiate between popularity of a language and what developers like using. Its easy to objectively measure which programming languages are being used but that doesnt measure the more subjective idea of which languages developers actually like.\n" +
                " ");
        dataList.add(article);

        article = new Article();
        article.setDefaultIcon("https://www.developer-tech.com//media/img/news/xprogramming-works-picture-id494345930.jpg.800x600_q96.png.pagespeed.ic.uWNClmI5By.jpg");
        article.setTitle("C named as TIOBEs 2017 programming language of the year");
        article.setSubject("electrical-engineering");
        article.setArticleUrl("https://www.developer-tech.com//news/2018/jan/11/developing-affection-assessing-rise-and-fall-programming-languages/");
        article.setRaiting(5);
        article.setUpVotes(5);
        article.setDislikes(1);
        article.setArticleData("Sometimes the old ones are the best ones: C has been named as TIOBEs programming language of 2017, nine years after its most recent triumph.\n" +
                " The language remains at #2 in the January 2018 rankings, behind Java and ahead of C++ – with no change from January 2017s index – but came out on top for language of the year because of its yearly growth of 1.69%. Runners up were Python (1.21% growth) and Erlang (0.98%).\n" +
                " TIOBE argues that the reason for Cs growth – admitting it won because “there were no outstanding alternatives” – was because of its continued climb in the growing manufacturing and machine industry, including the automotive market.\n" +
                " While Java and C remain the most dominant programming languages, there is no denying they have taken a hit over the past few years. The TIOBE index does not factor in the best language, or the one with the most lines of code written, instead focusing on hits of the most popular search engines. From a level of 21% for Java and 16% for C at the beginning of 2016, the most recent ratings for both are 14.2% and 11% respectively, with low points of 12% for Java (October 2017) and 6.5% for C (August 2017).\n" +
                " Regular readers of this publication may be surprised at Cs elevation, given various other sources throughout 2017 put Python, one of the runners up, at the top of the tree. Python was named, alongside Node.js and Rust, as one of the three languages growing quickest in popularity according to Stack Overflow in March, while in July IEEE Spectrum awarded Python the top programming language of 2017.\n" +
                " The top 10 languages in January 2018 according to TIOBE are Java, C, C++, Python, C#, JavaScript, Visual Basic.NET, R, PHP, and Perl. You can read the full index here.\n" +
                " ");
        dataList.add(article);

        Collections.sort(dataList, new Sortbysubject());
    }

    private void visualizeArticles(){
        ListNewsAdapter adapter = new ListNewsAdapter(HomeActivity.this, dataList);
        listNews.setAdapter(adapter);

        listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(HomeActivity.this, ArticleActivity.class);
                i.putExtra("position", String.valueOf(position));
                startActivity(i);
            }
        });
    }

    class Sortbysubject implements Comparator<Article>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Article a, Article b)
        {
            if(a.getSubject().equalsIgnoreCase(preferredSubject)&&b.getSubject().equalsIgnoreCase(preferredSubject)){
                double coefA=a.getRaiting()+(a.getUpVotes()-a.getDislikes())/10;
                double coefB=b.getRaiting()+(b.getUpVotes()-b.getDislikes())/10;
                if(coefA>coefB){
                    return -2000 - (int)coefB;
                }else{
                    return -2000 + (int)coefA;
                }
            }else{
                if(a.getSubject().equalsIgnoreCase(preferredSubject)){
                    return -2000;
                } else{
                    return 5000;
                }
            }
        }
    }
}
