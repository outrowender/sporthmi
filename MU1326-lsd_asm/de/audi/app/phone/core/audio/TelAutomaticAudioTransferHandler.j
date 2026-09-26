.version 50 0 
.class public super [152] 
.super [154] 

.method public [156] : [157] 
    .attribute [155] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [24] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     invokevirtual [19] 
L8:     invokeinterface [28] 0 
L13:    aload_0 
L14:    invokeinterface [29] 0 
L19:    return 
L20:    
    .end code 
.end method 

.method public [160] : [161] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     invokevirtual [19] 
L8:     invokeinterface [28] 0 
L13:    aload_0 
L14:    invokeinterface [30] 0 
L19:    return 
L20:    
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [155] .code stack 2 locals 0 
L0:     iload_1 
L1:     ldc [3] 
L3:     if_icmpeq L24 
L6:     iload_1 
L7:     ldc [4] 
L9:     if_icmpeq L24 
L12:    iload_1 
L13:    ldc [5] 
L15:    if_icmpeq L24 
L18:    iload_1 
L19:    ldc [6] 
L21:    if_icmpne L29 
L24:    aload_0 
L25:    aload_2 
L26:    invokespecial [27] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [164] : [165] 
    .attribute [155] .code stack 3 locals 8 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [20] 
L8:     sipush 10000 
L11:    ldc [7] 
L13:    invokevirtual [21] 
L16:    pop 
L17:    return 
L18:    aload_1 
L19:    invokeinterface [31] 0 
L24:    astore_2 
L25:    aload_1 
L26:    invokeinterface [32] 0 
L31:    astore_3 
L32:    aload_3 
L33:    ifnull L45 
L36:    aload_3 
L37:    invokeinterface [33] 0 
L42:    goto L46 
L45:    aconst_null 
L46:    astore 4 
L48:    aload_2 
L49:    ifnull L61 
L52:    aload_2 
L53:    invokeinterface [33] 0 
L58:    goto L62 
L61:    aconst_null 
L62:    astore 5 
L64:    aload 4 
L66:    ifnull L232 
L69:    aload 5 
L71:    ifnull L232 
L74:    aload 4 
L76:    invokevirtual [22] 
L79:    iconst_3 
L80:    if_icmpeq L93 
L83:    aload 4 
L85:    invokevirtual [22] 
L88:    bipush 32 
L90:    if_icmpne L97 
L93:    iconst_1 
L94:    goto L98 
L97:    iconst_0 
L98:    istore 6 
L100:   aload 5 
L102:   invokevirtual [22] 
L105:   iconst_3 
L106:   if_icmpeq L119 
L109:   aload 5 
L111:   invokevirtual [22] 
L114:   bipush 32 
L116:   if_icmpne L123 
L119:   iconst_1 
L120:   goto L124 
L123:   iconst_0 
L124:   istore 7 
L126:   aload 4 
L128:   invokevirtual [23] 
L131:   ifne L146 
L134:   aload 5 
L136:   invokevirtual [23] 
L139:   ifne L146 
L142:   iconst_1 
L143:   goto L147 
L146:   iconst_0 
L147:   istore 8 
L149:   iload 6 
L151:   ifne L163 
L154:   iload 7 
L156:   ifne L163 
L159:   iconst_1 
L160:   goto L164 
L163:   iconst_0 
L164:   istore 9 
L166:   iload 8 
L168:   ifeq L232 
L171:   iload 9 
L173:   ifeq L232 
L176:   aload_2 
L177:   invokeinterface [34] 0 
L182:   iconst_3 
L183:   if_icmpne L232 
L186:   aload_2 
L187:   invokeinterface [35] 0 
L192:   ifne L232 
L195:   aload_1 
L196:   invokeinterface [36] 0 
L201:   ifne L232 
L204:   aload_0 
L205:   getfield [20] 
L208:   ldc [8] 
L210:   ldc [9] 
L212:   invokevirtual [21] 
L215:   pop 
L216:   aload_0 
L217:   invokevirtual [19] 
L220:   invokeinterface [37] 0 
L225:   iconst_4 
L226:   iconst_0 
L227:   invokeinterface [38] 0 
L232:   return 
L233:   nop 
L234:   nop 
L235:   nop 
L236:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [39] 
.const [3] = Int 134218240 
.const [4] = Int 134217984 
.const [5] = Int 234881280 
.const [6] = Int 234881536 
.const [7] = String [40] 
.const [8] = Int 1078071040 
.const [9] = String [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Class [49] 
.const [18] = Class [50] 
.const [19] = Method [51] [52] 
.const [20] = Field [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = InterfaceMethod [71] [72] 
.const [30] = InterfaceMethod [73] [74] 
.const [31] = InterfaceMethod [75] [76] 
.const [32] = InterfaceMethod [77] [78] 
.const [33] = InterfaceMethod [79] [80] 
.const [34] = InterfaceMethod [81] [82] 
.const [35] = InterfaceMethod [83] [84] 
.const [36] = InterfaceMethod [85] [86] 
.const [37] = InterfaceMethod [87] [88] 
.const [38] = InterfaceMethod [89] [90] 
.const [39] = Utf8 'App.Phone.Audio' 
.const [40] = Utf8 'TelAutomaticAudioTransferHandler#checkChangeHFModeToPrivate stateStruct is null' 
.const [41] = Utf8 '[TelAutomaticAudioTransferHandler#checkChangeHFModeToPrivate] switching handsfree mode for non call leading device to private' 
.const [42] = Utf8 de/audi/app/phone/core/audio/TelAutomaticAudioTransferHandler 
.const [43] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [44] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [45] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [48] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [49] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [50] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
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
.const [81] = Class [136] 
.const [82] = NameAndType [137] [138] 
.const [83] = Class [139] 
.const [84] = NameAndType [140] [141] 
.const [85] = Class [142] 
.const [86] = NameAndType [143] [144] 
.const [87] = Class [145] 
.const [88] = NameAndType [146] [147] 
.const [89] = Class [148] 
.const [90] = NameAndType [149] [150] 
.const [91] = Utf8 de/audi/app/phone/core/audio/TelAutomaticAudioTransferHandler 
.const [92] = Utf8 getApplication 
.const [93] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [94] = Utf8 de/audi/app/phone/core/audio/TelAutomaticAudioTransferHandler 
.const [95] = Utf8 log 
.const [96] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;)Z 
.const [100] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [101] = Utf8 getMpCallState 
.const [102] = Utf8 ()I 
.const [103] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [104] = Utf8 isIdle 
.const [105] = Utf8 ()Z 
.const [106] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [109] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [110] = Utf8 init 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [113] = Utf8 deinit 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/audi/app/phone/core/audio/TelAutomaticAudioTransferHandler 
.const [116] = Utf8 checkChangeHFModeToPrivate 
.const [117] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [118] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [119] = Utf8 getGlobalTelephoneStateManager 
.const [120] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [121] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [122] = Utf8 registerListener 
.const [123] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [124] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [125] = Utf8 removeListener 
.const [126] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [127] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [128] = Utf8 getNonCallLeadingDevice 
.const [129] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [130] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [131] = Utf8 getCallLeadingDevice 
.const [132] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [133] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [134] = Utf8 getCallState 
.const [135] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [136] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [137] = Utf8 getTelMode 
.const [138] = Utf8 ()I 
.const [139] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [140] = Utf8 getHandsFreeMode 
.const [141] = Utf8 ()I 
.const [142] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [143] = Utf8 isAcceptIncomingCallOnNonCallLeadingDevicePending 
.const [144] = Utf8 ()Z 
.const [145] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [146] = Utf8 getTelephoneDSIAccess 
.const [147] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [148] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [149] = Utf8 requestSetHandsFreeModeNonCallLeadingDevice 
.const [150] = Utf8 (II)V 
.const [151] = Utf8 de/audi/app/phone/core/audio/TelAutomaticAudioTransferHandler 
.const [152] = Class [151] 
.const [153] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [154] = Class [153] 
.const [155] = Utf8 Code 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [158] = Utf8 init 
.const [159] = Utf8 ()V 
.const [160] = Utf8 deinit 
.const [161] = Utf8 ()V 
.const [162] = Utf8 updateGlobalTelephoneStateProperty 
.const [163] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [164] = Utf8 checkChangeHFModeToPrivate 
.const [165] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.end class 
