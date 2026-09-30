/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.iconrenderer.IconRenderer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.DSIIconExtractor;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class IconRendererSimulation
implements DSIIconExtractor {
    private IconRenderer iconHandler;
    private LogChannel logCh;
    private static final int RESOURCE_ID = 100000001;

    public IconRendererSimulation(IconRenderer iconRenderer, LogChannel logChannel) {
        this.iconHandler = iconRenderer;
        this.logCh = logChannel;
    }

    public void renderingInformationForRoadIcon(int n, int n2, int n3) {
        this.logCh.log(10000000, "[IconRendererSimulation#renderingInformationForRoadIcon] Called. ");
        this.iconHandler.renderingInformationForRoadIcon(new ResourceLocator(100000001), new TextRenderingInfo(0, 0, 0, 0, 0));
    }

    public void resourceIdForPOIIcon(int n, int n2, int n3) {
        this.logCh.log(10000000, "[IconRendererSimulation#renderingInformationForRoadIcon] Called. ");
        Thread thread = new Thread(){

            public void run() {
                IconRendererSimulation.this.iconHandler.resourceIdForPOIIcon(new ResourceLocator(100000001));
            }
        };
        thread.start();
    }

    public void resourceIdForTMCEventIcon(int n, int n2, int n3) {
        this.logCh.log(10000000, "[IconRendererSimulation#renderingInformationForRoadIcon] Called. ");
        this.iconHandler.resourceIdForTMCEventIcon(new ResourceLocator(100000001));
    }

    public void resourceIdForRoadClassIcon(int n, int n2, int n3) {
        this.logCh.log(10000000, "[IconRendererSimulation#resourceIdForRoadClassIcon] Called.");
        Thread thread = new Thread(){

            public void run() {
                IconRendererSimulation.this.iconHandler.resourceIdForRoadClassIcon(new ResourceLocator(100000001));
            }
        };
        thread.start();
    }

    public void resourceIdForTargetIcon(int n, int n2) {
        this.logCh.log(10000000, "[IconRendererSimulation#resourceIdForTargetIcon] Called.");
        Thread thread = new Thread(){

            public void run() {
                IconRendererSimulation.this.iconHandler.resourceIdForTargetIcon(new ResourceLocator(100000001));
            }
        };
        thread.start();
    }

    public void resourceIdForTrafficRegulationIcon(int n, int n2, int n3) {
        this.logCh.log(10000000, "[IconRendererSimulation#resourceIdForTrafficRegulationIcon] Called.");
        Thread thread = new Thread(){

            public void run() {
                IconRendererSimulation.this.iconHandler.resourceIdForTrafficRegulationIcon(new ResourceLocator(100000001));
            }
        };
        thread.start();
    }

    public void clearNotification(DSIListener dSIListener) {
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void clearNotification(int n, DSIListener dSIListener) {
    }

    public String getName() {
        return null;
    }

    public String getServiceAdapterVersion() {
        return null;
    }

    public void setNotification(DSIListener dSIListener) {
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void setNotification(int n, DSIListener dSIListener) {
    }

    public void renderingInformationForExitIcon(int n, int n2, int n3) {
    }

    public void resourceIdForAdditionalIcon(int n, int n2, int n3) {
    }

    public void resourceIdForCountryIcon(int n, int n2) {
    }

    public void resourceIdForTrafficRegulationIconWithSubindex(int n, int n2, int n3, int n4) {
    }

    public void renderingInformationForExitIconWithVariant(int n, int n2, int n3, int n4) {
    }

    public void setBrandIconStyle(int[] nArray, int n) {
    }

    public void getTMCEventIcon(int n, int n2, int n3, int n4) {
    }

    public void getPOIIcon(int n, int n2, int n3, int n4) {
    }

    public void getRoadIcon(int n, int n2, int n3, int n4) {
    }

    public void getDestinationIcon(int n, int n2, int n3) {
    }

    public void getRoadClassIcon(int n, int n2, int n3, int n4) {
    }

    public void getCountryInfoIcon(int n, int n2, int n3, int n4) {
    }

    public void getCountryFlagIcon(int n, int n2, int n3) {
    }

    public void getTrafficRegulationIcon(int n, int n2, int n3, int n4, int n5) {
    }

    public void getExitIcon(int n, int n2, int n3, int n4, int n5) {
    }

    public void resourceIdForAdditionalTurnListIcon(int n, int n2, int n3, int n4) {
    }

    public void resourceIdForTrafficSourceIcon(int n, int n2) {
    }

    public void resourceIdForAreaWarningIcon(int n, int n2) {
    }

    public void resourceIdForComposedPOIIcon(int n, int n2, int n3, int[] nArray) {
    }

    public void resourceIdForPOIIconFromRawData(int n, int n2, int n3) {
    }
}

