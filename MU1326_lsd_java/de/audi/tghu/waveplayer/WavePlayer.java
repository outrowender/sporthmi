/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tghu.waveplayer.SystemTonePlayer;

public interface WavePlayer {
    public RingTonePlayer getRingTonePlayer();

    public SystemTonePlayer getSystemTonePlayer();
}

