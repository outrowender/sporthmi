/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IWidgetDiagnosis;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.ScrollSubticksFilter;
import de.esolutions.hmi.widgets.audi.evo.widgets.MainWizardController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuListManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractPlaceholderMenuController
extends AbstractWidgetController
implements AnimationListener,
SelectionProvider,
PlaceholderMenuListManager,
LayoutContainer {
    protected static final float VIEWPORT_SCROLL_ANIMATION_TARGET = 1000.0f;
    protected PlaceholderMenuRenderer renderer;
    protected ScrollSubticksFilter subticksFilter;
    private final List allSlots;
    private final LinkedList slotPool = new LinkedList();
    private final LinkedList usedSlots = new LinkedList();
    protected final List itemEntries = new ArrayList();
    private final List allItems = new ArrayList();
    private final Map itemEntryMap = new HashMap();
    private final AnimatedFloatProperty viewportPosition = new AnimatedFloatProperty(0.0f);
    protected final Cursor selectionCursor = new Cursor(-1, false, false);
    protected final Cursor focusCursor;
    protected final AnimatedFloatProperty inOutPosition = new AnimatedFloatProperty(0.0f);
    private float scrollbarPosition;
    private float scrollbarLength;
    private float totalHeight;
    private AbstractAnimation viewportScrollAnimation;
    private final LogChannel lc;
    private static final int MAX_ICONS = 4;
    boolean menuEnterWasPressed;
    protected int rightTurn = 0;
    protected int leftTurn = 1;
    public BounceCursor bounceCursor;
    protected int bounceDirection = this.rightTurn;
    protected float bounceCursorMaxDeflection = 0.3f;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$widgets$MainWizardController;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController;

    public AbstractPlaceholderMenuController(int n, LogChannel logChannel) {
        this.lc = logChannel;
        this.subticksFilter = new ScrollSubticksFilter(logChannel);
        this.allSlots = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            Slot slot = new Slot();
            this.allSlots.add(slot);
            this.slotPool.add(slot);
        }
        this.viewportPosition.setUnanimatedValue(0.0f);
        this.inOutPosition.setUnanimatedValue(0.0f);
        this.focusCursor = new Cursor(this.getFocusCursorAnimationType(), true, false);
        this.bounceCursor = new BounceCursor(106);
    }

    protected abstract int getViewportAnimationType();

    protected abstract int getFocusCursorAnimationType();

    protected void addItem(PlaceholderMenuItem placeholderMenuItem) {
        PlaceholderItemEntry placeholderItemEntry;
        this.allItems.add(placeholderMenuItem);
        int n = this.itemEntries.size();
        if (placeholderMenuItem.isMultiItem()) {
            PlaceholderMenuMultiItem placeholderMenuMultiItem = (PlaceholderMenuMultiItem)placeholderMenuItem;
            PlaceholderMultiItemEntry placeholderMultiItemEntry = new PlaceholderMultiItemEntry(placeholderMenuMultiItem, n);
            placeholderMultiItemEntry.multiItem.setListManager(this);
            placeholderItemEntry = placeholderMultiItemEntry;
        } else {
            placeholderItemEntry = new PlaceholderItemEntry(placeholderMenuItem, n);
        }
        this.itemEntries.add(placeholderItemEntry);
        this.itemEntryMap.put(placeholderMenuItem, placeholderItemEntry);
    }

    protected PlaceholderItemEntry getItemEntry(PlaceholderMenuItem placeholderMenuItem) {
        return (PlaceholderItemEntry)this.itemEntryMap.get(placeholderMenuItem);
    }

    public void setRenderer(PlaceholderMenuRenderer placeholderMenuRenderer) {
        this.renderer = placeholderMenuRenderer;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.subticksFilter.reset();
        this.viewportPosition.setUnanimatedValue(-this.getMinCursorPosition());
        this.updateEntries();
        this.closeSubList(false);
        this.openSubList(false);
        if (!framework.getLanguageMgr().isLeftToRightOrientation()) {
            this.leftTurn = 0;
            this.rightTurn = 1;
        } else {
            this.leftTurn = 1;
            this.rightTurn = 0;
        }
    }

    protected void handleFocusChanged(int n, int n2, int n3) {
        if (n == 2) {
            this.subticksFilter.reset();
        }
        super.handleFocusChanged(n, n2, n3);
    }

    public void destroyWidget() {
        if (this.viewportScrollAnimation != null && this.viewportScrollAnimation.isAnimating()) {
            this.viewportScrollAnimation.stopAnimation();
        }
        this.viewportScrollAnimation = null;
        this.focusCursor.disconnect();
        this.selectionCursor.disconnect();
        this.bounceCursor.disconnect();
    }

    private void clearSlots() {
        while (!this.usedSlots.isEmpty()) {
            Slot slot = (Slot)this.usedSlots.removeFirst();
            this.slotPool.addFirst(slot);
            slot.enabled = false;
        }
    }

    protected AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    protected AbstractAnimation getViewportScrollAnimation() {
        if (this.viewportScrollAnimation != null) {
            return this.viewportScrollAnimation;
        }
        this.viewportScrollAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(this.getViewportAnimationType());
        this.viewportScrollAnimation.addListener(this);
        return this.viewportScrollAnimation;
    }

    public void add(final AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof PlaceholderMenuItem) {
            this.addItem((PlaceholderMenuItem)((Object)abstractWidget));
            return;
        }
        if (!(abstractWidget instanceof MenuItemController)) {
            return;
        }
        final MenuItemController menuItemController = (MenuItemController)abstractWidget;
        PlaceholderMenuItem placeholderMenuItem = new PlaceholderMenuItem(){

            public void keyTurned(WheelButtonEvent wheelButtonEvent) {
                menuItemController.keyTurned(wheelButtonEvent);
            }

            public void keyReleased(KeyEvent keyEvent) {
                menuItemController.keyReleased(keyEvent);
            }

            public void keyPressed(KeyEvent keyEvent) {
                menuItemController.keyPressed(keyEvent);
            }

            public void keyMoved(JoystickEvent joystickEvent) {
                menuItemController.keyMoved(joystickEvent);
            }

            public void itemFocused() {
            }

            public boolean isVisible() {
                return menuItemController.isVisible();
            }

            public boolean isSubSelection() {
                return false;
            }

            public boolean isSubItem() {
                return false;
            }

            public boolean isSelected() {
                return menuItemController.isSelected();
            }

            public boolean isMultiItem() {
                return false;
            }

            public int getSubItemCount() {
                return 0;
            }

            public String getLabelText() {
                InitializationContext initializationContext = AbstractPlaceholderMenuController.this.getInitContext();
                if (initializationContext == null) {
                    return null;
                }
                AbstractScreenFactory abstractScreenFactory = initializationContext.getScreenFactory();
                if (abstractScreenFactory == null) {
                    return null;
                }
                return abstractScreenFactory.getText(menuItemController.getLabelId(), AbstractPlaceholderMenuController.this.terminal.getViewSizeManager().getCurrentViewSize());
            }

            public Object getIconData(int n) {
                int n2;
                if (AbstractPlaceholderMenuController.this instanceof MainWizardController && (n2 = menuItemController.getWidgetID()) != -1) {
                    return Util.createInteger(n2);
                }
                int[] nArray = menuItemController.getBitmapIndices();
                if (nArray == null || nArray.length <= n) {
                    return null;
                }
                return Util.createInteger(nArray[n]);
            }

            public int[] getColorIndices() {
                return abstractWidget.getColorIndices();
            }

            public boolean isEnabled() {
                return abstractWidget.isEnabled();
            }

            public AbstractWidgetController getWidget() {
                return menuItemController;
            }

            public int getSdsItemSelectedAction() {
                return menuItemController.getSdsItemSelectedAction();
            }

            public int getSdsCommand() {
                return menuItemController.getSdsCommand();
            }

            public int getInternalID() {
                return menuItemController.getInternalID();
            }

            public int getWidgetID() {
                return menuItemController.getWidgetID();
            }

            public boolean isLockable() {
                return menuItemController.isLockable();
            }
        };
        this.addItem(placeholderMenuItem);
    }

    protected PlaceholderItemEntry findFirstVisibleItemEntry() {
        return this.findVisibleItemEntry(true);
    }

    protected PlaceholderItemEntry findLastVisibleItemEntry() {
        return this.findVisibleItemEntry(false);
    }

    protected PlaceholderItemEntry findVisibleItemEntry(boolean bl) {
        PlaceholderItemEntry placeholderItemEntry = bl ? this.getFirstItemEntry() : this.getLastItemEntry();
        Iterator iterator = this.getItemEntryIterator(placeholderItemEntry, bl);
        while (iterator.hasNext()) {
            PlaceholderItemEntry placeholderItemEntry2 = (PlaceholderItemEntry)iterator.next();
            if (!placeholderItemEntry2.isVisible()) continue;
            return placeholderItemEntry2;
        }
        return null;
    }

    protected PlaceholderItemEntry getFirstItemEntry() {
        for (int i2 = 0; i2 < this.itemEntries.size(); ++i2) {
            PlaceholderItemEntry placeholderItemEntry = (PlaceholderItemEntry)this.itemEntries.get(i2);
            if (placeholderItemEntry.isMultiItem()) {
                PlaceholderMultiItemEntry placeholderMultiItemEntry = (PlaceholderMultiItemEntry)placeholderItemEntry;
                PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry = placeholderMultiItemEntry.getFirstPart();
                if (placeholderMultiPartItemEntry == null) continue;
                return placeholderMultiPartItemEntry;
            }
            return placeholderItemEntry;
        }
        return null;
    }

    protected PlaceholderItemEntry getLastItemEntry() {
        for (int i2 = this.itemEntries.size() - 1; i2 >= 0; ++i2) {
            PlaceholderItemEntry placeholderItemEntry = (PlaceholderItemEntry)this.itemEntries.get(i2);
            if (placeholderItemEntry.isMultiItem()) {
                PlaceholderMultiItemEntry placeholderMultiItemEntry = (PlaceholderMultiItemEntry)placeholderItemEntry;
                PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry = placeholderMultiItemEntry.getLastPart();
                if (placeholderMultiPartItemEntry == null) continue;
                return placeholderMultiPartItemEntry;
            }
            return placeholderItemEntry;
        }
        return null;
    }

    protected Iterator getItemEntryIterator(PlaceholderItemEntry placeholderItemEntry, final boolean bl) {
        if (placeholderItemEntry == null) {
            this.lc.log(100000, "AbstractPlaceholderMenuController#getItemEntryIterator Start of iteration should not be null");
        }
        final PlaceholderItemEntry placeholderItemEntry2 = placeholderItemEntry;
        Iterator iterator = new Iterator(){
            private PlaceholderItemEntry nextItem;
            {
                this.nextItem = placeholderItemEntry2;
            }

            private PlaceholderItemEntry findNext() {
                if (this.nextItem == null) {
                    return null;
                }
                return this.nextItem.getNextIteratedEntry(bl);
            }

            public void remove() {
                throw new UnsupportedOperationException("Remove not supported");
            }

            public Object next() {
                PlaceholderItemEntry placeholderItemEntry = this.nextItem;
                this.nextItem = this.findNext();
                return placeholderItemEntry;
            }

            public boolean hasNext() {
                return this.nextItem != null;
            }
        };
        return iterator;
    }

    protected void updateEntries() {
        this.lc.log(1000000, "AbstractPlaceholderMenuController#updateEntries");
        this.selectionCursor.setTargetItemEntry(null);
        for (int i2 = 0; i2 < this.itemEntries.size(); ++i2) {
            PlaceholderItemEntry placeholderItemEntry = (PlaceholderItemEntry)this.itemEntries.get(i2);
            placeholderItemEntry.initialize();
        }
        this.updateSelection();
        PlaceholderItemEntry placeholderItemEntry = this.focusCursor.targetItemEntry;
        if (this.getClass().equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$MainWizardController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$MainWizardController = AbstractPlaceholderMenuController.class$("de.esolutions.hmi.widgets.audi.evo.widgets.MainWizardController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$MainWizardController)) {
            this.focusCursor.setTargetItemEntry(this.selectionCursor.targetItemEntry);
            if (this.focusCursor.targetItemEntry == null) {
                this.focusCursor.setTargetItemEntry(placeholderItemEntry);
            }
            if (this.focusCursor.targetItemEntry == null || !this.focusCursor.targetItemEntry.isVisible() || !this.focusCursor.targetItemEntry.isConnected()) {
                this.focusCursor.setTargetItemEntry(null);
            }
            if (this.focusCursor.targetItemEntry == null) {
                this.focusCursor.setTargetItemEntry(this.findFirstVisibleItemEntry());
            }
        }
        this.updatePositions();
        this.initializeViewportPosition();
        if (this.focusCursor.targetItemEntry != null) {
            this.setFocus(this.focusCursor.targetItemEntry, 0.0f, false);
        }
        if (this.selectionCursor.targetItemEntry != null) {
            this.setSelection(this.selectionCursor.targetItemEntry, false);
        }
        this.assignSlots();
        this.updateScrollbar();
        this.mainItemEntriesChanged();
        this.updateSubEntries(this.selectionCursor.getTargetItemEntry());
        this.setCompositesDirty(true);
    }

    protected void updateSubEntries(PlaceholderItemEntry placeholderItemEntry) {
    }

    protected void mainItemEntriesChanged() {
    }

    private boolean hasSelectionModel() {
        if (this.model == null) {
            return false;
        }
        if (!(this.model instanceof ChoiceModel)) {
            this.lc.log(100000, "AbstractPlaceholderMenuController#hasSelectionModel model should be a ChoiceModel, but is %1 ", this.model);
            return false;
        }
        return true;
    }

    private PlaceholderMenuItem getSelectionItem() {
        int n = ((ChoiceModel)this.model).getValue();
        if (n == -1) {
            return null;
        }
        for (int i2 = 0; i2 < this.allItems.size(); ++i2) {
            PlaceholderMenuItem placeholderMenuItem = (PlaceholderMenuItem)this.allItems.get(i2);
            int n2 = placeholderMenuItem.getWidgetID();
            if (n2 != n) continue;
            return placeholderMenuItem;
        }
        this.lc.log(100000, "AbstractPlaceholderMenuController#getSelectionItem could not find widget with id %1", (long)n);
        return null;
    }

    protected PlaceholderItemEntry updateSelection() {
        this.lc.log(1000000, "AbstractPlaceholderMenuController#updateSelection");
        PlaceholderItemEntry placeholderItemEntry = this.selectionCursor.targetItemEntry;
        PlaceholderItemEntry placeholderItemEntry2 = this.findSelectedEntry();
        if (!Util.equals(placeholderItemEntry, placeholderItemEntry2)) {
            this.selectionCursor.setTargetItemEntry(placeholderItemEntry2);
            this.mainItemEntriesChanged();
            this.setCompositesDirty(true);
        }
        return this.selectionCursor.targetItemEntry;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.lc.log(10000000, "AbstractPlaceholderMenuController#processModelUpdateEvent");
        if (modelUpdateEvent.getUpdateType() == 1) {
            this.lc.log(1000000, "AbstractPlaceholderMenuController#processModelUpdateEvent value updated");
            this.updateSelection();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    protected PlaceholderItemEntry findCurrentFirstVisibleItemEntry() {
        return this.findFirstVisibleItemEntry();
    }

    protected PlaceholderItemEntry findCurrentLastVisibleItemEntry() {
        return this.findLastVisibleItemEntry();
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        boolean bl;
        int n;
        boolean bl2;
        if (!this.hasState(36)) {
            return;
        }
        if (wheelButtonEvent.isVerticalDirection() && this instanceof SelectionMenuController) {
            bl2 = wheelButtonEvent.getDirection() == 0;
        } else {
            n = wheelButtonEvent.getDirection();
            boolean bl3 = this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation();
            bl2 = this.terminal.getLayout().getRotationalDirection(n) == (bl3 ? 1 : 2);
        }
        n = wheelButtonEvent.getClickCount();
        float f2 = this.subticksFilter.calculateSubticksProgress(n, wheelButtonEvent.getSubClickCount(), bl2);
        boolean bl4 = bl = f2 != this.getCurrentFocusCursor().getHddsOffset();
        if (n == 0 && !bl) {
            wheelButtonEvent.consume(false);
            return;
        }
        Cursor cursor = this.getCurrentFocusCursor();
        PlaceholderItemEntry placeholderItemEntry = cursor.targetItemEntry;
        PlaceholderItemEntry placeholderItemEntry2 = placeholderItemEntry == null ? this.findCurrentFirstVisibleItemEntry() : placeholderItemEntry;
        this.lc.log(10000000, "AbstractPlaceholerMenuController#keyPressed Current focused item: %1", (Object)placeholderItemEntry2);
        if (placeholderItemEntry2 == null) {
            return;
        }
        ++n;
        PlaceholderItemEntry placeholderItemEntry3 = placeholderItemEntry2;
        Iterator iterator = this.getItemEntryIterator(placeholderItemEntry2, bl2);
        while (n > 0) {
            if (!iterator.hasNext()) {
                this.subticksFilter.endOfListReached();
                f2 = 0.0f;
                break;
            }
            PlaceholderItemEntry placeholderItemEntry4 = (PlaceholderItemEntry)iterator.next();
            if (placeholderItemEntry4 == null) {
                --n;
                continue;
            }
            if (!placeholderItemEntry4.isVisible()) continue;
            --n;
            placeholderItemEntry3 = placeholderItemEntry4;
        }
        if (!placeholderItemEntry2.equals(placeholderItemEntry3)) {
            this.setFocus(placeholderItemEntry3, f2, true);
            wheelButtonEvent.consume();
        } else {
            if (bl) {
                this.getCurrentFocusCursor().hddsSubticksChanged(f2);
            }
            wheelButtonEvent.consume(false);
        }
        if (this.findCurrentFirstVisibleItemEntry() == placeholderItemEntry2) {
            if (wheelButtonEvent.getDirection() == this.leftTurn) {
                this.bounceDirection = this.leftTurn;
                this.bounceCursor.restartAnimation();
            } else {
                this.bounceCursor.abortAnimation();
            }
        } else if (this.findCurrentLastVisibleItemEntry() == placeholderItemEntry2) {
            if (wheelButtonEvent.getDirection() == this.rightTurn) {
                this.bounceDirection = this.rightTurn;
                this.bounceCursor.restartAnimation();
            } else {
                this.bounceCursor.abortAnimation();
            }
        }
    }

    public float getBounceOffset() {
        float f2 = this.bounceDirection == this.leftTurn ? -this.bounceCursorMaxDeflection : this.bounceCursorMaxDeflection;
        int n = this.bounceCursor.getBounceMode();
        if (n == 1) {
            return f2 * this.bounceCursor.getProgress();
        }
        if (n == 3) {
            return f2 * (1.0f - this.bounceCursor.getProgress());
        }
        if (n == 2) {
            return f2;
        }
        return 0.0f;
    }

    private void syncBounceDirty() {
        if (!this.focusCursor.getCursorAnimation().isAnimating()) {
            this.setCompositesDirty(true);
        }
    }

    public int getBounceDirection() {
        return this.bounceDirection;
    }

    public boolean isBouncing() {
        return this.bounceCursor.getBounceMode() != 0;
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        if (!this.hasState(36)) {
            return;
        }
        if (this.isSublistOpened() && this.isSelectionDrawerDirection(joystickEvent.getDirection())) {
            this.lc.log(10000000, "AbstractPlaceholerMenuController#keyMoved joystick left");
            if (this.closeSubList(true)) {
                this.lc.log(10000000, "AbstractPlaceholerMenuController#keyMoved sublist was closed");
                joystickEvent.consume();
                return;
            }
            this.lc.log(10000000, "AbstractPlaceholerMenuController#keyMoved sublist was not closed, not consuming event");
            return;
        }
        if (!this.isSublistOpened() && this.isOptionDrawerDirection(joystickEvent.getDirection())) {
            this.lc.log(10000000, "AbstractPlaceholerMenuController#keyMoved joystick right");
            if (this.openSubList(true)) {
                this.lc.log(10000000, "AbstractPlaceholerMenuController#keyMoved sublist was opened");
                joystickEvent.consume();
                return;
            }
            this.lc.log(10000000, "AbstractPlaceholerMenuController#keyMoved sublist was not opened, not consuming event");
            return;
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (!this.hasState(36)) {
            return;
        }
        this.subticksFilter.keyPressed(keyEvent);
        int n = keyEvent.getKeyCode();
        if (n == 15 && this.isSublistOpened()) {
            this.lc.log(1000000, "AbstractPlaceholerMenuController#keyPressed back");
            if (this.closeSubList(true)) {
                this.lc.log(1000000, "AbstractPlaceholerMenuController#keyPressed sublist was closed");
                keyEvent.consume();
                return;
            }
            this.lc.log(1000000, "AbstractPlaceholerMenuController#keyPressed sublist was not closed, not consuming event");
            return;
        }
        if (n != 17) {
            return;
        }
        PlaceholderItemEntry placeholderItemEntry = this.getCurrentFocusCursor().targetItemEntry;
        if (placeholderItemEntry == null) {
            this.lc.log(10000000, "AbstractPlaceholerMenuController#keyPressed no item focused");
            return;
        }
        this.lc.log(10000000, "AbstractPlaceholerMenuController#keyPressed on focused item %1", (Object)placeholderItemEntry);
        if (sdsService != null && sdsService.isSDSActive()) {
            this.callSdsServiceOnKeyPress(keyEvent, placeholderItemEntry);
            if (keyEvent.isConsumed()) {
                return;
            }
        }
        if (this.getClass().equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController = AbstractPlaceholderMenuController.class$("de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController)) {
            if (placeholderItemEntry.isSubItem()) {
                PlaceholderItemEntry placeholderItemEntry2 = this.getCurrentSelectionCursor().targetItemEntry;
                this.lc.log(10000000, "AbstractPlaceholerMenuController#keyPressed closing drawer (selected sub item %1)", (Object)placeholderItemEntry2);
                this.closeSelectionDrawer();
            } else if (placeholderItemEntry.isSelected()) {
                this.lc.log(10000000, "AbstractPlaceholerMenuController#keyPressed focused main item %1", (Object)placeholderItemEntry);
                boolean bl = this.openSubList(true);
                this.lc.log(10000000, "AbstractPlaceholerMenuController#keyPressed was opened: %1", bl);
            }
        }
        if (n == 17) {
            this.menuEnterWasPressed = true;
        }
        placeholderItemEntry.keyPressed(keyEvent);
        keyEvent.consume();
    }

    public void keyReleased(KeyEvent keyEvent) {
        keyEvent.setSdsAction(3);
        this.subticksFilter.keyReleased(keyEvent);
        super.keyReleased(keyEvent);
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        this.subticksFilter.touchPadPressed(touchEvent);
        super.touchPadPressed(touchEvent);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        this.subticksFilter.touchPadReleased(touchEvent);
        super.touchPadReleased(touchEvent);
    }

    public void touchPadApproached(TouchEvent touchEvent) {
        this.subticksFilter.touchPadApproached(touchEvent);
        super.touchPadApproached(touchEvent);
    }

    public void touchPadAbandoned(TouchEvent touchEvent) {
        this.subticksFilter.touchPadAbandoned(touchEvent);
        if (this.subticksFilter.isHandsOnRingEvent(touchEvent)) {
            this.lc.log(10000000, "AbstractPlaceholderMenuController#touchPadAbandoned: Hands left ring, so reset hDDS offset");
            this.resetHddsOffset();
        }
        super.touchPadAbandoned(touchEvent);
    }

    protected void resetHddsOffset() {
        this.focusCursor.hddsSubticksChanged(0.0f);
    }

    private boolean isSublistOpened() {
        if (!this.getClass().equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController = AbstractPlaceholderMenuController.class$("de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController)) {
            return false;
        }
        SelectionMenuController selectionMenuController = (SelectionMenuController)this;
        return selectionMenuController.isSubListOpened();
    }

    protected boolean openSubList(boolean bl) {
        return false;
    }

    protected boolean closeSubList(boolean bl) {
        return false;
    }

    protected Cursor getCurrentFocusCursor() {
        return this.focusCursor;
    }

    protected Cursor getCurrentSelectionCursor() {
        return this.selectionCursor;
    }

    private void callSdsServiceOnKeyPress(KeyEvent keyEvent, PlaceholderItemEntry placeholderItemEntry) {
        int n = placeholderItemEntry.getSdsItemSelectedAction();
        if (n == 1) {
            keyEvent.setSdsAction(n);
        } else if (n == 2) {
            keyEvent.consume();
            keyEvent.setSdsAction(n);
            int n2 = placeholderItemEntry.getModelID();
            if (placeholderItemEntry.isMultiPart()) {
                PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry = (PlaceholderMultiPartItemEntry)placeholderItemEntry;
                this.lc.log(10000000, "AbstractPlaceholderMenuController#callSdsServiceOnKeyPress: multipart item %1 was selected on listmodel %2.", (Object)placeholderMultiPartItemEntry, (long)n2);
                AbstractWidget.sdsService.itemSelected(n2, placeholderMultiPartItemEntry.getListIndex());
            } else {
                int n3 = placeholderItemEntry.getSdsCommand();
                this.lc.log(10000000, "AbstractPlaceholderMenuController#callSdsServiceOnKeyPress: item %1 was selected with modelID: %2, sdsCommand: %3", (Object)placeholderItemEntry, (long)n2, (long)n3);
                AbstractWidget.sdsService.keyTyped(n2, n3);
            }
        } else if (n == 3) {
            keyEvent.setSdsAction(n);
        }
    }

    protected void initializeViewportPosition() {
        this.lc.log(10000000, "AbstractPlaceholderMenuController#initializeViewportPosition");
        PlaceholderItemEntry placeholderItemEntry = this.focusCursor.targetItemEntry;
        float f2 = this.getMinCursorPosition();
        if (placeholderItemEntry == null) {
            this.viewportPosition.setUnanimatedValue(-f2);
        } else if (this.totalHeight <= this.getMaxCursorPosition() - this.getMinCursorPosition()) {
            this.viewportPosition.setUnanimatedValue(-this.getMinCursorPosition());
        } else {
            float f3 = placeholderItemEntry.getPosition();
            float f4 = f3 - this.viewportPosition.getTarget();
            float f5 = this.getMaxCursorPosition();
            this.lc.log(10000000, "AbstractPlaceholderMenuController#initializeViewportPosition positionInList: %1, totalHeight: %2, viewportPosition.target %3", (double)f3, (double)this.totalHeight, (double)this.viewportPosition.getTarget());
            if (f3 == this.totalHeight - 1.0f) {
                f4 = f5 + 1.0f;
            }
            if (f4 > f5) {
                this.viewportPosition.setUnanimatedValue(f3 - f5);
            } else if (f4 < f2) {
                this.viewportPosition.setUnanimatedValue(f3 - f2);
            }
        }
    }

    protected void adjustViewport(boolean bl) {
        float f2;
        PlaceholderItemEntry placeholderItemEntry = this.focusCursor.targetItemEntry;
        this.lc.log(10000000, "AbstractPlaceholderMenuController#adjustViewport Focusing %2, animate=%1", bl, (Object)placeholderItemEntry);
        AbstractAnimation abstractAnimation = this.getViewportScrollAnimation();
        if (!bl && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
            this.viewportPosition.setProgress(1.0f);
        }
        if (placeholderItemEntry == null) {
            return;
        }
        float f3 = placeholderItemEntry.getPosition() - this.viewportPosition.getTarget();
        if (this.lc.isDebug()) {
            this.lc.log(10000000, "AbstractPlaceholderMenuController#adjustViewport current target viewportPosition=%1, targetPosition=%2", (Object)String.valueOf(this.viewportPosition.getTarget()), (Object)String.valueOf(f3));
        }
        float f4 = this.getMinCursorPosition();
        float f5 = this.getMaxCursorPosition();
        if (f3 < f4) {
            f2 = placeholderItemEntry.getPosition() - f4;
            if (this.lc.isDebug()) {
                this.lc.log(10000000, "AbstractPlaceholderMenuController#adjustViewport targetPosition too small, scrolledTargetPosition=%1", (Object)String.valueOf(f2));
            }
        } else {
            if (f3 <= f5) {
                this.lc.log(10000000, "AbstractPlaceholderMenuController#adjustViewport targetPosition ok viewport target needs no change");
                return;
            }
            f2 = placeholderItemEntry.getPosition() - f5;
            this.lc.log(10000000, "AbstractPlaceholderMenuController#adjustViewport targetPosition too big, scrolledTargetPosition=%1", (Object)String.valueOf(f2));
        }
        if (!bl) {
            this.viewportPosition.setUnanimatedValue(f2);
            this.assignSlots();
            return;
        }
        this.viewportPosition.updateTarget(f2);
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, this.getViewportAnimationType(), false, this);
        }
    }

    protected abstract float getMaxCursorPosition();

    protected abstract float getMinCursorPosition();

    protected abstract float getMinItemPosition();

    protected abstract float getMaxItemPosition();

    protected void setFocus(PlaceholderItemEntry placeholderItemEntry, float f2, boolean bl) {
        this.lc.log(10000000, "AbstractPlaceholderMenuController#setFocus Focusing %1, animate=%2", (Object)placeholderItemEntry, (Object)String.valueOf(bl));
        AbstractAnimation abstractAnimation = this.getViewportScrollAnimation();
        if (!bl && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
        }
        float f3 = placeholderItemEntry.getPosition() - this.viewportPosition.getTarget();
        this.focusCursor.setTargetItemEntry(placeholderItemEntry, f2, bl);
        if (this.lc.isDebug()) {
            this.lc.log(10000000, "AbstractPlaceholderMenuController#setFocus current target viewportPosition=%1, targetPosition=%2", (Object)String.valueOf(this.viewportPosition.getTarget()), (Object)String.valueOf(f3));
        }
        this.adjustViewport(bl);
    }

    private void updateScrollbar() {
        this.lc.log(100000000, "AbstractPlaceholderMenuController#updateScrollbar totalHeight=%1", (double)this.totalHeight);
        if (this.totalHeight <= 0.0f) {
            this.scrollbarPosition = 0.0f;
            this.scrollbarLength = 0.0f;
            return;
        }
        this.scrollbarPosition = (this.viewportPosition.getCurrent() + this.getMinItemPosition()) / this.totalHeight;
        this.scrollbarLength = (this.getMaxItemPosition() - this.getMinItemPosition() + 1.0f) / this.totalHeight;
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "AbstractPlaceholderMenuController#updateScrollbar viewportPosition=%1, scrollbarPosition=%2, scrollbarLength=%3", (Object)new Float(this.viewportPosition.getCurrent()), (Object)new Float(this.scrollbarPosition), (Object)new Float(this.scrollbarLength));
        }
    }

    protected void updatePositions() {
        this.lc.log(10000000, "AbstractPlaceholderMenuController#updatePositions");
        PlaceholderItemEntry placeholderItemEntry = this.getFirstItemEntry();
        Iterator iterator = this.getItemEntryIterator(placeholderItemEntry, true);
        float f2 = 0.0f;
        while (iterator.hasNext()) {
            PlaceholderItemEntry placeholderItemEntry2 = (PlaceholderItemEntry)iterator.next();
            if (placeholderItemEntry2.isVisible()) {
                placeholderItemEntry2.setPosition(f2);
                if (this.lc.isDebug()) {
                    this.lc.log(10000000, "AbstractPlaceholderMenuController#updatePositions Position %1: %2", (Object)String.valueOf(f2), (Object)placeholderItemEntry2);
                }
                f2 += placeholderItemEntry2.getAnimatedHeight().getCurrent();
                continue;
            }
            this.lc.log(10000000, "AbstractPlaceholderMenuController#updatePositions Not showing %1:", (Object)placeholderItemEntry2);
        }
        this.totalHeight = f2;
    }

    protected void assignSlots() {
        this.lc.log(100000000, "AbstractPlaceholderMenuController#assignSlots");
        this.clearSlots();
        Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
        while (iterator.hasNext() && !this.slotPool.isEmpty()) {
            float f2;
            PlaceholderItemEntry placeholderItemEntry = (PlaceholderItemEntry)iterator.next();
            float f3 = placeholderItemEntry.getPosition() - this.viewportPosition.getCurrent();
            if (!this.inViewport(f3, f2 = placeholderItemEntry.getAnimatedHeight().getCurrent()) || !placeholderItemEntry.isVisible()) continue;
            Slot slot = placeholderItemEntry.getSlot();
            if (slot == null || slot.enabled || !placeholderItemEntry.equals(slot.getItemEntry())) {
                Slot slot2 = this.getSlotFromPool();
                placeholderItemEntry.setSlot(slot2);
                slot2.setItemEntry(placeholderItemEntry);
                continue;
            }
            this.slotPool.remove(slot);
            this.usedSlots.add(slot);
            slot.enabled = true;
        }
    }

    abstract boolean inViewport(float var1, float var2);

    protected boolean inSubViewport(float f2) {
        return false;
    }

    private Slot getSlotFromPool() {
        if (this.slotPool.isEmpty()) {
            return null;
        }
        Slot slot = (Slot)this.slotPool.removeFirst();
        slot.enabled = true;
        this.usedSlots.addLast(slot);
        return slot;
    }

    public List getSlots() {
        return Collections.unmodifiableList(this.allSlots);
    }

    public float getInOutPosition() {
        return this.inOutPosition.getCurrent();
    }

    public float getScrollbarPosition() {
        return this.scrollbarPosition;
    }

    public float getScrollbarLength() {
        return this.scrollbarLength;
    }

    protected float getMinSubCursorPosition() {
        return 0.0f;
    }

    protected float getMaxSubCursorPosition() {
        return 0.0f;
    }

    public void animate(int n, float f2, int n2) {
        AbstractAnimation abstractAnimation = this.getViewportScrollAnimation();
        float f3 = abstractAnimation.getProgress();
        this.viewportPosition.setProgress(f3);
        this.assignSlots();
        this.updateScrollbar();
        this.setCompositesDirty(true);
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        this.viewportPosition.setProgress(1.0f);
        this.assignSlots();
        this.updateScrollbar();
        this.setCompositesDirty(true);
    }

    private PlaceholderItemEntry findSelectedEntry() {
        PlaceholderMenuItem placeholderMenuItem;
        boolean bl = this.hasSelectionModel();
        if (bl) {
            placeholderMenuItem = this.getSelectionItem();
            this.lc.log(1000000, "AbstractPlaceholderMenuController#updateSelection selected item by model: %1", (Object)placeholderMenuItem);
        } else {
            placeholderMenuItem = null;
        }
        if (!bl || placeholderMenuItem != null) {
            Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
            while (iterator.hasNext()) {
                PlaceholderItemEntry placeholderItemEntry = (PlaceholderItemEntry)iterator.next();
                if (!placeholderItemEntry.isSelected()) {
                    for (int i2 = 0; i2 < placeholderItemEntry.getSubItemCount(); ++i2) {
                        PlaceholderSubItemEntry placeholderSubItemEntry = placeholderItemEntry.getSubItemEntry(i2);
                        placeholderSubItemEntry.setConnected(false);
                    }
                }
                if (!placeholderItemEntry.isVisible()) continue;
                if (bl && placeholderMenuItem.equals(placeholderItemEntry.getItem())) {
                    if (placeholderMenuItem.isMultiItem()) {
                        if (!placeholderItemEntry.isSelected()) continue;
                        return placeholderItemEntry;
                    }
                    return placeholderItemEntry;
                }
                if (bl || !placeholderItemEntry.isSelected()) continue;
                return placeholderItemEntry;
            }
        }
        return null;
    }

    public Cursor getSelectionCursor() {
        return this.selectionCursor;
    }

    public Cursor getFocusCursor() {
        return this.focusCursor;
    }

    public void selectionChanged(AbstractWidgetController abstractWidgetController) {
        PlaceholderItemEntry placeholderItemEntry = this.findSelectedEntry();
        this.setSelection(placeholderItemEntry, true);
    }

    protected void setSelection(PlaceholderItemEntry placeholderItemEntry, boolean bl) {
    }

    public String getInternalInfo() {
        Buffer buffer = new Buffer();
        buffer.append(" focusedDisplayLine=\"");
        buffer.append(this.getFocusedDisplayLineForDiag());
        buffer.append("\"");
        buffer.append(" focusedInternalID=\"");
        buffer.append(this.getFocusedInternalIDForDiag());
        buffer.append("\"");
        return buffer.toString();
    }

    private int getFocusedDisplayLineForDiag() {
        PlaceholderItemEntry placeholderItemEntry = this.focusCursor.targetItemEntry;
        if (placeholderItemEntry == null) {
            return -1;
        }
        PlaceholderItemEntry placeholderItemEntry2 = this.getFirstItemEntry();
        int n = 0;
        Iterator iterator = this.getItemEntryIterator(placeholderItemEntry2, true);
        while (iterator.hasNext()) {
            PlaceholderItemEntry placeholderItemEntry3 = (PlaceholderItemEntry)iterator.next();
            if (placeholderItemEntry.equals(placeholderItemEntry3)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public void subListModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, PlaceholderMenuMultiItem placeholderMenuMultiItem2, ModelUpdateEvent modelUpdateEvent) {
    }

    private void updateFocusCursorIfRowRemoved(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getClientData3().getInt(ModelUpdateData.Key.INDEX);
        if (this.focusCursor.targetItemEntry != null && this.focusCursor.targetItemEntry.getPosition() >= (float)n) {
            this.focusCursor.setTargetItemEntry(this.focusCursor.targetItemEntry.getPrevious());
        }
    }

    private void updateFocusCursorIfRowAdded(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getClientData3().getInt(ModelUpdateData.Key.INDEX);
        if (this.focusCursor.targetItemEntry != null && this.focusCursor.targetItemEntry.getPosition() >= (float)n) {
            this.focusCursor.setTargetItemEntry(this.focusCursor.targetItemEntry.getNext());
        }
    }

    public void listModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, ModelUpdateEvent modelUpdateEvent) {
        this.lc.log(10000000, "AbstractPlaceholderMenuController#listModelChanged item=%1, event=%2", (Object)placeholderMenuMultiItem, (Object)modelUpdateEvent);
        this.lc.log(10000000, "AbstractPlaceholderMenuController#listModelChanged type=%1, statusflags=%2", (long)modelUpdateEvent.getUpdateType(), (long)modelUpdateEvent.getClientData1());
        int n = modelUpdateEvent.getUpdateType();
        if (n == 16) {
            int n2 = modelUpdateEvent.getClientData1();
            this.lc.log(10000000, "AbstractPlaceholderMenuController#listModelChanged transaction finished, statusflags=%1", (long)n2);
            if ((n2 & 5) != 0) {
                this.lc.log(10000000, "AbstractPlaceholderMenuController#listModelChanged data changed");
                this.updateEntries();
            } else if ((n2 & 2) != 0) {
                this.lc.log(10000000, "AbstractPlaceholderMenuController#listModelChanged selection changed");
                this.updateSelection();
            }
        } else if (n == 7 || n == 8 || n == 9 || n == 5 || n == 6 || n == 20 || n == 21) {
            this.lc.log(10000000, "AbstractPlaceholderMenuController#listModelChanged data changed");
            if (this.getClass().equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController = AbstractPlaceholderMenuController.class$("de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController) && modelUpdateEvent.getClientData3() != null) {
                if (n == 7) {
                    this.updateFocusCursorIfRowAdded(modelUpdateEvent);
                } else if (n == 9) {
                    this.updateFocusCursorIfRowRemoved(modelUpdateEvent);
                }
            }
            this.updateEntries();
            this.checkForValidFocusCursorPosition();
        } else if (n == 22) {
            this.lc.log(10000000, "AbstractPlaceholderMenuController#listModelChanged selection changed");
            this.updateSelection();
        } else if (n == 19) {
            ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
            if (ModelTrigger.CLOSE_SELECTION_DRAWER.equals(modelUpdateData)) {
                this.lc.log(10000000, "AbstractPlaceholderMenuController#listModelChanged trigger close selection drawer");
                this.closeSelectionDrawer();
            } else if (ModelTrigger.JOIN_CURSOR.equals(modelUpdateData)) {
                this.lc.log(10000000, "AbstractPlaceholderMenuController#listModelChanged trigger join cursor");
                this.joinCursor(false);
            } else {
                this.lc.log(100000, "AbstractPlaceholderMenuController#listModelChanged unknown trigger %1", (Object)modelUpdateData);
            }
        } else {
            this.lc.log(100000, "AbstractPlaceholderMenuController#listModelChanged unsupported update type %1", (long)n);
            this.updateEntries();
            return;
        }
    }

    protected void checkForValidFocusCursorPosition() {
        PlaceholderItemEntry placeholderItemEntry = this.focusCursor.getTargetItemEntry();
        PlaceholderItemEntry placeholderItemEntry2 = this.getFirstItemEntry();
        Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
        while (iterator.hasNext()) {
            PlaceholderItemEntry placeholderItemEntry3 = (PlaceholderItemEntry)iterator.next();
            if (placeholderItemEntry3 != null && placeholderItemEntry3.equals(placeholderItemEntry)) {
                return;
            }
            if (placeholderItemEntry3 == null || !placeholderItemEntry3.isVisible()) continue;
            placeholderItemEntry2 = placeholderItemEntry3;
        }
        this.focusCursor.setTargetItemEntry(placeholderItemEntry2);
    }

    protected void joinCursor(boolean bl) {
        this.lc.log(10000000, "AbstractPlaceholderMenuController#joinCursor");
        PlaceholderItemEntry placeholderItemEntry = this.selectionCursor.targetItemEntry;
        if (placeholderItemEntry != null) {
            this.focusCursor.setTargetItemEntry(placeholderItemEntry, 0.0f, bl);
            this.adjustViewport(true);
        }
    }

    public void invalidateLayout(AbstractWidget abstractWidget) {
        this.lc.log(10000000, "AbstractPlaceholderMenuController#invalidateLayout");
        if (this.isConnected()) {
            this.updateEntries();
        }
    }

    protected PlaceholderMenuItem findPlaceholderMenuItem(AbstractWidget abstractWidget) {
        if (this.allItems.contains(abstractWidget)) {
            return (PlaceholderMenuItem)((Object)abstractWidget);
        }
        for (int i2 = 0; i2 < this.allItems.size(); ++i2) {
            PlaceholderMenuItem placeholderMenuItem = (PlaceholderMenuItem)this.allItems.get(i2);
            AbstractWidgetController abstractWidgetController = placeholderMenuItem.getWidget();
            if (!abstractWidget.equals(abstractWidgetController)) continue;
            return placeholderMenuItem;
        }
        return null;
    }

    public void setEnabled(AbstractWidget abstractWidget, boolean bl) {
        if (this.isConnected()) {
            this.updateEntries();
        }
    }

    protected void closeSelectionDrawer() {
        this.lc.log(10000000, "AbstractPlaceholderMenuController#closeSelectionDrawer");
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager();
        iDrawerFocusManagerEvo.requestDrawerClose(4);
    }

    public List getDiagnosisChildren() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
        while (iterator.hasNext()) {
            PlaceholderItemEntry placeholderItemEntry = (PlaceholderItemEntry)iterator.next();
            if (placeholderItemEntry.isSubItem()) continue;
            arrayList.add(placeholderItemEntry);
        }
        return arrayList;
    }

    private int getFocusedInternalIDForDiag() {
        PlaceholderItemEntry placeholderItemEntry = this.focusCursor.targetItemEntry;
        if (placeholderItemEntry == null) {
            return -1;
        }
        return placeholderItemEntry.getInternalID();
    }

    public boolean hasEntries() {
        return this.totalHeight > 0.0f;
    }

    public Cursor getSubSelectionCursor() {
        return null;
    }

    public Cursor getSubFocusCursor() {
        return null;
    }

    protected AnimatedFloatProperty getSubViewportPosition() {
        return null;
    }

    protected float getCurrentSubViewportPosition() {
        return 0.0f;
    }

    protected int getConnectedSubItems(PlaceholderItemEntry placeholderItemEntry) {
        if (placeholderItemEntry == null) {
            return 0;
        }
        int n = placeholderItemEntry.getSubItemCount();
        int n2 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            PlaceholderSubItemEntry placeholderSubItemEntry = placeholderItemEntry.getSubItemEntry(i2);
            if (!placeholderSubItemEntry.isConnected()) {
                return n2;
            }
            ++n2;
        }
        return n;
    }

    protected void textUpdated(PlaceholderItemEntry placeholderItemEntry) {
        if (placeholderItemEntry.equals(this.selectionCursor.getTargetItemEntry())) {
            this.selectionCursor.invalidateTargetWidth();
        }
        if (placeholderItemEntry.equals(this.focusCursor.getTargetItemEntry())) {
            this.focusCursor.invalidateTargetWidth();
        }
    }

    protected void clearItemEntriesCache() {
        if (this.getFirstItemEntry() != null) {
            Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (!(object instanceof PlaceholderItemEntry)) continue;
                PlaceholderItemEntry placeholderItemEntry = (PlaceholderItemEntry)object;
                placeholderItemEntry.clearCache();
                if (placeholderItemEntry.getSubItemCount() <= 0) continue;
                PlaceholderSubItemEntry placeholderSubItemEntry = placeholderItemEntry.getFirstSubItem();
                placeholderSubItemEntry.clearCache();
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public class Slot {
        private PlaceholderItemEntry itemEntry;
        private float position;
        boolean enabled;

        void setItemEntry(PlaceholderItemEntry placeholderItemEntry) {
            this.itemEntry = placeholderItemEntry;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("Slot [enabled=");
            buffer.append(this.enabled);
            buffer.append(", position=");
            buffer.append(this.position);
            buffer.append(", itemEntry=");
            buffer.append(this.itemEntry);
            buffer.append("]");
            return buffer.toString();
        }

        public float getPosition() {
            if (this.itemEntry == null) {
                return -1.0f;
            }
            float f2 = this.itemEntry.isSubItem() ? AbstractPlaceholderMenuController.this.getCurrentSubViewportPosition() : AbstractPlaceholderMenuController.this.viewportPosition.getCurrent();
            return this.itemEntry.getPosition() - f2;
        }

        public PlaceholderMenuItem getItem() {
            if (this.itemEntry == null) {
                return null;
            }
            return this.itemEntry.getItem();
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isFocused() {
            if (this.itemEntry == null) {
                return false;
            }
            return this.itemEntry.isFocused();
        }

        public boolean isSelected() {
            if (this.itemEntry == null) {
                return false;
            }
            return this.itemEntry.isHighlighted();
        }

        public float getSubPosition() {
            if (this.itemEntry == null) {
                return 0.0f;
            }
            return this.itemEntry.getSubPosition();
        }

        public PlaceholderItemEntry getItemEntry() {
            return this.itemEntry;
        }
    }

    public class Cursor
    implements AnimationListener {
        private static final int CURSOR_ANIMATION_TARGET = 1000;
        private final int cursorAnimationType;
        private float relativePosition;
        private float startPosition;
        private float hddsOffset;
        private PlaceholderItemEntry targetItemEntry;
        private AbstractAnimation cursorAnimation;
        private final boolean crop;
        private final boolean isSubCursor;
        private final AnimatedFloatProperty cursorWidth = new AnimatedFloatProperty(0.0f);
        private boolean targetWidthInitialized;

        public Cursor(int n, boolean bl, boolean bl2) {
            this.isSubCursor = bl2;
            this.cursorAnimationType = n;
            this.crop = bl;
        }

        public PlaceholderItemEntry getTargetItemEntry() {
            return this.targetItemEntry;
        }

        public void setTargetItemEntry(PlaceholderItemEntry placeholderItemEntry) {
            if (!Util.equals(this.targetItemEntry, placeholderItemEntry)) {
                this.targetWidthInitialized = false;
            }
            this.targetItemEntry = placeholderItemEntry;
        }

        public void disconnect() {
            if (this.cursorAnimation != null && this.cursorAnimation.isAnimating()) {
                this.cursorAnimation.stopAnimation();
            }
            this.cursorAnimation = null;
            this.targetWidthInitialized = false;
            this.cursorWidth.setUnanimatedValue(0.0f);
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("Cursor [relativePosition=");
            buffer.append(this.relativePosition);
            buffer.append(", targetPosition=");
            buffer.append(this.targetItemEntry);
            buffer.append("]");
            return buffer.toString();
        }

        private AbstractAnimation getCursorAnimation() {
            if (this.cursorAnimation != null) {
                return this.cursorAnimation;
            }
            if (this.cursorAnimationType < 0) {
                AbstractPlaceholderMenuController.this.lc.log(10000, "AbstractPlaceholderMenuController#getCursorAnimation cursorAnimationType not set");
                return null;
            }
            this.cursorAnimation = (AbstractAnimation)AbstractPlaceholderMenuController.this.getAnimationController().getIAnimation(this.cursorAnimationType);
            this.cursorAnimation.addListener(this);
            return this.cursorAnimation;
        }

        protected void setTargetItemEntry(PlaceholderItemEntry placeholderItemEntry, float f2, boolean bl) {
            float f3 = this.getCurrentPosition();
            if (!Util.equals(this.targetItemEntry, placeholderItemEntry) || f2 != this.hddsOffset) {
                this.targetWidthInitialized = false;
            }
            this.targetItemEntry = placeholderItemEntry;
            this.hddsOffset = f2;
            if (!bl || placeholderItemEntry == null) {
                if (this.cursorAnimation != null && this.cursorAnimation.isAnimating()) {
                    this.cursorAnimation.stopAnimation();
                }
                if (placeholderItemEntry == null) {
                    AbstractPlaceholderMenuController.this.setCompositesDirty(true);
                    return;
                }
                this.startPosition = placeholderItemEntry.getPosition();
                this.relativePosition = 1.0f;
                AbstractPlaceholderMenuController.this.setCompositesDirty(true);
                return;
            }
            this.startPosition = f3;
            this.restartAnimation();
        }

        private void restartAnimation() {
            AbstractAnimation abstractAnimation = this.getCursorAnimation();
            if (null == abstractAnimation) {
                return;
            }
            if (abstractAnimation.isAnimating()) {
                abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
            } else {
                abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, this.cursorAnimationType, false, AbstractPlaceholderMenuController.this);
            }
            this.relativePosition = abstractAnimation.getProgress();
        }

        public void hddsSubticksChanged(float f2) {
            if (f2 == this.hddsOffset) {
                return;
            }
            this.startPosition = this.getCurrentPosition();
            this.hddsOffset = f2;
            this.targetWidthInitialized = false;
            this.restartAnimation();
        }

        public float getCurrentPosition() {
            AnimatedFloatProperty animatedFloatProperty = this.isSubCursor ? AbstractPlaceholderMenuController.this.getSubViewportPosition() : AbstractPlaceholderMenuController.this.viewportPosition;
            float f2 = animatedFloatProperty.getCurrent();
            if (this.targetItemEntry == null) {
                return this.getCroppedPosition(this.startPosition);
            }
            this.relativePosition = Math.max(0.0f, Math.min(1.0f, this.relativePosition));
            return this.getCroppedPosition(this.startPosition + (this.targetItemEntry.getPosition() - f2 + this.hddsOffset - this.startPosition) * this.relativePosition);
        }

        public float getCurrentWidth() {
            this.cursorWidth.setProgress(this.relativePosition);
            return this.cursorWidth.getCurrent();
        }

        public boolean isCursorWidthInitialized() {
            return this.targetWidthInitialized;
        }

        public void setCursorWidthInitialized(boolean bl) {
            this.targetWidthInitialized = bl;
        }

        public void setTargetWidth(float f2) {
            if (this.cursorWidth.updateTarget(f2)) {
                AbstractPlaceholderMenuController.this.setCompositesDirty(true);
            }
            this.targetWidthInitialized = true;
        }

        private float getCroppedPosition(float f2) {
            if (!this.crop) {
                return f2;
            }
            if (this.isSubCursor) {
                return Math.max(AbstractPlaceholderMenuController.this.getMinSubCursorPosition(), Math.min(AbstractPlaceholderMenuController.this.getMaxSubCursorPosition(), f2));
            }
            return Math.max(AbstractPlaceholderMenuController.this.getMinCursorPosition(), Math.min(AbstractPlaceholderMenuController.this.getMaxCursorPosition(), f2));
        }

        public void animate(int n, float f2, int n2) {
            this.animate(n, f2);
        }

        public void animate(int n, float f2) {
            float f3 = this.cursorAnimation == null ? 1.0f : this.cursorAnimation.getProgress();
            this.relativePosition = f3;
            AbstractPlaceholderMenuController.this.assignSlots();
            AbstractPlaceholderMenuController.this.updateScrollbar();
            AbstractPlaceholderMenuController.this.setCompositesDirty(true);
        }

        public void animationStarted(int n, int n2) {
        }

        public void animationFinished(int n, int n2) {
            this.relativePosition = 1.0f;
            AbstractPlaceholderMenuController.this.assignSlots();
            AbstractPlaceholderMenuController.this.updateScrollbar();
            AbstractPlaceholderMenuController.this.setCompositesDirty(true);
        }

        public boolean isVisible() {
            boolean bl;
            boolean bl2 = bl = this.targetItemEntry != null && this.targetItemEntry.isVisible();
            if (!bl) {
                return false;
            }
            float f2 = this.getCurrentPosition();
            if (this.isSubCursor) {
                return AbstractPlaceholderMenuController.this.inSubViewport(f2);
            }
            return AbstractPlaceholderMenuController.this.inViewport(f2, 1.0f);
        }

        public void invalidateTargetWidth() {
            this.targetWidthInitialized = false;
            AbstractPlaceholderMenuController.this.setCompositesDirty(true);
        }

        public float getHddsOffset() {
            return this.hddsOffset;
        }

        public void setHddsOffset(float f2) {
            this.hddsOffset = f2;
        }
    }

    public class BounceCursor
    implements AnimationListener,
    ATIPEventListener {
        public static final int NO_BOUNCE = 0;
        public static final int BOUNCE_TO_DEFLECTION = 1;
        public static final int BOUNCE_AT_MAX_DEFLECTION = 2;
        public static final int BOUNCE_TO_ORIGIN = 3;
        public static final float BOUNCE_DEFLECTION_TARGET = 1000.0f;
        public static final float BOUNCE_DEFLECTION_ORIGIN = 0.0f;
        protected int type;
        protected AbstractAnimation animation;
        protected float progress;
        protected int bounceMode = 0;
        protected TimerEvent maxDeflectionIdleTimer = new TimerEvent(this);
        protected Job maxDeflectionIdleJob;
        private static final int CURSOR_BOUNCE_NO_MOVE_DURATION = 150;

        public BounceCursor(int n) {
            this.type = n;
        }

        public void disconnect() {
            this.cancelAnimation();
            this.cancelIdleTimer();
            this.bounceMode = 0;
            this.animation = null;
        }

        public void abortAnimation() {
            if (this.bounceMode != 0) {
                AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#BounceCursor#abortAnimation aborting bounce animation with mode: %1", (long)this.bounceMode);
                if (this.bounceMode == 1) {
                    this.bounceMode = 3;
                    this.getCursorAnimation().rollBackAnimation(true);
                } else if (this.bounceMode == 2) {
                    this.cancelIdleTimer();
                    this.processEvent(null);
                }
            }
        }

        public void animate(int n, float f2) {
            this.progress = this.animation == null ? 1.0f : this.animation.getProgress();
            AbstractPlaceholderMenuController.this.syncBounceDirty();
        }

        public void animate(int n, float f2, int n2) {
            this.animate(n, n2);
        }

        public void animationStarted(int n, int n2) {
            this.progress = this.animation.getProgress();
        }

        public void animationFinished(int n, int n2) {
            if (this.bounceMode == 3) {
                AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#BounceCursor#animationFinished bouncing animation finished");
                this.bounceMode = 0;
            } else if (this.bounceMode == 1) {
                AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#BounceCursor#animationFinished bouncing reached max deflection");
                this.bounceMode = 2;
                this.restartIdleTimer();
            }
            AbstractPlaceholderMenuController.this.syncBounceDirty();
        }

        public void cancelAnimation() {
            AbstractAnimation abstractAnimation = this.getCursorAnimation();
            if (abstractAnimation == null) {
                return;
            }
            abstractAnimation.stopAnimation();
        }

        public int getBounceMode() {
            return this.bounceMode;
        }

        protected AbstractAnimation getCursorAnimation() {
            if (this.animation != null) {
                return this.animation;
            }
            if (this.type < 0) {
                AbstractPlaceholderMenuController.this.lc.log(10000, "AbstractPlaceholderMenuController#BounceCursor#getCursorAnimation cursorAnimationType not set");
                return null;
            }
            this.animation = (AbstractAnimation)AbstractPlaceholderMenuController.this.getAnimationController().getIAnimation(this.type);
            this.animation.addListener(this);
            return this.animation;
        }

        public float getProgress() {
            return this.progress;
        }

        protected float getAnimationStart() {
            return this.bounceMode == 1 ? 0.0f : 1000.0f;
        }

        protected float getAnimationTarget() {
            return this.bounceMode == 1 ? 1000.0f : 0.0f;
        }

        public void restartAnimation() {
            AbstractAnimation abstractAnimation = this.getCursorAnimation();
            if (null == abstractAnimation) {
                return;
            }
            if (this.bounceMode == 0) {
                AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#BounceCursor#restartAnimation bounce direction set to deflection point");
                this.bounceMode = 1;
            } else if (this.bounceMode == 2) {
                this.restartIdleTimer();
                return;
            }
            if (!this.animation.isAnimating()) {
                AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#BounceCursor#restartAnimation starting bounce animation");
                abstractAnimation.startDynamicAnimation(this.getAnimationStart(), this.getAnimationTarget(), this.type, false, AbstractPlaceholderMenuController.this);
            }
        }

        public void cancelIdleTimer() {
            if (this.maxDeflectionIdleJob != null && !this.maxDeflectionIdleJob.isCanceled()) {
                this.maxDeflectionIdleJob.cancel();
            }
        }

        public void restartIdleTimer() {
            this.cancelIdleTimer();
            this.maxDeflectionIdleJob = AbstractWidget.hmiService.getEventDispatcher().postEvent(this.maxDeflectionIdleTimer, 150L);
        }

        public void processEvent(ATIPEvent aTIPEvent) {
            this.bounceMode = 3;
            AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#BounceCursor#processEvent bounce direction set to origin point");
            this.restartAnimation();
        }
    }

    public class PlaceholderItemEntry
    implements IWidgetDiagnosis {
        protected final PlaceholderMenuItem item;
        private float position;
        private float subPosition;
        private final AnimatedFloatProperty height = new AnimatedFloatProperty(1.0f);
        private Slot slot;
        protected final int itemEntryIndex;
        protected final List subItemEntries = new ArrayList();
        private boolean disconnected;
        protected String cachedText;
        protected Object[] cachedIcons = new Object[4];
        protected int textWidth = 0;

        protected PlaceholderItemEntry(PlaceholderMenuItem placeholderMenuItem, int n) {
            this.item = placeholderMenuItem;
            this.itemEntryIndex = n;
        }

        public int getSdsCommand() {
            return this.item.getSdsCommand();
        }

        public int getSdsItemSelectedAction() {
            return this.item.getSdsItemSelectedAction();
        }

        public void setConnected(boolean bl) {
            boolean bl2 = this.disconnected = !bl;
            if (bl) {
                this.clearCache();
            }
        }

        public boolean isConnected() {
            return !this.disconnected;
        }

        public void clearCache() {
            this.cachedText = null;
            this.textWidth = 0;
            for (int i2 = 0; i2 < this.cachedIcons.length; ++i2) {
                this.cachedIcons[i2] = null;
            }
        }

        public PlaceholderSubItemEntry getLastSubItem() {
            int n = this.subItemEntries.size();
            if (n > 0) {
                return (PlaceholderSubItemEntry)this.subItemEntries.get(n - 1);
            }
            return null;
        }

        public PlaceholderSubItemEntry getFirstSubItem() {
            int n = this.subItemEntries.size();
            if (n > 0) {
                return (PlaceholderSubItemEntry)this.subItemEntries.get(0);
            }
            return null;
        }

        public PlaceholderSubItemEntry getSubItemEntry(int n) {
            if (n < 0 || n >= this.subItemEntries.size()) {
                return null;
            }
            return (PlaceholderSubItemEntry)this.subItemEntries.get(n);
        }

        public int getSubItemCount() {
            return this.subItemEntries.size();
        }

        public boolean isMultiItem() {
            return false;
        }

        public boolean isMultiPart() {
            return false;
        }

        public void keyPressed(KeyEvent keyEvent) {
            this.item.keyPressed(keyEvent);
        }

        public void itemFocused() {
            this.item.itemFocused();
        }

        public boolean isVisible() {
            return this.item.isVisible();
        }

        public PlaceholderItemEntry getNext() {
            if (this.itemEntryIndex + 1 < AbstractPlaceholderMenuController.this.itemEntries.size()) {
                return (PlaceholderItemEntry)AbstractPlaceholderMenuController.this.itemEntries.get(this.itemEntryIndex + 1);
            }
            return null;
        }

        public PlaceholderItemEntry getPrevious() {
            if (this.itemEntryIndex > 0) {
                return (PlaceholderItemEntry)AbstractPlaceholderMenuController.this.itemEntries.get(this.itemEntryIndex - 1);
            }
            return null;
        }

        public String getLabelText() {
            if (this.cachedText != null) {
                return this.cachedText;
            }
            this.cachedText = this.loadLabelText();
            AbstractPlaceholderMenuController.this.textUpdated(this);
            this.textWidth = AbstractPlaceholderMenuController.this.renderer.getStringUtility().getStringWidth(this.cachedText);
            return this.cachedText;
        }

        public int getTextWidth() {
            return this.textWidth;
        }

        public boolean isEnabled() {
            return this.item.isEnabled();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(32);
            stringBuffer.append("ItemEntry [item=");
            stringBuffer.append(this.getItemInfo());
            stringBuffer.append(']');
            return stringBuffer.toString();
        }

        private String getItemInfo() {
            if (this.item == null) {
                return "<null>";
            }
            return this.item.getLabelText();
        }

        public PlaceholderMenuItem getItem() {
            return this.item;
        }

        public AnimatedFloatProperty getAnimatedHeight() {
            return this.height;
        }

        public float getPosition() {
            return this.position;
        }

        public void setPosition(float f2) {
            this.position = f2;
        }

        public void setSubPosition(float f2) {
            this.subPosition = f2;
        }

        public float getSubPosition() {
            return this.subPosition;
        }

        public Slot getSlot() {
            return this.slot;
        }

        public void setSlot(Slot slot) {
            this.slot = slot;
        }

        public boolean isSelected() {
            return this.item.isSelected();
        }

        public boolean isSubItem() {
            return this.item.isSubItem();
        }

        protected void initialize() {
            AbstractPlaceholderMenuController.this.opacity = 1.0f;
            this.clearCache();
        }

        public PlaceholderItemEntry getSelectedItemEntry() {
            return this;
        }

        public Object getIconData(int n) {
            Object object;
            Object object2 = this.cachedIcons[n];
            if (object2 != null) {
                return object2;
            }
            this.cachedIcons[n] = object = this.loadIconData(n);
            return object;
        }

        protected Object loadIconData(int n) {
            return this.item.getIconData(n);
        }

        protected String loadLabelText() {
            return this.item.getLabelText();
        }

        public PlaceholderItemEntry getNextIteratedEntry(boolean bl) {
            PlaceholderItemEntry placeholderItemEntry;
            PlaceholderItemEntry placeholderItemEntry2 = placeholderItemEntry = bl ? this.getNext() : this.getPrevious();
            while (placeholderItemEntry != null) {
                PlaceholderItemEntry placeholderItemEntry3 = placeholderItemEntry.getIterationStart(bl);
                if (placeholderItemEntry3 != null) {
                    return placeholderItemEntry3;
                }
                placeholderItemEntry = bl ? placeholderItemEntry.getNext() : placeholderItemEntry.getPrevious();
            }
            return null;
        }

        public PlaceholderItemEntry getIterationStart(boolean bl) {
            return this;
        }

        public void clearSubItems() {
            this.subItemEntries.clear();
        }

        public String getClassName() {
            String string = this.getClass().getName();
            int n = string.lastIndexOf(46);
            if (n != -1) {
                return string.substring(n + 1);
            }
            return string;
        }

        public int getX() {
            return 0;
        }

        public int getY() {
            return 0;
        }

        public int getWidth() {
            return 0;
        }

        public int getHeight() {
            return 0;
        }

        public int getDepth() {
            return 0;
        }

        public String getDiagnosisText() {
            return this.getLabelText();
        }

        public String getInternalInfo() {
            return null;
        }

        public int[] getBitmapIndices() {
            return new int[0];
        }

        public int[] getColorIndices() {
            return new int[0];
        }

        public List getDiagnosisChildren() {
            int n = this.getSubItemCount();
            if (n == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(n);
            for (int i2 = 0; i2 < n; ++i2) {
                arrayList.add(this.getSubItemEntry(i2));
            }
            return arrayList;
        }

        public boolean isActive() {
            return this.item.getWidget().isActive();
        }

        public boolean isHighlighted() {
            if (this.isSubItem()) {
                return this.equals(AbstractPlaceholderMenuController.this.getSubSelectionCursor().targetItemEntry);
            }
            return this.equals(AbstractPlaceholderMenuController.this.selectionCursor.targetItemEntry);
        }

        public boolean isFocused() {
            if (this.isSubItem()) {
                return this.equals(AbstractPlaceholderMenuController.this.getSubFocusCursor().targetItemEntry);
            }
            return this.equals(AbstractPlaceholderMenuController.this.focusCursor.targetItemEntry);
        }

        public boolean isFunctional() {
            return this.isConnected();
        }

        public int getModelID() {
            return this.item.getWidget().getModelID();
        }

        public void initializeSubItems() {
        }

        public int getInternalID() {
            return this.item.getInternalID();
        }
    }

    protected static class AnimatedFloatProperty {
        private float current;
        private float start;
        private float target;

        public AnimatedFloatProperty(float f2) {
            this.current = f2;
            this.start = f2;
            this.target = f2;
        }

        public float getCurrent() {
            return this.current;
        }

        public float getStart() {
            return this.start;
        }

        public float getTarget() {
            return this.target;
        }

        public float setProgress(float f2) {
            this.current = f2 >= 1.0f ? this.target : (f2 <= 0.0f ? this.start : this.start + (this.target - this.start) * f2);
            return this.current;
        }

        public void setUnanimatedValue(float f2) {
            this.current = f2;
            this.start = f2;
            this.target = f2;
        }

        public boolean updateTarget(float f2) {
            this.start = this.current;
            this.target = f2;
            return this.current != f2;
        }
    }

    public class PlaceholderSubItemEntry
    extends PlaceholderItemEntry {
        protected PlaceholderMultiPartItemEntry mainItemEntry;
        protected final int itemEntrySubIndex;

        protected PlaceholderSubItemEntry(PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry, int n) {
            super(placeholderMultiPartItemEntry.item, placeholderMultiPartItemEntry.itemEntryIndex);
            this.itemEntrySubIndex = n;
            this.mainItemEntry = placeholderMultiPartItemEntry;
        }

        public boolean isSubItem() {
            return true;
        }

        public PlaceholderItemEntry getNext() {
            int n = this.itemEntrySubIndex + 1;
            int n2 = this.mainItemEntry.getSubItemCount();
            if (n >= n2) {
                return null;
            }
            return this.mainItemEntry.getSubItemEntry(n);
        }

        public PlaceholderItemEntry getPrevious() {
            int n = this.itemEntrySubIndex - 1;
            if (n < 0) {
                return null;
            }
            return this.mainItemEntry.getSubItemEntry(n);
        }

        public float getSubPosition() {
            return 1.0f;
        }

        public boolean isSelected() {
            if (!this.isConnected()) {
                return false;
            }
            return this.mainItemEntry.multiItemEntry.multiItem.isSelected(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex);
        }

        public void keyPressed(KeyEvent keyEvent) {
            AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#keyPressed sublist item %1, index=%2, subindex=%3", (Object)this.mainItemEntry, (long)this.mainItemEntry.itemEntryIndex, (long)this.itemEntrySubIndex);
            this.mainItemEntry.multiItemEntry.multiItem.itemSelected(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex);
            AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#PlaceholderSubItemEntry#keyPressed closing drawer");
            AbstractPlaceholderMenuController.this.closeSelectionDrawer();
        }

        public boolean isVisible() {
            return this.mainItemEntry.multiItemEntry.multiItem.isVisible(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex);
        }

        public boolean isEnabled() {
            return this.mainItemEntry.multiItemEntry.multiItem.isEnabled(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex);
        }

        public Object loadIconData(int n) {
            return this.mainItemEntry.multiItemEntry.multiItem.getIconData(this.mainItemEntry.itemEntryIndex, this.itemEntrySubIndex, n);
        }

        public String loadLabelText() {
            return this.mainItemEntry.multiItemEntry.multiItem.getLabelText(this.mainItemEntry.multiPartIndex, this.itemEntrySubIndex);
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("SubItemEntry[main=");
            buffer.append(this.mainItemEntry);
            buffer.append(", itemEntrySubIndex=");
            buffer.append(this.itemEntrySubIndex);
            buffer.append(']');
            return buffer.toString();
        }

        public int getModelID() {
            return this.mainItemEntry.multiItemEntry.multiItem.getSubMenuMultiItem().getWidget().getModelID();
        }
    }

    protected class PlaceholderMultiItemEntry
    extends PlaceholderItemEntry {
        private final PlaceholderMenuMultiItem multiItem;
        private final List multiItemParts;

        protected PlaceholderMultiItemEntry(PlaceholderMenuMultiItem placeholderMenuMultiItem, int n) {
            super(placeholderMenuMultiItem, n);
            this.multiItemParts = new ArrayList();
            this.multiItem = placeholderMenuMultiItem;
        }

        public PlaceholderMultiPartItemEntry getFirstPart() {
            return (PlaceholderMultiPartItemEntry)(this.multiItemParts.isEmpty() ? null : this.multiItemParts.get(0));
        }

        public PlaceholderMultiPartItemEntry getLastPart() {
            return (PlaceholderMultiPartItemEntry)(this.multiItemParts.isEmpty() ? null : this.multiItemParts.get(this.getMultiPartCount() - 1));
        }

        public boolean isMultiItem() {
            return true;
        }

        public int getMultiPartCount() {
            return this.multiItemParts.size();
        }

        protected void initialize() {
            PlaceholderSubItemEntry placeholderSubItemEntry;
            int n;
            List list;
            PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry;
            int n2;
            AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize multiItem=%1", (Object)this.multiItem);
            int n3 = this.multiItem.getMultiItemCount();
            AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize multiItemCount=%1, multiItemPart count=%2", (long)n3, (long)this.multiItemParts.size());
            while (this.multiItemParts.size() > n3) {
                int n4 = this.multiItemParts.size() - 1;
                PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry2 = (PlaceholderMultiPartItemEntry)this.multiItemParts.get(n4);
                AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize disconnecting %1", (Object)placeholderMultiPartItemEntry2);
                placeholderMultiPartItemEntry2.setConnected(false);
                this.multiItemParts.remove(n4);
            }
            while (this.multiItemParts.size() < n3) {
                PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry3 = new PlaceholderMultiPartItemEntry(this, this.multiItemParts.size());
                AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize creating %1", (Object)placeholderMultiPartItemEntry3);
                this.multiItemParts.add(placeholderMultiPartItemEntry3);
            }
            int n5 = this.multiItem.getMainSelection();
            int n6 = this.multiItem.getSubItemCount();
            AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize main selection: %1, subItemCount=%2", (long)n5, (long)n6);
            for (n2 = 0; n2 < this.multiItemParts.size(); ++n2) {
                placeholderMultiPartItemEntry = (PlaceholderMultiPartItemEntry)this.multiItemParts.get(n2);
                list = placeholderMultiPartItemEntry.subItemEntries;
                if (n2 == n5) {
                    for (n = 0; n < n6 && n < list.size(); ++n) {
                        placeholderSubItemEntry = (PlaceholderSubItemEntry)list.get(n);
                        if (placeholderSubItemEntry.isConnected()) continue;
                        AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize reconnected subitem %1 to selected main item", (Object)placeholderSubItemEntry);
                        placeholderSubItemEntry.setConnected(true);
                    }
                    while (list.size() < n6) {
                        PlaceholderSubItemEntry placeholderSubItemEntry2 = new PlaceholderSubItemEntry(placeholderMultiPartItemEntry, list.size());
                        AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize added subitem %1 to selected main item", (Object)placeholderSubItemEntry2);
                        list.add(placeholderSubItemEntry2);
                    }
                    if (n6 > 0) {
                        while (list.size() > n6) {
                            PlaceholderSubItemEntry placeholderSubItemEntry3 = placeholderMultiPartItemEntry.removeSubItemEntry(list.size() - 1);
                            AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize Removing subitem %1 from selected main item", (Object)placeholderSubItemEntry3);
                        }
                        continue;
                    }
                    for (n = 0; n < list.size(); ++n) {
                        placeholderSubItemEntry = placeholderMultiPartItemEntry.getSubItemEntry(n);
                        AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize disconnecting subitem %1 from selected main item", (long)n);
                        placeholderSubItemEntry.setConnected(false);
                    }
                    continue;
                }
                for (n = 0; n < list.size(); ++n) {
                    placeholderSubItemEntry = (PlaceholderSubItemEntry)list.get(n);
                    AbstractPlaceholderMenuController.this.lc.log(10000000, "PlaceholderMultiItemEntry#initialize disconnecting subitem %1 from not selected main item", (Object)placeholderSubItemEntry);
                    placeholderSubItemEntry.setConnected(false);
                }
            }
            for (n2 = 0; n2 < n3; ++n2) {
                placeholderMultiPartItemEntry = (PlaceholderMultiPartItemEntry)this.multiItemParts.get(n2);
                if (placeholderMultiPartItemEntry.isConnected()) {
                    placeholderMultiPartItemEntry.clearCache();
                }
                list = placeholderMultiPartItemEntry.subItemEntries;
                for (n = 0; n < list.size(); ++n) {
                    placeholderSubItemEntry = (PlaceholderSubItemEntry)list.get(n);
                    if (!placeholderSubItemEntry.isConnected()) continue;
                    placeholderSubItemEntry.clearCache();
                }
            }
        }

        protected PlaceholderMultiPartItemEntry getPart(int n) {
            return (PlaceholderMultiPartItemEntry)this.multiItemParts.get(n);
        }

        public PlaceholderItemEntry getSelectedItemEntry() {
            int n = this.multiItem.getMainSelection();
            if (n < 0 || n >= this.multiItemParts.size()) {
                return null;
            }
            return (PlaceholderItemEntry)this.multiItemParts.get(n);
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("MultiItemEntry[item=");
            buffer.append(this.multiItem);
            buffer.append(']');
            return buffer.toString();
        }

        public void updateSelection() {
            PlaceholderSubItemEntry placeholderSubItemEntry;
            int n;
            PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry;
            int n2;
            for (n2 = 0; n2 < this.multiItemParts.size(); ++n2) {
                placeholderMultiPartItemEntry = (PlaceholderMultiPartItemEntry)this.multiItemParts.get(n2);
                List list = placeholderMultiPartItemEntry.subItemEntries;
                n = 0;
                while (n2 < list.size()) {
                    placeholderSubItemEntry = (PlaceholderSubItemEntry)list.get(n);
                    placeholderSubItemEntry.setConnected(false);
                    ++n;
                }
                list.clear();
            }
            n2 = this.multiItem.getMainSelection();
            if (n2 == -1) {
                return;
            }
            placeholderMultiPartItemEntry = (PlaceholderMultiPartItemEntry)this.multiItemParts.get(n2);
            int n3 = this.multiItem.getSubItemCount();
            AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#updateSelection multiItemPart=%1, count=%2", (long)n2, (long)n3);
            for (n = 0; n < n3; ++n) {
                placeholderSubItemEntry = new PlaceholderSubItemEntry(placeholderMultiPartItemEntry, n);
                placeholderMultiPartItemEntry.subItemEntries.add(placeholderSubItemEntry);
            }
        }

        public PlaceholderItemEntry getIterationStart(boolean bl) {
            PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry;
            PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry2 = placeholderMultiPartItemEntry = bl ? this.getFirstPart() : this.getLastPart();
            if (placeholderMultiPartItemEntry == null) {
                return null;
            }
            return placeholderMultiPartItemEntry.getIterationStart(bl);
        }
    }

    protected class PlaceholderMultiPartItemEntry
    extends PlaceholderItemEntry {
        protected final PlaceholderMultiItemEntry multiItemEntry;
        private int multiPartIndex;

        protected PlaceholderMultiPartItemEntry(PlaceholderMultiItemEntry placeholderMultiItemEntry, int n) {
            super(placeholderMultiItemEntry.multiItem, placeholderMultiItemEntry.itemEntryIndex);
            this.multiItemEntry = placeholderMultiItemEntry;
            this.multiPartIndex = n;
        }

        public void initializeSubItems() {
        }

        public PlaceholderItemEntry getNext() {
            if (this.multiPartIndex + 1 < this.multiItemEntry.multiItemParts.size()) {
                return (PlaceholderMultiPartItemEntry)this.multiItemEntry.multiItemParts.get(this.multiPartIndex + 1);
            }
            return null;
        }

        public PlaceholderItemEntry getPrevious() {
            if (this.multiPartIndex > 0) {
                return (PlaceholderMultiPartItemEntry)this.multiItemEntry.multiItemParts.get(this.multiPartIndex - 1);
            }
            return null;
        }

        public boolean isMultiPart() {
            return true;
        }

        public boolean isVisible() {
            return this.multiItemEntry.multiItem.isVisible(this.multiPartIndex, -1);
        }

        public boolean isSubItem() {
            return false;
        }

        public boolean isSelected() {
            if (!this.isConnected()) {
                return false;
            }
            return this.multiItemEntry.multiItem.isSelected(this.multiPartIndex, -1);
        }

        public boolean isEnabled() {
            return this.multiItemEntry.multiItem.isEnabled(this.multiPartIndex, -1);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(33);
            stringBuffer.append("MultiPartItemEntry[listIndex=");
            stringBuffer.append(this.multiPartIndex);
            stringBuffer.append(']');
            return stringBuffer.toString();
        }

        public int getListIndex() {
            return this.multiPartIndex;
        }

        public void setListIndex(int n) {
            this.multiPartIndex = n;
        }

        public void keyPressed(KeyEvent keyEvent) {
            this.multiItemEntry.multiItem.itemSelected(this.multiPartIndex, -1);
            if (!this.multiItemEntry.multiItem.hasSubList()) {
                AbstractPlaceholderMenuController.this.lc.log(10000000, "AbstractPlaceholderMenuController#PlaceholderMultiPartItemEntrykeyPressed closing drawer");
                AbstractPlaceholderMenuController.this.closeSelectionDrawer();
            }
        }

        protected String loadLabelText() {
            return this.multiItemEntry.multiItem.getLabelText(this.multiPartIndex, -1);
        }

        public Object loadIconData(int n) {
            return this.multiItemEntry.multiItem.getIconData(this.multiPartIndex, -1, n);
        }

        public PlaceholderItemEntry getNextIteratedEntry(boolean bl) {
            PlaceholderItemEntry placeholderItemEntry = super.getNextIteratedEntry(bl);
            if (placeholderItemEntry != null) {
                return placeholderItemEntry;
            }
            PlaceholderItemEntry placeholderItemEntry2 = this.multiItemEntry.getNextIteratedEntry(bl);
            if (placeholderItemEntry2 != null) {
                return placeholderItemEntry2.getIterationStart(bl);
            }
            return null;
        }

        public int getModelID() {
            return this.multiItemEntry.multiItem.getWidget().getModelID();
        }

        public PlaceholderSubItemEntry removeSubItemEntry(int n) {
            return (PlaceholderSubItemEntry)this.subItemEntries.remove(n);
        }
    }
}

