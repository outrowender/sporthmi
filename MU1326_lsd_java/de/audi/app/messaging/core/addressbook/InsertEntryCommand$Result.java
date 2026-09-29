/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.messaging.core.addressbook.InsertEntryCommand;
import de.audi.app.messaging.core.addressbook.InsertEntryCommand$1;

public final class InsertEntryCommand$Result {
    private final int resultCode;
    private final /* synthetic */ InsertEntryCommand this$0;

    private InsertEntryCommand$Result(InsertEntryCommand insertEntryCommand, int n) {
        this.this$0 = insertEntryCommand;
        this.resultCode = n;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    /* synthetic */ InsertEntryCommand$Result(InsertEntryCommand insertEntryCommand, int n, InsertEntryCommand$1 insertEntryCommand$1) {
        this(insertEntryCommand, n);
    }
}

