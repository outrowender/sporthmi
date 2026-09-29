/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.adb.TelADBDownloadInquiryHandler;
import de.audi.app.phone.core.msg.AbstractTelMessageListener;

class TelADBDownloadInquiryHandler$FactoryResetListener
extends AbstractTelMessageListener {
    private final /* synthetic */ TelADBDownloadInquiryHandler this$0;

    public TelADBDownloadInquiryHandler$FactoryResetListener(TelADBDownloadInquiryHandler telADBDownloadInquiryHandler, ITelApplication iTelApplication) {
        this.this$0 = telADBDownloadInquiryHandler;
        super(iTelApplication, "App.Phone.Main", 28);
    }

    @Override
    protected void messageReceived() {
        this.log.log(1078071040, "[TelADBDownloadInquiryHandler.FactoryResetListener#messageRecieved]");
        TelADBDownloadInquiryHandler.access$302(this.this$0, "");
        TelADBDownloadInquiryHandler.access$400(this.this$0, "");
        TelADBDownloadInquiryHandler.access$502(this.this$0, (short)-1);
        this.this$0.storeMobileADBDownloadSettingToPersistence((short)-1);
    }
}

