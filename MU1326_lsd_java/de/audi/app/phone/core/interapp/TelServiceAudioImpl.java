/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.audio.ITelAudio;
import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.atip.interapp.phone.ITelServiceAudio;

public class TelServiceAudioImpl
extends AbstractPhoneComponent
implements ITelServiceAudio {
    private volatile PhoneServiceProvider telServiceAudioProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceAudio;

    public TelServiceAudioImpl(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Audio");
    }

    public void init() {
        this.telServiceAudioProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelServiceAudio == null ? (class$de$audi$atip$interapp$phone$ITelServiceAudio = TelServiceAudioImpl.class$("de.audi.atip.interapp.phone.ITelServiceAudio")) : class$de$audi$atip$interapp$phone$ITelServiceAudio).getName(), this, null, this.getApplication().getBundleContext(), this.log);
        this.telServiceAudioProvider.startService();
    }

    public void deinit() {
        if (this.telServiceAudioProvider != null) {
            this.telServiceAudioProvider.stopService();
            this.telServiceAudioProvider = null;
        }
    }

    public void muteIncomingCallRingtone() {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("TelServiceAudioImpl#muteIncomingCallRingtone"){

            public void run() {
                ITelAudio iTelAudio = TelServiceAudioImpl.this.getApplication().getAudio();
                if (iTelAudio != null) {
                    TelServiceAudioImpl.this.log.log(1000000, "[TelServiceAudioImpl#muteIncomingCallRingtone] muting ringtone");
                    iTelAudio.muteRingtone(true);
                } else {
                    TelServiceAudioImpl.this.log.log(100000, "[TelServiceAudioImpl#muteIncomingCallRingtone] audioCmp is null --> NOP!");
                }
            }
        });
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

