/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ReusableInstanceCache;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractConversionWidgetController
extends AbstractWidgetController {
    protected static final ReusableInstanceCache MULTI_CHAR_ITEM_CACHE = new ReusableInstanceCache(AbstractConversionWidgetController.createMultiCharItemFactory());
    protected final List candidates = new ArrayList();
    private IRenderer renderer;
    protected ICandidateItem currentFocusedItem;
    protected ICandidateItem targetCursorItem;
    private boolean dataChanged = false;
    private boolean sizeChanged = false;

    protected final void resetInitialItem(boolean bl) {
        if (this.candidates.isEmpty()) {
            spellerLogChannel.log(100000, "[AbstractConversionWidgetController#resetInitialItem] Could not find a valid item for the initial focus.");
            this.currentFocusedItem = null;
        } else {
            this.currentFocusedItem = bl ? ConversionLineController.OPEN_MATRIX_POPUP_BUTTON_ITEM : this.getFirstFocusableItem();
        }
        this.targetCursorItem = this.currentFocusedItem;
    }

    protected ICandidateItem getFirstFocusableItem() {
        return (ICandidateItem)this.candidates.get(0);
    }

    public int getMarginRight() {
        return 0;
    }

    protected abstract void createMultiCharItems(String var1, List var2);

    public void disconnecting() {
        this.candidates.clear();
        super.disconnecting();
    }

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

    private void handlePressItem(ICandidateItem iCandidateItem) {
        if (iCandidateItem.isEnabled()) {
            this.handleCandidateSelect(iCandidateItem);
        } else {
            spellerLogChannel.log(10000000, "[AbstractConversionWidgetController#handlePressItem] Ignore press on disabled item %1.", (Object)iCandidateItem);
        }
    }

    protected abstract void handleCandidateSelect(ICandidateItem var1);

    protected void moveCursor(ICandidateItem iCandidateItem, boolean bl) {
        if (iCandidateItem == null || iCandidateItem == this.currentFocusedItem) {
            return;
        }
        if (!bl) {
            this.setCursorPosition(iCandidateItem);
            return;
        }
    }

    protected final void setCursorPosition(ICandidateItem iCandidateItem) {
        this.currentFocusedItem = iCandidateItem;
        this.setCompositesDirty(true);
    }

    public final void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public final IRenderer getRenderer() {
        return this.renderer;
    }

    public abstract String getUnconvertedCharacters();

    public final Iterator getCandidateIterator() {
        return this.candidates.iterator();
    }

    public final ICandidateItem getCurrentFocus() {
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

    private static ReusableInstanceCache.AbstractInstanceFactory createMultiCharItemFactory() {
        return new ReusableInstanceCache.AbstractInstanceFactory(){

            public ReusableInstanceCache.IReusable newInstance(String string) {
                if (!string.equals("ConversionLineController.MultiCharItem")) {
                    IWidgetLogChannel.tpLogChannelInternal.log(100000, "ConversionLineController#IInstanceFactory.newInstance: unkown type key '%1'. Returning a MultiCharItem.", (Object)string);
                }
                return new MultiCharItem();
            }
        };
    }

    protected static MultiCharItem createMultiCharItem(String string, int n) {
        if (string == null) {
            return null;
        }
        MultiCharItem multiCharItem = (MultiCharItem)MULTI_CHAR_ITEM_CACHE.getOrCreateInstance("ConversionLineController.MultiCharItem");
        multiCharItem.setChars(string);
        multiCharItem.setSourceIndex(n);
        return multiCharItem;
    }

    protected static final void releaseCacheUse(List list) {
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            ICandidateItem iCandidateItem = (ICandidateItem)list.get(i2);
            if (!(iCandidateItem instanceof MultiCharItem)) continue;
            MULTI_CHAR_ITEM_CACHE.collect(iCandidateItem);
        }
    }

    public static final class MultiCharItem
    extends AbstractCandidateItem
    implements ICharacterItem {
        public static final String TYPE_KEY = "ConversionLineController.MultiCharItem";
        private String characters;
        private String abbreviatedCharacters;

        public MultiCharItem() {
            this.reset();
        }

        public MultiCharItem(String string) {
            this.characters = string;
        }

        public String getTypeKey() {
            return TYPE_KEY;
        }

        public void reset() {
            super.reset();
            this.characters = "";
            this.abbreviatedCharacters = "";
        }

        public void setChars(String string) {
            this.characters = string;
            this.setColumnSpan(this.characters.length());
        }

        public String getChars() {
            return this.characters;
        }

        public String toString() {
            return new Buffer("MultiCharItem[").append("chars='").append(this.characters).append("'; col=").append(this.getColumnIndex()).append("; row=").append(this.getRowIndex()).append("; colSpan=").append(this.getColumnSpan()).append("]").toString();
        }

        public String getAbbreviatedCharacters() {
            return this.abbreviatedCharacters;
        }

        public void setAbbreviatedCharacters(String string) {
            this.abbreviatedCharacters = string;
        }
    }

    public static interface ICandidateItem
    extends ReusableInstanceCache.IReusable {
        public boolean isEnabled();

        public void setEnabled(boolean var1);

        public int getRowIndex();

        public void setRowIndex(int var1);

        public int getColumnIndex();

        public void setColumnIndex(int var1);

        public int getColumnSpan();

        public void setColumnSpan(int var1);

        public int getId();

        public void setSourceIndex(int var1);

        public int getSourceIndex();

        public void setWidth(float var1);

        public float getWidth();
    }

    public static interface ICharacterItem
    extends ICandidateItem {
        public void setChars(String var1);

        public String getChars();

        public void setAbbreviatedCharacters(String var1);

        public String getAbbreviatedCharacters();
    }

    protected static abstract class AbstractCandidateItem
    implements ICandidateItem {
        private static int instanceCounter = 0;
        private final int id = ++instanceCounter;
        private int rowIndex;
        private int columnIndex;
        private boolean enabled;
        private int columnSpan;
        private int sourceIndex;
        private float width;

        public AbstractCandidateItem() {
            this.reset();
        }

        public void reset() {
            this.rowIndex = 0;
            this.columnIndex = 0;
            this.enabled = true;
            this.columnSpan = 1;
            this.width = -1.0f;
        }

        public void setEnabled(boolean bl) {
            this.enabled = bl;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public int getRowIndex() {
            return this.rowIndex;
        }

        public void setRowIndex(int n) {
            this.rowIndex = n;
        }

        public int getColumnIndex() {
            return this.columnIndex;
        }

        public void setColumnIndex(int n) {
            this.columnIndex = n;
        }

        public int getColumnSpan() {
            return this.columnSpan;
        }

        public void setColumnSpan(int n) {
            this.columnSpan = n;
        }

        public int getId() {
            return this.id;
        }

        public void setSourceIndex(int n) {
            this.sourceIndex = n;
        }

        public int getSourceIndex() {
            return this.sourceIndex;
        }

        public float getWidth() {
            return this.width;
        }

        public void setWidth(float f2) {
            this.width = f2;
        }

        public String toString() {
            return new Buffer("CandidateItem[").append("col=").append(this.getColumnIndex()).append("; row=").append(this.getRowIndex()).append("; colSpan=").append(this.getColumnSpan()).append("]").toString();
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + this.columnIndex;
            n = 31 * n + this.columnSpan;
            n = 31 * n + (this.enabled ? 1231 : 1237);
            n = 31 * n + this.id;
            n = 31 * n + this.rowIndex;
            n = 31 * n + this.sourceIndex;
            n = 31 * n + Float.floatToIntBits(this.width);
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (!(object instanceof AbstractCandidateItem)) {
                return false;
            }
            AbstractCandidateItem abstractCandidateItem = (AbstractCandidateItem)object;
            if (this.columnIndex != abstractCandidateItem.columnIndex) {
                return false;
            }
            if (this.columnSpan != abstractCandidateItem.columnSpan) {
                return false;
            }
            if (this.enabled != abstractCandidateItem.enabled) {
                return false;
            }
            if (this.id != abstractCandidateItem.id) {
                return false;
            }
            if (this.rowIndex != abstractCandidateItem.rowIndex) {
                return false;
            }
            if (this.sourceIndex != abstractCandidateItem.sourceIndex) {
                return false;
            }
            return Float.floatToIntBits(this.width) == Float.floatToIntBits(abstractCandidateItem.width);
        }
    }
}

