import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.swing.*;


public class PostChanelAction extends AnAction {
    @Override
    public void actionPerformed(@org.jetbrains.annotations.NotNull AnActionEvent event) {
        Messages.showMessageDialog("Hello", "Post Code", Messages.getInformationIcon());

        Editor editor = event.getData(PlatformDataKeys.EDITOR);

        String selectedText = editor.getSelectionModel().getSelectedText();

        if (selectedText != null) {
            try {

                Description TextPox = new Description();
                TextPox.SentThis = selectedText;

            } catch (Exception ex) {
                ex.printStackTrace();
                Messages.showMessageDialog("Hello", "Post Code", Messages.getInformationIcon());
            }

        }
    }

    @Override
    public boolean isDumbAware() {
        return true;
    }
}
