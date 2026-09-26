.version 50 0 
.class public super [130] 
.super [132] 
.field private [133] [134] 
.field [135] [136] 

.method public [138] : [139] 
    .attribute [137] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [25] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [26] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [140] : [141] 
    .attribute [137] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [16] 
L4:     astore_1 
L5:     aload_0 
L6:     getfield [14] 
L9:     ifnull L22 
L12:    aload_0 
L13:    getfield [14] 
L16:    invokevirtual [17] 
L19:    ifne L46 
L22:    aload_0 
L23:    getfield [18] 
L26:    sipush 10000 
L29:    ldc [2] 
L31:    invokevirtual [19] 
L34:    pop 
L35:    aload_0 
L36:    invokevirtual [20] 
L39:    lconst_1 
L40:    invokeinterface [27] 0 
L45:    return 
L46:    aload_1 
L47:    ifnonnull L64 
L50:    aload_0 
L51:    getfield [18] 
L54:    sipush 10000 
L57:    ldc [3] 
L59:    invokevirtual [19] 
L62:    pop 
L63:    return 
L64:    aload_0 
L65:    getfield [18] 
L68:    ldc [4] 
L70:    new [28] 
L73:    dup 
L74:    invokespecial [24] 
L77:    ldc [6] 
L79:    invokevirtual [21] 
L82:    aload_0 
L83:    getfield [14] 
L86:    invokevirtual [21] 
L89:    invokevirtual [22] 
L92:    invokevirtual [19] 
L95:    pop 
L96:    aload_1 
L97:    aload_0 
L98:    getfield [14] 
L101:   invokeinterface [29] 0 
L106:   return 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [137] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_1 
L5:     iload_2 
L6:     invokeinterface [30] 0 
L11:    aload_0 
L12:    invokevirtual [20] 
L15:    invokeinterface [31] 0 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public enum [144] : [145] 
    .attribute [137] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [32] 
.const [3] = String [33] 
.const [4] = Int 1078071040 
.const [5] = Class [34] 
.const [6] = String [35] 
.const [7] = Class [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Field [43] [44] 
.const [15] = Field [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Field [65] [66] 
.const [26] = Field [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = Class [71] 
.const [29] = InterfaceMethod [72] [73] 
.const [30] = InterfaceMethod [74] [75] 
.const [31] = InterfaceMethod [76] [77] 
.const [32] = Utf8 'PerformPortalRegistrationCommand#execute() no user to log in... do nothing' 
.const [33] = Utf8 'PerformPortalRegistrationCommand#execute() no dsi' 
.const [34] = Utf8 java/lang/StringBuffer 
.const [35] = Utf8 'PerformPortalRegistrationCommand#execute() registering: ' 
.const [36] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand 
.const [37] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [38] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener 
.const [39] = Utf8 java/lang/String 
.const [40] = Utf8 de/audi/atip/log/LogChannel 
.const [41] = Utf8 de/audi/tghu/command/ICommandList 
.const [42] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Class [96] 
.const [56] = NameAndType [97] [98] 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Class [102] 
.const [60] = NameAndType [103] [104] 
.const [61] = Class [105] 
.const [62] = NameAndType [106] [107] 
.const [63] = Class [108] 
.const [64] = NameAndType [109] [110] 
.const [65] = Class [111] 
.const [66] = NameAndType [112] [113] 
.const [67] = Class [114] 
.const [68] = NameAndType [115] [116] 
.const [69] = Class [117] 
.const [70] = NameAndType [118] [119] 
.const [71] = Utf8 java/lang/StringBuffer 
.const [72] = Class [120] 
.const [73] = NameAndType [121] [122] 
.const [74] = Class [123] 
.const [75] = NameAndType [124] [125] 
.const [76] = Class [126] 
.const [77] = NameAndType [127] [128] 
.const [78] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand 
.const [79] = Utf8 email 
.const [80] = Utf8 Ljava/lang/String; 
.const [81] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand 
.const [82] = Utf8 listener 
.const [83] = Utf8 Lde/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener; 
.const [84] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand 
.const [85] = Utf8 getDSI 
.const [86] = Utf8 ()Lorg/dsi/ifc/online/DSIOnlineServiceRegistration; 
.const [87] = Utf8 java/lang/String 
.const [88] = Utf8 length 
.const [89] = Utf8 ()I 
.const [90] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand 
.const [91] = Utf8 logger 
.const [92] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [93] = Utf8 de/audi/atip/log/LogChannel 
.const [94] = Utf8 log 
.const [95] = Utf8 (ILjava/lang/String;)Z 
.const [96] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand 
.const [97] = Utf8 getCommandList 
.const [98] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [99] = Utf8 java/lang/StringBuffer 
.const [100] = Utf8 append 
.const [101] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [102] = Utf8 java/lang/StringBuffer 
.const [103] = Utf8 toString 
.const [104] = Utf8 ()Ljava/lang/String; 
.const [105] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 java/lang/StringBuffer 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand 
.const [112] = Utf8 email 
.const [113] = Utf8 Ljava/lang/String; 
.const [114] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand 
.const [115] = Utf8 listener 
.const [116] = Utf8 Lde/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener; 
.const [117] = Utf8 de/audi/tghu/command/ICommandList 
.const [118] = Utf8 commandAborted 
.const [119] = Utf8 (J)V 
.const [120] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [121] = Utf8 performPortalRegistration 
.const [122] = Utf8 (Ljava/lang/String;)V 
.const [123] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener 
.const [124] = Utf8 performPortalRegistrationResponse 
.const [125] = Utf8 (Ljava/lang/String;I)V 
.const [126] = Utf8 de/audi/tghu/command/ICommandList 
.const [127] = Utf8 commandFinished 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand 
.const [130] = Class [129] 
.const [131] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [132] = Class [131] 
.const [133] = Utf8 email 
.const [134] = Utf8 Ljava/lang/String; 
.const [135] = Utf8 listener 
.const [136] = Utf8 Lde/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener; 
.const [137] = Utf8 Code 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (Ljava/lang/String;Lde/audi/tghu/online/app/osr/command/auth/PerformPortalRegistrationCommand$PerformPortalRegistrationCommandResponseListener;)V 
.const [140] = Utf8 execute 
.const [141] = Utf8 ()V 
.const [142] = Utf8 performPortalRegistrationResponse 
.const [143] = Utf8 (Ljava/lang/String;I)V 
.const [144] = Utf8 updateServiceList 
.const [145] = Utf8 ([Lorg/dsi/ifc/online/OSRServiceState;I)V 
.end class 
