/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;

public class IconHandler {
    public static final int INVALID_RESOURCE_ID = -1;
    private RenderingInfoProvider renderingInfoProvider = null;
    private final LogChannel logChannel;

    public IconHandler(NavigationEnv navigationEnv) {
        this.logChannel = navigationEnv.getIconRendererLogChannel();
    }

    public void setRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.renderingInfoProvider = renderingInfoProvider;
    }

    public RenderingInfoProvider getRenderingInfoProvider() {
        return this.renderingInfoProvider;
    }

    public int resolvePOIIconResourceID(String string, int n) {
        int n2 = -1;
        if (string != null) {
            try {
                int n3 = Integer.parseInt(string);
                n2 = this.resolvePOIIconResourceID(n3, n);
            }
            catch (NumberFormatException numberFormatException) {
                this.logChannel.log(100000, "IconHandler#resolvePOIIconResourceID() - failed to parse categoryID: %1! ", (Object)string);
            }
        }
        return n2;
    }

    public int resolvePOIIconResourceID(int n, int n2) {
        int n3 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.getResourceIdForPOIIcon(n, n2);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n3 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolvePOIIconResourceID() - resolved RenderingInfo is null or invalid: requested icon not available! ");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolvePOIIconResourceID() - RenderingInfoProvider not found! ");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolvePOIIconResourceID( %1, %2 ) - returning resourceID: %3 ", (long)n, (long)n2, (long)n3);
        }
        return n3;
    }

    public int resolvePOIIconFromRawData(int n, int n2) {
        int n3 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.resourceIdForPOIIconFromRawData(n, n2);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n3 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolvePOIIconFromRawData() - resolved RenderingInfo is null or invalid: requested icon not available! ");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolvePOIIconFromRawData() - RenderingInfoProvider not found! ");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolvePOIIconFromRawData( %1, %2 ) - returning resourceID: %3 ", (long)n, (long)n2, (long)n3);
        }
        return n3;
    }

    public ExtRenderingInfo resolveStreetIconResourceID(long l, int n) {
        ExtRenderingInfo extRenderingInfo = null;
        if (this.renderingInfoProvider != null) {
            extRenderingInfo = this.renderingInfoProvider.getRenderingInformationForRoadIcon((int)l, n);
            if (extRenderingInfo == null || !extRenderingInfo.isValid()) {
                this.logChannel.log(100000, "IconHandler#resolveStreetIconResourceID() - resolved ExtRenderingInfo is null or invalid: requested icon not available! ");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveStreetIconResourceID() - RenderingInfoProvider not found! ");
        }
        return extRenderingInfo;
    }

    public ExtRenderingInfo resolveExitIconResourceID(int n, int n2) {
        ExtRenderingInfo extRenderingInfo = null;
        if (this.renderingInfoProvider != null) {
            extRenderingInfo = this.renderingInfoProvider.getRenderingInformationForExitIcon(n, n2);
            if (extRenderingInfo == null || !extRenderingInfo.isValid()) {
                this.logChannel.log(100000, "IconHandler#resolveExitIconResourceID() - resolved ExtRenderingInfo is null or invalid: requested icon not available! ");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveExitIconResourceID() - RenderingInfoProvider not found! ");
        }
        return extRenderingInfo;
    }

    public int resolveTMCIconResourceID(long l, int n) {
        int n2 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.getResourceIdForTMCEventIcon((int)l, n);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n2 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolveTMCIconResourceID() - resolved RenderingInfo is null or invalid: requested icon not available! ");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveTMCIconResourceID() - RenderingInfoProvider not found! ");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolveTMCIconResourceID( %1, %2 ) - returning resourceID: %3 ", l, (long)n, (long)n2);
        }
        return n2;
    }

    public int resolveTargetIcon(int n) {
        int n2 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.getResourceIdForTargetIcon(n);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n2 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolveTargetIcon() - resolved RenderingInfo is null or invalid: requested icon %1 not available!", (long)n);
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveTargetIcon() - RenderingInfoProvider not found!");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolveTargetIcon( %1 ) - returning resourceID: %2", (long)n, (long)n2);
        }
        return n2;
    }

    public int resolveTrafficRegulationIconWithSubindexResourceID(int n, int n2, int n3) {
        int n4 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.getResourceIdForTrafficRegulationIconWithSubindex(n, n2, n3);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n4 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolveTrafficRegulationIconWithSubindexResourceID() - resolved RenderingInfo is null or invalid: requested icon not available!");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveTrafficRegulationIconWithSubindexResourceID() - RenderingInfoProvider not found!");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolveTrafficRegulationIconWithSubindexResourceID( %1 ) - returning resourceID: %2", (long)n, (long)n4);
        }
        return n4;
    }

    public int resolveTrafficRegulationIconResourceID(int n, int n2) {
        int n3 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.getResourceIdForTrafficRegulationIcon(n, n2);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n3 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolveTrafficRegulationIconResourceID() - resolved RenderingInfo is null or invalid: requested icon not available!");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveTrafficRegulationIconResourceID() - RenderingInfoProvider not found!");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolveTrafficRegulationIconResourceID( %1 ) - returning resourceID: %2", (long)n, (long)n3);
        }
        return n3;
    }

    public int resolveTrafficRegulationIconResourceID(int n, int n2, int n3) {
        int n4 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.getResourceIdForTrafficRegulationIcon(n, n2, n3);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n4 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolveTrafficRegulationIconResourceID() - resolved RenderingInfo is null or invalid: requested icon not available!");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveTrafficRegulationIconResourceID() - RenderingInfoProvider not found!");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolveTrafficRegulationIconResourceID( %1 ) - returning resourceID: %2", (long)n, (long)n4);
        }
        return n4;
    }

    public int resolveRoadClassIconResourceID(int n, int n2) {
        int n3 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.getResourceIdForRoadClassIcon(n, n2);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n3 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolveRoadClassIconResourceID() - resolved RenderingInfo is null or invalid: requested icon not available!");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveRoadClassIconResourceID() - RenderingInfoProvider not found!");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolveRoadClassIconResourceID( %1 ) - returning resourceID: %2", (long)n, (long)n3);
        }
        return n3;
    }

    public int resolveAdditionalInfoIconResourceID(int n, int n2) {
        int n3 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.getResourceIdForAdditionalInfoIcon(n, n2);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n3 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolveAdditionalInfoIconResourceID() - resolved RenderingInfo is null or invalid: requested icon not available!");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveAdditionalInfoIconResourceID() - RenderingInfoProvider not found!");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolveAdditionalInfoIconResourceID( %1 ) - returning resourceID: %2", (long)n, (long)n3);
        }
        return n3;
    }

    public void resolveTrafficSign(int n, int n2, RenderingInfoProvider.TrafficSignCallback trafficSignCallback) {
        if (trafficSignCallback == null) {
            this.logChannel.log(10000, "IconHandler#resolveTrafficRegulationIcon() - callback is null!");
            return;
        }
        if (this.renderingInfoProvider != null) {
            this.renderingInfoProvider.getResourceIdForTrafficSignAsync(n, n2, trafficSignCallback);
        } else {
            this.logChannel.log(10000, "IconHandler#resolveTrafficRegulationIcon() - RenderingInfoProvider not found!");
            if (trafficSignCallback != null) {
                trafficSignCallback.renderingInfoReceived(n, n2, null);
            }
        }
    }

    public int resolveCountryIconResourceID(int n) {
        int n2 = -1;
        if (this.renderingInfoProvider != null) {
            RenderingInfo renderingInfo = this.renderingInfoProvider.getResourceIdForCountryIcon(n);
            if (renderingInfo != null && renderingInfo.isValid()) {
                n2 = renderingInfo.getResourceId();
            } else {
                this.logChannel.log(100000, "IconHandler#resolveCountryIconResourceID() - resolved RenderingInfo is null or invalid: requested icon not available!");
            }
        } else {
            this.logChannel.log(10000, "IconHandler#resolveCountryIconResourceID() - RenderingInfoProvider not found!");
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "IconHandler#resolveCountryIconResourceID( %1 ) - returning resourceID: %2", (long)n, (long)n2);
        }
        return n2;
    }

    public void flushCacheForPOIIcon() {
        if (this.renderingInfoProvider != null) {
            this.renderingInfoProvider.flushCacheForPOIIcon();
        }
    }
}

