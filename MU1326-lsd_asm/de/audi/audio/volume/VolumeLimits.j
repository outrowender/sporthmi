.version 50 0 
.class public super [213] 
.super [215] 
.field private static final [216] [217] 
.field private static final [218] [219] 
.field public final [220] [221] 
.field public final [222] [223] 
.field private final [224] [225] 
.field private final [226] [227] 
.field private final [228] [229] 
.field private volatile [230] [231] 
.field private volatile [232] [233] 
.field private volatile [234] [235] 
.field private [236] [237] 

.method public [239] : [240] 
    .attribute [238] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     new [41] 
L8:     dup 
L9:     aload_0 
L10:    aconst_null 
L11:    invokespecial [31] 
L14:    putfield [42] 
L17:    aload_0 
L18:    new [43] 
L21:    dup 
L22:    aload_0 
L23:    aconst_null 
L24:    invokespecial [32] 
L27:    putfield [44] 
L30:    aload_0 
L31:    new [45] 
L34:    dup 
L35:    invokespecial [30] 
L38:    putfield [40] 
L41:    aload_0 
L42:    iconst_0 
L43:    putfield [37] 
L46:    aload_0 
L47:    bipush 40 
L49:    putfield [36] 
L52:    aload_0 
L53:    iconst_0 
L54:    putfield [39] 
L57:    aload_0 
L58:    iconst_1 
L59:    putfield [46] 
L62:    aload_0 
L63:    aload_1 
L64:    getfield [22] 
L67:    putfield [38] 
L70:    aload_0 
L71:    aload_2 
L72:    putfield [47] 
L75:    return 
L76:    
    .end code 
.end method 

.method private [241] : [242] 
    .attribute [238] .code stack 3 locals 3 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [19] 
L5:     invokespecial [33] 
L8:     ifeq L36 
L11:    new [48] 
L14:    dup 
L15:    invokespecial [34] 
L18:    ldc [6] 
L20:    invokevirtual [24] 
L23:    aload_0 
L24:    getfield [19] 
L27:    invokevirtual [25] 
L30:    ldc [7] 
L32:    invokevirtual [24] 
L35:    areturn 
L36:    aload_0 
L37:    aload_0 
L38:    getfield [19] 
L41:    invokespecial [35] 
L44:    istore_3 
L45:    iload_3 
L46:    ifeq L69 
L49:    iconst_0 
L50:    istore_1 
L51:    aload_0 
L52:    getfield [21] 
L55:    ifeq L63 
L58:    bipush 30 
L60:    goto L65 
L63:    bipush 40 
L65:    istore_2 
L66:    goto L79 
L69:    aload_0 
L70:    getfield [17] 
L73:    istore_1 
L74:    aload_0 
L75:    getfield [16] 
L78:    istore_2 
L79:    aload_0 
L80:    getfield [23] 
L83:    iconst_0 
L84:    invokevirtual [26] 
L87:    iload_1 
L88:    iload_2 
L89:    invokevirtual [27] 
L92:    aload_0 
L93:    getfield [23] 
L96:    iconst_3 
L97:    invokevirtual [26] 
L100:   iload_1 
L101:   iload_2 
L102:   invokevirtual [27] 
L105:   aload_0 
L106:   getfield [23] 
L109:   iconst_4 
L110:   invokevirtual [26] 
L113:   iload_1 
L114:   iload_2 
L115:   invokevirtual [27] 
L118:   new [48] 
L121:   dup 
L122:   invokespecial [34] 
L125:   ldc [8] 
L127:   invokevirtual [24] 
L130:   iload_1 
L131:   invokevirtual [25] 
L134:   ldc [9] 
L136:   invokevirtual [24] 
L139:   iload_2 
L140:   invokevirtual [25] 
L143:   ldc [10] 
L145:   invokevirtual [24] 
L148:   aload_0 
L149:   getfield [19] 
L152:   invokevirtual [25] 
L155:   ldc [11] 
L157:   invokevirtual [24] 
L160:   iload_3 
L161:   invokevirtual [28] 
L164:   areturn 
L165:   nop 
L166:   nop 
L167:   nop 
L168:   
    .end code 
