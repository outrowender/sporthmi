/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;

class ADBInterAppService$2
extends NavCommand {
    private final /* synthetic */ AdbEntry val$entry;
    private final /* synthetic */ NaviADBService$LocationInputHandler val$newLocationInputHandler;
    private final /* synthetic */ IAddressInputForm val$aif;
    private final /* synthetic */ ADBInterAppService this$0;

    ADBInterAppService$2(ADBInterAppService aDBInterAppService, String string, AdbEntry adbEntry, NaviADBService$LocationInputHandler naviADBService$LocationInputHandler, IAddressInputForm iAddressInputForm) {
        this.this$0 = aDBInterAppService;
        this.val$entry = adbEntry;
        this.val$newLocationInputHandler = naviADBService$LocationInputHandler;
        this.val$aif = iAddressInputForm;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getChoiceModel(1042286080).setValue(1);
        NavLocation navLocation = this.dsiResponseContainer.getTryBestMatchResultData()[0].getLocation();
        if (null != navLocation && navLocation.isPositionValid()) {
            this.env.getChoiceModel(-1407187456).setValue(0);
            Util.setDescriptionOnLocation(navLocation, this.val$entry.getCombinedName());
            ADBInterAppService.access$300(this.this$0, this.val$newLocationInputHandler == null ? ADBInterAppService.access$200(this.this$0) : this.val$newLocationInputHandler);
            this.env.getChoiceModel(170).setValue(2);
            this.val$aif.startWithoutStrip(navLocation);
        } else {
            this.env.getChoiceModel(-1407187456).setValue(1);
        }
        this.getCommandList().commandFinished();
    }
}

