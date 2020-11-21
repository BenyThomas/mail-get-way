package tz.co.softnet.mailgetway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tz.co.softnet.mailgetway.entity.EStatementFileEntity;

@Repository
public interface EStatementFileRepository extends JpaRepository<EStatementFileEntity,Long> {

}
