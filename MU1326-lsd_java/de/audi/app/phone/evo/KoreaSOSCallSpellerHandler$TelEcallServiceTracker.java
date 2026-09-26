/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.app.phone.evo.KoreaSOSCallSpellerHandler;
import de.audi.atip.interapp.phone.ITelEcallService;
import de.audi.atip.interapp.phone.NullTelEcallService;

class KoreaSOSCallSpellerHandler$TelEcallServiceTracker
extends AbstractTelServiceTracker {
    private final /* synthetic */ KoreaSOSCallSpellerHandler this$0;

    public KoreaSOSCallSpellerHandler$TelEcallServiceTracker(KoreaSOSCallSpellerHandler koreaSOSCallSpellerHandler, ITelApplication iTelApplication) {
        this.this$0 = koreaSOSCallSpellerHandler;
        super(iTelApplication, "App.Phone.Main", KoreaSOSCallSpellerHandler.class$de$audi$atip$interapp$phone$ITelEcallService == null ? (KoreaSOSCallSpellerHandler.class$de$audi$atip$interapp$phone$ITelEcallService = KoreaSOSCallSpellerHandler.class$("de.audi.atip.interapp.phone.ITelEcallService")) : KoreaSOSCallSpellerHandler.class$de$audi$atip$interapp$phone$ITelEcallService);
    }

    @Override
    protected void serviceAvailable(Object object) {
        this.log.log(1078071040, "KoreaSOSCallSpellerHandler.TelServiceListenerTracker#serviceAvailable(): %1", object);
        KoreaSOSCallSpellerHandler.access$102(this.this$0, (ITelEcallService)object);
    }

    @Override
    protected void serviceRemoved(Object object) {
        this.log.log(1078071040, "KoreaSOSCallSpellerHandler.TelServiceListenerTracker#serviceRemoved(): %1", object);
        KoreaSOSCallSpellerHandler.access$102(this.this$0, new NullTelEcallService(this.log));
    }
}

