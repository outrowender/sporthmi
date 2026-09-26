/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.settings.SetSmscNumberCommand;
import de.audi.app.messaging.core.settings.SetSmscNumberCommand$1;

public final class SetSmscNumberCommand$Result {
    private final int resultCode;
    private final /* synthetic */ SetSmscNumberCommand this$0;

    private SetSmscNumberCommand$Result(SetSmscNumberCommand setSmscNumberCommand, int n) {
        this.this$0 = setSmscNumberCommand;
        this.resultCode = n;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    /* synthetic */ SetSmscNumberCommand$Result(SetSmscNumberCommand setSmscNumberCommand, int n, SetSmscNumberCommand$1 setSmscNumberCommand$1) {
        this(setSmscNumberCommand, n);
    }
}

