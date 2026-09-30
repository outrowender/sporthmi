/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxOnlineResults;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.utils.MapPin;

public class CtxOperatorCallResults
extends CtxOnlineResults {
    public CtxOperatorCallResults(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enter() {
        super.enter();
        this.updateCrossHairsBoundingBox();
    }

    protected void showLogo(boolean bl) {
    }

    public MapPin[] getDynamicPins() {
        this.getLogChannel().log(10000000, "CtxOperatorCallResults#getDynamicPins()");
        if (this.container.operatorCallResultLocation == null) {
            this.getLogChannel().log(10000, "CtxOperatorCallResults#getDynamicPins() - no location specified");
            return new MapPin[0];
        }
        MapPin mapPin = new MapPin(this.container.operatorCallResultLocation.getLongitude(), this.container.operatorCallResultLocation.getLatitude(), 28, 10);
        return new MapPin[]{mapPin};
    }

    protected void processResultFlags(IMapRequest iMapRequest) {
        this.getLogChannel().log(10000000, "CtxOperatorCallResults#processResultFlags() - container.operatorCallResultLocation: %1", (Object)this.container.operatorCallResultLocation);
        if (this.container.operatorCallResultLocation != null) {
            iMapRequest.setMapPosition(this.container.operatorCallResultLocation);
        } else {
            this.getLogChannel().log(10000, "CtxOperatorCallResults#processResultFlags() - no location specified");
        }
    }

    protected void onDDSClicked() {
        this.getLogChannel().log(10000000, "CtxOnCtxOperatorCallResults#onDDSClicked()");
    }
}

