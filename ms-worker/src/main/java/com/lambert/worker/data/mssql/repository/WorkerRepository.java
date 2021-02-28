package com.lambert.worker.data.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lambert.worker.data.mssql.entity.WorkerEntity;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Long>{

}
