/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.AbstractEntryListRowData;
import de.audi.app.messaging.core.folderbrowsing.IEntryListRowDataFactory;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.app.messaging.evo.folderbrowsing.EntryListRowDataEvo;
import org.dsi.ifc.messaging.ListEntry;

public class EntryListRowDataFactoryEvo
implements IEntryListRowDataFactory {
    @Override
    public AbstractEntryListRowData create(ListEntry listEntry, IEntryPropertyFactory iEntryPropertyFactory, int n, long l, ITextLookup iTextLookup) {
        return new EntryListRowDataEvo(listEntry, iEntryPropertyFactory, n, l, iTextLookup);
    }
}

