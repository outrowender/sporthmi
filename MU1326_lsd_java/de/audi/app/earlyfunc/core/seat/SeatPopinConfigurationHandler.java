/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.MasterSeatPopinContent;
import de.audi.app.earlyfunc.core.seat.SeatDisplayContent;
import de.audi.app.earlyfunc.core.seat.SeatPopinContent;
import de.audi.app.earlyfunc.core.seat.SeatPopinModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import org.dsi.ifc.carseat.MassageConfig;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.VisualizationConfig;

public class SeatPopinConfigurationHandler {
    private final LogChannel logChannel;
    private volatile SeatViewOptions viewOptions;
    private volatile SeatPneumaticViewOptions pneumaticViewOptions;
    private boolean driversideLeft = true;
    private static final int DRIVERSIDE_LEFT = 0;
    private static final int DRIVERSIDE_RIGHT = 1;
    private final ChoiceModelApp driversideModel;
    private final SeatPopinModel seatPopinModelLeft;
    private final SeatPopinModel seatPopinModelRight;
    private boolean updatedViewOptionsLeft = false;
    private boolean updatedViewOptionsRight = false;

    public SeatPopinConfigurationHandler(LogChannel logChannel, SeatPopinModel seatPopinModel, SeatPopinModel seatPopinModel2, ChoiceModelApp choiceModelApp) {
        this.logChannel = logChannel;
        this.seatPopinModelLeft = seatPopinModel;
        this.seatPopinModelRight = seatPopinModel2;
        this.driversideModel = choiceModelApp;
    }

    public void init() {
        this.seatPopinModelLeft.init();
        this.seatPopinModelRight.init();
    }

    public void deinit() {
        this.seatPopinModelLeft.deinit();
        this.seatPopinModelRight.deinit();
    }

    public boolean arePneumaticSettingsActive(boolean bl) {
        return (bl ? this.seatPopinModelLeft : this.seatPopinModelRight).arePneumaticAvailabilitySettingsActive();
    }

    private int getIntensityRange(boolean bl, boolean bl2) {
        MassageConfig massageConfig = this.getMassageConfig(bl, bl2);
        if (massageConfig != null) {
            return massageConfig.getIntensityRange();
        }
        return 0;
    }

    public SeatPopinModel getSeatPopinModel(boolean bl) {
        return bl ? this.seatPopinModelLeft : this.seatPopinModelRight;
    }

    public void updateConfiguration(SeatViewOptions seatViewOptions) {
        this.viewOptions = seatViewOptions;
        this.updatedViewOptionsLeft = true;
        this.updatedViewOptionsRight = true;
        this.isDriverSideLeft(false);
    }

    public void updateConfiguration(SeatPneumaticViewOptions seatPneumaticViewOptions) {
        this.pneumaticViewOptions = seatPneumaticViewOptions;
        this.updatedViewOptionsLeft = true;
        this.updatedViewOptionsRight = true;
        this.isDriverSideLeft(true);
    }

    public void setAvailabilityModels(boolean bl, boolean bl2) {
        boolean bl3;
        boolean bl4 = this.arePneumaticSettingsActive(bl);
        boolean bl5 = bl3 = bl ? this.updatedViewOptionsLeft : this.updatedViewOptionsRight;
        if (bl3 || bl4 && !bl2 || !bl4 && bl2) {
            ArrayList arrayList = new ArrayList(12);
            this.addMassageDisplayContent(bl, bl2, arrayList);
            this.addSecondaryFunctionsDisplayContent(bl, bl2, arrayList);
            if (bl) {
                this.seatPopinModelLeft.updateContentAvailability(arrayList, bl2, this.getIntensityRange(bl, bl2));
                this.updatedViewOptionsLeft = false;
            } else {
                this.seatPopinModelRight.updateContentAvailability(arrayList, bl2, this.getIntensityRange(bl, bl2));
                this.updatedViewOptionsRight = false;
            }
        }
    }

