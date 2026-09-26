.version 50 0 
.class public super abstract [45] 
.super [47] 
.implements [49] 
.field protected final [50] [51] 

.method protected static [53] : [54] 
    .attribute [52] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L28 
            L31 
            L34 
            default : L37 

L28:    ldc [2] 
L30:    areturn 
L31:    ldc [3] 
L33:    areturn 
L34:    ldc [4] 
L36:    areturn 
L37:    ldc [5] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public static [55] : [56] 
    .attribute [52] .code stack 1 locals 0 
L0:     iload_0 
L1:     lookupswitch 
            65536 : L36 
            131072 : L38 
            196608 : L40 
            default : L42 

L36:    iconst_0 
L37:    areturn 
L38:    iconst_1 
L39:    areturn 
L40:    iconst_2 
L41:    areturn 
L42:    iconst_m1 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [52] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [11] 
L6:     aload_0 
L7:     new [13] 
L10:    dup 
L11:    aload_0 
L12:    getfield [9] 
L15:    invokespecial [12] 
L18:    putfield [14] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [59] : [60] 
    .attribute [52] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 256 
.const [3] = Int 512 
.const [4] = Int 768 
.const [5] = Int 65535 
.const [6] = Class [15] 
.const [7] = Class [16] 
.const [8] = Class [17] 
.const [9] = Field [18] [19] 
.const [10] = Field [20] [21] 
.const [11] = Method [22] [23] 
.const [12] = Method [24] [25] 
.const [13] = Class [26] 
.const [14] = Field [27] [28] 
.const [15] = Utf8 de/audi/app/phone/core/dsi/NullTelDSIMobileEquipmentDeviceAccess 
.const [16] = Utf8 de/audi/app/phone/core/dsi/AbstractMobileEquipementTopologyAccess 
.const [17] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [18] = Class [29] 
.const [19] = NameAndType [30] [31] 
.const [20] = Class [32] 
.const [21] = NameAndType [33] [34] 
.const [22] = Class [35] 
.const [23] = NameAndType [36] [37] 
.const [24] = Class [38] 
.const [25] = NameAndType [39] [40] 
.const [26] = Utf8 de/audi/app/phone/core/dsi/NullTelDSIMobileEquipmentDeviceAccess 
.const [27] = Class [41] 
.const [28] = NameAndType [42] [43] 
.const [29] = Utf8 de/audi/app/phone/core/dsi/AbstractMobileEquipementTopologyAccess 
.const [30] = Utf8 log 
.const [31] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [32] = Utf8 de/audi/app/phone/core/dsi/AbstractMobileEquipementTopologyAccess 
.const [33] = Utf8 nullTelDSIMobileEquipmentDeviceAccess 
.const [34] = Utf8 Lde/audi/app/phone/core/dsi/NullTelDSIMobileEquipmentDeviceAccess; 
.const [35] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [36] = Utf8 <init> 
.const [37] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [38] = Utf8 de/audi/app/phone/core/dsi/NullTelDSIMobileEquipmentDeviceAccess 
.const [39] = Utf8 <init> 
.const [40] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [41] = Utf8 de/audi/app/phone/core/dsi/AbstractMobileEquipementTopologyAccess 
.const [42] = Utf8 nullTelDSIMobileEquipmentDeviceAccess 
.const [43] = Utf8 Lde/audi/app/phone/core/dsi/NullTelDSIMobileEquipmentDeviceAccess; 
.const [44] = Utf8 de/audi/app/phone/core/dsi/AbstractMobileEquipementTopologyAccess 
.const [45] = Class [44] 
.const [46] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [47] = Class [46] 
.const [48] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentTopologyAccess 
.const [49] = Class [48] 
.const [50] = Utf8 nullTelDSIMobileEquipmentDeviceAccess 
.const [51] = Utf8 Lde/audi/app/phone/core/dsi/NullTelDSIMobileEquipmentDeviceAccess; 
.const [52] = Utf8 Code 
.const [53] = Utf8 getRoleIDFromSlot 
.const [54] = Utf8 (I)I 
.const [55] = Utf8 getSlotIDFromRoleID 
.const [56] = Utf8 (I)I 
.const [57] = Utf8 <init> 
.const [58] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [59] = Utf8 getNullDeviceAccess 
.const [60] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceAccess; 
.end class 
