package com.ads.library.library.services;

import com.ads.library.library.dto.PublicationDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPublicationService {
    Page<PublicationDTO> getAllPublications(Integer page, Integer size);
    List<PublicationDTO> getAllPublications();
    PublicationDTO getPublicationById(Long id);
    PublicationDTO createPublication(PublicationDTO publicationDTO);
    PublicationDTO updatePublication(PublicationDTO publicationDTO);

    void deletePublicationById(Long id);
    void deleteAllPublications();
    Long getPublicationsNumber();

    void deletePublications(List<Long> publicationsIds);

}
