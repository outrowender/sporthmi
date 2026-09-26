/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.IReadable;
import java.util.NoSuchElementException;

final class IReadable$1
implements IReadable {
    IReadable$1() {
    }

    @Override
    public String nextSpeakTask() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNextSpeakTask() {
        return false;
    }
}

