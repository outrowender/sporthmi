/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.audi.remotehmi.util.EnumHelper$1;
import de.audi.remotehmi.util.EnumParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnumHelper {
    private final List instanceList = new ArrayList();
    private final List instanceListUnmodifiable = Collections.unmodifiableList(this.instanceList);
    private final Map instanceMap = new HashMap();
    private final EnumParser parser = new EnumHelper$1(this);

    public void addInstance(String string, Object object) {
        if (this.instanceMap.containsKey(string)) {
            throw new IllegalArgumentException(new StringBuffer().append("enum is already added: ").append(string).toString());
        }
        this.instanceList.add(object);
        this.instanceMap.put(string, object);
    }

    public List values() {
        return this.instanceListUnmodifiable;
    }

    public final Object valueOf(String string) {
        Object object = this.instanceMap.get(string);
        if (object == null) {
            throw new IllegalArgumentException(new StringBuffer().append("'").append(string).append("' is not a valid enum instance!").toString());
        }
        return object;
    }

    public EnumParser getParser() {
        return this.parser;
    }

    static /* synthetic */ Map access$000(EnumHelper enumHelper) {
        return enumHelper.instanceMap;
    }
}

