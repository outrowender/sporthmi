/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

public interface IRadioAudioService {
    public void fadeTo(int var1, int var2);

    public boolean isActive(int var1);

    public void requestAudioChannel(int var1, int var2);

    public int getStatus(int var1);

    public void demute();

    public boolean isAMAvailable();

    public int getConnectionForActiveTuner(int var1);

    public boolean isTunerAudioConnection(int var1);
}

