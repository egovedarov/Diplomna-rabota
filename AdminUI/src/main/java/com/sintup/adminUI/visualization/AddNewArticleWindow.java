package main.java.com.sintup.adminUI.visualization;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.commons.lang3.StringUtils;

import com.sintup.parser.dataLoding.DataLoader;

public class AddNewArticleWindow {

    public JFrame frame;
    private JTextField cssSelector;
    private JTextField articleSubject;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddNewArticleWindow window = new AddNewArticleWindow();
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
    public AddNewArticleWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Add New Article Window");
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        frame.setBounds(100, 100, 919, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        TextArea articleUrl = new TextArea();
        articleUrl.setBounds(10, 42, 410, 64);
        frame.getContentPane().add(articleUrl);

        TextArea iconUrl = new TextArea();
        iconUrl.setBounds(486, 42, 410, 64);
        frame.getContentPane().add(iconUrl);

        Label label = new Label("URL \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u044F\u0442\u0430");
        label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
        label.setAlignment(Label.CENTER);
        label.setBounds(0, 0, 444, 29);
        frame.getContentPane().add(label);

        Label label_1 = new Label(
                "URL \u043D\u0430 \u0433\u043B\u0430\u0432\u043D\u043E\u0442\u043E \u0438\u0437\u043E\u0431\u0440\u0430\u0436\u0435\u043D\u0438\u0435");
        label_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
        label_1.setAlignment(Label.CENTER);
        label_1.setBounds(452, 0, 444, 29);
        frame.getContentPane().add(label_1);

        TextArea articleTitle = new TextArea();
        articleTitle.setBounds(253, 212, 410, 64);
        frame.getContentPane().add(articleTitle);

        JComboBox articleRaiting = new JComboBox(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
        articleRaiting.setBounds(709, 328, 39, 25);
        frame.getContentPane().add(articleRaiting);

        cssSelector = new JTextField();
        cssSelector.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cssSelector.setBounds(210, 144, 477, 34);
        frame.getContentPane().add(cssSelector);
        cssSelector.setColumns(10);

        JLabel lblNewLabel = new JLabel("CSS \u0421\u0435\u043B\u0435\u043A\u0442\u043E\u0440");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(353, 112, 185, 34);
        frame.getContentPane().add(lblNewLabel);

        JButton addNewArticleButton = new JButton(
                "\u0414\u043E\u0431\u0430\u0432\u0438 \u0421\u0442\u0430\u0442\u0438\u044F");
        addNewArticleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String articleUrlText = articleUrl.getText();
                String cssSelectorText = cssSelector.getText();
                String iconUrlText = iconUrl.getText();
                String articleTitleText = articleTitle.getText();
                String articleSubjectText = articleSubject.getText();
                String articleRaitingText = (String) articleRaiting.getSelectedItem();

                if (StringUtils.isNotEmpty(articleUrlText) && StringUtils.isNotEmpty(cssSelectorText)
                        && StringUtils.isNotEmpty(iconUrlText) && StringUtils.isNotEmpty(articleTitleText)
                        && StringUtils.isNotEmpty(articleSubjectText) && StringUtils.isNotEmpty(articleRaitingText)) {
                    String errorMesage = DataLoader.loadCustomData(articleUrlText, articleTitleText, cssSelectorText,
                            iconUrlText, articleSubjectText, Integer.parseInt(articleRaitingText));
                    if (errorMesage != null) {
                        JOptionPane.showMessageDialog(frame, errorMesage, "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    MainWindow window = new MainWindow();
                    window.frame.setVisible(true);
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "Поне едно от полетата е празно!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        addNewArticleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        addNewArticleButton.setBounds(641, 366, 221, 64);
        frame.getContentPane().add(addNewArticleButton);

        Label label_2 = new Label(
                "\u0417\u0430\u0433\u043B\u0430\u0432\u0438\u0435 \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u044F\u0442\u0430");
        label_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
        label_2.setAlignment(Label.CENTER);
        label_2.setBounds(230, 184, 444, 29);
        frame.getContentPane().add(label_2);

        Label label_3 = new Label(
                "\u0414\u0438\u0441\u0446\u043F\u043B\u0438\u043D\u0430 \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u044F\u0442\u0430");
        label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
        label_3.setAlignment(Label.CENTER);
        label_3.setBounds(0, 288, 350, 29);
        frame.getContentPane().add(label_3);

        articleSubject = new JTextField();
        articleSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
        articleSubject.setColumns(10);
        articleSubject.setBounds(10, 319, 333, 34);
        frame.getContentPane().add(articleSubject);

        Label label_4 = new Label(
                "\u0420\u0435\u0439\u0442\u0438\u043D\u0433 \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u044F\u0442\u0430");
        label_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
        label_4.setAlignment(Label.CENTER);
        label_4.setBounds(546, 288, 350, 29);
        frame.getContentPane().add(label_4);

        JButton button = new JButton(
                "\u0417\u0430\u0440\u0435\u0436\u0434\u0430\u043D\u0435 \u043D\u0430 \u0441\u0442\u0430\u0442\u0438\u0438");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DataLoader.loadPredifyinedData();
                MainWindow window = new MainWindow();
                window.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setBounds(353, 366, 221, 64);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("\u041D\u0430\u0437\u0430\u0434");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainWindow window = new MainWindow();
                window.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        button_1.setMargin(new Insets(0, 0, 0, 0));
        button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button_1.setBounds(51, 366, 221, 64);
        frame.getContentPane().add(button_1);

    }
}
