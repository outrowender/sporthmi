/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.listener.ContentEnabledListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.BaselineWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxBackgroundController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxBackgroundRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxMenuBuilder;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SubElementMenuController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComboBoxController
extends AbstractWidgetController
implements BaselineWidget,
AnimationListener,
ContentEnabledListener {
    private int maxMenuHeight;
    private static final int MAX_HIERACHY_DEPTH;
    public static final int TYPE_NORMAL_COMBOBOX;
    public static final int TYPE_SUBELEMENT_COMBOBOX;
    private static final int SUBMENU_INSET;
    private int type;
    private int subElementMenuX = 0;
    private ComboBoxRenderer renderer;
    private boolean open = false;
    private AbstractAnimation animation;
    private int closedMenuY;
    private int openMenuY;
    private MenuController menu;
    private LabelController label;
    private IconController closedIcon;
    private ComboBoxBackgroundController comboBoxBackground;
    private boolean isOpening;
    private boolean isClosing;
    private int[] textIds;
    private int labelTextID;
    private int availableHintsAtRenderer = 0;
    private int availableHints = 0;
    private int selectedIndex = -1;
    private int[] cursorColors;
    private int[][] mapping;
    private LabelController[] labelControllers;
    private int openMenuWidth;
    private int closedMenuWidth;
    private int additionalSpace;
    private ComboBoxTimerController timer;
    private int contentTopOffset;
    private int contentBottomOffset;
    private int contentLeftOffset;
    private int contentRightOffset;
    private int closedMinHeight;
    private int insetsPreviewVert;
    private int closedIconoffsetX;
    private int closedIconLabelGap;
    private int closedIconWidth;
    private int scrollbarTopOffset;
    private int scrollbarBottomOffset;
    private int scrollbarWidth;
    private int contentScrollbarDistance;
    private int scrollbarBackgroundDistance;
    private int openComboToParentGlassplateDistance;

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.setComboBoxTextEnabledOrDisabled();
        if (this.timer == null) {
            this.timer = new ComboBoxTimerController();
            this.add(this.timer);
        }
    }

    @Override
    protected void afterConnected() {
        super.afterConnected();
        if (this.type == 0) {
            int n = 0;
            Object object = this.menu.getChildren().iterator();
            while (object.hasNext()) {
                AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object.next();
                if (!this.menu.isMenuItem(abstractWidgetController)) continue;
                n = this.layoutItem(n, abstractWidgetController);
            }
            object = this.terminal.getLayout();
            int n2 = object.getIntegerConstant(33);
            int n3 = object.getIntegerConstant(32);
            int n4 = object.getIntegerConstant(35);
            int n5 = object.getIntegerConstant(0);
            int n6 = Math.max(n5, n += n2 + n3 + n4);
            this.setPreferredWidth(n6);
            this.menu.setBounds(0, 0, n6, 20);
            this.menu.getLayout().setBackgroundInsetsVert(5);
            this.menu.getLayout().setItemsGap(2);
            this.menu.getLayout().setContentLeftOffset(0);
            this.menu.getLayout().setContentRightOffset(0);
            this.menu.getInitialization().setPersistentLayout(false);
            ((AbstractWidgetController)this.menu.getChildOfRole(3)).setBounds(this.menu.getWidth() - (object.getIntegerConstant(20) + object.getIntegerConstant(21) + object.getIntegerConstant(19)), object.getIntegerConstant(22), object.getIntegerConstant(20), this.menu.getHeight() - object.getIntegerConstant(22) + object.getIntegerConstant(23));
            this.menu.setCompositesDirty(true);
        }
    }

    private int layoutItem(int n, AbstractWidgetController abstractWidgetController) {
        MenuItemController menuItemController = (MenuItemController)abstractWidgetController;
        menuItemController.setMarginBottom(0);
        menuItemController.setGlassplateInsetsTop(0);
        if (menuItemController.isVisible()) {
            if (this.getType() == 0) {
                LabelController labelController = (LabelController)abstractWidgetController.getChild(0);
                n = Math.max(n, labelController.getPreferredWidth());
            } else {
                n = Math.max(n, abstractWidgetController.getPreferredWidth());
            }
        }
        return n;
    }

    private int menuItemIndexToComboIndex(int n) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.menu.getChildrenSize(); ++i2) {
            if (!(this.menu.getChild(i2) instanceof MenuItemController)) continue;
            if (n == n2) {
                return i2;
            }
            ++n2;
        }
        return n;
    }

    @Override
    public void setContentEnabled(int n, boolean bl) {
        if (n < 0 || n > this.menu.getChildren().size() - 1) {
            return;
        }
        this.menu.getChild(this.menuItemIndexToComboIndex(n)).setEnabled(bl);
        this.setComboBoxTextEnabledOrDisabled();
    }

    @Override
    public void setContentVisible(int n, boolean bl) {
        if (n < 0 || n > this.menu.getChildren().size() - 1) {
            return;
        }
        this.menu.getChild(this.menuItemIndexToComboIndex(n)).setVisible(bl);
    }

    public List getVisibleContent() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.menu.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!this.menu.isMenuItem(abstractWidget) || !abstractWidget.isVisible()) continue;
            arrayList.add(abstractWidget);
        }
        return arrayList;
    }

    public ComboBoxBackgroundController getComboBoxBackground() {
        return this.comboBoxBackground;
    }

    public ComboBoxController() {
        this.type = 0;
    }

    public ComboBoxController(int n) {
        this.setType(n);
    }

    public void setType(int n) {
        this.type = n == 1 ? n : 0;
    }

    public int getType() {
        return this.type;
    }

    public int getLabelTextID() {
        return this.labelTextID;
    }

    public void setLabelTextID(int n) {
        this.labelTextID = n;
    }

    private void initLayoutValues() {
        Layout layout = ((HMITerminalImpl)this.getTerminal()).getLayout();
        this.contentTopOffset = layout.getIntegerConstant(37);
        this.contentBottomOffset = layout.getIntegerConstant(38);
        this.contentLeftOffset = layout.getIntegerConstant(18);
        this.contentRightOffset = layout.getIntegerConstant(19);
        this.closedMinHeight = layout.getIntegerConstant(25);
        this.insetsPreviewVert = layout.getIntegerConstant(27);
        this.closedIconoffsetX = layout.getIntegerConstant(33);
        this.closedIconLabelGap = layout.getIntegerConstant(32);
        this.closedIconWidth = layout.getIntegerConstant(35);
        this.scrollbarTopOffset = layout.getIntegerConstant(39);
        this.scrollbarBottomOffset = layout.getIntegerConstant(40);
        this.scrollbarWidth = layout.getIntegerConstant(41);
        this.contentScrollbarDistance = layout.getIntegerConstant(42);
        this.scrollbarBackgroundDistance = layout.getIntegerConstant(43);
        this.openComboToParentGlassplateDistance = layout.getIntegerConstant(67);
        this.maxMenuHeight = layout.getIntegerConstant(77);
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.refreshAvailableHints();
        this.open = false;
        this.cursorColors = this.getMenuCursorColors();
        this.ensureBackgroundCreated();
        this.ensureLabelCreated();
        this.ensureClosedIconCreated();
        this.ensureMenuCreated();
        this.updateContent();
        this.initLayoutValues();
        if (this.type == 1) {
            this.comboBoxBackground.setVisible(false);
        }
    }

    private void createAnimation() {
        if (this.animation == null) {
            this.animation = (AbstractAnimation)((AbstractAnimationController)this.getTerminal().getIAnimationController()).getIAnimation(98);
            this.animation.addListener(this);
        }
    }

    private int[] getMenuCursorColors() {
        AbstractWidget abstractWidget = this.getParent();
        for (int i2 = 0; i2 < 5; ++i2) {
            if (abstractWidget instanceof MenuController) {
                AbstractWidget abstractWidget2 = ((MenuController)abstractWidget).getChildOfRole(1);
                if (abstractWidget2 != null) {
                    return abstractWidget2.getColorIndices();
                }
                return null;
            }
            if (abstractWidget == null) {
                return null;
            }
            abstractWidget = abstractWidget.getParent();
        }
        return null;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(ComboBoxRenderer comboBoxRenderer) {
        this.renderer = comboBoxRenderer;
    }

    public boolean isOpen() {
        return this.open;
    }

    public boolean isAnimating() {
        if (this.animation == null) {
            return false;
        }
        return this.animation.isAnimating();
    }

    private void refreshAvailableHints() {
        if (this.availableHints != 0 && this.availableHints != this.availableHintsAtRenderer) {
            int n = this.availableHints;
            Iterator iterator = this.menu.getChildren().iterator();
            while (iterator.hasNext()) {
                AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
                if (!this.menu.isMenuItem(abstractWidget)) continue;
                if ((n & 1) != 0) {
                    if (!abstractWidget.isVisible()) {
                        abstractWidget.setVisible(true);
                    }
                } else if (abstractWidget.isVisible()) {
                    abstractWidget.setVisible(false);
                }
                n >>= 1;
            }
        }
        this.availableHintsAtRenderer = this.availableHints;
    }

    public void updateScrollbarBounds() {
        AbstractWidget abstractWidget = this.menu.getChildOfRole(3);
        if (abstractWidget != null) {
            abstractWidget.setBounds(this.menu.getWidth() + this.contentScrollbarDistance + this.additionalSpace, this.scrollbarTopOffset, this.scrollbarWidth, this.menu.getHeight() - (this.scrollbarTopOffset + this.scrollbarBottomOffset));
        }
    }

    public void prepareForOpen() {
        if (this.renderer != null) {
            this.renderer.open();
            this.setCompositesDirty(true);
        }
        MenuItemIndex menuItemIndex = this.updateItemsSelectedState(this.selectedIndex);
        int[] nArray = this.calculateMenuHeight(menuItemIndex);
        int n = nArray[0];
        int n2 = nArray[1];
        this.menu.setHeight(n2);
        int n3 = -this.menu.getWidth() + this.getWidth();
        int n4 = -n - this.getMenuItemBaselineOffset(menuItemIndex);
        n4 = this.adjustMenuYForParentMenu(n4, this.getMenuItemBaselineOffset(menuItemIndex));
        if (this.type == 1) {
            int n5 = 0;
            if (this.isScrollbarNeeded()) {
                n5 = this.contentScrollbarDistance + this.scrollbarWidth + this.scrollbarBackgroundDistance;
            }
            this.subElementMenuX = ((SubElementMenuController)this.getParent()).getParent().getWidth() - (this.menu.getWidth() + 18) - n5;
            this.menu.setX(this.subElementMenuX - 18);
            this.menu.setY(n4 - 15);
        } else {
            this.menu.setX(n3);
            this.menu.setY(n4);
        }
        this.updateScrollbarBounds();
        this.menu.setViewport(new MenuViewport(null, null));
        MenuItemIndex menuItemIndex2 = this.menu.getFirstMenuItem();
        if (menuItemIndex2 != null) {
            menuLogCh.log(-2137614336, "ComboBoxController#prepareForOpen: focus first menu item with index: %1", (Object)menuItemIndex2);
            this.menu.focusItemImmediately(menuItemIndex2, FocusAdvice.KEEP_POSITION);
        }
        if (menuItemIndex != null) {
            menuLogCh.log(-2137614336, "ComboBoxController#prepareForOpen: focus selected menu item with index: %1", (Object)menuItemIndex);
            this.menu.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
        }
        this.menu.setCompositesDirty(true);
    }

    private int getMenuItemBaselineOffset(MenuItemIndex menuItemIndex) {
        if (menuItemIndex == null) {
            return 0;
        }
        int n = this.menu.getLayout().getContentInsetsVert();
        AbstractWidget abstractWidget = this.menu.getChild(menuItemIndex.widget);
        int n2 = this.getBaseline();
        if (abstractWidget instanceof BaselineWidget) {
            return ((BaselineWidget)((Object)abstractWidget)).getBaseline() - n2 + n;
        }
        if (abstractWidget != null) {
            logChannel.log(-1601830656, "ComboBoxController#getMenuItemBaselineOffset: combo item is not a baselineWidget. Index: %1, widget: %2", (Object)menuItemIndex, (Object)abstractWidget);
            return abstractWidget.getHeight() - n2 + n;
        }
        logChannel.log(-1601830656, "ComboBoxController#getMenuItemBaselineOffset: combo item %1 is null", (Object)menuItemIndex);
        return n;
    }

    private int[] calculateMenuHeight(MenuItemIndex menuItemIndex) {
        int[] nArray = this.menu.calculateMenuHeight(this.menu.getFirstMenuItem(), menuItemIndex);
        nArray[1] = Math.min(nArray[1], this.maxMenuHeight);
        return nArray;
    }

    private int adjustMenuYForParentMenu(int n, int n2) {
        AbstractWidget abstractWidget = this.getParent().getParent();
        if (!(abstractWidget instanceof MenuController)) {
            logChannel.log(-1601830656, "ComboBoxController#adjustMenuYForParentMenu: comboBox is not inside a parent menu.");
            return n;
        }
        MenuController menuController = (MenuController)abstractWidget;
        MenuItemIndex menuItemIndex = menuController.getMenuItemIndex(this.getParent());
        if (menuItemIndex == null) {
            logChannel.log(-1601830656, "ComboBoxController#adjustMenuYForParentMenu: parent MenuItem not found in parent menu.");
            return n;
        }
        int n3 = 0;
        int n4 = 1;
        if (this.terminal.getFramework().getKombiType() == 4) {
            n3 = this.getTerminalImpl().getLayout().getIntegerConstant(71);
            n4 = menuController.getLayout().getContentInsetsVert() + menuController.getMenuItemGlassplateInsets(menuItemIndex, true) - n3;
        }
        n = Math.max(n, -(this.getY() + this.parent.getY()) + this.openComboToParentGlassplateDistance - n4);
        int n5 = 2;
        if (this.terminal.getFramework().getKombiType() == 4) {
            n5 = menuController.getLayout().getContentInsetsVert() + menuController.getMenuItemGlassplateInsets(menuItemIndex, false) - n3;
        }
        int n6 = this.parent.getHeight() - (this.getY() + this.getHeight());
        n = Math.min(n, menuController.getHeight() - this.parent.getY() - this.menu.getHeight() - n6 - this.openComboToParentGlassplateDistance + n5);
        return n;
    }

    public MenuItemIndex comboIndexToMenuItemIndex(int n) {
        if (n == -1) {
            return null;
        }
        int n2 = 0;
        int n3 = 0;
        Iterator iterator = this.menu.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (this.menu.isMenuItem(abstractWidget)) {
                if (n2 == n) {
                    return new MenuItemIndex(n3, 0);
                }
                ++n2;
            }
            ++n3;
        }
        logChannel.log(10000, "ComboBoxController#comboModelIndexToMenuItemIndex: combo index %1 too high. menu has only %2 items", (long)n, (long)n2);
        return null;
    }

    private MenuItemIndex updateItemsSelectedState(int n) {
        int n2 = 0;
        int n3 = 0;
        MenuItemIndex menuItemIndex = null;
        Iterator iterator = this.menu.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (this.menu.isMenuItem(abstractWidget)) {
                MenuItemController menuItemController = (MenuItemController)abstractWidget;
                boolean bl = n2 == n;
                boolean bl2 = menuItemController.isSelected();
                menuItemController.setSelected(bl);
                if (bl2 != bl) {
                    this.menu.selectionChanged(menuItemController);
                }
                if (bl) {
                    menuItemIndex = new MenuItemIndex(n3, 0);
                }
                ++n2;
            }
            ++n3;
        }
        return menuItemIndex;
    }

    public int menuItemIndexToComboIndex(MenuItemIndex menuItemIndex) {
        if (menuItemIndex == null) {
            return -1;
        }
        int n = 0;
        int n2 = 0;
        Iterator iterator = this.menu.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (this.menu.isMenuItem(abstractWidget)) {
                if (n2 == menuItemIndex.widget) {
                    return n;
                }
                ++n;
            }
            ++n2;
        }
        logChannel.log(10000, "ComboBoxController#menuItemIndexToComboModelIndex: invalid menu index: %1. menu has only %2 items", (Object)menuItemIndex, (long)n);
        return -1;
    }

    int comboIndexToModelValue(int n) {
        if (this.mapping == null || this.mapping.length == 0) {
            return n;
        }
        if (n < 0 || n >= this.mapping.length) {
            logChannel.log(10000, "ComboBoxController#comboIndexToModelValue: invalid combo index: %1. mapping length: %2", (long)n, (long)this.mapping.length);
            return -1;
        }
        return this.mapping[n][0];
    }

    int modelValueToComboIndex(int n) {
        if (this.mapping == null || this.mapping.length == 0) {
            return n;
        }
        for (int i2 = 0; i2 < this.mapping.length; ++i2) {
            if (this.mapping[i2][0] != n) continue;
            return i2;
        }
        logChannel.log(10000, "ComboBoxController#modelValueToComboIndex: no mapping found for model value: %1", (long)n);
        return -1;
    }

    private void setMenuVisible(boolean bl) {
        boolean bl2;
        this.menu.setVisible(bl);
        this.menu.setActive(bl);
        boolean bl3 = bl2 = !bl;
        if (this.type == 0) {
            this.label.setVisible(bl2);
            this.closedIcon.setVisible(bl2);
        } else {
            this.closedIcon.setVisible(false);
            this.label.setVisible(false);
        }
    }

    private void ensureMenuCreated() {
        if (this.menu != null) {
            return;
        }
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!(abstractWidgetController instanceof MenuController)) continue;
            this.menu = (MenuController)abstractWidgetController;
            this.closedMenuY = this.menu.getY();
            return;
        }
        logChannel.log(-2137614336, "ComboBoxController#ensureMenuCreated: no menu found. Create one.");
        this.menu = this.instantiateMenu();
        new ComboBoxMenuBuilder((ExtHMITerminalEvo)((Object)this.getTerminalImpl())).configureMenu(this.menu, this, this.cursorColors);
        this.setMenuVisible(false);
        this.closedMenuY = this.menu.getY();
    }

    protected MenuController instantiateMenu() {
        return new MenuController();
    }

    private void ensureLabelCreated() {
        if (this.label != null) {
            return;
        }
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!(abstractWidgetController instanceof LabelController)) continue;
            this.label = (LabelController)abstractWidgetController;
            return;
        }
        logChannel.log(-2137614336, "ComboBoxController#ensureLabelCreated: no label found. Create one.");
        this.label = new ComboBoxMenuBuilder((ExtHMITerminalEvo)((Object)this.getTerminalImpl())).createPreviewLabel(this);
    }

    private void ensureClosedIconCreated() {
        if (this.closedIcon != null) {
            return;
        }
        Iterator iterator = this.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (!(abstractWidgetController instanceof IconController)) continue;
            this.closedIcon = (IconController)abstractWidgetController;
            return;
        }
        logChannel.log(-2137614336, "ComboBoxController#ensureLabelCreated: no label found. Create one.");
        this.closedIcon = new ComboBoxMenuBuilder((ExtHMITerminalEvo)((Object)this.getTerminalImpl())).createClosedIcon(this);
    }

    private void ensureBackgroundCreated() {
        if (this.comboBoxBackground != null) {
            return;
        }
        logChannel.log(-2137614336, "ComboBoxController#ensureGlassplateCreated: no glassplate found. Create one.");
        this.comboBoxBackground = new ComboBoxMenuBuilder((ExtHMITerminalEvo)((Object)this.getTerminalImpl())).createComboBoxBackground(this);
        this.comboBoxBackground.setColorIndices(this.getColorIndices());
    }

    private void selectFocusedItem() {
        int n = this.menuItemIndexToComboIndex(this.menu.getFocusedIndex());
        if (n != -1) {
            this.setSelectedIndex(n);
            this.fireItemSelected(n);
        }
    }

    private void fireItemSelected(int n) {
        if (this.model instanceof ChoiceModelGUI) {
            ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)this.model;
            int n2 = this.comboIndexToModelValue(n);
            logChannel.log(-2137614336, "ComboBoxController#fireItemSelected: notify choice model %1 with item %2, model value %3", (long)choiceModelGUI.getID(), (long)n, (long)n2);
            choiceModelGUI.itemSelected(n2, this.getTerminalImpl().getTerminalID());
        } else {
            logChannel.log(-1601830656, "ComboBoxController#fireItemSelected(%2): unknown model: %1", this.model, (long)n);
        }
    }

    public int[] getTextIds() {
        return this.textIds;
    }

    public void setTextIds(int[] nArray) {
        this.textIds = nArray;
    }

    public void setLabelControllers(LabelController[] labelControllerArray) {
        this.labelControllers = labelControllerArray;
    }

    public LabelController[] getLabelControllers() {
        return this.labelControllers;
    }

    private void itemFocused(int n) {
        if (this.model != null) {
            ((ChoiceModelGUI)this.model).itemFocused(n, this.terminal.getTerminalID());
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.isConsumed() || !this.hasState(36)) {
            return;
        }
        if (this.isOpen()) {
            if (keyEvent.getKeyCode() == 17) {
                this.timer.restartTimer();
                this.selectFocusedItem();
                this.close();
                keyEvent.consume();
            } else if (keyEvent.getKeyCode() == 15) {
                this.close();
                keyEvent.consume();
            }
        } else if (keyEvent.getKeyCode() == 17) {
            this.open();
            keyEvent.consume();
        }
    }

    public void setComboBoxTextEnabledOrDisabled() {
        MenuItemIndex menuItemIndex;
        AbstractWidgetController abstractWidgetController = null;
        if (this.menu != null && this.getSelectedIndex() != -1 && (menuItemIndex = this.comboIndexToMenuItemIndex(this.getSelectedIndex())) != null) {
            if (this.menu.getChild(menuItemIndex.widget) != null) {
                abstractWidgetController = (MenuItemController)this.menu.getChild(menuItemIndex.widget);
            }
            if (abstractWidgetController != null && abstractWidgetController.getChild(0) != null && this.label != null) {
                boolean bl = false;
                if (this.hasState(36)) {
                    bl = abstractWidgetController.getChild(0).isEnabled();
                }
                this.label.setEnabled(bl);
            }
        }
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        if (joystickEvent.isConsumed() || !this.hasState(36)) {
            return;
        }
        if (this.isOpen() && joystickEvent.getDirection() == 8) {
            this.close();
            joystickEvent.consume();
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1 || n == 2 || n == 18 || n == 14) {
            this.updateContent();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    protected boolean updateContent() {
        boolean bl = this.setSelectedIndex(this.getSelectedIndexFromModel());
        this.setComboBoxTextEnabledOrDisabled();
        return bl;
    }

    public boolean setSelectedIndex(int n) {
        if (this.selectedIndex == n && this.type == 0) {
            logChannel.log(-2137614336, "ComboBoxController#setSelectedIndex: selected index equals model value, no further action");
            return false;
        }
        this.selectedIndex = n;
        logChannel.log(-2137614336, "ComboBoxController#setSelectedIndex: new selected index, update label");
        this.updateLabel();
        this.setCompositesDirty(true);
        this.invalidateParentLayout();
        return true;
    }

    private void updateLabel() {
        if (this.type == 1) {
            this.label.setTextIds(new int[]{this.labelTextID});
        } else if (this.selectedIndex == -1) {
            this.label.setTextIds(null);
        } else if (this.labelControllers == null && this.textIds == null) {
            logChannel.log(10000, "ComboBoxController#updateLabel: textIDs and textLabels are null. selectedIndex: %1", (long)this.selectedIndex);
            this.label.setTextIds(null);
        } else {
            int n;
            int n2 = this.textIds == null ? 0 : this.textIds.length;
            int n3 = n = this.labelControllers == null ? 0 : this.labelControllers.length;
            if (this.selectedIndex < 0 || this.selectedIndex >= n2 + n) {
                logChannel.log(10000, "ComboBoxController#updateLabel: invalid selected index: %1, textIDs.length: %2 + textLabels.length: %3", (long)this.selectedIndex, (long)n2, (long)n);
                this.label.setTextIds(null);
            } else if (this.selectedIndex < n2) {
                this.label.setTextIds(new int[]{this.textIds[this.selectedIndex]});
            } else if (this.labelControllers != null) {
                LabelController labelController = this.labelControllers[this.selectedIndex - n2];
                this.label.setModel(labelController.getModel());
            }
        }
        this.label.updateContent();
        this.label.setCompositesDirty(true);
    }

    protected int getSelectedIndexFromModel() {
        if (this.model == null) {
            return -1;
        }
        if (this.model instanceof HMIModelGUI && ((HMIModelGUI)this.model).getStatus() == 3) {
            return -1;
        }
        if (this.model instanceof ChoiceModelGUI) {
            ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)this.model;
            this.availableHints = choiceModelGUI.getHints();
            int n = choiceModelGUI.getValue();
            return this.modelValueToComboIndex(n);
        }
        logChannel.log(-1601830656, "ComboBoxController#getSelectedIndexFromModel: Unknown model %2: %1", this.model, (long)this.modelID);
        return -1;
    }

    @Override
    public int getPreferredHeight() {
        int n = Math.max(this.label.getPreferredHeight(), this.closedIcon.getPreferredHeight());
        return n;
    }

    @Override
    public int getBaseline() {
        return this.label.getBaseline();
    }

    @Override
    public void render(RedrawContext redrawContext) {
        this.doLayout();
        super.render(redrawContext);
    }

    public void doLayout() {
        int n;
        int n2;
        if (this.type == 0) {
            this.menu.setWidth(this.getWidth());
            this.menu.getLayout().setContentRightOffset(-this.additionalSpace);
        }
        if (!this.open) {
            int n3;
            if (this.type == 1) {
                n2 = Math.min(this.height, this.label.getPreferredHeight());
                int n4 = Math.max(0, (this.height - n2) / 2);
                int n5 = this.parent.getWidth();
                this.label.setBounds(0, n4, n5, n2);
                n3 = n4;
                n = n2;
            } else {
                n2 = Math.min(this.height, this.closedIcon.getPreferredHeight());
                int n6 = Math.max(0, (this.height - n2) / 2);
                this.closedIcon.setBounds(this.closedIconoffsetX, n6 - 1, this.closedIconWidth, n2);
                int n7 = Math.min(this.height, this.label.getPreferredHeight());
                int n8 = Math.max(0, (this.height - n7) / 2);
                int n9 = this.closedIconoffsetX + this.closedIconWidth + this.closedIconLabelGap;
                int n10 = this.getWidth() - n9;
                this.label.setBounds(n9, n8, n10, n7);
                n3 = Math.min(n8, n6);
                n = Math.max(n7, n2);
            }
            if (!this.isOpening && !this.isClosing) {
                this.comboBoxBackground.setBounds(this.menu.getX(), n3 - this.insetsPreviewVert, this.getWidth() + this.additionalSpace, n + this.insetsPreviewVert * 2);
                this.closedMenuWidth = this.menu.getWidth() + this.additionalSpace;
            }
        } else {
            AbstractWidget abstractWidget = this.menu.getChildOfRole(3);
            if (abstractWidget != null && this.isScrollBarVisible()) {
                this.openMenuWidth = this.contentLeftOffset + this.menu.getWidth() + this.contentScrollbarDistance + this.scrollbarWidth + this.scrollbarBackgroundDistance;
                if (this.type == 0) {
                    this.openMenuWidth += this.additionalSpace;
                }
            } else {
                this.openMenuWidth = this.type == 0 ? this.getWidth() + this.additionalSpace : this.menu.getWidth();
            }
        }
        if (this.type == 1) {
            int n11 = 0;
            if (this.isScrollbarNeeded()) {
                n11 = this.contentScrollbarDistance + this.scrollbarWidth + this.scrollbarBackgroundDistance;
            }
            this.subElementMenuX = ((SubElementMenuController)this.getParent()).getParent().getWidth() - (this.menu.getWidth() + 18) - n11;
            this.menu.setX(this.subElementMenuX - 18);
            if (!this.isOpening && !this.isClosing) {
                n = this.openMenuWidth - this.closedMenuWidth;
                this.comboBoxBackground.setWidth(this.closedMenuWidth + (n + this.contentLeftOffset + this.contentRightOffset) - (this.isScrollbarNeeded() ? this.scrollbarBackgroundDistance : 0));
                n2 = this.contentLeftOffset - (this.subElementMenuX - 18);
                this.comboBoxBackground.setX(-n2);
            }
        }
    }

    public boolean isScrollBarVisible() {
        return this.menu.getViewport().start == null || !this.menu.getViewport().start.equals(this.menu.getFirstMenuItem()) || !this.menu.getViewport().end.equals(this.menu.getLastMenuItem());
    }

    public boolean isScrollbarNeeded() {
        int n = this.menu.getHeight();
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < this.menu.getChildrenSize(); ++i2) {
            MenuItemController menuItemController;
            if (!(this.menu.getChild(i2) instanceof MenuItemController) || !(menuItemController = (MenuItemController)this.menu.getChild(i2)).isVisible()) continue;
            if (n3 == 0) {
                n3 = menuItemController.getHeight();
            }
            ++n2;
        }
        return n2 * n3 > n;
    }

    public MenuController getMenu() {
        return this.menu;
    }

    public LabelController getLabel() {
        return this.label;
    }

    public IconController getClosedIcon() {
        return this.closedIcon;
    }

    @Override
    public void disconnecting() {
        this.close();
        this.timer.cancelTimer();
        super.disconnecting();
    }

    @Override
    public void predisconnecting() {
        if (this.isOpen()) {
            this.close();
            this.itemFocused(-1);
        }
        super.predisconnecting();
    }

    public int[][] getMapping() {
        return this.mapping;
    }

    public void setMapping(int[][] nArray) {
        this.mapping = nArray;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override
    protected void destroyWidget() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        this.animation = null;
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        if (this.isClosing) {
            this.comboBoxBackground.close();
            this.open = false;
            if (this.menu != null) {
                this.setMenuVisible(false);
            }
            if (this.renderer != null) {
                this.renderer.close();
            }
            this.setCompositesDirty(true);
            this.label.setDepth(-129);
            this.label.setCompositesDirty(true);
            if (this.type == 1) {
                this.comboBoxBackground.setVisible(false);
            }
            if (this.comboBoxBackground != null && this.comboBoxBackground.getRenderer() != null) {
                ((ComboBoxBackgroundRenderer)this.comboBoxBackground.getRenderer()).setOpenValue(0.0f);
            }
            this.dimParentElements(1.0f, true);
        }
        this.isOpening = false;
        this.isClosing = false;
    }

    @Override
    public void animate(int n, float f2, int n2) {
        if (n == 98) {
            int n3;
            int n4;
            int n5;
            if (this.isOpening) {
                if (this.type == 1) {
                    this.setOpacity(this.animation.getProgress());
                }
                if ((n5 = (int)(f2 * (float)this.menu.getHeight() / this.animation.getTarget()) + this.contentTopOffset + this.contentBottomOffset) > this.closedMinHeight) {
                    this.comboBoxBackground.setHeight(n5);
                    this.openMenuY = this.closedMenuY + (int)(f2 * (float)(this.menu.getY() - this.closedMenuY - this.contentTopOffset) / this.animation.getTarget());
                    this.comboBoxBackground.setY(this.openMenuY);
                }
                ((ComboBoxBackgroundRenderer)this.comboBoxBackground.getRenderer()).setOpenValue(f2 / this.animation.getTarget());
                n4 = this.openMenuWidth - this.closedMenuWidth;
                this.comboBoxBackground.setWidth(this.closedMenuWidth + (int)(f2 * (float)(n4 + this.contentLeftOffset + this.contentRightOffset) / this.animation.getTarget()) - (this.isScrollbarNeeded() ? this.scrollbarBackgroundDistance : 0));
                n3 = (int)((float)this.contentLeftOffset * this.animation.getValue() / this.animation.getTarget()) - (this.type == 1 ? this.subElementMenuX - 18 : 0);
                this.comboBoxBackground.setX(-n3);
            }
            if (this.isClosing) {
                if (this.type == 0) {
                    n5 = this.menu.getHeight() + this.label.getHeight();
                } else {
                    this.setOpacity(1.0f - this.animation.getProgress());
                    n5 = this.comboBoxBackground.getHeight();
                }
                if ((n5 -= (int)(f2 * (float)(this.menu.getHeight() - (this.label.getHeight() + this.contentTopOffset)) / this.animation.getTarget())) > this.closedMinHeight) {
                    this.comboBoxBackground.setHeight(n5);
                    n4 = this.openMenuY - (int)(f2 * (float)(this.openMenuY - this.closedMenuY + this.contentTopOffset) / this.animation.getTarget()) - this.contentTopOffset;
                    this.comboBoxBackground.setY(n4);
                } else {
                    this.comboBoxBackground.setY(this.closedMenuY - this.contentTopOffset);
                }
                ((ComboBoxBackgroundRenderer)this.comboBoxBackground.getRenderer()).setOpenValue(1.0f - f2 / this.animation.getTarget());
                n4 = this.openMenuWidth - this.closedMenuWidth;
                if (n4 > this.contentLeftOffset + this.contentRightOffset) {
                    this.comboBoxBackground.setWidth(this.openMenuWidth - (int)(f2 * (float)n4 / this.animation.getTarget()));
                    n3 = (int)((float)this.contentLeftOffset * this.animation.getValue() / this.animation.getTarget());
                    this.comboBoxBackground.setX(-this.contentLeftOffset + (n3 += this.type == 1 ? this.subElementMenuX + 18 : 0));
                } else {
                    this.comboBoxBackground.setWidth(this.openMenuWidth + (this.contentLeftOffset + this.contentRightOffset) - (int)(f2 * (float)(this.contentLeftOffset + this.contentRightOffset) / this.animation.getTarget()));
                    n3 = (int)((float)this.contentLeftOffset * this.animation.getValue() / this.animation.getTarget());
                    this.comboBoxBackground.setX(-this.contentLeftOffset + (n3 += this.type == 1 ? this.subElementMenuX + 18 : 0));
                }
            }
            this.setCompositesDirty(true);
        } else if (n == 76 && this.type == 1) {
            this.setOpacity(this.animation.getProgress());
            int n6 = (int)(f2 * (float)this.menu.getHeight() / this.animation.getTarget()) + this.contentTopOffset + this.contentBottomOffset;
            this.comboBoxBackground.setHeight(n6);
            this.openMenuY = this.closedMenuY + (int)(f2 * (float)(this.menu.getY() - this.closedMenuY - this.contentTopOffset) / this.animation.getTarget());
            this.comboBoxBackground.setY(this.openMenuY);
            ((ComboBoxBackgroundRenderer)this.comboBoxBackground.getRenderer()).setOpenValue(f2 / this.animation.getTarget());
            int n7 = this.openMenuWidth - this.closedMenuWidth;
            this.comboBoxBackground.setWidth(this.closedMenuWidth + (int)(f2 * (float)(n7 + this.contentLeftOffset + this.contentRightOffset) / this.animation.getTarget()) - (this.isScrollbarNeeded() ? this.scrollbarBackgroundDistance : 0));
            int n8 = (int)((float)this.contentLeftOffset * this.animation.getValue() / this.animation.getTarget()) - (this.subElementMenuX - 18);
            this.comboBoxBackground.setX(-n8);
        }
    }

    private void animate() {
        this.createAnimation();
        if (this.animation.isAnimating()) {
            this.animation.stopAnimation();
        } else {
            this.doLayout();
            this.animation.startDynamicAnimation(0.0f, 31300, 98, true, this);
        }
    }

    public void calculateAndAnimateBackground() {
        if (!this.isOpening) {
            this.prepareForOpen();
            this.createAnimation();
            if (this.animation.isAnimating()) {
                this.animation.stopAnimation();
            } else {
                this.doLayout();
                this.animation.startDynamicAnimation(0.0f, 31300, 76, true, this);
            }
        }
    }

    private void dimParentElements(float f2, boolean bl) {
        if (this.getParent() != null && this.getParent().getParent() != null && this.getParent().getParent() instanceof MenuController) {
            MenuController menuController = (MenuController)this.getParent().getParent();
            menuController.setComboBoxOpen(this.open);
            menuController.setOpenComboboxOpacity(f2);
            AbstractWidget abstractWidget = menuController.getChildOfRole(1);
            if (abstractWidget != null) {
                abstractWidget.setEnabled(bl);
                abstractWidget.setCompositesDirty(true);
            }
            menuController.relayout();
        }
    }

    public void close() {
        if (!this.isOpening && this.open) {
            this.reset();
        } else if (this.type == 1 && !this.getParent().isVisible()) {
            logChannel.log(-1601830656, "ComboBoxController#close Parent (SubelementMenuController) was set to invisible, close combobox");
            this.reset();
        }
    }

    public void reset() {
        if (this.open || this.isOpening) {
            this.open = false;
            this.isOpening = false;
            this.isClosing = true;
            this.itemFocused(-1);
            this.setMenuVisible(false);
            this.dimParentElements(1.0f, true);
            this.animate();
            if (this.comboBoxBackground != null && this.comboBoxBackground.getRenderer() != null) {
                ((ComboBoxBackgroundRenderer)this.comboBoxBackground.getRenderer()).setOpenValue(0.0f);
            }
        }
    }

    public void open() {
        if (!this.isClosing && !this.open) {
            this.setMenuVisible(true);
            this.refreshAvailableHints();
            this.prepareForOpen();
            this.open = true;
            this.dimParentElements(63, false);
            this.isOpening = true;
            this.isClosing = false;
            if (this.type == 1) {
                this.comboBoxBackground.setVisible(true);
            }
            this.itemFocused(this.menu.getMenuItemID(this.menu.getFocusedIndex()));
            this.animate();
            this.label.setDepth(-1);
            this.label.setCompositesDirty(true);
        }
    }

    @Override
    protected void handleFocusChanged(int n, int n2, int n3) {
        super.handleFocusChanged(n, n2, n3);
        if (n != 1) {
            return;
        }
        if (this.open && this.type == 0) {
            this.reset();
            this.open = false;
            if (this.menu != null) {
                this.setMenuVisible(false);
            }
            if (this.renderer != null) {
                this.renderer.close();
            }
            this.setCompositesDirty(true);
        }
    }

    public void menuItemFocused(int n) {
        if (!this.isOpen()) {
            return;
        }
        if (this.model instanceof ChoiceModelGUI) {
            menuLogCh.log(-2137614336, "ComboBoxController#menuItemFocused: notify choiceModel, item: %1", (long)n);
            ((ChoiceModelGUI)this.model).itemFocused(n, this.terminal.getTerminalID());
        } else {
            logChannel.log(-1601830656, "ComboBoxController#menuItemFocused: Unknown model %2: %1", this.model, (long)this.modelID);
        }
    }

    public void menuItemFocusCleared() {
        if (!this.isOpen()) {
            return;
        }
        if (this.model instanceof ChoiceModelGUI) {
            menuLogCh.log(-2137614336, "ComboBoxController#menuItemFocusCleared: no focused item for choice model");
            ((ChoiceModelGUI)this.model).itemFocused(-1, this.terminal.getTerminalID());
        } else {
            logChannel.log(-1601830656, "ComboBoxController#menuItemFocused: Unknown model %2: %1", this.model, (long)this.modelID);
        }
    }

    public int getAdditionalSpace() {
        return this.additionalSpace;
    }

    public void setAdditionalSpace(int n) {
        this.additionalSpace = n;
    }

    @Override
    public boolean hasBaseline() {
        return true;
    }
}

