/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.exception;

import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SerializerBufferUnderrunException
extends SerializerException {
    private static final long serialVersionUID = 1L;

    public SerializerBufferUnderrunException() {
    }

    public SerializerBufferUnderrunException(String string) {
        super(string);
    }
}

