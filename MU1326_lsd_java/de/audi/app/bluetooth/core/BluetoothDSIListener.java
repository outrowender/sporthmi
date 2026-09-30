/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDefaultListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

class BluetoothDSIListener
implements DSIBluetoothListener,
ICommandResponseSupplier {
    private final BluetoothDefaultListener bluetoothDefaultListener;
    private final CommandListManager cmdListManager;
    private final LogChannel log;

    BluetoothDSIListener(CommandListManager commandListManager, LogChannel logChannel) {
        this.cmdListManager = commandListManager;
        this.bluetoothDefaultListener = new BluetoothDefaultListener(logChannel);
        this.log = logChannel;
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[BluetoothDSIListener#asyncException] called, error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    public void deviceDisonnectionInfo(final String string, final String string2, final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#deviceDisonnectionInfo] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).deviceDisonnectionInfo(string, string2, n);
            }
        });
    }

    public void removeAuthenticationNoSupport(final String string, final String string2) {
        this.log.log(10000000, "[BluetoothDSIListener#removeAuthenticationNoSupport] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).removeAuthenticationNoSupport(string, string2);
            }
        });
    }

    public void responseAbortConnectService(final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseAbortConnectService] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseAbortConnectService(n);
            }
        });
    }

    public void responseAbortInquiry(final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseAbortInquiry] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseAbortInquiry(n);
            }
        });
    }

    public void responseAcceptIncomingServiceRequest(final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseAcceptIncomingServiceRequest] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseAcceptIncomingServiceRequest(n);
            }
        });
    }

    public void responseConnectService(final String string, final String string2, final int n, final int n2, final int n3) {
        this.log.log(10000000, "[BluetoothDSIListener#responseConnectService] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseConnectService(string, string2, n, n2, n3);
            }
        });
    }

    public void responseConnectServiceToInstance(final String string, final String string2, final int n, final int n2, final int n3) {
        this.log.log(10000000, "[BluetoothDSIListener#responseConnectServiceToInstance] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseConnectServiceToInstance(string, string2, n, n2, n3);
            }
        });
    }

    public void responseDisconnectService(final String string, final int n, final int n2) {
        this.log.log(10000000, "[BluetoothDSIListener#responseDisconnectService] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseDisconnectService(string, n, n2);
            }
        });
    }

    public void responseGetServices(final String string, final String string2, final int n, final int n2) {
        this.log.log(10000000, "[BluetoothDSIListener#responseGetServices] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseGetServices(string, string2, n, n2);
            }
        });
    }

    public void responseInquiry(final int n, final int n2) {
        this.log.log(10000000, "[BluetoothDSIListener#responseInquiry] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseInquiry(n, n2);
            }
        });
    }

    public void responsePasskeyResponse(final String string, final String string2, final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responsePasskeyResponse] Called, device address: %1, device name: %2, result: %3", (Object)string, (Object)string2, (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responsePasskeyResponse(string, string2, n);
            }
        });
    }

    public void responseReconnectSuspend(final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseReconnectSuspend] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseReconnectSuspend(n);
            }
        });
    }

    public void responseRemoveAuthentication(final String string, final String string2, final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseRemoveAuthentication] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseRemoveAuthentication(string, string2, n);
            }
        });
    }

    public void responseRestoreFactorySettings(final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseRestoreFactorySettings] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseRestoreFactorySettings(n);
            }
        });
    }

    public void responseSetA2DPUserSetting(final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseSetA2DPUserSetting] Called, result: %1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseSetA2DPUserSetting(n);
            }
        });
    }

    public void responseSetPriorizedDeviceReconnect(final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseSetPriorizedDeviceReconnect] Called, result: %1", (long)n);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseSetPriorizedDeviceReconnect(n);
            }
        });
    }

    public void responseSwitchBTState(final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseSwitchBTState] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseSwitchBTState(n);
            }
        });
    }

    public void responseSetAccessibleMode(final int n) {
        this.log.log(10000000, "[BluetoothDSIListener#responseSetAccessibleMode] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).responseSetAccessibleMode(n);
            }
        });
    }

    public void serviceRejectNoSupport(final String string, final String string2) {
        this.log.log(10000000, "[BluetoothDSIListener#serviceRejectNoSupport] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).serviceRejectNoSupport(string, string2);
            }
        });
    }

    public void updateA2DPUserSetting(final boolean bl, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateA2DP_UserSetting] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateA2DPUserSetting(bl, n);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateA2DP_UserSetting] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public void updateAccessibleMode(final int n, final boolean bl, final int n2) {
        if (n2 == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateAccessibleMode] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateAccessibleMode(n, bl, n2);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateAccessibleMode] Data is not valid, valid flag value: %1", (long)n2);
        }
    }

    public void updateBTState(final int n, final int n2) {
        if (n2 == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateBTState] Called, state: %1, validFlag: %2", (long)n, (long)n2);
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateBTState(n, n2);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateBTState] Data not valid, valid flag value: %1", (long)n2);
        }
    }

    public void updateDiscoveredDevices(final DiscoveredDevice discoveredDevice, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateDiscoveredDevices] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateDiscoveredDevices(discoveredDevice, n);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateDiscoveredDevices] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public void updateHUCandBTHSState(final int n, final int n2) {
        this.log.log(10000000, "[BluetoothDSIListener#updateHUCandBTHSState] Called");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIBluetoothListener)dSIListener).updateHUCandBTHSState(n, n2);
            }
        });
    }

    public void updateIncomingServiceRequest(final RequestIncomingService requestIncomingService, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateIncomingServiceRequest] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateIncomingServiceRequest(requestIncomingService, n);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateIncomingServiceRequest] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public void updateMasterRoleRequestError(final MasterRoleRequestStruct masterRoleRequestStruct, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateMasterRoleRequestError] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateMasterRoleRequestError(masterRoleRequestStruct, n);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateMasterRoleRequestError] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public void updatePasskeyState(final PasskeyStateStruct passkeyStateStruct, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updatePasskeyState] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updatePasskeyState(passkeyStateStruct, n);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updatePasskeyState] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public void updatePriorizedDeviceReconnect(final boolean bl, final String string, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updatePriorizedDeviceReconnect] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updatePriorizedDeviceReconnect(bl, string, n);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updatePriorizedDeviceReconnect] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public void updateReconnectIndicator(final ReconnectInfo reconnectInfo, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateReconnectIndicator] Called");
            if (reconnectInfo == null) {
                this.log.log(10000000, "[BluetoothDSIListener#updateReconnectIndicator] reconnectInfo is null! Ignoring update.");
            } else {
                CommandResponse.execute(this, new CommandResponse(){

                    public void call(DSIListener dSIListener) {
                        ((DSIBluetoothListener)dSIListener).updateReconnectIndicator(reconnectInfo, n);
                    }
                });
            }
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateReconnectIndicator] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public void updateServiceRequestState(final ServiceRequestStateStruct serviceRequestStateStruct, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateServiceRequestState] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateServiceRequestState(serviceRequestStateStruct, n);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateServiceRequestState] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public void updateSupportedBTProfiles(final int n, final int n2) {
        if (n2 == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateSupportedBTProfiles] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateSupportedBTProfiles(n, n2);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateSupportedBTProfiles] Data is not valid, valid flag value: %1", (long)n2);
        }
    }

    public void updateTrustedDevices(final TrustedDevice[] trustedDeviceArray, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateTrustedDevices] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateTrustedDevices(trustedDeviceArray, n);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateTrustedDevices] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public void updateUserFriendlyName(final String string, final int n) {
        if (n == 1) {
            this.log.log(10000000, "[BluetoothDSIListener#updateUserFriendlyName] Called");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIBluetoothListener)dSIListener).updateUserFriendlyName(string, n);
                }
            });
        } else {
            this.log.log(100000, "[BluetoothDSIListener#updateUserFriendlyName] Data is not valid, valid flag value: %1", (long)n);
        }
    }

    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    public DSIListener getDSIDefaultHandler() {
        return this.bluetoothDefaultListener;
    }

    public String getHandlerName() {
        return this.getClass().getName();
    }

    public LogChannel getLogChannel() {
        return this.log;
    }
}

