/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.source;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.evo.source.SourceListRow;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.IMultipleSourceSlotListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SourceListHMIHandler
extends AbstractMediaTerminalComponent
implements IActiveSourceListener,
IMultipleSourceSlotListener,
BaseListModelListener {
    private static final int NO_SELECTION = -1;
    private static final String LOGCLASS = "SourceListHMIHandler";
    private static final int UNIQUE_ID_TYPE_MULTIPLIER = 100;
    private static final int[] SOURCE_ORDERING = new int[]{6, 0, 2, 5, 1, 3, 10, 9, 11, 12, 7, 8, 13};
    private static final Map SOURCETYPEORDERMAP = new HashMap(SOURCE_ORDERING.length);
    private final Object mutex = new Object();
    private volatile BaseListModelApp sourceListModel;
    private ISourceSlot currentActiveSlot;
    private volatile ISourceSlot chargingSlot;

    public SourceListHMIHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.hmi().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.sourceListModel = this.getBaseListModel(200448);
        this.sourceListModel.setListener(this);
        this.getTerminal().getSourceController().addSlotListener(this);
        this.getTerminal().getSourceController().addActiveSourceListener(this);
    }

    public void deinit() {
        this.logger.hmi().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.sourceListModel.resetListener();
    }

    private void selectSlot(ISourceSlot iSourceSlot, BaseListModelApp baseListModelApp) {
        this.logger.hmi().log(1000000, "[%1.selectSlot] '%2'", (Object)LOGCLASS, (Object)iSourceSlot);
        if (iSourceSlot == null) {
            baseListModelApp.setSelectedIndex(-1);
            return;
        }
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            SourceListRow sourceListRow = (SourceListRow)baseListModelApp.getRow(i2);
            if (sourceListRow.getSourceType() != iSourceSlot.getSource().getType() || sourceListRow.getSlotIdx() != iSourceSlot.getIndex() && sourceListRow.getSlotIdx() != -1) continue;
            if (sourceListRow.getSlotIdx() == -1) {
                this.logger.hmi().log(1000000, "[%1.selectSlot] Row found (complete source)", (Object)LOGCLASS);
                baseListModelApp.setRow(i2, this.createRow(iSourceSlot));
            } else {
                this.logger.hmi().log(1000000, "[%1.selectSlot] Row found.", (Object)LOGCLASS);
            }
            baseListModelApp.setSelectedIndex(i2);
            return;
        }
        this.logger.hmi().log(1000000, "[%1.selectSlot] Row not found.", (Object)LOGCLASS, (Object)iSourceSlot);
        baseListModelApp.setSelectedIndex(-1);
    }

    private void unSelectSlot(ISourceSlot iSourceSlot, BaseListModelApp baseListModelApp) {
        this.logger.hmi().log(1000000, "[%1.unSelectSlot] '%2'", (Object)LOGCLASS, (Object)iSourceSlot);
        if (iSourceSlot == null) {
            return;
        }
        ISource iSource = iSourceSlot.getSource();
        if (!iSourceSlot.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            SourceListRow sourceListRow = (SourceListRow)baseListModelApp.getRow(i2);
            if (sourceListRow.getSourceType() != iSource.getType() || sourceListRow.getSlotIdx() != iSourceSlot.getIndex()) continue;
            if (iSource.isEmpty()) {
                this.logger.hmi().log(1000000, "[%1.unSelectSlot] [%2] Complete empty.", (Object)LOGCLASS, (Object)iSource);
                baseListModelApp.setRow(i2, this.createRow(iSource.getType(), -1, -1, iSource.getSlot(0).getError()));
                break;
            }
            this.logger.hmi().log(1000000, "[%1.unSelectSlot] [%2] Remove row '%3'", (Object)LOGCLASS, (Object)iSource, (long)i2);
            baseListModelApp.remove(sourceListRow);
            break;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        this.logger.hmi().log(1000000, "[%1.activeSourceChanged] '%2' (change='%3')", (Object)LOGCLASS, (Object)activeSourceState, (Object)bl);
        Object object = this.mutex;
        synchronized (object) {
            if (null == this.currentActiveSlot || bl || 10 == this.currentActiveSlot.getSource().getType()) {
                boolean bl2;
                Object object2;
                BaseListModelApp baseListModelApp = this.sourceListModel.getCopy();
                if (this.currentActiveSlot != null) {
                    this.unSelectSlot(this.currentActiveSlot.getSource().getSlot(this.currentActiveSlot), baseListModelApp);
                }
                this.selectSlot(activeSourceState.getSlot(), baseListModelApp);
                this.sourceListModel.update(baseListModelApp);
                this.currentActiveSlot = activeSourceState.getSlot();
                IActivationContext iActivationContext = this.getTerminal().getSourceController().getActivationContext();
                Object object3 = object2 = iActivationContext != null ? iActivationContext.getParameter("CLOSE_DRAWER") : null;
                if (object2 instanceof Boolean && (bl2 = ((Boolean)object2).booleanValue())) {
                    this.logger.hmi().log(1000000, "[%1.activeSourceChanged] Source changed on combi. Close selection context.", (Object)LOGCLASS);
                    this.closeSelectionDrawer(this.currentActiveSlot);
                }
            }
        }
    }

    public void sourceDeactivated() {
    }

    private boolean isActiveSourceSlot(ISourceSlot iSourceSlot) {
        return ((Object)iSourceSlot).equals(this.currentActiveSlot);
    }

    private int getLastActiveSlotIndex(ISource iSource) {
        if (this.currentActiveSlot == null) {
            return -1;
        }
        if (iSource.equals(this.currentActiveSlot.getSource())) {
            return this.currentActiveSlot.getIndex();
        }
        return -1;
    }

    private int getLastActiveDeviceIndex(ISource iSource) {
        if (this.currentActiveSlot == null) {
            return -1;
        }
        if (iSource.equals(this.currentActiveSlot.getSource())) {
            return this.currentActiveSlot.getDeviceIndex();
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    public void slotsChanged(ISource[] var1_1) {
        this.logger.hmi().log(1000000, "[%1.slotsChanged] Generate list rows.", (Object)"SourceListHMIHandler");
        var2_2 = new HashMap(var1_1.length);
        var3_3 = this.mutex;
        synchronized (var3_3) lbl-1000:
        // 2 sources

        {
            for (var4_4 = 0; var4_4 < var1_1.length; ++var4_4) {
                block28: {
                    var5_6 = var1_1[var4_4];
                    if (!SourceListHMIHandler.isSourceListSource(var5_6)) {
                        this.logger.hmi().log(1000000, "[%1.slotsChanged] [%2] Not visible.", (Object)"SourceListHMIHandler", (Object)var5_6);
                        continue;
                    }
                    var6_8 = new ArrayList(var5_6.getSlots().size());
                    var2_2.put(Integers.valueOf(var5_6.getType()), var6_8);
                    if (var5_6.isEmpty()) break block28;
                    var7_10 = var5_6.getSlots();
                    for (var8_12 = 0; var8_12 < var7_10.size(); ++var8_12) {
                        var9_13 = (ISourceSlot)var7_10.get(var8_12);
                        if (var9_13 == null) {
                            this.logger.hmi().log(100000, "[%1.slotsChanged] [%2][%3] Slot is null.", (Object)"SourceListHMIHandler", (Object)var5_6, (long)var8_12);
                            continue;
                        }
                        if (24 == var9_13.getError()) {
                            this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2][%3] ERROR Charging.", (Object)"SourceListHMIHandler", (Object)var5_6, (long)var8_12);
                            if (this.chargingSlot == null || this.chargingSlot.getSource().getType() != var9_13.getSource().getType() && this.chargingSlot.getIndex() != var9_13.getIndex()) {
                                this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2][%3] ERROR Charging slot set.", (Object)"SourceListHMIHandler", (Object)var5_6, (long)var8_12);
                                var10_16 = this.getChoiceModel(200752);
                                var10_16.setValue(var10_16.getValue() == 1 ? 2 : 1);
                                this.chargingSlot = var9_13;
                            }
                        } else if (this.chargingSlot != null && this.chargingSlot.getSource().getType() == var9_13.getSource().getType() && this.chargingSlot.getIndex() == var9_13.getIndex()) {
                            this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2][%3] Reset charging slot.", (Object)"SourceListHMIHandler", (Object)var5_6, (long)var8_12);
                            this.chargingSlot = null;
                        }
                        if (var9_13.isEmpty() && !this.isActiveSourceSlot(var9_13)) {
                            this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2][%3] Empty, not active.", (Object)"SourceListHMIHandler", (Object)var5_6, (long)var8_12);
                            continue;
                        }
                        this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2][%3] Create row.", (Object)"SourceListHMIHandler", (Object)var5_6, (long)var8_12);
                        var6_8.add(this.createRow(var9_13));
                    }
                    ** GOTO lbl-1000
                }
                if (this.chargingSlot != null && this.chargingSlot.getSource().getType() == var5_6.getType()) {
                    this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2] Reset charging slot.", (Object)"SourceListHMIHandler", (Object)var5_6);
                    this.chargingSlot = null;
                }
                if (var5_6.getSlots().size() > 0) {
                    var7_11 = this.getLastActiveSlotIndex(var5_6);
                    var8_12 = var5_6.getSlot(0).getError();
                    if (var7_11 == -1) {
                        this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2] Empty.", (Object)"SourceListHMIHandler", (Object)var5_6);
                        var6_8.add(this.createRow(var5_6.getType(), -1, this.getLastActiveDeviceIndex(var5_6), var8_12));
                        continue;
                    }
                    this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2] Empty, but active.", (Object)"SourceListHMIHandler", (Object)var5_6);
                    var9_14 = this.getLastActiveDeviceIndex(var5_6);
                    if (10 == var5_6.getType()) {
                        var6_8.add(this.createRow(var5_6.getType(), -1, var9_14, var8_12));
                        continue;
                    }
                    var6_8.add(this.createRow(var5_6.getType(), var7_11, var9_14, var8_12));
                    continue;
                }
                this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2] No slots.", (Object)"SourceListHMIHandler", (Object)var5_6);
            }
            this.logger.hmi().log(1000000, "[%1.slotChanged] Update list model.", (Object)"SourceListHMIHandler");
            var4_5 = this.sourceListModel.getCopy();
            try {
                for (var5_7 = 0; var5_7 < SourceListHMIHandler.SOURCE_ORDERING.length; ++var5_7) {
                    var6_9 = SourceListHMIHandler.SOURCE_ORDERING[var5_7];
                    var7_10 = (List)var2_2.get(Integers.valueOf(var6_9));
                    if (var7_10 == null) continue;
                    this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2] orderID='%3',rows='%4'", (Object)"SourceListHMIHandler", (Object)LogUtil.getSourceTypeStr(var6_9), (Object)Integers.valueOf(var5_7), (Object)Integers.valueOf(var7_10.size()));
                    var8_12 = this.getUpdatePos(var5_7, var4_5);
                    var9_15 = var7_10.iterator();
                    while (var9_15.hasNext()) {
                        var10_16 = (SourceListRow)var9_15.next();
                        var11_17 = (SourceListRow)var4_5.getRow(var8_12);
                        if (var11_17 == null) {
                            this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2] Add new row at '%3'", (Object)"SourceListHMIHandler", (Object)LogUtil.getSourceTypeStr(var6_9), (long)var8_12);
                            var4_5.append((EvoListRow)var10_16);
                        } else if (var10_16.getOrderKey() == var11_17.getOrderKey()) {
                            this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2] Update existing row at '%3'", (Object)"SourceListHMIHandler", (Object)LogUtil.getSourceTypeStr(var6_9), (long)var8_12);
                            var4_5.setRow(var8_12, (EvoListRow)var10_16);
                        } else {
                            this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2] Insert row at '%3'", (Object)"SourceListHMIHandler", (Object)LogUtil.getSourceTypeStr(var6_9), (long)var8_12);
                            var4_5.insertBefore(var11_17.getUniqueID(), (EvoListRow)var10_16);
                        }
                        ++var8_12;
                    }
                    while ((var9_15 = (SourceListRow)var4_5.getRow(var8_12)) != null && var9_15.getOrderKey() == var5_7) {
                        this.logger.hmi().log(100000000, "[%1.slotsChanged] [%2] Remove row at '%3'", (Object)"SourceListHMIHandler", (Object)LogUtil.getSourceTypeStr(var6_9), (long)var8_12);
                        var4_5.removeByIndex(var8_12);
                        ++var8_12;
                    }
                }
                if (this.currentActiveSlot != null) {
                    this.currentActiveSlot = this.currentActiveSlot.getSource().getSlot(this.currentActiveSlot.getIndex());
                }
                this.selectSlot(this.currentActiveSlot, var4_5);
            }
            finally {
                this.sourceListModel.update(var4_5);
            }
        }
    }

    private static boolean isSourceListSource(ISource iSource) {
        return SOURCETYPEORDERMAP.get(Integers.valueOf(iSource.getType())) != null;
    }

    private boolean isImportDisabled() {
        return !this.getTerminal().getConfiguration().isImportEnabled() && !this.getTerminal().getConfiguration().isRippingEnabled();
    }

    private int getUpdatePos(int n, BaseListModelApp baseListModelApp) {
        if (baseListModelApp.getLength() == 0) {
            this.logger.hmi().log(10000000, "[%1.getUpdatePos] List is empty", (Object)LOGCLASS);
            return 0;
        }
        int n2 = -1;
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            SourceListRow sourceListRow = (SourceListRow)baseListModelApp.getRow(i2);
            if (n2 == sourceListRow.getOrderKey()) continue;
            n2 = sourceListRow.getOrderKey();
            if (sourceListRow.getOrderKey() == n) {
                this.logger.hmi().log(10000000, "[%1.getUpdatePos] Same category found at '%2'", (Object)LOGCLASS, (long)i2);
                return i2;
            }
            if (sourceListRow.getOrderKey() <= n) continue;
            this.logger.hmi().log(10000000, "[%1.getUpdatePos] Next category found at '%2'", (Object)LOGCLASS, (long)i2);
            return i2;
        }
        this.logger.hmi().log(10000000, "[%1.getUpdatePos] End of list reached", (Object)LOGCLASS);
        return baseListModelApp.getLength();
    }

    private static int getOrderID(int n) {
        return (Integer)SOURCETYPEORDERMAP.get(Integers.valueOf(n));
    }

    private SourceListRow createRow(int n, int n2, int n3, int n4) {
        int n5 = n * 100 + n2;
        SourceListRow sourceListRow = new SourceListRow(n5, SourceListHMIHandler.getOrderID(n), n, n2, n3, this.isImportDisabled(), n4);
        this.logger.hmi().log(1000000, "[%1.createRow]  %2", (Object)LOGCLASS, (Object)sourceListRow);
        return sourceListRow;
    }

    private SourceListRow createRow(ISourceSlot iSourceSlot) {
        int n = iSourceSlot.getSource().getType() * 100 + iSourceSlot.getIndex();
        SourceListRow sourceListRow = new SourceListRow(n, SourceListHMIHandler.getOrderID(iSourceSlot.getSource().getType()), iSourceSlot, this.isImportDisabled());
        this.logger.hmi().log(1000000, "[%1.createRow]  %2", (Object)LOGCLASS, (Object)sourceListRow);
        return sourceListRow;
    }

    boolean isSelectionDrawerClosed(ISourceSlot iSourceSlot) {
        boolean bl;
        int n = iSourceSlot.getSource().getType();
        switch (n) {
            case 9: {
                bl = true;
                break;
            }
            case 13: {
                int n2 = iSourceSlot.getError();
                if (n2 != 0) {
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 11: 
            case 12: {
                MediaCapabilities mediaCapabilities = iSourceSlot.getCapabilities();
                if (null != mediaCapabilities && mediaCapabilities.isListHandling()) {
                    bl = false;
                    break;
                }
                bl = true;
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                int n3 = iSourceSlot.getContentType();
                if (n3 == 0 || n3 == 2) {
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    public void closeSelectionDrawer(ISourceSlot iSourceSlot) {
        if (this.isSelectionDrawerClosed(iSourceSlot)) {
            this.sourceListModel.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
        }
    }

    public void itemSelected(EvoListRow evoListRow, final int n, int n2, int n3, final int n4) {
        if (!(evoListRow instanceof SourceListRow)) {
            this.logger.hmi().log(10000, "[%1.itemSelected] row != SourceListRow", (Object)LOGCLASS);
            this.getModel(n).fireEvent(n4);
            return;
        }
        this.logger.hmi().log(1000000, "[%1.itemSelected] %2','%3'", (Object)LOGCLASS, (long)n, (long)n2);
        final SourceListRow sourceListRow = (SourceListRow)evoListRow;
        this.logger.hmi().log(1000000, "[%1.itemSelected] '%2','%3'", (Object)LOGCLASS, (Object)LogUtil.getSourceTypeStr(sourceListRow.getSourceType()), (long)sourceListRow.getSlotIdx());
        if (!sourceListRow.isEnabled()) {
            this.logger.hmi().log(1000000, "[%1.itemSelected] Disabled.", (Object)LOGCLASS);
            return;
        }
        this.getBaseListModel(200597).setSelectedIndex(-1);
        this.logger.hmi().log(1000000, "[%1.itemSelected] Activate source.", (Object)LOGCLASS);
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("SourceListHMIHandler.activateSource"){

            public void run() {
                ISourceSlot iSourceSlot = SourceListHMIHandler.this.getTerminal().getSourceController().getSelectedSlot();
                if (iSourceSlot != null && iSourceSlot.getSource().getType() == 4) {
                    SourceListHMIHandler.this.logger.hmi().log(1000000, "[%1.itemSelected] FilePlayer currently active. Ingore.", (Object)SourceListHMIHandler.LOGCLASS);
                    SourceListHMIHandler.this.getModel(n).fireEvent(n4);
                    return;
                }
                ISource iSource = SourceListHMIHandler.this.getTerminal().getSourceController().getSource(sourceListRow.getSourceType());
                ISourceSlot iSourceSlot2 = iSource.getSlot(sourceListRow.getSlotIdx());
                SourceListHMIHandler.this.getTerminal().getSourceController().activateSource(new ActivationContext(iSourceSlot2));
                SourceListHMIHandler.this.closeSelectionDrawer(iSourceSlot2);
                SourceListHMIHandler.this.getModel(n).fireEvent(n4);
            }
        });
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    static {
        for (int i2 = 0; i2 < SOURCE_ORDERING.length; ++i2) {
            SOURCETYPEORDERMAP.put(Integers.valueOf(SOURCE_ORDERING[i2]), Integers.valueOf(i2));
        }
    }
}

