.version 50 0 
.class public super [198] 
.super [200] 
.field public static final [201] [202] 
.field public static final [203] [204] 
.field private [205] [206] 
.field private [207] [208] 
.field private [209] [210] 

.method public annotation [212] : [213] 
    .attribute [211] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [214] : [215] 
    .attribute [211] .code stack 4 locals 8 
L0:     ldc [2] 
L2:     fstore_3 
L3:     iconst_m1 
L4:     istore 4 
L6:     iconst_0 
L7:     istore 5 
L9:     new [36] 
L12:    dup 
L13:    fconst_0 
L14:    iconst_1 
L15:    invokespecial [27] 
L18:    astore 6 
L20:    aload 6 
L22:    aload_0 
L23:    iload_1 
L24:    aload_2 
L25:    invokespecial [28] 
L28:    invokevirtual [16] 
L31:    aload 6 
L33:    iconst_4 
L34:    invokevirtual [17] 
L37:    pop 
L38:    aload 6 
L40:    invokevirtual [18] 
L43:    fstore_3 
L44:    aload 6 
L46:    invokevirtual [19] 
L49:    istore 4 
L51:    aload 6 
L53:    invokevirtual [20] 
L56:    istore 5 
L58:    ldc [4] 
L60:    istore 7 
L62:    aload_0 
L63:    iload 4 
L65:    fload_3 
L66:    invokespecial [29] 
L69:    istore 8 
L71:    iload_1 
L72:    aload_2 
L73:    arraylength 
L74:    iconst_1 
L75:    isub 
L76:    if_icmpne L83 
L79:    iconst_1 
L80:    goto L84 
L83:    iconst_0 
L84:    istore 9 
L86:    iload 9 
L88:    ifeq L130 
L91:    aload_0 
L92:    fload_3 
L93:    ldc [5] 
L95:    fmul 
L96:    invokestatic [6] 
L99:    invokespecial [30] 
L102:   aload_0 
L103:   iload 8 
L105:   invokespecial [31] 
L108:   aload_0 
L109:   getfield [21] 
L112:   iload_1 
L113:   if_icmpne L121 
L116:   ldc [7] 
L118:   goto L125 
L121:   aload_0 
L122:   invokevirtual [22] 
L125:   istore 7 
L127:   goto L139 
L130:   fload_3 
L131:   ldc [5] 
L133:   fmul 
L134:   invokestatic [6] 
L137:   istore 7 
L139:   iload 7 
L141:   ldc [7] 
L143:   if_icmpeq L171 
L146:   aload_0 
L147:   aload 6 
L149:   iconst_2 
L150:   invokevirtual [23] 
L153:   invokespecial [32] 
L156:   ifeq L171 
L159:   fload_3 
L160:   ldc [8] 
L162:   fmul 
L163:   invokestatic [6] 
L166:   istore 7 
L168:   iconst_5 
L169:   istore 8 
L171:   aload_0 
L172:   iload_1 
L173:   putfield [37] 
L176:   new [38] 
L179:   dup 
L180:   invokespecial [33] 
L183:   astore 10 
L185:   aload 10 
L187:   iload 7 
L189:   putfield [39] 
L192:   aload 10 
L194:   iload 8 
L196:   putfield [40] 
L199:   aload 10 
L201:   iload 5 
L203:   putfield [41] 
L206:   aload 10 
L208:   iload 9 
L210:   putfield [42] 
L213:   aload 10 
L215:   areturn 
L216:   
    .end code 
.end method 

.method public interface [216] : [217] 
    .attribute [211] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [218] : [219] 
    .attribute [211] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [43] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [220] : [221] 
    .attribute [211] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [222] : [223] 
    .attribute [211] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [44] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [224] : [225] 
    .attribute [211] .code stack 2 locals 1 
L0:     aload_2 
L1:     ifnull L9 
L4:     aload_2 
L5:     arraylength 
L6:     ifne L11 
L9:     fconst_0 
L10:    areturn 
L11:    iload_1 
L12:    ifge L19 
L15:    iconst_0 
L16:    goto L33 
L19:    iload_1 
L20:    aload_2 
L21:    arraylength 
L22:    if_icmplt L32 
L25:    aload_2 
L26:    arraylength 
L27:    iconst_1 
L28:    isub 
L29:    goto L33 
L32:    iload_1 
L33:    istore_3 
L34:    aload_2 
L35:    iload_3 
L36:    faload 
L37:    ldc [10] 
L39:    fdiv 
L40:    areturn 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [226] : [227] 
    .attribute [211] .code stack 2 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L40 
            L46 
            L48 
            L50 
            L52 
            L54 
            default : L56 

L40:    aload_0 
L41:    fload_2 
L42:    invokespecial [34] 
L45:    areturn 
L46:    iconst_4 
L47:    areturn 
L48:    iconst_4 
L49:    areturn 
L50:    iconst_3 
L51:    areturn 
L52:    iconst_2 
L53:    areturn 
L54:    iconst_0 
L55:    areturn 
L56:    iconst_0 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [228] : [229] 
    .attribute [211] .code stack 2 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     invokespecial [35] 
