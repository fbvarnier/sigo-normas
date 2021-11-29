package br.com.indtex.sigo.normas.gateway.storage;

public interface UploadService {
    String uploadObject(String objectName, String contentType, byte[] fileBytes);
}
