.version 50 0 
.class public super [85] 
.super [87] 

.method public annotation [89] : [90] 
    .attribute [88] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [21] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [91] : [92] 
    .attribute [88] .code stack 2 locals 0 
L0:     aload_2 
L1:     ifnull L20 
L4:     iload_1 
L5:     ldc [2] 
L7:     if_icmpeq L16 
L10:    iload_1 
L11:    ldc [3] 
L13:    if_icmpne L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [93] : [94] 
    .attribute [88] .code stack 7 locals 6 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [16] 
L9:     astore_2 
L10:    aload_1 
L11:    ifnull L107 
L14:    aload_2 
L15:    ifnull L92 
L18:    aload_2 
L19:    invokeinterface [22] 0 
L24:    astore_3 
L25:    aload_2 
L26:    invokeinterface [23] 0 
L31:    astore 4 
L33:    aload_3 
L34:    ifnull L42 
L37:    aload_3 
L38:    arraylength 
L39:    goto L43 
L42:    iconst_0 
L43:    istore 5 
L45:    aload 4 
L47:    ifnull L58 
L50:    aload 4 
L52:    invokevirtual [17] 
L55:    goto L59 
L58:    iconst_0 
L59:    istore 6 
L61:    aload_0 
L62:    getfield [18] 
L65:    ldc [4] 
L67:    ldc [5] 
L69:    iload 6 
L71:    i2l 
L72:    iload 5 
L74:    i2l 
L75:    invokevirtual [19] 
L78:    pop 
L79:    aload_1 
L80:    iload 6 
L82:    iload 5 
L84:    invokeinterface [24] 0 
L89:    goto L119 
L92:    aload_0 
L93:    getfield [18] 
L96:    ldc [6] 
L98:    ldc [7] 
L100:   invokevirtual [20] 
L103:   pop 
L104:   goto L119 
L107:   aload_0 
L108:   getfield [18] 
L111:   ldc [6] 
L113:   ldc [8] 
L115:   invokevirtual [20] 
L118:   pop 
L119:   return 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 704643328 
.const [3] = Int 654311680 
.const [4] = Int 1078071040 
.const [5] = String [25] 
.const [6] = Int -1601830656 
.const [7] = String [26] 
.const [8] = String [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Class [30] 
.const [12] = Class [31] 
.const [13] = Class [32] 
.const [14] = Class [33] 
.const [15] = Method [34] [35] 
.const [16] = Method [36] [37] 
.const [17] = Method [38] [39] 
.const [18] = Field [40] [41] 
.const [19] = Method [42] [43] 
.const [20] = Method [44] [45] 
.const [21] = Method [46] [47] 
.const [22] = InterfaceMethod [48] [49] 
.const [23] = InterfaceMethod [50] [51] 
.const [24] = InterfaceMethod [52] [53] 
.const [25] = Utf8 '[BAPPropertyTelMissedCallIndication#update] missedCalls=%1, missedNumbers=%2' 
.const [26] = Utf8 '[BAPPropertyTelMissedCallIndication#update] state is null --> NOP!' 
.const [27] = Utf8 '[BAPPropertyTelMissedCallIndication#update] CombiBAPServicePhone is null --> NOP!' 
.const [28] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMissedCallIndication 
.const [29] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [30] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [31] = Utf8 org/dsi/ifc/telephoneng/MissedCallIndicator 
.const [32] = Utf8 de/audi/atip/log/LogChannel 
.const [33] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [34] = Class [54] 
.const [35] = NameAndType [55] [56] 
.const [36] = Class [57] 
.const [37] = NameAndType [58] [59] 
.const [38] = Class [60] 
.const [39] = NameAndType [61] [62] 
.const [40] = Class [63] 
.const [41] = NameAndType [64] [65] 
.const [42] = Class [66] 
.const [43] = NameAndType [67] [68] 
.const [44] = Class [69] 
.const [45] = NameAndType [70] [71] 
.const [46] = Class [72] 
.const [47] = NameAndType [73] [74] 
.const [48] = Class [75] 
.const [49] = NameAndType [76] [77] 
.const [50] = Class [78] 
.const [51] = NameAndType [79] [80] 
.const [52] = Class [81] 
.const [53] = NameAndType [82] [83] 
.const [54] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMissedCallIndication 
.const [55] = Utf8 getCombiService 
.const [56] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [57] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMissedCallIndication 
.const [58] = Utf8 getTelephoneState 
.const [59] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [60] = Utf8 org/dsi/ifc/telephoneng/MissedCallIndicator 
.const [61] = Utf8 getMissedCallCount 
.const [62] = Utf8 ()I 
.const [63] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMissedCallIndication 
.const [64] = Utf8 log 
.const [65] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Utf8 log 
.const [68] = Utf8 (ILjava/lang/String;JJ)Z 
.const [69] = Utf8 de/audi/atip/log/LogChannel 
.const [70] = Utf8 log 
.const [71] = Utf8 (ILjava/lang/String;)Z 
.const [72] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [75] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [76] = Utf8 getMissedNumbers 
.const [77] = Utf8 ()[Lorg/dsi/ifc/telephoneng/CallStackEntry; 
.const [78] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [79] = Utf8 getMissedCallIndicator 
.const [80] = Utf8 ()Lorg/dsi/ifc/telephoneng/MissedCallIndicator; 
.const [81] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [82] = Utf8 updateMissedCallIndication 
.const [83] = Utf8 (II)V 
.const [84] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMissedCallIndication 
.const [85] = Class [84] 
.const [86] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [87] = Class [86] 
.const [88] = Utf8 Code 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [91] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [92] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [93] = Utf8 updateAsync 
.const [94] = Utf8 ()V 
.end class 
