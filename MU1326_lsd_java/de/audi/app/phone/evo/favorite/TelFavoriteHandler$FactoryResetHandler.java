/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.msg.AbstractTelMessageListener;
import de.audi.app.phone.evo.favorite.TelFavoriteHandler;

class TelFavoriteHandler$FactoryResetHandler
extends AbstractTelMessageListener {
    private final /* synthetic */ TelFavoriteHandler this$0;

    public TelFavoriteHandler$FactoryResetHandler(TelFavoriteHandler telFavoriteHandler, ITelApplication iTelApplication) {
        this.this$0 = telFavoriteHandler;
        super(iTelApplication, "App.Phone.Main", 28);
    }

    @Override
    protected void messageReceived() {
        this.log.log(1078071040, "[TelFavoriteHandler.FactoryResetHandler#messageRecieved] deleting all favorite information.");
        for (int i2 = 0; i2 < TelFavoriteHandler.access$200(this.this$0).length; ++i2) {
            if (TelFavoriteHandler.access$200(this.this$0)[i2] == null) continue;
            TelFavoriteHandler.access$200(this.this$0)[i2].deleteAll();
        }
    }
}

