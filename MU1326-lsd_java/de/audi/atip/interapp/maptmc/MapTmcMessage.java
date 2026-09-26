/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.maptmc;

import de.esolutions.fw.util.commons.Buffer;

public class MapTmcMessage {
    private long messageID;
    private boolean onRoute;
    private String directionOfRoad1;
    private String directionOfRoad2;
    private String startLocation;
    private String endLocation;
    private String[] eventText;
    private boolean bidirectional;
    private int geoPosLongitude;
    private int geoPosLatitude;
    private long messageCount;
    private long totalMessages;
    private String roadName;
    private String roadNumber;
    private boolean area;

    public MapTmcMessage(long l, String string, String string2, String string3, String string4, String string5, String string6, String[] stringArray, boolean bl, boolean bl2, int n, int n2, long l2, long l3, boolean bl3) {
        this.messageID = l;
        this.roadName = string;
        this.roadNumber = string2;
        this.directionOfRoad1 = string3;
        this.directionOfRoad2 = string4;
        this.startLocation = string5;
        this.endLocation = string6;
        this.eventText = stringArray;
        this.onRoute = bl;
        this.bidirectional = bl2;
        this.geoPosLongitude = n;
        this.geoPosLatitude = n2;
        this.messageCount = l2;
        this.totalMessages = l3;
        this.area = bl3;
    }

    public String getRoadName() {
        return this.roadName;
    }

    public String getRoadNumber() {
        return this.roadNumber;
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

    public String[] getEventText() {
        return this.eventText;
    }

    public int getGeoPosLatitude() {
        return this.geoPosLatitude;
    }

    public int getGeoPosLongitude() {
        return this.geoPosLongitude;
    }

    public boolean isOnRoute() {
        return this.onRoute;
    }

    public boolean isBidirectional() {
        return this.bidirectional;
    }

    public boolean isArea() {
        return this.area;
    }

    public long getMessageCount() {
        return this.messageCount;
    }

    public long getTotalMessages() {
        return this.totalMessages;
    }

    public long getMessageID() {
        return this.messageID;
    }

    public String getStartLocation() {
        return this.startLocation;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append('[');
        if (this.roadNumber != null && this.roadNumber.length() != 0) {
            buffer.append(this.roadNumber);
        } else if (this.roadName != null && this.roadName.length() != 0) {
            buffer.append(this.roadName);
            buffer.append(' ');
        }
        if (this.messageCount > 0L && this.totalMessages >= this.messageCount) {
            buffer.append(' ');
            buffer.append('(');
            buffer.append(this.messageCount);
            buffer.append('/');
            buffer.append(this.totalMessages);
            buffer.append(')');
        }
        if (this.area) {
            if (buffer.length() != 0) {
                buffer.append(',');
                buffer.append(' ');
            }
            buffer.append(this.startLocation);
        } else if (this.directionOfRoad1 != null && this.directionOfRoad1.length() != 0) {
            if (buffer.length() != 0) {
                buffer.append(',');
                buffer.append(' ');
            }
            buffer.append(this.directionOfRoad1);
            if (this.directionOfRoad2 != null && this.directionOfRoad2.length() != 0) {
                if (this.bidirectional) {
                    buffer.append(" <-> ");
                } else {
                    buffer.append(" -> ");
                }
                buffer.append(this.directionOfRoad2);
            }
        } else if (this.directionOfRoad2 != null && this.directionOfRoad2.length() != 0) {
            if (buffer.length() != 0) {
                buffer.append(',');
                buffer.append(' ');
            }
            buffer.append(this.directionOfRoad2);
        }
        if (this.eventText != null && this.eventText.length > 0 && this.eventText[0] != null && this.eventText[0].length() != 0) {
            if (buffer.length() != 0) {
                buffer.append(',');
                buffer.append(' ');
            }
            buffer.append(this.eventText[0]);
        }
        buffer.append(']');
        return buffer.toString();
    }
}

