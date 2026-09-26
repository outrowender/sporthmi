/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache$AbstractInstanceFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$ICandidateItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$MultiCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractConversionWidgetController
extends AbstractWidgetController {
    protected static final ReusableInstanceCache MULTI_CHAR_ITEM_CACHE = new ReusableInstanceCache(AbstractConversionWidgetController.createMultiCharItemFactory());
    protected final List candidates = new ArrayList();
    private IRenderer renderer;
    protected AbstractConversionWidgetController$ICandidateItem currentFocusedItem;
    protected AbstractConversionWidgetController$ICandidateItem targetCursorItem;
    private boolean dataChanged = false;
    private boolean sizeChanged = false;

    protected final void resetInitialItem(boolean bl) {
        if (this.candidates.isEmpty()) {
            spellerLogChannel.log(-1601830656, "[AbstractConversionWidgetController#resetInitialItem] Could not find a valid item for the initial focus.");
            this.currentFocusedItem = null;
        } else {
            this.currentFocusedItem = bl ? ConversionLineController.OPEN_MATRIX_POPUP_BUTTON_ITEM : this.getFirstFocusableItem();
        }
        this.targetCursorItem = this.currentFocusedItem;
    }

    protected AbstractConversionWidgetController$ICandidateItem getFirstFocusableItem() {
        return (AbstractConversionWidgetController$ICandidateItem)this.candidates.get(0);
    }

    public int getMarginRight() {
        return 0;
    }

    protected abstract void createMultiCharItems(String string, List list) {
    }

    @Override
    public void disconnecting() {
        this.candidates.clear();
        super.disconnecting();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (this.candidates.size() < 1) {
            return;
        }
        if (keyEvent.getKeyCode() == 17) {
            this.handlePressItem(this.targetCursorItem);
            keyEvent.consume(true);
        }
        super.keyPressed(keyEvent);
    }

    private void handlePressItem(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
        if (abstractConversionWidgetController$ICandidateItem.isEnabled()) {
            this.handleCandidateSelect(abstractConversionWidgetController$ICandidateItem);
        } else {
            spellerLogChannel.log(-2137614336, "[AbstractConversionWidgetController#handlePressItem] Ignore press on disabled item %1.", (Object)abstractConversionWidgetController$ICandidateItem);
        }
    }

    protected abstract void handleCandidateSelect(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
    }

    protected void moveCursor(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem, boolean bl) {
        if (abstractConversionWidgetController$ICandidateItem == null || abstractConversionWidgetController$ICandidateItem == this.currentFocusedItem) {
            return;
        }
        if (!bl) {
            this.setCursorPosition(abstractConversionWidgetController$ICandidateItem);
            return;
        }
    }

    protected final void setCursorPosition(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
        this.currentFocusedItem = abstractConversionWidgetController$ICandidateItem;
        this.setCompositesDirty(true);
    }

    public final void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    @Override
    public final IRenderer getRenderer() {
        return this.renderer;
    }

    public abstract String getUnconvertedCharacters() {
    }

    public final Iterator getCandidateIterator() {
        return this.candidates.iterator();
    }

    public final AbstractConversionWidgetController$ICandidateItem getCurrentFocus() {
        return this.currentFocusedItem;
    }

    public final boolean isDataChanged() {
        return this.dataChanged;
    }

    public final void setDataChanged(boolean bl) {
        this.dataChanged = bl;
    }

    public final int getCandidatesSize() {
        return this.candidates.size();
    }

    public boolean isSizeChanged() {
        return this.sizeChanged;
    }

    public void setSizeChanged(boolean bl) {
        this.sizeChanged = bl;
        this.setCompositesDirty(true);
    }

    private static ReusableInstanceCache$AbstractInstanceFactory createMultiCharItemFactory() {
        return new AbstractConversionWidgetController$1();
    }

    protected static AbstractConversionWidgetController$MultiCharItem createMultiCharItem(String string, int n) {
        if (string == null) {
            return null;
        }
        AbstractConversionWidgetController$MultiCharItem abstractConversionWidgetController$MultiCharItem = (AbstractConversionWidgetController$MultiCharItem)MULTI_CHAR_ITEM_CACHE.getOrCreateInstance("ConversionLineController.MultiCharItem");
        abstractConversionWidgetController$MultiCharItem.setChars(string);
        abstractConversionWidgetController$MultiCharItem.setSourceIndex(n);
        return abstractConversionWidgetController$MultiCharItem;
    }

    protected static final void releaseCacheUse(List list) {
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem = (AbstractConversionWidgetController$ICandidateItem)list.get(i2);
            if (!(abstractConversionWidgetController$ICandidateItem instanceof AbstractConversionWidgetController$MultiCharItem)) continue;
            MULTI_CHAR_ITEM_CACHE.collect(abstractConversionWidgetController$ICandidateItem);
        }
    }
}

