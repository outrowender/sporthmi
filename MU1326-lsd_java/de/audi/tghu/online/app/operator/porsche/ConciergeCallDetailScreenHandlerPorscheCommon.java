/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operator.porsche;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.IFormattingRequest;
import de.audi.atip.interapp.IFormattingResponse;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.online.app.operator.porsche.ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallResult;

public class ConciergeCallDetailScreenHandlerPorscheCommon
implements ButtonListener {
    protected HMIService hmiService;
    private ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi currentPoi;
    private ITelService telService;
    protected LogChannel log;
    protected NavigationHandler naviHandler;

    public ConciergeCallDetailScreenHandlerPorscheCommon(HMIService hMIService, LogChannel logChannel) {
        this.log = logChannel;
        this.hmiService = hMIService;
        hMIService.getButtonModel(-937549056).setButtonListener(this);
        hMIService.getButtonModel(-1776540928).setButtonListener(this);
        hMIService.getButtonModel(1344086784).setButtonListener(this);
        hMIService.getButtonModel(-1642192128).setButtonListener(this);
        hMIService.getButtonModel(-1306647808).setButtonListener(this);
    }

    public void updateDetailScreen(ConciergeCallModelHandlerPorscheCommon$ConciergeResultPoi conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi) {
        if (conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi == null) {
            return;
        }
        IFormattingRequest iFormattingRequest = this.naviHandler.getFormattingRequestFromPoiResult(conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi);
        IFormattingResponse iFormattingResponse = this.naviHandler.getNaviFormattingService().formattingTwoLines(iFormattingRequest);
        this.hmiService.getLabelModel(-870440192).setText(conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.name);
        this.hmiService.getLabelModel(857613056).setText(conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.phone);
        this.hmiService.getLabelModel(907944704).setText(iFormattingResponse.getFirstLineAsText());
        this.hmiService.getLabelModel(-903994624).setText(iFormattingResponse.getSecondLineAsText());
        this.currentPoi = conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi;
        OperatorCallResult operatorCallResult = new OperatorCallResult();
        operatorCallResult.address = new OperatorCallAddressEntry();
        operatorCallResult.address.url = conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.url;
        if (this.naviHandler != null) {
            this.naviHandler.showDetails(operatorCallResult);
            GuiTooltipInformationContainer guiTooltipInformationContainer = new GuiTooltipInformationContainer();
            guiTooltipInformationContainer.toolTipTwoLinesLine1st = conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.name;
            guiTooltipInformationContainer.toolTipTwoLinesLine2nd = iFormattingResponse.getFirstLineAsText();
            this.naviHandler.showPreviewMapForLocationConcierge(conciergeCallModelHandlerPorscheCommon$ConciergeResultPoi.navLocation, guiTooltipInformationContainer);
        }
    }

    public void setTelService(ITelService iTelService) {
        this.telService = iTelService;
    }

    public void setNaviHandler(NavigationHandler navigationHandler) {
        this.naviHandler = navigationHandler;
    }

    private void saveAsFavorite() {
        if (this.naviHandler != null) {
            this.naviHandler.getNaviService().saveAsFavorite(this.currentPoi.navLocation, this.currentPoi.name, true);
        } else {
            this.log.log(-1601830656, "ConciergeCallDetailScreenHandlerPorscheCommon#saveAsFavorite: naviHandler is null");
        }
    }

    private void startRouteGuidance() {
        if (this.naviHandler != null) {
            this.log.log(1078071040, "ConciergeCallDetailScreenHandlerPorscheCommon#keyTyped startRouteGuidance button");
            this.naviHandler.startRouteGuidance(this.currentPoi.name, this.currentPoi.navLocation, null);
        } else {
            this.log.log(-1601830656, "ConciergeCallDetailScreenHandlerPorscheCommon#startRouteGuidance: naviHandler is null");
        }
    }

    private void addAsStopover() {
        if (this.naviHandler != null) {
            this.log.log(1078071040, "ConciergeCallDetailScreenHandlerPorscheCommon#addAsStopover called for %1[%2]", (Object)this.currentPoi.name, (Object)this.currentPoi.navLocation);
            this.naviHandler.getNaviService().getNaviOnlineService().insertAsStopover(this.currentPoi.navLocation, this.currentPoi.name, null, -1, true);
        } else {
            this.log.log(-1601830656, "ConciergeCallDetailScreenHandlerPorscheCommon#addAsStopover: naviHandler is null");
        }
    }

    private void startPhoneCall() {
        if (this.telService != null) {
            this.log.log(1078071040, "ConciergeCallDetailScreenHandlerPorscheCommon#keyTyped call button: %1", (Object)this.currentPoi.phone);
            this.telService.dialNumber(this.currentPoi.phone, null, true);
        } else {
            this.log.log(-1601830656, "ConciergeCallDetailScreenHandlerPorscheCommon#startPhoneCall: telService is null");
        }
    }

    private void preparePhoneCall() {
        if (this.telService != null) {
            this.log.log(1078071040, "ConciergeCallDetailScreenHandlerPorscheCommon#keyTyped call button: %1", (Object)this.currentPoi.phone);
            this.telService.prepareDialing(this.currentPoi.phone, null);
        } else {
            this.log.log(-1601830656, "ConciergeCallDetailScreenHandlerPorscheCommon#startPhoneCall: telService is null");
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 2301640: {
                this.startPhoneCall();
                break;
            }
            case 2301598: {
                this.preparePhoneCall();
                break;
            }
            case 2301078: {
                this.startRouteGuidance();
                break;
            }
            case 2301264: {
                this.saveAsFavorite();
                break;
            }
            case 2301618: {
                this.addAsStopover();
                break;
            }
            default: {
                this.log.log(-1601830656, "ConciergeCallDetailScreenHandlerPorscheCommon#keyTyped: unknown modelID: %1", (long)n);
            }
        }
        this.hmiService.getButtonModel(n).fireEvent(0);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