    private void addSecondaryFunctionsDisplayContent(boolean bl, boolean bl2, ArrayList arrayList) {
        for (int i2 = MasterSeatPopinContent.GURTHOEHE.getSeatContentID(); i2 < MasterSeatPopinContent.getAllSeatPopinContents().length; ++i2) {
            MasterSeatPopinContent masterSeatPopinContent = MasterSeatPopinContent.getContentForID(i2);
            if (!masterSeatPopinContent.hasValidRowID()) continue;
            arrayList.add(this.getSecondaryFunctionAvailability(bl, bl2, MasterSeatPopinContent.getContentForID(i2)));
        }
    }

    private SeatDisplayContent getSecondaryFunctionAvailability(boolean bl, boolean bl2, MasterSeatPopinContent masterSeatPopinContent) {
        SeatDisplayContent seatDisplayContent = new SeatDisplayContent(masterSeatPopinContent);
        seatDisplayContent.setContentAvailable(this.isContentAvailable(bl, bl2, masterSeatPopinContent, MasterSeatPopinContent.SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE));
        seatDisplayContent.setHorizontalArrowsAvailable(this.getArrowAvailability(bl, bl2, masterSeatPopinContent, 1, seatDisplayContent.isContentAvailable()));
        seatDisplayContent.setVerticalArrowsAvailable(this.getArrowAvailability(bl, bl2, masterSeatPopinContent, 2, seatDisplayContent.isContentAvailable()));
        return seatDisplayContent;
    }

    private boolean getArrowAvailability(boolean bl, boolean bl2, MasterSeatPopinContent masterSeatPopinContent, int n, boolean bl3) {
        if (n == masterSeatPopinContent.getArrowDimension()) {
            return bl3;
        }
        if (MasterSeatPopinContent.LORDORSE.equalsMasterSeatPopinContent(masterSeatPopinContent)) {
            return this.getLordoseArrowState(bl, bl2, n);
        }
        if (MasterSeatPopinContent.SEITENWANGEN.equalsMasterSeatPopinContent(masterSeatPopinContent)) {
            return this.getSeitenwangenArrowState(bl, bl2, n);
        }
        return false;
    }

    private boolean getSeitenwangenArrowState(boolean bl, boolean bl2, int n) {
        VisualizationConfig visualizationConfig = this.getVisualizationConfig(bl, bl2);
        if (visualizationConfig != null) {
            if (n == 1) {
                return visualizationConfig.isLehnenwangenverstellung();
            }
            if (n == 2) {
                return visualizationConfig.isSitzflaechenwangenverstellung();
            }
            if (n == 3) {
                return visualizationConfig.isLehnenwangenverstellung() || visualizationConfig.isSitzflaechenwangenverstellung();
            }
        }
        return false;
    }

    private boolean getLordoseArrowState(boolean bl, boolean bl2, int n) {
        VisualizationConfig visualizationConfig = this.getVisualizationConfig(bl, bl2);
        if (visualizationConfig != null) {
            if (n == 1) {
                return visualizationConfig.isLordosenweitenverstellung();
            }
            if (n == 2) {
                return visualizationConfig.isLordosenhoehenverstellung();
            }
            if (n == 3) {
                return visualizationConfig.isLordosenhoehenverstellung() || visualizationConfig.isLordosenweitenverstellung();
            }
        }
        return false;
    }

    private void addMassageDisplayContent(boolean bl, boolean bl2, ArrayList arrayList) {
        MasterSeatPopinContent.MassageProgram[] massageProgramArray = MasterSeatPopinContent.MassageProgram.getAllMassagePrograms();
        for (int i2 = MasterSeatPopinContent.MassageProgram.MASSAGE_PROGRAM_NONE.getDsiProgramNr(); i2 < massageProgramArray.length; ++i2) {
            SeatDisplayContent seatDisplayContent = new SeatDisplayContent(massageProgramArray[i2]);
            seatDisplayContent.setContentAvailable(this.isMassageProgramAvailable(bl, bl2, i2));
            arrayList.add(seatDisplayContent);
        }
        SeatDisplayContent seatDisplayContent = new SeatDisplayContent(MasterSeatPopinContent.MassageProgram.MASSAGE_PROGRAM_NONE);
        seatDisplayContent.setContentAvailable(this.isMassageAvailable(bl, bl2));
        arrayList.add(seatDisplayContent);
    }

