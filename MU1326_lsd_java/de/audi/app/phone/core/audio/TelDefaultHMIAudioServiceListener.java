/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import java.util.Hashtable;

public class TelDefaultHMIAudioServiceListener
extends AbstractPhoneComponent
implements HMIAudioServiceListener {
    private final PhoneServiceProvider hmiAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;

    public TelDefaultHMIAudioServiceListener(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_PHONE);
        this.hmiAudioServiceListener = new PhoneServiceProvider((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = TelDefaultHMIAudioServiceListener.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
    }

    public void init() {
        super.init();
        this.hmiAudioServiceListener.startService();
    }

    public void deinit() {
        super.deinit();
        this.hmiAudioServiceListener.stopService();
    }

    public void updateAMAvailable(boolean bl) {
    }

    public void stopConnection(int n, int n2) {
    }

    public void pauseConnection(int n, int n2) {
    }

    public void startConnection(int n, int n2) {
    }

    public void errorConnection(int n, int n2, int n3) {
    }

    public void fadedIn(int n, int n2) {
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
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

