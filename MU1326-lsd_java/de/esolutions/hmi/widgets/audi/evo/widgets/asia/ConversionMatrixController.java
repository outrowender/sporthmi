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
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$ICandidateItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$MultiCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionMatrixController$ViewPort;
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
    private static final int CONST_DEFAULT_PAGE_SIZE;
    public static final float MINIMAL_SCROLLBAR_HANDLE_HEIGHT;
    private ScrollbarController scrollbar;
    private float scrollbarHandlePositionDeltaPerViewportDelta = 0.0f;
    private static final int AMOUNT_OF_ROWS_SCROLLING;
    private final ConversionMatrixController$ViewPort viewPort = new ConversionMatrixController$ViewPort(this, null);
    private IConversionMatrixModel conversionMatrixModel = IConversionMatrixModel.NULL;
    private static final int CURSOR_NO_MOVE;
    private static final int CURSOR_NORTH;
    private static final int CURSOR_SOUTH;
    private static final int CURSOR_LEFT;
    private static final int CURSOR_RIGHT;
    private boolean isModuleColorRefreshNeeded;
    private boolean isFirstTimeVisible = true;

    public ConversionMatrixController$ViewPort getViewPort() {
        return this.viewPort;
    }

    public int getScrollBarWidth() {
        if (this.scrollbar == null) {
            return 0;
        }
        return this.scrollbar.getWidth();
    }

    @Override
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
        int n2 = 16448 * f2;
        if (n2 < 41025) {
            int n3 = 41025 - n2;
            f2 -= n3 / (float)n;
            n2 = 41025;
        }
        this.scrollbar.setScrollbarHeight(n2);
        this.scrollbarHandlePositionDeltaPerViewportDelta = f2 * 1.0f;
        this.scrollbar.setScrollbarPosition(0.0f);
        this.scrollbar.setVisible(true);
        this.setCompositesDirty(true);
    }

    private int getAmountOfRows() {
        if (this.candidates.isEmpty()) {
            return 0;
        }
        AbstractConversionWidgetController$MultiCharItem abstractConversionWidgetController$MultiCharItem = (AbstractConversionWidgetController$MultiCharItem)this.candidates.get(this.candidates.size() - 1);
        return abstractConversionWidgetController$MultiCharItem.getRowIndex() + 1;
    }

    protected final void updateScrollbarHandlePosition() {
        if (this.scrollbar == null) {
            return;
        }
        this.scrollbar.setInterval(this.viewPort.getTopRowIndex(), this.viewPort.getBottomRowIndex(), this.getAmountOfRows(), false);
        float f2 = (float)ConversionMatrixController$ViewPort.access$100(this.viewPort) * this.scrollbarHandlePositionDeltaPerViewportDelta;
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

    @Override
    protected void createMultiCharItems(String string, List list) {
        this.candidates.clear();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AbstractConversionWidgetController$MultiCharItem abstractConversionWidgetController$MultiCharItem = ConversionMatrixController.createMultiCharItem((String)list.get(i2), i2);
            this.candidates.add(abstractConversionWidgetController$MultiCharItem);
        }
    }

    @Override
    protected void handleCandidateSelect(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
        if (!(abstractConversionWidgetController$ICandidateItem instanceof AbstractConversionWidgetController$MultiCharItem)) {
            tpLogChannelInternal.log(10000, "ConversionMatrixController#handleCandidateSelect: unkown candidate item type %1", (Object)abstractConversionWidgetController$ICandidateItem);
            return;
        }
        String string = ((AbstractConversionWidgetController$MultiCharItem)abstractConversionWidgetController$ICandidateItem).getChars();
        this.getConversionMatrixModel().setSelected(string, abstractConversionWidgetController$ICandidateItem.getSourceIndex());
    }

    public void setCursorPosition(AbstractConversionWidgetController$MultiCharItem abstractConversionWidgetController$MultiCharItem) {
        super.setCursorPosition(abstractConversionWidgetController$MultiCharItem);
    }

    @Override
    public void sourceDataChanged(List list) {
        ConversionMatrixController$ViewPort.access$200(this.viewPort);
        this.createMultiCharItems(this.getUnconvertedCharacters(), list);
        this.resetInitialItem(false);
        this.layoutMultiCharItems();
        ConversionMatrixController$ViewPort.access$200(this.viewPort);
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

    @Override
    public void candidateSelected(String string) {
        if (this.terminal != null && this.terminal.getPartialPopupManager() != null) {
            this.terminal.getPartialPopupManager().hidePopup(119);
        }
        this.getConversionMatrixModel().setIsActivated(false);
        this.candidates.clear();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.getConversionMatrixModel().handleMatrixKeyEvent(keyEvent);
        if (keyEvent.getKeyCode() == 15) {
            this.getConversionMatrixModel().setIsActivated(false);
        }
        if (this.getConversionMatrixModel().isActivated() && !keyEvent.isConsumed()) {
            super.keyPressed(keyEvent);
        }
    }

    @Override
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
        AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem = this.getRequiredFocusedItem(this.currentFocusedItem, n, n2);
        if (null != abstractConversionWidgetController$ICandidateItem) {
            this.moveCursor(abstractConversionWidgetController$ICandidateItem, false);
            this.setCompositesDirty(true);
            this.targetCursorItem = abstractConversionWidgetController$ICandidateItem;
            this.updateScrollbarHandlePosition();
            return true;
        }
        return false;
    }

    private AbstractConversionWidgetController$ICandidateItem getRequiredFocusedItem(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem, int n, int n2) {
        AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem2 = this.findNewCandidateItem(abstractConversionWidgetController$ICandidateItem, n, n2);
        if (null != abstractConversionWidgetController$ICandidateItem2 && null != this.viewPort) {
            this.viewPort.updateViewPortRowIndex(abstractConversionWidgetController$ICandidateItem2.getRowIndex());
        }
        return abstractConversionWidgetController$ICandidateItem2;
    }

    private AbstractConversionWidgetController$ICandidateItem findNewCandidateItem(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem, int n, int n2) {
        switch (n) {
            case 0: {
                return this.calculateVerticalMovement(abstractConversionWidgetController$ICandidateItem, n2, true);
            }
            case 1: {
                return this.calculateVerticalMovement(abstractConversionWidgetController$ICandidateItem, n2, false);
            }
            case 2: {
                return this.calculateHorizontalMovement(abstractConversionWidgetController$ICandidateItem, n2, false);
            }
            case 3: {
                return this.calculateHorizontalMovement(abstractConversionWidgetController$ICandidateItem, n2, true);
            }
        }
        tpLogChannelInternal.log(-1601830656, "ConversionMatrixController#findNewCandidateItem: unknown direction %1", (long)n);
        return null;
    }

    private AbstractConversionWidgetController$ICandidateItem calculateHorizontalMovement(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem, int n, boolean bl) {
        int n2 = bl ? n : -n;
        int n3 = this.candidates.indexOf(abstractConversionWidgetController$ICandidateItem);
        if (n3 >= 0) {
            int n4 = n3 + n2;
            if (n4 >= this.candidates.size()) {
                n4 = this.candidates.size() - 1;
            }
            if (n4 < 0) {
                n4 = 0;
            }
            return (AbstractConversionWidgetController$ICandidateItem)this.candidates.get(n4);
        }
        return null;
    }

    private AbstractConversionWidgetController$ICandidateItem calculateVerticalMovement(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem, int n, boolean bl) {
        int n2 = -1;
        n2 = bl ? abstractConversionWidgetController$ICandidateItem.getRowIndex() - n : abstractConversionWidgetController$ICandidateItem.getRowIndex() + n;
        return this.filterCandidateItem(n2, abstractConversionWidgetController$ICandidateItem);
    }

    private AbstractConversionWidgetController$ICandidateItem filterCandidateItem(int n, AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.candidates.iterator();
        while (iterator.hasNext()) {
            AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem2 = (AbstractConversionWidgetController$ICandidateItem)iterator.next();
            if (null == abstractConversionWidgetController$ICandidateItem2 || !ConversionMatrixController.isRowMatch(n, abstractConversionWidgetController$ICandidateItem2, arrayList) || !ConversionMatrixController.isColumnMatch(abstractConversionWidgetController$ICandidateItem.getColumnIndex(), abstractConversionWidgetController$ICandidateItem.getColumnSpan(), abstractConversionWidgetController$ICandidateItem2)) continue;
            return abstractConversionWidgetController$ICandidateItem2;
        }
        if (!arrayList.isEmpty()) {
            return (AbstractConversionWidgetController$ICandidateItem)arrayList.get(arrayList.size() - 1);
        }
        return null;
    }

    private static boolean isColumnMatch(int n, int n2, AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
        return n + n2 <= abstractConversionWidgetController$ICandidateItem.getColumnIndex() + abstractConversionWidgetController$ICandidateItem.getColumnSpan();
    }

    private static boolean isRowMatch(int n, AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem, List list) {
        boolean bl;
        boolean bl2 = bl = n == abstractConversionWidgetController$ICandidateItem.getRowIndex();
        if (bl) {
            list.add(abstractConversionWidgetController$ICandidateItem);
        }
        return bl;
    }

    @Override
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

    @Override
    public String getUnconvertedCharacters() {
        return this.getConversionMatrixModel().getUnconvertedCharacters();
    }

    @Override
    public void disconnecting() {
        if (null != this.viewPort) {
            ConversionMatrixController$ViewPort.access$200(this.viewPort);
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
            tpLogChannelInternal.log(1078071040, "ConversionMatrixController#connectConversionMatrixControllerWithModel: already connected before.");
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

    @Override
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
}

