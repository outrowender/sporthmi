/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.light;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.core.light.AbstractIntLightComponent;
import de.audi.app.car.core.light.IntLightColorListBusiness;
import de.audi.app.car.core.light.IntLightSetEvaluator;
import de.audi.app.car.core.light.IntLightSetEvaluator$SingleZoneIdentity;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class IntLightComponentEvo
extends AbstractIntLightComponent
implements IScreenStateListener {
    private static final int INDIVIDUAL_BRIGHTNESS_STEPS;
    CarViewOption singleRotaryViewOption = null;
    CarViewOption lastVisible = null;
    boolean isAllSetSyncMode = false;

    public IntLightComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(-567867136, this);
    }

    @Override
    protected void initBusiness() {
        super.initBusiness();
        this.ambientColorListBusiness = new IntLightColorListBusiness(this.getDSI(), this.getLogChannel(), this.ambientColorListModel);
    }

    @Override
    protected int getIndividualBrightnessStepWidth() {
        return 20;
    }

    @Override
    public void deinit() {
        this.getApplication().getScreenStateDispatcher().removeScreenStateListener(-567867136, this);
        super.deinit();
    }

    @Override
    protected void updateMenuEntryVisibility(IntLightViewOptions intLightViewOptions, IntLightSetEvaluator intLightSetEvaluator) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[IntLightComponentEvo#updateMenuEntryVisibility] %1", (Object)intLightViewOptions);
            this.getLogChannel().log(1078071040, "[IntLightComponentEvo#updateMenuEntryVisibility] %1", (Object)intLightSetEvaluator);
        }
        boolean bl = this.isIndividualSingle(intLightViewOptions, intLightSetEvaluator);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(153618688, 1);
        if (!bl) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2060973824, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile1()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2044196608, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile2()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2027419392, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile3()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2010642176, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile4()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1993864960, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile5()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1977087744, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile6()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1960310528, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile7()}));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1943533312, this.getMenuEntryVisibilityState(new CarViewOption[]{intLightViewOptions.getIntLightActiveProfile(), intLightViewOptions.getIntLightIlluminationProfile8()}));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2060973824, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2044196608, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2027419392, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2010642176, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1993864960, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1977087744, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1960310528, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1943533312, 1);
        }
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(170395904, this.getMenuEntryVisibilityState(this.singleRotaryViewOption));
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
        this.getLogChannel().log(1078071040, "[IntLightComponentEvo#isIndividualSingle]");
        this.singleRotaryViewOption = new CarViewOption(0, 0);
        int n = this.countVisibleProfiles(intLightViewOptions);
        if (n == 1) {
            this.setProfilesMode(false);
            this.setSingleRotaryMode(true, 0);
            this.singleRotaryViewOption = this.lastVisible;
            this.lastVisible = null;
            this.getLogChannel().log(1078071040, "[IntLightComponentEvo#isIndividualSingle] One profile mode: VO: %1", (Object)this.singleRotaryViewOption);
            return true;
        }
        if (n > 1) {
            this.setProfilesMode(true);
            this.setSingleRotaryMode(false, 0);
            this.lastVisible = null;
            this.getLogChannel().log(1078071040, "[IntLightComponentEvo#isIndividualSingle] Profiles mode");
            return false;
        }
        boolean bl = intLightSetEvaluator.hasAllSetsSyncSet() ? !intLightSetEvaluator.hasStandardSetSet() : intLightSetEvaluator.hasStandardSetSet();
        this.isAllSetSyncMode = intLightSetEvaluator.hasAllSetsSyncSet();
        this.setProfilesMode(!bl);
        ChoiceModelApp choiceModelApp = this.getApplication().getFrameworkAccess().getHMIService().getChoiceModel(-785381120);
        choiceModelApp.setValue(0);
        if (bl) {
            int n2 = intLightSetEvaluator.getAllSetsSyncSetNumber() + intLightSetEvaluator.getStandardSetSetNumber();
            this.setSingleRotaryMode(false, n2);
            this.setSingleSetViewOptions(n2, intLightViewOptions);
            this.getLogChannel().log(1078071040, "[IntLightComponentEvo#isIndividualSingle] AllsetSync/Standardset activeSet: %1", (long)n2);
            return true;
        }
        if (intLightSetEvaluator.getSingleIlluminatinSetId().getZoneIdentifier() != 0) {
            IntLightSetEvaluator$SingleZoneIdentity intLightSetEvaluator$SingleZoneIdentity = intLightSetEvaluator.getSingleIlluminatinSetId();
            choiceModelApp.setValue(intLightSetEvaluator$SingleZoneIdentity.getZoneIdentifier());
            this.setSingleRotaryMode(false, intLightSetEvaluator$SingleZoneIdentity.getSetNumber());
            this.setSingleSetViewOptions(intLightSetEvaluator$SingleZoneIdentity.getSetNumber(), intLightViewOptions);
            this.getLogChannel().log(1078071040, "[IntLightComponentEvo#isIndividualSingle] Single set active, activeSet: %1", (long)intLightSetEvaluator$SingleZoneIdentity.getSetNumber());
            return true;
        }
        this.getLogChannel().log(1078071040, "[IntLightComponentEvo#isIndividualSingle] check configuration!");
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
                this.getLogChannel().log(-1601830656, "SetNumber to high or negative or 0!");
            }
        }
        this.getLogChannel().log(1078071040, "[IntLightComponentEvo#setSingleSetViewOptions] ViewOption: %1", (Object)this.singleRotaryViewOption);
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

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(153618688, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-2060973824, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-2044196608, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-2027419392, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-2010642176, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1993864960, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1977087744, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1960310528, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1943533312, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(170395904, (short)1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(170395904, 1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(340, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(341, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(342, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(343, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(344, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(345, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(346, (short)1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(347, (short)1);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(153618688);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-2060973824);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-2044196608);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-2027419392);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-2010642176);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1993864960);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1977087744);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1960310528);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1943533312);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(170395904);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(340);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(341);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(342);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(343);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(344);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(345);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(346);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(347);
    }

    @Override
    public int getID() {
        return 33;
    }

    @Override
    public void notifyScreenVisible(int n) {
    }

    @Override
    public void notifyScreenHidden(int n) {
    }

    @Override
    public void notifyScreenConnected(int n) {
        if (n == -567867136) {
            this.inOneBrightnessScreen = true;
        }
    }

    @Override
    public void notifyScreenFadedOut(int n) {
        if (n == -567867136) {
            this.inOneBrightnessScreen = false;
            this.singleRotaryBusiness.resetEventWatcher();
        }
    }
}

