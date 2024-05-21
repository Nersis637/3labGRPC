package com.example;
import com.example.models.Clients;
import com.example.repository.ClientsRep;
import com.example.grpc.Client;
import com.example.grpc.ClientList;
import com.example.grpc.GetClientsRequest;
import io.grpc.stub.StreamObserver;
import com.example.grpc.ClientServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
@GrpcService
public class ClientServiceImpl extends ClientServiceGrpc.ClientServiceImplBase {

    @Autowired
    private ClientsRep clientsRep;
    @Override
    public void getClients(GetClientsRequest request, StreamObserver<ClientList> responseObserver) {
        Iterable<Clients> clientsIterable = clientsRep.findAll();
        ClientList.Builder clientListBuilder = ClientList.newBuilder();
        for (Clients clientEntity : clientsIterable) {
            Client client = Client.newBuilder()
                    .setName(clientEntity.getName())
                    .setSurname(clientEntity.getSurname())
                    .setExist(clientEntity.getExist())
                    .build();
            clientListBuilder.addClients(client);
        }
        ClientList clientList = clientListBuilder.build();
        responseObserver.onNext(clientList);
        responseObserver.onCompleted();
    }


}
