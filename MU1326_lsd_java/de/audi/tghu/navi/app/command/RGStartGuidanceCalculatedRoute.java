/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class RGStartGuidanceCalculatedRoute
extends NavCommand {
    private int index;
    private boolean rgActiveSent;
    private boolean resultSent;

    public RGStartGuidanceCalculatedRoute(int n) {
        this.index = n;
        this.rgActiveSent = false;
        this.resultSent = false;
    }

    @Override
    public void execute() {
        boolean bl = this.dsiResponseContainer.isRgActive();
        boolean bl2 = this.checkRouteCalculation();
        if (bl2) {
            this.logger.log(-2137614336, "RGStartGuidanceCalculatedRoute#execute() - calling rgStartGuidanceCalculatedRoute( %1 ) ", (long)this.index);
            this.getDSINavigation().rgStartGuidanceCalculatedRoute(this.index);
            if (bl) {
                // empty if block
            }
        } else {
            this.logger.log(-1601830656, "RGStartGuidanceCalculatedRoute#execute() - route calculation state is not valid, do not start guidance!");
            this.getCommandList().commandFinished();
        }
    }

    private boolean checkRouteCalculation() {
        int n = this.dsiResponseContainer.getRgRouteCalculationState();
        Object[] objectArray = this.dsiResponseContainer.getCalculatedRoutes();
        if (this.logger.isDebug2()) {
            Buffer buffer = new Buffer();
            Util.appendObjectArray(buffer, objectArray);
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "RGStartGuidanceCalculatedRoute#checkRouteCalculation() - rgRouteCalculationState: %2, rgCalculatedRoutes: %1", (Object)buffer, (long)n);
            }
        }
        boolean bl = n == 1 || n == 2 || n == 3;
        boolean bl2 = objectArray != null && objectArray.length > this.index && this.isCRLElementCalculated((CalculatedRouteListElement)objectArray[this.index]);
        return bl && bl2;
    }

    private boolean isCRLElementCalculated(CalculatedRouteListElement calculatedRouteListElement) {
        return calculatedRouteListElement.getCalculationState() == 3 || calculatedRouteListElement.getCalculationState() == 2 || calculatedRouteListElement.getCalculationState() == 5;
    }

    private void checkFinished() {
        if ((this.rgActiveSent || this.dsiResponseContainer.isRgActive()) && this.resultSent) {
            this.logger.log(-2137614336, "RGStartGuidanceCalculatedRoute#checkFinished() - guidance has been started successfully!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void updateRgActive(boolean bl) {
        this.logger.log(-2137614336, "RGStartGuidanceCalculatedRoute#updateRgActive( %1 ) ", bl);
        super.updateRgActive(bl);
        this.rgActiveSent = bl;
        this.checkFinished();
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
        if (n == 0) {
            this.logger.log(-2137614336, "RGStartGuidanceCalculatedRoute#rgStartGuidanceCalculatedRouteResult()");
            this.resultSent = true;
            this.checkFinished();
        } else {
            this.logger.log(10000, "RGStartGuidanceCalculatedRoute#rgStartGuidanceCalculatedRouteResult() - got error code %1 !", (long)n);
            this.getCommandList().commandAborted(n);
        }
    }

    @Override
    public void rgNotPossible(int n) {
        this.logger.log(10000, "RGStartGuidanceCalculatedRoute#rgNotPossible( %1 )", (long)n);
        super.rgNotPossible(n);
        this.getCommandList().commandAborted(n);
    }
}

