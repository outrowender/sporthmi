.version 50 0 
.class public super [91] 
.super [93] 
.field private final [94] [95] 
.field private static final [96] [97] 

.method public [99] : [100] 
    .attribute [98] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     new [18] 
L8:     dup 
L9:     invokespecial [15] 
L12:    putfield [19] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [98] .code stack 5 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iinc 2 1 
L5:     aload_0 
L6:     iload_2 
L7:     invokevirtual [8] 
L10:    ifne L2 
L13:    aload_0 
L14:    getfield [7] 
L17:    new [20] 
L20:    dup 
L21:    iload_2 
L22:    invokespecial [16] 
L25:    new [21] 
L28:    dup 
L29:    iload_1 
L30:    invokespecial [17] 
L33:    invokevirtual [9] 
L36:    pop 
L37:    iload_2 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [98] .code stack 4 locals 1 
L0:     iconst_m1 
L1:     istore_2 
L2:     aload_0 
L3:     iload_1 
L4:     invokevirtual [8] 
L7:     ifeq L32 
L10:    aload_0 
L11:    getfield [7] 
L14:    new [20] 
L17:    dup 
L18:    iload_1 
L19:    invokespecial [16] 
L22:    invokevirtual [10] 
L25:    checkcast [4] 
L28:    invokevirtual [11] 
L31:    istore_2 
L32:    iload_2 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [98] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     new [20] 
L7:     dup 
L8:     iload_1 
L9:     invokespecial [16] 
L12:    invokevirtual [12] 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [98] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     new [20] 
L7:     dup 
L8:     iload_1 
L9:     invokespecial [16] 
L12:    invokevirtual [12] 
L15:    ifeq L34 
L18:    aload_0 
L19:    getfield [7] 
L22:    new [20] 
L25:    dup 
L26:    iload_1 
L27:    invokespecial [16] 
L30:    invokevirtual [13] 
L33:    pop 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Class [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Field [27] [28] 
.const [8] = Method [29] [30] 
.const [9] = Method [31] [32] 
.const [10] = Method [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Class [49] 
.const [19] = Field [50] [51] 
.const [20] = Class [52] 
.const [21] = Class [53] 
.const [22] = Utf8 java/util/HashMap 
.const [23] = Utf8 java/lang/Integer 
.const [24] = Utf8 java/lang/Byte 
.const [25] = Utf8 de/esolutions/fw/util/tracing/filetransfer/util/FileTransferUtils$RequestIdPool 
.const [26] = Utf8 java/lang/Object 
.const [27] = Class [54] 
.const [28] = NameAndType [55] [56] 
.const [29] = Class [57] 
.const [30] = NameAndType [58] [59] 
.const [31] = Class [60] 
.const [32] = NameAndType [61] [62] 
.const [33] = Class [63] 
.const [34] = NameAndType [64] [65] 
.const [35] = Class [66] 
.const [36] = NameAndType [67] [68] 
.const [37] = Class [69] 
.const [38] = NameAndType [70] [71] 
.const [39] = Class [72] 
.const [40] = NameAndType [73] [74] 
.const [41] = Class [75] 
.const [42] = NameAndType [76] [77] 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Utf8 java/util/HashMap 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Utf8 java/lang/Integer 
.const [53] = Utf8 java/lang/Byte 
.const [54] = Utf8 de/esolutions/fw/util/tracing/filetransfer/util/FileTransferUtils$RequestIdPool 
.const [55] = Utf8 requestMap 
.const [56] = Utf8 Ljava/util/HashMap; 
.const [57] = Utf8 de/esolutions/fw/util/tracing/filetransfer/util/FileTransferUtils$RequestIdPool 
.const [58] = Utf8 isIdInUse 
.const [59] = Utf8 (I)Z 
.const [60] = Utf8 java/util/HashMap 
.const [61] = Utf8 put 
.const [62] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [63] = Utf8 java/util/HashMap 
.const [64] = Utf8 get 
.const [65] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [66] = Utf8 java/lang/Byte 
.const [67] = Utf8 byteValue 
.const [68] = Utf8 ()B 
.const [69] = Utf8 java/util/HashMap 
.const [70] = Utf8 containsKey 
.const [71] = Utf8 (Ljava/lang/Object;)Z 
.const [72] = Utf8 java/util/HashMap 
.const [73] = Utf8 remove 
.const [74] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [75] = Utf8 java/lang/Object 
.const [76] = Utf8 <init> 
.const [77] = Utf8 ()V 
.const [78] = Utf8 java/util/HashMap 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 java/lang/Integer 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (I)V 
.const [84] = Utf8 java/lang/Byte 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (B)V 
.const [87] = Utf8 de/esolutions/fw/util/tracing/filetransfer/util/FileTransferUtils$RequestIdPool 
.const [88] = Utf8 requestMap 
.const [89] = Utf8 Ljava/util/HashMap; 
.const [90] = Utf8 de/esolutions/fw/util/tracing/filetransfer/util/FileTransferUtils$RequestIdPool 
.const [91] = Class [90] 
.const [92] = Utf8 java/lang/Object 
.const [93] = Class [92] 
.const [94] = Utf8 requestMap 
.const [95] = Utf8 Ljava/util/HashMap; 
.const [96] = Utf8 usedId 
.const [97] = Utf8 I 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 getId 
.const [102] = Utf8 (B)I 
.const [103] = Utf8 getOperation 
.const [104] = Utf8 (I)B 
.const [105] = Utf8 isIdInUse 
.const [106] = Utf8 (I)Z 
.const [107] = Utf8 releaseId 
.const [108] = Utf8 (I)V 
.end class 
