/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.facebook.infrastructure.service;

import java.util.ArrayList;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import com.facebook.thrift.*;

import com.facebook.thrift.protocol.*;
import com.facebook.thrift.transport.*;

public class batch_mutation_t implements TBase, java.io.Serializable {
  public String table;
  public String key;
  public AbstractMap<String,ArrayList<column_t>> cfmap;

  public final Isset __isset = new Isset();
  public static final class Isset {
    public boolean table = false;
    public boolean key = false;
    public boolean cfmap = false;
  }

  public batch_mutation_t() {
  }

  public batch_mutation_t(
    String table,
    String key,
    AbstractMap<String,ArrayList<column_t>> cfmap)
  {
    this();
    this.table = table;
    this.__isset.table = true;
    this.key = key;
    this.__isset.key = true;
    this.cfmap = cfmap;
    this.__isset.cfmap = true;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id)
      {
        case 1:
          if (field.type == TType.STRING) {
            this.table = iprot.readString();
            this.__isset.table = true;
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2:
          if (field.type == TType.STRING) {
            this.key = iprot.readString();
            this.__isset.key = true;
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3:
          if (field.type == TType.MAP) {
            {
              TMap _map0 = iprot.readMapBegin();
              this.cfmap = new HashMap<String,ArrayList<column_t>>(2*_map0.size);
              for (int _i1 = 0; _i1 < _map0.size; ++_i1)
              {
                String _key2;
                ArrayList<column_t> _val3;
                _key2 = iprot.readString();
                {
                  TList _list4 = iprot.readListBegin();
                  _val3 = new ArrayList<column_t>(_list4.size);
                  for (int _i5 = 0; _i5 < _list4.size; ++_i5)
                  {
                    column_t _elem6 = new column_t();
                    _elem6 = new column_t();
                    _elem6.read(iprot);
                    _val3.add(_elem6);
                  }
                  iprot.readListEnd();
                }
                this.cfmap.put(_key2, _val3);
              }
              iprot.readMapEnd();
            }
            this.__isset.cfmap = true;
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
          break;
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
  }

  public void write(TProtocol oprot) throws TException {
    TStruct struct = new TStruct("batch_mutation_t");
    oprot.writeStructBegin(struct);
    TField field = new TField();
    if (this.table != null) {
      field.name = "table";
      field.type = TType.STRING;
      field.id = 1;
      oprot.writeFieldBegin(field);
      oprot.writeString(this.table);
      oprot.writeFieldEnd();
    }
    if (this.key != null) {
      field.name = "key";
      field.type = TType.STRING;
      field.id = 2;
      oprot.writeFieldBegin(field);
      oprot.writeString(this.key);
      oprot.writeFieldEnd();
    }
    if (this.cfmap != null) {
      field.name = "cfmap";
      field.type = TType.MAP;
      field.id = 3;
      oprot.writeFieldBegin(field);
      {
        oprot.writeMapBegin(new TMap(TType.STRING, TType.LIST, this.cfmap.size()));
        for (String _iter7 : this.cfmap.keySet())        {
          oprot.writeString(_iter7);
          {
            oprot.writeListBegin(new TList(TType.STRUCT, this.cfmap.get(_iter7).size()));
            for (column_t _iter8 : this.cfmap.get(_iter7))            {
              _iter8.write(oprot);
            }
            oprot.writeListEnd();
          }
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("batch_mutation_t(");
    sb.append("table:");
    sb.append(this.table);
    sb.append(",key:");
    sb.append(this.key);
    sb.append(",cfmap:");
    sb.append(this.cfmap);
    sb.append(")");
    return sb.toString();
  }

}
