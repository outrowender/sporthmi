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

public class PoiCallMiniAppModelHandler
extends AbstractBaseModelHandler {
    protected AbstractOperatorCall operatorCall;
    protected AbstractMiniAppHandler listener;

    public PoiCallMiniAppModelHandler(OnlineEnv onlineEnv, AbstractOperatorCall abstractOperatorCall, AbstractMiniAppHandler abstractMiniAppHandler) {
        super(onlineEnv.getHMIService());
        this.operatorCall = abstractOperatorCall;
        this.listener = abstractMiniAppHandler;
    }

    protected int[] getButtonIdsToRegister() {
        return new int[]{2301294};
    }

    protected int[] getTiledListIdsToRegister() {
        return new int[0];
    }

    protected void buttonKeyPressed(int n) {
        switch (n) {
            case 2301294: {
                this.setModelName("NUMBER_OF_REMOTE_HMI_APPS_IN_OPERATORCALL_CHOICE");
                this.fireButtonEvent();
                this.listener.triggerAppListDownload();
                break;
            }
            default: {
                this.logChannel.log(100000, "PoiCallMiniAppModelHandler#keyPressed: unknown button (%1) pressed", (long)n);
            }
        }
    }

    protected void listItemSelected(EvoListRow evoListRow, int n, int n2) {
    }

    protected void listItemFocused(EvoListRow evoListRow, int n, int n2) {
    }

    protected void optionKeyPressed(int n, int n2, int n3) {
        switch (n2) {
            case 2301175: {
                this.setModelName("OPERATOR_CALL_RESULTS_TILED_LIST");
                this.startMiniApp(n, n3, 0);
                break;
            }
            case 2301174: {
                this.setModelName("OPERATOR_RESULTS_TILED_LIST");
                TiledListModelApp tiledListModelApp = this.getTiledListModel(n2);
                PoiResultListRow poiResultListRow = (PoiResultListRow)tiledListModelApp.getRow(n3);
                int n4 = poiResultListRow.getHistoryCallIndex();
                this.startMiniApp(n, n4, n3);
                break;
            }
            default: {
                this.logChannel.log(100000, "optionKeyPressed#keyPressed: unknown button (%1) pressed", (long)n2);
            }
        }
    }

    private void startMiniApp(int n, int n2, int n3) {
        AbstractOperatorCallDataContainer abstractOperatorCallDataContainer = this.operatorCall.getData();
        AbstractHistoryCallData abstractHistoryCallData = abstractOperatorCallDataContainer.getHistoryCallData(n2);
        RemoteHMILocation remoteHMILocation = abstractHistoryCallData.getPoiForAudiConnect(n3);
        this.listener.triggerMiniApp(remoteHMILocation, n);
    }

    public void showPopup(int n) {
    }

    protected int[] getMenuModelIdsToRegister() {
        return new int[0];
    }

    protected void menuModelItemFocused(int n, long l, int n2) {
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
    }

    protected int[] getChoiceIdsToRegister() {
        return new int[0];
    }

    protected void choiceModelItemSelected(int n, int n2, int n3) {
    }
}

