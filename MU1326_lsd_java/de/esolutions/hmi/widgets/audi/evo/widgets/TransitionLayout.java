/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.LayoutManagerSimulation;

public class TransitionLayout
implements LayoutManager {
    private AbstractWidget[] widgets;
    private int[][] oldChildrenBounds;
    private int[][] newChildrenBounds;
    private int oldPreferredHeight;
    private int newPreferredHeight;
    private int oldPreferredWidth;
    private int newPreferredWidth;
    private float progress;
    private boolean animatePreferredSize;
    private LayoutManagerSimulation newLayoutManager;
    private int newWidthHint;
    private int newHeightHint;

    public void layout(AbstractWidget abstractWidget) {
        for (int i2 = 0; i2 < this.widgets.length; ++i2) {
            this.layoutWidget(this.widgets[i2], this.oldChildrenBounds[i2], this.newChildrenBounds[i2]);
        }
    }

    private void layoutWidget(AbstractWidget abstractWidget, int[] nArray, int[] nArray2) {
        if (nArray == null && nArray2 == null) {
            this.hideWidget(abstractWidget);
        } else {
            float f2 = this.getOpacity(nArray);
            float f3 = this.getOpacity(nArray2);
            float f4 = this.animateOpacity(f2, f3);
            int n = this.animateBound(0, nArray, nArray2);
            int n2 = this.animateBound(1, nArray, nArray2);
            int n3 = this.animateBound(2, nArray, nArray2);
            int n4 = this.animateBound(3, nArray, nArray2);
            abstractWidget.setBounds(n, n2, n3, n4);
            if (f4 <= 0.0f) {
                this.hideWidget(abstractWidget);
            } else {
                abstractWidget.setOpacity(f4);
                abstractWidget.setOnScreen(true);
            }
        }
    }

    private void hideWidget(AbstractWidget abstractWidget) {
        abstractWidget.setOnScreen(false);
        abstractWidget.setOpacity(1.0f);
    }

    private float getOpacity(int[] nArray) {
        return nArray == null ? 0.0f : 1.0f;
    }

    private int animateBound(int n, int[] nArray, int[] nArray2) {
        int n2 = nArray != null ? nArray[n] : nArray2[n];
        int n3 = nArray2 != null ? nArray2[n] : nArray[n];
        return this.animate(n2, n3);
    }

    private float animateOpacity(float f2, float f3) {
        if (this.progress == 1.0f) {
            return f3;
        }
        float f4 = this.calculateAcceleratedOpacityProgress(this.progress, f2, f3);
        float f5 = f3 - f2;
        float f6 = f5 * f4;
        return f2 + f6;
    }

    private float calculateAcceleratedOpacityProgress(float f2, float f3, float f4) {
        if (f3 < f4) {
            return f2 * f2 * f2;
        }
        return Math.min(1.0f, f2 * 2.0f);
    }

    private int animate(int n, int n2) {
        if (this.progress == 1.0f) {
            return n2;
        }
        int n3 = n2 - n;
        int n4 = Math.round((float)n3 * this.progress);
        return n + n4;
    }

    public int[] calculateSize(AbstractWidget abstractWidget, int n) {
        if (this.animatePreferredSize) {
            return new int[]{this.animate(this.oldPreferredWidth, this.newPreferredWidth), this.animate(this.oldPreferredHeight, this.newPreferredHeight)};
        }
        return new int[]{this.newPreferredWidth, this.newPreferredHeight};
    }

    public void flushCache() {
    }

    public AbstractWidget[] getWidgets() {
        return this.widgets;
    }

    public void setWidgets(AbstractWidget[] abstractWidgetArray) {
        this.widgets = abstractWidgetArray;
    }

    public int[][] getOldChildrenBounds() {
        return this.oldChildrenBounds;
    }

    public void setOldChildrenBounds(int[][] nArray) {
        this.oldChildrenBounds = nArray;
    }

    public int[][] getNewChildrenBounds() {
        return this.newChildrenBounds;
    }

    public void setNewChildrenBounds(int[][] nArray) {
        this.newChildrenBounds = nArray;
    }

    public int getOldPreferredHeight() {
        return this.oldPreferredHeight;
    }

    public void setOldPreferredHeight(int n) {
        this.oldPreferredHeight = n;
    }

    public int getNewPreferredHeight() {
        return this.newPreferredHeight;
    }

    public void setNewPreferredHeight(int n) {
        this.newPreferredHeight = n;
    }

    public int getOldPreferredWidth() {
        return this.oldPreferredWidth;
    }

    public void setOldPreferredWidth(int n) {
        this.oldPreferredWidth = n;
    }

    public int getNewPreferredWidth() {
        return this.newPreferredWidth;
    }

    public void setNewPreferredWidth(int n) {
        this.newPreferredWidth = n;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setProgress(float f2) {
        this.progress = f2;
    }

    public LayoutManagerSimulation getNewLayoutManager() {
        return this.newLayoutManager;
    }

    public void setNewLayoutManager(LayoutManagerSimulation layoutManagerSimulation) {
        this.newLayoutManager = layoutManagerSimulation;
    }

    public boolean isAnimatePreferredSize() {
        return this.animatePreferredSize;
    }

    public void setAnimatePreferredSize(boolean bl) {
        this.animatePreferredSize = bl;
    }

    public int getNewWidthHint() {
        return this.newWidthHint;
    }

    public void setNewWidthHint(int n) {
        this.newWidthHint = n;
    }

    public int getNewHeightHint() {
        return this.newHeightHint;
    }

    public void setNewHeightHint(int n) {
        this.newHeightHint = n;
    }
}

