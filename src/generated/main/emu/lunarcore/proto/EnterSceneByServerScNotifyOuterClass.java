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

public final class EnterSceneByServerScNotifyOuterClass {
  /**
   * Protobuf type {@code EnterSceneByServerScNotify}
   */
  public static final class EnterSceneByServerScNotify extends ProtoMessage<EnterSceneByServerScNotify> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional .EnterSceneReason reason = 11;</code>
     */
    private int reason;

    /**
     * <code>optional .SceneInfo scene = 7;</code>
     */
    private final SceneInfoOuterClass.SceneInfo scene = SceneInfoOuterClass.SceneInfo.newInstance();

    /**
     * <code>optional .LineupInfo lineup = 14;</code>
     */
    private final LineupInfoOuterClass.LineupInfo lineup = LineupInfoOuterClass.LineupInfo.newInstance();

    private EnterSceneByServerScNotify() {
    }

    /**
     * @return a new empty instance of {@code EnterSceneByServerScNotify}
     */
    public static EnterSceneByServerScNotify newInstance() {
      return new EnterSceneByServerScNotify();
    }

    /**
     * <code>optional .EnterSceneReason reason = 11;</code>
     * @return whether the reason field is set
     */
    public boolean hasReason() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional .EnterSceneReason reason = 11;</code>
     * @return this
     */
    public EnterSceneByServerScNotify clearReason() {
      bitField0_ &= ~0x00000001;
      reason = 0;
      return this;
    }

    /**
     * <code>optional .EnterSceneReason reason = 11;</code>
     * @return the reason
     */
    public EnterSceneReasonOuterClass.EnterSceneReason getReason() {
      return EnterSceneReasonOuterClass.EnterSceneReason.forNumber(reason);
    }

    /**
     * Gets the value of the internal enum store. The result is
     * equivalent to {@link EnterSceneByServerScNotify#getReason()}.getNumber().
     *
     * @return numeric wire representation
     */
    public int getReasonValue() {
      return reason;
    }

    /**
     * Sets the value of the internal enum store. This does not
     * do any validity checks, so be sure to use appropriate value
     * constants from {@link EnterSceneReasonOuterClass.EnterSceneReason}. Setting an invalid value
     * can cause {@link EnterSceneByServerScNotify#getReason()} to return null
     *
     * @param value the numeric wire value to set
     * @return this
     */
    public EnterSceneByServerScNotify setReasonValue(final int value) {
      bitField0_ |= 0x00000001;
      reason = value;
      return this;
    }

    /**
     * <code>optional .EnterSceneReason reason = 11;</code>
     * @param value the reason to set
     * @return this
     */
    public EnterSceneByServerScNotify setReason(
        final EnterSceneReasonOuterClass.EnterSceneReason value) {
      bitField0_ |= 0x00000001;
      reason = value.getNumber();
      return this;
    }

    /**
     * <code>optional .SceneInfo scene = 7;</code>
     * @return whether the scene field is set
     */
    public boolean hasScene() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .SceneInfo scene = 7;</code>
     * @return this
     */
    public EnterSceneByServerScNotify clearScene() {
      bitField0_ &= ~0x00000002;
      scene.clear();
      return this;
    }

    /**
     * <code>optional .SceneInfo scene = 7;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableScene()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public SceneInfoOuterClass.SceneInfo getScene() {
      return scene;
    }

    /**
     * <code>optional .SceneInfo scene = 7;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public SceneInfoOuterClass.SceneInfo getMutableScene() {
      bitField0_ |= 0x00000002;
      return scene;
    }

    /**
     * <code>optional .SceneInfo scene = 7;</code>
     * @param value the scene to set
     * @return this
     */
    public EnterSceneByServerScNotify setScene(final SceneInfoOuterClass.SceneInfo value) {
      bitField0_ |= 0x00000002;
      scene.copyFrom(value);
      return this;
    }

    /**
     * <code>optional .LineupInfo lineup = 14;</code>
     * @return whether the lineup field is set
     */
    public boolean hasLineup() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional .LineupInfo lineup = 14;</code>
     * @return this
     */
    public EnterSceneByServerScNotify clearLineup() {
      bitField0_ &= ~0x00000004;
      lineup.clear();
      return this;
    }

