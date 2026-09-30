/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.RangeListener;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDViewOptions;

public abstract class AbstractHUDComponent
extends AbstractDSICarKombiAdapter
implements ChoiceListener,
RangeListener {
    public static final short CODING_ID = 22;
    private static final String LOGCHANNEL_NAME = "App.Car.HUD";
    private static final int RNG_MIN_BRIGHTNESS = 0;
    private static final int RNG_MAX_BRIGHTNESS = 100;
    private static final int RNG_STEP_BRIGHTNESS = 10;
    private static final int MIN_ROTATION = -10;
    private static final int MAX_ROTATION = 10;
    private static final int STEP_ROTATION = 1;
    protected volatile HUDContent currContent = new HUDContent();
    protected volatile HUDViewOptions currViewOptions;
    private RangeModelWatcherTimer brightnessWatcher;
    private RangeModelWatcherTimer rotationWatcher;

    public AbstractHUDComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getRangeModel(600920).setRangeListener(this);
        this.getRangeModel(600920).setLimits(0, 100, 10);
        this.getRangeModel(601110).setRangeListener(this);
        this.getRangeModel(601110).setLimits(-10, 10, 1);
        this.brightnessWatcher = new RangeModelWatcherTimer("HUD_BRIGHTNESS_RANGE", this.getRangeModel(600920), 1000L, this.getLogChannel());
        this.rotationWatcher = new RangeModelWatcherTimer("HUD_ROTATION_RANGE", this.getRangeModel(601110), 1000L, this.getLogChannel());
        this.getChoiceModel(600917).setChoiceListener(this);
        this.getChoiceModel(600923).setChoiceListener(this);
        this.getChoiceModel(600925).setChoiceListener(this);
        this.getChoiceModel(600935).setChoiceListener(this);
        this.getChoiceModel(600931).setChoiceListener(this);
        this.getChoiceModel(600937).setChoiceListener(this);
        this.getChoiceModel(600933).setChoiceListener(this);
        this.getChoiceModel(601108).setChoiceListener(this);
        this.getChoiceModel(601124).setChoiceListener(this);
        this.getChoiceModel(602109).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getRangeModel(600920).resetListener();
        this.getRangeModel(601110).resetListener();
        this.getChoiceModel(600917).resetListener();
        this.getChoiceModel(600923).resetListener();
        this.getChoiceModel(600925).resetListener();
        this.getChoiceModel(600935).resetListener();
        this.getChoiceModel(600931).resetListener();
        this.getChoiceModel(600937).resetListener();
        this.getChoiceModel(600933).resetListener();
        this.getChoiceModel(601108).resetListener();
        this.getChoiceModel(601124).resetListener();
        this.getChoiceModel(602109).resetListener();
    }

    private void modifyRange(int n, int n2, int n3) {
        switch (n) {
            case 600920: {
                this.setBrightness(n2);
                break;
            }
            case 601110: {
                this.setRotation(n2);
                break;
            }
            default: {
                this.logModelData("increment or decrement:", n, n2, false);
            }
        }
    }

    protected void setHUDContent() {
        this.getLogChannel().log(10000000, "dsi.setHUDContent(%1)", (Object)this.currContent);
        this.getDSI().setHUDContent(this.currContent);
    }

    private void setBrightness(int n) {
        this.getLogChannel().log(10000000, "setBrightness: steps:%1", (long)n);
        int n2 = AbstractHUDComponent.clip(this.getRangeModel(600920).getValue() + n, 0, 100);
        this.getLogChannel().log(1000000, "setBrightness: dsi.setHUDBrightness(%1)", (long)n2);
        this.brightnessWatcher.setTempValue(n2);
        this.getDSI().setHUDBrightness((byte)n2);
    }

    private void setRotation(int n) {
        this.getLogChannel().log(1000000, "setRotation: steps: %1", (long)n);
        int n2 = AbstractHUDComponent.clip(this.getRangeModel(601110).getValue() + n, -10, 10);
        this.getLogChannel().log(1000000, "setRotation: dsi.setHUDRotationAdjustment(%1)", (long)n2);
        this.rotationWatcher.setTempValue(n2);
        this.getDSI().setHUDRotationAdjustment(n2);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("keyPressed:", n, n2, true);
        switch (n) {
            case 600920: {
                this.getRangeModel(n).fireEvent(n3);
                break;
            }
            case 601110: {
                this.getRangeModel(n).fireEvent(n3);
                break;
            }
            default: {
                this.logModelData("keyPressed:", n, n2, false);
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void decrement(int n, int n2, int n3) {
        this.logModelData("decrement", n, n2, true);
        this.modifyRange(n, -n2, n3);
    }

    public void increment(int n, int n2, int n3) {
        this.logModelData("increment", n, n2, true);
        this.modifyRange(n, n2, n3);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        boolean bl = n2 == 1;
        block0 : switch (n) {
            case 600917: {
                this.currContent.acc = bl;
                this.setHUDContent();
                break;
            }
            case 600925: {
                this.currContent.hca = bl;
                this.setHUDContent();
                break;
            }
            case 600923: {
                if (this.isOnlySpeedLimiterGRA()) {
                    this.currContent.speedLimiter = bl;
                }
                this.currContent.gra = bl;
                this.setHUDContent();
                break;
            }
            case 600931: {
                this.currContent.nightvision = bl;
                this.setHUDContent();
                break;
            }
            case 600937: {
                this.currContent.roadsign = bl;
                this.setHUDContent();
                break;
            }
            case 600933: {
                this.currContent.telephone = bl;
                this.setHUDContent();
                break;
            }
            case 600935: {
                this.currContent.rgi = bl;
                this.setHUDContent();
                break;
            }
            case 601108: {
                this.currContent.efficiencyAssist = bl;
                this.setHUDContent();
                break;
            }
            case 601124: {
                this.currContent.speedLimiter = bl;
                this.setHUDContent();
                break;
            }
            case 602109: {
                switch (n2) {
                    case 0: {
                        this.currContent.rgi = false;
                        this.currContent.navInfo = false;
                        this.setHUDContent();
                        break block0;
                    }
                    case 1: {
                        this.currContent.rgi = true;
                        this.currContent.navInfo = false;
                        this.setHUDContent();
                        break block0;
                    }
                    case 2: {
                        this.currContent.rgi = true;
                        this.currContent.navInfo = true;
                        this.setHUDContent();
                        break block0;
                    }
                }
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
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{37}, new int[]{40, 39, 38, 66})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public HUDViewOptions getViewOptions() {
        return this.currViewOptions;
    }

    public void updateHUDBrightness(byte by, int n) {
        this.getLogChannel().log(1000000, "updateHUDBrightness: '%1', valid='%2'", (long)by, (long)n);
        if (n == 1) {
            this.brightnessWatcher.setValidValue(by);
        }
    }

    public void updateHUDRotationAdjustment(int n, int n2) {
        this.getLogChannel().log(1000000, "updateHUDRotationAdjustment: '%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.rotationWatcher.setValidValue(n);
        }
    }

    public void updateHUDContent(HUDContent hUDContent, int n) {
        this.getLogChannel().log(1000000, "updateHUDContent: '%1', valid='%2'", (Object)hUDContent, (long)n);
        if (n == 1) {
            this.currContent = hUDContent;
            this.getChoiceModel(600917).setValue(hUDContent.acc ? 1 : 0);
            this.getChoiceModel(600923).setValue(hUDContent.gra ? 1 : 0);
            this.getChoiceModel(600925).setValue(hUDContent.hca ? 1 : 0);
            this.getChoiceModel(600935).setValue(hUDContent.rgi ? 1 : 0);
            if (hUDContent.rgi && hUDContent.navInfo) {
                this.getChoiceModel(602109).setValue(2);
            } else if (hUDContent.rgi && !hUDContent.navInfo) {
                this.getChoiceModel(602109).setValue(1);
            } else if (!hUDContent.rgi && !hUDContent.navInfo) {
                this.getChoiceModel(602109).setValue(0);
            }
            this.getChoiceModel(600931).setValue(hUDContent.nightvision ? 1 : 0);
            this.getChoiceModel(600937).setValue(hUDContent.roadsign ? 1 : 0);
            this.getChoiceModel(600933).setValue(hUDContent.telephone ? 1 : 0);
            this.getChoiceModel(601108).setValue(hUDContent.efficiencyAssist ? 1 : 0);
            this.getChoiceModel(601124).setValue(hUDContent.speedLimiter ? 1 : 0);
        }
    }

    public void updateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateHUDViewOptions: '%1', valid='%2'", (Object)(hUDViewOptions != null ? this.formatViewOptionsLog(hUDViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && hUDViewOptions != null) {
            this.currViewOptions = hUDViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    protected abstract void updateMenuEntryVisibility(HUDViewOptions var1);

    protected abstract boolean isOnlySpeedLimiterGRA();

    public String getName() {
        return "HUD";
    }
}

