.version 50 0 
.class public super [226] 
.super [228] 
.implements [230] 
.field private static final [231] [232] 
.field private final [233] [234] 
.field private [235] [236] 
.field private final [237] [238] 
.field private [239] [240] 
.field private [241] [242] 
.field private [243] [244] 

.method public [246] : [247] 
    .attribute [245] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [36] 
L4:     aload_0 
L5:     getstatic [2] 
L8:     putfield [41] 
L11:    aload_0 
L12:    new [42] 
L15:    dup 
L16:    invokespecial [36] 
L19:    putfield [43] 
L22:    aload_0 
L23:    new [44] 
L26:    dup 
L27:    aload_0 
L28:    invokespecial [37] 
L31:    putfield [45] 
L34:    aload_0 
L35:    new [46] 
L38:    dup 
L39:    invokespecial [38] 
L42:    putfield [47] 
L45:    aload_0 
L46:    iconst_m1 
L47:    putfield [48] 
L50:    aload_0 
L51:    aload_1 
L52:    invokevirtual [24] 
L55:    getfield [25] 
L58:    putfield [49] 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [248] : [249] 
    .attribute [245] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L14 using L17 
L7:     aload_0 
L8:     aload_1 
L9:     putfield [45] 
L12:    aload_2 
L13:    monitorexit 
L14:    goto L22 
        .catch [0] from L17 to L20 using L17 
L17:    astore_3 
L18:    aload_2 
L19:    monitorexit 
L20:    aload_3 
L21:    athrow 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [245] .code stack 6 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     dup 
L5:     astore 4 
L7:     monitorenter 
        .catch [0] from L8 to L164 using L167 
L8:     aload_1 
L9:     invokevirtual [27] 
L12:    ifne L44 
L15:    aload_3 
L16:    invokevirtual [27] 
L19:    ifne L44 
L22:    aload_2 
L23:    invokevirtual [27] 
L26:    ifne L44 
L29:    aload_0 
L30:    getfield [23] 
L33:    iconst_m1 
L34:    if_icmpeq L161 
L37:    aload_0 
L38:    invokevirtual [28] 
L41:    goto L161 
L44:    aload_0 
L45:    getfield [23] 
L48:    iconst_m1 
L49:    if_icmpne L87 
L52:    aload_0 
L53:    new [46] 
L56:    dup 
L57:    aload_1 
L58:    aload_2 
L59:    aload_3 
L60:    invokespecial [39] 
L63:    putfield [47] 
L66:    aload_0 
L67:    aload_0 
L68:    getfield [21] 
L71:    aload_0 
L72:    getfield [22] 
L75:    aload_0 
L76:    invokeinterface [50] 0 
L81:    putfield [48] 
L84:    goto L161 
L87:    aload_1 
L88:    aload_0 
L89:    getfield [22] 
L92:    getfield [29] 
L95:    invokevirtual [30] 
L98:    ifeq L129 
L101:   aload_2 
L102:   aload_0 
L103:   getfield [22] 
L106:   getfield [31] 
L109:   invokevirtual [30] 
L112:   ifeq L129 
L115:   aload_3 
L116:   aload_0 
L117:   getfield [22] 
L120:   getfield [32] 
L123:   invokevirtual [30] 
L126:   ifne L161 
L129:   aload_0 
L130:   new [46] 
L133:   dup 
L134:   aload_1 
L135:   aload_2 
L136:   aload_3 
L137:   invokespecial [39] 
L140:   putfield [47] 
L143:   aload_0 
L144:   aload_0 
L145:   getfield [21] 
L148:   aload_0 
L149:   getfield [22] 
L152:   aload_0 
L153:   invokeinterface [50] 0 
L158:   putfield [48] 
L161:   aload 4 
L163:   monitorexit 
L164:   goto L175 
        .catch [0] from L167 to L172 using L167 
L167:   astore 5 
L169:   aload 4 
L171:   monitorexit 
L172:   aload 5 
L174:   athrow 
L175:   return 
L176:   
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [245] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L32 using L35 
L7:     aload_0 
L8:     iconst_m1 
L9:     putfield [48] 
L12:    aload_0 
L13:    new [46] 
L16:    dup 
L17:    invokespecial [38] 
L20:    putfield [47] 
L23:    aload_0 
L24:    getstatic [2] 
L27:    putfield [41] 
L30:    aload_1 
L31:    monitorexit 
L32:    goto L40 
        .catch [0] from L35 to L38 using L35 
