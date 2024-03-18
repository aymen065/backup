package com.ads.library.library.controllers;

import com.ads.library.library.dto.PublicationDTO;
import com.ads.library.library.services.IPublicationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
@AllArgsConstructor
public class PublicationController {

    private IPublicationService publicationService;
    @GetMapping()
    public ResponseEntity<Page<PublicationDTO>> getAllPublications(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "3") int size) {
        try {
            return new ResponseEntity<>(publicationService.getAllPublications(page,size), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getBooksNumber() {
        try {
            return new ResponseEntity<>(publicationService.getPublicationsNumber(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<PublicationDTO>> getAllPublications() {
        try {
            return new ResponseEntity<>(publicationService.getAllPublications(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDTO> getPublicationById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(publicationService.getPublicationById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping()
    public ResponseEntity<PublicationDTO> createPublication(@RequestBody PublicationDTO publicationDTO) {
        try {
            return new ResponseEntity<>(publicationService.createPublication(publicationDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePublicationById(@PathVariable("id") long id) {

        try {
            publicationService.deletePublicationById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllPublications() {
        try {
            publicationService.deleteAllPublications();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
