.version 50 0 
.class public super [146] 
.super [148] 
.field private [149] [150] 
.field private [151] [152] 
.field private [153] [154] 

.method public [156] : [157] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [29] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [30] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [31] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [155] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     astore_1 
L5:     aload_0 
L6:     getfield [16] 
L9:     ifnonnull L26 
L12:    aload_0 
L13:    getfield [20] 
L16:    sipush 10000 
L19:    ldc [2] 
L21:    invokevirtual [21] 
L24:    pop 
L25:    return 
L26:    aload_0 
L27:    getfield [17] 
L30:    ifnull L41 
L33:    aload_0 
L34:    getfield [17] 
L37:    arraylength 
L38:    ifne L55 
L41:    aload_0 
L42:    getfield [20] 
L45:    sipush 10000 
L48:    ldc [3] 
L50:    invokevirtual [21] 
L53:    pop 
L54:    return 
L55:    aload_1 
L56:    ifnonnull L73 
L59:    aload_0 
L60:    getfield [20] 
L63:    sipush 10000 
L66:    ldc [4] 
L68:    invokevirtual [21] 
L71:    pop 
L72:    return 
L73:    aload_0 
L74:    getfield [20] 
L77:    ldc [5] 
L79:    new [32] 
L82:    dup 
L83:    invokespecial [28] 
L86:    ldc [7] 
L88:    invokevirtual [22] 
L91:    aload_0 
L92:    getfield [16] 
L95:    invokevirtual [23] 
L98:    invokevirtual [22] 
L101:   ldc [8] 
L103:   invokevirtual [22] 
L106:   aload_0 
L107:   getfield [17] 
L110:   arraylength 
L111:   invokevirtual [24] 
L114:   invokevirtual [25] 
L117:   invokevirtual [21] 
L120:   pop 
L121:   aload_1 
L122:   aload_0 
L123:   getfield [16] 
L126:   aload_0 
L127:   getfield [17] 
L130:   invokeinterface [33] 0 
L135:   return 
L136:   
    .end code 
.end method 

.method public [160] : [161] 
    .attribute [155] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifnull L18 
L7:     aload_0 
L8:     getfield [18] 
L11:    aload_1 
L12:    aload_3 
L13:    invokeinterface [34] 0 
L18:    aload_0 
L19:    invokevirtual [26] 
L22:    invokeinterface [35] 0 
L27:    return 
L28:    
    .end code 
.end method 

.method public enum [162] : [163] 
    .attribute [155] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [36] 
