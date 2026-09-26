.version 50 0 
.class public super [85] 
.super [87] 
.field public static final [88] [89] 
.field public static final [90] [91] 
.field public static final [92] [93] 
.field private final [94] [95] 
.field private [96] [97] 

.method public [99] : [100] 
    .attribute [98] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     new [27] 
L8:     dup 
L9:     bipush 20 
L11:    invokespecial [26] 
L14:    putfield [28] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [101] : [102] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [29] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [98] .code stack 3 locals 0 
L0:     iload_1 
L1:     ifeq L18 
L4:     aload_0 
L5:     getfield [19] 
L8:     ldc [3] 
L10:    bipush 42 
L12:    invokevirtual [21] 
L15:    goto L27 
L18:    aload_0 
L19:    getfield [19] 
L22:    ldc [3] 
L24:    invokevirtual [22] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     invokevirtual [23] 
L9:     iconst_m1 
L10:    if_icmpeq L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [98] .code stack 3 locals 0 
L0:     iload_1 
L1:     ifeq L18 
L4:     aload_0 
L5:     getfield [19] 
L8:     ldc [4] 
L10:    bipush 42 
L12:    invokevirtual [21] 
L15:    goto L27 
L18:    aload_0 
L19:    getfield [19] 
L22:    ldc [4] 
L24:    invokevirtual [22] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [98] .code stack 3 locals 0 
L0:     iload_1 
L1:     ifeq L18 
L4:     aload_0 
L5:     getfield [19] 
L8:     ldc [5] 
L10:    bipush 42 
L12:    invokevirtual [21] 
L15:    goto L27 
L18:    aload_0 
L19:    getfield [19] 
L22:    ldc [5] 
L24:    invokevirtual [22] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [98] .code stack 3 locals 0 
L0:     iload_1 
L1:     ifeq L18 
L4:     aload_0 
L5:     getfield [19] 
L8:     ldc [6] 
L10:    bipush 42 
L12:    invokevirtual [21] 
L15:    goto L27 
L18:    aload_0 
L19:    getfield [19] 
L22:    ldc [6] 
L24:    invokevirtual [22] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [98] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [7] 
L6:     invokevirtual [22] 
L9:     aload_0 
L10:    getfield [19] 
L13:    ldc [8] 
L15:    invokevirtual [22] 
L18:    iload_1 
L19:    lookupswitch 
            1 : L69 
            2 : L44 
            default : L83 

L44:    aload_0 
L45:    getfield [19] 
L48:    ldc [8] 
L50:    bipush 42 
L52:    invokevirtual [21] 
L55:    aload_0 
L56:    getfield [19] 
L59:    ldc [7] 
L61:    bipush 42 
L63:    invokevirtual [21] 
L66:    goto L83 
L69:    aload_0 
L70:    getfield [19] 
L73:    ldc [7] 
L75:    bipush 42 
L77:    invokevirtual [21] 
L80:    goto L83 
L83:    return 
L84:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [98] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [9] 
L6:     invokevirtual [22] 
L9:     aload_0 
L10:    getfield [19] 
L13:    ldc [10] 
L15:    invokevirtual [22] 
L18:    iload_1 
L19:    lookupswitch 
            1 : L69 
            2 : L44 
            default : L83 

L44:    aload_0 
L45:    getfield [19] 
L48:    ldc [10] 
L50:    bipush 42 
L52:    invokevirtual [21] 
L55:    aload_0 
L56:    getfield [19] 
L59:    ldc [9] 
L61:    bipush 42 
L63:    invokevirtual [21] 
L66:    goto L83 
L69:    aload_0 
L70:    getfield [19] 
L73:    ldc [9] 
L75:    bipush 42 
L77:    invokevirtual [21] 
L80:    goto L83 
L83:    return 
L84:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [98] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [11] 
L6:     invokevirtual [22] 
L9:     aload_0 
L10:    getfield [19] 
L13:    ldc [12] 
L15:    invokevirtual [22] 
L18:    iload_1 
L19:    lookupswitch 
            1 : L69 
            2 : L44 
            default : L83 

L44:    aload_0 
L45:    getfield [19] 
L48:    ldc [12] 
L50:    bipush 42 
L52:    invokevirtual [21] 
L55:    aload_0 
L56:    getfield [19] 
L59:    ldc [11] 
L61:    bipush 42 
L63:    invokevirtual [21] 
L66:    goto L83 
L69:    aload_0 
L70:    getfield [19] 
L73:    ldc [11] 
L75:    bipush 42 
L77:    invokevirtual [21] 
L80:    goto L83 
L83:    return 
L84:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [98] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [13] 
L6:     invokevirtual [22] 
L9:     aload_0 
L10:    getfield [19] 
L13:    ldc [14] 
L15:    invokevirtual [22] 
L18:    iload_1 
L19:    lookupswitch 
            1 : L69 
            2 : L44 
            default : L83 

