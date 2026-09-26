/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.services;

import de.audi.atip.audio.TerminalMapper;
import de.audi.audio.AudioEnv;
import de.audi.audio.services.BaseAudioService;
import de.audi.audio.store.ConnectionStore;
import de.esolutions.fw.util.commons.Buffer;

public class ToneAudioService
extends BaseAudioService {
    public ToneAudioService(AudioEnv audioEnv, String string) {
        super(audioEnv, string);
    }

    @Override
    public void releaseConnection(int n, int n2) {
        this.env.lcDSI.log(1078071040, "[ToneAudioService.releaseConnection] connection: %1, HT: %2]", (long)n, (long)n2);
        int n3 = TerminalMapper.toAudioTerminal(n2);
        int n4 = ConnectionStore.INSTANCE.getStatus(n, n3);
        switch (n4) {
            case 5: 
            case 6: {
                if (!this.env.lcMain.isDebug()) break;
                Buffer buffer = this.toDebug(n, n3, n, n2);
                this.env.lcMain.log(-2137614336, "[%1] [DSIAudioManagement.releaseConnection] IGNORED status:%3 %2", (Object)this.name, (Object)buffer, (long)n4);
                break;
            }
            default: {
                this.callReleaseConnection(n, n3);
            }
        }
    }
}

