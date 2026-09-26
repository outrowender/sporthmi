/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.TelOnlinePhoneStateUpdater$OnlineServiceRegistrationListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.online.IPhoneStateService;

public class TelOnlinePhoneStateUpdater
extends AbstractPhoneComponent {
    private volatile IPhoneStateService onlineService;
    private volatile boolean phoneReady;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IPhoneStateService;

    public TelOnlinePhoneStateUpdater(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.addSubPhoneComponent(new TelOnlinePhoneStateUpdater$OnlineServiceRegistrationListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    @Override
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
            this.log.log(1078071040, "[TelOnlinePhoneStateUpdater#updateOnlineService] phoneReady=%1", bl);
            iPhoneStateService.updatePhoneStatus(bl);
        } else {
            this.log.log(1078071040, "[TelOnlinePhoneStateUpdater#updateOnlineService] service is null --> NOP!");
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

    static /* synthetic */ IPhoneStateService access$002(TelOnlinePhoneStateUpdater telOnlinePhoneStateUpdater, IPhoneStateService iPhoneStateService) {
        telOnlinePhoneStateUpdater.onlineService = iPhoneStateService;
        return telOnlinePhoneStateUpdater.onlineService;
    }

    static /* synthetic */ boolean access$100(TelOnlinePhoneStateUpdater telOnlinePhoneStateUpdater) {
        return telOnlinePhoneStateUpdater.phoneReady;
    }

    static /* synthetic */ IPhoneStateService access$000(TelOnlinePhoneStateUpdater telOnlinePhoneStateUpdater) {
        return telOnlinePhoneStateUpdater.onlineService;
    }
}

