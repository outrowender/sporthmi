/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;

public class LispSelectItemFromLocation
extends NavCommand {
    private String keyForNavLocationFromCommandListMap;
    private NavLocation navLocation;
    private boolean liResultResponded = false;
    private boolean liCurrentStateResponded = false;

    public LispSelectItemFromLocation() {
    }

    public LispSelectItemFromLocation(String string) {
        this.keyForNavLocationFromCommandListMap = string;
    }

    public LispSelectItemFromLocation(NavLocation navLocation) {
        this.navLocation = navLocation;
    }

    public void execute() {
        NavLocation navLocation = this.getNavLocation();
        if (navLocation == null) {
            this.logger.log(10000000, "%1#execute() - the NavLocation returned by getNavLocation() is null", (Object)this.CLASS_NAME);
            this.getCommandList().commandAborted(this.CLASS_NAME + "#execute() NavLocation is NULL");
        } else {
            this.logger.log(10000000, "%1#execute() - use NavLocation %2 for lispSelectItemFromLocation", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
            this.getDSINavigation().lispSelectItemFromLocation(navLocation);
        }
    }

    private NavLocation getNavLocation() {
        if (this.navLocation != null) {
            this.logger.log(10000000, "%1#getNavLocation() - return given NavLocation from Constructor", (Object)this.CLASS_NAME);
            return this.navLocation;
        }
        if (this.keyForNavLocationFromCommandListMap != null) {
            Object object = this.getCommandList().get(this.keyForNavLocationFromCommandListMap);
            if (object == null || !(object instanceof NavLocation)) {
                this.logger.log(100000, "%1#getNavLocation() - the Object in the CommandList Map is no NavLocation --> return null", (Object)this.CLASS_NAME);
                return null;
            }
            this.logger.log(10000000, "%1#getNavLocation() - return NavLocation from CommandList Map", (Object)this.CLASS_NAME);
            return (NavLocation)object;
        }
        this.logger.log(10000000, "%1#getNavLocation() - no NavLocation has been passed in constructor --> use liCurrentLD from dsiResponseContainer", (Object)this.CLASS_NAME);
        return this.dsiResponseContainer.getLiCurrentLD();
    }

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logger.log(10000000, "LispSelectItemFromLocationCommand#liCurrentState - liCurrentLD=%1; availableSelectionCriteria=%2, usefulRefinementCriteria=%3", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Selcrit.asString(nArray), (Object)Selcrit.asString(nArray2));
        if (l != 0L) {
            this.getCommandList().commandAborted(l);
            return;
        }
        this.dsiResponseContainer.setLiCurrentState(navLocation, nArray, nArray2);
        this.liCurrentStateResponded = true;
        this.checkFinished();
    }

    public void liResult(long l) {
        if (l != 0L) {
            this.getCommandList().commandAborted(l);
            return;
        }
        this.liResultResponded = true;
        this.checkFinished();
    }

    private void checkFinished() {
        if (this.liCurrentStateResponded && this.liResultResponded) {
            this.getCommandList().commandFinished();
        }
    }
}

