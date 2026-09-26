/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import java.util.Map;

public abstract class SLMRulesMap {
    private static Map map;

    protected SLMRulesMap() {
    }

    public Map getMap() {
        if (map == null) {
            map = this.createFilledMap();
        }
        return map;
    }

    protected abstract Map createFilledMap() {
    }
}

