/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface IKanziResourceLoader {
    public static final int TYPE_TEMPLATE_NODE = 1;
    public static final int TYPE_MERGE_PROJECT = 2;
    public static final int TYPE_KZB_PATH = 3;
    public static final int TYPE_MATERIAL = 4;
    public static final int TYPE_MERGE_PROJECT_ASYNC = 5;
    public static final int TYPE_TEMPLATE_NODE_2D = 6;
    public static final int TYPE_MERGE_KZB_WITHOUT_LAYER = 7;

    public Object loadKanziResource(String var1, Object var2, int var3);

    public Object getKanziResourceFromCache(Object var1, int var2);
}

