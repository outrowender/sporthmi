/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager;
import java.util.Map;

class TelEvoRingtoneManager$RingtoneListExitedListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelEvoRingtoneManager this$0;

    public TelEvoRingtoneManager$RingtoneListExitedListener(TelEvoRingtoneManager telEvoRingtoneManager, ITelApplication iTelApplication) {
        this.this$0 = telEvoRingtoneManager;
        super(iTelApplication, "App.Phone.Audio", 3);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.log.log(1078071040, "[RingtoneListExitedListener#actionProxyCalled] CANCEL_RINGING_TONE");
        TelEvoRingtoneManager.access$402(this.this$0, false);
        TelEvoRingtoneManager.access$500(this.this$0);
    }
}

