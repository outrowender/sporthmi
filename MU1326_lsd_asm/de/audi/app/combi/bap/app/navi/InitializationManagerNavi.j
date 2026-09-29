.version 50 0 
.class public super [126] 
.super [128] 

.method public [130] : [131] 
    .attribute [129] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial [28] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [132] : [133] 
    .attribute [129] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [16] 
L14:    pop 
L15:    ldc [4] 
L17:    aload_1 
L18:    invokevirtual [17] 
L21:    ifne L33 
L24:    ldc [5] 
L26:    aload_1 
L27:    invokevirtual [17] 
L30:    ifeq L38 
L33:    aload_0 
L34:    iload_2 
L35:    invokevirtual [18] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [134] : [135] 
    .attribute [129] .code stack 2 locals 1 
L0:     new [30] 
L3:     dup 
L4:     invokespecial [29] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [7] 
L11:    invokevirtual [19] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    invokevirtual [20] 
L20:    invokevirtual [21] 
L23:    pop 
L24:    aload_1 
L25:    bipush 10 
L27:    invokevirtual [22] 
L30:    pop 
L31:    aload_1 
L32:    invokevirtual [23] 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [129] .code stack 5 locals 2 
L0:     iload_1 
L1:     tableswitch 0 
            L32 
            L37 
            L42 
            L47 
            default : L53 

L32:    iconst_0 
L33:    istore_2 
L34:    goto L70 
L37:    iconst_1 
L38:    istore_2 
L39:    goto L70 
L42:    iconst_3 
L43:    istore_2 
L44:    goto L70 
L47:    bipush 15 
L49:    istore_2 
L50:    goto L70 
L53:    aload_0 
L54:    getfield [15] 
L57:    sipush 10000 
L60:    ldc [8] 
L62:    iload_1 
L63:    i2l 
L64:    invokevirtual [24] 
L67:    pop 
L68:    iconst_0 
L69:    areturn 
L70:    aload_0 
L71:    getfield [25] 
L74:    invokevirtual [26] 
L77:    checkcast [9] 
L80:    astore_3 
L81:    aload_3 
L82:    getfield [27] 
L85:    iload_2 
L86:    if_icmpeq L96 
L89:    aload_3 
L90:    iload_2 
L91:    putfield [31] 
L94:    iconst_1 
L95:    areturn 
L96:    iconst_0 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [129] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokevirtual [26] 
L7:     checkcast [9] 
L10:    astore_1 
L11:    aload_1 
L12:    getfield [27] 
L15:    ifne L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 14808325 
.const [3] = String [32] 
.const [4] = String [33] 
.const [5] = String [34] 
.const [6] = Class [35] 
.const [7] = String [36] 
.const [8] = String [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Class [43] 
.const [15] = Field [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Field [64] [65] 
.const [26] = Method [66] [67] 
.const [27] = Field [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Method [72] [73] 
.const [30] = Class [74] 
.const [31] = Field [75] [76] 
.const [32] = Utf8 '[CombiModuleNavi.InitializationManagerNavi#appStateChanged] appName=%1, value=%2' 
.const [33] = Utf8 Navi 
.const [34] = Utf8 AppNavAsia 
.const [35] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [36] = Utf8 'appStateNavi = ' 
.const [37] = Utf8 '[CombiModuleNavi.InitializationManagerNavi#setFSGOperationStateValue] invalid opState: %1' 
.const [38] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FSG_OperationState_Status 
.const [39] = Utf8 de/audi/app/combi/bap/app/navi/InitializationManagerNavi 
.const [40] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleInitializationManagerFSG 
.const [41] = Utf8 de/audi/atip/log/LogChannel 
.const [42] = Utf8 java/lang/String 
.const [43] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [44] = Class [77] 
.const [45] = NameAndType [78] [79] 
.const [46] = Class [80] 
.const [47] = NameAndType [81] [82] 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Class [119] 
.const [73] = NameAndType [120] [121] 
.const [74] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Utf8 de/audi/app/combi/bap/app/navi/InitializationManagerNavi 
.const [78] = Utf8 logChannel 
.const [79] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [80] = Utf8 de/audi/atip/log/LogChannel 
.const [81] = Utf8 log 
.const [82] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [83] = Utf8 java/lang/String 
.const [84] = Utf8 equals 
.const [85] = Utf8 (Ljava/lang/Object;)Z 
.const [86] = Utf8 de/audi/app/combi/bap/app/navi/InitializationManagerNavi 
.const [87] = Utf8 processAppStateChanged 
.const [88] = Utf8 (I)V 
.const [89] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [90] = Utf8 append 
.const [91] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [92] = Utf8 de/audi/app/combi/bap/app/navi/InitializationManagerNavi 
.const [93] = Utf8 getAppState 
.const [94] = Utf8 ()I 
.const [95] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [96] = Utf8 append 
.const [97] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [98] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [99] = Utf8 append 
.const [100] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [101] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [102] = Utf8 toString 
.const [103] = Utf8 ()Ljava/lang/String; 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 log 
.const [106] = Utf8 (ILjava/lang/String;J)Z 
.const [107] = Utf8 de/audi/app/combi/bap/app/navi/InitializationManagerNavi 
.const [108] = Utf8 fsgOperationStateFunction 
.const [109] = Utf8 Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [110] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [111] = Utf8 getLastStatus 
.const [112] = Utf8 ()Lde/vw/mib/bap/requests/StatusProperty; 
.const [113] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FSG_OperationState_Status 
.const [114] = Utf8 op_State 
.const [115] = Utf8 I 
.const [116] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleInitializationManagerFSG 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG;Lde/audi/app/bap/dsi/bap/IDSIBAPController;Lde/audi/app/bap/IPowerState;)V 
.const [119] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FSG_OperationState_Status 
.const [123] = Utf8 op_State 
.const [124] = Utf8 I 
.const [125] = Utf8 de/audi/app/combi/bap/app/navi/InitializationManagerNavi 
.const [126] = Class [125] 
.const [127] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleInitializationManagerFSG 
.const [128] = Class [127] 
.const [129] = Utf8 Code 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (Lde/audi/app/combi/bap/fw/AbstractCombiModule;Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG;Lde/audi/app/bap/dsi/bap/IDSIBAPController;Lde/audi/app/bap/IPowerState;)V 
.const [132] = Utf8 appStateChanged 
.const [133] = Utf8 (Ljava/lang/String;I)V 
.const [134] = Utf8 appStatesToString 
.const [135] = Utf8 ()Ljava/lang/String; 
.const [136] = Utf8 setFSGOperationStateValue 
.const [137] = Utf8 (I)Z 
.const [138] = Utf8 isOpStateNormalOperation 
.const [139] = Utf8 ()Z 
.end class 
