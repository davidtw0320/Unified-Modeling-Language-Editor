package GUI;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener{

    private Menu menu;
    private ButtonPanel buttonPanel;
    private Canvas canvas;
    
    public Window(){
        super("UML editor");
        setSize(800,800);

        buttonPanel = new ButtonPanel();
        canvas = new Canvas(buttonPanel);
        menu = new Menu(canvas);
        setJMenuBar(menu);

        add(buttonPanel, BorderLayout.WEST);
        add(canvas,BorderLayout.CENTER);

        buttonPanel.panelAddActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        buttonPanel.panelActionPerformed(e);
    }
}