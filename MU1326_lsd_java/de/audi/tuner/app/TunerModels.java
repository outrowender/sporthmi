/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.tuner.app.TunerConfiguration;
import de.audi.tuner.app.Utilities;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.List;

public class TunerModels {
    public static final int CHOICE_ON = 0;
    public static final int CHOICE_OFF = 1;
    public static final int CHECKBOX_UNCHECKED = 0;
    public static final int CHECKBOX_CHECKED = 1;
    public static final int CHECKBOX_HALFCHECKED = 128;
    public static final int AUTOSTORE_STATUS_INACTIVE = 0;
    public static final int AUTOSTORE_STATUS_ACTIVE = 1;
    public static final int DATA_UPD_AVAILABLE = 1;
    public static final int DATA_UPD_NOTAVAILABLE = 2;
    public static final int DATA_UPD_WAITING = 3;
    public static final int DATA_UPD_ERROR = 4;
    public static final int STATUS_DISABLED = 0;
    public static final int STATUS_ENABLED = 1;
    public static final int ICON_NO_ICON = 0;
    public static final int ICON_DARKENED = 1;
    public static final int ICON_LIGHTED = 2;
    public static final int ICON_POOR_RECEPTION = 3;
    private final SimpleIntObjectMap internalModels = new SimpleIntObjectMap();
    private final IHMIServiceApp hmiService;
    private final int listChoiceModel = Utilities.isPGen1OrBentley() ? 100327 : 100316;

    TunerModels(IFrameworkAccess iFrameworkAccess) {
        this.hmiService = iFrameworkAccess.getHmiServiceApp();
    }

    void initializeModels() {
        this.getChoiceModel(100354).setStatus(0);
        this.getBaseListModel(100459).setStatus(0);
        this.getChoiceModel(220).setStatus(0);
        this.getLabelModel(100933).setText("");
        this.getLabelModel(100935).setText("");
        this.getLabelModel(100402).setText("");
        this.getChoiceModel(100320).setValue(TunerConfiguration.isAMDoubleTuner() ? 1 : 0);
        this.getChoiceModel(100357).setValue(TunerConfiguration.isDABDoubleTuner() ? 1 : 0);
    }

    public int getActiveTuner() {
        return this.getChoiceModel(100327).getValue();
    }

    public void setActiveTuner(int n) {
        this.getChoiceModel(100327).setValue(n);
    }

    public int getActiveList() {
        return this.getChoiceModel(this.listChoiceModel).getValue();
    }

    public void setActiveList(int n) {
        this.getChoiceModel(this.listChoiceModel).setValue(n);
    }

    public void setModelStatus(int n, int n2) {
        HMIModelApp hMIModelApp = this.hmiService.getModelApp(n);
        if (hMIModelApp.getStatus() != n2) {
            hMIModelApp.setStatus(n2);
        }
    }

    public BaseListModelApp getInternalBaseListModel(int n) {
        BaseListModelApp baseListModelApp = (BaseListModelApp)this.internalModels.get(n);
        if (baseListModelApp == null) {
            baseListModelApp = new BaseListModel(n);
            this.internalModels.add(n, baseListModelApp);
        }
        return baseListModelApp;
    }

    public HMIModelApp getModel(int n) {
        return this.hmiService.getModelApp(n);
    }

    HMIModelApp getModel(int n, int n2) {
        return this.hmiService.getModelApp(n, n2);
    }

    public ChoiceModelApp getChoiceModel(int n, int n2) {
        return this.hmiService.getChoiceModel(n, n2);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return this.hmiService.getChoiceModel(n);
    }

    public ButtonModelApp getButtonModel(int n) {
        return this.hmiService.getButtonModel(n);
    }

    public OptionModelApp getOptionModel(int n) {
        return this.hmiService.getOptionModel(n);
    }

    public VirtualButtonModelApp getVirtualButtonModel(int n) {
        return this.hmiService.getVirtualButtonModel(n);
    }

    public LabelModelApp getLabelModel(int n) {
        return this.hmiService.getLabelModel(n);
    }

    public LabelModelApp getLabelModel(int n, int n2) {
        return this.hmiService.getLabelModel(n, n2);
    }

    public BaseListModelApp getBaseListModel(int n) {
        return this.hmiService.getBaseListModel(n);
    }

    public ListModelApp getListModel(int n) throws IllegalArgumentException {
        return (ListModelApp)this.getModel(n);
    }

    public RangeModelApp getRangeModel(int n) {
        return this.hmiService.getRangeModel(n);
    }

    public SpellerModelApp getSpellerModel(int n) {
        return this.hmiService.getSpellerModel(n);
    }

    public MatchspellerModelApp getMatchspellerModel(int n) {
        return this.hmiService.getMatchSpellerModel(n);
    }

    public MenuModelApp getMenuModel(int n) {
        return this.hmiService.getMenuModel(n);
    }

    public ResourceLocatorModelApp getResourceLocatorModel(int n) {
        return this.hmiService.getResourceLocatorModel(n);
    }

    public ResourceLocatorModelApp getResourceLocatorModel(int n, int n2) {
        return this.hmiService.getResourceLocatorModel(n, n2);
    }

    public void setChoiceDataUpdateMediator(int n, int n2) {
        switch (n2) {
            case 3: {
                this.getChoiceModel(n).setStatus(0);
                this.getChoiceModel(n).setValue(-1);
                break;
            }
            case 1: {
                this.getChoiceModel(n).setValue(1);
                this.getChoiceModel(n).setStatus(1);
                break;
            }
            case 2: {
                this.getChoiceModel(n).setValue(-1);
                this.getChoiceModel(n).setStatus(1);
                break;
            }
            case 4: {
                this.getChoiceModel(n).setStatus(2);
                this.getChoiceModel(n).setValue(-1);
                break;
            }
        }
    }

    public boolean isDataUpdateMediatorAvailable(int n) {
        return this.getChoiceModel(n).getStatus() == 1 && this.getChoiceModel(n).getValue() >= 0;
    }

    public boolean isDataUpdateMediatorNotAvailable(int n) {
        return this.getChoiceModel(n).getStatus() == 1 && this.getChoiceModel(n).getValue() < 0;
    }

    public boolean isDataUpdateMediatorWaiting(int n) {
        return this.getChoiceModel(n).getStatus() == 0;
    }

    public static int booleanToCheckboxConstant(boolean bl) {
        return bl ? 1 : 0;
    }

    public static boolean checkboxConstantToBoolean(int n) {
        return n == 1;
    }

    public List getAvailableLists() {
        ArrayList arrayList = new ArrayList(10);
        if (this.getBaseListModel(100467).getLength() > 0) {
            arrayList.add(new Integer(12));
        }
        if (this.getBaseListModel(100466).getLength() > 0) {
            arrayList.add(new Integer(13));
        }
        if (this.getChoiceModel(100305).getValue() == 1) {
            arrayList.add(new Integer(11));
        }
        if (this.getChoiceModel(100354).getValue() == 1) {
            arrayList.add(new Integer(5));
        }
        if (this.getChoiceModel(220).getValue() == 1) {
            arrayList.add(new Integer(7));
        }
        if (this.getChoiceModel(100387).getValue() == 1) {
            arrayList.add(new Integer(1));
        }
        if (this.getChoiceModel(100319).getValue() == 1) {
            arrayList.add(new Integer(4));
        }
        return arrayList;
    }

    public static int getListSelectionIndex(BaseListModelApp baseListModelApp) {
        SelectedItem selectedItem = baseListModelApp.getSelected();
        return selectedItem != null ? selectedItem.getIndex() : -1;
    }
}

