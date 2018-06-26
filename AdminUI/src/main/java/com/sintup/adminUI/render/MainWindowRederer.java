package main.java.com.sintup.adminUI.render;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.sintup.parser.base.Article;

public class MainWindowRederer extends DefaultListCellRenderer implements ListCellRenderer<Object> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {

        Article article = (Article) value;
        setText(article.getTitle());
        setIcon(new ImageIcon(article.getDefaultIcon()));

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        // setSize(new Dimension(100, 100));
        // setAutoscrolls(true);
        // setEnabled(true);
        // setFont(list.getFont());

        return this;
    }
}
