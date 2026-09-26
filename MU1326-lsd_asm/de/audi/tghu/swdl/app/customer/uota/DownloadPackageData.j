.version 50 0 
.class super [244] 
.super [246] 
.field public static final [247] [248] 
.field public static final [249] [250] 
.field private final [251] [252] 
.field private final [253] [254] 

.method public [256] : [257] 
    .attribute [255] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [48] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [53] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [54] 
L14:    aconst_null 
L15:    aload_1 
L16:    if_acmpeq L24 
L19:    aload_1 
L20:    arraylength 
L21:    ifne L37 
L24:    aload_0 
L25:    getfield [29] 
L28:    sipush 10000 
L31:    ldc [2] 
L33:    invokevirtual [30] 
L36:    pop 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [258] : [259] 
    .attribute [255] .code stack 2 locals 0 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [28] 
L5:     if_acmpne L13 
L8:     iconst_0 
L9:     anewarray [3] 
L12:    areturn 
L13:    aload_0 
L14:    getfield [28] 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [260] : [261] 
    .attribute [255] .code stack 7 locals 0 
L0:     iload_1 
L1:     iflt L20 
L4:     iload_1 
L5:     aload_0 
L6:     invokespecial [49] 
L9:     arraylength 
L10:    if_icmpge L20 
L13:    aload_0 
L14:    invokespecial [49] 
L17:    iload_1 
L18:    aaload 
L19:    areturn 
L20:    aload_0 
L21:    getfield [29] 
L24:    sipush 10000 
L27:    ldc [4] 
L29:    iload_1 
L30:    i2l 
L31:    aload_0 
L32:    invokespecial [49] 
L35:    arraylength 
L36:    i2l 
L37:    invokevirtual [31] 
L40:    pop 
L41:    aconst_null 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method [262] : [263] 
    .attribute [255] .code stack 5 locals 2 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     iload_1 
L4:     invokespecial [50] 
L7:     astore_3 
L8:     aconst_null 
L9:     aload_3 
L10:    if_acmpeq L42 
L13:    aload_0 
L14:    invokespecial [49] 
L17:    iload_1 
L18:    aaload 
L19:    invokevirtual [32] 
L22:    istore_2 
L23:    aload_0 
L24:    getfield [29] 
L27:    ldc [5] 
L29:    ldc [6] 
L31:    iload_1 
L32:    invokestatic [7] 
L35:    iload_2 
L36:    invokestatic [8] 
L39:    invokevirtual [33] 
L42:    iload_2 
L43:    areturn 
L44:    
    .end code 
.end method 

.method [264] : [265] 
    .attribute [255] .code stack 2 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [50] 
L5:     astore_2 
L6:     aconst_null 
L7:     aload_2 
L8:     if_acmpeq L17 
L11:    aload_2 
L12:    iconst_0 
L13:    invokevirtual [34] 
L16:    areturn 
L17:    ldc [9] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method [266] : [267] 
    .attribute [255] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [29] 
L4:     ldc [5] 
L6:     ldc [10] 
L8:     aload_1 
L9:     invokevirtual [35] 
L12:    pop 
L13:    new [55] 
L16:    dup 
L17:    invokespecial [51] 
L20:    astore_2 
L21:    aload_0 
L22:    invokespecial [49] 
L25:    astore_3 
L26:    new [56] 
L29:    dup 
L30:    aload_3 
L31:    arraylength 
L32:    invokespecial [52] 
L35:    astore 4 
L37:    iconst_0 
L38:    istore 5 
L40:    iload 5 
L42:    aload_3 
L43:    arraylength 
L44:    if_icmpge L90 
L47:    aload_3 
L48:    iload 5 
L50:    aaload 
L51:    astore 6 
L53:    aload 6 
L55:    invokevirtual [36] 
L58:    ifne L84 
L61:    aload_1 
L62:    aload 6 
L64:    invokevirtual [37] 
L67:    invokevirtual [38] 
L70:    ifeq L84 
L73:    aload 4 
L75:    aload 6 
L77:    invokevirtual [39] 
L80:    invokevirtual [40] 
L83:    pop 
L84:    iinc 5 1 
L87:    goto L40 
L90:    aload 4 
L92:    invokestatic [13] 
L95:    aload 4 
L97:    invokevirtual [41] 
L100:   astore 5 
L102:   aload 5 
L104:   invokeinterface [57] 0 
L109:   ifeq L141 
L112:   aload_2 
L113:   invokevirtual [42] 
L116:   ifle L126 
L119:   aload_2 
L120:   ldc [14] 
L122:   invokevirtual [43] 
L125:   pop 
L126:   aload_2 
L127:   aload 5 
L129:   invokeinterface [58] 0 
L134:   invokevirtual [44] 
L137:   pop 
L138:   goto L102 
L141:   aload_0 
L142:   getfield [29] 
L145:   ldc [5] 
L147:   ldc [15] 
L149:   aload_2 
L150:   invokevirtual [35] 
L153:   pop 
L154:   aload_2 
L155:   invokevirtual [45] 
L158:   areturn 
L159:   nop 
L160:   
    .end code 
