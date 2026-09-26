.version 50 0 
.class super [118] 
.super [120] 
.field [121] [122] 
.field private final [123] [124] 

.method public [126] : [127] 
    .attribute [125] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     new [22] 
L8:     dup 
L9:     bipush 10 
L11:    invokespecial [21] 
L14:    putfield [23] 
L17:    aload_0 
L18:    aload_1 
L19:    putfield [24] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method [128] : [129] 
    .attribute [125] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_1 
L9:     invokevirtual [16] 
L12:    pop 
L13:    aload_0 
L14:    getfield [14] 
L17:    aload_1 
L18:    invokeinterface [25] 0 
L23:    pop 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method [130] : [131] 
    .attribute [125] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [3] 
L6:     ldc [5] 
L8:     invokevirtual [17] 
L11:    pop 
L12:    aload_0 
L13:    getfield [14] 
L16:    invokeinterface [26] 0 
L21:    ifne L57 
L24:    aload_0 
L25:    getfield [14] 
L28:    iconst_0 
L29:    invokeinterface [27] 0 
L34:    checkcast [6] 
L37:    astore_1 
L38:    aload_0 
L39:    getfield [15] 
L42:    ldc [3] 
L44:    ldc [7] 
L46:    aload_1 
L47:    getfield [18] 
L50:    i2l 
L51:    invokevirtual [19] 
L54:    pop 
L55:    aload_1 
L56:    areturn 
L57:    aconst_null 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method [132] : [133] 
    .attribute [125] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [3] 
L6:     ldc [8] 
L8:     invokevirtual [17] 
L11:    pop 
L12:    aload_0 
L13:    getfield [14] 
L16:    invokeinterface [26] 0 
L21:    ifne L38 
L24:    aload_0 
L25:    getfield [14] 
L28:    iconst_0 
L29:    invokeinterface [28] 0 
L34:    checkcast [6] 
L37:    areturn 
L38:    aconst_null 
L39:    areturn 
L40:    
    .end code 
.end method 

.method [134] : [135] 
    .attribute [125] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [3] 
L6:     ldc [9] 
L8:     invokevirtual [17] 
L11:    pop 
L12:    aload_0 
L13:    getfield [14] 
L16:    invokeinterface [29] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = Int -2137614336 
.const [4] = String [31] 
.const [5] = String [32] 
.const [6] = Class [33] 
.const [7] = String [34] 
.const [8] = String [35] 
.const [9] = String [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Class [39] 
.const [13] = Class [40] 
.const [14] = Field [41] [42] 
.const [15] = Field [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Class [57] 
.const [23] = Field [58] [59] 
.const [24] = Field [60] [61] 
.const [25] = InterfaceMethod [62] [63] 
.const [26] = InterfaceMethod [64] [65] 
.const [27] = InterfaceMethod [66] [67] 
.const [28] = InterfaceMethod [68] [69] 
.const [29] = InterfaceMethod [70] [71] 
.const [30] = Utf8 java/util/ArrayList 
.const [31] = Utf8 'WavePlayerMaster.RequestQueue.add(%1) called' 
.const [32] = Utf8 'WavePlayerMaster.RequestQueue.get() called' 
.const [33] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster$Request 
.const [34] = Utf8 'WavePlayerMaster.RequestQueue.get() request.id: %1' 
.const [35] = Utf8 'WavePlayerMaster.RequestQueue.remove() called' 
.const [36] = Utf8 'WavePlayerMaster.RequestQueue.clear() called' 
.const [37] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster$RequestQueue 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 de/audi/atip/log/LogChannel 
.const [40] = Utf8 java/util/List 
.const [41] = Class [72] 
.const [42] = NameAndType [73] [74] 
.const [43] = Class [75] 
.const [44] = NameAndType [76] [77] 
.const [45] = Class [78] 
.const [46] = NameAndType [79] [80] 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Class [84] 
.const [50] = NameAndType [85] [86] 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Class [90] 
.const [54] = NameAndType [91] [92] 
.const [55] = Class [93] 
.const [56] = NameAndType [94] [95] 
.const [57] = Utf8 java/util/ArrayList 
.const [58] = Class [96] 
.const [59] = NameAndType [97] [98] 
.const [60] = Class [99] 
.const [61] = NameAndType [100] [101] 
.const [62] = Class [102] 
.const [63] = NameAndType [103] [104] 
.const [64] = Class [105] 
.const [65] = NameAndType [106] [107] 
.const [66] = Class [108] 
.const [67] = NameAndType [109] [110] 
.const [68] = Class [111] 
.const [69] = NameAndType [112] [113] 
.const [70] = Class [114] 
.const [71] = NameAndType [115] [116] 
.const [72] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster$RequestQueue 
.const [73] = Utf8 list 
.const [74] = Utf8 Ljava/util/List; 
.const [75] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster$RequestQueue 
.const [76] = Utf8 lc 
.const [77] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 log 
.const [80] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [81] = Utf8 de/audi/atip/log/LogChannel 
.const [82] = Utf8 log 
.const [83] = Utf8 (ILjava/lang/String;)Z 
.const [84] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster$Request 
.const [85] = Utf8 id 
.const [86] = Utf8 I 
.const [87] = Utf8 de/audi/atip/log/LogChannel 
.const [88] = Utf8 log 
.const [89] = Utf8 (ILjava/lang/String;J)Z 
.const [90] = Utf8 java/lang/Object 
.const [91] = Utf8 <init> 
.const [92] = Utf8 ()V 
.const [93] = Utf8 java/util/ArrayList 
.const [94] = Utf8 <init> 
.const [95] = Utf8 (I)V 
.const [96] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster$RequestQueue 
.const [97] = Utf8 list 
.const [98] = Utf8 Ljava/util/List; 
.const [99] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster$RequestQueue 
.const [100] = Utf8 lc 
.const [101] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [102] = Utf8 java/util/List 
.const [103] = Utf8 add 
.const [104] = Utf8 (Ljava/lang/Object;)Z 
.const [105] = Utf8 java/util/List 
.const [106] = Utf8 isEmpty 
.const [107] = Utf8 ()Z 
.const [108] = Utf8 java/util/List 
.const [109] = Utf8 get 
.const [110] = Utf8 (I)Ljava/lang/Object; 
.const [111] = Utf8 java/util/List 
.const [112] = Utf8 remove 
.const [113] = Utf8 (I)Ljava/lang/Object; 
.const [114] = Utf8 java/util/List 
.const [115] = Utf8 clear 
.const [116] = Utf8 ()V 
.const [117] = Utf8 de/audi/tghu/waveplayer/WavePlayerMaster$RequestQueue 
.const [118] = Class [117] 
.const [119] = Utf8 java/lang/Object 
.const [120] = Class [119] 
.const [121] = Utf8 lc 
.const [122] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [123] = Utf8 list 
.const [124] = Utf8 Ljava/util/List; 
.const [125] = Utf8 Code 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [128] = Utf8 add 
.const [129] = Utf8 (Lde/audi/tghu/waveplayer/WavePlayerMaster$Request;)V 
.const [130] = Utf8 get 
.const [131] = Utf8 ()Lde/audi/tghu/waveplayer/WavePlayerMaster$Request; 
.const [132] = Utf8 remove 
.const [133] = Utf8 ()Lde/audi/tghu/waveplayer/WavePlayerMaster$Request; 
.const [134] = Utf8 clear 
.const [135] = Utf8 ()V 
.end class 
