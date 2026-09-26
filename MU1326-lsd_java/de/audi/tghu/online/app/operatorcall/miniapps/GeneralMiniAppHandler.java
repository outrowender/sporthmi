/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.miniapps;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.online.OnlineApplicationOtherContext;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.OnlineEnv;
import de.audi.tghu.online.app.operatorcall.handler.AbstractOperatorCallHandler;
import de.audi.tghu.online.app.operatorcall.miniapps.ConciergeCallMiniAppHandler;
import de.audi.tghu.online.app.operatorcall.miniapps.PoiCallMiniAppHandler;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import java.util.Iterator;
import java.util.List;

public class GeneralMiniAppHandler {
    public final int LABEL01;
    public final int LABEL02;
    public final int LABEL03;
    public final int LABEL04;
    public final int LABEL05;
    public final int LABEL06;
    public final int LABEL07;
    public final int LABEL08;
    public final int LABEL09;
    public final int LABEL10;
    public final int LABEL11;
    public final int LABEL12;
    public final int LABEL13;
    public final int LABEL14;
    public final int LABEL15;
    private PoiCallMiniAppHandler pMiniAppHandler;
    private ConciergeCallMiniAppHandler cMiniAppHandler;
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private OnlineEnv env;
    private final int[] labelIds = new int[]{1998398208, 1864180480, 1914512128, 2031952640, 1964843776, 1931289344, 2048729856, 1981620992, 2065507072, 1897734912, 1948066560, 1880957696, 2082284288, 2099061504, 2015175424};

    public GeneralMiniAppHandler(OnlineEnv onlineEnv, AbstractOperatorCallHandler abstractOperatorCallHandler) {
        this.LABEL01 = 1998398208;
        this.LABEL02 = 1864180480;
        this.LABEL03 = 1914512128;
        this.LABEL04 = 2031952640;
        this.LABEL05 = 1964843776;
        this.LABEL06 = 1931289344;
        this.LABEL07 = 2048729856;
        this.LABEL08 = 1981620992;
        this.LABEL09 = 2065507072;
        this.LABEL10 = 1897734912;
        this.LABEL11 = 1948066560;
        this.LABEL12 = 1880957696;
        this.LABEL13 = 2082284288;
        this.LABEL14 = 2099061504;
        this.LABEL15 = 2015175424;
        this.env = onlineEnv;
        this.pMiniAppHandler = new PoiCallMiniAppHandler(onlineEnv, abstractOperatorCallHandler.getOperatorCall(2));
        this.cMiniAppHandler = new ConciergeCallMiniAppHandler(onlineEnv, abstractOperatorCallHandler.getOperatorCall(1));
    }

    public void updateMiniAppList(List list) {
        int n;
        int n2;
        int n3;
        if (list == null || list.size() == 0) {
            n3 = 0;
            n2 = 3;
        } else {
            n3 = list.size();
            n2 = 1;
            Iterator iterator = list.iterator();
            for (n = 0; iterator.hasNext() && n < 15; ++n) {
                OnlineApplicationOtherContext onlineApplicationOtherContext = (OnlineApplicationOtherContext)iterator.next();
                String string = onlineApplicationOtherContext.getAppName();
                this.logChannel.log(-2137614336, "GeneralMiniAppHandler#updateMiniAppList# %1. miniapp is %2", (Object)Util.createInteger(n + 1), (Object)string);
                String string2 = onlineApplicationOtherContext.getAppContext();
                this.pMiniAppHandler.setNewMiniApp(n, string, string2);
                this.cMiniAppHandler.setNewMiniApp(n, string, string2);
                LabelModelApp labelModelApp = this.env.getLabelModel(this.labelIds[n]);
                labelModelApp.setText(string);
            }
        }
        this.logChannel.log(1078071040, "GeneralMiniAppHandler#updateMiniAppList called with size %1", (long)n3);
        this.setChoiceValue(1847403264, "NUMBER_OF_REMOTE_HMI_APPS_IN_OPERATORCALL_CHOICE", n);
        this.pMiniAppHandler.configureModelsMiniApps(n2, 0);
        this.cMiniAppHandler.configureModelsMiniApps(n2, 0);
    }

    public void setOnlineServiceProvider(AbstractExternalServiceProvider abstractExternalServiceProvider) {
        this.pMiniAppHandler.setOnlineServiceProvider(abstractExternalServiceProvider);
        this.cMiniAppHandler.setOnlineServiceProvider(abstractExternalServiceProvider);
    }

    public void errorOccured() {
        this.pMiniAppHandler.errorOccured();
        this.cMiniAppHandler.errorOccured();
    }

    protected void setChoiceValue(int n, String string, int n2) {
        this.logChannel.log(14808325, "AbstractBaseModelHandler#setChoiceValue: %1 : %2 -> %3", (Object)string, (long)this.getChoiceValue(n), (long)n2);
        this.env.getChoiceModel(n).setValue(n2);
    }

    protected int getChoiceValue(int n) {
        return this.env.getChoiceModel(n).getValue();
    }

    public void triggerLanguageChange() {
        this.logChannel.log(1078071040, "GeneralMiniAppHandler#triggerLanguageChange: called");
        this.updateMiniAppList(null);
    }
}

