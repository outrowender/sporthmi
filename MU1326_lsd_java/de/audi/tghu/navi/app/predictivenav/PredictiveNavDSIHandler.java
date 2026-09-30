/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.predictivenav.IPredictiveNavController;
import de.audi.tghu.navi.app.predictivenav.NullDSIPredictiveNav;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation;
import org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener;
import org.dsi.ifc.predictivenavigation.LikelyDestination;
import org.osgi.framework.BundleContext;

public class PredictiveNavDSIHandler
implements DSIPredictiveNavigationListener {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected DSIActivator dsiActivator = null;
    protected DSIPredictiveNavigation dsi;
    private static final int INSTANCEID_PREDICTIVE_NAV = 0;
    private static final int DEFAULT_MAX_PREDICTIONS = 3;
    private static final int DAY_IN_MINUTES = 1440;
    private static final int CLEAR_DESTINATION_RADIUS_IN_METERS = 800;
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected IFrameworkAccess framework;
    IPredictiveNavController pNavController;
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation;
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener;

    public PredictiveNavDSIHandler(NavigationEnv navigationEnv, IPredictiveNavController iPredictiveNavController) {
        this.env = navigationEnv;
        this.framework = navigationEnv.getFramework();
        this.logChannel = navigationEnv.getPredictiveNavigationLogChannel();
        this.pNavController = iPredictiveNavController;
    }

    protected final void deinitDSI() {
        this.logChannel.log(10000000, "%1#deinit()", (Object)this.CLASS_NAME);
        if (this.dsi != null) {
            try {
                this.dsi.clearNotification(this);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "%1#deinitDSI() = %2", (Object)this.CLASS_NAME, (Throwable)exception);
            }
        }
    }

    public void startDSI(BundleContext bundleContext) {
        this.logChannel.log(10000000, "%1#startDSI()", (Object)this.CLASS_NAME);
        this.getDSIActivator().start(bundleContext);
    }

    public void stopDSI(BundleContext bundleContext) {
        this.logChannel.log(10000000, "%1#stopDSI()", (Object)this.CLASS_NAME);
        this.getDSIActivator().stop(bundleContext);
    }

    private DSIActivator getDSIActivator() {
        if (this.dsiActivator == null) {
            IDSIClient iDSIClient = new IDSIClient(){

                public void setDSI(DSIBase dSIBase) {
                    PredictiveNavDSIHandler.this.setDSIPredictiveNavigation((DSIPredictiveNavigation)dSIBase);
                }

                public int[] getAutoNotifications() {
                    return new int[]{1, 3, 2};
                }
            };
            this.dsiActivator = new DSIActivator(this.framework, (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = PredictiveNavDSIHandler.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation).getName(), (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener = PredictiveNavDSIHandler.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener).getName(), new Integer(0), this, iDSIClient);
        }
        return this.dsiActivator;
    }

    private final void setDSIPredictiveNavigation(DSIPredictiveNavigation dSIPredictiveNavigation) {
        this.logChannel.log(10000000, "%1#setDSI # dsi=%2", (Object)this.CLASS_NAME, (Object)dSIPredictiveNavigation);
        if (dSIPredictiveNavigation == null) {
            this.deinitDSI();
        }
        DSIPredictiveNavigation dSIPredictiveNavigation2 = this.dsi = dSIPredictiveNavigation != null ? dSIPredictiveNavigation : new NullDSIPredictiveNav(this.logChannel);
        if (this.dsi != null) {
            this.setMaxPredictions(3);
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(10000, new StringBuffer().append(this.CLASS_NAME).append("#asyncException # errorMsg=%1, errorCode=%2, requestType=%3").toString(), (Object)string, (long)n, (long)n2);
    }

    public void updateOperationMode(int n, int n2) {
        this.logChannel.log(10000000, "%1#updateOperationMode # operationMode=%2, validFlag=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getContainer().setPredictiveNavOperationMode(n);
            this.pNavController.updateOperationMode();
        }
    }

    public void updateLikelyDestinations(LikelyDestination[] likelyDestinationArray, int n) {
        this.logLikelyDestinations(likelyDestinationArray, n);
        if (n == 1) {
            this.pNavController.updateLikelyDestinations(likelyDestinationArray);
        } else {
            this.logChannel.log(100000, "%1#updateLikelyDestinations # validFlag=%2", (Object)this.CLASS_NAME, (long)n);
        }
    }

    private void logLikelyDestinations(LikelyDestination[] likelyDestinationArray, int n) {
        if (likelyDestinationArray != null) {
            this.logChannel.log(10000000, "%1#updateLikelyDestinations # validFlag=%2 # size=%3", (Object)this.CLASS_NAME, (long)n, (long)likelyDestinationArray.length);
            for (int i2 = 0; i2 < likelyDestinationArray.length; ++i2) {
                if (likelyDestinationArray[i2] != null && likelyDestinationArray[i2].getDestination() != null) {
                    this.logChannel.log(10000000, "%1#updateLikelyDestinations # Destination=%2 # calcState=%3 # segmentId=%4", (Object)this.CLASS_NAME, (Object)likelyDestinationArray[i2].getDestination().street, (Object)Integer.toString(likelyDestinationArray[i2].getCalculationState()), (Object)likelyDestinationArray[i2].getSegmentId());
                } else {
                    this.logChannel.log(10000000, "%1#updateLikelyDestinations # invalid LikelyDestination or NavLocation", (Object)this.CLASS_NAME);
                }
                if (!this.logChannel.isDebug2()) continue;
                this.logChannel.log(100000000, "%1#likelyDestination[%2]=%3", (Object)this.CLASS_NAME, (Object)String.valueOf(i2), (Object)this.shortStringLikelyDestination(likelyDestinationArray[i2]));
            }
        } else {
            this.logChannel.log(10000000, "%1#updateLikelyDestinations # validFlag=%2 # noList", (Object)this.CLASS_NAME, (long)n);
        }
    }

    public void updateMaxPredictions(int n, int n2) {
        this.logChannel.log(10000000, "%1#updateMaxPredictions # predictions=%2, validFlag=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n2 == 1) {
            this.pNavController.updateMaxPredictions(n);
        } else if (n2 == 2) {
            // empty if block
        }
    }

    public void clearCacheResult() {
        this.logChannel.log(10000000, "%1#clearCacheResult", (Object)this.CLASS_NAME);
        this.pNavController.clearCacheResult();
    }

    public void clearCache() {
        this.logChannel.log(10000000, "%1#clearCache", (Object)this.CLASS_NAME);
        try {
            if (this.dsi != null) {
                this.dsi.clearCache();
            } else {
                this.logChannel.log(10000, "%1#clearCache dsi=null", (Object)this.CLASS_NAME);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#clearCache e=%2", (Object)this.CLASS_NAME, (Throwable)exception);
        }
    }

    public void clearCacheLast24h() {
        this.logChannel.log(10000000, "%1#clearCacheLast24h", (Object)this.CLASS_NAME);
        try {
            if (this.dsi != null) {
                this.dsi.clearCacheByAge(1440L);
            } else {
                this.logChannel.log(10000, "%1#clearCacheLast24h dsi=null", (Object)this.CLASS_NAME);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#clearCacheLast24h e=%2", (Object)this.CLASS_NAME, (Throwable)exception);
        }
    }

    public void clearCacheByAge(int n) {
        this.logChannel.log(10000000, "%1#clearCacheByAge AgeInMinutes = %1", (Object)this.CLASS_NAME, (long)n);
        try {
            if (this.dsi != null && n > 0) {
                this.dsi.clearCacheByAge(n);
            } else {
                this.logChannel.log(10000, "%1#clearCacheLast24h dsi=null", (Object)this.CLASS_NAME);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#clearCacheLast24h e=%2", (Object)this.CLASS_NAME, (Throwable)exception);
        }
    }

    public void clearCacheByDestination(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#clearCacheByDestination", (Object)this.CLASS_NAME);
        try {
            if (this.dsi != null && navLocation != null) {
                this.dsi.clearCacheByDestination(navLocation, 800);
            } else {
                this.logChannel.log(10000, "%1#clearCacheByDestination dsi or destination =null", (Object)this.CLASS_NAME);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#clearCacheByDestination e=%2", (Object)this.CLASS_NAME, (Throwable)exception);
        }
    }

    public void setOperationMode(int n) {
        this.logChannel.log(10000000, "%1#setOperationMode operationMode=%2", (Object)this.CLASS_NAME, (long)n);
        try {
            if (this.dsi != null) {
                this.dsi.setOperationMode(n);
            } else {
                this.logChannel.log(10000, "%1#setOperationMode dsi=null", (Object)this.CLASS_NAME);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#setOperationMode e=%2", (Object)this.CLASS_NAME, (Throwable)exception);
        }
    }

    public void setMaxPredictions(int n) {
        this.logChannel.log(10000000, "%1#setMaxPredictions", (Object)this.CLASS_NAME);
        try {
            if (this.dsi != null) {
                this.dsi.setMaxPredictions(n);
            } else {
                this.logChannel.log(10000, "%1#setMaxPredictions dsi=null", (Object)this.CLASS_NAME);
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "%1#maxPredictions e=%2", (Object)this.CLASS_NAME, (Throwable)exception);
        }
    }

    private String shortStringLikelyDestination(LikelyDestination likelyDestination) {
        StringBuffer stringBuffer = new StringBuffer(2600);
        stringBuffer.append("LikelyDestination");
        stringBuffer.append('(');
        stringBuffer.append("calcState=");
        stringBuffer.append(likelyDestination.calculationState);
        stringBuffer.append(", calcProgress=");
        stringBuffer.append(likelyDestination.calculationProgress);
        stringBuffer.append(", likelihood=");
        stringBuffer.append(likelyDestination.likelihood);
        stringBuffer.append(", destination=");
        stringBuffer.append(this.shortStringNavLocation(likelyDestination.destination));
        stringBuffer.append(", segmentId=");
        stringBuffer.append(likelyDestination.segmentId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    private String shortStringNavLocation(NavLocation navLocation) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Location [");
        stringBuffer.append(", positionValid=");
        stringBuffer.append(navLocation.positionValid);
        stringBuffer.append(", version=");
        stringBuffer.append(navLocation.version);
        stringBuffer.append(", versionOfLocationStructureValid=");
        stringBuffer.append(navLocation.versionOfLocationStructureValid);
        stringBuffer.append("]");
        return stringBuffer.toString();
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

