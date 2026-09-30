/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.DefaultIntValueConverterStrategy;
import de.audi.app.car.common.util.IIntValueConverterStrategy;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import org.dsi.ifc.cardriverassistance.NVViewOptions;

public abstract class AbstractNVComponent
extends AbstractDSICarDriverAssistanceAdapter
implements RangeListener {
    public static final short CODING_ID = 26;
    private static final String LOGCHANNEL_NAME = "App.Car.NV";
    private volatile NVViewOptions currViewOptions;
    private static final int NV_CONTRAST_MIN = 5;
    private static final int NV_CONTRAST_MAX = 95;
    private static final int NV_CONTRAST_STEP = 5;
    private RangeModelWatcherTimer nvContrastRangeWatcher;
    private static final int ATTR_NVCONTRAST = 10;
    private IIntValueConverterStrategy nvContrastValueConverterStrategy = new DefaultIntValueConverterStrategy();

    public AbstractNVComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    public IIntValueConverterStrategy getNvContrastValueConverterStrategy() {
        return this.nvContrastValueConverterStrategy;
    }

    public void setNvContrastValueConverterStrategy(IIntValueConverterStrategy iIntValueConverterStrategy) {
        this.nvContrastValueConverterStrategy = iIntValueConverterStrategy;
    }

    protected void changeValue(int n) {
        int n2 = this.getRangeModel(600333).getValue();
        int n3 = AbstractNVComponent.clip(n2 + n, 5, 95);
        try {
            int n4 = this.getNvContrastValueConverterStrategy().getDSIValue(n3);
            this.nvContrastRangeWatcher.setTempValue(n3);
            this.getLogChannel().log(1000000, "dsi.setNVContrast(%1)", (long)n4);
            this.getDSI().setNVContrast(n4);
        }
        catch (ValueConverterStrategyException valueConverterStrategyException) {
            this.getLogChannel().log(10000, "[AbstractNVComponent#changeValue] ValueConverterStrategyException occurred. Reason: ", (long)valueConverterStrategyException.getReason());
        }
    }

    protected void initModels() {
        RangeModelApp rangeModelApp = this.getRangeModel(600333);
        rangeModelApp.setRangeListener(this);
        rangeModelApp.setLimits(5, 95, 5);
        this.nvContrastRangeWatcher = new RangeModelWatcherTimer("NightVisionContrast", rangeModelApp, 1000L, this.getLogChannel());
    }

    protected void deinitModels() {
        this.getRangeModel(600333).resetListener();
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("keyPressed:", n, n2, true);
        switch (n) {
            case 600333: {
                this.getRangeModel(600333).fireEvent(n3);
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
        this.changeValue(-n2);
    }

    public void increment(int n, int n2, int n3) {
        this.logModelData("increment", n, n2, true);
        this.changeValue(n2);
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{8}, new int[]{10})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public void updateNVViewOptions(NVViewOptions nVViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateNVViewOptions(%1,%2)", (Object)nVViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = nVViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateNVContrast(int n, int n2) {
        this.getLogChannel().log(1000000, "updateNVContrast(%1,%2)", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                int n3 = this.getNvContrastValueConverterStrategy().getHMIValue(n);
                this.nvContrastRangeWatcher.setValidValue(n3);
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(10000, "[AbstractNVComponent#changeValue] ValueConverterStrategyException occurred. Reason: ", (long)valueConverterStrategyException.getReason());
            }
        }
    }

    public RangeModelApp getNVRangeModel() {
        return this.getRangeModel(600333);
    }

    public RangeModelWatcherTimer getNvContrastRangeWatcher() {
        return this.nvContrastRangeWatcher;
    }

    protected abstract void updateMenuEntryVisibility(NVViewOptions var1);

    public String getName() {
        return "NightVision";
    }
}

