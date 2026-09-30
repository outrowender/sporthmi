/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.hmi.view.IKzbMergeListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RectangleParameters;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerMain;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionDrawerPreviewIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SelectionMenuIdleTimerController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectionMenuController
extends AbstractPlaceholderMenuController
implements DrawerMain,
ScreenChangeAnimationItem,
DrawerAnimationListener,
IKzbMergeListener {
    private static final int MAIN_SLOT_COUNT = 6;
    private static final int SUB_SLOT_COUNT = 5;
    public static final int LINE_COUNT = 5;
    private static final float MAX_POSITION = 6.0f;
    private static final float MAX_SUB_POSITION = 6.0f;
    private static final float MIN_CURSOR_POSITION = 1.0f;
    private static final float MAX_CURSOR_POSITION = 5.0f;
    private static final float MIN_SUB_CURSOR_POSITION = 1.0f;
    private static final float MAX_SUB_CURSOR_POSITION = 4.0f;
    private static final float MIN_ITEM_POSITION = 1.0f;
    private static final float MAX_ITEM_POSITION = 5.0f;
    private static final float MIN_SUB_ITEM_POSITION = 1.0f;
    private static final float MAX_SUB_ITEM_POSITION = 4.0f;
    private static final int VIEWPORT_SCROLL_ANIMATION_TYPE = 84;
    private static final int FOCUS_CURSOR_ANIMATION_TYPE = 85;
    private int mmiCombiSyncMode = 1;
    private static final LogChannel lc;
    protected final Gap gap = new Gap();
    protected final List subAllSlots;
    protected final LinkedList subSlotPool = new LinkedList();
    protected final LinkedList subUsedSlots = new LinkedList();
    protected final AbstractPlaceholderMenuController.AnimatedFloatProperty subViewportPosition = new AbstractPlaceholderMenuController.AnimatedFloatProperty(0.0f);
    protected final AbstractPlaceholderMenuController.Cursor subSelectionCursor = new AbstractPlaceholderMenuController.Cursor(this, -1, false, true);
    protected final AbstractPlaceholderMenuController.Cursor subFocusCursor;
    private AbstractAnimation subViewportScrollAnimation;
    private float subScrollbarPosition;
    private float subScrollbarLength;
    private float subTotalHeight;
    private boolean sublistOpened;
    private boolean sublistClosing = false;
    private AbstractPlaceholderMenuController.PlaceholderItemEntry mainItemEntryForVisibleSublist;
    private boolean mergeCursorWhenOpening = true;
    protected float stagePosition = 0.0f;
    protected float screenChangePosition = 0.0f;
    private SelectionDrawerPreviewIconController selectionDrawerPreviewIconController;
    private int drawerAnimationMask = 8321;
    private float desaturation = 0.0f;
    private float darkening = 0.0f;
    private static final float DARKENING_MULTIPLICATOR = 0.3f;
    private boolean entriesChanged = true;
    private SelectionMenuIdleTimerController idleTimer;
    private int maxMainListTextWidthSmallStage = -1;
    private int maxMainListTextWidthBigStage = -1;
    private int maxSubListTextWidthSmallStage = -1;
    private int maxSubListTextWidthBigStage = -1;
    private boolean isCurrentViewSizeAnimationNearSmallStage;

    public SelectionMenuController() {
        super(6, lc);
        this.subAllSlots = new ArrayList(5);
        for (int i2 = 0; i2 < 5; ++i2) {
            AbstractPlaceholderMenuController.Slot slot = new AbstractPlaceholderMenuController.Slot(this);
            this.subAllSlots.add(slot);
            this.subSlotPool.add(slot);
        }
        this.subViewportPosition.setUnanimatedValue(0.0f);
        this.subFocusCursor = new AbstractPlaceholderMenuController.Cursor(this, this.getFocusCursorAnimationType(), true, true);
        this.idleTimer = new SelectionMenuIdleTimerController(lc);
        this.add(this.idleTimer);
        this.bounceCursorMaxDeflection = 0.25f;
    }

    public float getDarkening() {
        return this.darkening;
    }

    public float getDesaturation() {
        return this.desaturation;
    }

    public void resetColoring() {
        this.darkening = 0.0f;
        this.desaturation = 0.0f;
    }

    private void clearSubItems(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry) {
        lc.log(10000000, "SelectionMenuController#clearSubItems item=%1", (Object)placeholderItemEntry);
        if (placeholderItemEntry == null) {
            return;
        }
        placeholderItemEntry.clearSubItems();
    }

    protected boolean inViewport(float f2, float f3) {
        return f2 >= 0.0f && f2 < 6.0f;
    }

    protected boolean inSubViewport(float f2) {
        return f2 >= 0.0f && f2 < 6.0f;
    }

    protected int getViewportAnimationType() {
        return 84;
    }

    protected int getFocusCursorAnimationType() {
        return 85;
    }

    public List getSubSlots() {
        this.updateSubPositions();
        this.assignSubSlots();
        return Collections.unmodifiableList(this.subAllSlots);
    }

    protected void updateSubPositions() {
        lc.log(10000000, "SelectionMenuController#updateSubPositions");
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.getFirstSubItemEntry();
        if (placeholderItemEntry == null) {
            this.subTotalHeight = 0.0f;
            lc.log(10000000, "SelectionMenuController#updateSubPositions No sub items");
            return;
        }
        Iterator iterator = this.getItemEntryIterator(placeholderItemEntry, true);
        float f2 = 0.0f;
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry2 = (AbstractPlaceholderMenuController.PlaceholderItemEntry)iterator.next();
            if (placeholderItemEntry2.isVisible()) {
                placeholderItemEntry2.setPosition(f2);
                lc.log(10000000, "SelectionMenuController#updateSubPositions Position %1: %2", (Object)String.valueOf(f2), (Object)placeholderItemEntry2);
                f2 += placeholderItemEntry2.getAnimatedHeight().getCurrent();
                continue;
            }
            lc.log(10000000, "SelectionMenuController#updatePositions Not showing %1:", (Object)placeholderItemEntry2);
        }
        this.subTotalHeight = f2;
    }

    private AbstractPlaceholderMenuController.PlaceholderItemEntry getFirstSubItemEntry() {
        if (this.mainItemEntryForVisibleSublist == null) {
            return null;
        }
        return this.mainItemEntryForVisibleSublist.getFirstSubItem();
    }

    private AbstractPlaceholderMenuController.PlaceholderItemEntry getLastSubItemEntry() {
        if (this.mainItemEntryForVisibleSublist == null) {
            return null;
        }
        return this.mainItemEntryForVisibleSublist.getLastSubItem();
    }

    protected void assignSubSlots() {
        lc.log(10000000, "SelectionMenuController#assignSubSlots");
        this.clearSubSlots();
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.getFirstSubItemEntry();
        if (placeholderItemEntry == null) {
            lc.log(10000000, "SelectionMenuController#assignSubSlots no subitems");
        }
        float f2 = this.subViewportPosition.getCurrent();
        lc.log(10000000, "SelectionMenuController#assignSubSlots currentSubViewportPortPosition=%1", (double)f2);
        Iterator iterator = this.getItemEntryIterator(placeholderItemEntry, true);
        while (iterator.hasNext() && !this.subSlotPool.isEmpty()) {
            AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry2 = (AbstractPlaceholderMenuController.PlaceholderItemEntry)iterator.next();
            float f3 = placeholderItemEntry2.getPosition() - f2;
            if (lc.isDebug()) {
                lc.log(10000000, "SelectionMenuController#assignSubSlots position of %1 in viewport: %2", (Object)placeholderItemEntry2, (Object)new Float(f3));
            }
            if (f3 > 0.0f && f3 < 5.0f && placeholderItemEntry2.isVisible()) {
                AbstractPlaceholderMenuController.Slot slot = placeholderItemEntry2.getSlot();
                if (slot == null || slot.enabled || !placeholderItemEntry2.equals(slot.getItemEntry())) {
                    AbstractPlaceholderMenuController.Slot slot2 = this.getSubSlotFromPool();
                    placeholderItemEntry2.setSlot(slot2);
                    slot2.setItemEntry(placeholderItemEntry2);
                } else {
                    this.subSlotPool.remove(slot);
                    this.subUsedSlots.add(slot);
                    slot.enabled = true;
                }
                lc.log(10000000, "SelectionMenuController#assignSubSlots in viewport");
                continue;
            }
            lc.log(10000000, "SelectionMenuController#assignSubSlots not in viewport");
        }
    }

    private AbstractPlaceholderMenuController.Slot getSubSlotFromPool() {
        if (this.subSlotPool.isEmpty()) {
            return null;
        }
        AbstractPlaceholderMenuController.Slot slot = (AbstractPlaceholderMenuController.Slot)this.subSlotPool.removeFirst();
        slot.enabled = true;
        this.subUsedSlots.addLast(slot);
        return slot;
    }

    private void clearSubSlots() {
        while (!this.subUsedSlots.isEmpty()) {
            AbstractPlaceholderMenuController.Slot slot = (AbstractPlaceholderMenuController.Slot)this.subUsedSlots.removeFirst();
            this.subSlotPool.addFirst(slot);
            slot.enabled = false;
        }
    }

    public void showDrawerItem(boolean bl, boolean bl2) {
        lc.log(100000, "SelectionMenuController#showDrawerItem animate=%1", bl);
    }

    public void hideDrawerItem(boolean bl, boolean bl2) {
        lc.log(100000, "SelectionMenuController#hideDrawerItem animate=%1", bl);
    }

    private void setDrawerPosition(float f2, float f3, float f4) {
        if (lc.isDebug()) {
            lc.log(10000000, "SelectionMenuController#setDrawerPosition position=%1, stage=%2, screenChangePosition=%3", (Object)new Float(f2), (Object)new Float(f3), (Object)new Float(f4));
        }
        if (f2 <= 0.0f) {
            if (!this.mergeCursorWhenOpening) {
                lc.log(10000000, "SelectionMenuController#setDrawerPosition drawer closed, merging cursor when opening");
                this.mergeCursorWhenOpening = true;
                this.openSubList(false);
            }
        } else if (this.mergeCursorWhenOpening) {
            lc.log(10000000, "SelectionMenuController#setDrawerPosition opening drawer, merging cursor");
            this.joinCursor(false);
            this.mergeCursorWhenOpening = false;
        }
        this.inOutPosition.setUnanimatedValue(f2);
        this.stagePosition = f3;
        this.screenChangePosition = f4;
        this.setCompositesDirty(true);
    }

    protected void joinCursor(boolean bl) {
        lc.log(10000000, "SelectionMenuController#joinCursor");
        super.joinCursor(bl);
        this.joinSubCursor(bl);
    }

    protected void joinSubCursor(boolean bl) {
        lc.log(10000000, "SelectionMenuController#joinSubCursor");
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.subSelectionCursor.getTargetItemEntry() == null ? (bl ? null : this.getFirstSubItemEntry()) : this.subSelectionCursor.getTargetItemEntry();
        if (placeholderItemEntry != null) {
            this.subFocusCursor.setTargetItemEntry(placeholderItemEntry, 0.0f, bl);
            this.adjustSubViewport(true);
        }
    }

    public float getSubPosition() {
        return this.gap.getSubPosition();
    }

    protected float getMaxCursorPosition() {
        return 5.0f;
    }

    protected float getMinCursorPosition() {
        return 1.0f;
    }

    protected float getMaxItemPosition() {
        return 5.0f;
    }

    protected float getMinItemPosition() {
        return 1.0f;
    }

    protected void setSelection(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry, boolean bl) {
        if (placeholderItemEntry != null && placeholderItemEntry.isSubItem()) {
            this.subSelectionCursor.setTargetItemEntry(placeholderItemEntry, 0.0f, false);
            return;
        }
        this.selectionCursor.setTargetItemEntry(placeholderItemEntry, 0.0f, false);
        this.mainItemEntriesChanged();
    }

    public void destroyWidget() {
        super.destroyWidget();
        AbstractAnimation abstractAnimation = this.gap.gapAanimation;
        if (abstractAnimation != null && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
        }
        this.gap.gapAanimation = null;
        this.inOutPosition.setUnanimatedValue(0.0f);
        this.renderer.inOutPositionChanged();
    }

    public void setScreenChangeProgress(float f2) {
    }

    public void setScreenChangeTarget(int n) {
        if (lc.isDebug()) {
            lc.log(10000000, "SelectionMenuController#setScreenChangeTarget this=%1, target=%2", (Object)this, (Object)ScreenChangeAnimationItem.Helper.getText(n));
        }
        this.listenForScreenChange(n != 24);
    }

    public void screenChangeFinished() {
        this.inOutPosition.setProgress(1.0f);
        this.stagePosition = 1.0f;
        this.renderer.inOutPositionChanged();
        this.listenForScreenChange(false);
        this.setCompositesDirty(true);
    }

    public boolean hasIdleTimer() {
        return true;
    }

    public void setAnimationType(int n) {
    }

    public void setMMICombiSyncMode(int n) {
        this.mmiCombiSyncMode = n;
    }

    public int getMMICombiSyncMode() {
        return this.mmiCombiSyncMode;
    }

    public void subListModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, PlaceholderMenuMultiItem placeholderMenuMultiItem2, ModelUpdateEvent modelUpdateEvent) {
        lc.log(10000000, "SelectionMenuController#subListModelChanged mainItem=%1, subItem=%2, event=%3", (Object)placeholderMenuMultiItem, (Object)placeholderMenuMultiItem2, (Object)modelUpdateEvent);
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.getItemEntry(placeholderMenuMultiItem);
        lc.log(10000000, "SelectionMenuController#subListModelChanged itemEntry of mainItem: %1", (Object)placeholderItemEntry);
        int n = modelUpdateEvent.getUpdateType();
        if (n == 16) {
            int n2 = modelUpdateEvent.getClientData1();
            lc.log(10000000, "SelectionMenuController#subListModelChanged transaction finished, statusflags=%1", (long)n2);
            if ((n2 & 7) != 0) {
                AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry2 = this.getMainItemEntry(this.selectionCursor.getTargetItemEntry());
                lc.log(10000000, "SelectionMenuController#subListModelChanged data changed, old main selection: %1", (Object)placeholderItemEntry2);
                this.updateSubEntries(placeholderItemEntry);
                AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry3 = this.selectionCursor.getTargetItemEntry();
                lc.log(10000000, "SelectionMenuController#subListModelChanged selectedItemEntry=%1", (Object)placeholderItemEntry3);
                if (placeholderItemEntry3 != null) {
                    lc.log(10000000, "SelectionMenuController#subListModelChanged selectedItemEntry: isSubItem=%1, subItemCount=%2,", placeholderItemEntry3.isSubItem(), (long)placeholderItemEntry3.getSubItemCount());
                }
                if (placeholderItemEntry3 != null && !placeholderItemEntry3.isSubItem() && placeholderItemEntry3.getSubItemCount() == 0) {
                    lc.log(10000000, "SelectionMenuController#subListModelChanged closing drawer");
                    this.closeSelectionDrawer();
                } else {
                    lc.log(10000000, "SelectionMenuController#subListModelChanged not closing drawer");
                }
            }
        } else if (n == 7 || n == 8 || n == 9 || n == 5 || n == 6 || n == 20 || n == 21) {
            AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry4 = this.getMainItemEntry(this.selectionCursor.getTargetItemEntry());
            lc.log(10000000, "SelectionMenuController#subListModelChanged data changed, old main selection: %1", (Object)placeholderItemEntry4);
            this.updateSubEntries(placeholderItemEntry);
            this.updateGap(this.selectionCursor.getTargetItemEntry());
        } else if (n == 22) {
            lc.log(10000000, "SelectionMenuController#subListModelChanged selection changed");
            this.updateSubSelection();
        } else if (n == 19) {
            ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
            if (ModelTrigger.CLOSE_SELECTION_DRAWER.equals(modelUpdateData)) {
                lc.log(10000000, "SelectionMenuController#subListModelChanged trigger close selection drawer");
                this.closeSelectionDrawer();
            } else {
                lc.log(100000, "SelectionMenuController#subListModelChanged unknown trigger %1", (Object)modelUpdateData);
            }
        } else {
            lc.log(100000, "SelectionMenuController#subListModelChanged unsupported update type %1", (long)n);
            this.updateSubEntries(placeholderItemEntry);
            return;
        }
    }

    private AbstractPlaceholderMenuController.PlaceholderItemEntry getMainItemEntry(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry) {
        if (placeholderItemEntry == null) {
            return null;
        }
        if (placeholderItemEntry.isSubItem()) {
            AbstractPlaceholderMenuController.PlaceholderSubItemEntry placeholderSubItemEntry = (AbstractPlaceholderMenuController.PlaceholderSubItemEntry)placeholderItemEntry;
            return placeholderSubItemEntry.mainItemEntry;
        }
        return placeholderItemEntry;
    }

    public boolean haveEntriesChanged() {
        return this.entriesChanged;
    }

    public void resetEntriesChanged() {
        this.entriesChanged = false;
    }

    public float getInOutPosition() {
        float f2 = super.getInOutPosition();
        float f3 = this.getMMICombiSyncMode() == 2 ? 0.0f : f2;
        float f4 = f3 * (1.0f - this.screenChangePosition);
        lc.log(1000000, "SelectionMenuController#getInOutPosition ioPos=%1, controllerpos=%2, screenChangePosition=%3", (double)f3, (double)f2, (double)this.screenChangePosition);
        return f4;
    }

    protected void updateEntries() {
        super.updateEntries();
        this.entriesChanged = true;
    }

    protected void updateSubEntries(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry) {
        lc.log(10000000, "SelectionMenuController#updateSubEntries of %1", (Object)placeholderItemEntry);
        float f2 = this.subFocusCursor.getCurrentPosition();
        lc.log(10000000, "SelectionMenuController#updateSubEntries current focus position %1", (double)f2);
        this.subSelectionCursor.setTargetItemEntry(null);
        if (placeholderItemEntry != null) {
            placeholderItemEntry.initialize();
        }
        this.updateSubSelection();
        if (this.subFocusCursor.getTargetItemEntry() == null || !this.subFocusCursor.getTargetItemEntry().isVisible() || !this.subFocusCursor.getTargetItemEntry().isConnected()) {
            this.subFocusCursor.setTargetItemEntry(null);
        }
        if (this.subFocusCursor.getTargetItemEntry() == null) {
            this.subFocusCursor.setTargetItemEntry(this.subSelectionCursor.getTargetItemEntry());
        }
        if (this.subFocusCursor.getTargetItemEntry() == null) {
            this.subFocusCursor.setTargetItemEntry(this.findFirstVisibleSubItemEntry());
        }
        this.updateSubPositions();
        if (this.subFocusCursor.getTargetItemEntry() != null) {
            this.setFocus(this.subFocusCursor.getTargetItemEntry(), 0.0f, true);
        }
        if (this.subSelectionCursor.getTargetItemEntry() != null) {
            this.setSelection(this.subSelectionCursor.getTargetItemEntry(), false);
        }
        this.assignSubSlots();
        this.updateSubScrollbar();
        this.setCompositesDirty(true);
    }

    protected AbstractPlaceholderMenuController.PlaceholderItemEntry updateSelection() {
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = super.updateSelection();
        lc.log(10000000, "SelectionMenuController#updateSelection selection=%1", (Object)placeholderItemEntry);
        if (this.menuEnterWasPressed) {
            this.menuEnterWasPressed = false;
            this.joinCursor(false);
            this.updateGap(placeholderItemEntry);
        }
        if (placeholderItemEntry != null && this.isSubListOpened() && (!placeholderItemEntry.isEnabled() || placeholderItemEntry.getSubItemCount() == 0)) {
            this.closeSubList(true);
        }
        return placeholderItemEntry;
    }

    protected AbstractPlaceholderMenuController.PlaceholderItemEntry updateSubSelection() {
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.subSelectionCursor.getTargetItemEntry();
        lc.log(10000000, "SelectionMenuController#updateSubSelection old selection %1", (Object)placeholderItemEntry);
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry2 = null;
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry3 = this.getFirstSubItemEntry();
        if (placeholderItemEntry3 == null) {
            lc.log(10000000, "SelectionMenuController#updateSubSelection no sublist available");
        } else {
            Iterator iterator = this.getItemEntryIterator(placeholderItemEntry3, true);
            while (iterator.hasNext()) {
                AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry4 = (AbstractPlaceholderMenuController.PlaceholderItemEntry)iterator.next();
                if (!placeholderItemEntry4.isVisible() || !placeholderItemEntry4.isSelected()) continue;
                placeholderItemEntry2 = placeholderItemEntry4;
            }
        }
        if (placeholderItemEntry2 != null && !Util.equals(placeholderItemEntry, placeholderItemEntry2)) {
            this.subSelectionCursor.setTargetItemEntry(placeholderItemEntry2, 0.0f, false);
            this.setCompositesDirty(true);
        }
        lc.log(10000000, "SelectionMenuController#updateSubSelection new selection %1", (Object)this.subSelectionCursor.getTargetItemEntry());
        return this.subSelectionCursor.getTargetItemEntry();
    }

    private void updateGap(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry) {
        boolean bl;
        lc.log(10000000, "SelectionMenuController#updateGap selection=%1", (Object)placeholderItemEntry);
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry2 = this.getMainItemEntry(placeholderItemEntry);
        if (placeholderItemEntry2 == null) {
            bl = false;
        } else {
            int n = this.getConnectedSubItems(placeholderItemEntry2);
            lc.log(10000000, "SelectionMenuController#updateGap connected subitems: ", (long)n);
            bl = n > 0;
        }
        this.gap.setMainItemEntry(placeholderItemEntry2, true, bl, true);
    }

    protected boolean openSubList(boolean bl) {
        lc.log(10000000, "SelectionMenuController#openSubList");
        if (this.isSubListOpened()) {
            lc.log(10000000, "SelectionMenuController#openSubList sublist already opened");
            return false;
        }
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.selectionCursor.getTargetItemEntry();
        if (placeholderItemEntry == null) {
            lc.log(10000000, "SelectionMenuController#openSubList no main item selected");
            return false;
        }
        if (this.getConnectedSubItems(placeholderItemEntry) > 0) {
            this.joinCursor(true);
            lc.log(10000000, "SelectionMenuController#openSubList opening sublist for %1", (Object)placeholderItemEntry);
            this.gap.setMainItemEntry(placeholderItemEntry, true, true, bl);
            this.requestLargeViewSizeIfNeeded();
            return true;
        }
        lc.log(10000000, "SelectionMenuController#openSubList main item %1 has no sublist", (Object)placeholderItemEntry);
        return false;
    }

    public boolean closeSubList(boolean bl) {
        lc.log(10000000, "SelectionMenuController#closeSubList");
        if (this.isSubListOpened()) {
            this.idleTimer.cancelTimer();
            this.gap.setMainItemEntry(null, bl, false, false);
            this.sublistClosing = true;
            return true;
        }
        lc.log(10000000, "SelectionMenuController#openSubList sublist already closed");
        return false;
    }

    public boolean isSubListOpened() {
        return this.sublistOpened;
    }

    private boolean isSubListClosing() {
        return this.sublistClosing;
    }

    protected AbstractPlaceholderMenuController.Cursor getCurrentFocusCursor() {
        boolean bl = this.isSubListOpened();
        lc.log(10000000, "SelectionMenuController#getCurrentFocusCursor sublist focused: %1", bl);
        if (bl) {
            lc.log(10000000, "SelectionMenuController#getCurrentFocusCursor returning subFocusCursor", (Object)this.subFocusCursor);
            return this.subFocusCursor;
        }
        return super.getCurrentFocusCursor();
    }

    protected AbstractPlaceholderMenuController.Cursor getCurrentSelectionCursor() {
        if (this.isSubListOpened()) {
            return this.subSelectionCursor;
        }
        return super.getCurrentSelectionCursor();
    }

    protected AbstractPlaceholderMenuController.PlaceholderItemEntry findCurrentFirstVisibleItemEntry() {
        if (this.isSubListOpened()) {
            return this.findFirstVisibleSubItemEntry();
        }
        return super.findCurrentFirstVisibleItemEntry();
    }

    protected AbstractPlaceholderMenuController.PlaceholderItemEntry findCurrentLastVisibleItemEntry() {
        if (this.isSubListOpened()) {
            return this.findLastVisibleSubItemEntry();
        }
        return super.findCurrentLastVisibleItemEntry();
    }

    protected AbstractPlaceholderMenuController.PlaceholderItemEntry findFirstVisibleSubItemEntry() {
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.getFirstSubItemEntry();
        return this.findVisibleSubItemEntry(placeholderItemEntry, true);
    }

    protected AbstractPlaceholderMenuController.PlaceholderItemEntry findLastVisibleSubItemEntry() {
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.getLastSubItemEntry();
        return this.findVisibleSubItemEntry(placeholderItemEntry, false);
    }

    protected AbstractPlaceholderMenuController.PlaceholderItemEntry findVisibleSubItemEntry(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry, boolean bl) {
        if (placeholderItemEntry == null) {
            return null;
        }
        Iterator iterator = this.getItemEntryIterator(placeholderItemEntry, bl);
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry2 = (AbstractPlaceholderMenuController.PlaceholderItemEntry)iterator.next();
            if (!placeholderItemEntry2.isVisible()) continue;
            return placeholderItemEntry2;
        }
        return null;
    }

    protected void setFocus(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry, float f2, boolean bl) {
        lc.log(10000000, "SelectionMenuController#setFocus Focusing %1, animate=%2", (Object)placeholderItemEntry, (Object)String.valueOf(bl));
        if (placeholderItemEntry == null) {
            if (!this.isSubListOpened()) {
                lc.log(10000000, "SelectionMenuController#setFocus sublist not focused");
                super.setFocus(placeholderItemEntry, f2, bl);
                return;
            }
        } else if (!placeholderItemEntry.isSubItem()) {
            lc.log(10000000, "SelectionMenuController#setFocus not a sublist item");
            super.setFocus(placeholderItemEntry, f2, bl);
            return;
        }
        AbstractAnimation abstractAnimation = this.getSubViewportScrollAnimation();
        if (!bl && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
        }
        this.subFocusCursor.setTargetItemEntry(placeholderItemEntry, f2, bl);
        if (null != placeholderItemEntry) {
            lc.log(10000000, "SelectionMenuController#setFocus current target viewportPosition=%1, targetPosition=%2, focusedItemPosition=%3", (double)this.subViewportPosition.getTarget(), (double)(placeholderItemEntry.getPosition() - this.subViewportPosition.getTarget()), (double)placeholderItemEntry.getPosition());
        }
        this.adjustSubViewport(bl);
    }

    protected void resetHddsOffset() {
        super.resetHddsOffset();
        this.subFocusCursor.hddsSubticksChanged(0.0f);
    }

    protected void adjustSubViewport(boolean bl) {
        float f2;
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.subFocusCursor.getTargetItemEntry();
        lc.log(10000000, "SelectionMenuController#adjustSubViewport Focusing %1, animate=%2", (Object)placeholderItemEntry, (Object)String.valueOf(bl));
        AbstractAnimation abstractAnimation = this.getSubViewportScrollAnimation();
        if (!bl && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
            this.subViewportPosition.setProgress(1.0f);
        }
        if (placeholderItemEntry == null) {
            return;
        }
        float f3 = placeholderItemEntry.getPosition() - this.subViewportPosition.getTarget();
        lc.log(10000000, "SelectionMenuController#adjustSubViewport current target viewportPosition=%1, targetPosition=%2", (Object)String.valueOf(this.subViewportPosition.getTarget()), (Object)String.valueOf(f3));
        if (f3 < 1.0f) {
            f2 = placeholderItemEntry.getPosition() - 1.0f;
            lc.log(10000000, "SelectionMenuController#adjustSubViewport targetPosition too small, scrolledTargetPosition=%1", (Object)String.valueOf(f2));
        } else {
            if (f3 <= 4.0f) {
                lc.log(10000000, "SelectionMenuController#adjustSubViewport targetPosition ok viewport target needs no change");
                return;
            }
            f2 = placeholderItemEntry.getPosition() - 4.0f;
            lc.log(10000000, "SelectionMenuController#adjustSubViewport targetPosition too big, scrolledTargetPosition=%1", (Object)String.valueOf(f2));
        }
        if (!bl) {
            this.subViewportPosition.setUnanimatedValue(f2);
            this.assignSubSlots();
            return;
        }
        this.subViewportPosition.updateTarget(f2);
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, this.getViewportAnimationType(), false, this);
        }
    }

    protected AbstractAnimation getSubViewportScrollAnimation() {
        if (this.subViewportScrollAnimation != null) {
            return this.subViewportScrollAnimation;
        }
        this.subViewportScrollAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(this.getViewportAnimationType());
        this.subViewportScrollAnimation.addListener(new AnimationListener(){

            public void animate(int n, float f2, int n2) {
                float f3 = SelectionMenuController.this.subViewportScrollAnimation.getProgress();
                SelectionMenuController.this.subViewportPosition.setProgress(f3);
                SelectionMenuController.this.assignSubSlots();
                SelectionMenuController.this.updateSubScrollbar();
                SelectionMenuController.this.setCompositesDirty(true);
            }

            public void animationStarted(int n, int n2) {
            }

            public void animationFinished(int n, int n2) {
                SelectionMenuController.this.subViewportPosition.setProgress(1.0f);
                SelectionMenuController.this.assignSubSlots();
                SelectionMenuController.this.updateSubScrollbar();
                SelectionMenuController.this.setCompositesDirty(true);
            }
        });
        return this.subViewportScrollAnimation;
    }

    protected void updateSubScrollbar() {
        lc.log(10000000, "SelectionMenuController#updateSubScrollbar totalHeight=%1", (double)this.subTotalHeight);
        if (this.subTotalHeight <= 0.0f) {
            this.subScrollbarPosition = 0.0f;
            this.subScrollbarLength = 0.0f;
            return;
        }
        this.subScrollbarPosition = (this.subViewportPosition.getCurrent() + 1.0f) / this.subTotalHeight;
        this.subScrollbarLength = 4.0f / this.subTotalHeight;
        if (lc.isDebug()) {
            lc.log(10000000, "SelectionMenuController#updateSubScrollbar viewportPosition=%1, scrollbarPosition=%2, scrollbarLength=%3", (Object)new Float(this.subViewportPosition.getCurrent()), (Object)new Float(this.subScrollbarPosition), (Object)new Float(this.subScrollbarLength));
        }
    }

    public AbstractPlaceholderMenuController.Cursor getSubSelectionCursor() {
        return this.subSelectionCursor;
    }

    public AbstractPlaceholderMenuController.Cursor getSubFocusCursor() {
        return this.subFocusCursor;
    }

    public float getDrawerStage() {
        if (((HMITerminalEvo)((Object)this.terminal)).getSkin() == 1) {
            boolean bl = this.terminal.getViewSizeManager().isSportskinSmallStage();
            return bl ? 0.0f : 1.0f;
        }
        return this.stagePosition;
    }

    protected float getCurrentSubViewportPosition() {
        return this.subViewportPosition.getCurrent();
    }

    protected float getMinSubCursorPosition() {
        return 1.0f;
    }

    protected float getMaxSubCursorPosition() {
        return 4.0f;
    }

    protected AbstractPlaceholderMenuController.AnimatedFloatProperty getSubViewportPosition() {
        return this.subViewportPosition;
    }

    public float getSubScrollbarPosition() {
        return this.subScrollbarPosition;
    }

    public float getSubScrollbarLength() {
        return this.subScrollbarLength;
    }

    public RectangleParameters getRectangleParameters() {
        return null;
    }

    public void initializeScreenChangeAnimation() {
    }

    public void setPreviewIcons(SelectionDrawerPreviewIconController selectionDrawerPreviewIconController) {
        this.selectionDrawerPreviewIconController = selectionDrawerPreviewIconController;
    }

    protected void mainItemEntriesChanged() {
        if (this.selectionDrawerPreviewIconController == null) {
            return;
        }
        AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry = this.getFirstItemEntry();
        if (placeholderItemEntry == null) {
            this.selectionDrawerPreviewIconController.setPreviewIcons(null, Collections.EMPTY_LIST);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.getItemEntryIterator(placeholderItemEntry, true);
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry2 = (AbstractPlaceholderMenuController.PlaceholderItemEntry)iterator.next();
            if (!placeholderItemEntry2.isVisible() || !placeholderItemEntry2.isEnabled()) continue;
            arrayList.add(placeholderItemEntry2);
        }
        this.selectionDrawerPreviewIconController.setPreviewIcons(this.selectionCursor.getTargetItemEntry(), arrayList);
    }

    protected void textUpdated(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry) {
        super.textUpdated(placeholderItemEntry);
        if (placeholderItemEntry.equals(this.subSelectionCursor.getTargetItemEntry())) {
            this.subSelectionCursor.invalidateTargetWidth();
        }
        if (placeholderItemEntry.equals(this.subFocusCursor.getTargetItemEntry())) {
            this.subFocusCursor.invalidateTargetWidth();
        }
        placeholderItemEntry.cachedText = !placeholderItemEntry.isSubItem() ? this.renderer.getStringUtility().abbreviateTextEllipsis(placeholderItemEntry.cachedText, this.getMaxMainListTextWidth(), false) : this.renderer.getStringUtility().abbreviateTextEllipsis(placeholderItemEntry.cachedText, this.getMaxSubListTextWidth(), false);
    }

    public void setDrawerAnimationMask(int n) {
    }

    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
        this.setDrawerAnimation(fArray, fArray2, n);
    }

    public void initializeDrawerItem() {
        this.inOutPosition.setUnanimatedValue(0.0f);
        this.setCompositesDirty(true);
        if (!this.isConnected()) {
            this.renderer.inOutPositionChanged();
        }
    }

    public boolean canOpen() {
        return this.findFirstVisibleItemEntry() != null;
    }

    public boolean canClose() {
        return true;
    }

    public int getDrawerAnimationMask() {
        return this.drawerAnimationMask;
    }

    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        float f2;
        if (DrawerAnimationManager.Helper.hasFlag(n, 12)) {
            f2 = fArray[12];
            lc.log(10000000, "SelectionMenuController#setDrawerAnimation using screen change progress, screenChangePosition=%1", (double)f2);
        } else {
            f2 = this.screenChangePosition;
            lc.log(10000000, "SelectionMenuController#setDrawerAnimation using old screenChangePosition: %1", (double)f2);
        }
        float f3 = fArray[0];
        float f4 = 1.0f - fArray[7];
        this.setDrawerPosition(f3, f4, f2);
        if (!this.isConnected()) {
            this.renderer.inOutPositionChanged();
        }
        if (DrawerAnimationManager.Helper.hasFlag(n, 13)) {
            this.desaturation = fArray[13];
            this.darkening = this.desaturation * 0.3f;
        }
        this.setCompositesDirty(true);
        this.focusCursor.setCursorWidthInitialized(false);
        this.subFocusCursor.setCursorWidthInitialized(false);
        float f5 = fArray[7];
        boolean bl = this.isCurrentViewSizeAnimationNearSmallStage;
        this.isCurrentViewSizeAnimationNearSmallStage = !((double)f5 <= 0.5);
        if (this.isCurrentViewSizeAnimationNearSmallStage != bl) {
            this.clearItemEntriesCache();
        }
    }

    public void setTransitionForward(boolean bl) {
    }

    public boolean isTransitionForward() {
        return false;
    }

    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
        float f2;
        float f3;
        if (fArray == null) {
            f3 = 0.0f;
            f2 = 1.0f;
        } else {
            f3 = fArray[0];
            f2 = 1.0f - fArray[7];
        }
        this.setDrawerPosition(f3, f2, 0.0f);
        if (!this.isConnected()) {
            this.renderer.inOutPositionChanged();
        }
        this.setDrawerAnimation(fArray, fArray2, this.drawerAnimationMask);
    }

    private boolean isSelectionDrawerKey(int n) {
        if (this.isLTR()) {
            return n == 9;
        }
        return n == 11;
    }

    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
        if (this.isSelectionDrawerKey(keyEvent.getKeyCode()) && this.isSubListOpened() && !this.isSubListClosing()) {
            this.requestLargeViewSizeIfNeeded();
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.isSubListOpened()) {
            this.idleTimer.cancelTimer();
        }
        super.keyTurned(wheelButtonEvent);
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (this.isSubListOpened()) {
            this.idleTimer.cancelTimer();
        }
        super.keyPressed(keyEvent);
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        if (joystickEvent.getDirection() == 0 && this.isSubListOpened() && !this.isSubListClosing()) {
            this.requestLargeViewSizeIfNeeded();
        }
        super.keyMoved(joystickEvent);
    }

    private void requestLargeViewSizeIfNeeded() {
        int n;
        IViewSizeManager iViewSizeManager = this.terminal.getViewSizeManager();
        if (!iViewSizeManager.isRequestActive(n = 1)) {
            iViewSizeManager.requestLargeViewSize(n, 500);
        }
    }

    public void setInitialState(int n) {
    }

    public void hideDrawerItem() {
    }

    public void setDrawerAnimationType(int n) {
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.terminal.getDrawerFocusManager().initializeDrawerAnimation(this);
        this.sublistClosing = false;
        this.resetColoring();
    }

    private void listenForScreenChange(boolean bl) {
        if (bl) {
            this.drawerAnimationMask |= 0x1000;
        } else {
            this.drawerAnimationMask &= 0xFFFFEFFF;
            this.screenChangePosition = 0.0f;
        }
    }

    public void restartIdleTimer() {
    }

    public void cancelIdleTimer() {
    }

    public int getMaxMainListTextWidth() {
        if (this.isCurrentViewSizeAnimationNearSmallStage) {
            return this.maxMainListTextWidthSmallStage == -1 ? this.width : this.maxMainListTextWidthSmallStage;
        }
        return this.maxMainListTextWidthBigStage == -1 ? this.width : this.maxMainListTextWidthBigStage;
    }

    public int getMaxSubListTextWidth() {
        if (this.isCurrentViewSizeAnimationNearSmallStage) {
            return this.maxSubListTextWidthSmallStage == -1 ? this.width : this.maxSubListTextWidthSmallStage;
        }
        return this.maxSubListTextWidthBigStage == -1 ? this.width : this.maxSubListTextWidthBigStage;
    }

    public void setMainItemEntryForVisibleSublist(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry) {
        this.mainItemEntryForVisibleSublist = placeholderItemEntry;
    }

    public void setMaxMainListTextWidthSmallStage(int n) {
        this.maxMainListTextWidthSmallStage = n;
    }

    public void setMaxMainListTextWidthBigStage(int n) {
        this.maxMainListTextWidthBigStage = n;
    }

    public void setMaxSubListTextWidthSmallStage(int n) {
        this.maxSubListTextWidthSmallStage = n;
    }

    public void setMaxSubListTextWidthBigStage(int n) {
        this.maxSubListTextWidthBigStage = n;
    }

    public float getScreenChangePosition() {
        return this.screenChangePosition;
    }

    public String getWidgetName() {
        return this.getClassName();
    }

    public void mergeFinished(String string) {
        this.setCompositesDirty(true);
    }

    public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    static {
        if (AbstractWidget.framework != null) {
            lc = logSelectionDrawerController;
        } else {
            lc = null;
            System.err.println("SelectionMenuController: Warning: no framework available");
        }
    }

    protected class Gap
    implements AnimationListener {
        private static final float SUB_POS_OPEN = 1.0f;
        private static final float SUB_POS_CLOSE = 0.0f;
        private float subPos;
        private static final int ANIMATION_TYPE = 88;
        private AbstractAnimation gapAanimation;
        private AbstractPlaceholderMenuController.PlaceholderItemEntry currentItemEntry;
        private AbstractPlaceholderMenuController.PlaceholderItemEntry nextItemEntry;

        protected Gap() {
        }

        protected AbstractAnimation getGapAnimation() {
            if (this.gapAanimation != null) {
                return this.gapAanimation;
            }
            this.gapAanimation = (AbstractAnimation)SelectionMenuController.this.getAnimationController().getIAnimation(88);
            this.gapAanimation.addListener(this);
            return this.gapAanimation;
        }

        public void setMainItemEntry(AbstractPlaceholderMenuController.PlaceholderItemEntry placeholderItemEntry, boolean bl, boolean bl2, boolean bl3) {
            float f2;
            float f3;
            int n;
            lc.log(1000000, "SelectionMenuController#setMainItemEntry current=%1, itemEntry=%2, animate=%3, open=%4", (Object)this.currentItemEntry, (Object)placeholderItemEntry, (Object)bl, (Object)bl2);
            boolean bl4 = placeholderItemEntry == null ? false : (!bl2 ? false : (n = SelectionMenuController.this.getConnectedSubItems(placeholderItemEntry)) > 0);
            lc.log(10000000, "SelectionMenuController#setMainItemEntry targetSubistFocused=%1", bl4);
            float f4 = f3 = bl4 ? 1.0f : 0.0f;
            if (bl4) {
                if (SelectionMenuController.this.subSelectionCursor.getTargetItemEntry() == null) {
                    SelectionMenuController.this.subFocusCursor.setTargetItemEntry(placeholderItemEntry.getFirstSubItem(), 0.0f, bl);
                } else {
                    SelectionMenuController.this.subFocusCursor.setTargetItemEntry(SelectionMenuController.this.subSelectionCursor.getTargetItemEntry(), 0.0f, bl);
                }
            } else {
                SelectionMenuController.this.subFocusCursor.setTargetItemEntry(null, 0.0f, false);
            }
            AbstractAnimation abstractAnimation = this.getGapAnimation();
            if (!bl) {
                if (abstractAnimation.isAnimating()) {
                    abstractAnimation.stopAnimation();
                }
                lc.log(10000000, "SelectionMenuController#setMainItemEntry not animating -> setting currentItemEntry to %1", (Object)placeholderItemEntry);
                this.currentItemEntry = placeholderItemEntry;
                SelectionMenuController.this.mainItemEntryForVisibleSublist = placeholderItemEntry;
                this.nextItemEntry = null;
                this.subPos = f3;
                SelectionMenuController.this.sublistOpened = bl4;
                SelectionMenuController.this.sublistClosing = false;
                this.updateAnimationValues(this.subPos);
                if (bl4) {
                    SelectionMenuController.this.joinSubCursor(false);
                }
                this.currentItemEntry = null;
                return;
            }
            if (this.currentItemEntry == null) {
                lc.log(10000000, "SelectionMenuController#setMainItemEntry currentItemEntry not set -> setting currentItemEntry to %1", (Object)placeholderItemEntry);
                this.subPos = 0.0f;
                this.nextItemEntry = null;
                if (abstractAnimation.isAnimating()) {
                    lc.log(100000, "SelectionMenuController#setMainItemEntry currentItemEntry not set but animating");
                    abstractAnimation.stopAnimation();
                }
                if (!bl2 || placeholderItemEntry == null) {
                    lc.log(10000000, "SelectionMenuController#setMainItemEntry already closed");
                    SelectionMenuController.this.sublistOpened = false;
                    SelectionMenuController.this.mainItemEntryForVisibleSublist = null;
                    return;
                }
                this.currentItemEntry = placeholderItemEntry;
                SelectionMenuController.this.mainItemEntryForVisibleSublist = placeholderItemEntry;
                SelectionMenuController.this.sublistOpened = true;
                SelectionMenuController.this.joinCursor(false);
                lc.log(1000000, "SelectionMenuController#setMainItemEntry opening sublist");
                abstractAnimation.startDynamicAnimation(0.0f, 1.0f, 88, true, SelectionMenuController.this);
                if (bl3) {
                    SelectionMenuController.this.idleTimer.restartTimer();
                }
                return;
            }
            if (this.currentItemEntry.equals(placeholderItemEntry)) {
                f2 = f3;
                this.nextItemEntry = null;
            } else {
                f2 = 0.0f;
                this.nextItemEntry = placeholderItemEntry;
            }
            if (abstractAnimation.isAnimating()) {
                if (f2 == abstractAnimation.getTarget()) {
                    lc.log(1000000, "SelectionMenuController#setMainItemEntry keeping sublist animation target %1, current value %2", (Object)String.valueOf(f2), (Object)String.valueOf(abstractAnimation.getValue()));
                } else {
                    lc.log(1000000, "SelectionMenuController#setMainItemEntry changing sublist animation target from %1 to %2, current value %3", (double)abstractAnimation.getTarget(), (double)f2, (double)abstractAnimation.getValue());
                    abstractAnimation.setTarget(f2);
                }
            } else {
                lc.log(1000000, "SelectionMenuController#setMainItemEntry starting sublist animation from %1 to %2", (Object)String.valueOf(this.subPos), (Object)String.valueOf(f2));
                abstractAnimation.startDynamicAnimation(this.subPos, f2, 88, true, SelectionMenuController.this);
                if (this.subPos == 1.0f && f2 == 0.0f) {
                    SelectionMenuController.this.idleTimer.cancelTimer();
                }
            }
        }

        public float getSubPosition() {
            return this.subPos;
        }

        public void animate(int n, float f2, int n2) {
            if (lc.isDebug()) {
                lc.log(10000000, "SelectionMenuController#Gap#animate value=%1, type=%2", (Object)new Float(f2), (long)n);
            }
            this.updateAnimationValues(f2);
        }

        private void updateAnimationValues(float f2) {
            lc.log(10000000, "SelectionMenuController#updateAnimationValues value=%1", (double)f2);
            if (this.currentItemEntry == null) {
                lc.log(10000000, "SelectionMenuController#updateAnimationValues currentItemEntry is null");
                this.subPos = 0.0f;
            } else {
                this.subPos = f2;
            }
            SelectionMenuController.this.updateSubPositions();
            SelectionMenuController.this.adjustSubViewport(true);
            SelectionMenuController.this.assignSubSlots();
            SelectionMenuController.this.setCompositesDirty(true);
        }

        public void animationStarted(int n, int n2) {
        }

        public void animationFinished(int n, int n2) {
            lc.log(10000000, "SelectionMenuController#Gap#animationFinished current=%1, target=%2", (Object)this.currentItemEntry, (Object)this.nextItemEntry);
            AbstractAnimation abstractAnimation = this.getGapAnimation();
            if (this.nextItemEntry == null) {
                float f2 = abstractAnimation.getTarget();
                lc.log(10000000, "SelectionMenuController#Gap#animationFinished animation target: %1", (Object)String.valueOf(f2));
                if (f2 == 0.0f) {
                    if (this.currentItemEntry != null && !this.currentItemEntry.isSelected()) {
                        lc.log(10000000, "SelectionMenuController#Gap#animationFinished sublist closed, removing subitems");
                        SelectionMenuController.this.clearSubItems(this.currentItemEntry);
                    }
                    lc.log(10000000, "SelectionMenuController#Gap#animationFinished sublist closed and no nextItemEntry -> setting currentItemEntry to null");
                    this.currentItemEntry = null;
                    SelectionMenuController.this.mainItemEntryForVisibleSublist = null;
                    SelectionMenuController.this.sublistOpened = false;
                    SelectionMenuController.this.sublistClosing = false;
                    this.updateAnimationValues(0.0f);
                } else {
                    lc.log(10000000, "SelectionMenuController#Gap#animationFinished sublist opened");
                    this.updateAnimationValues(f2);
                }
            } else {
                if (this.currentItemEntry != null && !this.currentItemEntry.isSelected()) {
                    SelectionMenuController.this.clearSubItems(this.currentItemEntry);
                }
                int n3 = SelectionMenuController.this.getConnectedSubItems(this.nextItemEntry);
                lc.log(10000000, "SelectionMenuController#Gap#animationFinished sublist closed and nextItemEntry set -> setting currentItemEntry %1, subitems=%2", (Object)this.nextItemEntry, (long)n3);
                if (n3 > 0) {
                    lc.log(10000000, "SelectionMenuController#Gap#animationFinished opening sublist");
                    this.currentItemEntry = this.nextItemEntry;
                    SelectionMenuController.this.mainItemEntryForVisibleSublist = this.currentItemEntry;
                    this.nextItemEntry = null;
                    SelectionMenuController.this.sublistOpened = true;
                    abstractAnimation.startDynamicAnimation(0.0f, 1.0f, 88, true, SelectionMenuController.this);
                } else {
                    this.nextItemEntry = null;
                    this.currentItemEntry = null;
                    SelectionMenuController.this.mainItemEntryForVisibleSublist = null;
                    SelectionMenuController.this.sublistOpened = false;
                }
            }
            SelectionMenuController.this.setCompositesDirty(true);
        }
    }
}

