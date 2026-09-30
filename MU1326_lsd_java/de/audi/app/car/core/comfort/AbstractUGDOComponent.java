/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.comfort.AbstractDSICarComfortAdapter;
import de.audi.app.car.core.comfort.IUGDOComponent;
import de.audi.app.car.core.comfort.UGDOButtonListHandler;
import de.audi.app.car.core.comfort.UGDOHelper;
import de.audi.app.car.core.comfort.UGDOLearningHandler;
import de.audi.app.car.core.comfort.UGDOPopupHandler;
import de.audi.app.car.core.comfort.UGDOSynchronizationHandler;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.carcomfort.UGDOVersionData;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractUGDOComponent
extends AbstractDSICarComfortAdapter
implements IUGDOComponent {
    public static final short CODING_ID = 25;
    private static final String LOGCHANNEL_NAME = "App.Car.UGDO";
    private volatile UGDOViewOptions currentViewOptions;
    private final UGDOButtonListHandler buttonListHandler;
    protected UGDOPopupHandler popupHandler;
    protected UGDOLearningHandler learningHandler;
    protected UGDOSynchronizationHandler syncHandler;
    private volatile ArrayList receivedButtonList;

    public AbstractUGDOComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        super.setLogChannelDSI(true);
        this.receivedButtonList = new ArrayList();
        this.syncHandler = new UGDOSynchronizationHandler(iCarApplication, this, this.getDefaultLogChannel());
        this.learningHandler = new UGDOLearningHandler(iCarApplication, this, this.syncHandler, this.getDefaultLogChannel());
        this.buttonListHandler = new UGDOButtonListHandler(this, this.learningHandler, this.getDefaultLogChannel());
        this.popupHandler = new UGDOPopupHandler(iCarApplication, this, this.learningHandler, this.syncHandler, this.getDefaultLogChannel());
    }

    public void init() {
        super.init();
        this.popupHandler.init();
        this.learningHandler.init();
        this.syncHandler.init();
    }

    public void deinit() {
        this.popupHandler.deinit();
        this.learningHandler.deinit();
        this.syncHandler.deinit();
        super.deinit();
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{29}, new int[]{49, 50, 31, 32})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    public UGDOViewOptions getViewOptions() {
        return this.currentViewOptions;
    }

    public void updateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
        if (n == 1) {
            this.getLogChannel(1).log(1000000, "[updateUGDOViewOptions] viewOptions=%1", (Object)uGDOViewOptions);
            this.currentViewOptions = uGDOViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.resetModelOnViewOptionsDisabled();
            this.primaryAttributeFirstSetReceived();
        }
    }

    private void resetModelOnViewOptionsDisabled() {
        CarViewOption carViewOption = this.currentViewOptions.getDeleteButton();
        if (carViewOption.getState() == 1 && this.getChoiceModel(600414).getStatus() == 0) {
            this.getChoiceModel(600414).setStatus(2);
        }
    }

    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
        if (n == 1) {
            this.getLogChannel(1).log(1000000, "[updateUGDOButtonListUpdateInfo] info='%1'", (Object)uGDOButtonListUpdateInfo);
            UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo2 = new UGDOButtonListUpdateInfo();
            uGDOButtonListUpdateInfo2.arrayContent = uGDOButtonListUpdateInfo.arrayContent;
            uGDOButtonListUpdateInfo2.recordContent = uGDOButtonListUpdateInfo.recordContent;
            uGDOButtonListUpdateInfo2.startElement = uGDOButtonListUpdateInfo.startElement;
            uGDOButtonListUpdateInfo2.numOfElements = uGDOButtonListUpdateInfo.numOfElements;
            uGDOButtonListUpdateInfo2.transactionID = uGDOButtonListUpdateInfo.transactionID;
            uGDOButtonListUpdateInfo2.asgID = uGDOButtonListUpdateInfo.asgID;
            this.buttonListHandler.updateUGDOButtonListUpdateInfo(uGDOButtonListUpdateInfo2);
        }
    }

    public void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
        if (n2 == 1) {
            this.getLogChannel(1).log(1000000, "[updateUGDOButtonListTotalNumberOfElements] %1", (long)n);
            this.buttonListHandler.updateUGDOButtonListTotalNumberOfElements(n);
        }
    }

    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        this.getLogChannel(1).log(1000000, "[responseUGDOButtonListRA0] info=%1", (Object)uGDOButtonListUpdateInfo);
        this.buttonListHandler.responseUGDOButtonListRA0(uGDOButtonListUpdateInfo, uGDOButtonListRA0Array);
        this.updateMenuEntryVisibility(this.getCurrentViewOptionsObject());
    }

    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        this.getLogChannel(1).log(1000000, "[responseUGDOButtonListRA1] info=%1", (Object)uGDOButtonListUpdateInfo);
        this.buttonListHandler.responseUGDOButtonListRA1(uGDOButtonListUpdateInfo, uGDOButtonListRA1Array);
    }

    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        this.getLogChannel(1).log(1000000, "[responseUGDOButtonListRA2] info=%1", (Object)uGDOButtonListUpdateInfo);
        this.buttonListHandler.responseUGDOButtonListRA2(uGDOButtonListUpdateInfo, uGDOButtonListRA2Array);
    }

    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        this.getLogChannel(1).log(1000000, "[responseUGDOButtonListRA3] info=%1", (Object)uGDOButtonListUpdateInfo);
        this.buttonListHandler.responseUGDOButtonListRA3(uGDOButtonListUpdateInfo, uGDOButtonListRA3Array);
    }

    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        this.getLogChannel(1).log(1000000, "[responseUGDOButtonListRA4] info=%1", (Object)uGDOButtonListUpdateInfo);
        this.buttonListHandler.responseUGDOButtonListRA4(uGDOButtonListUpdateInfo, uGDOButtonListRA4Array);
    }

    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        this.getLogChannel(1).log(1000000, "[responseUGDOButtonListRA5] info=%1", (Object)uGDOButtonListUpdateInfo);
        this.buttonListHandler.responseUGDOButtonListRA5(uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
    }

    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        this.getLogChannel(1).log(1000000, "[responseUGDOButtonListRAF] info=%1", (Object)uGDOButtonListUpdateInfo);
        this.buttonListHandler.responseUGDOButtonListRAF(uGDOButtonListUpdateInfo, nArray);
    }

    public void updateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
        if (n == 1) {
            String string = Integer.toString(uGDOVersionData.getVersion());
            this.getLabelModel(600440).setText(string);
            String string2 = Integer.toString(uGDOVersionData.getState());
            this.getLabelModel(600441).setText(string2);
            String string3 = Integer.toString(uGDOVersionData.getCountryCode());
            this.getLabelModel(600439).setText(string3);
        }
    }

    public void acknowledgeUGDOLearning(int n, int n2) {
        this.getLogChannel(1).log(1000000, "[acknowledgeUGDOLearning] result='%1', softkey='%2'", (long)n, (long)n2);
        this.learningHandler.acknowledgeUGDOLearning(n, n2);
    }

    public void acknowledgeUGDODeleteButton(boolean bl) {
        this.getLogChannel(1).log(1000000, "[acknowledgeUGDODeleteButton] success='%1'", bl);
        this.learningHandler.acknowledgeUGDODeleteButton(bl);
    }

    public void updateUGDOContent(UGDOContent uGDOContent, int n) {
        if (n == 1) {
            this.getLogChannel(1).log(1000000, "[updateUGDOContent] <--- content=%1", (Object)uGDOContent);
            this.popupHandler.updateUGDOContent(uGDOContent);
        }
    }

    public void requestUGDOPopup(UGDOContent uGDOContent) {
        this.getLogChannel(1).log(1000000, "[requestUGDOPopup] <--- content='%1'", (Object)uGDOContent);
        this.popupHandler.requestUGDOPopup(uGDOContent);
    }

    public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
        this.getLogChannel(1).log(1000000, "[acknowledgeUGDOPopup] <--- content='%1'", (Object)uGDOContent);
        this.popupHandler.acknowledgeUGDOPopup(uGDOContent);
    }

    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        this.getLogChannel(1).log(1000000, "[acknowledgeUGDOSynchronisation] <--- data='%1'", (Object)UGDOHelper.toString(uGDOSynchronisation));
        this.syncHandler.acknowledgeUGDOSynchronisation(uGDOSynchronisation);
    }

    public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        this.getLogChannel(1).log(1000000, "[requestUGDOSynchronisation] <--- data='%1'", (Object)UGDOHelper.toString(uGDOSynchronisation));
        this.syncHandler.requestUGDOSynchronisation(uGDOSynchronisation);
    }

    public UGDOViewOptions getCurrentViewOptionsObject() {
        return this.currentViewOptions;
    }

    public DSICarComfort getDSICarComfort() {
        return this.getDSI();
    }

    public int getLearningHMIPopupID() {
        return this.getLearningPopupID();
    }

    public int getSyncHMIPopupID() {
        return this.getSyncPopupID();
    }

    public int getStandbyHMIPopupID() {
        return this.getStandbyPopupID();
    }

    protected void abortUGDOLearning() {
        boolean bl = this.learningHandler.isLearningStarted();
        boolean bl2 = this.syncHandler.isSyncRunning();
        this.getLogChannel(1).log(1000000, "[AbstractUGDOComponent#abortUGDOLearning] learning: %1 sync: %2", bl, bl2);
        int n = this.getChoiceModel(600428).getValue();
        if (n == 0 && bl) {
            this.getLogChannel(1).log(1000000, "[*** AbstractUGDOComponent#abortUGDOLearning LEARN_RESULT_IDLE] dsi.abortUGDOLearning()");
            this.getDSICarComfort().abortUGDOLearning();
            this.learningHandler.resetLearningStartedState();
        } else if (n == 2 && bl) {
            this.getLogChannel(1).log(1000000, "[*** AbstractUGDOComponent#abortUGDOLearning LEARN_RESULT_OK_FIXCODE_SYSTEM] dsi.abortUGDOLearning()");
            this.getDSICarComfort().abortUGDOLearning();
            this.learningHandler.resetLearningStartedState();
        } else if (n == 3 && !bl2) {
            this.getLogChannel(1).log(1000000, "[***AbstractUGDOComponent#abortUGDOLearning] CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ROLL_GROUP_UGDO_SYNC and cancel: no dsi call necessary");
        } else if (n == 3 && bl2) {
            UGDOSynchronisation uGDOSynchronisation = new UGDOSynchronisation();
            uGDOSynchronisation.state = 7;
            uGDOSynchronisation.doorMovement = 0;
            uGDOSynchronisation.softkey = bl ? this.learningHandler.getCurrentSoftkeyButton() : this.syncHandler.getCurrentSoftkeyButton();
            this.getLogChannel(1).log(1000000, "[***AbstractUGDOComponent#abortUGDOLearning LEARN_RESULT_OK_ROLLING_SYSTEM] -> dsi.setUGDOSynchronisation(%1)", (Object)UGDOHelper.toString(uGDOSynchronisation));
            this.getDSICarComfort().setUGDOSynchronisation(uGDOSynchronisation);
        } else {
            this.getLogChannel(1).log(1000000, "[***AbstractUGDOComponent#abortUGDOLearning] State not designated.");
        }
    }

    protected void restartUGDOLearning() {
        this.getLogChannel(1).log(1000000, "[AbstractUGDOComponent#restartUGDOLearning] ");
        this.learningHandler.startLearningButton();
    }

    protected void setUGDOSync() {
        this.learningHandler.resetLearningStartedState();
        this.syncHandler.startSync(this.learningHandler.getCurrentSoftkeyButton());
    }

    protected abstract void updateMenuEntryVisibility(UGDOViewOptions var1);

    protected abstract int getLearningPopupID();

    protected abstract int getSyncPopupID();

    protected abstract int getStandbyPopupID();

    public String getName() {
        return "UGDO";
    }

    public LogChannel getDSILogChannel() {
        return this.getLogChannel(1);
    }

    public final LogChannel getDefaultLogChannel() {
        return this.getLogChannel(0);
    }

    public ArrayList getInternalButtonList() {
        return this.receivedButtonList;
    }

    public void learningResultChanged(int n, int n2) {
    }

    public void syncResultChanged(int n, int n2) {
    }
}

