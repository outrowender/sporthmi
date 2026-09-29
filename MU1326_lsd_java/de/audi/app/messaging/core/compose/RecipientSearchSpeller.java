/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.InterpretationGuessItem;
import de.audi.app.messaging.core.compose.RecipientSearch;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller$CoreActionProxy;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller$MyButtonListener;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller$MyNewMessageObserver;
import de.audi.app.messaging.core.compose.RecipientSearchSpeller$MySpellerListener;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.MatchedAddress;

public final class RecipientSearchSpeller
extends AbstractMessagingComponent {
    private volatile SpellerModelApp spellerModel = this.framework.getHmiServiceApp().getSpellerModel(-896392960);
    private final RecipientSearch recipientSearch;
    public volatile boolean isInEditorView = false;

    public RecipientSearchSpeller(MessagingBundleContext messagingBundleContext, RecipientSearch recipientSearch) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.recipientSearch = recipientSearch;
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        boolean bl = this.recipientSearch != null;
        this.spellerModel = bl ? this.recipientSearch.getSpellerModel() : this.framework.getHmiServiceApp().getSpellerModel(-896392960);
        abstractMsgApplication.getModelAccess().initSpellerModel(this.spellerModel.getID(), 0, 254);
        this.clear();
        this.framework.getHmiServiceApp().getButtonModel(-661511936).setButtonListener(new RecipientSearchSpeller$MyButtonListener(this, null));
        RecipientSearchSpeller$MySpellerListener recipientSearchSpeller$MySpellerListener = new RecipientSearchSpeller$MySpellerListener(this, null);
        if (bl) {
            this.recipientSearch.addSpellerListener(recipientSearchSpeller$MySpellerListener);
        } else {
            this.spellerModel.setSpellerListener(recipientSearchSpeller$MySpellerListener);
        }
        abstractMsgApplication.getActionProxyService().addSubscriber(new RecipientSearchSpeller$CoreActionProxy(this, null));
        abstractMsgApplication.getNewMessage().addObserver(new RecipientSearchSpeller$MyNewMessageObserver(this, null));
    }

    public void clear() {
        this.log.log(-2137614336, "[RecipientSearchSpeller#clear]");
        this.spellerModel.clear();
        this.spellerModel.setControlButtonStates(-1, 0);
        this.msgApp.getInterpretationGuessItem().update("");
    }

    private void recipientSearchSpellerButton(int n, int n2) {
        this.log.log(-2137614336, "[RecipientSearchSpeller#recipientSearchSpellerButton]");
        if (this.recipientSearch != null && this.recipientSearch.getListLength() == 1) {
            this.log.log(-2137614336, "[RecipientSearch#keyTyped] Autoselecting the only search result");
            this.recipientSearch.selectListItem(0, n2);
        }
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void recipientSearchStringOkButton(int n, int n2) {
        this.log.log(1078071040, "[RecipientSearchSpeller#recipientSearchStringOkButton]");
        String string = new InterpretationGuessItem(this.messagingBundleContext).get();
        MatchedAddress matchedAddress = MessageContacts.toMatchedAddress(string.trim());
        this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsTo(new MatchedAddress[]{matchedAddress});
        this.clear();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ void access$400(RecipientSearchSpeller recipientSearchSpeller, int n, int n2) {
        recipientSearchSpeller.recipientSearchStringOkButton(n, n2);
    }

    static /* synthetic */ LogChannel access$500(RecipientSearchSpeller recipientSearchSpeller) {
        return recipientSearchSpeller.log;
    }

    static /* synthetic */ void access$600(RecipientSearchSpeller recipientSearchSpeller, int n, int n2) {
        recipientSearchSpeller.recipientSearchSpellerButton(n, n2);
    }

    static /* synthetic */ LogChannel access$700(RecipientSearchSpeller recipientSearchSpeller) {
        return recipientSearchSpeller.log;
    }

    static /* synthetic */ LogChannel access$800(RecipientSearchSpeller recipientSearchSpeller) {
        return recipientSearchSpeller.log;
    }

    static /* synthetic */ AbstractMsgApplication access$900(RecipientSearchSpeller recipientSearchSpeller) {
        return recipientSearchSpeller.msgApp;
    }

    static /* synthetic */ SpellerModelApp access$1000(RecipientSearchSpeller recipientSearchSpeller) {
        return recipientSearchSpeller.spellerModel;
    }

    static /* synthetic */ IFrameworkAccess access$1100(RecipientSearchSpeller recipientSearchSpeller) {
        return recipientSearchSpeller.framework;
    }

    static /* synthetic */ LogChannel access$1200(RecipientSearchSpeller recipientSearchSpeller) {
        return recipientSearchSpeller.log;
    }

    static /* synthetic */ IFrameworkAccess access$1300(RecipientSearchSpeller recipientSearchSpeller) {
        return recipientSearchSpeller.framework;
    }

    static /* synthetic */ LogChannel access$1400(RecipientSearchSpeller recipientSearchSpeller) {
        return recipientSearchSpeller.log;
    }
}

