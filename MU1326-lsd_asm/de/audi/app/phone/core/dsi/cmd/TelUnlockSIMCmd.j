.version 50 0 
.class public super [178] 
.super [180] 
.field private static final [181] [182] 
.field private final [183] [184] 
.field private final [185] [186] 
.field private final [187] [188] 
.field private volatile [189] [190] 

.method public [192] : [193] 
    .attribute [191] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload 4 
L3:     aload 5 
L5:     ldc [2] 
L7:     iload 6 
L9:     aload 7 
L11:    invokespecial [32] 
L14:    aload_0 
L15:    iload_1 
L16:    putfield [34] 
L19:    aload_0 
L20:    aload_2 
L21:    putfield [35] 
L24:    aload_0 
L25:    aload_3 
L26:    putfield [36] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [191] .code stack 2 locals 0 
L0:     ldc_w [1] 
L3:     freturn 
L4:     
    .end code 
.end method 

.method public [196] : [197] 
    .attribute [191] .code stack 8 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     ldc [2] 
L4:     new [37] 
L7:     dup 
L8:     aload_0 
L9:     aload_0 
L10:    getfield [21] 
L13:    ldc [4] 
L15:    invokespecial [33] 
L18:    aload_2 
L19:    invokestatic [5] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [198] : [199] 
    .attribute [191] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     aload_0 
