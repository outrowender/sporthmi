/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.core.light.IntLightSetEvaluator$SingleZoneIdentity;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class IntLightSetEvaluator {
    public static final int NO_SINGLE_SET_MODE;
    public static final int BRIGHTNESS_COCKPIT;
    public static final int BRIGHTNESS_CONTOUR;
    public static final int BRIGHTNESS_DOORS;
    public static final int BRIGHTNESS_FOOTWELL;
    public static final int BRIGHTNESS_SUNROOF;
    public static final int BRIGHTNESS_SURFACE;
    private IntLightViewOptions viewOptions;
    private int footwellFrontRearSetNumber = 0;
    private int cockpitSetNumber = 0;
    private int doorsFrontRearSetNumber = 0;
    private int sunRoofSetNumber = 0;
    private int contourSetNumber = 0;
    private int surfaceSetSetNumber = 0;
    private int allSetsSyncSetNumber = 0;
    private int standardSetSetNumber = 0;
    private LogChannel logChan;

    public IntLightSetEvaluator(IntLightViewOptions intLightViewOptions, LogChannel logChannel) {
        this.viewOptions = intLightViewOptions;
        this.logChan = logChannel;
        if (logChannel.isInfo()) {
            logChannel.log(1078071040, "[IntLightSetEvaluator#IntLightSetEvaluator] get IlluminationsetNumber for DSICarLight.SETUPILLUMINATIONSET_FOOTWELL_FRONTREAR");
        }
        this.footwellFrontRearSetNumber = this.getIlluminationSetNumber(5);
        if (logChannel.isInfo()) {
            logChannel.log(1078071040, "[IntLightSetEvaluator#IntLightSetEvaluator] get IlluminationsetNumber for DSICarLight.SETUPILLUMINATIONSET_COCKPIT");
        }
        this.cockpitSetNumber = this.getIlluminationSetNumber(6);
        if (logChannel.isInfo()) {
            logChannel.log(1078071040, "[IntLightSetEvaluator#IntLightSetEvaluator] get IlluminationsetNumber for DSICarLight.SETUPILLUMINATIONSET_DOORS_FRONTREAR");
        }
        this.doorsFrontRearSetNumber = this.getIlluminationSetNumber(7);
        if (logChannel.isInfo()) {
            logChannel.log(1078071040, "[IntLightSetEvaluator#IntLightSetEvaluator] get IlluminationsetNumber for DSICarLight.SETUPILLUMINATIONSET_SUNROOF");
        }
        this.sunRoofSetNumber = this.getIlluminationSetNumber(12);
        if (logChannel.isInfo()) {
            logChannel.log(1078071040, "[IntLightSetEvaluator#IntLightSetEvaluator] get IlluminationsetNumber for DSICarLight.SETUPILLUMINATIONSET_CONTOUR");
        }
        this.contourSetNumber = this.getIlluminationSetNumber(13);
        if (logChannel.isInfo()) {
            logChannel.log(1078071040, "[IntLightSetEvaluator#SETUPILLUMINATIONSET_SURFACE] get IlluminationsetNumber for DSICarLight.SETUPILLUMINATIONSET_SURFACE");
        }
        this.surfaceSetSetNumber = this.getIlluminationSetNumber(17);
        if (logChannel.isInfo()) {
            logChannel.log(1078071040, "[IntLightSetEvaluator#IntLightSetEvaluator] get IlluminationsetNumber for DSICarLight.SETUPILLUMINATIONSET_STANDARDSET");
        }
        this.standardSetSetNumber = this.getIlluminationSetNumber(11);
        if (logChannel.isInfo()) {
            logChannel.log(1078071040, "[IntLightSetEvaluator#SETUPILLUMINATIONSET_ALLSETSSYNC] get IlluminationsetNumber for DSICarLight.SETUPILLUMINATIONSET_ALLSETSSYNC");
        }
        this.allSetsSyncSetNumber = this.getIlluminationSetNumber(10);
    }

    public int getFootwellFrontRearSetNumber() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getFootwellFrontRearSetNumber] returning footwellFrontRearSetNumber = %1", (long)this.footwellFrontRearSetNumber);
        }
        return this.footwellFrontRearSetNumber;
    }

    public int getCockpitSetNumber() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getCockpitSetNumber] returning cockpitSetNumber = %1", (long)this.cockpitSetNumber);
        }
        return this.cockpitSetNumber;
    }

    public int getDoorsFrontRearSetNumber() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getDoorsFrontRearSetNumber] returning doorsFrontRearSetNumber = %1", (long)this.doorsFrontRearSetNumber);
        }
        return this.doorsFrontRearSetNumber;
    }

    public int getSunRoofSetNumber() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getSunRoofSetNumber] returning sunRoofSetNumber = %1", (long)this.sunRoofSetNumber);
        }
        return this.sunRoofSetNumber;
    }

    public int getContourSetNumber() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getContourSetNumber] returning contourSetNumber = %1", (long)this.contourSetNumber);
        }
        return this.contourSetNumber;
    }

    public int getSurfaceSetSetNumber() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getSurfaceSetSetNumber] returning surfaceSetSetNumber = %1", (long)this.surfaceSetSetNumber);
        }
        return this.surfaceSetSetNumber;
    }

    public int getAllSetsSyncSetNumber() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getAllSetSyncSetNumber] returning allSetSyncSetNumber = %1", (long)this.allSetsSyncSetNumber);
        }
        return this.allSetsSyncSetNumber;
    }

    public int getStandardSetSetNumber() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getStandardSetSetNumber] returning standardSetSetNumber = %1", (long)this.standardSetSetNumber);
        }
        return this.standardSetSetNumber;
    }

    public boolean hasAllSetsSyncSet() {
        return this.allSetsSyncSetNumber > 0;
    }

    public boolean hasStandardSetSet() {
        return this.standardSetSetNumber > 0;
    }

    public IntLightSetEvaluator$SingleZoneIdentity getSingleIlluminatinSetId() {
        int n = 0;
        boolean bl = false;
        IntLightSetEvaluator$SingleZoneIdentity intLightSetEvaluator$SingleZoneIdentity = new IntLightSetEvaluator$SingleZoneIdentity(this);
        if (this.getCockpitSetNumber() != 0) {
            ++n;
            intLightSetEvaluator$SingleZoneIdentity.setZoneIdentifier(1);
            intLightSetEvaluator$SingleZoneIdentity.setSetNumber(this.getCockpitSetNumber());
        }
        if (this.getContourSetNumber() != 0) {
            ++n;
            intLightSetEvaluator$SingleZoneIdentity.setZoneIdentifier(2);
            intLightSetEvaluator$SingleZoneIdentity.setSetNumber(this.getContourSetNumber());
        }
        if (this.getDoorsFrontRearSetNumber() != 0) {
            ++n;
            intLightSetEvaluator$SingleZoneIdentity.setZoneIdentifier(3);
            intLightSetEvaluator$SingleZoneIdentity.setSetNumber(this.getDoorsFrontRearSetNumber());
        }
        if (this.getFootwellFrontRearSetNumber() != 0) {
            ++n;
            intLightSetEvaluator$SingleZoneIdentity.setZoneIdentifier(4);
            intLightSetEvaluator$SingleZoneIdentity.setSetNumber(this.getFootwellFrontRearSetNumber());
        }
        if (this.getSunRoofSetNumber() != 0) {
            ++n;
            intLightSetEvaluator$SingleZoneIdentity.setZoneIdentifier(5);
            intLightSetEvaluator$SingleZoneIdentity.setSetNumber(this.getSunRoofSetNumber());
        }
        if (this.getSurfaceSetSetNumber() != 0) {
            ++n;
            intLightSetEvaluator$SingleZoneIdentity.setZoneIdentifier(6);
            intLightSetEvaluator$SingleZoneIdentity.setSetNumber(this.getSurfaceSetSetNumber());
        }
        if (n == 1) {
            return intLightSetEvaluator$SingleZoneIdentity;
        }
        intLightSetEvaluator$SingleZoneIdentity.setZoneIdentifier(0);
        return intLightSetEvaluator$SingleZoneIdentity;
    }

    public IntLightViewOptions getIntLightViewOptions() {
        return this.viewOptions;
    }

    public CarViewOption getFootwellFrontRearBrightnessViewOption() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getFootwellFrontRearBrightnessViewOption] from Set configured as DSICarLight.SETUPILLUMINATIONSET_FOOTWELL_FRONTREAR");
        }
        return this.getVo(5);
    }

    public CarViewOption getCockpitBrightnessViewOption() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getFootwellFrontRearBrightnessViewOption] from Set configured as DSICarLight.SETUPILLUMINATIONSET_COCKPIT");
        }
        return this.getVo(6);
    }

    public CarViewOption getDoorsFrontRearBrightnessViewOption() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getFootwellFrontRearBrightnessViewOption] from Set configured as DSICarLight.SETUPILLUMINATIONSET_DOORS_FRONTREAR");
        }
        return this.getVo(7);
    }

    public CarViewOption getRoofBrightnessViewOption() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getFootwellFrontRearBrightnessViewOption] from Set configured as DSICarLight.SETUPILLUMINATIONSET_SUNROOF");
        }
        return this.getVo(12);
    }

    public CarViewOption getContourBrightnessViewOption() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getFootwellFrontRearBrightnessViewOption] from Set configured as DSICarLight.SETUPILLUMINATIONSET_CONTOUR");
        }
        return this.getVo(13);
    }

    public CarViewOption getSurfaceBrighnessViewOption() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getSurfaceBrighnessViewOption] from Set configured as DSICarLight.SETUPILLUMINATIONSET_SURFACE");
        }
        return this.getVo(17);
    }

    public CarViewOption getAllSetsSyncViewOption() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getAllSetSyncViewOption] from Set configured as DSICarLight.SETUPILLUMINATIONSET_ALLSETSSYNC");
        }
        return this.getVo(10);
    }

    public CarViewOption getStandardSetViewOption() {
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "[IntLightSetEvaluator#getStandardSetViewOption] from Set configured as DSICarLight.SETUPILLUMINATIONSET_STANDARDSET");
        }
        return this.getVo(11);
    }

    private CarViewOption getVo(int n) {
        CarViewOption carViewOption;
        CarViewOption carViewOption2 = this.viewOptions.getIntLightConfig().getSetupIlluminationSet1() == n ? this.viewOptions.getIntLightIlluminationSet1() : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet2() == n ? this.viewOptions.getIntLightIlluminationSet2() : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet3() == n ? this.viewOptions.getIntLightIlluminationSet3() : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet4() == n ? this.viewOptions.getIntLightIlluminationSet4() : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet5() == n ? this.viewOptions.getIntLightIlluminationSet5() : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet6() == n ? this.viewOptions.getIntLightIlluminationSet6() : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet7() == n ? this.viewOptions.getIntLightIlluminationSet7() : (carViewOption = this.viewOptions.getIntLightConfig().getSetupIlluminationSet8() == n ? this.viewOptions.getIntLightIlluminationSet8() : new CarViewOption(0, 0))))))));
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "IntLightSetEvaluator: param = %2 resolved to CarViewOption = %1", (Object)carViewOption, (long)n);
        }
        return carViewOption;
    }

    private int getIlluminationSetNumber(int n) {
        int n2;
        int n3 = this.viewOptions.getIntLightConfig().getSetupIlluminationSet1() == n ? 1 : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet2() == n ? 2 : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet3() == n ? 3 : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet4() == n ? 4 : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet5() == n ? 5 : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet6() == n ? 6 : (this.viewOptions.getIntLightConfig().getSetupIlluminationSet7() == n ? 7 : (n2 = this.viewOptions.getIntLightConfig().getSetupIlluminationSet8() == n ? 8 : 0)))))));
        if (this.logChan.isInfo()) {
            this.logChan.log(1078071040, "IntLightSetEvaluator: param = %1 resolved to SetupIlluminationSet %2", (long)n, (long)n2);
        }
        return n2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("IntLightSetEvaluator( footwellFrontRearSetNumber: ");
        stringBuffer.append(this.footwellFrontRearSetNumber);
        stringBuffer.append(", cockpitSetNumber: ");
        stringBuffer.append(this.cockpitSetNumber);
        stringBuffer.append(", doorsFrontRearSetNumber: ");
        stringBuffer.append(this.doorsFrontRearSetNumber);
        stringBuffer.append(", sunRoofSetNumber: ");
        stringBuffer.append(this.sunRoofSetNumber);
        stringBuffer.append(", contourSetNumber: ");
        stringBuffer.append(this.contourSetNumber);
        stringBuffer.append(", allSetsSyncSetNumber: ");
        stringBuffer.append(this.allSetsSyncSetNumber);
        stringBuffer.append(", standardSetSetNumber: ");
        stringBuffer.append(this.standardSetSetNumber);
        stringBuffer.append(" )");
        return stringBuffer.toString();
    }
}

