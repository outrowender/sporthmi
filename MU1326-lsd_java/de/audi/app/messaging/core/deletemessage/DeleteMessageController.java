/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.deletemessage.DeleteMessageCommand;
import de.audi.app.messaging.core.deletemessage.DeleteMessageCommand$ResultHandler;
import de.audi.app.messaging.core.deletemessage.DeleteMessageController$1;
import de.audi.app.messaging.core.deletemessage.DeleteMessageController$2;
import de.audi.app.messaging.core.deletemessage.DeleteMessageController$MyButtonListener;
import de.audi.app.messaging.core.deletemessage.DeleteSimMessagesCommand;
import de.audi.app.messaging.core.deletemessage.DeleteSimMessagesCommand$Result;
import de.audi.app.messaging.core.deletemessage.IDeleteMessageControllerObserver;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import java.util.Iterator;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.messaging.MessagingAccount;

public final class DeleteMessageController
extends AbstractMessagingComponent {
    private final CopyOnWriteArrayList deleteMessageControllerObservers = new CopyOnWriteArrayList();
    private final DeleteMessageCommand$ResultHandler deleteMessageCallback = new DeleteMessageController$1(this);
    private final ICommandCallback deleteSimMessagesCallback = new DeleteMessageController$2(this);

    public DeleteMessageController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        DeleteMessageController$MyButtonListener deleteMessageController$MyButtonListener = new DeleteMessageController$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(1704075520).setButtonListener(deleteMessageController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1116938496).setButtonListener(deleteMessageController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1418928384).setButtonListener(deleteMessageController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1469260032).setButtonListener(deleteMessageController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1452482816).setButtonListener(deleteMessageController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1435705600).setButtonListener(deleteMessageController$MyButtonListener);
    }

    public void addObserver(IDeleteMessageControllerObserver iDeleteMessageControllerObserver) {
        this.log.log(-2137614336, "[DeleteMessageController#addObserver] observer = %1", (Object)iDeleteMessageControllerObserver);
        this.deleteMessageControllerObservers.add(iDeleteMessageControllerObserver);
    }

    public void deleteMessage(String string) {
        this.log.log(-2137614336, "[DeleteMessageController#deleteMessage] messageId = %1", (Object)String.valueOf(string));
        if (Strings.isNullOrEmpty(string)) {
            this.log.log(-1601830656, "[DeleteMessageController#deleteMessage] Cannot delete message: Message ID invalid.");
            this.setDeleteMessageState(2);
        } else {
            this.setDeleteMessageState(0);
            new DeleteMessageCommand(this.msgApp, this.deleteMessageCallback, new String[]{string}, true).schedule();
        }
    }

    public void deleteMessages(String[] stringArray) {
        this.log.log(-2137614336, "[DeleteMessageController#deleteMessage]");
        if (stringArray == null || stringArray.length < 1) {
            this.log.log(-1601830656, "[DeleteMessageController#deleteMessage] Cannot delete message: Message ID invalid.");
            this.setDeleteMessageState(2);
        } else {
            this.setDeleteMessageState(0);
            new DeleteMessageCommand(this.msgApp, this.deleteMessageCallback, stringArray, true).schedule();
        }
    }

    private void deleteFocusedMessage() {
        this.log.log(-2137614336, "[DeleteMessageController#deleteFocusedMessage]");
        String string = null;
        MessageListEntry messageListEntry = this.msgApp.getMessageOptionsManager().getFocusedMessageListEntry();
        if (messageListEntry != null) {
            string = messageListEntry.getMessageID();
        }
        this.deleteMessage(string);
    }

    private void handleDeleteMessageResult(int n) {
        this.log.log(-2137614336, "[DeleteMessageController#handleDeleteMessageResult] result = %1", (long)n);
        int n2 = 2;
        if (n == 0) {
            n2 = 1;
        }
        this.setDeleteMessageState(n2);
    }

    private void deleteSimMessages(int n) {
        try {
            if (this.log.isDebug()) {
                this.log.log(-2137614336, "[DeleteMessageController#deleteSimMessages] delFlag = %1", (long)n);
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
        this.log.log(-2137614336, "[DeleteMessageController#handleDeleteSimMessagesResult] command = %1", (Object)command);
        int n = 2;
        try {
            DeleteSimMessagesCommand deleteSimMessagesCommand = (DeleteSimMessagesCommand)command;
            DeleteSimMessagesCommand$Result deleteSimMessagesCommand$Result = (DeleteSimMessagesCommand$Result)deleteSimMessagesCommand.getResult();
            int n2 = deleteSimMessagesCommand$Result.getResultCode();
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
        this.log.log(-2137614336, "[DeleteMessageController#setDeleteMessageState] operationState = %1", (long)n);
        this.msgApp.getModelAccess().setOperationStateChoice(1720852736, n);
    }

    private void setDeleteSimMessagesState(int n) {
        this.log.log(-2137614336, "[DeleteMessageController#setDeleteSimMessagesState] operationState = %1", (long)n);
        this.msgApp.getModelAccess().setOperationStateChoice(1720852736, n);
        this.emitIndicateDeleteSimMessagesState(n);
    }

    public void emitIndicateDeleteSimMessagesState(int n) {
        this.log.log(-2137614336, "[DeleteMessageController#emitIndicateDeleteSimMessagesState]");
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
        this.log.log(1078071040, "[DeleteMessageController#deleteButton] modelID = %1", (long)n);
        this.deleteFocusedMessage();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimAllButton(int n, int n2) {
        this.log.log(1078071040, "[DeleteMessageController#deleteSimAllButton]");
        this.deleteSimMessages(4);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimInboxReadButton(int n, int n2) {
        this.log.log(1078071040, "[DeleteMessageController#deleteSimInboxReadButton]");
        this.deleteSimMessages(1);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimSentButton(int n, int n2) {
        this.log.log(1078071040, "[DeleteMessageController#deleteSimSentButton]");
        this.deleteSimMessages(2);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimOutboxButton(int n, int n2) {
        this.log.log(1078071040, "[DeleteMessageController#deleteSimOutboxButton]");
        this.deleteSimMessages(3);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ void access$000(DeleteMessageController deleteMessageController, int n) {
        deleteMessageController.handleDeleteMessageResult(n);
    }

    static /* synthetic */ void access$100(DeleteMessageController deleteMessageController, Command command) {
        deleteMessageController.handleDeleteSimMessagesResult(command);
    }

    static /* synthetic */ void access$300(DeleteMessageController deleteMessageController, int n, int n2) {
        deleteMessageController.deleteButton(n, n2);
    }

    static /* synthetic */ void access$400(DeleteMessageController deleteMessageController, int n, int n2) {
        deleteMessageController.deleteSimAllButton(n, n2);
    }

    static /* synthetic */ void access$500(DeleteMessageController deleteMessageController, int n, int n2) {
        deleteMessageController.deleteSimInboxReadButton(n, n2);
    }

    static /* synthetic */ void access$600(DeleteMessageController deleteMessageController, int n, int n2) {
        deleteMessageController.deleteSimSentButton(n, n2);
    }

    static /* synthetic */ void access$700(DeleteMessageController deleteMessageController, int n, int n2) {
        deleteMessageController.deleteSimOutboxButton(n, n2);
    }

    static /* synthetic */ LogChannel access$800(DeleteMessageController deleteMessageController) {
        return deleteMessageController.log;
    }
}

