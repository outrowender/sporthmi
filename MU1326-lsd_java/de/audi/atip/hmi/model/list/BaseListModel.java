/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.ModelException;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.FallbackTiledListModelListener;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.RowMap;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.model.update.ModelUpdateData$Key;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.LongList;
import java.util.ArrayList;
import java.util.List;

public class BaseListModel
extends AbstractModel
implements BaseListModelApp,
TiledListModelGUI {
    private final RowMap map = new RowMap();
    private int length;
    private final ModelGroup eventHistory;
    protected BaseListModelListener listener = FallbackTiledListModelListener.INSTANCE;
    private SelectedItem selectedItem = null;
    protected final String logPrefix;
    private MenuModel menu;
    private ModelUpdateData pendingUpdateData;

    public void setMenu(MenuModel menuModel) {
        this.menu = menuModel;
    }

    public BaseListModel(int n) {
        this(n, null);
    }

    public BaseListModel(int n, MenuModel menuModel) {
        this(n, menuModel, "BaseListModel");
    }

    protected BaseListModel(int n, MenuModel menuModel, String string) {
        this(n, menuModel, null, string);
    }

    private BaseListModel(int n, MenuModel menuModel, ModelGroup modelGroup, String string) {
        super(n);
        this.menu = menuModel == null ? new MenuModel(0) : menuModel;
        this.eventHistory = modelGroup;
        this.logPrefix = new Buffer().append('{').append(n).append("} [").append(string).toString();
        if (!this.isCopy() && menuModel != null) {
            this.menu.registerMenuItem(n, this);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.getLength() == 0;
    }

    @Override
    public int getModelType() {
        return 25;
    }

    @Override
    public void setListener(BaseListModelListener baseListModelListener) {
        this.listener = baseListModelListener != null ? baseListModelListener : FallbackTiledListModelListener.INSTANCE;
    }

    @Override
    public void resetListener() {
        this.listener = FallbackTiledListModelListener.INSTANCE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getMaxColumns() {
        Object object = this.mutex;
        synchronized (object) {
            EvoListRow evoListRow = this.map.getFirstOccupied();
            if (evoListRow == null) {
                return 0;
            }
            return evoListRow.getColumnCount();
        }
    }

    @Override
    public GuiListRow getGuiRow(int n) {
        return this.map.get(n);
    }

    @Override
    public int getIndexForUniqueID(long l) {
        return this.map.getIndex(l);
    }

    @Override
    public boolean contains(long l) {
        return this.map.getIndex(l) != -1;
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4) {
        ModelException modelException = new ModelException((HMIModel)this, "Call not supported by BaseListModel!");
        this.lc.log(10000, "%1.requestItems]", (Object)this.logPrefix, (Throwable)modelException);
    }

    @Override
    public void unrequestItems(int n, int n2, int n3) {
        ModelException modelException = new ModelException((HMIModel)this, "Call not supported by BaseListModel!");
        this.lc.log(10000, "%1.unrequestItems]", (Object)this.logPrefix, (Throwable)modelException);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void itemFocused(long l, int n, int n2) {
        EvoListRow evoListRow;
        int n3;
        Object object = this.mutex;
        synchronized (object) {
            n3 = this.map.getIndex(l);
            evoListRow = this.map.get(n3);
        }
        this.lc.log(-2137614336, "%1.itemFocused] [%3] %2", (Object)this.logPrefix, (Object)evoListRow, (long)n3);
        try {
            this.listener.itemFocused(evoListRow, this.id, n3, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemSelected(long l, int n, int n2) {
        EvoListRow evoListRow;
        int n3;
        Object object = this.mutex;
        synchronized (object) {
            n3 = this.map.getIndex(l);
            evoListRow = this.map.get(n3);
        }
        this.lc.log(-2137614336, "%1.itemSelected] [%3] %2", (Object)this.logPrefix, (Object)evoListRow, (long)n3);
        try {
            this.listener.itemSelected(evoListRow, this.id, n3, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemLongSelected(long l, int n, int n2) {
        EvoListRow evoListRow;
        int n3;
        Object object = this.mutex;
        synchronized (object) {
            n3 = this.map.getIndex(l);
            evoListRow = this.map.get(n3);
        }
        this.lc.log(-2137614336, "%1.itemSelected] [%3] %2", (Object)this.logPrefix, (Object)evoListRow, (long)n3);
        try {
            this.listener.itemLongSelected(evoListRow, this.id, n3, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemReleased(long l, int n, int n2) {
        EvoListRow evoListRow;
        int n3;
        Object object = this.mutex;
        synchronized (object) {
            n3 = this.map.getIndex(l);
            evoListRow = this.map.get(n3);
        }
        this.lc.log(-2137614336, "%1.itemReleased] [%3] %2", (Object)this.logPrefix, (Object)evoListRow, (long)n3);
        try {
            this.listener.itemReleased(evoListRow, this.id, n3, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void trigger(ModelTrigger modelTrigger) {
        this.lc.log(-2137614336, "%1.trigger] %2", (Object)this.logPrefix, (Object)modelTrigger);
        if (this.connected()) {
            this.fireModelUpdateEvent(modelTrigger);
        }
    }

    @Override
    public MenuModelApp getMenu() {
        return this.menu;
    }

    @Override
    public void setLength(int n) {
        this.setLength(n, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setLength(int n, boolean bl) {
        this.lc.log(-2137614336, "%1.setLength] %2", (Object)this.logPrefix, (long)n);
        if (n < 0) {
            throw new ModelException((HMIModel)this, new StringBuffer().append("Invalid length ").append(n).toString());
        }
        Object object = this.mutex;
        synchronized (object) {
            this.length = n;
        }
        if (bl) {
            this.fireModelUpdateEvent(5);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getLength() {
        Object object = this.mutex;
        synchronized (object) {
            return this.length;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public EvoListRow getRow(int n) {
        Object object = this.mutex;
        synchronized (object) {
            EvoListRow evoListRow = this.map.get(n);
            if (evoListRow == null) {
                return null;
            }
            return evoListRow.copy();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public EvoListRow getRowByUniqueID(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.getRow(this.map.getIndex(l));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setRow(int n, EvoListRow evoListRow) {
        this.lc.log(-2137614336, "%1.setRow] [%3] %2", (Object)this.logPrefix, (Object)evoListRow, (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.set(n, evoListRow);
        }
        if (this.connected()) {
            object = ModelUpdateData.obtain(8).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.UNIQUEID, evoListRow.getUniqueID()).put(ModelUpdateData$Key.COUNT, 1);
            this.fireModelUpdateEvent((ModelUpdateData)object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setRowWithoutEvent(int n, EvoListRow evoListRow) {
        this.lc.log(-2137614336, "%1.setRow] [%3] %2", (Object)this.logPrefix, (Object)evoListRow, (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.set(n, evoListRow);
        }
    }

    private void set(int n, EvoListRow evoListRow) {
        if (evoListRow != null) {
            this.map.set(n, evoListRow.copy());
        } else {
            this.map.remove(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setRows(int n, int n2, EvoListRow[] evoListRowArray) {
        Object object;
        boolean bl = evoListRowArray != null && evoListRowArray.length > 0;
        int n3 = bl ? evoListRowArray.length : 0;
        this.lc.log(-2137614336, "%1.setRows] requestID:%2 startIndex:%3", (Object)this.logPrefix, (long)n, (long)n2);
        this.lc.log(-2137614336, "%1.setRows] #rows:%2", (Object)this.logPrefix, (long)n3);
        if (bl) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
                    this.lc.log(14808325, "%1.setRows] [%3] %2", (Object)this.logPrefix, (Object)evoListRowArray[i2], (long)(n2 + i2));
                }
            }
            object = this.mutex;
            synchronized (object) {
                for (int i3 = 0; i3 < evoListRowArray.length; ++i3) {
                    this.set(n2 + i3, evoListRowArray[i3]);
                }
            }
        }
        if (this.connected()) {
            object = ModelUpdateData.obtain(8).put(ModelUpdateData$Key.INDEX, n2).put(ModelUpdateData$Key.REQUESTID, n).put(ModelUpdateData$Key.COUNT, n3);
            if (bl) {
                ((ModelUpdateData)object).put(ModelUpdateData$Key.UNIQUEID, evoListRowArray[0].getUniqueID());
            }
            this.fireModelUpdateEvent((ModelUpdateData)object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setRowsWithoutEvent(int n, int n2, EvoListRow[] evoListRowArray) {
        boolean bl = evoListRowArray != null && evoListRowArray.length > 0;
        int n3 = bl ? evoListRowArray.length : 0;
        this.lc.log(-2137614336, "%1.setRows] requestID:%2 startIndex:%3", (Object)this.logPrefix, (long)n, (long)n2);
        this.lc.log(-2137614336, "%1.setRows] #rows:%2", (Object)this.logPrefix, (long)n3);
        if (bl) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
                    this.lc.log(14808325, "%1.setRows] [%3] %2", (Object)this.logPrefix, (Object)evoListRowArray[i2], (long)(n2 + i2));
                }
            }
            Object object = this.mutex;
            synchronized (object) {
                for (int i3 = 0; i3 < evoListRowArray.length; ++i3) {
                    this.set(n2 + i3, evoListRowArray[i3]);
                }
            }
        }
        if (this.connected()) {
            this.pendingUpdateData = ModelUpdateData.obtain(8).put(ModelUpdateData$Key.INDEX, n2).put(ModelUpdateData$Key.REQUESTID, n).put(ModelUpdateData$Key.COUNT, n3);
            if (bl) {
                this.pendingUpdateData.put(ModelUpdateData$Key.UNIQUEID, evoListRowArray[0].getUniqueID());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clearRows(int n, int n2) {
        this.lc.log(-2137614336, "%1.clearRows] startIndex:%2 length:%3", (Object)this.logPrefix, (long)n, (long)n2);
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.map.remove(n + i2);
            }
        }
        if (this.connected()) {
            object = ModelUpdateData.obtain(20).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.COUNT, n2);
            this.fireModelUpdateEvent((ModelUpdateData)object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clearRow(int n) {
        this.lc.log(-2137614336, "%1.clearRow] index:%2", (Object)this.logPrefix, (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.map.remove(n);
        }
        if (this.connected()) {
            object = ModelUpdateData.obtain(20).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.COUNT, 1);
            this.fireModelUpdateEvent((ModelUpdateData)object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clearAll() {
        this.lc.log(-2137614336, "%1.clearAll]", (Object)this.logPrefix);
        Object object = this.mutex;
        synchronized (object) {
            this.map.clear();
        }
        this.fireModelUpdateEvent(21);
    }

    @Override
    public void remove(EvoListRow evoListRow) {
        if (evoListRow == null) {
            this.lc.log(10000, "%1.remove] Ignored NULL row!", (Object)this.logPrefix);
            return;
        }
        this.remove(evoListRow.getUniqueID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remove(long l) {
        int n;
        this.lc.log(-2137614336, "%1.remove] uniqueID:%2", (Object)this.logPrefix, l);
        Object object = this.mutex;
        synchronized (object) {
            n = this.removeAndShift(l);
        }
        if (n != -1 && this.connected()) {
            object = ModelUpdateData.obtain(9).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.UNIQUEID, l).put(ModelUpdateData$Key.COUNT, 1);
            this.fireModelUpdateEvent((ModelUpdateData)object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeByIndex(int n) {
        if (n == -1) {
            return;
        }
        Object object = this.mutex;
        synchronized (object) {
            EvoListRow evoListRow = this.map.removeAndShift(n);
            if (evoListRow != null) {
                --this.length;
                if (this.connected()) {
                    ModelUpdateData modelUpdateData = ModelUpdateData.obtain(9).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.UNIQUEID, evoListRow.getUniqueID()).put(ModelUpdateData$Key.COUNT, 1);
                    this.fireModelUpdateEvent(modelUpdateData);
                }
            }
        }
    }

    @Override
    public void remove(EvoListRow[] evoListRowArray) {
        if (evoListRowArray == null || evoListRowArray.length == 0) {
            this.lc.log(10000, "%1.remove] Ignored NULL or empty rows array!", (Object)this.logPrefix);
            return;
        }
        long[] lArray = new long[evoListRowArray.length];
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            lArray[i2] = evoListRowArray[i2].getUniqueID();
        }
        this.remove(lArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remove(long[] lArray) {
        ModelUpdateData modelUpdateData;
        this.lc.log(-2137614336, "%1.remove] #rows:%2", (Object)this.logPrefix, (long)lArray.length);
        Object object = this.mutex;
        synchronized (object) {
            modelUpdateData = this.removeAndShift(lArray);
        }
        if (modelUpdateData != null && this.connected()) {
            this.fireModelUpdateEvent(modelUpdateData);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeAndClose(long l, int n) {
        ModelUpdateData modelUpdateData;
        this.lc.log(-2137614336, "%1.removeAndClose] parentUniqueID:%2 length:%3", (Object)this.logPrefix, l, (long)n);
        int n2 = this.map.getIndex(l);
        if (n2 == -1) {
            this.lc.log(-1601830656, "%1.removeAndClose] No row with parentUniqueID:%2 found!", (Object)this.logPrefix, l);
            return;
        }
        int n3 = n2 + 1;
        Object object = this.mutex;
        synchronized (object) {
            LongList longList = new LongList(n);
            for (int i2 = 0; i2 < n; ++i2) {
                EvoListRow evoListRow = this.map.get(n3 + i2);
                if (evoListRow == null) continue;
                longList.add(evoListRow.getUniqueID());
            }
            modelUpdateData = this.removeAndShift(longList.toArray());
        }
        if (modelUpdateData != null && this.connected()) {
            modelUpdateData.put(ModelUpdateData$Key.PARENT_UNIQUEID, l);
            modelUpdateData.put(ModelUpdateData$Key.TRIGGER, ModelTrigger.CLOSE_FOLDER);
            this.fireModelUpdateEvent(modelUpdateData);
        }
    }

    private int removeAndShift(long l) {
        int n = this.map.getIndex(l);
        if (n == -1) {
            return -1;
        }
        EvoListRow evoListRow = this.map.removeAndShift(n);
        if (evoListRow == null) {
            return -1;
        }
        --this.length;
        return n;
    }

    private ModelUpdateData removeAndShift(long[] lArray) {
        this.lc.log(-2137614336, "%1.removeAndShift] #rows:%2", (Object)this.logPrefix, (long)lArray.length);
        int n = -1;
        long l = -1L;
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            int n2 = this.removeAndShift(lArray[i2]);
            if (n != -1 || n2 == -1) continue;
            n = n2;
            l = lArray[i2];
        }
        if (n != -1 && this.connected()) {
            return ModelUpdateData.obtain(9).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.UNIQUEID, l).put(ModelUpdateData$Key.COUNT, lArray.length);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeAll() {
        this.lc.log(-2137614336, "%1.removeAll]", (Object)this.logPrefix);
        Object object = this.mutex;
        synchronized (object) {
            this.map.clear();
            this.length = 0;
        }
        this.fireModelUpdateEvent(6, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setSelectedIndex(int n) {
        this.lc.log(-2137614336, "%1.setSelected] index:%2", (Object)this.logPrefix, (long)n);
        Object object = this.mutex;
        synchronized (object) {
            if (n == -1) {
                this.selectedItem = null;
            } else {
                EvoListRow evoListRow = this.map.get(n);
                if (evoListRow == null) {
                    throw new ModelException((HMIModel)this, new StringBuffer().append("No row found for given index: ").append(n).toString());
                }
                this.selectedItem = new SelectedItem(n, evoListRow.getUniqueID());
            }
        }
        this.fireModelUpdateEvent(22);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean setSelectedUniqueID(long l) {
        int n;
        this.lc.log(-2137614336, "%1.setSelected] uniqueID:%2", (Object)this.logPrefix, l);
        Object object = this.mutex;
        synchronized (object) {
            n = this.map.getIndex(l);
            if (n == -1) {
                return false;
            }
        }
        this.setSelectedIndex(n);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SelectedItem getSelected() {
        Object object = this.mutex;
        synchronized (object) {
            if (!(this.selectedItem == null || this.map.containsIndex(this.selectedItem.getIndex()) && this.map.containsUniqueID(this.selectedItem.getUniqueID()))) {
                this.selectedItem = null;
            }
            return this.selectedItem;
        }
    }

    @Override
    public void insertBefore(long l, EvoListRow evoListRow) {
        if (evoListRow == null) {
            this.lc.log(10000, "%1.insertBefore] uniqueID:%2 Given row is NULL!", (Object)this.logPrefix, l);
            return;
        }
        this.lc.log(-2137614336, "%1.insertBefore] uniqueID:%2", (Object)this.logPrefix, l);
        this.insert(l, new EvoListRow[]{evoListRow}, 0, true);
    }

    @Override
    public void insertAfter(long l, EvoListRow evoListRow) {
        if (evoListRow == null) {
            this.lc.log(10000, "%1.insertAfter] uniqueID:%2 Given row is NULL!", (Object)this.logPrefix, l);
            return;
        }
        this.lc.log(-2137614336, "%1.insertAfter] uniqueID:%2", (Object)this.logPrefix, l);
        this.insert(l, new EvoListRow[]{evoListRow}, 1, true);
    }

    @Override
    public void insertBefore(long l, EvoListRow[] evoListRowArray) {
        this.lc.log(-2137614336, "%1.insertBefore] uniqueID:%2", (Object)this.logPrefix, l);
        this.insert(l, evoListRowArray, 0, true);
    }

    @Override
    public void insertAfter(long l, EvoListRow[] evoListRowArray) {
        this.lc.log(-2137614336, "%1.insertAfter] uniqueID:%2", (Object)this.logPrefix, l);
        this.insert(l, evoListRowArray, 1, true);
    }

    @Override
    public void insertAfterAndOpen(long l, EvoListRow[] evoListRowArray) {
        this.lc.log(-2137614336, "%1.insertAfterAndOpen] parentUniqueID:%2", (Object)this.logPrefix, l);
        int n = this.insert(l, evoListRowArray, 1, false);
        if (this.connected()) {
            ModelUpdateData modelUpdateData = ModelUpdateData.obtain(7).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.UNIQUEID, evoListRowArray[0].getUniqueID()).put(ModelUpdateData$Key.COUNT, evoListRowArray.length).put(ModelUpdateData$Key.PARENT_UNIQUEID, l).put(ModelUpdateData$Key.TRIGGER, ModelTrigger.OPEN_FOLDER);
            this.fireModelUpdateEvent(modelUpdateData);
        }
    }

    @Override
    public void append(EvoListRow evoListRow) {
        if (evoListRow == null) {
            this.lc.log(10000, "%1.append] Given row is NULL!", (Object)this.logPrefix);
            return;
        }
        this.append(new EvoListRow[]{evoListRow});
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void append(EvoListRow[] evoListRowArray) {
        int n;
        if (evoListRowArray == null || evoListRowArray.length == 0) {
            this.lc.log(10000, "%1.add] Given rows array is NULL or empty!", (Object)this.logPrefix);
            return;
        }
        this.lc.log(-2137614336, "%1.append] #%2", (Object)this.logPrefix, (long)evoListRowArray.length);
        Object object = this.mutex;
        synchronized (object) {
            n = this.length;
            for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
                this.map.set(this.length, evoListRowArray[i2].copy());
                ++this.length;
            }
        }
        if (this.connected()) {
            object = ModelUpdateData.obtain(7).put(ModelUpdateData$Key.INDEX, n).put(ModelUpdateData$Key.UNIQUEID, evoListRowArray[0].getUniqueID()).put(ModelUpdateData$Key.COUNT, evoListRowArray.length);
            this.fireModelUpdateEvent((ModelUpdateData)object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List asList() {
        Object object = this.mutex;
        synchronized (object) {
            ArrayList arrayList = new ArrayList(this.length);
            for (int i2 = 0; i2 < this.length; ++i2) {
                EvoListRow evoListRow = this.map.get(i2);
                EvoListRow evoListRow2 = evoListRow != null ? evoListRow.copy() : null;
                arrayList.add(evoListRow2);
            }
            return arrayList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int insert(long l, EvoListRow[] evoListRowArray, int n, boolean bl) {
        if (evoListRowArray == null || evoListRowArray.length == 0) {
            this.lc.log(10000, "%1.insert] uniqueID:%2 Given rows array is NULL or empty!", (Object)this.logPrefix, l);
            return -1;
        }
        int n2 = -1;
        Object object = this.mutex;
        synchronized (object) {
            int n3 = this.map.getIndex(l);
            if (n3 == -1) {
                throw new ModelException((HMIModel)this, new StringBuffer().append("No index found for unique ID ").append(l).toString());
            }
            n2 = n3 + n;
            for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
                this.map.insert(n2 + i2, evoListRowArray[i2].copy());
            }
            this.length += evoListRowArray.length;
        }
        if (this.connected() && bl) {
            object = ModelUpdateData.obtain(7).put(ModelUpdateData$Key.INDEX, n2).put(ModelUpdateData$Key.UNIQUEID, evoListRowArray[0].getUniqueID()).put(ModelUpdateData$Key.COUNT, evoListRowArray.length);
            this.fireModelUpdateEvent((ModelUpdateData)object);
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public BaseListModelApp getCopy() {
        BaseListModel baseListModel = new BaseListModel(this.id, this.menu, new ModelGroup(), "TmpModel");
        Object object = this.mutex;
        synchronized (object) {
            BaseListModel.deepCopy(this, baseListModel);
        }
        return baseListModel;
    }

    @Override
    public BaseListModelApp getEmptyCopy() {
        if (this.eventHistory != null) {
            throw new ModelException((HMIModel)this, "I'm already a TMP model!");
        }
        BaseListModel baseListModel = new BaseListModel(this.id, this.menu, new ModelGroup(), "TmpModel");
        baseListModel.fireModelUpdateEvent(6, 0);
        return baseListModel;
    }

    @Override
    public BaseListModelApp getEmptyCopyWithoutEvents() {
        if (this.eventHistory != null) {
            throw new ModelException((HMIModel)this, "I'm already a TMP model!");
        }
        BaseListModel baseListModel = new BaseListModel(this.id, this.menu, new ModelGroup(), "TmpModel");
        baseListModel.length = this.length;
        return baseListModel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateModelWithPendingEvents(BaseListModelApp baseListModelApp) {
        if (baseListModelApp == null) {
            throw new IllegalArgumentException("Given model is NULL!");
        }
        if (!(baseListModelApp instanceof BaseListModel)) {
            throw new IllegalArgumentException(new StringBuffer().append("Unsupported model type: ").append(super.getClass()).toString());
        }
        if (baseListModelApp.getID() != this.id) {
            throw new IllegalArgumentException("Model ID mismatch!");
        }
        if (baseListModelApp == this) {
            throw new IllegalArgumentException("Can't update model with itself!");
        }
        this.lc.log(-2137614336, "%1.updateModelWithPendingEvents]", (Object)this.logPrefix);
        BaseListModel baseListModel = (BaseListModel)baseListModelApp;
        Object object = this.mutex;
        synchronized (object) {
            BaseListModel.deepCopy(baseListModel, this);
            if (this.pendingUpdateData != null) {
                this.fireModelUpdateEvent(this.pendingUpdateData);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void update(BaseListModelApp baseListModelApp) {
        if (baseListModelApp == null) {
            throw new IllegalArgumentException("Given model is NULL!");
        }
        if (!(baseListModelApp instanceof BaseListModel)) {
            throw new IllegalArgumentException(new StringBuffer().append("Unsupported model type: ").append(super.getClass()).toString());
        }
        if (baseListModelApp.getID() != this.id) {
            throw new IllegalArgumentException("Model ID mismatch!");
        }
        if (baseListModelApp == this) {
            throw new IllegalArgumentException("Can't update model with itself!");
        }
        this.lc.log(-2137614336, "%1.update]", (Object)this.logPrefix);
        BaseListModel baseListModel = (BaseListModel)baseListModelApp;
        Object object = this.mutex;
        synchronized (object) {
            BaseListModel.deepCopy(baseListModel, this);
        }
        if (baseListModel.eventHistory != null) {
            object = baseListModel.eventHistory.packageEventsAndClear();
            if (object != null) {
                this.postEvent(AbstractModelBank.getHMIservice(), (ModelUpdateEvent)object);
            }
        } else {
            this.fireModelUpdateEvent(6, this.getLength());
        }
    }

    @Override
    protected void postEvent(HMIService hMIService, ModelUpdateEvent modelUpdateEvent) {
        this.lc.log(14808325, "%1.postEvent] event:%2", (Object)this.logPrefix, (Object)modelUpdateEvent);
        if (this.eventHistory == null) {
            super.postEvent(hMIService, modelUpdateEvent);
        } else {
            this.eventHistory.addEvent(modelUpdateEvent);
        }
    }

    @Override
    public boolean connected() {
        if (!this.isCopy()) {
            return super.connected() || this.isInUseByConditions();
        }
        return true;
    }

    public boolean isCopy() {
        return this.eventHistory != null;
    }

    private static void deepCopy(BaseListModel baseListModel, BaseListModel baseListModel2) {
        baseListModel2.length = baseListModel.length;
        baseListModel2.selectedItem = baseListModel.selectedItem;
        baseListModel2.pendingUpdateData = baseListModel.pendingUpdateData;
        baseListModel2.map.clear();
        Integer[] integerArray = baseListModel.map.getIndices();
        for (int i2 = 0; i2 < integerArray.length; ++i2) {
            EvoListRow evoListRow = baseListModel.map.get(integerArray[i2]).copy();
            baseListModel2.map.set(integerArray[i2], evoListRow);
        }
    }

    @Override
    public String dumpContent() {
        BaseListModel baseListModel;
        Buffer buffer = new Buffer(1000);
        buffer.append(super.dumpContent());
        buffer.append("\nselectedIndex: ");
        if (null != this.getSelected()) {
            buffer.append(this.getSelected().getIndex());
        }
        if ((baseListModel = (BaseListModel)this.getCopy()) == null) {
            buffer.append("\nlist: null");
        } else {
            int n = baseListModel.getLength();
            buffer.append("\nlist.size(): ");
            buffer.append(n);
            for (int i2 = 0; i2 < n; ++i2) {
                buffer.append("\nlist[");
                buffer.append(i2);
                buffer.append("]: ");
                buffer.append(baseListModel.getRow(i2));
            }
        }
        return buffer.toString();
    }

    @Override
    public void beginTransaction() {
        throw new IllegalStateException("Please use new transaction concept!");
    }

    @Override
    public void endTransaction() {
        throw new IllegalStateException("Please use new transaction concept!");
    }

    @Override
    public void abortTransaction() {
        throw new IllegalStateException("Please use new transaction concept!");
    }
}

