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
    public static final short CODING_ID = 32;
    private static final String LOGCHANNEL_NAME = "App.Car.KeyData";
    private volatile CarViewOption currentViewOptions;
    private static final int KEYDATA_TRANSMITTED = 1;
    private static final int KEYDATA_NOT_TRANSMITTED = 0;
    private static final int MOBILE_KEY_STATUS_SERVICE_DEACTIVATED = 0;
    private static final int MOBILE_KEY_STATUS_NUMBER_AVAILABLE = 1;
    private static final int MOBILE_KEY_STATUS_INFORMATION_NOT_AVAILABLE = 2;
    private static final int MOBILE_KEY_STATUS_DELETION_IN_PROGRESS = 3;
    private CarServiceProvider mobileKeyStatusDisplayServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService;

    public AbstractKeyDataComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    public void init() {
        super.init();
        this.mobileKeyStatusDisplayServiceProvider = new CarServiceProvider((class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService == null ? (class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService = AbstractKeyDataComponent.class$("de.audi.atip.interapp.online.MobileKeyStatusDisplayService")) : class$de$audi$atip$interapp$online$MobileKeyStatusDisplayService).getName(), this, new Hashtable(0), this.getApplication().getBundleContext(), this.getLogChannel());
        this.mobileKeyStatusDisplayServiceProvider.startService();
    }

    protected void initModels() {
        this.getChoiceModel(602735).setValue(0);
    }

    protected void deinitModels() {
    }

    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
        this.getLogChannel().log(1000000, "updateKeyViewOption(%1), valid:%2", (Object)carViewOption, (long)n);
        if (n == 1) {
            this.currentViewOptions = carViewOption;
            this.updateMenuEntryVisibility(carViewOption);
            this.primaryAttributeFirstSetReceived();
            this.sendContentToSDIS(4, carViewOption);
        }
    }

    public void updateKeyData(KeyData keyData, int n) {
        this.getLogChannel().log(10000000, "updateKeyData(%1), valid:%2", (Object)keyData, (long)n);
        if (n == 1) {
            if (keyData.getTargetValue() == 0 && keyData.getActualValue() == 0 && keyData.getActiveKey() == 0) {
                this.getChoiceModel(600994).setValue(0);
            } else {
                this.getChoiceModel(600994).setValue(1);
                this.getLabelModel(600993).setText(Integer.toString(keyData.getActualValue()));
                this.sendContentToSDIS(4004, keyData);
            }
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{5}, new int[]{6})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(CarViewOption var1);

    public String getName() {
        return "KeyData";
    }

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
        this.getLogChannel().log(1000000, "AbstractKeyDataComponent#updateBackendState(%1): hmi value: %2", (long)n, (long)n2);
        this.getChoiceModel(602735).setValue(n2);
    }

    public void updateKeyCount(int n) {
        this.getLogChannel().log(1000000, "AbstractKeyDataComponent#updateKeyCount(%1)", (long)n);
        this.getLabelModel(602737).setText(String.valueOf(n));
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

