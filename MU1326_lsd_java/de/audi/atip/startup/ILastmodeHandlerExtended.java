/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.start.ILastmodeHandler;

public interface ILastmodeHandlerExtended
extends ILastmodeHandler {
    public void start();

    public void stop();

    public void initQueues();

    public void initLastmodeStorage(boolean var1);

    public void initPersistentData();

    public void restoreLastmode();

    public void storeNavEnabled(boolean var1);

    public void setLastmodeForAllTerminals(boolean var1);

    public boolean activateLastmodeAudio(int var1, int var2);

    public boolean activateLastmodeApp(int var1, int var2);

    public void writePersistentLastMode();

    public boolean checkLastmodeChange(KeyEvent var1);

    public void enqueueLastmodeChange(int var1, int var2);

    public boolean isValidLastmode(KeyEvent var1);

    public void initLastmodeAudioQueues();

    public void initLastmodeAppQueues();
}

