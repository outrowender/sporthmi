.version 50 0 
.class public super abstract [163] 
.super [165] 
.implements [167] 
.field protected [168] [169] 
.field protected [170] [171] 

.method public [173] : [174] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    getstatic [2] 
L13:    putfield [34] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public abstract [175] : [176] 
    .attribute [172] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [177] : [178] 
    .attribute [172] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [179] : [180] 
    .attribute [172] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [181] : [182] 
    .attribute [172] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [183] : [184] 
    .attribute [172] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [185] : [186] 
    .attribute [172] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [187] : [188] 
    .attribute [172] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [189] : [190] 
    .attribute [172] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public final [191] : [192] 
    .attribute [172] .code stack 5 locals 0 
L0:     aload_2 
L1:     ifnonnull L16 
L4:     aload_0 
L5:     getfield [19] 
L8:     iconst_3 
L9:     ldc [3] 
L11:    invokevirtual [20] 
L14:    pop 
L15:    return 
L16:    aload_0 
L17:    getfield [18] 
L20:    iload_1 
L21:    aload_2 
L22:    invokeinterface [35] 0 
L27:    aload_0 
L28:    getfield [19] 
L31:    iconst_1 
L32:    ldc [4] 
L34:    iload_1 
L35:    invokestatic [5] 
L38:    aload_2 
L39:    invokespecial [31] 
L42:    invokevirtual [21] 
L45:    invokevirtual [22] 
L48:    pop 
L49:    aload_0 
L50:    iload_1 
L51:    invokevirtual [23] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public final [193] : [194] 
    .attribute [172] .code stack 5 locals 1 
L0:     aload_2 
L1:     ifnonnull L16 
L4:     aload_0 
L5:     getfield [19] 
L8:     iconst_3 
L9:     ldc [3] 
L11:    invokevirtual [20] 
L14:    pop 
L15:    return 
L16:    iconst_0 
L17:    istore_3 
L18:    iload_3 
L19:    aload_1 
L20:    arraylength 
L21:    if_icmpge L43 
L24:    aload_0 
L25:    getfield [18] 
L28:    aload_1 
L29:    iload_3 
L30:    iaload 
L31:    aload_2 
L32:    invokeinterface [35] 0 
L37:    iinc 3 1 
L40:    goto L18 
L43:    aload_0 
L44:    getfield [19] 
L47:    iconst_1 
L48:    ldc [6] 
L50:    aload_1 
L51:    aload_2 
L52:    invokespecial [31] 
L55:    invokevirtual [21] 
L58:    invokevirtual [22] 
L61:    pop 
L62:    aload_0 
L63:    aload_1 
L64:    invokevirtual [24] 
L67:    return 
L68:    
    .end code 
.end method 

.method public final [195] : [196] 
    .attribute [172] .code stack 5 locals 2 
L0:     aload_1 
L1:     ifnonnull L16 
L4:     aload_0 
L5:     getfield [19] 
L8:     iconst_3 
L9:     ldc [3] 
L11:    invokevirtual [20] 
L14:    pop 
L15:    return 
L16:    aload_0 
L17:    invokevirtual [25] 
L20:    astore_2 
L21:    aload_2 
L22:    ifnull L75 
L25:    iconst_0 
L26:    istore_3 
L27:    iload_3 
L28:    aload_2 
L29:    arraylength 
L30:    if_icmpge L52 
L33:    aload_0 
L34:    getfield [18] 
L37:    aload_2 
L38:    iload_3 
L39:    iaload 
L40:    aload_1 
L41:    invokeinterface [35] 0 
L46:    iinc 3 1 
L49:    goto L27 
L52:    aload_0 
L53:    getfield [19] 
L56:    iconst_1 
L57:    ldc [6] 
L59:    aload_2 
L60:    aload_1 
L61:    invokespecial [31] 
L64:    invokevirtual [21] 
L67:    invokevirtual [22] 
L70:    pop 
L71:    aload_0 
L72:    invokevirtual [26] 
L75:    return 
L76:    
    .end code 
.end method 

.method public final [197] : [198] 
    .attribute [172] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     aload_2 
L6:     invokeinterface [36] 0 
L11:    aload_0 
L12:    getfield [19] 
L15:    iconst_1 
L16:    ldc [7] 
L18:    iload_1 
L19:    invokestatic [5] 
L22:    aload_2 
L23:    invokespecial [31] 
L26:    invokevirtual [21] 
L29:    invokevirtual [22] 
L32:    pop 
L33:    aload_0 
L34:    getfield [18] 
L37:    iload_1 
L38:    invokeinterface [37] 0 
L43:    ifne L51 
L46:    aload_0 
L47:    iload_1 
L48:    invokevirtual [27] 
L51:    return 
L52:    
    .end code 
