/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.tghu.navi.app.map.impl.PosInfoParser;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.map.PosInfo;

class PosInfoParser$FirstIndexParser {
    private int firstLocationIndex = -1;
    private int firstPOIIndex = -1;
    private int firstPOI3DIndex = -1;
    private int firstStackedPOIIndex = -1;
    private int firstTMCIndex = -1;
    private int firstTOPIndex = -1;
    private int firstAreaIndex = -1;
    private int firstXTRepresentation = -1;
    private int firstPicNavIndex = -1;
    private int firstPOIbyUID = -1;
    private int firstRouteSegment = -1;
    private int firstBuildingListPoi = -1;
    private final /* synthetic */ PosInfoParser this$0;

    public PosInfoParser$FirstIndexParser(PosInfoParser posInfoParser) {
        this.this$0 = posInfoParser;
        this.clean();
    }

    private void clean() {
        this.firstLocationIndex = -1;
        this.firstPOIIndex = -1;
        this.firstPOI3DIndex = -1;
        this.firstStackedPOIIndex = -1;
        this.firstTMCIndex = -1;
        this.firstTOPIndex = -1;
        this.firstAreaIndex = -1;
        this.firstXTRepresentation = -1;
        this.firstPicNavIndex = -1;
        this.firstPOIbyUID = -1;
        this.firstRouteSegment = -1;
        this.firstBuildingListPoi = -1;
    }

    public void lookupFirstIndexes(PosInfo[] posInfoArray) {
        this.clean();
        Buffer buffer = new Buffer();
        if (posInfoArray == null || posInfoArray.length <= 0) {
            return;
        }
        block15: for (int i2 = 0; i2 < posInfoArray.length; ++i2) {
            buffer.append(" [").append(i2).append("] eInfoType = ").append(posInfoArray[i2].getEInfoType());
            switch (posInfoArray[i2].getEInfoType()) {
                case 0: {
                    if (this.firstLocationIndex >= 0) continue block15;
                    this.firstLocationIndex = i2;
                    continue block15;
                }
                case 1: {
                    if (this.firstPOIIndex >= 0) continue block15;
                    this.firstPOIIndex = i2;
                    continue block15;
                }
                case 2: {
                    if (!PosInfoParser.access$1200(this.this$0).is3DLandmarksEnabled() || this.firstPOI3DIndex >= 0) continue block15;
                    this.firstPOI3DIndex = i2;
                    continue block15;
                }
                case 16: {
                    if (this.firstPOI3DIndex >= 0) continue block15;
                    this.firstPOI3DIndex = i2;
                    continue block15;
                }
                case 20: {
                    if (this.firstBuildingListPoi >= 0) continue block15;
                    this.firstBuildingListPoi = i2;
                    continue block15;
                }
                case 3: {
                    if (this.firstStackedPOIIndex >= 0) continue block15;
                    this.firstStackedPOIIndex = i2;
                    continue block15;
                }
                case 4: {
                    if (this.firstTMCIndex >= 0) continue block15;
                    this.firstTMCIndex = i2;
                    continue block15;
                }
                case 5: {
                    if (this.firstTOPIndex >= 0) continue block15;
                    this.firstTOPIndex = i2;
                    continue block15;
                }
                case 7: {
                    if (this.firstAreaIndex >= 0) continue block15;
                    this.firstAreaIndex = i2;
                    continue block15;
                }
                case 8: {
                    if (this.firstXTRepresentation >= 0) continue block15;
                    this.firstXTRepresentation = i2;
                    continue block15;
                }
                case 9: 
                case 10: {
                    if (this.firstPicNavIndex >= 0) continue block15;
                    this.firstPicNavIndex = i2;
                    continue block15;
                }
                case 11: {
                    if (this.firstPOIbyUID >= 0) continue block15;
                    this.firstPOIbyUID = i2;
                    continue block15;
                }
                case 13: {
                    if (this.firstRouteSegment >= 0) continue block15;
                    this.firstRouteSegment = i2;
                    continue block15;
                }
                default: {
                    PosInfoParser.access$1300(this.this$0).log(10000, "PosInfoParser#FirstIndexParser#lookupFirstIndexes() : unknown eInfoType = %1", (long)posInfoArray[i2].getEInfoType());
                }
            }
        }
        PosInfoParser.access$1300(this.this$0).log(14808325, "PosInfoParser#FirstIndexParser#lookupFirstIndexes() :%1", (Object)buffer.toString());
    }

    static /* synthetic */ int access$000(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstStackedPOIIndex;
    }

    static /* synthetic */ int access$100(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstPicNavIndex;
    }

    static /* synthetic */ int access$200(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstTMCIndex;
    }

    static /* synthetic */ int access$300(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstTOPIndex;
    }

    static /* synthetic */ int access$400(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstBuildingListPoi;
    }

    static /* synthetic */ int access$500(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstPOI3DIndex;
    }

    static /* synthetic */ int access$600(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstPOIIndex;
    }

    static /* synthetic */ int access$700(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstLocationIndex;
    }

    static /* synthetic */ int access$800(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstXTRepresentation;
    }

    static /* synthetic */ int access$900(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstAreaIndex;
    }

    static /* synthetic */ int access$1000(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstPOIbyUID;
    }

    static /* synthetic */ int access$1100(PosInfoParser$FirstIndexParser posInfoParser$FirstIndexParser) {
        return posInfoParser$FirstIndexParser.firstRouteSegment;
    }
}

