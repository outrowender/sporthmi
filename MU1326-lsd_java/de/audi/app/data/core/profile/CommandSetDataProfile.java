/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.profile;

import de.audi.app.data.core.AbstractDataCommand;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.profile.ApnAvailability;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.DSIDataConfiguration;

final class CommandSetDataProfile
extends AbstractDataCommand {
    private IDataApplication dataApplication;
    private final CDataProfile profile;
    private final ChoiceModelApp profileAvailableChoice;
    private final ChoiceModelApp monitor;
    private final ChoiceModelApp apnAvailabilityChoice;
    private final int applyButtonModelID;
    static /* synthetic */ Class class$de$audi$app$data$core$profile$CommandSetDataProfile;

    static void schedule(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration, CDataProfile cDataProfile, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, int n) {
        CommandSetDataProfile commandSetDataProfile = new CommandSetDataProfile(iDataApplication, dSIDataConfiguration, cDataProfile, choiceModelApp, choiceModelApp2, choiceModelApp3, n);
        AbstractDataCommand.schedule(iDataApplication.getCommandListManager(), commandSetDataProfile);
    }

    private CommandSetDataProfile(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration, CDataProfile cDataProfile, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, ChoiceModelApp choiceModelApp3, int n) {
        super(iDataApplication.getLogChannel(), dSIDataConfiguration, (class$de$audi$app$data$core$profile$CommandSetDataProfile == null ? (class$de$audi$app$data$core$profile$CommandSetDataProfile = CommandSetDataProfile.class$("de.audi.app.data.core.profile.CommandSetDataProfile")) : class$de$audi$app$data$core$profile$CommandSetDataProfile).getName());
        this.dataApplication = iDataApplication;
        this.profile = cDataProfile;
        if (this.profile.profileID < 0) {
            this.profile.profileID = 0;
        }
        this.profileAvailableChoice = choiceModelApp;
        this.apnAvailabilityChoice = choiceModelApp2;
        this.monitor = choiceModelApp3;
        this.applyButtonModelID = n;
    }

    @Override
    public void execute() {
        if (this.dsi != null) {
            this.dsi.setDataProfile(this.profile);
        } else {
            this.logger.log(-1601830656, "CommandSetDataProfile#execute(): dsi is NULL");
            this.finishWithError();
            this.finishCommand();
        }
    }

    @Override
    public void abort() {
        super.abort();
        this.finishWithError();
        this.finishCommand();
    }

    @Override
    public void setDataProfileResponse(CDataProfile cDataProfile, int n) {
        this.logger.log(1078071040, new StringBuffer().append("CommandSetDataProfile#setDataProfileResponse(): result=%1, dataProfile=").append(cDataProfile).toString(), (long)n);
        if (this.monitor != null) {
            this.monitor.setValue(n == 0 ? 0 : 1);
        } else {
            this.logger.log(-1601830656, "CommandSetDataProfile#setDataProfileResponse(): monitor is NULL");
        }
        this.apnAvailabilityChoice.setValue(ApnAvailability.valueOf((CDataProfile)cDataProfile).value);
        this.finishCommand();
    }

    private void finishWithError() {
        if (this.monitor != null) {
            this.monitor.setValue(1);
        } else {
            this.logger.log(-1601830656, "CommandSetDataProfile#finishWithError(): monitor is NULL");
        }
    }

    private void finishCommand() {
        this.profileAvailableChoice.setStatus(1);
        this.dataApplication.getFramework().getHmiServiceApp().getButtonModel(this.applyButtonModelID).fireEvent(0);
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

