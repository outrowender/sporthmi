/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.miniapps;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.remotehmi.RemoteHMILocation;
import de.audi.tghu.online.app.OnlineEnv;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractBaseModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.AbstractOperatorCallDataContainer;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.audi.tghu.online.app.operatorcall.miniapps.AbstractMiniAppHandler;

public class ConciergeCallMiniAppModelHandler
extends AbstractBaseModelHandler {
    protected AbstractOperatorCall operatorCall;
    protected AbstractMiniAppHandler listener;

    public ConciergeCallMiniAppModelHandler(OnlineEnv onlineEnv, AbstractOperatorCall abstractOperatorCall, AbstractMiniAppHandler abstractMiniAppHandler) {
        super(onlineEnv.getHMIService());
        this.operatorCall = abstractOperatorCall;
        this.listener = abstractMiniAppHandler;
    }

    @Override
    protected int[] getButtonIdsToRegister() {
        return null;
    }

    @Override
    protected int[] getTiledListIdsToRegister() {
        return null;
    }

    @Override
    protected void buttonKeyPressed(int n) {
        this.logChannel.log(-1601830656, "ConciergeCallMiniAppModelHandler#keyPressed: unknown button (%1) pressed", (long)n);
    }

    @Override
    protected void listItemSelected(EvoListRow evoListRow, int n, int n2) {
    }

    @Override
    protected void listItemFocused(EvoListRow evoListRow, int n, int n2) {
    }

    @Override
    public void showPopup(int n) {
    }

    @Override
    protected void optionKeyPressed(int n, int n2, int n3) {
        switch (n2) {
            case 2301241: {
                this.setModelName("CONCIERGE_CALL_RESULTS_TILED_LIST");
                this.startMiniApp(n, n3, 0);
                break;
            }
            case 2301247: {
                this.setModelName("CONCIERGE_RESULTS_TILED_LIST");
                TiledListModelApp tiledListModelApp = this.getTiledListModel(n2);
                PoiResultListRow poiResultListRow = (PoiResultListRow)tiledListModelApp.getRow(n3);
                int n4 = poiResultListRow.getHistoryCallIndex();
                this.startMiniApp(n, n4, n3);
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "ConciergeCallMiniAppModelHandler#optionKeyPressed: unknown button (%1) pressed", (long)n2);
                return;
            }
        }
        this.fireTiledListEvent();
    }

    private void startMiniApp(int n, int n2, int n3) {
        AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.operatorCall.getData();
        AbstractHistoryCallData abstractHistoryCallData = abstractOperatorCallDataContainer.getHistoryCallData(n2);
        RemoteHMILocation remoteHMILocation = abstractHistoryCallData.getPoiForAudiConnect(n3);
        this.listener.triggerMiniApp(remoteHMILocation, n);
    }

    @Override
    protected int[] getMenuModelIdsToRegister() {
        return new int[0];
    }

    @Override
    protected void menuModelItemFocused(int n, long l, int n2) {
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
    }

    @Override
    protected int[] getChoiceIdsToRegister() {
        return new int[0];
    }

    @Override
    protected void choiceModelItemSelected(int n, int n2, int n3) {
    }
}

