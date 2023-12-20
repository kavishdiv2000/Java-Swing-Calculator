package controller;

import jdk.jshell.JShell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;


public class ButtonClickListener implements ActionListener {
    private JTextField display;
    JShell js = JShell.create();
    public ButtonClickListener(JTextField display){
        this.display = display;

    }
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();
        if("AC".equals(buttonText)){
            this.display.setText("");
        }else if("Del".equals(buttonText)){
            if (this.display.getText().equals("Error")) this.display.setText("");
            String tempText = this.display.getText();
            this.display.setText(tempText.substring(0,tempText.length()-1));
        }

        else if ("=".equals(buttonText)) {
            try {
                String result = evaluateExpression("1.0*"+this.display.getText());
                this.display.setText(result);
            } catch (Exception ex) {
                this.display.setText("Error");
            }
        } else {
            if (this.display.getText().equals("Error")) this.display.setText("");

            this.display.setText(this.display.getText() + buttonText);
        }
    }

    private String evaluateExpression(String text){
        AtomicReference<String> value = new AtomicReference<>("");


        this.js.onSnippetEvent(snip -> {
            if (snip.status() == jdk.jshell.Snippet.Status.VALID) {
                value.set(String.valueOf(snip.value()));

            }
        });
        this.js.eval(this.js.sourceCodeAnalysis().analyzeCompletion(text).source());

        return String.valueOf(value);
    }


}
