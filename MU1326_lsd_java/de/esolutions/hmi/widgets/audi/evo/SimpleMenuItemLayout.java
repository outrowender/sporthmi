/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import java.util.Iterator;
import java.util.List;

public class SimpleMenuItemLayout
implements LayoutManager,
WidgetConstants {
    private static final int BIG_WIDGET_INDEX;
    private static final int SMALL_WIDGET_INDEX;
    private int gap = 5;
    private int alignmentVertical = 9;

    @Override
    public void layout(AbstractWidget abstractWidget) {
        AbstractWidgetController abstractWidgetController;
        int n = abstractWidget.getWidth();
        int n2 = abstractWidget.getHeight();
        AbstractWidgetController abstractWidgetController2 = this.getChild(abstractWidget, 1);
        if (abstractWidgetController2 != null) {
            int n3 = abstractWidgetController2.getPreferredWidth();
            int n4 = n - n3;
            this.layoutChild(abstractWidgetController2, n4, 0, n3, n2, abstractWidget);
            n -= n3 + this.gap;
        }
        if ((abstractWidgetController = this.getChild(abstractWidget, 0)) != null) {
            this.layoutChild(abstractWidgetController, 0, 0, n, n2, abstractWidget);
        }
    }

    protected void layoutChild(AbstractWidgetController abstractWidgetController, int n, int n2, int n3, int n4, AbstractWidget abstractWidget) {
        int n5;
        int n6;
        switch (this.alignmentVertical) {
            case 4: {
                n6 = 0;
                n5 = this.getActualChildHeight(abstractWidgetController, n4);
                break;
            }
            case 6: {
                n5 = this.getActualChildHeight(abstractWidgetController, n4);
                n6 = n4 - n5;
                break;
            }
            case 5: 
            case 7: {
                n5 = this.getActualChildHeight(abstractWidgetController, n4);
                float f2 = (float)(n4 - n5) / 2.0f;
                n6 = (int)(f2 + 63);
                break;
            }
            case 9: {
                n6 = 0;
                n5 = n4;
                break;
            }
            default: {
                IWidgetLogChannel.logLayout.log(10000, "SimpleMenuItemLayout#layoutChild: unknown vertical alignment: %1", (long)this.alignmentVertical);
                n6 = 0;
                n5 = n4;
            }
        }
        abstractWidgetController.setBounds(n, n2 + n6, n3, n5);
    }

    private int getActualChildHeight(AbstractWidgetController abstractWidgetController, int n) {
        return abstractWidgetController.getPreferredHeight();
    }

    @Override
    public int[] calculateSize(AbstractWidget abstractWidget, int n) {
        return new int[]{this.calculateWidth(abstractWidget), this.calculateHeight(abstractWidget)};
    }

    protected int calculateWidth(AbstractWidget abstractWidget) {
        AbstractWidgetController abstractWidgetController;
        int n = 0;
        AbstractWidgetController abstractWidgetController2 = this.getChild(abstractWidget, 0);
        if (abstractWidgetController2 != null) {
            n += abstractWidgetController2.getPreferredWidth();
        }
        if ((abstractWidgetController = this.getChild(abstractWidget, 1)) != null) {
            n += abstractWidgetController.getPreferredWidth();
        }
        if (abstractWidgetController2 != null && abstractWidgetController != null) {
            n += this.gap;
        }
        return n;
    }

    protected int calculateHeight(AbstractWidget abstractWidget) {
        int n = 0;
        Iterator iterator = abstractWidget.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            n = Math.max(n, abstractWidgetController.getPreferredHeight());
        }
        return n;
    }

    @Override
    public void flushCache() {
    }

    protected AbstractWidgetController getChild(AbstractWidget abstractWidget, int n) {
        List list = abstractWidget.getChildren();
        if (list.size() > n) {
            return (AbstractWidgetController)list.get(n);
        }
        return null;
    }

    public int getGap() {
        return this.gap;
    }

    public void setGap(int n) {
        this.gap = n;
    }

    public int getAlignmentVertical() {
        return this.alignmentVertical;
    }

    public void setAlignmentVertical(int n) {
        this.alignmentVertical = n;
    }
}

