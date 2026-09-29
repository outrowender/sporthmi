/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager;
import java.util.Map;

class TelEvoRingtoneManager$RingtoneListEnteredListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelEvoRingtoneManager this$0;

    public TelEvoRingtoneManager$RingtoneListEnteredListener(TelEvoRingtoneManager telEvoRingtoneManager, ITelApplication iTelApplication) {
        this.this$0 = telEvoRingtoneManager;
        super(iTelApplication, "App.Phone.Audio", 2);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.log.log(1078071040, "[RingtoneListEnteredListener#actionProxyCalled] PHONE_TONE_SETUP_ENTERED");
        TelEvoRingtoneManager.access$302(this.this$0, true);
        this.this$0.startRingtoneListPlayback();
    }
}

