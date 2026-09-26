/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

public interface ISDSStateObserver {
    default public void sdsSessionAborted() {
    }

    default public void sdsDialogStarted() {
    }

    default public void sdsDialogEnded() {
    }

    default public void sdsDialogAborting() {
    }
}