.end method 

.method private [243] : [244] 
    .attribute [238] .code stack 1 locals 0 
L0:     iload_1 
L1:     tableswitch 83 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L218 
            L216 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L218 
            L216 
            default : L218 

L216:   iconst_1 
L217:   areturn 
L218:   iconst_0 
L219:   areturn 
L220:   
    .end code 
.end method 

.method private [245] : [246] 
    .attribute [238] .code stack 1 locals 0 
L0:     iload_1 
L1:     tableswitch 95 
            L156 
            L158 
            L158 
            L156 
            L156 
            L158 
            L158 
            L158 
            L156 
            L156 
            L158 
            L158 
            L158 
            L158 
            L158 
            L158 
            L158 
            L156 
            L158 
            L156 
            L156 
            L156 
            L156 
            L156 
            L156 
            L158 
            L158 
            L158 
            L158 
            L156 
            L158 
            L158 
            L158 
            L158 
            L156 
            default : L158 

L156:   iconst_1 
L157:   areturn 
L158:   iconst_0 
L159:   areturn 
L160:   
    .end code 
.end method 

.method static synthetic [247] : [248] 
    .attribute [238] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [249] : [250] 
    .attribute [238] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [39] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [251] : [252] 
    .attribute [238] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [253] : [254] 
    .attribute [238] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [255] : [256] 
    .attribute [238] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [37] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [257] : [258] 
    .attribute [238] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [36] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [49] 
