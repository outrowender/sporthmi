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
import de.audi.atip.hmi.view.IKzbMergeListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem$Helper;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RectangleParameters;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager$Helper;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$AnimatedFloatProperty;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Cursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderSubItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Slot;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerMain;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionDrawerPreviewIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionMenuController$Gap;
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
    private static final int MAIN_SLOT_COUNT;
    private static final int SUB_SLOT_COUNT;
    public static final int LINE_COUNT;
    private static final float MAX_POSITION;
    private static final float MAX_SUB_POSITION;
    private static final float MIN_CURSOR_POSITION;
    private static final float MAX_CURSOR_POSITION;
    private static final float MIN_SUB_CURSOR_POSITION;
    private static final float MAX_SUB_CURSOR_POSITION;
    private static final float MIN_ITEM_POSITION;
    private static final float MAX_ITEM_POSITION;
    private static final float MIN_SUB_ITEM_POSITION;
    private static final float MAX_SUB_ITEM_POSITION;
    private static final int VIEWPORT_SCROLL_ANIMATION_TYPE;
    private static final int FOCUS_CURSOR_ANIMATION_TYPE;
    private int mmiCombiSyncMode = 1;
    private static final LogChannel lc;
    protected final SelectionMenuController$Gap gap = new SelectionMenuController$Gap(this);
    protected final List subAllSlots;
    protected final LinkedList subSlotPool = new LinkedList();
    protected final LinkedList subUsedSlots = new LinkedList();
    protected final AbstractPlaceholderMenuController$AnimatedFloatProperty subViewportPosition = new AbstractPlaceholderMenuController$AnimatedFloatProperty(0.0f);
    protected final AbstractPlaceholderMenuController$Cursor subSelectionCursor = new AbstractPlaceholderMenuController$Cursor(this, -1, false, true);
    protected final AbstractPlaceholderMenuController$Cursor subFocusCursor;
    private AbstractAnimation subViewportScrollAnimation;
    private float subScrollbarPosition;
    private float subScrollbarLength;
    private float subTotalHeight;
    private boolean sublistOpened;
    private boolean sublistClosing = false;
    private AbstractPlaceholderMenuController$PlaceholderItemEntry mainItemEntryForVisibleSublist;
    private boolean mergeCursorWhenOpening = true;
    protected float stagePosition = 0.0f;
    protected float screenChangePosition = 0.0f;
    private SelectionDrawerPreviewIconController selectionDrawerPreviewIconController;
    private int drawerAnimationMask = 8321;
    private float desaturation = 0.0f;
    private float darkening = 0.0f;
    private static final float DARKENING_MULTIPLICATOR;
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
            AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = new AbstractPlaceholderMenuController$Slot(this);
            this.subAllSlots.add(abstractPlaceholderMenuController$Slot);
            this.subSlotPool.add(abstractPlaceholderMenuController$Slot);
        }
        this.subViewportPosition.setUnanimatedValue(0.0f);
        this.subFocusCursor = new AbstractPlaceholderMenuController$Cursor(this, this.getFocusCursorAnimationType(), true, true);
        this.idleTimer = new SelectionMenuIdleTimerController(lc);
        this.add(this.idleTimer);
        this.bounceCursorMaxDeflection = 32830;
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

    private void clearSubItems(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        lc.log(-2137614336, "SelectionMenuController#clearSubItems item=%1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            return;
        }
        abstractPlaceholderMenuController$PlaceholderItemEntry.clearSubItems();
    }

    @Override
    protected boolean inViewport(float f2, float f3) {
        return f2 >= 0.0f && f2 < 49216;
    }

    @Override
    protected boolean inSubViewport(float f2) {
        return f2 >= 0.0f && f2 < 49216;
    }

    @Override
    protected int getViewportAnimationType() {
        return 84;
    }

    @Override
    protected int getFocusCursorAnimationType() {
        return 85;
    }

    public List getSubSlots() {
        this.updateSubPositions();
        this.assignSubSlots();
        return Collections.unmodifiableList(this.subAllSlots);
    }

    protected void updateSubPositions() {
        lc.log(-2137614336, "SelectionMenuController#updateSubPositions");
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.getFirstSubItemEntry();
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            this.subTotalHeight = 0.0f;
            lc.log(-2137614336, "SelectionMenuController#updateSubPositions No sub items");
            return;
        }
        Iterator iterator = this.getItemEntryIterator(abstractPlaceholderMenuController$PlaceholderItemEntry, true);
        float f2 = 0.0f;
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            if (abstractPlaceholderMenuController$PlaceholderItemEntry2.isVisible()) {
                abstractPlaceholderMenuController$PlaceholderItemEntry2.setPosition(f2);
                lc.log(-2137614336, "SelectionMenuController#updateSubPositions Position %1: %2", (Object)String.valueOf(f2), (Object)abstractPlaceholderMenuController$PlaceholderItemEntry2);
                f2 += abstractPlaceholderMenuController$PlaceholderItemEntry2.getAnimatedHeight().getCurrent();
                continue;
            }
            lc.log(-2137614336, "SelectionMenuController#updatePositions Not showing %1:", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry2);
        }
        this.subTotalHeight = f2;
    }

    private AbstractPlaceholderMenuController$PlaceholderItemEntry getFirstSubItemEntry() {
        if (this.mainItemEntryForVisibleSublist == null) {
            return null;
        }
        return this.mainItemEntryForVisibleSublist.getFirstSubItem();
    }

    private AbstractPlaceholderMenuController$PlaceholderItemEntry getLastSubItemEntry() {
        if (this.mainItemEntryForVisibleSublist == null) {
            return null;
        }
        return this.mainItemEntryForVisibleSublist.getLastSubItem();
    }

    protected void assignSubSlots() {
        lc.log(-2137614336, "SelectionMenuController#assignSubSlots");
        this.clearSubSlots();
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.getFirstSubItemEntry();
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            lc.log(-2137614336, "SelectionMenuController#assignSubSlots no subitems");
        }
        float f2 = this.subViewportPosition.getCurrent();
        lc.log(-2137614336, "SelectionMenuController#assignSubSlots currentSubViewportPortPosition=%1", (double)f2);
        Iterator iterator = this.getItemEntryIterator(abstractPlaceholderMenuController$PlaceholderItemEntry, true);
        while (iterator.hasNext() && !this.subSlotPool.isEmpty()) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            float f3 = abstractPlaceholderMenuController$PlaceholderItemEntry2.getPosition() - f2;
            if (lc.isDebug()) {
                lc.log(-2137614336, "SelectionMenuController#assignSubSlots position of %1 in viewport: %2", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry2, (Object)new Float(f3));
            }
            if (f3 > 0.0f && f3 < 41024 && abstractPlaceholderMenuController$PlaceholderItemEntry2.isVisible()) {
                AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = abstractPlaceholderMenuController$PlaceholderItemEntry2.getSlot();
                if (abstractPlaceholderMenuController$Slot == null || abstractPlaceholderMenuController$Slot.enabled || !abstractPlaceholderMenuController$PlaceholderItemEntry2.equals(abstractPlaceholderMenuController$Slot.getItemEntry())) {
                    AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot2 = this.getSubSlotFromPool();
                    abstractPlaceholderMenuController$PlaceholderItemEntry2.setSlot(abstractPlaceholderMenuController$Slot2);
                    abstractPlaceholderMenuController$Slot2.setItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry2);
                } else {
                    this.subSlotPool.remove(abstractPlaceholderMenuController$Slot);
                    this.subUsedSlots.add(abstractPlaceholderMenuController$Slot);
                    abstractPlaceholderMenuController$Slot.enabled = true;
                }
                lc.log(-2137614336, "SelectionMenuController#assignSubSlots in viewport");
                continue;
            }
            lc.log(-2137614336, "SelectionMenuController#assignSubSlots not in viewport");
        }
    }

    private AbstractPlaceholderMenuController$Slot getSubSlotFromPool() {
        if (this.subSlotPool.isEmpty()) {
            return null;
        }
        AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = (AbstractPlaceholderMenuController$Slot)this.subSlotPool.removeFirst();
        abstractPlaceholderMenuController$Slot.enabled = true;
        this.subUsedSlots.addLast(abstractPlaceholderMenuController$Slot);
        return abstractPlaceholderMenuController$Slot;
    }

    private void clearSubSlots() {
        while (!this.subUsedSlots.isEmpty()) {
            AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot = (AbstractPlaceholderMenuController$Slot)this.subUsedSlots.removeFirst();
            this.subSlotPool.addFirst(abstractPlaceholderMenuController$Slot);
            abstractPlaceholderMenuController$Slot.enabled = false;
        }
    }

    @Override
    public void showDrawerItem(boolean bl, boolean bl2) {
        lc.log(-1601830656, "SelectionMenuController#showDrawerItem animate=%1", bl);
    }

    @Override
    public void hideDrawerItem(boolean bl, boolean bl2) {
        lc.log(-1601830656, "SelectionMenuController#hideDrawerItem animate=%1", bl);
    }

    private void setDrawerPosition(float f2, float f3, float f4) {
        if (lc.isDebug()) {
            lc.log(-2137614336, "SelectionMenuController#setDrawerPosition position=%1, stage=%2, screenChangePosition=%3", (Object)new Float(f2), (Object)new Float(f3), (Object)new Float(f4));
        }
        if (f2 <= 0.0f) {
            if (!this.mergeCursorWhenOpening) {
                lc.log(-2137614336, "SelectionMenuController#setDrawerPosition drawer closed, merging cursor when opening");
                this.mergeCursorWhenOpening = true;
                this.openSubList(false);
            }
        } else if (this.mergeCursorWhenOpening) {
            lc.log(-2137614336, "SelectionMenuController#setDrawerPosition opening drawer, merging cursor");
            this.joinCursor(false);
            this.mergeCursorWhenOpening = false;
        }
        this.inOutPosition.setUnanimatedValue(f2);
        this.stagePosition = f3;
        this.screenChangePosition = f4;
        this.setCompositesDirty(true);
    }

    @Override
    protected void joinCursor(boolean bl) {
        lc.log(-2137614336, "SelectionMenuController#joinCursor");
        super.joinCursor(bl);
        this.joinSubCursor(bl);
    }

    protected void joinSubCursor(boolean bl) {
        lc.log(-2137614336, "SelectionMenuController#joinSubCursor");
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.subSelectionCursor.getTargetItemEntry() == null ? (bl ? null : this.getFirstSubItemEntry()) : this.subSelectionCursor.getTargetItemEntry();
        if (abstractPlaceholderMenuController$PlaceholderItemEntry != null) {
            this.subFocusCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry, 0.0f, bl);
            this.adjustSubViewport(true);
        }
    }

    public float getSubPosition() {
        return this.gap.getSubPosition();
    }

    @Override
    protected float getMaxCursorPosition() {
        return 41024;
    }

    @Override
    protected float getMinCursorPosition() {
        return 1.0f;
    }

    @Override
    protected float getMaxItemPosition() {
        return 41024;
    }

    @Override
    protected float getMinItemPosition() {
        return 1.0f;
    }

    @Override
    protected void setSelection(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry, boolean bl) {
        if (abstractPlaceholderMenuController$PlaceholderItemEntry != null && abstractPlaceholderMenuController$PlaceholderItemEntry.isSubItem()) {
            this.subSelectionCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry, 0.0f, false);
            return;
        }
        this.selectionCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry, 0.0f, false);
        this.mainItemEntriesChanged();
    }

    @Override
    public void destroyWidget() {
        super.destroyWidget();
        AbstractAnimation abstractAnimation = SelectionMenuController$Gap.access$600(this.gap);
        if (abstractAnimation != null && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
        }
        SelectionMenuController$Gap.access$602(this.gap, null);
        this.inOutPosition.setUnanimatedValue(0.0f);
        this.renderer.inOutPositionChanged();
    }

    @Override
    public void setScreenChangeProgress(float f2) {
    }

    @Override
    public void setScreenChangeTarget(int n) {
        if (lc.isDebug()) {
            lc.log(-2137614336, "SelectionMenuController#setScreenChangeTarget this=%1, target=%2", (Object)this, (Object)ScreenChangeAnimationItem$Helper.getText(n));
        }
        this.listenForScreenChange(n != 24);
    }

    @Override
    public void screenChangeFinished() {
        this.inOutPosition.setProgress(1.0f);
        this.stagePosition = 1.0f;
        this.renderer.inOutPositionChanged();
        this.listenForScreenChange(false);
        this.setCompositesDirty(true);
    }

    @Override
    public boolean hasIdleTimer() {
        return true;
    }

    @Override
    public void setAnimationType(int n) {
    }

    @Override
    public void setMMICombiSyncMode(int n) {
        this.mmiCombiSyncMode = n;
    }

    @Override
    public int getMMICombiSyncMode() {
        return this.mmiCombiSyncMode;
    }

    @Override
    public void subListModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, PlaceholderMenuMultiItem placeholderMenuMultiItem2, ModelUpdateEvent modelUpdateEvent) {
        lc.log(-2137614336, "SelectionMenuController#subListModelChanged mainItem=%1, subItem=%2, event=%3", (Object)placeholderMenuMultiItem, (Object)placeholderMenuMultiItem2, (Object)modelUpdateEvent);
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.getItemEntry(placeholderMenuMultiItem);
        lc.log(-2137614336, "SelectionMenuController#subListModelChanged itemEntry of mainItem: %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
        int n = modelUpdateEvent.getUpdateType();
        if (n == 16) {
            int n2 = modelUpdateEvent.getClientData1();
            lc.log(-2137614336, "SelectionMenuController#subListModelChanged transaction finished, statusflags=%1", (long)n2);
            if ((n2 & 7) != 0) {
                AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = this.getMainItemEntry(this.selectionCursor.getTargetItemEntry());
                lc.log(-2137614336, "SelectionMenuController#subListModelChanged data changed, old main selection: %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry2);
                this.updateSubEntries(abstractPlaceholderMenuController$PlaceholderItemEntry);
                AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry3 = this.selectionCursor.getTargetItemEntry();
                lc.log(-2137614336, "SelectionMenuController#subListModelChanged selectedItemEntry=%1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry3);
                if (abstractPlaceholderMenuController$PlaceholderItemEntry3 != null) {
                    lc.log(-2137614336, "SelectionMenuController#subListModelChanged selectedItemEntry: isSubItem=%1, subItemCount=%2,", abstractPlaceholderMenuController$PlaceholderItemEntry3.isSubItem(), (long)abstractPlaceholderMenuController$PlaceholderItemEntry3.getSubItemCount());
                }
                if (abstractPlaceholderMenuController$PlaceholderItemEntry3 != null && !abstractPlaceholderMenuController$PlaceholderItemEntry3.isSubItem() && abstractPlaceholderMenuController$PlaceholderItemEntry3.getSubItemCount() == 0) {
                    lc.log(-2137614336, "SelectionMenuController#subListModelChanged closing drawer");
                    this.closeSelectionDrawer();
                } else {
                    lc.log(-2137614336, "SelectionMenuController#subListModelChanged not closing drawer");
                }
            }
        } else if (n == 7 || n == 8 || n == 9 || n == 5 || n == 6 || n == 20 || n == 21) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry4 = this.getMainItemEntry(this.selectionCursor.getTargetItemEntry());
            lc.log(-2137614336, "SelectionMenuController#subListModelChanged data changed, old main selection: %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry4);
            this.updateSubEntries(abstractPlaceholderMenuController$PlaceholderItemEntry);
            this.updateGap(this.selectionCursor.getTargetItemEntry());
        } else if (n == 22) {
            lc.log(-2137614336, "SelectionMenuController#subListModelChanged selection changed");
            this.updateSubSelection();
        } else if (n == 19) {
            ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
            if (ModelTrigger.CLOSE_SELECTION_DRAWER.equals(modelUpdateData)) {
                lc.log(-2137614336, "SelectionMenuController#subListModelChanged trigger close selection drawer");
                this.closeSelectionDrawer();
            } else {
                lc.log(-1601830656, "SelectionMenuController#subListModelChanged unknown trigger %1", (Object)modelUpdateData);
            }
        } else {
            lc.log(-1601830656, "SelectionMenuController#subListModelChanged unsupported update type %1", (long)n);
            this.updateSubEntries(abstractPlaceholderMenuController$PlaceholderItemEntry);
            return;
        }
    }

    private AbstractPlaceholderMenuController$PlaceholderItemEntry getMainItemEntry(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            return null;
        }
        if (abstractPlaceholderMenuController$PlaceholderItemEntry.isSubItem()) {
            AbstractPlaceholderMenuController$PlaceholderSubItemEntry abstractPlaceholderMenuController$PlaceholderSubItemEntry = (AbstractPlaceholderMenuController$PlaceholderSubItemEntry)abstractPlaceholderMenuController$PlaceholderItemEntry;
            return abstractPlaceholderMenuController$PlaceholderSubItemEntry.mainItemEntry;
        }
        return abstractPlaceholderMenuController$PlaceholderItemEntry;
    }

    public boolean haveEntriesChanged() {
        return this.entriesChanged;
    }

    public void resetEntriesChanged() {
        this.entriesChanged = false;
    }

    @Override
    public float getInOutPosition() {
        float f2 = super.getInOutPosition();
        float f3 = this.getMMICombiSyncMode() == 2 ? 0.0f : f2;
        float f4 = f3 * (1.0f - this.screenChangePosition);
        lc.log(1078071040, "SelectionMenuController#getInOutPosition ioPos=%1, controllerpos=%2, screenChangePosition=%3", (double)f3, (double)f2, (double)this.screenChangePosition);
        return f4;
    }

    @Override
    protected void updateEntries() {
        super.updateEntries();
        this.entriesChanged = true;
    }

    @Override
    protected void updateSubEntries(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        lc.log(-2137614336, "SelectionMenuController#updateSubEntries of %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
        float f2 = this.subFocusCursor.getCurrentPosition();
        lc.log(-2137614336, "SelectionMenuController#updateSubEntries current focus position %1", (double)f2);
        this.subSelectionCursor.setTargetItemEntry(null);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry != null) {
            abstractPlaceholderMenuController$PlaceholderItemEntry.initialize();
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

    @Override
    protected AbstractPlaceholderMenuController$PlaceholderItemEntry updateSelection() {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = super.updateSelection();
        lc.log(-2137614336, "SelectionMenuController#updateSelection selection=%1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
        if (this.menuEnterWasPressed) {
            this.menuEnterWasPressed = false;
            this.joinCursor(false);
            this.updateGap(abstractPlaceholderMenuController$PlaceholderItemEntry);
        }
        if (abstractPlaceholderMenuController$PlaceholderItemEntry != null && this.isSubListOpened() && (!abstractPlaceholderMenuController$PlaceholderItemEntry.isEnabled() || abstractPlaceholderMenuController$PlaceholderItemEntry.getSubItemCount() == 0)) {
            this.closeSubList(true);
        }
        return abstractPlaceholderMenuController$PlaceholderItemEntry;
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry updateSubSelection() {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.subSelectionCursor.getTargetItemEntry();
        lc.log(-2137614336, "SelectionMenuController#updateSubSelection old selection %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = null;
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry3 = this.getFirstSubItemEntry();
        if (abstractPlaceholderMenuController$PlaceholderItemEntry3 == null) {
            lc.log(-2137614336, "SelectionMenuController#updateSubSelection no sublist available");
        } else {
            Iterator iterator = this.getItemEntryIterator(abstractPlaceholderMenuController$PlaceholderItemEntry3, true);
            while (iterator.hasNext()) {
                AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry4 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
                if (!abstractPlaceholderMenuController$PlaceholderItemEntry4.isVisible() || !abstractPlaceholderMenuController$PlaceholderItemEntry4.isSelected()) continue;
                abstractPlaceholderMenuController$PlaceholderItemEntry2 = abstractPlaceholderMenuController$PlaceholderItemEntry4;
            }
        }
        if (abstractPlaceholderMenuController$PlaceholderItemEntry2 != null && !Util.equals(abstractPlaceholderMenuController$PlaceholderItemEntry, abstractPlaceholderMenuController$PlaceholderItemEntry2)) {
            this.subSelectionCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry2, 0.0f, false);
            this.setCompositesDirty(true);
        }
        lc.log(-2137614336, "SelectionMenuController#updateSubSelection new selection %1", (Object)this.subSelectionCursor.getTargetItemEntry());
        return this.subSelectionCursor.getTargetItemEntry();
    }

    private void updateGap(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        boolean bl;
        lc.log(-2137614336, "SelectionMenuController#updateGap selection=%1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = this.getMainItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry2 == null) {
            bl = false;
        } else {
            int n = this.getConnectedSubItems(abstractPlaceholderMenuController$PlaceholderItemEntry2);
            lc.log(-2137614336, "SelectionMenuController#updateGap connected subitems: ", (long)n);
            bl = n > 0;
        }
        this.gap.setMainItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry2, true, bl, true);
    }

    @Override
    protected boolean openSubList(boolean bl) {
        lc.log(-2137614336, "SelectionMenuController#openSubList");
        if (this.isSubListOpened()) {
            lc.log(-2137614336, "SelectionMenuController#openSubList sublist already opened");
            return false;
        }
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.selectionCursor.getTargetItemEntry();
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            lc.log(-2137614336, "SelectionMenuController#openSubList no main item selected");
            return false;
        }
        if (this.getConnectedSubItems(abstractPlaceholderMenuController$PlaceholderItemEntry) > 0) {
            this.joinCursor(true);
            lc.log(-2137614336, "SelectionMenuController#openSubList opening sublist for %1", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
            this.gap.setMainItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry, true, true, bl);
            this.requestLargeViewSizeIfNeeded();
            return true;
        }
        lc.log(-2137614336, "SelectionMenuController#openSubList main item %1 has no sublist", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry);
        return false;
    }

    @Override
    public boolean closeSubList(boolean bl) {
        lc.log(-2137614336, "SelectionMenuController#closeSubList");
        if (this.isSubListOpened()) {
            this.idleTimer.cancelTimer();
            this.gap.setMainItemEntry(null, bl, false, false);
            this.sublistClosing = true;
            return true;
        }
        lc.log(-2137614336, "SelectionMenuController#openSubList sublist already closed");
        return false;
    }

    public boolean isSubListOpened() {
        return this.sublistOpened;
    }

    private boolean isSubListClosing() {
        return this.sublistClosing;
    }

    @Override
    protected AbstractPlaceholderMenuController$Cursor getCurrentFocusCursor() {
        boolean bl = this.isSubListOpened();
        lc.log(-2137614336, "SelectionMenuController#getCurrentFocusCursor sublist focused: %1", bl);
        if (bl) {
            lc.log(-2137614336, "SelectionMenuController#getCurrentFocusCursor returning subFocusCursor", (Object)this.subFocusCursor);
            return this.subFocusCursor;
        }
        return super.getCurrentFocusCursor();
    }

    @Override
    protected AbstractPlaceholderMenuController$Cursor getCurrentSelectionCursor() {
        if (this.isSubListOpened()) {
            return this.subSelectionCursor;
        }
        return super.getCurrentSelectionCursor();
    }

    @Override
    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findCurrentFirstVisibleItemEntry() {
        if (this.isSubListOpened()) {
            return this.findFirstVisibleSubItemEntry();
        }
        return super.findCurrentFirstVisibleItemEntry();
    }

    @Override
    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findCurrentLastVisibleItemEntry() {
        if (this.isSubListOpened()) {
            return this.findLastVisibleSubItemEntry();
        }
        return super.findCurrentLastVisibleItemEntry();
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findFirstVisibleSubItemEntry() {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.getFirstSubItemEntry();
        return this.findVisibleSubItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry, true);
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findLastVisibleSubItemEntry() {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.getLastSubItemEntry();
        return this.findVisibleSubItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry, false);
    }

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry findVisibleSubItemEntry(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry, boolean bl) {
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            return null;
        }
        Iterator iterator = this.getItemEntryIterator(abstractPlaceholderMenuController$PlaceholderItemEntry, bl);
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            if (!abstractPlaceholderMenuController$PlaceholderItemEntry2.isVisible()) continue;
            return abstractPlaceholderMenuController$PlaceholderItemEntry2;
        }
        return null;
    }

    @Override
    protected void setFocus(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry, float f2, boolean bl) {
        lc.log(-2137614336, "SelectionMenuController#setFocus Focusing %1, animate=%2", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry, (Object)String.valueOf(bl));
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            if (!this.isSubListOpened()) {
                lc.log(-2137614336, "SelectionMenuController#setFocus sublist not focused");
                super.setFocus(abstractPlaceholderMenuController$PlaceholderItemEntry, f2, bl);
                return;
            }
        } else if (!abstractPlaceholderMenuController$PlaceholderItemEntry.isSubItem()) {
            lc.log(-2137614336, "SelectionMenuController#setFocus not a sublist item");
            super.setFocus(abstractPlaceholderMenuController$PlaceholderItemEntry, f2, bl);
            return;
        }
        AbstractAnimation abstractAnimation = this.getSubViewportScrollAnimation();
        if (!bl && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
        }
        this.subFocusCursor.setTargetItemEntry(abstractPlaceholderMenuController$PlaceholderItemEntry, f2, bl);
        if (null != abstractPlaceholderMenuController$PlaceholderItemEntry) {
            lc.log(-2137614336, "SelectionMenuController#setFocus current target viewportPosition=%1, targetPosition=%2, focusedItemPosition=%3", (double)this.subViewportPosition.getTarget(), (double)(abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition() - this.subViewportPosition.getTarget()), (double)abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition());
        }
        this.adjustSubViewport(bl);
    }

    @Override
    protected void resetHddsOffset() {
        super.resetHddsOffset();
        this.subFocusCursor.hddsSubticksChanged(0.0f);
    }

    protected void adjustSubViewport(boolean bl) {
        float f2;
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.subFocusCursor.getTargetItemEntry();
        lc.log(-2137614336, "SelectionMenuController#adjustSubViewport Focusing %1, animate=%2", (Object)abstractPlaceholderMenuController$PlaceholderItemEntry, (Object)String.valueOf(bl));
        AbstractAnimation abstractAnimation = this.getSubViewportScrollAnimation();
        if (!bl && abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
            this.subViewportPosition.setProgress(1.0f);
        }
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            return;
        }
        float f3 = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition() - this.subViewportPosition.getTarget();
        lc.log(-2137614336, "SelectionMenuController#adjustSubViewport current target viewportPosition=%1, targetPosition=%2", (Object)String.valueOf(this.subViewportPosition.getTarget()), (Object)String.valueOf(f3));
        if (f3 < 1.0f) {
            f2 = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition() - 1.0f;
            lc.log(-2137614336, "SelectionMenuController#adjustSubViewport targetPosition too small, scrolledTargetPosition=%1", (Object)String.valueOf(f2));
        } else {
            if (f3 <= 32832) {
                lc.log(-2137614336, "SelectionMenuController#adjustSubViewport targetPosition ok viewport target needs no change");
                return;
            }
            f2 = abstractPlaceholderMenuController$PlaceholderItemEntry.getPosition() - 32832;
            lc.log(-2137614336, "SelectionMenuController#adjustSubViewport targetPosition too big, scrolledTargetPosition=%1", (Object)String.valueOf(f2));
        }
        if (!bl) {
            this.subViewportPosition.setUnanimatedValue(f2);
            this.assignSubSlots();
            return;
        }
        this.subViewportPosition.updateTarget(f2);
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 31300);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 31300, this.getViewportAnimationType(), false, this);
        }
    }

    protected AbstractAnimation getSubViewportScrollAnimation() {
        if (this.subViewportScrollAnimation != null) {
            return this.subViewportScrollAnimation;
        }
        this.subViewportScrollAnimation = (AbstractAnimation)this.getAnimationController().getIAnimation(this.getViewportAnimationType());
        this.subViewportScrollAnimation.addListener(new SelectionMenuController$1(this));
        return this.subViewportScrollAnimation;
    }

    protected void updateSubScrollbar() {
        lc.log(-2137614336, "SelectionMenuController#updateSubScrollbar totalHeight=%1", (double)this.subTotalHeight);
        if (this.subTotalHeight <= 0.0f) {
            this.subScrollbarPosition = 0.0f;
            this.subScrollbarLength = 0.0f;
            return;
        }
        this.subScrollbarPosition = (this.subViewportPosition.getCurrent() + 1.0f) / this.subTotalHeight;
        this.subScrollbarLength = 32832 / this.subTotalHeight;
        if (lc.isDebug()) {
            lc.log(-2137614336, "SelectionMenuController#updateSubScrollbar viewportPosition=%1, scrollbarPosition=%2, scrollbarLength=%3", (Object)new Float(this.subViewportPosition.getCurrent()), (Object)new Float(this.subScrollbarPosition), (Object)new Float(this.subScrollbarLength));
        }
    }

    @Override
    public AbstractPlaceholderMenuController$Cursor getSubSelectionCursor() {
        return this.subSelectionCursor;
    }

    @Override
    public AbstractPlaceholderMenuController$Cursor getSubFocusCursor() {
        return this.subFocusCursor;
    }

    public float getDrawerStage() {
        if (((HMITerminalEvo)((Object)this.terminal)).getSkin() == 1) {
            boolean bl = this.terminal.getViewSizeManager().isSportskinSmallStage();
            return bl ? 0.0f : 1.0f;
        }
        return this.stagePosition;
    }

    @Override
    protected float getCurrentSubViewportPosition() {
        return this.subViewportPosition.getCurrent();
    }

    @Override
    protected float getMinSubCursorPosition() {
        return 1.0f;
    }

    @Override
    protected float getMaxSubCursorPosition() {
        return 32832;
    }

    @Override
    protected AbstractPlaceholderMenuController$AnimatedFloatProperty getSubViewportPosition() {
        return this.subViewportPosition;
    }

    public float getSubScrollbarPosition() {
        return this.subScrollbarPosition;
    }

    public float getSubScrollbarLength() {
        return this.subScrollbarLength;
    }

    @Override
    public RectangleParameters getRectangleParameters() {
        return null;
    }

    @Override
    public void initializeScreenChangeAnimation() {
    }

    public void setPreviewIcons(SelectionDrawerPreviewIconController selectionDrawerPreviewIconController) {
        this.selectionDrawerPreviewIconController = selectionDrawerPreviewIconController;
    }

    @Override
    protected void mainItemEntriesChanged() {
        if (this.selectionDrawerPreviewIconController == null) {
            return;
        }
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry = this.getFirstItemEntry();
        if (abstractPlaceholderMenuController$PlaceholderItemEntry == null) {
            this.selectionDrawerPreviewIconController.setPreviewIcons(null, Collections.EMPTY_LIST);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.getItemEntryIterator(abstractPlaceholderMenuController$PlaceholderItemEntry, true);
        while (iterator.hasNext()) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = (AbstractPlaceholderMenuController$PlaceholderItemEntry)iterator.next();
            if (!abstractPlaceholderMenuController$PlaceholderItemEntry2.isVisible() || !abstractPlaceholderMenuController$PlaceholderItemEntry2.isEnabled()) continue;
            arrayList.add(abstractPlaceholderMenuController$PlaceholderItemEntry2);
        }
        this.selectionDrawerPreviewIconController.setPreviewIcons(this.selectionCursor.getTargetItemEntry(), arrayList);
    }

    @Override
    protected void textUpdated(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        super.textUpdated(abstractPlaceholderMenuController$PlaceholderItemEntry);
        if (abstractPlaceholderMenuController$PlaceholderItemEntry.equals(this.subSelectionCursor.getTargetItemEntry())) {
            this.subSelectionCursor.invalidateTargetWidth();
        }
        if (abstractPlaceholderMenuController$PlaceholderItemEntry.equals(this.subFocusCursor.getTargetItemEntry())) {
            this.subFocusCursor.invalidateTargetWidth();
        }
        abstractPlaceholderMenuController$PlaceholderItemEntry.cachedText = !abstractPlaceholderMenuController$PlaceholderItemEntry.isSubItem() ? this.renderer.getStringUtility().abbreviateTextEllipsis(abstractPlaceholderMenuController$PlaceholderItemEntry.cachedText, this.getMaxMainListTextWidth(), false) : this.renderer.getStringUtility().abbreviateTextEllipsis(abstractPlaceholderMenuController$PlaceholderItemEntry.cachedText, this.getMaxSubListTextWidth(), false);
    }

    @Override
    public void setDrawerAnimationMask(int n) {
    }

    @Override
    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    @Override
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

    @Override
    public boolean canOpen() {
        return this.findFirstVisibleItemEntry() != null;
    }

    @Override
    public boolean canClose() {
        return true;
    }

    @Override
    public int getDrawerAnimationMask() {
        return this.drawerAnimationMask;
    }

    @Override
    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        float f2;
        if (DrawerAnimationManager$Helper.hasFlag(n, 12)) {
            f2 = fArray[12];
            lc.log(-2137614336, "SelectionMenuController#setDrawerAnimation using screen change progress, screenChangePosition=%1", (double)f2);
        } else {
            f2 = this.screenChangePosition;
            lc.log(-2137614336, "SelectionMenuController#setDrawerAnimation using old screenChangePosition: %1", (double)f2);
        }
        float f3 = fArray[0];
        float f4 = 1.0f - fArray[7];
        this.setDrawerPosition(f3, f4, f2);
        if (!this.isConnected()) {
            this.renderer.inOutPositionChanged();
        }
        if (DrawerAnimationManager$Helper.hasFlag(n, 13)) {
            this.desaturation = fArray[13];
            this.darkening = this.desaturation * -1701209794;
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

    @Override
    public void setTransitionForward(boolean bl) {
    }

    @Override
    public boolean isTransitionForward() {
        return false;
    }

    @Override
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

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
        if (this.isSelectionDrawerKey(keyEvent.getKeyCode()) && this.isSubListOpened() && !this.isSubListClosing()) {
            this.requestLargeViewSizeIfNeeded();
        }
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.isSubListOpened()) {
            this.idleTimer.cancelTimer();
        }
        super.keyTurned(wheelButtonEvent);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (this.isSubListOpened()) {
            this.idleTimer.cancelTimer();
        }
        super.keyPressed(keyEvent);
    }

    @Override
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

    @Override
    public void hideDrawerItem() {
    }

    @Override
    public void setDrawerAnimationType(int n) {
    }

    @Override
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

    @Override
    public void restartIdleTimer() {
    }

    @Override
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

    public void setMainItemEntryForVisibleSublist(AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        this.mainItemEntryForVisibleSublist = abstractPlaceholderMenuController$PlaceholderItemEntry;
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

    @Override
    public String getWidgetName() {
        return this.getClassName();
    }

    @Override
    public void mergeFinished(String string) {
        this.setCompositesDirty(true);
    }

    @Override
    public void triggerGestureEvent(GestureEvent gestureEvent) {
    }

    static /* synthetic */ LogChannel access$000() {
        return lc;
    }

    static /* synthetic */ AbstractPlaceholderMenuController$PlaceholderItemEntry access$102(SelectionMenuController selectionMenuController, AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        selectionMenuController.mainItemEntryForVisibleSublist = abstractPlaceholderMenuController$PlaceholderItemEntry;
        return selectionMenuController.mainItemEntryForVisibleSublist;
    }

    static /* synthetic */ boolean access$202(SelectionMenuController selectionMenuController, boolean bl) {
        selectionMenuController.sublistOpened = bl;
        return selectionMenuController.sublistOpened;
    }

    static /* synthetic */ boolean access$302(SelectionMenuController selectionMenuController, boolean bl) {
        selectionMenuController.sublistClosing = bl;
        return selectionMenuController.sublistClosing;
    }

    static /* synthetic */ SelectionMenuIdleTimerController access$400(SelectionMenuController selectionMenuController) {
        return selectionMenuController.idleTimer;
    }

    static /* synthetic */ void access$500(SelectionMenuController selectionMenuController, AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry) {
        selectionMenuController.clearSubItems(abstractPlaceholderMenuController$PlaceholderItemEntry);
    }

    static /* synthetic */ AbstractAnimation access$700(SelectionMenuController selectionMenuController) {
        return selectionMenuController.subViewportScrollAnimation;
    }

    static {
        if (AbstractWidget.framework != null) {
            lc = logSelectionDrawerController;
        } else {
            lc = null;
            System.err.println("SelectionMenuController: Warning: no framework available");
        }
    }
}

