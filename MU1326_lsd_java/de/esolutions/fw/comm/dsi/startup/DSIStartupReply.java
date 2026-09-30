/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.startup;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIStartupReply {
    public static final String IPL_COMM_UUID = "29537988-2009-51c5-92b7-a91acc90fdcf";
    public static final String IPL_COMM_INTERFACE_KEY = "315540c0-c0b8-557f-8f71-77bd39010efd";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.16";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.16";

    public void updateDomainStatusRoot(int var1, int var2) throws MethodException;

    public void updateDomainStatusTuner(int var1, int var2) throws MethodException;

    public void updateDomainStatusMedia(int var1, int var2) throws MethodException;

    public void updateDomainStatusAddressbook(int var1, int var2) throws MethodException;

    public void updateDomainStatusPhone(int var1, int var2) throws MethodException;

    public void updateDomainStatusNav(int var1, int var2) throws MethodException;

    public void updateDomainStatusInfo(int var1, int var2) throws MethodException;

    public void updateDomainStatusCar(int var1, int var2) throws MethodException;

    public void updateDomainStatusAudio(int var1, int var2) throws MethodException;

    public void updateDomainStatusSDS(int var1, int var2) throws MethodException;

    public void updateDomainStatusSWDL(int var1, int var2) throws MethodException;

    public void updateDomainStatusEarlyApps(int var1, int var2) throws MethodException;

    public void updateDomainStatusPostStartup(int var1, int var2) throws MethodException;

    public void updateDomainStatusCommunication(int var1, int var2) throws MethodException;

    public void updateDomainStatusIpServices(int var1, int var2) throws MethodException;

    public void updateDomainStatusGEMMI(int var1, int var2) throws MethodException;

    public void updateDomainStatusBapkombi(int var1, int var2) throws MethodException;

    public void updateDomainStatusBluetooth(int var1, int var2) throws MethodException;

    public void updateDomainStatusBrowser(int var1, int var2) throws MethodException;

    public void updateDomainStatusExplorer(int var1, int var2) throws MethodException;

    public void updateDomainStatusCalendar(int var1, int var2) throws MethodException;

    public void updateDomainStatusPictureStore(int var1, int var2) throws MethodException;

    public void updateDomainStatusStreetView(int var1, int var2) throws MethodException;

    public void updateDomainStatusMobilityHorizon(int var1, int var2) throws MethodException;

    public void updateDomainStatusExBoxM(int var1, int var2) throws MethodException;

    public void updateDomainStatusMirrorLink(int var1, int var2) throws MethodException;

    public void updateDomainStatusSFA(int var1, int var2) throws MethodException;

    public void updateDomainStatusSearch(int var1, int var2) throws MethodException;

    public void updateDomainStatusDiagnosis(int var1, int var2) throws MethodException;

    public void updateDomainStatusAsiaLanguageSupport(int var1, int var2) throws MethodException;

    public void updateDomainStatusExLAP(int var1, int var2) throws MethodException;

    public void updateDomainStatusTVTuner(int var1, int var2) throws MethodException;

    public void updateDomainStatusMediaOnline(int var1, int var2) throws MethodException;

    public void updateDomainStatusMediaRouter(int var1, int var2) throws MethodException;

    public void updateDomainStatusRadioDataServer(int var1, int var2) throws MethodException;

    public void updateDomainStatusSmartphoneIntegration(int var1, int var2) throws MethodException;

    public void updateDomainStatusWirelessCharger(int var1, int var2) throws MethodException;

    public void startDomain(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

