/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.TitleBarWidget;
import java.util.Iterator;
import java.util.List;

public class TitleBarLayout
implements LayoutManager {
    private int minSizeBreadcrumbs = 0;
    private int gapLeft = 0;
    private int gapRight = 0;
    private int gapBottom = 0;
    private int gapTop = 0;
    private int gapLefticonBreadcrumb = 0;
    private int gapBreadcrumbSeparator = 0;
    private int gapSeparatorTitle = 0;
    private int gapTitleRighticon = 0;
    private int gapInsideLefticons = 0;
    private int gapInsideBreadcrumbs = 0;
    private int gapInsideTitles = 0;
    private int gapInsideRighticons = 0;

    public TitleBarLayout() {
        int[] nArray = new int[]{7, 15, 15, 0, 12, 0, 0};
        int n = AbstractWidget.framework.getScreenRes();
        this.gapBreadcrumbSeparator = nArray[n];
        this.gapSeparatorTitle = nArray[n];
        this.minSizeBreadcrumbs = 150;
    }

    @Override
    public int[] calculateSize(AbstractWidget abstractWidget, int n) {
        TitleBarWidget titleBarWidget = (TitleBarWidget)abstractWidget;
        int[] nArray = new int[2];
        int n2 = 0;
        this.calculatePartialSize(titleBarWidget.getLeftIconWidgets(), this.gapInsideLefticons, nArray);
        int n3 = nArray[0];
        n2 = Math.max(n2, nArray[1]);
        this.calculatePartialSize(titleBarWidget.getBreadcrumbWidgets(), this.gapInsideBreadcrumbs, nArray);
        int n4 = nArray[0];
        n2 = Math.max(n2, nArray[1]);
        this.calculatePartialSize(titleBarWidget.getTitleWidgets(), this.gapInsideTitles, nArray);
        int n5 = nArray[0];
        n2 = Math.max(n2, nArray[1]);
        this.calculatePartialSize(titleBarWidget.getRightIconWidgets(), this.gapInsideRighticons, nArray);
        int n6 = nArray[0];
        n2 = Math.max(n2, nArray[1]);
        this.calculateSeparatorSize(titleBarWidget, n4, nArray);
        int n7 = nArray[0];
        n2 = Math.max(n2, nArray[1]);
        int n8 = n3 + n4 + n7 + n5 + n6;
        if (n8 == 0 || n2 == 0) {
            return new int[]{0, 0};
        }
        n8 += this.calculateGapSum(new int[]{n3, n4, n7, n5, n6}, new int[]{this.gapLefticonBreadcrumb, this.gapBreadcrumbSeparator, this.gapSeparatorTitle, this.gapTitleRighticon});
        int n9 = n2 + this.gapTop + this.gapBottom;
        return new int[]{n8 += this.gapLeft + this.gapRight, n9};
    }

    int calculateGapSum(int[] nArray, int[] nArray2) {
        int n = 0;
        int n2 = 0;
        boolean bl = false;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            boolean bl2;
            boolean bl3 = bl2 = nArray[i2] > 0;
            if (i2 > 0) {
                if (bl) {
                    n2 = Math.max(n2, nArray2[i2 - 1]);
                }
                if (bl2) {
                    n += n2;
                    n2 = 0;
                }
            }
            if (!bl2) continue;
            bl = true;
        }
        return n;
    }

    private void calculatePartialSize(List list, int n, int[] nArray) {
        int n2 = 0;
        int n3 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!this.isWidgetVisible(abstractWidgetController)) continue;
            if (n2 > 0) {
                n2 += n;
            }
            n2 += abstractWidgetController.getPreferredWidth();
            n3 = Math.max(n3, abstractWidgetController.getPreferredHeight());
        }
        nArray[0] = n2;
        nArray[1] = n3;
    }

    private void calculateSeparatorSize(TitleBarWidget titleBarWidget, int n, int[] nArray) {
        if (this.shouldShowSeparator(n) && this.isSeparatorVisible(titleBarWidget)) {
            nArray[0] = titleBarWidget.getSeparatorWidth();
            nArray[1] = titleBarWidget.getSeparatorHeight();
        } else {
            nArray[0] = 0;
            nArray[1] = 0;
        }
    }

    private boolean isWidgetVisible(AbstractWidgetController abstractWidgetController) {
        if (abstractWidgetController.shouldRender()) {
            if (abstractWidgetController instanceof IEmptyableWidget) {
                return ((IEmptyableWidget)((Object)abstractWidgetController)).hasContent();
            }
            return true;
        }
        return false;
    }

    private boolean isSeparatorVisible(TitleBarWidget titleBarWidget) {
        return titleBarWidget.hasSeparator();
    }

    private boolean shouldShowSeparator(int n) {
        return n > 0;
    }

    @Override
    public void layout(AbstractWidget abstractWidget) {
        int n;
        boolean bl = AbstractWidget.framework.getLanguageMgr().isLeftToRightOrientation();
        TitleBarWidget titleBarWidget = (TitleBarWidget)abstractWidget;
        int n2 = n = abstractWidget.getWidth();
        int n3 = titleBarWidget.getHeight() - this.gapTop - this.gapBottom;
        int[] nArray = new int[2];
        int n4 = this.layoutWidgets(titleBarWidget.getLeftIconWidgets(), this.gapLeft, n2 -= this.gapLeft + this.gapRight, n3, this.gapInsideLefticons);
        int n5 = n4 > 0 ? this.gapLefticonBreadcrumb : 0;
        this.calculatePartialSize(titleBarWidget.getRightIconWidgets(), this.gapInsideRighticons, nArray);
        int n6 = Math.min(nArray[0], n2 -= n4);
        this.layoutWidgets(titleBarWidget.getRightIconWidgets(), n - this.gapRight - n6, n2, n3, this.gapInsideRighticons);
        n2 -= n6;
        int n7 = n6 > 0 ? this.gapTitleRighticon : 0;
        this.calculatePartialSize(titleBarWidget.getBreadcrumbWidgets(), this.gapInsideBreadcrumbs, nArray);
        int n8 = nArray[0];
        this.calculateSeparatorSize(titleBarWidget, n8, nArray);
        int n9 = nArray[0];
        this.calculatePartialSize(titleBarWidget.getTitleWidgets(), this.gapInsideTitles, nArray);
        int n10 = nArray[0];
        int n11 = this.calculateGapSum(new int[]{n8, n9, n10}, new int[]{this.gapBreadcrumbSeparator, this.gapSeparatorTitle});
        int n12 = n8 + n9 + n10 + n11;
        int n13 = n2 - n5 - n7;
        int n14 = Math.min(n12, n13);
        int n15 = n12 - n14;
        int n16 = Math.min(n15, Math.max(0, n8 - this.minSizeBreadcrumbs));
        int n17 = Math.min(n16, n15);
        int n18 = n15 - n17;
        int n19 = n14 % 2 == 0 ? (n - n14 + 1) / 2 : (n - n14) / 2;
        int n20 = n - n14 - this.gapRight;
        n19 = Math.min(n19, n20 -= n6 + n7);
        int n21 = this.gapLeft;
        n19 = Math.max(n19, n21 += n4 + n5);
        int n22 = n8 - n17;
        if (bl) {
            this.layoutWidgets(titleBarWidget.getBreadcrumbWidgets(), n19, n22, n3, this.gapInsideBreadcrumbs);
            n19 += n22;
            if (this.shouldShowSeparator(n8) && n9 > 0) {
                int n23 = Math.max(0, (n3 - titleBarWidget.getSeparatorHeight()) / 2);
                titleBarWidget.setSeparatorLocation(n19 += this.gapBreadcrumbSeparator, n23 + this.gapTop);
                titleBarWidget.setSeparatorVisible(true);
                n19 += n9 + this.gapSeparatorTitle;
            } else {
                titleBarWidget.setSeparatorVisible(false);
                int n24 = this.calculateGapSum(new int[]{n8, n9, n10}, new int[]{this.gapBreadcrumbSeparator, this.gapSeparatorTitle});
                n19 += n24;
            }
            this.layoutWidgets(titleBarWidget.getTitleWidgets(), n19, n10 - n18, n3, this.gapInsideTitles);
        } else {
            this.layoutWidgets(titleBarWidget.getTitleWidgets(), n19, n10 - n18, n3, this.gapInsideTitles);
            n19 += n10 - n18;
            if (this.shouldShowSeparator(n10 - n18) && n9 > 0) {
                int n25 = Math.max(0, (n3 - titleBarWidget.getSeparatorHeight()) / 2);
                titleBarWidget.setSeparatorLocation(n19 += this.gapBreadcrumbSeparator, n25 + this.gapTop);
                titleBarWidget.setSeparatorVisible(true);
                n19 += n9 + this.gapSeparatorTitle;
            } else {
                titleBarWidget.setSeparatorVisible(false);
                int n26 = this.calculateGapSum(new int[]{n10, n9, n8}, new int[]{this.gapBreadcrumbSeparator, this.gapSeparatorTitle});
                n19 += n26;
            }
            this.layoutWidgets(titleBarWidget.getBreadcrumbWidgets(), n19, n22, n3, this.gapInsideBreadcrumbs);
        }
    }

    private int layoutWidgets(List list, int n, int n2, int n3, int n4) {
        int n5 = 0;
        boolean bl = false;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!this.isWidgetVisible(abstractWidgetController)) continue;
            if (bl) {
                n5 += n4;
            }
            int n6 = Math.min(n2 - n5, abstractWidgetController.getPreferredWidth());
            int n7 = n + n5;
            this.layoutWidget(abstractWidgetController, n7, n6, n3);
            n5 += n6;
            bl = true;
        }
        return n5;
    }

    private void layoutWidget(AbstractWidgetController abstractWidgetController, int n, int n2, int n3) {
        int n4 = Math.min(n3, abstractWidgetController.getPreferredHeight());
        int n5 = (n3 - n4) / 2;
        abstractWidgetController.setBounds(n, n5 + this.gapTop, n2, n4);
    }

    @Override
    public void flushCache() {
    }

    public int getMinSizeBreadcrumbs() {
        return this.minSizeBreadcrumbs;
    }

    public void setMinSizeBreadcrumbs(int n) {
        this.minSizeBreadcrumbs = n;
    }

    public int getGapLeft() {
        return this.gapLeft;
    }

    public void setGapLeft(int n) {
        this.gapLeft = n;
    }

    public int getGapRight() {
        return this.gapRight;
    }

    public void setGapRight(int n) {
        this.gapRight = n;
    }

    public int getGapBottom() {
        return this.gapBottom;
    }

    public void setGapBottom(int n) {
        this.gapBottom = n;
    }

    public int getGapTop() {
        return this.gapTop;
    }

    public void setGapTop(int n) {
        this.gapTop = n;
    }

    public int getGapLefticonBreadcrumb() {
        return this.gapLefticonBreadcrumb;
    }

    public void setGapLefticonBreadcrumb(int n) {
        this.gapLefticonBreadcrumb = n;
    }

    public int getGapBreadcrumbSeparator() {
        return this.gapBreadcrumbSeparator;
    }

    public void setGapBreadcrumbSeparator(int n) {
        this.gapBreadcrumbSeparator = n;
    }

    public int getGapSeparatorTitle() {
        return this.gapSeparatorTitle;
    }

    public void setGapSeparatorTitle(int n) {
        this.gapSeparatorTitle = n;
    }

    public int getGapTitleRighticon() {
        return this.gapTitleRighticon;
    }

    public void setGapTitleRighticon(int n) {
        this.gapTitleRighticon = n;
    }

    public int getGapInsideLefticons() {
        return this.gapInsideLefticons;
    }

    public void setGapInsideLefticons(int n) {
        this.gapInsideLefticons = n;
    }

    public int getGapInsideBreadcrumbs() {
        return this.gapInsideBreadcrumbs;
    }

    public void setGapInsideBreadcrumbs(int n) {
        this.gapInsideBreadcrumbs = n;
    }

    public int getGapInsideTitles() {
        return this.gapInsideTitles;
    }

    public void setGapInsideTitles(int n) {
        this.gapInsideTitles = n;
    }

    public int getGapInsideRighticons() {
        return this.gapInsideRighticons;
    }

    public void setGapInsideRighticons(int n) {
        this.gapInsideRighticons = n;
    }
}

