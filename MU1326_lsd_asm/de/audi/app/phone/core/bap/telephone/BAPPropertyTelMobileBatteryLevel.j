.version 50 0 
.class public super [122] 
.super [124] 

.method public annotation [126] : [127] 
    .attribute [125] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [26] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [128] : [129] 
    .attribute [125] .code stack 2 locals 0 
L0:     aload_2 
L1:     ifnull L26 
L4:     iload_1 
L5:     ldc [2] 
L7:     if_icmpeq L22 
L10:    iload_1 
L11:    ldc [3] 
L13:    if_icmpeq L22 
L16:    iload_1 
L17:    ldc [4] 
L19:    if_icmpne L26 
L22:    iconst_1 
L23:    goto L27 
L26:    iconst_0 
L27:    areturn 
L28:    
    .end code 
.end method 

.method private [130] : [131] 
    .attribute [125] .code stack 2 locals 0 
L0:     iload_1 
L1:     ifeq L9 
L4:     iload_1 
L5:     iconst_1 
L6:     if_icmpne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [132] : [133] 
    .attribute [125] .code stack 1 locals 1 
L0:     sipush 254 
L3:     istore_2 
L4:     iload_1 
L5:     tableswitch 0 
            L44 
            L49 
            L55 
            L61 
            L67 
            L73 
            default : L79 

L44:    iconst_0 
L45:    istore_2 
L46:    goto L83 
L49:    bipush 19 
L51:    istore_2 
L52:    goto L83 
L55:    bipush 39 
L57:    istore_2 
L58:    goto L83 
L61:    bipush 59 
L63:    istore_2 
L64:    goto L83 
L67:    bipush 79 
L69:    istore_2 
L70:    goto L83 
L73:    bipush 100 
L75:    istore_2 
L76:    goto L83 
L79:    sipush 254 
L82:    istore_2 
L83:    iload_2 
L84:    areturn 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method protected [134] : [135] 
    .attribute [125] .code stack 5 locals 6 
