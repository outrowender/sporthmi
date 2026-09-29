/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public interface IAxisConstraints
extends WidgetConstants {
    public static final int DEFAULT_SHRINK_WEIGHT;
    public static final int DEFAULT_GROW_WEIGHT;
    public static final int DEFAULT_GAP;
    public static final int DEFAULT_HIDEMODE;
    public static final int DEFAULT_ALIGNMENT;
    public static final int DEFAULT_MAX;
    public static final int DEFAULT_MIN;
    public static final int DEFAULT_SIZE;
    public static final int DEFAULT_TABULATOR_ID;

    default public boolean hasFixedSize(int n) {
    }

    default public boolean isGrowing(int n) {
    }

    default public boolean isShrinking(int n) {
    }

    default public float getGrowWeight(int n) {
    }

    default public boolean hasGrowWeight(int n) {
    }

    default public float getShrinkWeight(int n) {
    }

    default public boolean hasShrinkWeight(int n) {
    }

    default public int getHidemode(int n) {
    }

    default public boolean hasHidemode(int n) {
    }

    default public float getResizeWeight(boolean bl, int n) {
    }

    default public boolean hasResizeWeights(boolean bl) {
    }

    default public int getAlignment(int n) {
    }

    default public boolean hasAlignment(int n) {
    }

    default public int getGap(int n) {
    }

    default public boolean hasGap(int n) {
    }

    default public int getSize(int n) {
    }

    default public boolean hasSize(int n) {
    }

    default public int getMax(int n) {
    }

    default public boolean hasMax(int n) {
    }

    default public int getMin(int n) {
    }

    default public boolean hasMin(int n) {
    }

    default public int getTabulatorID(int n) {
    }

    default public boolean hasTabulatorAtIndex(int n) {
    }

    default public boolean hasTabulatorWithID(int n) {
    }

    default public boolean hasTabulatorIDs() {
    }

    default public int[] getTabulatorIDs() {
    }

    default public int getLength() {
    }
}

