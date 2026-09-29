/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.templates.DeleteTemplateCommand;
import de.audi.app.messaging.core.templates.DeleteTemplateController$MyButtonListener;
import de.audi.app.messaging.core.templates.DeleteTemplateController$MyDsiMessagingListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.Template;

public final class DeleteTemplateController
extends AbstractMessagingComponent {
    private volatile Template deleteCandidate = null;
    private volatile Template[] userTemplates = new Template[0];

    public DeleteTemplateController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        DeleteTemplateController$MyButtonListener deleteTemplateController$MyButtonListener = new DeleteTemplateController$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(-745398016).setButtonListener(deleteTemplateController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1200824576).setButtonListener(deleteTemplateController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-711843584).setButtonListener(deleteTemplateController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1133715712).setButtonListener(deleteTemplateController$MyButtonListener);
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new DeleteTemplateController$MyDsiMessagingListener(this, null));
    }

    public void setDeleteCandidate(Template template) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[DeleteTemplateController#setDeleteCandidate] template = %1", (Object)String.valueOf(template));
        }
        this.deleteCandidate = template;
    }

    private void setUserTemplates(Template[] templateArray) {
        this.log.log(-2137614336, "[DeleteTemplateController#setUserTemplates]");
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
        this.msgApp.getModelAccess().setOperationStateChoice(-1148051200, 0);
        new DeleteTemplateCommand(this.msgApp, nArray).schedule();
    }

    private void deleteSingleUserTemplateButton(int n, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[DeleteTemplateController#deleteSingleUserTemplateButton] modelID = %1, deleteCandidate = %2", (Object)String.valueOf(n), (Object)String.valueOf(this.deleteCandidate));
        }
        if (this.deleteCandidate == null || this.deleteCandidate.isReadOnly()) {
            this.log.log(-1601830656, "[DeleteTemplateController#deleteSingleUserTemplateButton] The current candidate for deletion cannot be deleted, ignoring call.");
        } else {
            this.deleteTemplateSelection(new int[]{this.deleteCandidate.getId()});
            this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
        }
    }

    private void deleteAllUserTemplatesButton(int n, int n2) {
        this.log.log(1078071040, "[DeleteTemplateController#deleteAllUserTemplatesButton] modelID = %1", (long)n);
        this.deleteAllUserTemplates();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ void access$200(DeleteTemplateController deleteTemplateController, int n, int n2) {
        deleteTemplateController.deleteSingleUserTemplateButton(n, n2);
    }

    static /* synthetic */ void access$300(DeleteTemplateController deleteTemplateController, int n, int n2) {
        deleteTemplateController.deleteAllUserTemplatesButton(n, n2);
    }

    static /* synthetic */ LogChannel access$400(DeleteTemplateController deleteTemplateController) {
        return deleteTemplateController.log;
    }

    static /* synthetic */ LogChannel access$500(DeleteTemplateController deleteTemplateController) {
        return deleteTemplateController.log;
    }

    static /* synthetic */ void access$600(DeleteTemplateController deleteTemplateController, Template[] templateArray) {
        deleteTemplateController.setUserTemplates(templateArray);
    }
}

