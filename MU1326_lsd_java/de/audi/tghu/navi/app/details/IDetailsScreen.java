/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.tghu.navi.app.details.IDestinationHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.tmc.TmcMessage;

public interface IDetailsScreen {
    public IDestinationHandler getDestinationHandler();

    public void enterDetailsScreen(NavLocation var1);

    public void enterDetailsScreenTmc(TmcMessage var1);

    public void enterDetailsScreenOperatorCall(OperatorCallResult var1);
}

