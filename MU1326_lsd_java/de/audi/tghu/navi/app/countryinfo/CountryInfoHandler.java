/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.countryinfo;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.RequestCountryInfoCommand;
import de.audi.tghu.navi.app.command.RequestRoadClassSpeedInfoForCountryCommand;
import de.audi.tghu.navi.app.countryinfo.ICountryInfoHandler;
import de.audi.tghu.navi.app.countryinfo.RoadClassSpeedInfoRow;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public abstract class CountryInfoHandler
implements ICountryInfoHandler {
    public static final int ADDITIONAL_INFO_NOT_AVAILABLE;
    public static final int ADDITIONAL_INFO_AVAILABLE;
    public static final int SPEED_INFO_NOT_AVAILABLE;
    public static final int SPEED_INFO_AVAILABLE;
    public static final int RIGHT_HAND_TRAFFIC_OFF;
    public static final int RIGHT_HAND_TRAFFIC_ON;
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected final IconHandler iconHandler;
    protected LogChannel logChannel;
    protected IVehicle vehicle;

    public CountryInfoHandler(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IconHandler iconHandler, IVehicle iVehicle) {
        this.vehicle = iVehicle;
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.iconHandler = iconHandler;
        this.logChannel = navigationEnv.getLogChannel();
    }

    @Override
    public void startCountryInput(boolean bl) {
        this.startCountryInput(bl, '\u0000');
    }

    @Override
    public abstract void startCountryInput(boolean bl, char c2) {
    }

    @Override
    public void initiateCountry() {
        NavLocation navLocation = this.vehicle.getVehicleCountryLocation();
        this.setCountry(navLocation);
    }

    @Override
    public void setCountry(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "CountryInfoHandler#setCountry( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.setCountry(navLocation, this.commandListFactory.createCommandList());
    }

    @Override
    public void setCountry(NavLocation navLocation, CommandList commandList) {
        this.logChannel.log(-2137614336, "CountryInfoHandler#setCountry( %1, %2 )", (Object)LocationFormatter.formatLocationShort(navLocation), commandList == null ? 0L : (long)commandList.size());
        String string = LocationFormatter.formatCountry(navLocation);
        this.updateCountryTextfield(string);
        if (navLocation != null) {
            String string2 = navLocation.getCountryAbbreviation();
            if (!Util.isEmpty(string2)) {
                this.logChannel.log(-2137614336, "CountryInfoHandler#setCountry() - countryAbbreviation: %1 - postcommands count: %2", (Object)string2, (long)commandList.size());
                CommandList commandList2 = this.commandListFactory.createCommandList();
                commandList2.add(new RequestRoadClassSpeedInfoForCountryCommand(this, string2));
                commandList2.add(new RequestCountryInfoCommand(this, string2));
                commandList2.add(commandList);
                commandList2.execute("CountryInfoHandler#setCountry()");
            } else {
                this.logChannel.log(10000, "CountryInfoHandler#setCountry() - countryAbbreviation not available! ");
            }
        } else {
            this.logChannel.log(10000, "CountryInfoHandler#setCountry() - countryLocation is null! ");
        }
    }

    @Override
    public void updateCountryInfo(CountryInfo countryInfo) {
        if (countryInfo == null) {
            this.logChannel.log(-2137614336, "CountryInfoHandler#updateCountryInfo() - countryInfo is null! ");
            this.updateAdditionalInfoAvailable(false);
            return;
        }
        this.logChannel.log(-2137614336, "CountryInfoHandler#updateCountryInfo() - countryAbbreviation: %1 ", (Object)countryInfo.getCountryAbbreviation());
        this.updateCountryTextfield(countryInfo.getName());
        this.updateCountryAdditionalInfo(countryInfo.getAdditionalIcons(), countryInfo.getAdditionalInfo());
        this.updateRightHandTraffic(countryInfo.isRightHandTraffic());
    }

    @Override
    public void updateRoadClassSpeedInfo(RoadClassSpeedInfo[] roadClassSpeedInfoArray) {
        this.logChannel.log(-2137614336, "CountryInfoHandler#updateRoadClassSpeedInfo() %1 ", (Object)roadClassSpeedInfoArray);
        if (roadClassSpeedInfoArray != null && roadClassSpeedInfoArray.length > 0) {
            this.updateRoadClassSpeedInfoAvailable(true);
            this.updateCountryInfoSpeedUnit(roadClassSpeedInfoArray[0]);
            this.updateEvoSpeedLimitsModel(roadClassSpeedInfoArray, this.env.getListModel(1780286976));
            this.updatePorscheSpeedLimitsModel(roadClassSpeedInfoArray, this.env.getBaseListModel(656541184));
        } else {
            this.updateRoadClassSpeedInfoAvailable(false);
        }
    }

    private void updateEvoSpeedLimitsModel(RoadClassSpeedInfo[] roadClassSpeedInfoArray, ListModelApp listModelApp) {
        this.logChannel.log(-2137614336, "CountryInfoHandler#updateEvoSpeedLimitsModel() - size: %1 ", (long)roadClassSpeedInfoArray.length);
        listModelApp.beginTransaction();
        listModelApp.clear();
        if (listModelApp.getMaxRows() < roadClassSpeedInfoArray.length) {
            listModelApp.setMaxRows(roadClassSpeedInfoArray.length);
        }
        for (int i2 = 0; i2 < roadClassSpeedInfoArray.length; ++i2) {
            this.logChannel.log(-2137614336, "CountryInfoHandler#updateEvoSpeedLimitsModel() - add RoadClassSpeedInfo: %1 ", (Object)roadClassSpeedInfoArray[i2]);
            RoadClassSpeedInfoRow roadClassSpeedInfoRow = new RoadClassSpeedInfoRow(this.iconHandler, roadClassSpeedInfoArray[i2]);
            listModelApp.addRow(roadClassSpeedInfoRow.getCells());
        }
        listModelApp.endTransaction();
    }

    protected void updatePorscheSpeedLimitsModel(RoadClassSpeedInfo[] roadClassSpeedInfoArray, BaseListModelApp baseListModelApp) {
        this.logChannel.log(-2137614336, "CountryInfoHandler#updatePorscheSpeedLimitsModel() - size: %1 ", (long)roadClassSpeedInfoArray.length);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        baseListModelApp2.append(this.getSpeedModelRow(roadClassSpeedInfoArray));
        baseListModelApp.update(baseListModelApp2);
    }

    private EvoListRow getSpeedModelRow(RoadClassSpeedInfo[] roadClassSpeedInfoArray) {
        EvoListRow evoListRow = new EvoListRow(0, 17);
        evoListRow.setInteger(0, roadClassSpeedInfoArray.length);
        for (int i2 = 0; i2 < roadClassSpeedInfoArray.length; ++i2) {
            int n = roadClassSpeedInfoArray[i2].getVariant();
            evoListRow.setHMIResourceLocator(this.column(i2, 1), new HMIResourceLocator(this.iconHandler.resolveRoadClassIconResourceID(roadClassSpeedInfoArray[i2].getRoadClassIconReference(), n)));
            evoListRow.setHMIResourceLocator(this.column(i2, 2), new HMIResourceLocator(this.iconHandler.resolveTrafficRegulationIconResourceID(roadClassSpeedInfoArray[i2].getRoadSignIconReference(), n, 0)));
            evoListRow.setInteger(this.column(i2, 3), RoadClassSpeedInfoRow.convertRoadClass(roadClassSpeedInfoArray[i2].getRoadClassType()));
            evoListRow.setInteger(this.column(i2, 4), RoadClassSpeedInfoRow.convertRecommendedSpeed(roadClassSpeedInfoArray[i2].getRoadClassType()));
        }
        return evoListRow;
    }

    protected int column(int n, int n2) {
        return n * 4 + n2;
    }

    private void updateCountryAdditionalInfo(int[] nArray, String[] stringArray) {
        LabelModelApp labelModelApp;
        this.logChannel.log(1078071040, "CountryInfoHandler#updateCountryAdditionalInfo() ");
        if (stringArray == null || stringArray.length == 0) {
            this.logChannel.log(-2137614336, "CountryInfoHandler#updateCountryAdditionalInfo() - additionalInfo array is null or length is 0");
            this.updateAdditionalInfoAvailable(false);
            return;
        }
        int n = stringArray.length;
        this.logChannel.log(-2137614336, "CountryInfoHandler#updateCountryAdditionalInfo() - additionalInfo array length: %1", (long)n);
        try {
            labelModelApp = this.env.getLabelModel(1713178112);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "CountryInfoHandler#updateCountryAdditionalInfo() - caught ClassCastException: %1", (Throwable)classCastException);
            return;
        }
        Buffer buffer = new Buffer();
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(1428162048);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        for (int i2 = 0; i2 < n; ++i2) {
            if (Util.isEmpty(stringArray[i2])) continue;
            this.logChannel.log(-2137614336, "CountryInfoHandler#updateCountryAdditionalInfo() - add additional info text at index %1", (long)i2);
            buffer.append(stringArray[i2]);
            buffer.append('\n');
            EvoListRow evoListRow = new EvoListRow(i2, 2);
            evoListRow.setText(0, stringArray[i2]);
            evoListRow.setInteger(1, 0);
            baseListModelApp2.append(evoListRow);
        }
        baseListModelApp.update(baseListModelApp2);
        if (buffer.length() != 0) {
            this.logChannel.log(-2137614336, "CountryInfoHandler#updateCountryAdditionalInfo() - additional info text was added");
            labelModelApp.setText(buffer.toString());
            this.updateAdditionalInfoAvailable(true);
        } else {
            this.logChannel.log(-2137614336, "CountryInfoHandler#updateCountryAdditionalInfo() - no additional info text was added");
            this.updateAdditionalInfoAvailable(false);
        }
    }

    private void updateRightHandTraffic(boolean bl) {
        this.logChannel.log(1078071040, "CountryInfoHandler#updateRightHandTraffic() - rightHandTraffic: %1 ", bl);
        int n = bl ? 1 : 0;
        try {
            this.env.getChoiceModel(1763509760).setValue(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "CountryInfoHandler#updateRightHandTraffic() - caught ClassCastException: %1", (Throwable)classCastException);
        }
    }

    private void updateCountryTextfield(String string) {
        this.logChannel.log(1078071040, "CountryInfoHandler#updateCountryTextfield() - countryName: %1 ", (Object)string);
        try {
            this.env.getTextfieldModel(1662846464).setText1(string);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "CountryInfoHandler#updateCountryTextfield() - caught ClassCastException: %1", (Throwable)classCastException);
        }
    }

    public void updateAdditionalInfoAvailable(boolean bl) {
        this.logChannel.log(1078071040, "CountryInfoHandler#updateAdditionalInfoAvailable() - available: %1 ", bl);
        if (!bl) {
            this.env.getBaseListModel(1428162048).removeAll();
        }
        int n = bl ? 1 : 0;
        try {
            this.env.getChoiceModel(1729955328).setValue(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "CountryInfoHandler#updateAdditionalInfoAvailable() - caught ClassCastException: %1", (Throwable)classCastException);
        }
    }

    private void updateRoadClassSpeedInfoAvailable(boolean bl) {
        this.logChannel.log(1078071040, "CountryInfoHandler#updateRoadClassSpeedInfoAvailable() - available: %1 ", bl);
        int n = bl ? 1 : 0;
        try {
            this.env.getChoiceModel(1797064192).setValue(n);
        }
        catch (ClassCastException classCastException) {
            this.logChannel.log(10000, "CountryInfoHandler#updateRoadClassSpeedInfoAvailable() - caught ClassCastException: %1", (Throwable)classCastException);
        }
    }

    private void updateCountryInfoSpeedUnit(RoadClassSpeedInfo roadClassSpeedInfo) {
        if (roadClassSpeedInfo != null) {
            int n = CountryInfoHandler.convertSpeedUnit(roadClassSpeedInfo.getSpeedUnit());
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "CountryInfoHandler#updateCountryInfoSpeedUnit() - speedUnit: %1 ", (long)n);
            }
            this.env.getChoiceModel(-434108928).setValue(n);
        } else {
            this.logChannel.log(10000, "CountryInfoHandler#updateCountryInfoSpeedUnit() - speed info is null! ");
        }
    }

    private static int convertSpeedUnit(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }
}

