/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.AbstractOnlineSearchOptionModelListener;
import de.audi.app.navi.evo.poi.online.OnlineSearchForm;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import de.audi.tghu.navi.app.sds.ISDSController;

public class CallOptionModelListener
extends AbstractOnlineSearchOptionModelListener {
    private final ISDSController sdsController;
    private final OnlineSearchForm onlineSearchForm;

    public CallOptionModelListener(LogChannel logChannel, NavigationEnv navigationEnv, OnlineSearchSequence onlineSearchSequence, OnlineSearchForm onlineSearchForm, ISDSController iSDSController) {
        super(logChannel, navigationEnv, onlineSearchSequence, onlineSearchForm);
        this.onlineSearchForm = onlineSearchForm;
        this.sdsController = iSDSController;
        navigationEnv.getHMIService().getOptionModel(401005).setListener(this, 400618);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(1000000, "CallOptionModelListener#keyPressed(NAV_ONLINE_INPUT_COMPLETED_CALL_NUMBER_OPTION): selected");
        ListModelApp listModelApp = this.env.getListModel(400618);
        String string = ((TextListCell)listModelApp.getCell(n3, 0)).getText();
        String string2 = ((TextListCell)listModelApp.getCell(n3, 11)).getText();
        this.sdsController.abortSDSSession(true);
        if (this.onlineSearchForm.dialNumber(string, string2)) {
            this.logChannel.log(10000000, "CallOptionModelListener#keyPressed(): Fire model event, modelID: %1", (long)n);
            this.env.fireModelEvent(n, n5);
        }
    }
}

