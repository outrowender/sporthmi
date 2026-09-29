/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$1;
import de.audi.app.phone.core.audio.TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener$1;
import de.audi.app.phone.core.util.TelLoggingUtils;
import org.dsi.ifc.sse.DSISSEListener;

class TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener
implements DSISSEListener {
    private final /* synthetic */ TelMicrophoneGainLevelHandler this$0;

    private TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler) {
        this.this$0 = telMicrophoneGainLevelHandler;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        TelMicrophoneGainLevelHandler.access$1200(this.this$0).log(-1601830656, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISSEListener#asyncException] %1", (Object)TelLoggingUtils.asyncException(n, string, n2));
    }

    @Override
    public void responseSetMode(int n) {
    }

    @Override
    public void updateMode(int n, int n2) {
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
        TelMicrophoneGainLevelHandler.access$1600(this.this$0).enqueueEvent(new TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener$1(this, "DSISSEListener#updateMicGainLevel", n2, n));
    }

    @Override
    public void responseSetMicGainLevel(int n) {
        TelMicrophoneGainLevelHandler.access$1700(this.this$0).log(1078071040, "[TelMicrophoneGainLevelHandler.TelMicrophoneGainLevelDSISSEListener#responseSetMicGainLevel] replyCode=%1", (long)n);
    }

    @Override
    public void updateMicMuteState(int n, int n2) {
    }

    @Override
    public void responseSetMicMuteState(int n) {
    }

    /* synthetic */ TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener(TelMicrophoneGainLevelHandler telMicrophoneGainLevelHandler, TelMicrophoneGainLevelHandler$1 telMicrophoneGainLevelHandler$1) {
        this(telMicrophoneGainLevelHandler);
    }

    static /* synthetic */ TelMicrophoneGainLevelHandler access$1300(TelMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener) {
        return telMicrophoneGainLevelHandler$TelMicrophoneGainLevelDSISSEListener.this$0;
    }
}

