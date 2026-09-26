/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.Commands$AbstractContextPayload;

public final class Commands$RightDrawerStatePayload
extends Commands$AbstractContextPayload {
    public final String entryId;
    public final String value;

    public Commands$RightDrawerStatePayload(String string, String string2, String string3) {
        super(string);
        this.entryId = string2;
        this.value = string3;
    }
}

