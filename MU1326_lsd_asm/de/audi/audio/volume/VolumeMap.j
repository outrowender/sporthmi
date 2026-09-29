.version 50 0 
.class public final super [105] 
.super [107] 
.field public static final [108] [109] 
.field private final [110] [111] 
.field private final [112] [113] 
.field private final [114] [115] 
.field private final [116] [117] 

.method private [119] : [120] 
    .attribute [118] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     aload_0 
L5:     new [16] 
L8:     dup 
L9:     bipush 100 
L11:    invokespecial [12] 
L14:    putfield [17] 
L17:    aload_0 
L18:    new [16] 
L21:    dup 
L22:    bipush 100 
L24:    invokespecial [12] 
L27:    putfield [18] 
L30:    aload_0 
L31:    new [16] 
L34:    dup 
L35:    bipush 100 
L37:    invokespecial [12] 
L40:    putfield [19] 
L43:    aload_0 
L44:    new [20] 
L47:    dup 
L48:    invokespecial [11] 
L51:    putfield [21] 
L54:    aload_0 
L55:    getfield [5] 
L58:    bipush 8 
L60:    iconst_0 
L61:    invokevirtual [9] 
L64:    aload_0 
L65:    getfield [6] 
L68:    bipush 8 
L70:    iconst_0 
L71:    invokevirtual [9] 
L74:    aload_0 
L75:    getfield [7] 
L78:    bipush 8 
L80:    iconst_0 
L81:    invokevirtual [9] 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [118] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [8] 
L4:     dup 
L5:     astore 4 
L7:     monitorenter 
        .catch [0] from L8 to L21 using L24 
L8:     aload_0 
L9:     iload_2 
L10:    invokespecial [13] 
L13:    iload_1 
L14:    iload_3 
L15:    invokevirtual [9] 
L18:    aload 4 
L20:    monitorexit 
L21:    goto L32 
        .catch [0] from L24 to L29 using L24 
L24:    astore 5 
L26:    aload 4 
L28:    monitorexit 
L29:    aload 5 
L31:    athrow 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [118] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [8] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L18 using L19 
L7:     aload_0 
L8:     iload_1 
L9:     invokespecial [13] 
L12:    iload_2 
L13:    invokevirtual [10] 
L16:    aload_3 
L17:    monitorexit 
L18:    areturn 
        .catch [0] from L19 to L23 using L19 
L19:    astore 4 
L21:    aload_3 
L22:    monitorexit 
L23:    aload 4 
L25:    athrow 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [125] : [126] 
    .attribute [118] .code stack 1 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            3 : L28 
            4 : L33 
            default : L38 

L28:    aload_0 
L29:    getfield [6] 
L32:    areturn 
L33:    aload_0 
L34:    getfield [7] 
L37:    areturn 
L38:    aload_0 
L39:    getfield [5] 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method static [127] : [128] 
    .attribute [118] .code stack 2 locals 0 
