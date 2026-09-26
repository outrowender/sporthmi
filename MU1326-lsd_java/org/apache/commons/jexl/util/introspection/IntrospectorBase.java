/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util.introspection;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.jexl.util.introspection.ClassMap;

public class IntrospectorBase {
    protected Map classMethodMaps = new HashMap();
    protected Set cachedClassNames = new HashSet();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Method getMethod(Class clazz, String string, Object[] objectArray) {
        if (clazz == null) {
            throw new Exception(new StringBuffer().append("Introspector.getMethod(): Class method key was null: ").append(string).toString());
        }
        ClassMap classMap = null;
        Map map = this.classMethodMaps;
        synchronized (map) {
            classMap = (ClassMap)this.classMethodMaps.get(clazz);
            if (classMap == null) {
                if (this.cachedClassNames.contains(clazz.getName())) {
                    this.clearCache();
                }
                classMap = this.createClassMap(clazz);
            }
        }
        return classMap.findMethod(string, objectArray);
    }

    protected ClassMap createClassMap(Class clazz) {
        ClassMap classMap = new ClassMap(clazz);
        this.classMethodMaps.put(clazz, classMap);
        this.cachedClassNames.add(clazz.getName());
        return classMap;
    }

    protected void clearCache() {
        this.classMethodMaps.clear();
        this.cachedClassNames = new HashSet();
    }
}

