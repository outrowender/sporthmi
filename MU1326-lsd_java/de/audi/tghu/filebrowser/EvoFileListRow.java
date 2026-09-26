/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.filebrowser.AbstractEvoFileListRow;
import org.dsi.ifc.filebrowser.BrowsedFile;

public class EvoFileListRow
extends AbstractEvoFileListRow {
    protected static final int COLUMNS;
    protected static final int IDX_FILE_NAME;
    protected static final int IDX_FILE_TYPE;
    protected static final int IDX_SELECTED;
    protected static final int IDX_FOLDER;
    protected static final int IDX_FILE_SIZE;
    protected static final int IDX_FILE_ID;
    protected static final int IDX_FILE_OFFSET;
    protected static final int IDX_FILE;

    public EvoFileListRow(BrowsedFile browsedFile, int n) {
        super(browsedFile, n, 8);
        this.setRowData();
    }

    protected void setRowData() {
        this.setText(0, this.getBrowsedFile().getFilename());
        this.setInteger(1, this.getBrowsedFile().getFileType());
        this.setInteger(2, this.isSelected() ? 1 : 0);
        this.setInteger(3, this.isFolder() ? 1 : 0);
        this.setLong(4, this.getBrowsedFile().getFileSize());
        this.setLong(5, this.getBrowsedFile().getId());
        this.setLong(6, this.getOffset());
    }

    @Override
    public boolean equals(Object object) {
        return null != object && object instanceof EvoFileListRow && this.getUniqueID() == ((EvoFileListRow)object).getUniqueID();
    }

    @Override
    public int hashCode() {
        long l = this.getUniqueID();
        return (int)(l ^ l >>> 32);
    }

    @Override
    public EvoListRow copy() {
        return new EvoFileListRow(this.getBrowsedFile(), this.getOffset());
    }

    @Override
    public void setSelected(boolean bl) {
        super.setSelected(bl);
        this.setInteger(2, bl ? 1 : 0);
    }
}

