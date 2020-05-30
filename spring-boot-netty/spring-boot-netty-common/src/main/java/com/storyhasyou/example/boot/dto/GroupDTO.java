// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/storyhasyou/example/boot/dto/group.proto

package com.storyhasyou.example.boot.dto;

public final class GroupDTO {
  private GroupDTO() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface GroupOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Group)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    java.lang.String getId();
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    com.google.protobuf.ByteString
        getIdBytes();

    /**
     * <code>string groupName = 2;</code>
     * @return The groupName.
     */
    java.lang.String getGroupName();
    /**
     * <code>string groupName = 2;</code>
     * @return The bytes for groupName.
     */
    com.google.protobuf.ByteString
        getGroupNameBytes();
  }
  /**
   * Protobuf type {@code Group}
   */
  public  static final class Group extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Group)
      GroupOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Group.newBuilder() to construct.
    private Group(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Group() {
      id_ = "";
      groupName_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Group();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Group(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              id_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              groupName_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.storyhasyou.example.boot.dto.GroupDTO.internal_static_Group_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.storyhasyou.example.boot.dto.GroupDTO.internal_static_Group_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.storyhasyou.example.boot.dto.GroupDTO.Group.class, com.storyhasyou.example.boot.dto.GroupDTO.Group.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private volatile java.lang.Object id_;
    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int GROUPNAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object groupName_;
    /**
     * <code>string groupName = 2;</code>
     * @return The groupName.
     */
    public java.lang.String getGroupName() {
      java.lang.Object ref = groupName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        groupName_ = s;
        return s;
      }
    }
    /**
     * <code>string groupName = 2;</code>
     * @return The bytes for groupName.
     */
    public com.google.protobuf.ByteString
        getGroupNameBytes() {
      java.lang.Object ref = groupName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        groupName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
      }
      if (!getGroupNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, groupName_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
      }
      if (!getGroupNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, groupName_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.storyhasyou.example.boot.dto.GroupDTO.Group)) {
        return super.equals(obj);
      }
      com.storyhasyou.example.boot.dto.GroupDTO.Group other = (com.storyhasyou.example.boot.dto.GroupDTO.Group) obj;

      if (!getId()
          .equals(other.getId())) return false;
      if (!getGroupName()
          .equals(other.getGroupName())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId().hashCode();
      hash = (37 * hash) + GROUPNAME_FIELD_NUMBER;
      hash = (53 * hash) + getGroupName().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.storyhasyou.example.boot.dto.GroupDTO.Group parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.storyhasyou.example.boot.dto.GroupDTO.Group prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Group}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Group)
        com.storyhasyou.example.boot.dto.GroupDTO.GroupOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.storyhasyou.example.boot.dto.GroupDTO.internal_static_Group_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.storyhasyou.example.boot.dto.GroupDTO.internal_static_Group_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.storyhasyou.example.boot.dto.GroupDTO.Group.class, com.storyhasyou.example.boot.dto.GroupDTO.Group.Builder.class);
      }

      // Construct using com.storyhasyou.example.boot.dto.GroupDTO.Group.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        id_ = "";

        groupName_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.storyhasyou.example.boot.dto.GroupDTO.internal_static_Group_descriptor;
      }

      @java.lang.Override
      public com.storyhasyou.example.boot.dto.GroupDTO.Group getDefaultInstanceForType() {
        return com.storyhasyou.example.boot.dto.GroupDTO.Group.getDefaultInstance();
      }

      @java.lang.Override
      public com.storyhasyou.example.boot.dto.GroupDTO.Group build() {
        com.storyhasyou.example.boot.dto.GroupDTO.Group result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.storyhasyou.example.boot.dto.GroupDTO.Group buildPartial() {
        com.storyhasyou.example.boot.dto.GroupDTO.Group result = new com.storyhasyou.example.boot.dto.GroupDTO.Group(this);
        result.id_ = id_;
        result.groupName_ = groupName_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.storyhasyou.example.boot.dto.GroupDTO.Group) {
          return mergeFrom((com.storyhasyou.example.boot.dto.GroupDTO.Group)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.storyhasyou.example.boot.dto.GroupDTO.Group other) {
        if (other == com.storyhasyou.example.boot.dto.GroupDTO.Group.getDefaultInstance()) return this;
        if (!other.getId().isEmpty()) {
          id_ = other.id_;
          onChanged();
        }
        if (!other.getGroupName().isEmpty()) {
          groupName_ = other.groupName_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.storyhasyou.example.boot.dto.GroupDTO.Group parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.storyhasyou.example.boot.dto.GroupDTO.Group) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object id_ = "";
      /**
       * <code>string id = 1;</code>
       * @return The id.
       */
      public java.lang.String getId() {
        java.lang.Object ref = id_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          id_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       * @return The bytes for id.
       */
      public com.google.protobuf.ByteString
          getIdBytes() {
        java.lang.Object ref = id_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          id_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       * @param value The id to set.
       * @return This builder for chaining.
       */
      public Builder setId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearId() {
        
        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       * @param value The bytes for id to set.
       * @return This builder for chaining.
       */
      public Builder setIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        id_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object groupName_ = "";
      /**
       * <code>string groupName = 2;</code>
       * @return The groupName.
       */
      public java.lang.String getGroupName() {
        java.lang.Object ref = groupName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          groupName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string groupName = 2;</code>
       * @return The bytes for groupName.
       */
      public com.google.protobuf.ByteString
          getGroupNameBytes() {
        java.lang.Object ref = groupName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          groupName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string groupName = 2;</code>
       * @param value The groupName to set.
       * @return This builder for chaining.
       */
      public Builder setGroupName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        groupName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string groupName = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearGroupName() {
        
        groupName_ = getDefaultInstance().getGroupName();
        onChanged();
        return this;
      }
      /**
       * <code>string groupName = 2;</code>
       * @param value The bytes for groupName to set.
       * @return This builder for chaining.
       */
      public Builder setGroupNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        groupName_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Group)
    }

    // @@protoc_insertion_point(class_scope:Group)
    private static final com.storyhasyou.example.boot.dto.GroupDTO.Group DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.storyhasyou.example.boot.dto.GroupDTO.Group();
    }

    public static com.storyhasyou.example.boot.dto.GroupDTO.Group getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Group>
        PARSER = new com.google.protobuf.AbstractParser<Group>() {
      @java.lang.Override
      public Group parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Group(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Group> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Group> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.storyhasyou.example.boot.dto.GroupDTO.Group getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Group_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Group_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n,com/storyhasyou/example/boot/dto/group" +
      ".proto\"&\n\005Group\022\n\n\002id\030\001 \001(\t\022\021\n\tgroupName" +
      "\030\002 \001(\tB,\n com.storyhasyou.example.boot.d" +
      "toB\010GroupDTOb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Group_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Group_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Group_descriptor,
        new java.lang.String[] { "Id", "GroupName", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
