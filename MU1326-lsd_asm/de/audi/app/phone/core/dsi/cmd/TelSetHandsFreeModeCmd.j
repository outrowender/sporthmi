.version 50 0 
.class public super [127] 
.super [129] 
.field private final [130] [131] 

.method public [133] : [134] 
    .attribute [132] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     aload_3 
L3:     ldc [2] 
L5:     iload 4 
L7:     aload 5 
L9:     invokespecial [26] 
L12:    aload_0 
L13:    iload_1 
L14:    putfield [28] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [132] .code stack 8 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     ldc [2] 
L4:     new [29] 
L7:     dup 
L8:     aload_0 
L9:     aload_0 
L10:    getfield [18] 
L13:    ldc [4] 
L15:    invokespecial [27] 
L18:    aload_2 
L19:    invokestatic [5] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [132] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     aload_0 
L9:     getfield [17] 
L12:    i2l 
L13:    invokevirtual [19] 
L16:    pop 
L17:    aload_0 
L18:    invokevirtual [20] 
L21:    ifeq L40 
L24:    aload_0 
L25:    getfield [21] 
L28:    aload_0 
L29:    getfield [17] 
L32:    invokeinterface [30] 0 
L37:    goto L61 
L40:    aload_0 
L41:    getfield [18] 
L44:    ldc [8] 
L46:    ldc [9] 
L48:    invokevirtual [22] 
L51:    pop 
L52:    aload_0 
L53:    invokevirtual [23] 
L56:    invokeinterface [31] 0 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [132] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [6] 
L6:     ldc [10] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [19] 
L13:    pop 
L14:    aload_0 
L15:    getfield [24] 
L18:    ifnull L35 
L21:    aload_0 
L22:    getfield [24] 
L25:    iload_1 
L26:    aload_0 
L27:    getfield [25] 
L30:    invokeinterface [32] 0 
L35:    aload_0 
L36:    invokevirtual [23] 
L39:    invokeinterface [31] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [33] 
.const [3] = Class [34] 
.const [4] = String [35] 
.const [5] = Method [36] [37] 
.const [6] = Int 1078071040 
.const [7] = String [38] 
.const [8] = Int -1601830656 
.const [9] = String [39] 
.const [10] = String [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Class [45] 
.const [16] = Class [46] 
.const [17] = Field [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Field [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Field [61] [62] 
.const [25] = Field [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Field [69] [70] 
.const [29] = Class [71] 
.const [30] = InterfaceMethod [72] [73] 
.const [31] = InterfaceMethod [74] [75] 
.const [32] = InterfaceMethod [76] [77] 
.const [33] = Utf8 TelSetHandsFreeModeCmd 
.const [34] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd$1 
.const [35] = Utf8 TelSetHandsFreeModeCmdError 
.const [36] = Class [78] 
.const [37] = NameAndType [79] [80] 
.const [38] = Utf8 '[TelSetHandsFreeModeCmd#execute] telHFMode=%1' 
.const [39] = Utf8 '[TelSetHandsFreeModeCmd#execute] dsi is null!' 
.const [40] = Utf8 '[TelSetHandsFreeModeCmd#responseSetHandsFreeMode] result=%1' 
.const [41] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [42] = Utf8 de/audi/app/phone/core/dsi/cmd/AbstractTelDSIMECommand 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper 
.const [45] = Utf8 de/audi/tghu/command/ICommandList 
.const [46] = Utf8 de/audi/app/phone/core/dsi/ITelDSIResponseListener 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Class [84] 
.const [50] = NameAndType [85] [86] 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Class [90] 
.const [54] = NameAndType [91] [92] 
.const [55] = Class [93] 
.const [56] = NameAndType [94] [95] 
.const [57] = Class [96] 
.const [58] = NameAndType [97] [98] 
.const [59] = Class [99] 
.const [60] = NameAndType [100] [101] 
.const [61] = Class [102] 
.const [62] = NameAndType [103] [104] 
.const [63] = Class [105] 
.const [64] = NameAndType [106] [107] 
.const [65] = Class [108] 
.const [66] = NameAndType [109] [110] 
.const [67] = Class [111] 
.const [68] = NameAndType [112] [113] 
.const [69] = Class [114] 
.const [70] = NameAndType [115] [116] 
.const [71] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd$1 
.const [72] = Class [117] 
.const [73] = NameAndType [118] [119] 
.const [74] = Class [120] 
.const [75] = NameAndType [121] [122] 
.const [76] = Class [123] 
.const [77] = NameAndType [124] [125] 
.const [78] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [79] = Utf8 schedule 
.const [80] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/tghu/command/Command;Ljava/lang/String;Lde/audi/tghu/command/Command;Lde/audi/tghu/command/Monitor;)V 
.const [81] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [82] = Utf8 telHFMode 
.const [83] = Utf8 I 
.const [84] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [85] = Utf8 logger 
.const [86] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [87] = Utf8 de/audi/atip/log/LogChannel 
.const [88] = Utf8 log 
.const [89] = Utf8 (ILjava/lang/String;J)Z 
.const [90] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [91] = Utf8 isDSIAvailable 
.const [92] = Utf8 ()Z 
.const [93] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [94] = Utf8 dsi 
.const [95] = Utf8 Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper; 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 log 
.const [98] = Utf8 (ILjava/lang/String;)Z 
.const [99] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [100] = Utf8 getCommandList 
.const [101] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [102] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [103] = Utf8 listener 
.const [104] = Utf8 Lde/audi/app/phone/core/dsi/ITelDSIResponseListener; 
.const [105] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [106] = Utf8 terminalID 
.const [107] = Utf8 I 
.const [108] = Utf8 de/audi/app/phone/core/dsi/cmd/AbstractTelDSIMECommand 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper;Lde/audi/atip/log/LogChannel;Ljava/lang/String;ILde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [111] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd$1 
.const [112] = Utf8 <init> 
.const [113] = Utf8 (Lde/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd;Lde/audi/atip/log/LogChannel;Ljava/lang/String;)V 
.const [114] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [115] = Utf8 telHFMode 
.const [116] = Utf8 I 
.const [117] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper 
.const [118] = Utf8 requestSetHandsFreeMode 
.const [119] = Utf8 (I)V 
.const [120] = Utf8 de/audi/tghu/command/ICommandList 
.const [121] = Utf8 commandFinished 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/audi/app/phone/core/dsi/ITelDSIResponseListener 
.const [124] = Utf8 responseSetHandsFreeMode 
.const [125] = Utf8 (II)V 
.const [126] = Utf8 de/audi/app/phone/core/dsi/cmd/TelSetHandsFreeModeCmd 
.const [127] = Class [126] 
.const [128] = Utf8 de/audi/app/phone/core/dsi/cmd/AbstractTelDSIMECommand 
.const [129] = Class [128] 
.const [130] = Utf8 telHFMode 
.const [131] = Utf8 I 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (ILde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentRequestWrapper;Lde/audi/atip/log/LogChannel;ILde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [135] = Utf8 schedule 
.const [136] = Utf8 (Lde/audi/tghu/command/CommandListManager;Lde/audi/tghu/command/Monitor;)V 
.const [137] = Utf8 execute 
.const [138] = Utf8 ()V 
.const [139] = Utf8 responseSetHandsFreeMode 
.const [140] = Utf8 (I)V 
.end class 
