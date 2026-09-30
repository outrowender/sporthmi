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
import de.audi.app.car.core.kombi.DisplayConfigurationConfig;
import de.audi.app.car.core.kombi.IDisplayConfigurationConstants;
import de.audi.atip.hmi.model.DefaultRangeListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCTransmittableElements;
import org.dsi.ifc.carkombi.DCViewOptions;

public abstract class AbstractDisplayConfigurationComponent
extends AbstractDSICarKombiAdapter
implements IDisplayConfigurationConstants {
    public static final short CODING_ID = 10;
    private static final String LOGCHANNEL_NAME = "App.Car.DisplayConfiguration";
    protected static final int INVALID = -1;
    protected static final int DISABLED = 0;
    protected static final int ENABLED = 1;
    protected final DisplayConfigurationController displayConfigurationController;
    protected IIntValueConverterStrategy brightnessRangeValueConverterStrategy = new DefaultIntValueConverterStrategy();
    protected IIntValueConverterStrategy volumeRangeValueConverterStrategy = new DefaultIntValueConverterStrategy();
    private volatile DCViewOptions currentViewOptions;
    private RangeModelWatcherTimer brightnessModelWatcher;
    private RangeModelWatcherTimer volumeModelWatcher;
    private final DefaultRangeListener rangeModelListener = new DefaultRangeListener(){

        public void decrement(int n, int n2, int n3) {
            AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "AbstractDisplayConfigurationComponent.DefaultRangeListener#decrement: '%1', modelID: '%2'", (long)n2, (long)n);
            switch (n) {
                case 602293: {
                    int n4 = AbstractDisplayConfigurationComponent.this.getRangeModel(n).getValue() - n2;
                    this.setBrightness(n4);
                    break;
                }
                case 602323: {
                    int n5 = AbstractDisplayConfigurationComponent.this.getRangeModel(n).getValue() - n2;
                    this.setVolume(n5);
                    break;
                }
                default: {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(100000, "AbstractDisplayConfigurationComponent.DefaultRangeListener#increment: ModelID='%1' not supported.", (long)n);
                }
            }
        }

        public void increment(int n, int n2, int n3) {
            AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "AbstractDisplayConfigurationComponent.DefaultRangeListener#increment: '%1', modelID: '%2'", (long)n2, (long)n);
            switch (n) {
                case 602293: {
                    int n4 = AbstractDisplayConfigurationComponent.this.getRangeModel(n).getValue() + n2;
                    this.setBrightness(n4);
                    break;
                }
                case 602323: {
                    int n5 = AbstractDisplayConfigurationComponent.this.getRangeModel(n).getValue() + n2;
                    this.setVolume(n5);
                    break;
                }
                default: {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(100000, "AbstractDisplayConfigurationComponent.DefaultRangeListener#increment: ModelID='%1' not supported.", (long)n);
                }
            }
        }

        private void setBrightness(int n) {
            AbstractDisplayConfigurationComponent.this.brightnessModelWatcher.setTempValue(n);
            try {
                AbstractDisplayConfigurationComponent.this.displayConfigurationController.dsiSetBrightness(AbstractDisplayConfigurationComponent.this.brightnessRangeValueConverterStrategy.getDSIValue(n));
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                AbstractDisplayConfigurationComponent.this.getLogChannel().log(100000, "AbstractDisplayConfigurationComponent.DefaultRangeListener#setVolume] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }

        private void setVolume(int n) {
            AbstractDisplayConfigurationComponent.this.volumeModelWatcher.setTempValue(n);
            try {
                AbstractDisplayConfigurationComponent.this.displayConfigurationController.dsiSetVolume(AbstractDisplayConfigurationComponent.this.volumeRangeValueConverterStrategy.getDSIValue(n));
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                AbstractDisplayConfigurationComponent.this.getLogChannel().log(100000, "AbstractDisplayConfigurationComponent.DefaultRangeListener#setVolume] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }
    };

    public AbstractDisplayConfigurationComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.setLogChannelDSI(true);
        this.setLogChannelMSC(true);
        this.displayConfigurationController = new DisplayConfigurationController();
    }

    protected abstract DisplayConfigurationConfig getConfig();

    protected abstract void updateMenuEntryVisibility(DCViewOptions var1);

    protected abstract void notifyDisplayConfigurationChanged();

    protected abstract void onDCDisplaySetupUpdate(int var1, DCMainItems var2);

    protected abstract void onDCDisplaySelectionUpdate(int var1, DCMainItems var2);

    protected abstract void onDCAdditionalInstrumentSetupUpdate(DCAdditionalInstrument var1);

    public String getName() {
        return "Display Configuration";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{82}, new int[]{83, 84, 89, 86, 90, 87, 91, 88, 85, 92, 93})};
    }

    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append(null == this.currentViewOptions ? "No view options received yet" : this.currentViewOptions.toString());
        return buffer.toString();
    }

    protected void initModels() {
        this.getRangeModel(602293).setRangeListener(this.rangeModelListener);
        this.getRangeModel(602293).setLimits(this.getConfig().getDCBrightnessRangeMin(), this.getConfig().getDCBrightnessRangeMax(), this.getConfig().getDCBrightnessRangeStep());
        this.brightnessModelWatcher = new RangeModelWatcherTimer("DC_BRIGHTNESS_RANGE", this.getRangeModel(602293), this.getConfig().getWatchdogTimeout(), this.getLogChannel());
        this.getRangeModel(602323).setRangeListener(this.rangeModelListener);
        this.getRangeModel(602323).setLimits(this.getConfig().getDCVolumeRangeMin(), this.getConfig().getDCVolumeRangeMax(), this.getConfig().getDCVolumeRangeStep());
        this.volumeModelWatcher = new RangeModelWatcherTimer("DC_VOLUME_RANGE", this.getRangeModel(602323), this.getConfig().getWatchdogTimeout(), this.getLogChannel());
    }

    protected void deinitModels() {
        this.brightnessModelWatcher.forceCancelTimer();
        this.brightnessModelWatcher = null;
        this.getRangeModel(602293).resetListener();
        this.volumeModelWatcher.forceCancelTimer();
        this.volumeModelWatcher = null;
        this.getRangeModel(602323).resetListener();
    }

    public void updateDCViewOptions(DCViewOptions dCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractDisplayConfigurationComponent#updateDCViewOptions] viewOptions='%1', valid='%2'", (Object)(null != dCViewOptions ? this.formatViewOptionsLog(dCViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1) {
            this.currentViewOptions = dCViewOptions;
            this.updateMenuEntryVisibility(dCViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateDCBrightness(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCBrightness('%1'), valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            try {
                if (null != this.brightnessModelWatcher) {
                    this.brightnessModelWatcher.setValidValue(this.brightnessRangeValueConverterStrategy.getHMIValue(n));
                }
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "AbstractDisplayConfigurationComponent#updateDCBrightness] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }
    }

    public void updateDCVolume(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCVolume('%1'), valid='%2'", (long)n, (long)n2);
        if (1 == n2) {
            try {
                if (null != this.volumeModelWatcher) {
                    this.volumeModelWatcher.setValidValue(this.volumeRangeValueConverterStrategy.getHMIValue(n));
                }
            }
            catch (ValueConverterStrategyException valueConverterStrategyException) {
                this.getLogChannel().log(100000, "AbstractDisplayConfigurationComponent#updateDCVolume] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
            }
        }
    }

    public void updateDCDisplay1Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        if (this.getLogChannel(1).isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append(null == dCMainItems ? "null" : dCMainItems.toString()).append(", ");
            buffer.append(null == dCDisplayedAdditionalInfos ? "null" : dCDisplayedAdditionalInfos.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo ? "null" : dCAdditionalInfo.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo2 ? "null" : dCAdditionalInfo2.toString());
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCDisplay1Setup('%1'), valid='%2'", (Object)buffer.toString(), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySetupUpdate(1, dCMainItems);
        }
    }

    public void updateDCDisplay2Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        if (this.getLogChannel(1).isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append(null == dCMainItems ? "null" : dCMainItems.toString()).append(", ");
            buffer.append(null == dCDisplayedAdditionalInfos ? "null" : dCDisplayedAdditionalInfos.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo ? "null" : dCAdditionalInfo.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo2 ? "null" : dCAdditionalInfo2.toString());
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCDisplay2Setup('%1'), valid='%2'", (Object)buffer.toString(), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySetupUpdate(2, dCMainItems);
        }
    }

    public void updateDCDisplay3Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        if (this.getLogChannel(1).isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append(null == dCMainItems ? "null" : dCMainItems.toString()).append(", ");
            buffer.append(null == dCDisplayedAdditionalInfos ? "null" : dCDisplayedAdditionalInfos.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo ? "null" : dCAdditionalInfo.toString()).append(", ");
            buffer.append(null == dCAdditionalInfo2 ? "null" : dCAdditionalInfo2.toString());
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCDisplay3Setup('%1'), valid='%2'", (Object)buffer.toString(), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySetupUpdate(3, dCMainItems);
        }
    }

    public void updateDCDisplay1MainSelection(DCMainItems dCMainItems, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCDisplay1MainSelection('%1'), valid='%2'", (Object)(null == dCMainItems ? "null" : dCMainItems.toString()), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySelectionUpdate(1, dCMainItems);
        }
    }

    public void updateDCDisplay2MainSelection(DCMainItems dCMainItems, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCDisplay2MainSelection('%1'), valid='%2'", (Object)(null == dCMainItems ? "null" : dCMainItems.toString()), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySelectionUpdate(2, dCMainItems);
        }
    }

    public void updateDCDisplay3MainSelection(DCMainItems dCMainItems, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCDisplay3MainSelection('%1'), valid='%2'", (Object)(null == dCMainItems ? "null" : dCMainItems.toString()), (long)n);
        }
        if (1 == n) {
            this.onDCDisplaySelectionUpdate(3, dCMainItems);
        }
    }

    public void updateDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCAdditionalInstrumentSetup('%1'), valid='%2'", (Object)(null == dCAdditionalInstrument ? "null" : dCAdditionalInstrument.toString()), (long)n);
        }
        if (1 == n) {
            this.onDCAdditionalInstrumentSetupUpdate(dCAdditionalInstrument);
        }
    }

    public void updateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateDCElementContentSelectionListTotalNumberOfElements('%1'), valid='%2'", (long)n, (long)n2);
        }
        if (1 == n2) {
            this.displayConfigurationController.updateTotalNumberOfElements(n);
        }
    }

    public void responseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] (StatusArray) | responseDCElementContentSelectionListRAF('%1'), listOfPos='%2'", (Object)(null == dCElementContentSelectionListUpdateInfo ? "null" : dCElementContentSelectionListUpdateInfo.toString()), (Object)nArray);
        }
        this.displayConfigurationController.responseDCElementContentSelectionList(dCElementContentSelectionListUpdateInfo, nArray);
    }

    public void responseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] (StatusArray) responseDCElementContentSelectionListRA1('%1', '%2')", (Object)(null == dCElementContentSelectionListUpdateInfo ? "null" : dCElementContentSelectionListUpdateInfo.toString()), (Object)(null == dCElementContentSelectionListRA1Array ? "null" : dCElementContentSelectionListRA1Array.toString()));
        }
        this.displayConfigurationController.responseDCElementContentSelectionList(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
    }

    public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] (ChangedArray) | updateDCElementContentSelectionListUpdateInfo('%1', '%2'), valid='%3'", (Object)(null == dCElementContentSelectionListUpdateInfo ? "null" : dCElementContentSelectionListUpdateInfo.toString()), (Object)nArray, (long)n);
        }
        if (1 == n) {
            this.displayConfigurationController.updateDCElementContentSelectionListUpdateInfo(dCElementContentSelectionListUpdateInfo, nArray);
        }
    }

    public static class DCElementSelectionEntry {
        private final String uniqueKey;
        private final int displayID;
        private final int contentNameID;
        private boolean selection;
        private boolean available;

        public DCElementSelectionEntry(String string, int n, int n2) {
            this.uniqueKey = string;
            this.displayID = n;
            this.contentNameID = n2;
        }

        public String getUniqueKey() {
            return this.uniqueKey;
        }

        public int getDisplayID() {
            return this.displayID;
        }

        public int getContentNameID() {
            return this.contentNameID;
        }

        public boolean isSelection() {
            return this.selection;
        }

        public void setSelection(boolean bl) {
            this.selection = bl;
        }

        public boolean isAvailable() {
            return this.available;
        }

        public void setAvailable(boolean bl) {
            this.available = bl;
        }
    }

    protected class DisplayConfigurationController {
        private final Object mutex = new Object();
        protected final DisplayConfigurationArrayHandler arrayHandler = new DisplayConfigurationArrayHandler();

        protected DisplayConfigurationController() {
        }

        public DCElementSelectionEntry getDCElementSelectionFromArray(int n, int n2) {
            DCElementSelectionEntry dCElementSelectionEntry = null;
            DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array = this.arrayHandler.getCurrentArray();
            if (null != dCElementContentSelectionListRA1Array) {
                for (int i2 = 0; i2 < dCElementContentSelectionListRA1Array.length; ++i2) {
                    if (null == dCElementContentSelectionListRA1Array[i2] || dCElementContentSelectionListRA1Array[i2].getDisplay() != n || dCElementContentSelectionListRA1Array[i2].getElement() != n2) continue;
                    dCElementSelectionEntry = new DCElementSelectionEntry("", n, dCElementContentSelectionListRA1Array[i2].getElementContent());
                    dCElementSelectionEntry.setAvailable(true);
                    dCElementSelectionEntry.setSelection(true);
                    break;
                }
            }
            return dCElementSelectionEntry;
        }

        public void dsiSetDisplayConfiguration(int n, DCElementSelectionEntry[] dCElementSelectionEntryArray) {
            DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo = new DCElementContentSelectionListUpdateInfo();
            dCElementContentSelectionListUpdateInfo.asgID = 1;
            dCElementContentSelectionListUpdateInfo.transactionID = this.arrayHandler.getNewTransactionID();
            dCElementContentSelectionListUpdateInfo.recordContent = 1;
            dCElementContentSelectionListUpdateInfo.arrayContent = 1;
            dCElementContentSelectionListUpdateInfo.startElement = 0;
            dCElementContentSelectionListUpdateInfo.numOfElements = dCElementSelectionEntryArray.length;
            DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array = new DCElementContentSelectionListRA1[dCElementSelectionEntryArray.length];
            for (int i2 = 0; i2 < dCElementSelectionEntryArray.length; ++i2) {
                dCElementContentSelectionListRA1Array[i2] = new DCElementContentSelectionListRA1();
                dCElementContentSelectionListRA1Array[i2].pos = i2;
                dCElementContentSelectionListRA1Array[i2].display = n;
                dCElementContentSelectionListRA1Array[i2].additionalInfo = 1;
                dCElementContentSelectionListRA1Array[i2].element = i2 + 1;
                dCElementContentSelectionListRA1Array[i2].elementContent = dCElementSelectionEntryArray[i2].getContentNameID();
            }
            this.arrayHandler.sendSetGetArray(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
        }

        public void dsiSetDisplayMainSelection(int n, DCMainItems dCMainItems) {
            switch (n) {
                case 1: {
                    AbstractDisplayConfigurationComponent.this.getLogChannel(1).log(1000000, "[HMI|--->>|DSI] setDCDisplay1MainSelection(%1)", (Object)dCMainItems);
                    AbstractDisplayConfigurationComponent.this.getDSI().setDCDisplay1MainSelection(dCMainItems);
                    break;
                }
                case 2: {
                    AbstractDisplayConfigurationComponent.this.getLogChannel(1).log(1000000, "[HMI|--->>|DSI] setDCDisplay2MainSelection(%1)", (Object)dCMainItems);
                    AbstractDisplayConfigurationComponent.this.getDSI().setDCDisplay2MainSelection(dCMainItems);
                    break;
                }
                case 3: {
                    AbstractDisplayConfigurationComponent.this.getLogChannel(1).log(1000000, "[HMI|--->>|DSI] setDCDisplay3MainSelection(%1)", (Object)dCMainItems);
                    AbstractDisplayConfigurationComponent.this.getDSI().setDCDisplay3MainSelection(dCMainItems);
                    break;
                }
                default: {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(10000, "[AbstractDisplayConfigurationComponent#dsiSetDisplayMainSelection] dsiDisplayID='%1' not supported.", (long)n);
                }
            }
        }

        public void dsiSetBrightness(int n) {
            AbstractDisplayConfigurationComponent.this.getLogChannel(1).log(1000000, "[HMI|--->>|DSI] setDCBrightness(%1)", (long)n);
            AbstractDisplayConfigurationComponent.this.getDSI().setDCBrightness(n);
        }

        public void dsiSetVolume(int n) {
            AbstractDisplayConfigurationComponent.this.getLogChannel(1).log(1000000, "[HMI|--->>|DSI] setDCVolume(%1)", (long)n);
            AbstractDisplayConfigurationComponent.this.getDSI().setDCVolume(n);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateTotalNumberOfElements(int n) {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractDisplayConfigurationComponent.this.getLogChannel().isInfo()) {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "[DisplayConfigurationController#updateTotalNumberOfElements] called.");
                }
                this.arrayHandler.setTotalNumberOfElements(n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void responseDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractDisplayConfigurationComponent.this.getLogChannel().isInfo()) {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "[DisplayConfigurationController#responseDCElementContentSelectionList] called.");
                }
                this.arrayHandler.receivedStatusArray(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void responseDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractDisplayConfigurationComponent.this.getLogChannel().isInfo()) {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "[DisplayConfigurationController#responseDCElementContentSelectionList] called.");
                }
                AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "[DisplayConfigurationController#responseDCElementContentSelectionList] Not implemented yet.");
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractDisplayConfigurationComponent.this.getLogChannel().isInfo()) {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "[DisplayConfigurationController#updateDCElementContentSelectionListUpdateInfo] called.");
                }
                this.arrayHandler.receivedChangedArray(dCElementContentSelectionListUpdateInfo, nArray);
            }
        }
    }

    protected class DisplayConfigurationArrayHandler {
        public static final int FULL_RANGE_UPDATE_START_ELEMENT = 0;
        public static final int FULL_RANGE_UPDATE_NUM_OF_ELEMENTS = -1;
        private int currentTransactionID = 0;
        private int totalNumberOfElements = 0;
        private int numOfTransmittedElements = 0;
        private volatile DCElementContentSelectionListRA1[] currentArray = new DCElementContentSelectionListRA1[0];

        protected DisplayConfigurationArrayHandler() {
        }

        public int getNewTransactionID() {
            this.currentTransactionID = this.getNextTransactionID(this.currentTransactionID);
            return this.currentTransactionID;
        }

        public int getNextTransactionID(int n) {
            return 0 >= n || 15 <= n ? 1 : n + 1;
        }

        public int getTotalNumberOfElements() {
            return this.totalNumberOfElements;
        }

        public void setTotalNumberOfElements(int n) {
            this.totalNumberOfElements = 0 < n ? n : 0;
            this.currentArray = new DCElementContentSelectionListRA1[this.totalNumberOfElements];
        }

        public DCElementContentSelectionListRA1[] getCurrentArray() {
            return this.currentArray;
        }

        public void sendSetGetArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
            AbstractDisplayConfigurationComponent.this.getLogChannel(2).log(1000000, "[HMI|--->>|DSI] (SetGetArray) setDCElementContentSelectionListRA1 | header='%1', data='%2'", (Object)dCElementContentSelectionListUpdateInfo, (Object)this.arrayDataToString(dCElementContentSelectionListRA1Array));
            AbstractDisplayConfigurationComponent.this.getDSI().setDCElementContentSelectionListRA1(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
        }

        public void sendGetArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
            AbstractDisplayConfigurationComponent.this.getLogChannel(2).log(1000000, "[HMI|--->>|DSI] (GetArray) requestDCElementContentSelectionList | header='%1'", (Object)dCElementContentSelectionListUpdateInfo);
            AbstractDisplayConfigurationComponent.this.getDSI().requestDCElementContentSelectionList(dCElementContentSelectionListUpdateInfo);
        }

        public void receivedStatusArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
            AbstractDisplayConfigurationComponent.this.getLogChannel(2).log(1000000, "[HMI|<<---|DSI] (StatusArray) responseDCElementContentSelectionList | header='%1', data'%2'", (Object)dCElementContentSelectionListUpdateInfo, (Object)this.arrayDataToString(dCElementContentSelectionListRA1Array));
            if (null != dCElementContentSelectionListUpdateInfo) {
                if (this.isValidASGID(dCElementContentSelectionListUpdateInfo.asgID)) {
                    this.decodeStatusArray(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
                } else {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "[DisplayConfigurationArrayHandler#receivedStatusArray] ASG_ID='%1'. Response ignored.", (long)dCElementContentSelectionListUpdateInfo.asgID);
                }
            }
        }

        public void receivedChangedArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
            AbstractDisplayConfigurationComponent.this.getLogChannel(2).log(1000000, "[HMI|<<---|DSI] (ChangedArray) updateDCElementContentSelectionListUpdateInfo | header='%1', listOfPos=''", (Object)dCElementContentSelectionListUpdateInfo, (Object)nArray);
            if (null != dCElementContentSelectionListUpdateInfo) {
                if (this.isValidASGID(dCElementContentSelectionListUpdateInfo.asgID)) {
                    this.decodeChangedArray(dCElementContentSelectionListUpdateInfo, nArray);
                } else {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "[DisplayConfigurationArrayHandler#receivedChangedArray] ASG_ID='%1'. Update ignored.", (long)dCElementContentSelectionListUpdateInfo.asgID);
                }
            }
        }

        public boolean isValidASGID(int n) {
            return 0 == n || 1 == n;
        }

        private boolean isForwardRequestRequired(int n) {
            return 0 <= n && 0 < this.getTotalNumberOfElements() - this.numOfTransmittedElements;
        }

        private void decodeStatusArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
            int n;
            if (dCElementContentSelectionListUpdateInfo.numOfElements != dCElementContentSelectionListRA1Array.length) {
                AbstractDisplayConfigurationComponent.this.getLogChannel().log(100000, "[DisplayConfigurationController#decodeStatusArray] Data mismatch: header.numOfElements='%1', data.length='%2'", (long)dCElementContentSelectionListUpdateInfo.numOfElements, (long)dCElementContentSelectionListRA1Array.length);
            }
            int n2 = -1;
            for (n = 0; n < dCElementContentSelectionListRA1Array.length; ++n) {
                DCElementContentSelectionListRA1 dCElementContentSelectionListRA1 = dCElementContentSelectionListRA1Array[n];
                if (null != dCElementContentSelectionListRA1) {
                    this.decodeRecordAndUpdateData(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1);
                    ++this.numOfTransmittedElements;
                    n2 = dCElementContentSelectionListRA1.getPos();
                    continue;
                }
                AbstractDisplayConfigurationComponent.this.getLogChannel().log(100000, "[DisplayConfigurationController#decodeStatusArray] data element 'null'.");
            }
            if (this.isForwardRequestRequired(n2)) {
                int n3;
                n = this.getTotalNumberOfElements() - (n2 + 1);
                if (0 < n && 0 < (n3 = this.getMaxTransmittableElements(dCElementContentSelectionListUpdateInfo.getArrayContent()))) {
                    DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo2 = new DCElementContentSelectionListUpdateInfo();
                    dCElementContentSelectionListUpdateInfo2.asgID = 1;
                    dCElementContentSelectionListUpdateInfo2.transactionID = this.getNewTransactionID();
                    dCElementContentSelectionListUpdateInfo2.recordContent = dCElementContentSelectionListUpdateInfo.getArrayContent();
                    dCElementContentSelectionListUpdateInfo2.arrayContent = 3;
                    dCElementContentSelectionListUpdateInfo2.startElement = n2;
                    dCElementContentSelectionListUpdateInfo2.numOfElements = n <= n3 ? n : n3;
                    this.sendGetArray(dCElementContentSelectionListUpdateInfo2);
                }
            } else {
                this.numOfTransmittedElements = 0;
                AbstractDisplayConfigurationComponent.this.notifyDisplayConfigurationChanged();
            }
        }

        private void decodeChangedArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
            if (AbstractDisplayConfigurationComponent.this.getLogChannel().isInfo()) {
                AbstractDisplayConfigurationComponent.this.getLogChannel().log(1000000, "[DisplayConfigurationController#decodeChangedArray] header='%1'", (Object)(dCElementContentSelectionListUpdateInfo == null ? "null" : dCElementContentSelectionListUpdateInfo.toString()));
            }
            if (null != dCElementContentSelectionListUpdateInfo) {
                int n = dCElementContentSelectionListUpdateInfo.getArrayContent();
                if (0 == dCElementContentSelectionListUpdateInfo.getRecordContent() && 0 == dCElementContentSelectionListUpdateInfo.getStartElement() && -1 == dCElementContentSelectionListUpdateInfo.getNumOfElements()) {
                    int n2 = this.getMaxTransmittableElements(1);
                    if (0 < n2) {
                        DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo2 = new DCElementContentSelectionListUpdateInfo();
                        dCElementContentSelectionListUpdateInfo2.asgID = 1;
                        dCElementContentSelectionListUpdateInfo2.transactionID = this.getNewTransactionID();
                        dCElementContentSelectionListUpdateInfo2.recordContent = 1;
                        dCElementContentSelectionListUpdateInfo2.arrayContent = 1;
                        dCElementContentSelectionListUpdateInfo2.startElement = 0;
                        dCElementContentSelectionListUpdateInfo2.numOfElements = n2;
                        this.sendGetArray(dCElementContentSelectionListUpdateInfo2);
                    }
                } else if (1 == dCElementContentSelectionListUpdateInfo.getRecordContent() && (1 == n || 3 == n)) {
                    int n3 = this.getMaxTransmittableElements(1);
                    if (0 < n3) {
                        DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo3 = new DCElementContentSelectionListUpdateInfo();
                        dCElementContentSelectionListUpdateInfo3.asgID = 1;
                        dCElementContentSelectionListUpdateInfo3.transactionID = this.getNewTransactionID();
                        dCElementContentSelectionListUpdateInfo3.recordContent = 1;
                        dCElementContentSelectionListUpdateInfo3.arrayContent = dCElementContentSelectionListUpdateInfo.getArrayContent();
                        dCElementContentSelectionListUpdateInfo3.startElement = dCElementContentSelectionListUpdateInfo.getStartElement();
                        dCElementContentSelectionListUpdateInfo3.numOfElements = dCElementContentSelectionListUpdateInfo.getNumOfElements() <= n3 ? dCElementContentSelectionListUpdateInfo.getNumOfElements() : n3;
                        this.sendGetArray(dCElementContentSelectionListUpdateInfo3);
                    }
                } else {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(10000, "[DisplayConfigurationController#decodeChangedArray] ChangedArray not supported.");
                }
            } else {
                AbstractDisplayConfigurationComponent.this.getLogChannel().log(10000, "[DisplayConfigurationController#decodeChangedArray] Invalid setup or parameter.");
            }
        }

        private void decodeRecordAndUpdateData(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1 dCElementContentSelectionListRA1) {
            if (null != dCElementContentSelectionListUpdateInfo && null != dCElementContentSelectionListRA1) {
                if (1 == dCElementContentSelectionListUpdateInfo.getRecordContent()) {
                    int n = dCElementContentSelectionListRA1.getPos();
                    if (0 <= n && n < this.currentArray.length) {
                        this.currentArray[n] = dCElementContentSelectionListRA1;
                    }
                } else {
                    AbstractDisplayConfigurationComponent.this.getLogChannel().log(10000, "[DisplayConfigurationController#decodeRecordAndUpdateData] Record address not supported.");
                }
            }
        }

        private int getMaxTransmittableElements(int n) {
            int n2;
            if (null != AbstractDisplayConfigurationComponent.this.currentViewOptions && null != AbstractDisplayConfigurationComponent.this.currentViewOptions.getConfiguration()) {
                DCTransmittableElements dCTransmittableElements = AbstractDisplayConfigurationComponent.this.currentViewOptions.getConfiguration().getElementContentSelectionListTransmittableElements();
                switch (n) {
                    case 0: {
                        n2 = dCTransmittableElements.getRa0();
                        break;
                    }
                    case 1: {
                        n2 = dCTransmittableElements.getRa1();
                        break;
                    }
                    case 15: {
                        n2 = dCTransmittableElements.getRaF();
                        break;
                    }
                    default: {
                        n2 = 0;
                        break;
                    }
                }
            } else {
                n2 = 0;
            }
            return n2;
        }

        private String arrayDataToString(DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dCElementContentSelectionListRA1Array.length; ++i2) {
                buffer.append("[").append(i2).append("] ").append(dCElementContentSelectionListRA1Array[i2].toString());
            }
            return buffer.toString();
        }
    }
}

