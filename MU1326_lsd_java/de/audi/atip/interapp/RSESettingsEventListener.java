/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface RSESettingsEventListener {
    default public void processAudioUsageRestriction(boolean bl) {
    }

    default public void processTunerUsageRestriction(boolean bl) {
    }

    default public void processTVUsageRestriction(boolean bl) {
    }

    default public void processCDCUsageRestriction(boolean bl) {
    }

    default public void processFunctionUsageRestriction(boolean bl) {
    }

    default public void processChildProtection(boolean bl) {
    }
}

