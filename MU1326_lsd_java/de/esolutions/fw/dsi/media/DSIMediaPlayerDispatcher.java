/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMediaPlayerReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaPlayerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.DSIMediaPlayerListener;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.PlaybackMode;

public class DSIMediaPlayerDispatcher
extends AbstractDispatcher
implements DSIMediaPlayerReply {
    private DSIMediaPlayerReplyService service = new DSIMediaPlayerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaPlayerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMediaPlayerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$media$DSIMediaPlayerListener == null ? (class$org$dsi$ifc$media$DSIMediaPlayerListener = DSIMediaPlayerDispatcher.class$("org.dsi.ifc.media.DSIMediaPlayerListener")) : class$org$dsi$ifc$media$DSIMediaPlayerListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void updateVideoFormat(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateVideoFormat(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateVideoFormat(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateVideoNorm(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateVideoNorm(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateVideoNorm(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateCmdBlockingMask(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateCmdBlockingMask(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateCmdBlockingMask(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateNumVideoAngles(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateNumVideoAngles(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateNumVideoAngles(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePlaybackModeList(PlaybackMode[] playbackModeArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(5, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updatePlaybackModeList(playbackModeArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updatePlaybackModeList(playbackModeArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePlaybackMode(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(6, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updatePlaybackMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updatePlaybackMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePlaybackState(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updatePlaybackState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updatePlaybackState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateActiveMedia(long l, long l2, int n, int n2, int n3) throws MethodException {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(8, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateActiveMedia(l, l2, n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateActiveMedia(l, l2, n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePlaybackFolder(ListEntry[] listEntryArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(9, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updatePlaybackFolder(listEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updatePlaybackFolder(listEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateCapabilities(Capabilities capabilities, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(10, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateCapabilities(capabilities, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateCapabilities(capabilities, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePlayPosition(long l, int n, int n2, int n3) throws MethodException {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(11, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updatePlayPosition(l, n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updatePlayPosition(l, n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePlayViewSize(int n, int n2, int n3) throws MethodException {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(12, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updatePlayViewSize(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updatePlayViewSize(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateActiveVideoAngle(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(13, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateActiveVideoAngle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateActiveVideoAngle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateAudioStreamList(AudioStream[] audioStreamArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(14, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateAudioStreamList(audioStreamArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateAudioStreamList(audioStreamArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateActiveAudioStream(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(15, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateActiveAudioStream(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateActiveAudioStream(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSubtitleList(int[] nArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(16, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateSubtitleList(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateSubtitleList(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateActiveSubtitle(int n, int n2) throws MethodException {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(17, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updateActiveSubtitle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updateActiveSubtitle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseCmdBlocked(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responseCmdBlocked(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseRating(long l, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responseRating(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseFullyQualifiedName(long l, String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responseFullyQualifiedName(l, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseCoverArt(long l, ResourceLocator resourceLocator) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responseCoverArt(l, resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responsePlayView(ListEntry[] listEntryArray, int n, int n2, int n3) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responsePlayView(listEntryArray, n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseDetailInfo(EntryInfo entryInfo) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responseDetailInfo(entryInfo);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicationDvdEvent(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.indicationDvdEvent(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseSetPlaySelection(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responseSetPlaySelection(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseSetPlaySelectionAB(int n, boolean bl) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responseSetPlaySelectionAB(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseSetPlaybackURL(String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responseSetPlaybackURL(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responseSetVideoRect(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responseSetVideoRect(n, n2, n3, n4, n5, n6, n7, n8);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void responsePlaySimilarEntry(long l, boolean bl) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.responsePlaySimilarEntry(l, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void tempPMLRequest(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.tempPMLRequest(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updatePlaybackContentFolder(ListEntry[] listEntryArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    this.confirmNotificationListener(18, dSIMediaPlayerListener);
                    dSIMediaPlayerListener.updatePlaybackContentFolder(listEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)iterator.next();
                    dSIMediaPlayerListener.updatePlaybackContentFolder(listEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void asyncException(int n, String string, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    dSIMediaPlayerListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void yyIndication(String string, String string2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaPlayerListener dSIMediaPlayerListener = (DSIMediaPlayerListener)objectArray[i2];
                    Method method = dSIMediaPlayerListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMediaPlayerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMediaPlayerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMediaPlayerListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

