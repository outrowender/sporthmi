/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.templates.SaveTemplateController;
import de.audi.app.messaging.evo.templates.TemplateCreator$MyBaseListModelListener;
import de.audi.app.messaging.evo.templates.TemplateCreator$MyButtonListener;
import de.audi.app.messaging.evo.templates.TemplateCreator$MyDsiMessagingListener;
import de.audi.app.messaging.evo.templates.TemplateCreator$MySpellerListener;
import de.audi.app.messaging.evo.templates.TemplateCreator$SaveTemplateControllerObserver;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.Template;

public final class TemplateCreator
extends AbstractMessagingComponent {
    private final BaseListModelApp listModel = this.framework.getHmiServiceApp().getBaseListModel(1972576512);
    private final SpellerModelApp spellerModel = this.framework.getHmiServiceApp().getSpellerModel(1955799296);
    private final ChoiceModelApp isExistingTemplate = this.framework.getHmiServiceApp().getChoiceModel(-1701633792);
    private volatile Template currentTemplate = null;

    public TemplateCreator(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(new TemplateCreator$MyBaseListModelListener(this, null));
        abstractMsgApplication.getModelAccess().initSpellerModel(this.spellerModel.getID(), 1, 256);
        this.spellerModel.setSpellerListener(new TemplateCreator$MySpellerListener(this, null));
        TemplateCreator$MyButtonListener templateCreator$MyButtonListener = new TemplateCreator$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(1939022080).setButtonListener(templateCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1922244864).setButtonListener(templateCreator$MyButtonListener);
        abstractMsgApplication.getNewMessage().getSaveTemplateController().addObserver(new TemplateCreator$SaveTemplateControllerObserver(this, null));
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new TemplateCreator$MyDsiMessagingListener(this, null));
    }

    private void setCurrentTemplate(Template template) {
        if (this.log.isDebug()) {
            this.log.log(-2137614336, "[TemplateCreator#setCurrentTemplate] template = %1", (Object)String.valueOf(template));
        }
        this.currentTemplate = template;
        if (this.currentTemplate == null) {
            this.spellerModel.clear();
            this.isExistingTemplate.setValue(0);
        } else {
            this.spellerModel.setText(template.getBody());
            this.isExistingTemplate.setValue(1);
        }
    }

    private Template getCurrentTemplate() {
        return this.currentTemplate;
    }

    private void createTemplateNewButton(int n, int n2) {
        this.log.log(1078071040, "[TemplateCreator#createTemplateNewButton]");
        this.setCurrentTemplate(null);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void createTemplateSaveButton(int n, int n2) {
        this.log.log(1078071040, "[TemplateCreator#createTemplateSaveButton]");
        long l = this.msgApp.getUniqueIdDispenser().getNextId();
        String string = this.spellerModel.getText();
        SaveTemplateController saveTemplateController = this.msgApp.getNewMessage().getSaveTemplateController();
        saveTemplateController.requestSaveTemplate(l, string, this.getCurrentTemplate());
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ void access$500(TemplateCreator templateCreator, int n, int n2) {
        templateCreator.createTemplateNewButton(n, n2);
    }

    static /* synthetic */ void access$600(TemplateCreator templateCreator, int n, int n2) {
        templateCreator.createTemplateSaveButton(n, n2);
    }

    static /* synthetic */ LogChannel access$700(TemplateCreator templateCreator) {
        return templateCreator.log;
    }

    static /* synthetic */ LogChannel access$800(TemplateCreator templateCreator) {
        return templateCreator.log;
    }

    static /* synthetic */ void access$900(TemplateCreator templateCreator, Template template) {
        templateCreator.setCurrentTemplate(template);
    }

    static /* synthetic */ IFrameworkAccess access$1000(TemplateCreator templateCreator) {
        return templateCreator.framework;
    }

    static /* synthetic */ LogChannel access$1100(TemplateCreator templateCreator) {
        return templateCreator.log;
    }

    static /* synthetic */ AbstractMsgApplication access$1200(TemplateCreator templateCreator) {
        return templateCreator.msgApp;
    }

    static /* synthetic */ LogChannel access$1300(TemplateCreator templateCreator) {
        return templateCreator.log;
    }

    static /* synthetic */ SpellerModelApp access$1400(TemplateCreator templateCreator) {
        return templateCreator.spellerModel;
    }

    static /* synthetic */ LogChannel access$1500(TemplateCreator templateCreator) {
        return templateCreator.log;
    }

    static /* synthetic */ LogChannel access$1600(TemplateCreator templateCreator) {
        return templateCreator.log;
    }

    static /* synthetic */ LogChannel access$1700(TemplateCreator templateCreator) {
        return templateCreator.log;
    }

    static /* synthetic */ AbstractMsgApplication access$1800(TemplateCreator templateCreator) {
        return templateCreator.msgApp;
    }

    static /* synthetic */ BaseListModelApp access$1900(TemplateCreator templateCreator) {
        return templateCreator.listModel;
    }
}

