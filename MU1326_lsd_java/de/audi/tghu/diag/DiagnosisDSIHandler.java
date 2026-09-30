/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.diag;

import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.diag.DiagnosisApp;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.diagnose.DSIDiagnoseSystem;
import org.dsi.ifc.diagnose.DSIDiagnoseSystemListener;

public final class DiagnosisDSIHandler
implements DSIDiagnoseSystemListener,
TimerListener {
    private final IFrameworkAccess fw;
    private final LogChannel lc;
    private DSIDiagnoseSystem diagDSI;
    private int lastmodeAudio;
    private boolean isSourceSwitched;
    private volatile boolean deleteMemoryActive;
    private volatile boolean deletePMLPasswordActive;
    private Timer testPicTimer = new Timer("DiagTestPicRemover", 1L, true, this);
    private DiagnosisApp app;
    private NaviService naviInterAppService;

    DiagnosisDSIHandler(IFrameworkAccess iFrameworkAccess, DiagnosisApp diagnosisApp) {
        this.fw = iFrameworkAccess;
        this.lc = iFrameworkAccess.getLogChannel("Fw.Diagnosis.DSI");
        this.app = diagnosisApp;
    }

    public void setDSIDiagnoseSystem(DSIDiagnoseSystem dSIDiagnoseSystem) {
        this.lc.log(10000000, "setDSIDiagnoseSystem: dsi=%1", (Object)dSIDiagnoseSystem);
        this.diagDSI = dSIDiagnoseSystem;
        this.diagDSI.setNotification(new int[]{20}, (DSIListener)this);
    }

    public void setNaviService(NaviService naviService) {
        this.lc.log(10000000, "setNaviService: naviInterAppService=%1", (Object)naviService);
        this.naviInterAppService = naviService;
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "errorCode=%2, errorMsg=%1, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    private void sendMessage(int n) {
        this.fw.getMsgDistrib().sendMessage(n);
    }

    private final IAppSystem getAppSys() {
        return this.fw.getSysApp().getVariantAppSystem();
    }

    public void deleteMemory() {
        this.lc.log(10000000, "deleteMemory");
        this.fw.getInfotainmentrecorder().logInit();
        this.fw.getStorageMgr().startReset2FactorySettings();
        this.sendMessage(30);
        this.sendMessage(22);
        this.sendMessage(23);
        this.sendMessage(24);
        this.sendMessage(28);
        this.sendMessage(25);
        this.sendMessage(26);
        this.sendMessage(29);
        this.sendMessage(27);
        this.sendMessage(32);
        this.sendMessage(33);
        this.sendMessage(20);
        this.app.performAction(9, Boolean.TRUE);
        this.fw.getStorageMgr().endReset2FactorySettings();
    }

    private void startDiagMode() {
        this.lc.log(10000000, "startDiagMode");
        this.sendMessage(43);
        this.app.startDiagSession();
        this.lastmodeAudio = this.fw.getLastmodeHandler().getLastmodeAudio(-2);
    }

    private void stopDiagMode() {
        this.lc.log(10000000, "stopDiagMode");
        this.sendMessage(44);
        this.restoreSourceSwitch();
        this.removeTestPicPopup();
        this.app.stopDiagSession();
    }

    private void removeTestPicPopup() {
        this.fw.getHMIService().getChoiceModel(103).setValue(0);
    }

    private void restoreSourceSwitch() {
        if (this.isSourceSwitched) {
            if (this.lastmodeAudio == 1) {
                this.getAppSys().switch2Tuner();
                this.app.switch2OriginSource(0, 0);
            } else if (this.lastmodeAudio == 2) {
                this.getAppSys().switch2Media();
                this.app.switch2OriginSource(0, 1);
            }
        }
    }

    public void updateSourceSwitch(int n) {
        this.lc.log(10000000, "sourceSwitch=%1", (long)n);
        try {
            switch (n) {
                case 0: 
                case 1: 
                case 2: 
                case 3: {
                    this.getAppSys().switch2Tuner();
                    this.isSourceSwitched = true;
                    this.app.performAction(5, new Integer(n));
                    break;
                }
                case 20: {
                    this.isSourceSwitched = true;
                    this.app.performAction(5, new Integer(n));
                    break;
                }
                case 17: {
                    if (this.fw.isPorsche()) {
                        this.getAppSys().switch2Tuner();
                    } else {
                        this.getAppSys().switch2Media();
                    }
                    this.isSourceSwitched = true;
                    this.app.performAction(5, new Integer(n));
                    break;
                }
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 15: 
                case 16: 
                case 18: 
                case 19: 
                case 21: 
                case 22: {
                    this.getAppSys().switch2Media();
                    this.isSourceSwitched = true;
                    this.app.performAction(5, new Integer(n));
                    break;
                }
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "", (Throwable)exception);
        }
    }

    public void updateTestPictureDisplay(int n) {
        this.lc.log(10000000, "testPictureDisplay=%1", (long)n);
        if (n >= 0 && n <= 9) {
            if (this.fw.isFrontMU()) {
                this.fw.getHMIService().getChoiceModel(103).setValue(n);
                if (this.fw.isPorsche()) {
                    if (n >= 1 && n <= 9) {
                        this.fw.getHMIService().showPartialPopup(0, 122);
                    } else {
                        this.fw.getHMIService().removePartialPopup(0, 122);
                    }
                }
            }
        } else if (n >= 10 && n <= 18 || n < 19 || n <= 27) {
            // empty if block
        }
    }

    public void updatePmlPassword(boolean bl) {
        this.lc.log(10000000, "pmlPassword=%1", bl);
        this.app.performAction(9, bl);
    }

    public void updateDiagnosticValueChanged(int n, long l, int n2) {
        if (n2 == 1) {
            this.lc.log(10000000, "updateDiagnosticValueChanged(namespace=%1, key=%2)", (long)n, l);
            this.app.updateDiagnosticValueChanged(n, l);
        }
    }

    public void requestRoutine(int n, int n2, int n3, int[] nArray) {
        this.lc.log(10000000, "requestRoutine(msgId=%1, routine=%2, action=%3", (long)n, (long)n2, (long)n3);
        this.lc.log(10000000, "               options=%1)", (Object)nArray);
        if (this.diagDSI == null) {
            this.lc.log(10000, "requestRoutine() DSIDiagnoseSystem not tracked yet!!!");
            return;
        }
        if (n3 == 1) {
            switch (n2) {
                case 0: {
                    this.diagDSI.acknowledgeRoutine(n, n2, n3, 0);
                    this.deleteMemoryActive = true;
                    this.deleteMemory();
                    this.resultRoutine(0);
                    break;
                }
                case 1: {
                    this.diagDSI.acknowledgeRoutine(n, n2, n3, 0);
                    this.deletePMLPasswordActive = true;
                    this.updatePmlPassword(true);
                    this.resultRoutine(1);
                    break;
                }
                default: {
                    this.diagDSI.acknowledgeRoutine(n, n2, n3, 2);
                    break;
                }
            }
        } else if (n3 == 2) {
            this.diagDSI.acknowledgeRoutine(n, n2, n3, 0);
        } else if (n3 == 3) {
            if (n2 == 0) {
                this.diagDSI.resultRoutine(n, n2, n3, this.deleteMemoryActive ? 1 : 2, this.deleteMemoryActive ? 2 : 0);
            } else if (n2 == 1) {
                this.diagDSI.resultRoutine(n, n2, n3, this.deletePMLPasswordActive ? 1 : 2, this.deletePMLPasswordActive ? 2 : 0);
            } else {
                this.diagDSI.resultRoutine(n, n2, n3, 2, 0);
            }
        } else {
            this.lc.log(10000, "requestRoutine() wrong action=%1", (long)n3);
        }
    }

    private void resultRoutine(final int n) {
        long l = 10000L;
        if (n == 1) {
            l = 3000L;
        }
        Timer timer = new Timer("resultRoutine", l, true, new TimerListener(){

            public void fireTimer(Timer timer) {
                DiagnosisDSIHandler.this.lc.log(10000000, "Timer::resultRoutine # msgId=0 # routine=%2", (long)n);
                if (n == 0) {
                    DiagnosisDSIHandler.this.deleteMemoryActive = false;
                } else if (n == 1) {
                    DiagnosisDSIHandler.this.deletePMLPasswordActive = false;
                }
                DiagnosisDSIHandler.this.diagDSI.resultRoutine(0, n, 3, 2, 0);
            }

            public void cancelTimer(Timer timer) {
            }
        });
        timer.start();
    }

    public void requestActuatorTest(int n, int n2, int n3, int n4, int[] nArray) {
        this.lc.log(10000000, "requestActuatorTest(msgId=%1, test=%2, action=%3", (long)n, (long)n2, (long)n3);
        this.lc.log(10000000, "                    timing=%2, params=%1)", (Object)nArray, (long)n4);
        if (this.diagDSI == null) {
            this.lc.log(10000, "DSIDiagnoseSystem not tracked yet!!!");
            return;
        }
        if (n3 == 0) {
            switch (n2) {
                case 0: {
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 0);
                    this.startDiagMode();
                    break;
                }
                case 3: {
                    if (nArray == null || nArray.length < 1) {
                        this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 2);
                        break;
                    }
                    if (nArray[0] == 10 || nArray[0] == 20 || !this.isSourceCoded(nArray[0])) {
                        this.lc.log(10000000, "ACTUATOR_SOURCE_SWITCH::HMIRESPONSE_REQUEST_OUT_OF_RANGE");
                        this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 4);
                        break;
                    }
                    this.lc.log(10000000, "ACTUATOR_SOURCE_SWITCH::HMIRESPONSE_OK");
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 0);
                    this.updateSourceSwitch(nArray[0]);
                    break;
                }
                case 1: {
                    if (nArray == null || nArray.length < 1) {
                        this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 2);
                        break;
                    }
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 0);
                    this.updateTestPictureDisplay(nArray[0]);
                    this.startTestPicPopupRemoverTimer(n4);
                    break;
                }
                case 2: {
                    if (nArray == null || nArray.length < 1) {
                        this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 2);
                        break;
                    }
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 0);
                    this.updateTestPictureDisplay(nArray[0] + 9);
                    this.startTestPicPopupRemoverTimer(n4);
                    break;
                }
                case 4: {
                    if (this.naviInterAppService != null) {
                        this.naviInterAppService.diagStartDemoRouteGuidance(nArray);
                    }
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 0);
                    break;
                }
                default: {
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 2);
                    break;
                }
            }
        } else if (n3 == 1) {
            switch (n2) {
                case 0: {
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 0);
                    this.stopDiagMode();
                    break;
                }
                case 3: {
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 0);
                    this.restoreSourceSwitch();
                    break;
                }
                case 1: 
                case 2: {
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 0);
                    this.removeTestPicPopup();
                    break;
                }
                case 4: {
                    if (this.naviInterAppService != null) {
                        this.naviInterAppService.diagStopRouteGuidance();
                    }
                    this.diagDSI.acknowledgeActuatorTest(n, n2, n3, n4, nArray, 0);
                    break;
                }
            }
        } else {
            this.lc.log(10000, "requestRoutine() unused action=%1", (long)n3);
        }
    }

    private boolean isSourceCoded(int n) {
        switch (n) {
            case 3: {
                return this.fw.getSysConst(442) == 1;
            }
            case 18: 
            case 22: {
                return this.fw.getSysConst(483) == 1;
            }
            case 23: 
            case 24: {
                return false;
            }
            case 17: {
                return this.fw.getSysConst(491) == 1;
            }
            case 5: 
            case 6: {
                return this.fw.getSysConst(478) == 1;
            }
            case 9: {
                return this.fw.getSysConst(480) == 1;
            }
            case 11: {
                return this.fw.getSysConst(493) == 1;
            }
            case 12: {
                return this.fw.getSysConst(493) == 1 && this.fw.getSysConst(442) != 0;
            }
            case 4: 
            case 8: {
                return this.fw.getSysConst(502) == 1;
            }
        }
        return true;
    }

    private void startTestPicPopupRemoverTimer(int n) {
        if (this.testPicTimer != null) {
            this.testPicTimer.cancel();
            if (n != 255 && n >= 0) {
                this.testPicTimer.setDelay(n * 1000);
                this.testPicTimer.start();
            }
        }
    }

    public void fireTimer(Timer timer) {
        this.removeTestPicPopup();
    }

    public void cancelTimer(Timer timer) {
    }
}

