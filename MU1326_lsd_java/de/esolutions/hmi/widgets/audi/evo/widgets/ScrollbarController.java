/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarInterval;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import java.util.Iterator;
import java.util.List;

public class ScrollbarController
extends AbstractWidgetController
implements AnimationListener,
IMenuCallback {
    private static final float EPSILON = 0.008f;
    private static final float DEFAULT_MINIMAL_SCROLLBAR_HEIGHT = 20.0f;
    private static final int ANIMATION_TARGET = 1000;
    static final int ANIMATION_TYPE = 71;
    private ScrollbarRenderer renderer;
    private ScrollbarInterval animationStartInterval = ScrollbarInterval.getInvisibleInterval();
    private ScrollbarInterval targetInterval = ScrollbarInterval.getInvisibleInterval();
    private ScrollbarInterval animationInterval = ScrollbarInterval.getInvisibleInterval();
    private int entireValue;
    private int entireMax;
    private AbstractAnimation animation;
    private MenuItemIndex cachedTopVisibleItem;
    private MenuItemIndex cachedBottomVisibleItem;
    private int cachedTopItemFlatPos;
    private int cachedBottomItemFlatPos;
    private int cachedFlatMenuItemCount;
    private float cachedTopVisibleRatio;
    private float cachedBottomVisibleRatio;
    private float cachedMenuHeight;
    private int cachedMenuItemCount;
    private boolean infolineChanged;
    private boolean alignTop;
    private float scrollbarHeight;
    private float scrollbarPosition;
    private float menuMaxVisibleItemCount = -1.0f;

    protected void initializeWidget() {
        super.initializeWidget();
        this.clearCache();
    }

    public void setInterval(int n, int n2, int n3, boolean bl) {
        logScrollbar.log(10000000, "ScrollbarController#setInterval: from %1 to %2, count: %3", (long)n, (long)n2, (long)n3);
        float f2 = ScrollbarController.getPosition(n, n3);
        float f3 = ScrollbarController.getPosition(n2 + 1, n3);
        ScrollbarInterval scrollbarInterval = ScrollbarController.createInterval(f2, f3);
        if (!bl) {
            if (!scrollbarInterval.equals(this.animationInterval)) {
                this.setCompositesDirty(true);
            }
            this.animationStartInterval = scrollbarInterval;
            this.targetInterval = scrollbarInterval;
            this.animationInterval = scrollbarInterval;
            return;
        }
        if (!this.targetInterval.equals(scrollbarInterval)) {
            AbstractAnimation abstractAnimation = this.getAnimation();
            this.animationStartInterval = this.animationInterval;
            this.targetInterval = scrollbarInterval;
            if (abstractAnimation.isAnimating()) {
                abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
            } else {
                abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, 71, this.targetInterval.isVisible(), this);
            }
        }
    }

    private static ScrollbarInterval createInterval(float f2, float f3) {
        if (f2 < 0.0f || f3 < 0.0f) {
            return ScrollbarInterval.getInvisibleInterval();
        }
        if (f2 <= 0.008f && f3 >= 0.992f) {
            return ScrollbarInterval.getInvisibleInterval();
        }
        return new ScrollbarInterval(f2, f3, 1.0f);
    }

    private static float getPosition(int n, int n2) {
        if (n < 0 || n2 <= 0 || n > n2) {
            return -1.0f;
        }
        return (float)n / (float)n2;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(ScrollbarRenderer scrollbarRenderer) {
        this.renderer = scrollbarRenderer;
    }

    public ScrollbarInterval getAnimationInterval() {
        return this.animationInterval;
    }

    public void animate(int n, float f2) {
        AbstractAnimation abstractAnimation = this.getAnimation();
        if (n == 71) {
            this.animationInterval = this.animationStartInterval.getAnimationInterval(this.targetInterval, abstractAnimation.getProgress());
            this.setCompositesDirty(true);
        }
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        if (n == 71) {
            this.animationInterval = this.targetInterval;
            this.animationStartInterval = this.targetInterval;
            this.setCompositesDirty(true);
        }
    }

    private AbstractAnimation getAnimation() {
        if (this.animation == null) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(71);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    protected void destroyWidget() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        this.animation = null;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    public float getScrollbarHeight() {
        return this.scrollbarHeight;
    }

    public float getScrollbarPosition() {
        return this.scrollbarPosition;
    }

    public void setScrollbarHeight(float f2) {
        this.scrollbarHeight = f2;
    }

    public void setScrollbarPosition(float f2) {
        this.scrollbarPosition = f2;
    }

    private void updateScrollbarPosition() {
        float f2;
        boolean bl;
        MenuItemMetaData menuItemMetaData;
        MenuController menuController = this.getMenu();
        if (menuController == null) {
            this.animationInterval = ScrollbarInterval.getInvisibleInterval();
            this.clearCache();
            return;
        }
        MenuItemMetaData menuItemMetaData2 = this.getLayoutItem(menuController.getLayout().getFirstVisibleItem(), menuController);
        if (!this.isIndicesCached(menuItemMetaData2, menuItemMetaData = this.getLayoutItem(menuController.getLayout().getLastVisibleItem(), menuController))) {
            this.updateCachedIndices(menuItemMetaData2, menuItemMetaData, menuController);
        }
        this.updateVisibleRatios(menuController);
        ScrollbarInterval scrollbarInterval = this.createIntervalFromCachedValues(menuController);
        if (menuItemMetaData2 == null || menuItemMetaData == null) {
            this.animationInterval = scrollbarInterval;
            this.clearCache();
            this.setCompositesDirty(true);
            return;
        }
        int n = menuController.getFlatMenuItemCount();
        int n2 = menuController.getHeight();
        boolean bl2 = bl = this.menuMaxVisibleItemCount <= 1.0f || this.cachedMenuHeight != (float)n2 || this.infolineChanged || this.cachedMenuItemCount != n;
        if (bl) {
            this.cachedMenuHeight = n2;
            this.cachedMenuItemCount = n;
            this.infolineChanged = false;
            f2 = ScrollbarController.computeEstimatedItemHeight(menuController, 10, this.getHeight() * 2);
            this.menuMaxVisibleItemCount = this.computeVisibleItemCount(menuController, f2);
        }
        f2 = (float)this.getHeight() / (float)n;
        this.scrollbarHeight = ScrollbarController.clamp(20.0f, this.getHeight(), this.menuMaxVisibleItemCount * f2);
        float f3 = scrollbarInterval.getLastPos() - scrollbarInterval.getFirstPos();
        this.scrollbarPosition = ScrollbarController.changeScale(1.0f - f3, (float)this.getHeight() - this.scrollbarHeight, scrollbarInterval.getFirstPos());
        this.animationInterval = scrollbarInterval;
        this.setCompositesDirty(true);
    }

    private float computeVisibleItemCount(MenuController menuController, float f2) {
        float f3 = 0.0f;
        int n = menuController.getHeight();
        if (f2 > 0.0f) {
            f3 = (float)n / f2;
            if ((float)this.cachedMenuItemCount * f2 < (float)n && this.cachedFlatMenuItemCount > 1) {
                int n2 = this.cachedBottomItemFlatPos - this.cachedTopItemFlatPos + 1;
                f3 = (float)n2 - (1.0f - this.cachedTopVisibleRatio) - (1.0f - this.cachedBottomVisibleRatio);
            }
        }
        return f3;
    }

    private static float clamp(float f2, float f3, float f4) {
        return f4 < f2 ? f2 : (f4 > f3 ? f3 : f4);
    }

    private static float changeScale(float f2, float f3, float f4) {
        return f4 * f3 / f2;
    }

    private static float computeEstimatedItemHeight(MenuController menuController, int n, int n2) {
        int n3;
        int n4;
        int n5 = menuController.getLayout().getItemsGap();
        Iterator iterator = menuController.iterator(menuController.getFirstMenuItem(), true, true);
        int n6 = 0;
        for (n3 = 0; iterator.hasNext() && (n6 < n || n3 < n2); n3 += n4 + n5, ++n6) {
            n4 = ScrollbarController.getItemHeight(menuController, (MenuItemIndex)iterator.next(), true);
        }
        return n6 > 0 ? (float)n3 / (float)n6 : 0.0f;
    }

    private static int getItemHeight(MenuController menuController, MenuItemIndex menuItemIndex, boolean bl) {
        return menuController.getMenuItemHeight(menuItemIndex, bl && menuController.isExpanded(menuItemIndex));
    }

    private ScrollbarInterval createIntervalFromCachedValues(MenuController menuController) {
        if (this.cachedFlatMenuItemCount == 0) {
            logScrollbar.log(10000000, "ScrollbarController#createIntervalFromCachedValues: menu is empty");
            return ScrollbarInterval.getInvisibleInterval();
        }
        if (this.entireMax <= 0) {
            boolean bl;
            float f2 = (float)this.cachedTopItemFlatPos - this.cachedTopVisibleRatio + 1.0f;
            float f3 = (float)this.cachedBottomItemFlatPos + this.cachedBottomVisibleRatio;
            boolean bl2 = bl = menuController.getLayout().getFirstVisibleItem() == menuController.getLayout().getLastVisibleItem();
            if (bl && this.cachedTopVisibleRatio < 1.0f) {
                if (this.alignTop) {
                    f2 = this.cachedTopItemFlatPos;
                    f3 = (float)this.cachedTopItemFlatPos + this.cachedTopVisibleRatio;
                } else {
                    f2 = (float)(this.cachedTopItemFlatPos + 1) - this.cachedTopVisibleRatio;
                    f3 = this.cachedTopItemFlatPos + 1;
                }
            }
            logScrollbar.log(10000000, "ScrollbarController#createIntervalFromCachedValues: menu size: %1, visible items: %2 - %3", (double)this.cachedFlatMenuItemCount, (double)f2, (double)f3);
            return ScrollbarController.createInterval(f2 / (float)this.cachedFlatMenuItemCount, f3 / (float)this.cachedFlatMenuItemCount);
        }
        float f4 = ((float)this.entireValue + (float)this.cachedTopItemFlatPos - this.cachedTopVisibleRatio + 1.0f) / (float)this.entireMax;
        float f5 = ((float)this.entireValue + (float)this.cachedBottomItemFlatPos + this.cachedBottomVisibleRatio) / (float)this.entireMax;
        return ScrollbarController.createInterval(f4, f5);
    }

    private void updateCachedIndices(MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2, MenuController menuController) {
        int n = menuController.getFlatMenuItemCount();
        int n2 = menuItemMetaData == null ? -1 : this.getFlatIndex(menuItemMetaData, true, menuController);
        int n3 = menuItemMetaData2 == null ? -1 : this.getFlatIndex(menuItemMetaData2, false, menuController);
        this.cachedTopVisibleItem = menuItemMetaData == null ? null : menuItemMetaData.index;
        this.cachedBottomVisibleItem = menuItemMetaData2 == null ? null : menuItemMetaData2.index;
        this.cachedTopItemFlatPos = n2;
        this.cachedBottomItemFlatPos = n3;
        this.cachedFlatMenuItemCount = n;
    }

    private void updateVisibleRatios(MenuController menuController) {
        this.alignTop = menuController.getAnimationManager().getLayoutData().alignTop;
        float f2 = menuController.getLayout().getFirstItemVisibleRatio();
        float f3 = menuController.getLayout().getLastItemVisibleRatio();
        this.cachedTopVisibleRatio = this.alignTop ? f2 : f3;
        this.cachedBottomVisibleRatio = this.alignTop ? f3 : f2;
    }

    private int getFlatIndex(MenuItemMetaData menuItemMetaData, boolean bl, MenuController menuController) {
        MenuItemIndex menuItemIndex = menuItemMetaData.index;
        if (menuItemMetaData.remove) {
            Iterator iterator = menuController.iterator(menuItemIndex, bl, false);
            if (iterator.hasNext()) {
                menuItemIndex = (MenuItemIndex)iterator.next();
            } else {
                return -1;
            }
        }
        return menuController.getFlatIndex(menuItemIndex);
    }

    private MenuItemMetaData getLayoutItem(int n, MenuController menuController) {
        if (n == -1) {
            return null;
        }
        List list = menuController.getAnimationManager().getLayoutData().layoutItems;
        if (n >= 0 && n < list.size()) {
            return (MenuItemMetaData)list.get(n);
        }
        logScrollbar.log(10000, "ScrollbarController#getVisibleItem: invalid index: %2, visible items: %1", (Object)list, (long)n);
        return null;
    }

    private boolean isIndicesCached(MenuItemMetaData menuItemMetaData, MenuItemMetaData menuItemMetaData2) {
        MenuItemIndex menuItemIndex = menuItemMetaData == null ? null : menuItemMetaData.index;
        MenuItemIndex menuItemIndex2 = menuItemMetaData2 == null ? null : menuItemMetaData2.index;
        return Util.equals(menuItemIndex, this.cachedTopVisibleItem) && Util.equals(menuItemIndex2, this.cachedBottomVisibleItem);
    }

    public void clearCache() {
        this.cachedTopVisibleItem = null;
        this.cachedBottomVisibleItem = null;
        this.cachedTopItemFlatPos = -1;
        this.cachedBottomItemFlatPos = -1;
        this.cachedFlatMenuItemCount = 0;
        this.cachedTopVisibleRatio = 1.0f;
        this.cachedBottomVisibleRatio = 1.0f;
        this.menuMaxVisibleItemCount = -1.0f;
    }

    private MenuController getMenu() {
        if (this.parent instanceof MenuController) {
            return (MenuController)this.parent;
        }
        logScrollbar.log(10000, "ScrollbarController#getMenu: scrollbar is not in a menu. parent: %1", (Object)this.parent);
        return null;
    }

    public void menuLayouted() {
        this.updateScrollbarPosition();
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.updateModelValue();
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    private void updateModelValue() {
        if (this.model != null && this.model instanceof RangeModel) {
            this.setEntireValue(((RangeModel)this.model).getValue());
            this.setEntireMax(((RangeModel)this.model).getMaximum());
            this.updateScrollbarPosition();
        }
    }

    public void viewportUpdated(boolean bl) {
        this.clearCache();
    }

    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    public void menuFocusChangeFinished() {
    }

    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    public void setActiveMenuController(MenuController menuController) {
    }

    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }

    public void setEntireMax(int n) {
        this.entireMax = n;
    }

    public void setEntireValue(int n) {
        this.entireValue = n;
    }

    public int getEntireValue() {
        return this.entireValue;
    }

    public int getEntireMax() {
        return this.entireMax;
    }

    public void infolineChanged() {
        this.infolineChanged = true;
    }
}

