.version 50 0 
.class public super [81] 
.super [83] 
.field public [84] [85] 

.method public annotation [87] : [88] 
    .attribute [86] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [89] : [90] 
    .attribute [86] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [14] 
L5:     aload_0 
L6:     getfield [8] 
L9:     ifnull L44 
L12:    aload_1 
L13:    aload_0 
L14:    getfield [8] 
L17:    arraylength 
L18:    newarray short 
L20:    putfield [16] 
L23:    aload_0 
L24:    getfield [8] 
L27:    iconst_0 
L28:    aload_1 
L29:    getfield [8] 
L32:    iconst_0 
L33:    aload_0 
L34:    getfield [8] 
L37:    arraylength 
L38:    invokestatic [2] 
L41:    goto L49 
L44:    aload_1 
L45:    aconst_null 
L46:    putfield [16] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [86] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [16] 
L5:     aload_0 
L6:     iconst_1 
L7:     putfield [17] 
L10:    aload_0 
L11:    iconst_1 
L12:    invokevirtual [9] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [86] .code stack 3 locals 2 
L0:     new [18] 
L3:     dup 
L4:     ldc [4] 
L6:     invokespecial [15] 
L9:     astore_1 
L10:    aload_0 
L11:    getfield [8] 
L14:    ifnull L50 
L17:    iconst_0 
L18:    istore_2 
L19:    iload_2 
L20:    aload_0 
L21:    getfield [8] 
L24:    arraylength 
L25:    if_icmpge L50 
L28:    aload_1 
L29:    aload_0 
L30:    getfield [8] 
L33:    iload_2 
L34:    saload 
L35:    invokevirtual [10] 
L38:    bipush 32 
L40:    invokevirtual [11] 
L43:    pop 
L44:    iinc 2 1 
L47:    goto L19 
L50:    aload_1 
L51:    bipush 93 
L53:    invokevirtual [11] 
L56:    pop 
L57:    aload_1 
L58:    invokevirtual [12] 
L61:    areturn 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [19] [20] 
.const [3] = Class [21] 
.const [4] = String [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Field [26] [27] 
.const [9] = Method [28] [29] 
.const [10] = Method [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Field [42] [43] 
.const [17] = Field [44] [45] 
.const [18] = Class [46] 
.const [19] = Class [47] 
.const [20] = NameAndType [48] [49] 
.const [21] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [22] = Utf8 'stream: [' 
.const [23] = Utf8 de/audi/atip/hmi/combi/CombiRGIElement 
.const [24] = Utf8 de/audi/atip/hmi/combi/AbstractCombiElement 
.const [25] = Utf8 java/lang/System 
.const [26] = Class [50] 
.const [27] = NameAndType [51] [52] 
.const [28] = Class [53] 
.const [29] = NameAndType [54] [55] 
.const [30] = Class [56] 
.const [31] = NameAndType [57] [58] 
.const [32] = Class [59] 
.const [33] = NameAndType [60] [61] 
.const [34] = Class [62] 
.const [35] = NameAndType [63] [64] 
.const [36] = Class [65] 
.const [37] = NameAndType [66] [67] 
.const [38] = Class [68] 
.const [39] = NameAndType [69] [70] 
.const [40] = Class [71] 
.const [41] = NameAndType [72] [73] 
.const [42] = Class [74] 
.const [43] = NameAndType [75] [76] 
.const [44] = Class [77] 
.const [45] = NameAndType [78] [79] 
.const [46] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [47] = Utf8 java/lang/System 
.const [48] = Utf8 arraycopy 
.const [49] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [50] = Utf8 de/audi/atip/hmi/combi/CombiRGIElement 
.const [51] = Utf8 rgiStream 
.const [52] = Utf8 [S 
.const [53] = Utf8 de/audi/atip/hmi/combi/CombiRGIElement 
.const [54] = Utf8 setMergingAllowed 
.const [55] = Utf8 (Z)V 
.const [56] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [57] = Utf8 append 
.const [58] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [59] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [60] = Utf8 append 
.const [61] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [62] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [63] = Utf8 toString 
.const [64] = Utf8 ()Ljava/lang/String; 
.const [65] = Utf8 de/audi/atip/hmi/combi/AbstractCombiElement 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/audi/atip/hmi/combi/AbstractCombiElement 
.const [69] = Utf8 copyTo 
.const [70] = Utf8 (Lde/audi/atip/hmi/combi/AbstractCombiElement;)V 
.const [71] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [72] = Utf8 <init> 
.const [73] = Utf8 (Ljava/lang/String;)V 
.const [74] = Utf8 de/audi/atip/hmi/combi/CombiRGIElement 
.const [75] = Utf8 rgiStream 
.const [76] = Utf8 [S 
.const [77] = Utf8 de/audi/atip/hmi/combi/CombiRGIElement 
.const [78] = Utf8 dirty 
.const [79] = Utf8 Z 
.const [80] = Utf8 de/audi/atip/hmi/combi/CombiRGIElement 
.const [81] = Class [80] 
.const [82] = Utf8 de/audi/atip/hmi/combi/AbstractCombiElement 
.const [83] = Class [82] 
.const [84] = Utf8 rgiStream 
.const [85] = Utf8 [S 
.const [86] = Utf8 Code 
.const [87] = Utf8 <init> 
.const [88] = Utf8 ()V 
.const [89] = Utf8 copyTo 
.const [90] = Utf8 (Lde/audi/atip/hmi/combi/CombiRGIElement;)V 
.const [91] = Utf8 reset 
.const [92] = Utf8 ()V 
.const [93] = Utf8 toString 
.const [94] = Utf8 ()Ljava/lang/String; 
.end class 
