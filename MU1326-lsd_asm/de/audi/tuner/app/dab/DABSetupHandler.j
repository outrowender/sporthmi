.version 50 0 
.class public super [74] 
.super [76] 
.field static final [77] [78] 
.field static final [79] [80] 
.field static final [81] [82] 
.field public static final [83] [84] 
.field private static final [85] [86] 

.method [88] : [89] 
    .attribute [87] .code stack 4 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     aload_1 
L4:     aload_2 
L5:     invokespecial [18] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [90] : [91] 
    .attribute [87] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [13] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [92] : [93] 
    .attribute [87] .code stack 7 locals 0 
L0:     aload_1 
L1:     arraylength 
L2:     iconst_4 
L3:     if_icmpne L18 
L6:     aload_0 
L7:     getfield [12] 
L10:    aload_1 
L11:    iconst_1 
L12:    invokevirtual [14] 
L15:    goto L40 
L18:    aload_0 
L19:    getfield [15] 
L22:    getfield [16] 
L25:    sipush 10000 
L28:    ldc [3] 
L30:    aload_1 
L31:    arraylength 
L32:    i2l 
L33:    ldc_w [1] 
L36:    invokevirtual [17] 
L39:    pop 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [94] : [95] 
    .attribute [87] .code stack 4 locals 1 
L0:     iconst_4 
L1:     newarray int 
L3:     astore_0 
L4:     aload_0 
L5:     iconst_0 
L6:     invokestatic [4] 
L9:     iconst_3 
L10:    if_icmpne L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    iastore 
L19:    aload_0 
L20:    iconst_1 
L21:    iconst_1 
L22:    iastore 
L23:    aload_0 
L24:    iconst_2 
L25:    invokestatic [5] 
L28:    ifeq L35 
L31:    iconst_0 
L32:    goto L36 
L35:    iconst_1 
L36:    iastore 
L37:    aload_0 
L38:    iconst_3 
L39:    iconst_0 
L40:    iastore 
L41:    aload_0 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method protected [96] : [97] 
    .attribute [87] .code stack 3 locals 0 
L0:     invokestatic [4] 
L3:     iconst_3 
L4:     if_icmpne L11 
L7:     aload_1 
L8:     iconst_0 
L9:     iconst_1 
L10:    iastore 
L11:    aload_1 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [20] 
.const [3] = String [21] 
.const [4] = Method [22] [23] 
.const [5] = Method [24] [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Class [30] 
.const [11] = Class [31] 
.const [12] = Field [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Field [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Int 67108864 
.const [20] = Utf8 DAB 
.const [21] = Utf8 '[DABSetupHandler#storeSetup], Not storing setup, wrong size (is %1, expected %2)' 
.const [22] = Class [46] 
.const [23] = NameAndType [47] [48] 
.const [24] = Class [49] 
.const [25] = NameAndType [50] [51] 
.const [26] = Utf8 de/audi/tuner/app/dab/DABSetupHandler 
.const [27] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [28] = Utf8 de/audi/tuner/app/storage/TunerStorage 
.const [29] = Utf8 de/audi/tuner/app/Logger 
.const [30] = Utf8 de/audi/atip/log/LogChannel 
.const [31] = Utf8 de/audi/tuner/app/Utilities 
.const [32] = Class [52] 
.const [33] = NameAndType [53] [54] 
.const [34] = Class [55] 
.const [35] = NameAndType [56] [57] 
.const [36] = Class [58] 
.const [37] = NameAndType [59] [60] 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Class [64] 
.const [41] = NameAndType [65] [66] 
.const [42] = Class [67] 
.const [43] = NameAndType [68] [69] 
.const [44] = Class [70] 
.const [45] = NameAndType [71] [72] 
.const [46] = Utf8 de/audi/tuner/app/Utilities 
.const [47] = Utf8 getDAB1Bandsetting 
.const [48] = Utf8 ()B 
.const [49] = Utf8 de/audi/tuner/app/Utilities 
.const [50] = Utf8 isPGen1OrBentley 
.const [51] = Utf8 ()Z 
.const [52] = Utf8 de/audi/tuner/app/dab/DABSetupHandler 
.const [53] = Utf8 storage 
.const [54] = Utf8 Lde/audi/tuner/app/storage/TunerStorage; 
.const [55] = Utf8 de/audi/tuner/app/storage/TunerStorage 
.const [56] = Utf8 loadDABSetup 
.const [57] = Utf8 ()[I 
.const [58] = Utf8 de/audi/tuner/app/storage/TunerStorage 
.const [59] = Utf8 storeDABSetup 
.const [60] = Utf8 ([IZ)V 
.const [61] = Utf8 de/audi/tuner/app/dab/DABSetupHandler 
.const [62] = Utf8 logger 
.const [63] = Utf8 Lde/audi/tuner/app/Logger; 
.const [64] = Utf8 de/audi/tuner/app/Logger 
.const [65] = Utf8 main 
.const [66] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 log 
.const [69] = Utf8 (ILjava/lang/String;JJ)Z 
.const [70] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (Ljava/lang/String;Lde/audi/tuner/app/Logger;Lde/audi/tuner/app/storage/TunerStorage;)V 
.const [73] = Utf8 de/audi/tuner/app/dab/DABSetupHandler 
.const [74] = Class [73] 
.const [75] = Utf8 de/audi/tuner/app/AbstractSetupHandler 
.const [76] = Class [75] 
.const [77] = Utf8 DAB_SETUP_LBAND_INDEX 
.const [78] = Utf8 I 
.const [79] = Utf8 DAB_SETUP_STATION_TRACE_INDEX 
.const [80] = Utf8 I 
.const [81] = Utf8 DAB_SETUP_STATION_SORT_INDEX 
.const [82] = Utf8 I 
.const [83] = Utf8 DAB_SETUP_STATION_TRACE_REGIONAL_INDEX 
.const [84] = Utf8 I 
.const [85] = Utf8 DAB_SETUP_SIZE 
.const [86] = Utf8 I 
.const [87] = Utf8 Code 
.const [88] = Utf8 <init> 
.const [89] = Utf8 (Lde/audi/tuner/app/Logger;Lde/audi/tuner/app/storage/TunerStorage;)V 
.const [90] = Utf8 loadSetup 
.const [91] = Utf8 ()[I 
.const [92] = Utf8 storeSetup 
.const [93] = Utf8 ([I)V 
.const [94] = Utf8 getDefaultSetup 
.const [95] = Utf8 ()[I 
.const [96] = Utf8 checkSetupByVariant 
.const [97] = Utf8 ([I)[I 
.end class 
