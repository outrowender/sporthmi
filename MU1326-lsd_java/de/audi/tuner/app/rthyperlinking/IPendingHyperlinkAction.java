/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.log.LogChannel;

public interface IPendingHyperlinkAction {
    default public boolean isExecutable(LogChannel logChannel) {
    }

    default public void prepare() {
    }

    default public void execute() {
    }
}

