/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListModel;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.TooltipListener;
import de.audi.atip.hmi.modelaccess.AbstractListModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.TooltipModelApp;
import de.audi.atip.hmi.modelaccess.TooltipModelGUI;

public class TooltipModel
extends ListModel
implements TooltipModelApp,
TooltipModelGUI {
    private volatile TooltipListener listener = DUMMY_LISTENER;

    public TooltipModel(int n) {
        super(n);
    }

    public TooltipModel(int n, int n2) {
        super(n, n2);
    }

    public int getModelType() {
        return 13;
    }

    public void setListener(TooltipListener tooltipListener) {
        this.listener = tooltipListener != null ? tooltipListener : DUMMY_LISTENER;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setData(ListRow[] listRowArray) {
        if (listRowArray == null || listRowArray.length == 0) {
            return;
        }
        Object object = this.mutex;
        synchronized (object) {
            this.clear();
            for (int i2 = 0; i2 < listRowArray.length; ++i2) {
                this.addRow(listRowArray[i2].cells);
            }
        }
        super.fireModelUpdateEvent(12, 0, 0);
    }

    public void updateData(int n, int n2, ListCell listCell) {
        this.setCell(n, n2, listCell);
        super.fireModelUpdateEvent(10, n, n2);
    }

    public void requestTooltipData(HMIModelGUI hMIModelGUI, int n, boolean bl, int n2) {
        switch (hMIModelGUI.getModelType()) {
            case 4: {
                try {
                    this.listener.tooltipDataRequested(this.id, hMIModelGUI.getID(), n, bl, n2);
                }
                catch (Exception exception) {
                    this.handleListenerException(exception);
                }
                break;
            }
            case 10: 
            case 12: {
                ListRow listRow = ((AbstractListModelApp)((Object)hMIModelGUI)).getVisibleRow(n);
                if (listRow != null) {
                    try {
                        this.listener.tooltipDataRequested(this.id, hMIModelGUI.getID(), listRow, bl, n2);
                    }
                    catch (Exception exception) {
                        this.handleListenerException(exception);
                    }
                    break;
                }
                this.lc.log(10000, "(%1) TooltipModel.requestTooltipData() Row %2 not found in Dynamic/SlidingListModel %3 ", (long)this.id, (long)n, (long)hMIModelGUI.getID());
                break;
            }
            default: {
                this.lc.log(10000, "(%1) TooltipModel.requestTooltipData() Unknown model type %2 ", (long)this.id, (long)hMIModelGUI.getModelType());
            }
        }
    }

    public void tooltipVisible(HMIModelGUI hMIModelGUI, int n) {
        try {
            this.listener.tooltipVisible(this.id, hMIModelGUI.getID(), n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void tooltipHidden(HMIModelGUI hMIModelGUI, boolean bl, int n) {
        if (bl) {
            this.clear();
        }
        try {
            this.listener.tooltipHidden(this.id, hMIModelGUI.getID(), n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void fireModelUpdateEvent(int n) {
    }

    public void fireModelUpdateEvent(int n, int n2, int n3) {
    }

    public void fireModelUpdateEvent(int n, int n2) {
    }
}

