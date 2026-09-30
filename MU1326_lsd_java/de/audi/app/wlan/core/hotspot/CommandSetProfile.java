/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.hotspot;

import de.audi.app.wlan.core.AbstractWlanCommand;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIWLAN;
import org.dsi.ifc.networking.Profile;

final class CommandSetProfile
extends AbstractWlanCommand {
    private Profile profile;
    static /* synthetic */ Class class$de$audi$app$wlan$core$hotspot$CommandSetProfile;

    static void schedule(IWlanApplication iWlanApplication, DSIWLAN dSIWLAN, Profile profile) {
        CommandSetProfile commandSetProfile = new CommandSetProfile(iWlanApplication.getLogChannel(), dSIWLAN, profile);
        AbstractWlanCommand.schedule(iWlanApplication.getCommandListManager(), commandSetProfile);
    }

    private CommandSetProfile(LogChannel logChannel, DSIWLAN dSIWLAN, Profile profile) {
        super(logChannel, dSIWLAN, (class$de$audi$app$wlan$core$hotspot$CommandSetProfile == null ? (class$de$audi$app$wlan$core$hotspot$CommandSetProfile = CommandSetProfile.class$("de.audi.app.wlan.core.hotspot.CommandSetProfile")) : class$de$audi$app$wlan$core$hotspot$CommandSetProfile).getName());
        this.profile = profile;
    }

    public void execute() {
        this.dsiWlan.setProfile(this.profile);
    }

    public void responseSetProfile(int n) {
        this.logger.log(1000000, "CommandSetProfile#responseSetProfile(): result=%1", (long)n);
        this.commandList.commandFinished();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

