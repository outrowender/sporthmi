/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;

public interface ILastDestHandler {
    default public NavLocation getLastDestNavLocation(long l) {
    }

    default public SDSListEntry[] getLastDestListForSDS() {
    }

    default public SearchResult getLastDest(long l) {
    }

    default public byte[] getLastDestByteStream(int n) {
    }

    default public void languageChanged() {
    }

    default public NavCommand getLanguageChangedCommand() {
    }
}

