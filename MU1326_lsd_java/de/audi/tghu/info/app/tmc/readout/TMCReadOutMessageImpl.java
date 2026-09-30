/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.tmc.TmcPhoneme;

public class TMCReadOutMessageImpl
implements TMCReadOutMessage {
    static final int READ_OUT_NEVER = -1;
    static final int READ_OUT_COMPLETELY = 3;
    static final int READ_OUT_ONCE = 1;
    private String roadName;
    private String roadNumber;
    private long messageId;
    private long distanceToAttentionPoint1;
    private long distanceToAttentionPoint2;
    private String[] eventText;
    private long distanceToTarget;
    private String readOutString;
    private long streetSignId;
    private int alreadReadOut = -1;
    private long versionInfo;
    private String directionOfRoad1;
    private String directionOfRoad2;
    private String startLocation;
    private String endLocation;
    private TmcPhoneme phoneme;
    private boolean isBidirectional;
    private boolean isArea;
    private boolean isUrban;

    public TMCReadOutMessageImpl(TmcMessage tmcMessage) {
        this.messageId = tmcMessage.getMessageID();
        this.roadName = tmcMessage.getRoadName();
        this.roadNumber = tmcMessage.getRoadNumber();
        this.distanceToAttentionPoint1 = tmcMessage.getAttentionPoint1();
        this.distanceToAttentionPoint2 = tmcMessage.getAttentionPoint2();
        this.eventText = tmcMessage.getEventText();
        this.distanceToTarget = tmcMessage.getDistanceToEvent();
        this.versionInfo = tmcMessage.getVersionInfo();
        this.streetSignId = tmcMessage.getStreetSignId();
        this.directionOfRoad1 = tmcMessage.getDirectionOfRoad1();
        this.directionOfRoad2 = tmcMessage.getDirectionOfRoad2();
        this.startLocation = tmcMessage.getStartLocation();
        this.endLocation = tmcMessage.getEndLocation();
        this.phoneme = tmcMessage.getPhoneme();
        this.isBidirectional = tmcMessage.isIsBidirectional();
        this.isArea = tmcMessage.isIsArea();
        this.isUrban = tmcMessage.isUrbanFlag();
    }

    public String getRoadName() {
        return this.roadName;
    }

    public String getRoadNumber() {
        return this.roadNumber;
    }

    public long getMessageID() {
        return this.messageId;
    }

    public String getReadOutString() {
        return this.readOutString;
    }

    public void setReadOutString(String string) {
        this.readOutString = string;
    }

    public long getStreetSignId() {
        return this.streetSignId;
    }

    public int getReadOutState() {
        return this.alreadReadOut;
    }

    public void setReadOutState(int n) {
        this.alreadReadOut = n;
    }

    public long getDistanceToAttentionPoint1() {
        return this.distanceToAttentionPoint1;
    }

    public long getDistanceToAttentionPoint2() {
        return this.distanceToAttentionPoint2;
    }

    public String getDirectionOfRoad1() {
        return this.directionOfRoad1;
    }

    public String getDirectionOfRoad2() {
        return this.directionOfRoad2;
    }

    public String getEndLocation() {
        return this.endLocation;
    }

    public String getStartLocation() {
        return this.startLocation;
    }

    public long getDistanceToTarget() {
        return this.distanceToTarget;
    }

    public String[] getEventText() {
        return this.eventText;
    }

    public long getVersionInfo() {
        return this.versionInfo;
    }

    public TmcPhoneme getPhoneme() {
        return this.phoneme;
    }

    public boolean isBidirectional() {
        return this.isBidirectional;
    }

    public boolean isArea() {
        return this.isArea;
    }

    public boolean isUrban() {
        return this.isUrban;
    }

    public int hashCode() {
        return (int)(this.messageId ^ this.messageId >>> 32);
    }

    public boolean equals(Object object) {
        try {
            TMCReadOutMessageImpl tMCReadOutMessageImpl = (TMCReadOutMessageImpl)object;
            return this.messageId == tMCReadOutMessageImpl.getMessageID();
        }
        catch (Exception exception) {
            return false;
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append(this.messageId);
        buffer.append(", ");
        buffer.append(this.getRoadName());
        buffer.append(", ");
        buffer.append(this.getDirectionOfRoad1());
        buffer.append(", ");
        buffer.append(this.getDirectionOfRoad2());
        buffer.append(", ");
        buffer.append("dist.to.target: ");
        buffer.append(this.distanceToTarget);
        buffer.append(", ");
        buffer.append("dist.to.first.att.point: ");
        buffer.append(this.distanceToAttentionPoint1);
        buffer.append(", ");
        buffer.append("dist.to.sec.att.point: ");
        buffer.append(this.distanceToAttentionPoint2);
        buffer.append(", ");
        buffer.append("version.info: ");
        buffer.append(this.versionInfo);
        buffer.append("\n");
        return buffer.toString();
    }
}

