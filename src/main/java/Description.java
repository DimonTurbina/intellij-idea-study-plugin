import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Description extends JFrame {

    public JPanel jp = new JPanel();
    public String SentThis = "";
    JLabel jl = new JLabel();
    JTextField jt = new JTextField(30);
    JButton jb = new JButton("Enter");

    public Description()
    {
        setTitle("Description");
        setVisible(true);
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jp.add(jt);


        jt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = jt.getText();
                jl.setText(input);
            }
        });

        jp.add(jb);
        jb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                HttpClient httpClient = HttpClientBuilder.create().build();

                String input = jt.getText();
                jl.setText(input);

                input += "\n";
                HttpPost request = new HttpPost("https://api.telegram.org/bot2008724853:AAHzAHX8H3iCMOGq3WrQ7vbJ0kSOgNJ5Bp4/sendMessage");
                String QueryString = "{\"parse_mode\": \"Markdown\",\"chat_id\":\"-1001583169460\",\"text\":\"```\n" + StringEscapeUtils.unescapeJava(input + SentThis) + "\n```\"}";
                StringEntity params = null;
                try {

                    params = new StringEntity(QueryString);
                    params.setContentType("application/json");

                    //Box
                    String Discription = input;

                    request.setEntity(params);
                    HttpResponse response = httpClient.execute(request);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        jp.add(jl);
        add(jp);

    }

}
