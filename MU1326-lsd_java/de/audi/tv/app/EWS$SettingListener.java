/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.EWS;
import de.audi.tv.app.EWS$1;
import de.audi.tv.app.settings.DefaultSettingListener;

class EWS$SettingListener
extends DefaultSettingListener {
    private final /* synthetic */ EWS this$0;

    private EWS$SettingListener(EWS eWS) {
        this.this$0 = eWS;
    }

    @Override
    public void updateEWS(boolean bl) {
        EWS.access$802(this.this$0, bl);
    }

    /* synthetic */ EWS$SettingListener(EWS eWS, EWS$1 eWS$1) {
        this(eWS);
    }
}

