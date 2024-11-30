package com.example.mediaserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.xproce.lab.*;

import java.util.UUID;

@GrpcService
public class VideoService extends VideoServiceGrpc.VideoServiceImplBase {
    @Override
    public void uploadVideo(UploadVideoRequest request, StreamObserver<Video>
            responseObserver) {
        String title = request.getTitle();
        String description = request.getDescription();
        String url = request.getUrl();

        Video video = Video.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setTitle(title)
                .setDescription(description)
                .setUrl(url)
                //apreees
                .build();

        responseObserver.onNext(video);
        responseObserver.onCompleted();
    }
    @Override
    public void getVideo(VideoIdRequest request, StreamObserver<Video> responseObserver) {
        // Exemple : Récupérer une vidéo par son ID
        Video video = Video.newBuilder()
                .setId(request.getId())
                .setTitle("Sample Title")
                .setDescription("Sample Description")
                .setUrl("http://example.com/video.mp4")
                .setDurationSeconds(120)
                .setCreator(Creator.newBuilder()
                        .setId("1")
                        .setName("John Doe")
                        .setEmail("john.doe@example.com")
                        .build())
                .build();

        responseObserver.onNext(video);
        responseObserver.onCompleted();
    }


}
