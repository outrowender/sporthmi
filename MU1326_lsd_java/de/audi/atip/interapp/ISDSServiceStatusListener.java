/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface ISDSServiceStatusListener {
    public void notifySDSDialogStarted();

    public void notifySDSDialogEnded();

    public void notifySDSDialogAborting();
}

