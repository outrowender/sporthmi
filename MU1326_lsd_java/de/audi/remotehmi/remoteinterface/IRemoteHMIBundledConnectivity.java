/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.remoteinterface;

public interface IRemoteHMIBundledConnectivity {
    public static final int ESIM_DATA_BALANCE_LOW = 1;
    public static final int ESIM_DATA_BALANCE_EMPTY = 2;
    public static final int ESIM_DATA_BALANCE_EXPIRING = 3;
    public static final int ESIM_DATA_BALANCE_EXPIRED = 4;
    public static final String PROPERTY_JOB_NAME = "RemoteHMIBundledConnectivityJobName";
    public static final String DEFAULT_JOB_NAME = "NotifyCustomerDataPlanJob";
    public static final String PROPERTY_XSD_VERSION = "RemoteHMIBundledConnectivityXSDVersion";
    public static final String DEFAULT_XSD_VERSION = "v1_1_0";
    public static final String PROPERTY_XSD_NAME = "RemoteHMIBundledConnectivityXSDName";
    public static final String DEFAULT_XSD_NAME = "notifyCustomerDataplanJob_v1_1_0";
    public static final String POPUP_TYPE_NAME = "PopupType";
    public static final String POPUP_SERVICE_ID_NAME = "PopupServiceId";
    public static final int SERVICE_TYPE_DEFAULT = 0;
    public static final int SERVICE_TYPE_SHOW_DASHBOARD = 1;
    public static final int SERVICE_TYPE_BUY_NEW_DATAPLAN = 2;
    public static final boolean ESIM_DEFAULT_STATUS = false;
    public static final String ICCID_DEFAULT_VALUE = "undefined";
    public static final String IMSI_DEFAULT_VALUE = "undefined";
    public static final String PARAMETER_PAYLOAD = "payload";
    public static final String DIAGNOSIS_UI_PARAMETER_JOBTYPE = "diagnosisUIParameterJobType";
    public static final String DIAGNOSIS_UI_PARAMETER_ENABLE_APP_START = "diagnosisUIParameterEnableAppStart";
    public static final String DIAGNOSIS_UI_PARAMETER_IGNORE_ESIM_STATUS = "diagnosisUIParameterIgnoreEsimStatus";
    public static final String DIAGNOSIS_UI_POPUP_SERVICE_ID_VALUE = "dataplan_v1";
}

