/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.network;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.lang.AbstractTelLangaugeUpdateListener;
import de.audi.app.phone.core.network.AbstractTelNetworkSetupHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.i18n.Language;

class AbstractTelNetworkSetupHandler$TelNetworkModelLanguageUpdateListener
extends AbstractTelLangaugeUpdateListener {
    private final /* synthetic */ AbstractTelNetworkSetupHandler this$0;

    public AbstractTelNetworkSetupHandler$TelNetworkModelLanguageUpdateListener(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler, ITelApplication iTelApplication) {
        this.this$0 = abstractTelNetworkSetupHandler;
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void setLanguage(Language language) {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = AbstractTelNetworkSetupHandler.access$2900(this.this$0);
        if (iGlobalTelephoneStateStruct != null) {
            AbstractTelNetworkSetupHandler.access$3100(this.this$0, AbstractTelNetworkSetupHandler.access$3000(this.this$0, iGlobalTelephoneStateStruct.getPrimaryDeviceState()));
            AbstractTelNetworkSetupHandler.access$3300(this.this$0, AbstractTelNetworkSetupHandler.access$3200(this.this$0));
        }
    }
}

