/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.filebrowser.BrowsedFile;

public abstract class AbstractEvoFileListRow
extends EvoListRow {
    protected BrowsedFile browsedFile;
    protected int fileOffset;

    public AbstractEvoFileListRow(BrowsedFile browsedFile, int n, int n2) {
        super(browsedFile.getId(), n2);
        this.browsedFile = browsedFile;
        this.fileOffset = n;
    }

    public int getOffset() {
        return this.fileOffset;
    }

    public BrowsedFile getBrowsedFile() {
        return this.browsedFile;
    }

    public void setSelected(boolean bl) {
        this.browsedFile.setSelected(bl);
    }

    public boolean isSelected() {
        return this.browsedFile.isSelected();
    }

    public boolean isFolder() {
        return 3 == this.browsedFile.getFileType();
    }
}

