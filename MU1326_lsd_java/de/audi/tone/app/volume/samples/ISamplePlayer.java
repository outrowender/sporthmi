/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

public interface ISamplePlayer {
    public void play();

    public void stop();

    public void registerService(Object var1);

    public void deregisterService(Object var1);
}

