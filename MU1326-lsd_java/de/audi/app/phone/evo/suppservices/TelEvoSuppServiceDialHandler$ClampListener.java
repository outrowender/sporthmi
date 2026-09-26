/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.power.TelDefaultPowerEventListener;
import de.audi.app.phone.evo.suppservices.TelEvoSuppServiceDialHandler;

class TelEvoSuppServiceDialHandler$ClampListener
extends TelDefaultPowerEventListener {
    private final /* synthetic */ TelEvoSuppServiceDialHandler this$0;

    public TelEvoSuppServiceDialHandler$ClampListener(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoSuppServiceDialHandler;
        super(iTelApplication);
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (!bl && !bl2) {
            TelEvoSuppServiceDialHandler.access$1100(this.this$0);
        }
    }
}

