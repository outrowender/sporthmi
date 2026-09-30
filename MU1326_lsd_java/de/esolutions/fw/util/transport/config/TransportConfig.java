/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.config;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TransportConfig {
    private static TransportConfig config;
    private boolean isValid;
    private String failString;
    private boolean doTraceConfig;
    private HashMap nodeServiceMap;
    private HashMap procServiceMap;
    private String[] allNodeNames;
    private HashMap myProcServiceMap;
    private String myProcName;
    private String myNodeName;
    private ArrayList myKeys;
    private String[] myServiceNames;
    private String[] allServiceNames;
    private SystemConfig sysConfig = SystemConfig.getInstance();

    public static TransportConfig getInstance() {
        if (config == null) {
            config = new TransportConfig();
        }
        return config;
    }

    private TransportConfig() {
        if (!this.sysConfig.isValid()) {
            this.failString = "No valid system config: " + this.sysConfig.getFailString();
            return;
        }
        this.doTraceConfig = this.sysConfig.doTraceConfig();
        long l = 0L;
        ITimeSource iTimeSource = null;
        if (this.doTraceConfig) {
            iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
            l = iTimeSource.getCurrentTime();
        }
        this.isValid = this.parse(this.sysConfig);
        if (this.doTraceConfig) {
            long l2 = iTimeSource.getCurrentTime();
            System.out.println("TransportConfig: parse time " + (l2 - l) + " ms");
        }
    }

    public SystemConfig getSystemConfig() {
        return this.sysConfig;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String getFailString() {
        return this.failString;
    }

    public String[] getMyServiceNames() {
        return this.myServiceNames;
    }

    public String[] getAllServiceNames() {
        return this.allServiceNames;
    }

    public String[] getAllNodeNames() {
        return this.allNodeNames;
    }

    public String[] getMyReachableNodes(String string) {
        Object[] objectArray;
        int n;
        String string2 = this.myProcName + ":" + string + ":";
        int n2 = string2.length();
        HashSet hashSet = new HashSet();
        for (n = 0; n < this.myKeys.size(); ++n) {
            objectArray = (Object[])this.myKeys.get(n);
            if (!objectArray.startsWith(string2)) continue;
            String string3 = objectArray.substring(n2);
            if (string3.equals("*")) {
                for (int i2 = 0; i2 < this.allNodeNames.length; ++i2) {
                    hashSet.add(this.allNodeNames[n]);
                }
                continue;
            }
            hashSet.add(string3);
        }
        n = hashSet.size();
        if (n == 0) {
            return null;
        }
        objectArray = new String[n];
        hashSet.toArray(objectArray);
        return objectArray;
    }

    public ConfigValue[] getDictsForService(String string, String string2) {
        if (this.doTraceConfig) {
            System.out.println("TransportConfig.getDictsForService: service=" + string + " remoteProc=" + string2);
        }
        String string3 = string2 + ":" + string + ":" + this.myNodeName;
        ConfigValue configValue = (ConfigValue)this.procServiceMap.get(string3);
        String string4 = string2 + ":" + string + ":*";
        ConfigValue configValue2 = (ConfigValue)this.procServiceMap.get(string4);
        if (this.doTraceConfig) {
            System.out.println("  lookup: key=" + string3 + " -> " + configValue);
            System.out.println("  lookup: key=" + string4 + " -> " + configValue2);
        }
        String string5 = this.sysConfig.getNodeForProc(string2);
        String string6 = string5 + ":" + string + ":" + this.myNodeName;
        ConfigValue configValue3 = (ConfigValue)this.nodeServiceMap.get(string6);
        String string7 = string5 + ":" + string + ":*";
        ConfigValue configValue4 = (ConfigValue)this.nodeServiceMap.get(string7);
        if (this.doTraceConfig) {
            System.out.println("  lookup: key=" + string6 + " -> " + configValue3);
            System.out.println("  lookup: key=" + string7 + " -> " + configValue4);
        }
        if (configValue == null && configValue2 == null && configValue3 == null && configValue4 == null) {
            return null;
        }
        return new ConfigValue[]{configValue, configValue2, configValue3, configValue4};
    }

    public ConfigValue[] getDictsForMyService(String string, String string2) {
        if (this.doTraceConfig) {
            System.out.println("TransportConfig.getDictsForMyService: service=" + string + " offeredNode=" + string2);
        }
        String string3 = this.myProcName + ":" + string + ":" + string2;
        ConfigValue configValue = (ConfigValue)this.myProcServiceMap.get(string3);
        String string4 = this.myProcName + ":" + string + ":*";
        ConfigValue configValue2 = (ConfigValue)this.myProcServiceMap.get(string4);
        if (this.doTraceConfig) {
            System.out.println("  lookup: key=" + string3 + " -> " + configValue);
            System.out.println("  lookup: key=" + string4 + " -> " + configValue2);
        }
        if (configValue == null && configValue2 == null) {
            return null;
        }
        String string5 = this.myNodeName + ":" + string + ":" + string2;
        ConfigValue configValue3 = (ConfigValue)this.nodeServiceMap.get(string5);
        String string6 = this.myNodeName + ":" + string + ":*";
        ConfigValue configValue4 = (ConfigValue)this.nodeServiceMap.get(string6);
        if (this.doTraceConfig) {
            System.out.println("  lookup: key=" + string5 + " -> " + configValue3);
            System.out.println("  lookup: key=" + string6 + " -> " + configValue4);
        }
        if (configValue == null && configValue2 == null && configValue3 == null && configValue4 == null) {
            return null;
        }
        return new ConfigValue[]{configValue, configValue2, configValue3, configValue4};
    }

    public ConfigOverlayPathQuery getQueryForService(String string, String string2) {
        ConfigValue[] configValueArray = this.getDictsForService(string, string2);
        if (configValueArray == null) {
            return null;
        }
        return new ConfigOverlayPathQuery(configValueArray);
    }

    public ConfigOverlayPathQuery getQueryForMyService(String string, String string2) {
        ConfigValue[] configValueArray = this.getDictsForMyService(string, string2);
        if (configValueArray == null) {
            return null;
        }
        return new ConfigOverlayPathQuery(configValueArray);
    }

    protected boolean parse(SystemConfig systemConfig) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        String[] stringArray;
        this.myProcName = systemConfig.getMyProcName();
        this.myNodeName = systemConfig.getMyNodeName();
        this.nodeServiceMap = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ConfigValue configValue = systemConfig.getNodesConfig();
        String[] stringArray2 = systemConfig.getAllNodeNames();
        for (int i2 = 0; i2 < stringArray2.length; ++i2) {
            String string = stringArray2[i2];
            stringArray = configValue.getDictValue(string);
            if (stringArray == null || !stringArray.isDictionary()) {
                this.failString = "Invalid node " + string;
                return false;
            }
            object5 = stringArray.getDictValue("transport");
            if (object5 == null || !((ConfigValue)object5).isDictionary()) {
                this.failString = "No 'transport' in node " + string;
                return false;
            }
            if (!string.equals("*")) {
                hashSet2.add(string);
            }
            String[] stringArray3 = ((ConfigValue)object5).getAllDictKeys();
            for (int i3 = 0; i3 < stringArray3.length; ++i3) {
                object4 = stringArray3[i3];
                hashSet.add(object4);
                object3 = ((ConfigValue)object5).getDictValue((String)object4);
                if (object3 == null || !((ConfigValue)object3).isDictionary()) {
                    this.failString = "Invalid 'service' " + string + ":" + (String)object4;
                    return false;
                }
                String[] stringArray4 = ((ConfigValue)object3).getAllDictKeys();
                for (int i4 = 0; i4 < stringArray4.length; ++i4) {
                    String string2 = stringArray4[i4];
                    object2 = ((ConfigValue)object3).getDictValue(string2);
                    if (object2 == null || !((ConfigValue)object2).isDictionary()) {
                        this.failString = "Invalid target 'node' in " + string + ":" + (String)object4 + ":" + string2;
                        return false;
                    }
                    object = string + ":" + (String)object4 + ":" + string2;
                    if (this.doTraceConfig) {
                        System.out.println("TransportConfig: node '" + (String)object + "' is " + object2);
                    }
                    this.nodeServiceMap.put(object, object2);
                    if (string2.equals("*")) continue;
                    hashSet2.add(string2);
                }
            }
        }
        this.procServiceMap = new HashMap();
        this.myProcServiceMap = new HashMap();
        this.myKeys = new ArrayList();
        ConfigValue configValue2 = systemConfig.getProcsConfig();
        int n = configValue2.getArraySize();
        stringArray = systemConfig.getAllProcNames();
        object5 = systemConfig.getMyProcName();
        for (int i5 = 0; i5 < n; ++i5) {
            ConfigValue configValue3 = configValue2.getArrayValue(i5);
            if (configValue3 == null || (object4 = configValue3.getDictValue("transport")) == null) continue;
            if (!((ConfigValue)object4).isDictionary()) {
                this.failString = "Invalid transport in proc " + stringArray[i5];
                return false;
            }
            object3 = stringArray[i5];
            boolean bl = ((String)object3).equals(object5);
            String[] stringArray5 = ((ConfigValue)object4).getAllDictKeys();
            if (bl) {
                this.myServiceNames = stringArray5;
            }
            for (int i6 = 0; i6 < stringArray5.length; ++i6) {
                object2 = stringArray5[i6];
                hashSet.add(object2);
                object = ((ConfigValue)object4).getDictValue((String)object2);
                if (object == null || !((ConfigValue)object).isDictionary()) {
                    this.failString = "Invalid 'service' " + (String)object2 + " in proc " + stringArray[i5];
                    return false;
                }
                String[] stringArray6 = ((ConfigValue)object).getAllDictKeys();
                for (int i7 = 0; i7 < stringArray6.length; ++i7) {
                    String string = stringArray6[i7];
                    ConfigValue configValue4 = ((ConfigValue)object).getDictValue(string);
                    if (configValue4 == null || !configValue4.isDictionary()) {
                        this.failString = "Invalid target 'node' in " + (String)object3 + ":" + (String)object2 + ":" + string;
                        return false;
                    }
                    String string3 = (String)object3 + ":" + (String)object2 + ":" + string;
                    if (bl) {
                        if (this.doTraceConfig) {
                            System.out.println("TransportConfig: mine '" + string3 + "' is " + configValue4);
                        }
                        this.myProcServiceMap.put(string3, configValue4);
                        this.myKeys.add(string3);
                    } else {
                        if (this.doTraceConfig) {
                            System.out.println("TransportConfig: '" + string3 + "' is " + configValue4);
                        }
                        this.procServiceMap.put(string3, configValue4);
                    }
                    if (string.equals("*")) continue;
                    hashSet2.add(string);
                }
            }
        }
        this.allServiceNames = new String[hashSet.size()];
        hashSet.toArray(this.allServiceNames);
        this.allNodeNames = new String[hashSet2.size()];
        hashSet2.toArray(this.allNodeNames);
        return true;
    }
}

