/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import org.dsi.ifc.organizer.AdbEntry;

public interface GetEntryCommand$ResultHandler {
    default public void handleResult(int n, AdbEntry adbEntry) {
    }
}

