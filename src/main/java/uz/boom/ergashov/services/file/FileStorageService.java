package uz.boom.ergashov.services.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.ergashov.dto.file.ResourceDto;
import uz.boom.ergashov.mapper.file.ResourceMapper;
import uz.boom.ergashov.reposiroty.file.ResourceRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/7/2022
 * @project : mealDeliver
 */

@Slf4j
@Service
public class FileStorageService {

    private final String FILE_UPLOAD_PATH = "/upload/etm/organization/logos/";
    private final Path rootLocation;
    private final ResourceRepository repository;
    private final ResourceMapper mapper;

    public FileStorageService(ResourceRepository repository, ResourceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.rootLocation = Paths.get(FILE_UPLOAD_PATH);
    }

    @PostConstruct
    private void init() {
        if (!Files.exists(rootLocation)) {
            try {
                Files.createDirectories(rootLocation);
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e.getMessage(), e);
            }
        }
    }

    public ResourceDto store(MultipartFile file) throws IOException {
        /**
         * original name
         * new generated name
         * size
         * content type
         * upload path => /any url/new generated name
         */

        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        String contentType = file.getContentType();
        String extension = StringUtils.getFilenameExtension(originalFilename);
        String generatedName = System.currentTimeMillis() + "." + extension;
        Files.copy(file.getInputStream(), Paths.get(FILE_UPLOAD_PATH, generatedName), StandardCopyOption.REPLACE_EXISTING);
        String path = generatedName;

        ResourceDto dto = ResourceDto.builder().originalName(originalFilename)
                .size(size)
                .contentType(contentType)
                .generatedName(generatedName)
                .path(path)
                .build();

        repository.save(mapper.fromDto(dto));

        return dto;
    }


    public String storeAsync() {

        return "";
    }


    public Resource getResource(String filename) {
        Resource resource = new FileSystemResource(Paths.get(FILE_UPLOAD_PATH, filename));
        return resource;
    }
}
