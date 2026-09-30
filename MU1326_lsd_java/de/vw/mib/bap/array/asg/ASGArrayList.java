/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg;

import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface ASGArrayList {
    public static final int ARRAY_ERROR_CODE_REQUEST_TIME_OUT = -1;
    public static final int ARRAY_ERROR_CODE_HEART_BEAT_TIME_OUT = -2;
    public static final int ARRAY_ERROR_CODE_MAX_DATA_LENGTH_EXCEEDED = -3;
    public static final int ARRAY_ERROR_CODE_TEMPORARY_NOT_AVAILABLE = -4;
    public static final int HIGH_LEVEL_RETRY_TYPE_A = 0;
    public static final int HIGH_LEVEL_RETRY_TYPE_B = 1;

    public void changedArray(BAPChangedArray var1);

    public void statusArray(BAPStatusArray var1);

    public void error(int var1);

    public void insertArrayElements(BAPArrayDataList var1, int var2, int var3);

    public void deleteArrayElements(BAPArrayDataList var1, int var2);

    public void modifyArrayElement(BAPArrayElement var1, int var2);

    public void reloadData();

    public void refreshElements(BAPArrayElement var1, int var2, int var3);

    public void stopFetchingData();

    public void clearList();

    public boolean isLoading();

    public boolean isLoadingError();

    public boolean isModifyRequestPending();

    public int getListId();

    public int getAsgId();

    public int size();

    public int getBapArrayListSize();

    public int getHighLevelRetryType();

    public BAPArrayElement get(int var1);

    public BAPArrayDataList getElements(int var1, int var2);

    public BAPArrayDataList getAllElements();

    public ASGArrayListDelegate getDelegate();

    public ASGArrayListChangeNotifier getChangeNotifier();

    public ASGArrayListFactory getFactory();
}

