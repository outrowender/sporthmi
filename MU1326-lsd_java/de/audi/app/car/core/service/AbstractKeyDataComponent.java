/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.atip.interapp.online.MobileKeyStatusDisplayService;
import java.util.Hashtable;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractKeyDataComponent
extends AbstractDSICarVehicleStatesAdapter
implements MobileKeyStatusDisplayService {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile CarViewOption currentViewOptions;
    private static final int KEYDATA_TRANSMITTED;
    private static final int KEYDATA_NOT_TRANSMITTED;
    private static final int MOBILE_KEY_STATUS_SERVICE_DEACTIVATED;
    private static final int MOBILE_KEY_STATUS_NUMBER_AVAILABLE;
    private static final int MOBILE_KEY_STATUS_INFORMATION_NOT_AVAILABLE;
    private static final int MOBILE_KEY_STATUS_DELETION_IN_PROGRESS;
    private CarServiceProvider mobileKeyStatusDisplayServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService;

    public AbstractKeyDataComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.KeyData");
    }

    @Override
    public void init() {
        super.init();
        this.mobileKeyStatusDisplayServiceProvider = new CarServiceProvider((class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService == null ? (class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService = AbstractKeyDataComponent.class$("de.audi.atip.interapp.online.MobileKeyStatusDisplayService")) : class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService).getName(), this, new Hashtable(0), this.getApplication().getBundleContext(), this.getLogChannel());
        this.mobileKeyStatusDisplayServiceProvider.startService();
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(1865550080).setValue(0);
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
        this.getLogChannel().log(1078071040, "updateKeyViewOption(%1), valid:%2", (Object)carViewOption, (long)n);
        if (n == 1) {
            this.currentViewOptions = carViewOption;
            this.updateMenuEntryVisibility(carViewOption);
            this.primaryAttributeFirstSetReceived();
            this.sendContentToSDIS(4, carViewOption);
        }
    }

    @Override
    public void updateKeyData(KeyData keyData, int n) {
        this.getLogChannel().log(-2137614336, "updateKeyData(%1), valid:%2", (Object)keyData, (long)n);
        if (n == 1) {
            if (keyData.getTargetValue() == 0 && keyData.getActualValue() == 0 && keyData.getActiveKey() == 0) {
                this.getChoiceModel(-1574237952).setValue(0);
            } else {
                this.getChoiceModel(-1574237952).setValue(1);
                this.getLabelModel(-1591015168).setText(Integer.toString(keyData.getActualValue()));
                this.sendContentToSDIS(4004, keyData);
            }
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{5}, new int[]{6})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(CarViewOption carViewOption) {
    }

    @Override
    public String getName() {
        return "KeyData";
    }

    @Override
    public void updateBackendState(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        this.getLogChannel().log(1078071040, "AbstractKeyDataComponent#updateBackendState(%1): hmi value: %2", (long)n, (long)n2);
        this.getChoiceModel(1865550080).setValue(n2);
    }

    @Override
    public void updateKeyCount(int n) {
        this.getLogChannel().log(1078071040, "AbstractKeyDataComponent#updateKeyCount(%1)", (long)n);
        this.getLabelModel(1899104512).setText(String.valueOf(n));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

