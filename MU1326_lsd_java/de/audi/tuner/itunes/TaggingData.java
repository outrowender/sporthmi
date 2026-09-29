/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.itunes;

import de.esolutions.fw.util.commons.Buffer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.media.TagInformation;

public class TaggingData
implements Serializable {
    private static final long serialVersionUID;
    private TagInformation tag1;
    private TagInformation tag2;
    private int id;

    public TaggingData(TagInformation tagInformation, TagInformation tagInformation2) {
        if (tagInformation == null) {
            throw new IllegalArgumentException();
        }
        this.tag1 = tagInformation;
        this.tag2 = tagInformation2;
        if (tagInformation2 != null) {
            this.tag1.ambiguousTag = true;
            this.tag2.ambiguousTag = true;
        }
    }

    public void setId(int n) {
        this.id = n;
    }

    protected int getId() {
        return this.id;
    }

    public void setButtonPressed(int n) {
        if (n < 1 || n > 2) {
            throw new IllegalArgumentException("[TaggingData.setButtonPressed] pos must be 1 or 2");
        }
        if (this.tag2 == null) {
            throw new IllegalArgumentException("[TaggingData.setButtonPressed] tag is unambiguous -> buttonPressed is useless");
        }
        if (n == 1) {
            this.tag1.buttonPressed = true;
            this.tag2.buttonPressed = false;
        } else {
            this.tag2.buttonPressed = true;
            this.tag1.buttonPressed = false;
        }
    }

    public boolean isAmbigous() {
        return this.tag1 != null && this.tag2 != null;
    }

    public TagInformation getTag1() {
        return this.tag1;
    }

    public TagInformation getTag2() {
        return this.tag2;
    }

    TagInformation getTagAtButton() {
        if (this.tag1 != null && this.tag1.buttonPressed) {
            return this.tag1;
        }
        if (this.tag2 != null && this.tag2.buttonPressed) {
            return this.tag2;
        }
        return null;
    }

    public boolean equals(Object object) {
        if (object instanceof TaggingData) {
            TagInformation tagInformation = this.getTagAtButton();
            TagInformation tagInformation2 = ((TaggingData)object).getTagAtButton();
            if (tagInformation != null && tagInformation2 != null) {
                return tagInformation.artist.equals(tagInformation2.artist) && tagInformation.title.equals(tagInformation2.title) && tagInformation.album.equals(tagInformation2.album) && tagInformation.stationFrequency.equals(tagInformation2.stationFrequency) && tagInformation.programNumber == tagInformation2.programNumber && tagInformation.stationURL.equals(tagInformation2.stationURL) && tagInformation.songID.equals(tagInformation2.songID) && tagInformation.affiliateID.equals(tagInformation2.affiliateID);
            }
        }
        return false;
    }

    public int hashCode() {
        TagInformation tagInformation = this.getTagAtButton();
        int n = 1;
        n = 31 * n + (tagInformation == null ? 0 : this.getTagsHashCode(tagInformation));
        return n;
    }

    private int getTagsHashCode(TagInformation tagInformation) {
        int n = 1;
        n = 31 * n + (tagInformation.artist == null ? 0 : tagInformation.artist.hashCode());
        n = 31 * n + (tagInformation.title == null ? 0 : tagInformation.title.hashCode());
        n = 31 * n + (tagInformation.album == null ? 0 : tagInformation.album.hashCode());
        n = 31 * n + (tagInformation.stationURL == null ? 0 : tagInformation.stationURL.hashCode());
        n = 31 * n + (tagInformation.songID == null ? 0 : tagInformation.songID.hashCode());
        n = 31 * n + (tagInformation.affiliateID == null ? 0 : tagInformation.affiliateID.hashCode());
        n = 31 * n + (tagInformation.stationFrequency == null ? 0 : tagInformation.stationFrequency.hashCode());
        n = 31 * n + tagInformation.programNumber;
        return n;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        this.writeTagInfo(objectOutputStream, this.tag1);
        if (this.tag2 != null) {
            objectOutputStream.writeBoolean(true);
            this.writeTagInfo(objectOutputStream, this.tag2);
        } else {
            objectOutputStream.writeBoolean(false);
        }
    }

    private void writeTagInfo(ObjectOutputStream objectOutputStream, TagInformation tagInformation) {
        objectOutputStream.writeBoolean(tagInformation.ambiguousTag);
        objectOutputStream.writeBoolean(tagInformation.buttonPressed);
        objectOutputStream.writeUTF(tagInformation.title);
        objectOutputStream.writeUTF(tagInformation.artist);
        objectOutputStream.writeUTF(tagInformation.songID);
        objectOutputStream.writeUTF(tagInformation.stationFrequency);
        objectOutputStream.writeUTF(tagInformation.stationCallLetters);
        objectOutputStream.writeInt(tagInformation.programNumber);
        objectOutputStream.writeUTF(tagInformation.stationURL);
        objectOutputStream.writeLong(tagInformation.timeStamp.getTime());
        objectOutputStream.writeUTF(tagInformation.affiliateID);
        objectOutputStream.writeUTF(tagInformation.album);
        objectOutputStream.writeInt(tagInformation.iTunesFrontID);
        objectOutputStream.writeInt(tagInformation.podcastFeedURL);
        objectOutputStream.writeUTF(tagInformation.genre);
        objectOutputStream.writeUTF(tagInformation.unknownData);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.tag1 = this.readTagInfo(objectInputStream);
        boolean bl = objectInputStream.readBoolean();
        this.tag2 = bl ? this.readTagInfo(objectInputStream) : null;
    }

    private TagInformation readTagInfo(ObjectInputStream objectInputStream) {
        TagInformation tagInformation = new TagInformation();
        tagInformation.ambiguousTag = objectInputStream.readBoolean();
        tagInformation.buttonPressed = objectInputStream.readBoolean();
        tagInformation.title = objectInputStream.readUTF();
        tagInformation.artist = objectInputStream.readUTF();
        tagInformation.songID = objectInputStream.readUTF();
        tagInformation.stationFrequency = objectInputStream.readUTF();
        tagInformation.stationCallLetters = objectInputStream.readUTF();
        tagInformation.programNumber = objectInputStream.readInt();
        tagInformation.stationURL = objectInputStream.readUTF();
        long l = objectInputStream.readLong();
        tagInformation.timeStamp = new DateTime(l);
        tagInformation.affiliateID = objectInputStream.readUTF();
        tagInformation.album = objectInputStream.readUTF();
        tagInformation.iTunesFrontID = objectInputStream.readInt();
        tagInformation.podcastFeedURL = objectInputStream.readInt();
        tagInformation.genre = objectInputStream.readUTF();
        tagInformation.unknownData = objectInputStream.readUTF();
        return tagInformation;
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append("TaggingData tag1: ");
        buffer.append(this.tag1);
        buffer.append("\n tag2 ");
        buffer.append(this.tag2);
        return buffer.toString();
    }
}

