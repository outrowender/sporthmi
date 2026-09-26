.version 50 0 
.class public super [59] 
.super [61] 
.field [62] [63] 

.method public [65] : [66] 
    .attribute [64] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [13] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [64] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [8] 
L7:     ifne L12 
L10:    iconst_m1 
L11:    areturn 
L12:    aload_0 
L13:    getfield [7] 
L16:    invokevirtual [9] 
L19:    sipush 255 
L22:    iand 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [64] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [8] 
L7:     ifne L12 
L10:    iconst_m1 
L11:    areturn 
L12:    iload_3 
L13:    aload_0 
L14:    getfield [7] 
L17:    invokevirtual [10] 
L20:    invokestatic [2] 
L23:    istore_3 
L24:    aload_0 
L25:    getfield [7] 
L28:    aload_1 
L29:    iload_2 
L30:    iload_3 
L31:    invokevirtual [11] 
L34:    pop 
L35:    iload_3 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [14] [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Field [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Field [32] [33] 
.const [14] = Class [34] 
.const [15] = NameAndType [35] [36] 
.const [16] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/ByteBufferBackedInputStream 
.const [17] = Utf8 java/io/InputStream 
.const [18] = Utf8 java/nio/ByteBuffer 
.const [19] = Utf8 java/lang/Math 
.const [20] = Class [37] 
.const [21] = NameAndType [38] [39] 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Utf8 java/lang/Math 
.const [35] = Utf8 min 
.const [36] = Utf8 (II)I 
.const [37] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/ByteBufferBackedInputStream 
.const [38] = Utf8 buf 
.const [39] = Utf8 Ljava/nio/ByteBuffer; 
.const [40] = Utf8 java/nio/ByteBuffer 
.const [41] = Utf8 hasRemaining 
.const [42] = Utf8 ()Z 
.const [43] = Utf8 java/nio/ByteBuffer 
.const [44] = Utf8 get 
.const [45] = Utf8 ()B 
.const [46] = Utf8 java/nio/ByteBuffer 
.const [47] = Utf8 remaining 
.const [48] = Utf8 ()I 
.const [49] = Utf8 java/nio/ByteBuffer 
.const [50] = Utf8 get 
.const [51] = Utf8 ([BII)Ljava/nio/ByteBuffer; 
.const [52] = Utf8 java/io/InputStream 
.const [53] = Utf8 <init> 
.const [54] = Utf8 ()V 
.const [55] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/ByteBufferBackedInputStream 
.const [56] = Utf8 buf 
.const [57] = Utf8 Ljava/nio/ByteBuffer; 
.const [58] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/ByteBufferBackedInputStream 
.const [59] = Class [58] 
.const [60] = Utf8 java/io/InputStream 
.const [61] = Class [60] 
.const [62] = Utf8 buf 
.const [63] = Utf8 Ljava/nio/ByteBuffer; 
.const [64] = Utf8 Code 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (Ljava/nio/ByteBuffer;)V 
.const [67] = Utf8 read 
.const [68] = Utf8 ()I 
.const [69] = Utf8 read 
.const [70] = Utf8 ([BII)I 
.end class 
