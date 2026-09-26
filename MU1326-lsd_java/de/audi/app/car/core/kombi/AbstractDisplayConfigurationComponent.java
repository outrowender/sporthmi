/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.common.util.DefaultIntValueConverterStrategy;
import de.audi.app.car.common.util.IIntValueConverterStrategy;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.app.car.core.kombi.AbstractDisplayConfigurationComponent$1;
import de.audi.app.car.core.kombi.AbstractDisplayConfigurationComponent$DisplayConfigurationController;
import de.audi.app.car.core.kombi.DisplayConfigurationConfig;
import de.audi.app.car.core.kombi.IDisplayConfigurationConstants;
import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCViewOptions;

public abstract class AbstractDisplayConfigurationComponent
extends AbstractDSICarKombiAdapter
implements IDisplayConfigurationConstants {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    protected static final int INVALID;
    protected static final int DISABLED;
    protected static final int ENABLED;
    protected final AbstractDisplayConfigurationComponent$DisplayConfigurationController displayConfigurationController;
    protected IIntValueConverterStrategy brightnessRangeValueConverterStrategy = new DefaultIntValueConverterStrategy();
    protected IIntValueConverterStrategy volumeRangeValueConverterStrategy = new DefaultIntValueConverterStrategy();
    private volatile DCViewOptions currentViewOptions;
    private RangeModelWatcherTimer brightnessModelWatcher;
    private RangeModelWatcherTimer volumeModelWatcher;
    private final DefaultRangeListener rangeModelListener = new AbstractDisplayConfigurationComponent$1(this);

    public AbstractDisplayConfigurationComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.DisplayConfiguration");
        this.setLogChannelDSI(true);
        this.setLogChannelMSC(true);
        this.displayConfigurationController = new AbstractDisplayConfigurationComponent$DisplayConfigurationController(this);
    }

    protected abstract DisplayConfigurationConfig getConfig() {
    }

    protected abstract void updateMenuEntryVisibility(DCViewOptions dCViewOptions) {
    }

    protected abstract void notifyDisplayConfigurationChanged() {
    }

    protected abstract void onDCDisplaySetupUpdate(int n, DCMainItems dCMainItems) {
    }

    protected abstract void onDCDisplaySelectionUpdate(int n, DCMainItems dCMainItems) {
    }

    protected abstract void onDCAdditionalInstrumentSetupUpdate(DCAdditionalInstrument dCAdditionalInstrument) {
    }

    @Override
    public String getName() {
        return "Display Configuration";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{82}, new int[]{83, 84, 89, 86, 90, 87, 91, 88, 85, 92, 93})};
    }

    @Override
    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append(null == this.currentViewOptions ? "No view options received yet" : this.currentViewOptions.toString());
        return buffer.toString();
    }

    @Override
    protected void initModels() {
        this.getRangeModel(-1255143168).setRangeListener(this.rangeModelListener);
        this.getRangeModel(-1255143168).setLimits(this.getConfig().getDCBrightnessRangeMin(), this.getConfig().getDCBrightnessRangeMax(), this.getConfig().getDCBrightnessRangeStep());
        this.brightnessModelWatcher = new RangeModelWatcherTimer("DC_BRIGHTNESS_RANGE", this.getRangeModel(-1255143168), this.getConfig().getWatchdogTimeout(), this.getLogChannel());
        this.getRangeModel(-751826688).setRangeListener(this.rangeModelListener);
        this.getRangeModel(-751826688).setLimits(this.getConfig().getDCVolumeRangeMin(), this.getConfig().getDCVolumeRangeMax(), this.getConfig().getDCVolumeRangeStep());
        this.volumeModelWatcher = new RangeModelWatcherTimer("DC_VOLUME_RANGE", this.getRangeModel(-751826688), this.getConfig().getWatchdogTimeout(), this.getLogChannel());
    }

    @Override
    protected void deinitModels() {
        this.brightnessModelWatcher.forceCancelTimer();
        this.brightnessModelWatcher = null;
        this.getRangeModel(-1255143168).resetListener();
        this.volumeModelWatcher.forceCancelTimer();
        this.volumeModelWatcher = null;
        this.getRangeModel(-751826688).resetListener();
    }

    @Override
    public void updateDCViewOptions(DCViewOptions dCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractDisplayConfigurationComponent#updateDCViewOptions] viewOptions='%1', valid='%2'", (Object)(null != dCViewOptions ? this.formatViewOptionsLog(dCViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1) {
            this.currentViewOptions = dCViewOptions;
            this.updateMenuEntryVisibility(dCViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateDCBrightness(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCBrightness('%1'), valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            try {
                if (null != this.brightnessModelWatcher) {
                    this.brightnessModelWatcher.setValidValue(this.brightnessRangeValueConverterStrategy.getHMIValue(n));
                }
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "AbstractDisplayConfigurationComponent#updateDCBrightness] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }
    }

    @Override
    public void updateDCVolume(int n, int n2) {
        this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCVolume('%1'), valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            try {
                if (null != this.volumeModelWatcher) {
                    this.volumeModelWatcher.setValidValue(this.volumeRangeValueConverterStrategy.getHMIValue(n));
                }
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(-1601830656, "AbstractDisplayConfigurationComponent#updateDCVolume] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }
    }

    @Override
    public void updateDCDisplay1Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        if (this.getLogChannel(1).isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append(null == dCMainItems ? "null" : dCMainItems.toString()).append(", ");
            buffer.append(null == dCDisplayedAdditionalInfos ? "null" : dCDisplayedAdditionalInfos.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo ? "null" : dCAdditionalInfo.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo2 ? "null" : dCAdditionalInfo2.toString());
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCDisplay1Setup('%1'), valid='%2'", (Object)buffer.toString(), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySetupUpdate(1, dCMainItems);
        }
    }

    @Override
    public void updateDCDisplay2Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        if (this.getLogChannel(1).isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append(null == dCMainItems ? "null" : dCMainItems.toString()).append(", ");
            buffer.append(null == dCDisplayedAdditionalInfos ? "null" : dCDisplayedAdditionalInfos.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo ? "null" : dCAdditionalInfo.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo2 ? "null" : dCAdditionalInfo2.toString());
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCDisplay2Setup('%1'), valid='%2'", (Object)buffer.toString(), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySetupUpdate(2, dCMainItems);
        }
    }

    @Override
    public void updateDCDisplay3Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        if (this.getLogChannel(1).isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append(null == dCMainItems ? "null" : dCMainItems.toString()).append(", ");
            buffer.append(null == dCDisplayedAdditionalInfos ? "null" : dCDisplayedAdditionalInfos.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo ? "null" : dCAdditionalInfo.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo2 ? "null" : dCAdditionalInfo2.toString());
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCDisplay3Setup('%1'), valid='%2'", (Object)buffer.toString(), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySetupUpdate(3, dCMainItems);
        }
    }

    @Override
    public void updateDCDisplay1MainSelection(DCMainItems dCMainItems, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCDisplay1MainSelection('%1'), valid='%2'", (Object)(null == dCMainItems ? "null" : dCMainItems.toString()), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySelectionUpdate(1, dCMainItems);
        }
    }

    @Override
    public void updateDCDisplay2MainSelection(DCMainItems dCMainItems, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCDisplay2MainSelection('%1'), valid='%2'", (Object)(null == dCMainItems ? "null" : dCMainItems.toString()), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySelectionUpdate(2, dCMainItems);
        }
    }

    @Override
    public void updateDCDisplay3MainSelection(DCMainItems dCMainItems, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCDisplay3MainSelection('%1'), valid='%2'", (Object)(null == dCMainItems ? "null" : dCMainItems.toString()), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySelectionUpdate(3, dCMainItems);
        }
    }

    @Override
    public void updateDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCAdditionalInstrumentSetup('%1'), valid='%2'", (Object)(null == dCAdditionalInstrument ? "null" : dCAdditionalInstrument.toString()), (long)n);
        }
        if (1 == n) {
            this.onDCAdditionalInstrumentSetupUpdate(dCAdditionalInstrument);
        }
    }

    @Override
    public void updateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateDCElementContentSelectionListTotalNumberOfElements('%1'), valid='%2'", (long)n, (long)n2);
        }
        if (1 == n2) {
            this.displayConfigurationController.updateTotalNumberOfElements(n);
        }
    }

    @Override
    public void responseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] (StatusArray) | responseDCElementContentSelectionListRAF('%1'), listOfPos='%2'", (Object)(null == dCElementContentSelectionListUpdateInfo ? "null" : dCElementContentSelectionListUpdateInfo.toString()), (Object)nArray);
        }
        this.displayConfigurationController.responseDCElementContentSelectionList(dCElementContentSelectionListUpdateInfo, nArray);
    }

    @Override
    public void responseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] (StatusArray) responseDCElementContentSelectionListRA1('%1', '%2')", (Object)(null == dCElementContentSelectionListUpdateInfo ? "null" : dCElementContentSelectionListUpdateInfo.toString()), (Object)(null == dCElementContentSelectionListRA1Array ? "null" : dCElementContentSelectionListRA1Array.toString()));
        }
        this.displayConfigurationController.responseDCElementContentSelectionList(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
    }

    @Override
    public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] (ChangedArray) | updateDCElementContentSelectionListUpdateInfo('%1', '%2'), valid='%3'", (Object)(null == dCElementContentSelectionListUpdateInfo ? "null" : dCElementContentSelectionListUpdateInfo.toString()), (Object)nArray, (long)n);
        }
        if (1 == n) {
            this.displayConfigurationController.updateDCElementContentSelectionListUpdateInfo(dCElementContentSelectionListUpdateInfo, nArray);
        }
    }

    static /* synthetic */ DCViewOptions access$000(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent) {
        return abstractDisplayConfigurationComponent.currentViewOptions;
    }

    static /* synthetic */ RangeModelApp access$100(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent, int n) {
        return abstractDisplayConfigurationComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$200(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent, int n) {
        return abstractDisplayConfigurationComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$300(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent, int n) {
        return abstractDisplayConfigurationComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$400(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent, int n) {
        return abstractDisplayConfigurationComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelWatcherTimer access$500(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent) {
        return abstractDisplayConfigurationComponent.brightnessModelWatcher;
    }

    static /* synthetic */ RangeModelWatcherTimer access$600(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent) {
        return abstractDisplayConfigurationComponent.volumeModelWatcher;
    }
}

