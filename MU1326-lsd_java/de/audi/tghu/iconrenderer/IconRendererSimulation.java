/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRendererSimulation$1;
import de.audi.tghu.iconrenderer.IconRendererSimulation$2;
import de.audi.tghu.iconrenderer.IconRendererSimulation$3;
import de.audi.tghu.iconrenderer.IconRendererSimulation$4;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.DSIIconExtractor;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class IconRendererSimulation
implements DSIIconExtractor {
    private IconRenderer iconHandler;
    private LogChannel logCh;
    private static final int RESOURCE_ID;

    public IconRendererSimulation(IconRenderer iconRenderer, LogChannel logChannel) {
        this.iconHandler = iconRenderer;
        this.logCh = logChannel;
    }

    @Override
    public void renderingInformationForRoadIcon(int n, int n2, int n3) {
        this.logCh.log(-2137614336, "[IconRendererSimulation#renderingInformationForRoadIcon] Called. ");
        this.iconHandler.renderingInformationForRoadIcon(new ResourceLocator(31585541), new TextRenderingInfo(0, 0, 0, 0, 0));
    }

    @Override
    public void resourceIdForPOIIcon(int n, int n2, int n3) {
        this.logCh.log(-2137614336, "[IconRendererSimulation#renderingInformationForRoadIcon] Called. ");
        IconRendererSimulation$1 iconRendererSimulation$1 = new IconRendererSimulation$1(this);
        iconRendererSimulation$1.start();
    }

    @Override
    public void resourceIdForTMCEventIcon(int n, int n2, int n3) {
        this.logCh.log(-2137614336, "[IconRendererSimulation#renderingInformationForRoadIcon] Called. ");
        this.iconHandler.resourceIdForTMCEventIcon(new ResourceLocator(31585541));
    }

    @Override
    public void resourceIdForRoadClassIcon(int n, int n2, int n3) {
        this.logCh.log(-2137614336, "[IconRendererSimulation#resourceIdForRoadClassIcon] Called.");
        IconRendererSimulation$2 iconRendererSimulation$2 = new IconRendererSimulation$2(this);
        iconRendererSimulation$2.start();
    }

    @Override
    public void resourceIdForTargetIcon(int n, int n2) {
        this.logCh.log(-2137614336, "[IconRendererSimulation#resourceIdForTargetIcon] Called.");
        IconRendererSimulation$3 iconRendererSimulation$3 = new IconRendererSimulation$3(this);
        iconRendererSimulation$3.start();
    }

    @Override
    public void resourceIdForTrafficRegulationIcon(int n, int n2, int n3) {
        this.logCh.log(-2137614336, "[IconRendererSimulation#resourceIdForTrafficRegulationIcon] Called.");
        IconRendererSimulation$4 iconRendererSimulation$4 = new IconRendererSimulation$4(this);
        iconRendererSimulation$4.start();
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
    }

    public String getName() {
        return null;
    }

    public String getServiceAdapterVersion() {
        return null;
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void renderingInformationForExitIcon(int n, int n2, int n3) {
    }

    @Override
    public void resourceIdForAdditionalIcon(int n, int n2, int n3) {
    }

    @Override
    public void resourceIdForCountryIcon(int n, int n2) {
    }

    @Override
    public void resourceIdForTrafficRegulationIconWithSubindex(int n, int n2, int n3, int n4) {
    }

    @Override
    public void renderingInformationForExitIconWithVariant(int n, int n2, int n3, int n4) {
    }

    @Override
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

    @Override
    public void resourceIdForAdditionalTurnListIcon(int n, int n2, int n3, int n4) {
    }

    @Override
    public void resourceIdForTrafficSourceIcon(int n, int n2) {
    }

    @Override
    public void resourceIdForAreaWarningIcon(int n, int n2) {
    }

    @Override
    public void resourceIdForComposedPOIIcon(int n, int n2, int n3, int[] nArray) {
    }

    @Override
    public void resourceIdForPOIIconFromRawData(int n, int n2, int n3) {
    }

    static /* synthetic */ IconRenderer access$000(IconRendererSimulation iconRendererSimulation) {
        return iconRendererSimulation.iconHandler;
    }
}

