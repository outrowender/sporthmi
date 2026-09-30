/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.tghu.filebrowser.AbstractEvoFileListRow;
import de.audi.tghu.filebrowser.EvoFileListRow;
import de.audi.tghu.filebrowser.IEvoFileListRowBuilder;
import org.dsi.ifc.filebrowser.BrowsedFile;

public class DefaultEvoFileListRowBuilder
implements IEvoFileListRowBuilder {
    public AbstractEvoFileListRow buildRow(BrowsedFile browsedFile, int n) {
        return new EvoFileListRow(browsedFile, n);
    }
}