    public boolean isMassageProgramSelectable(boolean bl, int n) {
        return this.isMassageProgramAvailable(bl, this.arePneumaticSettingsActive(bl), n);
    }

    public boolean isLehnenwangenAvailable(boolean bl) {
        return this.getSeitenwangenArrowState(bl, this.arePneumaticSettingsActive(bl), 1);
    }

    public boolean isLordosenweiteAvailable(boolean bl) {
        return this.getLordoseArrowState(bl, this.arePneumaticSettingsActive(bl), 1);
    }

    public boolean isLehnenkopfAvailable(boolean bl) {
        return this.isLehnenkopfAvailable(bl, this.arePneumaticSettingsActive(bl));
    }

    public boolean isSitztiefeAvailable(boolean bl) {
        return this.isSitztiefeAvailable(bl, this.arePneumaticSettingsActive(bl));
    }

    public boolean isGurthoeheAvailable(boolean bl) {
        return this.isGurthoeheAvailable(bl, this.arePneumaticSettingsActive(bl));
    }

    public boolean isLordosenhoeheAvailable(boolean bl) {
        return this.getLordoseArrowState(bl, this.arePneumaticSettingsActive(bl), 2);
    }

    public boolean isSitzflaechenwangenAvailable(boolean bl) {
        return this.getSeitenwangenArrowState(bl, this.arePneumaticSettingsActive(bl), 2);
    }

    public boolean isSeatMemoryAvailable(boolean bl, MasterSeatPopinContent.SeatMemoryDetail seatMemoryDetail) {
        return this.isContentAvailable(bl, false, MasterSeatPopinContent.MEMORY, seatMemoryDetail);
    }

    public boolean isLordoseAvailable(boolean bl, boolean bl2) {
        return this.isContentAvailable(bl, bl2, MasterSeatPopinContent.LORDORSE, MasterSeatPopinContent.SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE);
    }

    public boolean isSeitenwangenAvailable(boolean bl, boolean bl2) {
        return this.isContentAvailable(bl, bl2, MasterSeatPopinContent.SEITENWANGEN, MasterSeatPopinContent.SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE);
    }

    private boolean isSitztiefeAvailable(boolean bl, boolean bl2) {
        return this.isContentAvailable(bl, bl2, MasterSeatPopinContent.SITZTIEFE, MasterSeatPopinContent.SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE);
    }

    private boolean isLehnenkopfAvailable(boolean bl, boolean bl2) {
        return this.isContentAvailable(bl, bl2, MasterSeatPopinContent.LEHNENKOPF, MasterSeatPopinContent.SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE);
    }

    private boolean isGurthoeheAvailable(boolean bl, boolean bl2) {
        return this.isContentAvailable(bl, bl2, MasterSeatPopinContent.GURTHOEHE, MasterSeatPopinContent.SeatMemoryDetail.MEMORYDETAIL_MEMORY_NONE);
    }

    public boolean isContentAvailable(boolean bl, boolean bl2, MasterSeatPopinContent masterSeatPopinContent, MasterSeatPopinContent.SeatMemoryDetail seatMemoryDetail) {
        if (masterSeatPopinContent.usesVOConfigType(1)) {
            VisualizationConfig visualizationConfig = this.getVisualizationConfig(bl, bl2);
            if (visualizationConfig != null) {
                return this.isVisualized(visualizationConfig, masterSeatPopinContent);
            }
            return false;
        }
        if (masterSeatPopinContent.usesVOConfigType(2)) {
            return this.isMemoryAvailable(bl, seatMemoryDetail);
        }
        if (masterSeatPopinContent.usesVOConfigType(3)) {
            return this.isMassageAvailable(bl, bl2);
        }
        return true;
    }

    public boolean isContentAvailable(boolean bl, SeatPopinContent seatPopinContent) {
        return this.isContentAvailable(bl, seatPopinContent.isPneumaticSeatContent(), seatPopinContent.getMasterContent(bl), seatPopinContent.getMemoryDetail(bl));
    }

