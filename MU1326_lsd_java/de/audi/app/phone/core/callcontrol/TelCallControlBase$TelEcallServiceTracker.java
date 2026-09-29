/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callcontrol;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callcontrol.TelCallControlBase;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.interapp.phone.ITelEcallService;
import de.audi.atip.interapp.phone.NullTelEcallService;

class TelCallControlBase$TelEcallServiceTracker
extends AbstractTelServiceTracker {
    private final /* synthetic */ TelCallControlBase this$0;

    public TelCallControlBase$TelEcallServiceTracker(TelCallControlBase telCallControlBase, ITelApplication iTelApplication) {
        this.this$0 = telCallControlBase;
        super(iTelApplication, "App.Phone.Main", TelCallControlBase.class$de$audi$atip$interapp$phone$ITelEcallService == null ? (TelCallControlBase.class$de$audi$atip$interapp$phone$ITelEcallService = TelCallControlBase.class$("de.audi.atip.interapp.phone.ITelEcallService")) : TelCallControlBase.class$de$audi$atip$interapp$phone$ITelEcallService);
    }

    @Override
    protected void serviceAvailable(Object object) {
        this.log.log(1078071040, "TelCallControlBase.TelServiceListenerTracker#serviceAvailable(): %1", object);
        TelCallControlBase.access$002(this.this$0, (ITelEcallService)object);
    }

    @Override
    protected void serviceRemoved(Object object) {
        this.log.log(1078071040, "TelCallControlBase.TelServiceListenerTracker#serviceRemoved(): %1", object);
        TelCallControlBase.access$002(this.this$0, new NullTelEcallService(this.log));
    }
}

