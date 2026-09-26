/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.IReadable$1;

public interface IReadable {
    public static final IReadable EMPTY_READABLE = new IReadable$1();

    default public boolean hasNextSpeakTask() {
    }

    default public String nextSpeakTask() {
    }
}

