/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractDynamicSidebarSegment;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ListScrollingController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDynamicSidebar
extends LayoutContainerController {
    private boolean isOpened;
    protected int xPosClosed = 681;
    protected int xPosOpened = 660;
    protected ArrayList activeIndices = new ArrayList(7);
    protected List segments;
    protected ListScrollingController listScrolling = new ListScrollingController(200, 7, 0, this.animationPeriod){

        void positionElements(float f2) {
            if (!AbstractDynamicSidebar.this.activeIndices.isEmpty()) {
                AbstractDynamicSidebar.this.updateCursorPosition(f2);
                float f3 = AbstractDynamicSidebar.this.calculateProgress(f2);
                int n = AbstractDynamicSidebar.this.calculateHeightDifference(this.pDestLineCount);
                AbstractDynamicSidebar.this.updateCursorHeight(AbstractDynamicSidebar.this.cursorHeightAtAnimationStart + Math.round(f3 * (float)n));
            }
        }

        public void scrollingStopped() {
        }
    };
    protected FocusCursorController cursor;
    protected int cursorHeightAtAnimationStart = 0;
    protected int animationPeriod = 50;
    protected float startPosition;
    protected float endPosition;
    protected float animationDistance;
    protected boolean[] segmentVisibility;
    protected boolean invalidFocus;
    protected int cursorOffset;
    protected int selectedSegmentIndex;

    public AbstractDynamicSidebar() {
        this.listScrolling.setLogChannel(mapOverlayLogCh);
        this.listScrolling.setDynamicLineHeight(true);
        int[] nArray = new int[]{10, 100, 50};
        this.listScrolling.setLineHeights(nArray, nArray.length);
        this.segments = new ArrayList(7);
    }

    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof AbstractDynamicSidebarSegment) {
            this.segments.add(abstractWidget);
        }
    }

    protected int calculateHeightDifference(int n) {
        int n2 = this.getActiveIndex(n);
        AbstractDynamicSidebarSegment abstractDynamicSidebarSegment = this.getSegment(n2);
        int n3 = abstractDynamicSidebarSegment.getPreferredHeight();
        return n3 - this.cursorHeightAtAnimationStart;
    }

    protected float calculateProgress(float f2) {
        float f3 = Math.abs(this.startPosition - f2);
        return f3 / this.animationDistance;
    }

    protected int[] calculateReverseCursorPositions() {
        int n;
        int n2;
        int n3;
        ArrayList arrayList = new ArrayList(this.segments.size());
        Integer n4 = Util.createInteger(0);
        for (n3 = 0; n3 < this.segments.size(); ++n3) {
            arrayList.add(n4);
        }
        n3 = 0;
        this.activeIndices.clear();
        for (n2 = this.segments.size() - 1; n2 >= 0; --n2) {
            AbstractDynamicSidebarSegment abstractDynamicSidebarSegment = this.getSegment(n2);
            sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#calculateReverseCursorPositions %2-th segment visible: %1", (Object)abstractDynamicSidebarSegment.isVisible(), (long)n2);
            if (!abstractDynamicSidebarSegment.isVisible()) continue;
            if (abstractDynamicSidebarSegment.isFocusable()) {
                arrayList.remove(n2);
                arrayList.add(n2, Util.createInteger(n3 += abstractDynamicSidebarSegment.getPreferredHeight()));
                n3 = 0;
                this.activeIndices.add(0, Util.createInteger(n2));
                continue;
            }
            n3 += abstractDynamicSidebarSegment.getPreferredHeight();
        }
        for (n = 0; n < arrayList.size(); ++n) {
            sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#calculateCursorPositions %2-th height = %1", arrayList.get(n), (long)n);
        }
        for (n = arrayList.size() - 1; n >= 0; --n) {
            if ((Integer)arrayList.get(n) != 0) continue;
            arrayList.remove(n);
        }
        this.cursorOffset = n3 + 1;
        sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#calculateCursorPositions cursorOffset = %1", (long)this.cursorOffset);
        int[] nArray = new int[arrayList.size()];
        n2 = 0;
        while (!arrayList.isEmpty()) {
            nArray[n2] = (Integer)arrayList.remove(0);
            sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#calculateCursorPositions %1-th pos = %2", (long)n2, (long)nArray[n2]);
            ++n2;
        }
        return nArray;
    }

    protected boolean[] calculateSegmentVisibility() {
        boolean[] blArray = new boolean[this.segments.size()];
        int n = this.segments.size();
        for (int i2 = 0; i2 < n; ++i2) {
            blArray[i2] = this.getSegment(i2).isVisible();
        }
        return blArray;
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.listScrolling.connected(initializationContext);
        this.listScrolling.setParamAnimationType1(10.0f, 0.5f, 100.0f, 3.0f);
        this.listScrolling.setLineHeights(this.calculateReverseCursorPositions(), this.activeIndices.size());
        this.listScrolling.setOffset(this.cursorOffset);
        this.listScrolling.setCurrentPosition(0);
        this.updateCursorPosition(this.listScrolling.getCurrentPosition());
        this.updateCursorHeight(this.getSegment(this.getActiveSegment()).getPreferredHeight());
        this.segmentVisibility = this.calculateSegmentVisibility();
        this.cursor.setVisible(false);
        this.setParentXCoordinate(this.isOpen());
    }

    public void disconnecting() {
        this.selectedSegmentIndex = this.getActiveSegment();
        super.disconnecting();
    }

    protected int getActiveIndex(int n) {
        int n2 = Math.max(0, Math.min(n, this.activeIndices.size() - 1));
        return (Integer)this.activeIndices.get(n2);
    }

    protected int getActiveSegment() {
        return this.getActiveIndex(this.listScrolling.getDestinationLine());
    }

    protected AbstractDynamicSidebarSegment getSegment(int n) {
        return (AbstractDynamicSidebarSegment)this.segments.get(n);
    }

    public boolean isOpen() {
        return this.isOpened;
    }

    private boolean isEvoScale() {
        return framework.getSysConst(4581) == 0 && framework.getSysConst(522) == 1;
    }

    protected boolean isScale() {
        return this.isEvoScale();
    }

    public void processVisibilityBatched(int[] nArray, boolean[] blArray) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.getSegment(nArray[i2]).setVisibleOnly(blArray[i2]);
        }
        this.segmentVisibilityChanged();
    }

    public void segmentVisibilityChanged() {
        if (!this.isConnected()) {
            return;
        }
        int n = this.segments.size();
        boolean[] blArray = this.calculateSegmentVisibility();
        int n2 = 0;
        if (!this.invalidFocus) {
            int n3;
            int n4 = this.getActiveSegment();
            sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#segmentVisibilityChanged currentLine = %1, destLine = %2, focusedSegmentIndex = %3", (long)this.listScrolling.getCurrentLine(), (long)this.listScrolling.getDestinationLine(), (long)n4);
            for (n3 = 0; n3 < n4; ++n3) {
                if (!blArray[n3] || !this.getSegment(n3).isFocusable()) continue;
                ++n2;
            }
            if (!blArray[n3] || !this.getSegment(n3).isFocusable()) {
                int n5 = n3;
                while (!(n3 >= n || blArray[n3] && this.getSegment(n3).isFocusable())) {
                    ++n3;
                }
                if (n3 == n) {
                    for (n3 = n5; !(n3 < 0 || blArray[n3] && this.getSegment(n3).isFocusable()); --n3) {
                    }
                    if (n3 >= 0) {
                        --n2;
                    } else {
                        this.invalidFocus = true;
                        this.cursor.setOnScreen(false);
                        sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#segmentVisibilityChanged invalidFocus = %1", this.invalidFocus);
                    }
                }
            }
        } else {
            int n6;
            for (n6 = 0; !(n6 >= n || blArray[n6] && this.getSegment(n6).isFocusable()); ++n6) {
            }
            if (n6 < n) {
                n2 = 0;
                this.invalidFocus = false;
                this.cursor.setOnScreen(true);
                sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#segmentVisibilityChanged invalidFocus = %1", this.invalidFocus);
            }
        }
        sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#segmentVisibilityChanged focusedLine = %1", (long)n2);
        this.listScrolling.setLineHeights(this.calculateReverseCursorPositions(), this.activeIndices.size());
        this.listScrolling.setOffset(this.cursorOffset);
        this.listScrolling.resetPosition();
        this.listScrolling.setCurrentPosition(n2);
        if (!this.activeIndices.isEmpty()) {
            this.updateCursorPosition(this.listScrolling.getCurrentPosition());
            this.updateCursorHeight(this.getSegment(this.getActiveSegment()).getPreferredHeight());
        }
        this.segmentVisibility = blArray;
    }

    protected void setCursorPosition(int n) {
        sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#setCursorPosition focusedSegment = %1", (long)n);
        boolean bl = this.setCursorPosition0(n);
        if (!bl) {
            sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#setCursorPosition Cursor position could not be applied.");
        }
    }

    protected boolean setCursorPosition0(int n) {
        int n2;
        int n3 = 0;
        int n4 = this.activeIndices.size();
        for (n2 = 0; n2 < n4; ++n2) {
            if (this.getActiveIndex(n2) != n) continue;
            n3 = n2;
            break;
        }
        if (n2 == n4) {
            return false;
        }
        this.listScrolling.setCurrentPosition(n3);
        this.updateCursorPosition(this.listScrolling.getCurrentPosition());
        this.updateCursorHeight(this.getSegment(n).getPreferredHeight());
        return true;
    }

    protected void sidebarClose() {
        sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#sidebarClose");
        this.setParentXCoordinate(false);
        this.shiftContent(-10);
        this.isOpened = false;
    }

    protected void sidebarOpen() {
        sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#sidebarOpen");
        this.setParentXCoordinate(true);
        this.shiftContent(10);
        this.isOpened = true;
    }

    protected void shiftContent(int n) {
        sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#shiftContent numPixels = %1", (long)n);
        int n2 = this.segments.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            AbstractDynamicSidebarSegment abstractDynamicSidebarSegment = this.getSegment(i2);
            int n3 = abstractDynamicSidebarSegment.getChildrenSize();
            for (int i3 = 0; i3 < n3; ++i3) {
                AbstractWidgetController abstractWidgetController = (AbstractWidgetController)abstractDynamicSidebarSegment.getChild(i3);
                int n4 = abstractWidgetController.getX();
                abstractWidgetController.setX(n4 + n);
            }
        }
    }

    protected void updateCursorHeight(int n) {
        this.cursor.setHeight(n - 1);
        this.cursor.setCompositesDirty(true);
    }

    protected void updateCursorPosition(float f2) {
        this.cursor.setY((int)f2);
        this.cursor.setCompositesDirty(true);
    }

    private void setParentXCoordinate(boolean bl) {
        AbstractWidget abstractWidget = this.getParent();
        if (abstractWidget instanceof LayoutContainerController) {
            CompositeRendererHigh compositeRendererHigh = (CompositeRendererHigh)((LayoutContainerController)abstractWidget).getRenderer();
            compositeRendererHigh.setFloatingPointOffset(bl ? -21.0f : 0.0f, 0.0f);
            abstractWidget.setCompositesDirty(true);
            sideBarLogChannel.log(10000000, "AbstractDynamicSidebar#connected Set floating point offset on parent.");
        }
    }
}

