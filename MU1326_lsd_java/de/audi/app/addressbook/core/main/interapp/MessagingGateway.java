/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.interapp;

import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.atip.interapp.IMessagingService;
import de.audi.atip.log.LogChannel;

public class MessagingGateway {
    private LogChannel log;
    private IMessagingService messagingService;
    private AbstractAddressBookApplication appAdr;

    public MessagingGateway(LogChannel logChannel, AbstractAddressBookApplication abstractAddressBookApplication) {
        this.log = logChannel;
        this.appAdr = abstractAddressBookApplication;
    }

    public void setMessagingService(IMessagingService iMessagingService) {
        this.log.log(10000000, "MessagingGateway#setMessagingService(): messagingService: %1", (Object)iMessagingService);
        this.messagingService = iMessagingService;
    }

    public void releaseMessagingService() {
        this.messagingService = null;
    }

    public boolean isSendSMSReady() {
        return this.isModelValueValid(155) && this.messagingService != null && this.isModelValueValid(4646);
    }

    public boolean isSendEmailReady() {
        return this.isModelValueValid(154) && this.messagingService != null && this.isModelValueValid(4649);
    }

    public void sendMessageTo(long l, int n, int n2) {
        this.sendMessageTo(l, n, n2, 0);
    }

    public void sendMessageTo(long l, int n, int n2, int n3) {
        IMessagingService iMessagingService = this.messagingService;
        if (iMessagingService == null) {
            this.log.log(10000, "MessagingGateway#sendMessageTo(): messaging service not available!");
            return;
        }
        this.log.log(1000000, "MessagingGateway#sendMessageTo(): entryId: %1, msgType: %2, dataIndex: %3", l, (long)n, (long)n2);
        if (n3 != 0) {
            this.log.log(1000000, "MessagingGateway#sendMessageTo(): viewtype: %1", (long)n3);
        }
        iMessagingService.composeMsgPresetRecipient(n, l, n2, n3);
    }

    public void sendMessageTo(String string, int n) {
        IMessagingService iMessagingService = this.messagingService;
        if (iMessagingService == null) {
            this.log.log(10000, "MessagingGateway#sendMessageTo(): messaging service not available!");
            return;
        }
        this.log.log(1000000, "MessagingGateway#sendMessageTo(): address: %1, msgType: %2", (Object)string, (long)n);
        iMessagingService.composeMsgPresetRecipient(n, string);
    }

    public void sendAsMessage(long l, int n, String string) {
        IMessagingService iMessagingService = this.messagingService;
        if (iMessagingService == null) {
            this.log.log(10000, "MessagingGateway#sendAsMessage(): messaging service not available!");
            return;
        }
        this.log.log(1000000, "MessagingGateway#sendAsMessage(): entryId: %2, msgType: %3, vCardPath: %1", (Object)string, l, (long)n);
        iMessagingService.composeMsgAttachVCard(n, string, l);
    }

    private boolean isModelValueValid(int n) {
        return this.appAdr.getHMIService().getChoiceModel(n).getValue() > 0;
    }
}

