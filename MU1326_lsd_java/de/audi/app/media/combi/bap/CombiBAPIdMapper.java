/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CombiBAPIdMapper
implements IDiagnosisDataProvider {
    private static final String LOGCLASS = "CombiBAPIdMapper";
    private final LogChannel logger;
    private final Map idMap;
    private final Map inverseIdMap;
    private final Object mapMutex = new Object();
    private int nextCombiID = 0;
    private Integer combiIDPlayingTrack = new Integer(0);
    private Integer combiIDBrowseFolder = new Integer(0);

    public CombiBAPIdMapper(LogChannel logChannel) {
        this.logger = logChannel;
        this.idMap = new HashMap();
        this.inverseIdMap = new HashMap();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset(boolean bl, boolean bl2) {
        if (this.logger.isInfo()) {
            this.logger.log(1000000, "[%1.reset] Reset (%2 %3)", (Object)LOGCLASS, (Object)(bl ? "PLAYINGTRACK" : ""), (Object)(bl2 ? "FOLDER" : ""));
        }
        Object object = this.mapMutex;
        synchronized (object) {
            CombiBAPMediaEntry combiBAPMediaEntry = null;
            CombiBAPMediaEntry combiBAPMediaEntry2 = null;
            if (!bl) {
                combiBAPMediaEntry = (CombiBAPMediaEntry)this.inverseIdMap.get(this.combiIDPlayingTrack);
            }
            if (!bl2) {
                combiBAPMediaEntry2 = (CombiBAPMediaEntry)this.inverseIdMap.get(this.combiIDBrowseFolder);
            }
            this.idMap.clear();
            this.inverseIdMap.clear();
            if (combiBAPMediaEntry == null) {
                this.combiIDPlayingTrack = new Integer(0);
            } else {
                this.idMap.put(combiBAPMediaEntry, this.combiIDPlayingTrack);
                this.inverseIdMap.put(this.combiIDPlayingTrack, combiBAPMediaEntry);
            }
            if (combiBAPMediaEntry2 == null) {
                this.combiIDBrowseFolder = new Integer(0);
            } else {
                this.idMap.put(combiBAPMediaEntry2, this.combiIDBrowseFolder);
                this.inverseIdMap.put(this.combiIDBrowseFolder, combiBAPMediaEntry2);
            }
            this.nextCombiID = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getCombiIDForPlayingTrack(CombiBAPMediaEntry combiBAPMediaEntry) {
        Object object = this.mapMutex;
        synchronized (object) {
            this.combiIDPlayingTrack = new Integer(this.getCombiID(combiBAPMediaEntry));
            return this.combiIDPlayingTrack;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getCombiIDForBrowseFolder(CombiBAPMediaEntry combiBAPMediaEntry) {
        Object object = this.mapMutex;
        synchronized (object) {
            this.combiIDBrowseFolder = new Integer(this.getCombiID(combiBAPMediaEntry));
            return this.combiIDBrowseFolder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getCombiID(CombiBAPMediaEntry combiBAPMediaEntry) {
        Object object;
        Object object2 = this.mapMutex;
        synchronized (object2) {
            object = this.idMap.get(combiBAPMediaEntry);
            if (object == null) {
                Integer n = new Integer(this.getNextCombiID());
                this.idMap.put(combiBAPMediaEntry, n);
                this.inverseIdMap.put(n, combiBAPMediaEntry);
                this.logger.log(10000000, "[%1.getCombiID] '%2' -> '%3' (new)", (Object)LOGCLASS, (Object)combiBAPMediaEntry, (Object)n);
                return n;
            }
            CombiBAPMediaEntry combiBAPMediaEntry2 = (CombiBAPMediaEntry)this.inverseIdMap.get(object);
            if (combiBAPMediaEntry2 == null || combiBAPMediaEntry2.getEntryFlags() != combiBAPMediaEntry.getEntryFlags()) {
                this.logger.log(10000000, "[%1.getCombiID] '%2' -> '%3' (update flags)", (Object)LOGCLASS, (Object)combiBAPMediaEntry, object);
                this.inverseIdMap.put(object, combiBAPMediaEntry);
                this.idMap.put(combiBAPMediaEntry, object);
            } else {
                this.logger.log(10000000, "[%1.getCombiID] '%2' -> '%3'", (Object)LOGCLASS, (Object)combiBAPMediaEntry, object);
            }
        }
        return (Integer)object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CombiBAPMediaEntry getEntry(int n) {
        Object object = this.mapMutex;
        synchronized (object) {
            return (CombiBAPMediaEntry)this.inverseIdMap.get(new Integer(n));
        }
    }

    private int getNextCombiID() {
        int n = this.nextCombiID;
        int n2 = 0;
        do {
            if (++n <= 65535) continue;
            this.logger.log(1000000, "[%1.getNextCombiID] Next combiID out of range.", (Object)LOGCLASS);
            n = 1;
            if (++n2 != 2) continue;
            this.logger.log(10000, "[%1.getNextCombiID] No free combi ID found. Reset IDs.", (Object)LOGCLASS);
            this.idMap.clear();
            this.inverseIdMap.clear();
            this.nextCombiID = 1;
            return this.nextCombiID;
        } while (this.inverseIdMap.get(Integers.valueOf(n)) != null);
        this.nextCombiID = n;
        return this.nextCombiID;
    }

    public String getDiagKey() {
        return "Combi.BAP.idMapper";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getDiagValue() {
        Buffer buffer = new Buffer();
        buffer.append("COMBI ID\t <-> \tENTRY\n");
        Object object = this.mapMutex;
        synchronized (object) {
            Iterator iterator = this.idMap.keySet().iterator();
            while (iterator.hasNext()) {
                CombiBAPMediaEntry combiBAPMediaEntry = (CombiBAPMediaEntry)iterator.next();
                Integer n = (Integer)this.idMap.get(combiBAPMediaEntry);
                buffer.append(n).append("\t <-> \t").append(combiBAPMediaEntry);
                if (n.equals(this.combiIDBrowseFolder)) {
                    buffer.append(" (BF)");
                } else if (n.equals(this.combiIDPlayingTrack)) {
                    buffer.append(" (PT)");
                }
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

