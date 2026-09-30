/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.INewMessageObserver;
import de.audi.app.messaging.core.compose.ISendMessageObserver;
import de.audi.app.messaging.core.compose.SendMessageCommand;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.guide.ModelAccess;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Maps;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.util.Util;
import de.audi.tghu.command.Command;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.RecipientList;

public final class SendMessageController
extends AbstractMessagingComponent {
    final int RESULT_CATEGORY_SENT_STORED;
    final int RESULT_CATEGORY_SENT_NOT_STORED;
    final int RESULT_CATEGORY_NOT_SENT_STORED;
    final int RESULT_CATEGORY_FAILURE;
    private static final int CHOICE_VALUE_ERROR_GENERAL = 0;
    private static final int CHOICE_VALUE_SENT_NOT_STORED = 1;
    private final ICommandCallback sendCommandCallback = new ICommandCallback(){

        public void terminating(Command command) {
            SendMessageController.this.handleSendMessageResult(command);
        }
    };
    private static volatile int nextSendRequestId = 0;
    private static volatile int lastSendRequestId = nextSendRequestId - 1;
    public final Map pendingRequestMap = new HashMap();
    private volatile boolean clearNewMessageOnSent = false;
    private CopyOnWriteArrayList sendMessageObservers = new CopyOnWriteArrayList();

    SendMessageController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.RESULT_CATEGORY_SENT_STORED = 0;
        this.RESULT_CATEGORY_SENT_NOT_STORED = 1;
        this.RESULT_CATEGORY_NOT_SENT_STORED = 2;
        this.RESULT_CATEGORY_FAILURE = 3;
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200231).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200531).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200271).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200496).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200384).setButtonListener(myButtonListener);
        abstractMsgApplication.getNewMessage().addObserver(new NewMessageObserver());
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void requestSend(MessageDetails messageDetails) {
        int n = 0;
        ModelAccess modelAccess = this.msgApp.getModelAccess();
        try {
            this.log.log(10000000, "[SendMessageController#requestSend] messageDetails = %1", (Object)messageDetails);
            if (messageDetails == null) {
                this.log.log(10000, "[SendMessageController#requestSend] Cannot send invalid message.");
                n = 2;
            } else {
                modelAccess.setOperationStateChoice(2200201, 0);
                lastSendRequestId = nextSendRequestId++;
                String string = messageDetails.getMessageStatus() == 2 ? messageDetails.getMessageID() : "";
                new SendMessageCommand(this.msgApp, this.sendCommandCallback, string, lastSendRequestId, messageDetails.getType(), new RecipientList(MessageContacts.getRawAddresses(messageDetails.getRecipientsTo()), MessageContacts.getRawAddresses(messageDetails.getRecipientsCc()), MessageContacts.getRawAddresses(messageDetails.getRecipientsBcc())), messageDetails.getSubject(), messageDetails.getBody(), messageDetails.getAttachments(), messageDetails.getMessagingAccountID()).schedule();
                n = 0;
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[SendMessageController#requestSend]");
            modelAccess.setOperationStateChoice(2200201, 3);
            n = 2;
        }
        finally {
            this.emitCurrentSendingStatus(n);
        }
    }

    public void setSendStateModelState(int n) {
        this.msgApp.getModelAccess().setOperationStateChoice(2200201, n);
    }

    private void handleSendMessageResult(Command command) {
        try {
            Object object;
            SendMessageCommand sendMessageCommand = (SendMessageCommand)command;
            int n = sendMessageCommand.getRequestId();
            String string = sendMessageCommand.getDraftId();
            RecipientList recipientList = sendMessageCommand.getRecipients();
            SendMessageCommand.Result result = (SendMessageCommand.Result)sendMessageCommand.getResult();
            int n2 = result.getResultCode();
            int[] nArray = result.getIndicationResultCodes();
            if (this.log.isInfo()) {
                object = new Buffer();
                ((Buffer)object).append("[SendMessageController#handleSendMessageResult] ");
                ((Buffer)object).append("requestId = ").append(n).append(", ");
                ((Buffer)object).append("draftId = ").append(string).append(", ");
                ((Buffer)object).append("result = ").append(n2).append(", ");
                ((Buffer)object).append("indicationResultCodes = ").append(Arrays.toString(nArray));
                this.log.log(1000000, ((Buffer)object).toString());
            }
            if (n2 == 0) {
                object = Strings.isNullOrEmpty(string) ? "" : string;
                this.putPendingRequest(n, (String)object);
                this.clearNewMessageOnSent = true;
                if (nArray == null) {
                    int n3 = MessageContacts.getRecipientCount(recipientList);
                    nArray = new int[n3];
                    for (int i2 = 0; i2 < n3; ++i2) {
                        nArray[i2] = 0;
                    }
                }
                this.indicateSendMessage(nArray, n);
            } else {
                this.emitCurrentSendingStatus(2);
                this.framework.getHmiServiceApp().getChoiceModel(2200200).setValue(0);
                this.msgApp.getModelAccess().setOperationStateChoice(2200201, 2);
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[SendMessageController#handleSendMessageResult]");
            this.msgApp.getModelAccess().setOperationStateChoice(2200201, 2);
        }
    }

    private void indicateSendMessage(int[] nArray, int n) {
        boolean bl;
        if (this.log.isInfo()) {
            this.log.log(1000000, "[SendMessageController#indicateSendMessage] requestId = %1, this.lastSendRequestId = %2, this.pendingRequestMap = %3", (Object)String.valueOf(n), (Object)String.valueOf(lastSendRequestId), (Object)this.pendingRequestMapToString());
        }
        String string = this.removePendingRequest(n);
        this.deleteAssociatedDraft(string, nArray);
        boolean bl2 = n == lastSendRequestId;
        boolean bl3 = bl = string != null;
        if (bl2 && bl) {
            boolean bl4;
            int n2 = this.toCombinedResultCategory(nArray);
            boolean bl5 = bl4 = n2 == 0 || n2 == 1;
            if (bl4 && this.clearNewMessageOnSent) {
                this.msgApp.getNewMessage().clear();
            }
            int n3 = 2;
            int n4 = 2;
            if (n2 == 0) {
                n3 = 1;
                n4 = 1;
            } else {
                int n5 = n2 == 1 ? 1 : 0;
                this.framework.getHmiServiceApp().getChoiceModel(2200200).setValue(n5);
                n4 = n5 == 1 ? 3 : n4;
            }
            this.emitCurrentSendingStatus(n4);
            this.msgApp.getModelAccess().setOperationStateChoice(2200201, n3);
        }
    }

    public synchronized void putPendingRequest(int n, String string) {
        this.pendingRequestMap.put(Util.createInteger(n), string);
    }

    public synchronized String removePendingRequest(int n) {
        return (String)this.pendingRequestMap.remove(Util.createInteger(n));
    }

    private synchronized String pendingRequestMapToString() {
        return Maps.toString(this.pendingRequestMap);
    }

    public void sendButton(int n, int n2) {
        this.log.log(1000000, "[SendMessageController#sendButton]");
        boolean bl = this.msgApp.getNewMessage().exceedsMaxBodyLength();
        if (!bl) {
            MessageDetails messageDetails = this.msgApp.getNewMessage().getTruncatedMessage().getMessageDetails();
            this.requestSend(messageDetails);
        }
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private int toResultCategory(int n) {
        int n2;
        switch (n) {
            case 0: 
            case 9: 
            case 12: {
                n2 = 0;
                break;
            }
            case 8: {
                n2 = 1;
                break;
            }
            case 11: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 3;
            }
        }
        return n2;
    }

    private int getErrorSeverity(int n) {
        int n2 = n == 0 ? 0 : (n == 1 ? 1 : (n == 2 ? 2 : 3));
        return n2;
    }

    private int toCombinedResultCategory(int[] nArray) {
        int n = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = this.toResultCategory(nArray[i2]);
            if (this.getErrorSeverity(n2) <= this.getErrorSeverity(n)) continue;
            n = n2;
        }
        return n;
    }

    private void deleteAssociatedDraft(String string, int[] nArray) {
        try {
            boolean bl;
            int n = this.toCombinedResultCategory(nArray);
            boolean bl2 = !Strings.isNullOrEmpty(string) && !"".equals(string);
            boolean bl3 = n == 0 || n == 1 || n == 2;
            boolean bl4 = bl = bl2 && bl3;
            if (this.log.isInfo()) {
                this.log.log(1000000, "[SendMessageController#deleteAssociatedDraft] draftId = %1, combinedResultCategory = %2, scheduling delete of draft: %3", (Object)String.valueOf(string), (Object)String.valueOf(n), (Object)String.valueOf(bl));
            }
            if (bl) {
                this.msgApp.getDeleteMessageController().deleteMessage(string);
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[SendMessageController#deleteAssociatedDraft]");
        }
    }

    private void forceSendButton(int n, int n2) {
        this.log.log(1000000, "[SendMessageController#forceSendButton]");
        MessageDetails messageDetails = this.msgApp.getNewMessage().getTruncatedMessage().getMessageDetails();
        this.requestSend(messageDetails);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void resendButton(int n, int n2) {
        this.log.log(1000000, "[SendMessageController#resendButton] modelID = %1", (long)n);
        MessageDetails messageDetails = this.msgApp.getSelectedMessage().getMessageDetails();
        this.requestSend(messageDetails);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    public void addObserver(ISendMessageObserver iSendMessageObserver) {
        this.log.log(10000000, "[SendMessageController#addObserver] observer = %1", (Object)iSendMessageObserver);
        this.sendMessageObservers.add(iSendMessageObserver);
    }

    public void emitCurrentSendingStatus(int n) {
        Iterator iterator = this.sendMessageObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((ISendMessageObserver)iterator.next()).indicateCurrentSendingStatus(n);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[SendMessage#emitMessageCleared]");
            }
        }
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200231 || n == 2200531) {
                SendMessageController.this.sendButton(n, n3);
            } else if (n == 2200271) {
                SendMessageController.this.forceSendButton(n, n3);
            } else if (n == 2200496 || n == 2200384) {
                SendMessageController.this.resendButton(n, n3);
            } else {
                SendMessageController.this.log.log(10000, "[SendMessageController#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private final class NewMessageObserver
    extends INewMessageObserver.DefaultNewMessageObserver {
        private NewMessageObserver() {
        }

        public void messageCleared() {
            SendMessageController.this.clearNewMessageOnSent = false;
        }
    }

    private class MyDsiMessagingListener
    extends DsiMessagingEmptyListener {
        private MyDsiMessagingListener() {
        }

        public final void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
            SendMessageController.this.indicateSendMessage(nArray, n);
        }
    }
}

