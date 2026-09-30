/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup.config;

import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.AppStateManager;
import de.audi.atip.startup.config.BundleToken;
import de.audi.atip.startup.config.Dependency;
import de.audi.atip.startup.config.Domain;
import de.audi.atip.startup.config.GuideModule;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class Component {
    private int lastmodeAppId;
    private int keyCode;
    private final String name;
    private int stateModelId;
    private boolean lastmodeAudio = false;
    private boolean lastmodeTransient = false;
    private GuideModule guideModule;
    private Domain domain;
    private BundleToken[] bundleTokens;
    private Component[] subComponents;
    private List dependencies;
    private boolean isReferenced = false;
    private boolean developmentOnly;
    private boolean pcSimOnly;
    private int audioContextID = -1;
    private final LogChannel lc;

    public Component(IConfigQuery iConfigQuery, int n, LogChannel logChannel) {
        ConfigValue configValue;
        this.lc = logChannel;
        this.name = iConfigQuery.getStringValue("name", "undefined");
        this.developmentOnly = iConfigQuery.getBooleanValue("development_only", false);
        this.pcSimOnly = iConfigQuery.getBooleanValue("pcsim_only", false);
        this.keyCode = iConfigQuery.getIntegerValue("key_code", 0);
        this.lastmodeAppId = iConfigQuery.getIntegerValue("lastmode_transient", -1);
        if (-1 == this.lastmodeAppId) {
            this.lastmodeAppId = iConfigQuery.getIntegerValue("lastmode_audio", -1);
            if (-1 == this.lastmodeAppId) {
                this.lastmodeAppId = iConfigQuery.getIntegerValue("lastmode", -1);
            } else {
                this.lastmodeAudio = true;
                this.audioContextID = iConfigQuery.getIntegerValue("audio_context", -1);
            }
        } else {
            this.lastmodeTransient = true;
        }
        this.stateModelId = iConfigQuery.getIntegerValue("state_model_id", 0);
        ConfigValue configValue2 = iConfigQuery.getValue("guide_module");
        if (configValue2 != null) {
            this.guideModule = new GuideModule(new ConfigPathQuery(configValue2));
        }
        if ((configValue = iConfigQuery.getValue("domain")) != null) {
            this.domain = new Domain(new ConfigPathQuery(configValue));
        }
        this.parseBundleTokens(iConfigQuery.getArray("bundles"), n);
        this.parseSubComponents(iConfigQuery.getArray("components"), n);
        this.parseDependencies(iConfigQuery.getArray("dependencies"));
    }

    static boolean checkMode(int n, int n2) {
        return (n & n2) == n2;
    }

    private void parseDependencies(ConfigValue configValue) {
        int n;
        if (configValue != null && (n = configValue.getArraySize()) > 0) {
            this.dependencies = new ArrayList(n);
            for (int i2 = 0; i2 < n; ++i2) {
                ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue.getArrayValue(i2));
                int n2 = configPathQuery.getIntegerValue("id", -1);
                String string = configPathQuery.getStringValue("comp_name");
                if (n2 != -1) {
                    int n3 = Long.decode(configPathQuery.getStringValue("required_state", "0x00")).intValue();
                    boolean bl = configPathQuery.getBooleanValue("start_asynchron", false);
                    this.dependencies.add(new Dependency(n2, n3, bl, null, false, false));
                    continue;
                }
                if (string == null) continue;
                this.dependencies.add(new Dependency(-1, -1, false, string, configPathQuery.getBooleanValue("stop_on_fail", false), configPathQuery.getBooleanValue("start_anyway", false)));
            }
        }
    }

    private void parseSubComponents(ConfigValue configValue, int n) {
        int n2;
        if (configValue != null && (n2 = configValue.getArraySize()) > 0) {
            this.subComponents = new Component[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                this.subComponents[i2] = new Component(new ConfigPathQuery(configValue.getArrayValue(i2)), n, this.lc);
            }
        }
    }

    private void parseBundleTokens(ConfigValue configValue, int n) {
        int n2;
        if (configValue != null && (n2 = configValue.getArraySize()) > 0) {
            int n3;
            ArrayList arrayList = new ArrayList(n2);
            for (n3 = 0; n3 < n2; ++n3) {
                BundleToken bundleToken = new BundleToken(new ConfigPathQuery(configValue.getArrayValue(n3)));
                if (bundleToken.isPcSimOnly() && !Component.checkMode(n, 2)) {
                    this.lc.log(1000000, "Component.parseBundleTokens(deviceMode:%1): skip PCSIM bundle '%2'", (Object)AppStateManager.deviceModeToString(n), (Object)bundleToken.getName());
                    continue;
                }
                if (bundleToken.isDevelopmentOnly() && !Component.checkMode(n, 1)) {
                    this.lc.log(1000000, "Component.parseBundleTokens(deviceMode:%1): skip DEVELOPMENT bundle '%2'", (Object)AppStateManager.deviceModeToString(n), (Object)bundleToken.getName());
                    continue;
                }
                arrayList.add(bundleToken);
            }
            this.bundleTokens = new BundleToken[arrayList.size()];
            for (n3 = 0; n3 < arrayList.size(); ++n3) {
                this.bundleTokens[n3] = (BundleToken)arrayList.get(n3);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public int getStateModelId() {
        return this.stateModelId;
    }

    public int getLastmodeAppId() {
        return this.lastmodeAppId;
    }

    public int getAudioConextID() {
        return this.audioContextID;
    }

    public boolean isLastmodeAudio() {
        return this.lastmodeAudio;
    }

    public boolean isLastmodeTransient() {
        return this.lastmodeTransient;
    }

    public boolean isLastmode() {
        return this.lastmodeAppId != -1;
    }

    public boolean isReferenced() {
        return this.isReferenced;
    }

    public boolean isDevelopmentOnly() {
        return this.developmentOnly;
    }

    public boolean isPcSimOnly() {
        return this.pcSimOnly;
    }

    public GuideModule getGuideModule() {
        return this.guideModule;
    }

    public Domain getDomain() {
        return this.domain;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    void setReferenced() {
        this.isReferenced = true;
    }

    public String[] getBundleNames() {
        String[] stringArray = new String[]{};
        if (this.bundleTokens != null && this.bundleTokens.length > 0) {
            stringArray = new String[this.bundleTokens.length];
            for (int i2 = 0; i2 < this.bundleTokens.length; ++i2) {
                stringArray[i2] = this.bundleTokens[i2].getName();
            }
        }
        return stringArray;
    }

    public int getSubComponentsNumber() {
        if (this.subComponents != null) {
            return this.subComponents.length;
        }
        return 0;
    }

    public Component getSubComponent(int n) {
        if (this.getSubComponentsNumber() > n) {
            return this.subComponents[n];
        }
        return null;
    }

    public void setSubComponent(Component component, int n) {
        if (this.getSubComponentsNumber() > n) {
            this.subComponents[n] = component;
        }
    }

    public List getAllDependencies() {
        return this.dependencies;
    }

    public List getComponentDependencies() {
        ArrayList arrayList = null;
        if (this.dependencies != null) {
            Iterator iterator = this.dependencies.iterator();
            while (iterator.hasNext()) {
                Dependency dependency = (Dependency)iterator.next();
                if (!dependency.isComponentDependency()) continue;
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(dependency);
            }
        }
        return arrayList;
    }

    public void removeDependencies(List list) {
        if (this.dependencies != null && list != null && !list.isEmpty()) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                this.dependencies.remove(iterator.next());
            }
            if (this.dependencies.isEmpty()) {
                this.dependencies = null;
            }
        }
    }

    public void removeSubComponents(List list) {
        if (this.subComponents != null && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.subComponents));
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                arrayList.remove(iterator.next());
            }
            if (arrayList.isEmpty()) {
                this.subComponents = null;
            } else {
                this.subComponents = new Component[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                    this.subComponents[i2] = (Component)arrayList.get(i2);
                }
            }
        }
    }
}

