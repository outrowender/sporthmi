/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.adb.TelADBDownloadInquiryHandler;
import de.audi.app.phone.core.model.TelDefaultButtonListener;

class TelADBDownloadInquiryHandler$TelADBDownloadYesButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelADBDownloadInquiryHandler this$0;

    public TelADBDownloadInquiryHandler$TelADBDownloadYesButtonListener(TelADBDownloadInquiryHandler telADBDownloadInquiryHandler, ITelApplication iTelApplication) {
        this.this$0 = telADBDownloadInquiryHandler;
        super(iTelApplication, 983041024);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelADBDownloadInquiryHandler.TelADBDownloadYesButtonListener#keyTyped] User has chosen to download address book from mobile device");
        TelADBDownloadInquiryHandler.access$000(this.this$0, (short)0);
        this.fireEvent(n3);
    }
}

