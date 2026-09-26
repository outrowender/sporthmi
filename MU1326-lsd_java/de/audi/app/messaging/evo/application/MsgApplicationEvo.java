/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.application;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.compose.AbstractOrganizerSearch;
import de.audi.app.messaging.core.compose.RecipientSearch;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearch;
import de.audi.app.messaging.core.guide.AbstractActionProxyService;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.search.MessagingSearch;
import de.audi.app.messaging.core.templates.ITemplatePropertyFactory;
import de.audi.app.messaging.evo.accounts.AccountListSubMenu;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController;
import de.audi.app.messaging.evo.cluster.ClusterMenuController;
import de.audi.app.messaging.evo.compose.DiscardDraftController;
import de.audi.app.messaging.evo.compose.EditorModeController;
import de.audi.app.messaging.evo.compose.MessageLengthPopup;
import de.audi.app.messaging.evo.compose.NewMessagePropertyFactoryEvo;
import de.audi.app.messaging.evo.compose.OrganizerSearchEvo;
import de.audi.app.messaging.evo.compose.SpeedThresholdPopup;
import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog;
import de.audi.app.messaging.evo.devicerole.DeviceRoleManagerEvo;
import de.audi.app.messaging.evo.folderbrowsing.EntryListRowDataFactoryEvo;
import de.audi.app.messaging.evo.folderbrowsing.EntryPropertyFactoryEvo;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService;
import de.audi.app.messaging.evo.folderbrowsing.FolderPathDisplay;
import de.audi.app.messaging.evo.guide.EvoActionProxyService;
import de.audi.app.messaging.evo.guide.TextLookupEvo;
import de.audi.app.messaging.evo.indication.PhoneIndicationController;
import de.audi.app.messaging.evo.readout.EvoReadableProvider;
import de.audi.app.messaging.evo.settings.SmscNumberController;
import de.audi.app.messaging.evo.statusbar.StatusBarManager;
import de.audi.app.messaging.evo.templates.TemplateCreator;
import de.audi.app.messaging.evo.templates.TemplatePropertyFactoryEvo;
import de.audi.app.messaging.evo.viewmessage.MessagePropertyFactoryEvo;
import de.audi.app.messaging.evo.viewmessage.SpeedViewingRestriction;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModelApp;

