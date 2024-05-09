package com.hrm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hrm.model.Owner;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface OwnerRepo extends JpaRepository<Owner, Integer> {

	@Query("select ownerId from Owner order by ownerId")
	public List<Integer> getIdList();
}
