.version 50 0 
.class public super [170] 
.super [172] 

.method public annotation [174] : [175] 
    .attribute [173] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [36] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [176] : [177] 
    .attribute [173] .code stack 2 locals 0 
L0:     aload_2 
L1:     ifnull L38 
L4:     iload_1 
L5:     ldc [2] 
L7:     if_icmpeq L34 
L10:    iload_1 
L11:    ldc [3] 
L13:    if_icmpeq L34 
L16:    iload_1 
L17:    ldc [4] 
L19:    if_icmpeq L34 
L22:    iload_1 
L23:    ldc [5] 
L25:    if_icmpeq L34 
L28:    iload_1 
L29:    ldc [6] 
L31:    if_icmpne L38 
L34:    iconst_1 
L35:    goto L39 
L38:    iconst_0 
L39:    areturn 
L40:    
    .end code 
.end method 

.method protected [178] : [179] 
    .attribute [173] .code stack 5 locals 7 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [26] 
L9:     astore_2 
L10:    aload_1 
L11:    ifnull L192 
L14:    aload_2 
L15:    ifnull L177 
L18:    aload_2 
L19:    invokeinterface [38] 0 
L24:    istore_3 
L25:    aload_2 
L26:    invokeinterface [39] 0 
L31:    istore 4 
L33:    aload_2 
L34:    invokeinterface [40] 0 
L39:    istore 5 
L41:    aload_0 
L42:    aload_2 
L43:    invokevirtual [27] 
L46:    ifeq L62 
L49:    aload_2 
L50:    invokeinterface [41] 0 
L55:    ifeq L62 
L58:    iconst_1 
L59:    goto L63 
L62:    iconst_0 
L63:    istore 6 
L65:    aload_0 
L66:    getfield [28] 
L69:    invokevirtual [29] 
L72:    ifeq L161 
L75:    new [42] 
L78:    dup 
L79:    invokespecial [37] 
L82:    astore 7 
L84:    aload 7 
L86:    ldc [8] 
L88:    invokevirtual [30] 
L91:    pop 
L92:    aload 7 
L94:    iload_3 
L95:    invokevirtual [31] 
L98:    pop 
L99:    aload 7 
L101:   ldc [9] 
L103:   invokevirtual [30] 
L106:   pop 
L107:   aload 7 
L109:   iload 4 
L111:   invokevirtual [31] 
L114:   pop 
L115:   aload 7 
L117:   ldc [10] 
L119:   invokevirtual [30] 
L122:   pop 
L123:   aload 7 
L125:   iload 5 
L127:   invokevirtual [31] 
L130:   pop 
L131:   aload 7 
L133:   ldc [11] 
L135:   invokevirtual [30] 
L138:   pop 
L139:   aload 7 
L141:   iload 6 
L143:   invokevirtual [31] 
L146:   pop 
L147:   aload_0 
L148:   getfield [28] 
L151:   ldc [12] 
L153:   ldc [13] 
L155:   aload 7 
L157:   invokevirtual [32] 
L160:   pop 
L161:   aload_1 
L162:   iload_3 
L163:   iload 4 
L165:   iload 5 
L167:   iload 6 
L169:   invokeinterface [43] 0 
L174:   goto L204 
L177:   aload_0 
L178:   getfield [28] 
L181:   ldc [14] 
L183:   ldc [15] 
L185:   invokevirtual [33] 
L188:   pop 
L189:   goto L204 
L192:   aload_0 
L193:   getfield [28] 
L196:   ldc [14] 
L198:   ldc [16] 
L200:   invokevirtual [33] 
L203:   pop 
L204:   return 
L205:   nop 
L206:   nop 
L207:   nop 
L208:   
    .end code 
.end method 

.method protected [180] : [181] 
    .attribute [173] .code stack 3 locals 3 
