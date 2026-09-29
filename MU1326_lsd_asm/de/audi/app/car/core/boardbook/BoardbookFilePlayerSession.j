.version 50 0 
.class public super [222] 
.super [224] 
.implements [226] 
.field private static final [227] [228] 
.field private static final [229] [230] 
.field private static final [231] [232] 
.field private static final [233] [234] 
.field private static final [235] [236] 
.field private static final [237] [238] 
.field private static final [239] [240] 
.field private static final [241] [242] 
.field private static final [243] [244] 
.field private static final [245] [246] 
.field private static final [247] [248] 
.field private static final [249] [250] 
.field final [251] [252] 
.field final [253] [254] 
.field private [255] [256] 
.field private [257] [258] 
.field private volatile [259] [260] 
.field private [261] [262] 
.field private [263] [264] 
.field private [265] [266] 

.method public [268] : [269] 
    .attribute [267] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [37] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [38] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [39] 
L19:    aload_0 
L20:    iload_3 
L21:    putfield [40] 
L24:    aload_0 
L25:    iload 4 
L27:    putfield [41] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public interface [270] : [271] 
    .attribute [267] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [272] : [273] 
    .attribute [267] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [42] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [274] : [275] 
    .attribute [267] .code stack 1 locals 0 
L0:     sipush 201 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [276] : [277] 
    .attribute [267] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [278] : [279] 
    .attribute [267] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method private [280] : [281] 
    .attribute [267] .code stack 7 locals 2 
L0:     iload_3 
L1:     iload_1 
L2:     if_icmple L9 
L5:     iconst_0 
L6:     goto L14 
L9:     iload_1 
L10:    iload_3 
L11:    isub 
L12:    iconst_2 
L13:    idiv 
L14:    istore 5 
L16:    iload 4 
L18:    iload_2 
L19:    if_icmple L26 
L22:    iconst_0 
L23:    goto L32 
L26:    iload_2 
L27:    iload 4 
L29:    isub 
L30:    iconst_2 
L31:    idiv 
L32:    istore 6 
L34:    aload_0 
L35:    getfield [19] 
L38:    ldc [3] 
L40:    ldc [4] 
L42:    iload_3 
L43:    i2l 
L44:    iload 4 
L46:    i2l 
L47:    invokevirtual [25] 
L50:    pop 
L51:    aload_0 
L52:    getfield [19] 
L55:    ldc [3] 
L57:    ldc [5] 
L59:    iload 5 
L61:    i2l 
L62:    iload 6 
L64:    i2l 
L65:    invokevirtual [25] 
L68:    pop 
L69:    aload_0 
L70:    getfield [26] 
L73:    iload 5 
L75:    iload 6 
L77:    iload_3 
L78:    iload 4 
L80:    invokeinterface [44] 0 
L85:    return 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [282] : [283] 
    .attribute [267] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     iconst_0 
L5:     invokevirtual [27] 
L8:     aload_0 
L9:     getfield [19] 
L12:    ldc [3] 
L14:    ldc [6] 
L16:    invokevirtual [28] 
L19:    pop 
L20:    aload_0 
L21:    aload_1 
L22:    checkcast [7] 
L25:    putfield [43] 
L28:    aload_0 
L29:    getfield [19] 
L32:    ldc [3] 
L34:    ldc [8] 
L36:    aload_0 
L37:    getfield [22] 
L40:    i2l 
L41:    invokevirtual [29] 
L44:    pop 
L45:    aload_0 
L46:    getfield [22] 
L49:    tableswitch 1 
            L80 
            L99 
            L144 
            L118 
            default : L144 

