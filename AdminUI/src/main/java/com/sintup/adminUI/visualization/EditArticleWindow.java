package main.java.com.sintup.adminUI.visualization;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.commons.lang3.StringUtils;

import com.sintup.parser.utils.DatabaseUtil;

public class EditArticleWindow {

    public JFrame frame;
    private JTextField articleSubject = new JTextField();
    JComboBox articleRaiting;
    TextArea articleText;

    private static String title;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditArticleWindow window = new EditArticleWindow(title);
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
    public EditArticleWindow(String title) {
        EditArticleWindow.title = title;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Edit Article Window");
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        frame.setBounds(100, 100, 919, 510);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        articleRaiting = new JComboBox(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
        articleText = new TextArea();
        JLabel titleLabel = new JLabel(
                "\u0417\u0430\u0433\u043B\u0430\u0432\u0438\u0435 \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u044F\u0442\u0430");
        DatabaseUtil databaseUtil = new DatabaseUtil(MainWindow.ADMIN_USER, MainWindow.ADMIN_PASSWORD);
        try {
            com.sintup.parser.base.Article article = databaseUtil.getArticle(title);
            articleText.setText(article.getArticleData());
            articleSubject.setText(article.getSubject());
            articleRaiting.setSelectedIndex(article.getRaiting() - 1);
            titleLabel.setText(article.getTitle());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Поне едно от полетата е празно!", "Error", JOptionPane.ERROR_MESSAGE);
            MainWindow window = new MainWindow();
            window.frame.setVisible(true);
            frame.setVisible(false);
        }

        articleText.setBounds(55, 96, 804, 208);
        articleText.setEditable(false);
        frame.getContentPane().add(articleText);

        articleRaiting.setBounds(711, 347, 39, 25);
        frame.getContentPane().add(articleRaiting);

        JLabel lblNewLabel = new JLabel(
                "\u0417\u0430\u0433\u043B\u0430\u0432\u0438\u0435 \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u044F\u0442\u0430");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(288, 11, 328, 34);
        frame.getContentPane().add(lblNewLabel);

        JButton addNewArticleButton = new JButton(
                "\u041E\u0431\u043D\u043E\u0432\u0438 \u0421\u0442\u0430\u0442\u0438\u044F");
        addNewArticleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String articleSubjectText = articleSubject.getText();
                String articleRaitingText = (String) articleRaiting.getSelectedItem();
                if (StringUtils.isNotEmpty(articleSubjectText) && StringUtils.isNotEmpty(articleRaitingText)) {
                    try {
                        databaseUtil.updateArticle(title, articleSubjectText, Integer.parseInt(articleRaitingText));
                        MainWindow window = new MainWindow();
                        window.frame.setVisible(true);
                        frame.setVisible(false);
                        frame.dispose();
                    } catch (NumberFormatException e) {
                        // the exception will not occur because we get the raiting from a combobox
                        e.getMessage();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(frame,
                                "Имаше проблем при обновяването на статията.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Поне едно от полетата е празно!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        addNewArticleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        addNewArticleButton.setBounds(529, 396, 221, 64);
        frame.getContentPane().add(addNewArticleButton);

        JLabel label = new JLabel(
                "\u0414\u0438\u0441\u0446\u0438\u043F\u043B\u0438\u043D\u0430 \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u044F\u0442\u0430");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        label.setBounds(10, 310, 328, 34);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel(
                "\u0420\u0435\u0439\u0442\u0438\u043D\u0433 \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u044F\u0442\u0430");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        label_1.setBounds(575, 310, 328, 34);
        frame.getContentPane().add(label_1);

        articleSubject.setBounds(20, 342, 303, 34);
        frame.getContentPane().add(articleSubject);
        articleSubject.setColumns(10);

        JButton backButton = new JButton("\u041D\u0430\u0437\u0430\u0434");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainWindow window = new MainWindow();
                window.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        backButton.setBounds(117, 396, 221, 64);
        frame.getContentPane().add(backButton);

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        titleLabel.setBounds(55, 56, 804, 34);
        frame.getContentPane().add(titleLabel);
    }
}
