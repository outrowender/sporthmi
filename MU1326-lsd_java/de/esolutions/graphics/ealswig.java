/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics;

import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode3DCamera;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.ealswigConstants;
import de.esolutions.graphics.ealswigJNI;

public class ealswig
implements ealswigConstants {
    public static INode getINodeByPath(IProject iProject, String string) {
        long l = ealswigJNI.getINodeByPath(IProject.getCPtr(iProject), iProject, string);
        return l == 0L ? null : new INode(l, false);
    }

    public static boolean setVisible(IProject iProject, String string, boolean bl) {
        return ealswigJNI.setVisible(IProject.getCPtr(iProject), iProject, string, bl);
    }

    public static boolean setTexture(IProject iProject, String string, String string2) {
        return ealswigJNI.setTexture(IProject.getCPtr(iProject), iProject, string, string2);
    }

    public static boolean createPixelPerfect(INode3DCamera iNode3DCamera, long l, long l2) {
        return ealswigJNI.createPixelPerfect(INode3DCamera.getCPtr(iNode3DCamera), iNode3DCamera, l, l2);
    }

    public static colorRGBAf RGBAtoRGBAf(long l) {
        return new colorRGBAf(ealswigJNI.RGBAtoRGBAf(l), true);
    }

    public static colorRGBAf ARGBtoRGBAf(long l) {
        return new colorRGBAf(ealswigJNI.ARGBtoRGBAf(l), true);
    }

    public static long toRGBAUint32(colorRGBAf colorRGBAf2) {
        return ealswigJNI.toRGBAUint32(colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public static long toARGBUint32(colorRGBAf colorRGBAf2) {
        return ealswigJNI.toARGBUint32(colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }
}

