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
import us.hebi.quickbuf.RepeatedMessage;

public final class SearchPlayerScRspOuterClass {
  /**
   * Protobuf type {@code SearchPlayerScRsp}
   */
  public static final class SearchPlayerScRsp extends ProtoMessage<SearchPlayerScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 retcode = 9;</code>
     */
    private int retcode;

    /**
     * <code>repeated .SimpleInfo search_result_list = 11;</code>
     */
    private final RepeatedMessage<SimpleInfoOuterClass.SimpleInfo> searchResultList = RepeatedMessage.newEmptyInstance(SimpleInfoOuterClass.SimpleInfo.getFactory());

    private SearchPlayerScRsp() {
    }

    /**
     * @return a new empty instance of {@code SearchPlayerScRsp}
     */
    public static SearchPlayerScRsp newInstance() {
      return new SearchPlayerScRsp();
    }

    /**
     * <code>optional uint32 retcode = 9;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 retcode = 9;</code>
     * @return this
     */
    public SearchPlayerScRsp clearRetcode() {
      bitField0_ &= ~0x00000001;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 9;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 9;</code>
     * @param value the retcode to set
     * @return this
     */
    public SearchPlayerScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000001;
      retcode = value;
      return this;
    }

    /**
     * <code>repeated .SimpleInfo search_result_list = 11;</code>
     * @return whether the searchResultList field is set
     */
    public boolean hasSearchResultList() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>repeated .SimpleInfo search_result_list = 11;</code>
     * @return this
     */
    public SearchPlayerScRsp clearSearchResultList() {
      bitField0_ &= ~0x00000002;
      searchResultList.clear();
      return this;
    }

    /**
     * <code>repeated .SimpleInfo search_result_list = 11;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableSearchResultList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<SimpleInfoOuterClass.SimpleInfo> getSearchResultList() {
      return searchResultList;
    }

    /**
     * <code>repeated .SimpleInfo search_result_list = 11;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<SimpleInfoOuterClass.SimpleInfo> getMutableSearchResultList() {
      bitField0_ |= 0x00000002;
      return searchResultList;
    }

    /**
     * <code>repeated .SimpleInfo search_result_list = 11;</code>
     * @param value the searchResultList to add
     * @return this
     */
    public SearchPlayerScRsp addSearchResultList(final SimpleInfoOuterClass.SimpleInfo value) {
      bitField0_ |= 0x00000002;
      searchResultList.add(value);
      return this;
    }

    /**
     * <code>repeated .SimpleInfo search_result_list = 11;</code>
     * @param values the searchResultList to add
     * @return this
     */
    public SearchPlayerScRsp addAllSearchResultList(
        final SimpleInfoOuterClass.SimpleInfo... values) {
      bitField0_ |= 0x00000002;
      searchResultList.addAll(values);
      return this;
    }

    @Override
    public SearchPlayerScRsp copyFrom(final SearchPlayerScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        retcode = other.retcode;
        searchResultList.copyFrom(other.searchResultList);
      }
      return this;
    }

    @Override
    public SearchPlayerScRsp mergeFrom(final SearchPlayerScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasSearchResultList()) {
        getMutableSearchResultList().addAll(other.searchResultList);
      }
      return this;
    }

    @Override
    public SearchPlayerScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      retcode = 0;
      searchResultList.clear();
      return this;
    }

    @Override
    public SearchPlayerScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      searchResultList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof SearchPlayerScRsp)) {
        return false;
      }
      SearchPlayerScRsp other = (SearchPlayerScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasSearchResultList() || searchResultList.equals(other.searchResultList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 72);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        for (int i = 0; i < searchResultList.length(); i++) {
          output.writeRawByte((byte) 90);
          output.writeMessageNoTag(searchResultList.get(i));
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += (1 * searchResultList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(searchResultList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public SearchPlayerScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 72: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 90) {
              break;
            }
          }
          case 90: {
            // searchResultList
            tag = input.readRepeatedMessage(searchResultList, tag);
            bitField0_ |= 0x00000002;
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
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRepeatedMessage(FieldNames.searchResultList, searchResultList);
      }
      output.endObject();
    }

    @Override
    public SearchPlayerScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1097936398: {
            if (input.isAtField(FieldNames.retcode)) {
              if (!input.trySkipNullValue()) {
                retcode = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1590552099:
          case -1788038295: {
            if (input.isAtField(FieldNames.searchResultList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(searchResultList);
                bitField0_ |= 0x00000002;
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
    public SearchPlayerScRsp clone() {
      return new SearchPlayerScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static SearchPlayerScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new SearchPlayerScRsp(), data).checkInitialized();
    }

    public static SearchPlayerScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SearchPlayerScRsp(), input).checkInitialized();
    }

    public static SearchPlayerScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SearchPlayerScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating SearchPlayerScRsp messages
     */
    public static MessageFactory<SearchPlayerScRsp> getFactory() {
      return SearchPlayerScRspFactory.INSTANCE;
    }

    private enum SearchPlayerScRspFactory implements MessageFactory<SearchPlayerScRsp> {
      INSTANCE;

      @Override
      public SearchPlayerScRsp create() {
        return SearchPlayerScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName searchResultList = FieldName.forField("searchResultList", "search_result_list");
    }
  }
}