L5:     ifeq L13 
L8:     bipush 6 
L10:    goto L14 
L13:    iconst_1 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [230] : [231] 
    .attribute [211] .code stack 2 locals 0 
L0:     fload_1 
L1:     fconst_1 
L2:     frem 
L3:     fconst_0 
L4:     fcmpl 
L5:     ifeq L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [232] : [233] 
    .attribute [211] .code stack 2 locals 0 
L0:     invokestatic [11] 
L3:     iconst_2 
L4:     if_icmpne L25 
L7:     fload_1 
L8:     ldc [5] 
L10:    fcmpg 
L11:    ifgt L25 
L14:    fload_1 
L15:    ldc [12] 
L17:    fcmpl 
L18:    iflt L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 32959 
.const [3] = Class [45] 
.const [4] = Int -65536 
.const [5] = Int 8257 
.const [6] = Method [46] [47] 
.const [7] = Int -16842752 
.const [8] = Int 8258 
.const [9] = Class [48] 
.const [10] = Int 5292871 
.const [11] = Method [49] [50] 
.const [12] = Int -604406210 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Class [53] 
.const [16] = Method [54] [55] 
.const [17] = Method [56] [57] 
.const [18] = Method [58] [59] 
.const [19] = Method [60] [61] 
.const [20] = Method [62] [63] 
.const [21] = Field [64] [65] 
.const [22] = Method [66] [67] 
.const [23] = Method [68] [69] 
.const [24] = Field [70] [71] 
.const [25] = Field [72] [73] 
.const [26] = Method [74] [75] 
.const [27] = Method [76] [77] 
.const [28] = Method [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Method [90] [91] 
.const [35] = Method [92] [93] 
.const [36] = Class [94] 
.const [37] = Field [95] [96] 
.const [38] = Class [97] 
.const [39] = Field [98] [99] 
.const [40] = Field [100] [101] 
.const [41] = Field [102] [103] 
.const [42] = Field [104] [105] 
.const [43] = Field [106] [107] 
.const [44] = Field [108] [109] 
.const [45] = Utf8 de/audi/atip/metrics/Distance 
.const [46] = Class [110] 
.const [47] = NameAndType [111] [112] 
.const [48] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [49] = Class [113] 
.const [50] = NameAndType [114] [115] 
.const [51] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 java/lang/Math 
.const [54] = Class [116] 
.const [55] = NameAndType [117] [118] 
.const [56] = Class [119] 
.const [57] = NameAndType [120] [121] 
.const [58] = Class [122] 
.const [59] = NameAndType [123] [124] 
.const [60] = Class [125] 
.const [61] = NameAndType [126] [127] 
.const [62] = Class [128] 
.const [63] = NameAndType [129] [130] 
.const [64] = Class [131] 
.const [65] = NameAndType [132] [133] 
.const [66] = Class [134] 
.const [67] = NameAndType [135] [136] 
.const [68] = Class [137] 
.const [69] = NameAndType [138] [139] 
.const [70] = Class [140] 
.const [71] = NameAndType [141] [142] 
.const [72] = Class [143] 
.const [73] = NameAndType [144] [145] 
.const [74] = Class [146] 
.const [75] = NameAndType [147] [148] 
.const [76] = Class [149] 
.const [77] = NameAndType [150] [151] 
.const [78] = Class [152] 
.const [79] = NameAndType [153] [154] 
.const [80] = Class [155] 
.const [81] = NameAndType [156] [157] 
.const [82] = Class [158] 
.const [83] = NameAndType [159] [160] 
.const [84] = Class [161] 
.const [85] = NameAndType [162] [163] 
.const [86] = Class [164] 
.const [87] = NameAndType [165] [166] 
.const [88] = Class [167] 
.const [89] = NameAndType [168] [169] 
.const [90] = Class [170] 
.const [91] = NameAndType [171] [172] 
.const [92] = Class [173] 
.const [93] = NameAndType [174] [175] 
.const [94] = Utf8 de/audi/atip/metrics/Distance 
.const [95] = Class [176] 
.const [96] = NameAndType [177] [178] 
.const [97] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [98] = Class [179] 
.const [99] = NameAndType [180] [181] 
.const [100] = Class [182] 
.const [101] = NameAndType [183] [184] 
.const [102] = Class [185] 
.const [103] = NameAndType [186] [187] 
.const [104] = Class [188] 
.const [105] = NameAndType [189] [190] 
.const [106] = Class [191] 
.const [107] = NameAndType [192] [193] 
.const [108] = Class [194] 
.const [109] = NameAndType [195] [196] 
.const [110] = Utf8 java/lang/Math 
.const [111] = Utf8 round 
.const [112] = Utf8 (F)I 
.const [113] = Utf8 de/audi/atip/metrics/Distance 
.const [114] = Utf8 getSystemUnit 
.const [115] = Utf8 ()I 
.const [116] = Utf8 de/audi/atip/metrics/Distance 
.const [117] = Utf8 setValue 
.const [118] = Utf8 (F)V 
.const [119] = Utf8 de/audi/atip/metrics/Distance 
.const [120] = Utf8 formatByMode 
.const [121] = Utf8 (I)Ljava/lang/String; 
.const [122] = Utf8 de/audi/atip/metrics/Distance 
.const [123] = Utf8 getFormattedDistance 
.const [124] = Utf8 ()F 
.const [125] = Utf8 de/audi/atip/metrics/Distance 
.const [126] = Utf8 getFormattedUnit 
.const [127] = Utf8 ()I 
.const [128] = Utf8 de/audi/atip/metrics/Distance 
.const [129] = Utf8 isFormattedDistanceValid 
.const [130] = Utf8 ()Z 
.const [131] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [132] = Utf8 lastZoomIndex 
.const [133] = Utf8 I 
.const [134] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [135] = Utf8 getMaximumScaleValue 
.const [136] = Utf8 ()I 
.const [137] = Utf8 de/audi/atip/metrics/Distance 
.const [138] = Utf8 getValue 
.const [139] = Utf8 (I)F 
.const [140] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [141] = Utf8 maximumScaleValue 
.const [142] = Utf8 I 
.const [143] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [144] = Utf8 maximumScaleUnit 
.const [145] = Utf8 I 
.const [146] = Utf8 java/lang/Object 
.const [147] = Utf8 <init> 
.const [148] = Utf8 ()V 
.const [149] = Utf8 de/audi/atip/metrics/Distance 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (FI)V 
.const [152] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [153] = Utf8 convertZoomIndexToKM 
.const [154] = Utf8 (I[F)F 
.const [155] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [156] = Utf8 convertFormattedUnitToMapScaleUnit 
.const [157] = Utf8 (IF)I 
.const [158] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [159] = Utf8 setMaximumScaleValue 
.const [160] = Utf8 (I)V 
.const [161] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [162] = Utf8 setMaximumScaleUnit 
.const [163] = Utf8 (I)V 
.const [164] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [165] = Utf8 shouldProvideQuarterMiles 
.const [166] = Utf8 (F)Z 
.const [167] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [168] = Utf8 <init> 
.const [169] = Utf8 ()V 
.const [170] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [171] = Utf8 getKMUnitForMapScale 
.const [172] = Utf8 (F)I 
.const [173] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [174] = Utf8 floatHasDecimals 
.const [175] = Utf8 (F)Z 
.const [176] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [177] = Utf8 lastZoomIndex 
.const [178] = Utf8 I 
.const [179] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [180] = Utf8 scale 
.const [181] = Utf8 I 
.const [182] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [183] = Utf8 scaleUnit 
.const [184] = Utf8 I 
.const [185] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [186] = Utf8 scaleValidity 
.const [187] = Utf8 Z 
.const [188] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [189] = Utf8 isMaxScale 
.const [190] = Utf8 Z 
.const [191] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [192] = Utf8 maximumScaleValue 
.const [193] = Utf8 I 
.const [194] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [195] = Utf8 maximumScaleUnit 
.const [196] = Utf8 I 
.const [197] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleHandler 
.const [198] = Class [197] 
.const [199] = Utf8 java/lang/Object 
.const [200] = Class [199] 
.const [201] = Utf8 QUARTER_MILE_MAX_THRESHOLD 
.const [202] = Utf8 F 
.const [203] = Utf8 QUARTER_MILE_MIN_THRESHOLD 
.const [204] = Utf8 F 
.const [205] = Utf8 lastZoomIndex 
.const [206] = Utf8 I 
.const [207] = Utf8 maximumScaleValue 
.const [208] = Utf8 I 
.const [209] = Utf8 maximumScaleUnit 
.const [210] = Utf8 I 
.const [211] = Utf8 Code 
.const [212] = Utf8 <init> 
.const [213] = Utf8 ()V 
.const [214] = Utf8 createMapScaleInfo 
.const [215] = Utf8 (I[F)Lde/audi/tghu/navi/app/map/handler/MapScaleInfo; 
.const [216] = Utf8 getMaximumScaleValue 
.const [217] = Utf8 ()I 
.const [218] = Utf8 setMaximumScaleValue 
.const [219] = Utf8 (I)V 
.const [220] = Utf8 getMaximumScaleUnit 
.const [221] = Utf8 ()I 
.const [222] = Utf8 setMaximumScaleUnit 
.const [223] = Utf8 (I)V 
.const [224] = Utf8 convertZoomIndexToKM 
.const [225] = Utf8 (I[F)F 
.const [226] = Utf8 convertFormattedUnitToMapScaleUnit 
.const [227] = Utf8 (IF)I 
.const [228] = Utf8 getKMUnitForMapScale 
.const [229] = Utf8 (F)I 
.const [230] = Utf8 floatHasDecimals 
.const [231] = Utf8 (F)Z 
.const [232] = Utf8 shouldProvideQuarterMiles 
.const [233] = Utf8 (F)Z 
.end class 
