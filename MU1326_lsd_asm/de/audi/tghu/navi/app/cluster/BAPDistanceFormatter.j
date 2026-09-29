.version 50 0 
.class public super [188] 
.super [190] 
.field private final [191] [192] 

.method public [194] : [195] 
    .attribute [193] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [39] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [196] : [197] 
    .attribute [193] .code stack 3 locals 0 
L0:     aload_1 
L1:     invokevirtual [19] 
L4:     ifeq L17 
L7:     aload_0 
L8:     aload_1 
L9:     invokestatic [2] 
L12:    iload_2 
L13:    invokevirtual [20] 
L16:    areturn 
L17:    aload_0 
L18:    aload_1 
L19:    invokestatic [2] 
L22:    iload_2 
L23:    invokevirtual [21] 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [198] : [199] 
    .attribute [193] .code stack 5 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L40 
            L48 
            L48 
            L44 
            L46 
            L42 
            default : L50 

L40:    iconst_1 
L41:    areturn 
L42:    iconst_0 
L43:    areturn 
L44:    iconst_3 
L45:    areturn 
L46:    iconst_2 
L47:    areturn 
L48:    iconst_4 
L49:    areturn 
L50:    aload_0 
L51:    getfield [18] 
L54:    ldc [3] 
L56:    ldc [4] 
L58:    iload_1 
L59:    i2l 
L60:    invokevirtual [22] 
L63:    pop 
L64:    sipush 255 
L67:    areturn 
L68:    
    .end code 
.end method 

.method private [200] : [201] 
    .attribute [193] .code stack 5 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            3 : L30 
            5 : L28 
            default : L32 

L28:    iconst_0 
L29:    areturn 
L30:    iconst_1 
L31:    areturn 
L32:    aload_0 
L33:    getfield [18] 
L36:    ldc [3] 
L38:    ldc [5] 
L40:    iload_1 
L41:    i2l 
L42:    invokevirtual [22] 
L45:    pop 
L46:    sipush 255 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [202] : [203] 
    .attribute [193] .code stack 4 locals 1 
L0:     new [40] 
L3:     dup 
L4:     iload_1 
L5:     i2f 
L6:     iconst_5 
L7:     invokespecial [32] 
L10:    astore 4 
L12:    aload 4 
L14:    iload_3 
L15:    ifeq L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_2 
L23:    iload_2 
L24:    iconst_2 
L25:    invokevirtual [23] 
L28:    pop 
L29:    aload 4 
L31:    areturn 
L32:    
    .end code 
.end method 

.method private [204] : [205] 
    .attribute [193] .code stack 3 locals 0 
L0:     iload_1 
L1:     iconst_4 
L2:     if_icmpeq L7 
L5:     iconst_m1 
L6:     areturn 
L7:     iload_3 
L8:     ifle L33 
L11:    iload_3 
L12:    bipush 100 
L14:    if_icmpge L33 
L17:    iload_3 
L18:    bipush 25 
L20:    irem 
L21:    ifne L33 
L24:    iconst_4 
L25:    iload_2 
L26:    imul 
L27:    iload_3 
L28:    bipush 25 
L30:    idiv 
L31:    iadd 
L32:    areturn 
L33:    iconst_m1 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [206] : [207] 
    .attribute [193] .code stack 4 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iconst_1 
L4:     invokespecial [33] 
L7:     astore_3 
L8:     aload_3 
L9:     getstatic [7] 
L12:    if_acmpeq L22 
L15:    aload_3 
L16:    invokevirtual [24] 
L19:    ifne L26 
L22:    getstatic [8] 
L25:    astore_3 
L26:    aload_3 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [193] .code stack 4 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iconst_5 
L4:     invokespecial [33] 
L7:     astore_3 
L8:     aload_3 
L9:     getstatic [7] 
L12:    if_acmpeq L22 
L15:    aload_3 
L16:    invokevirtual [24] 
L19:    ifne L26 
L22:    getstatic [8] 
L25:    astore_3 
L26:    aload_3 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [210] : [211] 
    .attribute [193] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iconst_4 
L4:     invokespecial [33] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [212] : [213] 
    .attribute [193] .code stack 6 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokevirtual [21] 
L6:     astore_3 
L7:     new [41] 
L10:    dup 
L11:    ldc [10] 
L13:    aload_3 
L14:    invokevirtual [25] 
L17:    iload_1 
L18:    aconst_null 
L19:    invokespecial [34] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [214] : [215] 
    .attribute [193] .code stack 6 locals 5 
