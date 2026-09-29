.version 50 0 
.class final super [71] 
.super [73] 
.field final synthetic [74] [75] 

.method [77] : [78] 
    .attribute [76] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [76] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokevirtual [11] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [76] .code stack 4 locals 1 
L0:     iconst_1 
L1:     newarray byte 
L3:     astore_1 
L4:     aload_0 
L5:     aload_1 
L6:     iconst_0 
L7:     iconst_1 
L8:     invokevirtual [12] 
L11:    pop 
L12:    aload_1 
L13:    iconst_0 
L14:    baload 
L15:    sipush 255 
L18:    iand 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [76] .code stack 6 locals 1 
L0:     iload_3 
L1:     aload_0 
L2:     invokevirtual [13] 
L5:     if_icmple L13 
L8:     aload_0 
L9:     invokevirtual [13] 
L12:    istore_3 
L13:    iload_3 
L14:    aload_0 
L15:    getfield [10] 
L18:    invokestatic [5] 
L21:    arraylength 
L22:    aload_0 
L23:    getfield [10] 
L26:    invokestatic [6] 
L29:    isub 
L30:    if_icmple L52 
L33:    aload_0 
L34:    getfield [10] 
L37:    invokestatic [5] 
L40:    arraylength 
L41:    aload_0 
L42:    getfield [10] 
L45:    invokestatic [6] 
L48:    isub 
L49:    goto L53 
L52:    iload_3 
L53:    istore 4 
L55:    aload_0 
L56:    getfield [10] 
L59:    invokestatic [5] 
L62:    aload_0 
L63:    getfield [10] 
L66:    invokestatic [6] 
L69:    aload_1 
L70:    iload_2 
L71:    iload 4 
L73:    invokestatic [8] 
L76:    iload 4 
L78:    iload_3 
L79:    if_icmpge L116 
L82:    aload_0 
L83:    getfield [10] 
L86:    invokestatic [5] 
L89:    iconst_0 
L90:    aload_1 
L91:    iload_2 
L92:    iload 4 
L94:    iadd 
L95:    iload_3 
L96:    iload 4 
L98:    isub 
L99:    invokestatic [8] 
L102:   aload_0 
L103:   getfield [10] 
L106:   iload_3 
L107:   iload 4 
L109:   isub 
L110:   invokestatic [9] 
L113:   goto L129 
L116:   aload_0 
L117:   getfield [10] 
L120:   dup 
L121:   invokestatic [6] 
L124:   iload_3 
L125:   iadd 
L126:   invokestatic [9] 
L129:   iload_3 
L130:   areturn 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [76] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_0 
L3:     aload_1 
L4:     arraylength 
L5:     invokevirtual [12] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [16] 
.const [3] = Class [17] 
.const [4] = Class [18] 
.const [5] = Method [19] [20] 
.const [6] = Method [21] [22] 
.const [7] = Class [23] 
.const [8] = Method [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Field [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Utf8 com/ibm/j9/ssl/StreamQueue$1 
.const [17] = Utf8 java/io/InputStream 
.const [18] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [19] = Class [40] 
.const [20] = NameAndType [41] [42] 
.const [21] = Class [43] 
.const [22] = NameAndType [44] [45] 
.const [23] = Utf8 java/lang/System 
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
.const [40] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [41] = Utf8 access$0 
.const [42] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)[B 
.const [43] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [44] = Utf8 access$1 
.const [45] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)I 
.const [46] = Utf8 java/lang/System 
.const [47] = Utf8 arraycopy 
.const [48] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [49] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [50] = Utf8 access$2 
.const [51] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;I)V 
.const [52] = Utf8 com/ibm/j9/ssl/StreamQueue$1 
.const [53] = Utf8 this$0 
.const [54] = Utf8 Lcom/ibm/j9/ssl/StreamQueue; 
.const [55] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [56] = Utf8 getSize 
.const [57] = Utf8 ()I 
.const [58] = Utf8 com/ibm/j9/ssl/StreamQueue$1 
.const [59] = Utf8 read 
.const [60] = Utf8 ([BII)I 
.const [61] = Utf8 com/ibm/j9/ssl/StreamQueue$1 
.const [62] = Utf8 available 
.const [63] = Utf8 ()I 
.const [64] = Utf8 java/io/InputStream 
.const [65] = Utf8 <init> 
.const [66] = Utf8 ()V 
.const [67] = Utf8 com/ibm/j9/ssl/StreamQueue$1 
.const [68] = Utf8 this$0 
.const [69] = Utf8 Lcom/ibm/j9/ssl/StreamQueue; 
.const [70] = Utf8 com/ibm/j9/ssl/StreamQueue$1 
.const [71] = Class [70] 
.const [72] = Utf8 java/io/InputStream 
.const [73] = Class [72] 
.const [74] = Utf8 this$0 
.const [75] = Utf8 Lcom/ibm/j9/ssl/StreamQueue; 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)V 
.const [79] = Utf8 available 
.const [80] = Utf8 ()I 
.const [81] = Utf8 read 
.const [82] = Utf8 ()I 
.const [83] = Utf8 read 
.const [84] = Utf8 ([BII)I 
.const [85] = Utf8 read 
.const [86] = Utf8 ([B)I 
.end class 
