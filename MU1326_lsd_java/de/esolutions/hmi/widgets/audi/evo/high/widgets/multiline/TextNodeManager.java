/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.multiline;

import de.audi.atip.hmi.model.texteditor.MLUtils;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultilineTextFieldRendererHigh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class TextNodeManager {
    static final int CLIPPING_MODE;
    int textNodesIndex = 0;
    boolean initialised = false;
    ArrayList unusedTextNodes = null;
    HashMap usedTextNodes = null;
    ArrayList allAllocatedTextNodes = null;
    EALManager ealManager = null;
    IWrappedFont font = null;
    IWrappedNode3D parentNode;

    public static TextNodeManager newInstance(EALManager eALManager, MultilineTextFieldRendererHigh multilineTextFieldRendererHigh, IWrappedFont iWrappedFont, IWrappedNode3D iWrappedNode3D) {
        TextNodeManager textNodeManager = null;
        if (eALManager != null && multilineTextFieldRendererHigh != null && iWrappedFont != null && iWrappedFont.getFontGroup() != null && iWrappedFont.getFontGroup().isValid() && iWrappedNode3D != null && iWrappedNode3D.isValid()) {
            textNodeManager = new TextNodeManager(eALManager, multilineTextFieldRendererHigh, iWrappedFont, iWrappedNode3D);
        }
        return textNodeManager;
    }

    TextNodeManager(EALManager eALManager, IWrappedFont iWrappedFont) {
        this.ealManager = eALManager;
        this.font = iWrappedFont;
    }

    private TextNodeManager(EALManager eALManager, MultilineTextFieldRendererHigh multilineTextFieldRendererHigh, IWrappedFont iWrappedFont, IWrappedNode3D iWrappedNode3D) {
        this.ealManager = eALManager;
        this.font = iWrappedFont;
        this.parentNode = iWrappedNode3D;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TextNodeManager[allAllocatedTextNodes.size()=").append(this.allAllocatedTextNodes != null ? this.allAllocatedTextNodes.size() : 0);
        buffer.append("; # of usedTextNodes=").append(this.usedTextNodes != null ? TextNodeManager.countTextNodes(this.usedTextNodes) : 0);
        buffer.append("; unusedTextNodes.size()=").append(this.unusedTextNodes != null ? this.unusedTextNodes.size() : 0);
        buffer.append("; parentNode=").append(this.parentNode != null ? this.parentNode.getNodeName() : "null");
        buffer.append("]");
        return buffer.toString();
    }

    public void init() {
        if (!this.initialised) {
            this.textNodesIndex = 0;
            if (this.usedTextNodes == null) {
                this.usedTextNodes = new HashMap();
            }
            if (this.unusedTextNodes == null) {
                this.unusedTextNodes = new ArrayList();
            }
            if (this.allAllocatedTextNodes == null) {
                this.allAllocatedTextNodes = new ArrayList();
            }
            this.initialised = true;
        }
    }

    public void deinit() {
        if (this.initialised) {
            this.textNodesIndex = 0;
            if (this.usedTextNodes != null) {
                this.usedTextNodes.clear();
                this.usedTextNodes = null;
            }
            if (this.unusedTextNodes != null) {
                this.unusedTextNodes.clear();
                this.unusedTextNodes = null;
            }
            if (this.ealManager != null && this.allAllocatedTextNodes != null) {
                int n = this.allAllocatedTextNodes.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    IWrappedNode3DText iWrappedNode3DText = (IWrappedNode3DText)this.allAllocatedTextNodes.get(i2);
                    iWrappedNode3DText.setVisible(false);
                    this.ealManager.destroy(iWrappedNode3DText);
                }
                this.allAllocatedTextNodes.clear();
                this.allAllocatedTextNodes = null;
            }
            this.initialised = false;
        }
    }

    public void addTextNode(String string, HashMap hashMap, long l, int n, float f2) {
        Object object;
        if (!this.initialised) {
            return;
        }
        String string2 = new StringBuffer().append(string).append("").toString();
        if (IWidgetLogChannel.logMessagingMultilineRenderer.isDebug()) {
            object = new Buffer();
            ((Buffer)object).append("TextNodeManager#addTextNode ");
            ((Buffer)object).append(this);
            ((Buffer)object).append(" text.hashCode()=").append(string2.hashCode());
            ((Buffer)object).append("; textColor=").append(l);
            ((Buffer)object).append("; x=").append(n);
            ((Buffer)object).append("; y=").append(f2);
            IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, ((Buffer)object).toString());
        }
        IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#addTextNode node already at map: %1", (object = TextNodeManager.getTextNodeFromMap(this.usedTextNodes, string2)) != null);
        if (object == null) {
            IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#addTextNode unusedTextNode found: %1", (object = this.getUnusedTextNode((IWrappedNode3DText)object)) != null);
            if (object != null) {
                object.setText(string2, this.font);
            }
        }
        if (object == null && (object = this.createNewTextNode(string2)) != null) {
            object.setClippingInheritance(17);
            this.allAllocatedTextNodes.add(object);
            IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#addTextNode new node created text='%1', nodeName='%2'", (Object)string2, (Object)object.getNodeName());
        }
        if (object != null) {
            object.getInterfaceText().setColor(l);
            object.setPosition(n, MLUtils.specialRound(f2), 0.0f);
            object.setVisible(true);
            this.putTextNodeIntoMap(hashMap, string2, (IWrappedNode3DText)object);
            IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#addTextNode %1", object);
        }
        IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#addTextNode %1", (Object)this);
    }

    private IWrappedNode3DText createNewTextNode(String string) {
        String string2;
        IWrappedNode3DText iWrappedNode3DText;
        if ((iWrappedNode3DText = this.ealManager.createText3D(this.parentNode, string2 = EALManager.createNodeName("multilineTextfield_textLine", this.textNodesIndex++, null), string, this.font)) != null && iWrappedNode3DText.isValid()) {
            return iWrappedNode3DText;
        }
        this.ealManager.destroy(iWrappedNode3DText);
        IWidgetLogChannel.logMessagingMultilineRenderer.log(10000, "TextNodeManager#createNewTextNode: allocation failed");
        return null;
    }

    private IWrappedNode3DText getUnusedTextNode(IWrappedNode3DText iWrappedNode3DText) {
        if (!this.unusedTextNodes.isEmpty()) {
            iWrappedNode3DText = (IWrappedNode3DText)this.unusedTextNodes.remove(this.unusedTextNodes.size() - 1);
        }
        return iWrappedNode3DText;
    }

    public void purgeUsedNodes(HashMap hashMap) {
        if (!this.initialised) {
            return;
        }
        IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#purgeUsedNodes START %1", (Object)this);
        if (this.usedTextNodes != null) {
            Collection collection = this.usedTextNodes.values();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                Object object;
                Object object2 = iterator.next();
                if (object2 instanceof IWrappedNode3DText) {
                    object = (IWrappedNode3DText)object2;
                    object.setVisible(false);
                    this.unusedTextNodes.add(object);
                    continue;
                }
                if (object2 instanceof ArrayList) {
                    object = (ArrayList)object2;
                    for (int i2 = 0; i2 < ((ArrayList)object).size(); ++i2) {
                        IWrappedNode3DText iWrappedNode3DText = (IWrappedNode3DText)((ArrayList)object).get(i2);
                        iWrappedNode3DText.setVisible(false);
                    }
                    this.unusedTextNodes.addAll((Collection)object);
                    continue;
                }
                IWidgetLogChannel.logMessagingMultilineRenderer.log(10000, "TextNodeManager#purgeUsedNodes unknown node type obj=%1", object2);
            }
        }
        this.usedTextNodes = hashMap;
        IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#purgeUsedNodes END %1", (Object)this);
    }

    private static IWrappedNode3DText getTextNodeFromMap(HashMap hashMap, String string) {
        IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#getTextNodeFromMap::START countTxtNodes(map)=%2, map.size()=%3, key=%1", (Object)string, (long)TextNodeManager.countTextNodes(hashMap), (long)hashMap.size());
        IWrappedNode3DText iWrappedNode3DText = null;
        Object object = hashMap.get(string);
        IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#getTextNodeFromMap value=%1", object);
        if (object instanceof IWrappedNode3DText) {
            iWrappedNode3DText = (IWrappedNode3DText)object;
            hashMap.remove(string);
        } else if (object instanceof ArrayList) {
            ArrayList arrayList = (ArrayList)object;
            int n = arrayList.size();
            IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#getTextNodeFromMap:: ArrayList arraySize=%1", (long)n);
            if (n > 0) {
                iWrappedNode3DText = (IWrappedNode3DText)arrayList.remove(n - 1);
            } else {
                hashMap.remove(string);
            }
        } else {
            IWidgetLogChannel.logMessagingMultilineRenderer.log(10000, "TextNodeManager#getTextNodeFromMap unknown type value=%1", object);
        }
        IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#getTextNodeFromMap::END countTxtNodes(map)=%1, map.size()=%2", (long)TextNodeManager.countTextNodes(hashMap), (long)hashMap.size());
        return iWrappedNode3DText;
    }

    private void putTextNodeIntoMap(HashMap hashMap, String string, IWrappedNode3DText iWrappedNode3DText) {
        IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#putTextNodeIntoMap::START countTxtNodes(map)=%2, map.size()=%3, key=%1", (Object)string, (long)TextNodeManager.countTextNodes(hashMap), (long)hashMap.size());
        Object object = hashMap.get(string);
        if (object == null) {
            hashMap.put(string, iWrappedNode3DText);
            IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#putTextNodeIntoMap new value added");
        } else if (object instanceof IWrappedNode3DText) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(object);
            arrayList.add(iWrappedNode3DText);
            hashMap.put(string, arrayList);
            IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#putTextNodeIntoMap array created: %1", (Object)arrayList);
        } else if (object instanceof ArrayList) {
            ((ArrayList)object).add(iWrappedNode3DText);
            IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#putTextNodeIntoMap array extended: %1", object);
        }
        IWidgetLogChannel.logMessagingMultilineRenderer.log(-2137614336, "TextNodeManager#putTextNodeIntoMap::END countTxtNodes(map)=%1, map.size()=%2", (long)TextNodeManager.countTextNodes(hashMap), (long)hashMap.size());
    }

    public static int countTextNodes(HashMap hashMap) {
        int n = 0;
        Collection collection = hashMap.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object instanceof IWrappedNode3DText) {
                ++n;
                continue;
            }
            if (!(object instanceof ArrayList)) continue;
            n += ((ArrayList)object).size();
        }
        return n;
    }
}