    public boolean isContentAvailable(boolean bl, boolean bl2, int n, MasterSeatPopinContent.SeatMemoryDetail seatMemoryDetail) {
        return this.isContentAvailable(bl, bl2, MasterSeatPopinContent.getContentForID(n), seatMemoryDetail);
    }

    private boolean isVisualized(VisualizationConfig visualizationConfig, MasterSeatPopinContent masterSeatPopinContent) {
        if (masterSeatPopinContent.equalsMasterSeatPopinContent(MasterSeatPopinContent.GURTHOEHE)) {
            return visualizationConfig.isGurthoehenverstellung();
        }
        if (masterSeatPopinContent.equalsMasterSeatPopinContent(MasterSeatPopinContent.LORDORSE)) {
            return visualizationConfig.isLordosenhoehenverstellung() || visualizationConfig.isLordosenweitenverstellung();
        }
        if (masterSeatPopinContent.equalsMasterSeatPopinContent(MasterSeatPopinContent.LEHNENKOPF)) {
            return visualizationConfig.isLehnenkopfverstellung();
        }
        if (masterSeatPopinContent.equalsMasterSeatPopinContent(MasterSeatPopinContent.SEITENWANGEN)) {
            return visualizationConfig.isSitzflaechenwangenverstellung() || visualizationConfig.isLehnenwangenverstellung();
        }
        if (masterSeatPopinContent.equalsMasterSeatPopinContent(MasterSeatPopinContent.SITZTIEFE)) {
            return visualizationConfig.isSitztiefenverstellung();
        }
        return false;
    }

