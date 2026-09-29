.version 50 0 
.class public super abstract [144] 
.super [146] 
.field private [147] [148] 
.field private [149] [150] 
.field private [151] [152] 
.field protected final [153] [154] 
.field protected final [155] [156] 
.field private [157] [158] 

.method public [160] : [161] 
    .attribute [159] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     ldc [2] 
L7:     putfield [27] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [28] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [29] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [30] 
L25:    aload_0 
L26:    aload_3 
L27:    putfield [31] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [159] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     invokevirtual [18] 
L5:     putfield [32] 
L8:     aload_0 
L9:     aload_0 
L10:    aload_0 
L11:    getfield [19] 
L14:    invokevirtual [20] 
L17:    putfield [32] 
L20:    aload_0 
L21:    getfield [17] 
L24:    getfield [21] 
L27:    aload_0 
L28:    getfield [14] 
L31:    ldc [3] 
L33:    aload_0 
L34:    getfield [16] 
L37:    aload_0 
L38:    getfield [19] 
L41:    invokevirtual [22] 
L44:    aload_0 
L45:    iconst_1 
L46:    putfield [28] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [159] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifeq L137 
L7:     iload_2 
L8:     iflt L106 
L11:    iload_2 
L12:    aload_0 
L13:    getfield [19] 
L16:    arraylength 
L17:    if_icmpge L106 
L20:    iload_1 
L21:    aload_0 
L22:    getfield [19] 
L25:    iload_2 
L26:    iaload 
L27:    if_icmpeq L73 
L30:    aload_0 
L31:    getfield [17] 
L34:    getfield [21] 
L37:    aload_0 
L38:    getfield [14] 
L41:    ldc [4] 
L43:    aload_0 
L44:    getfield [16] 
L47:    iload_2 
L48:    i2l 
L49:    iload_1 
L50:    i2l 
L51:    invokevirtual [23] 
L54:    pop 
L55:    aload_0 
L56:    getfield [19] 
L59:    iload_2 
L60:    iload_1 
L61:    iastore 
L62:    aload_0 
L63:    aload_0 
L64:    getfield [19] 
L67:    invokevirtual [24] 
L70:    goto L157 
L73:    aload_0 
L74:    getfield [17] 
L77:    getfield [21] 
L80:    aload_0 
L81:    getfield [14] 
L84:    ldc [5] 
L86:    aload_0 
L87:    getfield [16] 
L90:    iload_2 
L91:    i2l 
L92:    aload_0 
L93:    getfield [19] 
L96:    iload_2 
L97:    iaload 
L98:    i2l 
L99:    invokevirtual [23] 
L102:   pop 
L103:   goto L157 
L106:   aload_0 
L107:   getfield [17] 
L110:   getfield [21] 
L113:   sipush 10000 
L116:   ldc [6] 
L118:   aload_0 
L119:   getfield [16] 
L122:   iload_2 
L123:   i2l 
L124:   aload_0 
L125:   getfield [19] 
L128:   arraylength 
L129:   i2l 
L130:   invokevirtual [23] 
L133:   pop 
L134:   goto L157 
L137:   aload_0 
L138:   getfield [17] 
L141:   getfield [21] 
L144:   sipush 10000 
L147:   ldc [7] 
L149:   aload_0 
L150:   getfield [16] 
L153:   invokevirtual [25] 
L156:   pop 
L157:   return 
L158:   nop 
L159:   nop 
L160:   
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [159] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifeq L108 
L7:     aload_0 
L8:     getfield [19] 
L11:    arraylength 
L12:    iload_2 
L13:    aload_1 
L14:    arraylength 
L15:    iadd 
L16:    if_icmpeq L42 
L19:    iload_2 
L20:    aload_1 
L21:    arraylength 
L22:    iadd 
L23:    newarray int 
L25:    astore_3 
L26:    aload_0 
L27:    getfield [19] 
L30:    iconst_0 
L31:    aload_3 
L32:    iconst_0 
L33:    iload_2 
L34:    invokestatic [8] 
L37:    aload_0 
L38:    aload_3 
L39:    putfield [32] 
L42:    iconst_0 
L43:    istore_3 
L44:    iconst_0 
L45:    istore 4 
L47:    iload 4 
L49:    aload_1 
L50:    arraylength 
L51:    if_icmpge L81 
L54:    aload_1 
L55:    iload 4 
L57:    iaload 
L58:    aload_0 
L59:    getfield [19] 
L62:    iload_2 
L63:    iload 4 
L65:    iadd 
L66:    iaload 
L67:    if_icmpeq L75 
L70:    iconst_1 
L71:    istore_3 
L72:    goto L81 
L75:    iinc 4 1 
L78:    goto L47 
L81:    iload_3 
L82:    ifeq L105 
L85:    aload_1 
L86:    iconst_0 
L87:    aload_0 
L88:    getfield [19] 
L91:    iload_2 
L92:    aload_1 
L93:    arraylength 
L94:    invokestatic [8] 
L97:    aload_0 
L98:    aload_0 
L99:    getfield [19] 
L102:   invokevirtual [24] 
L105:   goto L128 
L108:   aload_0 
L109:   getfield [17] 
L112:   getfield [21] 
L115:   sipush 10000 
L118:   ldc [7] 
L120:   aload_0 
L121:   getfield [16] 
L124:   invokevirtual [25] 
L127:   pop 
L128:   return 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [168] : [169] 
    .attribute [159] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifeq L14 
