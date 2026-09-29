/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.Commands$AbstractContextPayload;

public final class Commands$GrayoutRightDrawerEntryPayload
extends Commands$AbstractContextPayload {
    public final String entryId;
    public final String infoText;

    public Commands$GrayoutRightDrawerEntryPayload(String string, String string2, String string3) {
        super(string);
        this.entryId = string2;
        this.infoText = string3;
    }
}

