/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;

public class LispSelectListItemByIdent
extends NavCommand {
    private final String ident;
    private boolean liCurrentStateResponded;
    private boolean liResultResponded;

    public LispSelectListItemByIdent(String string) {
        this.ident = string;
    }

    public void execute() {
        this.logger.log(10000000, "LispSelectListItemByIdent#execute() - calling lispSelectListItemByIdent( %1 ) ", (Object)this.ident);
        this.getDSINavigation().lispSelectListItemByIdent(this.ident);
    }

    private void checkFinished() {
        if (this.liCurrentStateResponded && this.liResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    public void liResult(long l) {
        this.logger.log(10000000, "LispSelectListItemByIdent#liResult( %1 ) ", l);
        if (l == 0L) {
            this.liResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logger.log(10000000, "LispSelectListItemByIdent#liCurrentState - liCurrentLD=%1; availableSelectionCriteria=%2; usefulRefinementCriteria=%3", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Selcrit.asString(nArray), (Object)Selcrit.asString(nArray2));
        this.dsiResponseContainer.setLiCurrentState(navLocation, nArray, nArray2);
        this.liCurrentStateResponded = true;
        this.checkFinished();
    }
}

