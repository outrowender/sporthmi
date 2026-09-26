.version 50 0 
.class super [175] 
.super [177] 
.implements [179] 
.field public static final [180] [181] 
.field public static final [182] [183] 
.field private final [184] [185] 
.field private [186] [187] 
.field private [188] [189] 
.field private final [190] [191] 

.method public [193] : [194] 
    .attribute [192] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     aconst_null 
L6:     checkcast [2] 
L9:     putfield [38] 
L12:    aload_0 
L13:    iconst_1 
L14:    putfield [39] 
L17:    aload_0 
L18:    aload_1 
L19:    putfield [40] 
L22:    aload_0 
L23:    aload_1 
L24:    invokevirtual [23] 
L27:    putfield [41] 
L30:    aload_0 
L31:    iconst_2 
L32:    anewarray [3] 
L35:    putfield [38] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [192] .code stack 3 locals 2 
L0:     iconst_1 
L1:     iload_1 
L2:     if_icmpne L36 
L5:     aload_0 
L6:     invokespecial [35] 
L9:     ldc [4] 
L11:    ldc [5] 
L13:    invokevirtual [25] 
L16:    pop 
L17:    aload_0 
L18:    dup 
L19:    astore_2 
L20:    monitorenter 
        .catch [0] from L21 to L28 using L31 
L21:    aload_0 
L22:    iconst_0 
L23:    putfield [39] 
L26:    aload_2 
L27:    monitorexit 
L28:    goto L36 
        .catch [0] from L31 to L34 using L31 
L31:    astore_3 
L32:    aload_2 
L33:    monitorexit 
L34:    aload_3 
L35:    athrow 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [192] .code stack 3 locals 2 
L0:     iconst_1 
L1:     iload_1 
L2:     if_icmpne L191 
L5:     aload_0 
L6:     invokespecial [36] 
L9:     iconst_1 
L10:    invokevirtual [26] 
L13:    ifeq L191 
L16:    aload_0 
L17:    invokespecial [36] 
L20:    invokevirtual [27] 
L23:    ifne L44 
L26:    aload_0 
L27:    invokespecial [36] 
L30:    invokevirtual [28] 
L33:    invokevirtual [29] 
L36:    invokeinterface [42] 0 
L41:    ifeq L73 
L44:    aconst_null 
L45:    aload_0 
L46:    getfield [20] 
L49:    iconst_0 
L50:    aaload 
L51:    if_acmpeq L191 
L54:    aload_0 
L55:    invokespecial [35] 
L58:    ldc [4] 
L60:    ldc [6] 
L62:    invokevirtual [25] 
L65:    pop 
L66:    aload_0 
L67:    invokevirtual [30] 
L70:    goto L191 
L73:    aload_0 
L74:    invokespecial [35] 
L77:    ldc [4] 
L79:    ldc [7] 
L81:    invokevirtual [25] 
L84:    pop 
L85:    aload_0 
L86:    dup 
L87:    astore_2 
L88:    monitorenter 
        .catch [0] from L89 to L183 using L186 
L89:    aload_0 
L90:    iconst_1 
L91:    putfield [39] 
L94:    aconst_null 
L95:    aload_0 
L96:    getfield [20] 
L99:    iconst_1 
L100:   aaload 
L101:   if_acmpeq L139 
L104:   aload_0 
L105:   invokespecial [35] 
L108:   ldc [4] 
L110:   ldc [8] 
L112:   invokevirtual [25] 
L115:   pop 
L116:   aload_0 
L117:   invokespecial [36] 
L120:   aload_0 
L121:   getfield [20] 
L124:   iconst_1 
L125:   aaload 
L126:   invokevirtual [31] 
L129:   aload_0 
L130:   getfield [20] 
L133:   iconst_1 
L134:   aconst_null 
L135:   aastore 
L136:   goto L181 
L139:   aconst_null 
L140:   aload_0 
L141:   getfield [20] 
L144:   iconst_0 
L145:   aaload 
L146:   if_acmpeq L181 
L149:   aload_0 
L150:   invokespecial [35] 
L153:   ldc [4] 
L155:   ldc [9] 
L157:   invokevirtual [25] 
L160:   pop 
L161:   aload_0 
L162:   invokespecial [36] 
L165:   aload_0 
L166:   getfield [20] 
L169:   iconst_0 
L170:   aaload 
L171:   invokevirtual [32] 
L174:   aload_0 
L175:   getfield [20] 
L178:   iconst_0 
L179:   aconst_null 
L180:   aastore 
L181:   aload_2 
L182:   monitorexit 
L183:   goto L191 
        .catch [0] from L186 to L189 using L186 
