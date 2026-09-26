/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.addressbook.GetEntryCommand$ResultHandler;
import de.audi.app.messaging.core.compose.AbstractOrganizerSearch;
import org.dsi.ifc.organizer.AdbEntry;

class AbstractOrganizerSearch$1
implements GetEntryCommand$ResultHandler {
    private final /* synthetic */ AbstractOrganizerSearch this$0;

    AbstractOrganizerSearch$1(AbstractOrganizerSearch abstractOrganizerSearch) {
        this.this$0 = abstractOrganizerSearch;
    }

    @Override
    public void handleResult(int n, AdbEntry adbEntry) {
        this.this$0.handleGetEntryResult(adbEntry);
    }
}