L7:     aload_0 
L8:     getfield [19] 
L11:    goto L15 
L14:    aconst_null 
L15:    areturn 
L16:    
    .end code 
.end method 

.method protected abstract [170] : [171] 
    .attribute [159] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [172] : [173] 
    .attribute [159] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [174] : [175] 
    .attribute [159] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [33] 
.const [4] = String [34] 
.const [5] = String [35] 
.const [6] = String [36] 
.const [7] = String [37] 
.const [8] = Method [38] [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Field [45] [46] 
.const [15] = Field [47] [48] 
.const [16] = Field [49] [50] 
.const [17] = Field [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Field [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = Field [73] [74] 
.const [29] = Field [75] [76] 
.const [30] = Field [77] [78] 
.const [31] = Field [79] [80] 
.const [32] = Field [81] [82] 
.const [33] = Utf8 '[%1SetupHandler#init], Initial setup is %2' 
.const [34] = Utf8 '[%1SetupHandler#valueUpdated], Value at position %2 changed (now %3)' 
.const [35] = Utf8 '[%1SetupHandler#valueUpdated], Value at position %2 did not change (still %3)' 
.const [36] = Utf8 '[%1SetupHandler#valueUpdated], Invalid index (%1) for setup (length %2)' 
.const [37] = Utf8 '[%1SetupHandler#valueUpdated], skipping, not initialized' 
.const [38] = Class [83] 
.const [39] = NameAndType [84] [85] 
.const [40] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 de/audi/tuner/app/Logger 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 java/lang/System 
.const [45] = Class [86] 
.const [46] = NameAndType [87] [88] 
.const [47] = Class [89] 
.const [48] = NameAndType [90] [91] 
.const [49] = Class [92] 
.const [50] = NameAndType [93] [94] 
.const [51] = Class [95] 
.const [52] = NameAndType [96] [97] 
.const [53] = Class [98] 
.const [54] = NameAndType [99] [100] 
.const [55] = Class [101] 
.const [56] = NameAndType [102] [103] 
.const [57] = Class [104] 
.const [58] = NameAndType [105] [106] 
.const [59] = Class [107] 
.const [60] = NameAndType [108] [109] 
.const [61] = Class [110] 
.const [62] = NameAndType [111] [112] 
.const [63] = Class [113] 
.const [64] = NameAndType [114] [115] 
.const [65] = Class [116] 
.const [66] = NameAndType [117] [118] 
.const [67] = Class [119] 
.const [68] = NameAndType [120] [121] 
.const [69] = Class [122] 
.const [70] = NameAndType [123] [124] 
.const [71] = Class [125] 
.const [72] = NameAndType [126] [127] 
.const [73] = Class [128] 
.const [74] = NameAndType [129] [130] 
.const [75] = Class [131] 
.const [76] = NameAndType [132] [133] 
.const [77] = Class [134] 
.const [78] = NameAndType [135] [136] 
.const [79] = Class [137] 
.const [80] = NameAndType [138] [139] 
.const [81] = Class [140] 
.const [82] = NameAndType [141] [142] 
.const [83] = Utf8 java/lang/System 
.const [84] = Utf8 arraycopy 
.const [85] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [86] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [87] = Utf8 logLevel 
.const [88] = Utf8 I 
.const [89] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [90] = Utf8 initialized 
.const [91] = Utf8 Z 
.const [92] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [93] = Utf8 whoAmI 
.const [94] = Utf8 Ljava/lang/String; 
.const [95] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [96] = Utf8 logger 
.const [97] = Utf8 Lde/audi/tuner/app/Logger; 
.const [98] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [99] = Utf8 loadSetup 
.const [100] = Utf8 ()[I 
.const [101] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [102] = Utf8 currentSetup 
.const [103] = Utf8 [I 
.const [104] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [105] = Utf8 checkSetupByVariant 
.const [106] = Utf8 ([I)[I 
.const [107] = Utf8 de/audi/tuner/app/Logger 
.const [108] = Utf8 main 
.const [109] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [110] = Utf8 de/audi/atip/log/LogChannel 
.const [111] = Utf8 log 
.const [112] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 log 
.const [115] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [116] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [117] = Utf8 storeSetup 
.const [118] = Utf8 ([I)V 
.const [119] = Utf8 de/audi/atip/log/LogChannel 
.const [120] = Utf8 log 
.const [121] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [122] = Utf8 java/lang/Object 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [126] = Utf8 logLevel 
.const [127] = Utf8 I 
.const [128] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [129] = Utf8 initialized 
.const [130] = Utf8 Z 
.const [131] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [132] = Utf8 whoAmI 
.const [133] = Utf8 Ljava/lang/String; 
.const [134] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [135] = Utf8 logger 
.const [136] = Utf8 Lde/audi/tuner/app/Logger; 
.const [137] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [138] = Utf8 storage 
.const [139] = Utf8 Lde/audi/tuner/app/storage/TunerStorage; 
.const [140] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [141] = Utf8 currentSetup 
.const [142] = Utf8 [I 
.const [143] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [144] = Class [143] 
.const [145] = Utf8 java/lang/Object 
.const [146] = Class [145] 
.const [147] = Utf8 logLevel 
.const [148] = Utf8 I 
.const [149] = Utf8 currentSetup 
.const [150] = Utf8 [I 
.const [151] = Utf8 whoAmI 
.const [152] = Utf8 Ljava/lang/String; 
.const [153] = Utf8 logger 
.const [154] = Utf8 Lde/audi/tuner/app/Logger; 
.const [155] = Utf8 storage 
.const [156] = Utf8 Lde/audi/tuner/app/storage/TunerStorage; 
.const [157] = Utf8 initialized 
.const [158] = Utf8 Z 
.const [159] = Utf8 Code 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Ljava/lang/String;Lde/audi/tuner/app/Logger;Lde/audi/tuner/app/storage/TunerStorage;)V 
.const [162] = Utf8 init 
.const [163] = Utf8 ()V 
.const [164] = Utf8 valueUpdated 
.const [165] = Utf8 (II)V 
.const [166] = Utf8 valueUpdated 
.const [167] = Utf8 ([II)V 
.const [168] = Utf8 getCurrentSetup 
.const [169] = Utf8 ()[I 
.const [170] = Utf8 loadSetup 
.const [171] = Utf8 ()[I 
.const [172] = Utf8 checkSetupByVariant 
.const [173] = Utf8 ([I)[I 
.const [174] = Utf8 storeSetup 
.const [175] = Utf8 ([I)V 
.end class 