L44:    aload_0 
L45:    getfield [19] 
L48:    ldc [14] 
L50:    bipush 42 
L52:    invokevirtual [21] 
L55:    aload_0 
L56:    getfield [19] 
L59:    ldc [13] 
L61:    bipush 42 
L63:    invokevirtual [21] 
L66:    goto L83 
L69:    aload_0 
L70:    getfield [19] 
L73:    ldc [13] 
L75:    bipush 42 
L77:    invokevirtual [21] 
L80:    goto L83 
L83:    return 
L84:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [98] .code stack 3 locals 0 
L0:     iload_1 
L1:     ifeq L18 
L4:     aload_0 
L5:     getfield [19] 
L8:     ldc [15] 
L10:    bipush 42 
L12:    invokevirtual [21] 
L15:    goto L27 
L18:    aload_0 
L19:    getfield [19] 
L22:    ldc [15] 
L24:    invokevirtual [22] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [98] .code stack 3 locals 0 
L0:     iload_1 
L1:     ifeq L18 
L4:     aload_0 
L5:     getfield [19] 
L8:     ldc [16] 
L10:    bipush 42 
L12:    invokevirtual [21] 
L15:    goto L27 
L18:    aload_0 
L19:    getfield [19] 
L22:    ldc [16] 
L24:    invokevirtual [22] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokevirtual [24] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = Int 1283849002 
.const [4] = Int 588765362 
.const [5] = Int 750231414 
.const [6] = Int -506411064 
.const [7] = Int -572310455 
.const [8] = Int 2072125149 
.const [9] = Int -227001526 
.const [10] = Int 1105542723 
.const [11] = Int -742342830 
.const [12] = Int -1147141149 
.const [13] = Int -314225761 
.const [14] = Int 96563711 
.const [15] = Int -1224426877 
.const [16] = Int -1055934063 
.const [17] = Class [31] 
.const [18] = Class [32] 
.const [19] = Field [33] [34] 
.const [20] = Field [35] [36] 
.const [21] = Method [37] [38] 
.const [22] = Method [39] [40] 
.const [23] = Method [41] [42] 
.const [24] = Method [43] [44] 
.const [25] = Method [45] [46] 
.const [26] = Method [47] [48] 
.const [27] = Class [49] 
.const [28] = Field [50] [51] 
.const [29] = Field [52] [53] 
.const [30] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [31] = Utf8 de/audi/app/tuner/RadioRowProperties 
.const [32] = Utf8 java/lang/Object 
.const [33] = Class [54] 
.const [34] = NameAndType [55] [56] 
.const [35] = Class [57] 
.const [36] = NameAndType [58] [59] 
.const [37] = Class [60] 
.const [38] = NameAndType [61] [62] 
.const [39] = Class [63] 
.const [40] = NameAndType [64] [65] 
.const [41] = Class [66] 
.const [42] = NameAndType [67] [68] 
.const [43] = Class [69] 
.const [44] = NameAndType [70] [71] 
.const [45] = Class [72] 
.const [46] = NameAndType [73] [74] 
.const [47] = Class [75] 
.const [48] = NameAndType [76] [77] 
.const [49] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [50] = Class [78] 
.const [51] = NameAndType [79] [80] 
.const [52] = Class [81] 
.const [53] = NameAndType [82] [83] 
.const [54] = Utf8 de/audi/app/tuner/RadioRowProperties 
.const [55] = Utf8 props 
.const [56] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [57] = Utf8 de/audi/app/tuner/RadioRowProperties 
.const [58] = Utf8 category 
.const [59] = Utf8 I 
.const [60] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [61] = Utf8 add 
.const [62] = Utf8 (II)V 
.const [63] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [64] = Utf8 remove 
.const [65] = Utf8 (I)V 
.const [66] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [67] = Utf8 get 
.const [68] = Utf8 (I)I 
.const [69] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [70] = Utf8 getKeys 
.const [71] = Utf8 ()[I 
.const [72] = Utf8 java/lang/Object 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (I)V 
.const [78] = Utf8 de/audi/app/tuner/RadioRowProperties 
.const [79] = Utf8 props 
.const [80] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [81] = Utf8 de/audi/app/tuner/RadioRowProperties 
.const [82] = Utf8 category 
.const [83] = Utf8 I 
.const [84] = Utf8 de/audi/app/tuner/RadioRowProperties 
.const [85] = Class [84] 
.const [86] = Utf8 java/lang/Object 
.const [87] = Class [86] 
.const [88] = Utf8 SEEK_POSSIBILITY_NO 
.const [89] = Utf8 I 
.const [90] = Utf8 SEEK_POSSIBILITY_YES 
.const [91] = Utf8 I 
.const [92] = Utf8 SEEK_POSSIBILITY_ALREADY 
.const [93] = Utf8 I 
.const [94] = Utf8 props 
.const [95] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [96] = Utf8 category 
.const [97] = Utf8 I 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 getCategory 
.const [102] = Utf8 ()I 
.const [103] = Utf8 setCategory 
.const [104] = Utf8 (I)V 
.const [105] = Utf8 setActive 
.const [106] = Utf8 (Z)V 
.const [107] = Utf8 isActive 
.const [108] = Utf8 ()Z 
.const [109] = Utf8 setNoRadioText 
.const [110] = Utf8 (Z)V 
.const [111] = Utf8 setScrollingPS 
.const [112] = Utf8 (Z)V 
.const [113] = Utf8 setTaggingInfosAvailable 
.const [114] = Utf8 (Z)V 
.const [115] = Utf8 setSongSeekPossible 
.const [116] = Utf8 (I)V 
.const [117] = Utf8 setArtistSeekPossible 
.const [118] = Utf8 (I)V 
.const [119] = Utf8 setTeam1SeekPossible 
.const [120] = Utf8 (I)V 
.const [121] = Utf8 setTeam2SeekPossible 
.const [122] = Utf8 (I)V 
.const [123] = Utf8 setNoSlideShow 
.const [124] = Utf8 (Z)V 
.const [125] = Utf8 setNameFreezed 
.const [126] = Utf8 (Z)V 
.const [127] = Utf8 toArray 
.const [128] = Utf8 ()[I 
.end class 