L0:     iload_1 
L1:     ifgt L8 
L4:     invokestatic [11] 
L7:     areturn 
L8:     aload_0 
L9:     iload_1 
L10:    iload_3 
L11:    iload_2 
L12:    invokespecial [35] 
L15:    astore 4 
L17:    aload 4 
L19:    invokevirtual [26] 
L22:    istore 5 
L24:    aload 4 
L26:    invokevirtual [27] 
L29:    istore 6 
L31:    aload_0 
L32:    aload 4 
L34:    invokevirtual [28] 
L37:    invokespecial [36] 
L40:    istore 7 
L42:    iload 5 
L44:    ifge L51 
L47:    invokestatic [11] 
L50:    areturn 
L51:    aload_0 
L52:    iload 7 
L54:    iload 5 
L56:    iload 6 
L58:    invokespecial [37] 
L61:    istore 8 
L63:    iload 8 
L65:    ifle L84 
L68:    new [41] 
L71:    dup 
L72:    bipush 10 
L74:    iload 8 
L76:    imul 
L77:    iconst_5 
L78:    iload_1 
L79:    aconst_null 
L80:    invokespecial [34] 
L83:    areturn 
L84:    iload 6 
L86:    iflt L117 
L89:    iload_3 
L90:    iconst_4 
L91:    if_icmpne L117 
L94:    iload 7 
L96:    iconst_1 
L97:    if_icmpne L107 
L100:   bipush 6 
L102:   istore 7 
L104:   goto L117 
L107:   iload 7 
L109:   iconst_4 
L110:   if_icmpne L117 
L113:   bipush 7 
L115:   istore 7 
L117:   new [41] 
L120:   dup 
L121:   aload 4 
L123:   invokevirtual [29] 
L126:   ldc [12] 
L128:   fmul 
L129:   invokestatic [13] 
L132:   iload 7 
L134:   iload_1 
L135:   aconst_null 
L136:   invokespecial [34] 
L139:   areturn 
L140:   
    .end code 
.end method 

.method public [216] : [217] 
    .attribute [193] .code stack 6 locals 3 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_2 
