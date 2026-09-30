/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.addressbook.AddressSelectionListRow;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Messages;
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;

public final class MessageCreator
extends AbstractMessagingComponent {
    private volatile int attachmentDownloadMode = 0;

    MessageCreator(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200502).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200381).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200163).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200389).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200491).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200390).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200506).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200497).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200392).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200498).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200388).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getBaseListModel(2200312).setListener(new MyBaseListModelListener());
    }

    public void setAttachmentDownloadMode(int n) {
        this.log.log(10000000, "[MessageCreator#setAttachmentDownloadMode] attachmentDownloadMode = %1", (long)n);
        this.attachmentDownloadMode = n;
    }

    public void composeNew() {
        this.log.log(10000000, "[MessageCreator#composeNew]");
        this.setCompositionMode(0);
        this.msgApp.getNewMessage().clear();
    }

    public void composeContinue() {
        this.log.log(10000000, "[MessageCreator#composeContinue]");
        this.setCompositionMode(1);
    }

    public void composeEdit() {
        this.log.log(10000000, "[MessageCreator#composeEdit]");
        this.setCompositionMode(2);
        MessageListEntry messageListEntry = this.msgApp.getMessageOptionsManager().getFocusedMessageListEntry();
        int n = this.computeAttachmentDownloadMode(messageListEntry);
        SelectedMessage.ISetMessageResultHandler iSetMessageResultHandler = new SelectedMessage.ISetMessageResultHandler(){

            public void responseSetMessage(boolean bl, MessageDetails messageDetails) {
                if (bl) {
                    MessageCreator.this.msgApp.getNewMessage().prepareEditMessage(messageDetails);
                }
            }
        };
        this.msgApp.getSelectedMessage().requestSetMessage(messageListEntry, n, iSetMessageResultHandler);
    }

    public void composeReply(final boolean bl) {
        this.log.log(10000000, "[MessageCreator#composeReply] replyAll = %1", bl);
        this.setCompositionMode(bl ? 4 : 3);
        MessageListEntry messageListEntry = this.msgApp.getMessageOptionsManager().getFocusedMessageListEntry();
        SelectedMessage.ISetMessageResultHandler iSetMessageResultHandler = new SelectedMessage.ISetMessageResultHandler(){

            public void responseSetMessage(boolean bl2, MessageDetails messageDetails) {
                if (bl2) {
                    MessageCreator.this.msgApp.getNewMessage().prepareReplyToMessage(messageDetails, bl);
                }
            }
        };
        this.msgApp.getSelectedMessage().requestSetMessage(messageListEntry, 0, iSetMessageResultHandler);
    }

    public void composeForward() {
        this.log.log(10000000, "[MessageCreator#composeForward]");
        this.setCompositionMode(5);
        MessageListEntry messageListEntry = this.msgApp.getMessageOptionsManager().getFocusedMessageListEntry();
        int n = this.computeAttachmentDownloadMode(messageListEntry);
        SelectedMessage.ISetMessageResultHandler iSetMessageResultHandler = new SelectedMessage.ISetMessageResultHandler(){

            public void responseSetMessage(boolean bl, MessageDetails messageDetails) {
                if (bl) {
                    MessageCreator.this.msgApp.getNewMessage().prepareForwardMessage(messageDetails);
                }
            }
        };
        this.msgApp.getSelectedMessage().requestSetMessage(messageListEntry, n, iSetMessageResultHandler);
    }

    private void setCompositionMode(int n) {
        this.log.log(10000000, "[MessageCreator#setCompositionMode] compositionMode = %1", (long)n);
        this.framework.getHmiServiceApp().getChoiceModel(2200430).setValue(n);
    }

    private int computeAttachmentDownloadMode(MessageListEntry messageListEntry) {
        boolean bl = messageListEntry != null;
        boolean bl2 = bl && messageListEntry.getAttachmentSize() > 0;
        boolean bl3 = bl && Messages.isEmail(messageListEntry);
        return bl2 && bl3 ? this.attachmentDownloadMode : 0;
    }

    private void composeMsgBlankButton(int n, int n2) {
        this.log.log(1000000, "[MessageCreator#composeMsgBlankButton] modelID = %1", (long)n);
        this.composeNew();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void composeMsgResumeButton(int n, int n2) {
        this.log.log(1000000, "[MessageCreator#composeMsgResumeButton] modelID = %1", (long)n);
        this.composeContinue();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void replyButton(int n, int n2) {
        this.log.log(1000000, "[MessageCreator#replyButton] modelID = %1", (long)n);
        this.composeReply(false);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void replyAllButton(int n, int n2) {
        this.log.log(1000000, "[MessageCreator#replyAllButton]");
        this.composeReply(true);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void forwardButton(int n, int n2) {
        this.log.log(1000000, "[MessageCreator#forwardButton] modelID = %1", (long)n);
        this.composeForward();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void editButton(int n, int n2) {
        this.log.log(1000000, "[MessageCreator#editButton] modelID = %1", (long)n);
        this.composeEdit();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200502 || n == 2200381) {
                MessageCreator.this.composeMsgBlankButton(n, n3);
            } else if (n == 2200163 || n == 2200389) {
                MessageCreator.this.composeMsgResumeButton(n, n3);
            } else if (n == 2200491 || n == 2200390) {
                MessageCreator.this.replyButton(n, n3);
            } else if (n == 2200506) {
                MessageCreator.this.replyAllButton(n, n3);
            } else if (n == 2200497 || n == 2200392) {
                MessageCreator.this.forwardButton(n, n3);
            } else if (n == 2200498 || n == 2200388) {
                MessageCreator.this.editButton(n, n3);
            } else {
                MessageCreator.this.log.log(10000, "[MessageCreator#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private class MyBaseListModelListener
    extends DefaultBaseListModelListener {
        private MyBaseListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            MessageCreator.this.log.log(1000000, "[MessageCreator#itemSelected] row = %1", (Object)evoListRow);
            MatchedAddress matchedAddress = ((AddressSelectionListRow)evoListRow).getMatchedAddress();
            NewMessage newMessage = MessageCreator.this.msgApp.getNewMessage();
            newMessage.clear();
            newMessage.getSelectedRecipientList().addRecipientsTo(new MatchedAddress[]{matchedAddress});
            MessageCreator.this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n4);
        }
    }
}

