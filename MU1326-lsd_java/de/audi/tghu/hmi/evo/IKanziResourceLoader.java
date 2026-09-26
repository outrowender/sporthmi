/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface IKanziResourceLoader {
    public static final int TYPE_TEMPLATE_NODE;
    public static final int TYPE_MERGE_PROJECT;
    public static final int TYPE_KZB_PATH;
    public static final int TYPE_MATERIAL;
    public static final int TYPE_MERGE_PROJECT_ASYNC;
    public static final int TYPE_TEMPLATE_NODE_2D;
    public static final int TYPE_MERGE_KZB_WITHOUT_LAYER;

    default public Object loadKanziResource(String string, Object object, int n) {
    }

    default public Object getKanziResourceFromCache(Object object, int n) {
    }
}

