/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.SemidynamicRouteGuidance$ModelAccess;

class SemidynamicRouteGuidance$ModelAccessImpl
implements SemidynamicRouteGuidance$ModelAccess {
    private final NavigationEnv env;
    private final LogChannel logChannel;

    public SemidynamicRouteGuidance$ModelAccessImpl(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
    }

    @Override
    public void setDynamicBypassAvailable(boolean bl) {
        this.logChannel.log(-2137614336, "SemidynamicRouteGuidance#setDynamicBypassAvailable( %1 ) ", bl);
        this.env.getChoiceModel(160).setValue(bl ? 1 : 0);
    }

    @Override
    public boolean isDynamicBypassAvailable() {
        return this.env.getChoiceModel(160).getValue() == 1;
    }

    @Override
    public void setTrafficOffsetShort(String string) {
        this.logChannel.log(-2137614336, "SemidynamicRouteGuidance#setTrafficOffsetShort( %1 ) ", (Object)string);
        this.env.getLabelModel(164).setText(string);
    }

    @Override
    public void setTrafficOffsetLong(String string) {
        this.logChannel.log(-2137614336, "SemidynamicRouteGuidance#setTrafficOffsetLong( %1 ) ", (Object)string);
        this.env.getLabelModel(163).setText(string);
    }

    @Override
    public void setSidebarButtonMode(int n) {
        this.logChannel.log(-2137614336, "SemidynamicRouteGuidance#setSidebarButtonMode( %1 ) ", (long)n);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-266533376);
        choiceModelApp.setValue(n);
    }
}

