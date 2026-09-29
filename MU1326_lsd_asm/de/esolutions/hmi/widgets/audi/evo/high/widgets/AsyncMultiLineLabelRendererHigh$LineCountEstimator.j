.version 50 0 
.class super [63] 
.super [65] 
.field private [66] [67] 
.field private [68] [69] 
.field private [70] [71] 

.method public [73] : [74] 
    .attribute [72] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [11] 
L9:     aload_0 
L10:    dload_2 
L11:    putfield [12] 
L14:    aload_0 
L15:    iconst_1 
L16:    iload_1 
L17:    bipush 90 
L19:    idiv 
L20:    invokestatic [2] 
L23:    putfield [13] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [72] .code stack 4 locals 6 
L0:     iload_2 
L1:     aload_0 
L2:     getfield [7] 
L5:     if_icmplt L14 
L8:     aload_0 
L9:     iload_1 
L10:    putfield [13] 
L13:    return 
L14:    iload_1 
L15:    iconst_3 
L16:    if_icmpge L32 
L19:    aload_0 
L20:    aload_0 
L21:    getfield [9] 
L24:    iload_1 
L25:    invokestatic [2] 
L28:    putfield [13] 
L31:    return 
L32:    iload_2 
L33:    i2d 
L34:    iload_1 
L35:    i2d 
L36:    ddiv 
L37:    dstore_3 
L38:    aload_0 
L39:    getfield [7] 
L42:    iload_2 
L43:    isub 
L44:    istore 5 
L46:    iload 5 
L48:    i2d 
L49:    dload_3 
L50:    ddiv 
L51:    d2i 
L52:    istore 6 
L54:    iload_1 
L55:    iload 6 
L57:    iadd 
L58:    istore 7 
L60:    aload_0 
L61:    getfield [9] 
L64:    i2d 
L65:    aload_0 
L66:    getfield [8] 
L69:    dmul 
L70:    d2i 
L71:    istore 8 
L73:    iload 7 
L75:    aload_0 
L76:    getfield [9] 
L79:    isub 
L80:    invokestatic [3] 
L83:    iload 8 
L85:    if_icmpge L89 
L88:    return 
L89:    aload_0 
L90:    iload 7 
L92:    putfield [13] 
L95:    return 
L96:    
    .end code 
.end method 

.method public interface [77] : [78] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [14] [15] 
.const [3] = Method [16] [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Class [20] 
.const [7] = Field [21] [22] 
.const [8] = Field [23] [24] 
.const [9] = Field [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Field [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Field [33] [34] 
.const [14] = Class [35] 
.const [15] = NameAndType [36] [37] 
.const [16] = Class [38] 
.const [17] = NameAndType [39] [40] 
.const [18] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [19] = Utf8 java/lang/Object 
.const [20] = Utf8 java/lang/Math 
.const [21] = Class [41] 
.const [22] = NameAndType [42] [43] 
.const [23] = Class [44] 
.const [24] = NameAndType [45] [46] 
.const [25] = Class [47] 
.const [26] = NameAndType [48] [49] 
.const [27] = Class [50] 
.const [28] = NameAndType [51] [52] 
.const [29] = Class [53] 
.const [30] = NameAndType [54] [55] 
.const [31] = Class [56] 
.const [32] = NameAndType [57] [58] 
.const [33] = Class [59] 
.const [34] = NameAndType [60] [61] 
.const [35] = Utf8 java/lang/Math 
.const [36] = Utf8 max 
.const [37] = Utf8 (II)I 
.const [38] = Utf8 java/lang/Math 
.const [39] = Utf8 abs 
.const [40] = Utf8 (I)I 
.const [41] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [42] = Utf8 totalCharCount 
.const [43] = Utf8 I 
.const [44] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [45] = Utf8 minimumChangeRatio 
.const [46] = Utf8 D 
.const [47] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [48] = Utf8 estimatedLineCount 
.const [49] = Utf8 I 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [54] = Utf8 totalCharCount 
.const [55] = Utf8 I 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [57] = Utf8 minimumChangeRatio 
.const [58] = Utf8 D 
.const [59] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [60] = Utf8 estimatedLineCount 
.const [61] = Utf8 I 
.const [62] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/AsyncMultiLineLabelRendererHigh$LineCountEstimator 
.const [63] = Class [62] 
.const [64] = Utf8 java/lang/Object 
.const [65] = Class [64] 
.const [66] = Utf8 totalCharCount 
.const [67] = Utf8 I 
.const [68] = Utf8 estimatedLineCount 
.const [69] = Utf8 I 
.const [70] = Utf8 minimumChangeRatio 
.const [71] = Utf8 D 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (ID)V 
.const [75] = Utf8 update 
.const [76] = Utf8 (II)V 
.const [77] = Utf8 getEstimatedLineCount 
.const [78] = Utf8 ()I 
.end class 