L80:    aload_0 
L81:    sipush 800 
L84:    sipush 480 
L87:    sipush 640 
L90:    sipush 360 
L93:    invokespecial [36] 
L96:    goto L145 
L99:    aload_0 
L100:   sipush 1024 
L103:   sipush 480 
L106:   sipush 853 
L109:   sipush 480 
L112:   invokespecial [36] 
L115:   goto L145 
L118:   aload_0 
L119:   getfield [23] 
L122:   ifeq L144 
L125:   aload_0 
L126:   sipush 800 
L129:   sipush 480 
L132:   sipush 640 
L135:   sipush 360 
L138:   invokespecial [36] 
L141:   goto L145 
L144:   return 
L145:   aload_0 
L146:   getfield [26] 
L149:   aload_0 
L150:   getfield [24] 
L153:   iconst_0 
L154:   invokeinterface [45] 0 
L159:   return 
L160:   
    .end code 
.end method 

.method public [284] : [285] 
    .attribute [267] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [9] 
L8:     invokevirtual [28] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [286] : [287] 
    .attribute [267] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [10] 
L8:     invokevirtual [28] 
L11:    pop 
L12:    aload_0 
L13:    aconst_null 
L14:    putfield [43] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [288] : [289] 
    .attribute [267] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [11] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [29] 
L13:    pop 
L14:    aload_0 
L15:    iload_1 
L16:    putfield [39] 
L19:    iload_1 
L20:    iconst_2 
L21:    if_icmpne L39 
L24:    aload_0 
L25:    getfield [30] 
L28:    iconst_2 
L29:    if_icmpeq L39 
L32:    aload_0 
L33:    getfield [20] 
L36:    invokevirtual [31] 
L39:    aload_0 
L40:    iload_1 
L41:    putfield [46] 
L44:    iload_1 
L45:    bipush 6 
L47:    if_icmpeq L59 
L50:    iload_1 
L51:    iconst_5 
L52:    if_icmpeq L59 
L55:    iload_1 
L56:    ifne L66 
L59:    aload_0 
L60:    getfield [20] 
L63:    invokevirtual [32] 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [290] : [291] 
    .attribute [267] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [12] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [25] 
L15:    pop 
L16:    aload_0 
L17:    getfield [20] 
L20:    iload_1 
L21:    iload_2 
L22:    invokevirtual [33] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [292] : [293] 
    .attribute [267] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [13] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [29] 
L13:    pop 
L14:    aload_0 
L15:    getfield [20] 
L18:    invokevirtual [34] 
L21:    iload_1 
L22:    invokeinterface [47] 0 
L27:    return 
L28:    
    .end code 
.end method 

.method public [294] : [295] 
    .attribute [267] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifnull L16 
L7:     aload_0 
L8:     getfield [26] 
L11:    invokeinterface [48] 0 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [296] : [297] 
    .attribute [267] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifnull L16 
