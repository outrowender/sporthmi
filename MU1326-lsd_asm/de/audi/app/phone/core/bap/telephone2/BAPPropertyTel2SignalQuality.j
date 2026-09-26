.version 50 0 
.class public super [159] 
.super [161] 
.field private static final [162] [163] 
.field private static final [164] [165] 
.field private static final [166] [167] 
.field private volatile [168] [169] 

.method public [171] : [172] 
    .attribute [170] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [30] 
L6:     aload_0 
L7:     iconst_m1 
L8:     putfield [33] 
L11:    return 
L12:    
    .end code 
.end method 

.method protected [173] : [174] 
    .attribute [170] .code stack 1 locals 0 
L0:     aload_2 
L1:     ifnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [175] : [176] 
    .attribute [170] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [22] 
L4:     invokevirtual [23] 
L7:     ifeq L119 
L10:    new [34] 
L13:    dup 
L14:    invokespecial [31] 
L17:    astore 7 
L19:    aload 7 
L21:    ldc [3] 
L23:    invokevirtual [24] 
L26:    pop 
L27:    aload 7 
L29:    iload_2 
L30:    invokevirtual [25] 
L33:    pop 
L34:    aload 7 
L36:    ldc [4] 
L38:    invokevirtual [24] 
L41:    pop 
L42:    aload 7 
L44:    ldc [5] 
L46:    invokevirtual [24] 
L49:    pop 
L50:    aload 7 
L52:    iload_3 
L53:    invokevirtual [25] 
L56:    pop 
L57:    aload 7 
L59:    ldc [4] 
L61:    invokevirtual [24] 
L64:    pop 
L65:    aload 7 
L67:    ldc [6] 
L69:    invokevirtual [24] 
L72:    pop 
L73:    aload 7 
L75:    iload 4 
L77:    invokevirtual [25] 
L80:    pop 
L81:    aload 7 
L83:    ldc [4] 
L85:    invokevirtual [24] 
L88:    pop 
L89:    aload 7 
L91:    ldc [7] 
L93:    invokevirtual [24] 
L96:    pop 
L97:    aload 7 
L99:    iload 5 
L101:   invokevirtual [25] 
L104:   pop 
L105:   aload_0 
L106:   getfield [22] 
L109:   ldc [8] 
L111:   ldc [9] 
L113:   aload 7 
L115:   invokevirtual [26] 
L118:   pop 
L119:   iload_3 
L120:   invokestatic [10] 
L123:   ifne L131 
L126:   iload 6 
L128:   ifne L145 
L131:   aload_1 
L132:   iload 5 
L134:   invokeinterface [35] 0 
L139:   aload_0 
L140:   iload 5 
L142:   putfield [33] 
L145:   return 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method protected [177] : [178] 
    .attribute [170] .code stack 7 locals 7 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [28] 
