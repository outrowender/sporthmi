/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.widgets;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.PreferredSize;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractWidgetController
extends AbstractWidget
implements PreferredSize {
    private List children;
    protected Object model;
    private int connectionState = 4;
    protected int preferredWidth = -1;
    protected int preferredHeight = -1;
    private int[] coordinateSets;
    private int fixedColorScheme = -1;

    public void animate(int n, float f2, int n2) {
        this.animate(n, f2);
    }

    public void animate(int n, float f2) {
    }

    public abstract IRenderer getRenderer();

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.afterConnected();
        this.connectionState = 2;
    }

    protected void initConnect(InitializationContext initializationContext) {
        super.initConnect(initializationContext);
        this.connectionState = 1;
        if (this.getRenderer() != null) {
            this.getRenderer().connect(initializationContext);
            this.getRenderer().updateInheritedFonts();
        }
    }

    protected void afterConnected() {
        this.setCompositesDirty(true);
    }

    public void disconnecting() {
        this.connectionState = 3;
        super.disconnecting();
        if (this.getRenderer() != null) {
            this.getRenderer().disconnect();
        }
        this.destroyWidget();
        this.connectionState = 4;
        this.resetInitContext();
    }

    protected void destroyWidget() {
    }

    protected void resetInitContext() {
        this.initContext = null;
    }

    public boolean isConnected() {
        return this.connectionState == 1 || this.connectionState == 2;
    }

    public boolean isConnectedSubtree() {
        return this.connectionState == 2;
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    protected void propagatePaint(RedrawContext redrawContext) {
        if (this.children != null) {
            AbstractWidget abstractWidget = null;
            int n = this.children.size();
            for (int i2 = 0; i2 < n; ++i2) {
                abstractWidget = (AbstractWidget)this.children.get(i2);
                redrawContext.setNodeIndex(i2);
                if (this.getRenderer() != null) {
                    this.getRenderer().prepareRedrawContextForChildren(redrawContext, abstractWidget);
                }
                if (!abstractWidget.isInvalid()) continue;
                abstractWidget.managePaint(redrawContext);
            }
        }
    }

    protected boolean shouldPropagatePaint() {
        return super.shouldPropagatePaint() || this.getRenderer() == null;
    }

    protected void propagateConnected(InitializationContext initializationContext) {
        if (this.getRenderer() != null) {
            initializationContext = this.getRenderer().createInitContextForChildren(initializationContext);
        }
        super.propagateConnected(initializationContext);
    }

    public void managePaint(RedrawContext redrawContext) {
        IRenderer iRenderer = this.getRenderer();
        if (iRenderer != null) {
            redrawContext = iRenderer.createRedrawContext(redrawContext);
        }
        super.managePaint(redrawContext);
        if (iRenderer != null) {
            iRenderer.restoreRedrawContext(redrawContext);
        }
    }

    public void render(RedrawContext redrawContext) {
        if (this.getRenderer() != null) {
            this.getRenderer().render(redrawContext);
        }
    }

    public void renderIfDirty(RedrawContext redrawContext) {
        if (this.getRenderer() != null && this.getRenderer().areCompositesDirty()) {
            this.render(redrawContext);
        }
    }

    protected void afterPaint(RedrawContext redrawContext) {
        super.afterPaint(redrawContext);
        this.setCompositesDirty(false);
    }

    public void setCompositesDirty(boolean bl) {
        if (this.getRenderer() != null) {
            this.getRenderer().setCompositesDirty(bl);
        }
        this.setInvalid(bl);
    }

    public void setCompositeDirty(int n) {
        if (this.getRenderer() != null) {
            this.getRenderer().setCompositeDirty(n);
        }
        this.setInvalid(true);
    }

    public final List getChildren() {
        if (this.children == null) {
            return Collections.EMPTY_LIST;
        }
        return this.children;
    }

    public AbstractWidget getChild(int n) {
        return (AbstractWidget)this.children.get(n);
    }

    public int getChildrenSize() {
        if (this.children == null) {
            return 0;
        }
        return this.children.size();
    }

    public void add(AbstractWidget abstractWidget) {
        if (this.children == null) {
            this.children = new ArrayList(12);
        }
        if (abstractWidget != null) {
            abstractWidget.setParent(this);
            this.children.add(abstractWidget);
            if (this.isConnected()) {
                this.propagateConnected(abstractWidget);
                this.setCompositesDirty(true);
            }
        } else {
            logChannel.log(10000, "AbstractWidget#add childWidget is null, this: %1", (Object)this);
        }
    }

    public void addWithPosition(AbstractWidget abstractWidget, int n) {
        if (this.children == null) {
            this.children = new ArrayList(12);
        }
        if (abstractWidget != null) {
            abstractWidget.setParent(this);
            this.children.add(n, abstractWidget);
            if (this.isConnected()) {
                this.propagateConnected(abstractWidget);
                this.setCompositesDirty(true);
            }
        } else {
            logChannel.log(10000, "AbstractWidget#add childWidget is null, this: %1", (Object)this);
        }
    }

    public void remove(AbstractWidget abstractWidget) {
        if (abstractWidget != null) {
            if (!this.getChildren().contains(abstractWidget)) {
                logChannel.log(10000, "AbstractWidgetController#remove: childWidget was not contained in list, this: %1,  child: %2", (Object)this, (Object)abstractWidget);
                return;
            }
            if (this.isConnected()) {
                abstractWidget.predisconnecting();
                abstractWidget.disconnecting();
                this.setCompositesDirty(true);
            }
            this.children.remove(abstractWidget);
            abstractWidget.removeParent();
        } else {
            logChannel.log(100000, "AbstractWidget#remove childWidget is null, this: %1", (Object)this);
        }
    }

    protected void propagateConnected(AbstractWidget abstractWidget) {
        InitializationContext initializationContext = this.getRenderer() != null ? this.getRenderer().createInitContextForChildren(this.initContext) : this.initContext;
        abstractWidget.connected(initializationContext);
    }

    public void setParent(AbstractWidget abstractWidget) {
        if (this.parent != null && abstractWidget != null) {
            throw new IllegalStateException("Widgets has already a parent. Old parent: " + this.parent + "\nNew parent: " + abstractWidget);
        }
        super.setParent(abstractWidget);
    }

    public void setModel(HMIModelGUI hMIModelGUI) {
        this.model = hMIModelGUI;
    }

    public void setModel(Object object) {
        this.model = object;
    }

    public Object getModel() {
        return this.model;
    }

    public void invalidateParentLayout() {
        if (this.parent instanceof LayoutContainer) {
            ((LayoutContainer)((Object)this.parent)).invalidateLayout(this);
        }
    }

    public void setVisible(boolean bl) {
        if (this.isVisible() != bl) {
            super.setVisible(bl);
            this.invalidateParentLayout();
            this.setCompositesDirty(true);
        }
    }

    public void setOnScreen(boolean bl) {
        if (this.isOnScreen() != bl) {
            super.setOnScreen(bl);
            this.setCompositesDirty(true);
        }
    }

    public void setVisibleOnCurrentStage(boolean bl) {
        if (this.isVisibleOnCurrentStage() != bl) {
            super.setVisibleOnCurrentStage(bl);
            this.setCompositesDirty(true);
        }
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        if (!this.hasBounds(n, n2, n3, n4)) {
            this.setCompositesDirty(true);
        }
        super.setBounds(n, n2, n3, n4);
    }

    public boolean hasBounds(int n, int n2, int n3, int n4) {
        return this.x == n && this.y == n2 && this.width == n3 && this.height == n4;
    }

    public void setX(int n) {
        if (this.x != n) {
            this.setCompositesDirty(true);
        }
        super.setX(n);
    }

    public void setY(int n) {
        if (this.y != n) {
            this.setCompositesDirty(true);
        }
        super.setY(n);
    }

    public void setWidth(int n) {
        if (this.width != n) {
            this.setCompositesDirty(true);
        }
        super.setWidth(n);
    }

    public void setHeight(int n) {
        if (this.height != n) {
            this.setCompositesDirty(true);
        }
        super.setHeight(n);
    }

    public int getPreferredWidth() {
        return this.preferredWidth;
    }

    public void setPreferredWidth(int n) {
        this.preferredWidth = n;
        this.invalidateParentLayout();
    }

    public int getPreferredHeight() {
        return this.preferredHeight;
    }

    public void setPreferredHeight(int n) {
        this.preferredHeight = n;
        this.invalidateParentLayout();
    }

    public HMITerminalImpl getTerminalImpl() {
        return this.terminal;
    }

    public int getBitmap(int n) {
        if (this.bitmapIndices == null || this.bitmapIndices.length == 0) {
            logChannel.log(10000, "AbstractWidgetController#getBitmap no images configured in widget: %1 in screen: %2 (%3)", (Object)this, (Object)Util.createInteger(this.getScreenId()), (Object)this.terminal.getScreenName(this.getScreenId()));
            return -1;
        }
        if (n < 0 || n >= this.bitmapIndices.length) {
            logChannel.log(100000, "AbstractWidgetController#getBitmap bitmap index: %1 out of bounds: %2", (long)n, (long)this.bitmapIndices.length);
            return -1;
        }
        int n2 = this.bitmapIndices[n];
        if (n2 < 0 && logChannel.isInfo()) {
            logChannel.log(1000000, "AbstractWidgetController#getBitmap bitmap index: %1 is undefined: %2 in screen %3 (%4)", (Object)Util.createInteger(n), (Object)Util.createInteger(n2), (Object)Util.createInteger(this.getScreenId()), (Object)this.terminal.getScreenName(this.getScreenId()));
        }
        return n2;
    }

    public int getScreenId() {
        if (this.initContext == null) {
            return -1;
        }
        return this.initContext.getScreenID();
    }

    public void setCoordinateSets(int[] nArray) {
        this.coordinateSets = nArray;
    }

    public int[] getCoordinateSets() {
        return this.coordinateSets;
    }

    public void setFixedColorScheme(int n) {
        this.fixedColorScheme = n;
    }

    public int getFixedColorScheme() {
        return this.fixedColorScheme;
    }

    public void makeSubtreeDirty() {
        this.makeSubtreeDirty(this);
    }

    private void makeSubtreeDirty(AbstractWidget abstractWidget) {
        abstractWidget.setCompositesDirty(true);
        Iterator iterator = abstractWidget.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget2 = (AbstractWidget)iterator.next();
            this.makeSubtreeDirty(abstractWidget2);
        }
    }

    protected static boolean isWheelButtonKey(int n) {
        return n == 17 || n == 20;
    }

    public boolean isInOptionDrawer() {
        if (!this.isConnected()) {
            logChannel.log(10000, "AbstractWidgetController#isInOptionDrawer: widget is not connected: %1", (Object)this);
            return false;
        }
        return this.terminal.getDrawerFocusManager().getOptionDrawer() == this.getInitContext().getScreen();
    }

    public boolean isInSelectionDrawer() {
        if (!this.isConnected()) {
            logChannel.log(10000, "AbstractWidgetController#isInSelectionDrawer: widget is not connected: %1", (Object)this);
            return false;
        }
        return this.terminal.getDrawerFocusManager().getSelectionDrawer() == this.getInitContext().getScreen();
    }

    public boolean isInEntertainmentDrawer() {
        if (!this.isConnected()) {
            logChannel.log(10000, "AbstractWidgetController#isInOptionDrawer: widget is not connected: %1", (Object)this);
            return false;
        }
        return this.terminal.getDrawerFocusManager().getEntertainmentDrawer() == this.getInitContext().getScreen();
    }
}

