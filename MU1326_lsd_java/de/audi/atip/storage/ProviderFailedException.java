/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storage;

import de.audi.atip.storage.NoSuchDataException;

public class ProviderFailedException
extends NoSuchDataException {
    private static final long serialVersionUID = -1828052353894720544L;

    public ProviderFailedException(int n, long l, Throwable throwable) {
        super(n, l, "ProviderFailedException: " + throwable.getMessage());
    }

    public ProviderFailedException(int n, long l, String string) {
        super(n, l, "ProviderFailedException: " + string);
    }
}