    private boolean isMemoryAvailable(boolean bl, MasterSeatPopinContent.SeatMemoryDetail seatMemoryDetail) {
        if (this.viewOptions != null && this.viewOptions.getSeatmemoryConfig() != null) {
            boolean bl2;
            boolean bl3 = bl2 = seatMemoryDetail.getModelValue() > -1;
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1000000, "[SeatPopinConfigurationHandler#isMemoryAvailable] MemoryDetail('%1') %2 used.", (Object)seatMemoryDetail, (Object)(bl2 ? "is" : "is not"));
            }
            if (bl) {
                return this.viewOptions.seatmemoryConfig.seatmemory1RL && bl2;
            }
            return this.viewOptions.seatmemoryConfig.seatmemory1RR && bl2;
        }
        return false;
    }

    public boolean isMassageAvailable(boolean bl, boolean bl2) {
        MassageConfig massageConfig = this.getMassageConfig(bl, bl2);
        if (massageConfig != null) {
            return massageConfig.getPrograms().isProgram1Exist() || massageConfig.getPrograms().isProgram2Exist() || massageConfig.getPrograms().isProgram3Exist() || massageConfig.getPrograms().isProgram4Exist() || massageConfig.getPrograms().isProgram5Exist() || massageConfig.getPrograms().isProgram6Exist();
        }
        return false;
    }

    private boolean isMassageProgramAvailable(boolean bl, boolean bl2, int n) {
        if (bl2) {
            return this.isPneumaticMassageProgramAvailable(bl, n);
        }
        return this.isSeatMassageProgramAvailable(bl, n);
    }

    private boolean isSeatMassageProgramAvailable(boolean bl, int n) {
        if (!this.isMassageAvailable(bl, false)) {
            return false;
        }
        switch (n) {
            case 0: {
                return true;
            }
            case 1: {
                return bl ? this.viewOptions.getMassageConfig1RL().getPrograms().isProgram1Exist() : this.viewOptions.getMassageConfig1RR().getPrograms().isProgram1Exist();
            }
            case 2: {
                return bl ? this.viewOptions.getMassageConfig1RL().getPrograms().isProgram2Exist() : this.viewOptions.getMassageConfig1RR().getPrograms().isProgram2Exist();
            }
            case 3: {
                return bl ? this.viewOptions.getMassageConfig1RL().getPrograms().isProgram3Exist() : this.viewOptions.getMassageConfig1RR().getPrograms().isProgram3Exist();
            }
            case 4: {
                return bl ? this.viewOptions.getMassageConfig1RL().getPrograms().isProgram4Exist() : this.viewOptions.getMassageConfig1RR().getPrograms().isProgram4Exist();
            }
            case 5: {
                return bl ? this.viewOptions.getMassageConfig1RL().getPrograms().isProgram5Exist() : this.viewOptions.getMassageConfig1RR().getPrograms().isProgram5Exist();
            }
            case 6: {
                return bl ? this.viewOptions.getMassageConfig1RL().getPrograms().isProgram6Exist() : this.viewOptions.getMassageConfig1RR().getPrograms().isProgram6Exist();
            }
        }
        return false;
    }

    private boolean isPneumaticMassageProgramAvailable(boolean bl, int n) {
        if (!this.isMassageAvailable(bl, true)) {
            return false;
        }
        switch (n) {
            case 0: {
                return true;
            }
            case 1: {
                return bl ? this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RL().getPrograms().isProgram1Exist() : this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RR().getPrograms().isProgram1Exist();
            }
            case 2: {
                return bl ? this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RL().getPrograms().isProgram2Exist() : this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RR().getPrograms().isProgram2Exist();
            }
            case 3: {
                return bl ? this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RL().getPrograms().isProgram3Exist() : this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RR().getPrograms().isProgram3Exist();
            }
            case 4: {
                return bl ? this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RL().getPrograms().isProgram4Exist() : this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RR().getPrograms().isProgram4Exist();
            }
            case 5: {
                return bl ? this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RL().getPrograms().isProgram5Exist() : this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RR().getPrograms().isProgram5Exist();
            }
            case 6: {
                return bl ? this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RL().getPrograms().isProgram6Exist() : this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RR().getPrograms().isProgram6Exist();
            }
        }
        return false;
    }

    private MassageConfig getMassageConfig(boolean bl, boolean bl2) {
        if (bl2) {
            if (this.pneumaticViewOptions != null && this.pneumaticViewOptions.getSeatPneumaticConfig() != null) {
                return bl ? this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RL() : this.pneumaticViewOptions.getSeatPneumaticConfig().getMassageConfig1RR();
            }
        } else if (this.viewOptions != null) {
            return bl ? this.viewOptions.getMassageConfig1RL() : this.viewOptions.getMassageConfig1RR();
        }
        return null;
    }

    private VisualizationConfig getVisualizationConfig(boolean bl, boolean bl2) {
        if (bl2) {
            if (this.pneumaticViewOptions != null && this.pneumaticViewOptions.getSeatPneumaticConfig() != null) {
                return bl ? this.pneumaticViewOptions.getSeatPneumaticConfig().visualizationConfig1RL : this.pneumaticViewOptions.getSeatPneumaticConfig().getVisualizationConfig1RR();
            }
        } else if (this.viewOptions != null) {
            return bl ? this.viewOptions.getVisualizationConfig1RL() : this.viewOptions.getVisualizationConfig1RR();
        }
        return null;
    }

    public SeatViewOptions getViewOptions() {
        return this.viewOptions;
    }

    public SeatPneumaticViewOptions getPneumaticViewOptions() {
        return this.pneumaticViewOptions;
    }

    public boolean isDriverSideLeft(boolean bl) {
        if (bl) {
            if (this.pneumaticViewOptions != null && this.pneumaticViewOptions.getSeatPneumaticConfig() != null) {
                this.setDriverSide(this.pneumaticViewOptions.getSeatPneumaticConfig().isDriversideLeft());
            }
        } else if (this.viewOptions != null && this.viewOptions.getSeatmemoryConfig() != null) {
            this.setDriverSide(this.viewOptions.getSeatmemoryConfig().isDriversideLeft());
        }
        return this.driversideLeft;
    }

    private void setDriverSide(boolean bl) {
        if (this.driversideLeft != bl) {
            this.driversideLeft = bl;
            this.driversideModel.setValue(bl ? 0 : 1);
        }
    }
}

