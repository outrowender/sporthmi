/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.attachments;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.attachments.AttachmentListRow;
import de.audi.app.messaging.core.attachments.AttachmentUtil;
import de.audi.app.messaging.core.attachments.IAttachmentObserver;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import java.util.Iterator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MessageDetails;

public final class AttachmentList
extends AbstractMessagingComponent
implements BaseListModelListener {
    private static final int ATTACHMENT_TYPE_UNSUPPORTED = 0;
    private static final int ATTACHMENT_TYPE_VCARD = 1;
    private final BaseListModelApp listModel;
    private volatile CopyOnWriteArrayList observers = new CopyOnWriteArrayList();
    private volatile AttachmentInformation[] attachmentInformations;
    private volatile int messageType = 4;
    private boolean useVariantSpecificListListener;

    public AttachmentList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getBaseListModel(2200253);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(this);
        this.framework.getHmiServiceApp().getButtonModel(2200256).setButtonListener(new MyButtonListener());
    }

    public void setUseVariantSpecificListListener(boolean bl) {
        this.useVariantSpecificListListener = bl;
    }

    public void setAttachments(AttachmentInformation[] attachmentInformationArray, int n) {
        this.log.log(10000000, "[AttachmentList#setAttachments] messageType = %1", (long)n);
        this.attachmentInformations = attachmentInformationArray;
        this.messageType = n;
        this.listModel.removeAll();
        for (int i2 = 0; i2 < attachmentInformationArray.length; ++i2) {
            AttachmentListRow attachmentListRow = new AttachmentListRow(attachmentInformationArray[i2], false);
            this.listModel.append(attachmentListRow);
        }
    }

    public AttachmentInformation[] getAttachments() {
        return this.attachmentInformations;
    }

    private void viewAttachmentsButton(int n, int n2) {
        this.log.log(1000000, "[AttachmentList#viewAttachmentsButton]");
        this.downloadAttachments();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    public void downloadAttachments() {
        this.log.log(1000000, "[AttachmentList#downloadAttachments]");
        this.emitDownloadResult(3);
        try {
            this.msgApp.getModelAccess().setOperationStateChoice(2200252, 0);
            int n = this.msgApp.getAccountManager().getSelectedAccount().getAccountID();
            String string = this.msgApp.getMessageOptionsManager().getFocusedMessageListEntry().getMessageID();
            GetMessageContentsCommand.ResultHandler resultHandler = new GetMessageContentsCommand.ResultHandler(){

                public void handleResult(boolean bl, MessageDetails messageDetails, int n) {
                    AttachmentList.this.handleCommandResult(bl, messageDetails, n);
                }
            };
            new GetMessageContentsCommand(this.msgApp, n, string, 2, resultHandler).schedule();
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[AttachmentList#viewAttachmentsButton]");
            this.handleCommandResult(false, null, 2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleCommandResult(boolean bl, MessageDetails messageDetails, int n) {
        this.log.log(1000000, "[AttachmentList#handleCommandResult]");
        int n2 = 2;
        AttachmentInformation[] attachmentInformationArray = new AttachmentInformation[]{};
        int n3 = 4;
        int n4 = 2;
        try {
            if (bl) {
                AttachmentInformation[] attachmentInformationArray2 = messageDetails.getAttachments();
                attachmentInformationArray = AttachmentUtil.getDownloadedAttachments(attachmentInformationArray2);
                n3 = messageDetails.getType();
                if (attachmentInformationArray2.length == attachmentInformationArray.length) {
                    n2 = 1;
                    n4 = 0;
                }
                n4 = 1;
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[AttachmentList#handleCommandResult]");
            n2 = 2;
            attachmentInformationArray = new AttachmentInformation[]{};
            n4 = 2;
        }
        finally {
            this.setAttachments(attachmentInformationArray, n3);
            this.msgApp.getModelAccess().setOperationStateChoice(2200252, n2);
            this.emitDownloadResult(n4);
        }
    }

    public void setAttachmentSelectionType(int n) {
        this.log.log(10000000, "[AttachmentList#setAttachmentSelectionType] attachmentType = %1", (long)n);
        this.framework.getHmiServiceApp().getChoiceModel(2200403).setValue(n);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AttachmentListRow attachmentListRow = (AttachmentListRow)evoListRow;
        AttachmentInformation attachmentInformation = attachmentListRow.getAttachmentInformation();
        this.log.log(1000000, "[AttachmentList#itemSelected] row = %1, attachmentInformation = %2", (Object)evoListRow, (Object)attachmentInformation);
        if (this.useVariantSpecificListListener) {
            this.emitAttachmentSelected(attachmentInformation);
        } else {
            int n5 = 0;
            if (!AttachmentUtil.isSupportedAttachment(attachmentInformation)) {
                this.listModel.setRow(n2, attachmentListRow.toggleLayout());
            } else if (AttachmentUtil.isVCardAttachment(attachmentInformation)) {
                n5 = 1;
                this.msgApp.getImportContactController().importContact(attachmentInformation, this.messageType);
            } else {
                this.log.log(10000, "[AttachmentList#itemSelected] Unknown use case, cannot figure out what to do with the selected attachment.");
            }
            this.setAttachmentSelectionType(n5);
            this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n4);
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void addObserver(IAttachmentObserver iAttachmentObserver) {
        this.log.log(10000000, "[AttachmentList#addObserver]");
        this.observers.add(iAttachmentObserver);
    }

    public void emitDownloadResult(int n) {
        this.log.log(10000000, "[AttachmentList#emitDownloadResult]");
        Iterator iterator = this.observers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IAttachmentObserver)iterator.next()).downloadComplete(n);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AttachmentList#emitDownloadResult]");
            }
        }
    }

    public void emitAttachmentSelected(AttachmentInformation attachmentInformation) {
        this.log.log(10000000, "[AttachmentList#emitDownloadResult]");
        Iterator iterator = this.observers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IAttachmentObserver)iterator.next()).attachmentSelected(attachmentInformation);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[AttachmentList#emitDownloadResult]");
            }
        }
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200256) {
                AttachmentList.this.viewAttachmentsButton(n, n3);
            } else {
                AttachmentList.this.log.log(10000, "[AttachmentList#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }
}

