.version 50 0 
.class public super [98] 
.super [100] 
.field static final [101] [102] 
.field static final [103] [104] 
.field static final [105] [106] 
.field static final [107] [108] 
.field static final [109] [110] 
.field static final [111] [112] 
.field static final [113] [114] 
.field static final [115] [116] 
.field static final [117] [118] 
.field static final [119] [120] 
.field private static final [121] [122] 

.method [124] : [125] 
    .attribute [123] .code stack 4 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     aload_1 
L4:     aload_2 
L5:     invokespecial [22] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [126] : [127] 
    .attribute [123] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokevirtual [17] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected [128] : [129] 
    .attribute [123] .code stack 7 locals 0 
L0:     aload_1 
L1:     arraylength 
L2:     bipush 10 
L4:     if_icmpne L19 
L7:     aload_0 
L8:     getfield [16] 
L11:    aload_1 
L12:    iconst_1 
L13:    invokevirtual [18] 
L16:    goto L41 
L19:    aload_0 
L20:    getfield [19] 
L23:    getfield [20] 
L26:    sipush 10000 
L29:    ldc [3] 
L31:    aload_1 
L32:    arraylength 
L33:    i2l 
L34:    ldc_w [1] 
L37:    invokevirtual [21] 
L40:    pop 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [130] : [131] 
    .attribute [123] .code stack 3 locals 1 
L0:     bipush 10 
L2:     newarray int 
L4:     astore_0 
L5:     aload_0 
L6:     iconst_1 
L7:     invokestatic [4] 
L10:    ifeq L17 
L13:    iconst_0 
L14:    goto L18 
L17:    iconst_1 
L18:    iastore 
L19:    aload_0 
L20:    iconst_2 
L21:    iconst_1 
L22:    iastore 
L23:    aload_0 
L24:    iconst_4 
L25:    invokestatic [5] 
L28:    ifeq L35 
L31:    iconst_1 
L32:    goto L36 
L35:    iconst_0 
L36:    iastore 
L37:    aload_0 
L38:    iconst_5 
L39:    iconst_0 
L40:    iastore 
L41:    aload_0 
L42:    bipush 6 
L44:    iconst_1 
L45:    iastore 
L46:    aload_0 
L47:    bipush 7 
L49:    invokestatic [4] 
L52:    ifeq L59 
L55:    iconst_2 
L56:    goto L60 
L59:    iconst_0 
L60:    iastore 
L61:    aload_0 
L62:    iconst_0 
L63:    iconst_2 
L64:    iastore 
L65:    aload_0 
L66:    bipush 8 
L68:    invokestatic [5] 
L71:    ifeq L78 
L74:    iconst_1 
L75:    goto L79 
L78:    iconst_0 
L79:    iastore 
L80:    aload_0 
L81:    bipush 9 
L83:    invokestatic [5] 
L86:    ifeq L93 
L89:    iconst_1 
L90:    goto L94 
L93:    iconst_0 
L94:    iastore 
L95:    aload_0 
L96:    areturn 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method protected [132] : [133] 
    .attribute [123] .code stack 3 locals 0 
