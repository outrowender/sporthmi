/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.eal.propertyType_t;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALException;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public class EALPropertyCache {
    private LogChannel lc;
    private final Map properties = new HashMap();
    private final Map textureProperties = new HashMap();

    public EALPropertyCache() {
        this.lc = IWidgetLogChannel.logChannel3DEngine;
    }

    private IProperty getProperty(INode iNode, String string) {
        IProperty iProperty;
        if (iNode == null) {
            this.lc.log(-1601830656, "EALPropertyCache#getProperty: node is null for key '%1'", (Object)string);
            return null;
        }
        Map map = (Map)this.properties.get(iNode);
        if (map != null && (iProperty = (IProperty)map.get(string)) != null) {
            return iProperty;
        }
        iProperty = iNode.getProperty(string);
        if (!iProperty.isValid()) {
            String string2 = iNode.getName();
            this.lc.log(10000, "EALPropertyCache#getProperty: could not create property for node '%1', key '%2'", (Object)string2, (Object)string);
            iProperty.dispose();
            return null;
        }
        this.insertPropertyIntoCache(iNode, string, iProperty);
        return iProperty;
    }

    private void insertPropertyIntoCache(INode iNode, String string, IProperty iProperty) {
        Map map = this.getPropertyMap(iNode);
        map.put(string, iProperty);
    }

    private Map getPropertyMap(INode iNode) {
        Map map = (Map)this.properties.get(iNode);
        if (map == null) {
            map = new HashMap();
            this.properties.put(iNode, map);
        }
        return map;
    }

    public boolean setProperty(INode iNode, String string, float f2) {
        if (!this.checkNode(iNode)) {
            return false;
        }
        IProperty iProperty = this.getProperty(iNode, string);
        if (iProperty == null) {
            return false;
        }
        if (iProperty.getFloat() == f2) {
            return true;
        }
        return iProperty.set(f2);
    }

    public boolean setProperty(INode iNode, String string, IMaterial iMaterial) {
        if (!this.checkNode(iNode)) {
            return false;
        }
        IProperty iProperty = this.getProperty(iNode, string);
        if (iProperty == null) {
            return false;
        }
        if (iMaterial == null) {
            iProperty.setDefault();
        }
        IMaterial iMaterial2 = iProperty.getMaterial();
        boolean bl = iMaterial2.equals(iMaterial);
        iMaterial2.dispose();
        if (bl) {
            return true;
        }
        return iProperty.set(iMaterial);
    }

    public boolean setProperty(INode iNode, String string, ITexture iTexture) {
        if (!this.checkNode(iNode)) {
            return false;
        }
        IProperty iProperty = this.getProperty(iNode, string);
        if (iProperty == null) {
            return false;
        }
        ITexture iTexture2 = iProperty.getTexture();
        boolean bl = iTexture2.equals(iTexture);
        iTexture2.dispose();
        if (bl) {
            return true;
        }
        this.addTextureProperty(iNode, string);
        if (iTexture == null) {
            return iProperty.setDefault();
        }
        return iProperty.set(iTexture);
    }

    private void addTextureProperty(INode iNode, String string) {
        Set set = (Set)this.textureProperties.get(iNode);
        if (set == null) {
            set = new HashSet(5);
            this.textureProperties.put(iNode, set);
        }
        set.add(string);
    }

    private boolean checkNode(INode iNode) {
        if (iNode == null) {
            if (this.lc.isDebug()) {
                this.lc.log(10000, "EALPropertyCache#checkNode node is null", (Throwable)new EALException("DebugStackTrace"));
            } else {
                this.lc.log(10000, "EALPropertyCache#checkNode node is null");
            }
            return false;
        }
        if (iNode.isDisposed()) {
            if (this.lc.isDebug()) {
                this.lc.log(10000, "EALPropertyCache#checkNode node is already disposed", (Throwable)new EALException("DebugStackTrace"));
            } else {
                this.lc.log(10000, "EALPropertyCache#checkNode node is already disposed");
            }
            return false;
        }
        return true;
    }

    private void clearTextureProperties(INode iNode) {
        boolean bl = this.checkNode(iNode);
        Set set = (Set)this.textureProperties.remove(iNode);
        if (set == null) {
            return;
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (bl) {
                IProperty iProperty = this.getProperty(iNode, string);
                if (iProperty == null) {
                    this.lc.log(10000, "EALPropertyCache#clearTextureProperties cannot get property to clear texture for key=%1", (Object)string);
                    continue;
                }
                if (iProperty.setDefault()) continue;
                this.lc.log(10000, "EALPropertyCache#clearTextureProperties cannot clear texture property for key=%1", (Object)string);
                continue;
            }
            this.lc.log(10000, "EALPropertyCache#clearTextureProperties key=%1", (Object)string);
        }
    }

    public boolean setPropertyWithoutChangeCheck(INode iNode, String string, boolean bl) {
        if (!this.checkNode(iNode)) {
            return false;
        }
        IProperty iProperty = this.getProperty(iNode, string);
        if (iProperty == null) {
            return false;
        }
        return iProperty.set(bl);
    }

    public boolean setProperty(INode iNode, String string, boolean bl) {
        if (!this.checkNode(iNode)) {
            return false;
        }
        IProperty iProperty = this.getProperty(iNode, string);
        if (iProperty == null) {
            return false;
        }
        if (iProperty.getBool() == bl) {
            return true;
        }
        return iProperty.set(bl);
    }

    public boolean setProperty(INode iNode, String string, colorRGBAf colorRGBAf2) {
        if (!this.checkNode(iNode)) {
            return false;
        }
        if (colorRGBAf2 == null) {
            this.lc.log(-1601830656, "EALPropertyCache#setProperty: color is null for key '%1'", (Object)string);
            return false;
        }
        IProperty iProperty = this.getProperty(iNode, string);
        if (iProperty == null) {
            return false;
        }
        colorRGBAf colorRGBAf3 = iProperty.getColor();
        boolean bl = this.equalsColor(colorRGBAf3, colorRGBAf2);
        if (bl) {
            return true;
        }
        return iProperty.set(colorRGBAf2);
    }

    public boolean setColorProperty(INode iNode, String string, int n) {
        if (!this.checkNode(iNode)) {
            return false;
        }
        IProperty iProperty = this.getProperty(iNode, string);
        if (iProperty == null) {
            return false;
        }
        int n2 = (int)iProperty.getColorAsInt();
        if (n2 == n) {
            return true;
        }
        return iProperty.setColor(n);
    }

    private boolean equalsColor(colorRGBAf colorRGBAf2, colorRGBAf colorRGBAf3) {
        if (colorRGBAf2 != null && colorRGBAf3 != null) {
            if (colorRGBAf2 == colorRGBAf3) {
                return true;
            }
            return colorRGBAf2.getFAlpha() == colorRGBAf3.getFAlpha() && colorRGBAf2.getFBlue() == colorRGBAf3.getFBlue() && colorRGBAf2.getFGreen() == colorRGBAf3.getFGreen() && colorRGBAf2.getFRed() == colorRGBAf3.getFRed();
        }
        return false;
    }

    public boolean setProperty(INode iNode, String string, float f2, float f3, float f4) {
        if (!this.checkNode(iNode)) {
            return false;
        }
        IProperty iProperty = this.getProperty(iNode, string);
        if (iProperty == null) {
            return false;
        }
        Vec3f vec3f = new Vec3f(f2, f3, f4);
        return iProperty.set(vec3f);
    }

    public void clearAll() {
        Iterator iterator = this.properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            INode iNode = (INode)map$Entry.getKey();
            boolean bl = this.checkNode(iNode);
            this.clearTextureProperties(iNode);
            String string = bl ? iNode.getName() : "<disposed node>";
            this.lc.log(-2137614336, "EALPropertyCache#clearAll: disposing properties from node '%1'", (Object)string);
            Map map = (Map)map$Entry.getValue();
            if (map == null) continue;
            Iterator iterator2 = map.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map$Entry map$Entry2 = (Map$Entry)iterator2.next();
                String string2 = (String)map$Entry2.getKey();
                IProperty iProperty = (IProperty)map$Entry2.getValue();
                if (iProperty == null) continue;
                this.lc.log(-2137614336, "EALPropertyCache#clearAll: disposing property '%1' from node '%2'", (Object)string2, (Object)string);
                iProperty.dispose();
            }
        }
        this.properties.clear();
    }

    public void clear(INode iNode) {
        String string;
        if (!this.checkNode(iNode)) {
            if (iNode == null) {
                return;
            }
            string = "<disposed node>";
        } else {
            string = iNode.getName();
        }
        this.clearTextureProperties(iNode);
        Map map = (Map)this.properties.remove(iNode);
        if (map == null) {
            this.lc.log(1078071040, "EALPropertyCache#clear: properties for node '%1' already cleared", (Object)string);
            return;
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string2 = (String)map$Entry.getKey();
            IProperty iProperty = (IProperty)map$Entry.getValue();
            if (iProperty == null) continue;
            this.lc.log(-2137614336, "EALPropertyCache#clear: disposing property '%1' from node '%2'", (Object)string2, (Object)string);
            iProperty.dispose();
        }
    }

    public boolean setProperty(IWrappedNode3D iWrappedNode3D, String string, float f2) {
        return this.setProperty((INode)iWrappedNode3D.getNode(), string, f2);
    }

    public boolean setColorProperty(IWrappedNode3D iWrappedNode3D, String string, int n) {
        if (iWrappedNode3D == null) {
            this.lc.log(-1601830656, "EALPropertyCache#setColorProperty: wrappedNode is null for key '%1'", (Object)string);
            return false;
        }
        return this.setColorProperty(iWrappedNode3D.getNode(), string, n);
    }

    public boolean setProperty(IWrappedNode3D iWrappedNode3D, String string, ITexture iTexture) {
        return this.setProperty((INode)iWrappedNode3D.getNode(), string, iTexture);
    }

    public boolean setProperty(IWrappedNode3D iWrappedNode3D, String string, boolean bl) {
        return this.setProperty((INode)iWrappedNode3D.getNode(), string, bl);
    }

    public boolean setProperty(IWrappedNode3D iWrappedNode3D, String string, colorRGBAf colorRGBAf2) {
        if (colorRGBAf2 == null) {
            this.lc.log(-1601830656, "EALPropertyCache#setProperty: color is null for key '%1'", (Object)string);
            return false;
        }
        if (iWrappedNode3D == null) {
            this.lc.log(-1601830656, "EALPropertyCache#setProperty: wrappedNode is null for key '%1'", (Object)string);
            return false;
        }
        return this.setProperty((INode)iWrappedNode3D.getNode(), string, colorRGBAf2);
    }

    public static boolean isPropertyAvailable(INode iNode, String string) {
        IProperty iProperty = iNode.getProperty(string);
        boolean bl = iProperty.isValid();
        iProperty.dispose();
        return bl;
    }

    public float getFloatProperty(IWrappedNode3D iWrappedNode3D, String string) {
        IProperty iProperty = this.tryToGetProperty(iWrappedNode3D, string, propertyType_t.PROPERTYTYPE_FLOAT);
        return iProperty.getFloat();
    }

    public colorRGBAf getColorProperty(IWrappedNode3D iWrappedNode3D, String string) {
        IProperty iProperty = this.tryToGetProperty(iWrappedNode3D, string, propertyType_t.PROPERTYTYPE_COLOR);
        return iProperty.getColor();
    }

    private IProperty tryToGetProperty(IWrappedNode3D iWrappedNode3D, String string, propertyType_t propertyType_t2) {
        IProperty iProperty = this.getProperty(iWrappedNode3D.getNode(), string);
        if (iProperty == null) {
            String string2 = new Buffer("No property '").append(string).append("' found for node ").append(iWrappedNode3D).toString();
            throw new IllegalArgumentException(string2);
        }
        if (iProperty.getType() != propertyType_t2) {
            String string3 = new Buffer("Property '").append(string).append("' of node ").append(iWrappedNode3D).append(" is of type ").append(iProperty.getType()).append(", not ").append(propertyType_t2).toString();
            throw new IllegalArgumentException(string3);
        }
        return iProperty;
    }
}

