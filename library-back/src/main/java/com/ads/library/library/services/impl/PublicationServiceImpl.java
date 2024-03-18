package com.ads.library.library.services.impl;


import com.ads.library.library.dto.PublicationDTO;
import com.ads.library.library.models.Publication;
import com.ads.library.library.repositories.IPublicationRepository;
import com.ads.library.library.services.IPublicationService;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublicationServiceImpl implements IPublicationService {
    private IPublicationRepository publicationRepository;
    private Mapper mapper;
    @Override
    public Page<PublicationDTO> getAllPublications(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
         return publicationRepository.findAll(paging).map(publication -> mapper.map(publication, PublicationDTO.class));
    }
    @Override
    public List<PublicationDTO> getAllPublications() {
        return publicationRepository.findAll().stream().map(publication -> mapper.map(publication, PublicationDTO.class)).toList();
    }

    @Override
    public PublicationDTO getPublicationById(Long id) {
        return mapper.map(publicationRepository.findById(id).orElse(null),PublicationDTO.class);
    }

    @Override
    public PublicationDTO createPublication(PublicationDTO publicationDTO) {
        return mapper.map(publicationRepository.save(mapper.map(publicationDTO, Publication.class)), PublicationDTO.class);
    }

    @Override
    public PublicationDTO updatePublication(PublicationDTO publicationDTO) {
        return null;
    }

    @Override
    public void deletePublicationById(Long id) {

        publicationRepository.deleteById(id);
    }

    @Override
    public void deleteAllPublications() {
        publicationRepository.deleteAll();
    }

    @Override
    public Long getPublicationsNumber() {
        return publicationRepository.count();
    }

    @Override
    public void deletePublications(List<Long> publicationsIds) {
        publicationRepository.deleteByIdIn(publicationsIds);
    }
}
