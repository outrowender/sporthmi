/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaS;
import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaI18NString;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncMediaAbstractBaseService
implements ASIHMISyncMediaS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.media.ASIHMISyncMedia");
    private static final int attributesCount = 16;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private MediaSourceSlot[] SourceList;
    private boolean SourceList_valid = false;
    private MediaActiveSourceState ActiveSlotState;
    private boolean ActiveSlotState_valid = false;
    private int PlaybackState;
    private boolean PlaybackState_valid = false;
    private MediaPlaylistState ListState;
    private boolean ListState_valid = false;
    private int PlayerCapabilities;
    private boolean PlayerCapabilities_valid = false;
    private boolean Mix;
    private boolean Mix_valid = false;
    private boolean RepeatTitle;
    private boolean RepeatTitle_valid = false;
    private int RepeatState;
    private boolean RepeatState_valid = false;
    private int ShuffleState;
    private boolean ShuffleState_valid = false;
    private MediaEntry PlayingTrack;
    private boolean PlayingTrack_valid = false;
    private MediaPlayTime PlayPosition;
    private boolean PlayPosition_valid = false;
    private MediaEntry[] PlaybackFolder;
    private boolean PlaybackFolder_valid = false;
    private int PlaybackPossible;
    private boolean PlaybackPossible_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static MediaSourceSlot copyMediaSourceSlot(MediaSourceSlot mediaSourceSlot) {
        if (mediaSourceSlot == null) {
            return null;
        }
        MediaSourceSlot mediaSourceSlot2 = new MediaSourceSlot();
        mediaSourceSlot2.source = mediaSourceSlot.source;
        mediaSourceSlot2.slotIdx = mediaSourceSlot.slotIdx;
        mediaSourceSlot2.mediaType = mediaSourceSlot.mediaType;
        mediaSourceSlot2.deviceIdx = mediaSourceSlot.deviceIdx;
        mediaSourceSlot2.state = mediaSourceSlot.state;
        mediaSourceSlot2.flags = mediaSourceSlot.flags;
        mediaSourceSlot2.name = ASIHMISyncMediaAbstractBaseService.copyString(mediaSourceSlot.name);
        return mediaSourceSlot2;
    }

    public static MediaActiveSourceState copyMediaActiveSourceState(MediaActiveSourceState mediaActiveSourceState) {
        if (mediaActiveSourceState == null) {
            return null;
        }
        MediaActiveSourceState mediaActiveSourceState2 = new MediaActiveSourceState();
        mediaActiveSourceState2.slot = ASIHMISyncMediaAbstractBaseService.copyMediaSourceSlot(mediaActiveSourceState.slot);
        mediaActiveSourceState2.state = mediaActiveSourceState.state;
        return mediaActiveSourceState2;
    }

    public static MediaPlaylistState copyMediaPlaylistState(MediaPlaylistState mediaPlaylistState) {
        if (mediaPlaylistState == null) {
            return null;
        }
        MediaPlaylistState mediaPlaylistState2 = new MediaPlaylistState();
        mediaPlaylistState2.flags = mediaPlaylistState.flags;
        mediaPlaylistState2.id = mediaPlaylistState.id;
        mediaPlaylistState2.size = mediaPlaylistState.size;
        return mediaPlaylistState2;
    }

    public static MediaEntry copyMediaEntry(MediaEntry mediaEntry) {
        if (mediaEntry == null) {
            return null;
        }
        MediaEntry mediaEntry2 = new MediaEntry();
        mediaEntry2.id = mediaEntry.id;
        mediaEntry2.type = mediaEntry.type;
        mediaEntry2.title = ASIHMISyncMediaAbstractBaseService.copyMediaI18NString(mediaEntry.title);
        mediaEntry2.artist = ASIHMISyncMediaAbstractBaseService.copyMediaI18NString(mediaEntry.artist);
        mediaEntry2.artistID = mediaEntry.artistID;
        mediaEntry2.album = ASIHMISyncMediaAbstractBaseService.copyMediaI18NString(mediaEntry.album);
        mediaEntry2.albumID = mediaEntry.albumID;
        mediaEntry2.genreID = mediaEntry.genreID;
        mediaEntry2.coverUrl = ASIHMISyncMediaAbstractBaseService.copyString(mediaEntry.coverUrl);
        return mediaEntry2;
    }

    public static MediaI18NString copyMediaI18NString(MediaI18NString mediaI18NString) {
        if (mediaI18NString == null) {
            return null;
        }
        MediaI18NString mediaI18NString2 = new MediaI18NString();
        mediaI18NString2.i18nKey = mediaI18NString.i18nKey;
        mediaI18NString2.name = ASIHMISyncMediaAbstractBaseService.copyString(mediaI18NString.name);
        return mediaI18NString2;
    }

    public static MediaPlayTime copyMediaPlayTime(MediaPlayTime mediaPlayTime) {
        if (mediaPlayTime == null) {
            return null;
        }
        MediaPlayTime mediaPlayTime2 = new MediaPlayTime();
        mediaPlayTime2.id = mediaPlayTime.id;
        mediaPlayTime2.time = mediaPlayTime.time;
        mediaPlayTime2.totalTime = mediaPlayTime.totalTime;
        return mediaPlayTime2;
    }

    public ASIHMISyncMediaAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncMedia", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncMediaReply);
        this.sendAttributeUpdate(l, aSIHMISyncMediaReply);
    }

    public synchronized void setNotification(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.setNotification(aSIHMISyncMediaReply);
        this.sendAttributeUpdate(aSIHMISyncMediaReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncMediaReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncMediaReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncMediaReply);
    }

    public synchronized void clearNotification(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.clearNotification(aSIHMISyncMediaReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncMediaReply);
    }

    private void sendAttributeUpdate(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            aSIHMISyncMediaReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncMediaReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncMediaReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncMediaReply.updateSourceList(this.SourceList, this.SourceList_valid);
            aSIHMISyncMediaReply.updateActiveSlotState(this.ActiveSlotState, this.ActiveSlotState_valid);
            aSIHMISyncMediaReply.updatePlaybackState(this.PlaybackState, this.PlaybackState_valid);
            aSIHMISyncMediaReply.updateListState(this.ListState, this.ListState_valid);
            aSIHMISyncMediaReply.updatePlayerCapabilities(this.PlayerCapabilities, this.PlayerCapabilities_valid);
            aSIHMISyncMediaReply.updateMix(this.Mix, this.Mix_valid);
            aSIHMISyncMediaReply.updateRepeatTitle(this.RepeatTitle, this.RepeatTitle_valid);
            aSIHMISyncMediaReply.updateRepeatState(this.RepeatState, this.RepeatState_valid);
            aSIHMISyncMediaReply.updateShuffleState(this.ShuffleState, this.ShuffleState_valid);
            aSIHMISyncMediaReply.updatePlayingTrack(this.PlayingTrack, this.PlayingTrack_valid);
            aSIHMISyncMediaReply.updatePlayPosition(this.PlayPosition, this.PlayPosition_valid);
            aSIHMISyncMediaReply.updatePlaybackFolder(this.PlaybackFolder, this.PlaybackFolder_valid);
            aSIHMISyncMediaReply.updatePlaybackPossible(this.PlaybackPossible, this.PlaybackPossible_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncMediaReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            if (l == 21L) {
                aSIHMISyncMediaReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 32L) {
                aSIHMISyncMediaReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 31L) {
                aSIHMISyncMediaReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 30L) {
                aSIHMISyncMediaReply.updateSourceList(this.SourceList, this.SourceList_valid);
            } else if (l == 22L) {
                aSIHMISyncMediaReply.updateActiveSlotState(this.ActiveSlotState, this.ActiveSlotState_valid);
            } else if (l == 27L) {
                aSIHMISyncMediaReply.updatePlaybackState(this.PlaybackState, this.PlaybackState_valid);
            } else if (l == 23L) {
                aSIHMISyncMediaReply.updateListState(this.ListState, this.ListState_valid);
            } else if (l == 38L) {
                aSIHMISyncMediaReply.updatePlayerCapabilities(this.PlayerCapabilities, this.PlayerCapabilities_valid);
            } else if (l == 24L) {
                aSIHMISyncMediaReply.updateMix(this.Mix, this.Mix_valid);
            } else if (l == 29L) {
                aSIHMISyncMediaReply.updateRepeatTitle(this.RepeatTitle, this.RepeatTitle_valid);
            } else if (l == 41L) {
                aSIHMISyncMediaReply.updateRepeatState(this.RepeatState, this.RepeatState_valid);
            } else if (l == 42L) {
                aSIHMISyncMediaReply.updateShuffleState(this.ShuffleState, this.ShuffleState_valid);
            } else if (l == 28L) {
                aSIHMISyncMediaReply.updatePlayingTrack(this.PlayingTrack, this.PlayingTrack_valid);
            } else if (l == 25L) {
                aSIHMISyncMediaReply.updatePlayPosition(this.PlayPosition, this.PlayPosition_valid);
            } else if (l == 26L) {
                aSIHMISyncMediaReply.updatePlaybackFolder(this.PlaybackFolder, this.PlaybackFolder_valid);
            } else if (l == 37L) {
                aSIHMISyncMediaReply.updatePlaybackPossible(this.PlaybackPossible, this.PlaybackPossible_valid);
            } else {
                System.out.println("unexpected");
            }
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    public void updateASIVersion(String string) throws MethodException {
        this.updateASIVersion(string, true);
    }

    public void updateASIVersion(String string, boolean bl) throws MethodException {
        this.ASIVersion = ASIHMISyncMediaAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRequestIDs(short[] sArray) throws MethodException {
        this.updateRequestIDs(sArray, true);
    }

    public void updateRequestIDs(short[] sArray, boolean bl) throws MethodException {
        if (sArray != null) {
            this.RequestIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.RequestIDs, 0, sArray.length);
        } else {
            this.RequestIDs = null;
        }
        this.RequestIDs_valid = bl;
        List list = this.baseService.getNotifications(32);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateRequestIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateReplyIDs(short[] sArray) throws MethodException {
        this.updateReplyIDs(sArray, true);
    }

    public void updateReplyIDs(short[] sArray, boolean bl) throws MethodException {
        if (sArray != null) {
            this.ReplyIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.ReplyIDs, 0, sArray.length);
        } else {
            this.ReplyIDs = null;
        }
        this.ReplyIDs_valid = bl;
        List list = this.baseService.getNotifications(31);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSourceList(MediaSourceSlot[] mediaSourceSlotArray) throws MethodException {
        this.updateSourceList(mediaSourceSlotArray, true);
    }

    public void updateSourceList(MediaSourceSlot[] mediaSourceSlotArray, boolean bl) throws MethodException {
        if (mediaSourceSlotArray != null) {
            this.SourceList = new MediaSourceSlot[mediaSourceSlotArray.length];
            for (int i2 = 0; i2 < mediaSourceSlotArray.length; ++i2) {
                this.SourceList[i2] = ASIHMISyncMediaAbstractBaseService.copyMediaSourceSlot(mediaSourceSlotArray[i2]);
            }
        } else {
            this.SourceList = null;
        }
        this.SourceList_valid = bl;
        List list = this.baseService.getNotifications(30);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateSourceList(mediaSourceSlotArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateActiveSlotState(MediaActiveSourceState mediaActiveSourceState) throws MethodException {
        this.updateActiveSlotState(mediaActiveSourceState, true);
    }

    public void updateActiveSlotState(MediaActiveSourceState mediaActiveSourceState, boolean bl) throws MethodException {
        this.ActiveSlotState = ASIHMISyncMediaAbstractBaseService.copyMediaActiveSourceState(mediaActiveSourceState);
        this.ActiveSlotState_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateActiveSlotState(mediaActiveSourceState, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlaybackState(int n) throws MethodException {
        this.updatePlaybackState(n, true);
    }

    public void updatePlaybackState(int n, boolean bl) throws MethodException {
        this.PlaybackState = n;
        this.PlaybackState_valid = bl;
        List list = this.baseService.getNotifications(27);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlaybackState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateListState(MediaPlaylistState mediaPlaylistState) throws MethodException {
        this.updateListState(mediaPlaylistState, true);
    }

    public void updateListState(MediaPlaylistState mediaPlaylistState, boolean bl) throws MethodException {
        this.ListState = ASIHMISyncMediaAbstractBaseService.copyMediaPlaylistState(mediaPlaylistState);
        this.ListState_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateListState(mediaPlaylistState, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlayerCapabilities(int n) throws MethodException {
        this.updatePlayerCapabilities(n, true);
    }

    public void updatePlayerCapabilities(int n, boolean bl) throws MethodException {
        this.PlayerCapabilities = n;
        this.PlayerCapabilities_valid = bl;
        List list = this.baseService.getNotifications(38);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlayerCapabilities(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateMix(boolean bl) throws MethodException {
        this.updateMix(bl, true);
    }

    public void updateMix(boolean bl, boolean bl2) throws MethodException {
        this.Mix = bl;
        this.Mix_valid = bl2;
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateMix(bl, bl2);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRepeatTitle(boolean bl) throws MethodException {
        this.updateRepeatTitle(bl, true);
    }

    public void updateRepeatTitle(boolean bl, boolean bl2) throws MethodException {
        this.RepeatTitle = bl;
        this.RepeatTitle_valid = bl2;
        List list = this.baseService.getNotifications(29);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateRepeatTitle(bl, bl2);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRepeatState(int n) throws MethodException {
        this.updateRepeatState(n, true);
    }

    public void updateRepeatState(int n, boolean bl) throws MethodException {
        this.RepeatState = n;
        this.RepeatState_valid = bl;
        List list = this.baseService.getNotifications(41);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateRepeatState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateShuffleState(int n) throws MethodException {
        this.updateShuffleState(n, true);
    }

    public void updateShuffleState(int n, boolean bl) throws MethodException {
        this.ShuffleState = n;
        this.ShuffleState_valid = bl;
        List list = this.baseService.getNotifications(42);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateShuffleState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlayingTrack(MediaEntry mediaEntry) throws MethodException {
        this.updatePlayingTrack(mediaEntry, true);
    }

    public void updatePlayingTrack(MediaEntry mediaEntry, boolean bl) throws MethodException {
        this.PlayingTrack = ASIHMISyncMediaAbstractBaseService.copyMediaEntry(mediaEntry);
        this.PlayingTrack_valid = bl;
        List list = this.baseService.getNotifications(28);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlayingTrack(mediaEntry, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlayPosition(MediaPlayTime mediaPlayTime) throws MethodException {
        this.updatePlayPosition(mediaPlayTime, true);
    }

    public void updatePlayPosition(MediaPlayTime mediaPlayTime, boolean bl) throws MethodException {
        this.PlayPosition = ASIHMISyncMediaAbstractBaseService.copyMediaPlayTime(mediaPlayTime);
        this.PlayPosition_valid = bl;
        List list = this.baseService.getNotifications(25);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlayPosition(mediaPlayTime, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlaybackFolder(MediaEntry[] mediaEntryArray) throws MethodException {
        this.updatePlaybackFolder(mediaEntryArray, true);
    }

    public void updatePlaybackFolder(MediaEntry[] mediaEntryArray, boolean bl) throws MethodException {
        if (mediaEntryArray != null) {
            this.PlaybackFolder = new MediaEntry[mediaEntryArray.length];
            for (int i2 = 0; i2 < mediaEntryArray.length; ++i2) {
                this.PlaybackFolder[i2] = ASIHMISyncMediaAbstractBaseService.copyMediaEntry(mediaEntryArray[i2]);
            }
        } else {
            this.PlaybackFolder = null;
        }
        this.PlaybackFolder_valid = bl;
        List list = this.baseService.getNotifications(26);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlaybackFolder(mediaEntryArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlaybackPossible(int n) throws MethodException {
        this.updatePlaybackPossible(n, true);
    }

    public void updatePlaybackPossible(int n, boolean bl) throws MethodException {
        this.PlaybackPossible = n;
        this.PlaybackPossible_valid = bl;
        List list = this.baseService.getNotifications(37);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlaybackPossible(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(21L), new Integer(0));
            this.map.put(new Long(32L), new Integer(1));
            this.map.put(new Long(31L), new Integer(2));
            this.map.put(new Long(30L), new Integer(3));
            this.map.put(new Long(22L), new Integer(4));
            this.map.put(new Long(27L), new Integer(5));
            this.map.put(new Long(23L), new Integer(6));
            this.map.put(new Long(38L), new Integer(7));
            this.map.put(new Long(24L), new Integer(8));
            this.map.put(new Long(29L), new Integer(9));
            this.map.put(new Long(41L), new Integer(10));
            this.map.put(new Long(42L), new Integer(11));
            this.map.put(new Long(28L), new Integer(12));
            this.map.put(new Long(25L), new Integer(13));
            this.map.put(new Long(26L), new Integer(14));
            this.map.put(new Long(37L), new Integer(15));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 16;
        }
    }
}

