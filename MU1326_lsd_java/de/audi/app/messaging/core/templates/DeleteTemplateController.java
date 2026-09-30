/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.templates.DeleteTemplateCommand;
import de.audi.atip.hmi.model.DefaultButtonListener;
import org.dsi.ifc.messaging.Template;

public final class DeleteTemplateController
extends AbstractMessagingComponent {
    private volatile Template deleteCandidate = null;
    private volatile Template[] userTemplates = new Template[0];

    public DeleteTemplateController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200275).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200391).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200277).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200387).setButtonListener(myButtonListener);
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
    }

    public void setDeleteCandidate(Template template) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[DeleteTemplateController#setDeleteCandidate] template = %1", (Object)String.valueOf(template));
        }
        this.deleteCandidate = template;
    }

    private void setUserTemplates(Template[] templateArray) {
        this.log.log(10000000, "[DeleteTemplateController#setUserTemplates]");
        this.userTemplates = templateArray != null ? templateArray : new Template[]{};
    }

    private void deleteAllUserTemplates() {
        int[] nArray = new int[this.userTemplates.length];
        for (int i2 = 0; i2 < this.userTemplates.length; ++i2) {
            nArray[i2] = this.userTemplates[i2].getId();
        }
        this.deleteTemplateSelection(nArray);
    }

    private void deleteTemplateSelection(int[] nArray) {
        this.msgApp.getModelAccess().setOperationStateChoice(2200251, 0);
        new DeleteTemplateCommand(this.msgApp, nArray).schedule();
    }

    private void deleteSingleUserTemplateButton(int n, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[DeleteTemplateController#deleteSingleUserTemplateButton] modelID = %1, deleteCandidate = %2", (Object)String.valueOf(n), (Object)String.valueOf(this.deleteCandidate));
        }
        if (this.deleteCandidate == null || this.deleteCandidate.isReadOnly()) {
            this.log.log(100000, "[DeleteTemplateController#deleteSingleUserTemplateButton] The current candidate for deletion cannot be deleted, ignoring call.");
        } else {
            this.deleteTemplateSelection(new int[]{this.deleteCandidate.getId()});
            this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
        }
    }

    private void deleteAllUserTemplatesButton(int n, int n2) {
        this.log.log(1000000, "[DeleteTemplateController#deleteAllUserTemplatesButton] modelID = %1", (long)n);
        this.deleteAllUserTemplates();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200275 || n == 2200391) {
                DeleteTemplateController.this.deleteSingleUserTemplateButton(n, n3);
            } else if (n == 2200277 || n == 2200387) {
                DeleteTemplateController.this.deleteAllUserTemplatesButton(n, n3);
            } else {
                DeleteTemplateController.this.log.log(10000, "[DeleteTemplateController#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private class MyDsiMessagingListener
    extends DsiMessagingEmptyListener {
        private MyDsiMessagingListener() {
        }

        public void getTemplatesResponse(int n, Template[] templateArray) {
            DeleteTemplateController.this.log.log(10000000, "[DeleteTemplateController#getTemplatesResponse]");
            if (n == 0) {
                DeleteTemplateController.this.setUserTemplates(templateArray);
            }
        }
    }
}

