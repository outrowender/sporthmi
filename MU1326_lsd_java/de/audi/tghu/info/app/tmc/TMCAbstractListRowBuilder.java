/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.TMCHelper;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class TMCAbstractListRowBuilder {
    protected AppTMC appTmc;
    private RenderingInfoProvider iconRenderer;
    protected LogChannel lc;

    public TMCAbstractListRowBuilder(AppTMC appTMC) {
        this.appTmc = appTMC;
        this.lc = appTMC.logMain;
    }

    public abstract TMCAbstractListRow buildSimpleListRow(TmcListElement var1);

    public abstract TMCAbstractListRow buildSimpleListRow(TmcMessage var1);

    public abstract TMCAbstractListRow[] buildDetailsList(TmcListElement var1);

    public abstract TMCAbstractListRow[] buildDetailsListMsg(TmcMessage var1);

    public abstract TMCAbstractListRow buildParentNodeListRow(TmcListElement var1, long var2);

    public void setRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.iconRenderer = renderingInfoProvider;
    }

    public TMCAbstractListRow[] buildDetailsList(TmcListElement tmcListElement, int n) {
        return new TMCAbstractListRow[0];
    }

    public int getAirDistance(TmcMessage tmcMessage) {
        int n = this.appTmc.getNaviService().computeRelativeAirDistance(tmcMessage.geoPosLongitude, tmcMessage.geoPosLatitude);
        return n;
    }

    public int getDirectionArrow(TmcMessage tmcMessage) {
        return this.appTmc.getNaviService().computeRelativeDirection(tmcMessage.geoPosLongitude, tmcMessage.geoPosLatitude);
    }

    public String getDirection(TmcMessage tmcMessage, IconCell iconCell) {
        String string;
        if (tmcMessage == null) {
            return null;
        }
        String string2 = string = tmcMessage.isIsArea() ? tmcMessage.getStartLocation() : tmcMessage.getDirectionOfRoad1();
        if ((iconCell == null || tmcMessage.isUrbanFlag()) && !TMCHelper.isEmpty(tmcMessage.getRoadName())) {
            if (string != null && !string.equals("")) {
                Buffer buffer = new Buffer(tmcMessage.getRoadName().length() + string.length() + 2);
                buffer.append(tmcMessage.getRoadName());
                buffer.append(", ");
                buffer.append(string);
                return buffer.toString();
            }
            return tmcMessage.getRoadName();
        }
        return string;
    }

    public String getEventText(TmcMessage tmcMessage) {
        String string = null;
        if (tmcMessage != null && tmcMessage.getEventText() != null && tmcMessage.getEventText().length > 0) {
            string = tmcMessage.getEventText()[0];
        } else {
            if (this.lc.isInfo()) {
                this.lc.log(1000000, "[TMCAbstractListRowBuilder#getEventText] no eventText found, return \"null\", msg: ", (Object)TMCHelper.formatTmcMessageForDebugging(tmcMessage));
            }
            string = "null";
        }
        return string;
    }

    public IconCell getRoadIcon(TmcListElement tmcListElement) {
        String string;
        int n;
        if (tmcListElement.getMessage() != null) {
            n = (int)tmcListElement.getMessage().getStreetSignId();
            string = tmcListElement.getMessage().getRoadNumber();
        } else {
            n = (int)tmcListElement.getStreetSignId();
            string = tmcListElement.getRoadNumber();
        }
        if (this.iconRenderer == null) {
            this.lc.log(10000, "[TMCAbstractListRowBuilder#getRoadIcon] iconRenderer is NULL");
            return null;
        }
        RenderingInfo renderingInfo = null;
        if (string != null && string.length() != 0) {
            try {
                renderingInfo = this.iconRenderer.getRenderingInformationForRoadIcon(n, string.length());
            }
            catch (Exception exception) {
                this.lc.log(10000, "[TMCAbstractListRowBuilder#getRoadIcon] ERROR = %1", (Throwable)exception);
            }
        }
        if (string == null || string.length() == 0 || renderingInfo == null || !renderingInfo.isValid()) {
            return null;
        }
        return new IconCell(new HMIResourceLocator(renderingInfo.getResourceId()), string, ((ExtRenderingInfo)renderingInfo).getFontReference(), ((ExtRenderingInfo)renderingInfo).getFontSize(), ((ExtRenderingInfo)renderingInfo).getFontColor(), ((ExtRenderingInfo)renderingInfo).getDeltaX(), ((ExtRenderingInfo)renderingInfo).getDeltaY());
    }

    public IconCell getEventIcon(TmcMessage tmcMessage, int n) {
        if (this.iconRenderer == null) {
            this.lc.log(10000, "[TMCAbstractListRowBuilder#getRoadIcon] iconRenderer is NULL");
            return null;
        }
        if (tmcMessage.getIconListId().length == 0) {
            this.lc.log(100000, "[TMCAbstractListRowBuilder#getRoadIcon] msg.getIconListId().length == 0");
            return null;
        }
        int n2 = this.appTmc.isRgActive() ? this.getSubindexForEventIcon(tmcMessage, this.lc) : 0;
        RenderingInfo renderingInfo = null;
        try {
            renderingInfo = this.iconRenderer.getResourceIdForTMCEventIcon(tmcMessage.getIconListId()[n], n2);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[TMCAbstractListRowBuilder#getEventIcon] ERROR = %1", (Throwable)exception);
        }
        if (renderingInfo != null && renderingInfo.isValid()) {
            return new IconCell(new HMIResourceLocator(renderingInfo.getResourceId()));
        }
        return new IconCell(new HMIResourceLocator(-1));
    }

    public int getArrowIcon(TmcMessage tmcMessage) {
        if (tmcMessage == null) {
            if (this.lc.isDebug2()) {
                this.lc.log(100000000, "[TMCAbstractListRowBuilder#getArrowIcon] Message is null - Return NO arrow icon, value: %1", -1L);
            }
            return -1;
        }
        if (tmcMessage.isIsArea()) {
            return -1;
        }
        if (tmcMessage.isIsBidirectional() && tmcMessage.getDirectionOfRoad2() != null && tmcMessage.getDirectionOfRoad2().trim().length() > 0) {
            return 1;
        }
        if (tmcMessage.getDirectionOfRoad2() == null || tmcMessage.getDirectionOfRoad2().trim().length() == 0) {
            return -1;
        }
        return 0;
    }

    private int getSubindexForEventIcon(TmcMessage tmcMessage, LogChannel logChannel) {
        int n = AppTMC.isMessageOnRoute(tmcMessage) ? 0 : (AppTMC.isMessageBypassed(tmcMessage) ? 2 : 1);
        return n;
    }

    protected int getDistance(long l, int n, TmcMessage tmcMessage, LogChannel logChannel) {
        if (tmcMessage != null) {
            if (AppTMC.isMessageOnRoute(tmcMessage)) {
                long l2 = tmcMessage.getDistanceToEvent();
                return (int)(l - l2);
            }
            return n;
        }
        logChannel.log(1000000, "[TMCAbstractListRowBuilder#getDistance] msg is null, return 0");
        return 0;
    }
}

