.version 50 0 
.class public super [135] 
.super [137] 
.field private final [138] [139] 
.field private final [140] [141] 

.method public [143] : [144] 
    .attribute [142] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [29] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [30] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [142] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [20] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [21] 
L16:    aload_0 
L17:    getfield [17] 
L20:    aload_0 
L21:    getfield [18] 
L24:    invokeinterface [31] 0 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [142] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     aload_1 
L9:     ifnull L19 
L12:    aload_1 
L13:    invokevirtual [22] 
L16:    goto L20 
L19:    aconst_null 
L20:    invokevirtual [23] 
L23:    pop 
L24:    aload_1 
L25:    ifnull L38 
L28:    aload_0 
L29:    aload_1 
L30:    invokespecial [27] 
L33:    aload_0 
L34:    aload_1 
L35:    invokespecial [28] 
L38:    aload_0 
L39:    invokevirtual [24] 
L42:    invokeinterface [32] 0 
L47:    return 
L48:    
    .end code 
.end method 

.method private [149] : [150] 
    .attribute [142] .code stack 7 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     invokevirtual [20] 
L11:    pop 
L12:    aload_0 
L13:    getfield [18] 
L16:    aload_0 
L17:    getfield [19] 
L20:    invokestatic [6] 
L23:    istore_2 
L24:    aload_1 
L25:    aload_0 
L26:    getfield [19] 
L29:    invokestatic [7] 
L32:    istore_3 
L33:    iload_2 
L34:    iload_3 
L35:    if_icmpeq L54 
L38:    aload_0 
L39:    getfield [19] 
L42:    ldc [8] 
L44:    ldc [9] 
L46:    iload_3 
L47:    i2l 
L48:    iload_2 
L49:    i2l 
L50:    invokevirtual [25] 
L53:    pop 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public enum [151] : [152] 
    .attribute [142] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [33] 
