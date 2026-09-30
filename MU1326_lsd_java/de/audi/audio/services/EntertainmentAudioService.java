/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.services;

import de.audi.atip.audio.TerminalMapper;
import de.audi.audio.AudioEnv;
import de.audi.audio.services.BaseAudioService;
import de.audi.audio.sse.NullDSISSE;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sse.DSISSE;

public class EntertainmentAudioService
extends BaseAudioService {
    private boolean logFirstRequest = true;
    private boolean logFirstFadeTo = true;
    private DSISSE dsiSSE;

    public EntertainmentAudioService(AudioEnv audioEnv, String string) {
        super(audioEnv, string);
        this.dsiSSE = new NullDSISSE(audioEnv.lcDSI);
    }

    public void setService(Object object) {
        if (object instanceof DSISSE) {
            this.dsiSSE = (DSISSE)object;
        }
    }

    public void requestConnection(int n, int n2, int n3) {
        switch (n) {
            case 8: {
                super.requestConnection(n, n2, n3);
                return;
            }
            case 102: {
                this.dsiSSE.requestSetMicMuteState(0);
                super.requestConnection(n, n2, n3);
                return;
            }
        }
        if (this.logFirstRequest) {
            this.env.logStartupEvent("[AUDIO] request EAC: " + n);
            this.logFirstRequest = false;
        }
        int n4 = TerminalMapper.toAudioTerminal(n2);
        if (this.env.lcMain.isDebug()) {
            Buffer buffer = this.toDebug(n, n4, n, n2);
            this.env.lcMain.log(10000000, "[%1] [EntertainmentAudioService.requestConnection] %2", (Object)this.name, (Object)buffer);
        }
        this.callRequestConnection(n, n4, n3);
    }

    public void releaseConnection(int n) {
        if (n == 102) {
            this.dsiSSE.requestSetMicMuteState(1);
        }
        super.releaseConnection(n);
    }

    public void fadeToConnection(int n, int n2) {
        if (this.logFirstFadeTo) {
            this.env.logStartupEvent("[AUDIO] fade-to EAC: " + n);
            this.logFirstFadeTo = false;
        }
        super.fadeToConnection(n, n2);
    }
}

