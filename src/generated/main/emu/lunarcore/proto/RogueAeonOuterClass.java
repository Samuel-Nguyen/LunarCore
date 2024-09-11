// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import java.io.IOException;
import us.hebi.quickbuf.FieldName;
import us.hebi.quickbuf.InvalidProtocolBufferException;
import us.hebi.quickbuf.JsonSink;
import us.hebi.quickbuf.JsonSource;
import us.hebi.quickbuf.MessageFactory;
import us.hebi.quickbuf.ProtoMessage;
import us.hebi.quickbuf.ProtoSink;
import us.hebi.quickbuf.ProtoSource;

public final class RogueAeonOuterClass {
  /**
   * Protobuf type {@code RogueAeon}
   */
  public static final class RogueAeon extends ProtoMessage<RogueAeon> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 unlock_aeon_enhance_num = 3;</code>
     */
    private int unlockAeonEnhanceNum;

    /**
     * <code>optional uint32 aeon_id = 15;</code>
     */
    private int aeonId;

    /**
     * <code>optional bool is_unlock_enhance_buff = 10;</code>
     */
    private boolean isUnlockEnhanceBuff;

    private RogueAeon() {
    }

    /**
     * @return a new empty instance of {@code RogueAeon}
     */
    public static RogueAeon newInstance() {
      return new RogueAeon();
    }

    /**
     * <code>optional uint32 unlock_aeon_enhance_num = 3;</code>
     * @return whether the unlockAeonEnhanceNum field is set
     */
    public boolean hasUnlockAeonEnhanceNum() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 unlock_aeon_enhance_num = 3;</code>
     * @return this
     */
    public RogueAeon clearUnlockAeonEnhanceNum() {
      bitField0_ &= ~0x00000001;
      unlockAeonEnhanceNum = 0;
      return this;
    }

    /**
     * <code>optional uint32 unlock_aeon_enhance_num = 3;</code>
     * @return the unlockAeonEnhanceNum
     */
    public int getUnlockAeonEnhanceNum() {
      return unlockAeonEnhanceNum;
    }

    /**
     * <code>optional uint32 unlock_aeon_enhance_num = 3;</code>
     * @param value the unlockAeonEnhanceNum to set
     * @return this
     */
    public RogueAeon setUnlockAeonEnhanceNum(final int value) {
      bitField0_ |= 0x00000001;
      unlockAeonEnhanceNum = value;
      return this;
    }

    /**
     * <code>optional uint32 aeon_id = 15;</code>
     * @return whether the aeonId field is set
     */
    public boolean hasAeonId() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 aeon_id = 15;</code>
     * @return this
     */
    public RogueAeon clearAeonId() {
      bitField0_ &= ~0x00000002;
      aeonId = 0;
      return this;
    }

    /**
     * <code>optional uint32 aeon_id = 15;</code>
     * @return the aeonId
     */
    public int getAeonId() {
      return aeonId;
    }

    /**
     * <code>optional uint32 aeon_id = 15;</code>
     * @param value the aeonId to set
     * @return this
     */
    public RogueAeon setAeonId(final int value) {
      bitField0_ |= 0x00000002;
      aeonId = value;
      return this;
    }

    /**
     * <code>optional bool is_unlock_enhance_buff = 10;</code>
     * @return whether the isUnlockEnhanceBuff field is set
     */
    public boolean hasIsUnlockEnhanceBuff() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional bool is_unlock_enhance_buff = 10;</code>
     * @return this
     */
    public RogueAeon clearIsUnlockEnhanceBuff() {
      bitField0_ &= ~0x00000004;
      isUnlockEnhanceBuff = false;
      return this;
    }

    /**
     * <code>optional bool is_unlock_enhance_buff = 10;</code>
     * @return the isUnlockEnhanceBuff
     */
    public boolean getIsUnlockEnhanceBuff() {
      return isUnlockEnhanceBuff;
    }

    /**
     * <code>optional bool is_unlock_enhance_buff = 10;</code>
     * @param value the isUnlockEnhanceBuff to set
     * @return this
     */
    public RogueAeon setIsUnlockEnhanceBuff(final boolean value) {
      bitField0_ |= 0x00000004;
      isUnlockEnhanceBuff = value;
      return this;
    }

