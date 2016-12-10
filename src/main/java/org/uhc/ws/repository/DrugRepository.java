package org.uhc.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uhc.ws.model.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

}
