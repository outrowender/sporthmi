/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.storage.TaggingListStorage;
import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.itunes.ITaggingManagerListener;
import de.audi.tuner.itunes.ITunesTaggingDSI;
import de.audi.tuner.itunes.TaggingData;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.LinkedList;
import org.dsi.ifc.media.TagInformation;

public class TaggingManager
implements TimerListener,
ITaggingManager {
    public static final int NO_DEVICE_SPACE_FREE;
    public static final int NO_DEVICE_NO_SPACE;
    public static final int DEVICE_FULL_SPACE_FREE;
    public static final int DEVICE_FULL_NO_SPACE;
    public static final int DEVICE_SPACE_FREE;
    public static final int TAGGING_MAX_ENTRIES;
    private LinkedList data;
    private ITunesTaggingDSI taggingDSI;
    private final TaggingListStorage storage;
    private final Timer tagStorageTimer = new Timer("tagStorageTimer", 0, true, this);
    private final Object mutex = new Object();
    private final TunerModels models;
    private final LogChannel log;
    private TaggingData lastToiPod;
    private int nextId = 1000;
    private ITaggingManagerListener[] listeners = new ITaggingManagerListener[0];

    public TaggingManager(TunerBasics tunerBasics) {
        this.models = tunerBasics.getModels();
        this.log = tunerBasics.getLogger().tagging;
        this.data = new LinkedList();
        this.storage = new TaggingListStorage(tunerBasics.getFramework().getStorageMgr(), tunerBasics.getLogger().main);
        this.data = this.storage.read();
        this.setLabels(this.data.size());
        this.models.getChoiceModel(92864768).setValue(50);
        this.models.getLabelModel(126419200).setText(String.valueOf(50));
    }

    public void init(ITunesTaggingDSI iTunesTaggingDSI) {
        this.taggingDSI = iTunesTaggingDSI;
    }

    @Override
    public void register(ITaggingManagerListener iTaggingManagerListener) {
        ITaggingManagerListener[] iTaggingManagerListenerArray = new ITaggingManagerListener[this.listeners.length + 1];
        System.arraycopy((Object)this.listeners, 0, (Object)iTaggingManagerListenerArray, 0, this.listeners.length);
        iTaggingManagerListenerArray[this.listeners.length] = iTaggingManagerListener;
        this.listeners = iTaggingManagerListenerArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int addTag(TaggingData taggingData) {
        if (this.log.isDebug()) {
            Buffer buffer = new Buffer(100);
            TagInformation tagInformation = taggingData.getTag1();
            buffer.append("Tag1: ");
            buffer.append("Artist: ").append(tagInformation.artist).append(' ');
            buffer.append("Title: ").append(tagInformation.title).append(' ');
            buffer.append("SongID: ").append(tagInformation.songID).append(' ');
            buffer.append("Button: ").append(tagInformation.buttonPressed);
            tagInformation = taggingData.getTag2();
            if (tagInformation != null) {
                Buffer buffer2 = new Buffer(100);
                buffer2.append("Tag2: ");
                buffer2.append("Artist: ").append(tagInformation.artist).append(' ');
                buffer2.append("Title: ").append(tagInformation.title).append(' ');
                buffer2.append("SongID: ").append(tagInformation.songID).append(' ');
                buffer2.append("Button: ").append(tagInformation.buttonPressed);
                this.log.log(-2137614336, "[TaggingManager.addTag] %1", (Object)buffer2);
            }
            this.log.log(-2137614336, "[TaggingManager.addTag] %1", (Object)buffer);
        }
        int n = this.getExpectedTagResult();
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].updateTagResult(n);
        }
        if (n == 2 || n == 3) {
            return n;
        }
        Object object = this.mutex;
        synchronized (object) {
            taggingData.setId(this.nextId++);
            this.data.add(taggingData);
        }
        this.setLabels(this.data.size());
        this.tagStorageTimer.restart();
        this.taggingDSI.tryToSendData();
        return n;
    }

    private void setLabels(int n) {
        this.models.getChoiceModel(59310336).setValue(n);
        this.models.getLabelModel(109641984).setText(String.valueOf(n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isAlreadyStored(TagInformation tagInformation) {
        Iterator iterator = this.data.iterator();
        Object object = this.mutex;
        synchronized (object) {
            if (this.lastToiPod != null && this.equals(tagInformation, this.lastToiPod.getTagAtButton())) {
                return true;
            }
            while (iterator.hasNext()) {
                TaggingData taggingData = (TaggingData)iterator.next();
                if (!this.equals(tagInformation, taggingData.getTagAtButton())) continue;
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isAlreadyStored(int n) {
        Iterator iterator = this.data.iterator();
        Object object = this.mutex;
        synchronized (object) {
            if (this.lastToiPod != null && this.compare(n, this.lastToiPod)) {
                return true;
            }
            while (iterator.hasNext()) {
                TaggingData taggingData = (TaggingData)iterator.next();
                if (!this.compare(n, taggingData)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean equals(TagInformation tagInformation, TagInformation tagInformation2) {
        boolean bl;
        if (tagInformation == null || tagInformation2 == null) {
            return false;
        }
        boolean bl2 = bl = !tagInformation.artist.equals(tagInformation2.artist) || !tagInformation.title.equals(tagInformation2.title) || !tagInformation.stationFrequency.equals(tagInformation2.stationFrequency) || tagInformation.programNumber != tagInformation2.programNumber;
        if (bl) {
            return false;
        }
        if (!Utilities.isEmpty(tagInformation.album)) {
            boolean bl3 = bl = !tagInformation.album.equals(tagInformation2.album);
            if (bl) {
                return false;
            }
        }
        if (!Utilities.isEmpty(tagInformation.songID)) {
            boolean bl4 = bl = !tagInformation.songID.equals(tagInformation2.songID);
            if (bl) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(int n, TaggingData taggingData) {
        TagInformation tagInformation = taggingData.getTagAtButton();
        return tagInformation != null && tagInformation.songID.equals(String.valueOf(n));
    }

    public TaggingData[] getData() {
        if (this.data != null && !this.data.isEmpty()) {
            return (TaggingData[])this.data.toArray(new TaggingData[this.data.size()]);
        }
        return new TaggingData[0];
    }

    public void removeData(TaggingData[] taggingDataArray) {
        for (int i2 = 0; i2 < taggingDataArray.length; ++i2) {
            Iterator iterator = this.data.iterator();
            while (iterator.hasNext()) {
                TaggingData taggingData = (TaggingData)iterator.next();
                if (taggingData.getId() != taggingDataArray[i2].getId()) continue;
                this.lastToiPod = taggingData;
                iterator.remove();
            }
        }
        this.setLabels(this.data.size());
        this.storage.write(this.data);
        this.contentChanged();
    }

    public Object dump() {
        Buffer buffer = new Buffer(1000);
        buffer.append("iTunes Tagging Buffer contains ");
        buffer.append(String.valueOf(this.data.size()));
        buffer.append(" entries\n");
        for (int i2 = 0; i2 < this.data.size(); ++i2) {
            buffer.append(String.valueOf(i2));
            buffer.append('\n');
            TaggingData taggingData = (TaggingData)this.data.get(i2);
            buffer.append(taggingData);
            buffer.append('\n');
        }
        return buffer;
    }

    @Override
    public boolean isTaggingSpaceFree() {
        return this.data.size() < 50;
    }

    public boolean containsTaggedItems() {
        return !this.data.isEmpty();
    }

    public void reset() {
        this.data.clear();
        this.lastToiPod = null;
        this.setLabels(this.data.size());
        this.tagStorageTimer.restart();
        this.contentChanged();
    }

    private void contentChanged() {
        ITaggingManagerListener[] iTaggingManagerListenerArray = this.listeners;
        for (int i2 = 0; i2 < iTaggingManagerListenerArray.length; ++i2) {
            iTaggingManagerListenerArray[i2].taggedContentChanged();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = this.mutex;
        synchronized (object) {
            this.storage.write(this.data);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public int getExpectedTagResult() {
        int n = this.taggingDSI.getDeviceStatus();
        int n2 = this.taggingDSI.getLastTagResult();
        if (n == 1) {
            if (n2 == 2) {
                if (this.isTaggingSpaceFree()) {
                    this.setLabels(this.data.size() + 1);
                    return 5;
                }
                return 3;
            }
            if (n2 == 0) {
                if (this.isTaggingSpaceFree()) {
                    this.setLabels(this.data.size() + 1);
                    return 4;
                }
                return 2;
            }
            if (this.isTaggingSpaceFree()) {
                this.setLabels(this.data.size() + 1);
                return 1;
            }
            return 2;
        }
        this.setLabels(this.data.size() + 1);
        if (this.isTaggingSpaceFree()) {
            return 1;
        }
        return 2;
    }
}

