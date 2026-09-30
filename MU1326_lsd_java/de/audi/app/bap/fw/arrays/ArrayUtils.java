/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.AbstractManagedListHandler;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.datatypes.ArrayHeader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {
    public static final int NOT_FOUND = -1;
    public static final int INDEX_SIZE_8BIT = 0;
    public static final int INDEX_SIZE_16BIT = 1;

    public static void prepareFullRangeUpdate(ArrayHeader arrayHeader, int n) {
        arrayHeader.setFullRangeUpdate(n != 0);
        arrayHeader.setRecordAddress(0);
    }

    public static void prepareElementInsertion(ArrayHeader arrayHeader, int n, int n2, int n3) {
        arrayHeader.mode.shift = true;
        arrayHeader.mode.arrayDirectionIsBackward = false;
        arrayHeader.mode.arrayPositionIsTransmitted = true;
        arrayHeader.mode.indexSize16BitForStartElements = n3 != 0;
        arrayHeader.setRecordAddress(15);
        arrayHeader.start = n;
        arrayHeader.elements = n2 + 1;
    }

    public static void prepareElementDeletion(ArrayHeader arrayHeader, int n, int n2, int n3) {
        arrayHeader.mode.shift = true;
        arrayHeader.mode.arrayDirectionIsBackward = true;
        arrayHeader.mode.arrayPositionIsTransmitted = true;
        arrayHeader.mode.indexSize16BitForStartElements = n3 != 0;
        arrayHeader.setRecordAddress(15);
        arrayHeader.start = n;
        arrayHeader.elements = n2;
    }

    public static void prepareElementChange(ArrayHeader arrayHeader, int n, int n2, int n3) {
        arrayHeader.mode.shift = false;
        arrayHeader.mode.arrayDirectionIsBackward = false;
        arrayHeader.mode.arrayPositionIsTransmitted = false;
        arrayHeader.mode.indexSize16BitForStartElements = n2 != 0;
        arrayHeader.setRecordAddress(n3);
        arrayHeader.start = n;
        arrayHeader.elements = 1;
    }

    public static void prepareElementBlockChange(ArrayHeader arrayHeader, int n, int n2, int n3, int n4, int n5) {
        arrayHeader.mode.shift = false;
        arrayHeader.mode.arrayDirectionIsBackward = false;
        arrayHeader.mode.arrayPositionIsTransmitted = true;
        arrayHeader.mode.indexSize16BitForStartElements = n3 != 0;
        arrayHeader.setRecordAddress(n4, n5);
        arrayHeader.start = n;
        arrayHeader.elements = n2 + 1;
    }

    public static CombiBAPArrayElement[] getListSection(LogChannel logChannel, CombiBAPArrayElement[] combiBAPArrayElementArray, int n, int n2, boolean bl, boolean bl2) {
        return ArrayUtils.getListSection(logChannel, Arrays.asList(combiBAPArrayElementArray), n, n2, bl, bl2);
    }

    public static CombiBAPArrayElement[] getListSection(LogChannel logChannel, List list, int n, int n2, boolean bl, boolean bl2) {
        if (list.isEmpty()) {
            return new CombiBAPArrayElement[0];
        }
        IndexRange indexRange = ArrayUtils.computeRange(logChannel, list, n, n2, bl, bl2);
        if (indexRange == null) {
            logChannel.log(100000, "[ArrayUtils#getListSection] error retrieving list section");
            return new CombiBAPArrayElement[0];
        }
        Object[] objectArray = new CombiBAPArrayElement[indexRange.getSize()];
        ArrayList arrayList = new ArrayList(10);
        arrayList.addAll(list.subList(indexRange.startIndex, indexRange.endIndex + 1));
        if (bl2) {
            Collections.reverse(arrayList);
        }
        arrayList.toArray(objectArray);
        return objectArray;
    }

    private static IndexRange computeRange(LogChannel logChannel, List list, int n, int n2, boolean bl, boolean bl2) {
        int n3 = list.size();
        int n4 = ArrayUtils.getIndexInList(list, n);
        if (n4 == -1) {
            logChannel.log(100000, "[ArrayUtils#computeRange] invalid BAP request sent by cluster: startPosID=%1 not found in list", (long)n);
            return null;
        }
        if (n4 == 0 && n != 0 && bl && bl2) {
            logChannel.log(10000000, "[ArrayUtils#computeRange] empty range because startPosID refers to first element but shift and reverse are set", (long)n);
            return null;
        }
        return ArrayUtils.computeRange(logChannel, n3, n4, n2, bl, bl2);
    }

    public static IndexRange computeRange(LogChannel logChannel, int n, int n2, int n3, boolean bl, boolean bl2) {
        return ArrayUtils.computeRange(logChannel, n, n2, 0, n3, bl, bl2);
    }

    public static IndexRange computeRange(LogChannel logChannel, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5;
        int n6 = ArrayUtils.getStartIndex(n, n2, n3, bl, bl2);
        if (bl2) {
            n5 = n6;
            n6 = n5 - (n4 - 1);
        } else {
            n5 = n6 + (n4 - 1);
        }
        if (n6 >= n) {
            logChannel.log(10000, "[ArrayUtils#computeRange] invalid BAP request sent by cluster: startIndex=%1 exceeds list size (%2)", (long)n6, (long)n);
            return null;
        }
        if (n6 < 0) {
            n6 = 0;
        }
        if (n5 >= n) {
            n5 = n - 1;
        }
        return new IndexRange(n6, n5);
    }

    private static int getStartIndex(int n, int n2, int n3, boolean bl, boolean bl2) {
        int n4;
        if (n2 == 0 && bl2 && bl) {
            n4 = n - 1 - n3;
        } else if (bl2) {
            int n5 = n4 = bl ? n2 - 1 : n2;
            if ((n4 -= n3) < 0) {
                n4 = 0;
            }
        } else {
            n4 = bl ? n2 + 1 : n2;
            n4 += n3;
        }
        return n4;
    }

    public static CombiBAPArrayElement findElementByID(CombiBAPArrayElement[] combiBAPArrayElementArray, int n) {
        if (combiBAPArrayElementArray != null) {
            for (int i2 = 0; i2 < combiBAPArrayElementArray.length; ++i2) {
                if (combiBAPArrayElementArray[i2] == null || combiBAPArrayElementArray[i2].getPosID() != n) continue;
                return combiBAPArrayElementArray[i2];
            }
        }
        return null;
    }

    public static int getIndexInList(List list, int n) {
        if (list.isEmpty()) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            CombiBAPArrayElement combiBAPArrayElement = (CombiBAPArrayElement)list.get(i2);
            if (combiBAPArrayElement.getPosID() != n) continue;
            return i2;
        }
        return -1;
    }

    public static int getIndexInList(CombiBAPArrayElement[] combiBAPArrayElementArray, int n) {
        if (n == 0) {
            return 0;
        }
        for (int i2 = 0; i2 < combiBAPArrayElementArray.length; ++i2) {
            if (combiBAPArrayElementArray[i2].getPosID() != n) continue;
            return i2;
        }
        return -1;
    }

    public static int getPosID(CombiBAPArrayElement[] combiBAPArrayElementArray, int n) {
        if (n >= 0 && n < combiBAPArrayElementArray.length && combiBAPArrayElementArray[n] != null) {
            return combiBAPArrayElementArray[n].getPosID();
        }
        return -1;
    }

    public static String printList(ArrayHandler arrayHandler) {
        if (arrayHandler instanceof AbstractManagedListHandler) {
            return ArrayUtils.printList(((AbstractManagedListHandler)arrayHandler).getManagedList());
        }
        Buffer buffer = new Buffer();
        buffer.append("List contains ");
        buffer.append(arrayHandler.getCurrentListSize());
        buffer.append(" elements");
        return buffer.toString();
    }

    public static String printList(Object[] objectArray) {
        if (objectArray == null || objectArray.length == 0) {
            return "List is empty\n";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            buffer.append(i2);
            buffer.append(": ");
            buffer.append(objectArray[i2]);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public static class IndexRange {
        public int startIndex;
        public int endIndex;

        private IndexRange(int n, int n2) {
            this.startIndex = n;
            this.endIndex = n2;
        }

        public int getSize() {
            return this.endIndex - this.startIndex + 1;
        }
    }
}

