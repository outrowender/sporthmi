/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.esolutions.hmi.widgets.audi.evo.online.GridListModel;
import de.esolutions.hmi.widgets.audi.evo.online.GridListRow;
import de.esolutions.hmi.widgets.audi.evo.online.RowInfo;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class GridListModel$RowSubrowIterator
implements ListIterator {
    private int currentIndex;
    private int currentSubindex;
    private final /* synthetic */ GridListModel this$0;

    public GridListModel$RowSubrowIterator(GridListModel gridListModel, int n, int n2) {
        this.this$0 = gridListModel;
        this.currentIndex = n;
        this.currentSubindex = n2;
    }

    @Override
    public boolean hasNext() {
        return this.this$0.getRowInfoAfter(this.currentIndex, this.currentSubindex).getRow() != null;
    }

    @Override
    public Object next() {
        RowInfo rowInfo = this.this$0.getRowInfoAfter(this.currentIndex, this.currentSubindex);
        if (rowInfo.getRow() == null) {
            throw new NoSuchElementException();
        }
        this.currentIndex = rowInfo.getIndex();
        this.currentSubindex = rowInfo.getSubindex();
        return rowInfo.getRow();
    }

    @Override
    public boolean hasPrevious() {
        return this.this$0.getRowAt(this.currentIndex, this.currentSubindex) != null;
    }

    @Override
    public Object previous() {
        GridListRow gridListRow = this.this$0.getRowAt(this.currentIndex, this.currentSubindex);
        if (gridListRow == null) {
            throw new NoSuchElementException();
        }
        RowInfo rowInfo = this.this$0.getRowInfoBefore(this.currentIndex, this.currentSubindex);
        this.currentIndex = rowInfo.getIndex();
        this.currentSubindex = rowInfo.getSubindex();
        return gridListRow;
    }

    public RowInfo nextRowInfo() {
        return this.this$0.getRowInfoAfter(this.currentIndex, this.currentSubindex);
    }

    public RowInfo previousRowInfo() {
        return this.this$0.getRowInfo(this.currentIndex, this.currentSubindex);
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException("nextIndex");
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException("previousIndex");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    public void add(Object object) {
        throw new UnsupportedOperationException("add");
    }

    @Override
    public void set(Object object) {
        throw new UnsupportedOperationException("set");
    }
}

