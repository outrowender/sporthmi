/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config;

import de.esolutions.fw.util.config.Config;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConfigProviderLegacy {
    private static final boolean TRACING_ENABLED = Boolean.getBoolean("trace.config");
    private static final String SYSPROP_CONFIGDIR = "config.dir";
    private static final String DEFAULT_CONFIGDIR = "config";
    private static final String SYSPROP_CONFIG_PREFIX = "config.file.";
    private static final String CONFIG_SUFFIX = ".properties";
    private static ConfigProviderLegacy provider;
    private Map configMap = new HashMap();
    private String configDirName = System.getProperty("config.dir", "config");

    public static ConfigProviderLegacy getInstance() {
        if (provider == null) {
            provider = new ConfigProviderLegacy();
        }
        return provider;
    }

    private ConfigProviderLegacy() {
    }

    public Config getConfig(String string) {
        if (TRACING_ENABLED) {
            System.out.println("[CONFIG] Config for following domain requested: " + string);
        }
        Config config = null;
        if (this.configMap.containsKey(string)) {
            config = (Config)this.configMap.get(string);
        } else {
            String string2 = this.configDirName + File.separator + string + CONFIG_SUFFIX;
            String string3 = System.getProperty(SYSPROP_CONFIG_PREFIX + string, string2);
            if (TRACING_ENABLED) {
                System.out.println("[CONFIG] Load config file: " + string3);
            }
            config = new Config(string, string3);
            this.configMap.put(string, config);
        }
        return config;
    }
}

