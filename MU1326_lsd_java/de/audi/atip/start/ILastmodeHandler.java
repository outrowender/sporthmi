/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.start;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.start.ILastmodeStorage;

public interface ILastmodeHandler
extends IAudioFocusManager {
    public int getLastmode(int var1);

    public int getLastmodeAudio(int var1);

    public void triggerFirstAudio(int var1);

    public void setLastmode(int var1, int var2, boolean var3);

    public void setLastmodeAudio(int var1, int var2);

    public void setLastmodeAudioStarted(int var1, boolean var2);

    public boolean isValidLastmode(int var1);

    public boolean isValidAudioLastmode(int var1);

    public ILastmodeStorage getLastmodeStorage();

    public void registerAudioClient(IAudioFocusClient var1);

    public void deregisterAudioClient(IAudioFocusClient var1);

    public void initAudioFocusManagement();

    public void setHMIAudioService(HMIAudioService var1);
}

