/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operator.porsche;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IFormattingRequest;
import de.audi.atip.interapp.IFormattingResponse;
import de.audi.atip.phone.ITelService;
import de.audi.remotehmi.util.DeepCloneable;
import de.audi.tghu.online.app.operator.porsche.ConciergeCallDetailScreenHandlerPorscheCommon;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.services.AbstractConciergeCallModelHandler;
import de.audi.tghu.online.app.remotehmi.browser.DetailScreenBrowserComponent;
import java.util.List;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallResult;

public class ConciergeCallModelHandlerPorscheCommon
extends AbstractConciergeCallModelHandler {
    private static final int COLUMN_START_RG = 1;
    public static final int CONCIERGE_RESULT_OK = 0;
    public static final int CONCIERGE_RESULT_ERROR = 1;
    public static final int CONCIERGE_RESULT_EMPTY = 2;
    protected static final int COL_NAME = 0;
    protected static final int COL_ADDRESS = 1;
    protected static final int COL_RRD = 3;
    protected static final int COL_RTT = 4;
    protected ConciergeCallDetailScreenHandlerPorscheCommon detailScreenhandler;
    private boolean sendGeoCoordinatesPersisted;
    protected TiledListModelApp resultListModel;
    protected NavigationHandler naviHandler;
    private DetailScreenBrowserComponent detailBrowser;
    private String detailBrowserURL;

    public ConciergeCallModelHandlerPorscheCommon(HMIService hMIService, AbstractOperatorCall abstractOperatorCall) {
        super(hMIService, abstractOperatorCall);
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#c'tor");
        this.resultListModel = hMIService.getTiledListModel(2301247);
    }

    protected int[] getButtonIdsToRegister() {
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#getButtonIdsToRegister");
        return new int[]{2301240, 2301244, 2301246, 2301245, 2301243, 2301242, 2301259, 2301261, 2301265, 2301269, 2301271, 2301267, 402756};
    }

    protected int[] getChoiceIdsToRegister() {
        return new int[]{2301471, 2301622};
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#keyTyped model: %1, id:%2", (long)n, (long)n2);
        this.saveModelData(n, n3);
        if (n == 2301246) {
            this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#keyTyped processStartNewCall");
            this.processStartNewCall();
        } else if (n == 2301245) {
            this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#keyTyped confirmButton pressed");
            this.hmiService.getChoiceModel(2301471).setValue(1);
            if (this.hmiService.getChoiceModel(2301622).getValue() == 1) {
                this.sendGeoCoordinatesPersisted = true;
                AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.listener.getData();
                abstractOperatorCallDataContainer.saveCCPInPersistence(1);
            }
            this.setCurrentPositionPopupVisibility(false);
            this.startNewCall();
        } else if (n == 2301242 || n == 2301243) {
            this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#keyTyped: CONCIERGE_ABORT_CONNECTING_BUTTON pressed!");
            if (this.currentState == 1) {
                this.hangup();
                this.setCurrentState(2);
                this.setCurrentStateChoice(2);
            } else {
                this.abortConnection();
                this.setCurrentState(3);
                this.setCurrentStateChoice(3);
            }
            this.removeConnectingPopup();
        } else if (n == 402756 && this.detailBrowser != null) {
            this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#keyTyped detail button is pressed browser will be started.");
            this.detailBrowser.loadURL(5, this.detailBrowserURL, false);
            this.fireModelEvent(402756);
        } else {
            this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#keyTyped: forwarding call to buttonKeyPressed");
            super.buttonKeyPressed(n);
        }
    }

    protected void keyPressed(int n) {
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#keyPressed model: %1, id:%2", (long)n, (long)n2);
        this.saveModelData(n, n3);
        if (n == 2301240) {
            this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#keyPressed: CONCIERGE_START_BCALL_BUTTON => start concierge call");
            this.setModelName("CONCIERGE_START_BCALL_BUTTON");
            this.setJokerKeyBackBehaviour(false);
            this.startNewCall();
        }
    }

    private void processStartNewCall() {
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#processStartNewCall sendGeoCoordinatesPersisted=%1", this.sendGeoCoordinatesPersisted);
        if (this.sendGeoCoordinatesPersisted) {
            this.startNewCall();
        } else {
            this.setCurrentPositionPopupVisibility(true);
        }
    }

    protected void removeConnectingPopup() {
    }

    protected void setCurrentPositionPopupVisibility(boolean bl) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#itemSelected( model: %1, i: %2, c: %3 )", (long)n, (long)n2, (long)n3);
        if (n == 2301247) {
            ObjectEvoListRow objectEvoListRow = (ObjectEvoListRow)evoListRow;
            ConciergeResultPoi conciergeResultPoi = (ConciergeResultPoi)objectEvoListRow.getObject();
            String string = conciergeResultPoi.url;
            if (n3 == 1) {
                this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#itemSelected: start rg to %1[%2]", (Object)conciergeResultPoi.name, (Object)conciergeResultPoi.navLocation);
                this.naviHandler.startRouteGuidance(conciergeResultPoi.name, conciergeResultPoi.navLocation, null);
            } else {
                this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#itemSelected: update detailscreen %1", (Object)conciergeResultPoi);
                this.detailScreenhandler.updateDetailScreen(conciergeResultPoi);
                if (string != null && string.length() > 0) {
                    this.detailBrowserURL = string;
                    this.setButtonStatus(402756, "PORSCHE_CONCIERGE_DETAIL_BUTTON", 1);
                } else {
                    this.setButtonStatus(402756, "PORSCHE_CONCIERGE_DETAIL_BUTTON", 0);
                }
            }
        }
        this.fireModelEvent(n);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "ConciergeCallModelHandlerPorscheCommon#itemSelected called with modelId = %1", (long)n);
        if (n == 2301471 || n == 2301622) {
            ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(n);
            choiceModelApp.setValue(choiceModelApp.getValue() ^ 1);
        }
    }

    protected void itemFocused(EvoListRow evoListRow, int n, int n2) {
    }

    public void showDefaultError(boolean bl, int n) {
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#showDefaultError: showError = %1, errorType = %2", bl, (long)n);
        this.listener.sendBAPSignal(106);
        this.setDownloadPoisRunning(false);
        this.setCurrentStateChoice(4);
    }

    public void setDownloadPoiResult(int n) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(2301185);
        choiceModelApp.setValue(n);
        choiceModelApp.setStatus(1);
    }

    public void setCurrentStateChoice(int n) {
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#setCurrentStateChoice state: %1", (long)n);
        if (this.currentState >= 4) {
            this.hmiService.getChoiceModel(2301641).setValue(4);
            this.showCurrentStatePopup(this.currentState);
        } else {
            this.hmiService.getChoiceModel(2301641).setValue(n);
        }
    }

    public void setCurrentState(int n) {
        this.logChannel.log(10000000, "ConciergeCallModelHandlerPorscheCommon#setCurrentState actualize state to %1", (long)n);
        this.currentState = n;
    }

    protected void showCurrentStatePopup(int n) {
    }

    protected int mapDsiResultCodeToHMI(int n, int n2) {
        int n3;
        switch (n) {
            case 1: {
                n3 = n2 < 1 ? 2 : 0;
                break;
            }
            default: {
                n3 = 1;
            }
        }
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#mapDsiResultToHMI dsiResult: %1 hmiResult: %2", (long)n, (long)n3);
        return n3;
    }

    public void setCallActive(boolean bl) {
        super.setCallActive(bl);
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#setCallActive() %1", bl);
        if (bl) {
            this.setCurrentState(1);
            this.setCurrentStateChoice(1);
        } else {
            this.setCurrentState(3);
            this.setCurrentStateChoice(3);
        }
    }

    public void extendResultsListModel(List list) {
        if (list == null) {
            this.logChannel.log(100000, "ConciergeCallModelHandlerPorscheCommon#extendResultsListModel() results is null.");
            return;
        }
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#extendResultsListModel() results: %1", (long)list.size());
        BaseListModelApp baseListModelApp = this.resultListModel.getEmptyCopy();
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            OperatorCallResult operatorCallResult = (OperatorCallResult)list.get(i2);
            ConciergeResultPoi conciergeResultPoi = this.convertPoi(operatorCallResult);
            ObjectEvoListRow objectEvoListRow = new ObjectEvoListRow(i2, 3);
            objectEvoListRow.setObject(conciergeResultPoi);
            if (this.naviHandler != null) {
                IFormattingRequest iFormattingRequest = this.naviHandler.getFormattingRequestFromPoiResult(conciergeResultPoi);
                IFormattingResponse iFormattingResponse = this.naviHandler.getNaviFormattingService().formattingOneLine(iFormattingRequest);
                objectEvoListRow.setText(1, iFormattingResponse.getFirstLineAsText());
            }
            objectEvoListRow.setText(0, conciergeResultPoi.name);
            baseListModelApp.append(objectEvoListRow);
        }
        this.resultListModel.update(baseListModelApp);
    }

    protected ConciergeResultPoi convertPoi(OperatorCallResult operatorCallResult) {
        ConciergeResultPoi conciergeResultPoi = new ConciergeResultPoi();
        conciergeResultPoi.name = operatorCallResult.name;
        conciergeResultPoi.phone = operatorCallResult.address.phoneNumber;
        conciergeResultPoi.street = operatorCallResult.address.street;
        conciergeResultPoi.city = operatorCallResult.address.city;
        conciergeResultPoi.zip = operatorCallResult.address.zip;
        conciergeResultPoi.url = operatorCallResult.address.url;
        conciergeResultPoi.navLocation = operatorCallResult.location;
        return conciergeResultPoi;
    }

    public boolean isConfirmCCPScreenShown() {
        return false;
    }

    public void setTelService(ITelService iTelService) {
        this.detailScreenhandler.setTelService(iTelService);
    }

    public void setNaviHandler(NavigationHandler navigationHandler) {
        this.naviHandler = navigationHandler;
        this.detailScreenhandler.setNaviHandler(navigationHandler);
    }

    protected boolean isPhoneReadyForJokerkey() {
        return true;
    }

    public void setCCPPersistenceState(int n) {
        this.logChannel.log(1000000, "ConciergeCallModelHandlerPorscheCommon#setCCPPersistenceState transmitCcpAllowed=%1", (long)n);
        if (n == 1) {
            this.hmiService.getChoiceModel(2301622).setValue(1);
            this.sendGeoCoordinatesPersisted = true;
        }
    }

    public void setDetailBrowser(DetailScreenBrowserComponent detailScreenBrowserComponent) {
        this.detailBrowser = detailScreenBrowserComponent;
    }

    public class ObjectEvoListRow
    extends EvoListRow {
        private DeepCloneable entry;

        protected ObjectEvoListRow(ObjectEvoListRow objectEvoListRow) {
            super(objectEvoListRow);
            this.setObject((DeepCloneable)objectEvoListRow.getObject().clone(true));
        }

        public ObjectEvoListRow(long l, int n) {
            super(l, n);
        }

        public void setObject(DeepCloneable deepCloneable) {
            if (deepCloneable != null) {
                this.entry = deepCloneable;
            }
        }

        public DeepCloneable getObject() {
            return this.entry;
        }

        public EvoListRow copy() {
            return new ObjectEvoListRow(this);
        }
    }

    public class ConciergeResultPoi
    implements DeepCloneable {
        public NavLocationWgs84 navLocation;
        public String url;
        public String zip;
        public String city;
        public String street;
        public String phone;
        public String name;

        public String toString() {
            return new StringBuffer().append("ConciergeResultPoi [navLocation=").append(this.navLocation).append(", url=").append(this.url).append(", zip=").append(this.zip).append(", city=").append(this.city).append(", street=").append(this.street).append(", phone=").append(this.phone).append(", name=").append(this.name).append("]").toString();
        }

        public Object clone(boolean bl) {
            ConciergeResultPoi conciergeResultPoi = new ConciergeResultPoi();
            conciergeResultPoi.name = this.name;
            conciergeResultPoi.phone = this.phone;
            conciergeResultPoi.street = this.street;
            conciergeResultPoi.city = this.city;
            conciergeResultPoi.zip = this.zip;
            conciergeResultPoi.url = this.url;
            conciergeResultPoi.navLocation = new NavLocationWgs84(this.navLocation.longitude, this.navLocation.latitude);
            return conciergeResultPoi;
        }
    }
}

