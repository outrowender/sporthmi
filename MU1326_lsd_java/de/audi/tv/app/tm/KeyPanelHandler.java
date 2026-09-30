/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class KeyPanelHandler {
    public final DefaultTVListener tvListener = new TVListenerImpl();
    private final TVEnv env;
    private final DSIHandler dsiHandler;
    private final ChoiceModelApp choiceModelApp;
    private volatile boolean keyLock = false;
    private final Object dsiAccessMutex = new Object();

    public KeyPanelHandler(DSIHandler dSIHandler, TVEnv tVEnv) {
        this.dsiHandler = dSIHandler;
        this.env = tVEnv;
        this.choiceModelApp = tVEnv.getChoiceModel(2600089);
        this.choiceModelApp.setChoiceListener(new ChoiceListenerImpl());
        ButtonListener buttonListener = new ButtonListener();
        tVEnv.getButtonModel(2600145).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600129).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600144).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600127).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600126).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600128).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600133).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600130).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600131).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600132).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600134).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600135).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600136).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600137).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600138).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600139).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600140).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600141).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600142).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600143).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600172).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600186).setButtonListener(buttonListener);
        tVEnv.getSpellerModel(2600224).setSpellerListener(new SpellerListener());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean externalKeyPressed(short s) {
        Object object = this.dsiAccessMutex;
        synchronized (object) {
            if (!this.keyLock) {
                this.dsiHandler.setTMTVKeyPanel(s, (short)1);
                this.dsiHandler.setTMTVKeyPanel(s, (short)0);
                return true;
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void buttonAction(short s, short s2) {
        Object object = this.dsiAccessMutex;
        synchronized (object) {
            this.keyLock = s2 == 1;
            this.dsiHandler.setTMTVKeyPanel(s, s2);
        }
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
        }

        public void keyReleased(int n, int n2, int n3) {
            short s = this.getKeyPanelCode(n);
            ((KeyPanelHandler)KeyPanelHandler.this).env.lcHMI.log(10000000, "[KeyPanelHandler.keyReleased] key:0x%1", (long)s);
            KeyPanelHandler.this.buttonAction(s, (short)1);
            KeyPanelHandler.this.buttonAction(s, (short)0);
        }

        private short getKeyPanelCode(int n) {
            switch (n) {
                case 2600145: {
                    return 1;
                }
                case 2600129: {
                    return 2;
                }
                case 2600144: {
                    return 3;
                }
                case 2600127: {
                    return 4;
                }
                case 2600126: {
                    return 5;
                }
                case 2600128: {
                    return 6;
                }
                case 2600133: {
                    return 12;
                }
                case 2600130: {
                    return 13;
                }
                case 2600131: {
                    return 14;
                }
                case 2600132: {
                    return 15;
                }
                case 2600134: {
                    return 29;
                }
                case 2600135: {
                    return 20;
                }
                case 2600136: {
                    return 21;
                }
                case 2600137: {
                    return 22;
                }
                case 2600138: {
                    return 23;
                }
                case 2600139: {
                    return 24;
                }
                case 2600140: {
                    return 25;
                }
                case 2600141: {
                    return 26;
                }
                case 2600142: {
                    return 27;
                }
                case 2600143: {
                    return 28;
                }
                case 2600172: {
                    return 36;
                }
                case 2600186: {
                    return 38;
                }
            }
            return -1;
        }
    }

    private class TVListenerImpl
    extends DefaultTVListener {
        private TVListenerImpl() {
        }

        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            short[] sArray = startUpConfig.requiredKeypanelList;
            SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap(5);
            SimpleIntObjectMap simpleIntObjectMap2 = new SimpleIntObjectMap(15);
            int n = -1;
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                n = sArray[i2];
                i2 += 2;
                IntList intList = new IntList(4);
                IntList intList2 = new IntList(20);
                while (i2 < sArray.length && sArray[i2] != 255) {
                    if (sArray[i2] > 0 && sArray[i2] < 5) {
                        intList.add(sArray[i2]);
                    } else if (sArray[i2] != 15 && sArray[i2] != 12 && sArray[i2] != 16 && sArray[i2] != 17 && sArray[i2] != 13 && sArray[i2] != 18 && sArray[i2] != 19 && sArray[i2] != 14 && sArray[i2] != 40 && sArray[i2] != 41 && sArray[i2] != 42 && sArray[i2] != 43) {
                        intList2.add(sArray[i2]);
                    }
                    ++i2;
                }
                simpleIntObjectMap.add(n, intList.toArray());
                simpleIntObjectMap2.add(n, intList2.toArray());
            }
            KeyPanelHandler.this.env.getDataModel(2600157).set(simpleIntObjectMap);
            KeyPanelHandler.this.env.getDataModel(2600158).set(simpleIntObjectMap2);
        }

        public void updateTMTVKeyPanel(short s, short s2) {
            if (s == -1) {
                return;
            }
            KeyPanelHandler.this.choiceModelApp.setValue(s);
            KeyPanelHandler.this.choiceModelApp.setStatus(1);
        }
    }

    private class SpellerListener
    extends DefaultSpellerListener {
        private SpellerListener() {
        }

        public void keyReleased(int n, int n2, int n3) {
            ((KeyPanelHandler)KeyPanelHandler.this).env.lcHMI.log(10000000, "[KeyPanelHandler.SpellerListener.keyReleased] key:0x%1", (long)n2);
            if (n2 >= 0 && n2 <= 9) {
                short s = TVUtil.KEYPANEL_NUMBER_CODES[n2];
                KeyPanelHandler.this.buttonAction(s, (short)1);
                KeyPanelHandler.this.buttonAction(s, (short)0);
            }
        }
    }

    private class ChoiceListenerImpl
    extends DefaultChoiceListener {
        private ChoiceListenerImpl() {
        }

        public void keyPressed(int n, int n2, int n3) {
            ((KeyPanelHandler)KeyPanelHandler.this).env.lcHMI.log(10000000, "[KeyPanelHandler.keyPressed] keyID:0x%1", (long)n2);
            KeyPanelHandler.this.buttonAction((short)n2, (short)1);
        }

        public void keyReleased(int n, int n2, int n3) {
            ((KeyPanelHandler)KeyPanelHandler.this).env.lcHMI.log(10000000, "[KeyPanelHandler.keyReleased] keyID:0x%1", (long)n2);
            KeyPanelHandler.this.buttonAction((short)n2, (short)0);
        }
    }
}

