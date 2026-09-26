/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.TurnListElement;

public class TurnListElementWrapper {
    private final TurnListElement turn;
    private String content = null;

    public TurnListElementWrapper(TurnListElement turnListElement) {
        this.turn = turnListElement;
    }

    public String toString() {
        if (this.content == null) {
            this.content = TurnListElementWrapper.toShortString(this.turn);
        }
        return this.content;
    }

    public static String toShortString(TurnListElement turnListElement) {
        int n;
        Buffer buffer = new Buffer("TurnListElement(");
        buffer.append("distance=").append(turnListElement.distance);
        buffer.append(", eta=").append(turnListElement.eta);
        buffer.append(", etaWithTimeDelay=").append(turnListElement.etaWithTimeDelay);
        if (turnListElement.maneuver != null && turnListElement.maneuver.length > 0) {
            buffer.append(", maneuver[").append(turnListElement.maneuver.length).append("]={");
            for (n = 0; n < turnListElement.maneuver.length; ++n) {
                if (n > 0) {
                    buffer.append(", ");
                }
                buffer.append(turnListElement.maneuver[n]);
            }
            buffer.append('}');
        }
        MapUtils.appendIfNotEmpty(buffer, ", street=", turnListElement.street);
        MapUtils.appendIfNotEmpty(buffer, ", turnToStreet=", turnListElement.turnToStreet);
        MapUtils.appendIfNotEmpty(buffer, ", streetIconText=", turnListElement.streetIconText);
        if (turnListElement.streetIconId >= 0) {
            buffer.append(", streetIconId=").append(turnListElement.streetIconId);
        }
        MapUtils.appendIfNotEmpty(buffer, ", exitNumber=", turnListElement.exitNumber);
        MapUtils.appendIfNotEmpty(buffer, ", signPostInfo=", turnListElement.signPostInfo);
        if (turnListElement.exitIconId >= 0) {
            buffer.append(", exitIconId=").append(turnListElement.exitIconId);
        }
        MapUtils.appendIfNotEmpty(buffer, ", countryAbbreviation=", turnListElement.countryAbbreviation);
        buffer.append(", type=").append(turnListElement.type);
        if (turnListElement.additionalIcons != null && turnListElement.additionalIcons.length > 0) {
            buffer.append(", additionalIcons[").append(turnListElement.additionalIcons.length).append("]={");
            for (n = 0; n < turnListElement.additionalIcons.length; ++n) {
                if (n > 0) {
                    buffer.append(", ");
                }
                buffer.append(turnListElement.additionalIcons[n]);
            }
            buffer.append('}');
        }
        if (turnListElement.laneGuidance != null && turnListElement.laneGuidance.length > 0) {
            buffer.append(", laneGuidance[").append(turnListElement.laneGuidance.length).append("]={");
            for (n = 0; n < turnListElement.laneGuidance.length; ++n) {
                if (n > 0) {
                    buffer.append(", ");
                }
                buffer.append(turnListElement.laneGuidance[n]);
            }
            buffer.append('}');
        }
        buffer.append(", destinationIndex=").append(turnListElement.destinationIndex);
        if (turnListElement.tollcost != null) {
            MapUtils.appendIfNotEmpty(buffer, ", tollcost=", turnListElement.tollcost.toString());
        }
        if (turnListElement.length > 0L) {
            buffer.append(", length=").append(turnListElement.length);
        }
        MapUtils.appendIfNotEmpty(buffer, ", streetCardinalDirection=", turnListElement.streetCardinalDirection);
        buffer.append(')');
        return buffer.toString();
    }
}

