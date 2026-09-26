/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelRingtoneManager;
import de.audi.app.phone.core.audio.TelRingtoneManager$1;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class TelRingtoneManager$TelAudioDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ TelRingtoneManager this$0;

    private TelRingtoneManager$TelAudioDiag(TelRingtoneManager telRingtoneManager) {
        this.this$0 = telRingtoneManager;
    }

    public void cmdSetUserDefinedRingtone(String string, String string2) {
        this.this$0.setUserDefinedRingtone(string, string2);
    }

    /* synthetic */ TelRingtoneManager$TelAudioDiag(TelRingtoneManager telRingtoneManager, TelRingtoneManager$1 telRingtoneManager$1) {
        this(telRingtoneManager);
    }
}

