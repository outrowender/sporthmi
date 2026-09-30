/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPController;
import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.IMultipleSourceSlotListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;

public class CombiBAPSourceListener
implements IActiveSourceListener,
IMultipleSourceSlotListener {
    private static final String LOGCLASS = "CombiBAPSourceListener";
    private final LogChannel logger;
    private final CombiBAPController controller;

    public CombiBAPSourceListener(CombiBAPController combiBAPController) {
        this.controller = combiBAPController;
        this.logger = combiBAPController.getLogChannel();
    }

    public void slotsChanged(ISource[] iSourceArray) {
        ArrayList arrayList;
        Object object;
        Object object2;
        CombiBAPAudioSource[][] combiBAPAudioSourceArray;
        this.logger.log(100000000, "[%1.slotsChanged]", (Object)LOGCLASS);
        HashMap hashMap = new HashMap();
        boolean bl = false;
        CombiBAPAudioSource[][] combiBAPAudioSourceArray2 = null;
        for (int i2 = 0; i2 < iSourceArray.length; ++i2) {
            Object object3;
            combiBAPAudioSourceArray = iSourceArray[i2];
            if (combiBAPAudioSourceArray.getType() == 11) {
                hashMap.put(Integers.valueOf(21), new ArrayList(1));
                hashMap.put(Integers.valueOf(22), new ArrayList(1));
            }
            if (this.controller.getTerminal().getSourceController().getActivationContext() != null) {
                object3 = this.controller.getTerminal().getSourceController().getActivationContext().getSlot();
                if (combiBAPAudioSourceArray.getType() == 10 && object3.getSource().getType() == 10) {
                    bl = true;
                    combiBAPAudioSourceArray2 = combiBAPAudioSourceArray;
                    if (CombiBAPUtils.isSourceEmpty((ISource)combiBAPAudioSourceArray)) {
                        object2 = CombiBAPUtils.getBAPSource((ISource)combiBAPAudioSourceArray, combiBAPAudioSourceArray.getSlot(0));
                        object = (ArrayList)hashMap.get(Integers.valueOf(((CombiBAPAudioSource)object2).getSourceType()));
                        if (object == null) {
                            object = new ArrayList(2);
                            hashMap.put(Integers.valueOf(((CombiBAPAudioSource)object2).getSourceType()), object);
                        }
                        ((ArrayList)object).add(object2);
                        continue;
                    }
                }
            } else {
                this.logger.log(1000000, "[%1.slotsChanged] Activation context not yet available.", (Object)LOGCLASS);
            }
            if (combiBAPAudioSourceArray.getType() == 7 || combiBAPAudioSourceArray.getType() == 8) {
                this.logger.log(100000000, "[%1.slotsChanged] TV -> ignore", (Object)LOGCLASS);
                continue;
            }
            if (combiBAPAudioSourceArray.getType() == 4) {
                this.logger.log(100000000, "[%1.slotsChanged] Fileplayer -> ignore", (Object)LOGCLASS);
                continue;
            }
            object3 = combiBAPAudioSourceArray.getSlots().iterator();
            while (object3.hasNext()) {
                object2 = (ISourceSlot)object3.next();
                object = CombiBAPUtils.getBAPSource((ISource)combiBAPAudioSourceArray, (ISourceSlot)object2);
                if (object == null) continue;
                arrayList = (ArrayList)hashMap.get(Integers.valueOf(((CombiBAPAudioSource)object).getSourceType()));
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                    hashMap.put(Integers.valueOf(((CombiBAPAudioSource)object).getSourceType()), arrayList);
                }
                arrayList.add(object);
            }
        }
        int[] nArray = new int[hashMap.keySet().size()];
        combiBAPAudioSourceArray = new CombiBAPAudioSource[nArray.length][];
        int n = 0;
        object2 = hashMap.keySet().iterator();
        while (object2.hasNext()) {
            object = (Integer)object2.next();
            nArray[n] = (Integer)object;
            arrayList = (ArrayList)hashMap.get(object);
            combiBAPAudioSourceArray[n] = (CombiBAPAudioSource[])arrayList.toArray(new CombiBAPAudioSource[arrayList.size()]);
            ++n;
        }
        this.controller.updateSourceList(nArray, combiBAPAudioSourceArray);
        if (bl && null != combiBAPAudioSourceArray2) {
            this.controller.updateUSBSource();
        }
    }

    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        this.logger.log(100000000, "[%1.activeSourceChanged] '%2' (changed='%3')", (Object)LOGCLASS, (Object)activeSourceState, (Object)bl);
        if (bl) {
            this.controller.updateActiveSource(activeSourceState.getSlot());
        }
        if (this.controller.isStartupFinished() || activeSourceState.getState() != 1 && activeSourceState.getState() != 3) {
            this.controller.updateActiveSourceState(activeSourceState);
        } else {
            this.controller.setActiveSourceState(activeSourceState);
        }
    }

    public void sourceDeactivated() {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

