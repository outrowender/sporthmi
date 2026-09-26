/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.terminalmode.ITerminalModeAudioService;
import de.audi.atip.log.LogChannel;

public class NullTerminalModeAudioService
extends NullService
implements ITerminalModeAudioService {
    public NullTerminalModeAudioService(LogChannel logChannel, int n, String string) {
        super(logChannel, n, string);
    }

    public NullTerminalModeAudioService(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    public NullTerminalModeAudioService(LogChannel logChannel) {
        super(logChannel, "NullTerminalModeAudioService");
    }

    @Override
    public void muteIncomingCarPlayRingtone() {
        this.log();
    }
}

