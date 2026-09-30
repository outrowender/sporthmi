/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.log.LogChannel;

public interface IPendingHyperlinkAction {
    public boolean isExecutable(LogChannel var1);

    public void prepare();

    public void execute();
}

