package com.employeeShift.EmployeeShiftProject.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/images")
public class ImageController {

    // Step 1: Define the base directory for images
    private final Path imageLocation = Paths.get("src/main/webapp/images");

    // Step 2: Define a GET endpoint to download images
    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String filename) {
        try {
            // Step 3: Resolve the file path
            Path file = imageLocation.resolve(filename);

            // Step 4: Create a UrlResource from the file path
            Resource resource = new UrlResource(file.toUri());

            // Step 5: Check if the resource exists and is readable
            if (resource.exists() || resource.isReadable()) {
                // Step 6: Create HTTP headers to return with the response
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\""); // Set content disposition to inline
                headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(file)); // Set the content type based on the file type

                // Step 7: Return the resource along with headers and HTTP status OK
                return new ResponseEntity<>(resource, headers, HttpStatus.OK);
            } else {
                // Step 8: If the resource does not exist or is not readable, return HTTP status NOT FOUND
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Step 9: If an exception occurs, return HTTP status INTERNAL SERVER ERROR
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
