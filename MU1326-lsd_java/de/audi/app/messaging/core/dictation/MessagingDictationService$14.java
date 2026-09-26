/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.util.Logs;
import org.dsi.ifc.messaging.MatchedAddress;

class MessagingDictationService$14
implements Runnable {
    private final /* synthetic */ int val$recipientType;
    private final /* synthetic */ String val$addressOrNumber;
    private final /* synthetic */ long val$entryID;
    private final /* synthetic */ String val$combinedName;
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$14(MessagingDictationService messagingDictationService, int n, String string, long l, String string2) {
        this.this$0 = messagingDictationService;
        this.val$recipientType = n;
        this.val$addressOrNumber = string;
        this.val$entryID = l;
        this.val$combinedName = string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            MessagingDictationService.access$5800(this.this$0).log(1078071040, "[MessagingDictationService#requestAddRecipient] recipientType = %1, addressOrNumber = %2, entryID = %3, combinedName = %4", (Object)String.valueOf(this.val$recipientType), (Object)String.valueOf(this.val$addressOrNumber), (Object)String.valueOf(this.val$entryID), (Object)String.valueOf(this.val$combinedName));
            if (!MessagingDictationService.access$100(this.this$0)) {
                MessagingDictationService.access$5900(this.this$0).log(10000, "[MessagingDictationService#requestBeginDialog] Illegal state: There is no dialog in progress.");
                n = 3;
            } else if (this.val$recipientType == 0) {
                MessagingDictationService.access$6000(this.this$0).log(10000, "[MessagingDictationService#requestAddRecipient] Illegal argument: recipientType = %1", (long)this.val$recipientType);
                n = 2;
            } else {
                MatchedAddress[] matchedAddressArray = new MatchedAddress[]{new MatchedAddress(this.val$addressOrNumber, this.val$combinedName, this.val$entryID, null)};
                if (this.val$recipientType == 1) {
                    MessagingDictationService.access$6100(this.this$0).getNewMessage().getSelectedRecipientList().addRecipientsTo(matchedAddressArray);
                } else if (this.val$recipientType == 2) {
                    MessagingDictationService.access$6200(this.this$0).getNewMessage().getSelectedRecipientList().addRecipientsCc(matchedAddressArray);
                } else if (this.val$recipientType == 2) {
                    MessagingDictationService.access$6300(this.this$0).getNewMessage().getSelectedRecipientList().addRecipientsCc(matchedAddressArray);
                }
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingDictationService.access$6400(this.this$0), exception, "[MessagingDictationService#requestAddRecipient]");
            n = 1;
        }
        finally {
            MessagingDictationService.access$2900(this.this$0, this.this$0.getCompositionState());
            MessagingDictationService.access$6500(this.this$0, n);
        }
    }
}

