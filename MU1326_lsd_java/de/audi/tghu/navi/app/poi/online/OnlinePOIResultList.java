/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.poi.online.RefreshResolvedEntryCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class OnlinePOIResultList {
    private static final boolean USE_PINS_A_TO_J = false;
    private LogChannel logChannel;
    private ResultElement[] resultList;
    private NavLocation searchContext;
    private int forcedZoomLevel;
    private NavLocationWgs84 forcedLocation;

    public OnlinePOIResultList(LogChannel logChannel) {
        this(logChannel, null);
    }

    public OnlinePOIResultList(LogChannel logChannel, OnlinePOIResultList onlinePOIResultList, int n, boolean bl) {
        this(logChannel, null);
        if (onlinePOIResultList != null && 0 <= n && n < onlinePOIResultList.length()) {
            logChannel.log(10000000, "OnlinePOIResultList#OnlinePOIResultList() - copy element at index %1.", (long)n);
            this.searchContext = bl ? onlinePOIResultList.searchContext : null;
            this.resultList = new ResultElement[]{onlinePOIResultList.getResultElement(n)};
            this.forcedLocation = onlinePOIResultList.getForcedLocation();
        }
    }

    public OnlinePOIResultList(LogChannel logChannel, OnlinePOIResultList onlinePOIResultList) {
        this.logChannel = logChannel;
        this.resultList = null;
        this.searchContext = null;
        if (onlinePOIResultList != null) {
            this.searchContext = onlinePOIResultList.searchContext;
            this.forcedLocation = onlinePOIResultList.getForcedLocation();
            int n = onlinePOIResultList.length();
            this.resultList = new ResultElement[n];
            logChannel.log(10000000, "OnlinePOIResultList#OnlinePOIResultList() - copy %1 elements.", (long)n);
            for (int i2 = 0; i2 < this.resultList.length; ++i2) {
                this.resultList[i2] = onlinePOIResultList.getResultElement(i2);
            }
        }
    }

    public void updateResultList(PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray, NavLocation navLocation) {
        this.resultList = null;
        this.searchContext = navLocation;
        if (poiOnlineSearchValuelistElementArray != null) {
            int n = poiOnlineSearchValuelistElementArray.length;
            this.resultList = new ResultElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                int n2 = 28;
                this.resultList[i2] = new ResultElement(poiOnlineSearchValuelistElementArray[i2], n2);
            }
        }
    }

    public NavLocation getSearchContext() {
        return this.searchContext;
    }

    public PoiOnlineSearchValuelistElement getPOIElementAt(int n) {
        PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = null;
        ResultElement resultElement = this.getResultElement(n);
        if (resultElement != null) {
            poiOnlineSearchValuelistElement = resultElement.getElement();
        }
        return poiOnlineSearchValuelistElement;
    }

    public int getStyleTypeAt(int n) {
        int n2 = 2;
        ResultElement resultElement = this.getResultElement(n);
        if (resultElement != null) {
            n2 = resultElement.getStyleType();
        }
        return n2;
    }

    public NavLocation getTransformedLocationAt(int n) {
        NavLocation navLocation = null;
        ResultElement resultElement = this.getResultElement(n);
        if (resultElement != null) {
            navLocation = resultElement.getTransformedLocation();
        }
        if (navLocation == null) {
            this.logChannel.log(100000, "OnlinePOIResultList#getTransfomedLocationAt() - no transformed location found at: %1!", (long)n);
        }
        return navLocation;
    }

    public CommandList resolveEntry(int n, ICommandListFactory iCommandListFactory) {
        this.logChannel.log(10000000, "OnlinePOIResultList#resolveEntry( %1 )", (long)n);
        ResultElement resultElement = this.getResultElement(n);
        CommandList commandList = null;
        if (resultElement != null) {
            if (resultElement.getTransformedLocation() == null) {
                PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = resultElement.getElement();
                NavLocation navLocation = Util.getLocationFromGeoPos(poiOnlineSearchValuelistElement.longitude, poiOnlineSearchValuelistElement.latitude);
                commandList = iCommandListFactory.createCommandList();
                commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation));
                commandList.add(new RefreshResolvedEntryCommand(resultElement));
            } else {
                this.logChannel.log(10000000, "OnlinePOIResultList#resolveEntry() - index: %1 already resolved! ", (long)n);
            }
        } else {
            this.logChannel.log(100000, "OnlinePOIResultList#resolveEntry() - no element found at index: %1", (long)n);
        }
        return commandList;
    }

    public int length() {
        int n = 0;
        if (this.resultList != null) {
            n = this.resultList.length;
        }
        return n;
    }

    private ResultElement getResultElement(int n) {
        ResultElement resultElement = null;
        if (this.resultList != null && 0 <= n && n < this.resultList.length) {
            resultElement = this.resultList[n];
        } else {
            this.logChannel.log(100000, "OnlinePOIResultList#getResultElement() - no element found at index: %1", (long)n);
        }
        return resultElement;
    }

    public void setForcedZoomLevel(int n) {
        this.forcedZoomLevel = n;
    }

    public int getForcedZoomLevel() {
        return this.forcedZoomLevel;
    }

    public void setForcedLocation(NavLocationWgs84 navLocationWgs84) {
        this.forcedLocation = navLocationWgs84;
    }

    public NavLocationWgs84 getForcedLocation() {
        return this.forcedLocation;
    }

    static class ResultElement {
        PoiOnlineSearchValuelistElement element;
        private int styleType;
        private NavLocation transformedLocation;

        public ResultElement(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n) {
            this.element = poiOnlineSearchValuelistElement;
            this.styleType = n;
            this.transformedLocation = null;
        }

        public NavLocation getTransformedLocation() {
            return this.transformedLocation;
        }

        public void setTransformedLocation(NavLocation navLocation) {
            this.transformedLocation = navLocation;
        }

        public PoiOnlineSearchValuelistElement getElement() {
            return this.element;
        }

        public int getStyleType() {
            return this.styleType;
        }
    }
}