    @Override
    public RogueAeon copyFrom(final RogueAeon other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        unlockAeonEnhanceNum = other.unlockAeonEnhanceNum;
        aeonId = other.aeonId;
        isUnlockEnhanceBuff = other.isUnlockEnhanceBuff;
      }
      return this;
    }

    @Override
    public RogueAeon mergeFrom(final RogueAeon other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasUnlockAeonEnhanceNum()) {
        setUnlockAeonEnhanceNum(other.unlockAeonEnhanceNum);
      }
      if (other.hasAeonId()) {
        setAeonId(other.aeonId);
      }
      if (other.hasIsUnlockEnhanceBuff()) {
        setIsUnlockEnhanceBuff(other.isUnlockEnhanceBuff);
      }
      return this;
    }

    @Override
    public RogueAeon clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      unlockAeonEnhanceNum = 0;
      aeonId = 0;
      isUnlockEnhanceBuff = false;
      return this;
    }

    @Override
    public RogueAeon clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof RogueAeon)) {
        return false;
      }
      RogueAeon other = (RogueAeon) o;
      return bitField0_ == other.bitField0_
        && (!hasUnlockAeonEnhanceNum() || unlockAeonEnhanceNum == other.unlockAeonEnhanceNum)
        && (!hasAeonId() || aeonId == other.aeonId)
        && (!hasIsUnlockEnhanceBuff() || isUnlockEnhanceBuff == other.isUnlockEnhanceBuff);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 24);
        output.writeUInt32NoTag(unlockAeonEnhanceNum);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(aeonId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 80);
        output.writeBoolNoTag(isUnlockEnhanceBuff);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(unlockAeonEnhanceNum);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(aeonId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 2;
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public RogueAeon mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 24: {
            // unlockAeonEnhanceNum
            unlockAeonEnhanceNum = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 120) {
              break;
            }
          }
          case 120: {
            // aeonId
            aeonId = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 80) {
              break;
            }
          }
          case 80: {
            // isUnlockEnhanceBuff
            isUnlockEnhanceBuff = input.readBool();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 0) {
              break;
            }
          }
          case 0: {
            return this;
          }
          default: {
            if (!input.skipField(tag)) {
              return this;
            }
            tag = input.readTag();
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.unlockAeonEnhanceNum, unlockAeonEnhanceNum);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.aeonId, aeonId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeBool(FieldNames.isUnlockEnhanceBuff, isUnlockEnhanceBuff);
      }
      output.endObject();
    }

    @Override
    public RogueAeon mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1040991167:
          case 7773396: {
            if (input.isAtField(FieldNames.unlockAeonEnhanceNum)) {
              if (!input.trySkipNullValue()) {
                unlockAeonEnhanceNum = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1421249154:
          case -1109029417: {
            if (input.isAtField(FieldNames.aeonId)) {
              if (!input.trySkipNullValue()) {
                aeonId = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1006386637:
          case -118645302: {
            if (input.isAtField(FieldNames.isUnlockEnhanceBuff)) {
              if (!input.trySkipNullValue()) {
                isUnlockEnhanceBuff = input.readBool();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          default: {
            input.skipUnknownField();
            break;
          }
        }
      }
      input.endObject();
      return this;
    }

    @Override
    public RogueAeon clone() {
      return new RogueAeon().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static RogueAeon parseFrom(final byte[] data) throws InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new RogueAeon(), data).checkInitialized();
    }

    public static RogueAeon parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RogueAeon(), input).checkInitialized();
    }

    public static RogueAeon parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RogueAeon(), input).checkInitialized();
    }

    /**
     * @return factory for creating RogueAeon messages
     */
    public static MessageFactory<RogueAeon> getFactory() {
      return RogueAeonFactory.INSTANCE;
    }

    private enum RogueAeonFactory implements MessageFactory<RogueAeon> {
      INSTANCE;

      @Override
      public RogueAeon create() {
        return RogueAeon.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName unlockAeonEnhanceNum = FieldName.forField("unlockAeonEnhanceNum", "unlock_aeon_enhance_num");

      static final FieldName aeonId = FieldName.forField("aeonId", "aeon_id");

      static final FieldName isUnlockEnhanceBuff = FieldName.forField("isUnlockEnhanceBuff", "is_unlock_enhance_buff");
    }
  }
}
