package views.popups;
import javax.swing.*;
import java.awt.*;

public class FailureDialog extends javax.swing.JDialog{
    public FailureDialog(String message){
        super((Window)null);
        setModal(true);

        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(330,230);
        JLabel failure_message=new JLabel("The transaction has failed!");
        failure_message.setBounds(20,20,300,30);
        failure_message.setFont(new Font("Sans Serif",Font.PLAIN,18));
        JLabel reason=new JLabel(message);
        reason.setForeground(Color.RED.darker());
        reason.setBounds(70,70,200,30);
        reason.setFont(new Font("Sans Serif",Font.PLAIN,18));
        JButton ok=new JButton("Go Back");
        ok.setBounds(100,120,100,30);
        ok.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dispose();
            }
        });
        add(failure_message);
        add(reason);
        add(ok);

        setVisible(true);
    }
}
