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
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile NVViewOptions currViewOptions;
    private static final int NV_CONTRAST_MIN;
    private static final int NV_CONTRAST_MAX;
    private static final int NV_CONTRAST_STEP;
    private RangeModelWatcherTimer nvContrastRangeWatcher;
    private static final int ATTR_NVCONTRAST;
    private IIntValueConverterStrategy nvContrastValueConverterStrategy = new DefaultIntValueConverterStrategy();

    public AbstractNVComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.NV");
    }

    public IIntValueConverterStrategy getNvContrastValueConverterStrategy() {
        return this.nvContrastValueConverterStrategy;
    }

    public void setNvContrastValueConverterStrategy(IIntValueConverterStrategy iIntValueConverterStrategy) {
        this.nvContrastValueConverterStrategy = iIntValueConverterStrategy;
    }

    protected void changeValue(int n) {
        int n2 = this.getRangeModel(220793088).getValue();
        int n3 = AbstractNVComponent.clip(n2 + n, 5, 95);
        try {
            int n4 = this.getNvContrastValueConverterStrategy().getDSIValue(n3);
            this.nvContrastRangeWatcher.setTempValue(n3);
            this.getLogChannel().log(1078071040, "dsi.setNVContrast(%1)", (long)n4);
            this.getDSI().setNVContrast(n4);
        }
        catch (ValueConverterStrategyException valueConverterStrategyException) {
            this.getLogChannel().log(10000, "[AbstractNVComponent#changeValue] ValueConverterStrategyException occurred. Reason: ", (long)valueConverterStrategyException.getReason());
        }
    }

    @Override
    protected void initModels() {
        RangeModelApp rangeModelApp = this.getRangeModel(220793088);
        rangeModelApp.setRangeListener(this);
        rangeModelApp.setLimits(5, 95, 5);
        this.nvContrastRangeWatcher = new RangeModelWatcherTimer("NightVisionContrast", rangeModelApp, 0, this.getLogChannel());
    }

    @Override
    protected void deinitModels() {
        this.getRangeModel(220793088).resetListener();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("keyPressed:", n, n2, true);
        switch (n) {
            case 600333: {
                this.getRangeModel(220793088).fireEvent(n3);
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
        this.changeValue(-n2);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.logModelData("increment", n, n2, true);
        this.changeValue(n2);
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{8}, new int[]{10})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    @Override
    public void updateNVViewOptions(NVViewOptions nVViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateNVViewOptions(%1,%2)", (Object)nVViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = nVViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateNVContrast(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateNVContrast(%1,%2)", (long)n, (long)n2);
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
        return this.getRangeModel(220793088);
    }

    public RangeModelWatcherTimer getNvContrastRangeWatcher() {
        return this.nvContrastRangeWatcher;
    }

    protected abstract void updateMenuEntryVisibility(NVViewOptions nVViewOptions) {
    }

    @Override
    public String getName() {
        return "NightVision";
    }
}

