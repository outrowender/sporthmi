/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.layouts;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import java.util.Iterator;
import java.util.List;

public class DefaultBoundedLayout
implements WidgetConstants,
LayoutManager {
    private static final DefaultBoundedLayout m_instance = new DefaultBoundedLayout();
    private static final int[] DUMMY_PREFRRED_SIZE = new int[]{-1, -1};

    public static synchronized DefaultBoundedLayout getInstance() {
        return m_instance;
    }

    private DefaultBoundedLayout() {
    }

    @Override
    public void layout(AbstractWidget abstractWidget) {
        if (abstractWidget != null) {
            Iterator iterator;
            int n = abstractWidget.getWidth();
            int n2 = abstractWidget.getHeight();
            List list = abstractWidget.getChildren();
            Iterator iterator2 = iterator = list != null ? list.iterator() : null;
            if (iterator != null) {
                while (iterator.hasNext()) {
                    Object object = iterator.next();
                    if (!(object instanceof AbstractWidgetController)) continue;
                    AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object;
                    int n3 = abstractWidgetController.getX();
                    int n4 = abstractWidgetController.getY();
                    int n5 = abstractWidgetController.getPreferredWidth();
                    n5 = n5 == -1 ? n : Math.min(abstractWidgetController.getPreferredWidth(), n);
                    n5 = AnimUtils.clamp(0, n - n3, n5);
                    int n6 = abstractWidgetController.getPreferredHeight();
                    n6 = n6 == -1 ? n2 : Math.min(abstractWidgetController.getPreferredHeight(), n2);
                    n6 = AnimUtils.clamp(0, n2 - n4, n6);
                    abstractWidgetController.setBounds(n3, n4, n5, n6);
                    abstractWidgetController.setInvalid(true);
                    abstractWidgetController.setCompositesDirty(true);
                }
            }
        }
    }

    @Override
    public int[] calculateSize(AbstractWidget abstractWidget, int n) {
        int[] nArray = DUMMY_PREFRRED_SIZE;
        if (abstractWidget instanceof EntertainmentDrawerContentController) {
            EntertainmentDrawerContentController entertainmentDrawerContentController = (EntertainmentDrawerContentController)abstractWidget;
            AbstractWidgetController abstractWidgetController = entertainmentDrawerContentController.getMain();
            if (abstractWidgetController != null) {
                nArray = new int[]{abstractWidgetController.getPreferredWidth(), abstractWidgetController.getPreferredHeight()};
            }
        } else if (abstractWidget != null && abstractWidget.getParent() instanceof AbstractWidgetController) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)abstractWidget.getParent();
            nArray = new int[]{abstractWidgetController.getPreferredWidth(), abstractWidgetController.getPreferredHeight()};
        }
        return nArray;
    }

    @Override
    public void flushCache() {
    }
}

