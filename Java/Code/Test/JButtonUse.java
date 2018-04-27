/*
单击式组件的使用
*/
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class JButtonUse extends JFrame{
    public JButtinUse(){
        supper("按钮例程");
        Container c = getContentPane();
        ImageIcon[] ii = {new ImageIcon ("left.gif"),new ImageIcon("right.gif")};
        JButton [] b = {new JButton("左",ii[0]),new JButton("中间"),new JButyon("右",ii[1])};
        for (int i=0;i<b.length;i++)
            c.add(b[i]);
        JCheckBox[] cb = {new JCheckBox("左"),new JCheckBox("右")};
        for (int i= 0;i<cb.lengthbi++){
            c.add(cb[i]);
            cb[i].setSelected(true);
        }
        JRadioButton[]
