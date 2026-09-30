/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.container;

import de.audi.tghu.exlap.dsi.BooleanElement;
import de.audi.tghu.exlap.impl.container.AbstractContainer;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaCapabilitiesContainer
extends AbstractContainer {
    private static final int CONTAINER_ID_MEDIA_CAPABILITIES = 66;
    private static final int ELEMENT_ID_COVER_ART = 152;
    private static final int ELEMENT_ID_DATABASE_BROWSE_MODE = 153;
    private static final int ELEMENT_ID_DETAIL_INFO = 154;
    private static final int ELEMENT_ID_ELAPSED_TIME = 155;
    private static final int ELEMENT_ID_FAST_BACKWARD = 156;
    private static final int ELEMENT_ID_FAST_FORWARD = 157;
    private static final int ELEMENT_ID_PAUSE = 158;
    private static final int ELEMENT_ID_PLAY = 159;
    private static final int ELEMENT_ID_PLAYBACK_MODES = 160;
    private static final int ELEMENT_ID_PLAYING_TIME = 161;
    private static final int ELEMENT_ID_PMLTMODE = 162;
    private static final int ELEMENT_ID_RAW_BROWSE_MODE = 163;
    private static final int ELEMENT_ID_SET_TIME_POS = 164;
    private static final int ELEMENT_ID_SKIP_BACKWARD = 165;
    private static final int ELEMENT_ID_SKIP_FORWARD = 166;
    private Map map = new HashMap();

    public MediaCapabilitiesContainer() {
    }

    public MediaCapabilitiesContainer(MediaCapabilitiesContainer mediaCapabilitiesContainer) {
        this.map.putAll(mediaCapabilitiesContainer.map);
    }

    public MediaCapabilitiesContainer(HASDataElement[] hASDataElementArray) {
        block17: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
            switch (hASDataElementArray[i2].elementId) {
                case 152: {
                    this.map.put(new Integer(152), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 153: {
                    this.map.put(new Integer(153), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 154: {
                    this.map.put(new Integer(154), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 155: {
                    this.map.put(new Integer(155), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 156: {
                    this.map.put(new Integer(156), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 157: {
                    this.map.put(new Integer(157), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 158: {
                    this.map.put(new Integer(158), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 159: {
                    this.map.put(new Integer(159), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 160: {
                    this.map.put(new Integer(160), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 161: {
                    this.map.put(new Integer(161), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 162: {
                    this.map.put(new Integer(162), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 163: {
                    this.map.put(new Integer(163), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 164: {
                    this.map.put(new Integer(164), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 165: {
                    this.map.put(new Integer(165), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
                case 166: {
                    this.map.put(new Integer(166), new Boolean(hASDataElementArray[i2].numericData == 1L));
                    continue block17;
                }
            }
        }
    }

    public MediaCapabilitiesContainer setCoverArt(boolean bl) {
        this.map.put(new Integer(152), new Boolean(bl));
        return this;
    }

    public boolean isSetCoverArt() {
        return this.map.containsKey(new Integer(152));
    }

    public boolean getCoverArt() {
        return (Boolean)this.map.get(new Integer(152));
    }

    public MediaCapabilitiesContainer setDatabaseBrowseMode(boolean bl) {
        this.map.put(new Integer(153), new Boolean(bl));
        return this;
    }

    public boolean isSetDatabaseBrowseMode() {
        return this.map.containsKey(new Integer(153));
    }

    public boolean getDatabaseBrowseMode() {
        return (Boolean)this.map.get(new Integer(153));
    }

    public MediaCapabilitiesContainer setDetailInfo(boolean bl) {
        this.map.put(new Integer(154), new Boolean(bl));
        return this;
    }

    public boolean isSetDetailInfo() {
        return this.map.containsKey(new Integer(154));
    }

    public boolean getDetailInfo() {
        return (Boolean)this.map.get(new Integer(154));
    }

    public MediaCapabilitiesContainer setElapsedTime(boolean bl) {
        this.map.put(new Integer(155), new Boolean(bl));
        return this;
    }

    public boolean isSetElapsedTime() {
        return this.map.containsKey(new Integer(155));
    }

    public boolean getElapsedTime() {
        return (Boolean)this.map.get(new Integer(155));
    }

    public MediaCapabilitiesContainer setFastBackward(boolean bl) {
        this.map.put(new Integer(156), new Boolean(bl));
        return this;
    }

    public boolean isSetFastBackward() {
        return this.map.containsKey(new Integer(156));
    }

    public boolean getFastBackward() {
        return (Boolean)this.map.get(new Integer(156));
    }

    public MediaCapabilitiesContainer setFastForward(boolean bl) {
        this.map.put(new Integer(157), new Boolean(bl));
        return this;
    }

    public boolean isSetFastForward() {
        return this.map.containsKey(new Integer(157));
    }

    public boolean getFastForward() {
        return (Boolean)this.map.get(new Integer(157));
    }

    public MediaCapabilitiesContainer setPause(boolean bl) {
        this.map.put(new Integer(158), new Boolean(bl));
        return this;
    }

    public boolean isSetPause() {
        return this.map.containsKey(new Integer(158));
    }

    public boolean getPause() {
        return (Boolean)this.map.get(new Integer(158));
    }

    public MediaCapabilitiesContainer setPlay(boolean bl) {
        this.map.put(new Integer(159), new Boolean(bl));
        return this;
    }

    public boolean isSetPlay() {
        return this.map.containsKey(new Integer(159));
    }

    public boolean getPlay() {
        return (Boolean)this.map.get(new Integer(159));
    }

    public MediaCapabilitiesContainer setPlaybackModes(boolean bl) {
        this.map.put(new Integer(160), new Boolean(bl));
        return this;
    }

    public boolean isSetPlaybackModes() {
        return this.map.containsKey(new Integer(160));
    }

    public boolean getPlaybackModes() {
        return (Boolean)this.map.get(new Integer(160));
    }

    public MediaCapabilitiesContainer setPlayingTime(boolean bl) {
        this.map.put(new Integer(161), new Boolean(bl));
        return this;
    }

    public boolean isSetPlayingTime() {
        return this.map.containsKey(new Integer(161));
    }

    public boolean getPlayingTime() {
        return (Boolean)this.map.get(new Integer(161));
    }

    public MediaCapabilitiesContainer setPMLTMode(boolean bl) {
        this.map.put(new Integer(162), new Boolean(bl));
        return this;
    }

    public boolean isSetPMLTMode() {
        return this.map.containsKey(new Integer(162));
    }

    public boolean getPMLTMode() {
        return (Boolean)this.map.get(new Integer(162));
    }

    public MediaCapabilitiesContainer setRawBrowseMode(boolean bl) {
        this.map.put(new Integer(163), new Boolean(bl));
        return this;
    }

    public boolean isSetRawBrowseMode() {
        return this.map.containsKey(new Integer(163));
    }

    public boolean getRawBrowseMode() {
        return (Boolean)this.map.get(new Integer(163));
    }

    public MediaCapabilitiesContainer setSetTimePos(boolean bl) {
        this.map.put(new Integer(164), new Boolean(bl));
        return this;
    }

    public boolean isSetSetTimePos() {
        return this.map.containsKey(new Integer(164));
    }

    public boolean getSetTimePos() {
        return (Boolean)this.map.get(new Integer(164));
    }

    public MediaCapabilitiesContainer setSkipBackward(boolean bl) {
        this.map.put(new Integer(165), new Boolean(bl));
        return this;
    }

    public boolean isSetSkipBackward() {
        return this.map.containsKey(new Integer(165));
    }

    public boolean getSkipBackward() {
        return (Boolean)this.map.get(new Integer(165));
    }

    public MediaCapabilitiesContainer setSkipForward(boolean bl) {
        this.map.put(new Integer(166), new Boolean(bl));
        return this;
    }

    public boolean isSetSkipForward() {
        return this.map.containsKey(new Integer(166));
    }

    public boolean getSkipForward() {
        return (Boolean)this.map.get(new Integer(166));
    }

    public List createContainer(int n, int n2, int n3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HASDataContainer(66, n2, n, this.createElements(), n3));
        return arrayList;
    }

    public HASDataContainer[] createContainer() {
        List list = this.createContainer(-1, 1, -1);
        return (HASDataContainer[])list.toArray(new HASDataContainer[list.size()]);
    }

    private HASDataElement[] createElements() {
        int n = 0;
        HASDataElement[] hASDataElementArray = new HASDataElement[this.map.size()];
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (entry.getValue() == null) continue;
            switch ((Integer)entry.getKey()) {
                case 152: {
                    hASDataElementArray[n++] = new BooleanElement(152, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 153: {
                    hASDataElementArray[n++] = new BooleanElement(153, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 154: {
                    hASDataElementArray[n++] = new BooleanElement(154, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 155: {
                    hASDataElementArray[n++] = new BooleanElement(155, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 156: {
                    hASDataElementArray[n++] = new BooleanElement(156, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 157: {
                    hASDataElementArray[n++] = new BooleanElement(157, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 158: {
                    hASDataElementArray[n++] = new BooleanElement(158, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 159: {
                    hASDataElementArray[n++] = new BooleanElement(159, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 160: {
                    hASDataElementArray[n++] = new BooleanElement(160, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 161: {
                    hASDataElementArray[n++] = new BooleanElement(161, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 162: {
                    hASDataElementArray[n++] = new BooleanElement(162, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 163: {
                    hASDataElementArray[n++] = new BooleanElement(163, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 164: {
                    hASDataElementArray[n++] = new BooleanElement(164, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 165: {
                    hASDataElementArray[n++] = new BooleanElement(165, (boolean)((Boolean)entry.getValue()));
                    break;
                }
                case 166: {
                    hASDataElementArray[n++] = new BooleanElement(166, (boolean)((Boolean)entry.getValue()));
                    break;
                }
            }
        }
        return hASDataElementArray;
    }

    public void toString(StringWriter stringWriter) {
        stringWriter.write("MediaCapabilitiesContainer(");
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            switch ((Integer)entry.getKey()) {
                case 152: {
                    if (entry.getValue() == null) {
                        stringWriter.write("coverArt(boolean)=null");
                        break;
                    }
                    stringWriter.write("coverArt(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 153: {
                    if (entry.getValue() == null) {
                        stringWriter.write("databaseBrowseMode(boolean)=null");
                        break;
                    }
                    stringWriter.write("databaseBrowseMode(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 154: {
                    if (entry.getValue() == null) {
                        stringWriter.write("detailInfo(boolean)=null");
                        break;
                    }
                    stringWriter.write("detailInfo(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 155: {
                    if (entry.getValue() == null) {
                        stringWriter.write("elapsedTime(boolean)=null");
                        break;
                    }
                    stringWriter.write("elapsedTime(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 156: {
                    if (entry.getValue() == null) {
                        stringWriter.write("fastBackward(boolean)=null");
                        break;
                    }
                    stringWriter.write("fastBackward(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 157: {
                    if (entry.getValue() == null) {
                        stringWriter.write("fastForward(boolean)=null");
                        break;
                    }
                    stringWriter.write("fastForward(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 158: {
                    if (entry.getValue() == null) {
                        stringWriter.write("pause(boolean)=null");
                        break;
                    }
                    stringWriter.write("pause(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 159: {
                    if (entry.getValue() == null) {
                        stringWriter.write("play(boolean)=null");
                        break;
                    }
                    stringWriter.write("play(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 160: {
                    if (entry.getValue() == null) {
                        stringWriter.write("playbackModes(boolean)=null");
                        break;
                    }
                    stringWriter.write("playbackModes(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 161: {
                    if (entry.getValue() == null) {
                        stringWriter.write("playingTime(boolean)=null");
                        break;
                    }
                    stringWriter.write("playingTime(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 162: {
                    if (entry.getValue() == null) {
                        stringWriter.write("pMLTMode(boolean)=null");
                        break;
                    }
                    stringWriter.write("pMLTMode(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 163: {
                    if (entry.getValue() == null) {
                        stringWriter.write("rawBrowseMode(boolean)=null");
                        break;
                    }
                    stringWriter.write("rawBrowseMode(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 164: {
                    if (entry.getValue() == null) {
                        stringWriter.write("setTimePos(boolean)=null");
                        break;
                    }
                    stringWriter.write("setTimePos(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 165: {
                    if (entry.getValue() == null) {
                        stringWriter.write("skipBackward(boolean)=null");
                        break;
                    }
                    stringWriter.write("skipBackward(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
                case 166: {
                    if (entry.getValue() == null) {
                        stringWriter.write("skipForward(boolean)=null");
                        break;
                    }
                    stringWriter.write("skipForward(boolean)='");
                    stringWriter.write(entry.getValue().toString());
                    stringWriter.write("'");
                    break;
                }
            }
            if (!iterator.hasNext()) continue;
            stringWriter.write(", ");
        }
        stringWriter.write(")");
    }

    protected Object clone() {
        MediaCapabilitiesContainer mediaCapabilitiesContainer = new MediaCapabilitiesContainer(this);
        return mediaCapabilitiesContainer;
    }
}

