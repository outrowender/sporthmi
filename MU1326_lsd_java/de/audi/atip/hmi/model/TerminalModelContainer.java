/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.HMIModelBank;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.model.BrowserModel;
import de.audi.atip.hmi.model.BufferedAbstractModel;
import de.audi.atip.hmi.model.BufferedButtonModel;
import de.audi.atip.hmi.model.BufferedChoiceModel;
import de.audi.atip.hmi.model.BufferedDynamicListModel;
import de.audi.atip.hmi.model.BufferedFolderListModel;
import de.audi.atip.hmi.model.BufferedIPSpellerModel;
import de.audi.atip.hmi.model.BufferedLabelModel;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.BufferedMatchspellerModel;
import de.audi.atip.hmi.model.BufferedRangeModel;
import de.audi.atip.hmi.model.BufferedSpellerModel;
import de.audi.atip.hmi.model.BufferedSpellerModelAsia;
import de.audi.atip.hmi.model.BufferedTextfieldModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.DataModel;
import de.audi.atip.hmi.model.DragAndDropListener;
import de.audi.atip.hmi.model.DynamicListModel;
import de.audi.atip.hmi.model.FastScrollingModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.IDragAndDropHandler;
import de.audi.atip.hmi.model.IPSpellerModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.ListModel;
import de.audi.atip.hmi.model.MatchspellerModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.RangeModel2D;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SlidingListModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.SpellerModelAsia;
import de.audi.atip.hmi.model.TextfieldModel;
import de.audi.atip.hmi.model.TooltipModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.TiledListModel;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.metrics.AbstractMetrics;

