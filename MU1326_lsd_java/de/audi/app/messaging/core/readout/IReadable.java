/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import java.util.NoSuchElementException;

public interface IReadable {
    public static final IReadable EMPTY_READABLE = new IReadable(){

        public String nextSpeakTask() {
            throw new NoSuchElementException();
        }

        public boolean hasNextSpeakTask() {
            return false;
        }
    };

    public boolean hasNextSpeakTask();

    public String nextSpeakTask();
}