L0:     new [22] 
L3:     dup 
L4:     invokespecial [14] 
L7:     putstatic [15] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = Class [24] 
.const [4] = Class [25] 
.const [5] = Field [26] [27] 
.const [6] = Field [28] [29] 
.const [7] = Field [30] [31] 
.const [8] = Field [32] [33] 
.const [9] = Method [34] [35] 
.const [10] = Method [36] [37] 
.const [11] = Method [38] [39] 
.const [12] = Method [40] [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Field [46] [47] 
.const [16] = Class [48] 
.const [17] = Field [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Class [55] 
.const [21] = Field [56] [57] 
.const [22] = Class [58] 
.const [23] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [24] = Utf8 java/lang/Object 
.const [25] = Utf8 de/audi/audio/volume/VolumeMap 
.const [26] = Class [59] 
.const [27] = NameAndType [60] [61] 
.const [28] = Class [62] 
.const [29] = NameAndType [63] [64] 
.const [30] = Class [65] 
.const [31] = NameAndType [66] [67] 
.const [32] = Class [68] 
.const [33] = NameAndType [69] [70] 
.const [34] = Class [71] 
.const [35] = NameAndType [72] [73] 
.const [36] = Class [74] 
.const [37] = NameAndType [75] [76] 
.const [38] = Class [77] 
.const [39] = NameAndType [78] [79] 
.const [40] = Class [80] 
.const [41] = NameAndType [81] [82] 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Class [89] 
.const [47] = NameAndType [90] [91] 
.const [48] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [49] = Class [92] 
.const [50] = NameAndType [93] [94] 
.const [51] = Class [95] 
.const [52] = NameAndType [96] [97] 
.const [53] = Class [98] 
.const [54] = NameAndType [99] [100] 
.const [55] = Utf8 java/lang/Object 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Utf8 de/audi/audio/volume/VolumeMap 
.const [59] = Utf8 de/audi/audio/volume/VolumeMap 
.const [60] = Utf8 frontMap 
.const [61] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [62] = Utf8 de/audi/audio/volume/VolumeMap 
.const [63] = Utf8 rearLeftMap 
.const [64] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [65] = Utf8 de/audi/audio/volume/VolumeMap 
.const [66] = Utf8 rearRightMap 
.const [67] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [68] = Utf8 de/audi/audio/volume/VolumeMap 
.const [69] = Utf8 mutex 
.const [70] = Utf8 Ljava/lang/Object; 
.const [71] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [72] = Utf8 add 
.const [73] = Utf8 (II)V 
.const [74] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [75] = Utf8 get 
.const [76] = Utf8 (I)I 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 de/esolutions/fw/util/commons/SimpleIntIntMap 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (I)V 
.const [83] = Utf8 de/audi/audio/volume/VolumeMap 
.const [84] = Utf8 getMapByAT 
.const [85] = Utf8 (I)Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [86] = Utf8 de/audi/audio/volume/VolumeMap 
.const [87] = Utf8 <init> 
.const [88] = Utf8 ()V 
.const [89] = Utf8 de/audi/audio/volume/VolumeMap 
.const [90] = Utf8 INSTANCE 
.const [91] = Utf8 Lde/audi/audio/volume/VolumeMap; 
.const [92] = Utf8 de/audi/audio/volume/VolumeMap 
.const [93] = Utf8 frontMap 
.const [94] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [95] = Utf8 de/audi/audio/volume/VolumeMap 
.const [96] = Utf8 rearLeftMap 
.const [97] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [98] = Utf8 de/audi/audio/volume/VolumeMap 
.const [99] = Utf8 rearRightMap 
.const [100] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [101] = Utf8 de/audi/audio/volume/VolumeMap 
.const [102] = Utf8 mutex 
.const [103] = Utf8 Ljava/lang/Object; 
.const [104] = Utf8 de/audi/audio/volume/VolumeMap 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Object 
.const [107] = Class [106] 
.const [108] = Utf8 INSTANCE 
.const [109] = Utf8 Lde/audi/audio/volume/VolumeMap; 
.const [110] = Utf8 frontMap 
.const [111] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [112] = Utf8 rearLeftMap 
.const [113] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [114] = Utf8 rearRightMap 
.const [115] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [116] = Utf8 mutex 
.const [117] = Utf8 Ljava/lang/Object; 
.const [118] = Utf8 Code 
.const [119] = Utf8 <init> 
.const [120] = Utf8 ()V 
.const [121] = Utf8 setVolume 
.const [122] = Utf8 (III)V 
.const [123] = Utf8 getVolume 
.const [124] = Utf8 (II)I 
.const [125] = Utf8 getMapByAT 
.const [126] = Utf8 (I)Lde/esolutions/fw/util/commons/SimpleIntIntMap; 
.const [127] = Utf8 <clinit> 
.const [128] = Utf8 ()V 
.end class 
