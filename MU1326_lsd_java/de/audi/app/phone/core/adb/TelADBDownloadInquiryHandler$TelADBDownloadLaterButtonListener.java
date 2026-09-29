/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.adb.TelADBDownloadInquiryHandler;
import de.audi.app.phone.core.model.TelDefaultButtonListener;

class TelADBDownloadInquiryHandler$TelADBDownloadLaterButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelADBDownloadInquiryHandler this$0;

    public TelADBDownloadInquiryHandler$TelADBDownloadLaterButtonListener(TelADBDownloadInquiryHandler telADBDownloadInquiryHandler, ITelApplication iTelApplication) {
        this.this$0 = telADBDownloadInquiryHandler;
        super(iTelApplication, 345310208);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelADBDownloadInquiryHandler.TelADBDownloadLaterButtonListener#keyTyped] User has chosen to be asked the next time.");
        TelADBDownloadInquiryHandler.access$000(this.this$0, (short)2);
        this.fireEvent(n3);
    }
}

