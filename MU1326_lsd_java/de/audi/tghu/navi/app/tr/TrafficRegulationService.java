/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.tr;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.tr.TrafficRegulationService$CountrySpeedInfoObserver;
import de.audi.tghu.navi.app.tr.TrafficRegulationService$CurrentTrafficSignObserver;
import de.audi.tghu.navi.app.tr.TrafficSignService;
import de.audi.tghu.navi.app.tr.TrafficUtil;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;
import org.dsi.ifc.trafficregulation.DSITrafficRegulationListener;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public class TrafficRegulationService
implements DSITrafficRegulationListener {
    protected final NavigationEnv env;
    private LogChannel logChannel;
    private TrafficSignService trafficSignService;
    private DSITrafficRegulation trafficRegulation;
    private TrafficRegulationService$CountrySpeedInfoObserver countrySpeedInfoObserver;
    private TrafficRegulationService$CurrentTrafficSignObserver currentTrafficSignObserver;
    private RoadClassSpeedInfo[] countrySpeedInfo;
    private TrafficSignInformationOnRoute[] trafficSignInfoOnRoute;
    private TrafficSignInformation currentTrafficSignInfo;

    public TrafficRegulationService(NavigationEnv navigationEnv, IconHandler iconHandler) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getTRLogChannel();
        this.trafficSignService = new TrafficSignService(navigationEnv, iconHandler, navigationEnv.getChoiceModel(-1155725824), navigationEnv.getChoiceModel(1948321280), navigationEnv.getResourceLocatorModel(1914766848), navigationEnv.getResourceLocatorModel(-752744960));
    }

    public static boolean isTrafficRegulationPresent(NavigationEnv navigationEnv) {
        return navigationEnv.getFramework().getSysConst(465) == 1;
    }

    public boolean isTrafficRegulationPresent() {
        return this.env.getFramework().getSysConst(465) == 1;
    }

    public void stop() {
        this.logChannel.log(-2137614336, "TrafficRegulationService#stop()");
        this.trafficSignService.stop();
    }

    public synchronized void setDSITrafficRegulation(DSITrafficRegulation dSITrafficRegulation) {
        this.logChannel.log(-2137614336, "TrafficRegulationService#setDSITrafficRegulation( %1 )", (Object)dSITrafficRegulation);
        this.trafficRegulation = dSITrafficRegulation;
        if (dSITrafficRegulation != null) {
            this.logChannel.log(-2137614336, "TrafficRegulationService#setDSITrafficRegulation() - calling setNotification(*ALL*)");
            dSITrafficRegulation.setNotification(new int[]{2, 3, 4}, (DSIListener)this);
            boolean bl = TrafficUtil.isTrafficRegulationInfoEnabled(this.env);
            this.setEnableTrafficRegulationInfo(bl);
        }
    }

    public void registerCountrySpeedInfoObserver(TrafficRegulationService$CountrySpeedInfoObserver trafficRegulationService$CountrySpeedInfoObserver) {
        this.logChannel.log(-2137614336, "TrafficRegulationService#registerCountrySpeedInfoObserver( %1 )", (Object)trafficRegulationService$CountrySpeedInfoObserver);
        this.countrySpeedInfoObserver = trafficRegulationService$CountrySpeedInfoObserver;
    }

    public void registerCurrentTrafficSignObserver(TrafficRegulationService$CurrentTrafficSignObserver trafficRegulationService$CurrentTrafficSignObserver) {
        this.logChannel.log(-2137614336, "TrafficRegulationService#registerCurrentTrafficSignObserver( %1 )", (Object)trafficRegulationService$CurrentTrafficSignObserver);
        this.currentTrafficSignObserver = trafficRegulationService$CurrentTrafficSignObserver;
    }

    public synchronized void setEnableTrafficRegulationInfo(boolean bl) {
        if (this.trafficRegulation != null) {
            this.logChannel.log(-2137614336, "TrafficRegulationService#setEnableTrafficRegulationInfo() - calling setSpeedLimitWarning( %1, false, 0 )", bl);
            this.trafficRegulation.setSpeedLimitWarning(bl, false, 0);
        }
    }

    public synchronized void requestRoadClassSpeedInfoForCountry(String string) {
        if (this.trafficRegulation != null) {
            this.logChannel.log(-2137614336, "TrafficRegulationService#requestRoadClassSpeedInfoForCountry() - calling requestRoadClassSpeedInfoForCountry( %1 )", (Object)string);
            this.trafficRegulation.requestRoadClassSpeedInfoForCountry(string);
        }
    }

    @Override
    public void updateCurrentTrafficSign(TrafficSignInformation trafficSignInformation, int n) {
        if (n == 1) {
            this.logChannel.log(-2137614336, "TrafficRegulation#updateCurrentTrafficSign()");
            this.currentTrafficSignInfo = trafficSignInformation;
            if (this.currentTrafficSignObserver != null) {
                this.currentTrafficSignObserver.updateCurrentTrafficSign(trafficSignInformation);
                if (!TrafficUtil.isTrafficRegulationInfoEnabled(this.env)) {
                    return;
                }
            }
            this.trafficSignService.updateCurrentTrafficSign(trafficSignInformation);
        }
    }

    @Override
    public void updateCountrySpeedInformation(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
        if (n == 1) {
            int n2 = roadClassSpeedInfoArray == null ? 0 : roadClassSpeedInfoArray.length;
            this.logChannel.log(-2137614336, "TrafficRegulation#updateCountrySpeedInformation() - length: %1 ", (long)n2);
            this.logChannel.log(-2137614336, "TrafficRegulation#updateCountrySpeedInformation() - speedInfo: %1 ", (Object)roadClassSpeedInfoArray);
            this.countrySpeedInfo = roadClassSpeedInfoArray;
        }
    }

    @Override
    public void updateTrafficSignOnRoute(TrafficSignInformationOnRoute[] trafficSignInformationOnRouteArray, int n) {
        if (n == 1) {
            int n2 = trafficSignInformationOnRouteArray == null ? 0 : trafficSignInformationOnRouteArray.length;
            this.logChannel.log(-2137614336, "TrafficRegulation#updateTrafficSignOnRoute() - length: %1 ", (long)n2);
            this.trafficSignInfoOnRoute = trafficSignInformationOnRouteArray;
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(-2137614336, "TrafficRegulation#asyncException( %2, %1, %3 )", (Object)string, (long)n, (long)n2);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("DSITrafficRegulation: ").append(this.trafficRegulation != null ? "available" : "n/a").append('\n');
        buffer.append("TrafficSignChoice: ").append(this.env.getChoiceModel(-1155725824).getValue()).append('\n');
        buffer.append("WarningSignAsiaChoice: ").append(this.env.getChoiceModel(1948321280).getValue()).append('\n');
        buffer.append("TrafficSignResourceLocator: ").append(this.env.getResourceLocatorModel(1914766848).getResourceLocator().getResourceID()).append('\n');
        return buffer.toString();
    }

    @Override
    public void requestRoadClassSpeedInfoForCountryResult(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
        this.logChannel.log(-2137614336, "TrafficRegulation#requestRoadClassSpeedInfoForCountryResult()");
        if (this.countrySpeedInfoObserver != null) {
            this.countrySpeedInfoObserver.requestRoadClassSpeedInfoForCountryResult(roadClassSpeedInfoArray, n);
        } else {
            this.logChannel.log(-1601830656, "TrafficRegulation#requestRoadClassSpeedInfoForCountryResult() - no observer registered!");
        }
    }

    public RoadClassSpeedInfo[] getCountrySpeedInfo() {
        return this.countrySpeedInfo;
    }

    public TrafficSignInformationOnRoute[] getTrafficSignInfoOnRoute() {
        return this.trafficSignInfoOnRoute;
    }

    public int getCurrentSpeedLimit() {
        int n = 0;
        if (this.currentTrafficSignInfo != null && this.currentTrafficSignInfo.getHighestPrioritySpeedLimit() != null) {
            this.currentTrafficSignInfo.getHighestPrioritySpeedLimit().getSpeedLimit();
            n = this.currentTrafficSignInfo.getHighestPrioritySpeedLimit().getSpeedLimit();
        }
        this.logChannel.log(-2137614336, "TrafficRegulation#getCurrentSpeedLimit() - result:%1", (long)n);
        return n;
    }

    public byte getCurrentSpeedLimitUnit() {
        int n = -1;
        if (this.currentTrafficSignInfo != null && this.currentTrafficSignInfo.getHighestPrioritySpeedLimit() != null) {
            int n2 = -1;
            n2 = this.currentTrafficSignInfo.getHighestPrioritySpeedLimit().getSpeedUnit();
            switch (n2) {
                case 0: {
                    n = 0;
                    break;
                }
                case 1: {
                    n = 1;
                    break;
                }
                default: {
                    n = -1;
                }
            }
        }
        this.logChannel.log(-2137614336, "TrafficRegulation#getCurrentSpeedLimitUnit() - result: %1 ", (long)n);
        return (byte)n;
    }

    public DSITrafficRegulation getTrafficRegulationDsi() {
        return this.trafficRegulation;
    }

    @Override
    public void updateTrailerStatus(int n, int n2) {
    }
}

