/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.SystemTonePlayer;

public class NullSystemTonePlayer
extends NullRingTonePlayer
implements SystemTonePlayer {
    public NullSystemTonePlayer(LogChannel logChannel) {
        super(logChannel, "SystemTonePlayer");
    }
}

