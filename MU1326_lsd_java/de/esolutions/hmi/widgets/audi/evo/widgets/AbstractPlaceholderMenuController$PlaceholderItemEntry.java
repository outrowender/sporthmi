/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.view.IWidgetDiagnosis;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$AnimatedFloatProperty;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Cursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$PlaceholderSubItemEntry;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController$Slot;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuItem;
import java.util.ArrayList;
import java.util.List;

public class AbstractPlaceholderMenuController$PlaceholderItemEntry
implements IWidgetDiagnosis {
    protected final PlaceholderMenuItem item;
    private float position;
    private float subPosition;
    private final AbstractPlaceholderMenuController$AnimatedFloatProperty height = new AbstractPlaceholderMenuController$AnimatedFloatProperty(1.0f);
    private AbstractPlaceholderMenuController$Slot slot;
    protected final int itemEntryIndex;
    protected final List subItemEntries = new ArrayList();
    private boolean disconnected;
    protected String cachedText;
    protected Object[] cachedIcons = new Object[4];
    protected int textWidth = 0;
    private final /* synthetic */ AbstractPlaceholderMenuController this$0;

    protected AbstractPlaceholderMenuController$PlaceholderItemEntry(AbstractPlaceholderMenuController abstractPlaceholderMenuController, PlaceholderMenuItem placeholderMenuItem, int n) {
        this.this$0 = abstractPlaceholderMenuController;
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

    public AbstractPlaceholderMenuController$PlaceholderSubItemEntry getLastSubItem() {
        int n = this.subItemEntries.size();
        if (n > 0) {
            return (AbstractPlaceholderMenuController$PlaceholderSubItemEntry)this.subItemEntries.get(n - 1);
        }
        return null;
    }

    public AbstractPlaceholderMenuController$PlaceholderSubItemEntry getFirstSubItem() {
        int n = this.subItemEntries.size();
        if (n > 0) {
            return (AbstractPlaceholderMenuController$PlaceholderSubItemEntry)this.subItemEntries.get(0);
        }
        return null;
    }

    public AbstractPlaceholderMenuController$PlaceholderSubItemEntry getSubItemEntry(int n) {
        if (n < 0 || n >= this.subItemEntries.size()) {
            return null;
        }
        return (AbstractPlaceholderMenuController$PlaceholderSubItemEntry)this.subItemEntries.get(n);
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

    @Override
    public boolean isVisible() {
        return this.item.isVisible();
    }

    public AbstractPlaceholderMenuController$PlaceholderItemEntry getNext() {
        if (this.itemEntryIndex + 1 < this.this$0.itemEntries.size()) {
            return (AbstractPlaceholderMenuController$PlaceholderItemEntry)this.this$0.itemEntries.get(this.itemEntryIndex + 1);
        }
        return null;
    }

    public AbstractPlaceholderMenuController$PlaceholderItemEntry getPrevious() {
        if (this.itemEntryIndex > 0) {
            return (AbstractPlaceholderMenuController$PlaceholderItemEntry)this.this$0.itemEntries.get(this.itemEntryIndex - 1);
        }
        return null;
    }

    public String getLabelText() {
        if (this.cachedText != null) {
            return this.cachedText;
        }
        this.cachedText = this.loadLabelText();
        this.this$0.textUpdated(this);
        this.textWidth = this.this$0.renderer.getStringUtility().getStringWidth(this.cachedText);
        return this.cachedText;
    }

    public int getTextWidth() {
        return this.textWidth;
    }

    @Override
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

    public AbstractPlaceholderMenuController$AnimatedFloatProperty getAnimatedHeight() {
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

    public AbstractPlaceholderMenuController$Slot getSlot() {
        return this.slot;
    }

    public void setSlot(AbstractPlaceholderMenuController$Slot abstractPlaceholderMenuController$Slot) {
        this.slot = abstractPlaceholderMenuController$Slot;
    }

    public boolean isSelected() {
        return this.item.isSelected();
    }

    public boolean isSubItem() {
        return this.item.isSubItem();
    }

    protected void initialize() {
        AbstractPlaceholderMenuController.access$602(this.this$0, 1.0f);
        this.clearCache();
    }

    public AbstractPlaceholderMenuController$PlaceholderItemEntry getSelectedItemEntry() {
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

    public AbstractPlaceholderMenuController$PlaceholderItemEntry getNextIteratedEntry(boolean bl) {
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry;
        AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry2 = abstractPlaceholderMenuController$PlaceholderItemEntry = bl ? this.getNext() : this.getPrevious();
        while (abstractPlaceholderMenuController$PlaceholderItemEntry != null) {
            AbstractPlaceholderMenuController$PlaceholderItemEntry abstractPlaceholderMenuController$PlaceholderItemEntry3 = abstractPlaceholderMenuController$PlaceholderItemEntry.getIterationStart(bl);
            if (abstractPlaceholderMenuController$PlaceholderItemEntry3 != null) {
                return abstractPlaceholderMenuController$PlaceholderItemEntry3;
            }
            abstractPlaceholderMenuController$PlaceholderItemEntry = bl ? abstractPlaceholderMenuController$PlaceholderItemEntry.getNext() : abstractPlaceholderMenuController$PlaceholderItemEntry.getPrevious();
        }
        return null;
    }

    public AbstractPlaceholderMenuController$PlaceholderItemEntry getIterationStart(boolean bl) {
        return this;
    }

    public void clearSubItems() {
        this.subItemEntries.clear();
    }

    @Override
    public String getClassName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n != -1) {
            return string.substring(n + 1);
        }
        return string;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getDepth() {
        return 0;
    }

    @Override
    public String getDiagnosisText() {
        return this.getLabelText();
    }

    @Override
    public String getInternalInfo() {
        return null;
    }

    @Override
    public int[] getBitmapIndices() {
        return new int[0];
    }

    @Override
    public int[] getColorIndices() {
        return new int[0];
    }

    @Override
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

    @Override
    public boolean isActive() {
        return this.item.getWidget().isActive();
    }

    @Override
    public boolean isHighlighted() {
        if (this.isSubItem()) {
            return this.equals(AbstractPlaceholderMenuController$Cursor.access$200(this.this$0.getSubSelectionCursor()));
        }
        return this.equals(AbstractPlaceholderMenuController$Cursor.access$200(this.this$0.selectionCursor));
    }

    @Override
    public boolean isFocused() {
        if (this.isSubItem()) {
            return this.equals(AbstractPlaceholderMenuController$Cursor.access$200(this.this$0.getSubFocusCursor()));
        }
        return this.equals(AbstractPlaceholderMenuController$Cursor.access$200(this.this$0.focusCursor));
    }

    @Override
    public boolean isFunctional() {
        return this.isConnected();
    }

    @Override
    public int getModelID() {
        return this.item.getWidget().getModelID();
    }

    public void initializeSubItems() {
    }

    public int getInternalID() {
        return this.item.getInternalID();
    }
}

