/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager;
import de.audi.app.phone.evo.util.AbstractDisplayFocusListener;

class TelEvoRingtoneManager$RingtoneListDisplayFocusListener
extends AbstractDisplayFocusListener {
    private final /* synthetic */ TelEvoRingtoneManager this$0;

    public TelEvoRingtoneManager$RingtoneListDisplayFocusListener(TelEvoRingtoneManager telEvoRingtoneManager, ITelApplication iTelApplication) {
        this.this$0 = telEvoRingtoneManager;
        super(iTelApplication, "App.Phone.Audio", 4026);
    }

    @Override
    protected void focusLost() {
        this.log.log(1078071040, "[TelEvoRingtoneManager.RingtoneListDisplayFocusListener#focusLost]");
        TelEvoRingtoneManager.access$002(this.this$0, true);
        TelEvoRingtoneManager.access$100(this.this$0);
    }

    @Override
    protected void focusGained() {
        this.log.log(1078071040, "[TelEvoRingtoneManager.RingtoneListDisplayFocusListener#focusGained]");
        TelEvoRingtoneManager.access$002(this.this$0, false);
        TelEvoRingtoneManager.access$100(this.this$0);
    }
}

