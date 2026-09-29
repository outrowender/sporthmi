.version 50 0 
.class public super [93] 
.super [95] 
.field public static final [96] [97] 
.field protected final [98] [99] 
.field protected final [100] [101] 

.method public [103] : [104] 
    .attribute [102] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     sipush 2048 
L5:     invokespecial [14] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [102] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     newarray byte 
L5:     invokespecial [15] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [17] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [18] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     invokevirtual [7] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [102] .code stack 4 locals 2 
L0:     iload_3 
L1:     aload_0 
L2:     getfield [6] 
L5:     arraylength 
L6:     if_icmple L15 
L9:     aload_0 
L10:    getfield [6] 
L13:    arraylength 
L14:    istore_3 
L15:    aload_0 
L16:    getfield [5] 
L19:    aload_0 
L20:    getfield [6] 
L23:    iconst_0 
L24:    iload_3 
L25:    invokevirtual [8] 
L28:    istore 4 
L30:    iconst_0 
L31:    istore 5 
L33:    iload 5 
L35:    iload 4 
L37:    if_icmpge L64 
L40:    aload_1 
L41:    iload_2 
L42:    iload 5 
L44:    iadd 
L45:    aload_0 
L46:    getfield [6] 
L49:    iload 5 
L51:    baload 
L52:    sipush 255 
L55:    iand 
L56:    i2c 
L57:    castore 
L58:    iinc 5 1 
L61:    goto L33 
L64:    iload 4 
L66:    areturn 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [102] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     lload_1 
L5:     invokevirtual [9] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [102] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     invokevirtual [10] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     iload_1 
L5:     invokevirtual [11] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     invokevirtual [12] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     invokevirtual [13] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [19] 
.const [3] = Class [20] 
.const [4] = Class [21] 
.const [5] = Field [22] [23] 
.const [6] = Field [24] [25] 
.const [7] = Method [26] [27] 
.const [8] = Method [28] [29] 
.const [9] = Method [30] [31] 
.const [10] = Method [32] [33] 
.const [11] = Method [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Field [46] [47] 
.const [18] = Field [48] [49] 
.const [19] = Utf8 org/apache/xerces/impl/io/Latin1Reader 
.const [20] = Utf8 java/io/Reader 
.const [21] = Utf8 java/io/InputStream 
.const [22] = Class [50] 
.const [23] = NameAndType [51] [52] 
.const [24] = Class [53] 
.const [25] = NameAndType [54] [55] 
.const [26] = Class [56] 
.const [27] = NameAndType [57] [58] 
.const [28] = Class [59] 
.const [29] = NameAndType [60] [61] 
.const [30] = Class [62] 
.const [31] = NameAndType [63] [64] 
.const [32] = Class [65] 
.const [33] = NameAndType [66] [67] 
.const [34] = Class [68] 
.const [35] = NameAndType [69] [70] 
.const [36] = Class [71] 
.const [37] = NameAndType [72] [73] 
.const [38] = Class [74] 
.const [39] = NameAndType [75] [76] 
.const [40] = Class [77] 
.const [41] = NameAndType [78] [79] 
.const [42] = Class [80] 
.const [43] = NameAndType [81] [82] 
.const [44] = Class [83] 
.const [45] = NameAndType [84] [85] 
.const [46] = Class [86] 
.const [47] = NameAndType [87] [88] 
.const [48] = Class [89] 
.const [49] = NameAndType [90] [91] 
.const [50] = Utf8 org/apache/xerces/impl/io/Latin1Reader 
.const [51] = Utf8 fInputStream 
.const [52] = Utf8 Ljava/io/InputStream; 
.const [53] = Utf8 org/apache/xerces/impl/io/Latin1Reader 
.const [54] = Utf8 fBuffer 
.const [55] = Utf8 [B 
.const [56] = Utf8 java/io/InputStream 
.const [57] = Utf8 read 
.const [58] = Utf8 ()I 
.const [59] = Utf8 java/io/InputStream 
.const [60] = Utf8 read 
.const [61] = Utf8 ([BII)I 
.const [62] = Utf8 java/io/InputStream 
.const [63] = Utf8 skip 
.const [64] = Utf8 (J)J 
.const [65] = Utf8 java/io/InputStream 
.const [66] = Utf8 markSupported 
.const [67] = Utf8 ()Z 
.const [68] = Utf8 java/io/InputStream 
.const [69] = Utf8 mark 
.const [70] = Utf8 (I)V 
.const [71] = Utf8 java/io/InputStream 
.const [72] = Utf8 reset 
.const [73] = Utf8 ()V 
.const [74] = Utf8 java/io/InputStream 
.const [75] = Utf8 close 
.const [76] = Utf8 ()V 
.const [77] = Utf8 org/apache/xerces/impl/io/Latin1Reader 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (Ljava/io/InputStream;I)V 
.const [80] = Utf8 org/apache/xerces/impl/io/Latin1Reader 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (Ljava/io/InputStream;[B)V 
.const [83] = Utf8 java/io/Reader 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 org/apache/xerces/impl/io/Latin1Reader 
.const [87] = Utf8 fInputStream 
.const [88] = Utf8 Ljava/io/InputStream; 
.const [89] = Utf8 org/apache/xerces/impl/io/Latin1Reader 
.const [90] = Utf8 fBuffer 
.const [91] = Utf8 [B 
.const [92] = Utf8 org/apache/xerces/impl/io/Latin1Reader 
.const [93] = Class [92] 
.const [94] = Utf8 java/io/Reader 
.const [95] = Class [94] 
.const [96] = Utf8 DEFAULT_BUFFER_SIZE 
.const [97] = Utf8 I 
.const [98] = Utf8 fInputStream 
.const [99] = Utf8 Ljava/io/InputStream; 
.const [100] = Utf8 fBuffer 
.const [101] = Utf8 [B 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Ljava/io/InputStream;)V 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Ljava/io/InputStream;I)V 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Ljava/io/InputStream;[B)V 
.const [109] = Utf8 read 
.const [110] = Utf8 ()I 
.const [111] = Utf8 read 
.const [112] = Utf8 ([CII)I 
.const [113] = Utf8 skip 
.const [114] = Utf8 (J)J 
.const [115] = Utf8 ready 
.const [116] = Utf8 ()Z 
.const [117] = Utf8 markSupported 
.const [118] = Utf8 ()Z 
.const [119] = Utf8 mark 
.const [120] = Utf8 (I)V 
.const [121] = Utf8 reset 
.const [122] = Utf8 ()V 
.const [123] = Utf8 close 
.const [124] = Utf8 ()V 
.end class 