L35:    astore_2 
L36:    aload_1 
L37:    monitorexit 
L38:    aload_2 
L39:    athrow 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [245] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     aload_2 
L9:     invokevirtual [33] 
L12:    pop 
L13:    aload_0 
L14:    getfield [20] 
L17:    dup 
L18:    astore_3 
L19:    monitorenter 
        .catch [0] from L20 to L69 using L75 
L20:    iload_1 
L21:    aload_0 
L22:    getfield [23] 
L25:    if_icmpne L70 
L28:    aload_0 
L29:    getfield [19] 
L32:    invokevirtual [34] 
L35:    astore 4 
L37:    aload_2 
L38:    invokevirtual [35] 
L41:    astore 5 
L43:    aload 4 
L45:    aload 5 
L47:    invokestatic [8] 
L50:    ifeq L70 
L53:    aload_0 
L54:    new [51] 
L57:    dup 
L58:    aload 5 
L60:    invokespecial [40] 
L63:    putfield [41] 
L66:    iconst_1 
L67:    aload_3 
L68:    monitorexit 
L69:    areturn 
        .catch [0] from L70 to L72 using L75 
L70:    aload_3 
L71:    monitorexit 
L72:    goto L82 
        .catch [0] from L75 to L79 using L75 
L75:    astore 6 
L77:    aload_3 
L78:    monitorexit 
L79:    aload 6 
L81:    athrow 
L82:    iconst_0 
L83:    areturn 
L84:    
    .end code 
.end method 

.method private static [256] : [257] 
    .attribute [245] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L9 
L4:     ldc [10] 
L6:     goto L10 
L9:     aload_0 
L10:    astore_0 
L11:    aload_1 
L12:    ifnonnull L20 
L15:    ldc [10] 
L17:    goto L21 
L20:    aload_1 
L21:    astore_1 
L22:    aload_1 
L23:    aload_0 
L24:    invokevirtual [30] 
L27:    ifne L34 
L30:    iconst_1 
L31:    goto L35 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [258] : [259] 
    .attribute [245] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L13 using L14 
L7:     aload_0 
L8:     getfield [19] 
L11:    aload_1 
L12:    monitorexit 
L13:    areturn 
        .catch [0] from L14 to L17 using L14 
