/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.tghu.hmi.evo.IKanziResourceLoader;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.CMergeInfo;
import de.esolutions.graphics.eal.FlagMerge;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITemplateNode2D;
import de.esolutions.graphics.eal.api.ITemplateNode3D;
import de.esolutions.graphics.eal.ealMergeFlag_t;
import de.esolutions.graphics.eal.merge_t;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedManagedNode;

public class KanziResourceLoaderMIB2High
implements IKanziResourceLoader,
IWidgetLogChannel {
    private static String kzbRoot;
    private final EALManager ealManager;
    private static final FlagMerge mergeFlags;
    private static final int LOADING_HINT_NONE;
    private static final int LOADING_HINT_PRELOAD;
    private static final int LOADING_HINT_MAP;
    private static final int LOADING_HINT_DEFAULT;

    public KanziResourceLoaderMIB2High(EALManager eALManager) {
        this.ealManager = eALManager;
        logChannel3DEngine.log(1078071040, "KanziResourceLoaderMIB2High loadingHint=%1", (Object)Integer.getInteger("ealMergeFlagLoadingHint", 1));
    }

    @Override
    public Object loadKanziResource(String string, Object object, int n) {
        logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Trying to load from kzb '%1' (type=%2)", (Object)string, (long)n);
        IProject iProject = this.getProject();
        if (iProject == null) {
            return null;
        }
        String string2 = new Buffer(kzbRoot.length() + string.length()).append(kzbRoot).append(string).toString();
        if (n == 7) {
            String string3 = string2;
            if (!iProject.merge(merge_t.MERGE_SYNCHRONOUS, string3, null, mergeFlags)) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not merge kzb '%1' in kzb '%2'", (Object)string2, (Object)string3);
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        if (n == 1) {
            String string4 = (String)object;
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Merging template node '%1'", (Object)string4);
            String string5 = string2;
            if (!iProject.merge(merge_t.MERGE_SYNCHRONOUS, string5, null, mergeFlags)) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not merge template '%1' in kzb '%2'", (Object)string4, (Object)string5);
                return null;
            }
            ITemplateNode3D iTemplateNode3D = iProject.getTemplateNode3D(string4);
            if (!iTemplateNode3D.isValid()) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not get template '%1'", (Object)string4);
                iTemplateNode3D.dispose();
                return null;
            }
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Template node merged");
            return iTemplateNode3D;
        }
        if (n == 2) {
            Integer n2 = (Integer)object;
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Merging project in kzb '%1' to layer", (Object)string, (Object)n2);
            String string6 = string2;
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Project loaded. Merging...");
            CMergeInfo cMergeInfo = new CMergeInfo();
            if (!iProject.merge(merge_t.MERGE_SYNCHRONOUS, string6, cMergeInfo, mergeFlags)) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not merge kzb '%1'", (Object)string6);
                return null;
            }
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Project merged.");
            String string7 = cMergeInfo.getPath();
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: screen main path in merge project: '%1'", (Object)string7);
            INode2D iNode2D = iProject.getNode2D(string7);
            if (!iNode2D.isValid()) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not load screen main path '%1' from kzb '%2'", (Object)string7, (Object)string6);
                iNode2D.dispose();
                return null;
            }
            IWrappedManagedNode iWrappedManagedNode = this.ealManager.getMasterRoot();
            if (!iWrappedManagedNode.getNode().isValid()) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not load master root while merging kzb '%1'", (Object)string6);
                iNode2D.dispose();
                return null;
            }
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Adding merged screen main to master root to layer %1", (Object)n2);
            if (!iWrappedManagedNode.addAuto(iNode2D, n2)) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not add merged screen main to master root while merging kzb '%1' to layer %2", (Object)string6, (Object)n2);
                iNode2D.dispose();
                return null;
            }
            return iNode2D;
        }
        if (n == 5) {
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Start async merging project in kzb '%1'", (Object)string);
            if (!iProject.merge(merge_t.MERGE_ASYNCHRONOUS, string2, null, mergeFlags)) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not start async merging project in kzb '%1'", (Object)string);
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        if (n == 3) {
            return string;
        }
        if (n == 4) {
            String[] stringArray = (String[])object;
            String string8 = stringArray[0];
            String string9 = stringArray[1];
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Loading material '%1', template '%2'", (Object)string9, (Object)string8);
            String string10 = string2;
            if (!iProject.merge(merge_t.MERGE_SYNCHRONOUS, string10, null, mergeFlags)) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not merge material '%1', template '%2' in kzb '%3'", (Object)string9, (Object)string8, (Object)string10);
                return null;
            }
            IMaterial iMaterial = iProject.getMaterial(string9);
            if (!iMaterial.isValid()) {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#loadKanziResource: Could not get material '%1'", (Object)string9);
                iMaterial.dispose();
                return null;
            }
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#loadKanziResource: Material merged");
            return iMaterial;
        }
        return null;
    }

    @Override
    public Object getKanziResourceFromCache(Object object, int n) {
        IProject iProject = this.getProject();
        if (iProject == null) {
            return null;
        }
        if (n == 1) {
            String string = (String)object;
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Trying to get template node '%1' from eal project", (Object)string);
            boolean bl = iProject.isPrefab(string);
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: node found: %1", bl);
            if (!bl) {
                return null;
            }
            ITemplateNode3D iTemplateNode3D = iProject.getTemplateNode3D(string);
            if (iTemplateNode3D.isValid()) {
                logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Returning template node '%1' from eal project", (Object)string);
                return iTemplateNode3D;
            }
            iTemplateNode3D.dispose();
            logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Template node '%1' not found in eal project", (Object)string);
        } else if (n == 6) {
            String string = (String)object;
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Trying to get 2d template node '%1' from eal project", (Object)string);
            boolean bl = iProject.isPrefab(string);
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: node found: ", bl);
            if (!bl) {
                return null;
            }
            ITemplateNode2D iTemplateNode2D = iProject.getTemplateNode2D(string);
            if (iTemplateNode2D.isValid()) {
                logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Returning 2d template node '%1' from eal project", (Object)string);
                return iTemplateNode2D;
            }
            iTemplateNode2D.dispose();
            logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: 2d template node '%1' not found in eal project", (Object)string);
        } else if (n == 4) {
            String[] stringArray = (String[])object;
            String string = stringArray[0];
            String string2 = stringArray[1];
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Trying to get material '%1', template '%2' from eal project", (Object)string2, (Object)string);
            boolean bl = iProject.isPrefab(string);
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: node found: ", bl);
            if (!bl) {
                return null;
            }
            ITemplateNode2D iTemplateNode2D = iProject.getTemplateNode2D(string);
            if (!iTemplateNode2D.isValid()) {
                logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Template node '%1' not found in eal project", (Object)string);
                iTemplateNode2D.dispose();
                return null;
            }
            iTemplateNode2D.dispose();
            logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Trying to get material '%1' from eal project", (Object)string2);
            IMaterial iMaterial = iProject.getMaterial(string2);
            if (iMaterial.isValid()) {
                logChannel3DEngine.log(-2137614336, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Returning material '%1' from eal project", (Object)string2);
                return iMaterial;
            }
            iMaterial.dispose();
            logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#getKanziResourceFromCache: Material '%1' not found in eal project", (Object)string2);
        }
        return null;
    }

    private IProject getProject() {
        if (this.ealManager == null) {
            return null;
        }
        return this.ealManager.getProject();
    }

    private static ealMergeFlag_t getMergeFlag(int n) {
        ealMergeFlag_t ealMergeFlag_t2;
        switch (n) {
            case 1: {
                ealMergeFlag_t2 = ealMergeFlag_t.EAL_MERGE_FLAG_LOADING_HINT_PRELOAD;
                break;
            }
            case 2: {
                ealMergeFlag_t2 = ealMergeFlag_t.EAL_MERGE_FLAG_LOADING_HINT_MAP;
                break;
            }
            case 0: {
                ealMergeFlag_t2 = ealMergeFlag_t.EAL_MERGE_FLAG_NONE;
                break;
            }
            default: {
                logChannel3DEngine.log(10000, "KanziResourceLoaderMIB2High#getMergeFlag unknown vmoption for %1: %2", (Object)"ealMergeFlagLoadingHint", (long)n);
                ealMergeFlag_t2 = ealMergeFlag_t.EAL_MERGE_FLAG_LOADING_HINT_PRELOAD;
            }
        }
        return ealMergeFlag_t2;
    }

    static {
        String string = System.getProperty("KzbRoot");
        kzbRoot = string == null ? "" : new StringBuffer().append(string).append("/").toString();
        int n = Integer.getInteger("ealMergeFlagLoadingHint", 1);
        ealMergeFlag_t ealMergeFlag_t2 = KanziResourceLoaderMIB2High.getMergeFlag(n);
        mergeFlags = new FlagMerge(ealMergeFlag_t2);
    }
}

