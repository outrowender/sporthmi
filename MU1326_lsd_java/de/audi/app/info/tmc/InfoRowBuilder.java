/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoDetailsRow;
import de.audi.app.info.tmc.InfoListRow;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.metrics.Distance;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.TMCAbstractListRowBuilder;
import java.util.ArrayList;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class InfoRowBuilder
extends TMCAbstractListRowBuilder {
    private static String LOGCLASS = "InfoRowBuilder";
    private InfoEnv env;

    public InfoRowBuilder(AppTMC appTMC, InfoEnv infoEnv) {
        super(appTMC);
        this.env = infoEnv;
    }

    public TMCAbstractListRow buildSimpleListRow(TmcListElement tmcListElement) {
        if (tmcListElement == null || tmcListElement.getMessage() == null) {
            this.lc.log(100000, "%1#buildListRow - message is null", (Object)LOGCLASS);
            return null;
        }
        TmcMessage tmcMessage = tmcListElement.getMessage();
        IconCell iconCell = this.getRoadIcon(tmcListElement);
        InfoListRow infoListRow = null;
        infoListRow = tmcMessage.isArea ? new InfoListRow(tmcListElement, iconCell, tmcMessage.getStartLocation(), -1, tmcMessage.getDirectionOfRoad2(), this.getEventIcon(tmcMessage, 0), this.getEventText(tmcMessage), this.getDirectionArrow(tmcMessage), this.getAirDistance(tmcMessage), this.env) : new InfoListRow(tmcListElement, iconCell, tmcMessage.getDirectionOfRoad1(), this.getArrowIcon(tmcMessage), tmcMessage.getDirectionOfRoad2(), this.getEventIcon(tmcMessage, 0), this.getEventText(tmcMessage), this.getDirectionArrow(tmcMessage), this.getAirDistance(tmcMessage), this.env);
        if (tmcMessage.routeRelevance == 0) {
            infoListRow.updateRrdCarToEvent(this.appTmc.getDistanceToFinalDestination());
        }
        return infoListRow;
    }

    public TMCAbstractListRow buildParentNodeListRow(TmcListElement tmcListElement, long l) {
        if (tmcListElement == null) {
            this.lc.log(100000, "%1#buildParentNodeListRow - message is null", (Object)LOGCLASS);
            return null;
        }
        IconCell iconCell = this.getRoadIcon(tmcListElement);
        InfoListRow infoListRow = new InfoListRow(tmcListElement, iconCell, tmcListElement.getRoadName(), String.valueOf(tmcListElement.getNumberOfMessagesInNode()), l);
        return infoListRow;
    }

    public TMCAbstractListRow[] buildDetailsList(TmcListElement tmcListElement) {
        InfoDetailsRow infoDetailsRow;
        if (tmcListElement == null || tmcListElement.getMessage() == null) {
            this.lc.log(10000, "%1#buildDetailsRow - message is null", (Object)LOGCLASS);
            return null;
        }
        TmcMessage tmcMessage = tmcListElement.getMessage();
        IconCell iconCell = this.getRoadIcon(tmcListElement);
        ArrayList arrayList = new ArrayList(8);
        if (!tmcMessage.isArea) {
            infoDetailsRow = new InfoDetailsRow(tmcListElement, 0, iconCell, tmcMessage.getDirectionOfRoad1(), this.getArrowIcon(tmcMessage), this.getEventIcon(tmcMessage, 0), new Distance(this.getAirDistance(tmcMessage), 5), 0, this.getDirectionArrow(tmcMessage), this.env);
            arrayList.add(infoDetailsRow);
        }
        infoDetailsRow = null;
        if (!StringUtilities.isNullOrEmpty(tmcMessage.startLocation) || !StringUtilities.isNullOrEmpty(tmcMessage.endLocation)) {
            if (!StringUtilities.isNullOrEmpty(tmcMessage.startLocation) && !StringUtilities.isNullOrEmpty(tmcMessage.endLocation)) {
                infoDetailsRow = new InfoDetailsRow(tmcListElement, 1, iconCell, tmcMessage.getDirectionOfRoad1(), this.getArrowIcon(tmcMessage), this.getEventIcon(tmcMessage, 0), new Distance(this.getAirDistance(tmcMessage), 5), 0, this.getDirectionArrow(tmcMessage), this.env);
                arrayList.add(infoDetailsRow);
            } else {
                infoDetailsRow = new InfoDetailsRow(tmcListElement, 2, iconCell, tmcMessage.getDirectionOfRoad1(), this.getArrowIcon(tmcMessage), this.getEventIcon(tmcMessage, 0), new Distance(this.getAirDistance(tmcMessage), 5), 0, this.getDirectionArrow(tmcMessage), this.env);
                arrayList.add(infoDetailsRow);
            }
        }
        for (int i2 = 1; i2 < tmcListElement.message.eventText.length; ++i2) {
            InfoDetailsRow infoDetailsRow2 = new InfoDetailsRow(tmcListElement, 3, iconCell, tmcMessage.getDirectionOfRoad1(), this.getArrowIcon(tmcMessage), this.getEventIcon(tmcMessage, i2), new Distance(this.getAirDistance(tmcMessage), 5), i2, this.getDirectionArrow(tmcMessage), this.env);
            arrayList.add(infoDetailsRow2);
        }
        InfoDetailsRow infoDetailsRow3 = null;
        if (tmcMessage.hasGeoPos) {
            if (tmcMessage.routeRelevance == 0) {
                infoDetailsRow3 = new InfoDetailsRow(tmcListElement, 5, iconCell, tmcMessage.getDirectionOfRoad1(), this.getArrowIcon(tmcMessage), this.getEventIcon(tmcMessage, 0), new Distance(this.getAirDistance(tmcMessage), 5), 0, this.getDirectionArrow(tmcMessage), this.env);
                long l = (long)this.appTmc.getDistanceToFinalDestination() - infoDetailsRow3.getTmcListElement().getMessage().distanceToEvent;
                if (l >= 0L) {
                    infoDetailsRow3.updateRrdCarToEvent(this.appTmc.getDistanceToFinalDestination());
                    arrayList.add(infoDetailsRow3);
                }
            } else {
                infoDetailsRow3 = new InfoDetailsRow(tmcListElement, 4, iconCell, tmcMessage.getDirectionOfRoad1(), this.getArrowIcon(tmcMessage), this.getEventIcon(tmcMessage, 0), new Distance(this.getAirDistance(tmcMessage), 5), 0, this.getDirectionArrow(tmcMessage), this.env);
                arrayList.add(infoDetailsRow3);
            }
        }
        return (TMCAbstractListRow[])arrayList.toArray(new InfoDetailsRow[arrayList.size()]);
    }

    public TMCAbstractListRow[] buildDetailsListMsg(TmcMessage tmcMessage) {
        if (tmcMessage == null) {
            this.lc.log(10000, "%1#buildDetailsRowMsg - message is null", (Object)LOGCLASS);
            return new TMCAbstractListRow[0];
        }
        TmcListElement tmcListElement = new TmcListElement();
        tmcListElement.setMessage(tmcMessage);
        return this.buildDetailsList(tmcListElement);
    }

    public TMCAbstractListRow buildSimpleListRow(TmcMessage tmcMessage) {
        TmcListElement tmcListElement = new TmcListElement();
        tmcListElement.setMessage(tmcMessage);
        return this.buildSimpleListRow(tmcListElement);
    }
}