L9:     astore_2 
L10:    aload_2 
L11:    ifnull L187 
L14:    aload_2 
L15:    invokeinterface [36] 0 
L20:    istore_3 
L21:    aload_2 
L22:    invokeinterface [37] 0 
L27:    ifnull L44 
L30:    aload_2 
L31:    invokeinterface [37] 0 
L36:    invokeinterface [38] 0 
L41:    goto L45 
L44:    iconst_4 
L45:    istore 4 
L47:    aload_2 
L48:    invokeinterface [37] 0 
L53:    ifnull L70 
L56:    aload_2 
L57:    invokeinterface [37] 0 
L62:    invokeinterface [39] 0 
L67:    goto L71 
L70:    iconst_0 
L71:    istore 5 
L73:    aload_2 
L74:    invokeinterface [37] 0 
L79:    ifnull L96 
L82:    aload_2 
L83:    invokeinterface [37] 0 
L88:    invokeinterface [40] 0 
L93:    goto L99 
L96:    sipush 255 
L99:    istore 6 
L101:   iload 6 
L103:   sipush 255 
L106:   if_icmpne L113 
L109:   iconst_0 
L110:   goto L115 
L113:   iload 6 
L115:   istore 7 
L117:   aload_1 
L118:   ifnull L172 
L121:   aload_0 
L122:   getfield [21] 
L125:   iconst_m1 
L126:   if_icmpne L146 
L129:   aload_0 
L130:   aload_1 
L131:   iload_3 
L132:   iload 4 
L134:   iload 6 
L136:   iload 7 
L138:   iload 5 
L140:   invokespecial [32] 
L143:   goto L184 
L146:   aload_0 
L147:   getfield [21] 
L150:   iload 7 
L152:   if_icmpeq L184 
L155:   aload_0 
L156:   aload_1 
L157:   iload_3 
L158:   iload 4 
L160:   iload 6 
L162:   iload 7 
L164:   iload 5 
L166:   invokespecial [32] 
L169:   goto L184 
L172:   aload_0 
L173:   getfield [22] 
L176:   ldc [11] 
L178:   ldc [12] 
L180:   invokevirtual [29] 
L183:   pop 
L184:   goto L200 
L187:   aload_0 
L188:   getfield [22] 
L191:   sipush 10000 
L194:   ldc [13] 
L196:   invokevirtual [29] 
L199:   pop 
L200:   return 
L201:   nop 
L202:   nop 
L203:   nop 
L204:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = String [42] 
.const [4] = String [43] 
.const [5] = String [44] 
.const [6] = String [45] 
.const [7] = String [46] 
.const [8] = Int 1078071040 
.const [9] = String [47] 
.const [10] = Method [48] [49] 
.const [11] = Int -1601830656 
.const [12] = String [50] 
.const [13] = String [51] 
.const [14] = Class [52] 
.const [15] = Class [53] 
.const [16] = Class [54] 
.const [17] = Class [55] 
.const [18] = Class [56] 
.const [19] = Class [57] 
.const [20] = Class [58] 
.const [21] = Field [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = Method [81] [82] 
.const [33] = Field [83] [84] 
.const [34] = Class [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = InterfaceMethod [88] [89] 
.const [37] = InterfaceMethod [90] [91] 
.const [38] = InterfaceMethod [92] [93] 
.const [39] = InterfaceMethod [94] [95] 
.const [40] = InterfaceMethod [96] [97] 
.const [41] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [42] = Utf8 'nadMode=' 
.const [43] = Utf8 ', ' 
.const [44] = Utf8 'telMode=' 
.const [45] = Utf8 'signalQuality=' 
.const [46] = Utf8 'dataSignalQuality=' 
.const [47] = Utf8 '[BAPPropertyTel2SignalQuality#updateCombiWithDataSignalQuality] %1' 
.const [48] = Class [98] 
.const [49] = NameAndType [99] [100] 
.const [50] = Utf8 '[BAPPropertyTel2SignalQuality#update] CombiBAPServicePhone is null --> NOP!' 
.const [51] = Utf8 'BAPPropertyTel2SignalQuality#updateAsync state is null' 
.const [52] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2SignalQuality 
.const [53] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [54] = Utf8 de/audi/atip/log/LogChannel 
.const [55] = Utf8 de/audi/app/phone/core/bap/telephone2/TelBAPManagerTel2Utils 
.const [56] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2 
.const [57] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [58] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Class [122] 
.const [74] = NameAndType [123] [124] 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Class [128] 
.const [78] = NameAndType [129] [130] 
.const [79] = Class [131] 
.const [80] = NameAndType [132] [133] 
.const [81] = Class [134] 
.const [82] = NameAndType [135] [136] 
.const [83] = Class [137] 
.const [84] = NameAndType [138] [139] 
.const [85] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [86] = Class [140] 
.const [87] = NameAndType [141] [142] 
.const [88] = Class [143] 
.const [89] = NameAndType [144] [145] 
.const [90] = Class [146] 
.const [91] = NameAndType [147] [148] 
.const [92] = Class [149] 
.const [93] = NameAndType [150] [151] 
.const [94] = Class [152] 
.const [95] = NameAndType [153] [154] 
.const [96] = Class [155] 
.const [97] = NameAndType [156] [157] 
.const [98] = Utf8 de/audi/app/phone/core/bap/telephone2/TelBAPManagerTel2Utils 
.const [99] = Utf8 telModeSupportsData 
.const [100] = Utf8 (I)Z 
.const [101] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2SignalQuality 
.const [102] = Utf8 dataSignalQuality 
.const [103] = Utf8 I 
.const [104] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2SignalQuality 
.const [105] = Utf8 log 
.const [106] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [107] = Utf8 de/audi/atip/log/LogChannel 
.const [108] = Utf8 isInfo 
.const [109] = Utf8 ()Z 
.const [110] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [111] = Utf8 append 
.const [112] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [113] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [114] = Utf8 append 
.const [115] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [116] = Utf8 de/audi/atip/log/LogChannel 
.const [117] = Utf8 log 
.const [118] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [119] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2SignalQuality 
.const [120] = Utf8 getCombiService 
.const [121] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2; 
.const [122] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2SignalQuality 
.const [123] = Utf8 getTelephoneState 
.const [124] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [125] = Utf8 de/audi/atip/log/LogChannel 
.const [126] = Utf8 log 
.const [127] = Utf8 (ILjava/lang/String;)Z 
.const [128] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [131] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2SignalQuality 
.const [135] = Utf8 updateCombiWithDataSignalQuality 
.const [136] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2;IIIIZ)V 
.const [137] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2SignalQuality 
.const [138] = Utf8 dataSignalQuality 
.const [139] = Utf8 I 
.const [140] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2 
.const [141] = Utf8 updateSignalQuality 
.const [142] = Utf8 (I)V 
.const [143] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [144] = Utf8 getNadMode 
.const [145] = Utf8 ()I 
.const [146] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [147] = Utf8 getNadInstanceState 
.const [148] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [149] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [150] = Utf8 getTelMode 
.const [151] = Utf8 ()I 
.const [152] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [153] = Utf8 isPhoneReady 
.const [154] = Utf8 ()Z 
.const [155] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [156] = Utf8 getSignalQuality 
.const [157] = Utf8 ()I 
.const [158] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2SignalQuality 
.const [159] = Class [158] 
.const [160] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [161] = Class [160] 
.const [162] = Utf8 SIGNAL_QUALITY_KOMBI_INVALID 
.const [163] = Utf8 I 
.const [164] = Utf8 SIGNAL_QUALITY_DSI_INVALID 
.const [165] = Utf8 I 
.const [166] = Utf8 SIGNAL_QUALITY_UNKNOWN 
.const [167] = Utf8 I 
.const [168] = Utf8 dataSignalQuality 
.const [169] = Utf8 I 
.const [170] = Utf8 Code 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [173] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [174] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [175] = Utf8 updateCombiWithDataSignalQuality 
.const [176] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2;IIIIZ)V 
.const [177] = Utf8 updateAsync 
.const [178] = Utf8 ()V 
.end class 
