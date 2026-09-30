/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.online.IGridListRow;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.esolutions.hmi.widgets.audi.evo.online.WidgetUtilities;
import java.util.ArrayList;
import java.util.List;

public class GridListRow
extends EvoListRow
implements IGridListRow {
    private IGrid grid;
    public static final int COLUMN_RECORD_SET = 0;
    public static final int COLUMN_FOCUSABLE = 1;
    public static final int COLUMN_DRAWER_PROPERTY = 2;
    public static final int COLUMN_GENERATION = 3;
    public static final int COLUMN_SHOW_SPEAKABLE_LINE_NUMBER = 4;
    public static final int COLUMN_INFO_LINE = 5;
    public static final int COLUMN_COUNT = 6;
    private boolean deletableIfOffscreen = false;
    private List rowsToInsertIfOffscreen = new ArrayList();

    protected GridListRow(GridListRow gridListRow) {
        super(gridListRow);
        IGrid iGrid = gridListRow.grid;
        if (iGrid != null) {
            this.setGridAndLayout((IGrid)iGrid.clone(true), gridListRow.getLayoutType());
        }
        this.rowsToInsertIfOffscreen = gridListRow.rowsToInsertIfOffscreen;
        this.deletableIfOffscreen = gridListRow.deletableIfOffscreen;
    }

    public GridListRow(long l) {
        super(l, 6);
        this.setPropertyCell(2, PropertyListCell.EMPTY_CELL);
    }

    public EvoListRow copy() {
        return new GridListRow(this);
    }

    public EvoListRow withId(long l) {
        GridListRow gridListRow = new GridListRow(l);
        gridListRow.setGridAndLayout(this.grid, this.getLayoutType());
        gridListRow.setRowsToInsertIfOffscreen(this.rowsToInsertIfOffscreen);
        gridListRow.setDeletableIfOffscreen(this.deletableIfOffscreen);
        return gridListRow;
    }

    public final void setGridAndLayout(IGrid iGrid, int n) {
        if (iGrid == null) {
            throw new IllegalArgumentException("ignoring: null given as new grid for old GridListRow=" + this);
        }
        this.grid = iGrid;
        Object object = this.getCell(3);
        int n2 = object instanceof Integer ? (Integer)object : 0;
        this.setInteger(3, n2 + 1);
        IGrid iGrid2 = WidgetUtilities.getLayoutedGrid(iGrid, n);
        if (iGrid2 == null) {
            iGrid2 = iGrid;
        }
        this.setInteger(0, GridListRow.calculateRecordSet(n, (int)this.getUniqueID()));
        this.setInteger(1, iGrid2.isFocusable() ? 1 : 0);
        this.setInteger(4, iGrid2.isLineNumberSpeakable() ? 2 : 0);
        this.setText(5, iGrid2.getInfoText());
    }

    public final IGrid getGrid() {
        return this.grid;
    }

    public final Object getGridObject() {
        return this.grid;
    }

    public boolean isArtificial() {
        return this.grid != null && this.grid.isArtificial();
    }

    public int getLayoutType() {
        int n = this.getInteger(0);
        return GridListRow.calculateLayoutType(n);
    }

    public String getGridId() {
        return this.grid == null ? "" : this.grid.getId();
    }

    public boolean isDeletableIfOffscreen() {
        return this.deletableIfOffscreen;
    }

    public void setDeletableIfOffscreen(boolean bl) {
        this.deletableIfOffscreen = bl;
    }

    public List getRowsToInsertIfOffscreen() {
        return this.rowsToInsertIfOffscreen;
    }

    private void setRowsToInsertIfOffscreen(List list) {
        this.rowsToInsertIfOffscreen = list;
    }

    public boolean hasReplacement() {
        if (this.rowsToInsertIfOffscreen.isEmpty()) {
            return false;
        }
        GridListRow gridListRow = (GridListRow)this.rowsToInsertIfOffscreen.get(0);
        return gridListRow.getGridId().equals(this.getGridId());
    }

    public String toString() {
        int n = this.rowsToInsertIfOffscreen.size();
        GridListRow gridListRow = n == 0 ? null : (GridListRow)this.rowsToInsertIfOffscreen.get(0);
        return "GridListRow [uniqueId=" + this.getUniqueID() + ", deletableIfOffscreen=" + this.deletableIfOffscreen + ", rowsToInsertIfOffscreen=" + n + ", grid=" + this.grid + ", firstSubrow=" + gridListRow + "]";
    }

    public static int calculateLayoutType(int n) {
        return n % 4;
    }

    public static int calculateRecordSet(int n, int n2) {
        return (n2 + 1) * 4 + n;
    }
}

