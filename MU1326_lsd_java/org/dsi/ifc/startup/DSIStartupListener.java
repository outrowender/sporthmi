/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.startup;

import org.dsi.ifc.base.DSIListener;

public interface DSIStartupListener
extends DSIListener {
    public void updateDomainStatusRoot(int var1, int var2);

    public void updateDomainStatusTuner(int var1, int var2);

    public void updateDomainStatusMedia(int var1, int var2);

    public void updateDomainStatusAddressbook(int var1, int var2);

    public void updateDomainStatusPhone(int var1, int var2);

    public void updateDomainStatusNav(int var1, int var2);

    public void updateDomainStatusInfo(int var1, int var2);

    public void updateDomainStatusCar(int var1, int var2);

    public void updateDomainStatusAudio(int var1, int var2);

    public void updateDomainStatusSDS(int var1, int var2);

    public void updateDomainStatusSWDL(int var1, int var2);

    public void updateDomainStatusEarlyApps(int var1, int var2);

    public void updateDomainStatusPostStartup(int var1, int var2);

    public void updateDomainStatusCommunication(int var1, int var2);

    public void updateDomainStatusIpServices(int var1, int var2);

    public void updateDomainStatusGEMMI(int var1, int var2);

    public void updateDomainStatusBapkombi(int var1, int var2);

    public void updateDomainStatusBluetooth(int var1, int var2);

    public void updateDomainStatusBrowser(int var1, int var2);

    public void updateDomainStatusExplorer(int var1, int var2);

    public void updateDomainStatusCalendar(int var1, int var2);

    public void updateDomainStatusPictureStore(int var1, int var2);

    public void updateDomainStatusStreetView(int var1, int var2);

    public void updateDomainStatusMobilityHorizon(int var1, int var2);

    public void updateDomainStatusExBoxM(int var1, int var2);

    public void updateDomainStatusMirrorLink(int var1, int var2);

    public void updateDomainStatusSFA(int var1, int var2);

    public void updateDomainStatusSearch(int var1, int var2);

    public void updateDomainStatusDiagnosis(int var1, int var2);

    public void updateDomainStatusAsiaLanguageSupport(int var1, int var2);

    public void updateDomainStatusExLAP(int var1, int var2);

    public void updateDomainStatusTVTuner(int var1, int var2);

    public void updateDomainStatusMediaOnline(int var1, int var2);

    public void updateDomainStatusMediaRouter(int var1, int var2);

    public void updateDomainStatusRadioDataServer(int var1, int var2);

    public void updateDomainStatusSmartphoneIntegration(int var1, int var2);

    public void updateDomainStatusWirelessCharger(int var1, int var2);

    public void startDomain(int var1, int var2);
}

