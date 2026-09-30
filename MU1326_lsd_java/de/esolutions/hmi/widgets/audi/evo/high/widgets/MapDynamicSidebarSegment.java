/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractDynamicSidebarSegment;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SideBarOrientationWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class MapDynamicSidebarSegment
extends AbstractDynamicSidebarSegment {
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof SideBarOrientationWidget) {
            ((SideBarOrientationWidget)abstractWidget).setChainedChildren(true);
            ((SideBarOrientationWidget)abstractWidget).setChainedAction(3, 17);
        }
        if (abstractWidget instanceof IconController) {
            ((IconController)abstractWidget).setProcessStateChange(2);
        }
    }
}