L0:     aload_1 
L1:     ifnull L92 
L4:     aload_1 
L5:     invokeinterface [44] 0 
L10:    astore_2 
L11:    aload_2 
L12:    ifnull L89 
L15:    aload_1 
L16:    invokeinterface [45] 0 
L21:    iconst_2 
L22:    if_icmpne L29 
L25:    iconst_1 
L26:    goto L30 
L29:    iconst_0 
L30:    istore_3 
L31:    aload_2 
L32:    invokevirtual [34] 
L35:    iconst_5 
L36:    if_icmpeq L47 
L39:    aload_2 
L40:    invokevirtual [34] 
L43:    iconst_2 
L44:    if_icmpne L73 
L47:    aload_1 
L48:    invokeinterface [46] 0 
L53:    ifnull L73 
L56:    aload_1 
L57:    invokeinterface [46] 0 
L62:    invokevirtual [35] 
L65:    iconst_2 
L66:    if_icmpne L73 
L69:    iconst_1 
L70:    goto L74 
L73:    iconst_0 
L74:    istore 4 
L76:    iload_3 
L77:    ifeq L82 
L80:    iconst_1 
L81:    areturn 
L82:    iload 4 
L84:    ifeq L89 
L87:    iconst_1 
L88:    areturn 
L89:    goto L105 
L92:    aload_0 
L93:    getfield [28] 
L96:    sipush 10000 
L99:    ldc [17] 
L101:   invokevirtual [33] 
L104:   pop 
L105:   iconst_0 
L106:   areturn 
L107:   nop 
L108:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 184550400 
.const [3] = Int 16778240 
.const [4] = Int 268435712 
.const [5] = Int 251658496 
.const [6] = Int 50331904 
.const [7] = Class [47] 
.const [8] = String [48] 
.const [9] = String [49] 
.const [10] = String [50] 
.const [11] = String [51] 
.const [12] = Int 1078071040 
.const [13] = String [52] 
.const [14] = Int -1601830656 
.const [15] = String [53] 
.const [16] = String [54] 
.const [17] = String [55] 
.const [18] = Class [56] 
.const [19] = Class [57] 
.const [20] = Class [58] 
.const [21] = Class [59] 
.const [22] = Class [60] 
.const [23] = Class [61] 
.const [24] = Class [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Field [69] [70] 
.const [29] = Method [71] [72] 
.const [30] = Method [73] [74] 
.const [31] = Method [75] [76] 
.const [32] = Method [77] [78] 
.const [33] = Method [79] [80] 
.const [34] = Method [81] [82] 
.const [35] = Method [83] [84] 
.const [36] = Method [85] [86] 
.const [37] = Method [87] [88] 
.const [38] = InterfaceMethod [89] [90] 
.const [39] = InterfaceMethod [91] [92] 
.const [40] = InterfaceMethod [93] [94] 
.const [41] = InterfaceMethod [95] [96] 
.const [42] = Class [97] 
.const [43] = InterfaceMethod [98] [99] 
.const [44] = InterfaceMethod [100] [101] 
.const [45] = InterfaceMethod [102] [103] 
.const [46] = InterfaceMethod [104] [105] 
.const [47] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [48] = Utf8 'voiceMailboxSupported=' 
.const [49] = Utf8 ', infoCallSupported=' 
.const [50] = Utf8 ', serviceCallSupported=' 
.const [51] = Utf8 ', emergencyCallSupported=' 
.const [52] = Utf8 '[BAPPropertyTelSupportedServiceNumbers#update] %1' 
.const [53] = Utf8 '[BAPPropertyTelSupportedServiceNumbers#update] state is null --> NOP!' 
.const [54] = Utf8 '[BAPPropertyTelSupportedServiceNumbers#update] CombiBAPServicePhone is null --> NOP!' 
.const [55] = Utf8 'BAPPropertyTelSupportedServiceNumbers#isEmergencyCallSupported state is null' 
.const [56] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSupportedServiceNumbers 
.const [57] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [58] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [61] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [62] = Utf8 org/dsi/ifc/telephoneng/LockStateStruct 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Class [112] 
.const [68] = NameAndType [113] [114] 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Class [121] 
.const [74] = NameAndType [122] [123] 
.const [75] = Class [124] 
.const [76] = NameAndType [125] [126] 
.const [77] = Class [127] 
.const [78] = NameAndType [128] [129] 
.const [79] = Class [130] 
.const [80] = NameAndType [131] [132] 
.const [81] = Class [133] 
.const [82] = NameAndType [134] [135] 
.const [83] = Class [136] 
.const [84] = NameAndType [137] [138] 
.const [85] = Class [139] 
.const [86] = NameAndType [140] [141] 
.const [87] = Class [142] 
.const [88] = NameAndType [143] [144] 
.const [89] = Class [145] 
.const [90] = NameAndType [146] [147] 
.const [91] = Class [148] 
.const [92] = NameAndType [149] [150] 
.const [93] = Class [151] 
.const [94] = NameAndType [152] [153] 
.const [95] = Class [154] 
.const [96] = NameAndType [155] [156] 
.const [97] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [98] = Class [157] 
.const [99] = NameAndType [158] [159] 
.const [100] = Class [160] 
.const [101] = NameAndType [161] [162] 
.const [102] = Class [163] 
.const [103] = NameAndType [164] [165] 
.const [104] = Class [166] 
.const [105] = NameAndType [167] [168] 
.const [106] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSupportedServiceNumbers 
.const [107] = Utf8 getCombiService 
.const [108] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [109] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSupportedServiceNumbers 
.const [110] = Utf8 getTelephoneState 
.const [111] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [112] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSupportedServiceNumbers 
.const [113] = Utf8 isEmergencyCallSupported 
.const [114] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [115] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSupportedServiceNumbers 
.const [116] = Utf8 log 
.const [117] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [118] = Utf8 de/audi/atip/log/LogChannel 
.const [119] = Utf8 isInfo 
.const [120] = Utf8 ()Z 
.const [121] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [122] = Utf8 append 
.const [123] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [124] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [125] = Utf8 append 
.const [126] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [127] = Utf8 de/audi/atip/log/LogChannel 
.const [128] = Utf8 log 
.const [129] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [130] = Utf8 de/audi/atip/log/LogChannel 
.const [131] = Utf8 log 
.const [132] = Utf8 (ILjava/lang/String;)Z 
.const [133] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [134] = Utf8 getTelActivationState 
.const [135] = Utf8 ()I 
.const [136] = Utf8 org/dsi/ifc/telephoneng/LockStateStruct 
.const [137] = Utf8 getTelLockState 
.const [138] = Utf8 ()I 
.const [139] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [142] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [146] = Utf8 isMailboxNumberAvailable 
.const [147] = Utf8 ()Z 
.const [148] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [149] = Utf8 isInfoCallSupported 
.const [150] = Utf8 ()Z 
.const [151] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [152] = Utf8 isBreakdownCallSupported 
.const [153] = Utf8 ()Z 
.const [154] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [155] = Utf8 isEmergencyNumberAvailable 
.const [156] = Utf8 ()Z 
.const [157] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [158] = Utf8 updateSupportedServiceNumbers 
.const [159] = Utf8 (ZZZZ)V 
.const [160] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [161] = Utf8 getActivationState 
.const [162] = Utf8 ()Lorg/dsi/ifc/telephoneng/ActivationStateStruct; 
.const [163] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [164] = Utf8 getPhoneModuleState 
.const [165] = Utf8 ()I 
.const [166] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [167] = Utf8 getLockState 
.const [168] = Utf8 ()Lorg/dsi/ifc/telephoneng/LockStateStruct; 
.const [169] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSupportedServiceNumbers 
.const [170] = Class [169] 
.const [171] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [172] = Class [171] 
.const [173] = Utf8 Code 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [176] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [177] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [178] = Utf8 updateAsync 
.const [179] = Utf8 ()V 
.const [180] = Utf8 isEmergencyCallSupported 
.const [181] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.end class 
