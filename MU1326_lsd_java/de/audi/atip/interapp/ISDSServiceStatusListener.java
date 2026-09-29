/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface ISDSServiceStatusListener {
    default public void notifySDSDialogStarted() {
    }

    default public void notifySDSDialogEnded() {
    }

    default public void notifySDSDialogAborting() {
    }
}

