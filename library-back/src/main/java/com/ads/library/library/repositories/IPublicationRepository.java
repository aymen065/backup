package com.ads.library.library.repositories;

import com.ads.library.library.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPublicationRepository extends JpaRepository<Publication,Long> {
    void deleteByIdIn(List<Long> ids);
}
