/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent$MassageProgram;
import de.audi.app.earlyfunc.core.seat.SeatPopinConfigurationHandler;
import de.audi.atip.log.LogChannel;
import java.lang.reflect.Field;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public class SeatPopinSettingsHandler {
    private final LogChannel logChannel;
    private final SeatPopinConfigurationHandler config;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$MassageData;

    public SeatPopinSettingsHandler(LogChannel logChannel, SeatPopinConfigurationHandler seatPopinConfigurationHandler) {
        this.logChannel = logChannel;
        this.config = seatPopinConfigurationHandler;
    }

    public void updateSeatMassageData1RL(MassageData massageData) {
        this.updateSeatMassageData(true, this.getMassageDataField(massageData, "program"), this.getMassageDataField(massageData, "intensity"));
    }

    public void updateSeatMassageData1RR(MassageData massageData) {
        this.updateSeatMassageData(false, this.getMassageDataField(massageData, "program"), this.getMassageDataField(massageData, "intensity"));
    }

    private int getMassageDataField(MassageData massageData, String string) {
        int n = 0;
        Class clazz = class$org$dsi$ifc$carseat$MassageData == null ? (class$org$dsi$ifc$carseat$MassageData = SeatPopinSettingsHandler.class$("org.dsi.ifc.carseat.MassageData")) : class$org$dsi$ifc$carseat$MassageData;
        try {
            Field field = clazz.getDeclaredField(string);
            Object object = field.get(massageData);
            if (object instanceof Integer) {
                n = (Integer)object;
            } else if (object instanceof Short) {
                n = ((Short)object).intValue();
            } else {
                this.logChannel.log(10000, "Field not found in the MassageData : '%1'", (Object)string);
            }
        }
        catch (SecurityException securityException) {
            this.logChannel.log(10000, "Exception in getMassageDataField(MassageData massageDataField, String name), for params: (%1, %2); Exception: %3", (Object)massageData, (Object)string, (Object)securityException);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            this.logChannel.log(10000, "Exception in getMassageDataField(MassageData massageDataField, String name), for params: (%1, %2); Exception: %3", (Object)massageData, (Object)string, (Object)noSuchFieldException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.logChannel.log(10000, "Exception in getMassageDataField(MassageData massageDataField, String name), for params: (%1, %2); Exception: %3", (Object)massageData, (Object)string, (Object)illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            this.logChannel.log(10000, "Exception in getMassageDataField(MassageData massageDataField, String name), for params: (%1, %2); Exception: %3", (Object)massageData, (Object)string, (Object)illegalAccessException);
        }
        return n;
    }

    private void updateSeatMassageData(boolean bl, int n, int n2) {
        MasterSeatPopinContent$MassageProgram masterSeatPopinContent$MassageProgram = MasterSeatPopinContent$MassageProgram.getMassageProgramForID(n);
        if (!this.config.isMassageProgramSelectable(bl, n)) {
            this.logChannel.log(-1601830656, "[SeatPopinSettingsHandler#updateSeatMassageData] %1('%2') on %3-side not supported: MASSAGE_PROGRAM_NONE will be selected", (Object)masterSeatPopinContent$MassageProgram, (Object)new Integer(n), (Object)(bl ? "left" : "right"), (long)n);
            masterSeatPopinContent$MassageProgram = MasterSeatPopinContent$MassageProgram.MASSAGE_PROGRAM_NONE;
            n2 = 0;
        }
        this.config.getSeatPopinModel(bl).selectMassageProgram(masterSeatPopinContent$MassageProgram, n2);
    }

    public void updateSeatSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown) {
        this.setSwitcherData(true, true, switcherDataUpDown);
    }

    public void updateSeatSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown) {
        this.setSwitcherData(false, true, switcherDataUpDown);
    }

    public void updateSeatSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown) {
        this.setSwitcherData(true, false, switcherDataUpDown);
    }

    public void updateSeatSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown) {
        this.setSwitcherData(false, false, switcherDataUpDown);
    }

    public void updateSeatSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward) {
        this.setSwitcherData(true, true, switcherDataBackForward);
    }

    public void updateSeatSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward) {
        this.setSwitcherData(false, true, switcherDataBackForward);
    }

    public void updateSeatSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward) {
        this.setSwitcherData(true, false, switcherDataBackForward);
    }

    public void updateSeatSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward) {
        this.setSwitcherData(false, false, switcherDataBackForward);
    }

    private void setSwitcherData(boolean bl, boolean bl2, SwitcherDataBackForward switcherDataBackForward) {
        int n;
        int n2 = n = bl2 ? 2 : 3;
        if (this.config.isLehnenwangenAvailable(bl)) {
            if (switcherDataBackForward.isLehnenwangen()) {
                this.config.getSeatPopinModel(bl).setArrowHighlighting(n, MasterSeatPopinContent.SEITENWANGEN);
            } else {
                this.config.getSeatPopinModel(bl).removeArrowHighlighting(n, MasterSeatPopinContent.SEITENWANGEN);
            }
        }
        if (this.config.isLehnenkopfAvailable(bl)) {
            if (switcherDataBackForward.isLehnenkopf()) {
                this.config.getSeatPopinModel(bl).setArrowHighlighting(n, MasterSeatPopinContent.LEHNENKOPF);
            } else {
                this.config.getSeatPopinModel(bl).removeArrowHighlighting(n, MasterSeatPopinContent.LEHNENKOPF);
            }
        }
        if (this.config.isLordosenweiteAvailable(bl)) {
            if (switcherDataBackForward.isLordosenweite()) {
                this.config.getSeatPopinModel(bl).setArrowHighlighting(n, MasterSeatPopinContent.LORDORSE);
            } else {
                this.config.getSeatPopinModel(bl).removeArrowHighlighting(n, MasterSeatPopinContent.LORDORSE);
            }
        }
        if (this.config.isSitztiefeAvailable(bl)) {
            if (switcherDataBackForward.isSitztiefe()) {
                this.config.getSeatPopinModel(bl).setArrowHighlighting(n, MasterSeatPopinContent.SITZTIEFE);
            } else {
                this.config.getSeatPopinModel(bl).removeArrowHighlighting(n, MasterSeatPopinContent.SITZTIEFE);
            }
        }
    }

    private void setSwitcherData(boolean bl, boolean bl2, SwitcherDataUpDown switcherDataUpDown) {
        int n;
        int n2 = n = bl2 ? 0 : 1;
        if (this.config.isGurthoeheAvailable(bl)) {
            if (switcherDataUpDown.isGurthoehe()) {
                this.config.getSeatPopinModel(bl).setArrowHighlighting(n, MasterSeatPopinContent.GURTHOEHE);
            } else {
                this.config.getSeatPopinModel(bl).removeArrowHighlighting(n, MasterSeatPopinContent.GURTHOEHE);
            }
        }
        if (this.config.isLordosenhoeheAvailable(bl)) {
            if (switcherDataUpDown.isLordosenhoehe()) {
                this.config.getSeatPopinModel(bl).setArrowHighlighting(n, MasterSeatPopinContent.LORDORSE);
            } else {
                this.config.getSeatPopinModel(bl).removeArrowHighlighting(n, MasterSeatPopinContent.LORDORSE);
            }
        }
        if (this.config.isSitzflaechenwangenAvailable(bl)) {
            if (switcherDataUpDown.isSitzflaechenwangen()) {
                this.config.getSeatPopinModel(bl).setArrowHighlighting(n, MasterSeatPopinContent.SEITENWANGEN);
            } else {
                this.config.getSeatPopinModel(bl).removeArrowHighlighting(n, MasterSeatPopinContent.SEITENWANGEN);
            }
        }
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

