/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.atip.interapp.phone.ITelMuteMicService;

public class TelMuteMicServiceImpl
extends AbstractPhoneComponent
implements ITelMuteMicService {
    private volatile PhoneServiceProvider telMuteMicServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelMuteMicService;

    public TelMuteMicServiceImpl(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Audio");
    }

    @Override
    public void init() {
        this.telMuteMicServiceProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelMuteMicService == null ? (class$de$audi$atip$interapp$phone$ITelMuteMicService = TelMuteMicServiceImpl.class$("de.audi.atip.interapp.phone.ITelMuteMicService")) : class$de$audi$atip$interapp$phone$ITelMuteMicService).getName(), this, null, this.getApplication().getBundleContext(), this.log);
        this.telMuteMicServiceProvider.startService();
    }

    @Override
    public void deinit() {
        if (this.telMuteMicServiceProvider != null) {
            this.telMuteMicServiceProvider.stopService();
            this.telMuteMicServiceProvider = null;
        }
    }

    @Override
    public void toggleMuteMicrophone(boolean bl) {
        this.log.log(1078071040, "[TelMuteMicServiceImpl#toggleMuteMicrophone] muteMicrophone=%1", bl);
        this.getApplication().getAudio().toggelMicMuteState(0);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

