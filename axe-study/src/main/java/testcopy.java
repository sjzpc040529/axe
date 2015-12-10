/**
 * 导入java中的库文件
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

/**
 * 自定义Win类，继承自Frame窗体，继承ActionListener接口
 * @author chenshanshan
 *
 */
class 	Win extends Frame implements ActionListener
{
    //菜单工具条
    MenuBar menubar;
    //菜单
    Menu menu;
    //菜单列表
    MenuItem copy,cut,paste;
    //文本框
    TextArea t1,t2;
    //剪贴板
    Clipboard clb=null;

    /**
     * 构造函数
     */
    Win()
    {
        //获取系统剪贴板
        clb=getToolkit().getSystemClipboard();

        //设置窗体控件
        menubar=new MenuBar();
        menu=new Menu("Edit");
        copy=new MenuItem("copy");
        cut=new MenuItem("cut");
        paste=new MenuItem("paste");
        t1=new TextArea(10,20);
        t2=new TextArea(10,20);
        menubar.add(menu);
        menu.add(copy);
        menu.add(cut);
        menu.add(paste);
        setMenuBar(menubar);
        add(t1);
        add(t2);

        //添加事件监听
        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);

        //设置窗体相关属性
        setLayout(new FlowLayout());
        setBounds(100,100,400,350);
        //窗体可见
        setVisible(true);
        //添加组件的有效验证
        validate();

        //添加窗体关闭事件的监听
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    /**
     * menu的监听
     */
    public void actionPerformed(ActionEvent e)
    {
        //复制
        if(e.getSource()==copy)
        {
            //获取文本框1中光标选中的值
            String temp=t1.getSelectedText();
            //将至以无格式文本格式传送
            StringSelection text=new StringSelection(temp);
            //将值设定到系统剪贴板中
            clb.setContents(text, null);
        }
        //剪切
        else if(e.getSource()==cut)
        {
            String temp=t1.getSelectedText();
            StringSelection text=new StringSelection(temp);
            clb.setContents(text, null);
            //获取光标选中的起点、终点位置
            int s=t1.getSelectionStart();
            int end=t1.getSelectionEnd();
            //将值从文本框1中删除
            t1.replaceRange("", s, end);
        }
        //黏贴
        else if(e.getSource()==paste)
        {
            //获取剪贴板中的值，con为要进行传输操作的数据
            Transferable con=clb.getContents(this);
            //表示一个 Java Unicode String 类的 DataFlavor
            DataFlavor flavor=DataFlavor.stringFlavor;
            //判断con是否是支持指定的数据 flavor。
            if(con.isDataFlavorSupported(flavor))
            {
                try
                {
                    String str;
                    //返回一个对象，该对象表示将要被传输的数据
                    str=(String )con.getTransferData(flavor);
                    //将系统剪贴板返回的数据放到文本框2中
                    t2.append(str);
                }
                catch(Exception ee)
                {

                }
            }
        }
    }
}

public class testcopy {
    public static void main(String args[])
    {
        //调用自定义的窗体类
        new Win();
    }

}
