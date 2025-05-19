package com.project.shopapp.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtils {

    private static String uploadDir;

    @Value("${app.upload.dir}")
    public void setUploadDir(String uploadDir) {
        FileUtils.uploadDir = uploadDir;
    }

    /**
     * Saves a file to the server's file system and returns the file path
     * 
     * @param file The MultipartFile to save
     * @return The path where the file was saved
     * @throws IOException If an I/O error occurs
     */
    public static String saveFile(MultipartFile file) throws IOException {
        // Create uploads directory if it doesn't exist
        File uploadDirectory = new File(uploadDir);
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }

        // Generate a unique file name to prevent duplicates
        String originalFileName = file.getOriginalFilename();
        String fileExtension = "";
        if (originalFileName != null && originalFileName.contains(".")) {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }
        String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

        // Define the target location
        Path targetLocation = Paths.get(uploadDir + File.separator + uniqueFileName);

        // Copy file to the target location
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return targetLocation.toString();
    }

    /**
     * Deletes a file from the server's file system
     * 
     * @param filePath The path of the file to delete
     * @return true if successful, false otherwise
     */
    public static boolean deleteFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Validates if the file is an allowed image type
     * 
     * @param file The file to validate
     * @return true if valid, false otherwise
     */
    public static boolean isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType == null) {
            return false;
        }

        return contentType.startsWith("image/");
    }

    /**
     * Checks if the file size is within the allowed limit
     * 
     * @param file        The file to check
     * @param maxSizeInMB The maximum allowed size in MB
     * @return true if within limit, false otherwise
     */
    public static boolean isFileSizeValid(MultipartFile file, int maxSizeInMB) {
        long maxSizeInBytes = maxSizeInMB * 1024 * 1024;
        return file.getSize() <= maxSizeInBytes;
    }
}