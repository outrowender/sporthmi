.version 50 0 
.class public super [141] 
.super [143] 
.field private final [144] [145] 
.field private final [146] [147] 
.field private final [148] [149] 

.method public [151] : [152] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [27] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [28] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [29] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [27] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [28] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [29] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [150] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [15] 
L12:    aload_0 
L13:    getfield [16] 
L16:    i2l 
L17:    invokevirtual [19] 
L20:    pop 
L21:    aload_0 
L22:    invokevirtual [20] 
L25:    aload_0 
L26:    getfield [15] 
L29:    aload_0 
L30:    getfield [16] 
L33:    invokeinterface [30] 0 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [150] .code stack 4 locals 0 
L0:     aload_1 
L1:     ifnonnull L28 
L4:     aload_0 
L5:     getfield [18] 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokevirtual [21] 
L15:    pop 
L16:    aload_0 
L17:    invokevirtual [22] 
L20:    ldc [6] 
L22:    invokeinterface [31] 0 
L27:    return 
L28:    aload_0 
L29:    getfield [18] 
L32:    ldc [2] 
L34:    ldc [7] 
L36:    aload_1 
L37:    invokevirtual [23] 
L40:    invokevirtual [24] 
L43:    pop 
L44:    aload_0 
L45:    getfield [17] 
L48:    ifnull L64 
L51:    aload_0 
L52:    getfield [17] 
L55:    aload_1 
L56:    invokeinterface [32] 0 
L61:    goto L69 
L64:    aload_0 
L65:    aload_1 
L66:    invokespecial [26] 
L69:    aload_0 
L70:    invokevirtual [22] 
L73:    invokeinterface [33] 0 
L78:    return 
L79:    nop 
L80:    
    .end code 
.end method 

.method public enum [159] : [160] 
    .attribute [150] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [34] 
.const [4] = Int -1601830656 
.const [5] = String [35] 
.const [6] = String [36] 
.const [7] = String [37] 
.const [8] = Class [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Field [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Field [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Field [69] [70] 
.const [28] = Field [71] [72] 
.const [29] = Field [73] [74] 
.const [30] = InterfaceMethod [75] [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = InterfaceMethod [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = Utf8 'ORSSetOnlineApplicationStateCommand#execute() applicationId: %1 state: %2' 
.const [35] = Utf8 'ORSSetOnlineApplicationStateCommand#getOnlineApplicationResponse() applicationId: %1 - app is null' 
.const [36] = Utf8 'getOnlineApplicationResponse failed' 
.const [37] = Utf8 'ORSSetOnlineApplicationStateCommand#getOnlineApplicationResponse() applicationId: %1' 
.const [38] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [39] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [40] = Utf8 de/audi/atip/log/LogChannel 
.const [41] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [42] = Utf8 de/audi/tghu/command/ICommandList 
.const [43] = Utf8 org/dsi/ifc/online/OSRApplication 
.const [44] = Utf8 de/audi/atip/interapp/online/IOnlineServiceListener 
.const [45] = Class [83] 
.const [46] = NameAndType [84] [85] 
.const [47] = Class [86] 
.const [48] = NameAndType [87] [88] 
.const [49] = Class [89] 
.const [50] = NameAndType [90] [91] 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Class [122] 
.const [72] = NameAndType [123] [124] 
.const [73] = Class [125] 
.const [74] = NameAndType [126] [127] 
.const [75] = Class [128] 
.const [76] = NameAndType [129] [130] 
.const [77] = Class [131] 
.const [78] = NameAndType [132] [133] 
.const [79] = Class [134] 
.const [80] = NameAndType [135] [136] 
.const [81] = Class [137] 
.const [82] = NameAndType [138] [139] 
.const [83] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [84] = Utf8 applicationId 
.const [85] = Utf8 Ljava/lang/String; 
.const [86] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [87] = Utf8 state 
.const [88] = Utf8 I 
.const [89] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [90] = Utf8 callback 
.const [91] = Utf8 Lde/audi/atip/interapp/online/IOnlineServiceListener; 
.const [92] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [93] = Utf8 logger 
.const [94] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 log 
.const [97] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [98] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [99] = Utf8 getDSI 
.const [100] = Utf8 ()Lorg/dsi/ifc/online/DSIOnlineServiceRegistration; 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (ILjava/lang/String;)Z 
.const [104] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [105] = Utf8 getCommandList 
.const [106] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [107] = Utf8 org/dsi/ifc/online/OSRApplication 
.const [108] = Utf8 getId 
.const [109] = Utf8 ()Ljava/lang/String; 
.const [110] = Utf8 de/audi/atip/log/LogChannel 
.const [111] = Utf8 log 
.const [112] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [113] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [117] = Utf8 getOnlineApplicationResponse 
.const [118] = Utf8 (Lorg/dsi/ifc/online/OSRApplication;)V 
.const [119] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [120] = Utf8 applicationId 
.const [121] = Utf8 Ljava/lang/String; 
.const [122] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [123] = Utf8 state 
.const [124] = Utf8 I 
.const [125] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [126] = Utf8 callback 
.const [127] = Utf8 Lde/audi/atip/interapp/online/IOnlineServiceListener; 
.const [128] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [129] = Utf8 setOnlineApplicationState 
.const [130] = Utf8 (Ljava/lang/String;I)V 
.const [131] = Utf8 de/audi/tghu/command/ICommandList 
.const [132] = Utf8 commandAborted 
.const [133] = Utf8 (Ljava/lang/String;)V 
.const [134] = Utf8 de/audi/atip/interapp/online/IOnlineServiceListener 
.const [135] = Utf8 getOnlineApplicationResponse 
.const [136] = Utf8 (Lorg/dsi/ifc/online/OSRApplication;)V 
.const [137] = Utf8 de/audi/tghu/command/ICommandList 
.const [138] = Utf8 commandFinished 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetOnlineApplicationStateCommand 
.const [141] = Class [140] 
.const [142] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [143] = Class [142] 
.const [144] = Utf8 applicationId 
.const [145] = Utf8 Ljava/lang/String; 
.const [146] = Utf8 state 
.const [147] = Utf8 I 
.const [148] = Utf8 callback 
.const [149] = Utf8 Lde/audi/atip/interapp/online/IOnlineServiceListener; 
.const [150] = Utf8 Code 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Ljava/lang/String;ILde/audi/atip/interapp/online/IOnlineServiceListener;)V 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (Ljava/lang/String;I)V 
.const [155] = Utf8 execute 
.const [156] = Utf8 ()V 
.const [157] = Utf8 getOnlineApplicationResponse 
.const [158] = Utf8 (Lorg/dsi/ifc/online/OSRApplication;)V 
.const [159] = Utf8 updateServiceList 
.const [160] = Utf8 ([Lorg/dsi/ifc/online/OSRServiceState;I)V 
.end class 
