/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.adb.TelADBDownloadInquiryHandler;
import de.audi.app.phone.core.model.TelDefaultButtonListener;

class TelADBDownloadInquiryHandler$TelADBDownloadNoButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelADBDownloadInquiryHandler this$0;

    public TelADBDownloadInquiryHandler$TelADBDownloadNoButtonListener(TelADBDownloadInquiryHandler telADBDownloadInquiryHandler, ITelApplication iTelApplication) {
        this.this$0 = telADBDownloadInquiryHandler;
        super(iTelApplication, 362087424);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelADBDownloadInquiryHandler.TelADBDownloadNoButtonListener#keyTyped] User has chosen not to download address book from mobile device");
        TelADBDownloadInquiryHandler.access$000(this.this$0, (short)1);
        this.fireEvent(n3);
    }
}

