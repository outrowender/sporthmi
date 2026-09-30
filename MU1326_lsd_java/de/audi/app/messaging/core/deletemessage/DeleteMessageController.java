/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.deletemessage.DeleteMessageCommand;
import de.audi.app.messaging.core.deletemessage.DeleteSimMessagesCommand;
import de.audi.app.messaging.core.deletemessage.IDeleteMessageControllerObserver;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.command.Command;
import java.util.Iterator;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.messaging.MessagingAccount;

public final class DeleteMessageController
extends AbstractMessagingComponent {
    private final CopyOnWriteArrayList deleteMessageControllerObservers = new CopyOnWriteArrayList();
    private final DeleteMessageCommand.ResultHandler deleteMessageCallback = new DeleteMessageCommand.ResultHandler(){

        public void handleResult(int n) {
            DeleteMessageController.this.handleDeleteMessageResult(n);
        }
    };
    private final ICommandCallback deleteSimMessagesCallback = new ICommandCallback(){

        public void terminating(Command command) {
            DeleteMessageController.this.handleDeleteSimMessagesResult(command);
        }
    };

    public DeleteMessageController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200165).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200386).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200404).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200407).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200406).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200405).setButtonListener(myButtonListener);
    }

    public void addObserver(IDeleteMessageControllerObserver iDeleteMessageControllerObserver) {
        this.log.log(10000000, "[DeleteMessageController#addObserver] observer = %1", (Object)iDeleteMessageControllerObserver);
        this.deleteMessageControllerObservers.add(iDeleteMessageControllerObserver);
    }

    public void deleteMessage(String string) {
        this.log.log(10000000, "[DeleteMessageController#deleteMessage] messageId = %1", (Object)String.valueOf(string));
        if (Strings.isNullOrEmpty(string)) {
            this.log.log(100000, "[DeleteMessageController#deleteMessage] Cannot delete message: Message ID invalid.");
            this.setDeleteMessageState(2);
        } else {
            this.setDeleteMessageState(0);
            new DeleteMessageCommand(this.msgApp, this.deleteMessageCallback, new String[]{string}, true).schedule();
        }
    }

    public void deleteMessages(String[] stringArray) {
        this.log.log(10000000, "[DeleteMessageController#deleteMessage]");
        if (stringArray == null || stringArray.length < 1) {
            this.log.log(100000, "[DeleteMessageController#deleteMessage] Cannot delete message: Message ID invalid.");
            this.setDeleteMessageState(2);
        } else {
            this.setDeleteMessageState(0);
            new DeleteMessageCommand(this.msgApp, this.deleteMessageCallback, stringArray, true).schedule();
        }
    }

    private void deleteFocusedMessage() {
        this.log.log(10000000, "[DeleteMessageController#deleteFocusedMessage]");
        String string = null;
        MessageListEntry messageListEntry = this.msgApp.getMessageOptionsManager().getFocusedMessageListEntry();
        if (messageListEntry != null) {
            string = messageListEntry.getMessageID();
        }
        this.deleteMessage(string);
    }

    private void handleDeleteMessageResult(int n) {
        this.log.log(10000000, "[DeleteMessageController#handleDeleteMessageResult] result = %1", (long)n);
        int n2 = 2;
        if (n == 0) {
            n2 = 1;
        }
        this.setDeleteMessageState(n2);
    }

    private void deleteSimMessages(int n) {
        try {
            if (this.log.isDebug()) {
                this.log.log(10000000, "[DeleteMessageController#deleteSimMessages] delFlag = %1", (long)n);
            }
            int n2 = -1;
            NewMessageIndicationManager newMessageIndicationManager = this.msgApp.getNewMessageIndicationManager();
            if (newMessageIndicationManager.isSimMemoryDepleted()) {
                n2 = newMessageIndicationManager.getSimMemoryDepletedAccountId();
            } else {
                this.log.log(10000, "[DeleteMessageController#deleteSimMessages] No account with depleted SIM memory found. Trying currently selected account instead.");
                MessagingAccount messagingAccount = this.msgApp.getAccountManager().getSelectedAccount();
                if (messagingAccount == null) {
                    throw new IllegalStateException("No account selected.");
                }
                n2 = messagingAccount.getAccountID();
            }
            new DeleteSimMessagesCommand(this.msgApp, this.deleteSimMessagesCallback, n2, n).schedule();
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[DeleteMessageController#deleteSimMessages]");
            this.setDeleteSimMessagesState(2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleDeleteSimMessagesResult(Command command) {
        this.log.log(10000000, "[DeleteMessageController#handleDeleteSimMessagesResult] command = %1", (Object)command);
        int n = 2;
        try {
            DeleteSimMessagesCommand deleteSimMessagesCommand = (DeleteSimMessagesCommand)command;
            DeleteSimMessagesCommand.Result result = (DeleteSimMessagesCommand.Result)deleteSimMessagesCommand.getResult();
            int n2 = result.getResultCode();
            if (n2 == 0) {
                n = 1;
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[DeleteMessageController#handleDeleteSimMessagesResult]");
            n = 2;
        }
        finally {
            this.setDeleteSimMessagesState(n);
        }
    }

    private void setDeleteMessageState(int n) {
        this.log.log(10000000, "[DeleteMessageController#setDeleteMessageState] operationState = %1", (long)n);
        this.msgApp.getModelAccess().setOperationStateChoice(2200166, n);
    }

    private void setDeleteSimMessagesState(int n) {
        this.log.log(10000000, "[DeleteMessageController#setDeleteSimMessagesState] operationState = %1", (long)n);
        this.msgApp.getModelAccess().setOperationStateChoice(2200166, n);
        this.emitIndicateDeleteSimMessagesState(n);
    }

    public void emitIndicateDeleteSimMessagesState(int n) {
        this.log.log(10000000, "[DeleteMessageController#emitIndicateDeleteSimMessagesState]");
        Iterator iterator = this.deleteMessageControllerObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IDeleteMessageControllerObserver)iterator.next()).indicateDeleteSimMessagesState(n);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DeleteMessageController#emitIndicateDeleteSimMessagesState]");
            }
        }
    }

    private void deleteButton(int n, int n2) {
        this.log.log(1000000, "[DeleteMessageController#deleteButton] modelID = %1", (long)n);
        this.deleteFocusedMessage();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimAllButton(int n, int n2) {
        this.log.log(1000000, "[DeleteMessageController#deleteSimAllButton]");
        this.deleteSimMessages(4);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimInboxReadButton(int n, int n2) {
        this.log.log(1000000, "[DeleteMessageController#deleteSimInboxReadButton]");
        this.deleteSimMessages(1);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimSentButton(int n, int n2) {
        this.log.log(1000000, "[DeleteMessageController#deleteSimSentButton]");
        this.deleteSimMessages(2);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimOutboxButton(int n, int n2) {
        this.log.log(1000000, "[DeleteMessageController#deleteSimOutboxButton]");
        this.deleteSimMessages(3);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200165 || n == 2200386) {
                DeleteMessageController.this.deleteButton(n, n3);
            } else if (n == 2200404) {
                DeleteMessageController.this.deleteSimAllButton(n, n3);
            } else if (n == 2200407) {
                DeleteMessageController.this.deleteSimInboxReadButton(n, n3);
            } else if (n == 2200406) {
                DeleteMessageController.this.deleteSimSentButton(n, n3);
            } else if (n == 2200405) {
                DeleteMessageController.this.deleteSimOutboxButton(n, n3);
            } else {
                DeleteMessageController.this.log.log(10000, "[DeleteMessageController#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }
}