L186:   astore_3 
L187:   aload_2 
L188:   monitorexit 
L189:   aload_3 
L190:   athrow 
L191:   return 
L192:   
    .end code 
.end method 

.method synchronized [199] : [200] 
    .attribute [192] .code stack 5 locals 0 
L0:     iload_1 
L1:     iflt L9 
L4:     iload_1 
L5:     iconst_1 
L6:     if_icmple L24 
L9:     aload_0 
L10:    invokespecial [35] 
L13:    ldc [10] 
L15:    ldc [11] 
L17:    iload_1 
L18:    i2l 
L19:    invokevirtual [33] 
L22:    pop 
L23:    return 
L24:    aload_0 
L25:    getfield [21] 
L28:    ifeq L117 
L31:    aload_0 
L32:    invokespecial [36] 
L35:    iconst_1 
L36:    invokevirtual [26] 
L39:    ifeq L117 
L42:    aload_0 
L43:    invokespecial [36] 
L46:    invokevirtual [27] 
L49:    ifne L117 
L52:    aload_0 
L53:    invokespecial [35] 
L56:    ldc [10] 
L58:    ldc [12] 
L60:    invokevirtual [25] 
L63:    pop 
L64:    iload_1 
L65:    lookupswitch 
            0 : L92 
            1 : L103 
            default : L114 

L92:    aload_0 
L93:    invokespecial [36] 
L96:    aload_2 
L97:    invokevirtual [32] 
L100:   goto L136 
L103:   aload_0 
L104:   invokespecial [36] 
L107:   aload_2 
L108:   invokevirtual [31] 
L111:   goto L136 
L114:   goto L136 
L117:   aload_0 
L118:   invokespecial [35] 
L121:   ldc [10] 
L123:   ldc [13] 
L125:   invokevirtual [25] 
L128:   pop 
L129:   aload_0 
L130:   getfield [20] 
L133:   iload_1 
L134:   aload_2 
L135:   aastore 
L136:   return 
L137:   nop 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method synchronized [201] : [202] 
    .attribute [192] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_2 
L2:     anewarray [3] 
L5:     putfield [38] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method [203] : [204] 
    .attribute [192] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [37] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [205] : [206] 
    .attribute [192] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     invokespecial [37] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private synchronized [207] : [208] 
    .attribute [192] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     iload_1 
L5:     aconst_null 
L6:     aastore 
L7:     return 
L8:     
    .end code 
.end method 

.method private interface [209] : [210] 
    .attribute [192] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private interface [211] : [212] 
    .attribute [192] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [43] 
