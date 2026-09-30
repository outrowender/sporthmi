/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.ICursor;
import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridColumn;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IGridRow;
import de.audi.remotehmi.ui.mib2.grid.ISpeller;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.util.List;

public interface IGridFactory
extends DumpInfoProvider {
    public IGridList createGridList(int var1);

    public IGridList synchronizedGridList(IGridList var1);

    public IGridList partiallySynchronizedGridList(IGridList var1);

    public IGrid createGrid(int var1);

    public IGridRow createGridRow();

    public IGridRow createGridRow(int var1, int var2);

    public IGridColumn createGridColumn();

    public IGridColumn createGridColumn(String var1, int var2, int var3, int var4, int var5);

    public IGridCell createGridCell(int var1, int var2, int var3);

    public ICursor createCursor();

    public ICursor createCursor(ICursorComponent var1, ICursorComponent var2);

    public ICursor createCursor(ICursorComponent var1, ICursorComponent var2, boolean var3);

    public ICursorComponent createCursorComponent();

    public ICursorComponent createCursorComponent(int var1, int var2, String var3, String var4);

    public ISpeller createSpeller(int var1);

    public void notifyGridListCreated(IGridList var1);

    public List createSubmenuPreviewCells(int var1, int var2, IGridCell var3, IGridCell var4);
}

