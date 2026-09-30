/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.templates.ISaveTemplateControllerObserver;
import de.audi.app.messaging.core.templates.ITemplatePropertyFactory;
import de.audi.app.messaging.core.templates.SaveTemplateController;
import de.audi.app.messaging.core.templates.TemplateListRow;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import org.dsi.ifc.messaging.Template;

public final class TemplateCreator
extends AbstractMessagingComponent {
    private final BaseListModelApp listModel = this.framework.getHmiServiceApp().getBaseListModel(2200437);
    private final SpellerModelApp spellerModel = this.framework.getHmiServiceApp().getSpellerModel(2200436);
    private final ChoiceModelApp isExistingTemplate = this.framework.getHmiServiceApp().getChoiceModel(2200474);
    private volatile Template currentTemplate = null;

    public TemplateCreator(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(new MyBaseListModelListener());
        abstractMsgApplication.getModelAccess().initSpellerModel(this.spellerModel.getID(), 1, 256);
        this.spellerModel.setSpellerListener(new MySpellerListener());
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200435).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200434).setButtonListener(myButtonListener);
        abstractMsgApplication.getNewMessage().getSaveTemplateController().addObserver(new SaveTemplateControllerObserver());
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
    }

    private void setCurrentTemplate(Template template) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TemplateCreator#setCurrentTemplate] template = %1", (Object)String.valueOf(template));
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
        this.log.log(1000000, "[TemplateCreator#createTemplateNewButton]");
        this.setCurrentTemplate(null);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void createTemplateSaveButton(int n, int n2) {
        this.log.log(1000000, "[TemplateCreator#createTemplateSaveButton]");
        long l = this.msgApp.getUniqueIdDispenser().getNextId();
        String string = this.spellerModel.getText();
        SaveTemplateController saveTemplateController = this.msgApp.getNewMessage().getSaveTemplateController();
        saveTemplateController.requestSaveTemplate(l, string, this.getCurrentTemplate());
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private final class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200435) {
                TemplateCreator.this.createTemplateNewButton(n, n3);
            } else if (n == 2200434) {
                TemplateCreator.this.createTemplateSaveButton(n, n3);
            } else {
                TemplateCreator.this.log.log(10000, "[TemplateCreator#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private class MySpellerListener
    extends DefaultSpellerListener {
        private MySpellerListener() {
        }

        public void textChanged(int n, String string, char c2, int n2) {
            TemplateCreator.this.log.log(10000000, "[TemplateCreator#textChanged] text = %1", (Object)string);
            TemplateCreator.this.spellerModel.setText(string);
        }
    }

    private class MyDsiMessagingListener
    extends DsiMessagingEmptyListener {
        private MyDsiMessagingListener() {
        }

        public void getTemplatesResponse(int n, Template[] templateArray) {
            TemplateCreator.this.log.log(10000000, "[TemplateCreator#getTemplatesResponse]");
            if (n == 0) {
                ITemplatePropertyFactory iTemplatePropertyFactory = TemplateCreator.this.msgApp.getTemplateList().getTemplatePropertyFactory();
                BaseListModelApp baseListModelApp = TemplateCreator.this.listModel.getCopy();
                baseListModelApp.removeAll();
                for (int i2 = 0; i2 < templateArray.length; ++i2) {
                    TemplateListRow templateListRow = new TemplateListRow(templateArray[i2], i2, iTemplatePropertyFactory);
                    baseListModelApp.append(templateListRow);
                }
                TemplateCreator.this.listModel.update(baseListModelApp);
            }
        }
    }

    private final class MyBaseListModelListener
    extends DefaultBaseListModelListener {
        private MyBaseListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            TemplateCreator.this.log.log(1000000, "[TemplateCreator#itemSelected] row = %1", (Object)evoListRow);
            Template template = ((TemplateListRow)evoListRow).getTemplate();
            TemplateCreator.this.setCurrentTemplate(template);
            TemplateCreator.this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n4);
        }

        public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            TemplateCreator.this.log.log(1000000, "[TemplateCreator#itemFocused] row = %1", (Object)evoListRow);
            Template template = ((TemplateListRow)evoListRow).getTemplate();
            TemplateCreator.this.msgApp.getNewMessage().getDeleteTemplateController().setDeleteCandidate(template);
        }
    }

    private final class SaveTemplateControllerObserver
    extends ISaveTemplateControllerObserver.EmptyImplementation {
        private SaveTemplateControllerObserver() {
        }

        public void responseSaveTemplate(long l, boolean bl) {
            if (TemplateCreator.this.log.isDebug()) {
                TemplateCreator.this.log.log(10000000, "[TemplateCreator#responseSaveTemplate] clientRequestId = %1, isResultOk = %2", (Object)String.valueOf(l), (Object)String.valueOf(bl));
            }
        }
    }
}

