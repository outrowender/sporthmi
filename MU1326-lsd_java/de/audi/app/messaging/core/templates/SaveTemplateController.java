/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.templates.ChangeTemplateCommand;
import de.audi.app.messaging.core.templates.ChangeTemplateCommand$ResultHandler;
import de.audi.app.messaging.core.templates.ISaveTemplateControllerObserver;
import de.audi.app.messaging.core.templates.SaveTemplateController$1;
import de.audi.app.messaging.core.templates.SaveTemplateController$MyButtonListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import org.dsi.ifc.messaging.Template;

public final class SaveTemplateController
extends AbstractMessagingComponent {
    private static final int TEMPLATE_ID_NEW;
    private static final int SAVE_TEMPLATE_RESULT_OK;
    private static final int SAVE_TEMPLATE_RESULT_ERROR_GENERAL;
    private static final int SAVE_TEMPLATE_RESULT_ERROR_MEMORY_DEPLETED;
    private final CopyOnWriteArrayList saveTemplateControllerObservers = new CopyOnWriteArrayList();
    private final ChangeTemplateCommand$ResultHandler commandResultHandler = new SaveTemplateController$1(this);

    public SaveTemplateController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        SaveTemplateController$MyButtonListener saveTemplateController$MyButtonListener = new SaveTemplateController$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(-1533927168).setButtonListener(saveTemplateController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1066606848).setButtonListener(saveTemplateController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-544071424).setButtonListener(saveTemplateController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-1701699328).setButtonListener(saveTemplateController$MyButtonListener);
    }

    public void addObserver(ISaveTemplateControllerObserver iSaveTemplateControllerObserver) {
        this.log.log(-2137614336, "[SaveTemplateController#addObserver] observer = %1", (Object)iSaveTemplateControllerObserver);
        this.saveTemplateControllerObservers.add(iSaveTemplateControllerObserver);
    }

    private void setSaveTemplateState(int n, int n2, long l) {
        if (n != 0) {
            this.emitResponseSaveTemplate(l, n2 == 0);
        }
        this.framework.getHmiServiceApp().getChoiceModel(-376299264).setValue(n2);
        this.msgApp.getModelAccess().setOperationStateChoice(143859968, n);
    }

    public void requestSaveTemplate(long l, String string, Template template) {
        boolean bl;
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[SaveTemplateController#requestSaveTemplate] clientRequestId = %1, text = %2, template = %3", (Object)String.valueOf(l), (Object)String.valueOf(string), (Object)String.valueOf(template));
        }
        boolean bl2 = template == null;
        boolean bl3 = Strings.isNullOrEmpty(string);
        boolean bl4 = bl = bl2 && !this.msgApp.getTemplateList().isSlotAvailable();
        if (bl3 || bl) {
            if (bl3) {
                this.log.log(-1601830656, "[SaveTemplateController#requestSaveTemplate] Cannot save template: Message body is empty.");
            } else {
                this.log.log(-1601830656, "[SaveTemplateController#requestSaveTemplate] Cannot save template: No slot available.");
            }
            int n = bl3 ? 1 : 2;
            this.setSaveTemplateState(2, n, l);
        } else {
            int n = bl2 ? -1 : template.getId();
            this.setSaveTemplateState(0, 0, l);
            new ChangeTemplateCommand(this.msgApp, this.commandResultHandler, l, n, string).schedule();
        }
        if (bl2) {
            this.msgApp.getTemplateList().setReplaceMode(false);
        }
    }

    private void handleCommandResult(long l, boolean bl) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[SaveTemplateController#handleCommandResult] clientRequestId = %1, isResultOk = %2", (Object)String.valueOf(l), (Object)String.valueOf(bl));
        }
        int n = 3;
        int n2 = 1;
        if (bl) {
            n = 1;
            n2 = 0;
        } else {
            n = 2;
            n2 = 1;
        }
        this.setSaveTemplateState(n, n2, l);
        this.msgApp.getTemplateList().loadTemplates();
    }

    private void emitResponseSaveTemplate(long l, boolean bl) {
        this.log.log(-2137614336, "[SaveTemplateController#emitResponseSaveTemplate]");
        Iterator iterator = this.saveTemplateControllerObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((ISaveTemplateControllerObserver)iterator.next()).responseSaveTemplate(l, bl);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[SaveTemplateController#emitResponseSaveTemplate]");
            }
        }
    }

    private void saveAsTemplateButton(int n, int n2) {
        this.log.log(1078071040, "[SaveTemplateController#saveAsTemplateButton] modelID = %1", (long)n);
        if (!this.msgApp.getNewMessage().exceedsMaxBodyLength()) {
            long l = this.msgApp.getUniqueIdDispenser().getNextId();
            String string = this.msgApp.getNewMessage().getTruncatedBody();
            this.requestSaveTemplate(l, string, null);
        }
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void forceSaveAsTemplateButton(int n, int n2) {
        this.log.log(1078071040, "[SaveTemplateController#forceSaveAsTemplateButton]");
        long l = this.msgApp.getUniqueIdDispenser().getNextId();
        String string = this.msgApp.getNewMessage().getTruncatedBody();
        this.requestSaveTemplate(l, string, null);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void replaceTemplateButton(int n, int n2) {
        this.log.log(1078071040, "[SaveTemplateController#replaceTemplateButton]");
        this.msgApp.getTemplateList().setReplaceMode(true);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ void access$000(SaveTemplateController saveTemplateController, long l, boolean bl) {
        saveTemplateController.handleCommandResult(l, bl);
    }

    static /* synthetic */ void access$200(SaveTemplateController saveTemplateController, int n, int n2) {
        saveTemplateController.saveAsTemplateButton(n, n2);
    }

    static /* synthetic */ void access$300(SaveTemplateController saveTemplateController, int n, int n2) {
        saveTemplateController.forceSaveAsTemplateButton(n, n2);
    }

    static /* synthetic */ void access$400(SaveTemplateController saveTemplateController, int n, int n2) {
        saveTemplateController.replaceTemplateButton(n, n2);
    }

    static /* synthetic */ LogChannel access$500(SaveTemplateController saveTemplateController) {
        return saveTemplateController.log;
    }
}

