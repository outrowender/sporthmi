/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractDynamicSidebar;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class AbstractDynamicSidebarSegment
extends LayoutContainerController {
    protected boolean focusable = false;
    protected boolean visibilityMutex = false;
    protected boolean lastVisibleState = false;
    protected boolean attemptedVisibilityChange = false;

    public AbstractDynamicSidebarSegment() {
        CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(this);
        this.setRenderer(compositeRendererHigh);
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
    }

    public boolean isFocusable() {
        return this.focusable;
    }

    public boolean isVisibilityLocked() {
        if (sideBarLogChannel.isDebug()) {
            sideBarLogChannel.log(-2137614336, "AbstractDynamicSidebarSegment#isVisibilityLocked The segment %2 is %1", this.visibilityMutex, (Object)this);
        }
        return this.visibilityMutex;
    }

    public void lockVisibility() {
        this.visibilityMutex = true;
    }

    public void setFocusable(boolean bl) {
        this.focusable = bl;
    }

    public void setOnScreenOnly(boolean bl) {
        if (!this.isVisibilityLocked()) {
            super.setOnScreen(bl);
        }
    }

    @Override
    public void setVisible(boolean bl) {
        if (!this.isVisibilityLocked()) {
            super.setVisible(bl);
            if (this.parent instanceof AbstractDynamicSidebar) {
                ((AbstractDynamicSidebar)this.parent).segmentVisibilityChanged();
            }
        } else {
            this.attemptedVisibilityChange = true;
            this.lastVisibleState = bl;
        }
    }

    public void setVisibleOnly(boolean bl) {
        if (!this.isVisibilityLocked()) {
            super.setVisible(bl);
        } else {
            this.attemptedVisibilityChange = true;
            this.lastVisibleState = bl;
        }
    }

    public void unlockVisibility() {
        this.visibilityMutex = false;
        if (this.attemptedVisibilityChange) {
            this.setVisible(this.lastVisibleState);
        }
    }
}

