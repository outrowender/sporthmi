/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;

final class SubmitPrivacyModeToBackendCommand
extends AbstractOSRCommand {
    private DSIOnlineServiceRegistration dsiOnlineServiceRegistration;

    SubmitPrivacyModeToBackendCommand(DSIOnlineServiceRegistration dSIOnlineServiceRegistration) {
        this.dsiOnlineServiceRegistration = dSIOnlineServiceRegistration;
    }

    public void execute() {
        this.dsiOnlineServiceRegistration.submitServiceStateChangesToBackend();
        this.getCommandList().commandFinished();
    }
}

