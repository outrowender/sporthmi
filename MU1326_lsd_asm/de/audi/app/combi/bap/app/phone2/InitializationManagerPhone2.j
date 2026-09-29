.version 50 0 
.class public super [124] 
.super [126] 

.method public [128] : [129] 
    .attribute [127] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial [27] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [130] : [131] 
    .attribute [127] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [15] 
L14:    pop 
L15:    ldc [4] 
L17:    aload_1 
L18:    invokevirtual [16] 
L21:    ifeq L29 
L24:    aload_0 
L25:    iload_2 
L26:    invokevirtual [17] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [132] : [133] 
    .attribute [127] .code stack 2 locals 1 
L0:     new [29] 
L3:     dup 
L4:     invokespecial [28] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [6] 
L11:    invokevirtual [18] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    invokevirtual [19] 
L20:    invokevirtual [20] 
L23:    pop 
L24:    aload_1 
L25:    bipush 10 
L27:    invokevirtual [21] 
L30:    pop 
L31:    aload_1 
L32:    invokevirtual [22] 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [134] : [135] 
    .attribute [127] .code stack 5 locals 2 
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
L54:    getfield [14] 
L57:    sipush 10000 
L60:    ldc [7] 
L62:    iload_1 
L63:    i2l 
L64:    invokevirtual [23] 
L67:    pop 
L68:    iconst_0 
L69:    areturn 
L70:    aload_0 
L71:    getfield [24] 
L74:    invokevirtual [25] 
L77:    checkcast [8] 
L80:    astore_3 
L81:    aload_3 
L82:    getfield [26] 
L85:    iload_2 
L86:    if_icmpeq L96 
L89:    aload_3 
L90:    iload_2 
L91:    putfield [30] 
L94:    iconst_1 
L95:    areturn 
L96:    iconst_0 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [127] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     invokevirtual [25] 
L7:     checkcast [8] 
L10:    astore_1 
L11:    aload_1 
L12:    getfield [26] 
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
.const [3] = String [31] 
.const [4] = String [32] 
.const [5] = Class [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Field [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Field [66] [67] 
.const [27] = Method [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Class [72] 
.const [30] = Field [73] [74] 
.const [31] = Utf8 '[CombiModulePhone2.InitializationManagerPhone2#appStateChanged] appName=%1, value=%2' 
.const [32] = Utf8 Phone 
.const [33] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [34] = Utf8 'appStatePhone = ' 
.const [35] = Utf8 '[CombiModulePhone2.InitializationManagerPhone2#setFSGOperationStateValue] invalid opState: %1' 
.const [36] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/FSG_OperationState_Status 
.const [37] = Utf8 de/audi/app/combi/bap/app/phone2/InitializationManagerPhone2 
.const [38] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleInitializationManagerFSG 
.const [39] = Utf8 de/audi/atip/log/LogChannel 
.const [40] = Utf8 java/lang/String 
.const [41] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [42] = Class [75] 
.const [43] = NameAndType [76] [77] 
.const [44] = Class [78] 
.const [45] = NameAndType [79] [80] 
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
.const [54] = Class [93] 
.const [55] = NameAndType [94] [95] 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Class [102] 
.const [61] = NameAndType [103] [104] 
.const [62] = Class [105] 
.const [63] = NameAndType [106] [107] 
.const [64] = Class [108] 
.const [65] = NameAndType [109] [110] 
.const [66] = Class [111] 
.const [67] = NameAndType [112] [113] 
.const [68] = Class [114] 
.const [69] = NameAndType [115] [116] 
.const [70] = Class [117] 
.const [71] = NameAndType [118] [119] 
.const [72] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Utf8 de/audi/app/combi/bap/app/phone2/InitializationManagerPhone2 
.const [76] = Utf8 logChannel 
.const [77] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 log 
.const [80] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [81] = Utf8 java/lang/String 
.const [82] = Utf8 equals 
.const [83] = Utf8 (Ljava/lang/Object;)Z 
.const [84] = Utf8 de/audi/app/combi/bap/app/phone2/InitializationManagerPhone2 
.const [85] = Utf8 processAppStateChanged 
.const [86] = Utf8 (I)V 
.const [87] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [88] = Utf8 append 
.const [89] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [90] = Utf8 de/audi/app/combi/bap/app/phone2/InitializationManagerPhone2 
.const [91] = Utf8 getAppState 
.const [92] = Utf8 ()I 
.const [93] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [94] = Utf8 append 
.const [95] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [96] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [97] = Utf8 append 
.const [98] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [99] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [100] = Utf8 toString 
.const [101] = Utf8 ()Ljava/lang/String; 
.const [102] = Utf8 de/audi/atip/log/LogChannel 
.const [103] = Utf8 log 
.const [104] = Utf8 (ILjava/lang/String;J)Z 
.const [105] = Utf8 de/audi/app/combi/bap/app/phone2/InitializationManagerPhone2 
.const [106] = Utf8 fsgOperationStateFunction 
.const [107] = Utf8 Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [108] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [109] = Utf8 getLastStatus 
.const [110] = Utf8 ()Lde/vw/mib/bap/requests/StatusProperty; 
.const [111] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/FSG_OperationState_Status 
.const [112] = Utf8 op_State 
.const [113] = Utf8 I 
.const [114] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleInitializationManagerFSG 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG;Lde/audi/app/bap/dsi/bap/IDSIBAPController;Lde/audi/app/bap/IPowerState;)V 
.const [117] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [118] = Utf8 <init> 
.const [119] = Utf8 ()V 
.const [120] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/FSG_OperationState_Status 
.const [121] = Utf8 op_State 
.const [122] = Utf8 I 
.const [123] = Utf8 de/audi/app/combi/bap/app/phone2/InitializationManagerPhone2 
.const [124] = Class [123] 
.const [125] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleInitializationManagerFSG 
.const [126] = Class [125] 
.const [127] = Utf8 Code 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (Lde/audi/app/combi/bap/fw/AbstractCombiModule;Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG;Lde/audi/app/bap/dsi/bap/IDSIBAPController;Lde/audi/app/bap/IPowerState;)V 
.const [130] = Utf8 appStateChanged 
.const [131] = Utf8 (Ljava/lang/String;I)V 
.const [132] = Utf8 appStatesToString 
.const [133] = Utf8 ()Ljava/lang/String; 
.const [134] = Utf8 setFSGOperationStateValue 
.const [135] = Utf8 (I)Z 
.const [136] = Utf8 isOpStateNormalOperation 
.const [137] = Utf8 ()Z 
.end class 
