/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bap;

import org.dsi.ifc.base.DSIBase;

public interface DSIBAP
extends DSIBase {
    public static final String VERSION = "2.11.5";
    public static final int RT_GETBAPSTATE = 1000;
    public static final int RT_SETHMISTATE = 1001;
    public static final int RT_REQUEST = 1002;
    public static final int RT_REQUESTVOID = 1003;
    public static final int RT_REQUESTBYTESEQUENCE = 1004;
    public static final int RT_REQUESTERROR = 1005;
    public static final int RP_ACKNOWLEDGE = 2004;
    public static final int IN_INDICATION = 3000;
    public static final int IN_INDICATIONVOID = 3001;
    public static final int IN_INDICATIONBYTESEQUENCE = 3002;
    public static final int IN_INDICATIONERROR = 3003;
    public static final int IN_BAPSTATESTATUS = 3004;
    public static final int BAPREQUESTTYPE_DATASETGET_REQ = 0;
    public static final int BAPREQUESTTYPE_DATASET_REQ = 1;
    public static final int BAPREQUESTTYPE_DATAGET_REQ = 2;
    public static final int BAPREQUESTTYPE_START_REQ = 3;
    public static final int BAPREQUESTTYPE_STARTRESULT_REQ = 4;
    public static final int BAPREQUESTTYPE_ABORT_REQ = 5;
    public static final int BAPREQUESTTYPE_DATAACK_REQ = 6;
    public static final int BAPREQUESTTYPE_DATA_CNF = 7;
    public static final int BAPREQUESTTYPE_PROCESSING_REQ = 8;
    public static final int BAPREQUESTTYPE_RESULT_REQ = 9;
    public static final int BAPREQUESTTYPE_CHANGED_REQ = 10;
    public static final int BAPREQUESTTYPE_DATAACK_CNF = 11;
    public static final int BAPDATATYPE_INT8_DATATYPE = 0;
    public static final int BAPDATATYPE_INT16_DATATYPE = 1;
    public static final int BAPDATATYPE_INT32_DATATYPE = 2;
    public static final int BAPDATATYPE_BYTESEQUENCE_DATATYPE = 3;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATA = 0;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATAACK = 1;
    public static final int ACKNOWLEDGETYPE_PROPERTY_ERROR = 2;
    public static final int ACKNOWLEDGETYPE_ARRAY_DATA = 3;
    public static final int ACKNOWLEDGETYPE_ARRAY_CHANGED = 4;
    public static final int ACKNOWLEDGETYPE_ARRAY_ERROR = 5;
    public static final int ACKNOWLEDGETYPE_METHOD_PROCESSING = 6;
    public static final int ACKNOWLEDGETYPE_METHOD_RESULT = 7;
    public static final int ACKNOWLEDGETYPE_METHOD_ERROR = 8;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATASETGET = 9;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATASET = 10;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATAGET = 11;
    public static final int ACKNOWLEDGETYPE_PROPERTY_ACK = 12;
    public static final int ACKNOWLEDGETYPE_ARRAY_DATASETGET = 13;
    public static final int ACKNOWLEDGETYPE_ARRAY_DATASET = 14;
    public static final int ACKNOWLEDGETYPE_ARRAY_DATAGET = 15;
    public static final int ACKNOWLEDGETYPE_METHOD_START = 16;
    public static final int ACKNOWLEDGETYPE_METHOD_STARTRESULT = 17;
    public static final int ACKNOWLEDGETYPE_METHOD_ABORT = 18;
    public static final int ACKNOWLEDGETYPE_CACHE_DATAGET = 19;
    public static final int ACKNOWLEDGETYPE_SET_HMI_STATE = 20;
    public static final int BAPINDICATIONTYPE_DATASETGET_IND = 0;
    public static final int BAPINDICATIONTYPE_DATASET_IND = 1;
    public static final int BAPINDICATIONTYPE_DATAGET_IND = 2;
    public static final int BAPINDICATIONTYPE_START_IND = 3;
    public static final int BAPINDICATIONTYPE_STARTRESULT_IND = 4;
    public static final int BAPINDICATIONTYPE_ABORT_IND = 5;
    public static final int BAPINDICATIONTYPE_PROCESSING_CNF = 6;
    public static final int BAPINDICATIONTYPE_ACK_IND = 7;
    public static final int BAPINDICATIONTYPE_DATAACK_RSP = 8;
    public static final int BAPINDICATIONTYPE_DATA_RSP = 9;
    public static final int BAPINDICATIONTYPE_PROCESSING_IND = 10;
    public static final int BAPINDICATIONTYPE_RESULT_IND = 11;
    public static final int BAPINDICATIONTYPE_CHANGED_IND = 12;
    public static final int BAPINDICATIONTYPE_RESET_IND = 13;
    public static final int ERRORCODE_TRANSPORTMEDIANOTACCESSIBLE = 17;
    public static final int ERRORCODE_ILLEGALSEQUENCE = 18;
    public static final int ERRORCODE_SEQUENCENUMBER = 19;
    public static final int ERRORCODE_TIMEOUTSEGMENTATION = 20;
    public static final int ERRORCODE_OVERSIZESEGMENTATION = 21;
    public static final int ERRORCODE_BADDATALENGTH = 22;
    public static final int ERRORCODE_RECEIVEDDATALOST = 23;
    public static final int ERRORCODE_HEARTBEATTIMEOUT = 33;
    public static final int ERRORCODE_RETRYNOTSUCCESSFUL = 34;
    public static final int ERRORCODE_BUSY = 35;
    public static final int ERRORCODE_REQUESTTIMEOUT = 36;
    public static final int ERRORCODE_INCOMPATIBLEPROTOCOLVERSION = 50;
    public static final int ERRORCODE_INCOMPATIBLEDATASPECIFICATION = 51;
    public static final int ERRORCODE_CACHEINVALID_SENDBUFFERNOTINITIALIZED_GETALLMESSAGECORRUPTED = 52;
    public static final int ERRORCODE_INVALIDSTATE = 53;
    public static final int ERRORCODE_CACHENOTAVAILABLE = 54;
    public static final int ERRORCODE_INVALIDARG = 55;
    public static final int ERRORCODE_OUTOFRANGE = 65;
    public static final int ERRORCODE_NOTIMPLEMENTED_TEMPORARYNOTAVAILABLE = 66;
    public static final int ERRORCODE_MAXDATALENGTHEXCEEDED = 67;
    public static final int ERRORCODE_UNITMISMATCH = 68;
    public static final int ERRORCODE_METHODABORTED = 80;
    public static final int BAPSTACKSTATE_NOT_READY = 0;
    public static final int BAPSTACKSTATE_READY = 1;
    public static final int HMISTATE_NOT_READY = 0;
    public static final int HMISTATE_READY_INITIALIZING = 1;
    public static final int HMISTATE_READY_RUNNING = 2;

    public void getBAPState(int var1);

    public void setHMIState(int var1, int var2);

    public void request(int var1, int var2, int var3, int var4, int var5);

    public void requestVoid(int var1, int var2, int var3);

    public void requestByteSequence(int var1, int var2, int var3, byte[] var4);

    public void requestError(int var1, int var2, int var3);
}

