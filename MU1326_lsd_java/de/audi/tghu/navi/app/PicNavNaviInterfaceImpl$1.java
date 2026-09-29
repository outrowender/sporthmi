/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

class PicNavNaviInterfaceImpl$1
extends NavCommand {
    private final /* synthetic */ ResourceLocator val$locator;
    private final /* synthetic */ PicNavNaviInterfaceImpl this$0;

    PicNavNaviInterfaceImpl$1(PicNavNaviInterfaceImpl picNavNaviInterfaceImpl, String string, ResourceLocator resourceLocator) {
        this.this$0 = picNavNaviInterfaceImpl;
        this.val$locator = resourceLocator;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        PicNavNaviInterfaceImpl.createPicNavLocationStatic(navLocation, this.val$locator);
        PicNavNaviInterfaceImpl.access$000(this.this$0).resolvedLocationResult(navLocation);
        this.getCommandList().commandFinished();
    }
}

