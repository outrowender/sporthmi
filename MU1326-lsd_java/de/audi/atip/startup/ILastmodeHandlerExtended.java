/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.start.ILastmodeHandler;

public interface ILastmodeHandlerExtended
extends ILastmodeHandler {
    default public void start() {
    }

    default public void stop() {
    }

    default public void initQueues() {
    }

    default public void initLastmodeStorage(boolean bl) {
    }

    default public void initPersistentData() {
    }

    default public void restoreLastmode() {
    }

    default public void storeNavEnabled(boolean bl) {
    }

    default public void setLastmodeForAllTerminals(boolean bl) {
    }

    default public boolean activateLastmodeAudio(int n, int n2) {
    }

    default public boolean activateLastmodeApp(int n, int n2) {
    }

    default public void writePersistentLastMode() {
    }

    default public boolean checkLastmodeChange(KeyEvent keyEvent) {
    }

    default public void enqueueLastmodeChange(int n, int n2) {
    }

    default public boolean isValidLastmode(KeyEvent keyEvent) {
    }

    default public void initLastmodeAudioQueues() {
    }

    default public void initLastmodeAppQueues() {
    }
}

