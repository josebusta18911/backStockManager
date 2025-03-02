package ve.com.servicio.rest.utils;

import java.io.*;
import java.nio.file.*;
import org.springframework.stereotype.Service;

@Service
public class FileUploadUtil {
      
    public static void saveFile(String dir) throws IOException {

        Path uploadPath = Paths.get(dir);
          
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
    }
}