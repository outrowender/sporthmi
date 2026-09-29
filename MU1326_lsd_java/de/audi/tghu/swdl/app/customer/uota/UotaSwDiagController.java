/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.dsi.ifc.uota.DSIUotA;

public class UotaSwDiagController {
    private final BaseUpdateOverTheAirController uotaController;

    public UotaSwDiagController(BaseUpdateOverTheAirController baseUpdateOverTheAirController) {
        this.uotaController = baseUpdateOverTheAirController;
    }

    public void triggerServerListRead() {
        this.getLogDSI().log(-1601830656, "[UotaSwDiagController].triggerServerListRead()!");
        DSIUotA dSIUotA = this.getDSI();
        if (null == dSIUotA) {
            this.getLogDSI().log(10000, "[UotaSwDiagController].triggerServerListRead() - NULL DSI!");
            return;
        }
        dSIUotA.getServerList();
    }

    public void triggerUpdatePackagesRead() {
        this.getLogDSI().log(-1601830656, "[UotaSwDiagController].triggerUpdatePackagesRead()!");
        DSIUotA dSIUotA = this.getDSI();
        if (null == dSIUotA) {
            this.getLogDSI().log(10000, "[UotaSwDiagController].triggerUpdatePackagesRead() - NULL DSI!");
            return;
        }
        dSIUotA.getUpdatePackages(1, this.getUotaController().getServerName(), this.getUotaController().getPackageFilter());
    }

    public void triggerUpdateDownloadStatus(int n) {
        this.getLogDSI().log(-2137614336, "[UotaSwDiagController].triggerUpdateDownloadStatus(%1)!", (long)n);
        this.getUotaController().getUotaDSIListener().updateDownloadState(1, n, 1);
    }

    public void triggerCustomerUpdateDone(int n, boolean bl) {
        this.getLogDSI().log(-1601830656, "[UotaSwDiagController].triggerCustomerUpdateDone(%2,%1)!", bl, (long)n);
        DSIUotA dSIUotA = this.getDSI();
        if (null == dSIUotA) {
            this.getLogDSI().log(10000, "[UotaSwDiagController].triggerCustomerUpdateDone() - NULL DSI!");
            return;
        }
        dSIUotA.customerDownloadFinished(1, n, bl);
    }

    public void triggerGetSwdlSourcePath() {
        this.getLogDSI().log(-1601830656, "[UotaSwDiagController].triggerGetSwdlSourcePath()!");
        DSIUotA dSIUotA = this.getDSI();
        if (null == dSIUotA) {
            this.getLogDSI().log(10000, "[UotaSwDiagController].triggerGetSwdlSourcePath() - NULL DSI!");
            return;
        }
        dSIUotA.getAttribute(1, 1);
    }

    public void triggerSwdlSourcePathResult(String string) {
        this.getLogDSI().log(-1601830656, "[UotaSwDiagController].triggerGetSwdlSourcePath(%1)!", (Object)string);
        this.getUotaController().getUotaDSIListener().attributeResult(1, 0, 1, string);
    }

    public Buffer getServerName() {
        return new Buffer(200).append("[serverName=").append(this.getUotaController().getServerName()).append("][serverNameResponse=").append(this.getUotaController().isServerNameResponse()).append(']');
    }

    public void setServerName(String string) {
        this.getLogDSI().log(-1601830656, "[UotaSwDiagController].setServerName(%1)! Setting server name directly!", (Object)string);
        this.getUotaController().setServerName(string);
        this.getUotaController().setServerNameResponse(true);
    }

    public void cleanupIgnoredPackages() {
        this.getLogUota().log(-1601830656, "[UotaSwDiagController].cleanupIgnoredPackages()!");
        this.getUotaController().getUserIgnoredPackagesContainer().cleanupIgnoredPackages();
    }

    public void resetInstalledPackageIDs() {
        this.getLogUota().log(-1601830656, "[UotaSwDiagController].resetInstalledPackageIDs()!");
        this.getUotaController().getUserIgnoredPackagesContainer().updateInstalledPackageIds("");
    }

    public void updateInstalledPackageIDs(String string) {
        this.getLogUota().log(-1601830656, "[UotaSwDiagController].updateInstalledPackageIDs(%1)!", (Object)string);
        this.getUotaController().getUserIgnoredPackagesContainer().updateInstalledPackageIds(string);
    }

    public Buffer getInstalledPackageIDs() {
        this.getLogUota().log(-1601830656, "[UotaSwDiagController].getInstalledPackageIDs()!");
        return new Buffer("Installed package IDs: ").append(StringUtils.toString(this.getUotaController().getUserIgnoredPackagesContainer().getInstalledPackageIDs(), ','));
    }

    public void removeFromIgnoredPackage(int n) {
        this.getLogUota().log(-1601830656, "[UotaSwDiagController].removeFromIgnoredPackage(%1)!", (long)n);
        this.getUotaController().getUserIgnoredPackagesContainer().removeFromIgnoredPackage(n);
    }

    public Buffer getHighestInstalledReleaseVersion() {
        this.getLogUota().log(-1601830656, "[UotaSwDiagController].getHighestInstalledReleaseVersion()!");
        return new Buffer(this.getUotaController().getUserIgnoredPackagesContainer().getHighestInstalledReleaseVersion());
    }

    public void cleanupHighestInstalledReleaseVersion() {
        this.getLogUota().log(-1601830656, "[UotaSwDiagController].cleanHighestInstalledReleaseVersion()!");
        this.getUotaController().getUserIgnoredPackagesContainer().updateLastInstalledReleaseVersion("");
    }

    public Buffer getNumberDownloadPackages() {
        this.getLogUota().log(-2137614336, "[UotaSwDiagController].getNumberOfCurrentDownloadPackage()");
        return new Buffer().append("Dovnload package ").append(this.getUotaController().getNumberOfCurrentDownloadPackage()).append(" of ").append(this.getUotaController().getTotalNumberOfUpdatePackages(false));
    }

    public void cleanupDownloadPackageNumbers() {
        this.getUotaController().cleanupDownloadPackageNumbers();
    }

    public void testFinalPopupTrigger() {
        this.getUotaController().testFinalPopupTrigger();
    }

    public Buffer getIgnoredPackages() {
        this.getLogUota().log(-1601830656, "[UotaSwDiagController].readIgnoredPackages()!");
        Buffer buffer = new Buffer(512);
        buffer.append("Ignored packages:\n");
        Map map = this.uotaController.getUserIgnoredPackagesContainer().getIgnoredPackagesMap();
        if (null != map) {
            Set set = map.keySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                buffer.append("PKG: ").append(string).append(" Version: ").append(map.get(string)).append('\n');
            }
        }
        return buffer;
    }

    private BaseUpdateOverTheAirController getUotaController() {
        return this.uotaController;
    }

    private LogChannel getLogUota() {
        return this.getUotaController().getLogUota();
    }

    private LogChannel getLogDSI() {
        return this.getUotaController().getLogDSI();
    }

    private DSIUotA getDSI() {
        return this.getUotaController().getDSI();
    }
}

