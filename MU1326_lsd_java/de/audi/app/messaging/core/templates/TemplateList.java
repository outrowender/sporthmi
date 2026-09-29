/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.templates.GetTemplatesCommand;
import de.audi.app.messaging.core.templates.ITemplatePropertyFactory;
import de.audi.app.messaging.core.templates.ITemplatePropertyFactory$NullFactory;
import de.audi.app.messaging.core.templates.TemplateList$1;
import de.audi.app.messaging.core.templates.TemplateList$CoreActionProxy;
import de.audi.app.messaging.core.templates.TemplateList$DiagPlugIn;
import de.audi.app.messaging.core.templates.TemplateList$MyButtonListener;
import de.audi.app.messaging.core.templates.TemplateList$MyI18NTarget;
import de.audi.app.messaging.core.templates.TemplateList$SettingsManagerObserver;
import de.audi.app.messaging.core.templates.TemplateListRow;
import de.audi.app.messaging.core.templates.TemplateListRow$LegacyListRow;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Dictionary;
import org.dsi.ifc.messaging.Template;

public final class TemplateList
extends AbstractMessagingComponent
implements ListListener,
IDiagProvider {
    public static final int USE_TEMPLATE_MODE_PREPEND_TO_QUOTE;
    public static final int USE_TEMPLATE_MODE_INSERT;
    static final int MAX_FIXED_TEMPLATES;
    static final int MAX_USER_TEMPLATES;
    private static final int MAX_TEMPLATES;
    private final ListModelApp listModel;
    private boolean hasData = false;
    private boolean isReplaceMode = false;
    private int useTemplateMode = 0;
    private Template[] userTemplates = new Template[0];
    private Template[] fixedTemplates = new Template[0];
    private boolean isUserTemplateSelected = false;
    private int selectedUserTemplateId = 0;
    private volatile ITemplatePropertyFactory templatePropertyFactory = new ITemplatePropertyFactory$NullFactory();
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    public TemplateList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getListModel(-1248648960);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.initFixedTemplates();
        this.listModel.setMaxColumns(5);
        this.listModel.setMaxRows(20);
        this.listModel.setListListener(this);
        this.framework.getHmiServiceApp().getButtonModel(-946724608).setButtonListener(new TemplateList$MyButtonListener(this, null));
        abstractMsgApplication.getSettingsManager().addObserver(new TemplateList$SettingsManagerObserver(this, null));
        abstractMsgApplication.getActionProxyService().addSubscriber(new TemplateList$CoreActionProxy(this, null));
        this.refresh();
        abstractMsgApplication.getDsiMessagingAccess().addDsiAccessClient(new TemplateList$1(this));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            Dictionary dictionary = ServiceProperties.createServiceProperties();
            dictionary.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
            iServiceRegistry.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = TemplateList.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)new TemplateList$MyI18NTarget(this, null), dictionary);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[TemplateList#connect]");
        }
    }

    public void setTemplatePropertyFactory(ITemplatePropertyFactory iTemplatePropertyFactory) {
        this.log.log(-2137614336, "[TemplateList#setTemplatePropertyFactory] templatePropertyFactory = %1", (Object)iTemplatePropertyFactory);
        this.templatePropertyFactory = iTemplatePropertyFactory;
        this.refresh();
    }

    public ITemplatePropertyFactory getTemplatePropertyFactory() {
        return this.templatePropertyFactory;
    }

    private void invalidateUserTemplates() {
        this.log.log(-2137614336, "[TemplateList#invalidateUserTemplates]");
        this.setUserTemplates(null);
        this.ensureTemplates();
    }

    public void setReplaceMode(boolean bl) {
        this.log.log(-2137614336, "[TemplateList#setReplaceMode] isReplaceMode = %1", bl);
        this.isReplaceMode = bl;
        this.refresh();
    }

    public void setUseTemplateMode(int n) {
        this.log.log(-2137614336, "[TemplateList#setUseTemplateMode] useTemplateMode = %1", (long)n);
        this.useTemplateMode = n;
    }

    void loadTemplates() {
        this.log.log(-2137614336, "[TemplateList#loadTemplates]");
        new GetTemplatesCommand(this.msgApp).schedule();
    }

    public void getTemplatesResponse(Template[] templateArray) {
        this.log.log(-2137614336, "[TemplateList#getTemplatesResponse]");
        this.setUserTemplates(templateArray);
    }

    private void setUserTemplates(Template[] templateArray) {
        this.log.log(-2137614336, "[TemplateList#setUserTemplates]");
        this.hasData = templateArray != null;
        this.userTemplates = templateArray != null ? templateArray : new Template[]{};
        this.checkSelectedUserTemplateValidity();
        int n = this.isSlotAvailable() ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(1989353728).setValue(n);
        this.refresh();
    }

    public void emptyTemplateSelected() {
        this.log.log(-2137614336, "[TemplateList#emptyTemplateSelected]");
        this.msgApp.getNewMessage().useTemplate("");
        this.setSelectedUserTemplate(false, 0);
    }

    public void setWaitSyncMediator(int n) {
        this.log.log(-2137614336, "[TemplateList#setWaitSyncStatus] mediatorState = %1", (long)n);
        this.msgApp.getModelAccess().setWaitSyncChoice(-1282268928, n);
    }

    public boolean isSlotAvailable() {
        return this.hasData && this.userTemplates.length < 10;
    }

    public int getTemplateCount() {
        return this.userTemplates.length + this.fixedTemplates.length;
    }

    public String toString() {
        Object[] objectArray = new Template[this.listModel.getLength()];
        for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
            objectArray[i2] = this.getTemplateListRow(i2).getTemplate();
        }
        Buffer buffer = new Buffer();
        buffer.append("TemplateList {list entries = ");
        buffer.append(Arrays.toMultiLineString(objectArray));
        buffer.append('}');
        return buffer.toString();
    }

    private void useTemplate(Template template) {
        this.log.log(-2137614336, "[TemplateList#useTemplate]");
        boolean bl = this.isFixedTemplate(template);
        boolean bl2 = !bl;
        int n = bl2 ? template.getId() : 0;
        this.setSelectedUserTemplate(bl2, n);
        if (this.useTemplateMode == 1) {
            this.msgApp.getNewMessage().insertBodyText(template.getBody());
        } else {
            this.msgApp.getNewMessage().useTemplate(template.getBody());
        }
    }

    private void refresh() {
        TemplateListRow templateListRow;
        Template template;
        int n;
        this.log.log(-2137614336, "[TemplateList#refresh]");
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.listModel);
        this.listModel.clear();
        for (n = 0; n < this.userTemplates.length; ++n) {
            template = this.userTemplates[n];
            if (this.isReplaceMode && template.isReadOnly()) continue;
            templateListRow = new TemplateListRow(template, n, this.templatePropertyFactory);
            this.listModel.addRow(templateListRow.asLegacyListRow());
        }
        for (n = 0; n < this.fixedTemplates.length; ++n) {
            template = this.fixedTemplates[n];
            if (this.isReplaceMode && template.isReadOnly()) continue;
            templateListRow = new TemplateListRow(template, n, this.templatePropertyFactory);
            this.listModel.addRow(templateListRow.asLegacyListRow());
        }
        modelGroup.flush();
        modelGroup.removeAll();
    }

    private void initFixedTemplates() {
        this.fixedTemplates = new Template[]{new Template(-1, new StringBuffer().append(this.getFixedTemplateText(-1)).append(" ").toString(), true), new Template(-2, new StringBuffer().append(this.getFixedTemplateText(-2)).append(" ").toString(), true), new Template(-3, new StringBuffer().append(this.getFixedTemplateText(-3)).append(" ").toString(), true), new Template(-4, new StringBuffer().append(this.getFixedTemplateText(-4)).append(" ").toString(), true), new Template(-5, new StringBuffer().append(this.getFixedTemplateText(-5)).append(" ").toString(), true), new Template(-6, new StringBuffer().append(this.getFixedTemplateText(-6)).append(" ").toString(), true), new Template(-7, new StringBuffer().append(this.getFixedTemplateText(-7)).append(" ").toString(), true), new Template(-8, new StringBuffer().append(this.getFixedTemplateText(-8)).append(" ").toString(), true), new Template(-9, new StringBuffer().append(this.getFixedTemplateText(-9)).append(" ").toString(), true), new Template(-10, new StringBuffer().append(this.getFixedTemplateText(-10)).append(" ").toString(), true)};
    }

    private void ensureTemplates() {
        this.log.log(-2137614336, "[TemplateList#ensureTemplates] hasData = %1, need to request templates: %2", this.hasData, !this.hasData);
        if (!this.hasData) {
            this.loadTemplates();
        }
    }

    private void checkSelectedUserTemplateValidity() {
        if (this.isUserTemplateSelected) {
            boolean bl = true;
            for (int i2 = 0; i2 < this.userTemplates.length; ++i2) {
                if (this.userTemplates[i2].getId() != this.selectedUserTemplateId) continue;
                bl = false;
                break;
            }
            if (bl) {
                this.log.log(-2137614336, "[TemplateList#ensureSelectedUserTemplateValid] Selected user-defined template has been removed.");
                this.setSelectedUserTemplate(false, 0);
            }
        }
    }

    private boolean isFixedTemplate(Template template) {
        return template.isReadOnly();
    }

    private String getFixedTemplateText(int n) {
        this.log.log(-2137614336, "TemplateList#getFixedTemplateText(): templateId: %1", (long)n);
        boolean bl = true;
        String string = "";
        ITextLookup iTextLookup = this.msgApp.getTextLookup();
        switch (n) {
            case -1: {
                string = iTextLookup.getTemplate1();
                break;
            }
            case -2: {
                string = iTextLookup.getTemplate2();
                break;
            }
            case -3: {
                string = iTextLookup.getTemplate3();
                break;
            }
            case -4: {
                string = iTextLookup.getTemplate4();
                break;
            }
            case -5: {
                string = iTextLookup.getTemplate5();
                break;
            }
            case -6: {
                string = iTextLookup.getTemplate6();
                break;
            }
            case -7: {
                string = iTextLookup.getTemplate7();
                break;
            }
            case -8: {
                string = iTextLookup.getTemplate8();
                break;
            }
            case -9: {
                string = iTextLookup.getTemplate9();
                break;
            }
            case -10: {
                string = iTextLookup.getTemplate10();
                break;
            }
            default: {
                bl = false;
            }
        }
        if (!bl) {
            this.log.log(10000, "[TemplateList#getFixedTemplateText] Invalid template ID.");
        }
        return string;
    }

    private TemplateListRow getTemplateListRow(int n) {
        return ((TemplateListRow$LegacyListRow)this.listModel.getRow(n)).asTemplateListRow();
    }

    public void setSelectedTemplateText(String string) {
        this.log.log(-2137614336, "[TemplateList#setSelectedTemplateText] template = %1", (Object)string);
        this.framework.getHmiServiceApp().getLabelModel(328409344).setText(string);
    }

    public void setSelectedUserTemplate(boolean bl, int n) {
        this.log.log(-2137614336, "[TemplateList#setSelectedUserTemplate] isUserTemplateSelected = %1,  templateId = %2", bl, (long)n);
        this.isUserTemplateSelected = bl;
        this.selectedUserTemplateId = n;
        int n2 = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2073174272).setValue(n2);
    }

    public Template getSelectedUserTemplate() {
        this.log.log(-2137614336, "[TemplateList#getSelectedUserTemplate] isUserTemplateSelected = %1,  templateId = %2", this.isUserTemplateSelected, (long)this.selectedUserTemplateId);
        Template template = null;
        if (this.isUserTemplateSelected) {
            for (int i2 = 0; i2 < this.userTemplates.length; ++i2) {
                if (this.userTemplates[i2].getId() != this.selectedUserTemplateId) continue;
                template = this.userTemplates[i2];
            }
        }
        return template;
    }

    private void applyEmptyTemplateButton(int n, int n2) {
        this.log.log(1078071040, "[TemplateList#applyEmptyTemplateButton]");
        this.emptyTemplateSelected();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void setFocusedRow(int n) {
        this.log.log(-2137614336, "[TemplateList#setFocusedRow] rowIndex = %1", (long)n);
        Template template = this.getTemplateListRow(n).getTemplate();
        this.msgApp.getNewMessage().getDeleteTemplateController().setDeleteCandidate(template);
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        Template template = this.getTemplateListRow(n2).getTemplate();
        if (template == null) {
            this.log.log(10000, "[TemplateList#itemSelected] could not determine selected template for modelID %1 and row %2", (long)n, (long)n2);
            return;
        }
        this.setSelectedTemplateText(template.getBody());
        this.setFocusedRow(n2);
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TemplateList#itemSelected] template = %1", (Object)String.valueOf(template));
        }
        if (this.isReplaceMode) {
            long l = this.msgApp.getUniqueIdDispenser().getNextId();
            String string = this.msgApp.getNewMessage().getTruncatedBody();
            this.msgApp.getNewMessage().getSaveTemplateController().requestSaveTemplate(l, string, template);
        } else {
            this.useTemplate(template);
        }
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n4);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.log.log(1078071040, "[TemplateList#itemFocused] row = %1", (long)n2);
        this.setFocusedRow(n2);
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new TemplateList$DiagPlugIn(this)};
    }

    static /* synthetic */ LogChannel access$300(TemplateList templateList) {
        return templateList.log;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$500(TemplateList templateList, int n, int n2) {
        templateList.applyEmptyTemplateButton(n, n2);
    }

    static /* synthetic */ LogChannel access$600(TemplateList templateList) {
        return templateList.log;
    }

    static /* synthetic */ LogChannel access$700(TemplateList templateList) {
        return templateList.log;
    }

    static /* synthetic */ LogChannel access$800(TemplateList templateList) {
        return templateList.log;
    }

    static /* synthetic */ LogChannel access$900(TemplateList templateList) {
        return templateList.log;
    }

    static /* synthetic */ void access$1000(TemplateList templateList) {
        templateList.initFixedTemplates();
    }

    static /* synthetic */ void access$1100(TemplateList templateList) {
        templateList.refresh();
    }

    static /* synthetic */ LogChannel access$1200(TemplateList templateList) {
        return templateList.log;
    }

    static /* synthetic */ void access$1300(TemplateList templateList) {
        templateList.invalidateUserTemplates();
    }
}