.end method 

.method [268] : [269] 
    .attribute [255] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [29] 
L4:     ldc [5] 
L6:     ldc [16] 
L8:     aload_1 
L9:     invokevirtual [35] 
L12:    pop 
L13:    new [55] 
L16:    dup 
L17:    invokespecial [51] 
L20:    astore_2 
L21:    aload_0 
L22:    invokespecial [49] 
L25:    astore_3 
L26:    new [56] 
L29:    dup 
L30:    iconst_1 
L31:    invokespecial [52] 
L34:    astore 4 
L36:    iconst_0 
L37:    istore 5 
L39:    iload 5 
L41:    aload_3 
L42:    arraylength 
L43:    if_icmpge L102 
L46:    aload_3 
L47:    iload 5 
L49:    aaload 
L50:    astore 6 
L52:    aload 6 
L54:    invokevirtual [36] 
L57:    ifne L96 
L60:    aload_1 
L61:    aload 6 
L63:    invokevirtual [37] 
L66:    invokevirtual [38] 
L69:    ifeq L96 
L72:    aload 4 
L74:    aload 6 
L76:    invokevirtual [46] 
L79:    invokevirtual [47] 
L82:    ifne L96 
L85:    aload 4 
L87:    aload 6 
L89:    invokevirtual [46] 
L92:    invokevirtual [40] 
L95:    pop 
L96:    iinc 5 1 
L99:    goto L39 
L102:   aload 4 
L104:   invokestatic [13] 
L107:   aload 4 
L109:   invokevirtual [41] 
L112:   astore 5 
L114:   aload 5 
L116:   invokeinterface [57] 0 
L121:   ifeq L153 
L124:   aload_2 
L125:   invokevirtual [42] 
L128:   ifle L138 
L131:   aload_2 
L132:   ldc [14] 
L134:   invokevirtual [43] 
L137:   pop 
L138:   aload_2 
L139:   aload 5 
L141:   invokeinterface [58] 0 
L146:   invokevirtual [44] 
L149:   pop 
L150:   goto L114 
L153:   aload_0 
L154:   getfield [29] 
L157:   ldc [5] 
L159:   ldc [17] 
L161:   aload_2 
L162:   invokevirtual [35] 
L165:   pop 
L166:   aload_2 
L167:   invokevirtual [45] 
L170:   areturn 
L171:   nop 
L172:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [59] 
.const [3] = Class [60] 
.const [4] = String [61] 
.const [5] = Int -2137614336 
.const [6] = String [62] 
.const [7] = Method [63] [64] 
.const [8] = Method [65] [66] 
.const [9] = String [67] 
.const [10] = String [68] 
.const [11] = Class [69] 
.const [12] = Class [70] 
.const [13] = Method [71] [72] 
.const [14] = String [73] 
.const [15] = String [74] 
.const [16] = String [75] 
.const [17] = String [76] 
.const [18] = Class [77] 
.const [19] = Class [78] 
.const [20] = String [79] 
.const [21] = String [80] 
.const [22] = Class [81] 
.const [23] = Class [82] 
.const [24] = Class [83] 
.const [25] = Class [84] 
.const [26] = Class [85] 
.const [27] = Class [86] 
.const [28] = Field [87] [88] 
.const [29] = Field [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Method [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Method [103] [104] 
.const [37] = Method [105] [106] 
.const [38] = Method [107] [108] 
.const [39] = Method [109] [110] 
.const [40] = Method [111] [112] 
.const [41] = Method [113] [114] 
.const [42] = Method [115] [116] 
.const [43] = Method [117] [118] 
.const [44] = Method [119] [120] 
.const [45] = Method [121] [122] 
.const [46] = Method [123] [124] 
.const [47] = Method [125] [126] 
.const [48] = Method [127] [128] 
.const [49] = Method [129] [130] 
.const [50] = Method [131] [132] 
.const [51] = Method [133] [134] 
.const [52] = Method [135] [136] 
.const [53] = Field [137] [138] 
.const [54] = Field [139] [140] 
.const [55] = Class [141] 
.const [56] = Class [142] 
.const [57] = InterfaceMethod [143] [144] 
.const [58] = InterfaceMethod [145] [146] 
.const [59] = Utf8 '[DownloadPackageData].<init>: no download packages found!' 
.const [60] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [61] = Utf8 '[DownloadPackageData].getDownloadPackage: incorrect package index %1, array length = %2' 
.const [62] = Utf8 '[DownloadPackageData].isPPOIPackage(%1): %2' 
.const [63] = Class [147] 
.const [64] = NameAndType [148] [149] 
.const [65] = Class [150] 
.const [66] = NameAndType [151] [152] 
.const [67] = Utf8 '' 
.const [68] = Utf8 '[DownloadPackageData].getPackageNames(%1)' 
.const [69] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [70] = Utf8 java/util/ArrayList 
.const [71] = Class [153] 
.const [72] = NameAndType [154] [155] 
.const [73] = Utf8 ', ' 
.const [74] = Utf8 '[DownloadPackageData].getPackageNames:%1' 
.const [75] = Utf8 '[DownloadPackageData].getPackageVersions(%1)' 
.const [76] = Utf8 '[DownloadPackageData].getPackageVersions:%1' 
.const [77] = Utf8 de/audi/tghu/swdl/app/customer/uota/DownloadPackageData 
.const [78] = Utf8 java/lang/Object 
.const [79] = Utf8 system 
.const [80] = Utf8 navdata 
.const [81] = Utf8 de/audi/atip/log/LogChannel 
.const [82] = Utf8 java/lang/Integer 
.const [83] = Utf8 java/lang/Boolean 
.const [84] = Utf8 java/lang/String 
.const [85] = Utf8 java/util/Collections 
.const [86] = Utf8 java/util/Iterator 
.const [87] = Class [156] 
.const [88] = NameAndType [157] [158] 
.const [89] = Class [159] 
.const [90] = NameAndType [160] [161] 
.const [91] = Class [162] 
.const [92] = NameAndType [163] [164] 
.const [93] = Class [165] 
.const [94] = NameAndType [166] [167] 
.const [95] = Class [168] 
.const [96] = NameAndType [169] [170] 
.const [97] = Class [171] 
.const [98] = NameAndType [172] [173] 
.const [99] = Class [174] 
.const [100] = NameAndType [175] [176] 
.const [101] = Class [177] 
.const [102] = NameAndType [178] [179] 
.const [103] = Class [180] 
.const [104] = NameAndType [181] [182] 
.const [105] = Class [183] 
.const [106] = NameAndType [184] [185] 
.const [107] = Class [186] 
.const [108] = NameAndType [187] [188] 
.const [109] = Class [189] 
.const [110] = NameAndType [190] [191] 
.const [111] = Class [192] 
.const [112] = NameAndType [193] [194] 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Class [198] 
.const [116] = NameAndType [199] [200] 
.const [117] = Class [201] 
.const [118] = NameAndType [202] [203] 
.const [119] = Class [204] 
.const [120] = NameAndType [205] [206] 
.const [121] = Class [207] 
.const [122] = NameAndType [208] [209] 
.const [123] = Class [210] 
.const [124] = NameAndType [211] [212] 
.const [125] = Class [213] 
.const [126] = NameAndType [214] [215] 
.const [127] = Class [216] 
.const [128] = NameAndType [217] [218] 
.const [129] = Class [219] 
.const [130] = NameAndType [220] [221] 
.const [131] = Class [222] 
.const [132] = NameAndType [223] [224] 
.const [133] = Class [225] 
.const [134] = NameAndType [226] [227] 
.const [135] = Class [228] 
.const [136] = NameAndType [229] [230] 
.const [137] = Class [231] 
.const [138] = NameAndType [232] [233] 
.const [139] = Class [234] 
.const [140] = NameAndType [235] [236] 
.const [141] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [142] = Utf8 java/util/ArrayList 
.const [143] = Class [237] 
.const [144] = NameAndType [238] [239] 
.const [145] = Class [240] 
.const [146] = NameAndType [241] [242] 
.const [147] = Utf8 java/lang/Integer 
.const [148] = Utf8 toString 
.const [149] = Utf8 (I)Ljava/lang/String; 
.const [150] = Utf8 java/lang/Boolean 
.const [151] = Utf8 toString 
.const [152] = Utf8 (Z)Ljava/lang/String; 
.const [153] = Utf8 java/util/Collections 
.const [154] = Utf8 sort 
.const [155] = Utf8 (Ljava/util/List;)V 
.const [156] = Utf8 de/audi/tghu/swdl/app/customer/uota/DownloadPackageData 
.const [157] = Utf8 downloadPackages 
.const [158] = Utf8 [Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [159] = Utf8 de/audi/tghu/swdl/app/customer/uota/DownloadPackageData 
.const [160] = Utf8 logChannel 
.const [161] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [162] = Utf8 de/audi/atip/log/LogChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (ILjava/lang/String;)Z 
.const [165] = Utf8 de/audi/atip/log/LogChannel 
.const [166] = Utf8 log 
.const [167] = Utf8 (ILjava/lang/String;JJ)Z 
.const [168] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [169] = Utf8 isPPOI 
.const [170] = Utf8 ()Z 
.const [171] = Utf8 de/audi/atip/log/LogChannel 
.const [172] = Utf8 log 
.const [173] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [174] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [175] = Utf8 getDisplayVersion 
.const [176] = Utf8 (I)Ljava/lang/String; 
.const [177] = Utf8 de/audi/atip/log/LogChannel 
.const [178] = Utf8 log 
.const [179] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [180] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [181] = Utf8 isTechnicalPackage 
.const [182] = Utf8 ()Z 
.const [183] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [184] = Utf8 getPkgCategory 
.const [185] = Utf8 ()Ljava/lang/String; 
.const [186] = Utf8 java/lang/String 
.const [187] = Utf8 equalsIgnoreCase 
.const [188] = Utf8 (Ljava/lang/String;)Z 
.const [189] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [190] = Utf8 getLastName 
.const [191] = Utf8 ()Ljava/lang/String; 
.const [192] = Utf8 java/util/ArrayList 
.const [193] = Utf8 add 
.const [194] = Utf8 (Ljava/lang/Object;)Z 
.const [195] = Utf8 java/util/ArrayList 
.const [196] = Utf8 iterator 
.const [197] = Utf8 ()Ljava/util/Iterator; 
.const [198] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [199] = Utf8 length 
.const [200] = Utf8 ()I 
.const [201] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [202] = Utf8 append 
.const [203] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [204] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [205] = Utf8 append 
.const [206] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [207] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [208] = Utf8 toString 
.const [209] = Utf8 ()Ljava/lang/String; 
.const [210] = Utf8 de/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper 
.const [211] = Utf8 getLastVersion 
.const [212] = Utf8 ()Ljava/lang/String; 
.const [213] = Utf8 java/util/ArrayList 
.const [214] = Utf8 contains 
.const [215] = Utf8 (Ljava/lang/Object;)Z 
.const [216] = Utf8 java/lang/Object 
.const [217] = Utf8 <init> 
.const [218] = Utf8 ()V 
.const [219] = Utf8 de/audi/tghu/swdl/app/customer/uota/DownloadPackageData 
.const [220] = Utf8 getDownloadPackages 
.const [221] = Utf8 ()[Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [222] = Utf8 de/audi/tghu/swdl/app/customer/uota/DownloadPackageData 
.const [223] = Utf8 getDownloadPackage 
.const [224] = Utf8 (I)Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [225] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [226] = Utf8 <init> 
.const [227] = Utf8 ()V 
.const [228] = Utf8 java/util/ArrayList 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (I)V 
.const [231] = Utf8 de/audi/tghu/swdl/app/customer/uota/DownloadPackageData 
.const [232] = Utf8 downloadPackages 
.const [233] = Utf8 [Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [234] = Utf8 de/audi/tghu/swdl/app/customer/uota/DownloadPackageData 
.const [235] = Utf8 logChannel 
.const [236] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [237] = Utf8 java/util/Iterator 
.const [238] = Utf8 hasNext 
.const [239] = Utf8 ()Z 
.const [240] = Utf8 java/util/Iterator 
.const [241] = Utf8 next 
.const [242] = Utf8 ()Ljava/lang/Object; 
.const [243] = Utf8 de/audi/tghu/swdl/app/customer/uota/DownloadPackageData 
.const [244] = Class [243] 
.const [245] = Utf8 java/lang/Object 
.const [246] = Class [245] 
.const [247] = Utf8 PKG_CATEGORY_SYSTEM 
.const [248] = Utf8 Ljava/lang/String; 
.const [249] = Utf8 PKG_CATEGORY_NAVDATA 
.const [250] = Utf8 Ljava/lang/String; 
.const [251] = Utf8 downloadPackages 
.const [252] = Utf8 [Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [253] = Utf8 logChannel 
.const [254] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [255] = Utf8 Code 
.const [256] = Utf8 <init> 
.const [257] = Utf8 ([Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper;Lde/audi/atip/log/LogChannel;)V 
.const [258] = Utf8 getDownloadPackages 
.const [259] = Utf8 ()[Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [260] = Utf8 getDownloadPackage 
.const [261] = Utf8 (I)Lde/audi/tghu/swdl/app/customer/uota/UotaPkgInfoWrapper; 
.const [262] = Utf8 isPPOIPackage 
.const [263] = Utf8 (I)Z 
.const [264] = Utf8 getPackageVersion 
.const [265] = Utf8 (I)Ljava/lang/String; 
.const [266] = Utf8 getPackageNames 
.const [267] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [268] = Utf8 getPackageVersions 
.const [269] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.end class 
