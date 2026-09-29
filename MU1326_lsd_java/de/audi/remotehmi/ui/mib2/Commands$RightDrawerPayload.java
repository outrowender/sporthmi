/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.Commands$AbstractContextPayload;
import java.util.List;

public final class Commands$RightDrawerPayload
extends Commands$AbstractContextPayload {
    public List rightDrawerEntriesList;

    public Commands$RightDrawerPayload(String string, List list) {
        super(string);
        this.rightDrawerEntriesList = list;
    }
}

