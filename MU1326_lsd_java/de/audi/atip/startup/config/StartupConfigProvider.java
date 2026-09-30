/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup.config;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.AppStateManager;
import de.audi.atip.startup.config.Component;
import de.audi.atip.startup.config.Dependency;
import de.esolutions.fw.util.config.ConfigProvider;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class StartupConfigProvider
extends ConfigProvider {
    private final HashMap componentsMap = new HashMap(50, 1.0f);

    public StartupConfigProvider(LogChannel logChannel, int n) {
        super("hmi_startup", "../ATIPBaseEvoHigh/src/resources");
        ConfigOverlayPathQuery configOverlayPathQuery = new ConfigOverlayPathQuery(new ConfigValue[]{this.getRoot()});
        ConfigValue configValue = configOverlayPathQuery.getArray("components");
        if (configValue != null && configValue.getArraySize() > 0) {
            Object object;
            Component component;
            int n2 = configValue.getArraySize();
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < n2; ++i2) {
                component = new Component(new ConfigPathQuery(configValue.getArrayValue(i2)), n, logChannel);
                object = component.getName();
                if (component.isPcSimOnly() && !Component.checkMode(n, 2)) {
                    logChannel.log(1000000, "StartupConfigProvider(deviceMode:%1): skip PCSIM component '%2'", (Object)AppStateManager.deviceModeToString(n), object);
                    hashMap.put(object, component);
                    continue;
                }
                if (component.isDevelopmentOnly() && !Component.checkMode(n, 1)) {
                    logChannel.log(1000000, "StartupConfigProvider(deviceMode:%1): skip DEVELOPMENT component '%2'", (Object)AppStateManager.deviceModeToString(n), object);
                    hashMap.put(object, component);
                    continue;
                }
                this.componentsMap.put(object, component);
            }
            Iterator iterator = new HashSet(this.componentsMap.values()).iterator();
            while (iterator.hasNext()) {
                Component component2;
                Object object2;
                ArrayList arrayList;
                component = (Component)iterator.next();
                object = component.getComponentDependencies();
                if (object != null && !object.isEmpty()) {
                    arrayList = new ArrayList(1);
                    Iterator iterator2 = object.iterator();
                    while (iterator2.hasNext()) {
                        object2 = (Dependency)iterator2.next();
                        if (((Dependency)object2).getDependentComponentName() != null) {
                            component2 = (Component)this.componentsMap.get(((Dependency)object2).getDependentComponentName());
                            if (component2 != null) {
                                ((Dependency)object2).setDependentComponent(component2);
                                component2.setReferenced();
                                continue;
                            }
                            if (hashMap.get(((Dependency)object2).getDependentComponentName()) != null) {
                                logChannel.log(1000000, "StartupConfigProvider: skip dependent component '%1' of '%2'", (Object)((Dependency)object2).getDependentComponentName(), (Object)component.getName());
                            } else {
                                logChannel.log(1000000, "StartupConfigProvider: unknown name of dependent component '%1'", (Object)((Dependency)object2).getDependentComponentName());
                            }
                            arrayList.add(object2);
                            continue;
                        }
                        logChannel.log(10000, "StartupConfigProvider: undefined dependency of component '%1'", (Object)component.getName());
                    }
                    component.removeDependencies(arrayList);
                }
                if (component.getSubComponentsNumber() <= 0) continue;
                arrayList = new ArrayList(1);
                for (int i3 = 0; i3 < component.getSubComponentsNumber(); ++i3) {
                    object2 = component.getSubComponent(i3);
                    if (object2 != null) {
                        component2 = (Component)this.componentsMap.get(((Component)object2).getName());
                        if (component2 != null) {
                            component.setSubComponent(component2, i3);
                            component2.setReferenced();
                            continue;
                        }
                        if (hashMap.get(((Component)object2).getName()) != null) {
                            logChannel.log(1000000, "StartupConfigProvider: skip subcomponent '%1' of '%2'", (Object)((Component)object2).getName(), (Object)component.getName());
                        } else {
                            logChannel.log(1000000, "StartupConfigProvider: unknown name of subcomponent '%1'", (Object)((Component)object2).getName());
                        }
                        arrayList.add(object2);
                        continue;
                    }
                    logChannel.log(10000, "StartupConfigProvider: undefined subcomponent of component '%1'", (Object)component.getName());
                }
                component.removeSubComponents(arrayList);
            }
        } else {
            logChannel.log(10000, "StartupConfigProvider: no JSON components found!");
            throw new FrameworkException("StartupConfigProvider: no JSON components found! Framework start failed!");
        }
    }

    public Iterator getComponentsIterator() {
        return this.componentsMap.values().iterator();
    }

    public HashMap getComponentsMap() {
        return this.componentsMap;
    }

    public Component getComponent(String string) {
        return (Component)this.componentsMap.get(string);
    }
}

