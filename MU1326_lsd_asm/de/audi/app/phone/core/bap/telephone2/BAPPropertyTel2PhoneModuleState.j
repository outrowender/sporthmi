.version 50 0 
.class public super [167] 
.super [169] 

.method private static [171] : [172] 
    .attribute [170] .code stack 1 locals 1 
L0:     aload_0 
L1:     ifnull L113 
L4:     aload_0 
L5:     invokeinterface [38] 0 
L10:    ifnull L41 
L13:    aload_0 
L14:    invokeinterface [38] 0 
L19:    invokeinterface [39] 0 
L24:    ifnull L41 
L27:    aload_0 
L28:    invokeinterface [38] 0 
L33:    invokeinterface [40] 0 
L38:    goto L42 
L41:    iconst_0 
L42:    istore_1 
L43:    iload_1 
L44:    tableswitch 0 
            L96 
            L102 
            L105 
            L100 
            L100 
            L98 
            L96 
            L109 
            L107 
            default : L111 

L96:    iconst_0 
L97:    areturn 
L98:    iconst_5 
L99:    areturn 
L100:   iconst_1 
L101:   areturn 
L102:   bipush 6 
L104:   areturn 
L105:   iconst_2 
L106:   areturn 
L107:   iconst_3 
L108:   areturn 
L109:   iconst_4 
L110:   areturn 
L111:   iconst_0 
L112:   areturn 
L113:   iconst_0 
L114:   areturn 
L115:   nop 
L116:   
    .end code 
.end method 

.method private static [173] : [174] 
    .attribute [170] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L50 
L4:     aload_0 
L5:     invokeinterface [41] 0 
L10:    tableswitch 0 
            L40 
            L42 
            L44 
            L46 
            default : L48 

L40:    iconst_0 
L41:    areturn 
L42:    iconst_1 
L43:    areturn 
L44:    iconst_3 
L45:    areturn 
L46:    iconst_2 
L47:    areturn 
L48:    iconst_0 
L49:    areturn 
L50:    iconst_0 
L51:    areturn 
L52:    
    .end code 
.end method 

.method private static [175] : [176] 
    .attribute [170] .code stack 2 locals 2 
L0:     aload_0 
L1:     ifnull L58 
L4:     aload_0 
L5:     invokeinterface [41] 0 
L10:    istore_1 
L11:    iload_1 
L12:    iconst_1 
L13:    if_icmpne L49 
L16:    aload_0 
L17:    invokeinterface [38] 0 
L22:    ifnull L49 
L25:    aload_0 
L26:    invokeinterface [38] 0 
L31:    invokeinterface [42] 0 
L36:    istore_2 
L37:    iload_2 
L38:    invokestatic [2] 
L41:    ifeq L46 
L44:    iconst_1 
L45:    areturn 
L46:    goto L58 
L49:    iload_1 
L50:    iconst_2 
L51:    if_icmpne L56 
L54:    iconst_3 
L55:    areturn 
L56:    iconst_0 
L57:    areturn 
L58:    iconst_0 
L59:    areturn 
L60:    
    .end code 
.end method 

.method private static [177] : [178] 
    .attribute [170] .code stack 1 locals 1 
L0:     aload_0 
L1:     ifnull L70 
L4:     aload_0 
L5:     invokeinterface [38] 0 
L10:    ifnull L27 
L13:    aload_0 
L14:    invokeinterface [38] 0 
L19:    invokeinterface [42] 0 
L24:    goto L28 
L27:    iconst_4 
L28:    istore_1 
L29:    iload_1 
L30:    tableswitch 0 
            L64 
            L64 
            L64 
            L66 
            L66 
            default : L68 

L64:    iconst_2 
L65:    areturn 
L66:    iconst_1 
L67:    areturn 
L68:    iconst_0 
L69:    areturn 
L70:    iconst_0 
L71:    areturn 
L72:    
    .end code 
.end method 

.method annotation [179] : [180] 
    .attribute [170] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [36] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [181] : [182] 
    .attribute [170] .code stack 2 locals 0 
L0:     aload_2 
L1:     ifnull L32 
L4:     iload_1 
L5:     ldc [3] 
L7:     if_icmpeq L28 
L10:    iload_1 
L11:    ldc [4] 
L13:    if_icmpeq L28 
L16:    iload_1 
L17:    ldc [5] 
L19:    if_icmpeq L28 
L22:    iload_1 
L23:    ldc [6] 
L25:    if_icmpne L32 
L28:    iconst_1 
L29:    goto L33 
L32:    iconst_0 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method protected [183] : [184] 
    .attribute [170] .code stack 5 locals 7 
