/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.contactimport;

import de.audi.app.messaging.core.contactimport.ParseVCardCommand;
import de.audi.app.messaging.core.contactimport.ParseVCardCommand$1;
import org.dsi.ifc.organizer.AdbEntry;

public final class ParseVCardCommand$Result {
    private final int resultCode;
    private final AdbEntry[] entries;
    private final /* synthetic */ ParseVCardCommand this$0;

    private ParseVCardCommand$Result(ParseVCardCommand parseVCardCommand, int n, AdbEntry[] adbEntryArray) {
        this.this$0 = parseVCardCommand;
        this.resultCode = n;
        this.entries = adbEntryArray;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public AdbEntry[] getEntries() {
        return this.entries;
    }

    /* synthetic */ ParseVCardCommand$Result(ParseVCardCommand parseVCardCommand, int n, AdbEntry[] adbEntryArray, ParseVCardCommand$1 parseVCardCommand$1) {
        this(parseVCardCommand, n, adbEntryArray);
    }
}

