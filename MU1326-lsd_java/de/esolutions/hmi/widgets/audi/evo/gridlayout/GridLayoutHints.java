/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;

public class GridLayoutHints
implements IGridLayoutHints {
    public int column;
    public int row;
    public int columnSpan = 1;
    public int rowSpan = 1;
    public int widthMin = 0;
    public int widthMax = -1;
    public int heightMin = 0;
    public int heightMax = -1;
    public int alignmentHoriz = -1;
    public int alignmentVert = -1;
    public int overlapGaps = 0;
    public int visibleConditions = -1;
    public int hidemode = -1;
    public boolean ignoreForCellSizes = false;
    public int[] afterEffects;

    public GridLayoutHints(int n, int n2) {
        this.column = n;
        this.row = n2;
    }

    public GridLayoutHints(int n, int n2, int n3, int n4) {
        this.column = n;
        this.row = n2;
        this.columnSpan = n3;
        this.rowSpan = n4;
    }

    @Override
    public boolean shouldShow(int n) {
        int n2 = this.visibleConditions & n;
        return n2 == n;
    }

    public void setVisibleForState(int n, boolean bl) {
        this.visibleConditions = bl ? (this.visibleConditions |= n) : (this.visibleConditions &= ~n);
    }

    @Override
    public int compareTo(Object object) {
        if (object instanceof GridLayoutHints) {
            GridLayoutHints gridLayoutHints = (GridLayoutHints)object;
            int n = this.row - gridLayoutHints.row;
            if (n != 0) {
                return n;
            }
            int n2 = this.column - gridLayoutHints.column;
            if (n2 != 0) {
                return n2;
            }
            int n3 = this.columnSpan - gridLayoutHints.columnSpan;
            if (n3 != 0) {
                return n3;
            }
            int n4 = this.rowSpan - gridLayoutHints.rowSpan;
            if (n4 != 0) {
                return n4;
            }
            int n5 = this.overlapGaps - gridLayoutHints.overlapGaps;
            if (n5 != 0) {
                return n5;
            }
            if (this.ignoreForCellSizes != gridLayoutHints.ignoreForCellSizes) {
                return this.ignoreForCellSizes ? 1 : -1;
            }
            return 0;
        }
        return -1;
    }

    public void setColumn(int n) {
        this.column = n;
    }

    public void setRow(int n) {
        this.row = n;
    }

    public void setColumnSpan(int n) {
        this.columnSpan = n;
    }

    public void setRowSpan(int n) {
        this.rowSpan = n;
    }

    public void setWidthMin(int n) {
        this.widthMin = n;
    }

    public void setWidthMax(int n) {
        this.widthMax = n;
    }

    public void setHeightMin(int n) {
        this.heightMin = n;
    }

    public void setHeightMax(int n) {
        this.heightMax = n;
    }

    public void setAlignmentHoriz(int n) {
        this.alignmentHoriz = n;
    }

    public void setAlignmentVert(int n) {
        this.alignmentVert = n;
    }

    public void setVisibleConditions(int n) {
        this.visibleConditions = n;
    }

    public void setHidemode(int n) {
        this.hidemode = n;
    }

    @Override
    public int getOverlapGaps() {
        return this.overlapGaps;
    }

    public void setOverlapGaps(int n) {
        this.overlapGaps = n;
    }

    @Override
    public boolean isIgnoreForCellSizes() {
        return this.ignoreForCellSizes;
    }

    public void setIgnoreForCellSizes(boolean bl) {
        this.ignoreForCellSizes = bl;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumnSpan() {
        return this.columnSpan;
    }

    @Override
    public int getRowSpan() {
        return this.rowSpan;
    }

    @Override
    public int getWidthMin() {
        return this.widthMin;
    }

    @Override
    public int getWidthMax() {
        return this.widthMax;
    }

    @Override
    public int getHeightMin() {
        return this.heightMin;
    }

    @Override
    public int getHeightMax() {
        return this.heightMax;
    }

    @Override
    public int getAlignmentHoriz() {
        return this.alignmentHoriz;
    }

    @Override
    public int getAlignmentVert() {
        return this.alignmentVert;
    }

    @Override
    public int getVisibleConditions() {
        return this.visibleConditions;
    }

    @Override
    public int getHidemode() {
        return this.hidemode;
    }

    @Override
    public int getAdditionalXOffset() {
        return this.afterEffects == null ? 0 : this.afterEffects[0];
    }

    @Override
    public int getAdditionalYOffset() {
        return this.afterEffects == null ? 0 : this.afterEffects[1];
    }

    @Override
    public int getAdditionalWidthOffset() {
        return this.afterEffects == null ? 0 : this.afterEffects[2];
    }

    @Override
    public int getAdditionalHeightOffset() {
        return this.afterEffects == null ? 0 : this.afterEffects[3];
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("pos: ").append(this.column).append("/").append(this.row);
        if (this.columnSpan != 1 || this.rowSpan != 1) {
            buffer.append(", span: ").append(this.columnSpan).append("/").append(this.rowSpan);
        }
        if (this.alignmentHoriz != -1 || this.alignmentVert != -1) {
            buffer.append(", align horiz: ").append(this.alignmentHoriz).append(", vert: ").append(this.alignmentVert);
        }
        if (this.widthMin != 0 || this.widthMax != -1) {
            buffer.append(", width min: ").append(this.widthMin).append(", max").append(this.widthMax);
        }
        if (this.heightMin != 0 || this.heightMax != -1) {
            buffer.append(", height min: ").append(this.heightMin).append(", max").append(this.heightMax);
        }
        if (this.hidemode != -1) {
            buffer.append(", hidemode: ").append(this.hidemode);
        }
        if (this.visibleConditions != -1) {
            buffer.append(", visible: ").append(this.visibleConditions);
        }
        if (this.ignoreForCellSizes) {
            buffer.append(", ignoreForCellSizes");
        }
        if (this.overlapGaps != 0) {
            buffer.append(", overlapGaps: ");
            boolean bl = true;
            if ((this.overlapGaps & 1) != 0) {
                buffer.append("top");
                bl = false;
            }
            if ((this.overlapGaps & 4) != 0) {
                if (!bl) {
                    buffer.append("-");
                }
                buffer.append("left");
                bl = false;
            }
            if ((this.overlapGaps & 8) != 0) {
                if (!bl) {
                    buffer.append("-");
                }
                buffer.append("right");
                bl = false;
            }
            if ((this.overlapGaps & 2) != 0) {
                if (!bl) {
                    buffer.append("-");
                }
                buffer.append("bottom");
            }
        }
        if (this.afterEffects != null) {
            buffer.append(", afterEffects (xywh): ").append(this.getAdditionalXOffset()).append("/").append(this.getAdditionalYOffset());
            buffer.append("/").append(this.getAdditionalWidthOffset()).append("/").append(this.getAdditionalHeightOffset());
        }
        return buffer.toString();
    }

    public void setAfterEffects(int n, int n2, int n3, int n4) {
        if (this.afterEffects == null) {
            this.afterEffects = new int[4];
        }
        this.afterEffects[0] = n;
        this.afterEffects[1] = n2;
        this.afterEffects[2] = n3;
        this.afterEffects[3] = n4;
    }
}

