.version 50 0 
.class super abstract [71] 
.super [73] 
.field private [74] [75] 
.field private [76] [77] 

.method public [79] : [80] 
    .attribute [78] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [14] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [78] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifne L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [78] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_0 
L5:     getfield [7] 
L8:     invokevirtual [9] 
L11:    if_icmpge L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [78] .code stack 6 locals 2 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     ifne L9 
L7:     aconst_null 
L8:     areturn 
L9:     aload_0 
L10:    getfield [7] 
L13:    invokevirtual [9] 
L16:    i2l 
L17:    aload_0 
L18:    getfield [8] 
L21:    i2l 
L22:    aload_0 
L23:    invokevirtual [11] 
L26:    i2l 
L27:    ladd 
L28:    invokestatic [2] 
L31:    l2i 
L32:    istore_1 
L33:    aload_0 
L34:    getfield [7] 
L37:    aload_0 
L38:    getfield [8] 
L41:    iload_1 
L42:    invokevirtual [12] 
L45:    astore_2 
L46:    aload_0 
L47:    iload_1 
L48:    putfield [15] 
L51:    aload_2 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public interface [87] : [88] 
    .attribute [78] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [89] : [90] 
    .attribute [78] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected abstract [91] : [92] 
    .attribute [78] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [16] [17] 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Field [22] [23] 
.const [8] = Field [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Class [40] 
.const [17] = NameAndType [41] [42] 
.const [18] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [19] = Utf8 java/lang/Object 
.const [20] = Utf8 java/lang/String 
.const [21] = Utf8 java/lang/Math 
.const [22] = Class [43] 
.const [23] = NameAndType [44] [45] 
.const [24] = Class [46] 
.const [25] = NameAndType [47] [48] 
.const [26] = Class [49] 
.const [27] = NameAndType [50] [51] 
.const [28] = Class [52] 
.const [29] = NameAndType [53] [54] 
.const [30] = Class [55] 
.const [31] = NameAndType [56] [57] 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Utf8 java/lang/Math 
.const [41] = Utf8 min 
.const [42] = Utf8 (JJ)J 
.const [43] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [44] = Utf8 text 
.const [45] = Utf8 Ljava/lang/String; 
.const [46] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [47] = Utf8 offset 
.const [48] = Utf8 I 
.const [49] = Utf8 java/lang/String 
.const [50] = Utf8 length 
.const [51] = Utf8 ()I 
.const [52] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [53] = Utf8 hasNext 
.const [54] = Utf8 ()Z 
.const [55] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [56] = Utf8 getFrameSize 
.const [57] = Utf8 ()I 
.const [58] = Utf8 java/lang/String 
.const [59] = Utf8 substring 
.const [60] = Utf8 (II)Ljava/lang/String; 
.const [61] = Utf8 java/lang/Object 
.const [62] = Utf8 <init> 
.const [63] = Utf8 ()V 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [65] = Utf8 text 
.const [66] = Utf8 Ljava/lang/String; 
.const [67] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [68] = Utf8 offset 
.const [69] = Utf8 I 
.const [70] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator 
.const [71] = Class [70] 
.const [72] = Utf8 java/lang/Object 
.const [73] = Class [72] 
.const [74] = Utf8 text 
.const [75] = Utf8 Ljava/lang/String; 
.const [76] = Utf8 offset 
.const [77] = Utf8 I 
.const [78] = Utf8 Code 
.const [79] = Utf8 <init> 
.const [80] = Utf8 (Ljava/lang/String;)V 
.const [81] = Utf8 isAtStart 
.const [82] = Utf8 ()Z 
.const [83] = Utf8 hasNext 
.const [84] = Utf8 ()Z 
.const [85] = Utf8 next 
.const [86] = Utf8 ()Ljava/lang/String; 
.const [87] = Utf8 getText 
.const [88] = Utf8 ()Ljava/lang/String; 
.const [89] = Utf8 getOffset 
.const [90] = Utf8 ()I 
.const [91] = Utf8 getFrameSize 
.const [92] = Utf8 ()I 
.end class 
