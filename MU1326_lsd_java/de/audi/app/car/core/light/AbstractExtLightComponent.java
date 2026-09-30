/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.light.AbstractDSICarLightAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public abstract class AbstractExtLightComponent
extends AbstractDSICarLightAdapter
implements ChoiceListener {
    public static final short CODING_ID = 6;
    private static final String LOGCHANNEL_NAME = "App.Car.ExtLight";
    private static final int DISABLED = 0;
    private static final int ENABLED = 1;
    private volatile ExtLightViewOptions currViewOptions;
    private volatile TimeState comingHomeTimeState = new TimeState();
    private volatile TimeState leavingHomeTimeState = new TimeState();

    public AbstractExtLightComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(600900).setChoiceListener(this);
        this.getChoiceModel(600913).setChoiceListener(this);
        this.getChoiceModel(600915).setChoiceListener(this);
        this.getChoiceModel(600911).setChoiceListener(this);
        this.getChoiceModel(600903).setChoiceListener(this);
        this.getChoiceModel(600905).setChoiceListener(this);
        this.getChoiceModel(600909).setChoiceListener(this);
        this.getChoiceModel(600902).setChoiceListener(this);
        this.getChoiceModel(601301).setChoiceListener(this);
        this.getChoiceModel(600892).setChoiceListener(this);
        this.getChoiceModel(602346).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(600900).resetListener();
        this.getChoiceModel(600913).resetListener();
        this.getChoiceModel(600915).resetListener();
        this.getChoiceModel(600911).resetListener();
        this.getChoiceModel(600903).resetListener();
        this.getChoiceModel(600905).resetListener();
        this.getChoiceModel(600909).resetListener();
        this.getChoiceModel(600902).resetListener();
        this.getChoiceModel(601301).resetListener();
        this.getChoiceModel(600892).resetListener();
        this.getChoiceModel(602346).resetListener();
    }

    private void setItemSelectedDayLight(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setItemSelectedDayLight(%1)", bl);
        this.getDSI().setExtLightDayLight(bl);
    }

    private void setItemSelectedTouristLight(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setExtLightTourist(%1)", bl);
        this.getDSI().setExtLightTourist(bl);
    }

    private void setItemSelectedSwitchOnTime(int n) {
        int n2 = 1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
        }
        this.getLogChannel().log(1000000, "dsi.setExtLightSwitchOnSensitivity(%1)", (long)n2);
        this.getDSI().setExtLightSwitchOnSensitivity(n2);
    }

    private void setItemSelectedHeadLight(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setExtLightHeadLightSystem(%1)", bl);
        this.getDSI().setExtLightHeadLightSystem(bl);
    }

    private void setItemSelectedEnterCarExitCarLight(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setExtLightComingHome(new TimeState(%2, %1))", bl, (long)this.comingHomeTimeState.getTime());
        this.getDSI().setExtLightComingHome(new TimeState(this.comingHomeTimeState.getTime(), bl));
        this.getLogChannel().log(1000000, "dsi.setExtLightLeavingHome(new TimeState(%2, %1))", bl, (long)this.leavingHomeTimeState.getTime());
        this.getDSI().setExtLightLeavingHome(new TimeState(this.leavingHomeTimeState.getTime(), bl));
    }

    private void setItemSelectedGlidingLight(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setExtLightGlidingLightSystem(%1)", bl);
        this.getDSI().setExtLightGlidingLightSystem(bl);
    }

    private void setItemSelectedLaserLight(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setExtLightLaserLight(%1)", bl);
        this.getDSI().setExtLightLaserLight(bl);
    }

    private void setItemSelectedMatrixBeamLight(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setItemSelectedMatrixBeamLight(%1)", bl);
        this.getDSI().setExtLightMaskedHighBeam(bl);
    }

    private void setItemSelectedAdaptiveLight(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setExtLightAdaptive(%1)", bl);
        this.getDSI().setExtLightAdaptive(bl);
    }

    private void setItemSelectedMotorwayBlinking(int n, boolean bl) {
        MotorwayBlinkingSettings motorwayBlinkingSettings = new MotorwayBlinkingSettings(n, bl);
        this.getLogChannel().log(1000000, "dsi.setExtLightMotorwayBlinking(%1)", (Object)motorwayBlinkingSettings);
        this.getDSI().setExtLightMotorwayBlinking(motorwayBlinkingSettings);
    }

    private void updateExtLightEnterExitCar() {
        this.getChoiceModel(600902).setValue(this.comingHomeTimeState.isState() && this.leavingHomeTimeState.isState() ? 1 : 0);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        boolean bl = n2 == 1;
        switch (n) {
            case 600900: {
                this.setItemSelectedDayLight(bl);
                break;
            }
            case 600913: 
            case 600915: {
                this.setItemSelectedTouristLight(bl);
                break;
            }
            case 600911: {
                this.setItemSelectedSwitchOnTime(n2);
                break;
            }
            case 600905: {
                this.setItemSelectedHeadLight(bl);
                break;
            }
            case 600903: {
                this.setItemSelectedGlidingLight(bl);
                break;
            }
            case 601301: {
                this.setItemSelectedLaserLight(bl);
                break;
            }
            case 600909: {
                this.setItemSelectedMatrixBeamLight(bl);
                break;
            }
            case 600892: {
                this.setItemSelectedAdaptiveLight(bl);
                break;
            }
            case 602346: {
                this.setItemSelectedMotorwayBlinking(1, bl);
                break;
            }
            case 600902: {
                this.setItemSelectedEnterCarExitCarLight(bl);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{12}, new int[]{18, 16, 20, 19, 22, 15, 17, 13, 14, 51, 21})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public void updateExtLightViewOptions(ExtLightViewOptions extLightViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateExtLightViewOptions: extLightViewOptions=%1, validFlag=%2", (Object)extLightViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = extLightViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateExtLightSwitchOnSensitivity(int n, int n2) {
        this.getLogChannel().log(10000000, "updateExtLightSwitchOnSensitivity: extLightSwitchOnSensitivity=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            int n3 = 0;
            switch (n) {
                case 0: {
                    n3 = 0;
                    break;
                }
                case 1: {
                    n3 = 1;
                    break;
                }
                case 2: {
                    n3 = 2;
                    break;
                }
                default: {
                    this.getLogChannel().log(10000, "updateExtLightSwitchOnSensitivity: value invalid: %1 ", (long)n);
                    n3 = 1;
                }
            }
            this.getChoiceModel(600911).setValue(n3);
        }
    }

    public void updateExtLightDaylight(boolean bl, int n) {
        this.getLogChannel().log(10000000, "updateExtLightDaylight: extLightDaylight=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600900).setValue(bl ? 1 : 0);
        }
    }

    public void updateExtLightTourist(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateExtLightTourist: extLightTourist=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600913).setValue(bl ? 1 : 0);
            this.getChoiceModel(600915).setValue(bl ? 1 : 0);
        }
    }

    public void updateExtLightHeadLightSystem(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateExtLightHeadLightSystem: extLightHeadLightSystem=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600905).setValue(bl ? 1 : 0);
        }
    }

    public void updateExtLightGlidingSystem(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateExtLightGlidingSystem: extLightGlidingSystem=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600903).setValue(bl ? 1 : 0);
        }
    }

    public void updateExtLightMaskedHighBeam(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateExtLightMaskedHighBeam: extLightMaskedHighBeam=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600909).setValue(bl ? 1 : 0);
        }
    }

    public void updateExtLightComingHome(TimeState timeState, int n) {
        this.getLogChannel().log(1000000, "updateExtLightComingHome: extLightComingHome=%1, validFlag=%2", (Object)timeState, (long)n);
        if (n == 1 && timeState != null) {
            this.comingHomeTimeState = timeState;
            this.updateExtLightEnterExitCar();
        }
    }

    public void updateExtLightLaserLight(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateExtLightLaserLight: state=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(601301).setValue(bl ? 1 : 0);
        }
    }

    public void updateExtLightLeavingHome(TimeState timeState, int n) {
        this.getLogChannel().log(1000000, "updateExtLightLeavingHome: extLightLeavingHome=%1, validFlag=%2", (Object)timeState, (long)n);
        if (n == 1 && timeState != null) {
            this.leavingHomeTimeState = timeState;
            this.updateExtLightEnterExitCar();
        }
    }

    public void updateExtLightAdaptive(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateExtLightAdaptive: updateExtLightAdaptive=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600892).setValue(bl ? 1 : 0);
        }
    }

    public void updateExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings, int n) {
        this.getLogChannel().log(1000000, "[AbstractExtLightComponent#updateExtLightMotorwayBlinking] setting=%1, validFlag=%2", (Object)(null == motorwayBlinkingSettings ? "null" : motorwayBlinkingSettings.toString()), (long)n);
        if (n == 1) {
            this.getChoiceModel(602346).setValue(motorwayBlinkingSettings.isState() ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(ExtLightViewOptions var1);

    public String getName() {
        return "ExtLight";
    }
}

