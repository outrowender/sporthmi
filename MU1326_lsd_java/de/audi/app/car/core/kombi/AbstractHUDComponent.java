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
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private static final int RNG_MIN_BRIGHTNESS;
    private static final int RNG_MAX_BRIGHTNESS;
    private static final int RNG_STEP_BRIGHTNESS;
    private static final int MIN_ROTATION;
    private static final int MAX_ROTATION;
    private static final int STEP_ROTATION;
    protected volatile HUDContent currContent = new HUDContent();
    protected volatile HUDViewOptions currViewOptions;
    private RangeModelWatcherTimer brightnessWatcher;
    private RangeModelWatcherTimer rotationWatcher;

    public AbstractHUDComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.HUD");
    }

    @Override
    protected void initModels() {
        this.getRangeModel(1479215360).setRangeListener(this);
        this.getRangeModel(1479215360).setLimits(0, 100, 10);
        this.getRangeModel(371984640).setRangeListener(this);
        this.getRangeModel(371984640).setLimits(-10, 10, 1);
        this.brightnessWatcher = new RangeModelWatcherTimer("HUD_BRIGHTNESS_RANGE", this.getRangeModel(1479215360), 0, this.getLogChannel());
        this.rotationWatcher = new RangeModelWatcherTimer("HUD_ROTATION_RANGE", this.getRangeModel(371984640), 0, this.getLogChannel());
        this.getChoiceModel(1428883712).setChoiceListener(this);
        this.getChoiceModel(1529547008).setChoiceListener(this);
        this.getChoiceModel(1563101440).setChoiceListener(this);
        this.getChoiceModel(1730873600).setChoiceListener(this);
        this.getChoiceModel(1663764736).setChoiceListener(this);
        this.getChoiceModel(1764428032).setChoiceListener(this);
        this.getChoiceModel(1697319168).setChoiceListener(this);
        this.getChoiceModel(338430208).setChoiceListener(this);
        this.getChoiceModel(606865664).setChoiceListener(this);
        this.getChoiceModel(-47249152).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getRangeModel(1479215360).resetListener();
        this.getRangeModel(371984640).resetListener();
        this.getChoiceModel(1428883712).resetListener();
        this.getChoiceModel(1529547008).resetListener();
        this.getChoiceModel(1563101440).resetListener();
        this.getChoiceModel(1730873600).resetListener();
        this.getChoiceModel(1663764736).resetListener();
        this.getChoiceModel(1764428032).resetListener();
        this.getChoiceModel(1697319168).resetListener();
        this.getChoiceModel(338430208).resetListener();
        this.getChoiceModel(606865664).resetListener();
        this.getChoiceModel(-47249152).resetListener();
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
        this.getLogChannel().log(-2137614336, "dsi.setHUDContent(%1)", (Object)this.currContent);
        this.getDSI().setHUDContent(this.currContent);
    }

    private void setBrightness(int n) {
        this.getLogChannel().log(-2137614336, "setBrightness: steps:%1", (long)n);
        int n2 = AbstractHUDComponent.clip(this.getRangeModel(1479215360).getValue() + n, 0, 100);
        this.getLogChannel().log(1078071040, "setBrightness: dsi.setHUDBrightness(%1)", (long)n2);
        this.brightnessWatcher.setTempValue(n2);
        this.getDSI().setHUDBrightness((byte)n2);
    }

    private void setRotation(int n) {
        this.getLogChannel().log(1078071040, "setRotation: steps: %1", (long)n);
        int n2 = AbstractHUDComponent.clip(this.getRangeModel(371984640).getValue() + n, -10, 10);
        this.getLogChannel().log(1078071040, "setRotation: dsi.setHUDRotationAdjustment(%1)", (long)n2);
        this.rotationWatcher.setTempValue(n2);
        this.getDSI().setHUDRotationAdjustment(n2);
    }

    @Override
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

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.logModelData("decrement", n, n2, true);
        this.modifyRange(n, -n2, n3);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.logModelData("increment", n, n2, true);
        this.modifyRange(n, n2, n3);
    }

    @Override
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

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{37}, new int[]{40, 39, 38, 66})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public HUDViewOptions getViewOptions() {
        return this.currViewOptions;
    }

    @Override
    public void updateHUDBrightness(byte by, int n) {
        this.getLogChannel().log(1078071040, "updateHUDBrightness: '%1', valid='%2'", (long)by, (long)n);
        if (n == 1) {
            this.brightnessWatcher.setValidValue(by);
        }
    }

    @Override
    public void updateHUDRotationAdjustment(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateHUDRotationAdjustment: '%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.rotationWatcher.setValidValue(n);
        }
    }

    @Override
    public void updateHUDContent(HUDContent hUDContent, int n) {
        this.getLogChannel().log(1078071040, "updateHUDContent: '%1', valid='%2'", (Object)hUDContent, (long)n);
        if (n == 1) {
            this.currContent = hUDContent;
            this.getChoiceModel(1428883712).setValue(hUDContent.acc ? 1 : 0);
            this.getChoiceModel(1529547008).setValue(hUDContent.gra ? 1 : 0);
            this.getChoiceModel(1563101440).setValue(hUDContent.hca ? 1 : 0);
            this.getChoiceModel(1730873600).setValue(hUDContent.rgi ? 1 : 0);
            if (hUDContent.rgi && hUDContent.navInfo) {
                this.getChoiceModel(-47249152).setValue(2);
            } else if (hUDContent.rgi && !hUDContent.navInfo) {
                this.getChoiceModel(-47249152).setValue(1);
            } else if (!hUDContent.rgi && !hUDContent.navInfo) {
                this.getChoiceModel(-47249152).setValue(0);
            }
            this.getChoiceModel(1663764736).setValue(hUDContent.nightvision ? 1 : 0);
            this.getChoiceModel(1764428032).setValue(hUDContent.roadsign ? 1 : 0);
            this.getChoiceModel(1697319168).setValue(hUDContent.telephone ? 1 : 0);
            this.getChoiceModel(338430208).setValue(hUDContent.efficiencyAssist ? 1 : 0);
            this.getChoiceModel(606865664).setValue(hUDContent.speedLimiter ? 1 : 0);
        }
    }

    @Override
    public void updateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateHUDViewOptions: '%1', valid='%2'", (Object)(hUDViewOptions != null ? this.formatViewOptionsLog(hUDViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && hUDViewOptions != null) {
            this.currViewOptions = hUDViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    protected abstract void updateMenuEntryVisibility(HUDViewOptions hUDViewOptions) {
    }

    protected abstract boolean isOnlySpeedLimiterGRA() {
    }

    @Override
    public String getName() {
        return "HUD";
    }
}

