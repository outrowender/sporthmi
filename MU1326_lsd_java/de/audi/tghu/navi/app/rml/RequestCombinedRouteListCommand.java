/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.CombinedRouteListElement;

public class RequestCombinedRouteListCommand
extends NavCommand {
    private int windowSize;
    private int offset;
    private long[] anchorId;
    private long openedListAnchorId;
    private final int repeatRequest;

    public RequestCombinedRouteListCommand(int n, int n2, long[] lArray, long l) {
        this.windowSize = n;
        this.offset = n2;
        this.anchorId = lArray;
        this.openedListAnchorId = l;
        this.repeatRequest = 0;
    }

    public RequestCombinedRouteListCommand(int n, int n2, long[] lArray, long l, int n3) {
        this.windowSize = n;
        this.offset = n2;
        this.anchorId = lArray;
        this.openedListAnchorId = l;
        this.repeatRequest = n3;
    }

    public long getTimeout() {
        if (this.anchorId.equals(RMLSequence.DEFAULT_ANCHOR_ID) && Util.isHURegionAsia()) {
            return -1L;
        }
        return super.getTimeout();
    }

    public void execute() {
        this.logger.log(10000000, "RequestCombinedRouteListCommand#execute() - calling requestCombinedRouteListWindow() anchorID = %1, openedListAnchorId = %2, offset = %3", (Object)this.anchorId, this.openedListAnchorId, (long)this.offset);
        this.getDSICombinedRouteList().requestCombinedRouteListWindow(this.windowSize, this.offset, this.anchorId, this.openedListAnchorId);
    }

    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
        this.logger.log(1000000, "RequestCombinedRouteListCommand#combinedRouteListResult() - usedAnchorId = %1, length=%2", l, combinedRouteListElementArray == null ? 0L : (long)combinedRouteListElementArray.length);
        if (this.logger.isDebug2()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < combinedRouteListElementArray.length; ++i2) {
                stringBuffer.append(i2).append(": ").append(combinedRouteListElementArray[i2]).append("\n");
            }
            this.logger.log(100000000, "RequestCombinedRouteListCommand#combinedRouteListResult() - CombinedRouteLustElement[] = %1", (Object)stringBuffer.toString());
        }
        this.dsiResponseContainer.setCombinedRouteListResult(l, combinedRouteListElementArray, n);
        if (combinedRouteListElementArray.length == 0) {
            if (this.repeatRequest > 0) {
                this.logger.log(1000000, "RequestCombinedRouteListCommand#combinedRouteListResult() - arrayLength is 0 (zero) repeat request (repeats left: %1)", (long)(this.repeatRequest - 1));
                this.getCommandList().commandFinishedWithPostCommand(new RequestCombinedRouteListCommand(this.windowSize, this.offset, this.anchorId, this.openedListAnchorId, this.repeatRequest - 1));
            } else {
                this.logger.log(100000, "RequestCombinedRouteListCommand#combinedRouteListResult() - No valid Routelist has been delivered by DSICombinedRouteList");
                this.getCommandList().commandFinished();
            }
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