public class TerminalModelContainer
implements HMIModel {
    private final int modelID;
    private final int modelType;
    private final boolean buffered;
    private final int rows;
    private final AbstractMetrics metric;
    private HMIModel[] terminalModel = new HMIModel[8];
    private int menuModelId = -1;

    public TerminalModelContainer(int n, int n2, boolean bl) {
        this(n, n2, bl, 5);
    }

    public TerminalModelContainer(int n, int n2, boolean bl, int n3) {
        this.modelID = n;
        this.modelType = n2;
        this.buffered = bl;
        this.rows = n3;
        this.metric = null;
    }

    public TerminalModelContainer(int n, int n2, int n3) {
        this.modelID = n;
        this.modelType = n2;
        this.menuModelId = n3;
        this.buffered = false;
        this.rows = 5;
        this.metric = null;
    }

    public TerminalModelContainer(int n, int n2, boolean bl, AbstractMetrics abstractMetrics) {
        this.modelID = n;
        this.modelType = n2;
        this.buffered = bl;
        this.rows = 5;
        this.metric = abstractMetrics;
    }

    public synchronized HMIModel getModel(int n, HMIModelBank hMIModelBank) {
        HMIModel hMIModel;
        try {
            hMIModel = this.terminalModel[n];
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new IllegalArgumentException("illegal terminal ID " + n);
        }
        if (hMIModel == null) {
            hMIModel = this.createModel(hMIModelBank);
            if (hMIModel instanceof AbstractModel) {
                ((AbstractModel)hMIModel).setTerminalID(n);
            } else if (hMIModel instanceof BufferedAbstractModel) {
                ((BufferedAbstractModel)hMIModel).setTerminalID(n);
            }
            this.terminalModel[n] = hMIModel;
        }
        return hMIModel;
    }

    public int getModelID() {
        return this.modelID;
    }

    public int getModelType() {
        return this.modelType;
    }

    private HMIModel createModel(HMIModelBank hMIModelBank) {
        switch (this.modelType) {
            case 18: {
                if (this.buffered) {
                    throw new UnsupportedOperationException("BufferedBrowserModel not supported");
                }
                return new BrowserModel(this.modelID);
            }
            case 1: {
                if (this.buffered) {
                    return new BufferedButtonModel(this.modelID);
                }
                return new ButtonModel(this.modelID);
            }
            case 2: {
                if (this.buffered) {
                    return new BufferedChoiceModel(this.modelID);
                }
                return new ChoiceModel(this.modelID);
            }
            case 11: {
                if (this.buffered) {
                    throw new UnsupportedOperationException("BufferedDataModel not supported");
                }
                return new DataModel(this.modelID);
            }
            case 12: {
                if (this.buffered) {
                    return new BufferedDynamicListModel(this.modelID, this.rows);
                }
                return new DynamicListModel(this.modelID, this.rows);
            }
            case 14: {
                if (this.buffered) {
                    throw new UnsupportedOperationException("BufferedFastScrollingModel not supported");
                }
                return new FastScrollingModel(this.modelID);
            }
            case 19: {
                if (this.buffered) {
                    return new BufferedIPSpellerModel(this.modelID);
                }
                return new IPSpellerModel(this.modelID);
            }
            case 3: {
                if (this.buffered) {
                    return new BufferedLabelModel(this.modelID);
                }
                return new LabelModel(this.modelID);
            }
            case 4: {
                if (this.buffered) {
                    return new BufferedListModel(this.modelID);
                }
                return new ListModel(this.modelID);
            }
            case 7: {
                if (this.buffered) {
                    return new BufferedMatchspellerModel(this.modelID);
                }
                return new MatchspellerModel(this.modelID);
            }
            case 9: {
                if (this.buffered) {
                    throw new UnsupportedOperationException("BufferedMetricsModel not supported");
                }
                if (this.metric == null) {
                    return new MetricsModel(this.modelID);
                }
                return new MetricsModel(this.modelID, this.metric);
            }
            case 5: {
                if (this.buffered) {
                    return new BufferedRangeModel(this.modelID);
                }
                return new RangeModel(this.modelID);
            }
            case 16: {
                if (this.buffered) {
                    throw new UnsupportedOperationException("BufferedRangeModel2D not supported");
                }
                return new RangeModel2D(this.modelID);
            }
            case 22: {
                if (this.buffered) {
                    throw new UnsupportedOperationException("BufferedResourceLocatorModel not supported");
                }
                return new ResourceLocatorModel(this.modelID);
            }
            case 10: {
                if (this.buffered) {
                    throw new UnsupportedOperationException("BufferedSlidingListModel not supported");
                }
                return new SlidingListModel(this.modelID, this.rows);
            }
            case 6: {
                if (this.buffered) {
                    return new BufferedSpellerModel(this.modelID);
                }
                return new SpellerModel(this.modelID);
            }
            case 15: {
                if (this.buffered) {
                    return new BufferedSpellerModelAsia(this.modelID);
                }
                return new SpellerModelAsia(this.modelID);
            }
            case 8: {
                if (this.buffered) {
                    return new BufferedTextfieldModel(this.modelID);
                }
                return new TextfieldModel(this.modelID);
            }
            case 13: {
                if (this.buffered) {
                    throw new UnsupportedOperationException("BufferedTooltipModel not supported");
                }
                return new TooltipModel(this.modelID);
            }
            case 17: {
                if (this.buffered) {
                    throw new UnsupportedOperationException("BufferedVirtualButtonModel not supported");
                }
                return new VirtualButtonModel(this.modelID);
            }
            case 20: {
                return new BufferedFolderListModel(this.modelID);
            }
            case 25: {
                return new BaseListModel(this.modelID, this.getMenuModel(hMIModelBank));
            }
            case 26: {
                return new TiledListModel(this.modelID, this.getMenuModel(hMIModelBank));
            }
            case 27: {
                return new MenuModel(this.modelID);
            }
        }
        throw new UnsupportedOperationException("model type " + this.modelType + " not supported");
    }

    private MenuModel getMenuModel(HMIModelBank hMIModelBank) {
        if (this.menuModelId == -1) {
            return null;
        }
        return (MenuModel)hMIModelBank.getModel(this.menuModelId);
    }

    public void deferredConnected() {
    }

    public boolean isEmpty() {
        return true;
    }

    public int getTerminalID() {
        return -2;
    }

    public void addReference() {
    }

    public int getChangeState() {
        return 0;
    }

    public void removeReference() {
    }

    public String dumpContent() {
        return "";
    }

    public int getHints() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public int getStatus() {
        return 0;
    }

    public void abortTransaction() throws IllegalStateException {
    }

    public void addHint(int n) {
    }

    public void beginTransaction() throws IllegalStateException {
    }

    public void endTransaction() throws IllegalStateException {
    }

    public boolean fireEvent(int n) {
        return false;
    }

    public boolean fireEvent(int n, AdditionalScreenData additionalScreenData) {
        return false;
    }

    public boolean isTransactionRunning() {
        return false;
    }

    public void removeHint(int n) {
    }

    public void resetHints() {
    }

    public void publishHints() {
        throw new UnsupportedOperationException("HMIModelApp#publishHints() not implemented!");
    }

    public void setStatus(int n) {
    }

    public int getID() {
        return this.getModelID();
    }

    public void resetListener() {
    }

    public int startDrag(int n, long l, int n2) {
        return 0;
    }

    public void stopDrag(int n, long l, long l2) {
    }

    public void drop(int n, long l, long l2, int n2, int n3) {
    }

    public void setDragAndDropHandler(IDragAndDropHandler iDragAndDropHandler) {
    }

    public void setDragAndDropListener(DragAndDropListener dragAndDropListener) {
    }

    public void trigger(ModelTrigger modelTrigger, int n) {
    }

    public void setModelGroup(ModelGroup modelGroup) {
    }
}

