/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.light;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.core.light.AbstractIntLightComponent;
import de.audi.app.car.core.light.IntLightColorListBusiness;
import de.audi.app.car.core.light.IntLightSetEvaluator;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class IntLightComponentEvo
extends AbstractIntLightComponent
implements IScreenStateListener {
    private static final int INDIVIDUAL_BRIGHTNESS_STEPS = 20;
    CarViewOption singleRotaryViewOption = null;
    CarViewOption lastVisible = null;
    boolean isAllSetSyncMode = false;

    public IntLightComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public void init() {
        super.init();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600030, this);
    }

    protected void initBusiness() {
        super.initBusiness();
        this.ambientColorListBusiness = new IntLightColorListBusiness(this.getDSI(), this.getLogChannel(), this.ambientColorListModel);
    }

    protected int getIndividualBrightnessStepWidth() {
        return 20;
    }

    public void deinit() {
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(600030, this);
        super.deinit();
    }

    protected void updateMenuEntryVisibility(IntLightViewOptions intLightViewOptions, IntLightSetEvaluator intLightSetEvaluator) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[IntLightComponentEvo#updateMenuEntryVisibility] %1", (Object)intLightViewOptions);
            this.getLogChannel().log(1000000, "[IntLightComponentEvo#updateMenuEntryVisibility] %1", (Object)intLightSetEvaluator);
        }
        boolean bl = this.isIndividualSingle(intLightViewOptions, intLightSetEvaluator);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600073, 1);
        if (!bl) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600197, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile1()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600198, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile2()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600199, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile3()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600200, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile4()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600201, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile5()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600202, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile6()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600203, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile7()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600204, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile8()}));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600197, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600198, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600199, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600200, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600201, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600202, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600203, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600204, 1);
        }
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600074, this.getMenuEntryVisibilityState(this.singleRotaryViewOption));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(340, this.getMenuEntryVisibilityState(intLightViewOptions.getIntLightAmbientLightColor()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(342, this.getMenuEntryVisibilityState(intLightViewOptions.getIntLightContourLightColor()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(341, this.getMenuEntryVisibilityState(intLightSetEvaluator.getContourBrightnessViewOption()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(343, this.getMenuEntryVisibilityState(intLightSetEvaluator.getDoorsFrontRearBrightnessViewOption()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(344, this.getMenuEntryVisibilityState(intLightSetEvaluator.getFootwellFrontRearBrightnessViewOption()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(345, this.getMenuEntryVisibilityState(intLightSetEvaluator.getCockpitBrightnessViewOption()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(346, this.getMenuEntryVisibilityState(intLightSetEvaluator.getRoofBrightnessViewOption()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(347, this.getMenuEntryVisibilityState(intLightSetEvaluator.getSurfaceBrighnessViewOption()));
    }

    private boolean isIndividualSingle(IntLightViewOptions intLightViewOptions, IntLightSetEvaluator intLightSetEvaluator) {
        this.getLogChannel().log(1000000, "[IntLightComponentEvo#isIndividualSingle]");
        this.singleRotaryViewOption = new CarViewOption(0, 0);
        int n = this.countVisibleProfiles(intLightViewOptions);
        if (n == 1) {
            this.setProfilesMode(false);
            this.setSingleRotaryMode(true, 0);
            this.singleRotaryViewOption = this.lastVisible;
            this.lastVisible = null;
            this.getLogChannel().log(1000000, "[IntLightComponentEvo#isIndividualSingle] One profile mode: VO: %1", (Object)this.singleRotaryViewOption);
            return true;
        }
        if (n > 1) {
            this.setProfilesMode(true);
            this.setSingleRotaryMode(false, 0);
            this.lastVisible = null;
            this.getLogChannel().log(1000000, "[IntLightComponentEvo#isIndividualSingle] Profiles mode");
            return false;
        }
        boolean bl = intLightSetEvaluator.hasAllSetsSyncSet() ? !intLightSetEvaluator.hasStandardSetSet() : intLightSetEvaluator.hasStandardSetSet();
        this.isAllSetSyncMode = intLightSetEvaluator.hasAllSetsSyncSet();
        this.setProfilesMode(!bl);
        ChoiceModelApp choiceModelApp = this.getApplication().getFrameworkAccess().getHMIService().getChoiceModel(602321);
        choiceModelApp.setValue(0);
        if (bl) {
            int n2 = intLightSetEvaluator.getAllSetsSyncSetNumber() + intLightSetEvaluator.getStandardSetSetNumber();
            this.setSingleRotaryMode(false, n2);
            this.setSingleSetViewOptions(n2, intLightViewOptions);
            this.getLogChannel().log(1000000, "[IntLightComponentEvo#isIndividualSingle] AllsetSync/Standardset activeSet: %1", (long)n2);
            return true;
        }
        if (intLightSetEvaluator.getSingleIlluminatinSetId().getZoneIdentifier() != 0) {
            IntLightSetEvaluator.SingleZoneIdentity singleZoneIdentity = intLightSetEvaluator.getSingleIlluminatinSetId();
            choiceModelApp.setValue(singleZoneIdentity.getZoneIdentifier());
            this.setSingleRotaryMode(false, singleZoneIdentity.getSetNumber());
            this.setSingleSetViewOptions(singleZoneIdentity.getSetNumber(), intLightViewOptions);
            this.getLogChannel().log(1000000, "[IntLightComponentEvo#isIndividualSingle] Single set active, activeSet: %1", (long)singleZoneIdentity.getSetNumber());
            return true;
        }
        this.getLogChannel().log(1000000, "[IntLightComponentEvo#isIndividualSingle] check configuration!");
        this.setSingleRotaryMode(false, 0);
        return false;
    }

    private void setSingleSetViewOptions(int n, IntLightViewOptions intLightViewOptions) {
        switch (n) {
            case 1: {
                this.singleRotaryViewOption = intLightViewOptions.getIntLightIlluminationSet1();
                break;
            }
            case 2: {
                this.singleRotaryViewOption = intLightViewOptions.getIntLightIlluminationSet2();
                break;
            }
            case 3: {
                this.singleRotaryViewOption = intLightViewOptions.getIntLightIlluminationSet3();
                break;
            }
            case 4: {
                this.singleRotaryViewOption = intLightViewOptions.getIntLightIlluminationSet4();
                break;
            }
            case 5: {
                this.singleRotaryViewOption = intLightViewOptions.getIntLightIlluminationSet5();
                break;
            }
            case 6: {
                this.singleRotaryViewOption = intLightViewOptions.getIntLightIlluminationSet6();
                break;
            }
            case 7: {
                this.singleRotaryViewOption = intLightViewOptions.getIntLightIlluminationSet7();
                break;
            }
            case 8: {
                this.singleRotaryViewOption = intLightViewOptions.getIntLightIlluminationSet8();
                break;
            }
            default: {
                this.getLogChannel().log(100000, "SetNumber to high or negative or 0!");
            }
        }
        this.getLogChannel().log(1000000, "[IntLightComponentEvo#setSingleSetViewOptions] ViewOption: %1", (Object)this.singleRotaryViewOption);
    }

    private int countVisibleProfiles(IntLightViewOptions intLightViewOptions) {
        int n = 0;
        if (intLightViewOptions.getIntLightIlluminationProfile1().getState() != 0) {
            ++n;
            this.lastVisible = intLightViewOptions.getIntLightIlluminationProfile1();
        }
        if (intLightViewOptions.getIntLightIlluminationProfile2().getState() != 0) {
            ++n;
            this.lastVisible = intLightViewOptions.getIntLightIlluminationProfile1();
        }
        if (intLightViewOptions.getIntLightIlluminationProfile3().getState() != 0) {
            ++n;
            this.lastVisible = intLightViewOptions.getIntLightIlluminationProfile1();
        }
        if (intLightViewOptions.getIntLightIlluminationProfile4().getState() != 0) {
            ++n;
            this.lastVisible = intLightViewOptions.getIntLightIlluminationProfile1();
        }
        if (intLightViewOptions.getIntLightIlluminationProfile5().getState() != 0) {
            ++n;
            this.lastVisible = intLightViewOptions.getIntLightIlluminationProfile1();
        }
        if (intLightViewOptions.getIntLightIlluminationProfile6().getState() != 0) {
            ++n;
            this.lastVisible = intLightViewOptions.getIntLightIlluminationProfile1();
        }
        if (intLightViewOptions.getIntLightIlluminationProfile7().getState() != 0) {
            ++n;
            this.lastVisible = intLightViewOptions.getIntLightIlluminationProfile1();
        }
        if (intLightViewOptions.getIntLightIlluminationProfile8().getState() != 0) {
            ++n;
            this.lastVisible = intLightViewOptions.getIntLightIlluminationProfile1();
        }
        return n;
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600073, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600197, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600198, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600199, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600200, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600201, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600202, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600203, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600204, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600074, (short)1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600074, 1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(340, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(341, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(342, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(343, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(344, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(345, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(346, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(347, (short)1);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600073);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600197);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600198);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600199);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600200);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600201);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600202);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600203);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600204);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600074);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(340);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(341);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(342);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(343);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(344);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(345);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(346);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(347);
    }

    public int getID() {
        return 33;
    }

    public void notifyScreenVisible(int n) {
    }

    public void notifyScreenHidden(int n) {
    }

    public void notifyScreenConnected(int n) {
        if (n == 600030) {
            this.inOneBrightnessScreen = true;
        }
    }

    public void notifyScreenFadedOut(int n) {
        if (n == 600030) {
            this.inOneBrightnessScreen = false;
            this.singleRotaryBusiness.resetEventWatcher();
        }
    }
}

