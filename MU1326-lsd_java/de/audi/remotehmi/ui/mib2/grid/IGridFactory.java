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
    default public IGridList createGridList(int n) {
    }

    default public IGridList synchronizedGridList(IGridList iGridList) {
    }

    default public IGridList partiallySynchronizedGridList(IGridList iGridList) {
    }

    default public IGrid createGrid(int n) {
    }

    default public IGridRow createGridRow() {
    }

    default public IGridRow createGridRow(int n, int n2) {
    }

    default public IGridColumn createGridColumn() {
    }

    default public IGridColumn createGridColumn(String string, int n, int n2, int n3, int n4) {
    }

    default public IGridCell createGridCell(int n, int n2, int n3) {
    }

    default public ICursor createCursor() {
    }

    default public ICursor createCursor(ICursorComponent iCursorComponent, ICursorComponent iCursorComponent2) {
    }

    default public ICursor createCursor(ICursorComponent iCursorComponent, ICursorComponent iCursorComponent2, boolean bl) {
    }

    default public ICursorComponent createCursorComponent() {
    }

    default public ICursorComponent createCursorComponent(int n, int n2, String string, String string2) {
    }

    default public ISpeller createSpeller(int n) {
    }

    default public void notifyGridListCreated(IGridList iGridList) {
    }

    default public List createSubmenuPreviewCells(int n, int n2, IGridCell iGridCell, IGridCell iGridCell2) {
    }
}

