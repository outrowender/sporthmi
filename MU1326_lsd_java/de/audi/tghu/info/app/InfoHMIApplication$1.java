/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app;

import de.audi.tghu.info.app.InfoHMIApplication;

class InfoHMIApplication$1
implements Runnable {
    private final /* synthetic */ InfoHMIApplication this$0;

    InfoHMIApplication$1(InfoHMIApplication infoHMIApplication) {
        this.this$0 = infoHMIApplication;
    }

    @Override
    public void run() {
        InfoHMIApplication.access$100(this.this$0).getFramework().getHmiServiceApp().showPartialPopup(0, InfoHMIApplication.access$000(this.this$0));
    }
}

