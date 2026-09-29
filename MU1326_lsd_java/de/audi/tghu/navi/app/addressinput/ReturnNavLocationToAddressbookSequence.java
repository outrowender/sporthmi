/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence$1;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence$2;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class ReturnNavLocationToAddressbookSequence {
    private final ICommandListFactory commandListFactory;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    public ReturnNavLocationToAddressbookSequence(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void startWithLiCurrentLd() {
        this.startWithLocation(null);
    }

    public void startWithLocation(NavLocation navLocation) {
        this.getStartCommandListWithLocation(navLocation).execute(new StringBuffer().append(this.CLASS_NAME).append("#startWithLocation").toString());
    }

    public CommandList getStartCommandListWithLiCurrentLd() {
        return this.getStartCommandListWithLocation(null);
    }

    public CommandList getStartCommandListWithLocation(NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ReturnNavLocationToAddressbookSequence$1(this, new StringBuffer().append(this.CLASS_NAME).append("#serializeLocation").toString(), navLocation));
        commandList.add(new ReturnNavLocationToAddressbookSequence$2(this, new StringBuffer().append(this.CLASS_NAME).append("#saveNavLocationOnEntry").toString()));
        return commandList;
    }
}

