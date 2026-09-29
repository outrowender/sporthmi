/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.settings;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carparkingsystem.PDCSound;

public final class ParkingSettingsConstant {
    private final String name;
    private final int modelID;
    private final int dsiAttribute;
    private final int[] selectableOptions;
    private final String[] optionNames;
    private final String modelName;
    public static final int PDC_VOLUME_QUIET;
    public static final int PDC_VOLUME_MEDIUM;
    public static final int PDC_VOLUME_MEDIUM_PGEN2;
    public static final int PDC_VOLUME_LOUD;
    public static final ParkingSettingsConstant VOLUMEFRONT;
    public static final ParkingSettingsConstant VOLUMEREAR;
    public static final ParkingSettingsConstant VOLUME_PGEN2;
    public static final ParkingSettingsConstant VPSDEFAULTVIEW;

    private ParkingSettingsConstant(String string, int n, String string2, int n2, int[] nArray, String[] stringArray) {
        this.name = string;
        this.modelID = n;
        this.modelName = string2;
        this.dsiAttribute = n2;
        this.selectableOptions = nArray;
        this.optionNames = stringArray;
    }

    public int getModelID() {
        return this.modelID;
    }

    public String getName() {
        return this.name;
    }

    public int getDsiAttribute() {
        return this.dsiAttribute;
    }

    public int[] getSelectableOptions() {
        return this.selectableOptions;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String[] getOptionNames() {
        return this.optionNames;
    }

    public void setModelValue(ChoiceModelApp choiceModelApp, int n, LogChannel logChannel) {
        for (int i2 = 0; i2 < this.getSelectableOptions().length; ++i2) {
            if (this.getSelectableOptions()[i2] != n) continue;
            if (logChannel.isInfo()) {
                logChannel.log(1078071040, "[ParkingSettingsConstant('%1')#setModelValue] HMI EarlyApps model='%2', value='%3', meaning of value='%4'", (Object)this.getName(), (Object)this.getModelName(), (Object)new Integer(i2), (Object)this.getOptionNames()[i2]);
            }
            choiceModelApp.setValue(i2);
            return;
        }
    }

    public void setPDCSoundVolume(ChoiceModelApp choiceModelApp, PDCSound pDCSound, LogChannel logChannel) {
        this.setModelValue(choiceModelApp, pDCSound.getVolume(), logChannel);
    }

    static {
        VOLUMEFRONT = new ParkingSettingsConstant("VOLUMEFRONT", -1073012736, "PARKING_SETTINGS_VOLUME_FRONT_CHOICE", 55, new int[]{1, 4, 9}, new String[]{"quiet", "medium", "loud"});
        VOLUMEREAR = new ParkingSettingsConstant("VOLUMEREAR", -1056235520, "PARKING_SETTINGS_VOLUME_REAR_CHOICE", 56, new int[]{1, 4, 9}, new String[]{"quiet", "medium", "loud"});
        VOLUME_PGEN2 = new ParkingSettingsConstant("VOLUMEBOTH", -1073012736, "PARKING_SETTINGS_VOLUME_FRONT_CHOICE", 55, new int[]{1, 5, 9}, new String[]{"quiet", "medium", "loud"});
        VPSDEFAULTVIEW = new ParkingSettingsConstant("VPSDEFAULTVIEW", -1156898816, "PARKING_SWITCHING_FRONT_REAR_CHOICE", 22, new int[]{1, 5}, new String[]{"off", "on"});
    }
}

