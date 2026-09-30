/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.bap.fw.arrays.ArrayUtils;
import de.audi.app.combi.bap.app.audio.AudioApplicationInFocusHandler;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.list.AbstractSourceListObserver;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSource_Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SourceListHandler
extends AbstractManagedListHandler {
    private static final int SOURCE_POS_SOURCETYPE_MULTIPLIER = 100;
    private static final Integer[] SOURCES_ORDER = new Integer[]{new Integer(0), new Integer(36), new Integer(3), new Integer(4), new Integer(5), new Integer(1), new Integer(2), new Integer(25), new Integer(26), new Integer(17), new Integer(35), new Integer(20), new Integer(10), new Integer(6), new Integer(8), new Integer(11), new Integer(7), new Integer(18), new Integer(19), new Integer(15), new Integer(16), new Integer(13), new Integer(14), new Integer(21), new Integer(22), new Integer(27), new Integer(28), new Integer(12), new Integer(23), new Integer(24), new Integer(29), new Integer(30), new Integer(31), new Integer(33), new Integer(9), new Integer(32), new Integer(34), new Integer(37), new Integer(38), new Integer(39), new Integer(40)};
    private static final Set SOURCES_TUNER = SourceListHandler.sourcesTuner();
    private static final Set SOURCES_MEDIA = SourceListHandler.sourcesMedia();
    private static final Set SOURCES_TV = SourceListHandler.sourcesTv();
    private static final Set SOURCES_TERMINALMODE = SourceListHandler.sourcesTerminalMode();
    private final Map sourceTypeToAvailableSlotsMapping = new HashMap();
    private final CombiBAPAudioSource dummySDEmptySlot = new CombiBAPAudioSource(11, 0, 0, 0, "", 1);
    private final CombiBAPAudioSource dummyAMIEmptySlot;
    private AbstractSourceListObserver activeSourceObserver = null;
    private CombiBAPAudioSource lastModeMedia = null;

    private static Set sourcesTuner() {
        HashSet hashSet = new HashSet();
        hashSet.add(new Integer(36));
        hashSet.add(new Integer(3));
        hashSet.add(new Integer(4));
        hashSet.add(new Integer(5));
        hashSet.add(new Integer(1));
        hashSet.add(new Integer(2));
        hashSet.add(new Integer(25));
        hashSet.add(new Integer(26));
        hashSet.add(new Integer(17));
        hashSet.add(new Integer(35));
        return hashSet;
    }

    private static Set sourcesMedia() {
        HashSet hashSet = new HashSet();
        hashSet.add(new Integer(20));
        hashSet.add(new Integer(10));
        hashSet.add(new Integer(6));
        hashSet.add(new Integer(8));
        hashSet.add(new Integer(11));
        hashSet.add(new Integer(7));
        hashSet.add(new Integer(18));
        hashSet.add(new Integer(19));
        hashSet.add(new Integer(15));
        hashSet.add(new Integer(13));
        hashSet.add(new Integer(14));
        hashSet.add(new Integer(21));
        hashSet.add(new Integer(22));
        hashSet.add(new Integer(27));
        hashSet.add(new Integer(28));
        hashSet.add(new Integer(16));
        hashSet.add(new Integer(12));
        hashSet.add(new Integer(23));
        hashSet.add(new Integer(24));
        hashSet.add(new Integer(29));
        hashSet.add(new Integer(30));
        hashSet.add(new Integer(31));
        hashSet.add(new Integer(33));
        hashSet.add(new Integer(34));
        return hashSet;
    }

    private static Set sourcesTv() {
        HashSet hashSet = new HashSet();
        hashSet.add(new Integer(9));
        hashSet.add(new Integer(32));
        return hashSet;
    }

    private static Set sourcesTerminalMode() {
        HashSet hashSet = new HashSet();
        hashSet.add(new Integer(37));
        hashSet.add(new Integer(38));
        hashSet.add(new Integer(39));
        hashSet.add(new Integer(40));
        return hashSet;
    }

    public SourceListHandler(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio, "SourceListHandler");
        this.dummySDEmptySlot.setPosID(SourceListHandler.createPosID(11, 0));
        this.dummyAMIEmptySlot = new CombiBAPAudioSource(15, 0, 0, 0, "", 1);
        this.dummyAMIEmptySlot.setPosID(SourceListHandler.createPosID(15, 0));
    }

    public static int getApplicationForSourceType(int n) {
        if (SOURCES_TUNER.contains(new Integer(n))) {
            return 0;
        }
        if (SOURCES_MEDIA.contains(new Integer(n))) {
            return 1;
        }
        if (SOURCES_TV.contains(new Integer(n))) {
            return 2;
        }
        if (SOURCES_TERMINALMODE.contains(new Integer(n))) {
            return 3;
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSources(int n, CombiBAPAudioSource[] combiBAPAudioSourceArray) {
        this.logChannel.log(1000000, "[SourceListHandler#updateSources] update %1 sources", (Object)AudioApplicationInFocusHandler.getAudioApplicationName(n));
        this.clearAvailableSlotsMapping(n);
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < combiBAPAudioSourceArray.length; ++i2) {
            combiBAPAudioSourceArray[i2].setPosID(SourceListHandler.createPosID(combiBAPAudioSourceArray[i2].getSourceType(), combiBAPAudioSourceArray[i2].getSourceId()));
            int n2 = combiBAPAudioSourceArray[i2].getSourceType();
            buffer.append('\n');
            buffer.append(combiBAPAudioSourceArray[i2]);
            Integer n3 = new Integer(n2);
            Map map = this.sourceTypeToAvailableSlotsMapping;
            synchronized (map) {
                List list = (List)this.sourceTypeToAvailableSlotsMapping.get(n3);
                if (list == null) {
                    list = new ArrayList(1);
                    this.sourceTypeToAvailableSlotsMapping.put(n3, list);
                }
                list.add(combiBAPAudioSourceArray[i2]);
                continue;
            }
        }
        this.logChannel.log(10000000, "[SourceListHandler#updateSources] %2 sources%1", (Object)buffer, (long)combiBAPAudioSourceArray.length);
        this.updateSourceList(n, this.getDisplayedSlots(this.retrieveActiveSource()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateSources(int n, int[] nArray, CombiBAPAudioSource[][] combiBAPAudioSourceArray) {
        this.logChannel.log(1000000, "[SourceListHandler#updateSources] update %1 sources", (Object)AudioApplicationInFocusHandler.getAudioApplicationName(n));
        boolean bl = false;
        boolean bl2 = false;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            Buffer buffer = new Buffer();
            List list = null;
            if (combiBAPAudioSourceArray[i2] == null) {
                list = null;
                buffer.append(" -> no sources (null)");
            } else {
                int n2;
                list = Arrays.asList(combiBAPAudioSourceArray[i2]);
                if (nArray[i2] == 19) {
                    bl2 = true;
                }
                if (nArray[i2] == 15) {
                    n2 = 1;
                    bl = true;
                    for (int i3 = 0; i3 < combiBAPAudioSourceArray[i2].length; ++i3) {
                        if (combiBAPAudioSourceArray[i2][i3].getMediaType() == 0) continue;
                        n2 = 0;
                        break;
                    }
                    if (n2 != 0) {
                        Map map = this.sourceTypeToAvailableSlotsMapping;
                        synchronized (map) {
                            this.sourceTypeToAvailableSlotsMapping.remove(new Integer(19));
                        }
                    }
                }
                for (n2 = 0; n2 < combiBAPAudioSourceArray[i2].length; ++n2) {
                    combiBAPAudioSourceArray[i2][n2].setPosID(SourceListHandler.createPosID(combiBAPAudioSourceArray[i2][n2].getSourceType(), combiBAPAudioSourceArray[i2][n2].getSourceId()));
                    buffer.append('\n');
                    buffer.append(combiBAPAudioSourceArray[i2][n2]);
                }
            }
            this.logChannel.log(10000000, "[SourceListHandler#updateSources] slots of sourceType=%2%1", (Object)buffer, (long)nArray[i2]);
            Map map = this.sourceTypeToAvailableSlotsMapping;
            synchronized (map) {
                if (bl2 && !bl) {
                    this.sourceTypeToAvailableSlotsMapping.remove(new Integer(15));
                }
                if (nArray[i2] == 19) {
                    ArrayList arrayList = new ArrayList(2);
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        CombiBAPAudioSource combiBAPAudioSource = (CombiBAPAudioSource)iterator.next();
                        if (combiBAPAudioSource.getMediaType() != 0) {
                            this.logChannel.log(10000000, "[SourceListHandler#updateSources] adding USB slot %1", (Object)combiBAPAudioSource);
                            arrayList.add(combiBAPAudioSource);
                            continue;
                        }
                        this.logChannel.log(10000000, "[SourceListHandler#updateSources] NOT adding USB slot %1", (Object)combiBAPAudioSource);
                    }
                    if (!arrayList.isEmpty()) {
                        this.sourceTypeToAvailableSlotsMapping.put(new Integer(nArray[i2]), arrayList);
                    }
                } else {
                    this.sourceTypeToAvailableSlotsMapping.put(new Integer(nArray[i2]), list);
                }
                continue;
            }
        }
        this.updateSourceList(n, this.getDisplayedSlots(this.retrieveActiveSource()));
    }

    private CombiBAPAudioSource retrieveActiveSource() {
        ActiveSource_Status activeSource_Status = (ActiveSource_Status)this.moduleFsg.getBAPFunctionPropertyFSG(16).getLastStatus();
        CombiBAPAudioSource combiBAPAudioSource = (CombiBAPAudioSource)this.getArrayElement(activeSource_Status.sourceList_Reference);
        if (combiBAPAudioSource == null) {
            combiBAPAudioSource = new CombiBAPAudioSource(0, 0, 0, 255, "");
        }
        return combiBAPAudioSource;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private List clearAvailableSlotsMapping(int n) {
        ArrayList arrayList = new ArrayList(10);
        Integer[] integerArray = this.getSourceTypeOrderWithinApp(n);
        Map map = this.sourceTypeToAvailableSlotsMapping;
        synchronized (map) {
            for (int i2 = 0; i2 < integerArray.length; ++i2) {
                List list = (List)this.sourceTypeToAvailableSlotsMapping.get(integerArray[i2]);
                if (list != null) {
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        CombiBAPAudioSource combiBAPAudioSource = (CombiBAPAudioSource)iterator.next();
                        arrayList.add(combiBAPAudioSource);
                    }
                }
                this.sourceTypeToAvailableSlotsMapping.remove(integerArray[i2]);
            }
        }
        return arrayList;
    }

    private Integer[] getSourceTypeOrderWithinApp(int n) {
        switch (n) {
            case 0: {
                return SourceListHandler.integerArrayFromIntegerSet(SOURCES_TUNER);
            }
            case 1: {
                return SourceListHandler.integerArrayFromIntegerSet(SOURCES_MEDIA);
            }
            case 2: {
                return SourceListHandler.integerArrayFromIntegerSet(SOURCES_TV);
            }
            case 3: {
                return SourceListHandler.integerArrayFromIntegerSet(SOURCES_TERMINALMODE);
            }
        }
        this.logChannel.log(10000000, "[SourceListHandler#getSourceTypeOrderWithinApp] invalid applicationID=%1", (long)n);
        return new Integer[0];
    }

    private static Integer[] integerArrayFromIntegerSet(Set set) {
        return (Integer[])set.toArray(new Integer[set.size()]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private List getDisplayedSlots(CombiBAPAudioSource combiBAPAudioSource) {
        Object object;
        Object object2;
        ArrayList arrayList = new ArrayList();
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        Object object3 = this.sourceTypeToAvailableSlotsMapping;
        synchronized (object3) {
            object2 = this.sourceTypeToAvailableSlotsMapping.keySet().iterator();
            while (object2.hasNext()) {
                List list;
                object = (Integer)object2.next();
                int n = (Integer)object;
                List list2 = (List)this.sourceTypeToAvailableSlotsMapping.get(object);
                if (n == 11) {
                    list = this.getSlotsWithoutEmpty(list2, combiBAPAudioSource, true);
                    if (list.isEmpty()) {
                        list.add(this.dummySDEmptySlot);
                    }
                } else if (n == 19) {
                    list = this.getSlotsWithoutEmpty(list2, combiBAPAudioSource, false);
                    bl2 = !list.isEmpty();
                } else if (n == 13) {
                    list = this.getSlotsWithoutEmpty(list2, combiBAPAudioSource, false);
                    bl |= !list.isEmpty();
                } else if (n == 14) {
                    list = this.getSlotsWithoutEmpty(list2, combiBAPAudioSource, false);
                    bl |= !list.isEmpty();
                } else if (n == 32) {
                    list = this.getSlotsWithoutEmpty(list2, combiBAPAudioSource, false);
                    bl |= !list.isEmpty();
                } else {
                    if (n == 15) {
                        list = this.getSlotsWithoutEmpty(list2, combiBAPAudioSource, false);
                        Iterator iterator = list.iterator();
                        while (iterator.hasNext()) {
                            CombiBAPAudioSource combiBAPAudioSource2 = (CombiBAPAudioSource)iterator.next();
                            if (combiBAPAudioSource2.getMediaType() != 12) continue;
                            bl3 = true;
                        }
                        continue;
                    }
                    list = list2;
                }
                if (list == null) continue;
                arrayList.addAll(list);
            }
        }
        this.logChannel.log(10000000, "[SourceListHandler#getDisplayedSlots] AUXConnected=%1, USBConnected=%2, iPodConnected=%3", bl, bl2, bl3);
        object3 = new Integer(15);
        object = this.sourceTypeToAvailableSlotsMapping;
        synchronized (object) {
            object2 = this.getSlotsWithoutEmpty((List)this.sourceTypeToAvailableSlotsMapping.get(object3), combiBAPAudioSource, true);
        }
        if (object2.isEmpty() && !bl2) {
            object2 = new ArrayList(1);
            object2.add(this.dummyAMIEmptySlot);
            this.logChannel.log(10000000, "[SourceListHandler#getDisplayedSlots] no AMI device connected");
        }
        arrayList.addAll((Collection)object2);
        this.logChannel.log(10000000, "[SourceListHandler#getDisplayedSlots] list displayed slots:\n%1", (Object)ArrayUtils.printList(arrayList.toArray()));
        return arrayList;
    }

    private List getSlotsWithoutEmpty(List list, CombiBAPAudioSource combiBAPAudioSource, boolean bl) {
        ArrayList arrayList = new ArrayList(2);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                CombiBAPAudioSource combiBAPAudioSource2 = (CombiBAPAudioSource)iterator.next();
                if (combiBAPAudioSource2.getAttributes().isBuiltInButNotReady()) {
                    if (!bl || (combiBAPAudioSource2.getSourceType() != combiBAPAudioSource.getSourceType() || combiBAPAudioSource2.getSourceId() != combiBAPAudioSource.getSourceId()) && (this.getLastModeMedia() == null || combiBAPAudioSource2.getSourceType() != this.getLastModeMedia().getSourceType() || combiBAPAudioSource2.getSourceId() != this.getLastModeMedia().getSourceId())) continue;
                    arrayList.add(combiBAPAudioSource2);
                    continue;
                }
                arrayList.add(combiBAPAudioSource2);
            }
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getListWithInvisibleSlots() {
        ArrayList arrayList = new ArrayList(10);
        Map map = this.sourceTypeToAvailableSlotsMapping;
        synchronized (map) {
            Iterator iterator = this.sourceTypeToAvailableSlotsMapping.values().iterator();
            while (iterator.hasNext()) {
                arrayList.addAll((List)iterator.next());
            }
        }
        return arrayList;
    }

    private void updateSourceList(int n, List list) {
        this.logChannel.log(10000000, "[SourceListHandler#updateSourceList] called (applicationID=%1)", (long)n);
        Object[] objectArray = new CombiBAPArrayElement[list.size()];
        list.toArray(objectArray);
        Arrays.sort(objectArray, new Comparator(){

            public int compare(Object object, Object object2) {
                return new Integer(((CombiBAPAudioSource)object).getPosID()).compareTo(new Integer(((CombiBAPAudioSource)object2).getPosID()));
            }
        });
        this.checkActiveSourceAdded((CombiBAPArrayElement[])objectArray);
        this.updateList((CombiBAPArrayElement[])objectArray);
    }

    private void checkActiveSourceAdded(CombiBAPArrayElement[] combiBAPArrayElementArray) {
        CombiBAPAudioSource combiBAPAudioSource;
        if (this.activeSourceObserver != null && (combiBAPAudioSource = this.activeSourceObserver.getSourceToWaitFor()) != null) {
            this.logChannel.log(10000000, "[SourceListHandler#checkActiveSourceAdded] activeSourceToWaitFor: %1", (Object)combiBAPAudioSource);
            CombiBAPAudioSource combiBAPAudioSource2 = (CombiBAPAudioSource)ArrayUtils.findElementByID(combiBAPArrayElementArray, SourceListHandler.createPosID(combiBAPAudioSource.getSourceType(), combiBAPAudioSource.getSourceId()));
            if (combiBAPAudioSource2 != null) {
                this.logChannel.log(10000000, "[SourceListHandler#checkActiveSourceAdded] source is now available in source list. source: %1", (Object)combiBAPAudioSource2);
                this.activeSourceObserver.notifySourceAdded(combiBAPAudioSource2);
                this.activeSourceObserver = null;
            }
        }
    }

    private static int createPosID(int n, int n2) {
        int n3 = n == 16 || n == 15 || n == 19 ? SourceListHandler.getOrderIndex(19) : SourceListHandler.getOrderIndex(n);
        return n3 * 100 + n2;
    }

    private static int getOrderIndex(int n) {
        Integer[] integerArray = SourceListHandler.getSourceTypeOrder();
        int n2 = integerArray.length;
        for (int i2 = 0; i2 < integerArray.length; ++i2) {
            if (integerArray[i2] != n) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    private static Integer[] getSourceTypeOrder() {
        return SOURCES_ORDER;
    }

    public CombiBAPAudioSource getAudioSource(int n, int n2) {
        return this.getAudioSource(n, n2, false);
    }

    public CombiBAPAudioSource getAudioSource(int n, int n2, boolean bl) {
        Object[] objectArray;
        if (bl) {
            List list = this.getListWithInvisibleSlots();
            Object[] objectArray2 = new CombiBAPArrayElement[list.size()];
            list.toArray(objectArray2);
            objectArray = objectArray2;
        } else {
            objectArray = this.getManagedList();
        }
        return (CombiBAPAudioSource)ArrayUtils.findElementByID((CombiBAPArrayElement[])objectArray, SourceListHandler.createPosID(n, n2));
    }

    public void getNextListPos(int n, int n2) {
        super.getNextListPosForArbitraryIds(n, n2);
    }

    public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
        ((CombiModuleAudio)this.moduleFsg).getTunerService().getNextListPosResult(bl ? 0 : 1, n, n2, n3);
    }

    public CombiBAPAudioSource notifySourceChanged(int n, int n2, AbstractSourceListObserver abstractSourceListObserver) {
        this.logChannel.log(10000000, "[SourceListHandler#notifySourceChanged] newSourceType=%2, newSourceId=%3, lastModeMedia=%1,", (Object)this.getLastModeMedia(), (long)n, (long)n2);
        CombiBAPAudioSource combiBAPAudioSource = this.getAudioSource(n, n2, true);
        if (combiBAPAudioSource == null) {
            this.logChannel.log(100000, "[SourceListHandler#notifySourceChanged] source is not in source list (sourceType=%1, sourceId=%2)", (long)n, (long)n2);
            combiBAPAudioSource = new CombiBAPAudioSource(n, n2, 255, "");
            if (abstractSourceListObserver != null) {
                abstractSourceListObserver.setSourceToWaitFor(combiBAPAudioSource);
                this.activeSourceObserver = abstractSourceListObserver;
                this.logChannel.log(10000000, "[SourceListHandler#notifySourceChanged] activeSourceObserver added");
            }
        } else {
            this.activeSourceObserver = null;
        }
        if (SourceListHandler.getApplicationForSourceType(n) == 1) {
            this.setLastModeMedia(combiBAPAudioSource);
            this.updateSourceList(1, this.getDisplayedSlots(combiBAPAudioSource));
        }
        return combiBAPAudioSource;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private CombiBAPAudioSource getLastModeMedia() {
        Map map = this.sourceTypeToAvailableSlotsMapping;
        synchronized (map) {
            return this.lastModeMedia;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setLastModeMedia(CombiBAPAudioSource combiBAPAudioSource) {
        Map map = this.sourceTypeToAvailableSlotsMapping;
        synchronized (map) {
            this.lastModeMedia = combiBAPAudioSource;
        }
    }
}

