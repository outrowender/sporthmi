/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.info.app.InfoEnv;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class TMCHelper {
    public static final int TYPE_DIRECTION_ROW = 0;
    public static final int TYPE_DETAIL_ROW = 1;
    public static final String ROUTEINFO_APPENDSTRING_HOVLANE = "\u25ca ";
    private InfoEnv env;
    private Calendar cal = Calendar.getInstance();
    private DateMetric dm = new DateMetric(this.cal.getTime(), 1);
    private LogChannel log;
    private static int region;

    public TMCHelper(InfoEnv infoEnv) {
        this.env = infoEnv;
        region = infoEnv.getFramework().getSysConst(442);
        this.log = this.env.getLogChannel("App.TMC.Helper");
        this.log.log(10000000, "X-Clacks-Overhead: GNU Terry Pratchett");
    }

    void checkActivateShowInMap(TmcListElement tmcListElement, EvoListRow evoListRow, int n) {
        if (tmcListElement == null) {
            this.log.log(100000, "[TMCHelper#checkActivateSkInMap] List element is null, disable SK.");
            this.env.getChoiceModel(500149).setValue(1);
            return;
        }
        TmcMessage tmcMessage = tmcListElement.getMessage();
        if (tmcMessage == null) {
            this.log.log(1000000, "[TMCHelper#checkActivateSkInMap] Message is null, disable ShowInMap.");
            this.env.getChoiceModel(500149).setValue(1);
            return;
        }
        if (!tmcMessage.isHasGeoPos()) {
            this.log.log(10000000, "[TMCHelper#checkActivateSkInMap] Message #%2 with ID %1 has no geo position, disable ShowInMap.", tmcMessage.getMessageID(), tmcMessage.getMessageCount());
            this.env.getChoiceModel(500149).setValue(1);
            return;
        }
        if (!this.containsValidEventIconRenderInfos(evoListRow, n)) {
            this.log.log(10000000, "[TMCHelper#checkActivateSkInMap] No event icons available for message #%2 with ID %1, disable ShowInMap.", tmcMessage.getMessageID(), tmcMessage.getMessageCount());
            this.env.getChoiceModel(500149).setValue(1);
            return;
        }
        if (this.log.isDebug2()) {
            this.log.log(100000000, "[TMCHelper#checkActivateSkInMap] Enable ShowInMap for message #%2 with ID %1.", tmcMessage.getMessageID(), tmcMessage.getMessageCount());
        }
        this.env.getChoiceModel(500149).setValue(0);
    }

    void checkActivateSkReadOut(TmcListElement tmcListElement) {
        if (tmcListElement == null) {
            this.log.log(100000, "[TMCHelper#checkActivateSkReadOut] List element is null, disable SK.");
            this.env.getChoiceModel(500191).setValue(1);
            return;
        }
        TmcMessage tmcMessage = tmcListElement.getMessage();
        if (tmcMessage == null) {
            if (this.log.isDebug2()) {
                this.log.log(100000000, "[TMCHelper#checkActivateSkReadOut] Message is null, disable SK.");
            }
            this.env.getChoiceModel(500191).setValue(1);
            return;
        }
        if (this.log.isDebug2()) {
            this.log.log(100000000, "[TMCHelper#checkActivateSkReadOut] Enable SK for Msg #%2 with ID %1. ", tmcMessage.getMessageID(), tmcMessage.getMessageCount());
        }
        this.env.getChoiceModel(500191).setValue(0);
    }

    void checkShowNextReturnButtonInDetailView(TmcMessage tmcMessage) {
        if (tmcMessage == null) {
            this.env.getChoiceModel(500185).setValue(1);
            if (this.log.isDebug2()) {
                this.log.log(100000000, "[TMCHelper#checkShowNextReturnButtonInDetailView] Show back button.");
            }
        } else {
            this.env.getChoiceModel(500185).setValue(0);
            if (this.log.isDebug2()) {
                this.log.log(100000000, "[TMCHelper#checkShowNextReturnButtonInDetailView] Show next button");
            }
        }
    }

    boolean containsValidEventIconRenderInfos(EvoListRow evoListRow, int n) {
        if (evoListRow == null) {
            this.log.log(10000000, "[TMCHelper#containsInvalidEventIconIds] Contains no valid data, row is null. ");
            return false;
        }
        Object var3_3 = null;
        try {
            switch (n) {
                case 1: {
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    this.log.log(10000, "[TMCHelper#containsInvalidEventIconIds] Unknown row type: %1 ", (long)n);
                    return false;
                }
            }
        }
        catch (ClassCastException classCastException) {
            this.log.log(10000, "[TMCHelper#containsInvalidEventIconIds] Couldn't cast row type: %1 ", (long)n);
            return false;
        }
        if (var3_3 == null || (var3_3).length == 0) {
            if (this.log.isDebug2()) {
                this.log.log(100000000, "[TMCHelper#containsInvalidEventIconIds] Contains no valid data, renderInfo is null or empty. ");
            }
            return false;
        }
        boolean bl = true;
        for (int i2 = 0; i2 < (var3_3).length; ++i2) {
            if (var3_3[i2] == null || !var3_3[i2].isValid()) continue;
            bl = false;
            break;
        }
        if (bl) {
            if (this.log.isDebug2()) {
                this.log.log(100000000, "[TMCHelper#containsInvalidEventIconIds] All icon rendering infos are invalid or null (%1 entries). ", (long)(var3_3).length);
            }
            return false;
        }
        if (this.log.isDebug2()) {
            this.log.log(100000000, "[TMCHelper#containsInvalidEventIconIds] TMC message contains valid event icon rendering infos. ");
        }
        return true;
    }

    public static final boolean isHURegionNAR() {
        return 1 == region;
    }

    public static boolean isHURegionAsia() {
        return region == 2 || region == 3 || region == 4 || region == 5;
    }

    public static boolean isHURegionCNTW() {
        return region == 2 || region == 5;
    }

    public static String determineHovLaneAppendString(TmcMessage tmcMessage) {
        if (TMCHelper.isHURegionNAR() && tmcMessage != null && tmcMessage.isAffectsHOVLane()) {
            return ROUTEINFO_APPENDSTRING_HOVLANE;
        }
        return "";
    }

    void callCombiForTmcReadOutStarted() {
        this.log.log(10000000, "[TMCHelper#callCombiForTmcReadOutStarted] Called, COMBI_T_M_C_ACTIVE_CHOICE set to value: %1", 1L);
        this.env.getChoiceModel(85).setValue(1);
    }

    void callCombiForTmcReadOutFinished() {
        this.log.log(10000000, "[TMCHelper#callCombiForTmcReadOutFinished] Called, COMBI_T_M_C_ACTIVE_CHOICE set to value: %1", 0L);
        this.env.getChoiceModel(85).setValue(0);
    }

    void setTmcReadOutDataAtCombi(TmcMessage tmcMessage) {
        if (tmcMessage == null) {
            this.log.log(10000000, "[TMCHelper#setTmcReadOutDataAtCombi] Message is null, do nothing.");
            return;
        }
        if (this.log.isDebug2()) {
            this.log.log(100000000, "[TMCHelper#setTmcReadOutDataAtCombi] Called, msg: %1", (Object)TMCHelper.formatTmcMessageForDebugging(tmcMessage));
        }
        this.cal.setTime(new Date(tmcMessage.getTimeStamp() * 1000L));
        this.dm.setDate(this.cal.getTime());
        String string = tmcMessage.getProviderName();
        String string2 = this.dm.format();
        if (this.log.isDebug2()) {
            this.log.log(100000000, "[TMCHelper#setTmcReadOutDataAtCombi] Set provider '%1' and time '%2'", (Object)string, (Object)string2);
        }
        this.env.getLabelModel(86).setText(string);
        this.env.getLabelModel(87).setText(string2);
        this.env.getModelAccess().setTMCStatusBar(string, string2);
    }

    public static String arrayToString(String string, int[] nArray) {
        Buffer buffer = new Buffer();
        buffer.append(string);
        buffer.append('[');
        if (nArray == null) {
            buffer.append("]: null");
        } else {
            buffer.append(nArray.length);
            buffer.append("]: {");
            int n = nArray.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                buffer.append(nArray[i2]);
                if (i2 >= n2) continue;
                buffer.append(", ");
            }
        }
        buffer.append("}");
        return buffer.toString();
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }

    public static String formatTmcListElementForDebugging(TmcListElement tmcListElement, long l, long l2, long l3) {
        if (tmcListElement == null) {
            return "null";
        }
        Buffer buffer = new Buffer();
        if (tmcListElement.getUID() == l3) {
            buffer.append("(-) ");
        } else if (tmcListElement.isHasChild()) {
            buffer.append("(+) ");
        } else if (tmcListElement.getParentID() != -1L) {
            buffer.append(" +--- ");
        }
        buffer.append(TMCHelper.formatTmcListElementForDebugging(tmcListElement, l, l2));
        return buffer.toString();
    }

    public static String formatRowForDebugging(EvoListRow evoListRow, long l) {
        if (evoListRow == null) {
            return "null";
        }
        return TMCHelper.formatRowForDebugging(evoListRow, l, -1L);
    }

    public static String formatRowForDebugging(EvoListRow evoListRow, long l, long l2) {
        if (evoListRow == null) {
            return "null";
        }
        Buffer buffer = new Buffer();
        return buffer.toString();
    }

    public static String formatTmcListElementForDebugging(TmcListElement tmcListElement, long l, long l2) {
        if (tmcListElement == null) {
            return "null";
        }
        Buffer buffer = new Buffer();
        buffer.append('[').append("ID:").append(tmcListElement.getUID()).append("][#").append(tmcListElement.getPositionInCompleteList());
        if (l2 >= 0L) {
            buffer.append('/').append(l2);
        }
        buffer.append("] ");
        if (!TMCHelper.isEmpty(tmcListElement.getDescription())) {
            buffer.append(tmcListElement.getDescription());
            buffer.append(' ');
        }
        if (tmcListElement.getType() == 1) {
            buffer.append(" (NODE");
        } else if (tmcListElement.getType() == 2) {
            buffer.append(" (MSG");
        } else if (tmcListElement.getType() == 0) {
            buffer.append(" (UNDEFINED");
        }
        if (tmcListElement.isHasChild()) {
            buffer.append(" with ").append(tmcListElement.getNumberOfMessagesInNode()).append(" children) ");
        } else {
            buffer.append(") ");
        }
        if (tmcListElement.getMessage() != null) {
            buffer.append("TmcMessage: ").append(TMCHelper.formatTmcMessageForDebugging(tmcListElement.getMessage(), l));
        }
        return buffer.toString();
    }

    public static String formatTmcMessageForDebugging(TmcListElement tmcListElement, long l) {
        if (tmcListElement == null) {
            return "null";
        }
        return TMCHelper.formatTmcMessageForDebugging(tmcListElement.getMessage(), l);
    }

    public static String formatTmcMessageForDebugging(TmcMessage tmcMessage) {
        if (tmcMessage == null) {
            return "null";
        }
        return TMCHelper.formatTmcMessageForDebugging(tmcMessage, -1L);
    }

    public static String formatTmcMessageForDebugging(TmcMessage tmcMessage, long l) {
        String[] stringArray;
        if (tmcMessage == null) {
            return "null";
        }
        Buffer buffer = new Buffer();
        buffer.append('[').append("ID:").append(tmcMessage.getMessageID()).append("][#").append(tmcMessage.getMessageCount());
        if (l >= 0L) {
            buffer.append('/').append(l);
        }
        buffer.append("] ");
        if ("X-URGENT".equals(tmcMessage.getUrgent())) {
            buffer.append("(X-Urgent)");
        }
        if (tmcMessage.getRouteRelevance() == 0) {
            buffer.append("(onR) ");
        } else if (tmcMessage.getRouteRelevance() == 1) {
            buffer.append("(offR) ");
        } else if (tmcMessage.getRouteRelevance() == 2) {
            buffer.append("(byP) ");
        } else if (tmcMessage.getRouteRelevance() == 3) {
            buffer.append("(byPdis) ");
        }
        if (!TMCHelper.isEmpty(tmcMessage.getRoadName())) {
            buffer.append(tmcMessage.getRoadName());
            if (tmcMessage.isUrbanFlag()) {
                buffer.append(" (urban)");
            }
        }
        if (tmcMessage.isIsArea()) {
            buffer.append(", ").append(tmcMessage.getStartLocation());
        } else if (!TMCHelper.isEmpty(tmcMessage.getDirectionOfRoad1())) {
            buffer.append(", ").append(tmcMessage.getDirectionOfRoad1());
            if (!TMCHelper.isEmpty(tmcMessage.getDirectionOfRoad2())) {
                if (tmcMessage.isIsBidirectional()) {
                    buffer.append("<->");
                } else {
                    buffer.append("->");
                }
                buffer.append(tmcMessage.getDirectionOfRoad2());
            }
        } else if (!TMCHelper.isEmpty(tmcMessage.getDirectionOfRoad2())) {
            buffer.append(", d2: ").append(tmcMessage.getDirectionOfRoad2());
        }
        if (!TMCHelper.isEmpty(tmcMessage.getStartLocation()) || !TMCHelper.isEmpty(tmcMessage.getEndLocation())) {
            buffer.append(", ");
            if (!TMCHelper.isEmpty(tmcMessage.getStartLocation())) {
                buffer.append(tmcMessage.getStartLocation());
                if (!TMCHelper.isEmpty(tmcMessage.getEndLocation())) {
                    buffer.append('~').append(tmcMessage.getEndLocation());
                }
            } else if (!TMCHelper.isEmpty(tmcMessage.getEndLocation())) {
                buffer.append("end: ").append(tmcMessage.getEndLocation());
            }
        }
        if ((stringArray = tmcMessage.getEventText()) != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (TMCHelper.isEmpty(stringArray[i2])) continue;
                buffer.append(", \"").append(stringArray[i2]).append('\"');
            }
        }
        if (tmcMessage.getIconListId() != null) {
            buffer.append(" (").append(tmcMessage.getIconListId().length).append(" icons)");
        }
        if (tmcMessage.isHasGeoPos()) {
            buffer.append(" [lat:").append(tmcMessage.getGeoPosLatitude()).append("/long:").append(tmcMessage.getGeoPosLongitude()).append(']');
        }
        return buffer.toString();
    }

    public static TmcListElement createTmcListElement(long l, TmcMessage tmcMessage, int n, String string, boolean bl, long l2, long l3, int n2, int n3) {
        TmcListElement tmcListElement = new TmcListElement();
        tmcListElement.streetSignId = l;
        tmcListElement.message = tmcMessage;
        tmcListElement.type = n;
        tmcListElement.description = string;
        tmcListElement.hasChild = bl;
        tmcListElement.uID = l2;
        tmcListElement.parentID = l3;
        tmcListElement.numberOfMessagesInNode = n2;
        tmcListElement.positionInCompleteList = n3;
        return tmcListElement;
    }
}