public final class MsgApplicationEvo
extends AbstractMsgApplication {
    private final EntryPropertyFactoryEvo entryPropertyFactoryEvo;
    private final MessagePropertyFactoryEvo messagePropertyFactoryEvo;
    private final ITemplatePropertyFactory templatePropertyFactoryEvo;
    private final AccountListSubMenu smsAccountListSubMenu;
    private final AccountListSubMenu emailAccountListSubMenu;
    private final FolderContentSearch folderContentSearch;
    private final EvoReadableProvider evoReadableProvider;
    private final NewMessageIndicationManager newMessageIndicationManager;

    public MsgApplicationEvo(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext);
        this.entryPropertyFactoryEvo = new EntryPropertyFactoryEvo(messagingBundleContext);
        this.addComponent(this.entryPropertyFactoryEvo);
        this.messagePropertyFactoryEvo = new MessagePropertyFactoryEvo(messagingBundleContext);
        this.addComponent(this.messagePropertyFactoryEvo);
        this.templatePropertyFactoryEvo = new TemplatePropertyFactoryEvo();
        this.setEntryListRowDataFactory(new EntryListRowDataFactoryEvo());
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        BaseListModelApp baseListModelApp = iHMIServiceApp.getBaseListModel(93528320);
        BaseListModelApp baseListModelApp2 = iHMIServiceApp.getBaseListModel(76751104);
        this.smsAccountListSubMenu = new AccountListSubMenu(messagingBundleContext, baseListModelApp, "SMS", false);
        this.emailAccountListSubMenu = new AccountListSubMenu(messagingBundleContext, baseListModelApp2, "E-Mail", false);
        this.addComponent(this.smsAccountListSubMenu);
        this.addComponent(this.emailAccountListSubMenu);
        this.addComponent(new FolderPathDisplay(messagingBundleContext));
        this.addComponent(new FolderBrowsingService(messagingBundleContext));
        this.addComponent(new PhoneIndicationController(messagingBundleContext));
        this.addComponent(new PhoneRingMenuController(messagingBundleContext));
        this.addComponent(new ClusterMenuController(messagingBundleContext));
        MessagingSearch messagingSearch = null;
        RecipientSearch recipientSearch = null;
        if (this.framework.getSysConst(4249) == 1) {
            messagingSearch = new MessagingSearch(messagingBundleContext);
            this.addComponent(messagingSearch);
            recipientSearch = new RecipientSearch(messagingBundleContext, messagingSearch);
            this.addComponent(recipientSearch);
            this.folderContentSearch = new FolderContentSearch(messagingBundleContext, messagingSearch);
            this.addComponent(this.folderContentSearch);
        } else {
            this.folderContentSearch = null;
        }
        RecipientSearchSpeller recipientSearchSpeller = new RecipientSearchSpeller(messagingBundleContext, recipientSearch);
        this.addComponent(recipientSearchSpeller);
        if (this.framework.getSysConst(4368) == 1) {
            this.addComponent(new SpeedViewingRestriction(messagingBundleContext));
        }
        this.addComponent(new DeleteSimMessagesDialog(messagingBundleContext));
        this.addComponent(new StatusBarManager(messagingBundleContext));
        this.evoReadableProvider = new EvoReadableProvider(messagingBundleContext);
        this.addComponent(this.evoReadableProvider);
        this.addComponent(new DiscardDraftController(messagingBundleContext));
        this.addComponent(new EditorModeController(messagingBundleContext));
        this.addComponent(new SpeedThresholdPopup(messagingBundleContext));
        this.addComponent(new MessageLengthPopup(messagingBundleContext));
        this.addComponent(new TemplateCreator(messagingBundleContext));
        this.addComponent(new SmscNumberController(messagingBundleContext));
        this.addComponent(new DeviceRoleManagerEvo(messagingBundleContext));
        this.newMessageIndicationManager = new NewMessageIndicationManager(messagingBundleContext);
        this.addComponent(this.newMessageIndicationManager);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.smsAccountListSubMenu.associate(this.getAccountManager().getSmsAccountList());
        this.emailAccountListSubMenu.associate(this.getAccountManager().getEmailAccountList());
        this.getEntryList().setEntryPropertyFactory(this.entryPropertyFactoryEvo);
        this.getMessageOptionsManager().setMessagePropertyFactory(this.messagePropertyFactoryEvo);
        this.getTemplateList().setTemplatePropertyFactory(this.templatePropertyFactoryEvo);
        this.getNewMessage().setPropertyFactory(new NewMessagePropertyFactoryEvo());
        this.getNewMessage().getMessageCreator().setAttachmentDownloadMode(2);
        this.getNewMessage().getSaveDraftController().setAutoSavePolicy(true);
        if (this.folderContentSearch != null) {
            this.folderContentSearch.setEntryPropertyFactory(this.entryPropertyFactoryEvo);
        }
        this.getMessageReader().setReadableProvider(this.evoReadableProvider);
    }

    @Override
    protected AbstractActionProxyService createActionProxyService(MessagingBundleContext messagingBundleContext) {
        return new EvoActionProxyService(messagingBundleContext);
    }

    @Override
    protected ITextLookup createTextLookup(MessagingBundleContext messagingBundleContext) {
        return new TextLookupEvo(messagingBundleContext);
    }

    @Override
    protected AbstractOrganizerSearch createOrganizerSearch(MessagingBundleContext messagingBundleContext) {
        return new OrganizerSearchEvo(messagingBundleContext, this.getMessagingAdbHandler());
    }

    @Override
    public NewMessageIndicationManager getNewMessageIndicationManager() {
        return this.newMessageIndicationManager;
    }
}