.const [3] = Class [50] 
.const [4] = Class [51] 
.const [5] = Class [52] 
.const [6] = String [53] 
.const [7] = String [54] 
.const [8] = String [55] 
.const [9] = String [56] 
.const [10] = String [57] 
.const [11] = String [58] 
.const [12] = Class [59] 
.const [13] = Class [60] 
.const [14] = Class [61] 
.const [15] = Class [62] 
.const [16] = Field [63] [64] 
.const [17] = Field [65] [66] 
.const [18] = Field [67] [68] 
.const [19] = Field [69] [70] 
.const [20] = Field [71] [72] 
.const [21] = Field [73] [74] 
.const [22] = Field [75] [76] 
.const [23] = Field [77] [78] 
.const [24] = Method [79] [80] 
.const [25] = Method [81] [82] 
.const [26] = Method [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Method [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Method [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Field [103] [104] 
.const [37] = Field [105] [106] 
.const [38] = Field [107] [108] 
.const [39] = Field [109] [110] 
.const [40] = Field [111] [112] 
.const [41] = Class [113] 
.const [42] = Field [114] [115] 
.const [43] = Class [116] 
.const [44] = Field [117] [118] 
.const [45] = Class [119] 
.const [46] = Field [120] [121] 
.const [47] = Field [122] [123] 
.const [48] = Class [124] 
.const [49] = Utf8 de/audi/audio/volume/VolumeLimits$Audiolistener 
.const [50] = Utf8 de/audi/audio/volume/VolumeLimits$SoundListener 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [53] = Utf8 'Active connection ' 
.const [54] = Utf8 " is a volume menu connection -> don't change min/max!" 
.const [55] = Utf8 'min:' 
.const [56] = Utf8 ' max:' 
.const [57] = Utf8 ' AAC:' 
.const [58] = Utf8 ' special:' 
.const [59] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [60] = Utf8 de/audi/audio/volume/OnOffVolumeRange$Controller 
.const [61] = Utf8 de/audi/audio/AudioEnv 
.const [62] = Utf8 de/audi/audio/volume/OnOffVolumeRange 
.const [63] = Class [125] 
.const [64] = NameAndType [126] [127] 
.const [65] = Class [128] 
.const [66] = NameAndType [129] [130] 
.const [67] = Class [131] 
.const [68] = NameAndType [132] [133] 
.const [69] = Class [134] 
.const [70] = NameAndType [135] [136] 
.const [71] = Class [137] 
.const [72] = NameAndType [138] [139] 
.const [73] = Class [140] 
.const [74] = NameAndType [141] [142] 
.const [75] = Class [143] 
.const [76] = NameAndType [144] [145] 
.const [77] = Class [146] 
.const [78] = NameAndType [147] [148] 
.const [79] = Class [149] 
.const [80] = NameAndType [150] [151] 
.const [81] = Class [152] 
.const [82] = NameAndType [153] [154] 
.const [83] = Class [155] 
.const [84] = NameAndType [156] [157] 
.const [85] = Class [158] 
.const [86] = NameAndType [159] [160] 
.const [87] = Class [161] 
.const [88] = NameAndType [162] [163] 
.const [89] = Class [164] 
.const [90] = NameAndType [165] [166] 
.const [91] = Class [167] 
.const [92] = NameAndType [168] [169] 
.const [93] = Class [170] 
.const [94] = NameAndType [171] [172] 
.const [95] = Class [173] 
.const [96] = NameAndType [174] [175] 
.const [97] = Class [176] 
.const [98] = NameAndType [177] [178] 
.const [99] = Class [179] 
.const [100] = NameAndType [180] [181] 
.const [101] = Class [182] 
.const [102] = NameAndType [183] [184] 
.const [103] = Class [185] 
.const [104] = NameAndType [186] [187] 
.const [105] = Class [188] 
.const [106] = NameAndType [189] [190] 
.const [107] = Class [191] 
.const [108] = NameAndType [192] [193] 
.const [109] = Class [194] 
.const [110] = NameAndType [195] [196] 
.const [111] = Class [197] 
.const [112] = NameAndType [198] [199] 
.const [113] = Utf8 de/audi/audio/volume/VolumeLimits$Audiolistener 
.const [114] = Class [200] 
.const [115] = NameAndType [201] [202] 
.const [116] = Utf8 de/audi/audio/volume/VolumeLimits$SoundListener 
.const [117] = Class [203] 
.const [118] = NameAndType [204] [205] 
.const [119] = Utf8 java/lang/Object 
.const [120] = Class [206] 
.const [121] = NameAndType [207] [208] 
.const [122] = Class [209] 
.const [123] = NameAndType [210] [211] 
.const [124] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [125] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [126] = Utf8 origMax 
.const [127] = Utf8 I 
.const [128] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [129] = Utf8 origMin 
.const [130] = Utf8 I 
.const [131] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [132] = Utf8 lc 
.const [133] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [134] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [135] = Utf8 activeConnection 
.const [136] = Utf8 I 
.const [137] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [138] = Utf8 mutex 
.const [139] = Utf8 Ljava/lang/Object; 
.const [140] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [141] = Utf8 internalAmplifier 
.const [142] = Utf8 Z 
.const [143] = Utf8 de/audi/audio/AudioEnv 
.const [144] = Utf8 lcVol 
.const [145] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [146] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [147] = Utf8 controller 
.const [148] = Utf8 Lde/audi/audio/volume/OnOffVolumeRange$Controller; 
.const [149] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [150] = Utf8 append 
.const [151] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [152] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [153] = Utf8 append 
.const [154] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [155] = Utf8 de/audi/audio/volume/OnOffVolumeRange$Controller 
.const [156] = Utf8 getRange 
.const [157] = Utf8 (I)Lde/audi/audio/volume/OnOffVolumeRange; 
.const [158] = Utf8 de/audi/audio/volume/OnOffVolumeRange 
.const [159] = Utf8 updateLimits 
.const [160] = Utf8 (II)V 
.const [161] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [162] = Utf8 append 
.const [163] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [164] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [165] = Utf8 updateLimits 
.const [166] = Utf8 ()Lde/esolutions/fw/util/commons/Buffer; 
.const [167] = Utf8 java/lang/Object 
.const [168] = Utf8 <init> 
.const [169] = Utf8 ()V 
.const [170] = Utf8 de/audi/audio/volume/VolumeLimits$Audiolistener 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lde/audi/audio/volume/VolumeLimits;Lde/audi/audio/volume/VolumeLimits$1;)V 
.const [173] = Utf8 de/audi/audio/volume/VolumeLimits$SoundListener 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Lde/audi/audio/volume/VolumeLimits;Lde/audi/audio/volume/VolumeLimits$1;)V 
.const [176] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [177] = Utf8 isVolMenuConnection 
.const [178] = Utf8 (I)Z 
.const [179] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [180] = Utf8 <init> 
.const [181] = Utf8 ()V 
.const [182] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [183] = Utf8 isSpecialConnection 
.const [184] = Utf8 (I)Z 
.const [185] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [186] = Utf8 origMax 
.const [187] = Utf8 I 
.const [188] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [189] = Utf8 origMin 
.const [190] = Utf8 I 
.const [191] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [192] = Utf8 lc 
.const [193] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [194] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [195] = Utf8 activeConnection 
.const [196] = Utf8 I 
.const [197] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [198] = Utf8 mutex 
.const [199] = Utf8 Ljava/lang/Object; 
.const [200] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [201] = Utf8 audioListener 
.const [202] = Utf8 Lde/audi/audio/intra/IAudioListener; 
.const [203] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [204] = Utf8 soundListener 
.const [205] = Utf8 Lde/audi/audio/intra/ISoundListener; 
.const [206] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [207] = Utf8 internalAmplifier 
.const [208] = Utf8 Z 
.const [209] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [210] = Utf8 controller 
.const [211] = Utf8 Lde/audi/audio/volume/OnOffVolumeRange$Controller; 
.const [212] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [213] = Class [212] 
.const [214] = Utf8 java/lang/Object 
.const [215] = Class [214] 
.const [216] = Utf8 INT_AMP_MAX 
.const [217] = Utf8 I 
.const [218] = Utf8 EXT_AMP_MAX 
.const [219] = Utf8 I 
.const [220] = Utf8 audioListener 
.const [221] = Utf8 Lde/audi/audio/intra/IAudioListener; 
.const [222] = Utf8 soundListener 
.const [223] = Utf8 Lde/audi/audio/intra/ISoundListener; 
.const [224] = Utf8 mutex 
.const [225] = Utf8 Ljava/lang/Object; 
.const [226] = Utf8 controller 
.const [227] = Utf8 Lde/audi/audio/volume/OnOffVolumeRange$Controller; 
.const [228] = Utf8 lc 
.const [229] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [230] = Utf8 origMin 
.const [231] = Utf8 I 
.const [232] = Utf8 origMax 
.const [233] = Utf8 I 
.const [234] = Utf8 activeConnection 
.const [235] = Utf8 I 
.const [236] = Utf8 internalAmplifier 
.const [237] = Utf8 Z 
.const [238] = Utf8 Code 
.const [239] = Utf8 <init> 
.const [240] = Utf8 (Lde/audi/audio/AudioEnv;Lde/audi/audio/volume/OnOffVolumeRange$Controller;)V 
.const [241] = Utf8 updateLimits 
.const [242] = Utf8 ()Lde/esolutions/fw/util/commons/Buffer; 
.const [243] = Utf8 isVolMenuConnection 
.const [244] = Utf8 (I)Z 
.const [245] = Utf8 isSpecialConnection 
.const [246] = Utf8 (I)Z 
.const [247] = Utf8 access$200 
.const [248] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)Ljava/lang/Object; 
.const [249] = Utf8 access$302 
.const [250] = Utf8 (Lde/audi/audio/volume/VolumeLimits;I)I 
.const [251] = Utf8 access$400 
.const [252] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)Lde/esolutions/fw/util/commons/Buffer; 
.const [253] = Utf8 access$500 
.const [254] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)Lde/audi/atip/log/LogChannel; 
.const [255] = Utf8 access$602 
.const [256] = Utf8 (Lde/audi/audio/volume/VolumeLimits;I)I 
.const [257] = Utf8 access$702 
.const [258] = Utf8 (Lde/audi/audio/volume/VolumeLimits;I)I 
.end class 