L9:     getfield [19] 
L12:    aload_0 
L13:    getfield [20] 
L16:    aload_0 
L17:    getfield [18] 
L20:    i2l 
L21:    invokevirtual [22] 
L24:    aload_0 
L25:    invokevirtual [23] 
L28:    ifeq L55 
L31:    aload_0 
L32:    getfield [24] 
L35:    aload_0 
L36:    getfield [18] 
L39:    aload_0 
L40:    getfield [19] 
L43:    aload_0 
L44:    getfield [20] 
L47:    invokeinterface [38] 0 
L52:    goto L76 
L55:    aload_0 
L56:    getfield [21] 
L59:    ldc [8] 
L61:    ldc [9] 
L63:    invokevirtual [25] 
L66:    pop 
L67:    aload_0 
L68:    invokevirtual [26] 
L71:    invokeinterface [39] 0 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [191] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [6] 
L6:     ldc [10] 
L8:     aload_1 
L9:     invokevirtual [27] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [40] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [191] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [6] 
L6:     ldc [11] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [29] 
L13:    pop 
L14:    aload_0 
L15:    getfield [30] 
L18:    ifnull L39 
L21:    aload_0 
L22:    getfield [30] 
L25:    iload_1 
L26:    aload_0 
L27:    getfield [31] 
L30:    aload_0 
L31:    getfield [28] 
L34:    invokeinterface [41] 0 
L39:    aload_0 
L40:    invokevirtual [26] 
L43:    invokeinterface [39] 0 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [43] 
.const [3] = Class [44] 
.const [4] = String [45] 
.const [5] = Method [46] [47] 
.const [6] = Int 1078071040 
.const [7] = String [48] 
.const [8] = Int -1601830656 
.const [9] = String [49] 
.const [10] = String [50] 
.const [11] = String [51] 
.const [12] = Class [52] 
.const [13] = Class [53] 
.const [14] = Class [54] 
.const [15] = Class [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Field [58] [59] 
.const [19] = Field [60] [61] 
.const [20] = Field [62] [63] 
.const [21] = Field [64] [65] 
.const [22] = Method [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Field [70] [71] 
.const [25] = Method [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Field [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Field [82] [83] 
.const [31] = Field [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Field [92] [93] 
.const [36] = Field [94] [95] 
.const [37] = Class [96] 
.const [38] = InterfaceMethod [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = Field [101] [102] 
.const [41] = InterfaceMethod [103] [104] 
.const [42] = Int -263650816 
.const [43] = Utf8 TelUnlockSIMCmd 
.const [44] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd$1 
.const [45] = Utf8 TelUnlockSIMCmdError 
.const [46] = Class [105] 
.const [47] = NameAndType [106] [107] 
.const [48] = Utf8 '[TelUnlockSIMCmd#execute] lockCode=%3, currentCode=%1, newCode=%2' 
.const [49] = Utf8 '[TelUnlockSIMCmd#execute] dsi is null!' 
.const [50] = Utf8 '[TelUnlockSIMCmd#updateLockState] lockState=%1' 
.const [51] = Utf8 '[TelUnlockSIMCmd#responseUnlockSIM] result=%1' 
.const [52] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [53] = Utf8 de/audi/app/phone/core/dsi/cmd/AbstractTelDSIMECommand 
.const [54] = Utf8 de/audi/atip/log/LogChannel 
.const [55] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper 
.const [56] = Utf8 de/audi/tghu/command/ICommandList 
.const [57] = Utf8 de/audi/app/phone/core/dsi/ITelDSIResponseListener 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd$1 
.const [97] = Class [165] 
.const [98] = NameAndType [166] [167] 
.const [99] = Class [168] 
.const [100] = NameAndType [169] [170] 
.const [101] = Class [171] 
.const [102] = NameAndType [172] [173] 
.const [103] = Class [174] 
.const [104] = NameAndType [175] [176] 
.const [105] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [106] = Utf8 schedule 
.const [107] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/tghu/command/Command;Ljava/lang/String;Lde/audi/tghu/command/Command;Lde/audi/tghu/command/Monitor;)V 
.const [108] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [109] = Utf8 telLockCode 
.const [110] = Utf8 I 
.const [111] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [112] = Utf8 telCurrentCode 
.const [113] = Utf8 Ljava/lang/String; 
.const [114] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [115] = Utf8 telNewCode 
.const [116] = Utf8 Ljava/lang/String; 
.const [117] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [118] = Utf8 logger 
.const [119] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 log 
.const [122] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [123] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [124] = Utf8 isDSIAvailable 
.const [125] = Utf8 ()Z 
.const [126] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [127] = Utf8 dsi 
.const [128] = Utf8 Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper; 
.const [129] = Utf8 de/audi/atip/log/LogChannel 
.const [130] = Utf8 log 
.const [131] = Utf8 (ILjava/lang/String;)Z 
.const [132] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [133] = Utf8 getCommandList 
.const [134] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [135] = Utf8 de/audi/atip/log/LogChannel 
.const [136] = Utf8 log 
.const [137] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [138] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [139] = Utf8 lockState 
.const [140] = Utf8 Lorg/dsi/ifc/telephoneng/LockStateStruct; 
.const [141] = Utf8 de/audi/atip/log/LogChannel 
.const [142] = Utf8 log 
.const [143] = Utf8 (ILjava/lang/String;J)Z 
.const [144] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [145] = Utf8 listener 
.const [146] = Utf8 Lde/audi/app/phone/core/dsi/ITelDSIResponseListener; 
.const [147] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [148] = Utf8 terminalID 
.const [149] = Utf8 I 
.const [150] = Utf8 de/audi/app/phone/core/dsi/cmd/AbstractTelDSIMECommand 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper;Lde/audi/atip/log/LogChannel;Ljava/lang/String;ILde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [153] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd$1 
.const [154] = Utf8 <init> 
.const [155] = Utf8 (Lde/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd;Lde/audi/atip/log/LogChannel;Ljava/lang/String;)V 
.const [156] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [157] = Utf8 telLockCode 
.const [158] = Utf8 I 
.const [159] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [160] = Utf8 telCurrentCode 
.const [161] = Utf8 Ljava/lang/String; 
.const [162] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [163] = Utf8 telNewCode 
.const [164] = Utf8 Ljava/lang/String; 
.const [165] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper 
.const [166] = Utf8 requestUnlockSIM 
.const [167] = Utf8 (ILjava/lang/String;Ljava/lang/String;)V 
.const [168] = Utf8 de/audi/tghu/command/ICommandList 
.const [169] = Utf8 commandFinished 
.const [170] = Utf8 ()V 
.const [171] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [172] = Utf8 lockState 
.const [173] = Utf8 Lorg/dsi/ifc/telephoneng/LockStateStruct; 
.const [174] = Utf8 de/audi/app/phone/core/dsi/ITelDSIResponseListener 
.const [175] = Utf8 responseUnlockSIM 
.const [176] = Utf8 (IILorg/dsi/ifc/telephoneng/LockStateStruct;)V 
.const [177] = Utf8 de/audi/app/phone/core/dsi/cmd/TelUnlockSIMCmd 
.const [178] = Class [177] 
.const [179] = Utf8 de/audi/app/phone/core/dsi/cmd/AbstractTelDSIMECommand 
.const [180] = Class [179] 
.const [181] = Utf8 TIMEOUT 
.const [182] = Utf8 J 
.const [183] = Utf8 telLockCode 
.const [184] = Utf8 I 
.const [185] = Utf8 telCurrentCode 
.const [186] = Utf8 Ljava/lang/String; 
.const [187] = Utf8 telNewCode 
.const [188] = Utf8 Ljava/lang/String; 
.const [189] = Utf8 lockState 
.const [190] = Utf8 Lorg/dsi/ifc/telephoneng/LockStateStruct; 
.const [191] = Utf8 Code 
.const [192] = Utf8 <init> 
.const [193] = Utf8 (ILjava/lang/String;Ljava/lang/String;Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper;Lde/audi/atip/log/LogChannel;ILde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [194] = Utf8 getTimeout 
.const [195] = Utf8 ()J 
.const [196] = Utf8 schedule 
.const [197] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/tghu/command/Monitor;)V 
.const [198] = Utf8 execute 
.const [199] = Utf8 ()V 
.const [200] = Utf8 updateLockState 
.const [201] = Utf8 (Lorg/dsi/ifc/telephoneng/LockStateStruct;I)V 
.const [202] = Utf8 responseUnlockSIM 
.const [203] = Utf8 (I)V 
.end class 
