package tz.co.softnet.mailgetway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.co.softnet.mailgetway.entity.ReceiverEntity;

public interface ReceiverRepository extends JpaRepository<ReceiverEntity,Long> {
}
