package main.java.com.sintup.adminUI.visualization;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sintup.parser.base.Article;
import com.sintup.parser.utils.DatabaseUtil;

import main.java.com.sintup.adminUI.render.MainWindowRederer;

public class MainWindow extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public static final String ADMIN_USER = "admin";
    public static final String ADMIN_PASSWORD = "Test321";

    DefaultListModel<Article> model = new DefaultListModel<Article>();

    JList<Article> articleList = new JList<Article>();

    List<Article> listOfArticles = new ArrayList<Article>();

    private void populate() {

        DatabaseUtil databaseUtil = new DatabaseUtil(ADMIN_USER, ADMIN_PASSWORD);

        try {
            listOfArticles = databaseUtil.getArticles();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Връзката с базата данни не може да бъде установена! Моля рестартирайте приложението.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        model.clear();

        for (Article article : listOfArticles) {
            model.addElement(article);
        }

        articleList.setCellRenderer(new MainWindowRederer());
        articleList.setMaximumSize(new Dimension(2, 2));
        articleList.setModel(model);
    }

    JFrame frame;
    private JScrollPane pane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Main Window");
        frame.setBounds(100, 100, 877, 476);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JButton addNewArticleButton = new JButton(
                "\u0414\u043E\u0431\u0430\u0432\u044F\u043D\u0435 \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u0438\r\n");
        addNewArticleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addNewArticleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddNewArticleWindow window = new AddNewArticleWindow();
                window.frame.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        addNewArticleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

            }
        });
        addNewArticleButton.setBounds(96, 359, 257, 42);
        frame.getContentPane().add(addNewArticleButton);

        JButton showCurrentArticleButton = new JButton(
                "\u041F\u043E\u043A\u0430\u0437\u0432\u0430\u043D\u0435 \u043D\u0430 \u0438\u0437\u0431\u0440\u0430\u043D\u0430\u0442\u0430 \u0441\u0442\u0430\u0442\u0438\u044F");
        showCurrentArticleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        showCurrentArticleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (articleList.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(frame, "Нито една статия не е маркирана.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    EditArticleWindow window = new EditArticleWindow(articleList.getSelectedValue().getTitle());
                    window.frame.setVisible(true);
                    frame.setVisible(false);
                }
            }
        });
        showCurrentArticleButton.setBounds(521, 359, 290, 42);
        frame.getContentPane().add(showCurrentArticleButton);
        populate();

        pane = new JScrollPane(articleList);
        pane.setBounds(96, 33, 715, 316);
        frame.getContentPane().add(pane);
        
        articleList.setBounds(136, 50, 642, 267);
        articleList.setFixedCellWidth(20);
    }

}
