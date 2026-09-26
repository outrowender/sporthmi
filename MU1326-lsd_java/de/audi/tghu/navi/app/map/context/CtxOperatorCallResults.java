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

    @Override
    public void enter() {
        super.enter();
        this.updateCrossHairsBoundingBox();
    }

    @Override
    protected void showLogo(boolean bl) {
    }

    @Override
    public MapPin[] getDynamicPins() {
        this.getLogChannel().log(-2137614336, "CtxOperatorCallResults#getDynamicPins()");
        if (this.container.operatorCallResultLocation == null) {
            this.getLogChannel().log(10000, "CtxOperatorCallResults#getDynamicPins() - no location specified");
            return new MapPin[0];
        }
        MapPin mapPin = new MapPin(this.container.operatorCallResultLocation.getLongitude(), this.container.operatorCallResultLocation.getLatitude(), 28, 10);
        return new MapPin[]{mapPin};
    }

    @Override
    protected void processResultFlags(IMapRequest iMapRequest) {
        this.getLogChannel().log(-2137614336, "CtxOperatorCallResults#processResultFlags() - container.operatorCallResultLocation: %1", (Object)this.container.operatorCallResultLocation);
        if (this.container.operatorCallResultLocation != null) {
            iMapRequest.setMapPosition(this.container.operatorCallResultLocation);
        } else {
            this.getLogChannel().log(10000, "CtxOperatorCallResults#processResultFlags() - no location specified");
        }
    }

    @Override
    protected void onDDSClicked() {
        this.getLogChannel().log(-2137614336, "CtxOnCtxOperatorCallResults#onDDSClicked()");
    }
}

