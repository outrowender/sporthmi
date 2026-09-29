/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.interapp.TelServiceAudioImpl$1;
import de.audi.atip.interapp.phone.ITelServiceAudio;
import de.audi.atip.log.LogChannel;

public class TelServiceAudioImpl
extends AbstractPhoneComponent
implements ITelServiceAudio {
    private volatile PhoneServiceProvider telServiceAudioProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceAudio;

    public TelServiceAudioImpl(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Audio");
    }

    @Override
    public void init() {
        this.telServiceAudioProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelServiceAudio == null ? (class$de$audi$atip$interapp$phone$ITelServiceAudio = TelServiceAudioImpl.class$("de.audi.atip.interapp.phone.ITelServiceAudio")) : class$de$audi$atip$interapp$phone$ITelServiceAudio).getName(), this, null, this.getApplication().getBundleContext(), this.log);
        this.telServiceAudioProvider.startService();
    }

    @Override
    public void deinit() {
        if (this.telServiceAudioProvider != null) {
            this.telServiceAudioProvider.stopService();
            this.telServiceAudioProvider = null;
        }
    }

    @Override
    public void muteIncomingCallRingtone() {
        this.getApplication().enqueueEvent(new TelServiceAudioImpl$1(this, "TelServiceAudioImpl#muteIncomingCallRingtone"));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITelApplication access$000(TelServiceAudioImpl telServiceAudioImpl) {
        return telServiceAudioImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$100(TelServiceAudioImpl telServiceAudioImpl) {
        return telServiceAudioImpl.log;
    }

    static /* synthetic */ LogChannel access$200(TelServiceAudioImpl telServiceAudioImpl) {
        return telServiceAudioImpl.log;
    }
}

