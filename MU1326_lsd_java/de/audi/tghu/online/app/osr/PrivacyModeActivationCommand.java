/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;

final class PrivacyModeActivationCommand
extends AbstractOSRCommand {
    private static final int PRIVACY_OFF;
    private static final int PRIVACY_ON;
    private final boolean privacyModeIsActive;
    private DSIOnlineServiceRegistration dsiOnlineServiceRegistration;

    PrivacyModeActivationCommand(DSIOnlineServiceRegistration dSIOnlineServiceRegistration, boolean bl) {
        this.dsiOnlineServiceRegistration = dSIOnlineServiceRegistration;
        this.privacyModeIsActive = bl;
    }

    @Override
    public void execute() {
        this.dsiOnlineServiceRegistration.setActivePrivacyCategoryMask(0);
        this.getCommandList().commandFinished();
    }
}

