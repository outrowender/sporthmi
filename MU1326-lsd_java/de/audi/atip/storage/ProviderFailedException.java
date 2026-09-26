/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storage;

import de.audi.atip.storage.NoSuchDataException;

public class ProviderFailedException
extends NoSuchDataException {
    private static final long serialVersionUID;

    public ProviderFailedException(int n, long l, Throwable throwable) {
        super(n, l, new StringBuffer().append("ProviderFailedException: ").append(throwable.getMessage()).toString());
    }

    public ProviderFailedException(int n, long l, String string) {
        super(n, l, new StringBuffer().append("ProviderFailedException: ").append(string).toString());
    }
}

