/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.interapp.online.IPhoneStateService;

public class TelOnlinePhoneStateUpdater
extends AbstractPhoneComponent {
    private volatile IPhoneStateService onlineService;
    private volatile boolean phoneReady;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IPhoneStateService;

    public TelOnlinePhoneStateUpdater(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.addSubPhoneComponent(new OnlineServiceRegistrationListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        boolean bl;
        if (iGlobalTelephoneStateStruct != null && this.phoneReady != (bl = iGlobalTelephoneStateStruct.isPhoneReady())) {
            this.updateOnlineService(bl);
            this.phoneReady = bl;
        }
    }

    private void updateOnlineService(boolean bl) {
        IPhoneStateService iPhoneStateService = this.onlineService;
        if (iPhoneStateService != null) {
            this.log.log(1000000, "[TelOnlinePhoneStateUpdater#updateOnlineService] phoneReady=%1", bl);
            iPhoneStateService.updatePhoneStatus(bl);
        } else {
            this.log.log(1000000, "[TelOnlinePhoneStateUpdater#updateOnlineService] service is null --> NOP!");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class OnlineServiceRegistrationListener
    extends AbstractTelServiceTracker {
        public OnlineServiceRegistrationListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", class$de$audi$atip$interapp$online$IPhoneStateService == null ? (class$de$audi$atip$interapp$online$IPhoneStateService = TelOnlinePhoneStateUpdater.class$("de.audi.atip.interapp.online.IPhoneStateService")) : class$de$audi$atip$interapp$online$IPhoneStateService);
        }

        protected void serviceAvailable(Object object) {
            TelOnlinePhoneStateUpdater.this.onlineService = (IPhoneStateService)object;
            this.log.log(1000000, "[TelOnlinePhoneStateUpdater.OnlineServiceRegistrationListener#serviceAvailable] phoneReady=%1", TelOnlinePhoneStateUpdater.this.phoneReady);
            TelOnlinePhoneStateUpdater.this.onlineService.updatePhoneStatus(TelOnlinePhoneStateUpdater.this.phoneReady);
        }

        protected void serviceRemoved(Object object) {
            TelOnlinePhoneStateUpdater.this.onlineService = null;
        }
    }
}

