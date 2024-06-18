package com.system.ophtalmological.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.ophtalmological.System.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long>{
    @Query(value = "select patient_id from diary  where patient_id = :id", nativeQuery = true)
	Long getpatient(long id);
    @Modifying
    @Query(value = "delete from  diary  where id = :id", nativeQuery = true)
	void deleteDiary(long id);
}