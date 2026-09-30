/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;

public interface ILastDestHandler {
    public NavLocation getLastDestNavLocation(long var1);

    public SDSListEntry[] getLastDestListForSDS();

    public SearchResult getLastDest(long var1);

    public byte[] getLastDestByteStream(int var1);

    public void languageChanged();

    public NavCommand getLanguageChangedCommand();
}