L3:     iload_2 
L4:     invokespecial [35] 
L7:     astore_3 
L8:     aload_3 
L9:     invokevirtual [30] 
L12:    i2f 
L13:    invokestatic [13] 
L16:    istore 4 
L18:    aload_0 
L19:    aload_3 
L20:    invokevirtual [28] 
L23:    invokespecial [38] 
L26:    istore 5 
L28:    new [41] 
L31:    dup 
L32:    iload 4 
L34:    iload 5 
L36:    iload_1 
L37:    aconst_null 
L38:    invokespecial [34] 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [42] [43] 
.const [3] = Int -1601830656 
.const [4] = String [44] 
.const [5] = String [45] 
.const [6] = Class [46] 
.const [7] = Field [47] [48] 
.const [8] = Field [49] [50] 
.const [9] = Class [51] 
.const [10] = Int -16842752 
.const [11] = Method [52] [53] 
.const [12] = Int 8257 
.const [13] = Method [54] [55] 
.const [14] = Class [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Field [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
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
.const [36] = Method [96] [97] 
.const [37] = Method [98] [99] 
.const [38] = Method [100] [101] 
.const [39] = Field [102] [103] 
.const [40] = Class [104] 
.const [41] = Class [105] 
.const [42] = Class [106] 
.const [43] = NameAndType [107] [108] 
.const [44] = Utf8 'BAPDistanceFormatter#convertFormattedDistanceUnit2BapUnit - unknown unit: %1' 
.const [45] = Utf8 'BAPDistanceFormatter#convertFormattedAltitudeUnit2BapUnit - unknown unit: %1' 
.const [46] = Utf8 de/audi/atip/metrics/Distance 
.const [47] = Class [109] 
.const [48] = NameAndType [110] [111] 
.const [49] = Class [112] 
.const [50] = NameAndType [113] [114] 
.const [51] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [52] = Class [115] 
.const [53] = NameAndType [116] [117] 
.const [54] = Class [118] 
.const [55] = NameAndType [119] [120] 
.const [56] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 java/lang/Math 
.const [60] = Class [121] 
.const [61] = NameAndType [122] [123] 
.const [62] = Class [124] 
.const [63] = NameAndType [125] [126] 
.const [64] = Class [127] 
.const [65] = NameAndType [128] [129] 
.const [66] = Class [130] 
.const [67] = NameAndType [131] [132] 
.const [68] = Class [133] 
.const [69] = NameAndType [134] [135] 
.const [70] = Class [136] 
.const [71] = NameAndType [137] [138] 
.const [72] = Class [139] 
.const [73] = NameAndType [140] [141] 
.const [74] = Class [142] 
.const [75] = NameAndType [143] [144] 
.const [76] = Class [145] 
.const [77] = NameAndType [146] [147] 
.const [78] = Class [148] 
.const [79] = NameAndType [149] [150] 
.const [80] = Class [151] 
.const [81] = NameAndType [152] [153] 
.const [82] = Class [154] 
.const [83] = NameAndType [155] [156] 
.const [84] = Class [157] 
.const [85] = NameAndType [158] [159] 
.const [86] = Class [160] 
.const [87] = NameAndType [161] [162] 
.const [88] = Class [163] 
.const [89] = NameAndType [164] [165] 
.const [90] = Class [166] 
.const [91] = NameAndType [167] [168] 
.const [92] = Class [169] 
.const [93] = NameAndType [170] [171] 
.const [94] = Class [172] 
.const [95] = NameAndType [173] [174] 
.const [96] = Class [175] 
.const [97] = NameAndType [176] [177] 
.const [98] = Class [178] 
.const [99] = NameAndType [179] [180] 
.const [100] = Class [181] 
.const [101] = NameAndType [182] [183] 
.const [102] = Class [184] 
.const [103] = NameAndType [185] [186] 
.const [104] = Utf8 de/audi/atip/metrics/Distance 
.const [105] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [106] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [107] = Utf8 access$000 
.const [108] = Utf8 (Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance;)I 
.const [109] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [110] = Utf8 INVALID 
.const [111] = Utf8 Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [112] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [113] = Utf8 INVALID_HANDELED_BY_APPCOMBIBAP 
.const [114] = Utf8 Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [115] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [116] = Utf8 invalid 
.const [117] = Utf8 ()Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [118] = Utf8 java/lang/Math 
.const [119] = Utf8 round 
.const [120] = Utf8 (F)I 
.const [121] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [122] = Utf8 logChannel 
.const [123] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [124] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [125] = Utf8 isMaximumMapScale 
.const [126] = Utf8 ()Z 
.const [127] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [128] = Utf8 formatMaximumMapScale 
.const [129] = Utf8 (IZ)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [130] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [131] = Utf8 formatMapScale 
.const [132] = Utf8 (IZ)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;J)Z 
.const [136] = Utf8 de/audi/atip/metrics/Distance 
.const [137] = Utf8 format 
.const [138] = Utf8 (III)Ljava/lang/String; 
.const [139] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [140] = Utf8 getValue 
.const [141] = Utf8 ()I 
.const [142] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [143] = Utf8 getUnit 
.const [144] = Utf8 ()I 
.const [145] = Utf8 de/audi/atip/metrics/Distance 
.const [146] = Utf8 getIntegerPortionOfFormattedDistance 
.const [147] = Utf8 ()I 
.const [148] = Utf8 de/audi/atip/metrics/Distance 
.const [149] = Utf8 getPureRationalPortionOfFormattedDistance 
.const [150] = Utf8 ()I 
.const [151] = Utf8 de/audi/atip/metrics/Distance 
.const [152] = Utf8 getFormattedUnit 
.const [153] = Utf8 ()I 
.const [154] = Utf8 de/audi/atip/metrics/Distance 
.const [155] = Utf8 getFormattedDistance 
.const [156] = Utf8 ()F 
.const [157] = Utf8 de/audi/atip/metrics/Distance 
.const [158] = Utf8 getFormattedHeight 
.const [159] = Utf8 ()I 
.const [160] = Utf8 java/lang/Object 
.const [161] = Utf8 <init> 
.const [162] = Utf8 ()V 
.const [163] = Utf8 de/audi/atip/metrics/Distance 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (FI)V 
.const [166] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [167] = Utf8 formatDistance 
.const [168] = Utf8 (IZI)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [169] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (IIILde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$1;)V 
.const [172] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [173] = Utf8 createFormattedDistanceInstance 
.const [174] = Utf8 (IIZ)Lde/audi/atip/metrics/Distance; 
.const [175] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [176] = Utf8 convertFormattedDistanceUnit2BapUnit 
.const [177] = Utf8 (I)I 
.const [178] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [179] = Utf8 getQuarterMiles 
.const [180] = Utf8 (III)I 
.const [181] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [182] = Utf8 convertFormattedAltitudeUnit2BapUnit 
.const [183] = Utf8 (I)I 
.const [184] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [185] = Utf8 logChannel 
.const [186] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [187] = Utf8 de/audi/tghu/navi/app/cluster/BAPDistanceFormatter 
.const [188] = Class [187] 
.const [189] = Utf8 java/lang/Object 
.const [190] = Class [189] 
.const [191] = Utf8 logChannel 
.const [192] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [193] = Utf8 Code 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [196] = Utf8 changeUnits 
.const [197] = Utf8 (Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance;Z)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [198] = Utf8 convertFormattedDistanceUnit2BapUnit 
.const [199] = Utf8 (I)I 
.const [200] = Utf8 convertFormattedAltitudeUnit2BapUnit 
.const [201] = Utf8 (I)I 
.const [202] = Utf8 createFormattedDistanceInstance 
.const [203] = Utf8 (IIZ)Lde/audi/atip/metrics/Distance; 
.const [204] = Utf8 getQuarterMiles 
.const [205] = Utf8 (III)I 
.const [206] = Utf8 formatDistanceToDestination 
.const [207] = Utf8 (IZ)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [208] = Utf8 formatDistanceToTurn 
.const [209] = Utf8 (IZ)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [210] = Utf8 formatMapScale 
.const [211] = Utf8 (IZ)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [212] = Utf8 formatMaximumMapScale 
.const [213] = Utf8 (IZ)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [214] = Utf8 formatDistance 
.const [215] = Utf8 (IZI)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.const [216] = Utf8 formatAltitude 
.const [217] = Utf8 (IZ)Lde/audi/tghu/navi/app/cluster/BAPDistanceFormatter$BAPDistance; 
.end class 
