/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayUtils;
import de.audi.app.bap.fw.arrays.ArrayUtils$IndexRange;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;

public class MediaBrowserListHandler
extends AbstractArrayHandler {
    private volatile int currentListSize;
    private volatile boolean isPlaybackFolder;
    private static final int REQUEST_TYPE_BY_INDEX;
    private static final int REQUEST_TYPE_BY_ID;
    private volatile int requestType;
    private volatile boolean listSizeUpdateDeferred = false;

    public MediaBrowserListHandler(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio, "MediaBrowserListHandler");
    }

    public void setPlaybackFolder(boolean bl) {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(-2137614336, "[%1#setPlaybackFolder]isPlaybackFolder='%2'", (Object)this.className, (Object)bl);
        }
        if (this.isPlaybackFolder != bl) {
            this.isPlaybackFolder = bl;
            if (!this.isRequestPending()) {
                boolean bl2 = ((CombiModuleAudio)this.moduleFsg).getAudioApplicationFocusHandler().isMediaInFocus();
                int n = this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType();
                if (this.logChannel.isDebug()) {
                    this.logChannel.log(-2137614336, "[%1#setPlaybackFolder] No pending request active! isMediaActive='%2', currentSyncType='%3'", (Object)this.className, (Object)bl2, (Object)new Integer(n));
                }
                if (bl2) {
                    this.sendEmptyList();
                } else {
                    this.logChannel.log(-1601830656, "[%1#setPlaybackFolder] media is not active -> don't send status array", (Object)this.className);
                }
            } else {
                this.logChannel.log(-2137614336, "[%1#setPlaybackFolder] pending request active -> status will be updated with response", (Object)this.className);
            }
        } else {
            this.logChannel.log(-2137614336, "[%2#setPlaybackFolder] playbackFolder status didn't change (isPlaybackFolder=%1)", bl, (Object)this.className);
        }
    }

    @Override
    public void requestListElements(GetArrayIndication getArrayIndication) {
        this.logChannel.log(-2137614336, "[%1#requestListElements] called (asgID=%2, taID=%3)", (Object)this.className, (long)getArrayIndication.getAsgID(), (long)getArrayIndication.getTaID());
        this.setPendingRequest(getArrayIndication);
        CombiBAPServiceMediaListener combiBAPServiceMediaListener = ((CombiModuleAudio)this.moduleFsg).getMediaServiceListener();
        if (combiBAPServiceMediaListener != null) {
            IArrayHeader iArrayHeader = getArrayIndication.getArrayHeader();
            int n = iArrayHeader.getStart();
            int n2 = iArrayHeader.getStartOffset();
            int n3 = iArrayHeader.getNumberOfElements();
            boolean bl = iArrayHeader.isModeShift();
            boolean bl2 = iArrayHeader.isModeArrayDirectionBackward();
            if (n == 0) {
                ArrayUtils$IndexRange arrayUtils$IndexRange = ArrayUtils.computeRange(this.logChannel, this.currentListSize, n, n2, n3, bl, bl2);
                if (arrayUtils$IndexRange != null) {
                    int n4 = arrayUtils$IndexRange.startIndex;
                    this.requestType = 0;
                    this.logChannel.log(-2137614336, "[%1#requestListElements] call 'mediaService#requestMediaBrowserListByIndex' with startIndex=%2, numberOfElements=%3", (Object)this.className, (long)n4, (long)n3);
                    combiBAPServiceMediaListener.requestMediaBrowserListByIndex(getArrayIndication.getTaID(), n4, n3);
                } else {
                    this.logChannel.log(-1601830656, "[%1#requestListElements] getArrayRequest not applicable on current list (currentListSize=%2, start=%3, numberOfElements=%4)", (Object)this.className, (Object)new Integer(this.currentListSize), (Object)new Integer(iArrayHeader.getStart()), (long)n3);
                    this.sendEmptyList();
                }
            } else {
                if (n2 != 0) {
                    this.logChannel.log(-1601830656, "[%1#requestListElements] startOffset (relativeJump) only supported for startPosID=0, was set to %2", (Object)this.className, (long)n2);
                }
                this.logChannel.log(-2137614336, "[%1#requestListElements] call 'mediaService#requestMediaBrowserListByID' with startPosID=%2, numberOfElements=%3", (Object)this.className, (long)n, (long)n3);
                this.requestType = 1;
                combiBAPServiceMediaListener.requestMediaBrowserListByID(getArrayIndication.getTaID(), n, n3);
            }
        } else {
            this.logChannel.log(10000, "[%1#requestListElements] unable to forward request because Media service is not available", (Object)this.className);
            this.sendEmptyList();
        }
    }

    @Override
    public void responseListElements(int n, CombiBAPArrayElement[] combiBAPArrayElementArray) {
        if (this.checkTAID(n)) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < combiBAPArrayElementArray.length; ++i2) {
                buffer.append('\n');
                buffer.append(combiBAPArrayElementArray[i2]);
            }
            this.logChannel.log(-2137614336, "[%1#responseListElements] received array: %2", (Object)this.className, (Object)buffer);
            if (this.isRequestPending()) {
                if (this.requestType == 1 && combiBAPArrayElementArray.length != 0) {
                    CombiBAPArrayElement[] combiBAPArrayElementArray2 = MediaBrowserListHandler.retrieveMatchingDataPart(combiBAPArrayElementArray, this.getPendingRequest().getArrayHeader());
                    if (combiBAPArrayElementArray2 == null) {
                        this.logChannel.log(10000, "[%1#responseListElements] response doesn't match request (element with startPosID=%3 not found), data:%2", (Object)this.className, (Object)buffer, (long)this.getPendingRequest().getArrayHeader().getStart());
                        this.sendEmptyList();
                    } else {
                        this.sendStatusRequest(combiBAPArrayElementArray2);
                    }
                } else {
                    this.sendStatusRequest(combiBAPArrayElementArray);
                }
            } else {
                this.logChannel.log(-2137614336, "[%1#responseListElements] pending request is null -> ignore update", (Object)this.className);
            }
        } else {
            this.logChannel.log(10000, "[%1#responseListElements] taID check failed -> ignore update!", (Object)this.className);
        }
    }

    private static CombiBAPArrayElement[] retrieveMatchingDataPart(CombiBAPArrayElement[] combiBAPArrayElementArray, IArrayHeader iArrayHeader) {
        CombiBAPArrayElement[] combiBAPArrayElementArray2;
        int n = ArrayUtils.getIndexInList(combiBAPArrayElementArray, iArrayHeader.getStart());
        if (n == -1) {
            combiBAPArrayElementArray2 = null;
        } else {
            int n2;
            int n3;
            if (iArrayHeader.isModeArrayDirectionBackward()) {
                int n4 = n - (iArrayHeader.isModeShift() ? 1 : 0);
                n3 = Math.max(0, n4 + 1 - iArrayHeader.getNumberOfElements());
                n2 = Math.min(iArrayHeader.getNumberOfElements(), n4 + 1);
            } else {
                n3 = n + (iArrayHeader.isModeShift() ? 1 : 0);
                n2 = Math.min(iArrayHeader.getNumberOfElements(), combiBAPArrayElementArray.length - n3);
            }
            combiBAPArrayElementArray2 = new CombiBAPArrayElement[n2];
            System.arraycopy((Object)combiBAPArrayElementArray, n3, (Object)combiBAPArrayElementArray2, 0, n2);
        }
        return combiBAPArrayElementArray2;
    }

    @Override
    public CombiBAPArrayElement getArrayElement(int n) {
        return null;
    }

    @Override
    public int getCurrentListSize() {
        return this.currentListSize;
    }

    @Override
    public void getNextListPos(int n, int n2) {
        ((CombiModuleAudio)this.moduleFsg).getMediaServiceListener().getNextListPos(n, n2);
    }

    @Override
    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        this.logChannel.log(-1601830656, "[%1#getNextListPosResult] invalid call", (Object)this.className);
    }

    @Override
    public boolean dataMustBeReversed() {
        return true;
    }

    public void notifyListSizeChanged(int n) {
        if (this.currentListSize == 0 && n == 0) {
            this.logChannel.log(-2137614336, "[%1#notifyListSizeChanged] list is still empty -> don't send ChangedArray", (Object)this.className);
        } else {
            this.currentListSize = n;
            if (this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType() == 3 || this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType() == 4) {
                this.moduleFsg.getLogChannel().log(-2137614336, "[ListManagerAudio#updateBrowserListSize] source change in progress, request deferred");
            } else if (this.moduleFsg.getFunctionSynchronizationHandler().getCurrentSyncType() == 6) {
                this.moduleFsg.getLogChannel().log(-2137614336, "[ListManagerAudio#updateBrowserListSize] track change in progress, request deferred");
                this.listSizeUpdateDeferred = true;
            } else {
                this.sendFullRangeUpdate();
            }
        }
    }

    @Override
    public int getPredecessorID(int n) {
        return 0;
    }

    @Override
    public int getSuccessorID(int n) {
        return 0;
    }

    public void clearMediaBrowserList(boolean bl) {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(-2137614336, "[%1#clearMediaBrowserList] sendUpdate='%2'", (Object)this.className, (Object)bl);
        }
        this.currentListSize = 0;
        this.isPlaybackFolder = false;
        if (bl) {
            this.sendEmptyList();
        }
    }

    public boolean isPlaybackFolder() {
        return this.isPlaybackFolder;
    }

    public boolean isListSizeUpdateDeferred() {
        return this.listSizeUpdateDeferred;
    }

    public void resetListSizeUpdateDeferred() {
        this.listSizeUpdateDeferred = false;
    }

    public boolean isSpontaneousStatusRequestSupported() {
        return false;
    }
}

