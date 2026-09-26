/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService$MessageType;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService$ResultCode;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.AbstractDistributedServiceComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

public class RemoteHMIIFolderBrowsingServiceListener
implements IFolderBrowsingServiceListener,
ButtonListener {
    private LogChannel logChannel;
    private RemoteHMIService remoteHMIService;
    private ButtonModelApp buttonModel;
    private int terminalID;
    private static int NO_ERROR = 0;
    private static int NOT_CONNECTED = 1;
    private ChoiceModelApp smsCount;
    private ChoiceModelApp emailCount;

    public RemoteHMIIFolderBrowsingServiceListener(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
        this.remoteHMIService = remoteHMIService;
        this.buttonModel = remoteHMIService.getFrameworkAccess().getHMIService().getButtonModel(572400384);
        this.buttonModel.setButtonListener(this);
        this.smsCount = remoteHMIService.getFrameworkAccess().getHMIService().getChoiceModel(605954816);
        this.emailCount = remoteHMIService.getFrameworkAccess().getHMIService().getChoiceModel(622732032);
        this.setErrorScreens(0, 0);
    }

    @Override
    public void updateAccounts(int n, int n2) {
        this.logChannel.log(1078071040, "RemoteHMIIFolderBrowsingServiceListener#updateAccounts: numSmsAccounts %1, numEmailAccounts %2", (long)n, (long)n2);
        this.setErrorScreens(n, n2);
    }

    private void setErrorScreens(int n, int n2) {
        int n3 = n > 0 ? NO_ERROR : NOT_CONNECTED;
        this.logChannel.log(1078071040, "RemoteHMIIFolderBrowsingServiceListener#setErrorScreens: setting SMS %1", (Object)(n3 == NO_ERROR ? " available" : " not available"));
        this.smsCount.setValue(n3);
        int n4 = n2 > 0 ? NO_ERROR : NOT_CONNECTED;
        this.logChannel.log(1078071040, "RemoteHMIIFolderBrowsingServiceListener#setErrorScreens: setting Email %1", (Object)(n4 == NO_ERROR ? " available" : " not available"));
        this.emailCount.setValue(n4);
    }

    @Override
    public void responseEnterAccount(IFolderBrowsingService$ResultCode iFolderBrowsingService$ResultCode) {
        this.logChannel.log(1078071040, "RemoteHMIIFolderBrowsingServiceListener#responseEnterAccount: got resultCode %1, invoking state machine", (Object)iFolderBrowsingService$ResultCode.toString());
        this.buttonModel.fireEvent(this.terminalID);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.terminalID = n3;
        IFolderBrowsingService$MessageType iFolderBrowsingService$MessageType = IFolderBrowsingService$MessageType.SMS;
        int n4 = ((AbstractDistributedServiceComponent)this.remoteHMIService.getDistributedServiceComponent()).getCurrentSelectedDistributedService();
        if (n4 == 8) {
            iFolderBrowsingService$MessageType = IFolderBrowsingService$MessageType.SMS;
        } else if (n4 == 12) {
            iFolderBrowsingService$MessageType = IFolderBrowsingService$MessageType.EMAIL;
        }
        if (this.remoteHMIService.getRemotehmiIFolderBrowsingService() != null) {
            this.logChannel.log(1078071040, "RemoteHMIIFolderBrowsingServiceListener#keyPressed: requestEnterAccount for %1", (Object)iFolderBrowsingService$MessageType);
            this.remoteHMIService.getRemotehmiIFolderBrowsingService().requestEnterAccount(iFolderBrowsingService$MessageType);
        } else {
            this.logChannel.log(1078071040, "RemoteHMIIFolderBrowsingServiceListener#keyPressed: cannot requestEnterAccount for %1", (Object)iFolderBrowsingService$MessageType);
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

