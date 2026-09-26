.version 50 0 
.class public super [181] 
.super [183] 
.implements [185] 
.implements [187] 
.field private static final [188] [189] 
.field private static final [190] [191] 
.field private final [192] [193] 
.field private final [194] [195] 
.field private [196] [197] 
.field private [198] [199] 
.field private [200] [201] 

.method public [203] : [204] 
    .attribute [202] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [36] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [37] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [38] 
L19:    aload_0 
L20:    aload_2 
L21:    putfield [39] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private interface [205] : [206] 
    .attribute [202] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [202] .code stack 9 locals 1 
L0:     iload_3 
L1:     ifeq L133 
L4:     aload_0 
L5:     getfield [20] 
L8:     ldc [2] 
L10:    ldc [3] 
L12:    iload_1 
L13:    i2l 
L14:    iload_2 
L15:    i2l 
L16:    invokevirtual [21] 
L19:    pop 
L20:    aload_0 
L21:    getfield [17] 
L24:    ifnull L35 
L27:    aload_0 
L28:    getfield [17] 
L31:    invokevirtual [22] 
L34:    pop 
L35:    new [40] 
L38:    dup 
L39:    iload_2 
L40:    iload_1 
L41:    invokespecial [33] 
L44:    astore 4 
L46:    aload_0 
L47:    iconst_1 
L48:    anewarray [4] 
L51:    putfield [41] 
L54:    aload_0 
L55:    getfield [23] 
L58:    iconst_0 
L59:    aload 4 
L61:    aastore 
L62:    aload_0 
L63:    invokespecial [34] 
L66:    invokevirtual [24] 
L69:    ifeq L86 
L72:    aload_0 
L73:    invokespecial [34] 
L76:    aload_0 
L77:    getfield [23] 
L80:    invokevirtual [25] 
L83:    goto L130 
L86:    aload_0 
L87:    getfield [20] 
L90:    ldc [2] 
L92:    ldc [5] 
L94:    iload_1 
L95:    i2l 
L96:    iload_2 
L97:    i2l 
L98:    ldc_w [1] 
L101:   invokevirtual [26] 
L104:   pop 
L105:   aload_0 
L106:   new [42] 
L109:   dup 
L110:   ldc [7] 
L112:   ldc_w [1] 
L115:   iconst_0 
L116:   aload_0 
L117:   invokespecial [35] 
L120:   putfield [36] 
L123:   aload_0 
L124:   getfield [17] 
L127:   invokevirtual [27] 
L130:   goto L145 
L133:   aload_0 
L134:   getfield [20] 
L137:   ldc [2] 
L139:   ldc [8] 
L141:   invokevirtual [28] 
L144:   pop 
L145:   return 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [202] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [2] 
L6:     ldc [9] 
L8:     invokevirtual [28] 
L11:    pop 
L12:    aload_0 
L13:    invokespecial [34] 
L16:    invokevirtual [29] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [202] .code stack 5 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [17] 
L5:     invokevirtual [30] 
L8:     ifeq L100 
L11:    aload_0 
L12:    getfield [18] 
L15:    sipush 150 
L18:    if_icmple L43 
L21:    aload_0 
L22:    getfield [20] 
L25:    sipush 10000 
L28:    ldc [10] 
L30:    invokevirtual [28] 
L33:    pop 
L34:    aload_0 
L35:    getfield [17] 
L38:    invokevirtual [22] 
L41:    pop 
L42:    return 
L43:    aload_0 
L44:    invokespecial [34] 
L47:    invokevirtual [24] 
L50:    ifeq L75 
L53:    aload_0 
L54:    invokespecial [34] 
L57:    aload_0 
L58:    getfield [23] 
L61:    invokevirtual [25] 
L64:    aload_0 
L65:    getfield [17] 
L68:    invokevirtual [22] 
L71:    pop 
L72:    goto L100 
L75:    aload_0 
L76:    getfield [20] 
L79:    ldc [11] 
L81:    ldc [12] 
L83:    ldc_w [1] 
L86:    invokevirtual [31] 
L89:    pop 
L90:    aload_0 
L91:    dup 
L92:    getfield [18] 
L95:    iconst_1 
L96:    iadd 
L97:    putfield [37] 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [202] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [17] 
L5:     invokevirtual [30] 
L8:     ifeq L21 
L11:    aload_0 
L12:    aconst_null 
L13:    putfield [36] 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [37] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [45] 
.const [4] = Class [46] 
.const [5] = String [47] 
.const [6] = Class [48] 
.const [7] = String [49] 
.const [8] = String [50] 
.const [9] = String [51] 
.const [10] = String [52] 
.const [11] = Int -2137614336 
.const [12] = String [53] 
.const [13] = Class [54] 
.const [14] = Class [55] 
.const [15] = Class [56] 
.const [16] = Class [57] 
.const [17] = Field [58] [59] 
.const [18] = Field [60] [61] 
.const [19] = Field [62] [63] 
.const [20] = Field [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Field [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Field [96] [97] 
.const [37] = Field [98] [99] 
.const [38] = Field [100] [101] 
.const [39] = Field [102] [103] 
.const [40] = Class [104] 
.const [41] = Field [105] [106] 
.const [42] = Class [107] 
.const [43] = Int 33554432 
.const [44] = Int -804847616 
.const [45] = Utf8 '[UotaNavListenerImpl].startNewGuidance(%1,%2)' 
.const [46] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [47] = Utf8 '[UotaNavListenerImpl].startNewGuidance(%1,%2): UotA service is not ready, wait %3 sec' 
.const [48] = Utf8 de/audi/atip/timer/Timer 
.const [49] = Utf8 'Wait UOTA service ready' 
.const [50] = Utf8 '[UotaNavListenerImpl].startNewGuidance(): trigger is not valid, nothing to do.' 
.const [51] = Utf8 '[UotaNavListenerImpl].cancelLastGuidance()' 
.const [52] = Utf8 '[UotaNavListenerImpl].fireTimer(): timer achieves the max limit of shots, cancel timer' 
.const [53] = Utf8 '[UotaNavListenerImpl].fireTimer(): UotA service still not ready, wait %1 sec' 
.const [54] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Class [165] 
.const [97] = NameAndType [166] [167] 
.const [98] = Class [168] 
.const [99] = NameAndType [169] [170] 
.const [100] = Class [171] 
.const [101] = NameAndType [172] [173] 
.const [102] = Class [174] 
.const [103] = NameAndType [175] [176] 
.const [104] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [105] = Class [177] 
.const [106] = NameAndType [178] [179] 
.const [107] = Utf8 de/audi/atip/timer/Timer 
.const [108] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [109] = Utf8 waitServiceReadyTimer 
.const [110] = Utf8 Lde/audi/atip/timer/Timer; 
.const [111] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [112] = Utf8 shotCount 
.const [113] = Utf8 I 
.const [114] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [115] = Utf8 uotaController 
.const [116] = Utf8 Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [117] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [118] = Utf8 logChannel 
.const [119] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 log 
.const [122] = Utf8 (ILjava/lang/String;JJ)Z 
.const [123] = Utf8 de/audi/atip/timer/Timer 
.const [124] = Utf8 cancel 
.const [125] = Utf8 ()Z 
.const [126] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [127] = Utf8 locations 
.const [128] = Utf8 [Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [129] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [130] = Utf8 isServiceReady 
.const [131] = Utf8 ()Z 
.const [132] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [133] = Utf8 startNewGuidance 
.const [134] = Utf8 ([Lorg/dsi/ifc/global/NavLocationWgs84;)V 
.const [135] = Utf8 de/audi/atip/log/LogChannel 
.const [136] = Utf8 log 
.const [137] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [138] = Utf8 de/audi/atip/timer/Timer 
.const [139] = Utf8 start 
.const [140] = Utf8 ()V 
.const [141] = Utf8 de/audi/atip/log/LogChannel 
.const [142] = Utf8 log 
.const [143] = Utf8 (ILjava/lang/String;)Z 
.const [144] = Utf8 de/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController 
.const [145] = Utf8 cancelLastGuidance 
.const [146] = Utf8 ()V 
.const [147] = Utf8 java/lang/Object 
.const [148] = Utf8 equals 
.const [149] = Utf8 (Ljava/lang/Object;)Z 
.const [150] = Utf8 de/audi/atip/log/LogChannel 
.const [151] = Utf8 log 
.const [152] = Utf8 (ILjava/lang/String;J)Z 
.const [153] = Utf8 java/lang/Object 
.const [154] = Utf8 <init> 
.const [155] = Utf8 ()V 
.const [156] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (II)V 
.const [159] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [160] = Utf8 getUotaController 
.const [161] = Utf8 ()Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [162] = Utf8 de/audi/atip/timer/Timer 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [165] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [166] = Utf8 waitServiceReadyTimer 
.const [167] = Utf8 Lde/audi/atip/timer/Timer; 
.const [168] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [169] = Utf8 shotCount 
.const [170] = Utf8 I 
.const [171] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [172] = Utf8 uotaController 
.const [173] = Utf8 Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [174] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [175] = Utf8 logChannel 
.const [176] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [177] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [178] = Utf8 locations 
.const [179] = Utf8 [Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [180] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotANavListenerImpl 
.const [181] = Class [180] 
.const [182] = Utf8 java/lang/Object 
.const [183] = Class [182] 
.const [184] = Utf8 de/audi/atip/interapp/navuota/UotaNavListener 
.const [185] = Class [184] 
.const [186] = Utf8 de/audi/atip/timer/TimerListener 
.const [187] = Class [186] 
.const [188] = Utf8 WAIT_TIMEOUT 
.const [189] = Utf8 J 
.const [190] = Utf8 MAX_SHOT_COUNT 
.const [191] = Utf8 I 
.const [192] = Utf8 uotaController 
.const [193] = Utf8 Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [194] = Utf8 logChannel 
.const [195] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [196] = Utf8 waitServiceReadyTimer 
.const [197] = Utf8 Lde/audi/atip/timer/Timer; 
.const [198] = Utf8 shotCount 
.const [199] = Utf8 I 
.const [200] = Utf8 locations 
.const [201] = Utf8 [Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [202] = Utf8 Code 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController;Lde/audi/atip/log/LogChannel;)V 
.const [205] = Utf8 getUotaController 
.const [206] = Utf8 ()Lde/audi/tghu/swdl/app/customer/uota/BaseUpdateOverTheAirController; 
.const [207] = Utf8 startNewGuidance 
.const [208] = Utf8 (IIZ)V 
.const [209] = Utf8 cancelLastGuidance 
.const [210] = Utf8 ()V 
.const [211] = Utf8 fireTimer 
.const [212] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [213] = Utf8 cancelTimer 
.const [214] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.end class 
