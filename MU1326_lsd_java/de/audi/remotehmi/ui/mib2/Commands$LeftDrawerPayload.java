/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.ui.mib2.Commands$AbstractContextPayload;
import java.util.List;

public final class Commands$LeftDrawerPayload
extends Commands$AbstractContextPayload {
    public List leftDrawerEntriesList;

    public Commands$LeftDrawerPayload(String string, List list) {
        super(string);
        this.leftDrawerEntriesList = list;
    }
}

