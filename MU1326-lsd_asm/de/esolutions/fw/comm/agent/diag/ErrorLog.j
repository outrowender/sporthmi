.version 50 0 
.class public super [97] 
.super [99] 
.field private final [100] [101] 
.field private final [102] [103] 
.field private [104] [105] 

.method public [107] : [108] 
    .attribute [106] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [17] 
L9:     aload_0 
L10:    new [18] 
L13:    dup 
L14:    invokespecial [16] 
L17:    putfield [19] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [109] : [110] 
    .attribute [106] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [8] 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [20] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [111] : [112] 
    .attribute [106] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_1 
L5:     invokevirtual [10] 
L8:     pop 
L9:     aload_0 
L10:    getfield [7] 
L13:    invokevirtual [11] 
L16:    aload_0 
L17:    getfield [6] 
L20:    if_icmple L45 
L23:    aload_0 
L24:    getfield [7] 
L27:    iconst_0 
L28:    invokevirtual [12] 
L31:    pop 
L32:    aload_0 
L33:    dup 
L34:    getfield [9] 
L37:    iconst_1 
L38:    iadd 
L39:    putfield [20] 
L42:    goto L9 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public synchronized [113] : [114] 
    .attribute [106] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [115] : [116] 
    .attribute [106] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [13] 
L7:     ifeq L12 
L10:    aconst_null 
L11:    areturn 
L12:    aload_0 
L13:    getfield [7] 
L16:    invokevirtual [11] 
L19:    anewarray [3] 
L22:    astore_1 
L23:    aload_0 
L24:    getfield [7] 
L27:    aload_1 
L28:    invokevirtual [14] 
L31:    pop 
L32:    aload_1 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = Class [23] 
.const [5] = Class [24] 
.const [6] = Field [25] [26] 
.const [7] = Field [27] [28] 
.const [8] = Method [29] [30] 
.const [9] = Field [31] [32] 
.const [10] = Method [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Field [47] [48] 
.const [18] = Class [49] 
.const [19] = Field [50] [51] 
.const [20] = Field [52] [53] 
.const [21] = Utf8 java/util/ArrayList 
.const [22] = Utf8 de/esolutions/fw/comm/agent/diag/IInfoBase 
.const [23] = Utf8 de/esolutions/fw/comm/agent/diag/ErrorLog 
.const [24] = Utf8 java/lang/Object 
.const [25] = Class [54] 
.const [26] = NameAndType [55] [56] 
.const [27] = Class [57] 
.const [28] = NameAndType [58] [59] 
.const [29] = Class [60] 
.const [30] = NameAndType [61] [62] 
.const [31] = Class [63] 
.const [32] = NameAndType [64] [65] 
.const [33] = Class [66] 
.const [34] = NameAndType [67] [68] 
.const [35] = Class [69] 
.const [36] = NameAndType [70] [71] 
.const [37] = Class [72] 
.const [38] = NameAndType [73] [74] 
.const [39] = Class [75] 
.const [40] = NameAndType [76] [77] 
.const [41] = Class [78] 
.const [42] = NameAndType [79] [80] 
.const [43] = Class [81] 
.const [44] = NameAndType [82] [83] 
.const [45] = Class [84] 
.const [46] = NameAndType [85] [86] 
.const [47] = Class [87] 
.const [48] = NameAndType [88] [89] 
.const [49] = Utf8 java/util/ArrayList 
.const [50] = Class [90] 
.const [51] = NameAndType [91] [92] 
.const [52] = Class [93] 
.const [53] = NameAndType [94] [95] 
.const [54] = Utf8 de/esolutions/fw/comm/agent/diag/ErrorLog 
.const [55] = Utf8 maxSize 
.const [56] = Utf8 I 
.const [57] = Utf8 de/esolutions/fw/comm/agent/diag/ErrorLog 
.const [58] = Utf8 entries 
.const [59] = Utf8 Ljava/util/ArrayList; 
.const [60] = Utf8 java/util/ArrayList 
.const [61] = Utf8 clear 
.const [62] = Utf8 ()V 
.const [63] = Utf8 de/esolutions/fw/comm/agent/diag/ErrorLog 
.const [64] = Utf8 numDropped 
.const [65] = Utf8 I 
.const [66] = Utf8 java/util/ArrayList 
.const [67] = Utf8 add 
.const [68] = Utf8 (Ljava/lang/Object;)Z 
.const [69] = Utf8 java/util/ArrayList 
.const [70] = Utf8 size 
.const [71] = Utf8 ()I 
.const [72] = Utf8 java/util/ArrayList 
.const [73] = Utf8 remove 
.const [74] = Utf8 (I)Ljava/lang/Object; 
.const [75] = Utf8 java/util/ArrayList 
.const [76] = Utf8 isEmpty 
.const [77] = Utf8 ()Z 
.const [78] = Utf8 java/util/ArrayList 
.const [79] = Utf8 toArray 
.const [80] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [81] = Utf8 java/lang/Object 
.const [82] = Utf8 <init> 
.const [83] = Utf8 ()V 
.const [84] = Utf8 java/util/ArrayList 
.const [85] = Utf8 <init> 
.const [86] = Utf8 ()V 
.const [87] = Utf8 de/esolutions/fw/comm/agent/diag/ErrorLog 
.const [88] = Utf8 maxSize 
.const [89] = Utf8 I 
.const [90] = Utf8 de/esolutions/fw/comm/agent/diag/ErrorLog 
.const [91] = Utf8 entries 
.const [92] = Utf8 Ljava/util/ArrayList; 
.const [93] = Utf8 de/esolutions/fw/comm/agent/diag/ErrorLog 
.const [94] = Utf8 numDropped 
.const [95] = Utf8 I 
.const [96] = Utf8 de/esolutions/fw/comm/agent/diag/ErrorLog 
.const [97] = Class [96] 
.const [98] = Utf8 java/lang/Object 
.const [99] = Class [98] 
.const [100] = Utf8 maxSize 
.const [101] = Utf8 I 
.const [102] = Utf8 entries 
.const [103] = Utf8 Ljava/util/ArrayList; 
.const [104] = Utf8 numDropped 
.const [105] = Utf8 I 
.const [106] = Utf8 Code 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (I)V 
.const [109] = Utf8 clear 
.const [110] = Utf8 ()V 
.const [111] = Utf8 add 
.const [112] = Utf8 (Lde/esolutions/fw/comm/agent/diag/IInfoBase;)V 
.const [113] = Utf8 getNumDropped 
.const [114] = Utf8 ()I 
.const [115] = Utf8 getAllEntries 
.const [116] = Utf8 ()[Lde/esolutions/fw/comm/agent/diag/IInfoBase; 
.end class 
