/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

public interface ISDSStateObserver {
    public void sdsSessionAborted();

    public void sdsDialogStarted();

    public void sdsDialogEnded();

    public void sdsDialogAborting();
}