    /**
     * <code>optional .LineupInfo lineup = 14;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableLineup()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public LineupInfoOuterClass.LineupInfo getLineup() {
      return lineup;
    }

    /**
     * <code>optional .LineupInfo lineup = 14;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public LineupInfoOuterClass.LineupInfo getMutableLineup() {
      bitField0_ |= 0x00000004;
      return lineup;
    }

    /**
     * <code>optional .LineupInfo lineup = 14;</code>
     * @param value the lineup to set
     * @return this
     */
    public EnterSceneByServerScNotify setLineup(final LineupInfoOuterClass.LineupInfo value) {
      bitField0_ |= 0x00000004;
      lineup.copyFrom(value);
      return this;
    }

    @Override
    public EnterSceneByServerScNotify copyFrom(final EnterSceneByServerScNotify other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        reason = other.reason;
        scene.copyFrom(other.scene);
        lineup.copyFrom(other.lineup);
      }
      return this;
    }

    @Override
    public EnterSceneByServerScNotify mergeFrom(final EnterSceneByServerScNotify other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasReason()) {
        setReasonValue(other.reason);
      }
      if (other.hasScene()) {
        getMutableScene().mergeFrom(other.scene);
      }
      if (other.hasLineup()) {
        getMutableLineup().mergeFrom(other.lineup);
      }
      return this;
    }

    @Override
    public EnterSceneByServerScNotify clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      reason = 0;
      scene.clear();
      lineup.clear();
      return this;
    }

    @Override
    public EnterSceneByServerScNotify clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      scene.clearQuick();
      lineup.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof EnterSceneByServerScNotify)) {
        return false;
      }
      EnterSceneByServerScNotify other = (EnterSceneByServerScNotify) o;
      return bitField0_ == other.bitField0_
        && (!hasReason() || reason == other.reason)
        && (!hasScene() || scene.equals(other.scene))
        && (!hasLineup() || lineup.equals(other.lineup));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 88);
        output.writeEnumNoTag(reason);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 58);
        output.writeMessageNoTag(scene);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 114);
        output.writeMessageNoTag(lineup);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeEnumSizeNoTag(reason);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(scene);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(lineup);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public EnterSceneByServerScNotify mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 88: {
            // reason
            final int value = input.readInt32();
            if (EnterSceneReasonOuterClass.EnterSceneReason.forNumber(value) != null) {
              reason = value;
              bitField0_ |= 0x00000001;
            }
            tag = input.readTag();
            if (tag != 58) {
              break;
            }
          }
          case 58: {
            // scene
            input.readMessage(scene);
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 114) {
              break;
            }
          }
          case 114: {
            // lineup
            input.readMessage(lineup);
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
        output.writeEnum(FieldNames.reason, reason, EnterSceneReasonOuterClass.EnterSceneReason.converter());
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeMessage(FieldNames.scene, scene);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeMessage(FieldNames.lineup, lineup);
      }
      output.endObject();
    }

    @Override
    public EnterSceneByServerScNotify mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -934964668: {
            if (input.isAtField(FieldNames.reason)) {
              if (!input.trySkipNullValue()) {
                final EnterSceneReasonOuterClass.EnterSceneReason value = input.readEnum(EnterSceneReasonOuterClass.EnterSceneReason.converter());
                if (value != null) {
                  reason = value.getNumber();
                  bitField0_ |= 0x00000001;
                } else {
                  input.skipUnknownEnumValue();
                }
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 109254796: {
            if (input.isAtField(FieldNames.scene)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(scene);
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1102671473: {
            if (input.isAtField(FieldNames.lineup)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(lineup);
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
    public EnterSceneByServerScNotify clone() {
      return new EnterSceneByServerScNotify().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static EnterSceneByServerScNotify parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new EnterSceneByServerScNotify(), data).checkInitialized();
    }

    public static EnterSceneByServerScNotify parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new EnterSceneByServerScNotify(), input).checkInitialized();
    }

    public static EnterSceneByServerScNotify parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new EnterSceneByServerScNotify(), input).checkInitialized();
    }

    /**
     * @return factory for creating EnterSceneByServerScNotify messages
     */
    public static MessageFactory<EnterSceneByServerScNotify> getFactory() {
      return EnterSceneByServerScNotifyFactory.INSTANCE;
    }

    private enum EnterSceneByServerScNotifyFactory implements MessageFactory<EnterSceneByServerScNotify> {
      INSTANCE;

      @Override
      public EnterSceneByServerScNotify create() {
        return EnterSceneByServerScNotify.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName reason = FieldName.forField("reason");

      static final FieldName scene = FieldName.forField("scene");

      static final FieldName lineup = FieldName.forField("lineup");
    }
  }
}
