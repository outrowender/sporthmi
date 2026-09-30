/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixModel;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixModelUpdateHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionWidgetRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConversionMatrixController
extends AbstractConversionWidgetController
implements IConversionMatrixModelUpdateHandler {
    private static IConversionMatrixModel isMatrixModelConnected = null;
    private static final int CONST_DEFAULT_PAGE_SIZE = 3;
    public static final float MINIMAL_SCROLLBAR_HANDLE_HEIGHT = 20.0f;
    private ScrollbarController scrollbar;
    private float scrollbarHandlePositionDeltaPerViewportDelta = 0.0f;
    private static final int AMOUNT_OF_ROWS_SCROLLING = 1;
    private final ViewPort viewPort = new ViewPort();
    private IConversionMatrixModel conversionMatrixModel = IConversionMatrixModel.NULL;
    private static final int CURSOR_NO_MOVE = -1;
    private static final int CURSOR_NORTH = 0;
    private static final int CURSOR_SOUTH = 1;
    private static final int CURSOR_LEFT = 2;
    private static final int CURSOR_RIGHT = 3;
    private boolean isModuleColorRefreshNeeded;
    private boolean isFirstTimeVisible = true;

    public ViewPort getViewPort() {
        return this.viewPort;
    }

    public int getScrollBarWidth() {
        if (this.scrollbar == null) {
            return 0;
        }
        return this.scrollbar.getWidth();
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.scrollbar = this.findScrollBar();
    }

    private void initializeScrollbar() {
        if (this.scrollbar == null) {
            return;
        }
        int n = this.getAmountOfRows();
        this.scrollbar.setInterval(this.viewPort.getTopRowIndex(), this.viewPort.getBottomRowIndex(), n, false);
        float f2 = (float)this.scrollbar.getHeight() / (float)n;
        float f3 = 3.0f * f2;
        if (f3 < 20.0f) {
            float f4 = 20.0f - f3;
            f2 -= f4 / (float)n;
            f3 = 20.0f;
        }
        this.scrollbar.setScrollbarHeight(f3);
        this.scrollbarHandlePositionDeltaPerViewportDelta = f2 * 1.0f;
        this.scrollbar.setScrollbarPosition(0.0f);
        this.scrollbar.setVisible(true);
        this.setCompositesDirty(true);
    }

    private int getAmountOfRows() {
        if (this.candidates.isEmpty()) {
            return 0;
        }
        AbstractConversionWidgetController.MultiCharItem multiCharItem = (AbstractConversionWidgetController.MultiCharItem)this.candidates.get(this.candidates.size() - 1);
        return multiCharItem.getRowIndex() + 1;
    }

    protected final void updateScrollbarHandlePosition() {
        if (this.scrollbar == null) {
            return;
        }
        this.scrollbar.setInterval(this.viewPort.getTopRowIndex(), this.viewPort.getBottomRowIndex(), this.getAmountOfRows(), false);
        float f2 = (float)this.viewPort.getDeltaFromTop() * this.scrollbarHandlePositionDeltaPerViewportDelta;
        this.scrollbar.setScrollbarPosition(f2);
    }

    protected ScrollbarController findScrollBar() {
        List list = this.getChildren();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof ScrollbarController)) continue;
            return (ScrollbarController)object;
        }
        tpLogChannelInternal.log(10000, "ConversionMatrixController#initializeWidget: wrong scrollbar attached, not instance of ScrollbarController: %1", (Object)this.scrollbar);
        return null;
    }

    protected void createMultiCharItems(String string, List list) {
        this.candidates.clear();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AbstractConversionWidgetController.MultiCharItem multiCharItem = ConversionMatrixController.createMultiCharItem((String)list.get(i2), i2);
            this.candidates.add(multiCharItem);
        }
    }

    protected void handleCandidateSelect(AbstractConversionWidgetController.ICandidateItem iCandidateItem) {
        if (!(iCandidateItem instanceof AbstractConversionWidgetController.MultiCharItem)) {
            tpLogChannelInternal.log(10000, "ConversionMatrixController#handleCandidateSelect: unkown candidate item type %1", (Object)iCandidateItem);
            return;
        }
        String string = ((AbstractConversionWidgetController.MultiCharItem)iCandidateItem).getChars();
        this.getConversionMatrixModel().setSelected(string, iCandidateItem.getSourceIndex());
    }

    public void setCursorPosition(AbstractConversionWidgetController.MultiCharItem multiCharItem) {
        super.setCursorPosition(multiCharItem);
    }

    public void sourceDataChanged(List list) {
        this.viewPort.reset();
        this.createMultiCharItems(this.getUnconvertedCharacters(), list);
        this.resetInitialItem(false);
        this.layoutMultiCharItems();
        this.viewPort.reset();
        this.initializeScrollbar();
        this.setDataChanged(true);
        this.setCompositesDirty(true);
    }

    private void layoutMultiCharItems() {
        if (!(this.getRenderer() instanceof IConversionWidgetRenderer)) {
            tpLogChannelInternal.log(10000, "ConversionMatrixController#layoutMultiCharItems: renderer was null or had the wrong type: %1 (expected IConversionWidgetRenderer)", (Object)this.getRenderer());
            return;
        }
        IConversionWidgetRenderer iConversionWidgetRenderer = (IConversionWidgetRenderer)this.getRenderer();
        iConversionWidgetRenderer.fillInLayoutData(this.candidates);
    }

    public void candidateSelected(String string) {
        if (this.terminal != null && this.terminal.getPartialPopupManager() != null) {
            this.terminal.getPartialPopupManager().hidePopup(119);
        }
        this.getConversionMatrixModel().setIsActivated(false);
        this.candidates.clear();
    }

    public void keyPressed(KeyEvent keyEvent) {
        this.getConversionMatrixModel().handleMatrixKeyEvent(keyEvent);
        if (keyEvent.getKeyCode() == 15) {
            this.getConversionMatrixModel().setIsActivated(false);
        }
        if (this.getConversionMatrixModel().isActivated() && !keyEvent.isConsumed()) {
            super.keyPressed(keyEvent);
        }
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        int n;
        if (null == this.candidates || this.candidates.isEmpty()) {
            return;
        }
        int n2 = joystickEvent.getDirection();
        switch (n2) {
            case 2: {
                n = 0;
                break;
            }
            case 6: {
                n = 1;
                break;
            }
            case 8: {
                n = 2;
                break;
            }
            case 4: {
                n = 3;
                break;
            }
            default: {
                n = -1;
            }
        }
        if (this.handleCursorMove(n, 1)) {
            joystickEvent.consume(true);
        }
    }

    private boolean handleCursorMove(int n, int n2) {
        if (-1 == n) {
            return false;
        }
        AbstractConversionWidgetController.ICandidateItem iCandidateItem = this.getRequiredFocusedItem(this.currentFocusedItem, n, n2);
        if (null != iCandidateItem) {
            this.moveCursor(iCandidateItem, false);
            this.setCompositesDirty(true);
            this.targetCursorItem = iCandidateItem;
            this.updateScrollbarHandlePosition();
            return true;
        }
        return false;
    }

    private AbstractConversionWidgetController.ICandidateItem getRequiredFocusedItem(AbstractConversionWidgetController.ICandidateItem iCandidateItem, int n, int n2) {
        AbstractConversionWidgetController.ICandidateItem iCandidateItem2 = this.findNewCandidateItem(iCandidateItem, n, n2);
        if (null != iCandidateItem2 && null != this.viewPort) {
            this.viewPort.updateViewPortRowIndex(iCandidateItem2.getRowIndex());
        }
        return iCandidateItem2;
    }

    private AbstractConversionWidgetController.ICandidateItem findNewCandidateItem(AbstractConversionWidgetController.ICandidateItem iCandidateItem, int n, int n2) {
        switch (n) {
            case 0: {
                return this.calculateVerticalMovement(iCandidateItem, n2, true);
            }
            case 1: {
                return this.calculateVerticalMovement(iCandidateItem, n2, false);
            }
            case 2: {
                return this.calculateHorizontalMovement(iCandidateItem, n2, false);
            }
            case 3: {
                return this.calculateHorizontalMovement(iCandidateItem, n2, true);
            }
        }
        tpLogChannelInternal.log(100000, "ConversionMatrixController#findNewCandidateItem: unknown direction %1", (long)n);
        return null;
    }

    private AbstractConversionWidgetController.ICandidateItem calculateHorizontalMovement(AbstractConversionWidgetController.ICandidateItem iCandidateItem, int n, boolean bl) {
        int n2 = bl ? n : -n;
        int n3 = this.candidates.indexOf(iCandidateItem);
        if (n3 >= 0) {
            int n4 = n3 + n2;
            if (n4 >= this.candidates.size()) {
                n4 = this.candidates.size() - 1;
            }
            if (n4 < 0) {
                n4 = 0;
            }
            return (AbstractConversionWidgetController.ICandidateItem)this.candidates.get(n4);
        }
        return null;
    }

    private AbstractConversionWidgetController.ICandidateItem calculateVerticalMovement(AbstractConversionWidgetController.ICandidateItem iCandidateItem, int n, boolean bl) {
        int n2 = -1;
        n2 = bl ? iCandidateItem.getRowIndex() - n : iCandidateItem.getRowIndex() + n;
        return this.filterCandidateItem(n2, iCandidateItem);
    }

    private AbstractConversionWidgetController.ICandidateItem filterCandidateItem(int n, AbstractConversionWidgetController.ICandidateItem iCandidateItem) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.candidates.iterator();
        while (iterator.hasNext()) {
            AbstractConversionWidgetController.ICandidateItem iCandidateItem2 = (AbstractConversionWidgetController.ICandidateItem)iterator.next();
            if (null == iCandidateItem2 || !ConversionMatrixController.isRowMatch(n, iCandidateItem2, arrayList) || !ConversionMatrixController.isColumnMatch(iCandidateItem.getColumnIndex(), iCandidateItem.getColumnSpan(), iCandidateItem2)) continue;
            return iCandidateItem2;
        }
        if (!arrayList.isEmpty()) {
            return (AbstractConversionWidgetController.ICandidateItem)arrayList.get(arrayList.size() - 1);
        }
        return null;
    }

    private static boolean isColumnMatch(int n, int n2, AbstractConversionWidgetController.ICandidateItem iCandidateItem) {
        return n + n2 <= iCandidateItem.getColumnIndex() + iCandidateItem.getColumnSpan();
    }

    private static boolean isRowMatch(int n, AbstractConversionWidgetController.ICandidateItem iCandidateItem, List list) {
        boolean bl;
        boolean bl2 = bl = n == iCandidateItem.getRowIndex();
        if (bl) {
            list.add(iCandidateItem);
        }
        return bl;
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        int n;
        if (null == this.candidates || this.candidates.isEmpty()) {
            return;
        }
        int n2 = wheelButtonEvent.getClickCount();
        if (n2 == 0) {
            return;
        }
        int n3 = wheelButtonEvent.getDirection();
        switch (n3) {
            case 1: {
                n = 2;
                break;
            }
            case 0: {
                n = 3;
                break;
            }
            default: {
                n = -1;
            }
        }
        if (this.handleCursorMove(n, n2)) {
            wheelButtonEvent.consume(true);
        }
        this.updateScrollbarHandlePosition();
    }

    public String getUnconvertedCharacters() {
        return this.getConversionMatrixModel().getUnconvertedCharacters();
    }

    public void disconnecting() {
        if (null != this.viewPort) {
            this.viewPort.reset();
        }
        super.disconnecting();
    }

    public void setConversionMatrixModel(IConversionMatrixModel iConversionMatrixModel) {
        this.conversionMatrixModel = iConversionMatrixModel;
        this.conversionMatrixModel.setUpdateHandler(this);
    }

    protected IConversionMatrixModel getConversionMatrixModel() {
        if (this.conversionMatrixModel == null || this.conversionMatrixModel == IConversionMatrixModel.NULL) {
            tpLogChannelInternal.log(10000, "ConversionMatrixController#getConversionMatrixModel: conversion matrix model is NULL!");
            this.conversionMatrixModel = IConversionMatrixModel.NULL;
        }
        return this.conversionMatrixModel;
    }

    public static void connectConversionMatrixControllerWithModel(IPartialPopupController iPartialPopupController, IConversionMatrixModel iConversionMatrixModel) {
        Object object;
        if (isMatrixModelConnected == iConversionMatrixModel) {
            tpLogChannelInternal.log(1000000, "ConversionMatrixController#connectConversionMatrixControllerWithModel: already connected before.");
            return;
        }
        if (!(iPartialPopupController instanceof AbstractWidget)) {
            tpLogChannelInternal.log(10000, "ConversionMatrixController#connectConversionMatrixControllerWithModel: could not connect conversion matrix with model, popup controller has unkown type.");
            return;
        }
        AbstractWidgetController abstractWidgetController = null;
        Iterator iterator = ((AbstractWidget)((Object)iPartialPopupController)).getChildren().iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            if (!(object instanceof GlassplateController)) continue;
            abstractWidgetController = (GlassplateController)object;
            break;
        }
        if (abstractWidgetController == null) {
            tpLogChannelInternal.log(10000, "ConversionMatrixController#connectConversionMatrixControllerWithModel: could not connect conversion matrix with model, did not find GlassplateController.");
            return;
        }
        iterator = abstractWidgetController.getChildren().iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            if (!(object instanceof ConversionMatrixController)) continue;
            ((ConversionMatrixController)object).setConversionMatrixModel(iConversionMatrixModel);
            return;
        }
        tpLogChannelInternal.log(10000, "ConversionMatrixController#connectConversionMatrixControllerWithModel: could not connect conversion matrix with model, did not find ConversionMatrixController.");
    }

    public boolean isModuleColorRefreshNeeded() {
        return this.isModuleColorRefreshNeeded;
    }

    public void onModuleColorRefreshed() {
        this.isModuleColorRefreshNeeded = false;
    }

    public void onPopupVisibilityChange(boolean bl) {
        if (bl) {
            if (this.isFirstTimeVisible) {
                this.layoutMultiCharItems();
                this.initializeScrollbar();
                this.isFirstTimeVisible = false;
            }
            this.isModuleColorRefreshNeeded = true;
            this.setDataChanged(true);
        } else {
            ConversionMatrixController.releaseCacheUse(this.candidates);
            this.candidates.clear();
        }
        this.getConversionMatrixModel().setIsActivated(bl);
    }

    public class ViewPort {
        private int topRowIndex = -1;
        private int bottomRowIndex = -1;
        private boolean viewPortChanged;
        private List viewPortData = new ArrayList();

        private ViewPort() {
            this.reset();
        }

        private void reset() {
            this.topRowIndex = 0;
            this.bottomRowIndex = 2;
            this.viewPortChanged();
        }

        private int getDeltaFromTop() {
            return this.topRowIndex / 1;
        }

        void updateViewPortRowIndex(int n) {
            if (n < this.topRowIndex) {
                this.topRowIndex = n;
                this.bottomRowIndex = this.topRowIndex + 3 - 1;
                this.viewPortChanged();
            } else if (n > this.bottomRowIndex) {
                this.bottomRowIndex = n;
                this.topRowIndex = this.bottomRowIndex - 3 + 1;
                this.viewPortChanged();
            }
        }

        public int getTopRowIndex() {
            return this.topRowIndex;
        }

        public int getBottomRowIndex() {
            return this.bottomRowIndex;
        }

        public List getCandidates() {
            AbstractConversionWidgetController.ICandidateItem iCandidateItem;
            int n;
            this.viewPortData.clear();
            Iterator iterator = ConversionMatrixController.this.getCandidateIterator();
            while (iterator.hasNext() && (n = (iCandidateItem = (AbstractConversionWidgetController.ICandidateItem)iterator.next()).getRowIndex()) <= this.getBottomRowIndex()) {
                if (n < this.getTopRowIndex()) continue;
                this.viewPortData.add(iCandidateItem);
            }
            return this.viewPortData;
        }

        private void viewPortChanged() {
            ConversionMatrixController.this.setDataChanged(true);
            this.viewPortChanged = true;
        }

        public boolean hasChanged() {
            return this.viewPortChanged;
        }

        public void onChangeRendered() {
            this.viewPortChanged = false;
        }
    }
}