.const [3] = String [37] 
.const [4] = String [38] 
.const [5] = Int 1078071040 
.const [6] = Class [39] 
.const [7] = String [40] 
.const [8] = String [41] 
.const [9] = Class [42] 
.const [10] = Class [43] 
.const [11] = Class [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Field [49] [50] 
.const [17] = Field [51] [52] 
.const [18] = Field [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Field [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Field [75] [76] 
.const [30] = Field [77] [78] 
.const [31] = Field [79] [80] 
.const [32] = Class [81] 
.const [33] = InterfaceMethod [82] [83] 
.const [34] = InterfaceMethod [84] [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = Utf8 'SetAutoLoginCommand#execute() no user to log in... do nothing' 
.const [37] = Utf8 'SetAutoLoginCommand#execute()no devices to connect with autoLogin ... do nothing' 
.const [38] = Utf8 'SetAutoLoginCommand#execute() no dsi' 
.const [39] = Utf8 java/lang/StringBuffer 
.const [40] = Utf8 'SetAutoLoginCommand#execute() for user ' 
.const [41] = Utf8 ' deviceCount: ' 
.const [42] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [43] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [44] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand$SetAutoLoginCommandResponseListener 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 org/dsi/ifc/online/OSRUser 
.const [47] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [48] = Utf8 de/audi/tghu/command/ICommandList 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Class [124] 
.const [74] = NameAndType [125] [126] 
.const [75] = Class [127] 
.const [76] = NameAndType [128] [129] 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Class [133] 
.const [80] = NameAndType [134] [135] 
.const [81] = Utf8 java/lang/StringBuffer 
.const [82] = Class [136] 
.const [83] = NameAndType [137] [138] 
.const [84] = Class [139] 
.const [85] = NameAndType [140] [141] 
.const [86] = Class [142] 
.const [87] = NameAndType [143] [144] 
.const [88] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [89] = Utf8 user 
.const [90] = Utf8 Lorg/dsi/ifc/online/OSRUser; 
.const [91] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [92] = Utf8 devices 
.const [93] = Utf8 [Lorg/dsi/ifc/online/OSRDevice; 
.const [94] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [95] = Utf8 listener 
.const [96] = Utf8 Lde/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand$SetAutoLoginCommandResponseListener; 
.const [97] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [98] = Utf8 getDSI 
.const [99] = Utf8 ()Lorg/dsi/ifc/online/DSIOnlineServiceRegistration; 
.const [100] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [101] = Utf8 logger 
.const [102] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 log 
.const [105] = Utf8 (ILjava/lang/String;)Z 
.const [106] = Utf8 java/lang/StringBuffer 
.const [107] = Utf8 append 
.const [108] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [109] = Utf8 org/dsi/ifc/online/OSRUser 
.const [110] = Utf8 getName 
.const [111] = Utf8 ()Ljava/lang/String; 
.const [112] = Utf8 java/lang/StringBuffer 
.const [113] = Utf8 append 
.const [114] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 toString 
.const [117] = Utf8 ()Ljava/lang/String; 
.const [118] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [119] = Utf8 getCommandList 
.const [120] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [121] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [128] = Utf8 user 
.const [129] = Utf8 Lorg/dsi/ifc/online/OSRUser; 
.const [130] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [131] = Utf8 devices 
.const [132] = Utf8 [Lorg/dsi/ifc/online/OSRDevice; 
.const [133] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [134] = Utf8 listener 
.const [135] = Utf8 Lde/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand$SetAutoLoginCommandResponseListener; 
.const [136] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [137] = Utf8 setAutoLogin 
.const [138] = Utf8 (Lorg/dsi/ifc/online/OSRUser;[Lorg/dsi/ifc/online/OSRDevice;)V 
.const [139] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand$SetAutoLoginCommandResponseListener 
.const [140] = Utf8 setAutoLoginResponse 
.const [141] = Utf8 (Lorg/dsi/ifc/online/OSRUser;[I)V 
.const [142] = Utf8 de/audi/tghu/command/ICommandList 
.const [143] = Utf8 commandFinished 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand 
.const [146] = Class [145] 
.const [147] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [148] = Class [147] 
.const [149] = Utf8 user 
.const [150] = Utf8 Lorg/dsi/ifc/online/OSRUser; 
.const [151] = Utf8 listener 
.const [152] = Utf8 Lde/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand$SetAutoLoginCommandResponseListener; 
.const [153] = Utf8 devices 
.const [154] = Utf8 [Lorg/dsi/ifc/online/OSRDevice; 
.const [155] = Utf8 Code 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lorg/dsi/ifc/online/OSRUser;[Lorg/dsi/ifc/online/OSRDevice;Lde/audi/tghu/online/app/osr/command/auth/SetAutoLoginCommand$SetAutoLoginCommandResponseListener;)V 
.const [158] = Utf8 execute 
.const [159] = Utf8 ()V 
.const [160] = Utf8 setAutoLoginResponse 
.const [161] = Utf8 (Lorg/dsi/ifc/online/OSRUser;[Lorg/dsi/ifc/online/OSRDevice;[I)V 
.const [162] = Utf8 updateServiceList 
.const [163] = Utf8 ([Lorg/dsi/ifc/online/OSRServiceState;I)V 
.end class 
