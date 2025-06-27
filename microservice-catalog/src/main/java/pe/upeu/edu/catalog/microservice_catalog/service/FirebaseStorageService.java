package pe.upeu.edu.catalog.microservice_catalog.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FirebaseStorageService {

    @Value("${firebase.credentials}")
    private String firebaseCredentialsPath;

    @Value("${firebase.storage.bucket}")
    private String bucketName;

    // Inicializar Firebase una sola vez
    @PostConstruct
    public void initializeFirebase() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            InputStream serviceAccount = new ClassPathResource(firebaseCredentialsPath).getInputStream();
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket(bucketName)
                    .build();

            FirebaseApp.initializeApp(options);
        }
    }

    // Subir imagen
    public String uploadImageToFirebase(MultipartFile file, String identifier) throws IOException {
        String fileName = identifier + "_" + UUID.randomUUID() + "." + getFileExtension(file);
        StorageClient.getInstance().bucket().create(
                "images/" + fileName,
                file.getBytes(),
                file.getContentType()
        );
        return "https://firebasestorage.googleapis.com/v0/b/" + bucketName + "/o/images%2F" + fileName + "?alt=media";
    }

    // Obtener extensión
    private String getFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        return fileName != null && fileName.contains(".") ?
                fileName.substring(fileName.lastIndexOf(".") + 1) : "jpg";
    }

    // Eliminar imagen
    public void deleteImageFromFirebase(String imageUrl) {
        String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        String objectPath = "images/" + fileName;
        boolean deleted = StorageClient.getInstance().bucket().get(objectPath).delete();
        if (!deleted) {
            throw new RuntimeException("No se pudo eliminar la imagen de Firebase Storage: " + objectPath);
        }
    }

    // Leer imagen (byte[])
    public byte[] getImageFromFirebase(String imageUrl) throws IOException {
        String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        String objectPath = "images/" + fileName;
        return StorageClient.getInstance().bucket().get(objectPath).getContent();
    }
}
