/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.cc.IComponentConditionManager;
import de.audi.atip.hmi.event.ComponentConditionEvent;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.PropertyObject;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DrawerConditionEngine
implements IDrawerConditionEngine,
ServiceTrackerCustomizer {
    private HMITerminalEvo terminal = null;
    private int terminalID = 0;
    private BundleContext bundleContext = null;
    private ServiceTracker serviceTracker;
    private IComponentConditionManager componentConditionManager = null;
    private DrawerController drawerController = null;
    private long[] contextIDs = null;
    private Map visibleEntries = new HashMap(75);
    private Map visibleEntriesInContext = new HashMap(75);
    private Map visibleNotContextSpecificEntries = new HashMap(75);
    private int targetModelID = -1;
    private int targetRow = 0;
    private int targetWidgetID = -1;
    private IRightDrawerActionReceiver targetActionReceiver = null;
    private IFocusedPropertyObject focusedProperty = null;
    static /* synthetic */ Class class$de$audi$atip$hmi$cc$IComponentConditionManager;
    static /* synthetic */ Class class$de$audi$atip$hmi$IDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$hmi$IDrawerCategory;
    static /* synthetic */ Class class$de$audi$atip$hmi$IDrawerFocus;

    public DrawerConditionEngine(HMITerminalEvo hMITerminalEvo, IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        this.terminal = hMITerminalEvo;
        this.terminalID = hMITerminalEvo.getTerminalID();
        this.bundleContext = bundleContext;
        String[] stringArray = new String[]{(class$de$audi$atip$hmi$cc$IComponentConditionManager == null ? (class$de$audi$atip$hmi$cc$IComponentConditionManager = DrawerConditionEngine.class$("de.audi.atip.hmi.cc.IComponentConditionManager")) : class$de$audi$atip$hmi$cc$IComponentConditionManager).getName()};
        if (bundleContext != null) {
            this.serviceTracker = new ServiceTracker(bundleContext, stringArray, (ServiceTrackerCustomizer)this);
            this.serviceTracker.open();
        } else {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000, "DrawerConditionEngine#constructor bundleContext is null, can not open service tracker, sidebar entries might be wrong");
        }
    }

    public void activateDrawer(IDrawerControllerEvo iDrawerControllerEvo, long[] lArray) {
        long[] lArray2 = this.contextIDs;
        this.contextIDs = lArray;
        if (IWidgetLogChannel.logDrawerCondtionEngine.isDebug()) {
            int n;
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#activateDrawer previousContextIDs: %1, new contextIDs: %2", (Object)lArray2, (Object)lArray);
            Buffer buffer = new Buffer(30);
            buffer.append("previousContextIDs:");
            if (lArray2 != null) {
                for (n = 0; n < lArray2.length; ++n) {
                    buffer.append(lArray2[n]);
                    buffer.append(';');
                }
            }
            buffer.append("\n");
            if (lArray != null) {
                buffer.append("contextIDs:");
                for (n = 0; n < lArray.length; ++n) {
                    buffer.append(lArray[n]);
                    buffer.append(';');
                }
            }
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#activateDrawer %1", (Object)buffer);
        }
        if (this.drawerController != null) {
            if (this.drawerController.equals(iDrawerControllerEvo)) {
                IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#activateDrawer new and old drawerController are the same, refresh the current one");
                this.refreshDrawerContextID(lArray2, lArray);
            } else {
                IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#activateDrawer deactivate previous drawer, activate new drawerController if there is one, newDrawerController: %1", (Object)this.drawerController);
                this.deactivatePreviousDrawerController();
                if (iDrawerControllerEvo != null) {
                    this.activateNewDrawer(iDrawerControllerEvo);
                }
            }
        } else if (iDrawerControllerEvo != null) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#activateDrawer there is no previousDrawerController - activate the new one if there is one");
            this.activateNewDrawer(iDrawerControllerEvo);
        } else {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#activateDrawer no new and no previous drawer controller - do nothing");
        }
    }

    private void refreshDrawerContextID(long[] lArray, long[] lArray2) {
        IComponentConditionManager iComponentConditionManager = this.componentConditionManager;
        if (iComponentConditionManager == null) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000, "DrawerConditionEngine#refreshDrawerContextID componentConditionManager is null - sidebar elements cannot be enabled or set invisible");
            return;
        }
        this.visibleEntriesInContext.clear();
        this.visibleNotContextSpecificEntries.clear();
        Set set = this.visibleEntries.keySet();
        IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#refreshDrawerContextID visibleEntriesSize: %1", (long)set.size());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            PropertyObject propertyObject = (PropertyObject)iterator.next();
            if (propertyObject.getType() == 2) {
                this.visibleEntriesInContext.put(propertyObject, null);
                this.visibleNotContextSpecificEntries.put(propertyObject, null);
                continue;
            }
            int[] nArray = propertyObject.getContextIDs();
            int n = 0;
            if (nArray != null) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    int n2;
                    if (lArray != null) {
                        for (n2 = 0; n2 < lArray.length; ++n2) {
                            if ((long)nArray[i2] != lArray[n2]) continue;
                            n |= 1;
                        }
                    }
                    if (lArray2 == null) continue;
                    for (n2 = 0; n2 < lArray2.length; ++n2) {
                        if ((long)nArray[i2] != lArray2[n2]) continue;
                        n |= 2;
                    }
                }
            }
            if (n == 1) {
                propertyObject.getWidget().setVisible(false);
            } else if (n == 2) {
                AbstractWidget abstractWidget = propertyObject.getWidget();
                abstractWidget.setVisible(true);
                this.visibleEntriesInContext.put(propertyObject, null);
                if (propertyObject.getType() != 0) {
                    this.visibleNotContextSpecificEntries.put(propertyObject, null);
                }
                this.setEnabledState(iComponentConditionManager, propertyObject);
            } else if (n == 3) {
                this.visibleEntriesInContext.put(propertyObject, null);
                if (propertyObject.getType() != 0) {
                    this.visibleNotContextSpecificEntries.put(propertyObject, null);
                }
                this.setEnabledState(iComponentConditionManager, propertyObject);
            }
            if (!IWidgetLogChannel.logDrawerCondtionEngine.isDebug()) continue;
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#refreshDrawerContextID widget:%1 visibleCCID: %2 bitfieldVisibility: %3", (Object)propertyObject.getWidget(), (long)propertyObject.getVisibleCCID(), (long)n);
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#refreshDrawerContextID isVisible: %1, isEnabled: %2", this.evaluateCondition(propertyObject.getVisibleCCID(), iComponentConditionManager), this.evaluateCondition(propertyObject.getEnabledCCID(), iComponentConditionManager));
        }
        IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#refreshDrawerContextID end of refresh visibleEntriesInContext: %1", (long)this.visibleEntriesInContext.size());
    }

    private void setEnabledState(IComponentConditionManager iComponentConditionManager, PropertyObject propertyObject) {
        int n = propertyObject.getEnabledCCID();
        boolean bl = this.evaluateCondition(n, iComponentConditionManager) ? true : n == -1;
        AbstractWidget abstractWidget = propertyObject.getWidget();
        abstractWidget.setEnabled(bl);
    }

    private boolean evaluateCondition(int n, IComponentConditionManager iComponentConditionManager) {
        if (n == -2) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#evaluateCondition CCM#isTrue ignored. Constant is used for ccid: %1", (long)n);
            return true;
        }
        return iComponentConditionManager.isTrue(n, this.terminalID);
    }

    private void evaluateDeactivation(int n, IComponentConditionManager iComponentConditionManager) {
        if (n != -2) {
            iComponentConditionManager.deactivateCC(n);
        } else {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#evaluateDeactivation CCM did not deactivate ccid: %1, constant is used.", (long)n);
        }
    }

    private void evaluateActivation(int n, IComponentConditionManager iComponentConditionManager) {
        if (n != -2) {
            iComponentConditionManager.activateCC(n);
        } else {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#evaluateActivation CCM did not activated ccid: %1, constant is used.", (long)n);
        }
    }

    private void deactivatePreviousDrawerController() {
        IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#deactivatePreviousDrawerController");
        IComponentConditionManager iComponentConditionManager = this.componentConditionManager;
        if (iComponentConditionManager == null) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000, "DrawerConditionEngine#deactivatePreviousDrawerController componentConditionManager is null - sidebar elements cannot be enabled or set invisible");
            return;
        }
        Iterator iterator = this.visibleEntries.keySet().iterator();
        while (iterator.hasNext()) {
            PropertyObject propertyObject = (PropertyObject)iterator.next();
            int n = propertyObject.getVisibleCCID();
            this.evaluateDeactivation(n, iComponentConditionManager);
            int n2 = propertyObject.getEnabledCCID();
            this.evaluateDeactivation(n2, iComponentConditionManager);
        }
        this.visibleEntries.clear();
        this.visibleEntriesInContext.clear();
        this.visibleNotContextSpecificEntries.clear();
        this.drawerController = null;
    }

    private void activateNewDrawer(IDrawerControllerEvo iDrawerControllerEvo) {
        this.drawerController = (DrawerController)iDrawerControllerEvo;
        PropertyObject[] propertyObjectArray = this.drawerController.getPropertyObjects();
        if (propertyObjectArray == null) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000, "DrawerConditionEngine#activateNewDrawer No property objects found!");
            return;
        }
        IComponentConditionManager iComponentConditionManager = this.componentConditionManager;
        if (iComponentConditionManager == null) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000, "DrawerConditionEngine#activateNewDrawer componentConditionManager is null - sidebar elements cannot be enabled or set invisible");
            return;
        }
        for (int i2 = 0; i2 < propertyObjectArray.length; ++i2) {
            PropertyObject propertyObject = propertyObjectArray[i2];
            if (propertyObject == null) {
                IWidgetLogChannel.logDrawerCondtionEngine.log(10000, "DrawerConditionEngine#activateNewDrawer propertyObject is null - drawer element state might be wrong (visible/enabled). Index: %1", (long)i2);
                continue;
            }
            int n = propertyObject.getVisibleCCID();
            this.evaluateActivation(n, iComponentConditionManager);
            boolean bl = false;
            boolean bl2 = false;
            if (this.evaluateCondition(n, iComponentConditionManager)) {
                this.visibleEntries.put(propertyObject, null);
                bl = this.setEntryVisibleInContext(propertyObject);
            } else {
                bl = n == -1;
            }
            propertyObject.getWidget().setVisible(bl);
            int n2 = propertyObject.getEnabledCCID();
            this.evaluateActivation(n2, iComponentConditionManager);
            bl2 = this.evaluateCondition(n2, iComponentConditionManager) ? true : n2 == -1;
            propertyObject.getWidget().setEnabled(bl2);
            String string = propertyObject.getWidget().toString();
            if (!IWidgetLogChannel.logDrawerCondtionEngine.isDebug()) continue;
            AbstractWidget abstractWidget = propertyObject.getWidget();
            if (abstractWidget instanceof MenuItemController) {
                string = this.getNameOfMenuItem((MenuItemController)abstractWidget);
            }
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#activateNewDrawer widget: %1 visibleCCID: %2, enabledCCID: %3", (Object)string, (long)n, (long)n2);
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#activateNewDrawer isVisible: %1, isEnabled: %2", bl, bl2);
        }
    }

    private boolean setEntryVisibleInContext(PropertyObject propertyObject) {
        boolean bl = false;
        block0 : switch (propertyObject.getType()) {
            case 2: {
                this.visibleEntriesInContext.put(propertyObject, null);
                this.visibleNotContextSpecificEntries.put(propertyObject, null);
                bl = true;
                break;
            }
            case 0: 
            case 1: {
                if (this.contextIDs == null) break;
                int[] nArray = propertyObject.getContextIDs();
                if (nArray != null) {
                    for (int i2 = 0; i2 < nArray.length; ++i2) {
                        for (int i3 = 0; i3 < this.contextIDs.length; ++i3) {
                            if ((long)nArray[i2] != this.contextIDs[i3]) continue;
                            this.visibleEntriesInContext.put(propertyObject, null);
                            if (propertyObject.getType() != 0) {
                                this.visibleNotContextSpecificEntries.put(propertyObject, null);
                            }
                            bl = true;
                            break;
                        }
                        if (bl) break block0;
                    }
                    break;
                }
                IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#activateNewDrawer no propertyObjectContextIDs available, they are null for type: %2, widget: %1 is not added to visibleEntries in context", (Object)propertyObject.getWidget(), (long)propertyObject.getType());
                break;
            }
            default: {
                IWidgetLogChannel.logDrawerCondtionEngine.log(100000, "DrawerConditionEngine#activateNewDrawer unknown type: %1", (long)propertyObject.getType());
            }
        }
        return bl;
    }

    public void processCCEvent(ComponentConditionEvent componentConditionEvent) {
        int n;
        int n2;
        PropertyObject[] propertyObjectArray;
        IComponentConditionManager iComponentConditionManager = this.componentConditionManager;
        if (iComponentConditionManager == null) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000, "DrawerConditionEngine#activateNewDrawer componentConditionManager is null - sidebar elements cannot be enabled or set invisible");
            return;
        }
        int[] nArray = componentConditionEvent.getChangedComponentConditions();
        if (IWidgetLogChannel.logDrawerCondtionEngine.isDebug()) {
            propertyObjectArray = new Buffer(128);
            for (n2 = 0; n2 < nArray.length; ++n2) {
                propertyObjectArray.append(nArray[n2]);
                propertyObjectArray.append(':');
                propertyObjectArray.append(this.evaluateCondition(nArray[n2], iComponentConditionManager));
                propertyObjectArray.append(';');
            }
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#processCCEvent component condition IDs which have changed: %1", (Object)propertyObjectArray);
        }
        if (this.drawerController == null) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(1000000, "DrawerConditionEngine#processCCEvent drawerController is null - no drawer set, cannot process component condition event");
            return;
        }
        propertyObjectArray = this.drawerController.getPropertyObjects();
        if (propertyObjectArray == null) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(100000, "DrawerConditionEngine#processCCEvent No property objects found at this drawer! %1", (Object)this.drawerController);
            return;
        }
        for (n2 = 0; n2 < nArray.length; ++n2) {
            n = nArray[n2];
            boolean bl = this.evaluateCondition(n, iComponentConditionManager);
            for (int i2 = 0; i2 < propertyObjectArray.length; ++i2) {
                PropertyObject propertyObject = propertyObjectArray[i2];
                if (n == propertyObject.getVisibleCCID()) {
                    if (bl) {
                        this.visibleEntries.put(propertyObject, null);
                        boolean bl2 = this.setEntryVisibleInContext(propertyObject);
                        propertyObject.getWidget().setVisible(bl2);
                        continue;
                    }
                    this.visibleEntries.remove(propertyObject);
                    this.visibleEntriesInContext.remove(propertyObject);
                    propertyObject.getWidget().setVisible(false);
                    if (propertyObject.getType() == 0) continue;
                    this.visibleNotContextSpecificEntries.remove(propertyObject);
                    continue;
                }
                if (n == propertyObject.getEnabledCCID()) {
                    propertyObject.getWidget().setEnabled(bl);
                    continue;
                }
                if (propertyObject.getEnabledCCID() != -2) continue;
                propertyObject.getWidget().setEnabled(true);
            }
        }
        if (this.terminal != null && this.terminal.getDrawerFocusManager().getDrawerState() == 8) {
            this.updateFocusedProperty();
        }
        if (propertyObjectArray.length > 0 && propertyObjectArray[0] != null) {
            AbstractWidget abstractWidget = propertyObjectArray[0].getWidget();
            n = abstractWidget instanceof AbstractWidgetController ? ((AbstractWidgetController)abstractWidget).getScreenId() : -1;
            IWidgetLogChannel.logRepaintCause.log(10000000, "DrawerConditionEngine#processCCEvent: trigger repaint. screen id: %2, event: %1", (Object)componentConditionEvent, (long)n);
            abstractWidget.triggerRepaint();
        }
    }

    public void spellerActive(boolean bl) {
    }

    public void setFocusedProperty(IFocusedPropertyObject iFocusedPropertyObject) {
        IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#setFocusedProperty newFocusedProperty=%1, oldFocusedProperty=%2", (Object)iFocusedPropertyObject, (Object)this.focusedProperty);
        this.focusedProperty = iFocusedPropertyObject;
        this.updateFocusedProperty();
    }

    public void updateFocusedProperty() {
        int n = -1;
        int[] nArray = null;
        if (this.focusedProperty != null) {
            n = this.focusedProperty.getCategory();
            nArray = this.focusedProperty.getProperties();
            this.targetModelID = this.focusedProperty.getModelID();
            this.targetRow = this.focusedProperty.getRow();
            this.targetWidgetID = this.focusedProperty.getWidgetID();
            this.targetActionReceiver = this.focusedProperty.getActionReceiverWidget();
        } else {
            this.targetModelID = -1;
            this.targetRow = 0;
            this.targetWidgetID = -1;
            this.targetActionReceiver = null;
        }
        this.logState(n, nArray);
        Iterator iterator = this.visibleEntriesInContext.keySet().iterator();
        while (iterator.hasNext()) {
            PropertyObject propertyObject = (PropertyObject)iterator.next();
            if (propertyObject.getType() == 2 || propertyObject.getType() == 1) continue;
            int[] nArray2 = propertyObject.getCategories();
            boolean bl = false;
            if (this.focusedProperty != null && nArray2 != null) {
                for (int i2 = 0; i2 < nArray2.length; ++i2) {
                    if (!this.compareCategory(n, nArray2[i2])) continue;
                    bl = true;
                    break;
                }
            } else if (IWidgetLogChannel.logDrawerCondtionEngine.isDebug()) {
                IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#setFocusedProperty focusedProperty or category is null focusedProperty: %1, categories: %2. Entry in option drawer with visibleCCID: %3 is set visible: false", (Object)this.focusedProperty, (Object)nArray2, (long)propertyObject.getVisibleCCID());
            }
            if (bl) {
                if (nArray == null || nArray.length == 0) {
                    int[] nArray3 = propertyObject.getFocusPropertiesToShow();
                    if (nArray3 != null && nArray3.length > 0) {
                        if (IWidgetLogChannel.logDrawerCondtionEngine.isDebug()) {
                            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#setFocusedProperty no focusedPropertyToShow configured (null or length == 0) entry in option drawer with visibleCCID: %1 is set visible: false", (long)propertyObject.getVisibleCCID());
                        }
                        bl = false;
                    }
                } else {
                    int n2;
                    int[] nArray4;
                    int n3;
                    int[] nArray5 = propertyObject.getFocusPropertiesToHide();
                    if (nArray5 != null) {
                        for (int i3 = 0; i3 < nArray5.length; ++i3) {
                            for (n3 = 0; n3 < nArray.length; ++n3) {
                                if (nArray5[i3] != nArray[n3]) continue;
                                bl = false;
                                break;
                            }
                            if (!bl) break;
                        }
                    }
                    if (bl && (nArray4 = propertyObject.getFocusPropertiesToShow()) != null) {
                        for (n3 = 0; n3 < nArray4.length; ++n3) {
                            boolean bl2 = false;
                            for (n2 = 0; n2 < nArray.length; ++n2) {
                                if (nArray4[n3] != nArray[n2]) continue;
                                bl2 = true;
                                break;
                            }
                            if (bl2) continue;
                            bl = false;
                            break;
                        }
                    }
                    if (bl) {
                        int[] nArray6;
                        IComponentConditionManager iComponentConditionManager = this.componentConditionManager;
                        if (iComponentConditionManager == null) {
                            IWidgetLogChannel.logDrawerCondtionEngine.log(10000, "DrawerConditionEngine#setFocusedProperty componentConditionManager is null - option drawers elements might be enabled/disabled wrong");
                            return;
                        }
                        n3 = this.evaluateCondition(propertyObject.getEnabledCCID(), iComponentConditionManager) ? 1 : 0;
                        if (n3 != 0 && (nArray6 = propertyObject.getFocusPropertiesToDisable()) != null) {
                            for (n2 = 0; n2 < nArray6.length; ++n2) {
                                for (int i4 = 0; i4 < nArray.length; ++i4) {
                                    if (nArray6[n2] != nArray[i4]) continue;
                                    n3 = 0;
                                    break;
                                }
                                if (n3 == 0) break;
                            }
                        }
                        propertyObject.getWidget().setEnabled(n3 != 0);
                    }
                }
            }
            propertyObject.getWidget().setVisible(bl);
        }
    }

    private void logState(int n, int[] nArray) {
        if (IWidgetLogChannel.logDrawerCondtionEngine.isDebug()) {
            int n2;
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#setFocusedProperty focusedProperty: %1", (Object)this.focusedProperty);
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#setFocusedProperty focusedCategory: %1", (long)n);
            Buffer buffer = new Buffer(512);
            buffer.append("DrawerConditionEngine#setFocusedProperty contextIDs: ");
            if (this.contextIDs != null) {
                for (n2 = 0; n2 < this.contextIDs.length; ++n2) {
                    buffer.append(this.contextIDs[n2]);
                    buffer.append(", ");
                }
            } else {
                buffer.append("none");
            }
            buffer.append("DrawerConditionEngine#setFocusedProperty focusedProperties: ");
            if (nArray != null) {
                for (n2 = 0; n2 < nArray.length; ++n2) {
                    buffer.append(nArray[n2]);
                    buffer.append(", ");
                }
            } else {
                buffer.append("none");
            }
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#setFocusedProperty targetModelID: %1, targetRow: %2, targetWidgetID: %3", (long)this.targetModelID, (long)this.targetRow, (long)this.targetWidgetID);
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#setFocusedProperty targetActionReceiver: %1", (Object)this.targetActionReceiver);
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, buffer.toString());
        }
    }

    protected boolean compareCategory(int n, int n2) {
        if (n == 1657326040 && n2 == 1083550776) {
            return true;
        }
        return n == n2;
    }

    public Object addingService(ServiceReference serviceReference) {
        if (this.bundleContext == null) {
            IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#addingService(): bundleContext is null, bundle probably has been stopped -> NOP");
            return null;
        }
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IComponentConditionManager) {
            this.setComponentConditionManager((IComponentConditionManager)object);
            return object;
        }
        IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#addingService(): unknown service, service has not been tracked: %1", object);
        return null;
    }

    protected void setComponentConditionManager(IComponentConditionManager iComponentConditionManager) {
        this.componentConditionManager = iComponentConditionManager;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        IWidgetLogChannel.logDrawerCondtionEngine.log(10000000, "DrawerConditionEngine#removedService() service: %1", object);
        if (object instanceof IComponentConditionManager) {
            this.componentConditionManager = null;
        }
    }

    public int getTargetModelID() {
        return this.targetModelID;
    }

    public int getTargetRow() {
        return this.targetRow;
    }

    public int getTargetWidgetID() {
        return this.targetWidgetID;
    }

    public long[] getActiveContexts() {
        return this.contextIDs;
    }

    public IRightDrawerActionReceiver getTargetActionReceiver() {
        return this.targetActionReceiver;
    }

    public boolean hasNotContextSpecificEntries() {
        return !this.visibleNotContextSpecificEntries.isEmpty();
    }

    private String translateContext(long l) {
        List list = Arrays.asList((class$de$audi$atip$hmi$IDrawerContext == null ? (class$de$audi$atip$hmi$IDrawerContext = DrawerConditionEngine.class$("de.audi.atip.hmi.IDrawerContext")) : class$de$audi$atip$hmi$IDrawerContext).getInterfaces());
        return this.matchReflectionNameByID(list, l);
    }

    private String translateCategory(long l) {
        List list = Arrays.asList((class$de$audi$atip$hmi$IDrawerCategory == null ? (class$de$audi$atip$hmi$IDrawerCategory = DrawerConditionEngine.class$("de.audi.atip.hmi.IDrawerCategory")) : class$de$audi$atip$hmi$IDrawerCategory).getInterfaces());
        return this.matchReflectionNameByID(list, l);
    }

    private String translateFocusProperty(long l) {
        List list = Arrays.asList((class$de$audi$atip$hmi$IDrawerFocus == null ? (class$de$audi$atip$hmi$IDrawerFocus = DrawerConditionEngine.class$("de.audi.atip.hmi.IDrawerFocus")) : class$de$audi$atip$hmi$IDrawerFocus).getInterfaces());
        return this.matchReflectionNameByID(list, l);
    }

    private String matchReflectionNameByID(List list, long l) {
        Object object;
        ArrayList arrayList = new ArrayList();
        Object object2 = list.iterator();
        while (object2.hasNext()) {
            object = (Class)object2.next();
            arrayList.addAll(Arrays.asList(((Class)object).getDeclaredFields()));
        }
        object2 = "";
        object = arrayList.iterator();
        while (object.hasNext()) {
            Field field = (Field)object.next();
            Integer n = new Integer(0);
            try {
                if ((n = (Integer)field.get(n)).longValue() != l) continue;
                object2 = new String(new StringBuffer().append(field.getDeclaringClass().getName()).append(".").append(field.getName()).append("(").append(l).append(")").toString());
                break;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
        return object2;
    }

    public Object getInternalState() {
        PropertyObject propertyObject;
        Buffer buffer = new Buffer(2048);
        IComponentConditionManager iComponentConditionManager = this.componentConditionManager;
        int n = ((DrawerController)this.terminal.getDrawerFocusManager().getOptionDrawer()).getID();
        if (iComponentConditionManager == null) {
            return null;
        }
        buffer.append("CurrentDrawerID: ").append(n).append("\n");
        buffer.append("DrawerConditionEngine state:\n");
        buffer.append("** contexts:\n");
        if (this.contextIDs != null) {
            for (int i2 = 0; i2 < this.contextIDs.length; ++i2) {
                long l = this.contextIDs[i2];
                this.translateContext(l);
                buffer.append(this.translateContext(l)).append(", ");
            }
        } else {
            buffer.append("null");
        }
        buffer.append("\n");
        buffer.append("** visible entries:\n");
        Set set = this.visibleEntries.keySet();
        Object[] objectArray = set.iterator();
        while (objectArray.hasNext()) {
            propertyObject = (PropertyObject)objectArray.next();
            buffer.append("visibleCCID: ").append(propertyObject.getVisibleCCID()).append(" visible: ").append(this.evaluateCondition(propertyObject.getVisibleCCID(), iComponentConditionManager));
            buffer.append(" enabledCCID: ").append(propertyObject.getEnabledCCID()).append(" enabled: ").append(this.evaluateCondition(propertyObject.getEnabledCCID(), iComponentConditionManager)).append("\n");
        }
        buffer.append("** visible entries in context:\n");
        set = this.visibleEntriesInContext.keySet();
        objectArray = set.iterator();
        while (objectArray.hasNext()) {
            propertyObject = (PropertyObject)objectArray.next();
            buffer.append(" visibleCCID: ").append(propertyObject.getVisibleCCID()).append(" visible: ").append(this.evaluateCondition(propertyObject.getVisibleCCID(), iComponentConditionManager));
            buffer.append(" enabledCCID: ").append(propertyObject.getEnabledCCID()).append(" enabled: ").append(this.evaluateCondition(propertyObject.getEnabledCCID(), iComponentConditionManager)).append("\n");
        }
        buffer.append("** focusedProperties:\n");
        if (this.focusedProperty != null) {
            buffer.append("focusedProperty category: ").append(this.focusedProperty.getCategory()).append("\n");
            buffer.append("focusedProperty modelID: ").append(this.focusedProperty.getModelID()).append("\n");
            buffer.append("focusedProperty widgetID: ").append(this.focusedProperty.getWidgetID()).append("\n");
            buffer.append("focusedProperty properties: ");
            objectArray = this.focusedProperty.getProperties();
            if (objectArray != null) {
                for (int i3 = 0; i3 < objectArray.length; ++i3) {
                    buffer.append((int)objectArray[i3]).append(", ");
                }
            } else {
                buffer.append("null");
            }
        } else {
            buffer.append("null");
        }
        buffer.append("\n");
        buffer.append("** state of entries:\n");
        objectArray = this.drawerController.getPropertyObjects();
        if (objectArray != null) {
            for (int i4 = 0; i4 < objectArray.length; ++i4) {
                AbstractWidget abstractWidget = objectArray[i4].getWidget();
                if (abstractWidget instanceof MenuItemController) {
                    buffer.append("\tEntry[ \"").append(this.getNameOfMenuItem((MenuItemController)abstractWidget)).append("\" ]");
                } else {
                    buffer.append("\tWidget: \" ").append(abstractWidget.toString()).append("\" ");
                }
                buffer.append(": with visibleCCID: ").append(objectArray[i4].getVisibleCCID()).append(" is visible: ").append(abstractWidget.isVisible()).append(" is Enabled: ").append(abstractWidget.isEnabled());
                buffer.append("\n          type: ").append(objectArray[i4].getType());
                buffer.append(" categories: ");
                int[] nArray = objectArray[i4].getCategories();
                if (nArray != null) {
                    for (int i5 = 0; i5 < nArray.length; ++i5) {
                        buffer.append(this.translateCategory(nArray[i5])).append(", ");
                    }
                } else {
                    buffer.append("null");
                }
                buffer.append("\n          focusedPropertiesToShow: ");
                int[] nArray2 = objectArray[i4].getFocusPropertiesToShow();
                if (nArray2 != null) {
                    for (int i6 = 0; i6 < nArray2.length; ++i6) {
                        buffer.append(this.translateFocusProperty(nArray2[i6])).append(", ");
                    }
                } else {
                    buffer.append("null");
                }
                buffer.append(" focusedPropertiesToHide: ");
                int[] nArray3 = objectArray[i4].getFocusPropertiesToHide();
                if (nArray3 != null) {
                    for (int i7 = 0; i7 < nArray3.length; ++i7) {
                        buffer.append(this.translateFocusProperty(nArray3[i7])).append(", ");
                    }
                } else {
                    buffer.append("null");
                }
                buffer.append(" focusedPropertiesToDisable: ");
                int[] nArray4 = objectArray[i4].getFocusPropertiesToDisable();
                if (nArray4 != null) {
                    for (int i8 = 0; i8 < nArray4.length; ++i8) {
                        buffer.append(this.translateFocusProperty(nArray4[i8])).append(", ");
                    }
                } else {
                    buffer.append("null");
                }
                buffer.append("\n");
            }
        }
        return buffer;
    }

    private String getNameOfMenuItem(MenuItemController menuItemController) {
        AbstractWidget abstractWidget;
        if (menuItemController.getChildrenSize() > 0 && (abstractWidget = menuItemController.getChild(0)) instanceof LabelController) {
            return ((LabelController)abstractWidget).getText();
        }
        return menuItemController.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

