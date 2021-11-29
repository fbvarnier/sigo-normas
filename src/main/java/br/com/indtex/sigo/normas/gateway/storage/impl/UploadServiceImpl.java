package br.com.indtex.sigo.normas.gateway.storage.impl;

import br.com.indtex.sigo.normas.gateway.storage.UploadService;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UploadServiceImpl implements UploadService {

    @Value("${sigo.projectId}")
    private String projectId;

    @Value("${sigo.bucketName}")
    private String bucketName;

    @Override
    public String uploadObject(String objectName, String contentType, byte[] fileBytes) {
        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        var blob = storage.create(blobInfo, fileBytes);
        return blob.getMediaLink();
    }
}
