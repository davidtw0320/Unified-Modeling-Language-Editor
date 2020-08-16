package GUI;

import Mode.*;

import javax.swing.*;

public class UMLButton extends JToggleButton{
    public Mode mode;
    public int buttonIndex;
    
    UMLButton(Mode mode, int index, Icon icon){
        super(icon);
        this.mode = mode;
        this.buttonIndex = index;
    }
}