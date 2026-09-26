/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$ICandidateItem;

public abstract class AbstractConversionWidgetController$AbstractCandidateItem
implements AbstractConversionWidgetController$ICandidateItem {
    private static int instanceCounter = 0;
    private final int id = ++instanceCounter;
    private int rowIndex;
    private int columnIndex;
    private boolean enabled;
    private int columnSpan;
    private int sourceIndex;
    private float width;

    public AbstractConversionWidgetController$AbstractCandidateItem() {
        this.reset();
    }

    @Override
    public void reset() {
        this.rowIndex = 0;
        this.columnIndex = 0;
        this.enabled = true;
        this.columnSpan = 1;
        this.width = 32959;
    }

    @Override
    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public int getRowIndex() {
        return this.rowIndex;
    }

    @Override
    public void setRowIndex(int n) {
        this.rowIndex = n;
    }

    @Override
    public int getColumnIndex() {
        return this.columnIndex;
    }

    @Override
    public void setColumnIndex(int n) {
        this.columnIndex = n;
    }

    @Override
    public int getColumnSpan() {
        return this.columnSpan;
    }

    @Override
    public void setColumnSpan(int n) {
        this.columnSpan = n;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setSourceIndex(int n) {
        this.sourceIndex = n;
    }

    @Override
    public int getSourceIndex() {
        return this.sourceIndex;
    }

    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(float f2) {
        this.width = f2;
    }

    public String toString() {
        return new Buffer("CandidateItem[").append("col=").append(this.getColumnIndex()).append("; row=").append(this.getRowIndex()).append("; colSpan=").append(this.getColumnSpan()).append("]").toString();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.columnIndex;
        n = 31 * n + this.columnSpan;
        n = 31 * n + (this.enabled ? 1231 : 1237);
        n = 31 * n + this.id;
        n = 31 * n + this.rowIndex;
        n = 31 * n + this.sourceIndex;
        n = 31 * n + Float.floatToIntBits(this.width);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof AbstractConversionWidgetController$AbstractCandidateItem)) {
            return false;
        }
        AbstractConversionWidgetController$AbstractCandidateItem abstractConversionWidgetController$AbstractCandidateItem = (AbstractConversionWidgetController$AbstractCandidateItem)object;
        if (this.columnIndex != abstractConversionWidgetController$AbstractCandidateItem.columnIndex) {
            return false;
        }
        if (this.columnSpan != abstractConversionWidgetController$AbstractCandidateItem.columnSpan) {
            return false;
        }
        if (this.enabled != abstractConversionWidgetController$AbstractCandidateItem.enabled) {
            return false;
        }
        if (this.id != abstractConversionWidgetController$AbstractCandidateItem.id) {
            return false;
        }
        if (this.rowIndex != abstractConversionWidgetController$AbstractCandidateItem.rowIndex) {
            return false;
        }
        if (this.sourceIndex != abstractConversionWidgetController$AbstractCandidateItem.sourceIndex) {
            return false;
        }
        return Float.floatToIntBits(this.width) == Float.floatToIntBits(abstractConversionWidgetController$AbstractCandidateItem.width);
    }
}

