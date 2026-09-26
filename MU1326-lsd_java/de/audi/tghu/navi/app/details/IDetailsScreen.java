/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.tghu.navi.app.details.IDestinationHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.tmc.TmcMessage;

public interface IDetailsScreen {
    default public IDestinationHandler getDestinationHandler() {
    }

    default public void enterDetailsScreen(NavLocation navLocation) {
    }

    default public void enterDetailsScreenTmc(TmcMessage tmcMessage) {
    }

    default public void enterDetailsScreenOperatorCall(OperatorCallResult operatorCallResult) {
    }
}