.end method 

.method public final [199] : [200] 
    .attribute [172] .code stack 3 locals 1 
L0:     iconst_0 
L1:     istore_3 
L2:     iload_3 
L3:     aload_1 
L4:     arraylength 
L5:     if_icmpge L22 
L8:     aload_0 
L9:     aload_1 
L10:    iload_3 
L11:    iaload 
L12:    aload_2 
L13:    invokespecial [32] 
L16:    iinc 3 1 
L19:    goto L2 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public final [201] : [202] 
    .attribute [172] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnull L31 
L9:     iconst_0 
L10:    istore_3 
L11:    iload_3 
L12:    aload_2 
L13:    arraylength 
L14:    if_icmpge L31 
L17:    aload_0 
L18:    aload_2 
L19:    iload_3 
L20:    iaload 
L21:    aload_1 
L22:    invokespecial [32] 
L25:    iinc 3 1 
L28:    goto L11 
L31:    return 
L32:    
    .end code 
.end method 

.method public enum [203] : [204] 
    .attribute [172] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [205] : [206] 
    .attribute [172] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     iconst_3 
L5:     ldc [8] 
L7:     aload_0 
L8:     invokespecial [31] 
L11:    invokevirtual [21] 
L14:    aload_1 
L15:    invokevirtual [28] 
L18:    invokevirtual [22] 
L21:    pop 
L22:    aload_0 
L23:    getfield [19] 
L26:    iconst_2 
L27:    ldc [9] 
L29:    aload_1 
L30:    invokevirtual [29] 
L33:    pop 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [38] [39] 
.const [3] = String [40] 
.const [4] = String [41] 
.const [5] = Method [42] [43] 
.const [6] = String [44] 
.const [7] = String [45] 
.const [8] = String [46] 
.const [9] = String [47] 
.const [10] = Class [48] 
.const [11] = Class [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Class [53] 
.const [16] = Class [54] 
.const [17] = Class [55] 
.const [18] = Field [56] [57] 
.const [19] = Field [58] [59] 
.const [20] = Method [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Method [84] [85] 
.const [33] = Field [86] [87] 
.const [34] = Field [88] [89] 
.const [35] = InterfaceMethod [90] [91] 
.const [36] = InterfaceMethod [92] [93] 
.const [37] = InterfaceMethod [94] [95] 
.const [38] = Class [96] 
.const [39] = NameAndType [97] [98] 
.const [40] = Utf8 'setNotification without listener ' 
.const [41] = Utf8 'DSI notification listener added: attribute=%1, listener=%2' 
.const [42] = Class [99] 
.const [43] = NameAndType [100] [101] 
.const [44] = Utf8 'DSI notification listener added: attributes=%1, listener=%2' 
.const [45] = Utf8 'DSI notification listener removed: attribute=%1, listener=%2' 
.const [46] = Utf8 'Provider call not executed: class=%1 reason=%2' 
.const [47] = Utf8 'Provider call not executed: exception=%1' 
.const [48] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [51] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [52] = Utf8 de/esolutions/fw/dsi/base/IDispatcher 
.const [53] = Utf8 java/lang/String 
.const [54] = Utf8 java/lang/Class 
.const [55] = Utf8 java/lang/Exception 
.const [56] = Class [102] 
.const [57] = NameAndType [103] [104] 
.const [58] = Class [105] 
.const [59] = NameAndType [106] [107] 
.const [60] = Class [108] 
.const [61] = NameAndType [109] [110] 
.const [62] = Class [111] 
.const [63] = NameAndType [112] [113] 
.const [64] = Class [114] 
.const [65] = NameAndType [115] [116] 
.const [66] = Class [117] 
.const [67] = NameAndType [118] [119] 
.const [68] = Class [120] 
.const [69] = NameAndType [121] [122] 
.const [70] = Class [123] 
.const [71] = NameAndType [124] [125] 
.const [72] = Class [126] 
.const [73] = NameAndType [127] [128] 
.const [74] = Class [129] 
.const [75] = NameAndType [130] [131] 
.const [76] = Class [132] 
.const [77] = NameAndType [133] [134] 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Class [159] 
.const [95] = NameAndType [160] [161] 
.const [96] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [97] = Utf8 DSI_PROVIDER 
.const [98] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [99] = Utf8 java/lang/String 
.const [100] = Utf8 valueOf 
.const [101] = Utf8 (I)Ljava/lang/String; 
.const [102] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [103] = Utf8 dispatcher 
.const [104] = Utf8 Lde/esolutions/fw/dsi/base/IDispatcher; 
.const [105] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [106] = Utf8 tracer 
.const [107] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [108] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [109] = Utf8 log 
.const [110] = Utf8 (SLjava/lang/String;)Z 
.const [111] = Utf8 java/lang/Class 
.const [112] = Utf8 getName 
.const [113] = Utf8 ()Ljava/lang/String; 
.const [114] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [115] = Utf8 log 
.const [116] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [117] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [118] = Utf8 setNotification 
.const [119] = Utf8 (I)V 
.const [120] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [121] = Utf8 setNotification 
.const [122] = Utf8 ([I)V 
.const [123] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [124] = Utf8 getAttributeIDs 
.const [125] = Utf8 ()[I 
.const [126] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [127] = Utf8 setNotification 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [130] = Utf8 clearNotification 
.const [131] = Utf8 (I)V 
.const [132] = Utf8 java/lang/Exception 
.const [133] = Utf8 getMessage 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [136] = Utf8 log 
.const [137] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [138] = Utf8 java/lang/Object 
.const [139] = Utf8 <init> 
.const [140] = Utf8 ()V 
.const [141] = Utf8 java/lang/Object 
.const [142] = Utf8 getClass 
.const [143] = Utf8 ()Ljava/lang/Class; 
.const [144] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [145] = Utf8 clearNotification 
.const [146] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [147] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [148] = Utf8 dispatcher 
.const [149] = Utf8 Lde/esolutions/fw/dsi/base/IDispatcher; 
.const [150] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [151] = Utf8 tracer 
.const [152] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [153] = Utf8 de/esolutions/fw/dsi/base/IDispatcher 
.const [154] = Utf8 addUnconfirmedNotificationListener 
.const [155] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [156] = Utf8 de/esolutions/fw/dsi/base/IDispatcher 
.const [157] = Utf8 removeNotificationListener 
.const [158] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [159] = Utf8 de/esolutions/fw/dsi/base/IDispatcher 
.const [160] = Utf8 hasNotificationListeners 
.const [161] = Utf8 (I)Z 
.const [162] = Utf8 de/esolutions/fw/dsi/base/AbstractProviderBase 
.const [163] = Class [162] 
.const [164] = Utf8 java/lang/Object 
.const [165] = Class [164] 
.const [166] = Utf8 org/dsi/ifc/base/DSIBase 
.const [167] = Class [166] 
.const [168] = Utf8 tracer 
.const [169] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [170] = Utf8 dispatcher 
.const [171] = Utf8 Lde/esolutions/fw/dsi/base/IDispatcher; 
.const [172] = Utf8 Code 
.const [173] = Utf8 <init> 
.const [174] = Utf8 (Lde/esolutions/fw/dsi/base/IDispatcher;)V 
.const [175] = Utf8 getName 
.const [176] = Utf8 ()Ljava/lang/String; 
.const [177] = Utf8 getAttributeIDs 
.const [178] = Utf8 ()[I 
.const [179] = Utf8 setNotification 
.const [180] = Utf8 (I)V 
.const [181] = Utf8 setNotification 
.const [182] = Utf8 ([I)V 
.const [183] = Utf8 setNotification 
.const [184] = Utf8 ()V 
.const [185] = Utf8 clearNotification 
.const [186] = Utf8 (I)V 
.const [187] = Utf8 clearNotification 
.const [188] = Utf8 ([I)V 
.const [189] = Utf8 clearNotification 
.const [190] = Utf8 ()V 
.const [191] = Utf8 setNotification 
.const [192] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [193] = Utf8 setNotification 
.const [194] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [195] = Utf8 setNotification 
.const [196] = Utf8 (Lorg/dsi/ifc/base/DSIListener;)V 
.const [197] = Utf8 clearNotification 
.const [198] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [199] = Utf8 clearNotification 
.const [200] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [201] = Utf8 clearNotification 
.const [202] = Utf8 (Lorg/dsi/ifc/base/DSIListener;)V 
.const [203] = Utf8 yySet 
.const [204] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [205] = Utf8 traceException 
.const [206] = Utf8 (Ljava/lang/Exception;)V 
.end class 