L7:     aload_0 
L8:     getfield [26] 
L11:    invokeinterface [49] 0 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [50] 
.const [3] = Int 1078071040 
.const [4] = String [51] 
.const [5] = String [52] 
.const [6] = String [53] 
.const [7] = Class [54] 
.const [8] = String [55] 
.const [9] = String [56] 
.const [10] = String [57] 
.const [11] = String [58] 
.const [12] = String [59] 
.const [13] = String [60] 
.const [14] = Class [61] 
.const [15] = Class [62] 
.const [16] = Class [63] 
.const [17] = Class [64] 
.const [18] = Class [65] 
.const [19] = Field [66] [67] 
.const [20] = Field [68] [69] 
.const [21] = Field [70] [71] 
.const [22] = Field [72] [73] 
.const [23] = Field [74] [75] 
.const [24] = Field [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Field [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Field [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Field [108] [109] 
.const [41] = Field [110] [111] 
.const [42] = Field [112] [113] 
.const [43] = Field [114] [115] 
.const [44] = InterfaceMethod [116] [117] 
.const [45] = InterfaceMethod [118] [119] 
.const [46] = Field [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = InterfaceMethod [124] [125] 
.const [49] = InterfaceMethod [126] [127] 
.const [50] = Utf8 BoardbookVideoSession 
.const [51] = Utf8 'BoardbookFilePlayerSession#calcAndSetVideoScaling():  XRes = %1  and YRes = %2' 
.const [52] = Utf8 'BoardbookFilePlayerSession#calcAndSetVideoScaling():  XPos = %1  and YPos = %2' 
.const [53] = Utf8 'BoardbookFilePlayerSession#onActive()' 
.const [54] = Utf8 de/audi/atip/interapp/media/IMediaFileSessionPlayer 
.const [55] = Utf8 'ScreenRes: %1' 
.const [56] = Utf8 'BoardbookFilePlayerSession#onSuspended()' 
.const [57] = Utf8 'BoardbookFilePlayerSession#onClose()' 
.const [58] = Utf8 'BoardbookFilePlayerSession#updateState: update session state %1' 
.const [59] = Utf8 'BoardbooFilePlayerSession#updatePlayPosition %1 %2' 
.const [60] = Utf8 'BoardbookFilePlayerSession#updateVideoDisplayContext received display context %1' 
.const [61] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [62] = Utf8 java/lang/Object 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 de/audi/app/car/core/boardbook/BoardbookHandler 
.const [65] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [66] = Class [128] 
.const [67] = NameAndType [129] [130] 
.const [68] = Class [131] 
.const [69] = NameAndType [132] [133] 
.const [70] = Class [134] 
.const [71] = NameAndType [135] [136] 
.const [72] = Class [137] 
.const [73] = NameAndType [138] [139] 
.const [74] = Class [140] 
.const [75] = NameAndType [141] [142] 
.const [76] = Class [143] 
.const [77] = NameAndType [144] [145] 
.const [78] = Class [146] 
.const [79] = NameAndType [147] [148] 
.const [80] = Class [149] 
.const [81] = NameAndType [150] [151] 
.const [82] = Class [152] 
.const [83] = NameAndType [153] [154] 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Class [158] 
.const [87] = NameAndType [159] [160] 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Class [167] 
.const [93] = NameAndType [168] [169] 
.const [94] = Class [170] 
.const [95] = NameAndType [171] [172] 
.const [96] = Class [173] 
.const [97] = NameAndType [174] [175] 
.const [98] = Class [176] 
.const [99] = NameAndType [177] [178] 
.const [100] = Class [179] 
.const [101] = NameAndType [180] [181] 
.const [102] = Class [182] 
.const [103] = NameAndType [183] [184] 
.const [104] = Class [185] 
.const [105] = NameAndType [186] [187] 
.const [106] = Class [188] 
.const [107] = NameAndType [189] [190] 
.const [108] = Class [191] 
.const [109] = NameAndType [192] [193] 
.const [110] = Class [194] 
.const [111] = NameAndType [195] [196] 
.const [112] = Class [197] 
.const [113] = NameAndType [198] [199] 
.const [114] = Class [200] 
.const [115] = NameAndType [201] [202] 
.const [116] = Class [203] 
.const [117] = NameAndType [204] [205] 
.const [118] = Class [206] 
.const [119] = NameAndType [207] [208] 
.const [120] = Class [209] 
.const [121] = NameAndType [210] [211] 
.const [122] = Class [212] 
.const [123] = NameAndType [213] [214] 
.const [124] = Class [215] 
.const [125] = NameAndType [216] [217] 
.const [126] = Class [218] 
.const [127] = NameAndType [219] [220] 
.const [128] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [129] = Utf8 logChannel 
.const [130] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [131] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [132] = Utf8 handler 
.const [133] = Utf8 Lde/audi/app/car/core/boardbook/BoardbookHandler; 
.const [134] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [135] = Utf8 state 
.const [136] = Utf8 I 
.const [137] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [138] = Utf8 currentScreenRes 
.const [139] = Utf8 I 
.const [140] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [141] = Utf8 isEvoHighMMIKombi 
.const [142] = Utf8 Z 
.const [143] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [144] = Utf8 url 
.const [145] = Utf8 Ljava/lang/String; 
.const [146] = Utf8 de/audi/atip/log/LogChannel 
.const [147] = Utf8 log 
.const [148] = Utf8 (ILjava/lang/String;JJ)Z 
.const [149] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [150] = Utf8 player 
.const [151] = Utf8 Lde/audi/atip/interapp/media/IMediaFileSessionPlayer; 
.const [152] = Utf8 de/audi/app/car/core/boardbook/BoardbookHandler 
.const [153] = Utf8 setVideoLoading 
.const [154] = Utf8 (Z)V 
.const [155] = Utf8 de/audi/atip/log/LogChannel 
.const [156] = Utf8 log 
.const [157] = Utf8 (ILjava/lang/String;)Z 
.const [158] = Utf8 de/audi/atip/log/LogChannel 
.const [159] = Utf8 log 
.const [160] = Utf8 (ILjava/lang/String;J)Z 
.const [161] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [162] = Utf8 oldstate 
.const [163] = Utf8 I 
.const [164] = Utf8 de/audi/app/car/core/boardbook/BoardbookHandler 
.const [165] = Utf8 triggerScreenChangeToVideo 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/audi/app/car/core/boardbook/BoardbookHandler 
.const [168] = Utf8 returnFromVideoToBoardbook 
.const [169] = Utf8 ()V 
.const [170] = Utf8 de/audi/app/car/core/boardbook/BoardbookHandler 
.const [171] = Utf8 updatePlayPosition 
.const [172] = Utf8 (II)V 
.const [173] = Utf8 de/audi/app/car/core/boardbook/BoardbookHandler 
.const [174] = Utf8 getDisplayContextModel 
.const [175] = Utf8 ()Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [176] = Utf8 java/lang/Object 
.const [177] = Utf8 <init> 
.const [178] = Utf8 ()V 
.const [179] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [180] = Utf8 calcAndSetVideoScaling 
.const [181] = Utf8 (IIII)V 
.const [182] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [183] = Utf8 logChannel 
.const [184] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [185] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [186] = Utf8 handler 
.const [187] = Utf8 Lde/audi/app/car/core/boardbook/BoardbookHandler; 
.const [188] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [189] = Utf8 state 
.const [190] = Utf8 I 
.const [191] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [192] = Utf8 currentScreenRes 
.const [193] = Utf8 I 
.const [194] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [195] = Utf8 isEvoHighMMIKombi 
.const [196] = Utf8 Z 
.const [197] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [198] = Utf8 url 
.const [199] = Utf8 Ljava/lang/String; 
.const [200] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [201] = Utf8 player 
.const [202] = Utf8 Lde/audi/atip/interapp/media/IMediaFileSessionPlayer; 
.const [203] = Utf8 de/audi/atip/interapp/media/IMediaFileSessionPlayer 
.const [204] = Utf8 setVideoScaling 
.const [205] = Utf8 (IIII)V 
.const [206] = Utf8 de/audi/atip/interapp/media/IMediaFileSessionPlayer 
.const [207] = Utf8 play 
.const [208] = Utf8 (Ljava/lang/String;Z)V 
.const [209] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [210] = Utf8 oldstate 
.const [211] = Utf8 I 
.const [212] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [213] = Utf8 setValue 
.const [214] = Utf8 (I)V 
.const [215] = Utf8 de/audi/atip/interapp/media/IMediaFileSessionPlayer 
.const [216] = Utf8 pause 
.const [217] = Utf8 ()V 
.const [218] = Utf8 de/audi/atip/interapp/media/IMediaFileSessionPlayer 
.const [219] = Utf8 resume 
.const [220] = Utf8 ()V 
.const [221] = Utf8 de/audi/app/car/core/boardbook/BoardbookFilePlayerSession 
.const [222] = Class [221] 
.const [223] = Utf8 java/lang/Object 
.const [224] = Class [223] 
.const [225] = Utf8 de/audi/atip/interapp/media/IMediaFilePlayerSession 
.const [226] = Class [225] 
.const [227] = Utf8 RESOLUTION_X_SCREEN_G24 
.const [228] = Utf8 I 
.const [229] = Utf8 RESOLUTION_Y_SCREEN_G24 
.const [230] = Utf8 I 
.const [231] = Utf8 RESOLUTION_X_VIDEO_G24 
.const [232] = Utf8 I 
.const [233] = Utf8 RESOLUTION_Y_VIDEO_G24 
.const [234] = Utf8 I 
.const [235] = Utf8 RESOLUTION_X_SCREEN_G22 
.const [236] = Utf8 I 
.const [237] = Utf8 RESOLUTION_Y_SCREEN_G22 
.const [238] = Utf8 I 
.const [239] = Utf8 RESOLUTION_X_VIDEO_G22 
.const [240] = Utf8 I 
.const [241] = Utf8 RESOLUTION_Y_VIDEO_G22 
.const [242] = Utf8 I 
.const [243] = Utf8 RESOLUTION_X_SCREEN_G21 
.const [244] = Utf8 I 
.const [245] = Utf8 RESOLUTION_Y_SCREEN_G21 
.const [246] = Utf8 I 
.const [247] = Utf8 RESOLUTION_X_VIDEO_G21 
.const [248] = Utf8 I 
.const [249] = Utf8 RESOLUTION_Y_VIDEO_G21 
.const [250] = Utf8 I 
.const [251] = Utf8 currentScreenRes 
.const [252] = Utf8 I 
.const [253] = Utf8 isEvoHighMMIKombi 
.const [254] = Utf8 Z 
.const [255] = Utf8 state 
.const [256] = Utf8 I 
.const [257] = Utf8 oldstate 
.const [258] = Utf8 I 
.const [259] = Utf8 player 
.const [260] = Utf8 Lde/audi/atip/interapp/media/IMediaFileSessionPlayer; 
.const [261] = Utf8 url 
.const [262] = Utf8 Ljava/lang/String; 
.const [263] = Utf8 logChannel 
.const [264] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [265] = Utf8 handler 
.const [266] = Utf8 Lde/audi/app/car/core/boardbook/BoardbookHandler; 
.const [267] = Utf8 Code 
.const [268] = Utf8 <init> 
.const [269] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/car/core/boardbook/BoardbookHandler;IZ)V 
.const [270] = Utf8 getState 
.const [271] = Utf8 ()I 
.const [272] = Utf8 setPlaybackUrl 
.const [273] = Utf8 (Ljava/lang/String;)V 
.const [274] = Utf8 getAudioConnection 
.const [275] = Utf8 ()I 
.const [276] = Utf8 getType 
.const [277] = Utf8 ()I 
.const [278] = Utf8 getName 
.const [279] = Utf8 ()Ljava/lang/String; 
.const [280] = Utf8 calcAndSetVideoScaling 
.const [281] = Utf8 (IIII)V 
.const [282] = Utf8 onActive 
.const [283] = Utf8 (Lde/audi/atip/interapp/media/IMediaSessionPlayer;)V 
.const [284] = Utf8 onSuspend 
.const [285] = Utf8 ()V 
.const [286] = Utf8 onClose 
.const [287] = Utf8 ()V 
.const [288] = Utf8 updateState 
.const [289] = Utf8 (I)V 
.const [290] = Utf8 updatePlayPosition 
.const [291] = Utf8 (II)V 
.const [292] = Utf8 updateVideoContext 
.const [293] = Utf8 (I)V 
.const [294] = Utf8 pause 
.const [295] = Utf8 ()V 
.const [296] = Utf8 resume 
.const [297] = Utf8 ()V 
.end class 