L14:    astore_2 
L15:    aload_1 
L16:    monitorexit 
L17:    aload_2 
L18:    athrow 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [52] [53] 
.const [3] = Class [54] 
.const [4] = Class [55] 
.const [5] = Class [56] 
.const [6] = Int -2137614336 
.const [7] = String [57] 
.const [8] = Method [58] [59] 
.const [9] = Class [60] 
.const [10] = String [61] 
.const [11] = Class [62] 
.const [12] = Class [63] 
.const [13] = Class [64] 
.const [14] = Class [65] 
.const [15] = Class [66] 
.const [16] = Class [67] 
.const [17] = Class [68] 
.const [18] = Class [69] 
.const [19] = Field [70] [71] 
.const [20] = Field [72] [73] 
.const [21] = Field [74] [75] 
.const [22] = Field [76] [77] 
.const [23] = Field [78] [79] 
.const [24] = Method [80] [81] 
.const [25] = Field [82] [83] 
.const [26] = Field [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Method [88] [89] 
.const [29] = Field [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Field [94] [95] 
.const [32] = Field [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Field [114] [115] 
.const [42] = Class [116] 
.const [43] = Field [117] [118] 
.const [44] = Class [119] 
.const [45] = Field [120] [121] 
.const [46] = Class [122] 
.const [47] = Field [123] [124] 
.const [48] = Field [125] [126] 
.const [49] = Field [127] [128] 
.const [50] = InterfaceMethod [129] [130] 
.const [51] = Class [131] 
.const [52] = Class [132] 
.const [53] = NameAndType [133] [134] 
.const [54] = Utf8 java/lang/Object 
.const [55] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler$1 
.const [56] = Utf8 org/dsi/ifc/media/CoverartInfo 
.const [57] = Utf8 '[CoverArtManager.setCoverArt] %1' 
.const [58] = Class [135] 
.const [59] = NameAndType [136] [137] 
.const [60] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [61] = Utf8 '' 
.const [62] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [63] = Utf8 de/audi/tuner/ifc/ISimpleTuner 
.const [64] = Utf8 de/audi/tuner/app/TunerBasics 
.const [65] = Utf8 de/audi/tuner/app/Logger 
.const [66] = Utf8 java/lang/String 
.const [67] = Utf8 de/audi/tuner/app/gracenote/IGracenoteRequest 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [70] = Class [138] 
.const [71] = NameAndType [139] [140] 
.const [72] = Class [141] 
.const [73] = NameAndType [142] [143] 
.const [74] = Class [144] 
.const [75] = NameAndType [145] [146] 
.const [76] = Class [147] 
.const [77] = NameAndType [148] [149] 
.const [78] = Class [150] 
.const [79] = NameAndType [151] [152] 
.const [80] = Class [153] 
.const [81] = NameAndType [154] [155] 
.const [82] = Class [156] 
.const [83] = NameAndType [157] [158] 
.const [84] = Class [159] 
.const [85] = NameAndType [160] [161] 
.const [86] = Class [162] 
.const [87] = NameAndType [163] [164] 
.const [88] = Class [165] 
.const [89] = NameAndType [166] [167] 
.const [90] = Class [168] 
.const [91] = NameAndType [169] [170] 
.const [92] = Class [171] 
.const [93] = NameAndType [172] [173] 
.const [94] = Class [174] 
.const [95] = NameAndType [175] [176] 
.const [96] = Class [177] 
.const [97] = NameAndType [178] [179] 
.const [98] = Class [180] 
.const [99] = NameAndType [181] [182] 
.const [100] = Class [183] 
.const [101] = NameAndType [184] [185] 
.const [102] = Class [186] 
.const [103] = NameAndType [187] [188] 
.const [104] = Class [189] 
.const [105] = NameAndType [190] [191] 
.const [106] = Class [192] 
.const [107] = NameAndType [193] [194] 
.const [108] = Class [195] 
.const [109] = NameAndType [196] [197] 
.const [110] = Class [198] 
.const [111] = NameAndType [199] [200] 
.const [112] = Class [201] 
.const [113] = NameAndType [202] [203] 
.const [114] = Class [204] 
.const [115] = NameAndType [205] [206] 
.const [116] = Utf8 java/lang/Object 
.const [117] = Class [207] 
.const [118] = NameAndType [208] [209] 
.const [119] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler$1 
.const [120] = Class [210] 
.const [121] = NameAndType [211] [212] 
.const [122] = Utf8 org/dsi/ifc/media/CoverartInfo 
.const [123] = Class [213] 
.const [124] = NameAndType [214] [215] 
.const [125] = Class [216] 
.const [126] = NameAndType [217] [218] 
.const [127] = Class [219] 
.const [128] = NameAndType [220] [221] 
.const [129] = Class [222] 
.const [130] = NameAndType [223] [224] 
.const [131] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [132] = Utf8 de/audi/tuner/ifc/ISimpleTuner 
.const [133] = Utf8 EMPTY_RL 
.const [134] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [135] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [136] = Utf8 isUriNew 
.const [137] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Z 
.const [138] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [139] = Utf8 coverArt 
.const [140] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [141] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [142] = Utf8 mutex 
.const [143] = Utf8 Ljava/lang/Object; 
.const [144] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [145] = Utf8 gracenote 
.const [146] = Utf8 Lde/audi/tuner/app/gracenote/IGracenoteRequest; 
.const [147] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [148] = Utf8 gracenoteRequest 
.const [149] = Utf8 Lorg/dsi/ifc/media/CoverartInfo; 
.const [150] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [151] = Utf8 requestId 
.const [152] = Utf8 I 
.const [153] = Utf8 de/audi/tuner/app/TunerBasics 
.const [154] = Utf8 getLogger 
.const [155] = Utf8 ()Lde/audi/tuner/app/Logger; 
.const [156] = Utf8 de/audi/tuner/app/Logger 
.const [157] = Utf8 gracenote 
.const [158] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [159] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [160] = Utf8 log 
.const [161] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [162] = Utf8 java/lang/String 
.const [163] = Utf8 length 
.const [164] = Utf8 ()I 
.const [165] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [166] = Utf8 clear 
.const [167] = Utf8 ()V 
.const [168] = Utf8 org/dsi/ifc/media/CoverartInfo 
.const [169] = Utf8 artist 
.const [170] = Utf8 Ljava/lang/String; 
.const [171] = Utf8 java/lang/String 
.const [172] = Utf8 equals 
.const [173] = Utf8 (Ljava/lang/Object;)Z 
.const [174] = Utf8 org/dsi/ifc/media/CoverartInfo 
.const [175] = Utf8 album 
.const [176] = Utf8 Ljava/lang/String; 
.const [177] = Utf8 org/dsi/ifc/media/CoverartInfo 
.const [178] = Utf8 title 
.const [179] = Utf8 Ljava/lang/String; 
.const [180] = Utf8 de/audi/atip/log/LogChannel 
.const [181] = Utf8 log 
.const [182] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [183] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [184] = Utf8 getResourceURI 
.const [185] = Utf8 ()Ljava/lang/String; 
.const [186] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [187] = Utf8 getUrl 
.const [188] = Utf8 ()Ljava/lang/String; 
.const [189] = Utf8 java/lang/Object 
.const [190] = Utf8 <init> 
.const [191] = Utf8 ()V 
.const [192] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler$1 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lde/audi/tuner/app/gracenote/CoverArtHandler;)V 
.const [195] = Utf8 org/dsi/ifc/media/CoverartInfo 
.const [196] = Utf8 <init> 
.const [197] = Utf8 ()V 
.const [198] = Utf8 org/dsi/ifc/media/CoverartInfo 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [201] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [202] = Utf8 <init> 
.const [203] = Utf8 (Ljava/lang/String;)V 
.const [204] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [205] = Utf8 coverArt 
.const [206] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [207] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [208] = Utf8 mutex 
.const [209] = Utf8 Ljava/lang/Object; 
.const [210] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [211] = Utf8 gracenote 
.const [212] = Utf8 Lde/audi/tuner/app/gracenote/IGracenoteRequest; 
.const [213] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [214] = Utf8 gracenoteRequest 
.const [215] = Utf8 Lorg/dsi/ifc/media/CoverartInfo; 
.const [216] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [217] = Utf8 requestId 
.const [218] = Utf8 I 
.const [219] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [220] = Utf8 log 
.const [221] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [222] = Utf8 de/audi/tuner/app/gracenote/IGracenoteRequest 
.const [223] = Utf8 gracenoteRequest 
.const [224] = Utf8 (Lorg/dsi/ifc/media/CoverartInfo;Lde/audi/tuner/app/gracenote/IGracenoteResponse;)I 
.const [225] = Utf8 de/audi/tuner/app/gracenote/CoverArtHandler 
.const [226] = Class [225] 
.const [227] = Utf8 java/lang/Object 
.const [228] = Class [227] 
.const [229] = Utf8 de/audi/tuner/app/gracenote/IGracenoteResponse 
.const [230] = Class [229] 
.const [231] = Utf8 NO_JOB 
.const [232] = Utf8 I 
.const [233] = Utf8 log 
.const [234] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [235] = Utf8 coverArt 
.const [236] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [237] = Utf8 mutex 
.const [238] = Utf8 Ljava/lang/Object; 
.const [239] = Utf8 gracenote 
.const [240] = Utf8 Lde/audi/tuner/app/gracenote/IGracenoteRequest; 
.const [241] = Utf8 gracenoteRequest 
.const [242] = Utf8 Lorg/dsi/ifc/media/CoverartInfo; 
.const [243] = Utf8 requestId 
.const [244] = Utf8 I 
.const [245] = Utf8 Code 
.const [246] = Utf8 <init> 
.const [247] = Utf8 (Lde/audi/tuner/app/TunerBasics;)V 
.const [248] = Utf8 register 
.const [249] = Utf8 (Lde/audi/tuner/app/gracenote/IGracenoteRequest;)V 
.const [250] = Utf8 requestCoverArt 
.const [251] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [252] = Utf8 clear 
.const [253] = Utf8 ()V 
.const [254] = Utf8 setCoverArt 
.const [255] = Utf8 (ILorg/dsi/ifc/global/ResourceLocator;)Z 
.const [256] = Utf8 isUriNew 
.const [257] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Z 
.const [258] = Utf8 getCoverArt 
.const [259] = Utf8 ()Lde/audi/atip/hmi/model/HMIResourceLocator; 
.end class 
