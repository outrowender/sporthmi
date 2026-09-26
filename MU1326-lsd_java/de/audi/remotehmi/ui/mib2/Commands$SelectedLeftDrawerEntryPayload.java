/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.Commands$AbstractContextPayload;

public class Commands$SelectedLeftDrawerEntryPayload
extends Commands$AbstractContextPayload {
    public String idValue;

    public Commands$SelectedLeftDrawerEntryPayload(String string, String string2) {
        super(string2);
        this.idValue = string;
    }
}

