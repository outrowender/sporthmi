/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.AbstractEntryListRowData;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.guide.ITextLookup;
import org.dsi.ifc.messaging.ListEntry;

public interface IEntryListRowDataFactory {
    public AbstractEntryListRowData create(ListEntry var1, IEntryPropertyFactory var2, int var3, long var4, ITextLookup var6);
}

