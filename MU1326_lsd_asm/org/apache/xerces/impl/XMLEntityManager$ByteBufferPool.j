.version 50 0 
.class final super [69] 
.super [71] 
.field private static final [72] [73] 
.field private [74] [75] 
.field private [76] [77] 
.field private [78] [79] 
.field private [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_3 
L2:     iload_1 
L3:     invokespecial [9] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [11] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [12] 
L14:    aload_0 
L15:    aload_0 
L16:    getfield [5] 
L19:    anewarray [2] 
L22:    putfield [13] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [14] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [82] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifle L26 
L7:     aload_0 
L8:     getfield [7] 
L11:    aload_0 
L12:    dup 
L13:    getfield [8] 
L16:    iconst_1 
L17:    isub 
L18:    dup_x1 
L19:    putfield [14] 
L22:    aaload 
L23:    goto L32 
L26:    aload_0 
L27:    getfield [6] 
L30:    newarray byte 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [89] : [90] 
    .attribute [82] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_0 
L5:     getfield [7] 
L8:     arraylength 
L9:     if_icmpge L29 
L12:    aload_0 
L13:    getfield [7] 
L16:    aload_0 
L17:    dup 
L18:    getfield [8] 
L21:    dup_x1 
L22:    iconst_1 
L23:    iadd 
L24:    putfield [14] 
L27:    aload_1 
L28:    aastore 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [12] 
L5:     aload_0 
L6:     aload_0 
L7:     getfield [5] 
L10:    anewarray [2] 
L13:    putfield [13] 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [14] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Field [18] [19] 
.const [6] = Field [20] [21] 
.const [7] = Field [22] [23] 
.const [8] = Field [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Field [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Field [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Utf8 [B 
.const [16] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [17] = Utf8 java/lang/Object 
.const [18] = Class [38] 
.const [19] = NameAndType [39] [40] 
.const [20] = Class [41] 
.const [21] = NameAndType [42] [43] 
.const [22] = Class [44] 
.const [23] = NameAndType [45] [46] 
.const [24] = Class [47] 
.const [25] = NameAndType [48] [49] 
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
.const [38] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [39] = Utf8 fPoolSize 
.const [40] = Utf8 I 
.const [41] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [42] = Utf8 fBufferSize 
.const [43] = Utf8 I 
.const [44] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [45] = Utf8 fByteBufferPool 
.const [46] = Utf8 [[B 
.const [47] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [48] = Utf8 fDepth 
.const [49] = Utf8 I 
.const [50] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [51] = Utf8 <init> 
.const [52] = Utf8 (II)V 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 <init> 
.const [55] = Utf8 ()V 
.const [56] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [57] = Utf8 fPoolSize 
.const [58] = Utf8 I 
.const [59] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [60] = Utf8 fBufferSize 
.const [61] = Utf8 I 
.const [62] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [63] = Utf8 fByteBufferPool 
.const [64] = Utf8 [[B 
.const [65] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [66] = Utf8 fDepth 
.const [67] = Utf8 I 
.const [68] = Utf8 org/apache/xerces/impl/XMLEntityManager$ByteBufferPool 
.const [69] = Class [68] 
.const [70] = Utf8 java/lang/Object 
.const [71] = Class [70] 
.const [72] = Utf8 DEFAULT_POOL_SIZE 
.const [73] = Utf8 I 
.const [74] = Utf8 fPoolSize 
.const [75] = Utf8 I 
.const [76] = Utf8 fBufferSize 
.const [77] = Utf8 I 
.const [78] = Utf8 fByteBufferPool 
.const [79] = Utf8 [[B 
.const [80] = Utf8 fDepth 
.const [81] = Utf8 I 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (I)V 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (II)V 
.const [87] = Utf8 getBuffer 
.const [88] = Utf8 ()[B 
.const [89] = Utf8 returnBuffer 
.const [90] = Utf8 ([B)V 
.const [91] = Utf8 setBufferSize 
.const [92] = Utf8 (I)V 
.end class 
