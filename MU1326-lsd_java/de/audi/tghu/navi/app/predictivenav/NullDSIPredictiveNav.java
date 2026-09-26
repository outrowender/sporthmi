/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation;

public class NullDSIPredictiveNav
implements DSIPredictiveNavigation {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final LogChannel logChannel;

    public NullDSIPredictiveNav(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChannel.log(-2137614336, "%1#setNotification()", (Object)this.CLASS_NAME);
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logChannel.log(-2137614336, "%1#setNotification()", (Object)this.CLASS_NAME);
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logChannel.log(-2137614336, "%1#setNotification()", (Object)this.CLASS_NAME);
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChannel.log(-2137614336, "%1#clearNotification() - ", (Object)this.CLASS_NAME);
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChannel.log(-2137614336, "%1#clearNotification()", (Object)this.CLASS_NAME);
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logChannel.log(-2137614336, "%1#clearNotification()", (Object)this.CLASS_NAME);
    }

    @Override
    public void setOperationMode(int n) {
        this.logChannel.log(-2137614336, "%1#setOperationMode() - operationMode=%2", (Object)this.CLASS_NAME, (long)n);
    }

    @Override
    public void setMaxPredictions(int n) {
        this.logChannel.log(-2137614336, "%1#setMaxPredictions() - predictions=%2", (Object)this.CLASS_NAME, (long)n);
    }

    @Override
    public void clearCache() {
        this.logChannel.log(-2137614336, "%1#clearCache()", (Object)this.CLASS_NAME);
    }

    @Override
    public void clearCacheByDestination(NavLocation navLocation, int n) {
        this.logChannel.log(-2137614336, "%1#clearCacheByDestination() - radius=%2, destination=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)navLocation);
    }

    @Override
    public void clearCacheByAge(long l) {
        this.logChannel.log(-2137614336, "%1#clearCacheByAge() - age=%2", (Object)this.CLASS_NAME, l);
    }
}

