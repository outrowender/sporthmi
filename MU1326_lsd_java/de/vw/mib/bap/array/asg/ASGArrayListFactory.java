/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg;

import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface ASGArrayListFactory {
    public BAPGetArray createGetArrayRequest(ASGArrayList var1);

    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList var1);

    public BAPArrayElement createEmptyElement(ASGArrayList var1);

    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList var1, BAPArrayElement var2, BAPArrayElement var3, int var4);

    public Timer createTimer(ASGArrayList var1, TimerNotifier var2, long var3);
}

