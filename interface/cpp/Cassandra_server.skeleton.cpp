// This autogenerated skeleton file illustrates how to build a server.
// You should copy it to another filename to avoid overwriting it.

#include "Cassandra.h"
#include <protocol/TBinaryProtocol.h>
#include <server/TSimpleServer.h>
#include <transport/TServerSocket.h>
#include <transport/TBufferTransports.h>

using namespace facebook::thrift;
using namespace facebook::thrift::protocol;
using namespace facebook::thrift::transport;
using namespace facebook::thrift::server;

using boost::shared_ptr;

using namespace com::facebook::infrastructure::service;

class CassandraHandler : virtual public CassandraIf {
 public:
  CassandraHandler() {
    // Your initialization goes here
  }

  void get_slice(std::vector<column_t> & _return, const std::string& tablename, const std::string& key, const std::string& columnFamily_column, const int32_t start, const int32_t count) {
    // Your implementation goes here
    printf("get_slice\n");
  }

  void get_column(column_t& _return, const std::string& tablename, const std::string& key, const std::string& columnFamily_column) {
    // Your implementation goes here
    printf("get_column\n");
  }

  int32_t get_column_count(const std::string& tablename, const std::string& key, const std::string& columnFamily_column) {
    // Your implementation goes here
    printf("get_column_count\n");
  }

  void insert(const std::string& tablename, const std::string& key, const std::string& columnFamily_column, const std::string& cellData, const int32_t timestamp) {
    // Your implementation goes here
    printf("insert\n");
  }

  void batch_insert(const batch_mutation_t& batchMutation) {
    // Your implementation goes here
    printf("batch_insert\n");
  }

  bool batch_insert_blocking(const batch_mutation_t& batchMutation) {
    // Your implementation goes here
    printf("batch_insert_blocking\n");
  }

  void remove(const std::string& tablename, const std::string& key, const std::string& columnFamily_column) {
    // Your implementation goes here
    printf("remove\n");
  }

  void get_slice_super(std::vector<superColumn_t> & _return, const std::string& tablename, const std::string& key, const std::string& columnFamily_superColumnName, const int32_t start, const int32_t count) {
    // Your implementation goes here
    printf("get_slice_super\n");
  }

  void get_superColumn(superColumn_t& _return, const std::string& tablename, const std::string& key, const std::string& columnFamily) {
    // Your implementation goes here
    printf("get_superColumn\n");
  }

  void batch_insert_superColumn(const batch_mutation_super_t& batchMutationSuper) {
    // Your implementation goes here
    printf("batch_insert_superColumn\n");
  }

  bool batch_insert_superColumn_blocking(const batch_mutation_super_t& batchMutationSuper) {
    // Your implementation goes here
    printf("batch_insert_superColumn_blocking\n");
  }

};

int main(int argc, char **argv) {
  int port = 9090;
  shared_ptr<CassandraHandler> handler(new CassandraHandler());
  shared_ptr<TProcessor> processor(new CassandraProcessor(handler));
  shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
  shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
  shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

  TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);
  server.serve();
  return 0;
}
