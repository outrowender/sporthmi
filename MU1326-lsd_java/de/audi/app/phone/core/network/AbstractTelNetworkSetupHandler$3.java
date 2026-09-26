/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.network;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.network.AbstractTelNetworkSetupHandler;

class AbstractTelNetworkSetupHandler$3
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ AbstractTelNetworkSetupHandler this$0;

    AbstractTelNetworkSetupHandler$3(AbstractTelNetworkSetupHandler abstractTelNetworkSetupHandler) {
        this.this$0 = abstractTelNetworkSetupHandler;
    }

    @Override
    public void responseNetworkRegistration(int n, int n2) {
        AbstractTelNetworkSetupHandler.access$2200(this.this$0).log(-2137614336, "AbstractTelNetworkSetupHandler#responseNetworkRegistration: result=%1, regMode=%2 ", (long)n, (long)AbstractTelNetworkSetupHandler.access$100(this.this$0));
        if (AbstractTelNetworkSetupHandler.access$100(this.this$0) == 1) {
            AbstractTelNetworkSetupHandler.access$2300(this.this$0).log(-2137614336, "AbstractTelNetworkSetupHandler#responseNetworkRegistration: Automatic registration requested, ignoring result, displaying TEL_SETUP_NET_MAIN! ");
            AbstractTelNetworkSetupHandler.access$2100(this.this$0).setError(1);
            return;
        }
        switch (n) {
            case 0: {
                AbstractTelNetworkSetupHandler.access$2400(this.this$0).log(-2137614336, "AbstractTelNetworkSetupHandler#responseNetworkRegistration: Registration successful, displaying TEL_SETUP_NET_MAIN! ");
                AbstractTelNetworkSetupHandler.access$2100(this.this$0).setAvaible();
                break;
            }
            case 15: {
                AbstractTelNetworkSetupHandler.access$2500(this.this$0).log(-1601830656, "AbstractTelNetworkSetupHandler#responseNetworkRegistration: error, registration not allowed ");
                AbstractTelNetworkSetupHandler.access$2100(this.this$0).setError(2);
                break;
            }
            case 13: {
                AbstractTelNetworkSetupHandler.access$2600(this.this$0).log(-1601830656, "AbstractTelNetworkSetupHandler#responseNetworkRegistration: No network access, reigstration failed ");
                AbstractTelNetworkSetupHandler.access$2100(this.this$0).setError(2);
                break;
            }
            case 12: {
                AbstractTelNetworkSetupHandler.access$2700(this.this$0).log(-1601830656, "AbstractTelNetworkSetupHandler#responseNetworkRegistration: No network reply, displaying TEL_SETUP_NET_STATUS2! ");
                AbstractTelNetworkSetupHandler.access$2100(this.this$0).setNotAvailable();
                break;
            }
            default: {
                AbstractTelNetworkSetupHandler.access$2800(this.this$0).log(-1601830656, "AbstractTelNetworkSetupHandler#responseNetworkRegistration: Generic error, displaying TEL_SETUP_NET_STATUS2! ");
                AbstractTelNetworkSetupHandler.access$2100(this.this$0).setError(-1);
            }
        }
    }
}

