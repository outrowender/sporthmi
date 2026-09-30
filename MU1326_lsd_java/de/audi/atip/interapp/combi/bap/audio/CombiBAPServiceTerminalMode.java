/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudio;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;

public interface CombiBAPServiceTerminalMode
extends CombiBAPServiceAudio {
    public void updateSourceListTerminalMode(int[] var1, CombiBAPAudioSource[][] var2);

    public void updatePlayPosition(PlayPosition var1);
}

