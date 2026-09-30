/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.exception;

import de.esolutions.fw.util.transport.exception.TransportException;

public class TransportQueueShutdownException
extends TransportException {
    private static final long serialVersionUID = 1L;

    public TransportQueueShutdownException() {
    }

    public TransportQueueShutdownException(String string) {
        super(string);
    }
}