.const [4] = String [34] 
.const [5] = String [35] 
.const [6] = Method [36] [37] 
.const [7] = Method [38] [39] 
.const [8] = Int -1601830656 
.const [9] = String [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Class [47] 
.const [17] = Field [48] [49] 
.const [18] = Field [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Method [66] [67] 
.const [27] = Method [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Field [72] [73] 
.const [30] = Field [74] [75] 
.const [31] = InterfaceMethod [76] [77] 
.const [32] = InterfaceMethod [78] [79] 
.const [33] = Utf8 '[ORSSetApplicationPropertiesCommand#execute] enter' 
.const [34] = Utf8 '[ORSSetApplicationPropertiesCommand#getOnlineApplicationResponse] application:%1' 
.const [35] = Utf8 '[ORSSetApplicationPropertiesCommand#getOnlineApplicationResponse]' 
.const [36] = Class [80] 
.const [37] = NameAndType [81] [82] 
.const [38] = Class [83] 
.const [39] = NameAndType [84] [85] 
.const [40] = Utf8 '[ORSSetApplicationPropertiesCommand#getOnlineApplicationResponse] - different reminder state expected! current %1, expected %2' 
.const [41] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [42] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [45] = Utf8 org/dsi/ifc/online/OSRApplication 
.const [46] = Utf8 de/audi/tghu/command/ICommandList 
.const [47] = Utf8 de/audi/tghu/online/app/osr/OnlineServiceRegistrationHelper 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Class [98] 
.const [57] = NameAndType [99] [100] 
.const [58] = Class [101] 
.const [59] = NameAndType [102] [103] 
.const [60] = Class [104] 
.const [61] = NameAndType [105] [106] 
.const [62] = Class [107] 
.const [63] = NameAndType [108] [109] 
.const [64] = Class [110] 
.const [65] = NameAndType [111] [112] 
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Class [116] 
.const [69] = NameAndType [117] [118] 
.const [70] = Class [119] 
.const [71] = NameAndType [120] [121] 
.const [72] = Class [122] 
.const [73] = NameAndType [123] [124] 
.const [74] = Class [125] 
.const [75] = NameAndType [126] [127] 
.const [76] = Class [128] 
.const [77] = NameAndType [129] [130] 
.const [78] = Class [131] 
.const [79] = NameAndType [132] [133] 
.const [80] = Utf8 de/audi/tghu/online/app/osr/OnlineServiceRegistrationHelper 
.const [81] = Utf8 getReminderStatus 
.const [82] = Utf8 ([Lorg/dsi/ifc/online/OSRApplicationProperties;Lde/audi/atip/log/LogChannel;)I 
.const [83] = Utf8 de/audi/tghu/online/app/osr/OnlineServiceRegistrationHelper 
.const [84] = Utf8 getReminderStatus 
.const [85] = Utf8 (Lorg/dsi/ifc/online/OSRApplication;Lde/audi/atip/log/LogChannel;)I 
.const [86] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [87] = Utf8 applicationId 
.const [88] = Utf8 Ljava/lang/String; 
.const [89] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [90] = Utf8 propertyList 
.const [91] = Utf8 [Lorg/dsi/ifc/online/OSRApplicationProperties; 
.const [92] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [93] = Utf8 logger 
.const [94] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 log 
.const [97] = Utf8 (ILjava/lang/String;)Z 
.const [98] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [99] = Utf8 getDSI 
.const [100] = Utf8 ()Lorg/dsi/ifc/online/DSIOnlineServiceRegistration; 
.const [101] = Utf8 org/dsi/ifc/online/OSRApplication 
.const [102] = Utf8 getId 
.const [103] = Utf8 ()Ljava/lang/String; 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 log 
.const [106] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [107] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [108] = Utf8 getCommandList 
.const [109] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [110] = Utf8 de/audi/atip/log/LogChannel 
.const [111] = Utf8 log 
.const [112] = Utf8 (ILjava/lang/String;JJ)Z 
.const [113] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [117] = Utf8 getOnlineApplicationResponse 
.const [118] = Utf8 (Lorg/dsi/ifc/online/OSRApplication;)V 
.const [119] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [120] = Utf8 checkReminderResponse 
.const [121] = Utf8 (Lorg/dsi/ifc/online/OSRApplication;)V 
.const [122] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [123] = Utf8 applicationId 
.const [124] = Utf8 Ljava/lang/String; 
.const [125] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [126] = Utf8 propertyList 
.const [127] = Utf8 [Lorg/dsi/ifc/online/OSRApplicationProperties; 
.const [128] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [129] = Utf8 setApplicationProperties 
.const [130] = Utf8 (Ljava/lang/String;[Lorg/dsi/ifc/online/OSRApplicationProperties;)V 
.const [131] = Utf8 de/audi/tghu/command/ICommandList 
.const [132] = Utf8 commandFinished 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/audi/tghu/online/app/osr/command/OSRSetApplicationPropertiesCommand 
.const [135] = Class [134] 
.const [136] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [137] = Class [136] 
.const [138] = Utf8 applicationId 
.const [139] = Utf8 Ljava/lang/String; 
.const [140] = Utf8 propertyList 
.const [141] = Utf8 [Lorg/dsi/ifc/online/OSRApplicationProperties; 
.const [142] = Utf8 Code 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Ljava/lang/String;[Lorg/dsi/ifc/online/OSRApplicationProperties;)V 
.const [145] = Utf8 execute 
.const [146] = Utf8 ()V 
.const [147] = Utf8 getOnlineApplicationResponse 
.const [148] = Utf8 (Lorg/dsi/ifc/online/OSRApplication;)V 
.const [149] = Utf8 checkReminderResponse 
.const [150] = Utf8 (Lorg/dsi/ifc/online/OSRApplication;)V 
.const [151] = Utf8 updateServiceList 
.const [152] = Utf8 ([Lorg/dsi/ifc/online/OSRServiceState;I)V 
.end class 
