/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.FolderOpenFocusAdvice;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayoutData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;

public class FocusAdviceHandler
implements IWidgetLogChannel {
    public static final int EVALUATION_BEST = 0;
    public static final int EVALUATION_IMPROVING = 1;
    public static final int EVALUATION_BAD = 2;
    public static final int EVALUATION_CHANGE_ALIGNMENT_WITH_FIRST_POSTION = 3;
    public static final int EVALUATION_CHANGE_ALIGNMENT_WITH_SAME_ADVICE = 4;
    private final FocusAdvice advice;
    private final MenuViewport oldViewport;
    private final MenuController menu;
    private final MenuLayoutData layoutData;
    private int heightSum;
    private int itemsCount;
    private MenuItemMetaData focusedItem;
    private MenuItemMetaData previousItem;

    public FocusAdviceHandler(FocusAdvice focusAdvice, MenuViewport menuViewport, MenuLayoutData menuLayoutData, MenuController menuController) {
        this.oldViewport = menuViewport;
        this.layoutData = menuLayoutData;
        this.menu = menuController;
        this.advice = this.setupAdvice(focusAdvice, menuViewport);
    }

    private FocusAdvice setupAdvice(FocusAdvice focusAdvice, MenuViewport menuViewport) {
        if (focusAdvice == FocusAdvice.KEEP_POSITION && menuViewport.isEmpty()) {
            FocusAdvice focusAdvice2 = this.menu.getInitialization().getInitialFocusAdvice();
            if (focusAdvice2 == FocusAdvice.KEEP_POSITION) {
                focusAdvice2 = FocusAdvice.VIEWPORT_FIRST_POSITION;
            }
            menuLogCh.log(10000000, "FocusAdviceHandler#setupAdvice: advice is KEEP_POSITION, but old viewport is empty. Use instead: %1", (Object)focusAdvice2);
            return focusAdvice2;
        }
        return focusAdvice;
    }

    public void initialize(MenuItemMetaData menuItemMetaData) {
        this.focusedItem = menuItemMetaData;
        this.previousItem = null;
        this.itemsCount = 0;
        this.heightSum = 0;
    }

    public int evaluateFocusPosition(MenuItemMetaData menuItemMetaData) {
        if (!menuItemMetaData.remove) {
            ++this.itemsCount;
        }
        int n = this.calculateEvaluationResult(menuItemMetaData);
        this.previousItem = menuItemMetaData;
        return n;
    }

    private int calculateEvaluationResult(MenuItemMetaData menuItemMetaData) {
        int n = this.heightSum;
        this.addItemHeight(menuItemMetaData);
        if (this.advice == FocusAdvice.VIEWPORT_FIRST_POSITION) {
            return this.evaluateForItemPosition(menuItemMetaData, 1);
        }
        if (this.advice == FocusAdvice.VIEWPORT_SECOND_POSITION) {
            return this.evaluateForItemPosition(menuItemMetaData, 2);
        }
        if (this.advice == FocusAdvice.VIEWPORT_LAST_POSITION) {
            if (this.isTopAligned()) {
                if (this.shouldNotScrollInItem(menuItemMetaData)) {
                    return 2;
                }
                return this.evaluatePixelAdvice(menuItemMetaData, this.getMaxHeight(), n);
            }
            return this.evaluateForItemPosition(menuItemMetaData, 1);
        }
        if (this.advice == FocusAdvice.KEEP_POSITION) {
            return this.evaluateKeepPosition(menuItemMetaData);
        }
        if (this.advice instanceof FolderOpenFocusAdvice) {
            FolderOpenFocusAdvice folderOpenFocusAdvice = (FolderOpenFocusAdvice)this.advice;
            int n2 = this.getEffectiveWidgetAdvicePixels(folderOpenFocusAdvice);
            return this.evaluateFolderOpenAdvice(menuItemMetaData, folderOpenFocusAdvice, n2, n);
        }
        if (this.advice instanceof WidgetFocusAdvice) {
            if (this.shouldNotScrollInItem(menuItemMetaData)) {
                return 2;
            }
            int n3 = this.getEffectiveWidgetAdvicePixels((WidgetFocusAdvice)this.advice);
            return this.evaluatePixelAdvice(menuItemMetaData, n3, n);
        }
        menuLogCh.log(10000, "FocusAdviceHandler#evaluateFocusPosition: unknown focus advice: %1", (Object)this.advice);
        return 2;
    }

    private boolean shouldNotScrollInItem(MenuItemMetaData menuItemMetaData) {
        boolean bl;
        boolean bl2 = bl = !new MenuUpdateManager(this.menu, this.layoutData).shouldUseItemToFillViewport(menuItemMetaData, this.focusedItem, this.oldViewport, !this.isTopAligned(), this.advice);
        if (bl) {
            menuLogCh.log(10000000, "FocusAdviceHandler#shouldNotScrollInItem: don't scroll in item %1, focus: %2, old viewport: %3", (Object)menuItemMetaData, (Object)this.focusedItem, (Object)this.oldViewport);
        }
        return bl;
    }

    private int evaluateForItemPosition(MenuItemMetaData menuItemMetaData, int n) {
        if (this.itemsCount == n) {
            return 0;
        }
        int n2 = this.getMaxHeight();
        if (this.heightSum > n2) {
            menuLogCh.log(100000, "FocusAdviceHandler#evaluateForItemPosition: exceeded max height: %2, current height sum: %3, requested position: %3", (long)n2, (long)this.heightSum, (long)n);
            return 3;
        }
        if (this.itemsCount < n) {
            return 1;
        }
        return 2;
    }

    private int evaluatePixelAdvice(MenuItemMetaData menuItemMetaData, int n, int n2) {
        if (this.heightSum > this.getMaxHeight()) {
            if (this.oldViewport.contains(menuItemMetaData.index)) {
                menuLogCh.log(100000, "FocusAdviceHandler#evaluatePixelAdvice: height too high, can't keep pixels: %2, maxHeight: %3, currentItem: %1", (Object)menuItemMetaData, (long)n, (long)this.getMaxHeight());
                return 3;
            }
            return 2;
        }
        if (this.heightSum == n) {
            return 0;
        }
        int n3 = n2 - n;
        int n4 = this.heightSum - n;
        if (Math.abs(n4) <= Math.abs(n3)) {
            if (n4 < 0) {
                return 1;
            }
            if (n4 == 0) {
                return 0;
            }
            return 0;
        }
        return 2;
    }

    private int getEffectiveWidgetAdvicePixels(WidgetFocusAdvice widgetFocusAdvice) {
        int n = widgetFocusAdvice.getPixel();
        if (n < 0) {
            menuLogCh.log(10000, "FocusAdviceHandler#getEffectiveWidgetAdvicePixels: WidgetFocusAdvive with negative pixel offset: %1", (long)n);
            n = 0;
        }
        n += this.focusedItem.heightAfter + this.menu.getMenuItemGlassplateInsets(this.focusedItem, !this.isTopAligned());
        if (this.isTopAligned() != widgetFocusAdvice.isTopAligned()) {
            n = this.getMaxHeight() - n;
        }
        return n;
    }

    private int evaluateKeepPosition(MenuItemMetaData menuItemMetaData) {
        MenuItemIndex menuItemIndex;
        if (this.heightSum > this.getMaxHeight()) {
            menuLogCh.log(10000000, "FocusAdviceHandler#evaluateKeepPosition: height too high, change alignment. currentItem: %1, oldViewport: %2, heightSum: %3", (Object)menuItemMetaData, (Object)this.oldViewport, (long)this.heightSum);
            return 3;
        }
        MenuItemIndex menuItemIndex2 = menuItemIndex = this.isTopAligned() ? this.oldViewport.start : this.oldViewport.end;
        if (menuItemMetaData.index.equals(menuItemIndex)) {
            if (menuItemMetaData.remove) {
                return this.isTopAligned() ? 2 : 1;
            }
            return 0;
        }
        if (MenuLayoutData.isBefore(menuItemIndex, menuItemMetaData.index, this.isTopAligned())) {
            return 1;
        }
        return 2;
    }

    private int evaluateFolderOpenAdvice(MenuItemMetaData menuItemMetaData, FolderOpenFocusAdvice folderOpenFocusAdvice, int n, int n2) {
        if (this.isTopAligned()) {
            int n3 = this.getMaxHeight() - folderOpenFocusAdvice.getNewItemsHeight();
            if (this.heightSum > n3) {
                return 4;
            }
        } else {
            int n4 = folderOpenFocusAdvice.getNewItemsHeight() + this.focusedItem.heightAfter + this.menu.getMenuItemGlassplateInsets(this.focusedItem, !this.isTopAligned()) + this.menu.getMenuItemGlassplateInsets(menuItemMetaData, this.isTopAligned());
            if (this.heightSum > this.getMaxHeight()) {
                return 2;
            }
            if (this.heightSum == this.getMaxHeight()) {
                return 0;
            }
            if (this.heightSum < n4) {
                return 1;
            }
            if (this.heightSum == n4) {
                int n5 = this.evaluatePixelAdvice(menuItemMetaData, n, n2);
                return n5 == 1 ? 1 : 0;
            }
        }
        return this.evaluatePixelAdvice(menuItemMetaData, n, n2);
    }

    private void addItemHeight(MenuItemMetaData menuItemMetaData) {
        int n;
        int n2;
        boolean bl;
        boolean bl2 = bl = this.previousItem == null;
        if (bl) {
            n2 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData, !this.isTopAligned());
            n = 0;
        } else {
            n2 = this.menu.getLayout().getItemsGap();
            n = this.menu.getMenuItemGlassplateInsets(this.previousItem, this.isTopAligned());
        }
        int n3 = this.menu.getMenuItemGlassplateInsets(menuItemMetaData, this.isTopAligned());
        this.heightSum += menuItemMetaData.heightAfter + n2 + n3 - n;
    }

    private boolean isTopAligned() {
        return this.layoutData.alignTop;
    }

    private int getMaxHeight() {
        return this.menu.getLayout().getContentAreaHeight();
    }
}

