/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.model.update.ModelUpdateData$Key;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.ScrollSubticksFilter;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$2;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$AnimatedFloatProperty;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$BounceCursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Cursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderMultiItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderSubItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Slot;
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
    protected static final float VIEWPORT_SCROLL_ANIMATION_TARGET;
    protected PlaceholderMenuRenderer renderer;
    protected ScrollSubticksFilter subticksFilter;
    private final List allSlots;
    private final LinkedList slotPool = new LinkedList();
    private final LinkedList usedSlots = new LinkedList();
    protected final List itemEntries = new ArrayList();
    private final List allItems = new ArrayList();
    private final Map itemEntryMap = new HashMap();
    private final AbstractPlaceholderMenuController$AnimatedFloatProperty viewportPosition = new AbstractPlaceholderMenuController$AnimatedFloatProperty(0.0f);
    protected final AbstractPlaceholderMenuController$Cursor selectionCursor = new AbstractPlaceholderMenuController$Cursor(this, -1, false, false);
    protected final AbstractPlaceholderMenuController$Cursor focusCursor;
    protected final AbstractPlaceholderMenuController$AnimatedFloatProperty inOutPosition = new AbstractPlaceholderMenuController$AnimatedFloatProperty(0.0f);
    private float scrollbarPosition;
    private float scrollbarLength;
    private float totalHeight;
    private AbstractAnimation viewportScrollAnimation;
    private final LogChannel lc;
    private static final int MAX_ICONS;
    boolean menuEnterWasPressed;
    protected int rightTurn = 0;
    protected int leftTurn = 1;
    public AbstractPlaceholderMenuController$BounceCursor bounceCursor;
    protected int bounceDirection = this.rightTurn;
    protected float bounceCursorMaxDeflection = -1701209794;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$widgets$MainWizardController;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController;

    public AbstractPlaceholderMenuController(int n, LogChannel logChannel) {
        this.lc = logChannel;
        this.subticksFilter = new ScrollSubticksFilter(logChannel);
        this.allSlots = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = new AbstractPlaceholderMenuController$Slot(this);
            this.allSlots.add(abstractPlaceholderMenuController$Slot);
            this.slotPool.add(abstractPlaceholderMenuController$Slot);
        }
        this.viewportPosition.setUnanimatedValue(0.0f);
        this.inOutPosition.setUnanimatedValue(0.0f);
        this.focusCursor = new AbstractPlaceholderMenuController$Cursor(this, this.getFocusCursorAnimationType(), true, false);
        this.bounceCursor = new AbstractPlaceholderMenuController$BounceCursor(this, 106);
    }

    protected abstract int getViewportAnimationType() {
    }

    protected abstract int getFocusCursorAnimationType() {
    }

    protected void addItem(PlaceholderMenuItem placeholderMenuItem) {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry;
        this.allItems.add(placeholderMenuItem);
        int n = this.itemEntries.size();
        if (placeholderMenuItem.isMultiItem()) {
            PlaceholderMenuMultiItem placeholderMenuMultiItem = (PlaceholderMenuMultiItem)placeholderMenuItem;
            AbstractPlaceholderMenuController$PlaceholderMultiItemEntry abstractPlaceholderMenuController$PlaceholderMultiItemEntry = new AbstractPlaceholderMenuController$PlaceholderMultiItemEntry(this, placeholderMenuMultiItem, n);
            AbstractPlaceholderMenuController$PlaceholderMultiItemEntry.access$000(abstractPlaceholderMenuController$PlaceholderMultiItemEntry).setListManager(this);
            abstractPlaceholderMenuController$PlaceholderItemEntry = abstractPlaceholderMenuController$PlaceholderMultiItemEntry;
        } else {
            abstractPlaceholderMenuController$PlaceholderItemEntry = new AbstractPlaceholderMenuController$PlaceholderItemEntry(this, placeholderMenuItem, n);
        }
        this.itemEntries.add(abstractPlaceholderMenuController$PlaceholderItemEntry);
        this.itemEntryMap.put(placeholderMenuItem, abstractPlaceholderMenuController$PlaceholderItemEntry);
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry getItemEntry(PlaceholderMenuItem placeholderMenuItem) {
        return (AbstractPlaceholderMenuController$PlaceholderItemEntry)this.itemEntryMap.get(placeholderMenuItem);
    }

    public void setRenderer(PlaceholderMenuRenderer placeholderMenuRenderer) {
        this.renderer = placeholderMenuRenderer;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    @Override
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

    @Override
    protected void handleFocusChanged(int n, int n2, int n3) {
        if (n == 2) {
            this.subticksFilter.reset();
        }
        super.handleFocusChanged(n, n2, n3);
    }

    @Override
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
            AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = (AbstractPlaceholderMenuController$Slot)this.usedSlots.removeFirst();
            this.slotPool.addFirst(abstractPlaceholderMenuController$Slot);
            abstractPlaceholderMenuController$Slot.enabled = false;
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

    @Override
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof PlaceholderMenuItem) {
            this.addItem((PlaceholderMenuItem)((Object)abstractWidget));
            return;
        }
        if (!(abstractWidget instanceof MenuItemController)) {
            return;
        }
        MenuItemController menuItemController = (MenuItemController)abstractWidget;
        AbstractPlaceholderMenuController$1 abstractPlaceholderMenuController$1 = new AbstractPlaceholderMenuController$1(this, menuItemController, abstractWidget);
        this.addItem(abstractPlaceholderMenuController$1);
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findFirstVisibleItemEntry() {
        return this.findVisibleItemEntry(true);
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findLastVisibleItemEntry() {
        return this.findVisibleItemEntry(false);
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findVisibleItemEntry(boolean bl) {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = bl ? this.getFirstItemEntry() : this.getLastItemEntry();
        Iterator iterator = this.getItemEntryIterator(abstractPlaceholderMenuController$PlaceholderItemEntry, bl);
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            if (!abstractPlaceholderMenuController$PlaceholderItemEntry2.isVisible()) continue;
            return abstractPlaceholderMenuController$PlaceholderItemEntry2;
        }
        return null;
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry getFirstItemEntry() {
        for (int i2 = 0; i2 < this.itemEntries.size(); ++i2) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = (AbstractPlaceholderMenuController$PlaceholderItemEntry)this.itemEntries.get(i2);
            if (abstractPlaceholderMenuController$PlaceholderItemEntry.isMultiItem()) {
                AbstractPlaceholderMenuController$PlaceholderMultiItemEntry abstractPlaceholderMenuController$PlaceholderMultiItemEntry = (AbstractPlaceholderMenuController$PlaceholderMultiItemEntry)abstractPlaceholderMenuController$PlaceholderItemEntry;
                AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry = abstractPlaceholderMenuController$PlaceholderMultiItemEntry.getFirstPart();
                if (placeholderMultiPartItemEntry == null) continue;
                return placeholderMultiPartItemEntry;
            }
            return abstractPlaceholderMenuController$PlaceholderItemEntry;
        }
        return null;
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry getLastItemEntry() {
        for (int i2 = this.itemEntries.size() - 1; i2 >= 0; ++i2) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = (AbstractPlaceholderMenuController$PlaceholderItemEntry)this.itemEntries.get(i2);
            if (abstractPlaceholderMenuController$PlaceholderItemEntry.isMultiItem()) {
                AbstractPlaceholderMenuController$PlaceholderMultiItemEntry abstractPlaceholderMenuController$PlaceholderMultiItemEntry = (AbstractPlaceholderMenuController$PlaceholderMultiItemEntry)abstractPlaceholderMenuController$PlaceholderItemEntry;
                AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry placeholderMultiPartItemEntry = abstractPlaceholderMenuController$PlaceholderMultiItemEntry.getLastPart();
                if (placeholderMultiPartItemEntry == null) continue;
                return placeholderMultiPartItemEntry;
            }
            return abstractPlaceholderMenuController$PlaceholderItemEntry;
        }
        return null;
    }

    protected Iterator getItemEntryIterator(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry, boolean bl) {
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            this.lc.log(-1601830656, "AbstractPlaceholderMenuController#getItemEntryIterator Start of iteration should not be null");
        }
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = abstractPlaceholderMenuController$PlaceholderItemEntry;
        AbstractPlaceholderMenuController$2 abstractPlaceholderMenuController$2 = new AbstractPlaceholderMenuController$2(this, abstractPlaceholderMenuController$PlaceholderItemEntry2, bl);
        return abstractPlaceholderMenuController$2;
    }

    protected void updateEntries() {
        this.lc.log(1078071040, "AbstractPlaceholderMenuController#updateEntries");
        this.selectionCursor.setTargetItemEntry(null);
        for (int i2 = 0; i2 < this.itemEntries.size(); ++i2) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = (AbstractPlaceholderMenuController$PlaceholderItemEntry)this.itemEntries.get(i2);
            abstractPlaceholderMenuController$PlaceholderItemEntry.initialize();
        }
        this.updateSelection();
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor);
        if (super.getClass().equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$MainWizardController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$MainWizardController = AbstractPlaceholderMenuController.class$("de.esolutions.hmi.widgets.audi.evo.widgets.MainWizardController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$MainWizardController)) {
            this.focusCursor.setTargetItemEntry(AbstractPlaceholderMenuController$Cursor.access$200(this.selectionCursor));
            if (AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor) == null) {
                this.focusCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry);
            }
            if (AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor) == null || !AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor).isVisible() || !AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor).isConnected()) {
                this.focusCursor.setTargetItemEntry(null);
            }
            if (AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor) == null) {
                this.focusCursor.setTargetItemEntry(this.findFirstVisibleItemEntry());
            }
        }
        this.updatePositions();
        this.initializeViewportPosition();
        if (AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor) != null) {
            this.setFocus(AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor), 0.0f, false);
        }
        if (AbstractPlaceholderMenuController$Cursor.access$200(this.selectionCursor) != null) {
            this.setSelection(AbstractPlaceholderMenuController$Cursor.access$200(this.selectionCursor), false);
        }
        this.assignSlots();
        this.updateScrollbar();
        this.mainItemEntriesChanged();
        this.updateSubEntries(this.selectionCursor.getTargetItemEntry());
        this.setCompositesDirty(true);
    }

    protected void updateSubEntries(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
    }

    protected void mainItemEntriesChanged() {
    }

    private boolean hasSelectionModel() {
        if (this.model == null) {
            return false;
        }
        if (!(this.model instanceof ChoiceModel)) {
            this.lc.log(-1601830656, "AbstractPlaceholderMenuController#hasSelectionModel model should be a ChoiceModel, but is %1 ", this.model);
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
        this.lc.log(-1601830656, "AbstractPlaceholderMenuController#getSelectionItem could not find widget with id %1", (long)n);
        return null;
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry updateSelection() {
        this.lc.log(1078071040, "AbstractPlaceholderMenuController#updateSelection");
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = AbstractPlaceholderMenuController$Cursor.access$200(this.selectionCursor);
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = this.findSelectedEntry();
        if (!Util.equals(abstractPlaceholderMenuController$PlaceholderItemEntry, abstractPlaceholderMenuController$PlaceholderItemEntry2)) {
            this.selectionCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry2);
            this.mainItemEntriesChanged();
            this.setCompositesDirty(true);
        }
        return AbstractPlaceholderMenuController$Cursor.access$200(this.selectionCursor);
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#processModelUpdateEvent");
        if (modelUpdateEvent.getUpdateType() == 1) {
            this.lc.log(1078071040, "AbstractPlaceholderMenuController#processModelUpdateEvent value updated");
            this.updateSelection();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findCurrentFirstVisibleItemEntry() {
        return this.findFirstVisibleItemEntry();
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findCurrentLastVisibleItemEntry() {
        return this.findLastVisibleItemEntry();
    }

    @Override
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
        AbstractPlaceholderMenuController$Cursor abstractPlaceholderMenuController$Cursor = this.getCurrentFocusCursor();
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = AbstractPlaceholderMenuController$Cursor.access$200(abstractPlaceholderMenuController$Cursor);
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = abstractPlaceholderMenuController$PlaceholderItemEntry == null ? this.findCurrentFirstVisibleItemEntry() : abstractPlaceholderMenuController$PlaceholderItemEntry;
        this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyPressed Current focused item: %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry2);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry2 == null) {
            return;
        }
        ++n;
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry3 = abstractPlaceholderMenuController$PlaceholderItemEntry2;
        Iterator iterator = this.getItemEntryIterator(abstractPlaceholderMenuController$PlaceholderItemEntry2, bl2);
        while (n > 0) {
            if (!iterator.hasNext()) {
                this.subticksFilter.endOfListReached();
                f2 = 0.0f;
                break;
            }
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry4 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            if (abstractPlaceholderMenuController$PlaceholderItemEntry4 == null) {
                --n;
                continue;
            }
            if (!abstractPlaceholderMenuController$PlaceholderItemEntry4.isVisible()) continue;
            --n;
            abstractPlaceholderMenuController$PlaceholderItemEntry3 = abstractPlaceholderMenuController$PlaceholderItemEntry4;
        }
        if (!abstractPlaceholderMenuController$PlaceholderItemEntry2.equals(abstractPlaceholderMenuController$PlaceholderItemEntry3)) {
            this.setFocus(abstractPlaceholderMenuController$PlaceholderItemEntry3, f2, true);
            wheelButtonEvent.consume();
        } else {
            if (bl) {
                this.getCurrentFocusCursor().hddsSubticksChanged(f2);
            }
            wheelButtonEvent.consume(false);
        }
        if (this.findCurrentFirstVisibleItemEntry() == abstractPlaceholderMenuController$PlaceholderItemEntry2) {
            if (wheelButtonEvent.getDirection() == this.leftTurn) {
                this.bounceDirection = this.leftTurn;
                this.bounceCursor.restartAnimation();
            } else {
                this.bounceCursor.abortAnimation();
            }
        } else if (this.findCurrentLastVisibleItemEntry() == abstractPlaceholderMenuController$PlaceholderItemEntry2) {
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
        if (!AbstractPlaceholderMenuController$Cursor.access$300(this.focusCursor).isAnimating()) {
            this.setCompositesDirty(true);
        }
    }

    public int getBounceDirection() {
        return this.bounceDirection;
    }

    public boolean isBouncing() {
        return this.bounceCursor.getBounceMode() != 0;
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        if (!this.hasState(36)) {
            return;
        }
        if (this.isSublistOpened() && this.isSelectionDrawerDirection(joystickEvent.getDirection())) {
            this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyMoved joystick left");
            if (this.closeSubList(true)) {
                this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyMoved sublist was closed");
                joystickEvent.consume();
                return;
            }
            this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyMoved sublist was not closed, not consuming event");
            return;
        }
        if (!this.isSublistOpened() && this.isOptionDrawerDirection(joystickEvent.getDirection())) {
            this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyMoved joystick right");
            if (this.openSubList(true)) {
                this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyMoved sublist was opened");
                joystickEvent.consume();
                return;
            }
            this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyMoved sublist was not opened, not consuming event");
            return;
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!this.hasState(36)) {
            return;
        }
        this.subticksFilter.keyPressed(keyEvent);
        int n = keyEvent.getKeyCode();
        if (n == 15 && this.isSublistOpened()) {
            this.lc.log(1078071040, "AbstractPlaceholerMenuController#keyPressed back");
            if (this.closeSubList(true)) {
                this.lc.log(1078071040, "AbstractPlaceholerMenuController#keyPressed sublist was closed");
                keyEvent.consume();
                return;
            }
            this.lc.log(1078071040, "AbstractPlaceholerMenuController#keyPressed sublist was not closed, not consuming event");
            return;
        }
        if (n != 17) {
            return;
        }
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = AbstractPlaceholderMenuController$Cursor.access$200(this.getCurrentFocusCursor());
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyPressed no item focused");
            return;
        }
        this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyPressed on focused item %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
        if (sdsService != null && sdsService.isSDSActive()) {
            this.callSdsServiceOnKeyPress(keyEvent, abstractPlaceholderMenuController$PlaceholderItemEntry);
            if (keyEvent.isConsumed()) {
                return;
            }
        }
        if (super.getClass().equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController = AbstractPlaceholderMenuController.class$("de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController)) {
            if (abstractPlaceholderMenuController$PlaceholderItemEntry.isSubItem()) {
                AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = AbstractPlaceholderMenuController$Cursor.access$200(this.getCurrentSelectionCursor());
                this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyPressed closing drawer (selected sub item %1)", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry2);
                this.closeSelectionDrawer();
            } else if (abstractPlaceholderMenuController$PlaceholderItemEntry.isSelected()) {
                this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyPressed focused main item %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
                boolean bl = this.openSubList(true);
                this.lc.log(-2137614336, "AbstractPlaceholerMenuController#keyPressed was opened: %1", bl);
            }
        }
        if (n == 17) {
            this.menuEnterWasPressed = true;
        }
        abstractPlaceholderMenuController$PlaceholderItemEntry.keyPressed(keyEvent);
        keyEvent.consume();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keyEvent.setSdsAction(3);
        this.subticksFilter.keyReleased(keyEvent);
        super.keyReleased(keyEvent);
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        this.subticksFilter.touchPadPressed(touchEvent);
        super.touchPadPressed(touchEvent);
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        this.subticksFilter.touchPadReleased(touchEvent);
        super.touchPadReleased(touchEvent);
    }

    @Override
    public void touchPadApproached(TouchEvent touchEvent) {
        this.subticksFilter.touchPadApproached(touchEvent);
        super.touchPadApproached(touchEvent);
    }

    @Override
    public void touchPadAbandoned(TouchEvent touchEvent) {
        this.subticksFilter.touchPadAbandoned(touchEvent);
        if (this.subticksFilter.isHandsOnRingEvent(touchEvent)) {
            this.lc.log(-2137614336, "AbstractPlaceholderMenuController#touchPadAbandoned: Hands left ring, so reset hDDS offset");
            this.resetHddsOffset();
        }
        super.touchPadAbandoned(touchEvent);
    }

    protected void resetHddsOffset() {
        this.focusCursor.hddsSubticksChanged(0.0f);
    }

    private boolean isSublistOpened() {
        if (!super.getClass().equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController = AbstractPlaceholderMenuController.class$("de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController)) {
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

    protected AbstractPlaceholderMenuController$Cursor getCurrentFocusCursor() {
        return this.focusCursor;
    }

    protected AbstractPlaceholderMenuController$Cursor getCurrentSelectionCursor() {
        return this.selectionCursor;
    }

    private void callSdsServiceOnKeyPress(KeyEvent keyEvent, AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        int n = abstractPlaceholderMenuController$PlaceholderItemEntry.getSdsItemSelectedAction();
        if (n == 1) {
            keyEvent.setSdsAction(n);
        } else if (n == 2) {
            keyEvent.consume();
            keyEvent.setSdsAction(n);
            int n2 = abstractPlaceholderMenuController$PlaceholderItemEntry.getModelID();
            if (abstractPlaceholderMenuController$PlaceholderItemEntry.isMultiPart()) {
                AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry = (AbstractPlaceholderMenuController$PlaceholderMultiPartItemEntry)abstractPlaceholderMenuController$PlaceholderItemEntry;
                this.lc.log(-2137614336, "AbstractPlaceholderMenuController#callSdsServiceOnKeyPress: multipart item %1 was selected on listmodel %2.", (Object)abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry, (long)n2);
                AbstractWidget.sdsService.itemSelected(n2, abstractPlaceholderMenuController$PlaceholderMultiPartItemEntry.getListIndex());
            } else {
                int n3 = abstractPlaceholderMenuController$PlaceholderItemEntry.getSdsCommand();
                this.lc.log(-2137614336, "AbstractPlaceholderMenuController#callSdsServiceOnKeyPress: item %1 was selected with modelID: %2, sdsCommand: %3", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry, (long)n2, (long)n3);
                AbstractWidget.sdsService.keyTyped(n2, n3);
            }
        } else if (n == 3) {
            keyEvent.setSdsAction(n);
        }
    }

    protected void initializeViewportPosition() {
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#initializeViewportPosition");
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor);
        float f2 = this.getMinCursorPosition();
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            this.viewportPosition.setUnanimatedValue(-f2);
        } else if (this.totalHeight <= this.getMaxCursorPosition() - this.getMinCursorPosition()) {
            this.viewportPosition.setUnanimatedValue(-this.getMinCursorPosition());
        } else {
            float f3 = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition();
            float f4 = f3 - this.viewportPosition.getTarget();
            float f5 = this.getMaxCursorPosition();
            this.lc.log(-2137614336, "AbstractPlaceholderMenuController#initializeViewportPosition positionInList: %1, totalHeight: %2, viewportPosition.target %3", (double)f3, (double)this.totalHeight, (double)this.viewportPosition.getTarget());
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
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor);
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#adjustViewport Focusing %2, animate=%1", bl, (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
        AbstractAnimation abstractAnimation = this.getViewportScrollAnimation();
        if (!bl && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
            this.viewportPosition.setProgress(1.0f);
        }
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            return;
        }
        float f3 = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition() - this.viewportPosition.getTarget();
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "AbstractPlaceholderMenuController#adjustViewport current target viewportPosition=%1, targetPosition=%2", (Object)String.valueOf(this.viewportPosition.getTarget()), (Object)String.valueOf(f3));
        }
        float f4 = this.getMinCursorPosition();
        float f5 = this.getMaxCursorPosition();
        if (f3 < f4) {
            f2 = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition() - f4;
            if (this.lc.isDebug()) {
                this.lc.log(-2137614336, "AbstractPlaceholderMenuController#adjustViewport targetPosition too small, scrolledTargetPosition=%1", (Object)String.valueOf(f2));
            }
        } else {
            if (f3 <= f5) {
                this.lc.log(-2137614336, "AbstractPlaceholderMenuController#adjustViewport targetPosition ok viewport target needs no change");
                return;
            }
            f2 = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition() - f5;
            this.lc.log(-2137614336, "AbstractPlaceholderMenuController#adjustViewport targetPosition too big, scrolledTargetPosition=%1", (Object)String.valueOf(f2));
        }
        if (!bl) {
            this.viewportPosition.setUnanimatedValue(f2);
            this.assignSlots();
            return;
        }
        this.viewportPosition.updateTarget(f2);
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 31300);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 31300, this.getViewportAnimationType(), false, this);
        }
    }

    protected abstract float getMaxCursorPosition() {
    }

    protected abstract float getMinCursorPosition() {
    }

    protected abstract float getMinItemPosition() {
    }

    protected abstract float getMaxItemPosition() {
    }

    protected void setFocus(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry, float f2, boolean bl) {
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#setFocus Focusing %1, animate=%2", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry, (Object)String.valueOf(bl));
        AbstractAnimation abstractAnimation = this.getViewportScrollAnimation();
        if (!bl && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
        }
        float f3 = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition() - this.viewportPosition.getTarget();
        this.focusCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry, f2, bl);
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "AbstractPlaceholderMenuController#setFocus current target viewportPosition=%1, targetPosition=%2", (Object)String.valueOf(this.viewportPosition.getTarget()), (Object)String.valueOf(f3));
        }
        this.adjustViewport(bl);
    }

    private void updateScrollbar() {
        this.lc.log(14808325, "AbstractPlaceholderMenuController#updateScrollbar totalHeight=%1", (double)this.totalHeight);
        if (this.totalHeight <= 0.0f) {
            this.scrollbarPosition = 0.0f;
            this.scrollbarLength = 0.0f;
            return;
        }
        this.scrollbarPosition = (this.viewportPosition.getCurrent() + this.getMinItemPosition()) / this.totalHeight;
        this.scrollbarLength = (this.getMaxItemPosition() - this.getMinItemPosition() + 1.0f) / this.totalHeight;
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "AbstractPlaceholderMenuController#updateScrollbar viewportPosition=%1, scrollbarPosition=%2, scrollbarLength=%3", (Object)new Float(this.viewportPosition.getCurrent()), (Object)new Float(this.scrollbarPosition), (Object)new Float(this.scrollbarLength));
        }
    }

    protected void updatePositions() {
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#updatePositions");
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.getFirstItemEntry();
        Iterator iterator = this.getItemEntryIterator(abstractPlaceholderMenuController$PlaceholderItemEntry, true);
        float f2 = 0.0f;
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            if (abstractPlaceholderMenuController$PlaceholderItemEntry2.isVisible()) {
                abstractPlaceholderMenuController$PlaceholderItemEntry2.setPosition(f2);
                if (this.lc.isDebug()) {
                    this.lc.log(-2137614336, "AbstractPlaceholderMenuController#updatePositions Position %1: %2", (Object)String.valueOf(f2), (Object)abstractPlaceholderMenuController$PlaceholderItemEntry2);
                }
                f2 += abstractPlaceholderMenuController$PlaceholderItemEntry2.getAnimatedHeight().getCurrent();
                continue;
            }
            this.lc.log(-2137614336, "AbstractPlaceholderMenuController#updatePositions Not showing %1:", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry2);
        }
        this.totalHeight = f2;
    }

    protected void assignSlots() {
        this.lc.log(14808325, "AbstractPlaceholderMenuController#assignSlots");
        this.clearSlots();
        Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
        while (iterator.hasNext() && !this.slotPool.isEmpty()) {
            float f2;
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            float f3 = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition() - this.viewportPosition.getCurrent();
            if (!this.inViewport(f3, f2 = abstractPlaceholderMenuController$PlaceholderItemEntry.getAnimatedHeight().getCurrent()) || !abstractPlaceholderMenuController$PlaceholderItemEntry.isVisible()) continue;
            AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = abstractPlaceholderMenuController$PlaceholderItemEntry.getSlot();
            if (abstractPlaceholderMenuController$Slot == null || abstractPlaceholderMenuController$Slot.enabled || !abstractPlaceholderMenuController$PlaceholderItemEntry.equals(abstractPlaceholderMenuController$Slot.getItemEntry())) {
                AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot2 = this.getSlotFromPool();
                abstractPlaceholderMenuController$PlaceholderItemEntry.setSlot(abstractPlaceholderMenuController$Slot2);
                abstractPlaceholderMenuController$Slot2.setItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry);
                continue;
            }
            this.slotPool.remove(abstractPlaceholderMenuController$Slot);
            this.usedSlots.add(abstractPlaceholderMenuController$Slot);
            abstractPlaceholderMenuController$Slot.enabled = true;
        }
    }

    abstract boolean inViewport(float f2, float f3) {
    }

    protected boolean inSubViewport(float f2) {
        return false;
    }

    private AbstractPlaceholderMenuController$Slot getSlotFromPool() {
        if (this.slotPool.isEmpty()) {
            return null;
        }
        AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = (AbstractPlaceholderMenuController$Slot)this.slotPool.removeFirst();
        abstractPlaceholderMenuController$Slot.enabled = true;
        this.usedSlots.addLast(abstractPlaceholderMenuController$Slot);
        return abstractPlaceholderMenuController$Slot;
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

    @Override
    public void animate(int n, float f2, int n2) {
        AbstractAnimation abstractAnimation = this.getViewportScrollAnimation();
        float f3 = abstractAnimation.getProgress();
        this.viewportPosition.setProgress(f3);
        this.assignSlots();
        this.updateScrollbar();
        this.setCompositesDirty(true);
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
        this.viewportPosition.setProgress(1.0f);
        this.assignSlots();
        this.updateScrollbar();
        this.setCompositesDirty(true);
    }

    private AbstractPlaceholderMenuController$PlaceholderItemEntry findSelectedEntry() {
        PlaceholderMenuItem placeholderMenuItem;
        boolean bl = this.hasSelectionModel();
        if (bl) {
            placeholderMenuItem = this.getSelectionItem();
            this.lc.log(1078071040, "AbstractPlaceholderMenuController#updateSelection selected item by model: %1", (Object)placeholderMenuItem);
        } else {
            placeholderMenuItem = null;
        }
        if (!bl || placeholderMenuItem != null) {
            Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
            while (iterator.hasNext()) {
                AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
                if (!abstractPlaceholderMenuController$PlaceholderItemEntry.isSelected()) {
                    for (int i2 = 0; i2 < abstractPlaceholderMenuController$PlaceholderItemEntry.getSubItemCount(); ++i2) {
                        AbstractPlaceholderMenuController$PlaceholderSubItemEntry abstractPlaceholderMenuController$PlaceholderSubItemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry.getSubItemEntry(i2);
                        abstractPlaceholderMenuController$PlaceholderSubItemEntry.setConnected(false);
                    }
                }
                if (!abstractPlaceholderMenuController$PlaceholderItemEntry.isVisible()) continue;
                if (bl && placeholderMenuItem.equals(abstractPlaceholderMenuController$PlaceholderItemEntry.getItem())) {
                    if (placeholderMenuItem.isMultiItem()) {
                        if (!abstractPlaceholderMenuController$PlaceholderItemEntry.isSelected()) continue;
                        return abstractPlaceholderMenuController$PlaceholderItemEntry;
                    }
                    return abstractPlaceholderMenuController$PlaceholderItemEntry;
                }
                if (bl || !abstractPlaceholderMenuController$PlaceholderItemEntry.isSelected()) continue;
                return abstractPlaceholderMenuController$PlaceholderItemEntry;
            }
        }
        return null;
    }

    public AbstractPlaceholderMenuController$Cursor getSelectionCursor() {
        return this.selectionCursor;
    }

    public AbstractPlaceholderMenuController$Cursor getFocusCursor() {
        return this.focusCursor;
    }

    @Override
    public void selectionChanged(AbstractWidgetController abstractWidgetController) {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.findSelectedEntry();
        this.setSelection(abstractPlaceholderMenuController$PlaceholderItemEntry, true);
    }

    protected void setSelection(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry, boolean bl) {
    }

    @Override
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
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            return -1;
        }
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = this.getFirstItemEntry();
        int n = 0;
        Iterator iterator = this.getItemEntryIterator(abstractPlaceholderMenuController$PlaceholderItemEntry2, true);
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry3 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            if (abstractPlaceholderMenuController$PlaceholderItemEntry.equals(abstractPlaceholderMenuController$PlaceholderItemEntry3)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    @Override
    public void subListModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, PlaceholderMenuMultiItem placeholderMenuMultiItem2, ModelUpdateEvent modelUpdateEvent) {
    }

    private void updateFocusCursorIfRowRemoved(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getClientData3().getInt(ModelUpdateData$Key.INDEX);
        if (AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor) != null && AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor).getPosition() >= (float)n) {
            this.focusCursor.setTargetItemEntry(AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor).getPrevious());
        }
    }

    private void updateFocusCursorIfRowAdded(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getClientData3().getInt(ModelUpdateData$Key.INDEX);
        if (AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor) != null && AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor).getPosition() >= (float)n) {
            this.focusCursor.setTargetItemEntry(AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor).getNext());
        }
    }

    @Override
    public void listModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, ModelUpdateEvent modelUpdateEvent) {
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#listModelChanged item=%1, event=%2", (Object)placeholderMenuMultiItem, (Object)modelUpdateEvent);
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#listModelChanged type=%1, statusflags=%2", (long)modelUpdateEvent.getUpdateType(), (long)modelUpdateEvent.getClientData1());
        int n = modelUpdateEvent.getUpdateType();
        if (n == 16) {
            int n2 = modelUpdateEvent.getClientData1();
            this.lc.log(-2137614336, "AbstractPlaceholderMenuController#listModelChanged transaction finished, statusflags=%1", (long)n2);
            if ((n2 & 5) != 0) {
                this.lc.log(-2137614336, "AbstractPlaceholderMenuController#listModelChanged data changed");
                this.updateEntries();
            } else if ((n2 & 2) != 0) {
                this.lc.log(-2137614336, "AbstractPlaceholderMenuController#listModelChanged selection changed");
                this.updateSelection();
            }
        } else if (n == 7 || n == 8 || n == 9 || n == 5 || n == 6 || n == 20 || n == 21) {
            this.lc.log(-2137614336, "AbstractPlaceholderMenuController#listModelChanged data changed");
            if (super.getClass().equals(class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController = AbstractPlaceholderMenuController.class$("de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$SelectionMenuController) && modelUpdateEvent.getClientData3() != null) {
                if (n == 7) {
                    this.updateFocusCursorIfRowAdded(modelUpdateEvent);
                } else if (n == 9) {
                    this.updateFocusCursorIfRowRemoved(modelUpdateEvent);
                }
            }
            this.updateEntries();
            this.checkForValidFocusCursorPosition();
        } else if (n == 22) {
            this.lc.log(-2137614336, "AbstractPlaceholderMenuController#listModelChanged selection changed");
            this.updateSelection();
        } else if (n == 19) {
            ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
            if (ModelTrigger.CLOSE_SELECTION_DRAWER.equals(modelUpdateData)) {
                this.lc.log(-2137614336, "AbstractPlaceholderMenuController#listModelChanged trigger close selection drawer");
                this.closeSelectionDrawer();
            } else if (ModelTrigger.JOIN_CURSOR.equals(modelUpdateData)) {
                this.lc.log(-2137614336, "AbstractPlaceholderMenuController#listModelChanged trigger join cursor");
                this.joinCursor(false);
            } else {
                this.lc.log(-1601830656, "AbstractPlaceholderMenuController#listModelChanged unknown trigger %1", (Object)modelUpdateData);
            }
        } else {
            this.lc.log(-1601830656, "AbstractPlaceholderMenuController#listModelChanged unsupported update type %1", (long)n);
            this.updateEntries();
            return;
        }
    }

    protected void checkForValidFocusCursorPosition() {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.focusCursor.getTargetItemEntry();
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = this.getFirstItemEntry();
        Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry3 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            if (abstractPlaceholderMenuController$PlaceholderItemEntry3 != null && abstractPlaceholderMenuController$PlaceholderItemEntry3.equals(abstractPlaceholderMenuController$PlaceholderItemEntry)) {
                return;
            }
            if (abstractPlaceholderMenuController$PlaceholderItemEntry3 == null || !abstractPlaceholderMenuController$PlaceholderItemEntry3.isVisible()) continue;
            abstractPlaceholderMenuController$PlaceholderItemEntry2 = abstractPlaceholderMenuController$PlaceholderItemEntry3;
        }
        this.focusCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry2);
    }

    protected void joinCursor(boolean bl) {
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#joinCursor");
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = AbstractPlaceholderMenuController$Cursor.access$200(this.selectionCursor);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry != null) {
            this.focusCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry, 0.0f, bl);
            this.adjustViewport(true);
        }
    }

    @Override
    public void invalidateLayout(AbstractWidget abstractWidget) {
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#invalidateLayout");
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
        this.lc.log(-2137614336, "AbstractPlaceholderMenuController#closeSelectionDrawer");
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager();
        iDrawerFocusManagerEvo.requestDrawerClose(4);
    }

    @Override
    public List getDiagnosisChildren() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            if (abstractPlaceholderMenuController$PlaceholderItemEntry.isSubItem()) continue;
            arrayList.add(abstractPlaceholderMenuController$PlaceholderItemEntry);
        }
        return arrayList;
    }

    private int getFocusedInternalIDForDiag() {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = AbstractPlaceholderMenuController$Cursor.access$200(this.focusCursor);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            return -1;
        }
        return abstractPlaceholderMenuController$PlaceholderItemEntry.getInternalID();
    }

    public boolean hasEntries() {
        return this.totalHeight > 0.0f;
    }

    public AbstractPlaceholderMenuController$Cursor getSubSelectionCursor() {
        return null;
    }

    public AbstractPlaceholderMenuController$Cursor getSubFocusCursor() {
        return null;
    }

    protected AbstractPlaceholderMenuController$AnimatedFloatProperty getSubViewportPosition() {
        return null;
    }

    protected float getCurrentSubViewportPosition() {
        return 0.0f;
    }

    protected int getConnectedSubItems(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            return 0;
        }
        int n = abstractPlaceholderMenuController$PlaceholderItemEntry.getSubItemCount();
        int n2 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            AbstractPlaceholderMenuController$PlaceholderSubItemEntry abstractPlaceholderMenuController$PlaceholderSubItemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry.getSubItemEntry(i2);
            if (!abstractPlaceholderMenuController$PlaceholderSubItemEntry.isConnected()) {
                return n2;
            }
            ++n2;
        }
        return n;
    }

    protected void textUpdated(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        if (abstractPlaceholderMenuController$PlaceholderItemEntry.equals(this.selectionCursor.getTargetItemEntry())) {
            this.selectionCursor.invalidateTargetWidth();
        }
        if (abstractPlaceholderMenuController$PlaceholderItemEntry.equals(this.focusCursor.getTargetItemEntry())) {
            this.focusCursor.invalidateTargetWidth();
        }
    }

    protected void clearItemEntriesCache() {
        if (this.getFirstItemEntry() != null) {
            Iterator iterator = this.getItemEntryIterator(this.getFirstItemEntry(), true);
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (!(object instanceof AbstractPlaceholderMenuController$PlaceholderItemEntry)) continue;
                AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = (AbstractPlaceholderMenuController$PlaceholderItemEntry)object;
                abstractPlaceholderMenuController$PlaceholderItemEntry.clearCache();
                if (abstractPlaceholderMenuController$PlaceholderItemEntry.getSubItemCount() <= 0) continue;
                AbstractPlaceholderMenuController$PlaceholderSubItemEntry abstractPlaceholderMenuController$PlaceholderSubItemEntry = abstractPlaceholderMenuController$PlaceholderItemEntry.getFirstSubItem();
                abstractPlaceholderMenuController$PlaceholderSubItemEntry.clearCache();
            }
        }
    }

    static /* synthetic */ HMITerminalImpl access$100(AbstractPlaceholderMenuController abstractPlaceholderMenuController) {
        return abstractPlaceholderMenuController.terminal;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$400(AbstractPlaceholderMenuController abstractPlaceholderMenuController) {
        return abstractPlaceholderMenuController.lc;
    }

    static /* synthetic */ void access$500(AbstractPlaceholderMenuController abstractPlaceholderMenuController) {
        abstractPlaceholderMenuController.syncBounceDirty();
    }

    static /* synthetic */ float access$602(AbstractPlaceholderMenuController abstractPlaceholderMenuController, float f2) {
        abstractPlaceholderMenuController.opacity = f2;
        return abstractPlaceholderMenuController.opacity;
    }

    static /* synthetic */ AbstractPlaceholderMenuController$AnimatedFloatProperty access$900(AbstractPlaceholderMenuController abstractPlaceholderMenuController) {
        return abstractPlaceholderMenuController.viewportPosition;
    }

    static /* synthetic */ void access$1000(AbstractPlaceholderMenuController abstractPlaceholderMenuController) {
        abstractPlaceholderMenuController.updateScrollbar();
    }
}