.const [3] = Class [44] 
.const [4] = Int 1078071040 
.const [5] = String [45] 
.const [6] = String [46] 
.const [7] = String [47] 
.const [8] = String [48] 
.const [9] = String [49] 
.const [10] = Int -2137614336 
.const [11] = String [50] 
.const [12] = String [51] 
.const [13] = String [52] 
.const [14] = Class [53] 
.const [15] = Class [54] 
.const [16] = Class [55] 
.const [17] = Class [56] 
.const [18] = Class [57] 
.const [19] = Class [58] 
.const [20] = Field [59] [60] 
.const [21] = Field [61] [62] 
.const [22] = Field [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Field [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Method [79] [80] 
.const [31] = Method [81] [82] 
.const [32] = Method [83] [84] 
.const [33] = Method [85] [86] 
.const [34] = Method [87] [88] 
.const [35] = Method [89] [90] 
.const [36] = Method [91] [92] 
.const [37] = Method [93] [94] 
.const [38] = Field [95] [96] 
.const [39] = Field [97] [98] 
.const [40] = Field [99] [100] 
.const [41] = Field [101] [102] 
.const [42] = InterfaceMethod [103] [104] 
.const [43] = Utf8 [[Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [44] = Utf8 [Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [45] = Utf8 '[UotaSpeedThresholdHandler].exceedsUpperThreshold()' 
.const [46] = Utf8 '[UotaSpeedThresholdHandler].belowLowerThreshold(): the system proposal is not up-to-date, clean up it' 
.const [47] = Utf8 '[UotaSpeedThresholdHandler].belowLowerThreshold()' 
.const [48] = Utf8 '[UotaSpeedThresholdHandler].belowLowerThreshold(): Triggering show destination proposal pop-up!' 
.const [49] = Utf8 '[UotaSpeedThresholdHandler].belowLowerThreshold(): Triggering show system proposal pop-up!' 
.const [50] = Utf8 '[UotaSpeedThresholdHandler].requestSysProposalInfoPopup(): unknown pop-up type %1' 
.const [51] = Utf8 '[UotaSpeedThresholdHandler].requestSysProposalInfoPopup(): Below speed threshold, showing pop-ups' 
.const [52] = Utf8 '[UotaSpeedThresholdHandler].requestNewPopup(): Over speed threshold, delaying pop-ups' 
.const [53] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [54] = Utf8 java/lang/Object 
.const [55] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 de/audi/tghu/swdl/app/SwdlModels 
.const [58] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Class [108] 
.const [62] = NameAndType [109] [110] 
.const [63] = Class [111] 
.const [64] = NameAndType [112] [113] 
.const [65] = Class [114] 
.const [66] = NameAndType [115] [116] 
.const [67] = Class [117] 
.const [68] = NameAndType [118] [119] 
.const [69] = Class [120] 
.const [70] = NameAndType [121] [122] 
.const [71] = Class [123] 
.const [72] = NameAndType [124] [125] 
.const [73] = Class [126] 
.const [74] = NameAndType [127] [128] 
.const [75] = Class [129] 
.const [76] = NameAndType [130] [131] 
.const [77] = Class [132] 
.const [78] = NameAndType [133] [134] 
.const [79] = Class [135] 
.const [80] = NameAndType [136] [137] 
.const [81] = Class [138] 
.const [82] = NameAndType [139] [140] 
.const [83] = Class [141] 
.const [84] = NameAndType [142] [143] 
.const [85] = Class [144] 
.const [86] = NameAndType [145] [146] 
.const [87] = Class [147] 
.const [88] = NameAndType [148] [149] 
.const [89] = Class [150] 
.const [90] = NameAndType [151] [152] 
.const [91] = Class [153] 
.const [92] = NameAndType [154] [155] 
.const [93] = Class [156] 
.const [94] = NameAndType [157] [158] 
.const [95] = Class [159] 
.const [96] = NameAndType [160] [161] 
.const [97] = Class [162] 
.const [98] = NameAndType [163] [164] 
.const [99] = Class [165] 
.const [100] = NameAndType [166] [167] 
.const [101] = Class [168] 
.const [102] = NameAndType [169] [170] 
.const [103] = Class [171] 
.const [104] = NameAndType [172] [173] 
.const [105] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [106] = Utf8 updatePackages 
.const [107] = Utf8 [[Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [108] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [109] = Utf8 isBelowVelocityThreshold 
.const [110] = Utf8 Z 
.const [111] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [112] = Utf8 uotaController 
.const [113] = Utf8 Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [114] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [115] = Utf8 getLogUota 
.const [116] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [117] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [118] = Utf8 logUota 
.const [119] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 log 
.const [122] = Utf8 (ILjava/lang/String;)Z 
.const [123] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [124] = Utf8 isUotaUpdateAllowed 
.const [125] = Utf8 (Z)Z 
.const [126] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [127] = Utf8 isDownloadActive 
.const [128] = Utf8 ()Z 
.const [129] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [130] = Utf8 getSwdlModels 
.const [131] = Utf8 ()Lde/audi/tghu/swdl/app/SwdlModels; 
.const [132] = Utf8 de/audi/tghu/swdl/app/SwdlModels 
.const [133] = Utf8 getCustomerProgressStateChoice 
.const [134] = Utf8 ()Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [135] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [136] = Utf8 cleanUpSysProposalPopupRequest 
.const [137] = Utf8 ()V 
.const [138] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [139] = Utf8 showDestinationProposalPackagesAvailablePopup 
.const [140] = Utf8 ([Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper;)V 
.const [141] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [142] = Utf8 showSystemProposalPackagesAvailablePopup 
.const [143] = Utf8 ([Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper;)V 
.const [144] = Utf8 de/audi/atip/log/LogChannel 
.const [145] = Utf8 log 
.const [146] = Utf8 (ILjava/lang/String;J)Z 
.const [147] = Utf8 java/lang/Object 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [151] = Utf8 getLogUota 
.const [152] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [153] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [154] = Utf8 getUotaController 
.const [155] = Utf8 ()Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [156] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [157] = Utf8 cleanUpPopupRequest 
.const [158] = Utf8 (I)V 
.const [159] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [160] = Utf8 updatePackages 
.const [161] = Utf8 [[Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [162] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [163] = Utf8 isBelowVelocityThreshold 
.const [164] = Utf8 Z 
.const [165] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [166] = Utf8 uotaController 
.const [167] = Utf8 Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [168] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [169] = Utf8 logUota 
.const [170] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [171] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [172] = Utf8 getValue 
.const [173] = Utf8 ()I 
.const [174] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaSpeedThresholdHandler 
.const [175] = Class [174] 
.const [176] = Utf8 java/lang/Object 
.const [177] = Class [176] 
.const [178] = Utf8 de/audi/atip/sysapp/SpeedThresholdListener 
.const [179] = Class [178] 
.const [180] = Utf8 POPUP_TYPE_SYSTEM_PROPOSAL 
.const [181] = Utf8 I 
.const [182] = Utf8 POPUP_TYPE_DESTINATION_PROPOSAL 
.const [183] = Utf8 I 
.const [184] = Utf8 uotaController 
.const [185] = Utf8 Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [186] = Utf8 updatePackages 
.const [187] = Utf8 [[Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [188] = Utf8 isBelowVelocityThreshold 
.const [189] = Utf8 Z 
.const [190] = Utf8 logUota 
.const [191] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [192] = Utf8 Code 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController;)V 
.const [195] = Utf8 exceedsUpperThreshold 
.const [196] = Utf8 (I)V 
.const [197] = Utf8 belowLowerThreshold 
.const [198] = Utf8 (I)V 
.const [199] = Utf8 requestSysProposalInfoPopup 
.const [200] = Utf8 (I[Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper;)V 
.const [201] = Utf8 cleanUpPopupRequests 
.const [202] = Utf8 ()V 
.const [203] = Utf8 cleanUpDestinationPopupRequest 
.const [204] = Utf8 ()V 
.const [205] = Utf8 cleanUpSysProposalPopupRequest 
.const [206] = Utf8 ()V 
.const [207] = Utf8 cleanUpPopupRequest 
.const [208] = Utf8 (I)V 
.const [209] = Utf8 getUotaController 
.const [210] = Utf8 ()Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [211] = Utf8 getLogUota 
.const [212] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.end class 
