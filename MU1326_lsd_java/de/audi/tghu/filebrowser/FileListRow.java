/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import org.dsi.ifc.filebrowser.BrowsedFile;

public class FileListRow
extends ListRow {
    private static final int OFFSET_SELECTED = 2;
    private final BrowsedFile file;
    private final int offset;

    private static final boolean isFolder(BrowsedFile browsedFile) {
        return browsedFile.getFileType() == 3;
    }

    private static final ListCell[] file2Cells(BrowsedFile browsedFile, int n) {
        ListCell[] listCellArray = new ListCell[]{new TextListCell(browsedFile.getFilename()), new IntegerListCell(browsedFile.getFileType()), new IntegerListCell(browsedFile.isSelected() ? 1 : 0), new IntegerListCell(FileListRow.isFolder(browsedFile) ? 1 : 0), new LongListCell(browsedFile.getFileSize()), new LongListCell(browsedFile.getId()), new LongListCell(n), new ObjectListCell(browsedFile)};
        return listCellArray;
    }

    FileListRow(BrowsedFile browsedFile, int n) {
        super(FileListRow.file2Cells(browsedFile, n));
        this.file = browsedFile;
        this.offset = n;
    }

    public long getId() {
        return this.file.getId();
    }

    public final BrowsedFile getFile() {
        return this.file;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final boolean equals(Object object) {
        return object instanceof FileListRow && this.getId() == ((FileListRow)object).getId();
    }

    public final int hashCode() {
        return (int)this.getId();
    }

    public final void setSelected(boolean bl) {
        this.file.setSelected(bl);
        ((IntegerListCell)this.getCell(2)).setValue(this.file.isSelected() ? 1 : 0);
    }

    public final boolean isFolder() {
        return FileListRow.isFolder(this.getFile());
    }
}