L0:     aload_1 
L1:     arraylength 
L2:     bipush 10 
L4:     if_icmpeq L11 
L7:     invokestatic [6] 
L10:    astore_1 
L11:    aload_1 
L12:    bipush 6 
L14:    iconst_1 
L15:    iastore 
L16:    invokestatic [7] 
L19:    ifeq L42 
L22:    aload_1 
L23:    iconst_5 
L24:    iconst_0 
L25:    iastore 
L26:    aload_1 
L27:    bipush 7 
L29:    iaload 
L30:    iconst_2 
L31:    if_icmpne L51 
L34:    aload_1 
L35:    bipush 7 
L37:    iconst_0 
L38:    iastore 
L39:    goto L51 
L42:    aload_1 
L43:    bipush 7 
L45:    iconst_2 
L46:    iastore 
L47:    aload_1 
L48:    iconst_1 
L49:    iconst_0 
L50:    iastore 
L51:    invokestatic [8] 
L54:    ifne L61 
L57:    aload_1 
L58:    iconst_0 
L59:    iconst_2 
L60:    iastore 
L61:    invokestatic [9] 
L64:    ifne L77 
L67:    aload_1 
L68:    bipush 8 
L70:    iconst_0 
L71:    iastore 
L72:    aload_1 
L73:    bipush 9 
L75:    iconst_0 
L76:    iastore 
L77:    aload_1 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [24] 
.const [3] = String [25] 
.const [4] = Method [26] [27] 
.const [5] = Method [28] [29] 
.const [6] = Method [30] [31] 
.const [7] = Method [32] [33] 
.const [8] = Method [34] [35] 
.const [9] = Method [36] [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Class [42] 
.const [15] = Class [43] 
.const [16] = Field [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Field [50] [51] 
.const [20] = Field [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Int 167772160 
.const [24] = Utf8 AMFM 
.const [25] = Utf8 '[AMFMSetupHandler#storeSetup], Not storing setup, wrong size (is %1, expected %2)' 
.const [26] = Class [58] 
.const [27] = NameAndType [59] [60] 
.const [28] = Class [61] 
.const [29] = NameAndType [62] [63] 
.const [30] = Class [64] 
.const [31] = NameAndType [65] [66] 
.const [32] = Class [67] 
.const [33] = NameAndType [68] [69] 
.const [34] = Class [70] 
.const [35] = NameAndType [71] [72] 
.const [36] = Class [73] 
.const [37] = NameAndType [74] [75] 
.const [38] = Utf8 de/audi/tuner/app/amfm/AMFMSetupHandler 
.const [39] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [40] = Utf8 de/audi/tuner/app/storage/TunerStorage 
.const [41] = Utf8 de/audi/tuner/app/Logger 
.const [42] = Utf8 de/audi/atip/log/LogChannel 
.const [43] = Utf8 de/audi/tuner/app/Utilities 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Utf8 de/audi/tuner/app/Utilities 
.const [59] = Utf8 isPiIgnore 
.const [60] = Utf8 ()Z 
.const [61] = Utf8 de/audi/tuner/app/Utilities 
.const [62] = Utf8 isHdDefaultOn 
.const [63] = Utf8 ()Z 
.const [64] = Utf8 de/audi/tuner/app/amfm/AMFMSetupHandler 
.const [65] = Utf8 getDefaultSetup 
.const [66] = Utf8 ()[I 
.const [67] = Utf8 de/audi/tuner/app/Utilities 
.const [68] = Utf8 isSinglePiMode 
.const [69] = Utf8 ()Z 
.const [70] = Utf8 de/audi/tuner/app/Utilities 
.const [71] = Utf8 isPGen1OrBentley 
.const [72] = Utf8 ()Z 
.const [73] = Utf8 de/audi/tuner/app/Utilities 
.const [74] = Utf8 isNARBuild 
.const [75] = Utf8 ()Z 
.const [76] = Utf8 de/audi/tuner/app/amfm/AMFMSetupHandler 
.const [77] = Utf8 storage 
.const [78] = Utf8 Lde/audi/tuner/app/storage/TunerStorage; 
.const [79] = Utf8 de/audi/tuner/app/storage/TunerStorage 
.const [80] = Utf8 loadAMFMSetup 
.const [81] = Utf8 ()[I 
.const [82] = Utf8 de/audi/tuner/app/storage/TunerStorage 
.const [83] = Utf8 storeAMFMSetup 
.const [84] = Utf8 ([IZ)V 
.const [85] = Utf8 de/audi/tuner/app/amfm/AMFMSetupHandler 
.const [86] = Utf8 logger 
.const [87] = Utf8 Lde/audi/tuner/app/Logger; 
.const [88] = Utf8 de/audi/tuner/app/Logger 
.const [89] = Utf8 main 
.const [90] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 log 
.const [93] = Utf8 (ILjava/lang/String;JJ)Z 
.const [94] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Ljava/lang/String;Lde/audi/tuner/app/Logger;Lde/audi/tuner/app/storage/TunerStorage;)V 
.const [97] = Utf8 de/audi/tuner/app/amfm/AMFMSetupHandler 
.const [98] = Class [97] 
.const [99] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [100] = Class [99] 
.const [101] = Utf8 AMFM_SETUP_STATION_SORT_AM_INDEX 
.const [102] = Utf8 I 
.const [103] = Utf8 AMFM_SETUP_STATION_TRACE_INDEX 
.const [104] = Utf8 I 
.const [105] = Utf8 AMFM_SETUP_STATION_TRACE_REG_INDEX 
.const [106] = Utf8 I 
.const [107] = Utf8 AMFM_SETUP_RECP_PREF_MODE_INDEX 
.const [108] = Utf8 I 
.const [109] = Utf8 AMFM_SETUP_HD_ON_OFF_INDEX 
.const [110] = Utf8 I 
.const [111] = Utf8 AMFM_SETUP_STATION_NAME_FIXVAR_INDEX 
.const [112] = Utf8 I 
.const [113] = Utf8 AMFM_SETUP_STATION_NAME_ONOFF_INDEX 
.const [114] = Utf8 I 
.const [115] = Utf8 AMFM_SETUP_STATION_SORT_FM_INDEX 
.const [116] = Utf8 I 
.const [117] = Utf8 AMFM_SETUP_HD_ON_OFF_FM_INDEX 
.const [118] = Utf8 I 
.const [119] = Utf8 AMFM_SETUP_HD_ON_OFF_AM_INDEX 
.const [120] = Utf8 I 
.const [121] = Utf8 AMFM_SETUP_SIZE 
.const [122] = Utf8 I 
.const [123] = Utf8 Code 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Lde/audi/tuner/app/Logger;Lde/audi/tuner/app/storage/TunerStorage;)V 
.const [126] = Utf8 loadSetup 
.const [127] = Utf8 ()[I 
.const [128] = Utf8 storeSetup 
.const [129] = Utf8 ([I)V 
.const [130] = Utf8 getDefaultSetup 
.const [131] = Utf8 ()[I 
.const [132] = Utf8 checkSetupByVariant 
.const [133] = Utf8 ([I)[I 
.end class 
