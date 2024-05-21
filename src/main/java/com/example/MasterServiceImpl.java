package com.example;

import com.example.models.Masters;
import com.example.repository.MastersRep;
import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class MasterServiceImpl extends MasterServiceGrpc.MasterServiceImplBase {
    @Autowired
    private MastersRep mastersRep;
    public void getMasters(GetMastersRequest request, StreamObserver<MasterList> responseObserver) {
        Iterable<Masters> mastersIterable = mastersRep.findAll();
        MasterList.Builder masterListBuilder = MasterList.newBuilder();
        for (Masters masterEntity : mastersIterable) {
            Master master = Master.newBuilder()
                    .setName(masterEntity.getName())
                    .setSurname(masterEntity.getSurname())
                    .setExist(masterEntity.getExist())
                    .build();
            masterListBuilder.addMasters(master);
        }
        MasterList masterList = masterListBuilder.build();
        responseObserver.onNext(masterList);
        responseObserver.onCompleted();
    }
}
