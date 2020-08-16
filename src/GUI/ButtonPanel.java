package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Mode.Association.*;
import Mode.Class.*;
import Mode.*;

public class ButtonPanel extends JPanel{
    public ArrayList<UMLButton> buttonSet = new ArrayList<>();
    private Integer buttonSetSize = 6;
    private UMLButton button;
    private ButtonGroup buttonGroup;
    public int buttonIndex;

    public ButtonPanel(){
        buttonGroup = new ButtonGroup();
        setLayout(new GridLayout(buttonSetSize, 1));
        for(int buttonIndex=0; buttonIndex < buttonSetSize; buttonIndex ++){
            switch (buttonIndex){
                case 0:
                    button = new UMLButton(new SelectMode(), buttonIndex, new ImageIcon(getClass().getResource("/resources/" + String.valueOf(buttonIndex) + ".png")));
                    break;
                case 1:
                    button = new UMLButton(new AssociationLineMode(), buttonIndex, new ImageIcon(getClass().getResource("/resources/" + String.valueOf(buttonIndex) + ".png")));
                    break;
                case 2:
                    button = new UMLButton(new GeneralizationLineMode(), buttonIndex, new ImageIcon(getClass().getResource("/resources/" + String.valueOf(buttonIndex) + ".png")));
                    break;
                case 3:
                    button = new UMLButton(new CompositionLineMode(), buttonIndex, new ImageIcon(getClass().getResource("/resources/" + String.valueOf(buttonIndex) + ".png")));
                    break;
                case 4:
                    button = new UMLButton(new ClassObjectMode(), buttonIndex, new ImageIcon(getClass().getResource("/resources/" + String.valueOf(buttonIndex) + ".png")));
                    break;
                case 5:
                    button = new UMLButton(new UseClassObjectMode(), buttonIndex, new ImageIcon(getClass().getResource("/resources/" + String.valueOf(buttonIndex) + ".png")));
                    break;
            }
            add(button);
            buttonSet.add(button);
            buttonGroup.add(button);
        }
        
    }
    
    public void panelAddActionListener(ActionListener window){
        for(UMLButton button: buttonSet){
            button.addActionListener(window);
        }
    }

    public void panelActionPerformed(ActionEvent e){
        UMLButton basicButton = (UMLButton) e.getSource();
        buttonIndex = basicButton.buttonIndex;
    }
}