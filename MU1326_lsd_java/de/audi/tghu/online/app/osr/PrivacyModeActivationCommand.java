/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;

final class PrivacyModeActivationCommand
extends AbstractOSRCommand {
    private static final int PRIVACY_OFF = 1;
    private static final int PRIVACY_ON = 32;
    private final boolean privacyModeIsActive;
    private DSIOnlineServiceRegistration dsiOnlineServiceRegistration;

    PrivacyModeActivationCommand(DSIOnlineServiceRegistration dSIOnlineServiceRegistration, boolean bl) {
        this.dsiOnlineServiceRegistration = dSIOnlineServiceRegistration;
        this.privacyModeIsActive = bl;
    }

    public void execute() {
        this.dsiOnlineServiceRegistration.setActivePrivacyCategoryMask(0);
        this.getCommandList().commandFinished();
    }
}

