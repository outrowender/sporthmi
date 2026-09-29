/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IAxisConstraints;

public class AxisConstraints
implements IAxisConstraints,
Cloneable {
    public final int length;
    public int[] size;
    public int[] min;
    public int[] max;
    public int[] gaps;
    public int[] alignment;
    public float[] grow;
    public float[] shrink;
    public int[] tabulatorIDs;
    public int[] hidemode;

    public AxisConstraints(int n) {
        this.length = n;
    }

    @Override
    public boolean hasFixedSize(int n) {
        return this.size != null && this.size[n] >= 0;
    }

    @Override
    public boolean isGrowing(int n) {
        return this.grow != null && this.grow[n] > 0.0f;
    }

    @Override
    public boolean isShrinking(int n) {
        return this.shrink == null || this.shrink[n] > 0.0f;
    }

    @Override
    public float getGrowWeight(int n) {
        if (this.grow == null) {
            return 0.0f;
        }
        return this.grow[n];
    }

    @Override
    public boolean hasGrowWeight(int n) {
        return this.grow != null && this.grow.length > n;
    }

    @Override
    public float getShrinkWeight(int n) {
        if (this.shrink == null) {
            return 1.0f;
        }
        return this.shrink[n];
    }

    @Override
    public boolean hasShrinkWeight(int n) {
        return this.shrink != null && this.shrink.length > n;
    }

    @Override
    public int getHidemode(int n) {
        if (this.hidemode == null) {
            return 0;
        }
        return this.hidemode[n];
    }

    @Override
    public boolean hasHidemode(int n) {
        return this.hidemode != null && this.hidemode.length > n;
    }

    @Override
    public float getResizeWeight(boolean bl, int n) {
        return bl ? this.getGrowWeight(n) : this.getShrinkWeight(n);
    }

    @Override
    public boolean hasResizeWeights(boolean bl) {
        float[] fArray = bl ? this.grow : this.shrink;
        return fArray != null;
    }

    public void setSize(int[] nArray) {
        this.size = nArray;
    }

    public void setMin(int[] nArray) {
        this.min = nArray;
    }

    public void setMax(int[] nArray) {
        this.max = nArray;
    }

    public void setGaps(int[] nArray) {
        this.gaps = nArray;
    }

    public void setAlignment(int[] nArray) {
        this.alignment = nArray;
    }

    public void setGrow(float[] fArray) {
        this.grow = fArray;
    }

    public void setShrink(float[] fArray) {
        this.shrink = fArray;
    }

    public void setTabulatorIDs(int[] nArray) {
        this.tabulatorIDs = nArray;
    }

    public void setHidemode(int[] nArray) {
        this.hidemode = nArray;
    }

    @Override
    public int getAlignment(int n) {
        return this.alignment != null ? this.alignment[n] : -1;
    }

    @Override
    public boolean hasAlignment(int n) {
        return this.alignment != null && this.alignment.length > n;
    }

    @Override
    public int getGap(int n) {
        return this.gaps != null ? this.gaps[n] : 0;
    }

    @Override
    public boolean hasGap(int n) {
        return this.gaps != null && this.gaps.length > n;
    }

    @Override
    public int getSize(int n) {
        return this.size != null ? this.size[n] : -1;
    }

    @Override
    public boolean hasSize(int n) {
        return this.size != null && this.size.length > n;
    }

    @Override
    public int getMax(int n) {
        return this.max != null ? this.max[n] : -1;
    }

    @Override
    public boolean hasMax(int n) {
        return this.max != null && this.max.length > n;
    }

    @Override
    public int getMin(int n) {
        return this.min != null ? this.min[n] : -1;
    }

    @Override
    public boolean hasMin(int n) {
        return this.min != null && this.min.length > n;
    }

    @Override
    public int getTabulatorID(int n) {
        return this.tabulatorIDs != null ? this.tabulatorIDs[n] : -1;
    }

    @Override
    public boolean hasTabulatorAtIndex(int n) {
        return this.tabulatorIDs != null && this.tabulatorIDs.length > n;
    }

    @Override
    public boolean hasTabulatorWithID(int n) {
        if (this.tabulatorIDs == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.tabulatorIDs.length; ++i2) {
            if (n != this.tabulatorIDs[i2]) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasTabulatorIDs() {
        return this.tabulatorIDs != null;
    }

    @Override
    public int[] getTabulatorIDs() {
        return this.tabulatorIDs;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.toStringGap(0));
        for (int i2 = 0; i2 < this.length; ++i2) {
            buffer.append(" [").append(this.toStringCell(i2)).append("]");
            buffer.append(this.toStringGap(i2 + 1));
        }
        return buffer.toString();
    }

    protected String toStringGap(int n) {
        Buffer buffer = new Buffer();
        if (this.gaps != null && this.gaps.length > n && this.gaps[n] != 0) {
            buffer.append(" ").append(this.gaps[n]);
        }
        if (this.tabulatorIDs != null && this.tabulatorIDs.length > n && this.tabulatorIDs[n] != -1) {
            if (buffer.length() > 0) {
                buffer.append(",");
            }
            buffer.append(" ");
            buffer.append("tab:").append(this.tabulatorIDs[n]);
        }
        return buffer.toString();
    }

    private String toStringCell(int n) {
        Buffer buffer = new Buffer();
        if (this.min != null && this.min.length > n && this.min[n] != -1) {
            buffer.append(this.min[n]).append(":");
        }
        if (this.size != null && this.size.length > n && this.size[n] != -1) {
            buffer.append(this.size[n]);
        }
        if (this.max != null && this.max.length > n && this.max[n] != -1) {
            buffer.append(":").append(this.max[n]);
        }
        if (this.alignment != null && this.alignment.length > n) {
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append("align: ").append(this.alignment[n]);
        }
        if (this.grow != null && this.grow.length > n && this.grow[n] != 0.0f) {
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append("grow: ").append(this.grow[n]);
        }
        if (this.shrink != null && this.shrink.length > n && this.shrink[n] != 1.0f) {
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append("shrink: ").append(this.shrink[n]);
        }
        if (this.hidemode != null && this.hidemode.length > n && this.hidemode[n] != 0) {
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append("hidemode: ").append(this.hidemode[n]);
        }
        return buffer.toString();
    }

    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            // empty catch block
        }
        return object;
    }
}

