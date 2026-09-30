/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface RSESettingsEventListener {
    public void processAudioUsageRestriction(boolean var1);

    public void processTunerUsageRestriction(boolean var1);

    public void processTVUsageRestriction(boolean var1);

    public void processCDCUsageRestriction(boolean var1);

    public void processFunctionUsageRestriction(boolean var1);

    public void processChildProtection(boolean var1);
}

