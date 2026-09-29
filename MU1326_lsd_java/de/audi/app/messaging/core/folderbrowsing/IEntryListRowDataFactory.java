/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.AbstractEntryListRowData;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.guide.ITextLookup;
import org.dsi.ifc.messaging.ListEntry;

public interface IEntryListRowDataFactory {
    default public AbstractEntryListRowData create(ListEntry listEntry, IEntryPropertyFactory iEntryPropertyFactory, int n, long l, ITextLookup iTextLookup) {
    }
}

