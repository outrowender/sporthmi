/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public interface IAxisConstraints
extends WidgetConstants {
    public static final int DEFAULT_SHRINK_WEIGHT = 1;
    public static final int DEFAULT_GROW_WEIGHT = 0;
    public static final int DEFAULT_GAP = 0;
    public static final int DEFAULT_HIDEMODE = 0;
    public static final int DEFAULT_ALIGNMENT = -1;
    public static final int DEFAULT_MAX = -1;
    public static final int DEFAULT_MIN = -1;
    public static final int DEFAULT_SIZE = -1;
    public static final int DEFAULT_TABULATOR_ID = -1;

    public boolean hasFixedSize(int var1);

    public boolean isGrowing(int var1);

    public boolean isShrinking(int var1);

    public float getGrowWeight(int var1);

    public boolean hasGrowWeight(int var1);

    public float getShrinkWeight(int var1);

    public boolean hasShrinkWeight(int var1);

    public int getHidemode(int var1);

    public boolean hasHidemode(int var1);

    public float getResizeWeight(boolean var1, int var2);

    public boolean hasResizeWeights(boolean var1);

    public int getAlignment(int var1);

    public boolean hasAlignment(int var1);

    public int getGap(int var1);

    public boolean hasGap(int var1);

    public int getSize(int var1);

    public boolean hasSize(int var1);

    public int getMax(int var1);

    public boolean hasMax(int var1);

    public int getMin(int var1);

    public boolean hasMin(int var1);

    public int getTabulatorID(int var1);

    public boolean hasTabulatorAtIndex(int var1);

    public boolean hasTabulatorWithID(int var1);

    public boolean hasTabulatorIDs();

    public int[] getTabulatorIDs();

    public int getLength();
}

