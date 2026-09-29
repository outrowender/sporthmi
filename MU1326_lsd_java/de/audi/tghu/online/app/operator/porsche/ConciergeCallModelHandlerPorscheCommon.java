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
import de.audi.tghu.online.app.operator.porsche.ConciergeCallDetailScreenHandlerPorscheCommon;
import de.audi.tghu.online.app.operator.porsche.ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi;
import de.audi.tghu.online.app.operator.porsche.ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import de.audi.tghu.online.app.operatorcall.services.AbstractConciergeCallModelHandler;
import de.audi.tghu.online.app.remotehmi.browser.DetailScreenBrowserComponent;
import java.util.List;
import org.dsi.ifc.online.OperatorCallResult;

public class ConciergeCallModelHandlerPorscheCommon
extends AbstractConciergeCallModelHandler {
    private static final int COLUMN_START_RG;
    public static final int CONCIERGE_RESULT_OK;
    public static final int CONCIERGE_RESULT_ERROR;
    public static final int CONCIERGE_RESULT_EMPTY;
    protected static final int COL_NAME;
    protected static final int COL_ADDRESS;
    protected static final int COL_RRD;
    protected static final int COL_RTT;
    protected ConciergeCallDetailScreenHandlerPorscheCommon detailScreenhandler;
    private boolean sendGeoCoordinatesPersisted;
    protected TiledListModelApp resultListModel;
    protected NavigationHandler naviHandler;
    private DetailScreenBrowserComponent detailBrowser;
    private String detailBrowserURL;

    public ConciergeCallModelHandlerPorscheCommon(HMIService hMIService, AbstractOperatorCall abstractOperatorCall) {
        super(hMIService, abstractOperatorCall);
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#c'tor");
        this.resultListModel = hMIService.getTiledListModel(1058874112);
    }

    @Override
    protected int[] getButtonIdsToRegister() {
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#getButtonIdsToRegister");
        return new int[]{941433600, 1008542464, 1042096896, 1025319680, 991765248, 974988032, 1260200704, 1293755136, 1360864000, 1427972864, 1461527296, 1394418432, 1143277056};
    }

    @Override
    protected int[] getChoiceIdsToRegister() {
        return new int[]{522068736, -1239538944};
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#keyTyped model: %1, id:%2", (long)n, (long)n2);
        this.saveModelData(n, n3);
        if (n == 1042096896) {
            this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#keyTyped processStartNewCall");
            this.processStartNewCall();
        } else if (n == 1025319680) {
            this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#keyTyped confirmButton pressed");
            this.hmiService.getChoiceModel(522068736).setValue(1);
            if (this.hmiService.getChoiceModel(-1239538944).getValue() == 1) {
                this.sendGeoCoordinatesPersisted = true;
                AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.listener.getData();
                abstractOperatorCallDataContainer.saveCCPInPersistence(1);
            }
            this.setCurrentPositionPopupVisibility(false);
            this.startNewCall();
        } else if (n == 974988032 || n == 991765248) {
            this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#keyTyped: CONCIERGE_ABORT_CONNECTING_BUTTON pressed!");
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
        } else if (n == 1143277056 && this.detailBrowser != null) {
            this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#keyTyped detail button is pressed browser will be started.");
            this.detailBrowser.loadURL(5, this.detailBrowserURL, false);
            this.fireModelEvent(1143277056);
        } else {
            this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#keyTyped: forwarding call to buttonKeyPressed");
            super.buttonKeyPressed(n);
        }
    }

    protected void keyPressed(int n) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#keyPressed model: %1, id:%2", (long)n, (long)n2);
        this.saveModelData(n, n3);
        if (n == 941433600) {
            this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#keyPressed: CONCIERGE_START_BCALL_BUTTON => start concierge call");
            this.setModelName("CONCIERGE_START_BCALL_BUTTON");
            this.setJokerKeyBackBehaviour(false);
            this.startNewCall();
        }
    }

    private void processStartNewCall() {
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#processStartNewCall sendGeoCoordinatesPersisted=%1", this.sendGeoCoordinatesPersisted);
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

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#itemSelected( model: %1, i: %2, c: %3 )", (long)n, (long)n2, (long)n3);
        if (n == 1058874112) {
            ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow = (ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow)evoListRow;
            ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi = (ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi)conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow.getObject();
            String string = conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.url;
            if (n3 == 1) {
                this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#itemSelected: start rg to %1[%2]", (Object)conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.name, (Object)conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.navLocation);
                this.naviHandler.startRouteGuidance(conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.name, conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.navLocation, null);
            } else {
                this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#itemSelected: update detailscreen %1", (Object)conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi);
                this.detailScreenhandler.updateDetailScreen(conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi);
                if (string != null && string.length() > 0) {
                    this.detailBrowserURL = string;
                    this.setButtonStatus(1143277056, "PORSCHE_CONCIERGE_DETAIL_BUTTON", 1);
                } else {
                    this.setButtonStatus(1143277056, "PORSCHE_CONCIERGE_DETAIL_BUTTON", 0);
                }
            }
        }
        this.fireModelEvent(n);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "ConciergeCallModelHandlerPorscheCommon#itemSelected called with modelId = %1", (long)n);
        if (n == 522068736 || n == -1239538944) {
            ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(n);
            choiceModelApp.setValue(choiceModelApp.getValue() ^ 1);
        }
    }

    protected void itemFocused(EvoListRow evoListRow, int n, int n2) {
    }

    @Override
    public void showDefaultError(boolean bl, int n) {
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#showDefaultError: showError = %1, errorType = %2", bl, (long)n);
        this.listener.sendBAPSignal(106);
        this.setDownloadPoisRunning(false);
        this.setCurrentStateChoice(4);
    }

    @Override
    public void setDownloadPoiResult(int n) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(18686720);
        choiceModelApp.setValue(n);
        choiceModelApp.setStatus(1);
    }

    public void setCurrentStateChoice(int n) {
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#setCurrentStateChoice state: %1", (long)n);
        if (this.currentState >= 4) {
            this.hmiService.getChoiceModel(-920771840).setValue(4);
            this.showCurrentStatePopup(this.currentState);
        } else {
            this.hmiService.getChoiceModel(-920771840).setValue(n);
        }
    }

    @Override
    public void setCurrentState(int n) {
        this.logChannel.log(-2137614336, "ConciergeCallModelHandlerPorscheCommon#setCurrentState actualize state to %1", (long)n);
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
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#mapDsiResultToHMI dsiResult: %1 hmiResult: %2", (long)n, (long)n3);
        return n3;
    }

    @Override
    public void setCallActive(boolean bl) {
        super.setCallActive(bl);
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#setCallActive() %1", bl);
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
            this.logChannel.log(-1601830656, "ConciergeCallModelHandlerPorscheCommon#extendResultsListModel() results is null.");
            return;
        }
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#extendResultsListModel() results: %1", (long)list.size());
        BaseListModelApp baseListModelApp = this.resultListModel.getEmptyCopy();
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            OperatorCallResult operatorCallResult = (OperatorCallResult)list.get(i2);
            ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi = this.convertPoi(operatorCallResult);
            ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow = new ConciergeCallModelHandlerPorscheCommon$ObjectEvoListRow(this, i2, 3);
            conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow.setObject(conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi);
            if (this.naviHandler != null) {
                IFormattingRequest iFormattingRequest = this.naviHandler.getFormattingRequestFromPoiResult(conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi);
                IFormattingResponse iFormattingResponse = this.naviHandler.getNaviFormattingService().formattingOneLine(iFormattingRequest);
                conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow.setText(1, iFormattingResponse.getFirstLineAsText());
            }
            conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow.setText(0, conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.name);
            baseListModelApp.append(conciergeCallModelHandlerPorscheCommon$ObjectEvoListRow);
        }
        this.resultListModel.update(baseListModelApp);
    }

    protected ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi convertPoi(OperatorCallResult operatorCallResult) {
        ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi = new ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi(this);
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.name = operatorCallResult.name;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.phone = operatorCallResult.address.phoneNumber;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.street = operatorCallResult.address.street;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.city = operatorCallResult.address.city;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.zip = operatorCallResult.address.zip;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.url = operatorCallResult.address.url;
        conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.navLocation = operatorCallResult.location;
        return conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi;
    }

    @Override
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

    @Override
    protected boolean isPhoneReadyForJokerkey() {
        return true;
    }

    public void setCCPPersistenceState(int n) {
        this.logChannel.log(1078071040, "ConciergeCallModelHandlerPorscheCommon#setCCPPersistenceState transmitCcpAllowed=%1", (long)n);
        if (n == 1) {
            this.hmiService.getChoiceModel(-1239538944).setValue(1);
            this.sendGeoCoordinatesPersisted = true;
        }
    }

    public void setDetailBrowser(DetailScreenBrowserComponent detailScreenBrowserComponent) {
        this.detailBrowser = detailScreenBrowserComponent;
    }
}

