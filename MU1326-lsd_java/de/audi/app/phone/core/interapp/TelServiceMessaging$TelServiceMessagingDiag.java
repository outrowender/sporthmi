/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.interapp.TelServiceMessaging;
import de.audi.app.phone.core.interapp.TelServiceMessaging$1;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class TelServiceMessaging$TelServiceMessagingDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ TelServiceMessaging this$0;

    private TelServiceMessaging$TelServiceMessagingDiag(TelServiceMessaging telServiceMessaging) {
        this.this$0 = telServiceMessaging;
    }

    public void cmdUpdateNewMessagesAvailable(boolean bl, boolean bl2) {
        this.this$0.notifyNewMessagesAvailable(bl, bl2);
    }

    /* synthetic */ TelServiceMessaging$TelServiceMessagingDiag(TelServiceMessaging telServiceMessaging, TelServiceMessaging$1 telServiceMessaging$1) {
        this(telServiceMessaging);
    }
}

