/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.INewMessageObserver;
import de.audi.app.messaging.core.compose.InterpretationGuessItem;
import de.audi.app.messaging.core.compose.RecipientSearch;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import org.dsi.ifc.messaging.MatchedAddress;

public final class RecipientSearchSpeller
extends AbstractMessagingComponent {
    private volatile SpellerModelApp spellerModel = this.framework.getHmiServiceApp().getSpellerModel(2200266);
    private final RecipientSearch recipientSearch;
    public volatile boolean isInEditorView = false;

    public RecipientSearchSpeller(MessagingBundleContext messagingBundleContext, RecipientSearch recipientSearch) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.recipientSearch = recipientSearch;
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        boolean bl = this.recipientSearch != null;
        this.spellerModel = bl ? this.recipientSearch.getSpellerModel() : this.framework.getHmiServiceApp().getSpellerModel(2200266);
        abstractMsgApplication.getModelAccess().initSpellerModel(this.spellerModel.getID(), 0, 254);
        this.clear();
        this.framework.getHmiServiceApp().getButtonModel(2200280).setButtonListener(new MyButtonListener());
        MySpellerListener mySpellerListener = new MySpellerListener();
        if (bl) {
            this.recipientSearch.addSpellerListener(mySpellerListener);
        } else {
            this.spellerModel.setSpellerListener(mySpellerListener);
        }
        abstractMsgApplication.getActionProxyService().addSubscriber(new CoreActionProxy());
        abstractMsgApplication.getNewMessage().addObserver(new MyNewMessageObserver());
    }

    public void clear() {
        this.log.log(10000000, "[RecipientSearchSpeller#clear]");
        this.spellerModel.clear();
        this.spellerModel.setControlButtonStates(-1, 0);
        this.msgApp.getInterpretationGuessItem().update("");
    }

    private void recipientSearchSpellerButton(int n, int n2) {
        this.log.log(10000000, "[RecipientSearchSpeller#recipientSearchSpellerButton]");
        if (this.recipientSearch != null && this.recipientSearch.getListLength() == 1) {
            this.log.log(10000000, "[RecipientSearch#keyTyped] Autoselecting the only search result");
            this.recipientSearch.selectListItem(0, n2);
        }
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void recipientSearchStringOkButton(int n, int n2) {
        this.log.log(1000000, "[RecipientSearchSpeller#recipientSearchStringOkButton]");
        String string = new InterpretationGuessItem(this.messagingBundleContext).get();
        MatchedAddress matchedAddress = MessageContacts.toMatchedAddress(string.trim());
        this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsTo(new MatchedAddress[]{matchedAddress});
        this.clear();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private final class CoreActionProxy
    extends DefaultCoreActionProxy
    implements IActionProxySubscriber {
        private CoreActionProxy() {
        }

        public void searchableViewTransition(int n, int n2, int n3) {
            RecipientSearchSpeller.this.log.log(10000000, "[RecipientSearchSpeller#searchableViewTransition]");
            if (n3 == 0 && n2 == 1) {
                RecipientSearchSpeller.this.isInEditorView = true;
            } else if (n3 == 1 && n2 == 1) {
                RecipientSearchSpeller.this.isInEditorView = false;
            }
        }
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200280) {
                RecipientSearchSpeller.this.recipientSearchStringOkButton(n, n3);
            } else {
                RecipientSearchSpeller.this.log.log(10000, "[RecipientSearchSpeller#keyTyped] Unexpected modelId = %1", (long)n);
            }
        }
    }

    private class MySpellerListener
    extends DefaultSpellerListener {
        private MySpellerListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200266) {
                RecipientSearchSpeller.this.recipientSearchSpellerButton(n, n3);
            } else {
                RecipientSearchSpeller.this.log.log(10000, "[RecipientSearchSpeller#keyTyped] Unexpected modelId = %1", (long)n);
            }
        }

        public void textChanged(int n, String string, char c2, int n2) {
            RecipientSearchSpeller.this.log.log(10000000, "[RecipientSearchSpeller#textChanged] text = %1", (Object)string);
            InterpretationGuessItem interpretationGuessItem = RecipientSearchSpeller.this.msgApp.getInterpretationGuessItem();
            interpretationGuessItem.update(string);
            boolean bl = interpretationGuessItem.isValid();
            int n3 = bl ? 0 : 1;
            RecipientSearchSpeller.this.spellerModel.setControlButtonStates(-1, n3);
            RecipientSearchSpeller.this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
        }

        public void commandPressed(int n, int n2, int n3) {
            RecipientSearchSpeller.this.log.log(1000000, "[RecipientSearchSpeller#commandPressed] index = %1", (long)n2);
            if (RecipientSearchSpeller.this.isInEditorView && n2 == 4711) {
                RecipientSearchSpeller.this.spellerModel.setSpellerInitiallyOpen(true);
                RecipientSearchSpeller.this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n3);
            } else {
                RecipientSearchSpeller.this.spellerModel.setSpellerInitiallyOpen(false);
            }
        }
    }

    private class MyNewMessageObserver
    extends INewMessageObserver.DefaultNewMessageObserver {
        private MyNewMessageObserver() {
        }

        public void messageCleared() {
            RecipientSearchSpeller.this.clear();
        }
    }
}

