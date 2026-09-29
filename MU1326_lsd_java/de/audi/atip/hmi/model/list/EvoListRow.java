/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class EvoListRow
implements GuiListRow {
    private final Object[] cells;
    private final int columns;
    private final long uniqueID;

    protected EvoListRow(EvoListRow evoListRow) {
        if (evoListRow != null) {
            this.uniqueID = evoListRow.uniqueID;
            this.columns = evoListRow.columns;
            this.cells = new Object[evoListRow.cells.length];
            System.arraycopy((Object)evoListRow.cells, 0, (Object)this.cells, 0, this.cells.length);
        } else {
            this.uniqueID = -1L;
            this.columns = 0;
            this.cells = null;
        }
    }

    public EvoListRow(long l, int n) {
        this.uniqueID = l;
        this.columns = n;
        this.cells = new Object[n];
    }

    @Override
    public final long getUniqueID() {
        return this.uniqueID;
    }

    @Override
    public final int getColumnCount() {
        return this.columns;
    }

    @Override
    public final int getInteger(int n) {
        return (Integer)this.getCell(n);
    }

    @Override
    public final long getLong(int n) {
        return (Long)this.getCell(n);
    }

    @Override
    public final String getText(int n) {
        return (String)this.getCell(n);
    }

    public final EvoListRow setMetrics(int n, AbstractMetrics abstractMetrics) {
        return this.setCell(n, abstractMetrics);
    }

    @Override
    public final AbstractMetrics getMetrics(int n) {
        return (AbstractMetrics)this.getCell(n);
    }

    public final EvoListRow setInteger(int n, int n2) {
        return this.setCell(n, Util.createInteger(n2));
    }

    public final EvoListRow setLong(int n, long l) {
        return this.setCell(n, Util.createLong(l));
    }

    public final EvoListRow setText(int n, String string) {
        return this.setCell(n, string);
    }

    public final EvoListRow setHMIResourceLocator(int n, HMIResourceLocator hMIResourceLocator) {
        return this.setCell(n, hMIResourceLocator);
    }

    public final EvoListRow setPropertyCell(int n, PropertyListCell propertyListCell) {
        return this.setCell(n, propertyListCell);
    }

    public final EvoListRow setIconCell(int n, IconCell iconCell) {
        return this.setCell(n, iconCell);
    }

    public final EvoListRow setHighlightTextCell(int n, TextListCellHighlightText textListCellHighlightText) {
        return this.setCell(n, textListCellHighlightText);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object getCell(int n) {
        if (n < 0 || n >= this.cells.length) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid col:").append(n).append(" - #col:").append(this.columns).toString());
        }
        Object[] objectArray = this.cells;
        synchronized (this.cells) {
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return this.cells[n];
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private EvoListRow setCell(int n, Object object) {
        if (n < 0 || n >= this.cells.length) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid col:").append(n).append(" - #col:").append(this.columns).toString());
        }
        Object[] objectArray = this.cells;
        synchronized (this.cells) {
            this.cells[n] = object;
            // ** MonitorExit[var3_3] (shouldn't be in output)
            return this;
        }
    }

    public String toString() {
        if (this.cells == null) {
            return super.toString();
        }
        Buffer buffer = new Buffer();
        buffer.append("UniqueID:").append(this.uniqueID);
        for (int i2 = 0; i2 < this.columns; ++i2) {
            buffer.append(" [").append(i2).append(']');
            Object object = this.getCell(i2);
            buffer.append(object != null ? object : "null");
        }
        return buffer.toString();
    }

    public int hashCode() {
        return (int)(this.uniqueID ^ this.uniqueID >>> 32);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof EvoListRow)) {
            return false;
        }
        return this.uniqueID == ((EvoListRow)object).uniqueID;
    }

    public EvoListRow copy() {
        return new EvoListRow(this);
    }
}

