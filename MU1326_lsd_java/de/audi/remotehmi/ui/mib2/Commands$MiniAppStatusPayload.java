/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.Commands$AbstractContextPayload;

public final class Commands$MiniAppStatusPayload
extends Commands$AbstractContextPayload {
    public final String hostingContext;

    public Commands$MiniAppStatusPayload(String string, String string2) {
        super(string);
        this.hostingContext = string2;
    }
}