L0:     aload_0 
L1:     invokevirtual [21] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [22] 
L9:     astore_2 
L10:    aload_1 
L11:    ifnull L121 
L14:    aload_2 
L15:    ifnull L106 
L18:    aload_0 
L19:    aload_2 
L20:    invokeinterface [30] 0 
L25:    invokespecial [27] 
L28:    istore_3 
L29:    aload_2 
L30:    invokeinterface [31] 0 
L35:    ifeq L51 
L38:    aload_0 
L39:    aload_2 
L40:    invokeinterface [30] 0 
L45:    invokespecial [28] 
L48:    goto L54 
L51:    sipush 255 
L54:    istore 4 
L56:    aload_0 
L57:    getfield [23] 
L60:    ldc [5] 
L62:    ldc [6] 
L64:    iload 4 
L66:    invokestatic [7] 
L69:    iload_3 
L70:    invokestatic [8] 
L73:    invokevirtual [24] 
L76:    new [32] 
L79:    dup 
L80:    iload 4 
L82:    iload_3 
L83:    invokespecial [29] 
L86:    astore 5 
L88:    aload 5 
L90:    invokestatic [10] 
L93:    astore 6 
L95:    aload_1 
L96:    aload 6 
L98:    invokeinterface [33] 0 
L103:   goto L133 
L106:   aload_0 
L107:   getfield [23] 
L110:   ldc [11] 
L112:   ldc [12] 
L114:   invokevirtual [25] 
L117:   pop 
L118:   goto L133 
L121:   aload_0 
L122:   getfield [23] 
L125:   ldc [11] 
L127:   ldc [13] 
L129:   invokevirtual [25] 
L132:   pop 
L133:   return 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 100663552 
.const [3] = Int 50331904 
.const [4] = Int 251658496 
.const [5] = Int 1078071040 
.const [6] = String [34] 
.const [7] = Method [35] [36] 
.const [8] = Method [37] [38] 
.const [9] = Class [39] 
.const [10] = Method [40] [41] 
.const [11] = Int -1601830656 
.const [12] = String [42] 
.const [13] = String [43] 
.const [14] = Class [44] 
.const [15] = Class [45] 
.const [16] = Class [46] 
.const [17] = Class [47] 
.const [18] = Class [48] 
.const [19] = Class [49] 
.const [20] = Class [50] 
.const [21] = Method [51] [52] 
.const [22] = Method [53] [54] 
.const [23] = Field [55] [56] 
.const [24] = Method [57] [58] 
.const [25] = Method [59] [60] 
.const [26] = Method [61] [62] 
.const [27] = Method [63] [64] 
.const [28] = Method [65] [66] 
.const [29] = Method [67] [68] 
.const [30] = InterfaceMethod [69] [70] 
.const [31] = InterfaceMethod [71] [72] 
.const [32] = Class [73] 
.const [33] = InterfaceMethod [74] [75] 
.const [34] = Utf8 '[BAPPropertyTelMobileBatteryLevel#update] mobile1ChargeLevel=%1 mobile1ChargeLevelCritical=%2' 
.const [35] = Class [76] 
.const [36] = NameAndType [77] [78] 
.const [37] = Class [79] 
.const [38] = NameAndType [80] [81] 
.const [39] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPhoneMobileBatteryLevel$ChargeLevel 
.const [40] = Class [82] 
.const [41] = NameAndType [83] [84] 
.const [42] = Utf8 '[BAPPropertyTelMobileBatteryLevel#update] state or activationState is null --> NOP!' 
.const [43] = Utf8 '[BAPPropertyTelMobileBatteryLevel#update] CombiBAPServicePhone is null --> NOP!' 
.const [44] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMobileBatteryLevel 
.const [45] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [46] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [47] = Utf8 java/lang/String 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPhoneMobileBatteryLevel 
.const [50] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [51] = Class [85] 
.const [52] = NameAndType [86] [87] 
.const [53] = Class [88] 
.const [54] = NameAndType [89] [90] 
.const [55] = Class [91] 
.const [56] = NameAndType [92] [93] 
.const [57] = Class [94] 
.const [58] = NameAndType [95] [96] 
.const [59] = Class [97] 
.const [60] = NameAndType [98] [99] 
.const [61] = Class [100] 
.const [62] = NameAndType [101] [102] 
.const [63] = Class [103] 
.const [64] = NameAndType [104] [105] 
.const [65] = Class [106] 
.const [66] = NameAndType [107] [108] 
.const [67] = Class [109] 
.const [68] = NameAndType [110] [111] 
.const [69] = Class [112] 
.const [70] = NameAndType [113] [114] 
.const [71] = Class [115] 
.const [72] = NameAndType [116] [117] 
.const [73] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPhoneMobileBatteryLevel$ChargeLevel 
.const [74] = Class [118] 
.const [75] = NameAndType [119] [120] 
.const [76] = Utf8 java/lang/String 
.const [77] = Utf8 valueOf 
.const [78] = Utf8 (I)Ljava/lang/String; 
.const [79] = Utf8 java/lang/String 
.const [80] = Utf8 valueOf 
.const [81] = Utf8 (Z)Ljava/lang/String; 
.const [82] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPhoneMobileBatteryLevel 
.const [83] = Utf8 createOnlyMobileChargeLevel1 
.const [84] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPhoneMobileBatteryLevel$ChargeLevel;)Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPhoneMobileBatteryLevel; 
.const [85] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMobileBatteryLevel 
.const [86] = Utf8 getCombiService 
.const [87] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [88] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMobileBatteryLevel 
.const [89] = Utf8 getTelephoneState 
.const [90] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [91] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMobileBatteryLevel 
.const [92] = Utf8 log 
.const [93] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;)Z 
.const [100] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [103] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMobileBatteryLevel 
.const [104] = Utf8 isChargeLevelCritical 
.const [105] = Utf8 (I)Z 
.const [106] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMobileBatteryLevel 
.const [107] = Utf8 getClusterBatteryLevel 
.const [108] = Utf8 (I)I 
.const [109] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPhoneMobileBatteryLevel$ChargeLevel 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (IZ)V 
.const [112] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [113] = Utf8 getBatteryChargeLevel 
.const [114] = Utf8 ()I 
.const [115] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [116] = Utf8 isPhoneReady 
.const [117] = Utf8 ()Z 
.const [118] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [119] = Utf8 updateMobileBatteryLevel 
.const [120] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPhoneMobileBatteryLevel;)V 
.const [121] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMobileBatteryLevel 
.const [122] = Class [121] 
.const [123] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [124] = Class [123] 
.const [125] = Utf8 Code 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [128] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [129] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [130] = Utf8 isChargeLevelCritical 
.const [131] = Utf8 (I)Z 
.const [132] = Utf8 getClusterBatteryLevel 
.const [133] = Utf8 (I)I 
.const [134] = Utf8 updateAsync 
.const [135] = Utf8 ()V 
.end class 
