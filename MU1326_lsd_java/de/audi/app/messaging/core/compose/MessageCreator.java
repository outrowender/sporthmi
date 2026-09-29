/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.MessageCreator$1;
import de.audi.app.messaging.core.compose.MessageCreator$2;
import de.audi.app.messaging.core.compose.MessageCreator$3;
import de.audi.app.messaging.core.compose.MessageCreator$MyBaseListModelListener;
import de.audi.app.messaging.core.compose.MessageCreator$MyButtonListener;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Messages;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.MessageListEntry;

public final class MessageCreator
extends AbstractMessagingComponent {
    private volatile int attachmentDownloadMode = 0;

    MessageCreator(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MessageCreator$MyButtonListener messageCreator$MyButtonListener = new MessageCreator$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(-1231871744).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1033052416).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1670521088).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1167270144).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-1416421120).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1184047360).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-1164762880).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-1315757824).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1217601792).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-1298980608).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1150492928).setButtonListener(messageCreator$MyButtonListener);
        this.framework.getHmiServiceApp().getBaseListModel(-124641024).setListener(new MessageCreator$MyBaseListModelListener(this, null));
    }

    public void setAttachmentDownloadMode(int n) {
        this.log.log(-2137614336, "[MessageCreator#setAttachmentDownloadMode] attachmentDownloadMode = %1", (long)n);
        this.attachmentDownloadMode = n;
    }

    public void composeNew() {
        this.log.log(-2137614336, "[MessageCreator#composeNew]");
        this.setCompositionMode(0);
        this.msgApp.getNewMessage().clear();
    }

    public void composeContinue() {
        this.log.log(-2137614336, "[MessageCreator#composeContinue]");
        this.setCompositionMode(1);
    }

    public void composeEdit() {
        this.log.log(-2137614336, "[MessageCreator#composeEdit]");
        this.setCompositionMode(2);
        MessageListEntry messageListEntry = this.msgApp.getMessageOptionsManager().getFocusedMessageListEntry();
        int n = this.computeAttachmentDownloadMode(messageListEntry);
        MessageCreator$1 messageCreator$1 = new MessageCreator$1(this);
        this.msgApp.getSelectedMessage().requestSetMessage(messageListEntry, n, messageCreator$1);
    }

    public void composeReply(boolean bl) {
        this.log.log(-2137614336, "[MessageCreator#composeReply] replyAll = %1", bl);
        this.setCompositionMode(bl ? 4 : 3);
        MessageListEntry messageListEntry = this.msgApp.getMessageOptionsManager().getFocusedMessageListEntry();
        MessageCreator$2 messageCreator$2 = new MessageCreator$2(this, bl);
        this.msgApp.getSelectedMessage().requestSetMessage(messageListEntry, 0, messageCreator$2);
    }

    public void composeForward() {
        this.log.log(-2137614336, "[MessageCreator#composeForward]");
        this.setCompositionMode(5);
        MessageListEntry messageListEntry = this.msgApp.getMessageOptionsManager().getFocusedMessageListEntry();
        int n = this.computeAttachmentDownloadMode(messageListEntry);
        MessageCreator$3 messageCreator$3 = new MessageCreator$3(this);
        this.msgApp.getSelectedMessage().requestSetMessage(messageListEntry, n, messageCreator$3);
    }

    private void setCompositionMode(int n) {
        this.log.log(-2137614336, "[MessageCreator#setCompositionMode] compositionMode = %1", (long)n);
        this.framework.getHmiServiceApp().getChoiceModel(1855136000).setValue(n);
    }

    private int computeAttachmentDownloadMode(MessageListEntry messageListEntry) {
        boolean bl = messageListEntry != null;
        boolean bl2 = bl && messageListEntry.getAttachmentSize() > 0;
        boolean bl3 = bl && Messages.isEmail(messageListEntry);
        return bl2 && bl3 ? this.attachmentDownloadMode : 0;
    }

    private void composeMsgBlankButton(int n, int n2) {
        this.log.log(1078071040, "[MessageCreator#composeMsgBlankButton] modelID = %1", (long)n);
        this.composeNew();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void composeMsgResumeButton(int n, int n2) {
        this.log.log(1078071040, "[MessageCreator#composeMsgResumeButton] modelID = %1", (long)n);
        this.composeContinue();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void replyButton(int n, int n2) {
        this.log.log(1078071040, "[MessageCreator#replyButton] modelID = %1", (long)n);
        this.composeReply(false);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void replyAllButton(int n, int n2) {
        this.log.log(1078071040, "[MessageCreator#replyAllButton]");
        this.composeReply(true);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void forwardButton(int n, int n2) {
        this.log.log(1078071040, "[MessageCreator#forwardButton] modelID = %1", (long)n);
        this.composeForward();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void editButton(int n, int n2) {
        this.log.log(1078071040, "[MessageCreator#editButton] modelID = %1", (long)n);
        this.composeEdit();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ AbstractMsgApplication access$200(MessageCreator messageCreator) {
        return messageCreator.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$300(MessageCreator messageCreator) {
        return messageCreator.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$400(MessageCreator messageCreator) {
        return messageCreator.msgApp;
    }

    static /* synthetic */ void access$500(MessageCreator messageCreator, int n, int n2) {
        messageCreator.composeMsgBlankButton(n, n2);
    }

    static /* synthetic */ void access$600(MessageCreator messageCreator, int n, int n2) {
        messageCreator.composeMsgResumeButton(n, n2);
    }

    static /* synthetic */ void access$700(MessageCreator messageCreator, int n, int n2) {
        messageCreator.replyButton(n, n2);
    }

    static /* synthetic */ void access$800(MessageCreator messageCreator, int n, int n2) {
        messageCreator.replyAllButton(n, n2);
    }

    static /* synthetic */ void access$900(MessageCreator messageCreator, int n, int n2) {
        messageCreator.forwardButton(n, n2);
    }

    static /* synthetic */ void access$1000(MessageCreator messageCreator, int n, int n2) {
        messageCreator.editButton(n, n2);
    }

    static /* synthetic */ LogChannel access$1100(MessageCreator messageCreator) {
        return messageCreator.log;
    }

    static /* synthetic */ LogChannel access$1200(MessageCreator messageCreator) {
        return messageCreator.log;
    }

    static /* synthetic */ AbstractMsgApplication access$1300(MessageCreator messageCreator) {
        return messageCreator.msgApp;
    }

    static /* synthetic */ IFrameworkAccess access$1400(MessageCreator messageCreator) {
        return messageCreator.framework;
    }
}

