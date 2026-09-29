.version 50 0 
.class super [84] 
.super [86] 
.field private [87] [88] 
.field private final synthetic [89] [90] 

.method private [92] : [93] 
    .attribute [91] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [18] 
L5:     aload_0 
L6:     invokespecial [17] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [19] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [94] : [95] 
    .attribute [91] .code stack 3 locals 0 
L0:     iload_1 
L1:     iconst_2 
L2:     if_icmpne L36 
L5:     aload_0 
L6:     getfield [13] 
L9:     invokestatic [2] 
L12:    ldc [3] 
L14:    ldc [4] 
L16:    invokevirtual [15] 
L19:    pop 
L20:    aload_0 
L21:    getfield [13] 
L24:    invokestatic [5] 
L27:    iconst_1 
L28:    invokeinterface [20] 0 
L33:    goto L95 
L36:    aload_0 
L37:    getfield [14] 
L40:    iconst_2 
L41:    if_icmpeq L52 
L44:    aload_0 
L45:    getfield [14] 
L48:    iconst_3 
L49:    if_icmpne L95 
L52:    iload_1 
L53:    ifeq L61 
L56:    iload_1 
L57:    iconst_4 
L58:    if_icmpne L95 
L61:    aload_0 
L62:    getfield [13] 
L65:    invokestatic [2] 
L68:    ldc [3] 
L70:    ldc [6] 
L72:    invokevirtual [15] 
L75:    pop 
L76:    aload_0 
L77:    getfield [13] 
L80:    invokestatic [5] 
L83:    aload_0 
L84:    getfield [13] 
L87:    invokestatic [7] 
L90:    invokeinterface [20] 0 
L95:    aload_0 
L96:    iload_1 
L97:    putfield [19] 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method synthetic [96] : [97] 
    .attribute [91] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [16] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [21] [22] 
.const [3] = Int 1078071040 
.const [4] = String [23] 
.const [5] = Method [24] [25] 
.const [6] = String [26] 
.const [7] = Method [27] [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Class [32] 
.const [12] = Class [33] 
.const [13] = Field [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Field [46] [47] 
.const [20] = InterfaceMethod [48] [49] 
.const [21] = Class [50] 
.const [22] = NameAndType [51] [52] 
.const [23] = Utf8 '[WirelessChargingPowerEventListener#notifyPowerListenerOnEnterState] going standby.' 
.const [24] = Class [53] 
.const [25] = NameAndType [54] [55] 
.const [26] = Utf8 '[WirelessChargingPowerEventListener#notifyPowerListenerOnEnterState] starting from standby. Update the wireless information with the latest recieved value.' 
.const [27] = Class [56] 
.const [28] = NameAndType [57] [58] 
.const [29] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [30] = Utf8 de/audi/atip/power/DefaultPowerEventListener 
.const [31] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [32] = Utf8 de/audi/atip/log/LogChannel 
.const [33] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler 
.const [34] = Class [59] 
.const [35] = NameAndType [60] [61] 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Class [80] 
.const [49] = NameAndType [81] [82] 
.const [50] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [51] = Utf8 access$100 
.const [52] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)Lde/audi/atip/log/LogChannel; 
.const [53] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [54] = Utf8 access$200 
.const [55] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)Lde/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler; 
.const [56] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [57] = Utf8 access$300 
.const [58] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)I 
.const [59] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [60] = Utf8 this$0 
.const [61] = Utf8 Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler; 
.const [62] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [63] = Utf8 lastPwrState 
.const [64] = Utf8 I 
.const [65] = Utf8 de/audi/atip/log/LogChannel 
.const [66] = Utf8 log 
.const [67] = Utf8 (ILjava/lang/String;)Z 
.const [68] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [69] = Utf8 <init> 
.const [70] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)V 
.const [71] = Utf8 de/audi/atip/power/DefaultPowerEventListener 
.const [72] = Utf8 <init> 
.const [73] = Utf8 ()V 
.const [74] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [75] = Utf8 this$0 
.const [76] = Utf8 Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler; 
.const [77] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [78] = Utf8 lastPwrState 
.const [79] = Utf8 I 
.const [80] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler 
.const [81] = Utf8 updateStatusBar 
.const [82] = Utf8 (I)V 
.const [83] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [84] = Class [83] 
.const [85] = Utf8 de/audi/atip/power/DefaultPowerEventListener 
.const [86] = Class [85] 
.const [87] = Utf8 lastPwrState 
.const [88] = Utf8 I 
.const [89] = Utf8 this$0 
.const [90] = Utf8 Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler; 
.const [91] = Utf8 Code 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)V 
.const [94] = Utf8 notifyPowerListenerOnEnterState 
.const [95] = Utf8 (II)V 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$1;)V 
.end class 