L0:     aload_0 
L1:     invokevirtual [28] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [29] 
L9:     astore_2 
L10:    aload_1 
L11:    ifnonnull L27 
L14:    aload_0 
L15:    getfield [30] 
L18:    ldc [7] 
L20:    ldc [8] 
L22:    invokevirtual [31] 
L25:    pop 
L26:    return 
L27:    aload_2 
L28:    ifnonnull L44 
L31:    aload_0 
L32:    getfield [30] 
L35:    ldc [7] 
L37:    ldc [9] 
L39:    invokevirtual [31] 
L42:    pop 
L43:    return 
L44:    aload_2 
L45:    invokestatic [10] 
L48:    istore_3 
L49:    aload_2 
L50:    invokestatic [11] 
L53:    istore 4 
L55:    aload_2 
L56:    invokestatic [12] 
L59:    istore 5 
L61:    aload_2 
L62:    invokestatic [13] 
L65:    istore 6 
L67:    aload_0 
L68:    getfield [30] 
L71:    invokevirtual [32] 
L74:    ifeq L163 
L77:    new [43] 
L80:    dup 
L81:    invokespecial [37] 
L84:    astore 7 
L86:    aload 7 
L88:    ldc [15] 
L90:    invokevirtual [33] 
L93:    pop 
L94:    aload 7 
L96:    iload_3 
L97:    invokevirtual [34] 
L100:   pop 
L101:   aload 7 
L103:   ldc [16] 
L105:   invokevirtual [33] 
L108:   pop 
L109:   aload 7 
L111:   iload 4 
L113:   invokevirtual [34] 
L116:   pop 
L117:   aload 7 
L119:   ldc [17] 
L121:   invokevirtual [33] 
L124:   pop 
L125:   aload 7 
L127:   iload 5 
L129:   invokevirtual [34] 
L132:   pop 
L133:   aload 7 
L135:   ldc [18] 
L137:   invokevirtual [33] 
L140:   pop 
L141:   aload 7 
L143:   iload 6 
L145:   invokevirtual [34] 
L148:   pop 
L149:   aload_0 
L150:   getfield [30] 
L153:   ldc [19] 
L155:   ldc [20] 
L157:   aload 7 
L159:   invokevirtual [35] 
L162:   pop 
L163:   aload_1 
L164:   iload_3 
L165:   iload 4 
L167:   iload 5 
L169:   iload 6 
L171:   invokeinterface [44] 0 
L176:   return 
L177:   nop 
L178:   nop 
L179:   nop 
L180:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [45] [46] 
.const [3] = Int 50332416 
.const [4] = Int 50331904 
.const [5] = Int 50332160 
.const [6] = Int 50332672 
.const [7] = Int -1601830656 
.const [8] = String [47] 
.const [9] = String [48] 
.const [10] = Method [49] [50] 
.const [11] = Method [51] [52] 
.const [12] = Method [53] [54] 
.const [13] = Method [55] [56] 
.const [14] = Class [57] 
.const [15] = String [58] 
.const [16] = String [59] 
.const [17] = String [60] 
.const [18] = String [61] 
.const [19] = Int 1078071040 
.const [20] = String [62] 
.const [21] = Class [63] 
.const [22] = Class [64] 
.const [23] = Class [65] 
.const [24] = Class [66] 
.const [25] = Class [67] 
.const [26] = Class [68] 
.const [27] = Class [69] 
.const [28] = Method [70] [71] 
.const [29] = Method [72] [73] 
.const [30] = Field [74] [75] 
.const [31] = Method [76] [77] 
.const [32] = Method [78] [79] 
.const [33] = Method [80] [81] 
.const [34] = Method [82] [83] 
.const [35] = Method [84] [85] 
.const [36] = Method [86] [87] 
.const [37] = Method [88] [89] 
.const [38] = InterfaceMethod [90] [91] 
.const [39] = InterfaceMethod [92] [93] 
.const [40] = InterfaceMethod [94] [95] 
.const [41] = InterfaceMethod [96] [97] 
.const [42] = InterfaceMethod [98] [99] 
.const [43] = Class [100] 
.const [44] = InterfaceMethod [101] [102] 
.const [45] = Class [103] 
.const [46] = NameAndType [104] [105] 
.const [47] = Utf8 '[BAPPropertyTel2PhoneModuleState#update] CombiBAPServicePhone is null --> NOP!' 
.const [48] = Utf8 '[BAPPropertyTel2PhoneModuleState#update] state is null --> NOP!' 
.const [49] = Class [106] 
.const [50] = NameAndType [107] [108] 
.const [51] = Class [109] 
.const [52] = NameAndType [110] [111] 
.const [53] = Class [112] 
.const [54] = NameAndType [113] [114] 
.const [55] = Class [115] 
.const [56] = NameAndType [116] [117] 
.const [57] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [58] = Utf8 'moduleState=' 
.const [59] = Utf8 ', moduleSupportedServices=' 
.const [60] = Utf8 ', moduleActiveServices=' 
.const [61] = Utf8 ', simState=' 
.const [62] = Utf8 '[BAPPropertyTel2PhoneModuleState#update] %1' 
.const [63] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2PhoneModuleState 
.const [64] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [65] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [66] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [67] = Utf8 de/audi/app/phone/core/bap/telephone2/TelBAPManagerTel2Utils 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2 
.const [70] = Class [118] 
.const [71] = NameAndType [119] [120] 
.const [72] = Class [121] 
.const [73] = NameAndType [122] [123] 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Class [127] 
.const [77] = NameAndType [128] [129] 
.const [78] = Class [130] 
.const [79] = NameAndType [131] [132] 
.const [80] = Class [133] 
.const [81] = NameAndType [134] [135] 
.const [82] = Class [136] 
.const [83] = NameAndType [137] [138] 
.const [84] = Class [139] 
.const [85] = NameAndType [140] [141] 
.const [86] = Class [142] 
.const [87] = NameAndType [143] [144] 
.const [88] = Class [145] 
.const [89] = NameAndType [146] [147] 
.const [90] = Class [148] 
.const [91] = NameAndType [149] [150] 
.const [92] = Class [151] 
.const [93] = NameAndType [152] [153] 
.const [94] = Class [154] 
.const [95] = NameAndType [155] [156] 
.const [96] = Class [157] 
.const [97] = NameAndType [158] [159] 
.const [98] = Class [160] 
.const [99] = NameAndType [161] [162] 
.const [100] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [101] = Class [163] 
.const [102] = NameAndType [164] [165] 
.const [103] = Utf8 de/audi/app/phone/core/bap/telephone2/TelBAPManagerTel2Utils 
.const [104] = Utf8 telModeSupportsData 
.const [105] = Utf8 (I)Z 
.const [106] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2PhoneModuleState 
.const [107] = Utf8 getModuleState 
.const [108] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [109] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2PhoneModuleState 
.const [110] = Utf8 getModuleSupportedServices 
.const [111] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [112] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2PhoneModuleState 
.const [113] = Utf8 getModuleActiveServices 
.const [114] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [115] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2PhoneModuleState 
.const [116] = Utf8 getSIMState 
.const [117] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [118] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2PhoneModuleState 
.const [119] = Utf8 getCombiService 
.const [120] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2; 
.const [121] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2PhoneModuleState 
.const [122] = Utf8 getTelephoneState 
.const [123] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [124] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2PhoneModuleState 
.const [125] = Utf8 log 
.const [126] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [127] = Utf8 de/audi/atip/log/LogChannel 
.const [128] = Utf8 log 
.const [129] = Utf8 (ILjava/lang/String;)Z 
.const [130] = Utf8 de/audi/atip/log/LogChannel 
.const [131] = Utf8 isInfo 
.const [132] = Utf8 ()Z 
.const [133] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [134] = Utf8 append 
.const [135] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [136] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [139] = Utf8 de/audi/atip/log/LogChannel 
.const [140] = Utf8 log 
.const [141] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [142] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [145] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [146] = Utf8 <init> 
.const [147] = Utf8 ()V 
.const [148] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [149] = Utf8 getNadInstanceState 
.const [150] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [151] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [152] = Utf8 getActivationState 
.const [153] = Utf8 ()Lorg/dsi/ifc/telephoneng/ActivationStateStruct; 
.const [154] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [155] = Utf8 getPhoneModuleState 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [158] = Utf8 getNadMode 
.const [159] = Utf8 ()I 
.const [160] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [161] = Utf8 getTelMode 
.const [162] = Utf8 ()I 
.const [163] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2 
.const [164] = Utf8 updatePhoneModuleState 
.const [165] = Utf8 (IIII)V 
.const [166] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2PhoneModuleState 
.const [167] = Class [166] 
.const [168] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [169] = Class [168] 
.const [170] = Utf8 Code 
.const [171] = Utf8 getModuleState 
.const [172] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [173] = Utf8 getModuleSupportedServices 
.const [174] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [175] = Utf8 getModuleActiveServices 
.const [176] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [177] = Utf8 getSIMState 
.const [178] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [181] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [182] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [183] = Utf8 updateAsync 
.const [184] = Utf8 ()V 
.end class 
