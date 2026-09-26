/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.interapp;

import de.audi.app.media.content.media.utils.IntMap;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.content.media.utils.NoMapElementException;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.esolutions.fw.util.commons.Buffer;

public class MediaSlotInfoImpl
implements MediaSlotInfo {
    private static final IntMap MEDIATYPEMAP = new IntMap(25);
    private static final IntMap SOURCETYPEMAP;
    private final String mountPoint;
    private final String name;
    private final int slotIdx;
    private final int type;
    private boolean empty;
    private boolean readOnly;
    private int sourceType;
    private boolean synced;

    public MediaSlotInfoImpl(ISourceSlot iSourceSlot) {
        int n;
        int n2;
        this.mountPoint = iSourceSlot.getMountPoint();
        this.slotIdx = iSourceSlot.getIndex();
        this.empty = iSourceSlot.isEmpty();
        this.readOnly = iSourceSlot.getFlags().isReadOnly();
        this.name = iSourceSlot.getName();
        this.synced = false;
        try {
            n2 = MEDIATYPEMAP.get(iSourceSlot.getMediaType());
        }
        catch (NoMapElementException noMapElementException) {
            n2 = 0;
        }
        if (n2 == 2) {
            this.synced = MediaUtils.isDefaultSyncSource(iSourceSlot.getSource().getType());
        } else if (n2 == 10) {
            this.synced = iSourceSlot.getCapabilities().isSearch();
        }
        this.type = n2;
        try {
            n = SOURCETYPEMAP.get(iSourceSlot.getSource().getType());
        }
        catch (NoMapElementException noMapElementException) {
            n = -1;
        }
        this.sourceType = n;
    }

    @Override
    public String getMountPoint() {
        return this.mountPoint;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSlotIdx() {
        return this.slotIdx;
    }

    @Override
    public boolean isEmpty() {
        return this.empty;
    }

    @Override
    public boolean isReadOnly() {
        return this.readOnly;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public int getSourceType() {
        return this.sourceType;
    }

    @Override
    public boolean isSyncedSource() {
        return this.synced;
    }

    public String toString() {
        Buffer buffer = new Buffer(40);
        buffer.append("[MediaSlotInfoImpl: idx='").append(this.slotIdx).append("',mount='").append(this.mountPoint).append("',empty='").append(this.empty).append("',readOnly='").append(this.readOnly).append("', type='").append(this.type).append("']");
        return buffer.toString();
    }

    static {
        MEDIATYPEMAP.put(14, 5);
        MEDIATYPEMAP.put(19, 5);
        MEDIATYPEMAP.put(17, 6);
        MEDIATYPEMAP.put(15, 6);
        MEDIATYPEMAP.put(1, 1);
        MEDIATYPEMAP.put(5, 4);
        MEDIATYPEMAP.put(6, 3);
        MEDIATYPEMAP.put(2, 2);
        MEDIATYPEMAP.put(7, 2);
        MEDIATYPEMAP.put(12, 2);
        MEDIATYPEMAP.put(11, 2);
        MEDIATYPEMAP.put(9, 2);
        MEDIATYPEMAP.put(10, 2);
        MEDIATYPEMAP.put(13, 7);
        MEDIATYPEMAP.put(24, 10);
        MEDIATYPEMAP.put(21, 9);
        MEDIATYPEMAP.put(22, 8);
        SOURCETYPEMAP = new IntMap(20);
        SOURCETYPEMAP.put(9, 9);
        SOURCETYPEMAP.put(8, 8);
        SOURCETYPEMAP.put(11, 11);
        SOURCETYPEMAP.put(1, 2);
        SOURCETYPEMAP.put(0, 1);
        SOURCETYPEMAP.put(3, 4);
        SOURCETYPEMAP.put(2, 3);
        SOURCETYPEMAP.put(6, 6);
        SOURCETYPEMAP.put(5, 5);
        SOURCETYPEMAP.put(7, 7);
        SOURCETYPEMAP.put(10, 10);
        SOURCETYPEMAP.put(12, 12);
        SOURCETYPEMAP.put(13, 13);
    }
}

