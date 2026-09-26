/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.swdl.ude.IEApplication;
import de.audi.tghu.swdl.ude.IEApplication$1;

class IEApplication$RebootTimerListener
extends DefaultTimerListener {
    private final /* synthetic */ IEApplication this$0;

    private IEApplication$RebootTimerListener(IEApplication iEApplication) {
        this.this$0 = iEApplication;
    }

    @Override
    public void fireTimer(Timer timer) {
        IEApplication.access$800(this.this$0).getLogUDE().log(1078071040, "[RebootTimerListener.fireTimer] trigger reboot");
        IEApplication.access$800(this.this$0).rebootSystem();
    }

    /* synthetic */ IEApplication$RebootTimerListener(IEApplication iEApplication, IEApplication$1 iEApplication$1) {
        this(iEApplication);
    }
}

