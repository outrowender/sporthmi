/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.tghu.filebrowser.AbstractEvoFileListRow;
import org.dsi.ifc.filebrowser.BrowsedFile;

public interface IEvoFileListRowBuilder {
    public AbstractEvoFileListRow buildRow(BrowsedFile var1, int var2);
}

